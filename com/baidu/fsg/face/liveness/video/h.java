package com.baidu.fsg.face.liveness.video;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public abstract class h implements c {
    public static final int f = 24;
    public static final int g = 1;
    public static final int h = 1048576;
    public volatile boolean i;
    protected b j;
    protected long m;
    protected long n;
    protected volatile boolean k = false;
    protected ExecutorService l = Executors.newSingleThreadExecutor();
    protected VideoInfo o = new VideoInfo();
    protected volatile boolean p = false;
    protected int q = 24;
    protected int r = 1;
    protected int s = 1048576;

    protected abstract boolean a();

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    public h(b bVar) {
        this.j = bVar;
    }

    @Override // com.baidu.fsg.face.liveness.video.c
    public void g() {
        if (this.i && !this.p) {
            b();
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        if (this.j != null) {
            this.j.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        if (this.j != null) {
            this.j.b(this);
        }
    }
}
