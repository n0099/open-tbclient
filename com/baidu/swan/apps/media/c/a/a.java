package com.baidu.swan.apps.media.c.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public a(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.media.c.a.c
    public boolean a(com.baidu.swan.apps.media.c.a aVar, com.baidu.swan.apps.media.c.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("vrvideo", "open, video id:" + cVar.djT + " slave id: " + cVar.cMR);
        a(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void a(com.baidu.swan.apps.media.c.a aVar, com.baidu.swan.apps.media.c.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.b(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    @Override // com.baidu.swan.apps.media.c.a.c
    protected com.baidu.swan.apps.media.c.a d(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        com.baidu.swan.apps.media.a U = com.baidu.swan.apps.media.b.U(str, str2, str3);
        if (U == null) {
            return new com.baidu.swan.apps.media.c.a(context, com.baidu.swan.apps.media.c.c.a(jSONObject, new com.baidu.swan.apps.media.c.c()));
        }
        if (U.aAI() instanceof com.baidu.swan.apps.media.c.a) {
            return (com.baidu.swan.apps.media.c.a) U.aAI();
        }
        return null;
    }
}
