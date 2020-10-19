package com.baidu.cesium.c.a;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile byte[] f1307a;

    public static byte[] a() {
        if (f1307a == null) {
            synchronized (g.class) {
                if (f1307a == null) {
                    byte[] bArr = new byte[16];
                    System.arraycopy(com.baidu.cesium.c.c.b.b(), 0, bArr, 0, 16);
                    c cVar = new c();
                    cVar.a(2, bArr, bArr);
                    f1307a = cVar.a(new byte[]{-71, -100, -115, 26, 39, -124, 14, 14, -31, -46, -56, 1, 25, -127, -99, -107, -54, 51, 46, 14, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50});
                }
            }
        }
        return f1307a;
    }
}
