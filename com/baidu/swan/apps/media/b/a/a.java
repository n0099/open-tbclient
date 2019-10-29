package com.baidu.swan.apps.media.b.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class a extends z {
    private static boolean aWf;

    public a(j jVar) {
        super(jVar, "/swan/live");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b bVar) {
        if (DEBUG) {
            Log.d("LivePlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b bVar) {
        if (DEBUG) {
            Log.d("LivePlayerAction", "handleSubAction subAction: " + str);
        }
        b(context, str, unitedSchemeEntity, callbackHandler, bVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    private boolean a(final Context context, String str, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final b bVar) {
        b QZ = b.QZ();
        if (QZ == null) {
            return false;
        }
        if (DEBUG && com.baidu.swan.apps.ac.a.a.NY()) {
            if (a(context, unitedSchemeEntity)) {
                com.baidu.swan.apps.u.a.Jw().f(context, unitedSchemeEntity, callbackHandler, bVar);
            }
        } else {
            QZ.Rd().a((Activity) context, "mapp_i_live_player", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.media.b.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: b */
                public void B(Boolean bool) {
                    boolean unused = a.aWf = bool.booleanValue();
                    if (bool.booleanValue()) {
                        c.i("live", "authorize success");
                        if (a.this.a(context, unitedSchemeEntity)) {
                            com.baidu.swan.apps.u.a.Jw().f(context, unitedSchemeEntity, callbackHandler, bVar);
                            return;
                        }
                        return;
                    }
                    c.i("live", "authorize fail");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(401));
                }
            });
        }
        return true;
    }

    private void b(Context context, String str, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b bVar) {
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
                com.baidu.swan.apps.u.a.Jw().c(context, unitedSchemeEntity, callbackHandler, bVar);
                if (!Me()) {
                    a(context, str, unitedSchemeEntity, callbackHandler, bVar);
                    return;
                } else if (a(context, unitedSchemeEntity)) {
                    com.baidu.swan.apps.u.a.Jw().f(context, unitedSchemeEntity, callbackHandler, bVar);
                    return;
                } else {
                    return;
                }
            case 1:
                com.baidu.swan.apps.u.a.Jw().d(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 2:
                com.baidu.swan.apps.u.a.Jw().e(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 3:
                if (Me()) {
                    com.baidu.swan.apps.u.a.Jw().f(context, unitedSchemeEntity, callbackHandler, bVar);
                    return;
                }
                return;
            case 4:
                com.baidu.swan.apps.u.a.Jw().g(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 5:
                com.baidu.swan.apps.u.a.Jw().h(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 6:
                com.baidu.swan.apps.u.a.Jw().i(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case 7:
                com.baidu.swan.apps.u.a.Jw().j(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            case '\b':
                com.baidu.swan.apps.u.a.Jw().k(context, unitedSchemeEntity, callbackHandler, bVar);
                return;
            default:
                return;
        }
    }

    private boolean Me() {
        return aWf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        if (context == null || unitedSchemeEntity == null) {
            return false;
        }
        return UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity).optBoolean("autoplay", false);
    }
}
