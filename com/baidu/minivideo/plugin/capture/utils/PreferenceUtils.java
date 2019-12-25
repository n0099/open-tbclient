package com.baidu.minivideo.plugin.capture.utils;

import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.baidu.minivideo.plugin.capture.Application;
import java.util.Set;
/* loaded from: classes11.dex */
public class PreferenceUtils {
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

    public static boolean contains(String str) {
        return PreferenceManager.getDefaultSharedPreferences(Application.get()).contains(str);
    }

    public static void putStringSet(String str, Set<String> set) {
        try {
            commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putStringSet(str, set));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Set<String> getStringSet(String str, Set<String> set) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(Application.get()).getStringSet(str, set);
        } catch (Exception e) {
            e.printStackTrace();
            return set;
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

    public static void putFloat(String str, float f) {
        try {
            commitEditor(PreferenceManager.getDefaultSharedPreferences(Application.get()).edit().putFloat(str, f));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public static float getFloat(String str, float f) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(Application.get()).getFloat(str, f);
        } catch (Exception e) {
            e.printStackTrace();
            return f;
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

    public static long getLong(String str) {
        return getLong(str, 0L);
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
