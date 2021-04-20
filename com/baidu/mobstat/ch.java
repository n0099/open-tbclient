package com.baidu.mobstat;
/* loaded from: classes2.dex */
public class ch extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public int f8750a;

    public ch(int i) {
        this.f8750a = i;
    }

    public int a() {
        return this.f8750a;
    }

    public ch(int i, String str) {
        super(str);
        this.f8750a = i;
    }

    public ch(int i, Throwable th) {
        super(th);
        this.f8750a = i;
    }
}
