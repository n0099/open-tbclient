package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes2.dex */
public class a {
    public static final String avT = "content://" + com.baidu.swan.apps.database.favorite.b.avR + "/history_with_app";
    public static final String avU = "content://" + com.baidu.swan.apps.database.favorite.b.avR + "/history";
    public static final String avV = "content://" + com.baidu.swan.apps.database.favorite.b.avR + "/history_with_aps_pms";

    public static Uri CK() {
        return Uri.parse(avT);
    }

    public static Uri CL() {
        return Uri.parse(avV);
    }

    public static Uri CM() {
        return Uri.parse(avU);
    }
}
