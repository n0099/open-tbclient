package com.baidu.swan.apps.media.b.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.media.b.a.g
    public boolean a(com.baidu.swan.apps.media.b.a aVar, com.baidu.swan.apps.media.b.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("video", "open, video id:" + cVar.diq + " slave id: " + cVar.cLr);
        aVar.ayD();
        a(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void a(com.baidu.swan.apps.media.b.a aVar, com.baidu.swan.apps.media.b.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.d(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    @Override // com.baidu.swan.apps.media.b.a.g
    protected com.baidu.swan.apps.media.b.a c(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        com.baidu.swan.apps.media.a U = com.baidu.swan.apps.media.b.U(str, str2, str3);
        if (U == null) {
            return new com.baidu.swan.apps.media.b.a(context, com.baidu.swan.apps.media.b.c.a(jSONObject, new com.baidu.swan.apps.media.b.c()));
        }
        if (U.aAF() instanceof com.baidu.swan.apps.media.b.a) {
            return (com.baidu.swan.apps.media.b.a) U.aAF();
        }
        return null;
    }
}
