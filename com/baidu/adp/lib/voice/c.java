package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class c implements Runnable {
    private static volatile int nT = 0;
    private static Object oa = new Object();
    private final Handler mHandler;
    private AudioTrack nW;
    private String nX;
    private Amrnb nZ;
    private int oc;
    private final short[] nY = {12, 13, 15, 17, 19, 20, 26, 31, 5};
    private final int mCurBeginSecond = 0;
    private int mElapsedTime = 0;
    private final Handler ob = new Handler();
    private final Runnable mPlayTimeThread = new d(this);
    private final Runnable od = new e(this);

    public int fD() {
        if (this.nW == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = this.nW.getPlaybackHeadPosition();
            if (this.nW != null) {
                int sampleRate = this.nW.getSampleRate();
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
        this.oc = 0;
        this.oc = i;
        this.mHandler = handler;
        try {
            this.nZ = new Amrnb();
            if (this.nZ == null && this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        }
    }

    public void Q(int i) {
        this.oc = i;
    }

    private void init() {
        try {
            this.nW = new AudioTrack(q.oD, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_8, 2, 2, Math.min(AudioTrack.getMinBufferSize(LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_8, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e) {
            this.nW = null;
            BdLog.e(e.getMessage());
        }
        nT = 1;
    }

    public void release() {
        int i;
        this.mHandler.removeCallbacks(this.od);
        synchronized (oa) {
            if (this.nW != null) {
                try {
                    i = this.nW.getPlaybackHeadPosition();
                    try {
                        this.nW.stop();
                        this.nW.release();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    i = 0;
                }
                this.oc = 0;
                this.nW = null;
            } else {
                i = 0;
            }
            if (this.ob != null) {
                this.ob.removeCallbacks(this.mPlayTimeThread);
            }
            if (this.mHandler != null) {
                Message obtainMessage = this.mHandler.obtainMessage(0);
                obtainMessage.arg1 = i;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
        nT = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0168  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        FileInputStream fileInputStream;
        boolean z;
        Process.setThreadPriority(-19);
        if (this.nZ == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
            }
        } else if (this.nX == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        } else {
            File file = new File(this.nX);
            if (file == null || !file.exists()) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    return;
                }
                return;
            }
            init();
            if (this.nW == null || this.nW.getState() == 0) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                    return;
                }
                return;
            }
            if (this.oc > 0) {
                this.nW.reloadStaticData();
                this.nW.setPlaybackHeadPosition(this.oc);
            }
            this.nW.play();
            nT = 2;
            this.ob.post(this.mPlayTimeThread);
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    Boolean bool = true;
                    byte[] bArr = new byte[32];
                    this.nZ.decoderInit();
                    short[] sArr = new short[160];
                    while (nT == 2) {
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
                        short s = this.nY[(bArr[0] >> 3) & 15];
                        if (fileInputStream2.read(bArr, 1, s) != s) {
                            z = true;
                            break;
                        }
                        synchronized (oa) {
                            if (this.nW != null && this.nW.getPlayState() == 3) {
                                this.nZ.decoderDecode(bArr, sArr);
                                this.nW.write(sArr, 0, sArr.length);
                            }
                        }
                    }
                    z = false;
                    try {
                        fileInputStream2.close();
                        this.nZ.decoderDeinit();
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
                        nT = 3;
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
            nT = 3;
            if (!z) {
                this.mHandler.postDelayed(this.od, 500L);
            } else {
                release();
            }
        }
    }

    public void aJ(String str) {
        this.nX = str;
    }

    public void stop() {
        nT = 3;
        release();
    }
}
