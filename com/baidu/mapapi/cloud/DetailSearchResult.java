package com.baidu.mapapi.cloud;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class DetailSearchResult extends BaseSearchResult {
    public CloudPoiInfo poiInfo;

    @Override // com.baidu.mapapi.cloud.BaseSearchResult
    public void parseFromJSON(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        super.parseFromJSON(jSONObject);
        if (this.status != 0 || (optJSONArray = jSONObject.optJSONArray("contents")) == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return;
        }
        this.poiInfo = new CloudPoiInfo();
        this.poiInfo.a(optJSONObject);
    }
}
