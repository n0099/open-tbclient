package com.baidu.pass.main.facesdk.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class PreferencesUtil {
    public static final String LEFT_MOUNT = "[";
    public static final String LENGTH_SUFFIX = "#LENGTH";
    public static final String RIGHT_MOUNT = "]";
    public static SharedPreferences mPrefs;

    public static boolean contains(String str) {
        return getPreferences().contains(str);
    }

    public static Map<String, ?> getAll() {
        return getPreferences().getAll();
    }

    public static boolean getBoolean(String str, boolean z) {
        return getPreferences().getBoolean(str, z);
    }

    public static float getFloat(String str, float f2) {
        return getPreferences().getFloat(str, f2);
    }

    public static int getInt(String str, int i2) {
        return getPreferences().getInt(str, i2);
    }

    public static long getLong(String str, long j) {
        return getPreferences().getLong(str, j);
    }

    public static SharedPreferences getPreferences() {
        SharedPreferences sharedPreferences = mPrefs;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        throw new RuntimeException("please call iniPrefs(context) in the Application class onCreate.");
    }

    public static String getString(String str, String str2) {
        return getPreferences().getString(str, str2);
    }

    @TargetApi(11)
    public static Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences preferences = getPreferences();
        if (Build.VERSION.SDK_INT >= 11) {
            return preferences.getStringSet(str, set);
        }
        if (preferences.contains(str + LENGTH_SUFFIX)) {
            set = new HashSet<>();
            int i2 = preferences.getInt(str + LENGTH_SUFFIX, -1);
            if (i2 >= 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    preferences.getString(str + LEFT_MOUNT + i3 + RIGHT_MOUNT, null);
                }
            }
        }
        return set;
    }

    public static void initPrefs(Context context) {
        if (mPrefs == null) {
            String packageName = context.getPackageName();
            if (packageName != null) {
                mPrefs = context.getSharedPreferences(packageName, 4);
                return;
            }
            throw new NullPointerException("Prefs key may not be null");
        }
    }

    public static void putBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putBoolean(str, z);
        if (Build.VERSION.SDK_INT < 9) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static void putFloat(String str, float f2) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putFloat(str, f2);
        if (Build.VERSION.SDK_INT < 9) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static void putInt(String str, int i2) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putInt(str, i2);
        if (Build.VERSION.SDK_INT < 9) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static void putLong(String str, long j) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putLong(str, j);
        if (Build.VERSION.SDK_INT < 9) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static void putString(String str, String str2) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putString(str, str2);
        if (Build.VERSION.SDK_INT < 9) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    @TargetApi(11)
    public static void putStringSet(String str, Set<String> set) {
        int i2;
        SharedPreferences.Editor edit = getPreferences().edit();
        if (Build.VERSION.SDK_INT >= 11) {
            edit.putStringSet(str, set);
        } else {
            SharedPreferences sharedPreferences = mPrefs;
            boolean contains = sharedPreferences.contains(str + LENGTH_SUFFIX);
            int i3 = 0;
            if (contains) {
                SharedPreferences sharedPreferences2 = mPrefs;
                i2 = sharedPreferences2.getInt(str + LENGTH_SUFFIX, -1);
            } else {
                i2 = 0;
            }
            edit.putInt(str + LENGTH_SUFFIX, set.size());
            for (String str2 : set) {
                edit.putString(str + LEFT_MOUNT + i3 + RIGHT_MOUNT, str2);
                i3++;
            }
            while (i3 < i2) {
                edit.remove(str + LEFT_MOUNT + i3 + RIGHT_MOUNT);
                i3++;
            }
        }
        if (Build.VERSION.SDK_INT < 9) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    @Deprecated
    public static void reInit(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            if (packageName != null) {
                mPrefs = context.getSharedPreferences(packageName, 4);
                return;
            }
            throw new NullPointerException("Prefs key may not be null");
        }
    }

    public static void remove(String str) {
        SharedPreferences preferences = getPreferences();
        SharedPreferences.Editor edit = preferences.edit();
        if (preferences.contains(str + LENGTH_SUFFIX)) {
            int i2 = preferences.getInt(str + LENGTH_SUFFIX, -1);
            if (i2 >= 0) {
                edit.remove(str + LENGTH_SUFFIX);
                for (int i3 = 0; i3 < i2; i3++) {
                    edit.remove(str + LEFT_MOUNT + i3 + RIGHT_MOUNT);
                }
            }
        }
        edit.remove(str);
        if (Build.VERSION.SDK_INT < 9) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
