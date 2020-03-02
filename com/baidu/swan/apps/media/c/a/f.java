package com.baidu.swan.apps.media.c.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.ab;
/* loaded from: classes11.dex */
public class f extends ab {
    private c bEC;
    private k bED;
    private e bEE;
    private d bEF;
    private i bEG;
    private b bEH;
    private j bEI;
    private h bEJ;

    public f(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/video");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
        boolean a;
        com.baidu.swan.apps.console.c.d("VideoPlayerAction", "handleSubAction subAction : " + str);
        com.baidu.swan.apps.console.c.d("VideoPlayerAction", "params : " + b(unitedSchemeEntity, "params"));
        char c = 65535;
        switch (str.hashCode()) {
            case -1701478259:
                if (str.equals("/swanAPI/video/pause")) {
                    c = 4;
                    break;
                }
                break;
            case -1440375597:
                if (str.equals("/swanAPI/video/open")) {
                    c = 0;
                    break;
                }
                break;
            case -1440349763:
                if (str.equals("/swanAPI/video/play")) {
                    c = 3;
                    break;
                }
                break;
            case -1440267007:
                if (str.equals("/swanAPI/video/seek")) {
                    c = 5;
                    break;
                }
                break;
            case -1145507635:
                if (str.equals("/swanAPI/video/remove")) {
                    c = 2;
                    break;
                }
                break;
            case -1049743086:
                if (str.equals("/swanAPI/video/update")) {
                    c = 1;
                    break;
                }
                break;
            case -274000988:
                if (str.equals("/swanAPI/video/fullScreen")) {
                    c = 6;
                    break;
                }
                break;
            case 711122280:
                if (str.equals("/swanAPI/video/sendDanmu")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (this.bEC == null) {
                    this.bEC = new c("/swanAPI/video/open");
                }
                a = this.bEC.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.bED == null) {
                    this.bED = new k("/swanAPI/video/update");
                }
                a = this.bED.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.bEJ == null) {
                    this.bEJ = new h("/swanAPI/video/remove");
                }
                a = this.bEJ.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.bEE == null) {
                    this.bEE = new e("/swanAPI/video/play");
                }
                a = this.bEE.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.bEF == null) {
                    this.bEF = new d("/swanAPI/video/pause");
                }
                a = this.bEF.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.bEG == null) {
                    this.bEG = new i("/swanAPI/video/seek");
                }
                a = this.bEG.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.bEH == null) {
                    this.bEH = new b("/swanAPI/video/fullScreen");
                }
                a = this.bEH.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.bEI == null) {
                    this.bEI = new j("/swanAPI/video/sendDanmu");
                }
                a = this.bEI.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a = false;
                break;
        }
        return a || super.e(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
