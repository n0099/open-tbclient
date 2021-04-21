package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.wallet.base.audio.b;
import d.b.i0.r.g0.c.d;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes3.dex */
public class MyAudioRecorder implements d {
    public static final int[] n = {SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 22050, 11025, 8000};
    public static Object o = new Object();
    public static AudioRecord p = null;
    public static MediaRecorder q = null;

    /* renamed from: a  reason: collision with root package name */
    public Thread f13351a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13352b;

    /* renamed from: c  reason: collision with root package name */
    public int f13353c;

    /* renamed from: d  reason: collision with root package name */
    public String f13354d;

    /* renamed from: e  reason: collision with root package name */
    public State f13355e;

    /* renamed from: f  reason: collision with root package name */
    public RandomAccessFile f13356f;

    /* renamed from: g  reason: collision with root package name */
    public short f13357g;

    /* renamed from: h  reason: collision with root package name */
    public int f13358h;
    public short i;
    public int j;
    public int k;
    public byte[] l;
    public int m;

    /* loaded from: classes3.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MyAudioRecorder.this.n();
        }
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.f13353c = 0;
        this.f13354d = null;
        try {
            this.f13352b = z;
            if (z) {
                if (i4 == 2) {
                    this.i = (short) 16;
                } else {
                    this.i = (short) 8;
                }
                if (i3 == 2) {
                    this.f13357g = (short) 1;
                } else {
                    this.f13357g = (short) 2;
                }
                this.f13358h = i2;
                int i5 = (i2 * 120) / 1000;
                this.k = i5;
                int i6 = (((i5 * 2) * this.i) * this.f13357g) / 8;
                this.j = i6;
                if (i6 < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    int minBufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.j = minBufferSize;
                    this.k = minBufferSize / (((this.i * 2) * this.f13357g) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.j));
                }
                AudioRecord audioRecord = new AudioRecord(i, i2, i3, i4, this.j);
                p = audioRecord;
                if (audioRecord.getRecordingState() == 3) {
                    p.stop();
                }
                if (p.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                MediaRecorder mediaRecorder = new MediaRecorder();
                q = mediaRecorder;
                mediaRecorder.setAudioSource(1);
                q.setOutputFormat(1);
                q.setAudioEncoder(1);
            }
            this.f13353c = 0;
            this.f13354d = null;
            this.f13355e = State.INITIALIZING;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                BdLog.e(e2);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.f13355e = State.ERROR;
        }
    }

    public static MyAudioRecorder f(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        boolean z;
        boolean z2;
        synchronized (o) {
            p = null;
            q = null;
            int i = 3;
            if (bool.booleanValue()) {
                myAudioRecorder = new MyAudioRecorder(false, 1, n[3], 2, 2);
            } else {
                do {
                    myAudioRecorder = new MyAudioRecorder(true, 1, n[i], 2, 2);
                    i--;
                    z = true;
                    z2 = i >= 0;
                    if (myAudioRecorder.h() == State.INITIALIZING) {
                        z = false;
                    }
                } while (z & z2);
            }
        }
        return myAudioRecorder;
    }

    @Override // d.b.i0.r.g0.c.d
    public void a() {
        this.f13355e = State.STOPPED;
    }

    @Override // d.b.i0.r.g0.c.d
    public boolean b(String str) {
        if (k(str)) {
            return i();
        }
        return false;
    }

    @Override // d.b.i0.r.g0.c.d
    public boolean c() {
        synchronized (o) {
            if (this.f13351a == null || !this.f13351a.isAlive()) {
                Thread thread = new Thread(new a());
                this.f13351a = thread;
                thread.start();
            }
        }
        return false;
    }

    @Override // d.b.i0.r.g0.c.d
    public boolean d() {
        return this.f13355e == State.RECORDING;
    }

    public final short g(byte b2, byte b3) {
        return (short) (b2 | (b3 << 8));
    }

    public State h() {
        return this.f13355e;
    }

    public boolean i() {
        try {
            if (this.f13355e == State.INITIALIZING) {
                if (this.f13352b) {
                    if ((p.getState() == 1) & (this.f13354d != null)) {
                        if (this.f13356f != null) {
                            this.f13356f.close();
                            this.f13356f = null;
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f13354d, "rw");
                        this.f13356f = randomAccessFile;
                        randomAccessFile.setLength(0L);
                        this.f13356f.writeBytes(b.f23223e);
                        this.f13356f.writeInt(0);
                        this.f13356f.writeBytes(b.f23224f);
                        this.f13356f.writeBytes(b.f23225g);
                        this.f13356f.writeInt(Integer.reverseBytes(16));
                        this.f13356f.writeShort(Short.reverseBytes((short) 1));
                        this.f13356f.writeShort(Short.reverseBytes(this.f13357g));
                        this.f13356f.writeInt(Integer.reverseBytes(this.f13358h));
                        this.f13356f.writeInt(Integer.reverseBytes(((this.f13358h * this.i) * this.f13357g) / 8));
                        this.f13356f.writeShort(Short.reverseBytes((short) ((this.f13357g * this.i) / 8)));
                        this.f13356f.writeShort(Short.reverseBytes(this.i));
                        this.f13356f.writeBytes("data");
                        this.f13356f.writeInt(0);
                        this.l = new byte[((this.k * this.i) / 8) * this.f13357g];
                        this.f13355e = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.f13355e = State.ERROR;
                        return false;
                    }
                } else {
                    q.prepare();
                    this.f13355e = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            j();
            this.f13355e = State.ERROR;
            return false;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e2.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.f13355e = State.ERROR;
            return false;
        }
    }

    public void j() {
        State state = this.f13355e;
        if (state == State.RECORDING) {
            m();
        } else {
            if ((state == State.READY) & this.f13352b) {
                try {
                    this.f13356f.close();
                } catch (IOException unused) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.f13354d).delete();
            }
        }
        if (this.f13352b) {
            AudioRecord audioRecord = p;
            if (audioRecord != null) {
                audioRecord.release();
                return;
            }
            return;
        }
        MediaRecorder mediaRecorder = q;
        if (mediaRecorder != null) {
            mediaRecorder.release();
        }
    }

    public boolean k(String str) {
        try {
            if (this.f13355e == State.INITIALIZING) {
                this.f13354d = str;
                if (this.f13352b) {
                    return true;
                }
                q.setOutputFile(str);
                return true;
            }
            return true;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e2.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.f13355e = State.ERROR;
            return false;
        }
    }

    public void l() {
        if (this.f13355e == State.READY) {
            if (this.f13352b) {
                this.m = 0;
                p.startRecording();
                AudioRecord audioRecord = p;
                byte[] bArr = this.l;
                audioRecord.read(bArr, 0, bArr.length);
            } else {
                q.start();
            }
            this.f13355e = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.f13355e = State.ERROR;
    }

    public void m() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        p.stop();
        try {
            this.f13356f.seek(4L);
            this.f13356f.writeInt(Integer.reverseBytes(this.m + 36));
            this.f13356f.seek(40L);
            this.f13356f.writeInt(Integer.reverseBytes(this.m));
            this.f13356f.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException unused) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.f13355e = State.ERROR;
        }
        this.f13355e = State.STOPPED;
    }

    public final void n() {
        if (p == null) {
            return;
        }
        try {
            l();
            while (d()) {
                int i = 0;
                p.read(this.l, 0, this.l.length);
                try {
                    System.out.println(this.l);
                    this.f13356f.write(this.l);
                    this.m += this.l.length;
                    if (this.i == 16) {
                        while (i < this.l.length / 2) {
                            int i2 = i * 2;
                            short g2 = g(this.l[i2], this.l[i2 + 1]);
                            if (g2 > this.f13353c) {
                                this.f13353c = g2;
                            }
                            i++;
                        }
                    } else {
                        while (i < this.l.length) {
                            if (this.l[i] > this.f13353c) {
                                this.f13353c = this.l[i];
                            }
                            i++;
                        }
                    }
                } catch (IOException unused) {
                }
            }
            m();
            j();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
