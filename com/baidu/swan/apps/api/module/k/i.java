package com.baidu.swan.apps.api.module.k;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i extends com.baidu.swan.apps.api.a.d {
    private int cAC;

    public i(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lO(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-ShowSMSPanel", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bj.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-ShowSMSPanel", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bj.second;
        com.baidu.swan.apps.console.c.d("Api-ShowSMSPanel", "params: ", jSONObject);
        final String optString = jSONObject.optString("content");
        JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
        if (optJSONArray == null) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        final String r = r(optJSONArray);
        if (TextUtils.isEmpty(r) || TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        final String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        com.baidu.swan.apps.runtime.d.aHq().aHm().aHG().b(getContext(), "scope_show_sms_panel", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.api.module.k.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    int errorCode = hVar.getErrorCode();
                    i.this.a(optString2, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.hD(errorCode)));
                    return;
                }
                i.this.bi(r, optString);
                i.this.a(optString2, new com.baidu.swan.apps.api.c.b(0));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public void bi(@NonNull String str, @NonNull String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SENDTO");
        intent.setData(Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        getContext().startActivity(intent);
        akc();
    }

    private String r(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        this.cAC = jSONArray.length();
        for (int i = 0; i < this.cAC; i++) {
            String optString = jSONArray.optString(i);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            sb.append(optString);
            if (i != this.cAC - 1) {
                sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            }
        }
        return sb.toString();
    }

    private void akc() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mType = "sms_panel";
        fVar.mValue = String.valueOf(this.cAC);
        fVar.u("appid", com.baidu.swan.apps.runtime.d.aHq().getAppId());
        com.baidu.swan.apps.statistic.h.a("1639", fVar);
    }
}
