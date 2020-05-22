package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends c {
    public ArrayList<com.baidu.swan.apps.x.a.a.c> ciJ;
    public int[] ciK = {0, 0, 0, 0};

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("points") && (jSONArray2 = jSONObject.getJSONArray("points")) != null && jSONArray2.length() > 0) {
                int length = jSONArray2.length();
                this.ciJ = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                    if (jSONObject2 != null) {
                        com.baidu.swan.apps.x.a.a.c cVar = new com.baidu.swan.apps.x.a.a.c();
                        cVar.parseFromJson(jSONObject2);
                        if (cVar.isValid()) {
                            this.ciJ.add(cVar);
                        }
                    }
                }
            }
            if (jSONObject.has("padding") && (jSONArray = jSONObject.getJSONArray("padding")) != null && jSONArray.length() > 0) {
                int min = Math.min(jSONArray.length(), 4);
                for (int i2 = 0; i2 < min; i2++) {
                    this.ciK[i2] = ag.B(jSONArray.optInt(i2));
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bPG) || TextUtils.isEmpty(this.bPF) || this.ciJ == null || this.ciJ.size() <= 0) ? false : true;
    }
}
