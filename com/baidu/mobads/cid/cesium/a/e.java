package com.baidu.mobads.cid.cesium.a;

import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class e {

    /* loaded from: classes2.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(Throwable th) {
            super(th);
        }
    }

    public static String a(byte[] bArr) {
        byte[] a2 = com.baidu.mobads.cid.cesium.c.a.g.a();
        return new String(com.baidu.mobads.cid.cesium.c.a.c.a(a2, a2, bArr));
    }

    public static Method a(Class<?> cls, String str, Class<?>[] clsArr) {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
