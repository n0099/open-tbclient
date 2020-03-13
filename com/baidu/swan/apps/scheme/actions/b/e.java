package com.baidu.swan.apps.scheme.actions.b;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
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
/* loaded from: classes11.dex */
public class e extends b {
    private static final String bRA = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";
    private static final String bRB = SchemeConfig.getSchemeHead() + "://swangame/%s";

    public e(j jVar) {
        super(jVar, "/swanAPI/getFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        JSONArray jSONArray = new JSONArray();
        List<SwanFavorItemData> Sg = SwanFavorDataManager.Sf().Sg();
        if (Sg.size() > 0) {
            for (SwanFavorItemData swanFavorItemData : Sg) {
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
                str = String.format(bRB, swanFavorItemData.getAppKey());
            } else {
                str = bRA + swanFavorItemData.getAppKey() + "\"}";
            }
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected boolean o(UnitedSchemeEntity unitedSchemeEntity) {
        return true;
    }
}
