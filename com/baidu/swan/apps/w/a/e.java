package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends c {
    public String dku = "";
    public String dkv = "";
    public ArrayList<String> dkw;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("scale")) {
                this.dkf = jSONObject.optDouble("scale", 18.0d);
            }
            if (jSONObject.has("name")) {
                this.dku = jSONObject.optString("name");
            }
            if (jSONObject.has("address")) {
                this.dkv = jSONObject.optString("address");
            }
            if (jSONObject.has("ignoredApps") && (optJSONArray = jSONObject.optJSONArray("ignoredApps")) != null) {
                int length = optJSONArray.length();
                this.dkw = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    this.dkw.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cNP) || this.dke == null || !this.dke.isValid()) ? false : true;
    }
}
