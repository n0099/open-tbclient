package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public boolean atX() {
        boolean z = com.baidu.swan.apps.w.a.abR().getSwitch("game_bdtls_switcher", false);
        if (DEBUG) {
            com.baidu.swan.apps.console.c.v("BDTLS", "isBdtlsSwitch=" + z);
        }
        return z;
    }

    public boolean pG(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("ma/game/od/get_user_cloud_storage") || str.contains("ma/game/od/set_user_cloud_storage"));
    }
}
