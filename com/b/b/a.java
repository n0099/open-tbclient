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
        private static Object pNZ;
        private static Method pOa;
        private static Method pOb;
        private static Method pOc;
        private static Method pOd;
        private static Class<?> sClass;

        static {
            pOa = null;
            pOb = null;
            pOc = null;
            pOd = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                pNZ = sClass.newInstance();
                pOa = sClass.getMethod("getUDID", Context.class);
                pOb = sClass.getMethod("getOAID", Context.class);
                pOc = sClass.getMethod("getVAID", Context.class);
                pOd = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || pNZ == null) ? false : true;
        }

        public static String cf(Context context) {
            return b(context, pOb);
        }

        private static String b(Context context, Method method) {
            if (pNZ != null && method != null) {
                try {
                    Object invoke = method.invoke(pNZ, context);
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
