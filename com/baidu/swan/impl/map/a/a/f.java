package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class f extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.e> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();

    public static f aUZ() {
        return new f();
    }

    private boolean a(Context context, com.baidu.swan.apps.w.a.e eVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar2) {
        com.baidu.swan.apps.console.c.i("map", "OpenLocationAction start");
        if (!eVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model is invalid");
            return false;
        }
        com.baidu.swan.impl.map.c.a.Z(a(eVar)).aVg();
        com.baidu.swan.apps.console.c.i("map", "OpenLocationAction end");
        return true;
    }

    private Bundle a(com.baidu.swan.apps.w.a.e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("slaveId", eVar.cpq);
        bundle.putDouble("latitude", eVar.cLG.latitude);
        bundle.putDouble("longitude", eVar.cLG.longitude);
        bundle.putDouble("scale", eVar.cLH);
        bundle.putString("name", eVar.cLW);
        bundle.putString("address", eVar.cLX);
        bundle.putStringArrayList("ignoredApps", eVar.cLY);
        return bundle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.w.a.e eVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar2, JSONObject jSONObject) {
        return a(context, eVar, bVar, eVar2);
    }
}
