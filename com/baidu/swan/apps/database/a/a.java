package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes10.dex */
public class a {
    public static final String bpm = "content://" + com.baidu.swan.apps.database.favorite.b.bpk + "/history_with_app";
    public static final String bpn = "content://" + com.baidu.swan.apps.database.favorite.b.bpk + "/history";
    public static final String bpo = "content://" + com.baidu.swan.apps.database.favorite.b.bpk + "/history_with_aps_pms";

    public static Uri Pb() {
        return Uri.parse(bpm);
    }

    public static Uri Pc() {
        return Uri.parse(bpo);
    }

    public static Uri Pd() {
        return Uri.parse(bpn);
    }
}
