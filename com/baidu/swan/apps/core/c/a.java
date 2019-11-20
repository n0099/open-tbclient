package com.baidu.swan.apps.core.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.c.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.w.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/sConsole");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("ConsoleAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar) {
        boolean optBoolean;
        if (DEBUG) {
            Log.d("ConsoleAction", "handleSubAction subAction: " + str);
        }
        if (!com.baidu.swan.apps.console.a.Dd() && !com.baidu.swan.apps.console.c.Dg() && !TextUtils.equals(str, "/swan/sConsole/debugSwitch")) {
            return super.a(context, unitedSchemeEntity, callbackHandler, str, bVar);
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        char c = 65535;
        switch (str.hashCode()) {
            case -1742105685:
                if (str.equals("/swan/sConsole/debugSwitch")) {
                    c = 0;
                    break;
                }
                break;
            case -1379115294:
                if (str.equals("/swan/sConsole/sanFullData2Console")) {
                    c = 4;
                    break;
                }
                break;
            case 445086889:
                if (str.equals("/swan/sConsole/sanIncData2Console")) {
                    c = 3;
                    break;
                }
                break;
            case 1128561559:
                if (str.equals("/swan/sConsole/getSanDataFromActiveSlave")) {
                    c = 5;
                    break;
                }
                break;
            case 1301000075:
                if (str.equals("/swan/sConsole/postMessage")) {
                    c = 6;
                    break;
                }
                break;
            case 1874836862:
                if (str.equals("/swan/sConsole/hide")) {
                    c = 2;
                    break;
                }
                break;
            case 1875163961:
                if (str.equals("/swan/sConsole/show")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (optParamsAsJo == null || (optBoolean = optParamsAsJo.optBoolean("enableDebug")) == com.baidu.swan.apps.console.a.Dd()) {
                    return true;
                }
                h(context, optBoolean);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.console.c.i("ConsoleAction", " sConsole switch：" + optParamsAsJo.optBoolean("enableDebug"));
                return true;
            case 1:
                e.LE().Lk().bj(true);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.console.c.i("ConsoleAction", "sConsole show");
                return true;
            case 2:
                e.LE().Lk().bj(false);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.console.c.i("ConsoleAction", "sConsole hide");
                return true;
            case 3:
                if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                    com.baidu.swan.apps.console.c.i("ConsoleAction", "send san inc data");
                    b.er(optParamsAsJo.toString());
                    return true;
                }
                com.baidu.swan.apps.console.c.e("ConsoleAction", "san inc data is null");
                return true;
            case 4:
                if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                    com.baidu.swan.apps.console.c.i("ConsoleAction", "send san full data");
                    b.eq(optParamsAsJo.toString());
                    return true;
                }
                com.baidu.swan.apps.console.c.e("ConsoleAction", "san full data is null");
                return true;
            case 5:
                com.baidu.swan.apps.console.c.i("ConsoleAction", "request san full data");
                b.Eo();
                return true;
            case 6:
                com.baidu.swan.games.c.e.aQ(optParamsAsJo);
                return true;
            default:
                return super.a(context, unitedSchemeEntity, callbackHandler, str, bVar);
        }
    }

    private void h(final Context context, final boolean z) {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            c.a(Ra, context, new c.a() { // from class: com.baidu.swan.apps.core.c.a.1
                @Override // com.baidu.swan.apps.core.c.c.a
                public void d(boolean z2, String str) {
                    if (z2) {
                        com.baidu.swan.apps.console.a.h(context, z);
                    } else {
                        c.R(context, str);
                    }
                }
            });
        }
    }
}
