package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.swan.apps.as.af;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends c {
    public int[] bvA = {0, 0, 0, 0};
    public ArrayList<com.baidu.swan.apps.z.a.a.c> bvz;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("points") && (jSONArray2 = jSONObject.getJSONArray("points")) != null && jSONArray2.length() > 0) {
                int length = jSONArray2.length();
                this.bvz = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                    if (jSONObject2 != null) {
                        com.baidu.swan.apps.z.a.a.c cVar = new com.baidu.swan.apps.z.a.a.c();
                        cVar.parseFromJson(jSONObject2);
                        if (cVar.isValid()) {
                            this.bvz.add(cVar);
                        }
                    }
                }
            }
            if (jSONObject.has("padding") && (jSONArray = jSONObject.getJSONArray("padding")) != null && jSONArray.length() > 0) {
                int min = Math.min(jSONArray.length(), 4);
                for (int i2 = 0; i2 < min; i2++) {
                    this.bvA[i2] = af.S(jSONArray.optInt(i2));
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bdW) || TextUtils.isEmpty(this.bdV) || this.bvz == null || this.bvz.size() <= 0) ? false : true;
    }
}
