package com.baidu.swan.apps.ac.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.module.a.b;
import com.baidu.swan.apps.setting.oauth.a.f;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends a {
    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.api.c.b bz(JSONObject jSONObject) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.apps.ac.c.d.b
    public String aEV() {
        return "snsapi_userinfo";
    }

    @Override // com.baidu.swan.apps.ac.c.d.a
    void a(SwanAppActivity swanAppActivity, String str, com.baidu.swan.apps.ac.c.b.b bVar, final com.baidu.swan.apps.setting.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2) {
        final com.baidu.swan.apps.ac.c.c.a aVar2 = new com.baidu.swan.apps.ac.c.c.a(bVar.cMQ);
        aVar2.cMR = bVar.cMR;
        if (aVar == null || aVar.dLO.aNi() != 0) {
            com.baidu.swan.apps.ac.d.a.print("open data result failure");
            bVar2.P(aVar2);
            return;
        }
        com.baidu.swan.apps.ac.d.a.print("obtain user info detail, get login code");
        b.a aVar3 = new b.a(bVar.pageParams);
        Bundle bundle = new Bundle();
        bundle.putString("__plugin__", bVar.dtW);
        com.baidu.swan.apps.runtime.d.aIJ().aIF().aIZ().a(swanAppActivity, aVar3, bundle, new com.baidu.swan.apps.ao.e.b<h<f.c>>() { // from class: com.baidu.swan.apps.ac.c.d.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(h<f.c> hVar) {
                if (hVar == null || !hVar.isOk() || TextUtils.isEmpty(hVar.mData.code)) {
                    com.baidu.swan.apps.ac.d.a.print("login failure, can't get login code");
                    bVar2.P(aVar2);
                    return;
                }
                JSONObject jSONObject = aVar.dKW;
                if (jSONObject != null) {
                    try {
                        jSONObject.put("code", hVar.mData.code);
                        aVar2.isSuccess = true;
                    } catch (JSONException e) {
                        if (com.baidu.swan.apps.b.DEBUG) {
                            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
                        }
                    }
                    aVar2.duc = jSONObject.toString();
                }
                bVar2.P(aVar2);
            }
        });
    }
}
