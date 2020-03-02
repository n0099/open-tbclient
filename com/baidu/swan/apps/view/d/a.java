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
import com.baidu.swan.apps.y.f;
import java.io.File;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
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
        com.baidu.swan.apps.component.components.a.b s = s(unitedSchemeEntity);
        if (s == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!s.Gs()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse insert params, but invalid");
            return false;
        } else {
            String e = e(s.path, eVar);
            if (TextUtils.isEmpty(e)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                return false;
            }
            if (f.WS().Wx()) {
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
            com.baidu.swan.apps.component.b.c KF = new com.baidu.swan.apps.component.components.a.a(context, s, e).KF();
            boolean isSuccess = KF.isSuccess();
            c.i("AbsSwanAppWidget", "insert anim view success = " + isSuccess);
            if (isSuccess) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, KF.msg);
                c.e("AbsSwanAppWidget", "insert anim view, but failure: " + KF.msg);
            }
            return isSuccess;
        }
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        com.baidu.swan.apps.component.components.a.b s = s(unitedSchemeEntity);
        if (s == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!s.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse update params, but invalid");
            return false;
        } else {
            com.baidu.swan.apps.component.components.a.a aVar = (com.baidu.swan.apps.component.components.a.a) com.baidu.swan.apps.component.container.a.d(s);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.e("AbsSwanAppWidget", "get component is null");
                return false;
            }
            com.baidu.swan.apps.component.b.c a = aVar.a((com.baidu.swan.apps.component.components.a.a) s);
            boolean isSuccess = a.isSuccess();
            c.i("AbsSwanAppWidget", "update anim view success = " + isSuccess);
            if (isSuccess) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return isSuccess;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, a.msg);
            c.e("AbsSwanAppWidget", "update anim view, but failure: " + a.msg);
            return isSuccess;
        }
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        com.baidu.swan.apps.component.components.a.b s = s(unitedSchemeEntity);
        if (s == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!s.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse remove params, but invalid");
            return false;
        } else {
            com.baidu.swan.apps.component.components.a.a aVar = (com.baidu.swan.apps.component.components.a.a) com.baidu.swan.apps.component.container.a.d(s);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.e("AbsSwanAppWidget", "get component is null");
                return false;
            }
            com.baidu.swan.apps.component.b.c KH = aVar.KH();
            boolean isSuccess = KH.isSuccess();
            c.i("AbsSwanAppWidget", "remove anim view success = " + isSuccess);
            if (isSuccess) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return isSuccess;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, KH.msg);
            c.e("AbsSwanAppWidget", "remove anim view, but failure: " + KH.msg);
            return isSuccess;
        }
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        return false;
    }

    private String e(String str, e eVar) {
        String a;
        if (TextUtils.isEmpty(str) || eVar == null) {
            return null;
        }
        try {
            if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                a = com.baidu.swan.apps.storage.b.bp(str, eVar.id);
            } else {
                a = com.baidu.swan.apps.storage.b.a(str, eVar, eVar.getVersion());
            }
            if (TextUtils.isEmpty(a)) {
                return null;
            }
            File file = new File(a);
            if (com.baidu.swan.d.c.z(file)) {
                return com.baidu.swan.d.c.readFileData(file);
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
    private com.baidu.swan.apps.component.components.a.b s(UnitedSchemeEntity unitedSchemeEntity) {
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
