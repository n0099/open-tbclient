package com.baidu.mobstat;
/* loaded from: classes17.dex */
public class ch extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f2604a;

    public ch(int i) {
        this.f2604a = i;
    }

    public ch(int i, String str) {
        super(str);
        this.f2604a = i;
    }

    public ch(int i, Throwable th) {
        super(th);
        this.f2604a = i;
    }

    public int a() {
        return this.f2604a;
    }
}
