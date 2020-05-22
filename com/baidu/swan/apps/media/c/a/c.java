package com.baidu.swan.apps.media.c.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com  reason: collision with root package name */
    protected String f1000com;

    public abstract boolean a(com.baidu.swan.apps.media.c.a aVar, com.baidu.swan.apps.media.c.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar);

    public c(@NonNull String str) {
        this.f1000com = str;
    }

    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("vrvideo", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        com.baidu.swan.apps.media.c.a b = b(context, optParamsAsJo.optString("slaveId"), optParamsAsJo.optString("sanId"), optParamsAsJo.optString("videoId"), optParamsAsJo);
        if (b == null || context == null) {
            com.baidu.swan.apps.console.c.e("vrvideo", "player id is invalid or context is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.media.c.c a = com.baidu.swan.apps.media.c.c.a(optParamsAsJo, b.ajD());
        if (!a.isValid()) {
            com.baidu.swan.apps.console.c.e("vrvideo", "param is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        return a(b, a, context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Nullable
    protected com.baidu.swan.apps.media.c.a b(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        com.baidu.swan.apps.media.a E;
        if (TextUtils.isEmpty(str3) || (E = com.baidu.swan.apps.media.b.E(str, str2, str3)) == null || !(E.aii() instanceof com.baidu.swan.apps.media.c.a)) {
            return null;
        }
        return (com.baidu.swan.apps.media.c.a) E.aii();
    }
}
