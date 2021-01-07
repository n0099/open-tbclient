package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes9.dex */
public class a {
    public static final String dbz = "content://" + com.baidu.swan.apps.database.favorite.b.dbw + "/history_with_app";
    public static final String dbA = "content://" + com.baidu.swan.apps.database.favorite.b.dbw + "/history";
    public static final String dbB = "content://" + com.baidu.swan.apps.database.favorite.b.dbw + "/history_with_aps_pms";

    public static Uri awO() {
        return Uri.parse(dbz);
    }

    public static Uri awP() {
        return Uri.parse(dbB);
    }

    public static Uri awQ() {
        return Uri.parse(dbA);
    }
}
