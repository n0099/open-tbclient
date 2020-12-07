package com.baidu.b.c.a;
/* loaded from: classes26.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile byte[] f1259a;

    public static byte[] a() {
        if (f1259a == null) {
            synchronized (g.class) {
                if (f1259a == null) {
                    byte[] bArr = new byte[16];
                    System.arraycopy(com.baidu.b.c.c.b.b(), 0, bArr, 0, 16);
                    c cVar = new c();
                    cVar.a(2, bArr, bArr);
                    f1259a = cVar.a(new byte[]{-71, -100, -115, 26, 39, -124, 14, 14, -31, -46, -56, 1, 25, -127, -99, -107, -54, 51, 46, 14, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50});
                }
            }
        }
        return f1259a;
    }
}
