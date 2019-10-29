package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends BaseData {
    public AlaLiveInfoData mLiveInfo;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mLiveInfo = new AlaLiveInfoData();
            JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
            if (optJSONObject != null) {
                this.mLiveInfo.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("author");
            if (optJSONObject2 != null) {
                long optLong = optJSONObject2.optLong("id");
                String optString = optJSONObject2.optString("name");
                String optString2 = optJSONObject2.optString("name_show");
                optJSONObject2.optString("portrait");
                this.mLiveInfo.user_id = optLong;
                this.mLiveInfo.user_name = optString;
                this.mLiveInfo.user_nickname = optString2;
            }
        }
    }
}
