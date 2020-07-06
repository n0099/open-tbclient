package com.b.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {
    public static boolean isSupported() {
        return C0015a.isSupported();
    }

    public static String gc(Context context) {
        return C0015a.gc(context.getApplicationContext());
    }

    /* renamed from: com.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0015a {
        private static Object nAl;
        private static Class<?> nAm;
        private static Method nAn;
        private static Method nAo;
        private static Method nAp;
        private static Method nAq;

        static {
            nAn = null;
            nAo = null;
            nAp = null;
            nAq = null;
            try {
                nAm = Class.forName("com.android.id.impl.IdProviderImpl");
                nAl = nAm.newInstance();
                nAn = nAm.getMethod("getUDID", Context.class);
                nAo = nAm.getMethod("getOAID", Context.class);
                nAp = nAm.getMethod("getVAID", Context.class);
                nAq = nAm.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (nAm == null || nAl == null) ? false : true;
        }

        public static String gc(Context context) {
            return b(context, nAo);
        }

        private static String b(Context context, Method method) {
            if (nAl != null && method != null) {
                try {
                    Object invoke = method.invoke(nAl, context);
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
