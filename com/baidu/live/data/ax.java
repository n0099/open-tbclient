package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ax {
    public List<Long> aJV;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJV = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("id");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aJV.add(Long.valueOf(optJSONArray.optLong(i)));
                }
            }
        }
    }
}
