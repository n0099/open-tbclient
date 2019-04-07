package com.baidu.swan.apps.media.b.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class a extends y {
    private static boolean aAM;

    public a(j jVar) {
        super(jVar, "/swan/live");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b bVar) {
        if (DEBUG) {
            Log.d("LivePlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b bVar) {
        if (DEBUG) {
            Log.d("LivePlayerAction", "handleSubAction subAction: " + str);
        }
        if (!EA()) {
            if (a(context, str, unitedSchemeEntity, callbackHandler, bVar)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            return super.a(context, unitedSchemeEntity, callbackHandler, str, bVar);
        }
        c.d("live", "has been authorized successful!");
        b(context, str, unitedSchemeEntity, callbackHandler, bVar);
        return true;
    }

    private boolean a(final Context context, final String str, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final b bVar) {
        b IV = b.IV();
        if (IV == null) {
            return false;
        }
        if (DEBUG && com.baidu.swan.apps.ac.a.a.Ge()) {
            b(context, str, unitedSchemeEntity, callbackHandler, bVar);
        } else {
            IV.IZ().a((Activity) context, "mapp_i_live_player", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.swan.apps.media.b.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    boolean unused = a.aAM = bool.booleanValue();
                    if (bool.booleanValue()) {
                        c.i("live", "authorize success");
                        a.this.b(context, str, unitedSchemeEntity, callbackHandler, bVar);
                        return;
                    }
                    c.i("live", "authorize fail");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(401));
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b bVar) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1079918014:
                if (str.equals("/swan/live/pause")) {
                    c = 7;
                    break;
                }
                break;
            case -866190259:
                if (str.equals("/swan/live/mute")) {
                    c = 5;
                    break;
                }
                break;
            case -866135938:
                if (str.equals("/swan/live/open")) {
                    c = 0;
                    break;
                }
                break;
            case -866110104:
                if (str.equals("/swan/live/play")) {
                    c = 3;
                    break;
                }
                break;
            case -866012618:
                if (str.equals("/swan/live/stop")) {
                    c = 4;
                    break;
                }
                break;
            case 838638351:
                if (str.equals("/swan/live/fullScreen")) {
                    c = 6;
                    break;
                }
                break;
            case 942990776:
                if (str.equals("/swan/live/remove")) {
                    c = 2;
                    break;
                }
                break;
            case 943175009:
                if (str.equals("/swan/live/resume")) {
                    c = '\b';
                    break;
                }
                break;
            case 1038755325:
                if (str.equals("/swan/live/update")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                com.baidu.swan.apps.u.a.CK().c(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 1:
                com.baidu.swan.apps.u.a.CK().d(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 2:
                com.baidu.swan.apps.u.a.CK().e(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 3:
                com.baidu.swan.apps.u.a.CK().f(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 4:
                com.baidu.swan.apps.u.a.CK().g(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 5:
                com.baidu.swan.apps.u.a.CK().h(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 6:
                com.baidu.swan.apps.u.a.CK().i(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 7:
                com.baidu.swan.apps.u.a.CK().j(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case '\b':
                com.baidu.swan.apps.u.a.CK().k(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            default:
                return;
        }
    }

    private boolean EA() {
        return aAM;
    }
}
