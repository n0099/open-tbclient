package com.baidu.android.nebula.d;

import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f675a = false;
    private long b = Util.MILLSECONDS_OF_MINUTE;
    private long c = System.currentTimeMillis();

    public abstract int a(ByteBuffer byteBuffer);

    public void a(long j) {
        this.b = j;
    }

    public abstract int b(ByteBuffer byteBuffer);

    public abstract boolean b();

    public abstract boolean c();

    public void d() {
        this.f675a = true;
    }

    public boolean e() {
        return this.f675a;
    }

    public boolean f() {
        return this.b != 0 && System.currentTimeMillis() - this.c > this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.c = System.currentTimeMillis();
    }
}
