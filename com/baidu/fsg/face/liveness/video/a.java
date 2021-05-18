package com.baidu.fsg.face.liveness.video;

import android.annotation.TargetApi;
import android.media.MediaMuxer;
import com.baidu.fsg.base.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a extends h {

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f6049b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f6050c = false;

    /* renamed from: a  reason: collision with root package name */
    public g f6051a;

    /* renamed from: d  reason: collision with root package name */
    public int f6052d;

    /* renamed from: e  reason: collision with root package name */
    public CountDownLatch f6053e;
    public String t;

    public a(String str, b bVar) {
        super(bVar);
        this.t = str;
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    @TargetApi(18)
    public boolean a() {
        int a2 = this.j.a();
        int b2 = this.j.b();
        LogUtil.i("previewSize:" + a2 + "," + b2);
        f6049b = false;
        f6050c = false;
        int c2 = this.j.c();
        try {
            MediaMuxer mediaMuxer = new MediaMuxer(this.t, 0);
            mediaMuxer.setOrientationHint(c2);
            this.f6053e = new CountDownLatch(1);
            g gVar = new g(a2, b2, this.s, this.q, this.r, null, mediaMuxer, this.f6053e);
            this.f6051a = gVar;
            gVar.a(this);
            this.o.d(c2);
            this.o.a(this.t);
            this.o.a(a2);
            this.o.b(b2);
            return true;
        } catch (IOException e2) {
            a(e2);
            return false;
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    public void b() {
        if (this.f6078i) {
            i();
            this.f6078i = false;
            this.f6051a.c();
            this.f6052d += this.f6051a.e();
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    public void c() {
        if (this.f6078i) {
            i();
            this.f6078i = false;
            this.f6051a.c();
            this.f6052d += this.f6051a.e();
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    public void d() {
        this.l.submit(new Runnable() { // from class: com.baidu.fsg.face.liveness.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.e();
                a.this.n = System.currentTimeMillis();
                VideoInfo.a(a.this.o.a(), a.this.o);
                a.this.f6052d = 0;
            }
        });
    }

    public void e() {
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = -1;
        long j = 0;
        long j2 = 1000;
        while (true) {
            boolean z = false;
            try {
                z = !this.f6053e.await(j2, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
            }
            j2 = 5000;
            if (!z) {
                if (this.p) {
                    return;
                }
                return;
            } else if (!this.f6051a.isAlive()) {
                if (this.p || this.f6051a.b()) {
                    return;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                a(new RuntimeException("wait record stop" + (currentTimeMillis2 - currentTimeMillis) + "ms,timeout"));
                return;
            } else if (i2 != this.f6051a.f()) {
                i2 = this.f6051a.f();
                j = System.currentTimeMillis();
            } else if (System.currentTimeMillis() - j > 10000) {
                String str = (System.currentTimeMillis() - j) + "ms cannot write finish, record fail";
                LogUtil.e(str);
                a(new RuntimeException(str));
                return;
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.c
    public void f() {
        this.p = false;
        h();
        if (a()) {
            this.f6051a.start();
            this.m = System.currentTimeMillis();
            this.f6078i = true;
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.e
    public void a(byte[] bArr, long j) {
        if (!this.f6078i || bArr == null || this.k) {
            return;
        }
        this.f6051a.a(bArr, j);
    }

    @Override // com.baidu.fsg.face.liveness.video.d
    public void a(Throwable th) {
        if (this.p) {
            return;
        }
        LogUtil.i("onVideoRecordFail");
        synchronized (this) {
            if (this.p) {
                return;
            }
            this.p = true;
            if (th != null) {
                LogUtil.e(th.toString());
                th.printStackTrace();
            }
            if (this.f6078i) {
                LogUtil.i("stopRecordAndCancel");
                c();
            }
            File file = new File(this.o.a());
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
