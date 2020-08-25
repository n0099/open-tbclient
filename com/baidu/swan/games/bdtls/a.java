package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public boolean aLk() {
        boolean z = com.baidu.swan.apps.t.a.aoM().getSwitch("game_bdtls_switcher", false);
        if (DEBUG) {
            com.baidu.swan.apps.console.c.i("BDTLS", "isBdtlsSwitch=" + z);
        }
        return z;
    }

    public boolean uE(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("ma/game/od/get_user_cloud_storage") || str.contains("ma/game/od/set_user_cloud_storage"));
    }
}
