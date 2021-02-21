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
        private static Object pYE;
        private static Method pYF;
        private static Method pYG;
        private static Method pYH;
        private static Method pYI;
        private static Class<?> sClass;

        static {
            pYF = null;
            pYG = null;
            pYH = null;
            pYI = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                pYE = sClass.newInstance();
                pYF = sClass.getMethod("getUDID", Context.class);
                pYG = sClass.getMethod("getOAID", Context.class);
                pYH = sClass.getMethod("getVAID", Context.class);
                pYI = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || pYE == null) ? false : true;
        }

        public static String ce(Context context) {
            return b(context, pYG);
        }

        private static String b(Context context, Method method) {
            if (pYE != null && method != null) {
                try {
                    Object invoke = method.invoke(pYE, context);
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
