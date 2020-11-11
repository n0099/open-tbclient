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
        private static Object pDb;
        private static Method pDc;
        private static Method pDd;
        private static Method pDe;
        private static Method pDf;
        private static Class<?> sClass;

        static {
            pDc = null;
            pDd = null;
            pDe = null;
            pDf = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                pDb = sClass.newInstance();
                pDc = sClass.getMethod("getUDID", Context.class);
                pDd = sClass.getMethod("getOAID", Context.class);
                pDe = sClass.getMethod("getVAID", Context.class);
                pDf = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || pDb == null) ? false : true;
        }

        public static String bt(Context context) {
            return b(context, pDd);
        }

        private static String b(Context context, Method method) {
            if (pDb != null && method != null) {
                try {
                    Object invoke = method.invoke(pDb, context);
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
