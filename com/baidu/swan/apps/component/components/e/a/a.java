package com.baidu.swan.apps.component.components.e.a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.apps.scheme.actions.b {
    public a(j jVar) {
        super(jVar, "/swanAPI/coverview");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    @NonNull
    public String getModuleName() {
        return "/swanAPI/coverview";
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("Component-Action-CoverView", "insert");
        }
        com.baidu.swan.apps.component.components.e.c.b j = j(unitedSchemeEntity);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("Component-Action-CoverView", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.b.c alb = new com.baidu.swan.apps.component.components.e.c.a(context, j).alb();
        boolean isSuccess = alb.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, alb.msg);
        }
        return isSuccess;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("Component-Action-CoverView", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        com.baidu.swan.apps.component.components.e.c.b j = j(unitedSchemeEntity);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("Component-Action-CoverView", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.e.c.a aVar = (com.baidu.swan.apps.component.components.e.c.a) com.baidu.swan.apps.component.container.a.d(j);
        if (aVar == null) {
            String str2 = "can't find coverView component:#" + j.cLq;
            c.e("Component-Action-CoverView", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c a2 = aVar.a((com.baidu.swan.apps.component.components.e.c.a) j);
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
            Log.d("Component-Action-CoverView", "remove");
        }
        com.baidu.swan.apps.component.components.e.c.b j = j(unitedSchemeEntity);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("Component-Action-CoverView", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.e.c.a aVar = (com.baidu.swan.apps.component.components.e.c.a) com.baidu.swan.apps.component.container.a.d(j);
        if (aVar == null) {
            String str2 = "can't find coverView component:#" + j.cLq;
            c.e("Component-Action-CoverView", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c ald = aVar.ald();
        boolean isSuccess = ald.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return isSuccess;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, ald.msg);
        return isSuccess;
    }

    @Nullable
    private com.baidu.swan.apps.component.components.e.c.b j(UnitedSchemeEntity unitedSchemeEntity) {
        com.baidu.swan.apps.component.components.e.c.b bVar = null;
        if (unitedSchemeEntity != null) {
            JSONObject m = m(unitedSchemeEntity);
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.e("Component-Action-CoverView", "params is null");
            } else {
                bVar = new com.baidu.swan.apps.component.components.e.c.b();
                try {
                    bVar.parseFromJson(m);
                } catch (JSONException e) {
                    e.printStackTrace();
                    c.e("Component-Action-CoverView", "model parse exception:", e);
                }
            }
        }
        return bVar;
    }
}
