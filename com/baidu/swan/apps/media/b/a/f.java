package com.baidu.swan.apps.media.b.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.aa;
/* loaded from: classes8.dex */
public class f extends aa {
    private c dkH;
    private k dkI;
    private e dkJ;
    private d dkK;
    private i dkL;
    private b dkM;
    private j dkN;
    private h dkO;

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
        boolean a2;
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
                if (this.dkH == null) {
                    this.dkH = new c("/swanAPI/video/open");
                }
                a2 = this.dkH.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.dkI == null) {
                    this.dkI = new k("/swanAPI/video/update");
                }
                a2 = this.dkI.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.dkO == null) {
                    this.dkO = new h("/swanAPI/video/remove");
                }
                a2 = this.dkO.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.dkJ == null) {
                    this.dkJ = new e("/swanAPI/video/play");
                }
                a2 = this.dkJ.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.dkK == null) {
                    this.dkK = new d("/swanAPI/video/pause");
                }
                a2 = this.dkK.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.dkL == null) {
                    this.dkL = new i("/swanAPI/video/seek");
                }
                a2 = this.dkL.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.dkM == null) {
                    this.dkM = new b("/swanAPI/video/fullScreen");
                }
                a2 = this.dkM.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.dkN == null) {
                    this.dkN = new j("/swanAPI/video/sendDanmu");
                }
                a2 = this.dkN.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a2 = false;
                break;
        }
        return a2 || super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
