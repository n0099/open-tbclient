package com.baidu.android.nebula.b;
/* loaded from: classes.dex */
public final class o extends Exception {
    private final u a;

    public o(u uVar, String str) {
        super(str);
        this.a = uVar;
    }

    public o(u uVar, String str, Exception exc) {
        super(str, exc);
        this.a = uVar;
    }

    public u a() {
        return this.a;
    }
}
