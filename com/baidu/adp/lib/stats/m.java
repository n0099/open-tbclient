package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
final class m {
    final /* synthetic */ l a;
    private long b;
    private boolean c;
    private int d;
    private long e;
    private boolean f;

    private m(l lVar) {
        this.a = lVar;
        this.c = false;
        this.d = 0;
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(l lVar, byte b) {
        this(lVar);
    }

    public final boolean a() {
        return this.f;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final long b() {
        return this.e;
    }

    public final void a(long j) {
        this.e = j;
    }

    public final int c() {
        return this.d;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final long d() {
        return this.b;
    }

    public final void b(long j) {
        this.b = j;
    }

    public final boolean e() {
        return this.c;
    }

    public final void b(boolean z) {
        this.c = z;
    }
}
