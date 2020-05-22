package com.b.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {
    public static boolean isSupported() {
        return C0015a.isSupported();
    }

    public static String gb(Context context) {
        return C0015a.gb(context.getApplicationContext());
    }

    /* renamed from: com.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0015a {
        private static Object ndh;
        private static Class<?> ndi;
        private static Method ndj;
        private static Method ndk;
        private static Method ndl;
        private static Method ndm;

        static {
            ndj = null;
            ndk = null;
            ndl = null;
            ndm = null;
            try {
                ndi = Class.forName("com.android.id.impl.IdProviderImpl");
                ndh = ndi.newInstance();
                ndj = ndi.getMethod("getUDID", Context.class);
                ndk = ndi.getMethod("getOAID", Context.class);
                ndl = ndi.getMethod("getVAID", Context.class);
                ndm = ndi.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (ndi == null || ndh == null) ? false : true;
        }

        public static String gb(Context context) {
            return b(context, ndk);
        }

        private static String b(Context context, Method method) {
            if (ndh != null && method != null) {
                try {
                    Object invoke = method.invoke(ndh, context);
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
