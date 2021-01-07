package com.baidu.swan.apps.api.module.k;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.api.a.d {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b anI() {
        if (DEBUG) {
            Log.d("Api-BrightnessApi", "handle");
        }
        com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (aMm == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        SwanAppActivity aMf = aMm.aMf();
        if (aMf == null) {
            com.baidu.swan.apps.console.c.e("Api-BrightnessApi", "null activity");
            return new com.baidu.swan.apps.api.c.b(1001, "null activity");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", com.baidu.swan.apps.ak.d.b.a.aQg().M(aMf));
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        }
    }
}
