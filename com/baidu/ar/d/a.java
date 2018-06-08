package com.baidu.ar.d;
/* loaded from: classes3.dex */
public class a {
    public int a;
    public int b;

    public a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.a == aVar.a) {
                    return this.b == aVar.b;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int hashCode() {
        return (this.a * 32713) + this.b;
    }
}
