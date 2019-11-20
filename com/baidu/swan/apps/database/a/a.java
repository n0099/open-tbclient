package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes2.dex */
public class a {
    public static final String aOQ = "content://" + com.baidu.swan.apps.database.favorite.b.aOO + "/history_with_app";
    public static final String aOR = "content://" + com.baidu.swan.apps.database.favorite.b.aOO + "/history";
    public static final String aOS = "content://" + com.baidu.swan.apps.database.favorite.b.aOO + "/history_with_aps_pms";

    public static Uri HF() {
        return Uri.parse(aOQ);
    }

    public static Uri HG() {
        return Uri.parse(aOS);
    }

    public static Uri HH() {
        return Uri.parse(aOR);
    }
}
