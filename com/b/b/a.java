package com.b.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {
    public static boolean isSupported() {
        return C0013a.isSupported();
    }

    public static String fI(Context context) {
        return C0013a.fI(context.getApplicationContext());
    }

    /* renamed from: com.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0013a {
        private static Object mJe;
        private static Class<?> mJf;
        private static Method mJg;
        private static Method mJh;
        private static Method mJi;
        private static Method mJj;

        static {
            mJg = null;
            mJh = null;
            mJi = null;
            mJj = null;
            try {
                mJf = Class.forName("com.android.id.impl.IdProviderImpl");
                mJe = mJf.newInstance();
                mJg = mJf.getMethod("getUDID", Context.class);
                mJh = mJf.getMethod("getOAID", Context.class);
                mJi = mJf.getMethod("getVAID", Context.class);
                mJj = mJf.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (mJf == null || mJe == null) ? false : true;
        }

        public static String fI(Context context) {
            return b(context, mJh);
        }

        private static String b(Context context, Method method) {
            if (mJe != null && method != null) {
                try {
                    Object invoke = method.invoke(mJe, context);
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
