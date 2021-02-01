package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int[] f4370a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f4371b;
    public char[] c;

    public c(char[] cArr, int[] iArr, int[] iArr2) {
        this.f4370a = iArr;
        this.f4371b = iArr2;
        this.c = cArr;
    }

    public c a() {
        int[] iArr = new int[this.f4370a.length];
        int[] iArr2 = new int[this.f4370a.length];
        char[] cArr = new char[this.f4370a.length];
        return new c((char[]) this.c.clone(), (int[]) this.f4370a.clone(), (int[]) this.f4371b.clone());
    }

    public static c a(c cVar, c cVar2) {
        int[] iArr = new int[cVar.f4370a.length + cVar2.f4370a.length];
        int[] iArr2 = new int[cVar.f4370a.length + cVar2.f4370a.length];
        char[] cArr = new char[cVar.f4370a.length + cVar2.f4370a.length];
        for (int i = 0; i < cVar.f4370a.length; i++) {
            iArr[i] = cVar.f4370a[i];
            iArr2[i] = cVar.f4371b[i];
            cArr[i] = cVar.c[i];
        }
        for (int i2 = 0; i2 < cVar2.f4370a.length; i2++) {
            iArr[cVar.f4370a.length + i2] = cVar2.f4370a[i2];
            iArr2[cVar.f4370a.length + i2] = cVar2.f4371b[i2];
            cArr[cVar.f4370a.length + i2] = cVar2.c[i2];
        }
        return new c(cArr, iArr, iArr2);
    }

    public static c a(c cVar, int i) {
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = cVar.f4370a[i2];
            iArr2[i2] = cVar.f4371b[i2];
            cArr[i2] = cVar.c[i2];
        }
        return new c(cArr, iArr, iArr2);
    }

    public static c b(c cVar, int i) {
        int length = cVar.c.length - i;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "getTail originLen:" + cVar.c.length);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "getTail tailLen:" + length);
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = cVar.f4370a[i + i2];
            iArr2[i2] = cVar.f4371b[i + i2];
            cArr[i2] = cVar.c[i + i2];
        }
        return new c(cArr, iArr, iArr2);
    }
}
