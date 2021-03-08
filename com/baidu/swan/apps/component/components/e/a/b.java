package com.baidu.swan.apps.component.components.e.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.component.components.e.b.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.scheme.actions.b {
    public b(j jVar) {
        super(jVar, "/swanAPI/coverimage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    @NonNull
    public String getModuleName() {
        return "/swanAPI/coverimage";
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("Component-Action-ImageCover", "insert");
        }
        c k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", "model is null");
            return false;
        }
        final com.baidu.swan.apps.component.components.e.b.b bVar = new com.baidu.swan.apps.component.components.e.b.b(context, k);
        bVar.a(new com.baidu.swan.apps.component.components.e.b.a() { // from class: com.baidu.swan.apps.component.components.e.a.b.1
            @Override // com.baidu.swan.apps.component.components.e.b.a
            public void a(int i, View view, @Nullable Object obj) {
                c cVar = (c) bVar.alh();
                switch (i) {
                    case 0:
                    case 1:
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "loadState");
                            jSONObject.put("parentId", cVar.cMS);
                            jSONObject.put("viewId", cVar.cMQ);
                            jSONObject.put("loadState", i == 1 ? "finish" : BdStatsConstant.StatsType.ERROR);
                        } catch (JSONException e) {
                            com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", "loadState callback error", e);
                        }
                        b.this.a(callbackHandler, jSONObject, cVar.callback);
                        return;
                    default:
                        return;
                }
            }
        });
        com.baidu.swan.apps.component.b.c ale = bVar.ale();
        boolean isSuccess = ale.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, ale.msg);
        }
        return isSuccess;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("Component-Action-ImageCover", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        c k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.e.b.b bVar = (com.baidu.swan.apps.component.components.e.b.b) com.baidu.swan.apps.component.container.a.d(k);
        if (bVar == null) {
            String str2 = "can't find imageCoverView component:#" + k.cMQ;
            com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c a2 = bVar.a((com.baidu.swan.apps.component.components.e.b.b) k);
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
            Log.d("Component-Action-ImageCover", "remove");
        }
        c k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.e.b.b bVar = (com.baidu.swan.apps.component.components.e.b.b) com.baidu.swan.apps.component.container.a.d(k);
        if (bVar == null) {
            String str2 = "can't find imageCoverView component:#" + k.cMQ;
            com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c alg = bVar.alg();
        boolean isSuccess = alg.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return isSuccess;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, alg.msg);
        return isSuccess;
    }

    @Nullable
    private c k(UnitedSchemeEntity unitedSchemeEntity) {
        c cVar = null;
        if (unitedSchemeEntity != null) {
            JSONObject m = m(unitedSchemeEntity);
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", "params is null");
            } else {
                cVar = new c();
                try {
                    cVar.parseFromJson(m);
                } catch (JSONException e) {
                    e.printStackTrace();
                    com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", "model parse exception:", e);
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
        com.baidu.swan.apps.console.c.i("Component-Action-ImageCover", "sendAsyncCallback info: " + jSONObject);
        if (!TextUtils.isEmpty(str)) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
