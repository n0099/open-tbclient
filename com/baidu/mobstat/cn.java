package com.baidu.mobstat;
/* loaded from: classes3.dex */
public class cn extends Exception {
    public int a;

    public cn(int i) {
        this.a = i;
    }

    public cn(int i, String str) {
        super(str);
        this.a = i;
    }

    public cn(int i, Throwable th) {
        super(th);
        this.a = i;
    }

    public int a() {
        return this.a;
    }
}
