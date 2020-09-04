package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class f extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.e> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();

    public static f aRE() {
        return new f();
    }

    private boolean a(Context context, com.baidu.swan.apps.w.a.e eVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar2) {
        com.baidu.swan.apps.console.c.i("map", "OpenLocationAction start");
        if (!eVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model is invalid");
            return false;
        }
        com.baidu.swan.impl.map.c.a.Z(a(eVar)).aRL();
        com.baidu.swan.apps.console.c.i("map", "OpenLocationAction end");
        return true;
    }

    private Bundle a(com.baidu.swan.apps.w.a.e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("slaveId", eVar.caY);
        bundle.putDouble("latitude", eVar.cxA.latitude);
        bundle.putDouble("longitude", eVar.cxA.longitude);
        bundle.putDouble("scale", eVar.cxB);
        bundle.putString("name", eVar.cxQ);
        bundle.putString("address", eVar.cxR);
        bundle.putStringArrayList("ignoredApps", eVar.cxS);
        return bundle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.w.a.e eVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar2, JSONObject jSONObject) {
        return a(context, eVar, bVar, eVar2);
    }
}
