package com.baidu.fsg.face.liveness.video;

import android.media.MediaMuxer;
import com.baidu.fsg.base.utils.LogUtil;
import java.lang.Thread;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public class g extends Thread implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    protected LinkedBlockingQueue<a> f2314a;

    /* renamed from: b  reason: collision with root package name */
    protected f f2315b;
    protected int d;
    protected int e;
    protected d g;
    protected boolean h;
    protected boolean i;
    protected int j;
    protected int k;
    protected byte[] l;
    protected long m;
    private long o;
    protected boolean c = false;
    protected LinkedList<byte[]> f = new LinkedList<>();
    private long p = -1;
    int n = 0;

    public g(int i, int i2, int i3, int i4, int i5, String str, MediaMuxer mediaMuxer, CountDownLatch countDownLatch) {
        this.j = i;
        this.k = i2;
        setPriority(10);
        setName("VideoMediaEncoderThread");
        this.f2314a = new LinkedBlockingQueue<>();
        this.e = i4;
        a(i, i2, i3, i4, i5, str, mediaMuxer);
    }

    protected void a(int i, int i2, int i3, int i4, int i5, String str, MediaMuxer mediaMuxer) {
        this.f2315b = new f(i, i2, i3, i4, i5, mediaMuxer);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a take;
        if (!this.i) {
            Thread.currentThread().setUncaughtExceptionHandler(this);
            this.i = true;
            LogUtil.i("+initInThread");
            this.f2315b.a();
            LogUtil.i("-initInThread");
        }
        while (true) {
            try {
                LogUtil.i("+mQueue.take");
                take = this.f2314a.take();
                LogUtil.i("-mQueue.take");
            } catch (InterruptedException e) {
                e.printStackTrace();
                LogUtil.e(e.toString());
            }
            if (take.f2317b != null) {
                LogUtil.i("+encodeFrame");
                long currentTimeMillis = System.currentTimeMillis();
                this.f2315b.a(take.f2317b, take.f2316a);
                long currentTimeMillis2 = System.currentTimeMillis();
                LogUtil.i("-encodeFrame");
                synchronized (this.f) {
                    this.f.add(take.f2317b);
                }
                this.d++;
                LogUtil.i("mRecorder.encodeFrame:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
                if (this.p < 0) {
                    this.p = take.f2316a / 1000;
                }
                this.o = (take.f2316a / 1000) - this.p;
            } else {
                this.f.clear();
                this.f2314a.clear();
                this.f2315b.b();
                this.h = true;
                return;
            }
        }
    }

    public void a(byte[] bArr, long j) {
        byte[] bArr2;
        if (!this.c && this.f2314a != null) {
            if (this.f.size() > 0) {
                synchronized (this.f) {
                    bArr2 = this.f.pop();
                }
                if (bArr.length != bArr2.length) {
                    try {
                        bArr2 = new byte[bArr.length];
                    } catch (OutOfMemoryError e) {
                        LogUtil.e(e.toString());
                        e.printStackTrace();
                        return;
                    }
                }
            } else {
                try {
                    bArr2 = new byte[bArr.length];
                } catch (OutOfMemoryError e2) {
                    LogUtil.e(e2.toString());
                    e2.printStackTrace();
                    return;
                }
            }
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            a aVar = new a();
            this.l = bArr2;
            this.m = j;
            aVar.f2317b = bArr2;
            aVar.f2316a = j;
            if (this.f2314a.size() < 50) {
                this.f2314a.add(aVar);
            }
        }
    }

    public long a() {
        return this.o;
    }

    public boolean b() {
        return this.h;
    }

    public void c() {
        a aVar = new a();
        aVar.f2317b = null;
        aVar.f2316a = 0L;
        this.f2314a.add(aVar);
        this.c = true;
        this.l = null;
        this.m = 0L;
    }

    @Deprecated
    public void d() {
        a aVar = new a();
        aVar.f2317b = null;
        aVar.f2316a = 0L;
        this.f2314a.clear();
        this.f2314a.add(aVar);
        this.c = true;
    }

    public int e() {
        return this.d + 1;
    }

    public void a(d dVar) {
        this.g = dVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
    }

    public int f() {
        if (this.f2314a == null) {
            return 0;
        }
        return this.f2314a.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f2316a;

        /* renamed from: b  reason: collision with root package name */
        byte[] f2317b;

        a() {
        }
    }

    public void a(Throwable th) {
        if (this.g != null) {
            this.g.a(th);
        }
        th.printStackTrace();
        LogUtil.e(th.toString());
        if (this.f2315b != null) {
            this.f2315b.b();
        }
    }
}
