package com.baidu.swan.apps.media.b.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.media.b.a.g
    public boolean a(com.baidu.swan.apps.media.b.a aVar, com.baidu.swan.apps.media.b.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("video", "open, video id:" + cVar.cMu + " slave id: " + cVar.cpq);
        aVar.atM();
        a(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void a(com.baidu.swan.apps.media.b.a aVar, com.baidu.swan.apps.media.b.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.d(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    @Override // com.baidu.swan.apps.media.b.a.g
    protected com.baidu.swan.apps.media.b.a a(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        com.baidu.swan.apps.media.a H = com.baidu.swan.apps.media.b.H(str, str2, str3);
        if (H == null) {
            return new com.baidu.swan.apps.media.b.a(context, com.baidu.swan.apps.media.b.c.a(jSONObject, new com.baidu.swan.apps.media.b.c()));
        }
        if (H.avO() instanceof com.baidu.swan.apps.media.b.a) {
            return (com.baidu.swan.apps.media.b.a) H.avO();
        }
        return null;
    }
}
