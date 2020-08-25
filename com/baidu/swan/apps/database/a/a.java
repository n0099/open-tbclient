package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes8.dex */
public class a {
    public static final String coL = "content://" + com.baidu.swan.apps.database.favorite.b.coI + "/history_with_app";
    public static final String coM = "content://" + com.baidu.swan.apps.database.favorite.b.coI + "/history";
    public static final String coN = "content://" + com.baidu.swan.apps.database.favorite.b.coI + "/history_with_aps_pms";

    public static Uri ale() {
        return Uri.parse(coL);
    }

    public static Uri alf() {
        return Uri.parse(coN);
    }

    public static Uri alg() {
        return Uri.parse(coM);
    }
}
