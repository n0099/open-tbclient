package com.baidu.swan.apps.media.d.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes11.dex */
public class b extends ab {
    private a cdR;
    private e cdS;
    private d cdT;

    public b(j jVar) {
        super(jVar, "/swanAPI/vrvideo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("VrVideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
        boolean a;
        com.baidu.swan.apps.console.c.d("VrVideoPlayerAction", "handleSubAction subAction : " + str);
        com.baidu.swan.apps.console.c.d("VrVideoPlayerAction", "params : " + b(unitedSchemeEntity, "params"));
        char c = 65535;
        switch (str.hashCode()) {
            case 533456719:
                if (str.equals("/swanAPI/vrvideo/open")) {
                    c = 0;
                    break;
                }
                break;
            case 1626770505:
                if (str.equals("/swanAPI/vrvideo/remove")) {
                    c = 2;
                    break;
                }
                break;
            case 1722535054:
                if (str.equals("/swanAPI/vrvideo/update")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (this.cdR == null) {
                    this.cdR = new a("/swanAPI/vrvideo/open");
                }
                a = this.cdR.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.cdS == null) {
                    this.cdS = new e("/swanAPI/vrvideo/update");
                }
                a = this.cdS.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.cdT == null) {
                    this.cdT = new d("/swanAPI/vrvideo/remove");
                }
                a = this.cdT.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a = false;
                break;
        }
        return a || super.e(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
