package com.baidu.swan.apps.media.d.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.z;
/* loaded from: classes2.dex */
public class f extends z {
    private c aDA;
    private k aDB;
    private e aDC;
    private d aDD;
    private i aDE;
    private b aDF;
    private j aDG;
    private h aDH;

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
                if (this.aDA == null) {
                    this.aDA = new c("/swan/video/open");
                }
                a = this.aDA.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 1:
                if (this.aDB == null) {
                    this.aDB = new k("/swan/video/update");
                }
                a = this.aDB.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 2:
                if (this.aDH == null) {
                    this.aDH = new h("/swan/video/remove");
                }
                a = this.aDH.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 3:
                if (this.aDC == null) {
                    this.aDC = new e("/swan/video/play");
                }
                a = this.aDC.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 4:
                if (this.aDD == null) {
                    this.aDD = new d("/swan/video/pause");
                }
                a = this.aDD.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 5:
                if (this.aDE == null) {
                    this.aDE = new i("/swan/video/seek");
                }
                a = this.aDE.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 6:
                if (this.aDF == null) {
                    this.aDF = new b("/swan/video/fullScreen");
                }
                a = this.aDF.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 7:
                if (this.aDG == null) {
                    this.aDG = new j("/swan/video/sendDanmu");
                }
                a = this.aDG.a(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            default:
                a = false;
                break;
        }
        return a || super.a(context, unitedSchemeEntity, callbackHandler, str, bVar);
    }
}
