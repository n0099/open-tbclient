package com.baidu.swan.apps.media.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected String dkP;

    public abstract boolean a(com.baidu.swan.apps.media.b.a aVar, com.baidu.swan.apps.media.b.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar);

    public g(@NonNull String str) {
        this.dkP = str;
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
        com.baidu.swan.apps.media.b.a c = c(context, optParamsAsJo.optString("slaveId"), optParamsAsJo.optString("sanId"), optParamsAsJo.optString("videoId"), optParamsAsJo);
        if (c == null || context == null) {
            com.baidu.swan.apps.console.c.e("video", "player id is invalid or context is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.media.b.c a2 = com.baidu.swan.apps.media.b.c.a(optParamsAsJo, c.aiW());
        if (!a2.isValid()) {
            com.baidu.swan.apps.console.c.e("video", "param is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        return a(c, a2, context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Nullable
    protected com.baidu.swan.apps.media.b.a c(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        com.baidu.swan.apps.media.a T;
        if (TextUtils.isEmpty(str3) || (T = com.baidu.swan.apps.media.b.T(str, str2, str3)) == null || !(T.aAh() instanceof com.baidu.swan.apps.media.b.a)) {
            return null;
        }
        return (com.baidu.swan.apps.media.b.a) T.aAh();
    }
}
