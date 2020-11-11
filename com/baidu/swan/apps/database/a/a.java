package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes10.dex */
public class a {
    public static final String cRv = "content://" + com.baidu.swan.apps.database.favorite.b.cRs + "/history_with_app";
    public static final String cRw = "content://" + com.baidu.swan.apps.database.favorite.b.cRs + "/history";
    public static final String cRx = "content://" + com.baidu.swan.apps.database.favorite.b.cRs + "/history_with_aps_pms";

    public static Uri asV() {
        return Uri.parse(cRv);
    }

    public static Uri asW() {
        return Uri.parse(cRx);
    }

    public static Uri asX() {
        return Uri.parse(cRw);
    }
}
