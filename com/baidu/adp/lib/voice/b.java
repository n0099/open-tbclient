package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class b implements Runnable {
    private static Object QH = new Object();
    private String QE;
    private Amrnb QG;
    private int QJ;
    private AudioTrack mAudioTrack;
    private final Handler mHandler;
    private volatile int QB = 0;
    private final short[] QF = {12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0, 0, 0};
    private final int mCurBeginSecond = 0;
    private int mElapsedTime = 0;
    private final Handler QI = new Handler();
    private final Runnable mPlayTimeThread = new Runnable() { // from class: com.baidu.adp.lib.voice.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mAudioTrack != null) {
                try {
                    if (b.this.mAudioTrack.getPlayState() != 3) {
                        return;
                    }
                } catch (NullPointerException e) {
                }
                int nS = b.this.nS() + 0;
                if (nS != b.this.mElapsedTime) {
                    b.this.mElapsedTime = nS;
                    Message obtainMessage = b.this.mHandler.obtainMessage(6);
                    obtainMessage.arg1 = b.this.mElapsedTime;
                    b.this.mHandler.sendMessage(obtainMessage);
                }
                b.this.QI.postDelayed(b.this.mPlayTimeThread, 100L);
            }
        }
    };
    private final Runnable QK = new Runnable() { // from class: com.baidu.adp.lib.voice.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.release();
        }
    };

    public int nS() {
        if (this.mAudioTrack == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = this.mAudioTrack.getPlaybackHeadPosition();
            if (this.mAudioTrack != null) {
                int sampleRate = this.mAudioTrack.getSampleRate();
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

    public b(Handler handler, int i) {
        this.QJ = 0;
        this.QJ = i;
        this.mHandler = handler;
        try {
            this.QG = new Amrnb();
            if (this.QG == null && this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        }
    }

    public void aD(int i) {
        this.QJ = i;
    }

    private void init() {
        try {
            this.mAudioTrack = new AudioTrack(h.QO, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e) {
            this.mAudioTrack = null;
            BdLog.e(e.getMessage());
        }
        this.QB = 1;
    }

    public void release() {
        int i;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.QK);
        }
        synchronized (QH) {
            if (this.mAudioTrack != null) {
                try {
                    i = this.mAudioTrack.getPlaybackHeadPosition();
                    try {
                        this.mAudioTrack.stop();
                        this.mAudioTrack.release();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    i = 0;
                }
                this.QJ = 0;
                this.mAudioTrack = null;
            } else {
                i = 0;
            }
            if (this.QI != null) {
                this.QI.removeCallbacks(this.mPlayTimeThread);
            }
            if (this.mHandler != null) {
                Message obtainMessage = this.mHandler.obtainMessage(0);
                obtainMessage.arg1 = i;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
        this.QB = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0160  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        FileInputStream fileInputStream;
        boolean z = true;
        Process.setThreadPriority(-19);
        if (this.QG == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } else if (this.QE == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        } else {
            File file = new File(this.QE);
            if (file == null || !file.exists()) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    return;
                }
                return;
            }
            init();
            if (this.mAudioTrack == null || this.mAudioTrack.getState() == 0) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                    return;
                }
                return;
            }
            if (this.QJ > 0) {
                this.mAudioTrack.reloadStaticData();
                this.mAudioTrack.setPlaybackHeadPosition(this.QJ);
            }
            try {
                this.mAudioTrack.play();
                this.QB = 2;
                this.QI.post(this.mPlayTimeThread);
                fileInputStream = new FileInputStream(file);
                try {
                    Boolean bool = true;
                    byte[] bArr = new byte[32];
                    this.QG.decoderInit();
                    short[] sArr = new short[160];
                    while (this.QB == 2) {
                        if (bool.booleanValue()) {
                            if (fileInputStream.read(bArr, 0, 6) == 6) {
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
                        if (fileInputStream.read(bArr, 0, 1) > 0) {
                            short s = this.QF[(bArr[0] >> 3) & 15];
                            if (fileInputStream.read(bArr, 1, s) == s) {
                                synchronized (QH) {
                                    if (this.mAudioTrack != null && this.mAudioTrack.getPlayState() == 3) {
                                        this.QG.decoderDecode(bArr, sArr);
                                        this.mAudioTrack.write(sArr, 0, sArr.length);
                                    }
                                }
                            }
                        }
                    }
                    z = false;
                    try {
                        fileInputStream.close();
                        this.QG.decoderDeinit();
                    } catch (Exception e) {
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
                        this.QB = 3;
                        if (!z) {
                        }
                    }
                } catch (Exception e3) {
                    z = false;
                }
            } catch (Exception e4) {
                z = false;
                fileInputStream = null;
            }
            this.QB = 3;
            if (!z) {
                this.mHandler.postDelayed(this.QK, 500L);
            } else {
                release();
            }
        }
    }

    public void cg(String str) {
        this.QE = str;
    }

    public void stop() {
        this.QB = 3;
        release();
    }
}
