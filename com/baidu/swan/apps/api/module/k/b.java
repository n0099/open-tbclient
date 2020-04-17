package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.api.a.c {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b RQ() {
        if (DEBUG) {
            Log.d("Api-BrightnessApi", "handle");
        }
        e akO = e.akO();
        if (akO == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "SwanApp is null");
        }
        SwanAppActivity akJ = akO.akJ();
        if (akJ == null) {
            com.baidu.swan.apps.console.c.e("Api-BrightnessApi", "null activity");
            return new com.baidu.swan.apps.api.b.b(1001, "null activity");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", com.baidu.swan.apps.ao.d.b.a.anV().O(akJ));
            return new com.baidu.swan.apps.api.b.b(0, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            return new com.baidu.swan.apps.api.b.b(1001, "make result json error");
        }
    }
}
