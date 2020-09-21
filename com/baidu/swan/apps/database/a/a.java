package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes3.dex */
public class a {
    public static final String cqS = "content://" + com.baidu.swan.apps.database.favorite.b.cqP + "/history_with_app";
    public static final String cqT = "content://" + com.baidu.swan.apps.database.favorite.b.cqP + "/history";
    public static final String cqU = "content://" + com.baidu.swan.apps.database.favorite.b.cqP + "/history_with_aps_pms";

    public static Uri alO() {
        return Uri.parse(cqS);
    }

    public static Uri alP() {
        return Uri.parse(cqU);
    }

    public static Uri alQ() {
        return Uri.parse(cqT);
    }
}
