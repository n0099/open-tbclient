package com.baidu.fsg.face.liveness.video;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public abstract class h implements c {

    /* renamed from: f  reason: collision with root package name */
    public static final int f5975f = 24;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5976g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5977h = 1048576;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f5978i;
    public b j;
    public long m;
    public long n;
    public volatile boolean k = false;
    public ExecutorService l = Executors.newSingleThreadExecutor();
    public VideoInfo o = new VideoInfo();
    public volatile boolean p = false;
    public int q = 24;
    public int r = 1;
    public int s = 1048576;

    public h(b bVar) {
        this.j = bVar;
    }

    public abstract boolean a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    @Override // com.baidu.fsg.face.liveness.video.c
    public void g() {
        if (!this.f5978i || this.p) {
            return;
        }
        b();
        d();
    }

    public void h() {
        b bVar = this.j;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void i() {
        b bVar = this.j;
        if (bVar != null) {
            bVar.b(this);
        }
    }
}
