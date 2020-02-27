package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.sapi2.activity.SlideActiviy;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends c {
    public String bAa = "";
    public String bAb = "";
    public ArrayList<String> bAc;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("scale")) {
                this.bzL = jSONObject.optDouble("scale", 18.0d);
            }
            if (jSONObject.has("name")) {
                this.bAa = jSONObject.optString("name");
            }
            if (jSONObject.has(SlideActiviy.ADDRESS_PAGE_NAME)) {
                this.bAb = jSONObject.optString(SlideActiviy.ADDRESS_PAGE_NAME);
            }
            if (jSONObject.has("ignoredApps") && (optJSONArray = jSONObject.optJSONArray("ignoredApps")) != null) {
                int length = optJSONArray.length();
                this.bAc = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    this.bAc.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bil) || this.bzK == null || !this.bzK.isValid()) ? false : true;
    }
}
