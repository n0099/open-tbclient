package com.baidu.swan.apps.media.c.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.ab;
/* loaded from: classes10.dex */
public class f extends ab {
    private b bAA;
    private j bAB;
    private h bAC;
    private c bAv;
    private k bAw;
    private e bAx;
    private d bAy;
    private i bAz;

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
                if (this.bAv == null) {
                    this.bAv = new c("/swanAPI/video/open");
                }
                a = this.bAv.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.bAw == null) {
                    this.bAw = new k("/swanAPI/video/update");
                }
                a = this.bAw.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.bAC == null) {
                    this.bAC = new h("/swanAPI/video/remove");
                }
                a = this.bAC.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.bAx == null) {
                    this.bAx = new e("/swanAPI/video/play");
                }
                a = this.bAx.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.bAy == null) {
                    this.bAy = new d("/swanAPI/video/pause");
                }
                a = this.bAy.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.bAz == null) {
                    this.bAz = new i("/swanAPI/video/seek");
                }
                a = this.bAz.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.bAA == null) {
                    this.bAA = new b("/swanAPI/video/fullScreen");
                }
                a = this.bAA.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.bAB == null) {
                    this.bAB = new j("/swanAPI/video/sendDanmu");
                }
                a = this.bAB.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a = false;
                break;
        }
        return a || super.e(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
