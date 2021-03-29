package com.baidu.mobstat;
/* loaded from: classes2.dex */
public class ch extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public int f9176a;

    public ch(int i) {
        this.f9176a = i;
    }

    public int a() {
        return this.f9176a;
    }

    public ch(int i, String str) {
        super(str);
        this.f9176a = i;
    }

    public ch(int i, Throwable th) {
        super(th);
        this.f9176a = i;
    }
}
