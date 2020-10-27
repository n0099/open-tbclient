package com.baidu.swan.apps.media.b.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.aa;
/* loaded from: classes10.dex */
public class f extends aa {
    private c cZj;
    private k cZk;
    private e cZl;
    private d cZm;
    private i cZn;
    private b cZo;
    private j cZp;
    private h cZq;

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
                if (this.cZj == null) {
                    this.cZj = new c("/swanAPI/video/open");
                }
                a2 = this.cZj.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.cZk == null) {
                    this.cZk = new k("/swanAPI/video/update");
                }
                a2 = this.cZk.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.cZq == null) {
                    this.cZq = new h("/swanAPI/video/remove");
                }
                a2 = this.cZq.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.cZl == null) {
                    this.cZl = new e("/swanAPI/video/play");
                }
                a2 = this.cZl.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.cZm == null) {
                    this.cZm = new d("/swanAPI/video/pause");
                }
                a2 = this.cZm.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.cZn == null) {
                    this.cZn = new i("/swanAPI/video/seek");
                }
                a2 = this.cZn.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.cZo == null) {
                    this.cZo = new b("/swanAPI/video/fullScreen");
                }
                a2 = this.cZo.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.cZp == null) {
                    this.cZp = new j("/swanAPI/video/sendDanmu");
                }
                a2 = this.cZp.a(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                a2 = false;
                break;
        }
        return a2 || super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
