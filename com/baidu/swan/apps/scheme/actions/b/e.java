package com.baidu.swan.apps.scheme.actions.b;

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
    private static final String aPN = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";
    private static final String aPO = SchemeConfig.getSchemeHead() + "://swangame/%s";

    public e(j jVar) {
        super(jVar, "/swan/getFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        JSONArray jSONArray = new JSONArray();
        List<com.baidu.swan.apps.database.a> AK = com.baidu.swan.apps.database.favorite.a.AK();
        if (AK.size() > 0) {
            for (com.baidu.swan.apps.database.a aVar : AK) {
                jSONArray.put(f(aVar));
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

    private JSONObject f(com.baidu.swan.apps.database.a aVar) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aVar.appId);
            jSONObject.put("type", aVar.type);
            jSONObject.put("iconUrl", aVar.iconUrl);
            jSONObject.put("title", aVar.name);
            jSONObject.put("frameType", aVar.category);
            if (aVar.category == 1) {
                str = String.format(aPO, aVar.appId);
            } else {
                str = aPN + aVar.appId + "\"}";
            }
            jSONObject.put("scheme", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected boolean k(UnitedSchemeEntity unitedSchemeEntity) {
        return true;
    }
}
