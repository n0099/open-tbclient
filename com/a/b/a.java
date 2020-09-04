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
        private static Object odh;
        private static Method odi;
        private static Method odj;
        private static Method odk;
        private static Method odl;
        private static Class<?> sClass;

        static {
            odi = null;
            odj = null;
            odk = null;
            odl = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                odh = sClass.newInstance();
                odi = sClass.getMethod("getUDID", Context.class);
                odj = sClass.getMethod("getOAID", Context.class);
                odk = sClass.getMethod("getVAID", Context.class);
                odl = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || odh == null) ? false : true;
        }

        public static String bo(Context context) {
            return b(context, odj);
        }

        private static String b(Context context, Method method) {
            if (odh != null && method != null) {
                try {
                    Object invoke = method.invoke(odh, context);
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
