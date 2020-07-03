package com.baidu.swan.impl.map.a;

import android.content.Context;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class c extends a<com.baidu.swan.apps.x.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();

    public static c aEQ() {
        return new c();
    }

    private boolean j(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, e eVar) {
        com.baidu.swan.apps.console.c.i("map", "MapRemoveAction start");
        boolean a = com.baidu.swan.impl.map.c.aEN().a(cVar);
        com.baidu.swan.apps.console.c.i("map", "MapRemoveAction end");
        return a;
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, e eVar, JSONObject jSONObject) {
        return j(context, cVar, bVar, eVar);
    }
}
