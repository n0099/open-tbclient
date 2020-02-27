package com.baidu.swan.apps.console.debugger.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes11.dex */
public class b extends ab {
    public b(j jVar) {
        super(jVar, "/swanAPI/remoteDebug");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.d("RemoteDebugAction", "handle entity: " + unitedSchemeEntity.toString());
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("RemoteDebugAction", "handleSubAction subAction: " + str);
        if (!e.LN()) {
            com.baidu.swan.apps.console.c.e("RemoteDebugAction", "Can't invoke this action outside Remote Debug mode");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        SwanAppActivity acz = com.baidu.swan.apps.runtime.d.acA().acz();
        char c = 65535;
        switch (str.hashCode()) {
            case -279631955:
                if (str.equals("/swanAPI/remoteDebug/shutdown")) {
                    c = 1;
                    break;
                }
                break;
            case 1013845168:
                if (str.equals("/swanAPI/remoteDebug/reload")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                com.baidu.swan.apps.console.c.i("RemoteDebugAction", "Remote Debug reload");
                if (acz != null) {
                    Intent intent = acz.getIntent();
                    e.LP();
                    com.baidu.swan.apps.runtime.d.acA().v(new String[0]);
                    com.baidu.swan.apps.runtime.d.acA().c(intent.getExtras(), "update_tag_by_remote_debug");
                }
                return true;
            case 1:
                if (acz != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        acz.finishAndRemoveTask();
                    } else {
                        acz.finish();
                    }
                    System.exit(0);
                }
                return true;
            default:
                return super.e(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
    }
}
