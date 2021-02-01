package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends c {
    public String dhQ = "";
    public String dhR = "";
    public ArrayList<String> dhS;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("scale")) {
                this.dhB = jSONObject.optDouble("scale", 18.0d);
            }
            if (jSONObject.has("name")) {
                this.dhQ = jSONObject.optString("name");
            }
            if (jSONObject.has("address")) {
                this.dhR = jSONObject.optString("address");
            }
            if (jSONObject.has("ignoredApps") && (optJSONArray = jSONObject.optJSONArray("ignoredApps")) != null) {
                int length = optJSONArray.length();
                this.dhS = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    this.dhS.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cLr) || this.dhA == null || !this.dhA.isValid()) ? false : true;
    }
}
