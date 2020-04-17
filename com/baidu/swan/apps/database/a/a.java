package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes11.dex */
public class a {
    public static final String bRQ = "content://" + com.baidu.swan.apps.database.favorite.b.bRO + "/history_with_app";
    public static final String bRR = "content://" + com.baidu.swan.apps.database.favorite.b.bRO + "/history";
    public static final String bRS = "content://" + com.baidu.swan.apps.database.favorite.b.bRO + "/history_with_aps_pms";

    public static Uri Zj() {
        return Uri.parse(bRQ);
    }

    public static Uri Zk() {
        return Uri.parse(bRS);
    }

    public static Uri Zl() {
        return Uri.parse(bRR);
    }
}
