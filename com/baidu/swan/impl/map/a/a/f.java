package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import android.os.Bundle;
import com.baidu.sapi2.activity.SlideActiviy;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.z.a.e> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();

    public static f apc() {
        return new f();
    }

    private boolean a(Context context, com.baidu.swan.apps.z.a.e eVar, com.baidu.swan.apps.z.b bVar, com.baidu.swan.apps.runtime.e eVar2) {
        com.baidu.swan.apps.console.c.i("map", "OpenLocationAction start");
        if (!eVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model is invalid");
            return false;
        }
        com.baidu.swan.impl.map.c.a.T(a(eVar)).apk();
        com.baidu.swan.apps.console.c.i("map", "OpenLocationAction end");
        return true;
    }

    private Bundle a(com.baidu.swan.apps.z.a.e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("slaveId", eVar.bdi);
        bundle.putDouble("latitude", eVar.buN.latitude);
        bundle.putDouble("longitude", eVar.buN.longitude);
        bundle.putDouble("scale", eVar.buO);
        bundle.putString("name", eVar.bvd);
        bundle.putString(SlideActiviy.ADDRESS_PAGE_NAME, eVar.bve);
        bundle.putStringArrayList("ignoredApps", eVar.bvf);
        return bundle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.z.a.e eVar, com.baidu.swan.apps.z.b bVar, com.baidu.swan.apps.runtime.e eVar2, JSONObject jSONObject) {
        return a(context, eVar, bVar, eVar2);
    }
}
