package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.e> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();

    public static f baD() {
        return new f();
    }

    private boolean a(Context context, com.baidu.swan.apps.w.a.e eVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar2) {
        com.baidu.swan.apps.console.c.i("map", "OpenLocationAction start");
        if (!eVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model is invalid");
            return false;
        }
        com.baidu.swan.impl.map.c.a.Z(a(eVar)).baK();
        com.baidu.swan.apps.console.c.i("map", "OpenLocationAction end");
        return true;
    }

    private Bundle a(com.baidu.swan.apps.w.a.e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("slaveId", eVar.cLr);
        bundle.putDouble("latitude", eVar.dhA.latitude);
        bundle.putDouble("longitude", eVar.dhA.longitude);
        bundle.putDouble("scale", eVar.dhB);
        bundle.putString("name", eVar.dhQ);
        bundle.putString("address", eVar.dhR);
        bundle.putStringArrayList("ignoredApps", eVar.dhS);
        return bundle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.w.a.e eVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar2, JSONObject jSONObject) {
        return a(context, eVar, bVar, eVar2);
    }
}
