package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes9.dex */
public class a {
    public static final String cYX = "content://" + com.baidu.swan.apps.database.favorite.b.cYU + "/history_with_app";
    public static final String cYY = "content://" + com.baidu.swan.apps.database.favorite.b.cYU + "/history";
    public static final String cYZ = "content://" + com.baidu.swan.apps.database.favorite.b.cYU + "/history_with_aps_pms";

    public static Uri ats() {
        return Uri.parse(cYX);
    }

    public static Uri att() {
        return Uri.parse(cYZ);
    }

    public static Uri atu() {
        return Uri.parse(cYY);
    }
}
