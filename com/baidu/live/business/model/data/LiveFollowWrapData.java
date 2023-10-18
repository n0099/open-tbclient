package com.baidu.live.business.model.data;

import com.baidu.tieba.q70;
import com.baidu.tieba.t70;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveFollowWrapData {
    public int errCode;
    public String errMsg;
    public List<LiveFollowEntity> followList;
    public FollowMore followMore;

    /* loaded from: classes3.dex */
    public static class FollowMore {
        public String scheme;
        public String txt;

        public FollowMore(String str, String str2) {
            this.scheme = str;
            this.txt = str2;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        this.errCode = jSONObject.optInt("inner_errno");
        this.errMsg = jSONObject.optString("inner_msg");
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.followList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    LiveFollowEntity liveFollowEntity = new LiveFollowEntity();
                    liveFollowEntity.parserJson(optJSONObject2);
                    this.followList.add(liveFollowEntity);
                }
            }
        }
        if (!q70.c(this.followList) && (optJSONObject = jSONObject.optJSONObject("more")) != null) {
            String optString = optJSONObject.optString("scheme");
            if (!t70.a(optString)) {
                this.followMore = new FollowMore(optString, optJSONObject.optString("txt"));
            }
        }
    }
}
