package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes8.dex */
public class a {
    public static final String daz = "content://" + com.baidu.swan.apps.database.favorite.b.dav + "/history_with_app";
    public static final String daA = "content://" + com.baidu.swan.apps.database.favorite.b.dav + "/history";
    public static final String daB = "content://" + com.baidu.swan.apps.database.favorite.b.dav + "/history_with_aps_pms";

    public static Uri atv() {
        return Uri.parse(daz);
    }

    public static Uri atw() {
        return Uri.parse(daB);
    }

    public static Uri atx() {
        return Uri.parse(daA);
    }
}
