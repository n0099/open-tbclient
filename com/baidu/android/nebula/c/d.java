package com.baidu.android.nebula.c;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f278a = false;
    private long b = 60000;
    private long c = System.currentTimeMillis();

    public abstract int a(ByteBuffer byteBuffer);

    public void a(long j) {
        this.b = j;
    }

    public abstract int b(ByteBuffer byteBuffer);

    public abstract boolean b();

    public abstract boolean c();

    public void d() {
        this.f278a = true;
    }

    public boolean e() {
        return this.f278a;
    }

    public boolean f() {
        return this.b != 0 && System.currentTimeMillis() - this.c > this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.c = System.currentTimeMillis();
    }
}
