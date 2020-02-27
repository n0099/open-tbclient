package com.baidu.mapapi.cloud;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class CloudSearchResult extends BaseSearchResult {
    public List<CloudPoiInfo> poiList;

    @Override // com.baidu.mapapi.cloud.BaseSearchResult
    public void parseFromJSON(JSONObject jSONObject) throws JSONException {
        super.parseFromJSON(jSONObject);
        if (this.status != 0) {
            return;
        }
        this.poiList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("contents");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    CloudPoiInfo cloudPoiInfo = new CloudPoiInfo();
                    cloudPoiInfo.a(optJSONObject);
                    this.poiList.add(cloudPoiInfo);
                }
            }
        }
    }
}
