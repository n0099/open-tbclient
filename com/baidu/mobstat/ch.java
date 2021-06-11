package com.baidu.mobstat;
/* loaded from: classes2.dex */
public class ch extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public int f8837a;

    public ch(int i2) {
        this.f8837a = i2;
    }

    public int a() {
        return this.f8837a;
    }

    public ch(int i2, String str) {
        super(str);
        this.f8837a = i2;
    }

    public ch(int i2, Throwable th) {
        super(th);
        this.f8837a = i2;
    }
}
