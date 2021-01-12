package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes8.dex */
public class a {
    public static final String cWL = "content://" + com.baidu.swan.apps.database.favorite.b.cWI + "/history_with_app";
    public static final String cWM = "content://" + com.baidu.swan.apps.database.favorite.b.cWI + "/history";
    public static final String cWN = "content://" + com.baidu.swan.apps.database.favorite.b.cWI + "/history_with_aps_pms";

    public static Uri asU() {
        return Uri.parse(cWL);
    }

    public static Uri asV() {
        return Uri.parse(cWN);
    }

    public static Uri asW() {
        return Uri.parse(cWM);
    }
}
