package com.baidu.mobstat;
/* loaded from: classes15.dex */
public class ch extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f3832a;

    public ch(int i) {
        this.f3832a = i;
    }

    public ch(int i, String str) {
        super(str);
        this.f3832a = i;
    }

    public ch(int i, Throwable th) {
        super(th);
        this.f3832a = i;
    }

    public int a() {
        return this.f3832a;
    }
}
