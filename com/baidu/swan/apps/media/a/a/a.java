package com.baidu.swan.apps.media.a.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.d.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.c;
import com.baidu.swan.apps.setting.oauth.h;
/* loaded from: classes10.dex */
public class a extends ab {
    private static boolean bzl;

    public a(j jVar) {
        super(jVar, "/swanAPI/live");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("LivePlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("LivePlayerAction", "handleSubAction subAction: " + str);
        }
        b(context, str, unitedSchemeEntity, callbackHandler, eVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    private boolean a(final Context context, String str, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        e aap = e.aap();
        if (aap == null) {
            return false;
        }
        if (com.baidu.swan.apps.ah.a.a.Yf()) {
            if (a(context, unitedSchemeEntity)) {
                com.baidu.swan.apps.w.a.RU().f(context, unitedSchemeEntity, callbackHandler, eVar);
            }
        } else {
            aap.aaz().b(context, "mapp_i_live_player", new b<h<b.d>>() { // from class: com.baidu.swan.apps.media.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(h<b.d> hVar) {
                    boolean unused = a.bzl = c.b(hVar);
                    if (!a.bzl) {
                        c.a(hVar, callbackHandler, unitedSchemeEntity);
                        return;
                    }
                    com.baidu.swan.apps.console.c.i("live", "authorize success");
                    if (a.this.a(context, unitedSchemeEntity)) {
                        com.baidu.swan.apps.w.a.RU().f(context, unitedSchemeEntity, callbackHandler, eVar);
                    }
                }
            });
        }
        return true;
    }

    private void b(Context context, String str, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        char c = 65535;
        switch (str.hashCode()) {
            case -968032953:
                if (str.equals("/swanAPI/live/mute")) {
                    c = 5;
                    break;
                }
                break;
            case -967978632:
                if (str.equals("/swanAPI/live/open")) {
                    c = 0;
                    break;
                }
                break;
            case -967952798:
                if (str.equals("/swanAPI/live/play")) {
                    c = 3;
                    break;
                }
                break;
            case -967855312:
                if (str.equals("/swanAPI/live/stop")) {
                    c = 4;
                    break;
                }
                break;
            case 57925768:
                if (str.equals("/swanAPI/live/pause")) {
                    c = 7;
                    break;
                }
                break;
            case 708868233:
                if (str.equals("/swanAPI/live/fullScreen")) {
                    c = 6;
                    break;
                }
                break;
            case 1856409650:
                if (str.equals("/swanAPI/live/remove")) {
                    c = 2;
                    break;
                }
                break;
            case 1856593883:
                if (str.equals("/swanAPI/live/resume")) {
                    c = '\b';
                    break;
                }
                break;
            case 1952174199:
                if (str.equals("/swanAPI/live/update")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                com.baidu.swan.apps.w.a.RU().c(context, unitedSchemeEntity, callbackHandler, eVar);
                if (!VB()) {
                    a(context, str, unitedSchemeEntity, callbackHandler, eVar);
                    return;
                } else if (a(context, unitedSchemeEntity)) {
                    com.baidu.swan.apps.w.a.RU().f(context, unitedSchemeEntity, callbackHandler, eVar);
                    return;
                } else {
                    return;
                }
            case 1:
                com.baidu.swan.apps.w.a.RU().d(context, unitedSchemeEntity, callbackHandler, eVar);
                return;
            case 2:
                com.baidu.swan.apps.w.a.RU().e(context, unitedSchemeEntity, callbackHandler, eVar);
                return;
            case 3:
                if (VB()) {
                    com.baidu.swan.apps.w.a.RU().f(context, unitedSchemeEntity, callbackHandler, eVar);
                    return;
                }
                return;
            case 4:
                com.baidu.swan.apps.w.a.RU().g(context, unitedSchemeEntity, callbackHandler, eVar);
                return;
            case 5:
                com.baidu.swan.apps.w.a.RU().h(context, unitedSchemeEntity, callbackHandler, eVar);
                return;
            case 6:
                com.baidu.swan.apps.w.a.RU().i(context, unitedSchemeEntity, callbackHandler, eVar);
                return;
            case 7:
                com.baidu.swan.apps.w.a.RU().j(context, unitedSchemeEntity, callbackHandler, eVar);
                return;
            case '\b':
                com.baidu.swan.apps.w.a.RU().k(context, unitedSchemeEntity, callbackHandler, eVar);
                return;
            default:
                return;
        }
    }

    private boolean VB() {
        if (com.baidu.swan.apps.ah.a.a.Yf()) {
            return true;
        }
        return bzl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        if (context == null || unitedSchemeEntity == null) {
            return false;
        }
        return UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity).optBoolean("autoplay", false);
    }
}
