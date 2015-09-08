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
    private static Object za = new Object();
    private final Handler mHandler;
    private AudioTrack yW;
    private String yX;
    private Amrnb yZ;
    private int zc;
    private final short[] yY = {12, 13, 15, 17, 19, 20, 26, 31, 5};
    private final int mCurBeginSecond = 0;
    private int mElapsedTime = 0;
    private final Handler zb = new Handler();
    private final Runnable mPlayTimeThread = new d(this);
    private final Runnable zd = new e(this);

    public int jo() {
        if (this.yW == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = this.yW.getPlaybackHeadPosition();
            if (this.yW != null) {
                int sampleRate = this.yW.getSampleRate();
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
        this.zc = 0;
        this.zc = i;
        this.mHandler = handler;
        try {
            this.yZ = new Amrnb();
            if (this.yZ == null && this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        }
    }

    public void ah(int i) {
        this.zc = i;
    }

    private void init() {
        try {
            this.yW = new AudioTrack(l.zh, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e) {
            this.yW = null;
            BdLog.e(e.getMessage());
        }
        mPlayingState = 1;
    }

    public void release() {
        int i;
        this.mHandler.removeCallbacks(this.zd);
        synchronized (za) {
            if (this.yW != null) {
                try {
                    i = this.yW.getPlaybackHeadPosition();
                    try {
                        this.yW.stop();
                        this.yW.release();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    i = 0;
                }
                this.zc = 0;
                this.yW = null;
            } else {
                i = 0;
            }
            if (this.zb != null) {
                this.zb.removeCallbacks(this.mPlayTimeThread);
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
        if (this.yZ == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } else if (this.yX == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        } else {
            File file = new File(this.yX);
            if (file == null || !file.exists()) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    return;
                }
                return;
            }
            init();
            if (this.yW == null || this.yW.getState() == 0) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                    return;
                }
                return;
            }
            if (this.zc > 0) {
                this.yW.reloadStaticData();
                this.yW.setPlaybackHeadPosition(this.zc);
            }
            try {
                this.yW.play();
                mPlayingState = 2;
                this.zb.post(this.mPlayTimeThread);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    Boolean bool = true;
                    byte[] bArr = new byte[32];
                    this.yZ.decoderInit();
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
                        short s = this.yY[(bArr[0] >> 3) & 15];
                        if (fileInputStream2.read(bArr, 1, s) != s) {
                            z = true;
                            break;
                        }
                        synchronized (za) {
                            if (this.yW != null && this.yW.getPlayState() == 3) {
                                this.yZ.decoderDecode(bArr, sArr);
                                this.yW.write(sArr, 0, sArr.length);
                            }
                        }
                    }
                    z = false;
                    try {
                        fileInputStream2.close();
                        this.yZ.decoderDeinit();
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
                this.mHandler.postDelayed(this.zd, 500L);
            } else {
                release();
            }
        }
    }

    public void aW(String str) {
        this.yX = str;
    }

    public void stop() {
        mPlayingState = 3;
        release();
    }
}
