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
    public LinkedBlockingQueue<a> f6064a;

    /* renamed from: b  reason: collision with root package name */
    public f f6065b;

    /* renamed from: d  reason: collision with root package name */
    public int f6067d;

    /* renamed from: e  reason: collision with root package name */
    public int f6068e;

    /* renamed from: g  reason: collision with root package name */
    public d f6070g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6071h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6072i;
    public int j;
    public int k;
    public byte[] l;
    public long m;
    public long o;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6066c = false;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<byte[]> f6069f = new LinkedList<>();
    public long p = -1;
    public int n = 0;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f6073a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f6074b;
    }

    public g(int i2, int i3, int i4, int i5, int i6, String str, MediaMuxer mediaMuxer, CountDownLatch countDownLatch) {
        this.j = i2;
        this.k = i3;
        setPriority(10);
        setName("VideoMediaEncoderThread");
        this.f6064a = new LinkedBlockingQueue<>();
        this.f6068e = i5;
        a(i2, i3, i4, i5, i6, str, mediaMuxer);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, String str, MediaMuxer mediaMuxer) {
        this.f6065b = new f(i2, i3, i4, i5, i6, mediaMuxer);
    }

    public boolean b() {
        return this.f6071h;
    }

    public void c() {
        a aVar = new a();
        aVar.f6074b = null;
        aVar.f6073a = 0L;
        this.f6064a.add(aVar);
        this.f6066c = true;
        this.l = null;
        this.m = 0L;
    }

    @Deprecated
    public void d() {
        a aVar = new a();
        aVar.f6074b = null;
        aVar.f6073a = 0L;
        this.f6064a.clear();
        this.f6064a.add(aVar);
        this.f6066c = true;
    }

    public int e() {
        return this.f6067d + 1;
    }

    public int f() {
        LinkedBlockingQueue<a> linkedBlockingQueue = this.f6064a;
        if (linkedBlockingQueue == null) {
            return 0;
        }
        return linkedBlockingQueue.size();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a take;
        if (!this.f6072i) {
            Thread.currentThread().setUncaughtExceptionHandler(this);
            this.f6072i = true;
            LogUtil.i("+initInThread");
            this.f6065b.a();
            LogUtil.i("-initInThread");
        }
        while (true) {
            try {
                LogUtil.i("+mQueue.take");
                take = this.f6064a.take();
                LogUtil.i("-mQueue.take");
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                LogUtil.e(e2.toString());
            }
            if (take.f6074b == null) {
                this.f6069f.clear();
                this.f6064a.clear();
                this.f6065b.b();
                this.f6071h = true;
                return;
            }
            LogUtil.i("+encodeFrame");
            long currentTimeMillis = System.currentTimeMillis();
            this.f6065b.a(take.f6074b, take.f6073a);
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.i("-encodeFrame");
            synchronized (this.f6069f) {
                this.f6069f.add(take.f6074b);
            }
            this.f6067d++;
            LogUtil.i("mRecorder.encodeFrame:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
            if (this.p < 0) {
                this.p = take.f6073a / 1000;
            }
            this.o = (take.f6073a / 1000) - this.p;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
    }

    public void a(byte[] bArr, long j) {
        byte[] bArr2;
        if (this.f6066c || this.f6064a == null) {
            return;
        }
        if (this.f6069f.size() > 0) {
            synchronized (this.f6069f) {
                bArr2 = this.f6069f.pop();
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
        aVar.f6074b = bArr2;
        aVar.f6073a = j;
        if (this.f6064a.size() < 50) {
            this.f6064a.add(aVar);
        }
    }

    public long a() {
        return this.o;
    }

    public void a(d dVar) {
        this.f6070g = dVar;
    }

    public void a(Throwable th) {
        d dVar = this.f6070g;
        if (dVar != null) {
            dVar.a(th);
        }
        th.printStackTrace();
        LogUtil.e(th.toString());
        f fVar = this.f6065b;
        if (fVar != null) {
            fVar.b();
        }
    }
}
