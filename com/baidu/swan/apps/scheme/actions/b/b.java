package com.baidu.swan.apps.scheme.actions.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
import rx.d;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class b extends z {
    public b(j jVar) {
        super(jVar, "/swan/deleteHistory");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            c.e("history", "none swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty swanApp");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            c.e("history", "empty joParams");
            if (DEBUG) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty joParams");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.e("history", "empty cb");
            if (DEBUG) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty cb");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
            return false;
        }
        final String optString2 = optParamsAsJo.optString("appid");
        if (TextUtils.isEmpty(optString2)) {
            c.e("history", "empty appId");
            if (DEBUG) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty appId");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty appId");
            return false;
        } else if (!(context instanceof Activity)) {
            c.e("history", "error context");
            if (DEBUG) {
                Log.d("SwanAppAction", "RMSwanHistory --- the context is not an activity");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "the context is not an activity");
            return false;
        } else {
            bVar.Lu().a((Activity) context, "mapp_i_delete_history", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.scheme.actions.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    if (bool.booleanValue()) {
                        b.this.a(unitedSchemeEntity, callbackHandler, optString2, optString);
                        return;
                    }
                    c.e("history", "Permission denied");
                    if (b.DEBUG) {
                        Log.d("SwanAppAction", "RMSwanHistory --- Permission denied");
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied").toString());
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str, final String str2) {
        c.i("history", "start remove history");
        d.bl(str).b(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.scheme.actions.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: fm */
            public Boolean call(String str3) {
                return Boolean.valueOf(com.baidu.swan.apps.database.a.b.a(AppRuntime.getAppContext().getContentResolver(), str3, false));
            }
        }).a(rx.a.b.a.cLp()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.scheme.actions.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: c */
            public void call(Boolean bool) {
                com.baidu.swan.apps.ae.b Lq;
                com.baidu.swan.apps.process.messaging.client.a CR;
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(str) && (Lq = com.baidu.swan.apps.ae.b.Lq()) != null && (CR = Lq.CR()) != null) {
                        CR.a(8, new SwanAppDeleteInfo(str));
                    }
                    c.i("history", "remove success");
                    if (b.DEBUG) {
                        Log.d("SwanAppAction", "RMSwanHistory --- success & appid : " + str);
                    }
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), str2);
                    return;
                }
                c.w("history", "execute fail --- no match app id");
                if (b.DEBUG) {
                    Log.d("SwanAppAction", "RMSwanHistory --- no match app id");
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), str2);
            }
        });
    }
}
