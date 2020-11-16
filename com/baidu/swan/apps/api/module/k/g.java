package com.baidu.swan.apps.api.module.k;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends com.baidu.swan.apps.api.a.d {
    public g(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lG(String str) {
        if (DEBUG) {
            Log.d("Api-PhoneCallApi", "start make phone call");
        }
        if (aiS()) {
            com.baidu.swan.apps.console.c.e("Api-PhoneCallApi", "Api-PhoneCallApi does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.c.b(1001, "Api-PhoneCallApi does not supported when app is invisible.");
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bi = com.baidu.swan.apps.api.d.b.bi("Api-PhoneCallApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bi.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-PhoneCallApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bi.second;
        if (jSONObject != null) {
            String optString = jSONObject.optString("phoneNumber");
            if (!TextUtils.isEmpty(optString)) {
                intent.setData(Uri.parse("tel:" + optString));
            }
        }
        if (com.baidu.swan.apps.ap.e.startActivitySafely(getContext(), intent)) {
            return new com.baidu.swan.apps.api.c.b(0);
        }
        return new com.baidu.swan.apps.api.c.b(1001);
    }
}
