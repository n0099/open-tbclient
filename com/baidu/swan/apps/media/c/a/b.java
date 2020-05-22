package com.baidu.swan.apps.media.c.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes11.dex */
public class b extends aa {
    private a coC;
    private e coD;
    private d coE;

    public b(j jVar) {
        super(jVar, "/swanAPI/vrvideo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("VrVideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
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
                if (this.coC == null) {
                    this.coC = new a("/swanAPI/vrvideo/open");
                }
                a = this.coC.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.coD == null) {
                    this.coD = new e("/swanAPI/vrvideo/update");
                }
                a = this.coD.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.coE == null) {
                    this.coE = new d("/swanAPI/vrvideo/remove");
                }
                a = this.coE.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a = false;
                break;
        }
        return a || super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
