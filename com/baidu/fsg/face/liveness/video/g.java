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
    public LinkedBlockingQueue<a> f5964a;

    /* renamed from: b  reason: collision with root package name */
    public f f5965b;

    /* renamed from: d  reason: collision with root package name */
    public int f5967d;

    /* renamed from: e  reason: collision with root package name */
    public int f5968e;

    /* renamed from: g  reason: collision with root package name */
    public d f5970g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5971h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5972i;
    public int j;
    public int k;
    public byte[] l;
    public long m;
    public long o;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5966c = false;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<byte[]> f5969f = new LinkedList<>();
    public long p = -1;
    public int n = 0;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f5973a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f5974b;
    }

    public g(int i2, int i3, int i4, int i5, int i6, String str, MediaMuxer mediaMuxer, CountDownLatch countDownLatch) {
        this.j = i2;
        this.k = i3;
        setPriority(10);
        setName("VideoMediaEncoderThread");
        this.f5964a = new LinkedBlockingQueue<>();
        this.f5968e = i5;
        a(i2, i3, i4, i5, i6, str, mediaMuxer);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, String str, MediaMuxer mediaMuxer) {
        this.f5965b = new f(i2, i3, i4, i5, i6, mediaMuxer);
    }

    public boolean b() {
        return this.f5971h;
    }

    public void c() {
        a aVar = new a();
        aVar.f5974b = null;
        aVar.f5973a = 0L;
        this.f5964a.add(aVar);
        this.f5966c = true;
        this.l = null;
        this.m = 0L;
    }

    @Deprecated
    public void d() {
        a aVar = new a();
        aVar.f5974b = null;
        aVar.f5973a = 0L;
        this.f5964a.clear();
        this.f5964a.add(aVar);
        this.f5966c = true;
    }

    public int e() {
        return this.f5967d + 1;
    }

    public int f() {
        LinkedBlockingQueue<a> linkedBlockingQueue = this.f5964a;
        if (linkedBlockingQueue == null) {
            return 0;
        }
        return linkedBlockingQueue.size();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a take;
        if (!this.f5972i) {
            Thread.currentThread().setUncaughtExceptionHandler(this);
            this.f5972i = true;
            LogUtil.i("+initInThread");
            this.f5965b.a();
            LogUtil.i("-initInThread");
        }
        while (true) {
            try {
                LogUtil.i("+mQueue.take");
                take = this.f5964a.take();
                LogUtil.i("-mQueue.take");
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                LogUtil.e(e2.toString());
            }
            if (take.f5974b == null) {
                this.f5969f.clear();
                this.f5964a.clear();
                this.f5965b.b();
                this.f5971h = true;
                return;
            }
            LogUtil.i("+encodeFrame");
            long currentTimeMillis = System.currentTimeMillis();
            this.f5965b.a(take.f5974b, take.f5973a);
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.i("-encodeFrame");
            synchronized (this.f5969f) {
                this.f5969f.add(take.f5974b);
            }
            this.f5967d++;
            LogUtil.i("mRecorder.encodeFrame:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
            if (this.p < 0) {
                this.p = take.f5973a / 1000;
            }
            this.o = (take.f5973a / 1000) - this.p;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
    }

    public void a(byte[] bArr, long j) {
        byte[] bArr2;
        if (this.f5966c || this.f5964a == null) {
            return;
        }
        if (this.f5969f.size() > 0) {
            synchronized (this.f5969f) {
                bArr2 = this.f5969f.pop();
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
        aVar.f5974b = bArr2;
        aVar.f5973a = j;
        if (this.f5964a.size() < 50) {
            this.f5964a.add(aVar);
        }
    }

    public long a() {
        return this.o;
    }

    public void a(d dVar) {
        this.f5970g = dVar;
    }

    public void a(Throwable th) {
        d dVar = this.f5970g;
        if (dVar != null) {
            dVar.a(th);
        }
        th.printStackTrace();
        LogUtil.e(th.toString());
        f fVar = this.f5965b;
        if (fVar != null) {
            fVar.b();
        }
    }
}
