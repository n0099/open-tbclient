package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.sapi2.activity.SlideActiviy;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends c {
    public String bvd = "";
    public String bve = "";
    public ArrayList<String> bvf;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("scale")) {
                this.buO = jSONObject.optDouble("scale", 18.0d);
            }
            if (jSONObject.has("name")) {
                this.bvd = jSONObject.optString("name");
            }
            if (jSONObject.has(SlideActiviy.ADDRESS_PAGE_NAME)) {
                this.bve = jSONObject.optString(SlideActiviy.ADDRESS_PAGE_NAME);
            }
            if (jSONObject.has("ignoredApps") && (optJSONArray = jSONObject.optJSONArray("ignoredApps")) != null) {
                int length = optJSONArray.length();
                this.bvf = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    this.bvf.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bdi) || this.buN == null || !this.buN.isValid()) ? false : true;
    }
}
