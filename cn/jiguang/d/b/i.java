package cn.jiguang.d.b;
/* loaded from: classes3.dex */
public final class i {
    int a;
    int b = 0;
    long c;
    byte[] d;
    int e;
    String f;

    public i(byte[] bArr, String str, int i) {
        this.d = bArr;
        this.a = i;
        this.f = str;
        if (bArr == null || bArr.length < 24) {
            cn.jiguang.e.c.c("RequestCacheManager", "parse requesting failed");
            return;
        }
        this.e = cn.jiguang.g.a.a(bArr[3]);
        this.c = 0L;
        for (int i2 = 0; i2 < 8; i2++) {
            this.c = (this.c << 8) + (bArr[i2 + 4] & 255);
        }
    }

    public final String a() {
        String b;
        b = h.b(this.c, this.f);
        return b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.c == iVar.c && this.e == iVar.e) {
            return this.f != null ? this.f.equals(iVar.f) : iVar.f == null;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f != null ? this.f.hashCode() : 0) + ((((((int) (this.c ^ (this.c >>> 32))) + 31) * 31) + this.e) * 31);
    }

    public final String toString() {
        return "Requesting{timeout=" + this.a + ", times=" + this.b + ", rid=" + this.c + ", command=" + this.e + ", sdkType='" + this.f + "'}";
    }
}
