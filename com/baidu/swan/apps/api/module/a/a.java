package com.baidu.swan.apps.api.module.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.games.v.c;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b km(String str) {
        if (DEBUG) {
            Log.d("Api-CheckSession", "start check session");
        }
        final CallbackHandler ajO = ajQ().ajO();
        e aIO = e.aIO();
        if (aIO == null) {
            c.h(ajO, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty swanApp");
        }
        String appKey = aIO.getAppKey();
        if (TextUtils.isEmpty(appKey)) {
            c.h(ajO, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty app key");
        }
        JSONObject kl = kl(str);
        if (kl == null) {
            c.h(ajO, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return new com.baidu.swan.apps.api.c.b(201, "empty joParams");
        }
        final String optString = kl.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.h(ajO, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        }
        Context context = getContext();
        if (!aIO.aJa().isLogin(context)) {
            c.h(ajO, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            return new com.baidu.swan.apps.api.c.b(10004, "user not logged in");
        }
        com.baidu.swan.apps.runtime.d.aIJ().aIL().agv().aio().aa(context, appKey).A(new com.baidu.swan.apps.ao.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.api.module.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(h<JSONObject> hVar) {
                JSONObject wrapCallbackParams;
                if (hVar.isOk() && a.aM(hVar.mData)) {
                    JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(hVar.getErrorCode());
                    c.h(ajO, wrapCallbackParams.toString());
                }
                ajO.handleSchemeDispatchCallback(optString, wrapCallbackParams.toString());
            }
        }).aKE();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public static boolean aM(JSONObject jSONObject) {
        return jSONObject != null && TextUtils.equals(jSONObject.optString(BaseJsonData.TAG_ERRNO), "0");
    }
}
