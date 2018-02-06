package com.baidu.ar.util.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class a {
    private static SharedPreferences a = null;

    private static SharedPreferences a(Context context) {
        synchronized (a.class) {
            if (a == null) {
                synchronized (a.class) {
                    a = context.getSharedPreferences("ar_info", 0);
                }
            }
        }
        return a;
    }

    public static boolean a(Context context, String str, boolean z) {
        return a(context).getBoolean(str, z);
    }

    public static boolean b(Context context, String str, boolean z) {
        return a(context).edit().putBoolean(str, z).commit();
    }
}
