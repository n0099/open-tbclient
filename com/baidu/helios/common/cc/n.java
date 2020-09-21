package com.baidu.helios.common.cc;

import java.lang.reflect.Method;
/* loaded from: classes6.dex */
class n {

    /* loaded from: classes6.dex */
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
        return new String(new com.baidu.helios.common.a.b().B(bArr));
    }

    public static Method a(Class<?> cls, String str, Class<?>[] clsArr) {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
