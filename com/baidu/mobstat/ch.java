package com.baidu.mobstat;
/* loaded from: classes4.dex */
public class ch extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f2657a;

    public ch(int i) {
        this.f2657a = i;
    }

    public ch(int i, String str) {
        super(str);
        this.f2657a = i;
    }

    public ch(int i, Throwable th) {
        super(th);
        this.f2657a = i;
    }

    public int a() {
        return this.f2657a;
    }
}
