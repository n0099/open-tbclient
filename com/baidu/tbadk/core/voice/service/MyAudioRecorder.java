package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.wallet.base.audio.b;
import d.a.n0.r.g0.c.d;
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
    public Thread f12706a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12707b;

    /* renamed from: c  reason: collision with root package name */
    public int f12708c;

    /* renamed from: d  reason: collision with root package name */
    public String f12709d;

    /* renamed from: e  reason: collision with root package name */
    public State f12710e;

    /* renamed from: f  reason: collision with root package name */
    public RandomAccessFile f12711f;

    /* renamed from: g  reason: collision with root package name */
    public short f12712g;

    /* renamed from: h  reason: collision with root package name */
    public int f12713h;

    /* renamed from: i  reason: collision with root package name */
    public short f12714i;
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
        this.f12708c = 0;
        this.f12709d = null;
        try {
            this.f12707b = z;
            if (z) {
                if (i5 == 2) {
                    this.f12714i = (short) 16;
                } else {
                    this.f12714i = (short) 8;
                }
                if (i4 == 2) {
                    this.f12712g = (short) 1;
                } else {
                    this.f12712g = (short) 2;
                }
                this.f12713h = i3;
                int i6 = (i3 * 120) / 1000;
                this.k = i6;
                int i7 = (((i6 * 2) * this.f12714i) * this.f12712g) / 8;
                this.j = i7;
                if (i7 < AudioRecord.getMinBufferSize(i3, i4, i5)) {
                    int minBufferSize = AudioRecord.getMinBufferSize(i3, i4, i5);
                    this.j = minBufferSize;
                    this.k = minBufferSize / (((this.f12714i * 2) * this.f12712g) / 8);
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
            this.f12708c = 0;
            this.f12709d = null;
            this.f12710e = State.INITIALIZING;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                BdLog.e(e2);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.f12710e = State.ERROR;
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

    @Override // d.a.n0.r.g0.c.d
    public void a() {
        this.f12710e = State.STOPPED;
    }

    @Override // d.a.n0.r.g0.c.d
    public boolean b(String str) {
        if (k(str)) {
            return i();
        }
        return false;
    }

    @Override // d.a.n0.r.g0.c.d
    public boolean c() {
        synchronized (o) {
            if (this.f12706a == null || !this.f12706a.isAlive()) {
                Thread thread = new Thread(new a());
                this.f12706a = thread;
                thread.start();
            }
        }
        return false;
    }

    @Override // d.a.n0.r.g0.c.d
    public boolean d() {
        return this.f12710e == State.RECORDING;
    }

    public final short g(byte b2, byte b3) {
        return (short) (b2 | (b3 << 8));
    }

    public State h() {
        return this.f12710e;
    }

    public boolean i() {
        try {
            if (this.f12710e == State.INITIALIZING) {
                if (this.f12707b) {
                    if ((p.getState() == 1) & (this.f12709d != null)) {
                        if (this.f12711f != null) {
                            this.f12711f.close();
                            this.f12711f = null;
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f12709d, "rw");
                        this.f12711f = randomAccessFile;
                        randomAccessFile.setLength(0L);
                        this.f12711f.writeBytes(b.f23297e);
                        this.f12711f.writeInt(0);
                        this.f12711f.writeBytes(b.f23298f);
                        this.f12711f.writeBytes(b.f23299g);
                        this.f12711f.writeInt(Integer.reverseBytes(16));
                        this.f12711f.writeShort(Short.reverseBytes((short) 1));
                        this.f12711f.writeShort(Short.reverseBytes(this.f12712g));
                        this.f12711f.writeInt(Integer.reverseBytes(this.f12713h));
                        this.f12711f.writeInt(Integer.reverseBytes(((this.f12713h * this.f12714i) * this.f12712g) / 8));
                        this.f12711f.writeShort(Short.reverseBytes((short) ((this.f12712g * this.f12714i) / 8)));
                        this.f12711f.writeShort(Short.reverseBytes(this.f12714i));
                        this.f12711f.writeBytes("data");
                        this.f12711f.writeInt(0);
                        this.l = new byte[((this.k * this.f12714i) / 8) * this.f12712g];
                        this.f12710e = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.f12710e = State.ERROR;
                        return false;
                    }
                } else {
                    q.prepare();
                    this.f12710e = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            j();
            this.f12710e = State.ERROR;
            return false;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e2.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.f12710e = State.ERROR;
            return false;
        }
    }

    public void j() {
        State state = this.f12710e;
        if (state == State.RECORDING) {
            m();
        } else {
            if ((state == State.READY) & this.f12707b) {
                try {
                    this.f12711f.close();
                } catch (IOException unused) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.f12709d).delete();
            }
        }
        if (this.f12707b) {
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
            if (this.f12710e == State.INITIALIZING) {
                this.f12709d = str;
                if (this.f12707b) {
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
            this.f12710e = State.ERROR;
            return false;
        }
    }

    public void l() {
        if (this.f12710e == State.READY) {
            if (this.f12707b) {
                this.m = 0;
                p.startRecording();
                AudioRecord audioRecord = p;
                byte[] bArr = this.l;
                audioRecord.read(bArr, 0, bArr.length);
            } else {
                q.start();
            }
            this.f12710e = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.f12710e = State.ERROR;
    }

    public void m() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        p.stop();
        try {
            this.f12711f.seek(4L);
            this.f12711f.writeInt(Integer.reverseBytes(this.m + 36));
            this.f12711f.seek(40L);
            this.f12711f.writeInt(Integer.reverseBytes(this.m));
            this.f12711f.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException unused) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.f12710e = State.ERROR;
        }
        this.f12710e = State.STOPPED;
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
                    this.f12711f.write(this.l);
                    this.m += this.l.length;
                    if (this.f12714i == 16) {
                        while (i2 < this.l.length / 2) {
                            int i3 = i2 * 2;
                            short g2 = g(this.l[i3], this.l[i3 + 1]);
                            if (g2 > this.f12708c) {
                                this.f12708c = g2;
                            }
                            i2++;
                        }
                    } else {
                        while (i2 < this.l.length) {
                            if (this.l[i2] > this.f12708c) {
                                this.f12708c = this.l[i2];
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
