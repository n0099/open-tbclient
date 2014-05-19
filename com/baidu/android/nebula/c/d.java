package com.baidu.android.nebula.c;

import com.baidu.tbadk.TbConfig;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public abstract class d {
    private boolean a = false;
    private long b = TbConfig.USE_TIME_INTERVAL;
    private long c = System.currentTimeMillis();

    public abstract int a(ByteBuffer byteBuffer);

    public void a(long j) {
        this.b = j;
    }

    public abstract int b(ByteBuffer byteBuffer);

    public abstract boolean b();

    public abstract boolean c();

    public void d() {
        this.a = true;
    }

    public boolean e() {
        return this.a;
    }

    public boolean f() {
        return this.b != 0 && System.currentTimeMillis() - this.c > this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.c = System.currentTimeMillis();
    }
}
