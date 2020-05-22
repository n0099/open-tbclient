package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes11.dex */
public class a {
    public static final String cbM = "content://" + com.baidu.swan.apps.database.favorite.b.cbK + "/history_with_app";
    public static final String cbN = "content://" + com.baidu.swan.apps.database.favorite.b.cbK + "/history";
    public static final String cbO = "content://" + com.baidu.swan.apps.database.favorite.b.cbK + "/history_with_aps_pms";

    public static Uri acj() {
        return Uri.parse(cbM);
    }

    public static Uri ack() {
        return Uri.parse(cbO);
    }

    public static Uri acl() {
        return Uri.parse(cbN);
    }
}
