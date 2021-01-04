package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public boolean aXP() {
        boolean z = com.baidu.swan.apps.t.a.aAu().getSwitch("game_bdtls_switcher", false);
        if (DEBUG) {
            com.baidu.swan.apps.console.c.i("BDTLS", "isBdtlsSwitch=" + z);
        }
        return z;
    }

    public boolean wS(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("ma/game/od/get_user_cloud_storage") || str.contains("ma/game/od/set_user_cloud_storage"));
    }
}
