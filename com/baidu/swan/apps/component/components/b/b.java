package com.baidu.swan.apps.component.components.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.scheme.actions.b {
    public b(j jVar) {
        super(jVar, "/swanAPI/button");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    @NonNull
    public String getModuleName() {
        return "/swanAPI/button";
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("Component-Action-Button", "insert");
        }
        c j = j(unitedSchemeEntity);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-Button", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.b.c WT = new a(context, j).WT();
        boolean isSuccess = WT.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, WT.msg);
        }
        return isSuccess;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("Component-Action-Button", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        c j = j(unitedSchemeEntity);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-Button", "model is null");
            return false;
        }
        a aVar = (a) com.baidu.swan.apps.component.container.a.d(j);
        if (aVar == null) {
            String str2 = "can't find button component:#" + j.bVl;
            com.baidu.swan.apps.console.c.e("Component-Action-Button", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c a = aVar.a((a) j);
        boolean isSuccess = a.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return isSuccess;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, a.msg);
        return isSuccess;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("Component-Action-Button", "remove");
        }
        c j = j(unitedSchemeEntity);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-Button", "model is null");
            return false;
        }
        a aVar = (a) com.baidu.swan.apps.component.container.a.d(j);
        if (aVar == null) {
            String str2 = "can't find button component:#" + j.bVl;
            com.baidu.swan.apps.console.c.e("Component-Action-Button", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c WV = aVar.WV();
        boolean isSuccess = WV.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return isSuccess;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, WV.msg);
        return isSuccess;
    }

    @Nullable
    private c j(UnitedSchemeEntity unitedSchemeEntity) {
        c cVar = null;
        if (unitedSchemeEntity != null) {
            JSONObject n = n(unitedSchemeEntity);
            if (n == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                com.baidu.swan.apps.console.c.e("Component-Action-Button", "params is null");
            } else {
                cVar = new c();
                try {
                    cVar.parseFromJson(n);
                } catch (JSONException e) {
                    e.printStackTrace();
                    com.baidu.swan.apps.console.c.e("Component-Action-Button", "model parse exception:", e);
                }
            }
        }
        return cVar;
    }
}
