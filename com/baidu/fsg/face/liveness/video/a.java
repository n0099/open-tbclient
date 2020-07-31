package com.baidu.fsg.face.liveness.video;

import android.annotation.TargetApi;
import android.media.MediaMuxer;
import com.baidu.fsg.base.utils.LogUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class a extends h {
    public static volatile boolean b = false;
    public static volatile boolean c = false;
    protected g a;
    protected int d;
    protected CountDownLatch e;
    private String t;

    public a(String str, b bVar) {
        super(bVar);
        this.t = str;
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    @TargetApi(18)
    protected boolean a() {
        int a = this.j.a();
        int b2 = this.j.b();
        LogUtil.i("previewSize:" + a + Constants.ACCEPT_TIME_SEPARATOR_SP + b2);
        b = false;
        c = false;
        int c2 = this.j.c();
        try {
            MediaMuxer mediaMuxer = new MediaMuxer(this.t, 0);
            mediaMuxer.setOrientationHint(c2);
            this.e = new CountDownLatch(1);
            this.a = new g(a, b2, this.s, this.q, this.r, null, mediaMuxer, this.e);
            this.a.a(this);
            this.o.d(c2);
            this.o.a(this.t);
            this.o.a(a);
            this.o.b(b2);
            return true;
        } catch (IOException e) {
            a(e);
            return false;
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    protected void b() {
        if (this.i) {
            i();
            this.i = false;
            this.a.c();
            this.d += this.a.e();
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    protected void c() {
        if (this.i) {
            i();
            this.i = false;
            this.a.c();
            this.d += this.a.e();
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    protected void d() {
        this.l.submit(new Runnable() { // from class: com.baidu.fsg.face.liveness.video.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.e();
                a.this.n = System.currentTimeMillis();
                VideoInfo.a(a.this.o.a(), a.this.o);
                a.this.d = 0;
            }
        });
    }

    protected void e() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        int i = -1;
        long j = 0;
        long j2 = 1000;
        while (true) {
            try {
                z = !this.e.await(j2, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                z = false;
            }
            j2 = 5000;
            if (!z) {
                if (this.p) {
                }
                return;
            } else if (!this.a.isAlive()) {
                if (!this.p && !this.a.b()) {
                    a(new RuntimeException("wait record stop" + (System.currentTimeMillis() - currentTimeMillis) + "ms,timeout"));
                    return;
                }
                return;
            } else if (i != this.a.f()) {
                i = this.a.f();
                j = System.currentTimeMillis();
            } else if (System.currentTimeMillis() - j > 10000) {
                String str = (System.currentTimeMillis() - j) + "ms cannot write finish, record fail";
                LogUtil.e(str);
                a(new RuntimeException(str));
                return;
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.e
    public void a(byte[] bArr, long j) {
        if (this.i && bArr != null && !this.k) {
            this.a.a(bArr, j);
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.d
    public void a(Throwable th) {
        if (!this.p) {
            LogUtil.i("onVideoRecordFail");
            synchronized (this) {
                if (!this.p) {
                    this.p = true;
                    if (th != null) {
                        LogUtil.e(th.toString());
                        th.printStackTrace();
                    }
                    if (this.i) {
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
    }

    @Override // com.baidu.fsg.face.liveness.video.c
    public void f() {
        this.p = false;
        h();
        if (a()) {
            this.a.start();
            this.m = System.currentTimeMillis();
            this.i = true;
        }
    }
}
