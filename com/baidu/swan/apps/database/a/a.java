package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes7.dex */
public class a {
    public static final String cio = "content://" + com.baidu.swan.apps.database.favorite.b.cil + "/history_with_app";
    public static final String cip = "content://" + com.baidu.swan.apps.database.favorite.b.cil + "/history";
    public static final String ciq = "content://" + com.baidu.swan.apps.database.favorite.b.cil + "/history_with_aps_pms";

    public static Uri aev() {
        return Uri.parse(cio);
    }

    public static Uri aew() {
        return Uri.parse(ciq);
    }

    public static Uri aex() {
        return Uri.parse(cip);
    }
}
