package com.baidu.swan.apps.scheme.actions.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends y {
    public static final String aPQ = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";
    public static final String aPR = SchemeConfig.getSchemeHead() + "://swangame/%s";

    /* renamed from: com.baidu.swan.apps.scheme.actions.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0165a {
        void ab(JSONObject jSONObject);
    }

    public a(j jVar) {
        super(jVar, "/swan/getHistory");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            c.e("history", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
                return false;
            }
            return false;
        }
        final String optString = n.dm(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.e("history", "none cb");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!(context instanceof Activity)) {
            c.e("history", "error context");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- the context is not an activity");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "the context is not an activity");
            return false;
        } else {
            bVar.IZ().a((Activity) context, "mapp_i_get_history", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.swan.apps.scheme.actions.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    if (bool.booleanValue()) {
                        a.this.b(unitedSchemeEntity, callbackHandler, optString);
                        return;
                    }
                    c.e("history", "permission denied");
                    if (a.DEBUG) {
                        Log.d("SwanAppAction", "getSwanHistory --- permission denied");
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied").toString());
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str) {
        c.i("history", "start get history");
        com.baidu.swan.apps.database.a.b.a(new InterfaceC0165a() { // from class: com.baidu.swan.apps.scheme.actions.c.a.2
            @Override // com.baidu.swan.apps.scheme.actions.c.a.InterfaceC0165a
            public void ab(JSONObject jSONObject) {
                if (jSONObject == null || jSONObject.length() == 0) {
                    c.i("history", "none history");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(null, 0).toString(), str);
                    return;
                }
                c.i("history", "get history :" + jSONObject.toString());
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), str);
            }
        });
    }
}
