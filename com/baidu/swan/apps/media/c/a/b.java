package com.baidu.swan.apps.media.c.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes7.dex */
public class b extends aa {
    private a cvt;
    private e cvu;
    private d cvv;

    public b(j jVar) {
        super(jVar, "/swanAPI/vrvideo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.c("VrVideoPlayerAction", "handle entity: ", unitedSchemeEntity);
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
        boolean a;
        com.baidu.swan.apps.console.c.c("VrVideoPlayerAction", "handleSubAction subAction : " + str + "params : ", b(unitedSchemeEntity, "params"));
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
                if (this.cvt == null) {
                    this.cvt = new a("/swanAPI/vrvideo/open");
                }
                a = this.cvt.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.cvu == null) {
                    this.cvu = new e("/swanAPI/vrvideo/update");
                }
                a = this.cvu.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.cvv == null) {
                    this.cvv = new d("/swanAPI/vrvideo/remove");
                }
                a = this.cvv.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a = false;
                break;
        }
        return a || super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
