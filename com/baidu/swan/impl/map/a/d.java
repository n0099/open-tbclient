package com.baidu.swan.impl.map.a;

import android.content.Context;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class d extends a<com.baidu.swan.apps.z.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();

    public static d arD() {
        return new d();
    }

    private boolean k(Context context, com.baidu.swan.apps.z.a.c cVar, com.baidu.swan.apps.z.b bVar, e eVar) {
        com.baidu.swan.apps.console.c.i("map", "MapUpdateAction start");
        boolean b = com.baidu.swan.impl.map.c.arz().b(context, cVar);
        com.baidu.swan.apps.console.c.i("map", "MapUpdateAction end");
        return b;
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.z.a.c cVar, com.baidu.swan.apps.z.b bVar, e eVar, JSONObject jSONObject) {
        return k(context, cVar, bVar, eVar);
    }
}
