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
    private static Object zb = new Object();
    private final Handler mHandler;
    private AudioTrack yX;
    private String yY;
    private Amrnb za;
    private int zd;
    private final short[] yZ = {12, 13, 15, 17, 19, 20, 26, 31, 5};
    private final int mCurBeginSecond = 0;
    private int mElapsedTime = 0;
    private final Handler zc = new Handler();
    private final Runnable mPlayTimeThread = new d(this);
    private final Runnable ze = new e(this);

    public int jq() {
        if (this.yX == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = this.yX.getPlaybackHeadPosition();
            if (this.yX != null) {
                int sampleRate = this.yX.getSampleRate();
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
        this.zd = 0;
        this.zd = i;
        this.mHandler = handler;
        try {
            this.za = new Amrnb();
            if (this.za == null && this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        }
    }

    public void ah(int i) {
        this.zd = i;
    }

    private void init() {
        try {
            this.yX = new AudioTrack(l.zi, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e) {
            this.yX = null;
            BdLog.e(e.getMessage());
        }
        mPlayingState = 1;
    }

    public void release() {
        int i;
        this.mHandler.removeCallbacks(this.ze);
        synchronized (zb) {
            if (this.yX != null) {
                try {
                    i = this.yX.getPlaybackHeadPosition();
                    try {
                        this.yX.stop();
                        this.yX.release();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    i = 0;
                }
                this.zd = 0;
                this.yX = null;
            } else {
                i = 0;
            }
            if (this.zc != null) {
                this.zc.removeCallbacks(this.mPlayTimeThread);
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
        if (this.za == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } else if (this.yY == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        } else {
            File file = new File(this.yY);
            if (file == null || !file.exists()) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    return;
                }
                return;
            }
            init();
            if (this.yX == null || this.yX.getState() == 0) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                    return;
                }
                return;
            }
            if (this.zd > 0) {
                this.yX.reloadStaticData();
                this.yX.setPlaybackHeadPosition(this.zd);
            }
            try {
                this.yX.play();
                mPlayingState = 2;
                this.zc.post(this.mPlayTimeThread);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    Boolean bool = true;
                    byte[] bArr = new byte[32];
                    this.za.decoderInit();
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
                        short s = this.yZ[(bArr[0] >> 3) & 15];
                        if (fileInputStream2.read(bArr, 1, s) != s) {
                            z = true;
                            break;
                        }
                        synchronized (zb) {
                            if (this.yX != null && this.yX.getPlayState() == 3) {
                                this.za.decoderDecode(bArr, sArr);
                                this.yX.write(sArr, 0, sArr.length);
                            }
                        }
                    }
                    z = false;
                    try {
                        fileInputStream2.close();
                        this.za.decoderDeinit();
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
                this.mHandler.postDelayed(this.ze, 500L);
            } else {
                release();
            }
        }
    }

    public void aV(String str) {
        this.yY = str;
    }

    public void stop() {
        mPlayingState = 3;
        release();
    }
}
