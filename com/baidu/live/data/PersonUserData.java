package com.baidu.live.data;

import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PersonUserData implements Serializable {
    public static final int PERSON_FANS_TYPE = 0;
    public static final int PERSON_FOLLOWS_TYPE = 1;
    public static final int PERSON_PLAYBACKS_TYPE = 2;
    public AlaLiveInfoData live_info;
    public AlaLocationData location_info;
    public am login_user_info;
    public d mAnchorTagData;
    public YuyinAlaSdkData mYuyinAlaSdkData;
    public YuyinAlaPersonManagerData mYuyinBanMangerData;
    public AlaRelationData relation_info;
    public am topContributionUserInfo;
    public am user_info;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
        if (optJSONObject != null) {
            this.user_info = new am();
            this.user_info.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(CashierData.SDK);
        if (optJSONObject != null) {
            this.mYuyinAlaSdkData = new YuyinAlaSdkData();
            this.mYuyinAlaSdkData.parse(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("login_user_info");
        if (optJSONObject3 != null) {
            this.login_user_info = new am();
            this.login_user_info.parserJson(optJSONObject3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("location_info");
        if (optJSONObject4 != null) {
            this.location_info = new AlaLocationData();
            this.location_info.parserJson(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("relation_info");
        if (optJSONObject5 != null) {
            this.relation_info = new AlaRelationData();
            this.relation_info.parserJson(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("live_info");
        if (optJSONObject6 != null) {
            this.live_info = new AlaLiveInfoData();
            this.live_info.parserJson(optJSONObject6);
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("top_contribution");
        if (optJSONObject7 != null) {
            this.topContributionUserInfo = new am();
            this.topContributionUserInfo.parserJson(optJSONObject7);
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject("anchor_tags");
        if (optJSONObject8 != null) {
            this.mAnchorTagData = new d();
            this.mAnchorTagData.parse(optJSONObject8);
        }
        JSONObject optJSONObject9 = jSONObject.optJSONObject("user_manager");
        if (optJSONObject9 != null) {
            this.mYuyinBanMangerData = new YuyinAlaPersonManagerData();
            this.mYuyinBanMangerData.parse(optJSONObject9);
        }
    }

    public boolean isImOnceBan() {
        return this.user_info != null && this.user_info.is_block == 1;
    }

    public boolean isImForeverBan() {
        return this.user_info != null && this.user_info.is_block == 2;
    }

    public boolean isChatOnceBan() {
        return this.user_info != null && this.user_info.aJr == 1;
    }

    public boolean isChatForeverBan() {
        return this.user_info != null && this.user_info.aJr == 2;
    }

    public boolean isLandScapeLive() {
        return this.live_info != null && this.live_info.screen_direction == 2;
    }
}
