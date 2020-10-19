package com.a.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes11.dex */
public class a {
    public static boolean isSupported() {
        return C0009a.isSupported();
    }

    public static String bt(Context context) {
        return C0009a.bt(context.getApplicationContext());
    }

    /* renamed from: com.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static class C0009a {
        private static Object oCl;
        private static Method oCm;
        private static Method oCn;
        private static Method oCo;
        private static Method oCp;
        private static Class<?> sClass;

        static {
            oCm = null;
            oCn = null;
            oCo = null;
            oCp = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                oCl = sClass.newInstance();
                oCm = sClass.getMethod("getUDID", Context.class);
                oCn = sClass.getMethod("getOAID", Context.class);
                oCo = sClass.getMethod("getVAID", Context.class);
                oCp = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || oCl == null) ? false : true;
        }

        public static String bt(Context context) {
            return b(context, oCn);
        }

        private static String b(Context context, Method method) {
            if (oCl != null && method != null) {
                try {
                    Object invoke = method.invoke(oCl, context);
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
