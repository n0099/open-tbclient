package com.baidu.swan.apps.api.module.k;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.apps.api.a.c {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b hp(String str) {
        if (DEBUG) {
            Log.d("Api-PhoneCallApi", "start make phone call");
        }
        if (Ru()) {
            com.baidu.swan.apps.console.c.e("Api-PhoneCallApi", "Api-PhoneCallApi does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.b.b(1001, "Api-PhoneCallApi does not supported when app is invisible.");
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-PhoneCallApi", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) az.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-PhoneCallApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) az.second;
        if (jSONObject != null) {
            String optString = jSONObject.optString("phoneNumber");
            if (!TextUtils.isEmpty(optString)) {
                intent.setData(Uri.parse("tel:" + optString));
            }
        }
        if (com.baidu.swan.apps.as.c.startActivitySafely(getContext(), intent)) {
            return new com.baidu.swan.apps.api.b.b(0);
        }
        return new com.baidu.swan.apps.api.b.b(1001);
    }
}
