package com.b.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {
    public static boolean isSupported() {
        return C0013a.isSupported();
    }

    public static String fU(Context context) {
        return C0013a.fU(context.getApplicationContext());
    }

    /* renamed from: com.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0013a {
        private static Object mJb;
        private static Class<?> mJc;
        private static Method mJd;
        private static Method mJe;
        private static Method mJf;
        private static Method mJg;

        static {
            mJd = null;
            mJe = null;
            mJf = null;
            mJg = null;
            try {
                mJc = Class.forName("com.android.id.impl.IdProviderImpl");
                mJb = mJc.newInstance();
                mJd = mJc.getMethod("getUDID", Context.class);
                mJe = mJc.getMethod("getOAID", Context.class);
                mJf = mJc.getMethod("getVAID", Context.class);
                mJg = mJc.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (mJc == null || mJb == null) ? false : true;
        }

        public static String fU(Context context) {
            return a(context, mJe);
        }

        private static String a(Context context, Method method) {
            if (mJb != null && method != null) {
                try {
                    Object invoke = method.invoke(mJb, context);
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
