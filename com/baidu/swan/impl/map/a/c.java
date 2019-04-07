package com.baidu.swan.impl.map.a;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends a<com.baidu.swan.apps.x.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();

    public static c PU() {
        return new c();
    }

    private boolean j(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        com.baidu.swan.apps.console.c.i("map", "MapRemoveAction start");
        boolean a = com.baidu.swan.impl.map.c.PS().a(cVar);
        com.baidu.swan.apps.console.c.i("map", "MapRemoveAction end");
        return a;
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return j(context, cVar, bVar, bVar2);
    }
}
