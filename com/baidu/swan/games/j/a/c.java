package com.baidu.swan.games.j.a;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes10.dex */
public class c {
    public static boolean oQ(String str) {
        return TextUtils.equals(PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("KEY_DEBUG_SWAN_GAME_CORE_MODE", "none"), str);
    }
}
