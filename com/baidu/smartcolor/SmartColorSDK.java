package com.baidu.smartcolor;

import com.baidu.smartcolor.utils.Tri;
import d.a.h0.a;
/* loaded from: classes2.dex */
public class SmartColorSDK {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SmartColorSDK f10117a;

    static {
        System.loadLibrary("native-bridge");
        f10117a = null;
    }

    public static int a(Tri tri) {
        if (tri == Tri.TRUE) {
            return 1;
        }
        return tri == Tri.FALSE ? 0 : 2;
    }

    public static SmartColorSDK b() {
        if (f10117a == null) {
            synchronized (SmartColorSDK.class) {
                if (f10117a == null) {
                    f10117a = new SmartColorSDK();
                }
            }
        }
        return f10117a;
    }

    private native String getNativeSmartColor(byte[] bArr, int i2, int i3, int i4, int i5, String str, String str2, int i6, int i7, int i8, int i9, long j, long j2, long j3, long j4);

    public String c(a aVar, byte[] bArr, int i2) {
        return getNativeSmartColor(bArr, i2, aVar.i(), aVar.j(), aVar.n(), aVar.s(), aVar.k(), a(aVar.l()), a(aVar.m()), a(aVar.h()), a(aVar.g()), aVar.q(), aVar.o(), aVar.r(), aVar.p());
    }
}
