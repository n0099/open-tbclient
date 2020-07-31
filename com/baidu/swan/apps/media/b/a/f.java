package com.baidu.swan.apps.media.b.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.aa;
/* loaded from: classes7.dex */
public class f extends aa {
    private c cuV;
    private k cuW;
    private e cuX;
    private d cuY;
    private i cuZ;
    private b cva;
    private j cvb;
    private h cvc;

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
                if (this.cuV == null) {
                    this.cuV = new c("/swanAPI/video/open");
                }
                a = this.cuV.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.cuW == null) {
                    this.cuW = new k("/swanAPI/video/update");
                }
                a = this.cuW.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.cvc == null) {
                    this.cvc = new h("/swanAPI/video/remove");
                }
                a = this.cvc.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.cuX == null) {
                    this.cuX = new e("/swanAPI/video/play");
                }
                a = this.cuX.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.cuY == null) {
                    this.cuY = new d("/swanAPI/video/pause");
                }
                a = this.cuY.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.cuZ == null) {
                    this.cuZ = new i("/swanAPI/video/seek");
                }
                a = this.cuZ.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.cva == null) {
                    this.cva = new b("/swanAPI/video/fullScreen");
                }
                a = this.cva.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.cvb == null) {
                    this.cvb = new j("/swanAPI/video/sendDanmu");
                }
                a = this.cvb.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a = false;
                break;
        }
        return a || super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
