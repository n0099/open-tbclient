package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends c {
    public String cjb = "";
    public String cjc = "";
    public ArrayList<String> cjd;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("scale")) {
                this.ciM = jSONObject.optDouble("scale", 18.0d);
            }
            if (jSONObject.has("name")) {
                this.cjb = jSONObject.optString("name");
            }
            if (jSONObject.has("address")) {
                this.cjc = jSONObject.optString("address");
            }
            if (jSONObject.has("ignoredApps") && (optJSONArray = jSONObject.optJSONArray("ignoredApps")) != null) {
                int length = optJSONArray.length();
                this.cjd = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    this.cjd.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bPG) || this.ciL == null || !this.ciL.isValid()) ? false : true;
    }
}
