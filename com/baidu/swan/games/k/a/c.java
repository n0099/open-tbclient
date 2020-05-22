package com.baidu.swan.games.k.a;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes11.dex */
public class c {
    public static boolean rU(String str) {
        return TextUtils.equals(PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("KEY_DEBUG_SWAN_GAME_CORE_MODE", "none"), str);
    }
}
