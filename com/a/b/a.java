package com.a.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes18.dex */
public class a {
    public static boolean isSupported() {
        return C0009a.isSupported();
    }

    public static String bZ(Context context) {
        return C0009a.bZ(context.getApplicationContext());
    }

    /* renamed from: com.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    static class C0009a {
        private static Object pyk;
        private static Method pyl;
        private static Method pym;
        private static Method pyn;
        private static Method pyo;
        private static Class<?> sClass;

        static {
            pyl = null;
            pym = null;
            pyn = null;
            pyo = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                pyk = sClass.newInstance();
                pyl = sClass.getMethod("getUDID", Context.class);
                pym = sClass.getMethod("getOAID", Context.class);
                pyn = sClass.getMethod("getVAID", Context.class);
                pyo = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || pyk == null) ? false : true;
        }

        public static String bZ(Context context) {
            return b(context, pym);
        }

        private static String b(Context context, Method method) {
            if (pyk != null && method != null) {
                try {
                    Object invoke = method.invoke(pyk, context);
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
