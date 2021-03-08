package com.baidu.swan.apps.api.module.k;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.api.a.d {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b akp() {
        if (DEBUG) {
            Log.d("Api-BrightnessApi", "handle");
        }
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        SwanAppActivity aIH = aIO.aIH();
        if (aIH == null) {
            com.baidu.swan.apps.console.c.e("Api-BrightnessApi", "null activity");
            return new com.baidu.swan.apps.api.c.b(1001, "null activity");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", com.baidu.swan.apps.ak.d.b.a.aMI().G(aIH));
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        }
    }
}
