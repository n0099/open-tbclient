package com.baidu.swan.impl.map.a;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends a<com.baidu.swan.apps.x.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();

    public static b Zq() {
        return new b();
    }

    private boolean i(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        com.baidu.swan.apps.console.c.i("map", "MapCreateAction start");
        boolean a = com.baidu.swan.impl.map.c.Zp().a(context, cVar);
        com.baidu.swan.apps.console.c.i("map", "MapCreateAction end");
        return a;
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return i(context, cVar, bVar, bVar2);
    }
}
