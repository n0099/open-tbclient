package com.baidu.searchbox.ugc.utils;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes13.dex */
public class UgcSharePrefsUtils {
    public static void commit(String str) {
        SharedPreferences.Editor edit = AppRuntime.getAppContext().getSharedPreferences("ugc", 0).edit();
        edit.putBoolean(str, true);
        edit.commit();
    }

    public static boolean getValue(String str) {
        return AppRuntime.getAppContext().getSharedPreferences("ugc", 0).getBoolean(str, false);
    }
}
