package com.baidu.ala.data;

import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveUserInfoData extends m implements Serializable {
    public static final int ALA_AUTHENT_STATUS_FAILED = 3;
    public static final int ALA_AUTHENT_STATUS_NOT = 0;
    public static final int ALA_AUTHENT_STATUS_NOW = 1;
    public static final int ALA_AUTHENT_STATUS_PASS = 2;
    public static final int LIVE_STATUS_ON_LIVING = 1;
    public long alaId;
    public String appId;
    public String bd_portrait;
    public boolean canUseChallenge;
    public int changeSex;
    public long charmCount;
    public int createTime;
    public String description;
    public int fansCount;
    public int followCount;
    public int follow_status;
    public String greatAnchorDescGrade;
    public String greatAnchorDescRole;
    public String greatAnchorIcon;
    public int hasTiebaName;
    public int isAdmin;
    public int isBlock;
    public int isBluediamondMember;
    public int isLogin;
    public boolean isNewGiftPriceStrategy = false;
    public int isOfficial;
    public double lat;
    public int levelExp;
    public int levelId;
    public long levelNextExp;
    public long liveId;
    public int liveStatus;
    public List<AlaLiveMarkData> live_mark_info_new;
    public double lng;
    public String location;
    public String passName;
    public int petalNum;
    public String portrait;
    public int recordCount;
    public int sex;
    public long streamID;
    public long userId;
    public String userName;
    public int userStatus;
    public int verifyInfoStatus;
    public int verifyStatus;
    public int verifyType;
    public int verifyVideoStatus;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.alaId = jSONObject.optLong("ala_id");
            this.userName = jSONObject.optString("user_nickname");
            if (TextUtils.isEmpty(this.userName)) {
                this.userName = jSONObject.optString("user_name");
            }
            this.sex = jSONObject.optInt("sex");
            this.description = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.bd_portrait = jSONObject.optString("bd_portrait");
            this.levelId = jSONObject.optInt("level_id");
            this.levelExp = jSONObject.optInt("level_exp");
            this.location = jSONObject.optString("location");
            this.lng = jSONObject.optDouble("lng");
            this.lat = jSONObject.optDouble("lat");
            this.fansCount = jSONObject.optInt("fans_count");
            this.followCount = jSONObject.optInt("follow_count");
            this.charmCount = jSONObject.optLong("charm_count");
            this.userStatus = jSONObject.optInt("user_status");
            this.liveStatus = jSONObject.optInt("live_status");
            this.isLogin = jSONObject.optInt(ImageViewerConfig.IS_LOGIN);
            this.liveId = jSONObject.optLong("live_id");
            this.createTime = jSONObject.optInt("create_time");
            this.changeSex = jSONObject.optInt("change_sex");
            this.recordCount = jSONObject.optInt("record_count");
            this.streamID = jSONObject.optLong(BdStatsConstant.StatsKey.STREAM_ID);
            this.passName = jSONObject.optString("pass_name");
            this.hasTiebaName = jSONObject.optInt("has_tieba_username");
            this.verifyStatus = jSONObject.optInt("verify_status");
            this.isOfficial = jSONObject.optInt("is_official");
            this.recordCount = jSONObject.optInt("record_count");
            this.levelNextExp = jSONObject.optLong("next_exp");
            this.isAdmin = jSONObject.optInt("is_live_admin");
            this.isBlock = jSONObject.optInt("is_block");
            this.greatAnchorIcon = jSONObject.optString("great_anchor_icon");
            this.greatAnchorDescGrade = jSONObject.optString("great_anchor_desc_grade");
            this.greatAnchorDescRole = jSONObject.optString("great_anchor_desc_role");
            this.verifyInfoStatus = jSONObject.optInt("verify_info_status");
            this.verifyVideoStatus = jSONObject.optInt("verify_info_status");
            this.verifyType = jSONObject.optInt("verify_type");
            this.petalNum = jSONObject.optInt("petal_num");
            this.appId = jSONObject.optString("third_app_id");
            this.canUseChallenge = jSONObject.optInt("challenge_switch", 0) == 1;
            this.isNewGiftPriceStrategy = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.live_mark_info_new == null) {
                    this.live_mark_info_new = new ArrayList();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject);
                        this.live_mark_info_new.add(alaLiveMarkData);
                    }
                }
            }
            this.follow_status = jSONObject.optInt("follow_status");
        }
    }
}
