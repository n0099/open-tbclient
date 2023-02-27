package com.baidu.live.business.model.data;

import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveBannerWrapData {
    public List<LiveBannerEntity> bannerList;
    public int count;
    public int errCode;
    public String errMsg;
    public int position;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.errCode = jSONObject.optInt("inner_errno");
        this.errMsg = jSONObject.optString("inner_msg");
        this.count = jSONObject.optInt("count");
        this.position = jSONObject.optInt(CriusAttrConstants.POSITION);
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.bannerList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    LiveBannerEntity liveBannerEntity = new LiveBannerEntity();
                    liveBannerEntity.parserJson(optJSONObject);
                    if (liveBannerEntity.isValid()) {
                        liveBannerEntity.position = this.bannerList.size();
                        this.bannerList.add(liveBannerEntity);
                    }
                }
            }
        }
    }
}
