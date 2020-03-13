package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes11.dex */
public class a {
    public static final String btx = "content://" + com.baidu.swan.apps.database.favorite.b.btv + "/history_with_app";
    public static final String bty = "content://" + com.baidu.swan.apps.database.favorite.b.btv + "/history";
    public static final String btz = "content://" + com.baidu.swan.apps.database.favorite.b.btv + "/history_with_aps_pms";

    public static Uri Rr() {
        return Uri.parse(btx);
    }

    public static Uri Rs() {
        return Uri.parse(btz);
    }

    public static Uri Rt() {
        return Uri.parse(bty);
    }
}
