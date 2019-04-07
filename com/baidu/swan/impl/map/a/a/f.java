package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.e> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();

    public static f Qb() {
        return new f();
    }

    private boolean a(Context context, com.baidu.swan.apps.x.a.e eVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        com.baidu.swan.apps.console.c.i("map", "OpenLocationAction start");
        if (!eVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model is invalid");
            return false;
        }
        com.baidu.swan.impl.map.c.a.z(a(eVar)).Qg();
        com.baidu.swan.apps.console.c.i("map", "OpenLocationAction end");
        return true;
    }

    private Bundle a(com.baidu.swan.apps.x.a.e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("slaveId", eVar.aBG);
        bundle.putDouble("latitude", eVar.ayL.latitude);
        bundle.putDouble("longitude", eVar.ayL.longitude);
        bundle.putDouble("scale", eVar.ayM);
        bundle.putString("name", eVar.name);
        bundle.putString("address", eVar.address);
        return bundle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.x.a.e eVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return a(context, eVar, bVar, bVar2);
    }
}
