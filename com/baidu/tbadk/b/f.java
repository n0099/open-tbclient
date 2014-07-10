package com.baidu.tbadk.b;
/* loaded from: classes.dex */
public class f {
    public String a;
    public String b;

    public f(String str, String str2) {
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
            f fVar = (f) obj;
            if (this.a == null) {
                if (fVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(fVar.a)) {
                return false;
            }
            return this.b == null ? fVar.b == null : this.b.equals(fVar.b);
        }
        return false;
    }
}
