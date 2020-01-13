package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.sapi2.activity.SlideActiviy;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends c {
    public String bvR = "";
    public String bvS = "";
    public ArrayList<String> bvT;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("scale")) {
                this.bvC = jSONObject.optDouble("scale", 18.0d);
            }
            if (jSONObject.has("name")) {
                this.bvR = jSONObject.optString("name");
            }
            if (jSONObject.has(SlideActiviy.ADDRESS_PAGE_NAME)) {
                this.bvS = jSONObject.optString(SlideActiviy.ADDRESS_PAGE_NAME);
            }
            if (jSONObject.has("ignoredApps") && (optJSONArray = jSONObject.optJSONArray("ignoredApps")) != null) {
                int length = optJSONArray.length();
                this.bvT = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    this.bvT.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bdW) || this.bvB == null || !this.bvB.isValid()) ? false : true;
    }
}
