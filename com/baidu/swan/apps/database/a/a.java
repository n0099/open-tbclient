package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes11.dex */
public class a {
    public static final String bRW = "content://" + com.baidu.swan.apps.database.favorite.b.bRU + "/history_with_app";
    public static final String bRX = "content://" + com.baidu.swan.apps.database.favorite.b.bRU + "/history";
    public static final String bRY = "content://" + com.baidu.swan.apps.database.favorite.b.bRU + "/history_with_aps_pms";

    public static Uri Zi() {
        return Uri.parse(bRW);
    }

    public static Uri Zj() {
        return Uri.parse(bRY);
    }

    public static Uri Zk() {
        return Uri.parse(bRX);
    }
}
