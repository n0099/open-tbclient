package com.baidu.searchbox.v8engine.net.io;

import java.util.Arrays;
/* loaded from: classes4.dex */
public final class g extends d {
    public final transient byte[][] f;
    public final transient int[] g;

    public g(a aVar, int i) {
        super(null);
        j.a(aVar.b, 0L, i);
        e eVar = aVar.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = eVar.c;
            int i6 = eVar.b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                eVar = eVar.f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f = new byte[i4];
        this.g = new int[i4 * 2];
        e eVar2 = aVar.a;
        int i7 = 0;
        while (i2 < i) {
            this.f[i7] = eVar2.a;
            i2 += eVar2.c - eVar2.b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.g;
            iArr[i7] = i2;
            iArr[this.f.length + i7] = eVar2.b;
            eVar2.d = true;
            i7++;
            eVar2 = eVar2.f;
        }
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        return binarySearch;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public byte a(int i) {
        int i2;
        j.a(this.g[this.f.length - 1], i, 1L);
        int b = b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.g[b - 1];
        }
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        return bArr[b][(i - i2) + iArr[bArr.length + b]];
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.c() == c() && a(0, dVar, 0, c())) {
                return true;
            }
        }
        return false;
    }

    private d e() {
        return new d(d());
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public String a() {
        return e().a();
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public String b() {
        return e().b();
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public int c() {
        return this.g[this.f.length - 1];
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public byte[] d() {
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int length = this.f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f[i2];
            int[] iArr = this.g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.d = i4;
        return i4;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public String toString() {
        return e().toString();
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public d a(int i, int i2) {
        return e().a(i, i2);
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public boolean a(int i, d dVar, int i2, int i3) {
        int i4;
        if (i < 0 || i > c() - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.g[b - 1];
            }
            int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr = this.f;
            if (!dVar.a(i2, bArr[b], (i - i4) + iArr[bArr.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > c() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.g[b - 1];
            }
            int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr2 = this.f;
            if (!j.a(bArr2[b], (i - i4) + iArr[bArr2.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }
}
