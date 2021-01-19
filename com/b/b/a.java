package com.b.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class a {
    public static boolean isSupported() {
        return C0011a.isSupported();
    }

    public static String cf(Context context) {
        return C0011a.cf(context.getApplicationContext());
    }

    /* renamed from: com.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0011a {
        private static Object pOa;
        private static Method pOb;
        private static Method pOc;
        private static Method pOd;
        private static Method pOe;
        private static Class<?> sClass;

        static {
            pOb = null;
            pOc = null;
            pOd = null;
            pOe = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                pOa = sClass.newInstance();
                pOb = sClass.getMethod("getUDID", Context.class);
                pOc = sClass.getMethod("getOAID", Context.class);
                pOd = sClass.getMethod("getVAID", Context.class);
                pOe = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || pOa == null) ? false : true;
        }

        public static String cf(Context context) {
            return b(context, pOc);
        }

        private static String b(Context context, Method method) {
            if (pOa != null && method != null) {
                try {
                    Object invoke = method.invoke(pOa, context);
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
