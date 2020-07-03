package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.aq.ak;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b in(String str) {
        if (DEBUG) {
            Log.d("Api-ClipboardApi", "start set clipboard data");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-ClipboardApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ClipboardApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        ak.cE(getContext()).setText(((JSONObject) aR.second).optString("data"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b Vx() {
        if (DEBUG) {
            Log.d("Api-ClipboardApi", "start get clipboard data");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            CharSequence text = ak.cE(getContext()).getText();
            jSONObject.put("data", TextUtils.isEmpty(text) ? "" : text.toString());
            if (DEBUG) {
                Log.i("Api-ClipboardApi", "getClipboardData:  " + jSONObject);
            }
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new com.baidu.swan.apps.api.c.b(1001, "JSONException");
        }
    }
}
