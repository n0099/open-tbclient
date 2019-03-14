package com.baidu.swan.apps.scheme.actions.j;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String mSrc;

    public d() {
        super("viewId", "webView");
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.mSrc = jSONObject.optString("src");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d m(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        String str = unitedSchemeEntity.getParams().get(LegoListActivityConfig.PARAMS);
        d dVar = new d();
        try {
            dVar.parseFromJson(new JSONObject(str));
            return dVar;
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("WebView", "parsing params occurs exception", e);
            return null;
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBD);
    }
}
