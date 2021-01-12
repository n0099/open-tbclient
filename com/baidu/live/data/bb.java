package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bb {
    public List<ba> aLM;
    public String liveId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.liveId = jSONObject.optString("live_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aLM = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        ba baVar = new ba();
                        baVar.parserJson(optJSONObject);
                        this.aLM.add(baVar);
                    }
                }
            }
        }
    }
}
