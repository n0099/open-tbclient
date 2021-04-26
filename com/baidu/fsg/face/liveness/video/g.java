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
    public LinkedBlockingQueue<a> f6210a;

    /* renamed from: b  reason: collision with root package name */
    public f f6211b;

    /* renamed from: d  reason: collision with root package name */
    public int f6213d;

    /* renamed from: e  reason: collision with root package name */
    public int f6214e;

    /* renamed from: g  reason: collision with root package name */
    public d f6216g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6217h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6218i;
    public int j;
    public int k;
    public byte[] l;
    public long m;
    public long o;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6212c = false;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<byte[]> f6215f = new LinkedList<>();
    public long p = -1;
    public int n = 0;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f6219a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f6220b;
    }

    public g(int i2, int i3, int i4, int i5, int i6, String str, MediaMuxer mediaMuxer, CountDownLatch countDownLatch) {
        this.j = i2;
        this.k = i3;
        setPriority(10);
        setName("VideoMediaEncoderThread");
        this.f6210a = new LinkedBlockingQueue<>();
        this.f6214e = i5;
        a(i2, i3, i4, i5, i6, str, mediaMuxer);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, String str, MediaMuxer mediaMuxer) {
        this.f6211b = new f(i2, i3, i4, i5, i6, mediaMuxer);
    }

    public boolean b() {
        return this.f6217h;
    }

    public void c() {
        a aVar = new a();
        aVar.f6220b = null;
        aVar.f6219a = 0L;
        this.f6210a.add(aVar);
        this.f6212c = true;
        this.l = null;
        this.m = 0L;
    }

    @Deprecated
    public void d() {
        a aVar = new a();
        aVar.f6220b = null;
        aVar.f6219a = 0L;
        this.f6210a.clear();
        this.f6210a.add(aVar);
        this.f6212c = true;
    }

    public int e() {
        return this.f6213d + 1;
    }

    public int f() {
        LinkedBlockingQueue<a> linkedBlockingQueue = this.f6210a;
        if (linkedBlockingQueue == null) {
            return 0;
        }
        return linkedBlockingQueue.size();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a take;
        if (!this.f6218i) {
            Thread.currentThread().setUncaughtExceptionHandler(this);
            this.f6218i = true;
            LogUtil.i("+initInThread");
            this.f6211b.a();
            LogUtil.i("-initInThread");
        }
        while (true) {
            try {
                LogUtil.i("+mQueue.take");
                take = this.f6210a.take();
                LogUtil.i("-mQueue.take");
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                LogUtil.e(e2.toString());
            }
            if (take.f6220b == null) {
                this.f6215f.clear();
                this.f6210a.clear();
                this.f6211b.b();
                this.f6217h = true;
                return;
            }
            LogUtil.i("+encodeFrame");
            long currentTimeMillis = System.currentTimeMillis();
            this.f6211b.a(take.f6220b, take.f6219a);
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.i("-encodeFrame");
            synchronized (this.f6215f) {
                this.f6215f.add(take.f6220b);
            }
            this.f6213d++;
            LogUtil.i("mRecorder.encodeFrame:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
            if (this.p < 0) {
                this.p = take.f6219a / 1000;
            }
            this.o = (take.f6219a / 1000) - this.p;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
    }

    public void a(byte[] bArr, long j) {
        byte[] bArr2;
        if (this.f6212c || this.f6210a == null) {
            return;
        }
        if (this.f6215f.size() > 0) {
            synchronized (this.f6215f) {
                bArr2 = this.f6215f.pop();
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
        aVar.f6220b = bArr2;
        aVar.f6219a = j;
        if (this.f6210a.size() < 50) {
            this.f6210a.add(aVar);
        }
    }

    public long a() {
        return this.o;
    }

    public void a(d dVar) {
        this.f6216g = dVar;
    }

    public void a(Throwable th) {
        d dVar = this.f6216g;
        if (dVar != null) {
            dVar.a(th);
        }
        th.printStackTrace();
        LogUtil.e(th.toString());
        f fVar = this.f6211b;
        if (fVar != null) {
            fVar.b();
        }
    }
}
