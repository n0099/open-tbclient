package com.baidu.swan.apps.component.components.b;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
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
        c i = i(unitedSchemeEntity);
        if (i == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-Button", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.b.c aow = new a(context, i).aow();
        boolean isSuccess = aow.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, aow.msg);
        }
        return isSuccess;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("Component-Action-Button", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        c i = i(unitedSchemeEntity);
        if (i == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-Button", "model is null");
            return false;
        }
        a aVar = (a) com.baidu.swan.apps.component.container.a.d(i);
        if (aVar == null) {
            String str2 = "can't find button component:#" + i.cNO;
            com.baidu.swan.apps.console.c.e("Component-Action-Button", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c a2 = aVar.a((a) i);
        boolean isSuccess = a2.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return isSuccess;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, a2.msg);
        return isSuccess;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("Component-Action-Button", "remove");
        }
        c i = i(unitedSchemeEntity);
        if (i == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-Button", "model is null");
            return false;
        }
        a aVar = (a) com.baidu.swan.apps.component.container.a.d(i);
        if (aVar == null) {
            String str2 = "can't find button component:#" + i.cNO;
            com.baidu.swan.apps.console.c.e("Component-Action-Button", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c aoy = aVar.aoy();
        boolean isSuccess = aoy.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return isSuccess;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, aoy.msg);
        return isSuccess;
    }

    @Nullable
    private c i(UnitedSchemeEntity unitedSchemeEntity) {
        c cVar = null;
        if (unitedSchemeEntity != null) {
            JSONObject m = m(unitedSchemeEntity);
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                com.baidu.swan.apps.console.c.e("Component-Action-Button", "params is null");
            } else {
                cVar = new c();
                try {
                    cVar.parseFromJson(m);
                } catch (JSONException e) {
                    e.printStackTrace();
                    com.baidu.swan.apps.console.c.e("Component-Action-Button", "model parse exception:", e);
                }
            }
        }
        return cVar;
    }
}
