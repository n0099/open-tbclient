package com.baidu.swan.apps.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends aa {
    private com.baidu.swan.apps.c.b bUt;

    public e(j jVar) {
        super(jVar, "/swanAPI/rewardedVideoAd");
        this.bUt = null;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("SwanAppAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject b2 = b(unitedSchemeEntity, "params");
        String optString = b2.optString("cb");
        String optString2 = b2.optString("action");
        b bVar = new b(callbackHandler, optString);
        a aVar = new a(unitedSchemeEntity, callbackHandler);
        if (this.bUt == null) {
            this.bUt = com.baidu.swan.apps.t.a.apX().a(b2, bVar, aVar);
            if (this.bUt == null) {
                this.bUt = new com.baidu.swan.apps.c.a();
            }
        }
        if (TextUtils.equals(optString2, "show")) {
            this.bUt.a(b2, aVar);
            return true;
        } else if (TextUtils.equals(optString2, TrackLoadSettingsAtom.TYPE)) {
            this.bUt.a(b2, aVar, bVar);
            return true;
        } else {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    private class a implements c {
        private final UnitedSchemeEntity bUu;
        private final CallbackHandler bUv;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.bUu = unitedSchemeEntity;
            this.bUv = callbackHandler;
        }
    }

    /* loaded from: classes3.dex */
    private class b implements d {
        private final CallbackHandler bUv;
        private final String bUx;

        public b(CallbackHandler callbackHandler, String str) {
            this.bUv = callbackHandler;
            this.bUx = str;
        }
    }
}
