package com.baidu.mobads.cid.cesium.c.a;

import androidx.exifinterface.media.ExifInterface;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile byte[] f8148a;

    public static byte[] a() {
        if (f8148a == null) {
            synchronized (g.class) {
                if (f8148a == null) {
                    byte[] bArr = new byte[16];
                    System.arraycopy(com.baidu.mobads.cid.cesium.c.c.b.b(), 0, bArr, 0, 16);
                    c cVar = new c();
                    cVar.a(2, bArr, bArr);
                    f8148a = cVar.a(new byte[]{-71, -100, -115, 26, 39, -124, 14, 14, ExifInterface.MARKER_APP1, -46, -56, 1, 25, -127, -99, -107, ExifInterface.MARKER_SOF10, 51, 46, 14, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50});
                }
            }
        }
        return f8148a;
    }
}
