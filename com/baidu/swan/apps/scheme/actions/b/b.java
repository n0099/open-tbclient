package com.baidu.swan.apps.scheme.actions.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public abstract class b extends y {
    protected String aPP;
    protected String mCallback;

    protected abstract void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    protected abstract boolean k(UnitedSchemeEntity unitedSchemeEntity);

    public b(j jVar, String str) {
        super(jVar, str);
        this.mCallback = null;
        this.aPP = null;
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public final boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e("favorite", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
                return false;
            }
            return false;
        }
        this.mCallback = n.dm(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            com.baidu.swan.apps.console.c.e("favorite", "none cb");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!(context instanceof Activity)) {
            com.baidu.swan.apps.console.c.e("favorite", "error context");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- the context is not an activity");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "the context is not an activity");
            return false;
        } else if (!k(unitedSchemeEntity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params error");
            return false;
        } else {
            bVar.IZ().a((Activity) context, "mapp_favorite", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.swan.apps.scheme.actions.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    if (!bool.booleanValue()) {
                        com.baidu.swan.apps.console.c.e("favorite", "permission denied");
                        if (b.DEBUG) {
                            Log.d("SwanAppAction", "getSwanHistory --- permission denied");
                        }
                        callbackHandler.handleSchemeDispatchCallback(b.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied").toString());
                        return;
                    }
                    b.this.a(unitedSchemeEntity, callbackHandler, b.this.mCallback);
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
