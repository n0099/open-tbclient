package com.baidu.swan.apps.api.module.k;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g extends com.baidu.swan.apps.api.a.d {
    public g(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lx(String str) {
        if (DEBUG) {
            Log.d("Api-PhoneCallApi", "start make phone call");
        }
        if (aha()) {
            com.baidu.swan.apps.console.c.e("Api-PhoneCallApi", "Api-PhoneCallApi does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.c.b(1001, "Api-PhoneCallApi does not supported when app is invisible.");
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-PhoneCallApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bj.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-PhoneCallApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bj.second;
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
