package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class c implements Runnable {
    private static Object zr = new Object();
    private final Handler mHandler;
    private AudioTrack zn;
    private String zo;
    private Amrnb zq;
    private int zt;
    private volatile int mPlayingState = 0;
    private final short[] zp = {12, 13, 15, 17, 19, 20, 26, 31, 5};
    private final int mCurBeginSecond = 0;
    private int mElapsedTime = 0;
    private final Handler zs = new Handler();
    private final Runnable mPlayTimeThread = new d(this);
    private final Runnable zu = new e(this);

    public int jB() {
        if (this.zn == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = this.zn.getPlaybackHeadPosition();
            if (this.zn != null) {
                int sampleRate = this.zn.getSampleRate();
                if (sampleRate != 0) {
                    return (int) (((playbackHeadPosition * 1.0f) / (sampleRate * 1.0f)) * 1000.0f);
                }
                return 0;
            }
            return 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    public c(Handler handler, int i) {
        this.zt = 0;
        this.zt = i;
        this.mHandler = handler;
        try {
            this.zq = new Amrnb();
            if (this.zq == null && this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        }
    }

    public void at(int i) {
        this.zt = i;
    }

    private void init() {
        try {
            this.zn = new AudioTrack(l.zy, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e) {
            this.zn = null;
            BdLog.e(e.getMessage());
        }
        this.mPlayingState = 1;
    }

    public void release() {
        int i;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.zu);
        }
        synchronized (zr) {
            if (this.zn != null) {
                try {
                    i = this.zn.getPlaybackHeadPosition();
                    try {
                        this.zn.stop();
                        this.zn.release();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    i = 0;
                }
                this.zt = 0;
                this.zn = null;
            } else {
                i = 0;
            }
            if (this.zs != null) {
                this.zs.removeCallbacks(this.mPlayTimeThread);
            }
            if (this.mHandler != null) {
                Message obtainMessage = this.mHandler.obtainMessage(0);
                obtainMessage.arg1 = i;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
        this.mPlayingState = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0169  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        FileInputStream fileInputStream;
        boolean z;
        Process.setThreadPriority(-19);
        if (this.zq == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } else if (this.zo == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        } else {
            File file = new File(this.zo);
            if (file == null || !file.exists()) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    return;
                }
                return;
            }
            init();
            if (this.zn == null || this.zn.getState() == 0) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                    return;
                }
                return;
            }
            if (this.zt > 0) {
                this.zn.reloadStaticData();
                this.zn.setPlaybackHeadPosition(this.zt);
            }
            try {
                this.zn.play();
                this.mPlayingState = 2;
                this.zs.post(this.mPlayTimeThread);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    Boolean bool = true;
                    byte[] bArr = new byte[32];
                    this.zq.decoderInit();
                    short[] sArr = new short[160];
                    while (this.mPlayingState == 2) {
                        if (bool.booleanValue()) {
                            if (fileInputStream2.read(bArr, 0, 6) == 6) {
                                if (bArr[0] != 35 || bArr[1] != 33 || bArr[2] != 65 || bArr[3] != 77 || bArr[4] != 82) {
                                    break;
                                } else if (bArr[5] != 10) {
                                    z = false;
                                    break;
                                } else {
                                    bool = false;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (fileInputStream2.read(bArr, 0, 1) <= 0) {
                            z = true;
                            break;
                        }
                        short s = this.zp[(bArr[0] >> 3) & 15];
                        if (fileInputStream2.read(bArr, 1, s) != s) {
                            z = true;
                            break;
                        }
                        synchronized (zr) {
                            if (this.zn != null && this.zn.getPlayState() == 3) {
                                this.zq.decoderDecode(bArr, sArr);
                                this.zn.write(sArr, 0, sArr.length);
                            }
                        }
                    }
                    z = false;
                    try {
                        fileInputStream2.close();
                        this.zq.decoderDeinit();
                    } catch (Exception e) {
                        fileInputStream = fileInputStream2;
                        if (this.mHandler != null) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                                BdLog.e(e2.getMessage());
                            }
                        }
                        this.mPlayingState = 3;
                        if (!z) {
                        }
                    }
                } catch (Exception e3) {
                    z = false;
                    fileInputStream = fileInputStream2;
                }
            } catch (Exception e4) {
                fileInputStream = null;
                z = false;
            }
            this.mPlayingState = 3;
            if (!z) {
                this.mHandler.postDelayed(this.zu, 500L);
            } else {
                release();
            }
        }
    }

    public void aY(String str) {
        this.zo = str;
    }

    public void stop() {
        this.mPlayingState = 3;
        release();
    }
}
