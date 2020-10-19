package com.baidu.pano.platform.a;
/* loaded from: classes7.dex */
public class v extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final l f2661a;
    private long b;

    public v() {
        this.f2661a = null;
    }

    public v(l lVar) {
        this.f2661a = lVar;
    }

    public v(Throwable th) {
        super(th);
        this.f2661a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.b = j;
    }
}
