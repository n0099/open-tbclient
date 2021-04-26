package com.baidu.mobads.cid.cesium.c.a;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile byte[] f8441a;

    public static byte[] a() {
        if (f8441a == null) {
            synchronized (g.class) {
                if (f8441a == null) {
                    byte[] bArr = new byte[16];
                    System.arraycopy(com.baidu.mobads.cid.cesium.c.c.b.b(), 0, bArr, 0, 16);
                    c cVar = new c();
                    cVar.a(2, bArr, bArr);
                    f8441a = cVar.a(new byte[]{-71, -100, -115, 26, 39, -124, 14, 14, -31, -46, -56, 1, 25, -127, -99, -107, -54, 51, 46, 14, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50});
                }
            }
        }
        return f8441a;
    }
}
