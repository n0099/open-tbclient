package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class e extends c {
    public String dfA = "";
    public String dfB = "";
    public ArrayList<String> dfC;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("scale")) {
                this.dfl = jSONObject.optDouble("scale", 18.0d);
            }
            if (jSONObject.has("name")) {
                this.dfA = jSONObject.optString("name");
            }
            if (jSONObject.has("address")) {
                this.dfB = jSONObject.optString("address");
            }
            if (jSONObject.has("ignoredApps") && (optJSONArray = jSONObject.optJSONArray("ignoredApps")) != null) {
                int length = optJSONArray.length();
                this.dfC = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    this.dfC.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cIW) || this.dfk == null || !this.dfk.isValid()) ? false : true;
    }
}
