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
        private static Object pym;
        private static Method pyn;
        private static Method pyo;
        private static Method pyp;
        private static Method pyq;
        private static Class<?> sClass;

        static {
            pyn = null;
            pyo = null;
            pyp = null;
            pyq = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                pym = sClass.newInstance();
                pyn = sClass.getMethod("getUDID", Context.class);
                pyo = sClass.getMethod("getOAID", Context.class);
                pyp = sClass.getMethod("getVAID", Context.class);
                pyq = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || pym == null) ? false : true;
        }

        public static String bZ(Context context) {
            return b(context, pyo);
        }

        private static String b(Context context, Method method) {
            if (pym != null && method != null) {
                try {
                    Object invoke = method.invoke(pym, context);
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
