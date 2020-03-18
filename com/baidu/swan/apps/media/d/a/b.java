package com.baidu.swan.apps.media.d.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes11.dex */
public class b extends ab {
    private a bFi;
    private e bFj;
    private d bFk;

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
                if (this.bFi == null) {
                    this.bFi = new a("/swanAPI/vrvideo/open");
                }
                a = this.bFi.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.bFj == null) {
                    this.bFj = new e("/swanAPI/vrvideo/update");
                }
                a = this.bFj.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.bFk == null) {
                    this.bFk = new d("/swanAPI/vrvideo/remove");
                }
                a = this.bFk.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a = false;
                break;
        }
        return a || super.e(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
