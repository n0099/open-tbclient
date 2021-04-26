package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int[] f10099a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f10100b;

    /* renamed from: c  reason: collision with root package name */
    public char[] f10101c;

    public c(char[] cArr, int[] iArr, int[] iArr2) {
        this.f10099a = iArr;
        this.f10100b = iArr2;
        this.f10101c = cArr;
    }

    public static c b(c cVar, int i2) {
        int length = cVar.f10101c.length - i2;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "getTail originLen:" + cVar.f10101c.length);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "getTail tailLen:" + length);
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        char[] cArr = new char[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + i3;
            iArr[i3] = cVar.f10099a[i4];
            iArr2[i3] = cVar.f10100b[i4];
            cArr[i3] = cVar.f10101c[i4];
        }
        return new c(cArr, iArr, iArr2);
    }

    public c a() {
        int[] iArr = this.f10099a;
        int[] iArr2 = new int[iArr.length];
        int[] iArr3 = new int[iArr.length];
        char[] cArr = new char[iArr.length];
        return new c((char[]) this.f10101c.clone(), (int[]) iArr.clone(), (int[]) this.f10100b.clone());
    }

    public static c a(c cVar, c cVar2) {
        int[] iArr = cVar.f10099a;
        int length = iArr.length;
        int[] iArr2 = cVar2.f10099a;
        int[] iArr3 = new int[length + iArr2.length];
        int[] iArr4 = new int[iArr.length + iArr2.length];
        char[] cArr = new char[iArr.length + iArr2.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr5 = cVar.f10099a;
            if (i3 >= iArr5.length) {
                break;
            }
            iArr3[i3] = iArr5[i3];
            iArr4[i3] = cVar.f10100b[i3];
            cArr[i3] = cVar.f10101c[i3];
            i3++;
        }
        while (true) {
            int[] iArr6 = cVar2.f10099a;
            if (i2 < iArr6.length) {
                int[] iArr7 = cVar.f10099a;
                iArr3[iArr7.length + i2] = iArr6[i2];
                iArr4[iArr7.length + i2] = cVar2.f10100b[i2];
                cArr[iArr7.length + i2] = cVar2.f10101c[i2];
                i2++;
            } else {
                return new c(cArr, iArr3, iArr4);
            }
        }
    }

    public static c a(c cVar, int i2) {
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = cVar.f10099a[i3];
            iArr2[i3] = cVar.f10100b[i3];
            cArr[i3] = cVar.f10101c[i3];
        }
        return new c(cArr, iArr, iArr2);
    }
}
