package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes2.dex */
public class a {
    public static final String aPi = "content://" + com.baidu.swan.apps.database.favorite.b.aPg + "/history_with_app";
    public static final String aPj = "content://" + com.baidu.swan.apps.database.favorite.b.aPg + "/history";
    public static final String aPk = "content://" + com.baidu.swan.apps.database.favorite.b.aPg + "/history_with_aps_pms";

    public static Uri HE() {
        return Uri.parse(aPi);
    }

    public static Uri HF() {
        return Uri.parse(aPk);
    }

    public static Uri HG() {
        return Uri.parse(aPj);
    }
}
