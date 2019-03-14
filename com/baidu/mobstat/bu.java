package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public abstract class bu {
    public abstract SharedPreferences getSharedPreferences(Context context);

    public boolean getBoolean(Context context, String str, boolean z) {
        return getSharedPreferences(context).getBoolean(str, z);
    }

    public void putBoolean(Context context, String str, boolean z) {
        getSharedPreferences(context).edit().putBoolean(str, z).commit();
    }

    public int getInt(Context context, String str, int i) {
        return getSharedPreferences(context).getInt(str, i);
    }

    public void putInt(Context context, String str, int i) {
        getSharedPreferences(context).edit().putInt(str, i).commit();
    }

    public Float getFloat(Context context, String str, int i) {
        return Float.valueOf(getSharedPreferences(context).getFloat(str, i));
    }

    public void putFloat(Context context, String str, Float f) {
        getSharedPreferences(context).edit().putFloat(str, f.floatValue()).commit();
    }

    public long getLong(Context context, String str, long j) {
        return getSharedPreferences(context).getLong(str, j);
    }

    public void putLong(Context context, String str, long j) {
        getSharedPreferences(context).edit().putLong(str, j).commit();
    }

    public String getString(Context context, String str, String str2) {
        return getSharedPreferences(context).getString(str, str2);
    }

    public void putString(Context context, String str, String str2) {
        getSharedPreferences(context).edit().putString(str, str2).commit();
    }

    public void removeString(Context context, String str) {
        getSharedPreferences(context).edit().remove(str).commit();
    }
}
