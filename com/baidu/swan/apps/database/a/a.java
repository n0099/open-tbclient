package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes2.dex */
public class a {
    public static final String avv = "content://" + com.baidu.swan.apps.database.favorite.b.avt + "/history_with_app";
    public static final String avw = "content://" + com.baidu.swan.apps.database.favorite.b.avt + "/history";
    public static final String avx = "content://" + com.baidu.swan.apps.database.favorite.b.avt + "/history_with_aps_pms";

    public static Uri CG() {
        return Uri.parse(avv);
    }

    public static Uri CH() {
        return Uri.parse(avx);
    }

    public static Uri CI() {
        return Uri.parse(avw);
    }
}
