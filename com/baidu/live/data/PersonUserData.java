package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonUserData implements Serializable {
    public static final int PERSON_FANS_TYPE = 0;
    public static final int PERSON_FOLLOWS_TYPE = 1;
    public static final int PERSON_PLAYBACKS_TYPE = 2;
    public AlaLocationData location_info;
    public ae login_user_info;
    public c mAnchorTagData;
    public AlaRelationData relation_info;
    public ae topContributionUserInfo;
    public ae user_info;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
        if (optJSONObject != null) {
            this.user_info = new ae();
            this.user_info.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("login_user_info");
        if (optJSONObject2 != null) {
            this.login_user_info = new ae();
            this.login_user_info.parserJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("location_info");
        if (optJSONObject3 != null) {
            this.location_info = new AlaLocationData();
            this.location_info.parserJson(optJSONObject3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("relation_info");
        if (optJSONObject4 != null) {
            this.relation_info = new AlaRelationData();
            this.relation_info.parserJson(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("top_contribution");
        if (optJSONObject5 != null) {
            this.topContributionUserInfo = new ae();
            this.topContributionUserInfo.parserJson(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("anchor_tags");
        if (optJSONObject6 != null) {
            this.mAnchorTagData = new c();
            this.mAnchorTagData.parse(optJSONObject6);
        }
    }

    public boolean isImOnceBan() {
        return this.user_info != null && this.user_info.is_block == 1;
    }

    public boolean isImForeverBan() {
        return this.user_info != null && this.user_info.is_block == 2;
    }

    public boolean isChatOnceBan() {
        return this.user_info != null && this.user_info.aBp == 1;
    }

    public boolean isChatForeverBan() {
        return this.user_info != null && this.user_info.aBp == 2;
    }
}
