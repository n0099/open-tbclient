package com.a.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class a {
    public static boolean isSupported() {
        return C0008a.isSupported();
    }

    public static String bo(Context context) {
        return C0008a.bo(context.getApplicationContext());
    }

    /* renamed from: com.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    static class C0008a {
        private static Object ocP;
        private static Method ocQ;
        private static Method ocR;
        private static Method ocS;
        private static Method ocT;
        private static Class<?> sClass;

        static {
            ocQ = null;
            ocR = null;
            ocS = null;
            ocT = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                ocP = sClass.newInstance();
                ocQ = sClass.getMethod("getUDID", Context.class);
                ocR = sClass.getMethod("getOAID", Context.class);
                ocS = sClass.getMethod("getVAID", Context.class);
                ocT = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || ocP == null) ? false : true;
        }

        public static String bo(Context context) {
            return b(context, ocR);
        }

        private static String b(Context context, Method method) {
            if (ocP != null && method != null) {
                try {
                    Object invoke = method.invoke(ocP, context);
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
