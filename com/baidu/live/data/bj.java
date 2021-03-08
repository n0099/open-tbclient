package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bj {
    public List<Long> aQv;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQv = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("id");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aQv.add(Long.valueOf(optJSONArray.optLong(i)));
                }
            }
        }
    }
}
