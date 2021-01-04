package com.baidu.mapsdkplatform.comapi.commonutils.a;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f3144a;

    /* renamed from: b  reason: collision with root package name */
    private int f3145b;
    private int c;

    public a(int i, int i2, int i3) {
        this.f3144a = i;
        this.f3145b = i2;
        this.c = i3;
    }

    public int a() {
        return this.f3145b;
    }

    public void a(int i) {
        this.c = i;
    }

    public int b() {
        return this.c;
    }

    public String toString() {
        return "DownloadThreadInfo{id=" + this.f3144a + ", start=" + this.f3145b + ", end=" + this.c + '}';
    }
}
