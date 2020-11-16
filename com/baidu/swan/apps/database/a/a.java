package com.baidu.swan.apps.database.a;

import android.net.Uri;
/* loaded from: classes7.dex */
public class a {
    public static final String cPL = "content://" + com.baidu.swan.apps.database.favorite.b.cPI + "/history_with_app";
    public static final String cPM = "content://" + com.baidu.swan.apps.database.favorite.b.cPI + "/history";
    public static final String cPN = "content://" + com.baidu.swan.apps.database.favorite.b.cPI + "/history_with_aps_pms";

    public static Uri asn() {
        return Uri.parse(cPL);
    }

    public static Uri aso() {
        return Uri.parse(cPN);
    }

    public static Uri asp() {
        return Uri.parse(cPM);
    }
}
