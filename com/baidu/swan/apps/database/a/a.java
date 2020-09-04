package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes8.dex */
public class a {
    public static final String coP = "content://" + com.baidu.swan.apps.database.favorite.b.coM + "/history_with_app";
    public static final String coQ = "content://" + com.baidu.swan.apps.database.favorite.b.coM + "/history";
    public static final String coR = "content://" + com.baidu.swan.apps.database.favorite.b.coM + "/history_with_aps_pms";

    public static Uri ale() {
        return Uri.parse(coP);
    }

    public static Uri alf() {
        return Uri.parse(coR);
    }

    public static Uri alg() {
        return Uri.parse(coQ);
    }
}
