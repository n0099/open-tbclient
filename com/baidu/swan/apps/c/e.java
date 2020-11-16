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
/* loaded from: classes7.dex */
public class e extends aa {
    private com.baidu.swan.apps.c.b ctt;

    public e(j jVar) {
        super(jVar, "/swanAPI/rewardedVideoAd");
        this.ctt = null;
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
        if (this.ctt == null) {
            this.ctt = com.baidu.swan.apps.t.a.awv().a(b2, bVar, aVar);
            if (this.ctt == null) {
                this.ctt = new com.baidu.swan.apps.c.a();
            }
        }
        if (TextUtils.equals(optString2, "show")) {
            this.ctt.a(b2, aVar);
            return true;
        } else if (TextUtils.equals(optString2, TrackLoadSettingsAtom.TYPE)) {
            this.ctt.a(b2, aVar, bVar);
            return true;
        } else {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    private class a implements c {
        private final UnitedSchemeEntity ctu;
        private final CallbackHandler ctv;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.ctu = unitedSchemeEntity;
            this.ctv = callbackHandler;
        }
    }

    /* loaded from: classes7.dex */
    private class b implements d {
        private final CallbackHandler ctv;
        private final String cty;

        public b(CallbackHandler callbackHandler, String str) {
            this.ctv = callbackHandler;
            this.cty = str;
        }
    }
}
