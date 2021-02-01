package com.b.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class a {
    public static boolean isSupported() {
        return C0011a.isSupported();
    }

    public static String ce(Context context) {
        return C0011a.ce(context.getApplicationContext());
    }

    /* renamed from: com.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0011a {
        private static Object pYe;
        private static Method pYf;
        private static Method pYg;
        private static Method pYh;
        private static Method pYi;
        private static Class<?> sClass;

        static {
            pYf = null;
            pYg = null;
            pYh = null;
            pYi = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                pYe = sClass.newInstance();
                pYf = sClass.getMethod("getUDID", Context.class);
                pYg = sClass.getMethod("getOAID", Context.class);
                pYh = sClass.getMethod("getVAID", Context.class);
                pYi = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || pYe == null) ? false : true;
        }

        public static String ce(Context context) {
            return b(context, pYg);
        }

        private static String b(Context context, Method method) {
            if (pYe != null && method != null) {
                try {
                    Object invoke = method.invoke(pYe, context);
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
