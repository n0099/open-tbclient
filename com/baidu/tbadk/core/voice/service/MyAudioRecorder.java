package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.wallet.base.audio.b;
import d.a.i0.r.g0.c.d;
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
    public Thread f13318a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13319b;

    /* renamed from: c  reason: collision with root package name */
    public int f13320c;

    /* renamed from: d  reason: collision with root package name */
    public String f13321d;

    /* renamed from: e  reason: collision with root package name */
    public State f13322e;

    /* renamed from: f  reason: collision with root package name */
    public RandomAccessFile f13323f;

    /* renamed from: g  reason: collision with root package name */
    public short f13324g;

    /* renamed from: h  reason: collision with root package name */
    public int f13325h;

    /* renamed from: i  reason: collision with root package name */
    public short f13326i;
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

    public MyAudioRecorder(boolean z, int i2, int i3, int i4, int i5) {
        this.f13320c = 0;
        this.f13321d = null;
        try {
            this.f13319b = z;
            if (z) {
                if (i5 == 2) {
                    this.f13326i = (short) 16;
                } else {
                    this.f13326i = (short) 8;
                }
                if (i4 == 2) {
                    this.f13324g = (short) 1;
                } else {
                    this.f13324g = (short) 2;
                }
                this.f13325h = i3;
                int i6 = (i3 * 120) / 1000;
                this.k = i6;
                int i7 = (((i6 * 2) * this.f13326i) * this.f13324g) / 8;
                this.j = i7;
                if (i7 < AudioRecord.getMinBufferSize(i3, i4, i5)) {
                    int minBufferSize = AudioRecord.getMinBufferSize(i3, i4, i5);
                    this.j = minBufferSize;
                    this.k = minBufferSize / (((this.f13326i * 2) * this.f13324g) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.j));
                }
                AudioRecord audioRecord = new AudioRecord(i2, i3, i4, i5, this.j);
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
            this.f13320c = 0;
            this.f13321d = null;
            this.f13322e = State.INITIALIZING;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                BdLog.e(e2);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.f13322e = State.ERROR;
        }
    }

    public static MyAudioRecorder f(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        boolean z;
        boolean z2;
        synchronized (o) {
            p = null;
            q = null;
            int i2 = 3;
            if (bool.booleanValue()) {
                myAudioRecorder = new MyAudioRecorder(false, 1, n[3], 2, 2);
            } else {
                do {
                    myAudioRecorder = new MyAudioRecorder(true, 1, n[i2], 2, 2);
                    i2--;
                    z = true;
                    z2 = i2 >= 0;
                    if (myAudioRecorder.h() == State.INITIALIZING) {
                        z = false;
                    }
                } while (z & z2);
            }
        }
        return myAudioRecorder;
    }

    @Override // d.a.i0.r.g0.c.d
    public void a() {
        this.f13322e = State.STOPPED;
    }

    @Override // d.a.i0.r.g0.c.d
    public boolean b(String str) {
        if (k(str)) {
            return i();
        }
        return false;
    }

    @Override // d.a.i0.r.g0.c.d
    public boolean c() {
        synchronized (o) {
            if (this.f13318a == null || !this.f13318a.isAlive()) {
                Thread thread = new Thread(new a());
                this.f13318a = thread;
                thread.start();
            }
        }
        return false;
    }

    @Override // d.a.i0.r.g0.c.d
    public boolean d() {
        return this.f13322e == State.RECORDING;
    }

    public final short g(byte b2, byte b3) {
        return (short) (b2 | (b3 << 8));
    }

    public State h() {
        return this.f13322e;
    }

    public boolean i() {
        try {
            if (this.f13322e == State.INITIALIZING) {
                if (this.f13319b) {
                    if ((p.getState() == 1) & (this.f13321d != null)) {
                        if (this.f13323f != null) {
                            this.f13323f.close();
                            this.f13323f = null;
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f13321d, "rw");
                        this.f13323f = randomAccessFile;
                        randomAccessFile.setLength(0L);
                        this.f13323f.writeBytes(b.f23938e);
                        this.f13323f.writeInt(0);
                        this.f13323f.writeBytes(b.f23939f);
                        this.f13323f.writeBytes(b.f23940g);
                        this.f13323f.writeInt(Integer.reverseBytes(16));
                        this.f13323f.writeShort(Short.reverseBytes((short) 1));
                        this.f13323f.writeShort(Short.reverseBytes(this.f13324g));
                        this.f13323f.writeInt(Integer.reverseBytes(this.f13325h));
                        this.f13323f.writeInt(Integer.reverseBytes(((this.f13325h * this.f13326i) * this.f13324g) / 8));
                        this.f13323f.writeShort(Short.reverseBytes((short) ((this.f13324g * this.f13326i) / 8)));
                        this.f13323f.writeShort(Short.reverseBytes(this.f13326i));
                        this.f13323f.writeBytes("data");
                        this.f13323f.writeInt(0);
                        this.l = new byte[((this.k * this.f13326i) / 8) * this.f13324g];
                        this.f13322e = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.f13322e = State.ERROR;
                        return false;
                    }
                } else {
                    q.prepare();
                    this.f13322e = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            j();
            this.f13322e = State.ERROR;
            return false;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e2.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.f13322e = State.ERROR;
            return false;
        }
    }

    public void j() {
        State state = this.f13322e;
        if (state == State.RECORDING) {
            m();
        } else {
            if ((state == State.READY) & this.f13319b) {
                try {
                    this.f13323f.close();
                } catch (IOException unused) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.f13321d).delete();
            }
        }
        if (this.f13319b) {
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
            if (this.f13322e == State.INITIALIZING) {
                this.f13321d = str;
                if (this.f13319b) {
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
            this.f13322e = State.ERROR;
            return false;
        }
    }

    public void l() {
        if (this.f13322e == State.READY) {
            if (this.f13319b) {
                this.m = 0;
                p.startRecording();
                AudioRecord audioRecord = p;
                byte[] bArr = this.l;
                audioRecord.read(bArr, 0, bArr.length);
            } else {
                q.start();
            }
            this.f13322e = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.f13322e = State.ERROR;
    }

    public void m() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        p.stop();
        try {
            this.f13323f.seek(4L);
            this.f13323f.writeInt(Integer.reverseBytes(this.m + 36));
            this.f13323f.seek(40L);
            this.f13323f.writeInt(Integer.reverseBytes(this.m));
            this.f13323f.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException unused) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.f13322e = State.ERROR;
        }
        this.f13322e = State.STOPPED;
    }

    public final void n() {
        if (p == null) {
            return;
        }
        try {
            l();
            while (d()) {
                int i2 = 0;
                p.read(this.l, 0, this.l.length);
                try {
                    System.out.println(this.l);
                    this.f13323f.write(this.l);
                    this.m += this.l.length;
                    if (this.f13326i == 16) {
                        while (i2 < this.l.length / 2) {
                            int i3 = i2 * 2;
                            short g2 = g(this.l[i3], this.l[i3 + 1]);
                            if (g2 > this.f13320c) {
                                this.f13320c = g2;
                            }
                            i2++;
                        }
                    } else {
                        while (i2 < this.l.length) {
                            if (this.l[i2] > this.f13320c) {
                                this.f13320c = this.l[i2];
                            }
                            i2++;
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
