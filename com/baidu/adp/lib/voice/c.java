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
    private static Object zJ = new Object();
    private final Handler mHandler;
    private AudioTrack zF;
    private String zG;
    private Amrnb zI;
    private int zL;
    private volatile int zC = 0;
    private final short[] zH = {12, 13, 15, 17, 19, 20, 26, 31, 5};
    private final int mCurBeginSecond = 0;
    private int mElapsedTime = 0;
    private final Handler zK = new Handler();
    private final Runnable mPlayTimeThread = new d(this);
    private final Runnable zM = new e(this);

    public int jH() {
        if (this.zF == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = this.zF.getPlaybackHeadPosition();
            if (this.zF != null) {
                int sampleRate = this.zF.getSampleRate();
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
        this.zL = 0;
        this.zL = i;
        this.mHandler = handler;
        try {
            this.zI = new Amrnb();
            if (this.zI == null && this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        }
    }

    public void as(int i) {
        this.zL = i;
    }

    private void init() {
        try {
            this.zF = new AudioTrack(l.zQ, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e) {
            this.zF = null;
            BdLog.e(e.getMessage());
        }
        this.zC = 1;
    }

    public void release() {
        int i;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.zM);
        }
        synchronized (zJ) {
            if (this.zF != null) {
                try {
                    i = this.zF.getPlaybackHeadPosition();
                    try {
                        this.zF.stop();
                        this.zF.release();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    i = 0;
                }
                this.zL = 0;
                this.zF = null;
            } else {
                i = 0;
            }
            if (this.zK != null) {
                this.zK.removeCallbacks(this.mPlayTimeThread);
            }
            if (this.mHandler != null) {
                Message obtainMessage = this.mHandler.obtainMessage(0);
                obtainMessage.arg1 = i;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
        this.zC = 0;
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
        if (this.zI == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } else if (this.zG == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        } else {
            File file = new File(this.zG);
            if (file == null || !file.exists()) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    return;
                }
                return;
            }
            init();
            if (this.zF == null || this.zF.getState() == 0) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                    return;
                }
                return;
            }
            if (this.zL > 0) {
                this.zF.reloadStaticData();
                this.zF.setPlaybackHeadPosition(this.zL);
            }
            try {
                this.zF.play();
                this.zC = 2;
                this.zK.post(this.mPlayTimeThread);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    Boolean bool = true;
                    byte[] bArr = new byte[32];
                    this.zI.decoderInit();
                    short[] sArr = new short[160];
                    while (this.zC == 2) {
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
                        short s = this.zH[(bArr[0] >> 3) & 15];
                        if (fileInputStream2.read(bArr, 1, s) != s) {
                            z = true;
                            break;
                        }
                        synchronized (zJ) {
                            if (this.zF != null && this.zF.getPlayState() == 3) {
                                this.zI.decoderDecode(bArr, sArr);
                                this.zF.write(sArr, 0, sArr.length);
                            }
                        }
                    }
                    z = false;
                    try {
                        fileInputStream2.close();
                        this.zI.decoderDeinit();
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
                        this.zC = 3;
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
            this.zC = 3;
            if (!z) {
                this.mHandler.postDelayed(this.zM, 500L);
            } else {
                release();
            }
        }
    }

    public void bb(String str) {
        this.zG = str;
    }

    public void stop() {
        this.zC = 3;
        release();
    }
}
