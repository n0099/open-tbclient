package com.baidu.swan.apps.view.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes9.dex */
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
        com.baidu.swan.apps.component.components.a.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!q.aoG()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse insert params, but invalid");
            return false;
        } else {
            String d = d(q.path, eVar);
            if (TextUtils.isEmpty(d)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                return false;
            }
            if (f.aDG().aDk()) {
                try {
                    new JSONObject(d);
                } catch (Throwable th) {
                    if (DEBUG) {
                        th.printStackTrace();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                    return false;
                }
            }
            com.baidu.swan.apps.component.b.c aow = new com.baidu.swan.apps.component.components.a.a(context, q, d).aow();
            boolean isSuccess = aow.isSuccess();
            c.i("AbsSwanAppWidget", "insert anim view success = " + isSuccess);
            if (isSuccess) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, aow.msg);
                c.e("AbsSwanAppWidget", "insert anim view, but failure: " + aow.msg);
            }
            return isSuccess;
        }
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        com.baidu.swan.apps.component.components.a.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!q.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse update params, but invalid");
            return false;
        } else {
            com.baidu.swan.apps.component.components.a.a aVar = (com.baidu.swan.apps.component.components.a.a) com.baidu.swan.apps.component.container.a.d(q);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.e("AbsSwanAppWidget", "get component is null");
                return false;
            }
            com.baidu.swan.apps.component.b.c a2 = aVar.a((com.baidu.swan.apps.component.components.a.a) q);
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
        com.baidu.swan.apps.component.components.a.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!q.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse remove params, but invalid");
            return false;
        } else {
            com.baidu.swan.apps.component.components.a.a aVar = (com.baidu.swan.apps.component.components.a.a) com.baidu.swan.apps.component.container.a.d(q);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.e("AbsSwanAppWidget", "get component is null");
                return false;
            }
            com.baidu.swan.apps.component.b.c aoy = aVar.aoy();
            boolean isSuccess = aoy.isSuccess();
            c.i("AbsSwanAppWidget", "remove anim view success = " + isSuccess);
            if (isSuccess) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return isSuccess;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, aoy.msg);
            c.e("AbsSwanAppWidget", "remove anim view, but failure: " + aoy.msg);
            return isSuccess;
        }
    }

    private String d(String str, e eVar) {
        String a2;
        if (TextUtils.isEmpty(str) || eVar == null) {
            return null;
        }
        try {
            if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                a2 = com.baidu.swan.apps.storage.b.cE(str, eVar.id);
            } else {
                a2 = com.baidu.swan.apps.storage.b.a(str, eVar, eVar.getVersion());
            }
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            File file = new File(a2);
            if (d.O(file)) {
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
    private com.baidu.swan.apps.component.components.a.b q(UnitedSchemeEntity unitedSchemeEntity) {
        com.baidu.swan.apps.component.components.a.b bVar = null;
        if (unitedSchemeEntity != null) {
            JSONObject m = m(unitedSchemeEntity);
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.e("SwanAppAction", "params is null");
            } else {
                bVar = new com.baidu.swan.apps.component.components.a.b();
                try {
                    bVar.parseFromJson(m);
                } catch (JSONException e) {
                    e.printStackTrace();
                    c.e("SwanAppAction", "model parse exception:", e);
                }
            }
        }
        return bVar;
    }
}
