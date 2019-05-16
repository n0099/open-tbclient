package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes2.dex */
public class a {
    public static final String auR = "content://" + com.baidu.swan.apps.database.favorite.b.auP + "/history_with_app";
    public static final String auS = "content://" + com.baidu.swan.apps.database.favorite.b.auP + "/history";
    public static final String auT = "content://" + com.baidu.swan.apps.database.favorite.b.auP + "/history_with_aps_pms";

    public static Uri BX() {
        return Uri.parse(auR);
    }

    public static Uri BY() {
        return Uri.parse(auT);
    }

    public static Uri BZ() {
        return Uri.parse(auS);
    }
}
