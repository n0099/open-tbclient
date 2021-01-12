package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bf {
    public List<Long> aLY;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLY = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("id");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aLY.add(Long.valueOf(optJSONArray.optLong(i)));
                }
            }
        }
    }
}
