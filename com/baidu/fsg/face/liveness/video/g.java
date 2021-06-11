package com.baidu.fsg.face.liveness.video;

import android.media.MediaMuxer;
import com.baidu.fsg.base.utils.LogUtil;
import java.lang.Thread;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class g extends Thread implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public LinkedBlockingQueue<a> f6007a;

    /* renamed from: b  reason: collision with root package name */
    public f f6008b;

    /* renamed from: d  reason: collision with root package name */
    public int f6010d;

    /* renamed from: e  reason: collision with root package name */
    public int f6011e;

    /* renamed from: g  reason: collision with root package name */
    public d f6013g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6014h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6015i;
    public int j;
    public int k;
    public byte[] l;
    public long m;
    public long o;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6009c = false;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<byte[]> f6012f = new LinkedList<>();
    public long p = -1;
    public int n = 0;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f6016a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f6017b;
    }

    public g(int i2, int i3, int i4, int i5, int i6, String str, MediaMuxer mediaMuxer, CountDownLatch countDownLatch) {
        this.j = i2;
        this.k = i3;
        setPriority(10);
        setName("VideoMediaEncoderThread");
        this.f6007a = new LinkedBlockingQueue<>();
        this.f6011e = i5;
        a(i2, i3, i4, i5, i6, str, mediaMuxer);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, String str, MediaMuxer mediaMuxer) {
        this.f6008b = new f(i2, i3, i4, i5, i6, mediaMuxer);
    }

    public boolean b() {
        return this.f6014h;
    }

    public void c() {
        a aVar = new a();
        aVar.f6017b = null;
        aVar.f6016a = 0L;
        this.f6007a.add(aVar);
        this.f6009c = true;
        this.l = null;
        this.m = 0L;
    }

    @Deprecated
    public void d() {
        a aVar = new a();
        aVar.f6017b = null;
        aVar.f6016a = 0L;
        this.f6007a.clear();
        this.f6007a.add(aVar);
        this.f6009c = true;
    }

    public int e() {
        return this.f6010d + 1;
    }

    public int f() {
        LinkedBlockingQueue<a> linkedBlockingQueue = this.f6007a;
        if (linkedBlockingQueue == null) {
            return 0;
        }
        return linkedBlockingQueue.size();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a take;
        if (!this.f6015i) {
            Thread.currentThread().setUncaughtExceptionHandler(this);
            this.f6015i = true;
            LogUtil.i("+initInThread");
            this.f6008b.a();
            LogUtil.i("-initInThread");
        }
        while (true) {
            try {
                LogUtil.i("+mQueue.take");
                take = this.f6007a.take();
                LogUtil.i("-mQueue.take");
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                LogUtil.e(e2.toString());
            }
            if (take.f6017b == null) {
                this.f6012f.clear();
                this.f6007a.clear();
                this.f6008b.b();
                this.f6014h = true;
                return;
            }
            LogUtil.i("+encodeFrame");
            long currentTimeMillis = System.currentTimeMillis();
            this.f6008b.a(take.f6017b, take.f6016a);
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.i("-encodeFrame");
            synchronized (this.f6012f) {
                this.f6012f.add(take.f6017b);
            }
            this.f6010d++;
            LogUtil.i("mRecorder.encodeFrame:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
            if (this.p < 0) {
                this.p = take.f6016a / 1000;
            }
            this.o = (take.f6016a / 1000) - this.p;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
    }

    public void a(byte[] bArr, long j) {
        byte[] bArr2;
        if (this.f6009c || this.f6007a == null) {
            return;
        }
        if (this.f6012f.size() > 0) {
            synchronized (this.f6012f) {
                bArr2 = this.f6012f.pop();
            }
            if (bArr.length != bArr2.length) {
                try {
                    bArr2 = new byte[bArr.length];
                } catch (OutOfMemoryError e2) {
                    LogUtil.e(e2.toString());
                    e2.printStackTrace();
                    return;
                }
            }
        } else {
            try {
                bArr2 = new byte[bArr.length];
            } catch (OutOfMemoryError e3) {
                LogUtil.e(e3.toString());
                e3.printStackTrace();
                return;
            }
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        a aVar = new a();
        this.l = bArr2;
        this.m = j;
        aVar.f6017b = bArr2;
        aVar.f6016a = j;
        if (this.f6007a.size() < 50) {
            this.f6007a.add(aVar);
        }
    }

    public long a() {
        return this.o;
    }

    public void a(d dVar) {
        this.f6013g = dVar;
    }

    public void a(Throwable th) {
        d dVar = this.f6013g;
        if (dVar != null) {
            dVar.a(th);
        }
        th.printStackTrace();
        LogUtil.e(th.toString());
        f fVar = this.f6008b;
        if (fVar != null) {
            fVar.b();
        }
    }
}
