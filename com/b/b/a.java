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
        private static Object ner;
        private static Class<?> nes;
        private static Method neu;
        private static Method nev;

        /* renamed from: new  reason: not valid java name */
        private static Method f0new;
        private static Method nex;

        static {
            neu = null;
            nev = null;
            f0new = null;
            nex = null;
            try {
                nes = Class.forName("com.android.id.impl.IdProviderImpl");
                ner = nes.newInstance();
                neu = nes.getMethod("getUDID", Context.class);
                nev = nes.getMethod("getOAID", Context.class);
                f0new = nes.getMethod("getVAID", Context.class);
                nex = nes.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (nes == null || ner == null) ? false : true;
        }

        public static String gb(Context context) {
            return b(context, nev);
        }

        private static String b(Context context, Method method) {
            if (ner != null && method != null) {
                try {
                    Object invoke = method.invoke(ner, context);
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
