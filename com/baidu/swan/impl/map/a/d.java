package com.baidu.swan.impl.map.a;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends a<com.baidu.swan.apps.x.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();

    public static d TH() {
        return new d();
    }

    private boolean k(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        com.baidu.swan.apps.console.c.i("map", "MapUpdateAction start");
        boolean b = com.baidu.swan.impl.map.c.TE().b(context, cVar);
        com.baidu.swan.apps.console.c.i("map", "MapUpdateAction end");
        return b;
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return k(context, cVar, bVar, bVar2);
    }
}
