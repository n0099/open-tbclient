package com.baidu.ar.f;
/* loaded from: classes3.dex */
public class f {
    public int a;
    public int b;
    public int c;

    public f(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.a == fVar.a && this.b == fVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 32713) + this.b;
    }
}
