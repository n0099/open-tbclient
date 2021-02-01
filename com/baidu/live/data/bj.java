package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bj {
    public List<Long> aOV;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOV = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("id");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aOV.add(Long.valueOf(optJSONArray.optLong(i)));
                }
            }
        }
    }
}
