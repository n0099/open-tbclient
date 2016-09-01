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
    private static Object sO = new Object();
    private final Handler mHandler;
    private AudioTrack sK;
    private String sL;
    private Amrnb sN;
    private int sQ;
    private volatile int sH = 0;
    private final short[] sM = {12, 13, 15, 17, 19, 20, 26, 31, 5};
    private final int mCurBeginSecond = 0;
    private int mElapsedTime = 0;
    private final Handler sP = new Handler();
    private final Runnable mPlayTimeThread = new d(this);
    private final Runnable sR = new e(this);

    public int gQ() {
        if (this.sK == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = this.sK.getPlaybackHeadPosition();
            if (this.sK != null) {
                int sampleRate = this.sK.getSampleRate();
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
        this.sQ = 0;
        this.sQ = i;
        this.mHandler = handler;
        try {
            this.sN = new Amrnb();
            if (this.sN == null && this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        }
    }

    public void aw(int i) {
        this.sQ = i;
    }

    private void init() {
        try {
            this.sK = new AudioTrack(l.sV, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e) {
            this.sK = null;
            BdLog.e(e.getMessage());
        }
        this.sH = 1;
    }

    public void release() {
        int i;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.sR);
        }
        synchronized (sO) {
            if (this.sK != null) {
                try {
                    i = this.sK.getPlaybackHeadPosition();
                    try {
                        this.sK.stop();
                        this.sK.release();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    i = 0;
                }
                this.sQ = 0;
                this.sK = null;
            } else {
                i = 0;
            }
            if (this.sP != null) {
                this.sP.removeCallbacks(this.mPlayTimeThread);
            }
            if (this.mHandler != null) {
                Message obtainMessage = this.mHandler.obtainMessage(0);
                obtainMessage.arg1 = i;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
        this.sH = 0;
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
        if (this.sN == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } else if (this.sL == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        } else {
            File file = new File(this.sL);
            if (file == null || !file.exists()) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    return;
                }
                return;
            }
            init();
            if (this.sK == null || this.sK.getState() == 0) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                    return;
                }
                return;
            }
            if (this.sQ > 0) {
                this.sK.reloadStaticData();
                this.sK.setPlaybackHeadPosition(this.sQ);
            }
            try {
                this.sK.play();
                this.sH = 2;
                this.sP.post(this.mPlayTimeThread);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    Boolean bool = true;
                    byte[] bArr = new byte[32];
                    this.sN.decoderInit();
                    short[] sArr = new short[160];
                    while (this.sH == 2) {
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
                        short s = this.sM[(bArr[0] >> 3) & 15];
                        if (fileInputStream2.read(bArr, 1, s) != s) {
                            z = true;
                            break;
                        }
                        synchronized (sO) {
                            if (this.sK != null && this.sK.getPlayState() == 3) {
                                this.sN.decoderDecode(bArr, sArr);
                                this.sK.write(sArr, 0, sArr.length);
                            }
                        }
                    }
                    z = false;
                    try {
                        fileInputStream2.close();
                        this.sN.decoderDeinit();
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
                        this.sH = 3;
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
            this.sH = 3;
            if (!z) {
                this.mHandler.postDelayed(this.sR, 500L);
            } else {
                release();
            }
        }
    }

    public void aW(String str) {
        this.sL = str;
    }

    public void stop() {
        this.sH = 3;
        release();
    }
}
