package cn.jiguang.d.c;

import java.io.Serializable;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public final class j implements Serializable, Comparable {
    public static final j a;
    public static final j b;
    private static final j lm;
    private byte[] c;
    private long d;
    private int e;
    private static final byte[] f = {0};
    private static final byte[] g = {1, 42};
    private static final DecimalFormat ll = new DecimalFormat();
    private static final byte[] i = new byte[256];

    static {
        ll.setMinimumIntegerDigits(3);
        for (int i2 = 0; i2 < i.length; i2++) {
            if (i2 < 65 || i2 > 90) {
                i[i2] = (byte) i2;
            } else {
                i[i2] = (byte) ((i2 - 65) + 97);
            }
        }
        j jVar = new j();
        a = jVar;
        jVar.b(f, 0, 1);
        j jVar2 = new j();
        b = jVar2;
        jVar2.c = new byte[0];
        j jVar3 = new j();
        lm = jVar3;
        jVar3.b(g, 0, 1);
    }

    private j() {
    }

    public j(d dVar) {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z2) {
            int f2 = dVar.f();
            switch (f2 & 192) {
                case 0:
                    if (c() < 128) {
                        if (f2 != 0) {
                            bArr[0] = (byte) f2;
                            dVar.a(bArr, 1, f2);
                            a(bArr, 0, 1);
                            break;
                        } else {
                            a(f, 0, 1);
                            z2 = true;
                            break;
                        }
                    } else {
                        throw new t("too many labels");
                    }
                case 192:
                    int f3 = ((f2 & (-193)) << 8) + dVar.f();
                    if (f3 < dVar.a() - 2) {
                        if (!z) {
                            dVar.d();
                            z = true;
                        }
                        dVar.b(f3);
                        break;
                    } else {
                        throw new t("bad compression");
                    }
                default:
                    throw new t("bad label type");
            }
        }
        if (z) {
            dVar.e();
        }
    }

    private j(j jVar, int i2) {
        int c = jVar.c();
        if (i2 > c) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        this.c = jVar.c;
        b(c - i2);
        for (int i3 = 0; i3 < 7 && i3 < c - i2; i3++) {
            a(i3, jVar.a(i3 + i2));
        }
    }

    private j(String str, j jVar) {
        boolean z;
        byte b2;
        if (str.equals("")) {
            throw g(str, "empty name");
        }
        if (str.equals("@")) {
            if (jVar == null) {
                b(b, this);
            } else {
                b(jVar, this);
            }
        } else if (str.equals(".")) {
            b(a, this);
        } else {
            int i2 = -1;
            int i3 = 1;
            byte[] bArr = new byte[64];
            boolean z2 = false;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < str.length(); i6++) {
                byte charAt = (byte) str.charAt(i6);
                if (z2) {
                    if (charAt >= 48 && charAt <= 57 && i4 < 3) {
                        i4++;
                        i5 = (i5 * 10) + (charAt - 48);
                        if (i5 > 255) {
                            throw g(str, "bad escape");
                        }
                        if (i4 >= 3) {
                            b2 = (byte) i5;
                        } else {
                            continue;
                        }
                    } else if (i4 > 0 && i4 < 3) {
                        throw g(str, "bad escape");
                    } else {
                        b2 = charAt;
                    }
                    if (i3 > 63) {
                        throw g(str, "label too long");
                    }
                    bArr[i3] = b2;
                    z2 = false;
                    i2 = i3;
                    i3++;
                } else if (charAt == 92) {
                    z2 = true;
                    i4 = 0;
                    i5 = 0;
                } else if (charAt != 46) {
                    int i7 = i2 == -1 ? i6 : i2;
                    if (i3 > 63) {
                        throw g(str, "label too long");
                    }
                    bArr[i3] = charAt;
                    i3++;
                    i2 = i7;
                } else if (i2 == -1) {
                    throw g(str, "invalid empty label");
                } else {
                    bArr[0] = (byte) (i3 - 1);
                    a(str, bArr, 0, 1);
                    i2 = -1;
                    i3 = 1;
                }
            }
            if (i4 > 0 && i4 < 3) {
                throw g(str, "bad escape");
            }
            if (z2) {
                throw g(str, "bad escape");
            }
            if (i2 == -1) {
                a(str, f, 0, 1);
                z = true;
            } else {
                bArr[0] = (byte) (i3 - 1);
                a(str, bArr, 0, 1);
                z = false;
            }
            if (jVar == null || z) {
                return;
            }
            a(str, jVar.c, jVar.a(0), jVar.c());
        }
    }

    private final int a(int i2) {
        if (i2 == 0 && c() == 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= c()) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i2 < 7) {
            return ((int) (this.d >>> ((7 - i2) * 8))) & 255;
        }
        int a2 = a(6);
        int i3 = 6;
        while (i3 < i2) {
            i3++;
            a2 = this.c[a2] + 1 + a2;
        }
        return a2;
    }

    public static j a(j jVar, j jVar2) {
        if (jVar.a()) {
            return jVar;
        }
        j jVar3 = new j();
        b(jVar, jVar3);
        jVar3.a(jVar2.c, jVar2.a(0), jVar2.c());
        return jVar3;
    }

    public static j a(String str) {
        return a(str, (j) null);
    }

    public static j a(String str, j jVar) {
        return (!str.equals("@") || jVar == null) ? str.equals(".") ? a : new j(str, jVar) : jVar;
    }

    private static String a(byte[] bArr, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + 1;
        int i4 = bArr[i2];
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            int i6 = bArr[i5] & 255;
            if (i6 <= 32 || i6 >= 127) {
                stringBuffer.append('\\');
                stringBuffer.append(ll.format(i6));
            } else if (i6 == 34 || i6 == 40 || i6 == 41 || i6 == 46 || i6 == 59 || i6 == 92 || i6 == 64 || i6 == 36) {
                stringBuffer.append('\\');
                stringBuffer.append((char) i6);
            } else {
                stringBuffer.append((char) i6);
            }
        }
        return stringBuffer.toString();
    }

    private final void a(int i2, int i3) {
        if (i2 >= 7) {
            return;
        }
        int i4 = (7 - i2) * 8;
        this.d &= (255 << i4) ^ (-1);
        this.d = (i3 << i4) | this.d;
    }

    private final void a(String str, byte[] bArr, int i2, int i3) {
        try {
            a(bArr, i2, i3);
        } catch (k e) {
            throw g(str, "Name too long");
        }
    }

    private final void a(byte[] bArr, int i2, int i3) {
        int length = this.c == null ? 0 : this.c.length - a(0);
        int i4 = i2;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = bArr[i4];
            if (i7 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i8 = i7 + 1;
            i4 += i8;
            i5 += i8;
        }
        int i9 = length + i5;
        if (i9 > 255) {
            throw new k();
        }
        int c = c();
        int i10 = c + i3;
        if (i10 > 128) {
            throw new IllegalStateException("too many labels");
        }
        byte[] bArr2 = new byte[i9];
        if (length != 0) {
            System.arraycopy(this.c, a(0), bArr2, 0, length);
        }
        System.arraycopy(bArr, i2, bArr2, length, i5);
        this.c = bArr2;
        for (int i11 = 0; i11 < i3; i11++) {
            a(c + i11, length);
            length += bArr2[length] + 1;
        }
        b(i10);
    }

    private final void b(int i2) {
        this.d &= -256;
        this.d |= i2;
    }

    private static final void b(j jVar, j jVar2) {
        if (jVar.a(0) == 0) {
            jVar2.c = jVar.c;
            jVar2.d = jVar.d;
            return;
        }
        int a2 = jVar.a(0);
        int length = jVar.c.length - a2;
        int c = jVar.c();
        jVar2.c = new byte[length];
        System.arraycopy(jVar.c, a2, jVar2.c, 0, length);
        for (int i2 = 0; i2 < c && i2 < 7; i2++) {
            jVar2.a(i2, jVar.a(i2) - a2);
        }
        jVar2.b(c);
    }

    private final void b(byte[] bArr, int i2, int i3) {
        try {
            a(bArr, 0, 1);
        } catch (k e) {
        }
    }

    private final int c() {
        return (int) (this.d & 255);
    }

    private static s g(String str, String str2) {
        return new s("'" + str + "': " + str2);
    }

    public final void a(e eVar) {
        byte[] bArr;
        int c = c();
        if (c == 0) {
            bArr = new byte[0];
        } else {
            bArr = new byte[this.c.length - a(0)];
            int a2 = a(0);
            int i2 = 0;
            for (int i3 = 0; i3 < c; i3++) {
                byte b2 = this.c[a2];
                if (b2 > 63) {
                    throw new IllegalStateException("invalid label");
                }
                bArr[i2] = this.c[a2];
                a2++;
                int i4 = i2 + 1;
                int i5 = 0;
                while (i5 < b2) {
                    bArr[i4] = i[this.c[a2] & 255];
                    i5++;
                    i4++;
                    a2++;
                }
                i2 = i4;
            }
        }
        eVar.a(bArr);
    }

    public final void a(e eVar, b bVar) {
        int c = c();
        int i2 = 0;
        while (i2 < c - 1) {
            j jVar = i2 == 0 ? this : new j(this, i2);
            int a2 = bVar != null ? bVar.a(jVar) : -1;
            if (a2 >= 0) {
                eVar.c(a2 | 49152);
                return;
            }
            if (bVar != null) {
                bVar.a(eVar.a(), jVar);
            }
            int a3 = a(i2);
            eVar.a(this.c, a3, this.c[a3] + 1);
            i2++;
        }
        eVar.b(0);
    }

    public final void a(e eVar, b bVar, boolean z) {
        if (z) {
            a(eVar);
        } else {
            a(eVar, (b) null);
        }
    }

    public final boolean a() {
        int c = c();
        return c != 0 && this.c[a(c + (-1))] == 0;
    }

    public final int b() {
        return c();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        j jVar = (j) obj;
        if (this == jVar) {
            return 0;
        }
        int c = c();
        int c2 = jVar.c();
        int i2 = c > c2 ? c2 : c;
        for (int i3 = 1; i3 <= i2; i3++) {
            int a2 = a(c - i3);
            int a3 = jVar.a(c2 - i3);
            byte b2 = this.c[a2];
            byte b3 = jVar.c[a3];
            for (byte b4 = 0; b4 < b2 && b4 < b3; b4++) {
                int i4 = i[this.c[(b4 + a2) + 1] & 255] - i[jVar.c[(b4 + a3) + 1] & 255];
                if (i4 != 0) {
                    return i4;
                }
            }
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return c - c2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar.e == 0) {
            jVar.hashCode();
        }
        if (this.e == 0) {
            hashCode();
        }
        if (jVar.e == this.e && jVar.c() == c()) {
            byte[] bArr = jVar.c;
            int a2 = jVar.a(0);
            int c = c();
            int a3 = a(0);
            for (int i2 = 0; i2 < c; i2++) {
                if (this.c[a3] != bArr[a2]) {
                    return false;
                }
                int i3 = a3 + 1;
                byte b2 = this.c[a3];
                int i4 = a2 + 1;
                if (b2 > 63) {
                    throw new IllegalStateException("invalid label");
                }
                a2 = i4;
                a3 = i3;
                int i5 = 0;
                while (i5 < b2) {
                    int i6 = a3 + 1;
                    byte b3 = i[this.c[a3] & 255];
                    int i7 = a2 + 1;
                    if (b3 != i[bArr[a2] & 255]) {
                        return false;
                    }
                    i5++;
                    a2 = i7;
                    a3 = i6;
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = 0;
        if (this.e != 0) {
            return this.e;
        }
        for (int a2 = a(0); a2 < this.c.length; a2++) {
            i2 += (i2 << 3) + i[this.c[a2] & 255];
        }
        this.e = i2;
        return this.e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        return r3.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toString() {
        int i2 = 0;
        int c = c();
        if (c == 0) {
            return "@";
        }
        if (c == 1 && this.c[a(0)] == 0) {
            return ".";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int a2 = a(0);
        while (true) {
            if (i2 >= c) {
                break;
            }
            byte b2 = this.c[a2];
            if (b2 > 63) {
                throw new IllegalStateException("invalid label");
            }
            if (b2 == 0) {
                stringBuffer.append('.');
                break;
            }
            if (i2 > 0) {
                stringBuffer.append('.');
            }
            stringBuffer.append(a(this.c, a2));
            a2 += b2 + 1;
            i2++;
        }
    }
}
