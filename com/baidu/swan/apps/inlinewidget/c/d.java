package com.baidu.swan.apps.inlinewidget.c;

import android.content.Context;
import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.v.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends aa {
    public d(j jVar) {
        super(jVar, "/swanAPI/setFullscreenOrientationSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("setFullscreenOrientationSync", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal runtime");
            if (DEBUG) {
                Log.e("SwanAppAction", "setFullscreenOrientationSync --- illegal runtime");
            }
            return false;
        } else if (context == null) {
            com.baidu.swan.apps.console.c.e("setFullscreenOrientationSync", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (DEBUG) {
                Log.e("SwanAppAction", "setFullscreenOrientationSync --- illegal context");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                com.baidu.swan.apps.console.c.e("setFullscreenOrientationSync", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            int optInt = optParamsAsJo.optInt("orientationType", DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
            com.baidu.swan.apps.adaptation.b.e mn = f.asJ().mn(optParamsAsJo.optString("slaveId"));
            if (!(mn instanceof SwanAppWebViewManager)) {
                com.baidu.swan.apps.console.c.e("setFullscreenOrientationSync", "no WebView with this slaveId");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int ia = ia(optInt);
            ((SwanAppWebViewManager) mn).gZ(ia);
            if (DEBUG) {
                Log.d("setFullscreenOrientationSync", "orientation set to : " + ia);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    private int ia(int i) {
        switch (i) {
            case -90:
                return 8;
            case 0:
                return 1;
            case 90:
                return 0;
            default:
                return -1;
        }
    }
}
