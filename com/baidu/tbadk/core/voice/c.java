package com.baidu.tbadk.core.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.baidu.adp.lib.voice.Amrnb;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public final class c implements Runnable {
    private static volatile int a = 0;
    private static Object g = new Object();
    private AudioTrack b;
    private String c;
    private Amrnb e;
    private final Handler f;
    private int l;
    private final short[] d = {12, 13, 15, 17, 19, 20, 26, 31, 5};
    private final int h = 0;
    private int i = 0;
    private final Handler j = new Handler();
    private final Runnable k = new d(this);
    private final Runnable m = new e(this);

    public final int a() {
        if (this.b == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = this.b.getPlaybackHeadPosition();
            if (this.b != null) {
                int sampleRate = this.b.getSampleRate();
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
        this.l = 0;
        this.l = i;
        this.f = handler;
        try {
            this.e = new Amrnb();
            if (this.e == null && this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(2));
            }
        } catch (Exception e) {
            if (this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(2));
            }
        }
    }

    public final void a(int i) {
        this.l = i;
    }

    public final void b() {
        int i;
        this.f.removeCallbacks(this.m);
        synchronized (g) {
            if (this.b != null) {
                try {
                    i = this.b.getPlaybackHeadPosition();
                    try {
                        this.b.stop();
                        this.b.release();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    i = 0;
                }
                this.l = 0;
                this.b = null;
            } else {
                i = 0;
            }
            if (this.j != null) {
                this.j.removeCallbacks(this.k);
            }
            if (this.f != null) {
                Message obtainMessage = this.f.obtainMessage(0);
                obtainMessage.arg1 = i;
                this.f.sendMessage(obtainMessage);
            }
        }
        a = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b3  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        FileInputStream fileInputStream;
        Process.setThreadPriority(-19);
        if (this.e == null) {
            if (this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(2));
            }
        } else if (this.c == null) {
            if (this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(1));
            }
        } else {
            File file = new File(this.c);
            if (!file.exists()) {
                if (this.f != null) {
                    this.f.sendMessage(this.f.obtainMessage(1));
                    return;
                }
                return;
            }
            try {
                this.b = new AudioTrack(VoiceManager.i, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
            } catch (IllegalArgumentException e) {
                this.b = null;
                com.baidu.adp.lib.util.f.b("AmrAudioPlayerRunnable", "init new AudioTrack", "error = " + e.getMessage());
            }
            a = 1;
            if (this.b == null || this.b.getState() == 0) {
                if (this.f != null) {
                    this.f.sendMessage(this.f.obtainMessage(3));
                    return;
                }
                return;
            }
            if (this.l > 0) {
                this.b.reloadStaticData();
                this.b.setPlaybackHeadPosition(this.l);
            }
            this.b.play();
            a = 2;
            this.j.post(this.k);
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    Boolean bool = true;
                    byte[] bArr = new byte[32];
                    this.e.decoderInit();
                    short[] sArr = new short[160];
                    while (a == 2) {
                        if (bool.booleanValue()) {
                            if (fileInputStream.read(bArr, 0, 6) != 6 || bArr[0] != 35 || bArr[1] != 33 || bArr[2] != 65 || bArr[3] != 77 || bArr[4] != 82 || bArr[5] != 10) {
                                break;
                            }
                            bool = false;
                        }
                        if (fileInputStream.read(bArr, 0, 1) <= 0) {
                            z = true;
                            break;
                        }
                        short s = this.d[(bArr[0] >> 3) & 15];
                        if (fileInputStream.read(bArr, 1, s) != s) {
                            z = true;
                            break;
                        }
                        synchronized (g) {
                            if (this.b != null && this.b.getPlayState() == 3) {
                                this.e.decoderDecode(bArr, sArr);
                                this.b.write(sArr, 0, sArr.length);
                            }
                        }
                    }
                    z = false;
                    try {
                        fileInputStream.close();
                        this.e.decoderDeinit();
                        com.baidu.adp.lib.util.f.d("-----gf : decoderDeinit");
                    } catch (Exception e2) {
                        if (this.f != null) {
                            this.f.sendMessage(this.f.obtainMessage(5));
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                                com.baidu.adp.lib.util.f.b("AudioPlayer", "play", "error = " + e3.getMessage());
                            }
                        }
                        a = 3;
                        if (!z) {
                        }
                    }
                } catch (Exception e4) {
                    z = false;
                }
            } catch (Exception e5) {
                z = false;
                fileInputStream = null;
            }
            a = 3;
            if (!z) {
                this.f.postDelayed(this.m, 500L);
            } else {
                b();
            }
        }
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void c() {
        a = 3;
        b();
    }
}
