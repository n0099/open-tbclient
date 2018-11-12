package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;
/* loaded from: classes4.dex */
public class c {
    public int[] a;
    public int[] b;
    public char[] c;

    public c(char[] cArr, int[] iArr, int[] iArr2) {
        this.a = iArr;
        this.b = iArr2;
        this.c = cArr;
    }

    public c a() {
        int[] iArr = new int[this.a.length];
        int[] iArr2 = new int[this.a.length];
        char[] cArr = new char[this.a.length];
        return new c((char[]) this.c.clone(), (int[]) this.a.clone(), (int[]) this.b.clone());
    }

    public static c a(c cVar, c cVar2) {
        int[] iArr = new int[cVar.a.length + cVar2.a.length];
        int[] iArr2 = new int[cVar.a.length + cVar2.a.length];
        char[] cArr = new char[cVar.a.length + cVar2.a.length];
        for (int i = 0; i < cVar.a.length; i++) {
            iArr[i] = cVar.a[i];
            iArr2[i] = cVar.b[i];
            cArr[i] = cVar.c[i];
        }
        for (int i2 = 0; i2 < cVar2.a.length; i2++) {
            iArr[cVar.a.length + i2] = cVar2.a[i2];
            iArr2[cVar.a.length + i2] = cVar2.b[i2];
            cArr[cVar.a.length + i2] = cVar2.c[i2];
        }
        return new c(cArr, iArr, iArr2);
    }

    public static c a(c cVar, int i) {
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = cVar.a[i2];
            iArr2[i2] = cVar.b[i2];
            cArr[i2] = cVar.c[i2];
        }
        return new c(cArr, iArr, iArr2);
    }

    public static c b(c cVar, int i) {
        int length = cVar.c.length - i;
        com.baidu.platform.comapi.wnplatform.c.a.c("yang11", "getTail originLen:" + cVar.c.length);
        com.baidu.platform.comapi.wnplatform.c.a.c("yang11", "getTail tailLen:" + length);
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = cVar.a[i + i2];
            iArr2[i2] = cVar.b[i + i2];
            cArr[i2] = cVar.c[i + i2];
        }
        return new c(cArr, iArr, iArr2);
    }
}
