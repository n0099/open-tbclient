package com.baidu.swan.apps.media.c.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.ab;
/* loaded from: classes11.dex */
public class f extends ab {
    private c cdD;
    private k cdE;
    private e cdF;
    private d cdG;
    private i cdH;
    private b cdI;
    private j cdJ;
    private h cdK;

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
                if (this.cdD == null) {
                    this.cdD = new c("/swanAPI/video/open");
                }
                a = this.cdD.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.cdE == null) {
                    this.cdE = new k("/swanAPI/video/update");
                }
                a = this.cdE.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.cdK == null) {
                    this.cdK = new h("/swanAPI/video/remove");
                }
                a = this.cdK.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.cdF == null) {
                    this.cdF = new e("/swanAPI/video/play");
                }
                a = this.cdF.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.cdG == null) {
                    this.cdG = new d("/swanAPI/video/pause");
                }
                a = this.cdG.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.cdH == null) {
                    this.cdH = new i("/swanAPI/video/seek");
                }
                a = this.cdH.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.cdI == null) {
                    this.cdI = new b("/swanAPI/video/fullScreen");
                }
                a = this.cdI.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.cdJ == null) {
                    this.cdJ = new j("/swanAPI/video/sendDanmu");
                }
                a = this.cdJ.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a = false;
                break;
        }
        return a || super.e(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
