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

    /* renamed from: if  reason: not valid java name */
    public com.baidu.swan.apps.api.c.b m25if(String str) {
        if (DEBUG) {
            Log.d("Api-ClipboardApi", "start set clipboard data");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-ClipboardApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ClipboardApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        ak.cD(getContext()).setText(((JSONObject) aP.second).optString("data"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b Ur() {
        if (DEBUG) {
            Log.d("Api-ClipboardApi", "start get clipboard data");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            CharSequence text = ak.cD(getContext()).getText();
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
