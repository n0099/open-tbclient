package com.baidu.swan.apps.media.c.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.media.c.a.g
    public boolean a(com.baidu.swan.apps.media.c.a aVar, com.baidu.swan.apps.media.c.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("video", "open, video id:" + cVar.bAA + " slave id: " + cVar.bin);
        aVar.Vl();
        a(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void a(com.baidu.swan.apps.media.c.a aVar, com.baidu.swan.apps.media.c.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.d(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    @Override // com.baidu.swan.apps.media.c.a.g
    protected com.baidu.swan.apps.media.c.a a(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        com.baidu.swan.apps.media.a B = com.baidu.swan.apps.media.b.B(str, str2, str3);
        if (B == null) {
            return new com.baidu.swan.apps.media.c.a(context, com.baidu.swan.apps.media.c.c.a(jSONObject, new com.baidu.swan.apps.media.c.c()));
        }
        if (B.Xc() instanceof com.baidu.swan.apps.media.c.a) {
            return (com.baidu.swan.apps.media.c.a) B.Xc();
        }
        return null;
    }
}
