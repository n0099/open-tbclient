package com.baidu.swan.apps.component.components.e.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
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
        com.baidu.swan.apps.component.components.e.c.b k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("Component-Action-CoverView", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.b.c KI = new com.baidu.swan.apps.component.components.e.c.a(context, k).KI();
        boolean isSuccess = KI.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, KI.msg);
        }
        return isSuccess;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("Component-Action-CoverView", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        com.baidu.swan.apps.component.components.e.c.b k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("Component-Action-CoverView", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.e.c.a aVar = (com.baidu.swan.apps.component.components.e.c.a) com.baidu.swan.apps.component.container.a.d(k);
        if (aVar == null) {
            String str2 = "can't find coverView component:#" + k.biA;
            c.e("Component-Action-CoverView", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c a = aVar.a((com.baidu.swan.apps.component.components.e.c.a) k);
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
            Log.d("Component-Action-CoverView", "remove");
        }
        com.baidu.swan.apps.component.components.e.c.b k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("Component-Action-CoverView", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.e.c.a aVar = (com.baidu.swan.apps.component.components.e.c.a) com.baidu.swan.apps.component.container.a.d(k);
        if (aVar == null) {
            String str2 = "can't find coverView component:#" + k.biA;
            c.e("Component-Action-CoverView", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c KK = aVar.KK();
        boolean isSuccess = KK.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return isSuccess;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, KK.msg);
        return isSuccess;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        return false;
    }

    @Nullable
    private com.baidu.swan.apps.component.components.e.c.b k(UnitedSchemeEntity unitedSchemeEntity) {
        com.baidu.swan.apps.component.components.e.c.b bVar = null;
        if (unitedSchemeEntity != null) {
            JSONObject n = n(unitedSchemeEntity);
            if (n == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.e("Component-Action-CoverView", "params is null");
            } else {
                bVar = new com.baidu.swan.apps.component.components.e.c.b();
                try {
                    bVar.parseFromJson(n);
                } catch (JSONException e) {
                    e.printStackTrace();
                    c.e("Component-Action-CoverView", "model parse exception:", e);
                }
            }
        }
        return bVar;
    }
}
