package com.baidu.swan.apps.media.d.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class b extends y {
    public b(j jVar) {
        super(jVar, "/swan/video");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar) {
        boolean n;
        c.d("VideoPlayerAction", "handleSubAction subAction : " + str);
        c.d("VideoPlayerAction", "params : " + c(unitedSchemeEntity, "params"));
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
                n = com.baidu.swan.apps.u.a.CJ().c(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 1:
                n = com.baidu.swan.apps.u.a.CJ().d(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 2:
                n = com.baidu.swan.apps.u.a.CJ().e(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 3:
                n = com.baidu.swan.apps.u.a.CJ().f(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 4:
                n = com.baidu.swan.apps.u.a.CJ().j(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 5:
                n = com.baidu.swan.apps.u.a.CJ().l(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 6:
                n = com.baidu.swan.apps.u.a.CJ().m(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            case 7:
                n = com.baidu.swan.apps.u.a.CJ().n(context, unitedSchemeEntity, callbackHandler, bVar);
                break;
            default:
                n = false;
                break;
        }
        return n || super.a(context, unitedSchemeEntity, callbackHandler, str, bVar);
    }
}
