package com.baidu.swan.apps.media.c.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes7.dex */
public class b extends aa {
    private a ddW;
    private e ddX;
    private d ddY;

    public b(j jVar) {
        super(jVar, "/swanAPI/vrvideo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.d("VrVideoPlayerAction", "handle entity: ", unitedSchemeEntity);
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
        boolean a2;
        com.baidu.swan.apps.console.c.d("VrVideoPlayerAction", "handleSubAction subAction : " + str + "params : ", b(unitedSchemeEntity, "params"));
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
                if (this.ddW == null) {
                    this.ddW = new a("/swanAPI/vrvideo/open");
                }
                a2 = this.ddW.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.ddX == null) {
                    this.ddX = new e("/swanAPI/vrvideo/update");
                }
                a2 = this.ddX.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.ddY == null) {
                    this.ddY = new d("/swanAPI/vrvideo/remove");
                }
                a2 = this.ddY.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a2 = false;
                break;
        }
        return a2 || super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
