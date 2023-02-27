package com.baidu.searchbox.crius.util;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.crius.CriusRuntime;
/* loaded from: classes2.dex */
public class PreferenceUtil {

    /* loaded from: classes2.dex */
    public static class CriusPreference {
        public static final String PREFERENCE_NAME = "com.baidu.searchbox.feed.crius";

        /* loaded from: classes2.dex */
        public static final class Holder {
            public static final SharedPreferences INSTANCE = CriusRuntime.context().getSharedPreferences(CriusPreference.PREFERENCE_NAME, 0);
        }

        public static SharedPreferences getPreference() {
            return Holder.INSTANCE;
        }
    }

    public static boolean getBoolean(@NonNull String str, boolean z) {
        return CriusPreference.getPreference().getBoolean(str, z);
    }

    @Nullable
    public static String getString(@NonNull String str, @Nullable String str2) {
        return CriusPreference.getPreference().getString(str, str2);
    }

    public static void putBoolean(@NonNull String str, boolean z) {
        CriusPreference.getPreference().edit().putBoolean(str, z).apply();
    }

    public static void putString(@NonNull String str, @Nullable String str2) {
        CriusPreference.getPreference().edit().putString(str, str2).apply();
    }
}
