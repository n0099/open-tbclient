package com.baidu.pano.platform.a;
/* loaded from: classes20.dex */
public class v extends Exception {
    public final l a;
    private long b;

    public v() {
        this.a = null;
    }

    public v(l lVar) {
        this.a = lVar;
    }

    public v(Throwable th) {
        super(th);
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.b = j;
    }
}
