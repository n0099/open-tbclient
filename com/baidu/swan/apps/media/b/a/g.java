package com.baidu.swan.apps.media.b.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected String dfo;

    public abstract boolean a(com.baidu.swan.apps.media.b.a aVar, com.baidu.swan.apps.media.b.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar);

    public g(@NonNull String str) {
        this.dfo = str;
    }

    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("video", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        com.baidu.swan.apps.media.b.a a2 = a(context, optParamsAsJo.optString("slaveId"), optParamsAsJo.optString("sanId"), optParamsAsJo.optString("videoId"), optParamsAsJo);
        if (a2 == null || context == null) {
            com.baidu.swan.apps.console.c.e("video", "player id is invalid or context is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.media.b.c a3 = com.baidu.swan.apps.media.b.c.a(optParamsAsJo, a2.ajf());
        if (!a3.isValid()) {
            com.baidu.swan.apps.console.c.e("video", "param is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        return a(a2, a3, context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Nullable
    protected com.baidu.swan.apps.media.b.a a(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        com.baidu.swan.apps.media.a O;
        if (TextUtils.isEmpty(str3) || (O = com.baidu.swan.apps.media.b.O(str, str2, str3)) == null || !(O.aAi() instanceof com.baidu.swan.apps.media.b.a)) {
            return null;
        }
        return (com.baidu.swan.apps.media.b.a) O.aAi();
    }
}
