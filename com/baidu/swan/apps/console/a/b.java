package com.baidu.swan.apps.console.a;

import android.content.Context;
import android.os.Build;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class b extends z {
    public b(j jVar) {
        super(jVar, "/swan/remoteDebug");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.console.c.d("RemoteDebugAction", "handle entity: " + unitedSchemeEntity.toString());
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.console.c.i("RemoteDebugAction", "handleSubAction subAction: " + str);
        if (!d.Dk()) {
            com.baidu.swan.apps.console.c.e("RemoteDebugAction", "Can't invoke this action outside Remote Debug mode");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        SwanAppActivity Lp = e.LD().Lp();
        char c = 65535;
        switch (str.hashCode()) {
            case 1183295719:
                if (str.equals("/swan/remoteDebug/shutdown")) {
                    c = 1;
                    break;
                }
                break;
            case 1524864106:
                if (str.equals("/swan/remoteDebug/reload")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                com.baidu.swan.apps.console.c.i("RemoteDebugAction", "Remote Debug reload");
                if (Lp != null) {
                    Lp.recreate();
                }
                return true;
            case 1:
                if (Lp != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        Lp.finishAndRemoveTask();
                    } else {
                        Lp.finish();
                    }
                    System.exit(0);
                }
                return true;
            default:
                return super.a(context, unitedSchemeEntity, callbackHandler, str, bVar);
        }
    }
}
