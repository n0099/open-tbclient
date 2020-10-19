package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes10.dex */
public class a {
    public static final String cDg = "content://" + com.baidu.swan.apps.database.favorite.b.cDd + "/history_with_app";
    public static final String cDh = "content://" + com.baidu.swan.apps.database.favorite.b.cDd + "/history";
    public static final String cDi = "content://" + com.baidu.swan.apps.database.favorite.b.cDd + "/history_with_aps_pms";

    public static Uri aoz() {
        return Uri.parse(cDg);
    }

    public static Uri aoA() {
        return Uri.parse(cDi);
    }

    public static Uri aoB() {
        return Uri.parse(cDh);
    }
}
