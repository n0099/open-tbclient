package com.baidu.swan.apps.console.debugger.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes11.dex */
public class b extends aa {
    public b(j jVar) {
        super(jVar, "/swanAPI/remoteDebug");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.d("RemoteDebugAction", "handle entity: " + unitedSchemeEntity.toString());
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("RemoteDebugAction", "handleSubAction subAction: " + str);
        if (!e.Xs()) {
            com.baidu.swan.apps.console.c.e("RemoteDebugAction", "Can't invoke this action outside Remote Debug mode");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        SwanAppActivity apG = com.baidu.swan.apps.runtime.d.apI().apG();
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
                if (apG != null) {
                    Intent intent = apG.getIntent();
                    e.Xu();
                    com.baidu.swan.apps.runtime.d.apI().v(new String[0]);
                    com.baidu.swan.apps.runtime.d.apI().d(intent.getExtras(), "update_tag_by_remote_debug");
                }
                return true;
            case 1:
                if (apG != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        apG.finishAndRemoveTask();
                    } else {
                        apG.finish();
                    }
                    System.exit(0);
                }
                return true;
            default:
                return super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
    }
}
