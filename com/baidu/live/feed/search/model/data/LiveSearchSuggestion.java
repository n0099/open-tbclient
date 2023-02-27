package com.baidu.live.feed.search.model.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveSearchSuggestion {
    public String type = "";
    public String question = "";

    public void parseJSONObj(JSONObject jSONObject) {
        this.type = jSONObject.optString("type");
        this.question = jSONObject.optString("q");
    }
}
