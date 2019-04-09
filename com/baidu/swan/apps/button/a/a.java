package com.baidu.swan.apps.button.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.button.container.button.SwanAppNativeButtonContainer;
import com.baidu.swan.apps.button.view.button.SwanAppNativeButton;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends y {
    public a(j jVar) {
        super(jVar, "/swan/button");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b bVar) {
        if (DEBUG) {
            Log.d("SwanAppNativeButton", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b bVar) {
        if (DEBUG) {
            Log.i("SwanAppNativeButton", "handleSubAction subAction: " + str);
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            c.e("SwanAppNativeButton", "no params json");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        if (DEBUG) {
            Log.i("SwanAppNativeButton", "handleSubAction params: " + unitedSchemeEntity.getParam("params"));
        }
        com.baidu.swan.apps.button.b.a.a x = x(optParamsAsJo);
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        AbsoluteLayout eP = aa.eP(x.aBH);
        if (eP == null) {
            c.e("SwanAppNativeButton", "can not find webView by #" + x.aBH);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return a(str, context, x, eP, unitedSchemeEntity, callbackHandler);
    }

    private boolean a(String str, Context context, @NonNull com.baidu.swan.apps.button.b.a.a aVar, @NonNull AbsoluteLayout absoluteLayout, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2125853582:
                if (str.equals("/swan/button/remove")) {
                    c = 2;
                    break;
                }
                break;
            case -2030089033:
                if (str.equals("/swan/button/update")) {
                    c = 1;
                    break;
                }
                break;
            case 1919932071:
                if (str.equals("/swan/button/insert")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return a(context, aVar, absoluteLayout, unitedSchemeEntity, callbackHandler);
            case 1:
                return b(context, aVar, absoluteLayout, unitedSchemeEntity, callbackHandler);
            case 2:
                return c(context, aVar, absoluteLayout, unitedSchemeEntity, callbackHandler);
            default:
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
        }
    }

    private boolean a(Context context, @NonNull com.baidu.swan.apps.button.b.a.a aVar, @NonNull AbsoluteLayout absoluteLayout, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        com.baidu.swan.apps.model.a.a.b bVar = aVar.aBJ;
        if (bVar == null || !bVar.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        SwanAppNativeButton swanAppNativeButton = new SwanAppNativeButton(context);
        swanAppNativeButton.a(aVar);
        boolean a = new SwanAppNativeButtonContainer(context).a((SwanAppNativeButtonContainer) swanAppNativeButton);
        if (a) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return a;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return a;
    }

    private boolean b(Context context, @NonNull com.baidu.swan.apps.button.b.a.a aVar, @NonNull AbsoluteLayout absoluteLayout, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        com.baidu.swan.apps.model.a.a.b bVar = aVar.aBJ;
        if (bVar == null || !bVar.isValid()) {
            c.e("SwanAppNativeButton", "position not valid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (!(a instanceof SwanAppNativeButtonContainer)) {
            if (DEBUG) {
                throw new RuntimeException("update button with illegal container: not a SwanAppNativeButtonContainer");
            }
            c.e("SwanAppNativeButton", "can't find button:#" + aVar.id);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        boolean a2 = ((SwanAppNativeButtonContainer) a).a((SwanAppNativeButtonContainer) aVar);
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return a2;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return a2;
    }

    private boolean c(Context context, @NonNull com.baidu.swan.apps.button.b.a.a aVar, @NonNull AbsoluteLayout absoluteLayout, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (!(a instanceof SwanAppNativeButtonContainer)) {
            if (DEBUG) {
                throw new RuntimeException("remove button with illegal container: not a SwanAppNativeButtonContainer");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        boolean MI = ((SwanAppNativeButtonContainer) a).MI();
        if (MI) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return MI;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return MI;
    }

    private com.baidu.swan.apps.button.b.a.a x(@NonNull JSONObject jSONObject) {
        com.baidu.swan.apps.button.b.a.a aVar = new com.baidu.swan.apps.button.b.a.a();
        try {
            aVar.parseFromJson(jSONObject);
        } catch (JSONException e) {
            c.e("SwanAppNativeButton", "model parse exception:", e);
        }
        return aVar;
    }
}
