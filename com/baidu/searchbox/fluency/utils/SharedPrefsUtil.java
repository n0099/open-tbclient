package com.baidu.searchbox.fluency.utils;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes2.dex */
public class SharedPrefsUtil {

    /* loaded from: classes2.dex */
    public static class FpsPreferences extends SharedPrefsWrapper {
        public static final String FLUENCY_FPS_PREF_NAME = "com.baidu.searchbox.fluency.fps.pref";

        /* loaded from: classes2.dex */
        public static final class Holder {
            public static final FpsPreferences INSTANCE = new FpsPreferences();
        }

        public FpsPreferences() {
            super(FLUENCY_FPS_PREF_NAME);
        }

        public static FpsPreferences getInstance() {
            return Holder.INSTANCE;
        }
    }

    public static SharedPrefsWrapper getFpsPreference() {
        return FpsPreferences.getInstance();
    }

    public static boolean containsKey(String str) {
        return getFpsPreference().contains(str);
    }

    public static boolean getBoolean(String str, boolean z) {
        return getFpsPreference().getBoolean(str, z);
    }

    public static int getInt(String str, int i) {
        return getFpsPreference().getInt(str, i);
    }

    public static long getLong(String str, long j) {
        return getFpsPreference().getLong(str, j);
    }

    public static String getString(String str, String str2) {
        return getFpsPreference().getString(str, str2);
    }

    public static void putBoolean(String str, boolean z) {
        getFpsPreference().putBoolean(str, z);
    }

    public static void putInt(String str, int i) {
        getFpsPreference().putInt(str, i);
    }

    public static void putLong(String str, long j) {
        getFpsPreference().putLong(str, j);
    }

    public static void putString(String str, String str2) {
        getFpsPreference().putString(str, str2);
    }
}
