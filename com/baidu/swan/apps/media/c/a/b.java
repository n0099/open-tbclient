package com.baidu.swan.apps.media.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public b(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.media.c.a.g
    public boolean a(com.baidu.swan.apps.media.c.a aVar, com.baidu.swan.apps.media.c.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("video", "fullscreen, video id:" + cVar.bYY + " slave id: " + cVar.bGO);
        a(aVar, cVar.bsQ, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void a(com.baidu.swan.apps.media.c.a aVar, boolean z, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params != null && !params.isEmpty()) {
            aVar.g(z, z(params));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    private int z(HashMap<String, String> hashMap) {
        String str = hashMap.get("params");
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optInt("direction", -1);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }
}
