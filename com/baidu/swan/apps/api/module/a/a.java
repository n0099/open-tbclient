package com.baidu.swan.apps.api.module.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends c {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b fe(String str) {
        if (DEBUG) {
            Log.d("Api-CheckSession", "start check session");
        }
        final CallbackHandler JC = JE().JC();
        e acG = e.acG();
        if (acG == null) {
            com.baidu.swan.games.u.c.f(JC, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.b.b(1001, "empty swanApp");
        }
        String appKey = acG.getAppKey();
        if (TextUtils.isEmpty(appKey)) {
            com.baidu.swan.games.u.c.i(JC, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return new com.baidu.swan.apps.api.b.b(1001, "empty clientId");
        }
        JSONObject fd = fd(str);
        if (fd == null) {
            com.baidu.swan.games.u.c.f(JC, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return new com.baidu.swan.apps.api.b.b(201, "empty joParams");
        }
        final String optString = fd.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.games.u.c.f(JC, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return new com.baidu.swan.apps.api.b.b(201, "empty cb");
        }
        Context context = getContext();
        if (!(context instanceof Activity)) {
            return new com.baidu.swan.apps.api.b.b(1001, "the context is not an activity");
        }
        if (!acG.acQ().isLogin(context)) {
            com.baidu.swan.games.u.c.i(JC, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            return new com.baidu.swan.apps.api.b.b(10004, "user not logged in");
        }
        d.acC().acE().GV().HS().c((Activity) context, appKey).h(new com.baidu.swan.apps.as.d.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.api.module.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(h<JSONObject> hVar) {
                JSONObject wrapCallbackParams;
                if (hVar.isOk() && a.O(hVar.mData)) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(hVar.mData.optJSONObject("data"), hVar.getErrorCode());
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(hVar.getErrorCode());
                    com.baidu.swan.games.u.c.i(JC, wrapCallbackParams.toString());
                }
                JC.handleSchemeDispatchCallback(optString, wrapCallbackParams.toString());
            }
        }).aei();
        return new com.baidu.swan.apps.api.b.b(0);
    }

    public static boolean O(JSONObject jSONObject) {
        return jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0");
    }
}
