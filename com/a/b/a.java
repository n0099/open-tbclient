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
        private static Object ptH;
        private static Method ptI;
        private static Method ptJ;
        private static Method ptK;
        private static Method ptL;
        private static Class<?> sClass;

        static {
            ptI = null;
            ptJ = null;
            ptK = null;
            ptL = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                ptH = sClass.newInstance();
                ptI = sClass.getMethod("getUDID", Context.class);
                ptJ = sClass.getMethod("getOAID", Context.class);
                ptK = sClass.getMethod("getVAID", Context.class);
                ptL = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || ptH == null) ? false : true;
        }

        public static String bt(Context context) {
            return b(context, ptJ);
        }

        private static String b(Context context, Method method) {
            if (ptH != null && method != null) {
                try {
                    Object invoke = method.invoke(ptH, context);
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
