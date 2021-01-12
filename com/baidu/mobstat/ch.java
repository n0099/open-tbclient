package com.baidu.mobstat;
/* loaded from: classes14.dex */
public class ch extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f3794a;

    public ch(int i) {
        this.f3794a = i;
    }

    public ch(int i, String str) {
        super(str);
        this.f3794a = i;
    }

    public ch(int i, Throwable th) {
        super(th);
        this.f3794a = i;
    }

    public int a() {
        return this.f3794a;
    }
}
