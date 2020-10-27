package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes10.dex */
public class a {
    public static final String cLC = "content://" + com.baidu.swan.apps.database.favorite.b.cLz + "/history_with_app";
    public static final String cLD = "content://" + com.baidu.swan.apps.database.favorite.b.cLz + "/history";
    public static final String cLE = "content://" + com.baidu.swan.apps.database.favorite.b.cLz + "/history_with_aps_pms";

    public static Uri aqu() {
        return Uri.parse(cLC);
    }

    public static Uri aqv() {
        return Uri.parse(cLE);
    }

    public static Uri aqw() {
        return Uri.parse(cLD);
    }
}
