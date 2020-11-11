package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bc {
    public List<Long> aOI;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOI = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("id");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aOI.add(Long.valueOf(optJSONArray.optLong(i)));
                }
            }
        }
    }
}
