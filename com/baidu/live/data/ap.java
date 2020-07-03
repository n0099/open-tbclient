package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ap {
    public List<Long> aBY;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBY = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("id");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aBY.add(Long.valueOf(optJSONArray.optLong(i)));
                }
            }
        }
    }
}
