package com.baidu.swan.apps.view.d;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.b;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.c.d;
import java.io.File;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends b {
    public a(j jVar) {
        super(jVar, "/swanAPI/animView");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    @NonNull
    public String getModuleName() {
        return "/swanAPI/animView";
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        com.baidu.swan.apps.component.components.a.b r = r(unitedSchemeEntity);
        if (r == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!r.adc()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse insert params, but invalid");
            return false;
        } else {
            String e = e(r.path, eVar);
            if (TextUtils.isEmpty(e)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                return false;
            }
            if (f.axo().awS()) {
                try {
                    new JSONObject(e);
                } catch (Throwable th) {
                    if (DEBUG) {
                        th.printStackTrace();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                    return false;
                }
            }
            com.baidu.swan.apps.component.b.c ain = new com.baidu.swan.apps.component.components.a.a(context, r, e).ain();
            boolean isSuccess = ain.isSuccess();
            c.i("AbsSwanAppWidget", "insert anim view success = " + isSuccess);
            if (isSuccess) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, ain.msg);
                c.e("AbsSwanAppWidget", "insert anim view, but failure: " + ain.msg);
            }
            return isSuccess;
        }
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        com.baidu.swan.apps.component.components.a.b r = r(unitedSchemeEntity);
        if (r == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!r.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse update params, but invalid");
            return false;
        } else {
            com.baidu.swan.apps.component.components.a.a aVar = (com.baidu.swan.apps.component.components.a.a) com.baidu.swan.apps.component.container.a.d(r);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.e("AbsSwanAppWidget", "get component is null");
                return false;
            }
            com.baidu.swan.apps.component.b.c a2 = aVar.a((com.baidu.swan.apps.component.components.a.a) r);
            boolean isSuccess = a2.isSuccess();
            c.d("AbsSwanAppWidget", "update anim view success = " + isSuccess);
            if (isSuccess) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return isSuccess;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, a2.msg);
            c.e("AbsSwanAppWidget", "update anim view, but failure: " + a2.msg);
            return isSuccess;
        }
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        com.baidu.swan.apps.component.components.a.b r = r(unitedSchemeEntity);
        if (r == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!r.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse remove params, but invalid");
            return false;
        } else {
            com.baidu.swan.apps.component.components.a.a aVar = (com.baidu.swan.apps.component.components.a.a) com.baidu.swan.apps.component.container.a.d(r);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.e("AbsSwanAppWidget", "get component is null");
                return false;
            }
            com.baidu.swan.apps.component.b.c aip = aVar.aip();
            boolean isSuccess = aip.isSuccess();
            c.i("AbsSwanAppWidget", "remove anim view success = " + isSuccess);
            if (isSuccess) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return isSuccess;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, aip.msg);
            c.e("AbsSwanAppWidget", "remove anim view, but failure: " + aip.msg);
            return isSuccess;
        }
    }

    private String e(String str, e eVar) {
        String a2;
        if (TextUtils.isEmpty(str) || eVar == null) {
            return null;
        }
        try {
            if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                a2 = com.baidu.swan.apps.storage.b.cz(str, eVar.id);
            } else {
                a2 = com.baidu.swan.apps.storage.b.a(str, eVar, eVar.getVersion());
            }
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            File file = new File(a2);
            if (d.M(file)) {
                return d.readFileData(file);
            }
            return null;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Nullable
    private com.baidu.swan.apps.component.components.a.b r(UnitedSchemeEntity unitedSchemeEntity) {
        com.baidu.swan.apps.component.components.a.b bVar = null;
        if (unitedSchemeEntity != null) {
            JSONObject n = n(unitedSchemeEntity);
            if (n == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.e("SwanAppAction", "params is null");
            } else {
                bVar = new com.baidu.swan.apps.component.components.a.b();
                try {
                    bVar.parseFromJson(n);
                } catch (JSONException e) {
                    e.printStackTrace();
                    c.e("SwanAppAction", "model parse exception:", e);
                }
            }
        }
        return bVar;
    }
}
