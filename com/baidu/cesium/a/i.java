package com.baidu.cesium.a;

import d.a.j.d.a.c;
import d.a.j.d.a.g;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class i {

    /* loaded from: classes2.dex */
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
        byte[] a2 = g.a();
        return new String(c.d(a2, a2, bArr));
    }

    public static Method b(Class<?> cls, String str, Class<?>[] clsArr) {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
