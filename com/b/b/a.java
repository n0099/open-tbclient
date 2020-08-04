package com.b.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes18.dex */
public class a {
    public static boolean isSupported() {
        return C0015a.isSupported();
    }

    public static String gk(Context context) {
        return C0015a.gk(context.getApplicationContext());
    }

    /* renamed from: com.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    static class C0015a {
        private static Object nIW;
        private static Method nIX;
        private static Method nIY;
        private static Method nIZ;
        private static Method nJa;
        private static Class<?> sClass;

        static {
            nIX = null;
            nIY = null;
            nIZ = null;
            nJa = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                nIW = sClass.newInstance();
                nIX = sClass.getMethod("getUDID", Context.class);
                nIY = sClass.getMethod("getOAID", Context.class);
                nIZ = sClass.getMethod("getVAID", Context.class);
                nJa = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || nIW == null) ? false : true;
        }

        public static String gk(Context context) {
            return b(context, nIY);
        }

        private static String b(Context context, Method method) {
            if (nIW != null && method != null) {
                try {
                    Object invoke = method.invoke(nIW, context);
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
