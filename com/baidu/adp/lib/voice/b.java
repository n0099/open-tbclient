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
    private static Object rU = new Object();
    private AudioTrack mAudioTrack;
    private final Handler mHandler;
    private String rR;
    private Amrnb rT;
    private int rW;
    private volatile int rO = 0;
    private final short[] rS = {12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0, 0, 0};
    private final int mCurBeginSecond = 0;
    private int mElapsedTime = 0;
    private final Handler rV = new Handler();
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
                int hf = b.this.hf() + 0;
                if (hf != b.this.mElapsedTime) {
                    b.this.mElapsedTime = hf;
                    Message obtainMessage = b.this.mHandler.obtainMessage(6);
                    obtainMessage.arg1 = b.this.mElapsedTime;
                    b.this.mHandler.sendMessage(obtainMessage);
                }
                b.this.rV.postDelayed(b.this.mPlayTimeThread, 100L);
            }
        }
    };
    private final Runnable rX = new Runnable() { // from class: com.baidu.adp.lib.voice.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.release();
        }
    };

    public int hf() {
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
        this.rW = 0;
        this.rW = i;
        this.mHandler = handler;
        try {
            this.rT = new Amrnb();
            if (this.rT == null && this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        }
    }

    public void S(int i) {
        this.rW = i;
    }

    private void init() {
        try {
            this.mAudioTrack = new AudioTrack(h.sc, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e) {
            this.mAudioTrack = null;
            BdLog.e(e.getMessage());
        }
        this.rO = 1;
    }

    public void release() {
        int i;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.rX);
        }
        synchronized (rU) {
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
                this.rW = 0;
                this.mAudioTrack = null;
            } else {
                i = 0;
            }
            if (this.rV != null) {
                this.rV.removeCallbacks(this.mPlayTimeThread);
            }
            if (this.mHandler != null) {
                Message obtainMessage = this.mHandler.obtainMessage(0);
                obtainMessage.arg1 = i;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
        this.rO = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0167  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        FileInputStream fileInputStream;
        boolean z;
        Process.setThreadPriority(-19);
        if (this.rT == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } else if (this.rR == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        } else {
            File file = new File(this.rR);
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
            if (this.rW > 0) {
                this.mAudioTrack.reloadStaticData();
                this.mAudioTrack.setPlaybackHeadPosition(this.rW);
            }
            try {
                this.mAudioTrack.play();
                this.rO = 2;
                this.rV.post(this.mPlayTimeThread);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    Boolean bool = true;
                    byte[] bArr = new byte[32];
                    this.rT.decoderInit();
                    short[] sArr = new short[160];
                    while (this.rO == 2) {
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
                        short s = this.rS[(bArr[0] >> 3) & 15];
                        if (fileInputStream2.read(bArr, 1, s) != s) {
                            z = true;
                            break;
                        }
                        synchronized (rU) {
                            if (this.mAudioTrack != null && this.mAudioTrack.getPlayState() == 3) {
                                this.rT.decoderDecode(bArr, sArr);
                                this.mAudioTrack.write(sArr, 0, sArr.length);
                            }
                        }
                    }
                    z = false;
                    try {
                        fileInputStream2.close();
                        this.rT.decoderDeinit();
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
                        this.rO = 3;
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
            this.rO = 3;
            if (!z) {
                this.mHandler.postDelayed(this.rX, 500L);
            } else {
                release();
            }
        }
    }

    public void aw(String str) {
        this.rR = str;
    }

    public void stop() {
        this.rO = 3;
        release();
    }
}
