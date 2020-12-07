package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes25.dex */
public class a {
    public static final String cWE = "content://" + com.baidu.swan.apps.database.favorite.b.cWB + "/history_with_app";
    public static final String cWF = "content://" + com.baidu.swan.apps.database.favorite.b.cWB + "/history";
    public static final String cWG = "content://" + com.baidu.swan.apps.database.favorite.b.cWB + "/history_with_aps_pms";

    public static Uri avv() {
        return Uri.parse(cWE);
    }

    public static Uri avw() {
        return Uri.parse(cWG);
    }

    public static Uri avx() {
        return Uri.parse(cWF);
    }
}
