package com.baidu.fsg.face.liveness.video;

import android.media.MediaMuxer;
import com.baidu.fsg.base.utils.LogUtil;
import java.lang.Thread;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class g extends Thread implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    protected LinkedBlockingQueue<a> f2364a;

    /* renamed from: b  reason: collision with root package name */
    protected f f2365b;
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
        this.f2364a = new LinkedBlockingQueue<>();
        this.e = i4;
        a(i, i2, i3, i4, i5, str, mediaMuxer);
    }

    protected void a(int i, int i2, int i3, int i4, int i5, String str, MediaMuxer mediaMuxer) {
        this.f2365b = new f(i, i2, i3, i4, i5, mediaMuxer);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a take;
        if (!this.i) {
            Thread.currentThread().setUncaughtExceptionHandler(this);
            this.i = true;
            LogUtil.i("+initInThread");
            this.f2365b.a();
            LogUtil.i("-initInThread");
        }
        while (true) {
            try {
                LogUtil.i("+mQueue.take");
                take = this.f2364a.take();
                LogUtil.i("-mQueue.take");
            } catch (InterruptedException e) {
                e.printStackTrace();
                LogUtil.e(e.toString());
            }
            if (take.f2367b != null) {
                LogUtil.i("+encodeFrame");
                long currentTimeMillis = System.currentTimeMillis();
                this.f2365b.a(take.f2367b, take.f2366a);
                long currentTimeMillis2 = System.currentTimeMillis();
                LogUtil.i("-encodeFrame");
                synchronized (this.f) {
                    this.f.add(take.f2367b);
                }
                this.d++;
                LogUtil.i("mRecorder.encodeFrame:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
                if (this.p < 0) {
                    this.p = take.f2366a / 1000;
                }
                this.o = (take.f2366a / 1000) - this.p;
            } else {
                this.f.clear();
                this.f2364a.clear();
                this.f2365b.b();
                this.h = true;
                return;
            }
        }
    }

    public void a(byte[] bArr, long j) {
        byte[] bArr2;
        if (!this.c && this.f2364a != null) {
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
            aVar.f2367b = bArr2;
            aVar.f2366a = j;
            if (this.f2364a.size() < 50) {
                this.f2364a.add(aVar);
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
        aVar.f2367b = null;
        aVar.f2366a = 0L;
        this.f2364a.add(aVar);
        this.c = true;
        this.l = null;
        this.m = 0L;
    }

    @Deprecated
    public void d() {
        a aVar = new a();
        aVar.f2367b = null;
        aVar.f2366a = 0L;
        this.f2364a.clear();
        this.f2364a.add(aVar);
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
        if (this.f2364a == null) {
            return 0;
        }
        return this.f2364a.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f2366a;

        /* renamed from: b  reason: collision with root package name */
        byte[] f2367b;

        a() {
        }
    }

    public void a(Throwable th) {
        if (this.g != null) {
            this.g.a(th);
        }
        th.printStackTrace();
        LogUtil.e(th.toString());
        if (this.f2365b != null) {
            this.f2365b.b();
        }
    }
}
