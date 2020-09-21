package com.baidu.cesium.a;

import java.lang.reflect.Method;
/* loaded from: classes18.dex */
public class i {

    /* loaded from: classes18.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }

        public a(Throwable th) {
            super(th);
        }
    }

    public static String a(byte[] bArr) {
        byte[] a2 = com.baidu.cesium.c.a.g.a();
        return new String(com.baidu.cesium.c.a.c.c(a2, a2, bArr));
    }

    public static Method a(Class<?> cls, String str, Class<?>[] clsArr) {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
