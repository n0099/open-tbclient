package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bd {
    public List<Long> aPW;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPW = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("id");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aPW.add(Long.valueOf(optJSONArray.optLong(i)));
                }
            }
        }
    }
}
