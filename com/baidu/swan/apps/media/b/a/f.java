package com.baidu.swan.apps.media.b.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.aa;
/* loaded from: classes8.dex */
public class f extends aa {
    private c cCF;
    private k cCG;
    private e cCH;
    private d cCI;
    private i cCJ;
    private b cCK;
    private j cCL;
    private h cCM;

    public f(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/video");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
        boolean a;
        com.baidu.swan.apps.console.c.i("VideoPlayerAction", "handleSubAction subAction : " + str + "params : " + b(unitedSchemeEntity, "params"));
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
                if (this.cCF == null) {
                    this.cCF = new c("/swanAPI/video/open");
                }
                a = this.cCF.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.cCG == null) {
                    this.cCG = new k("/swanAPI/video/update");
                }
                a = this.cCG.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.cCM == null) {
                    this.cCM = new h("/swanAPI/video/remove");
                }
                a = this.cCM.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.cCH == null) {
                    this.cCH = new e("/swanAPI/video/play");
                }
                a = this.cCH.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.cCI == null) {
                    this.cCI = new d("/swanAPI/video/pause");
                }
                a = this.cCI.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.cCJ == null) {
                    this.cCJ = new i("/swanAPI/video/seek");
                }
                a = this.cCJ.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.cCK == null) {
                    this.cCK = new b("/swanAPI/video/fullScreen");
                }
                a = this.cCK.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.cCL == null) {
                    this.cCL = new j("/swanAPI/video/sendDanmu");
                }
                a = this.cCL.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a = false;
                break;
        }
        return a || super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
