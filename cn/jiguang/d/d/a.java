package cn.jiguang.d.d;

import java.io.Serializable;
/* loaded from: classes3.dex */
public final class a implements Serializable {
    public String a;
    public String b;
    public int c;
    public String d;

    public a() {
        this.a = "";
        this.b = "";
        this.c = 0;
    }

    public a(String str, String str2, int i) {
        this.a = "";
        this.b = "";
        this.c = 0;
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return (cn.jiguang.g.i.a(this.a) || cn.jiguang.g.i.a(this.b) || cn.jiguang.g.i.a(aVar.a) || cn.jiguang.g.i.a(aVar.b) || !cn.jiguang.g.i.a(this.a, aVar.a) || !cn.jiguang.g.i.a(this.b, aVar.b)) ? false : true;
        }
        return false;
    }

    public final String toString() {
        return "AWakeInfo{pk_name='" + this.a + "', sv_name='" + this.b + "', target_version=" + this.c + ", providerAuthority='" + this.d + "'}";
    }
}
