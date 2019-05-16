package com.baidu.swan.apps.media.d.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.z;
/* loaded from: classes2.dex */
public class f extends z {
    private c aCS;
    private k aCT;
    private e aCU;
    private d aCV;
    private i aCW;
    private b aCX;
    private j aCY;
    private h aCZ;

    public f(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/video");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar) {
        boolean a;
        com.baidu.swan.apps.console.c.d("VideoPlayerAction", "handleSubAction subAction : " + str);
        com.baidu.swan.apps.console.c.d("VideoPlayerAction", "params : " + c(unitedSchemeEntity, "params"));
        char c = 65535;
        switch (str.hashCode()) {
            case -546094626:
                if (str.equals("/swan/video/fullScreen")) {
                    c = 6;
                    break;
                }
                break;
            case 603278343:
                if (str.equals("/swan/video/remove")) {
                    c = 2;
                    break;
                }
                break;
            case 699042892:
                if (str.equals("/swan/video/update")) {
                    c = 1;
                    break;
                }
                break;
            case 840892398:
                if (str.equals("/swan/video/sendDanmu")) {
                    c = 7;
                    break;
                }
                break;
            case 1680070163:
                if (str.equals("/swan/video/pause")) {
                    c = 4;
                    break;
                }
                break;
            case 1716747917:
                if (str.equals("/swan/video/open")) {
                    c = 0;
                    break;
                }
                break;
            case 1716773751:
                if (str.equals("/swan/video/play")) {
                    c = 3;
                    break;
                }
                break;
            case 1716856507:
                if (str.equals("/swan/video/seek")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (this.aCS == null) {
                    this.aCS = new c("/swan/video/open");
                }
                a = this.aCS.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 1:
                if (this.aCT == null) {
                    this.aCT = new k("/swan/video/update");
                }
                a = this.aCT.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 2:
                if (this.aCZ == null) {
                    this.aCZ = new h("/swan/video/remove");
                }
                a = this.aCZ.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 3:
                if (this.aCU == null) {
                    this.aCU = new e("/swan/video/play");
                }
                a = this.aCU.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 4:
                if (this.aCV == null) {
                    this.aCV = new d("/swan/video/pause");
                }
                a = this.aCV.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 5:
                if (this.aCW == null) {
                    this.aCW = new i("/swan/video/seek");
                }
                a = this.aCW.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 6:
                if (this.aCX == null) {
                    this.aCX = new b("/swan/video/fullScreen");
                }
                a = this.aCX.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 7:
                if (this.aCY == null) {
                    this.aCY = new j("/swan/video/sendDanmu");
                }
                a = this.aCY.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            default:
                a = false;
                break;
        }
        return a || super.a(context, unitedSchemeEntity, callbackHandler, str, bVar);
    }
}
