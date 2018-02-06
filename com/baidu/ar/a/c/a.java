package com.baidu.ar.a.c;
/* loaded from: classes3.dex */
public class a {
    private int a = -1;
    private int b = -1;

    public boolean a() {
        return (this.a == 1 || this.a == -1) && this.b == 0;
    }

    public boolean a(boolean z) {
        if (this.b != -1) {
            this.a = this.b;
            this.b = z ? 0 : 1;
        } else if (z) {
            this.a = this.b;
            this.b = 0;
        }
        return this.b != -1;
    }

    public boolean b() {
        return this.a == 0 && this.b == 1;
    }

    public void c() {
        this.a = -1;
        this.b = -1;
    }
}
