package com.baidu.swan.impl.map.a;

import android.content.Context;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b extends a<com.baidu.swan.apps.w.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();

    public static b aZl() {
        return new b();
    }

    private boolean i(Context context, com.baidu.swan.apps.w.a.c cVar, com.baidu.swan.apps.w.b bVar, e eVar) {
        com.baidu.swan.apps.console.c.i("map", "MapCreateAction start");
        boolean a2 = com.baidu.swan.impl.map.c.aZj().a(context, cVar);
        com.baidu.swan.apps.console.c.i("map", "MapCreateAction end");
        return a2;
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.w.a.c cVar, com.baidu.swan.apps.w.b bVar, e eVar, JSONObject jSONObject) {
        return i(context, cVar, bVar, eVar);
    }
}
