package com.baidu.swan.games.h.a;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class c {
    public static boolean jt(String str) {
        return TextUtils.equals(PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("KEY_DEBUG_SWAN_GAME_CORE_MODE", "none"), str);
    }
}
