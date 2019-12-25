package com.baidu.swan.apps.scheme.actions.m;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class d extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String mSrc;

    public d() {
        super("webView", "viewId");
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d q(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        String str = unitedSchemeEntity.getParams().get("params");
        d dVar = new d();
        try {
            dVar.parseFromJson(new JSONObject(str));
            return dVar;
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("WebView", "parsing params occurs exception", e);
            return null;
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bdi);
    }
}
