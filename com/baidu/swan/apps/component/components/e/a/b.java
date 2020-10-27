package com.baidu.swan.apps.component.components.e.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
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
/* loaded from: classes10.dex */
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
        c l = l(unitedSchemeEntity);
        if (l == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", "model is null");
            return false;
        }
        final com.baidu.swan.apps.component.components.e.b.b bVar = new com.baidu.swan.apps.component.components.e.b.b(context, l);
        bVar.a(new com.baidu.swan.apps.component.components.e.b.a() { // from class: com.baidu.swan.apps.component.components.e.a.b.1
            @Override // com.baidu.swan.apps.component.components.e.b.a
            public void a(int i, View view, @Nullable Object obj) {
                c cVar = (c) bVar.aiq();
                switch (i) {
                    case 0:
                    case 1:
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "loadState");
                            jSONObject.put("parentId", cVar.cxT);
                            jSONObject.put("viewId", cVar.cxR);
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
        com.baidu.swan.apps.component.b.c ain = bVar.ain();
        boolean isSuccess = ain.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, ain.msg);
        }
        return isSuccess;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b
    public boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (DEBUG) {
            Log.d("Component-Action-ImageCover", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        c l = l(unitedSchemeEntity);
        if (l == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.e.b.b bVar = (com.baidu.swan.apps.component.components.e.b.b) com.baidu.swan.apps.component.container.a.d(l);
        if (bVar == null) {
            String str2 = "can't find imageCoverView component:#" + l.cxR;
            com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c a2 = bVar.a((com.baidu.swan.apps.component.components.e.b.b) l);
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
        c l = l(unitedSchemeEntity);
        if (l == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", "model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.e.b.b bVar = (com.baidu.swan.apps.component.components.e.b.b) com.baidu.swan.apps.component.container.a.d(l);
        if (bVar == null) {
            String str2 = "can't find imageCoverView component:#" + l.cxR;
            com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        com.baidu.swan.apps.component.b.c aip = bVar.aip();
        boolean isSuccess = aip.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return isSuccess;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, aip.msg);
        return isSuccess;
    }

    @Nullable
    private c l(UnitedSchemeEntity unitedSchemeEntity) {
        c cVar = null;
        if (unitedSchemeEntity != null) {
            JSONObject n = n(unitedSchemeEntity);
            if (n == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                com.baidu.swan.apps.console.c.e("Component-Action-ImageCover", "params is null");
            } else {
                cVar = new c();
                try {
                    cVar.parseFromJson(n);
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
