package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends c {
    public ArrayList<String> bYB;
    public String bYz = "";
    public String bYA = "";

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("scale")) {
                this.bYk = jSONObject.optDouble("scale", 18.0d);
            }
            if (jSONObject.has("name")) {
                this.bYz = jSONObject.optString("name");
            }
            if (jSONObject.has("address")) {
                this.bYA = jSONObject.optString("address");
            }
            if (jSONObject.has("ignoredApps") && (optJSONArray = jSONObject.optJSONArray("ignoredApps")) != null) {
                int length = optJSONArray.length();
                this.bYB = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    this.bYB.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bGO) || this.bYj == null || !this.bYj.isValid()) ? false : true;
    }
}
