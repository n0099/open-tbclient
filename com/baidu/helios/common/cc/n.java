package com.baidu.helios.common.cc;

import d.b.q.g.b.b;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class n {

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
        return new String(new b().a(bArr), "UTF-8");
    }

    public static Method b(Class<?> cls, String str, Class<?>[] clsArr) {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
