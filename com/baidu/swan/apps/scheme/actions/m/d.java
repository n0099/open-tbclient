package com.baidu.swan.apps.scheme.actions.m;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String amP;
    public boolean cWe;
    public List<String> cWf;
    public String mSrc;
    public String mType;

    public d() {
        super("webView", "viewId");
        this.cWe = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.mSrc = jSONObject.optString("src");
            this.amP = jSONObject.optString("userAgent");
            this.mType = jSONObject.optString("type");
            JSONArray optJSONArray = jSONObject.optJSONArray("targetUrls");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                this.cWf = new ArrayList();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.cWf.add(optJSONArray.optString(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d p(UnitedSchemeEntity unitedSchemeEntity) {
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
        return !TextUtils.isEmpty(this.cda);
    }
}
