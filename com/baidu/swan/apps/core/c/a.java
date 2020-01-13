package com.baidu.swan.apps.core.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.b.g;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/sConsole");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("ConsoleAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        boolean optBoolean;
        if (DEBUG) {
            Log.d("ConsoleAction", "handleSubAction subAction: " + str);
        }
        if (!com.baidu.swan.apps.console.a.Ja() && !com.baidu.swan.apps.console.c.Jd() && !TextUtils.equals(str, "/swanAPI/sConsole/debugSwitch")) {
            return super.e(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        char c = 65535;
        switch (str.hashCode()) {
            case -1923550429:
                if (str.equals("/swanAPI/sConsole/sanIncData2Console")) {
                    c = 3;
                    break;
                }
                break;
            case -1792428120:
                if (str.equals("/swanAPI/sConsole/sanFullData2Console")) {
                    c = 4;
                    break;
                }
                break;
            case -797920904:
                if (str.equals("/swanAPI/sConsole/hide")) {
                    c = 2;
                    break;
                }
                break;
            case -797593805:
                if (str.equals("/swanAPI/sConsole/show")) {
                    c = 1;
                    break;
                }
                break;
            case -161927599:
                if (str.equals("/swanAPI/sConsole/postMessage")) {
                    c = 6;
                    break;
                }
                break;
            case 1089933937:
                if (str.equals("/swanAPI/sConsole/debugSwitch")) {
                    c = 0;
                    break;
                }
                break;
            case 2136057821:
                if (str.equals("/swanAPI/sConsole/getSanDataFromActiveSlave")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (optParamsAsJo == null || (optBoolean = optParamsAsJo.optBoolean("enableDebug")) == com.baidu.swan.apps.console.a.Ja()) {
                    return true;
                }
                com.baidu.swan.apps.console.a.i(context, optBoolean);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.console.c.i("ConsoleAction", " sConsole switch：" + optParamsAsJo.optBoolean("enableDebug"));
                return true;
            case 1:
                f.UC().Ug().bO(true);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.console.c.i("ConsoleAction", "sConsole show");
                return true;
            case 2:
                f.UC().Ug().bO(false);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.console.c.i("ConsoleAction", "sConsole hide");
                return true;
            case 3:
                if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                    com.baidu.swan.apps.console.c.i("ConsoleAction", "send san inc data");
                    b.gC(optParamsAsJo.toString());
                    return true;
                }
                com.baidu.swan.apps.console.c.e("ConsoleAction", "san inc data is null");
                return true;
            case 4:
                if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                    com.baidu.swan.apps.console.c.i("ConsoleAction", "send san full data");
                    b.gB(optParamsAsJo.toString());
                    return true;
                }
                com.baidu.swan.apps.console.c.e("ConsoleAction", "san full data is null");
                return true;
            case 5:
                com.baidu.swan.apps.console.c.i("ConsoleAction", "request san full data");
                b.KW();
                return true;
            case 6:
                g.bx(optParamsAsJo);
                return true;
            default:
                return super.e(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
    }
}
