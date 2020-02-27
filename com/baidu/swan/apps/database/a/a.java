package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes11.dex */
public class a {
    public static final String btv = "content://" + com.baidu.swan.apps.database.favorite.b.btt + "/history_with_app";
    public static final String btw = "content://" + com.baidu.swan.apps.database.favorite.b.btt + "/history";
    public static final String btx = "content://" + com.baidu.swan.apps.database.favorite.b.btt + "/history_with_aps_pms";

    public static Uri Rp() {
        return Uri.parse(btv);
    }

    public static Uri Rq() {
        return Uri.parse(btx);
    }

    public static Uri Rr() {
        return Uri.parse(btw);
    }
}
