package com.baidu.mobstat;
/* loaded from: classes15.dex */
public class ch extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f3831a;

    public ch(int i) {
        this.f3831a = i;
    }

    public ch(int i, String str) {
        super(str);
        this.f3831a = i;
    }

    public ch(int i, Throwable th) {
        super(th);
        this.f3831a = i;
    }

    public int a() {
        return this.f3831a;
    }
}
