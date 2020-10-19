package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int[] f3085a;
    public int[] b;
    public char[] c;

    public b(char[] cArr, int[] iArr, int[] iArr2) {
        this.f3085a = iArr;
        this.b = iArr2;
        this.c = cArr;
    }

    public b a() {
        int[] iArr = new int[this.f3085a.length];
        int[] iArr2 = new int[this.f3085a.length];
        char[] cArr = new char[this.f3085a.length];
        return new b((char[]) this.c.clone(), (int[]) this.f3085a.clone(), (int[]) this.b.clone());
    }

    public static b a(b bVar, b bVar2) {
        int[] iArr = new int[bVar.f3085a.length + bVar2.f3085a.length];
        int[] iArr2 = new int[bVar.f3085a.length + bVar2.f3085a.length];
        char[] cArr = new char[bVar.f3085a.length + bVar2.f3085a.length];
        for (int i = 0; i < bVar.f3085a.length; i++) {
            iArr[i] = bVar.f3085a[i];
            iArr2[i] = bVar.b[i];
            cArr[i] = bVar.c[i];
        }
        for (int i2 = 0; i2 < bVar2.f3085a.length; i2++) {
            iArr[bVar.f3085a.length + i2] = bVar2.f3085a[i2];
            iArr2[bVar.f3085a.length + i2] = bVar2.b[i2];
            cArr[bVar.f3085a.length + i2] = bVar2.c[i2];
        }
        return new b(cArr, iArr, iArr2);
    }

    public static b a(b bVar, int i) {
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = bVar.f3085a[i2];
            iArr2[i2] = bVar.b[i2];
            cArr[i2] = bVar.c[i2];
        }
        return new b(cArr, iArr, iArr2);
    }

    public static b b(b bVar, int i) {
        int length = bVar.c.length - i;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "getTail originLen:" + bVar.c.length);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "getTail tailLen:" + length);
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bVar.f3085a[i + i2];
            iArr2[i2] = bVar.b[i + i2];
            cArr[i2] = bVar.c[i + i2];
        }
        return new b(cArr, iArr, iArr2);
    }
}
