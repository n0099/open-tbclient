package com.baidu.ar.util.sputil;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class ARSharedPreference {
    private static SharedPreferences a = null;

    private static SharedPreferences a(Context context) {
        synchronized (ARSharedPreference.class) {
            if (a == null) {
                synchronized (ARSharedPreference.class) {
                    a = context.getSharedPreferences("ar_info", 0);
                }
            }
        }
        return a;
    }

    public static boolean contains(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return a(context).getBoolean(str, z);
    }

    public static int getInt(Context context, String str, int i) {
        return a(context).getInt(str, i);
    }

    public static boolean putBoolean(Context context, String str, boolean z) {
        return a(context).edit().putBoolean(str, z).commit();
    }

    public static boolean putInt(Context context, String str, int i) {
        return a(context).edit().putInt(str, i).commit();
    }

    public static void removeKey(Context context, String str) {
        a(context).edit().remove(str).commit();
    }

    public static void setPref(Context context, String str, Object obj) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        String valueOf = String.valueOf(obj);
        if (!TextUtils.isEmpty(valueOf)) {
            if (obj instanceof Boolean) {
                edit.putBoolean(str, Boolean.valueOf(valueOf).booleanValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str, Float.valueOf(valueOf).floatValue());
            } else if (obj instanceof Integer) {
                edit.putInt(str, Integer.parseInt(valueOf));
            } else if (obj instanceof Long) {
                edit.putLong(str, Long.parseLong(valueOf));
            } else if (obj instanceof String) {
                edit.putString(str, valueOf);
            }
        }
        edit.commit();
    }
}
