package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes11.dex */
public class a {
    public static final String cgB = "content://" + com.baidu.swan.apps.database.favorite.b.cgz + "/history_with_app";
    public static final String cgC = "content://" + com.baidu.swan.apps.database.favorite.b.cgz + "/history";
    public static final String cgD = "content://" + com.baidu.swan.apps.database.favorite.b.cgz + "/history_with_aps_pms";

    public static Uri adp() {
        return Uri.parse(cgB);
    }

    public static Uri adq() {
        return Uri.parse(cgD);
    }

    public static Uri adr() {
        return Uri.parse(cgC);
    }
}
