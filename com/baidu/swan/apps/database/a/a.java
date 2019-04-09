package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes2.dex */
public class a {
    public static final String auB = "content://" + com.baidu.swan.apps.database.favorite.b.auz + "/history_with_app";
    public static final String auC = "content://" + com.baidu.swan.apps.database.favorite.b.auz + "/history";
    public static final String auD = "content://" + com.baidu.swan.apps.database.favorite.b.auz + "/history_with_aps_pms";

    public static Uri AQ() {
        return Uri.parse(auB);
    }

    public static Uri AR() {
        return Uri.parse(auD);
    }

    public static Uri AS() {
        return Uri.parse(auC);
    }
}
