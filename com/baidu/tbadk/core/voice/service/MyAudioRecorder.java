package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.wallet.base.audio.b;
import d.b.h0.r.g0.c.d;
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
    public Thread f13681a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13682b;

    /* renamed from: c  reason: collision with root package name */
    public int f13683c;

    /* renamed from: d  reason: collision with root package name */
    public String f13684d;

    /* renamed from: e  reason: collision with root package name */
    public State f13685e;

    /* renamed from: f  reason: collision with root package name */
    public RandomAccessFile f13686f;

    /* renamed from: g  reason: collision with root package name */
    public short f13687g;

    /* renamed from: h  reason: collision with root package name */
    public int f13688h;
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
        this.f13683c = 0;
        this.f13684d = null;
        try {
            this.f13682b = z;
            if (z) {
                if (i4 == 2) {
                    this.i = (short) 16;
                } else {
                    this.i = (short) 8;
                }
                if (i3 == 2) {
                    this.f13687g = (short) 1;
                } else {
                    this.f13687g = (short) 2;
                }
                this.f13688h = i2;
                int i5 = (i2 * 120) / 1000;
                this.k = i5;
                int i6 = (((i5 * 2) * this.i) * this.f13687g) / 8;
                this.j = i6;
                if (i6 < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    int minBufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.j = minBufferSize;
                    this.k = minBufferSize / (((this.i * 2) * this.f13687g) / 8);
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
            this.f13683c = 0;
            this.f13684d = null;
            this.f13685e = State.INITIALIZING;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                BdLog.e(e2);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.f13685e = State.ERROR;
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

    @Override // d.b.h0.r.g0.c.d
    public void a() {
        this.f13685e = State.STOPPED;
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean b(String str) {
        if (k(str)) {
            return i();
        }
        return false;
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean c() {
        synchronized (o) {
            if (this.f13681a == null || !this.f13681a.isAlive()) {
                Thread thread = new Thread(new a());
                this.f13681a = thread;
                thread.start();
            }
        }
        return false;
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean d() {
        return this.f13685e == State.RECORDING;
    }

    public final short g(byte b2, byte b3) {
        return (short) (b2 | (b3 << 8));
    }

    public State h() {
        return this.f13685e;
    }

    public boolean i() {
        try {
            if (this.f13685e == State.INITIALIZING) {
                if (this.f13682b) {
                    if ((p.getState() == 1) & (this.f13684d != null)) {
                        if (this.f13686f != null) {
                            this.f13686f.close();
                            this.f13686f = null;
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f13684d, "rw");
                        this.f13686f = randomAccessFile;
                        randomAccessFile.setLength(0L);
                        this.f13686f.writeBytes(b.f23529e);
                        this.f13686f.writeInt(0);
                        this.f13686f.writeBytes(b.f23530f);
                        this.f13686f.writeBytes(b.f23531g);
                        this.f13686f.writeInt(Integer.reverseBytes(16));
                        this.f13686f.writeShort(Short.reverseBytes((short) 1));
                        this.f13686f.writeShort(Short.reverseBytes(this.f13687g));
                        this.f13686f.writeInt(Integer.reverseBytes(this.f13688h));
                        this.f13686f.writeInt(Integer.reverseBytes(((this.f13688h * this.i) * this.f13687g) / 8));
                        this.f13686f.writeShort(Short.reverseBytes((short) ((this.f13687g * this.i) / 8)));
                        this.f13686f.writeShort(Short.reverseBytes(this.i));
                        this.f13686f.writeBytes("data");
                        this.f13686f.writeInt(0);
                        this.l = new byte[((this.k * this.i) / 8) * this.f13687g];
                        this.f13685e = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.f13685e = State.ERROR;
                        return false;
                    }
                } else {
                    q.prepare();
                    this.f13685e = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            j();
            this.f13685e = State.ERROR;
            return false;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e2.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.f13685e = State.ERROR;
            return false;
        }
    }

    public void j() {
        State state = this.f13685e;
        if (state == State.RECORDING) {
            m();
        } else {
            if ((state == State.READY) & this.f13682b) {
                try {
                    this.f13686f.close();
                } catch (IOException unused) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.f13684d).delete();
            }
        }
        if (this.f13682b) {
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
            if (this.f13685e == State.INITIALIZING) {
                this.f13684d = str;
                if (this.f13682b) {
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
            this.f13685e = State.ERROR;
            return false;
        }
    }

    public void l() {
        if (this.f13685e == State.READY) {
            if (this.f13682b) {
                this.m = 0;
                p.startRecording();
                AudioRecord audioRecord = p;
                byte[] bArr = this.l;
                audioRecord.read(bArr, 0, bArr.length);
            } else {
                q.start();
            }
            this.f13685e = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.f13685e = State.ERROR;
    }

    public void m() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        p.stop();
        try {
            this.f13686f.seek(4L);
            this.f13686f.writeInt(Integer.reverseBytes(this.m + 36));
            this.f13686f.seek(40L);
            this.f13686f.writeInt(Integer.reverseBytes(this.m));
            this.f13686f.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException unused) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.f13685e = State.ERROR;
        }
        this.f13685e = State.STOPPED;
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
                    this.f13686f.write(this.l);
                    this.m += this.l.length;
                    if (this.i == 16) {
                        while (i < this.l.length / 2) {
                            int i2 = i * 2;
                            short g2 = g(this.l[i2], this.l[i2 + 1]);
                            if (g2 > this.f13683c) {
                                this.f13683c = g2;
                            }
                            i++;
                        }
                    } else {
                        while (i < this.l.length) {
                            if (this.l[i] > this.f13683c) {
                                this.f13683c = this.l[i];
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
