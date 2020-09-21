package com.a.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes25.dex */
public class a {
    public static boolean isSupported() {
        return C0008a.isSupported();
    }

    public static String bn(Context context) {
        return C0008a.bn(context.getApplicationContext());
    }

    /* renamed from: com.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    static class C0008a {
        private static Object omS;
        private static Method omT;
        private static Method omU;
        private static Method omV;
        private static Method omW;
        private static Class<?> sClass;

        static {
            omT = null;
            omU = null;
            omV = null;
            omW = null;
            try {
                sClass = Class.forName("com.android.id.impl.IdProviderImpl");
                omS = sClass.newInstance();
                omT = sClass.getMethod("getUDID", Context.class);
                omU = sClass.getMethod("getOAID", Context.class);
                omV = sClass.getMethod("getVAID", Context.class);
                omW = sClass.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (sClass == null || omS == null) ? false : true;
        }

        public static String bn(Context context) {
            return b(context, omU);
        }

        private static String b(Context context, Method method) {
            if (omS != null && method != null) {
                try {
                    Object invoke = method.invoke(omS, context);
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
