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
    private static volatile int mPlayingState = 0;
    private static Object zc = new Object();
    private final Handler mHandler;
    private AudioTrack yY;
    private String yZ;
    private Amrnb zb;
    private int ze;
    private final short[] za = {12, 13, 15, 17, 19, 20, 26, 31, 5};
    private final int mCurBeginSecond = 0;
    private int mElapsedTime = 0;
    private final Handler zd = new Handler();
    private final Runnable mPlayTimeThread = new d(this);
    private final Runnable zf = new e(this);

    public int jr() {
        if (this.yY == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = this.yY.getPlaybackHeadPosition();
            if (this.yY != null) {
                int sampleRate = this.yY.getSampleRate();
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
        this.ze = 0;
        this.ze = i;
        this.mHandler = handler;
        try {
            this.zb = new Amrnb();
            if (this.zb == null && this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        }
    }

    public void ah(int i) {
        this.ze = i;
    }

    private void init() {
        try {
            this.yY = new AudioTrack(l.zj, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e) {
            this.yY = null;
            BdLog.e(e.getMessage());
        }
        mPlayingState = 1;
    }

    public void release() {
        int i;
        this.mHandler.removeCallbacks(this.zf);
        synchronized (zc) {
            if (this.yY != null) {
                try {
                    i = this.yY.getPlaybackHeadPosition();
                    try {
                        this.yY.stop();
                        this.yY.release();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    i = 0;
                }
                this.ze = 0;
                this.yY = null;
            } else {
                i = 0;
            }
            if (this.zd != null) {
                this.zd.removeCallbacks(this.mPlayTimeThread);
            }
            if (this.mHandler != null) {
                Message obtainMessage = this.mHandler.obtainMessage(0);
                obtainMessage.arg1 = i;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
        mPlayingState = 0;
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
        if (this.zb == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } else if (this.yZ == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        } else {
            File file = new File(this.yZ);
            if (file == null || !file.exists()) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    return;
                }
                return;
            }
            init();
            if (this.yY == null || this.yY.getState() == 0) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                    return;
                }
                return;
            }
            if (this.ze > 0) {
                this.yY.reloadStaticData();
                this.yY.setPlaybackHeadPosition(this.ze);
            }
            try {
                this.yY.play();
                mPlayingState = 2;
                this.zd.post(this.mPlayTimeThread);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    Boolean bool = true;
                    byte[] bArr = new byte[32];
                    this.zb.decoderInit();
                    short[] sArr = new short[160];
                    while (mPlayingState == 2) {
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
                        short s = this.za[(bArr[0] >> 3) & 15];
                        if (fileInputStream2.read(bArr, 1, s) != s) {
                            z = true;
                            break;
                        }
                        synchronized (zc) {
                            if (this.yY != null && this.yY.getPlayState() == 3) {
                                this.zb.decoderDecode(bArr, sArr);
                                this.yY.write(sArr, 0, sArr.length);
                            }
                        }
                    }
                    z = false;
                    try {
                        fileInputStream2.close();
                        this.zb.decoderDeinit();
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
                        mPlayingState = 3;
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
            mPlayingState = 3;
            if (!z) {
                this.mHandler.postDelayed(this.zf, 500L);
            } else {
                release();
            }
        }
    }

    public void aW(String str) {
        this.yZ = str;
    }

    public void stop() {
        mPlayingState = 3;
        release();
    }
}
