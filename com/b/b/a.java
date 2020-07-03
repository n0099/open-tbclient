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
        private static Object nAi;
        private static Class<?> nAj;
        private static Method nAk;
        private static Method nAl;
        private static Method nAm;
        private static Method nAn;

        static {
            nAk = null;
            nAl = null;
            nAm = null;
            nAn = null;
            try {
                nAj = Class.forName("com.android.id.impl.IdProviderImpl");
                nAi = nAj.newInstance();
                nAk = nAj.getMethod("getUDID", Context.class);
                nAl = nAj.getMethod("getOAID", Context.class);
                nAm = nAj.getMethod("getVAID", Context.class);
                nAn = nAj.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (nAj == null || nAi == null) ? false : true;
        }

        public static String gc(Context context) {
            return b(context, nAl);
        }

        private static String b(Context context, Method method) {
            if (nAi != null && method != null) {
                try {
                    Object invoke = method.invoke(nAi, context);
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
