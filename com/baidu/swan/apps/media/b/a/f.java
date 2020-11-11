package com.baidu.swan.apps.media.b.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.aa;
/* loaded from: classes10.dex */
public class f extends aa {
    private c dfg;
    private k dfh;
    private e dfi;
    private d dfj;
    private i dfk;
    private b dfl;
    private j dfm;
    private h dfn;

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
                if (this.dfg == null) {
                    this.dfg = new c("/swanAPI/video/open");
                }
                a2 = this.dfg.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.dfh == null) {
                    this.dfh = new k("/swanAPI/video/update");
                }
                a2 = this.dfh.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.dfn == null) {
                    this.dfn = new h("/swanAPI/video/remove");
                }
                a2 = this.dfn.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.dfi == null) {
                    this.dfi = new e("/swanAPI/video/play");
                }
                a2 = this.dfi.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.dfj == null) {
                    this.dfj = new d("/swanAPI/video/pause");
                }
                a2 = this.dfj.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.dfk == null) {
                    this.dfk = new i("/swanAPI/video/seek");
                }
                a2 = this.dfk.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.dfl == null) {
                    this.dfl = new b("/swanAPI/video/fullScreen");
                }
                a2 = this.dfl.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.dfm == null) {
                    this.dfm = new j("/swanAPI/video/sendDanmu");
                }
                a2 = this.dfm.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a2 = false;
                break;
        }
        return a2 || super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
