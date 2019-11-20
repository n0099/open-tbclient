package com.baidu.swan.apps.scheme.actions.favorite;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.j;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends b {
    private static final String blQ = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";
    private static final String blR = SchemeConfig.getSchemeHead() + "://swangame/%s";

    public e(j jVar) {
        super(jVar, "/swan/getFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.favorite.b
    protected void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        JSONArray jSONArray = new JSONArray();
        List<com.baidu.swan.apps.database.a> Hx = com.baidu.swan.apps.database.favorite.a.Hx();
        if (Hx.size() > 0) {
            for (com.baidu.swan.apps.database.a aVar : Hx) {
                jSONArray.put(g(aVar));
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

    private JSONObject g(com.baidu.swan.apps.database.a aVar) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aVar.appId);
            jSONObject.put("type", aVar.type);
            jSONObject.put("iconUrl", aVar.iconUrl);
            jSONObject.put("title", aVar.name);
            jSONObject.put("frameType", aVar.category);
            if (aVar.category == 1) {
                str = String.format(blR, aVar.appId);
            } else {
                str = blQ + aVar.appId + "\"}";
            }
            jSONObject.put("scheme", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.apps.scheme.actions.favorite.b
    protected boolean k(UnitedSchemeEntity unitedSchemeEntity) {
        return true;
    }
}
