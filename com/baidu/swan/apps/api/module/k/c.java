package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.al;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b kR(String str) {
        if (DEBUG) {
            Log.d("Api-ClipboardApi", "start set clipboard data");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-ClipboardApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bn.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ClipboardApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        al.dS(getContext()).setText(((JSONObject) bn.second).optString("data"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b ajP() {
        if (DEBUG) {
            Log.d("Api-ClipboardApi", "start get clipboard data");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            CharSequence text = al.dS(getContext()).getText();
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
