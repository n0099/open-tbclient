package com.baidu.mobstat;
/* loaded from: classes8.dex */
public class ch extends Exception {
    private int a;

    public ch(int i) {
        this.a = i;
    }

    public ch(int i, String str) {
        super(str);
        this.a = i;
    }

    public ch(int i, Throwable th) {
        super(th);
        this.a = i;
    }

    public int a() {
        return this.a;
    }
}
