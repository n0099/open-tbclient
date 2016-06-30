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
    private static Object pW = new Object();
    private final Handler mHandler;
    private AudioTrack pS;
    private String pT;
    private Amrnb pV;
    private int pY;
    private volatile int pP = 0;
    private final short[] pU = {12, 13, 15, 17, 19, 20, 26, 31, 5};
    private final int mCurBeginSecond = 0;
    private int mElapsedTime = 0;
    private final Handler pX = new Handler();
    private final Runnable mPlayTimeThread = new d(this);
    private final Runnable pZ = new e(this);

    public int fV() {
        if (this.pS == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = this.pS.getPlaybackHeadPosition();
            if (this.pS != null) {
                int sampleRate = this.pS.getSampleRate();
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
        this.pY = 0;
        this.pY = i;
        this.mHandler = handler;
        try {
            this.pV = new Amrnb();
            if (this.pV == null && this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        }
    }

    public void ag(int i) {
        this.pY = i;
    }

    private void init() {
        try {
            this.pS = new AudioTrack(l.qd, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e) {
            this.pS = null;
            BdLog.e(e.getMessage());
        }
        this.pP = 1;
    }

    public void release() {
        int i;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.pZ);
        }
        synchronized (pW) {
            if (this.pS != null) {
                try {
                    i = this.pS.getPlaybackHeadPosition();
                    try {
                        this.pS.stop();
                        this.pS.release();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    i = 0;
                }
                this.pY = 0;
                this.pS = null;
            } else {
                i = 0;
            }
            if (this.pX != null) {
                this.pX.removeCallbacks(this.mPlayTimeThread);
            }
            if (this.mHandler != null) {
                Message obtainMessage = this.mHandler.obtainMessage(0);
                obtainMessage.arg1 = i;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
        this.pP = 0;
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
        if (this.pV == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } else if (this.pT == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        } else {
            File file = new File(this.pT);
            if (file == null || !file.exists()) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    return;
                }
                return;
            }
            init();
            if (this.pS == null || this.pS.getState() == 0) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                    return;
                }
                return;
            }
            if (this.pY > 0) {
                this.pS.reloadStaticData();
                this.pS.setPlaybackHeadPosition(this.pY);
            }
            try {
                this.pS.play();
                this.pP = 2;
                this.pX.post(this.mPlayTimeThread);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    Boolean bool = true;
                    byte[] bArr = new byte[32];
                    this.pV.decoderInit();
                    short[] sArr = new short[160];
                    while (this.pP == 2) {
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
                        short s = this.pU[(bArr[0] >> 3) & 15];
                        if (fileInputStream2.read(bArr, 1, s) != s) {
                            z = true;
                            break;
                        }
                        synchronized (pW) {
                            if (this.pS != null && this.pS.getPlayState() == 3) {
                                this.pV.decoderDecode(bArr, sArr);
                                this.pS.write(sArr, 0, sArr.length);
                            }
                        }
                    }
                    z = false;
                    try {
                        fileInputStream2.close();
                        this.pV.decoderDeinit();
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
                        this.pP = 3;
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
            this.pP = 3;
            if (!z) {
                this.mHandler.postDelayed(this.pZ, 500L);
            } else {
                release();
            }
        }
    }

    public void aU(String str) {
        this.pT = str;
    }

    public void stop() {
        this.pP = 3;
        release();
    }
}
