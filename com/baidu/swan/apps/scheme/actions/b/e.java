package com.baidu.swan.apps.scheme.actions.b;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.scheme.j;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends b {
    private static final String dJF = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";
    private static final String dJG = SchemeConfig.getSchemeHead() + "://swangame/%s";

    public e(j jVar) {
        super(jVar, "/swanAPI/getFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected void b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        JSONArray jSONArray = new JSONArray();
        List<SwanFavorItemData> ayk = SwanFavorDataManager.ayj().ayk();
        if (ayk.size() > 0) {
            for (SwanFavorItemData swanFavorItemData : ayk) {
                jSONArray.put(b(swanFavorItemData));
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("favors", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }

    private JSONObject b(SwanFavorItemData swanFavorItemData) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", swanFavorItemData.getAppKey());
            jSONObject.put("type", swanFavorItemData.getAppType());
            jSONObject.put("iconUrl", swanFavorItemData.getIconUrl());
            jSONObject.put("title", swanFavorItemData.getAppName());
            jSONObject.put("frameType", swanFavorItemData.getAppFrameType());
            if (swanFavorItemData.getAppFrameType() == 1) {
                str = String.format(dJG, swanFavorItemData.getAppKey());
            } else {
                str = dJF + swanFavorItemData.getAppKey() + "\"}";
            }
            jSONObject.put("scheme", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected boolean b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        return true;
    }
}
