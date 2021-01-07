package com.b.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class a {
    public static boolean isSupported() {
        return C0011a.isSupported();
    }

    public static String cg(Context context) {
        return C0011a.cg(context.getApplicationContext());
    }

    /* renamed from: com.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0011a {
        private static Method pSA;
        private static Method pSB;
        private static Method pSC;
        private static Method pSD;
        private static Object pSz;
        private static Class<?> sClass;

        static {
            pSA = null;
            pSB = null;
            pSC = null;
            pSD = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                pSz = sClass.newInstance();
                pSA = sClass.getMethod("getUDID", Context.class);
                pSB = sClass.getMethod("getOAID", Context.class);
                pSC = sClass.getMethod("getVAID", Context.class);
                pSD = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || pSz == null) ? false : true;
        }

        public static String cg(Context context) {
            return b(context, pSB);
        }

        private static String b(Context context, Method method) {
            if (pSz != null && method != null) {
                try {
                    Object invoke = method.invoke(pSz, context);
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
