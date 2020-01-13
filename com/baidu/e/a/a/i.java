package com.baidu.e.a.a;

import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.baidu.minivideo.plugin.capture.Application;
/* loaded from: classes12.dex */
public class i {
    public static void putString(String str, String str2) {
        try {
            commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putString(str, str2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearString(String str) {
        try {
            commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().remove(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getString(String str) {
        return getString(str, null);
    }

    public static String getString(String str, String str2) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(Application.get()).getString(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static void putBoolean(String str, boolean z) {
        try {
            commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putBoolean(str, z));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public static boolean getBoolean(String str, boolean z) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(Application.get()).getBoolean(str, z);
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static void putInt(String str, int i) {
        try {
            commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putInt(str, i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getInt(String str) {
        return getInt(str, 0);
    }

    public static int getInt(String str, int i) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(Application.get()).getInt(str, i);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static void putLong(String str, long j) {
        try {
            commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putLong(str, j));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getLong(String str, long j) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(Application.get()).getLong(str, j);
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static void commitEditor(SharedPreferences.Editor editor) {
        if (editor != null) {
            if (hasGingerbread()) {
                editor.apply();
            } else {
                editor.commit();
            }
        }
    }

    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= 9;
    }
}
