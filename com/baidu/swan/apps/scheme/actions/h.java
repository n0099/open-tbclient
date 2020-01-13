package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h extends ab {
    private List<String> bMQ;
    private AtomicBoolean bMR;

    public h(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/downloadPackages");
        this.bMR = new AtomicBoolean(false);
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
        if (this.bMQ == null) {
            this.bMQ = Collections.synchronizedList(new ArrayList());
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "invalid parameter");
            return false;
        }
        final JSONArray optJSONArray = b.optJSONArray("appKeys");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "appKeys must not empty");
            return false;
        }
        String optString = b.optString("netconf");
        if (TextUtils.isEmpty(optString)) {
            optString = "0";
        }
        if (!com.baidu.swan.apps.core.a.a.a.gz(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
            return false;
        }
        final String b2 = b(callbackHandler);
        if (!c(callbackHandler)) {
            b(optJSONArray, b2);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        } else {
            eVar.aaz().b(context, "mapp_pre_download", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.h.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    h.this.a(hVar, unitedSchemeEntity, callbackHandler, optJSONArray, b2);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.setting.oauth.h<b.d> hVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
        if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
            return;
        }
        b(jSONArray, str);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private void b(JSONArray jSONArray, final String str) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.bMQ.add(optString);
                }
            }
            if (!this.bMR.getAndSet(true)) {
                com.baidu.swan.apps.as.m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.pms.c.d.b bVar = new com.baidu.swan.pms.c.d.b(h.this.bMQ);
                        bVar.qo(str);
                        bVar.qn("1");
                        com.baidu.swan.pms.c.a(bVar, new com.baidu.swan.apps.core.pms.d());
                    }
                }, "小程序端能力-批量下载");
            }
        }
    }

    private String b(CallbackHandler callbackHandler) {
        return d(callbackHandler) ? "10" : "2";
    }

    private boolean c(CallbackHandler callbackHandler) {
        return d(callbackHandler);
    }

    private boolean d(CallbackHandler callbackHandler) {
        if (callbackHandler instanceof TypedCallbackHandler) {
            int invokeSourceType = ((TypedCallbackHandler) callbackHandler).getInvokeSourceType();
            return invokeSourceType == 0 || invokeSourceType == 1;
        }
        return false;
    }
}
