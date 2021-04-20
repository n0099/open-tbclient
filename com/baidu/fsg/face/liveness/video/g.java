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
    public LinkedBlockingQueue<a> f6042a;

    /* renamed from: b  reason: collision with root package name */
    public f f6043b;

    /* renamed from: d  reason: collision with root package name */
    public int f6045d;

    /* renamed from: e  reason: collision with root package name */
    public int f6046e;

    /* renamed from: g  reason: collision with root package name */
    public d f6048g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6049h;
    public boolean i;
    public int j;
    public int k;
    public byte[] l;
    public long m;
    public long o;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6044c = false;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<byte[]> f6047f = new LinkedList<>();
    public long p = -1;
    public int n = 0;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f6050a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f6051b;
    }

    public g(int i, int i2, int i3, int i4, int i5, String str, MediaMuxer mediaMuxer, CountDownLatch countDownLatch) {
        this.j = i;
        this.k = i2;
        setPriority(10);
        setName("VideoMediaEncoderThread");
        this.f6042a = new LinkedBlockingQueue<>();
        this.f6046e = i4;
        a(i, i2, i3, i4, i5, str, mediaMuxer);
    }

    public void a(int i, int i2, int i3, int i4, int i5, String str, MediaMuxer mediaMuxer) {
        this.f6043b = new f(i, i2, i3, i4, i5, mediaMuxer);
    }

    public boolean b() {
        return this.f6049h;
    }

    public void c() {
        a aVar = new a();
        aVar.f6051b = null;
        aVar.f6050a = 0L;
        this.f6042a.add(aVar);
        this.f6044c = true;
        this.l = null;
        this.m = 0L;
    }

    @Deprecated
    public void d() {
        a aVar = new a();
        aVar.f6051b = null;
        aVar.f6050a = 0L;
        this.f6042a.clear();
        this.f6042a.add(aVar);
        this.f6044c = true;
    }

    public int e() {
        return this.f6045d + 1;
    }

    public int f() {
        LinkedBlockingQueue<a> linkedBlockingQueue = this.f6042a;
        if (linkedBlockingQueue == null) {
            return 0;
        }
        return linkedBlockingQueue.size();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a take;
        if (!this.i) {
            Thread.currentThread().setUncaughtExceptionHandler(this);
            this.i = true;
            LogUtil.i("+initInThread");
            this.f6043b.a();
            LogUtil.i("-initInThread");
        }
        while (true) {
            try {
                LogUtil.i("+mQueue.take");
                take = this.f6042a.take();
                LogUtil.i("-mQueue.take");
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                LogUtil.e(e2.toString());
            }
            if (take.f6051b == null) {
                this.f6047f.clear();
                this.f6042a.clear();
                this.f6043b.b();
                this.f6049h = true;
                return;
            }
            LogUtil.i("+encodeFrame");
            long currentTimeMillis = System.currentTimeMillis();
            this.f6043b.a(take.f6051b, take.f6050a);
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.i("-encodeFrame");
            synchronized (this.f6047f) {
                this.f6047f.add(take.f6051b);
            }
            this.f6045d++;
            LogUtil.i("mRecorder.encodeFrame:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
            if (this.p < 0) {
                this.p = take.f6050a / 1000;
            }
            this.o = (take.f6050a / 1000) - this.p;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
    }

    public void a(byte[] bArr, long j) {
        byte[] bArr2;
        if (this.f6044c || this.f6042a == null) {
            return;
        }
        if (this.f6047f.size() > 0) {
            synchronized (this.f6047f) {
                bArr2 = this.f6047f.pop();
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
        aVar.f6051b = bArr2;
        aVar.f6050a = j;
        if (this.f6042a.size() < 50) {
            this.f6042a.add(aVar);
        }
    }

    public long a() {
        return this.o;
    }

    public void a(d dVar) {
        this.f6048g = dVar;
    }

    public void a(Throwable th) {
        d dVar = this.f6048g;
        if (dVar != null) {
            dVar.a(th);
        }
        th.printStackTrace();
        LogUtil.e(th.toString());
        f fVar = this.f6043b;
        if (fVar != null) {
            fVar.b();
        }
    }
}
