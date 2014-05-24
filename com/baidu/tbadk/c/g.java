package com.baidu.tbadk.c;
/* loaded from: classes.dex */
public class g {
    public String a;
    public String b;

    public g(String str, String str2) {
        this.a = "";
        this.b = "";
        this.a = str;
        this.b = str2;
    }

    public int hashCode() {
        return (((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            g gVar = (g) obj;
            if (this.a == null) {
                if (gVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(gVar.a)) {
                return false;
            }
            return this.b == null ? gVar.b == null : this.b.equals(gVar.b);
        }
        return false;
    }
}
