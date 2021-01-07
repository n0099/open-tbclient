package com.baidu.mapsdkplatform.comapi.commonutils.a;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f3145a;

    /* renamed from: b  reason: collision with root package name */
    private int f3146b;
    private int c;

    public a(int i, int i2, int i3) {
        this.f3145a = i;
        this.f3146b = i2;
        this.c = i3;
    }

    public int a() {
        return this.f3146b;
    }

    public void a(int i) {
        this.c = i;
    }

    public int b() {
        return this.c;
    }

    public String toString() {
        return "DownloadThreadInfo{id=" + this.f3145a + ", start=" + this.f3146b + ", end=" + this.c + '}';
    }
}
