package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes2.dex */
public class a {
    public static final String aux = "content://" + com.baidu.swan.apps.database.favorite.b.auv + "/history_with_app";
    public static final String auy = "content://" + com.baidu.swan.apps.database.favorite.b.auv + "/history";
    public static final String auz = "content://" + com.baidu.swan.apps.database.favorite.b.auv + "/history_with_aps_pms";

    public static Uri AS() {
        return Uri.parse(aux);
    }

    public static Uri AT() {
        return Uri.parse(auz);
    }

    public static Uri AU() {
        return Uri.parse(auy);
    }
}
