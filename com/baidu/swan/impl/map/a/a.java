package com.baidu.swan.impl.map.a;

import android.content.Context;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.x.a.c;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public abstract class a<T extends com.baidu.swan.apps.x.a.c> {
    protected abstract boolean a(Context context, T t, com.baidu.swan.apps.x.b bVar, e eVar, JSONObject jSONObject);

    public boolean h(Context context, T t, com.baidu.swan.apps.x.b bVar, e eVar) {
        JSONObject jSONObject = new JSONObject();
        if (!a(context, t, bVar, eVar, jSONObject)) {
            bVar.onError(1001);
            com.baidu.swan.apps.console.c.e("map", "doAction fail");
            return false;
        }
        if (jSONObject.length() <= 0) {
            jSONObject = null;
        }
        bVar.aa(jSONObject);
        return true;
    }
}
