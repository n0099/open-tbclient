package com.b.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class a {
    public static boolean isSupported() {
        return C0017a.isSupported();
    }

    public static String cd(Context context) {
        return C0017a.cd(context.getApplicationContext());
    }

    /* renamed from: com.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0017a {
        private static Object pZs;
        private static Method pZt;
        private static Method pZu;
        private static Method pZv;
        private static Method pZw;
        private static Class<?> sClass;

        static {
            pZt = null;
            pZu = null;
            pZv = null;
            pZw = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                pZs = sClass.newInstance();
                pZt = sClass.getMethod("getUDID", Context.class);
                pZu = sClass.getMethod("getOAID", Context.class);
                pZv = sClass.getMethod("getVAID", Context.class);
                pZw = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || pZs == null) ? false : true;
        }

        public static String cd(Context context) {
            return b(context, pZu);
        }

        private static String b(Context context, Method method) {
            if (pZs != null && method != null) {
                try {
                    Object invoke = method.invoke(pZs, context);
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
