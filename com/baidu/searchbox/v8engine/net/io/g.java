package com.baidu.searchbox.v8engine.net.io;

import java.util.Arrays;
/* loaded from: classes2.dex */
public final class g extends d {

    /* renamed from: f  reason: collision with root package name */
    public final transient byte[][] f10146f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int[] f10147g;

    public g(a aVar, int i2) {
        super(null);
        j.a(aVar.f10131b, 0L, i2);
        e eVar = aVar.f10130a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = eVar.f10139c;
            int i7 = eVar.f10138b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                eVar = eVar.f10142f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f10146f = new byte[i5];
        this.f10147g = new int[i5 * 2];
        e eVar2 = aVar.f10130a;
        int i8 = 0;
        while (i3 < i2) {
            this.f10146f[i8] = eVar2.f10137a;
            i3 += eVar2.f10139c - eVar2.f10138b;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f10147g;
            iArr[i8] = i3;
            iArr[this.f10146f.length + i8] = eVar2.f10138b;
            eVar2.f10140d = true;
            i8++;
            eVar2 = eVar2.f10142f;
        }
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
        return this.f10147g[this.f10146f.length - 1];
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public byte[] d() {
        int[] iArr = this.f10147g;
        byte[][] bArr = this.f10146f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f10147g;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f10146f[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
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

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public int hashCode() {
        int i2 = this.f10135d;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f10146f.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < length) {
            byte[] bArr = this.f10146f[i3];
            int[] iArr = this.f10147g;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i4) + i6;
            while (i6 < i8) {
                i5 = (i5 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i4 = i7;
        }
        this.f10135d = i5;
        return i5;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public String toString() {
        return e().toString();
    }

    private int b(int i2) {
        int binarySearch = Arrays.binarySearch(this.f10147g, 0, this.f10146f.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public d a(int i2, int i3) {
        return e().a(i2, i3);
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public byte a(int i2) {
        j.a(this.f10147g[this.f10146f.length - 1], i2, 1L);
        int b2 = b(i2);
        int i3 = b2 == 0 ? 0 : this.f10147g[b2 - 1];
        int[] iArr = this.f10147g;
        byte[][] bArr = this.f10146f;
        return bArr[b2][(i2 - i3) + iArr[bArr.length + b2]];
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public boolean a(int i2, d dVar, int i3, int i4) {
        if (i2 < 0 || i2 > c() - i4) {
            return false;
        }
        int b2 = b(i2);
        while (i4 > 0) {
            int i5 = b2 == 0 ? 0 : this.f10147g[b2 - 1];
            int min = Math.min(i4, ((this.f10147g[b2] - i5) + i5) - i2);
            int[] iArr = this.f10147g;
            byte[][] bArr = this.f10146f;
            if (!dVar.a(i3, bArr[b2], (i2 - i5) + iArr[bArr.length + b2], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b2++;
        }
        return true;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > c() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int b2 = b(i2);
        while (i4 > 0) {
            int i5 = b2 == 0 ? 0 : this.f10147g[b2 - 1];
            int min = Math.min(i4, ((this.f10147g[b2] - i5) + i5) - i2);
            int[] iArr = this.f10147g;
            byte[][] bArr2 = this.f10146f;
            if (!j.a(bArr2[b2], (i2 - i5) + iArr[bArr2.length + b2], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b2++;
        }
        return true;
    }
}
