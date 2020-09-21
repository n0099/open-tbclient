package com.baidu.mapsdkplatform.comapi.commonutils.a;
/* loaded from: classes3.dex */
public class a {
    private int a;
    private int b;
    private int c;

    public a(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.c = i;
    }

    public int b() {
        return this.c;
    }

    public String toString() {
        return "DownloadThreadInfo{id=" + this.a + ", start=" + this.b + ", end=" + this.c + '}';
    }
}
