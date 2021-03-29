package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int[] f10181a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f10182b;

    /* renamed from: c  reason: collision with root package name */
    public char[] f10183c;

    public c(char[] cArr, int[] iArr, int[] iArr2) {
        this.f10181a = iArr;
        this.f10182b = iArr2;
        this.f10183c = cArr;
    }

    public static c b(c cVar, int i) {
        int length = cVar.f10183c.length - i;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "getTail originLen:" + cVar.f10183c.length);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "getTail tailLen:" + length);
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + i2;
            iArr[i2] = cVar.f10181a[i3];
            iArr2[i2] = cVar.f10182b[i3];
            cArr[i2] = cVar.f10183c[i3];
        }
        return new c(cArr, iArr, iArr2);
    }

    public c a() {
        int[] iArr = this.f10181a;
        int[] iArr2 = new int[iArr.length];
        int[] iArr3 = new int[iArr.length];
        char[] cArr = new char[iArr.length];
        return new c((char[]) this.f10183c.clone(), (int[]) iArr.clone(), (int[]) this.f10182b.clone());
    }

    public static c a(c cVar, c cVar2) {
        int[] iArr = cVar.f10181a;
        int length = iArr.length;
        int[] iArr2 = cVar2.f10181a;
        int[] iArr3 = new int[length + iArr2.length];
        int[] iArr4 = new int[iArr.length + iArr2.length];
        char[] cArr = new char[iArr.length + iArr2.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr5 = cVar.f10181a;
            if (i2 >= iArr5.length) {
                break;
            }
            iArr3[i2] = iArr5[i2];
            iArr4[i2] = cVar.f10182b[i2];
            cArr[i2] = cVar.f10183c[i2];
            i2++;
        }
        while (true) {
            int[] iArr6 = cVar2.f10181a;
            if (i < iArr6.length) {
                int[] iArr7 = cVar.f10181a;
                iArr3[iArr7.length + i] = iArr6[i];
                iArr4[iArr7.length + i] = cVar2.f10182b[i];
                cArr[iArr7.length + i] = cVar2.f10183c[i];
                i++;
            } else {
                return new c(cArr, iArr3, iArr4);
            }
        }
    }

    public static c a(c cVar, int i) {
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = cVar.f10181a[i2];
            iArr2[i2] = cVar.f10182b[i2];
            cArr[i2] = cVar.f10183c[i2];
        }
        return new c(cArr, iArr, iArr2);
    }
}
