package com.b.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class a {
    public static boolean isSupported() {
        return C0011a.isSupported();
    }

    public static String cg(Context context) {
        return C0011a.cg(context.getApplicationContext());
    }

    /* renamed from: com.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0011a {
        private static Object pQR;
        private static Method pQS;
        private static Method pQT;
        private static Method pQU;
        private static Method pQV;
        private static Class<?> sClass;

        static {
            pQS = null;
            pQT = null;
            pQU = null;
            pQV = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                pQR = sClass.newInstance();
                pQS = sClass.getMethod("getUDID", Context.class);
                pQT = sClass.getMethod("getOAID", Context.class);
                pQU = sClass.getMethod("getVAID", Context.class);
                pQV = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || pQR == null) ? false : true;
        }

        public static String cg(Context context) {
            return b(context, pQT);
        }

        private static String b(Context context, Method method) {
            if (pQR != null && method != null) {
                try {
                    Object invoke = method.invoke(pQR, context);
                    if (invoke != null) {
                        return (String) invoke;
                    }
                } catch (Exception e) {
                    Log.e("XiaomiId", "invoke method error", e);
                }
            }
            return null;
        }
    }
}
