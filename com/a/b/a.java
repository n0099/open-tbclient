package com.a.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes19.dex */
public class a {
    public static boolean isSupported() {
        return C0009a.isSupported();
    }

    public static String bt(Context context) {
        return C0009a.bt(context.getApplicationContext());
    }

    /* renamed from: com.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    static class C0009a {
        private static Object pEE;
        private static Method pEF;
        private static Method pEG;
        private static Method pEH;
        private static Method pEI;
        private static Class<?> sClass;

        static {
            pEF = null;
            pEG = null;
            pEH = null;
            pEI = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                pEE = sClass.newInstance();
                pEF = sClass.getMethod("getUDID", Context.class);
                pEG = sClass.getMethod("getOAID", Context.class);
                pEH = sClass.getMethod("getVAID", Context.class);
                pEI = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || pEE == null) ? false : true;
        }

        public static String bt(Context context) {
            return b(context, pEG);
        }

        private static String b(Context context, Method method) {
            if (pEE != null && method != null) {
                try {
                    Object invoke = method.invoke(pEE, context);
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
