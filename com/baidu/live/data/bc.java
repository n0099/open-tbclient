package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bc {
    public List<Long> aMX;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aMX = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("id");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aMX.add(Long.valueOf(optJSONArray.optLong(i)));
                }
            }
        }
    }
}
