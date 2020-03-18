package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes11.dex */
public class a {
    public static final String btJ = "content://" + com.baidu.swan.apps.database.favorite.b.btH + "/history_with_app";
    public static final String btK = "content://" + com.baidu.swan.apps.database.favorite.b.btH + "/history";
    public static final String btL = "content://" + com.baidu.swan.apps.database.favorite.b.btH + "/history_with_aps_pms";

    public static Uri Ru() {
        return Uri.parse(btJ);
    }

    public static Uri Rv() {
        return Uri.parse(btL);
    }

    public static Uri Rw() {
        return Uri.parse(btK);
    }
}
