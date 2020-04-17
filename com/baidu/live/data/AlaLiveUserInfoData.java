package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveUserInfoData extends BaseData implements Serializable {
    public static final int ALA_AUTHENT_STATUS_FAILED = 3;
    public static final int ALA_AUTHENT_STATUS_NOT = 0;
    public static final int ALA_AUTHENT_STATUS_NOW = 1;
    public static final int ALA_AUTHENT_STATUS_PASS = 2;
    public static final int LIVE_STATUS_ON_LIVING = 1;
    public long alaId;
    public String appId;
    public boolean canUseChallenge;
    public int changeSex;
    public long charmCount;
    public int clubMemberLevel;
    public int createTime;
    public String description;
    public JSONObject extraUserInfo;
    public int fansCount;
    public int followCount;
    public String greatAnchorDescGrade;
    public String greatAnchorDescRole;
    public String greatAnchorIcon;
    public int hasTiebaName;
    public int isAdmin;
    public int isAdminOnline;
    public int isBlock;
    public int isBluediamondMember;
    public int isLogin;
    public boolean isNewGiftPriceStrategy = false;
    public boolean isNewUser;
    public int isOfficial;
    public int isUegBlock;
    public double lat;
    public int levelExp;
    public int levelId;
    public long levelNextExp;
    public long liveId;
    public int liveStatus;
    public List<AlaLiveMarkData> live_mark_info_new;
    public double lng;
    public String location;
    public AlaLiveUserPermData mPermInfo;
    public String metaKey;
    public String nickName;
    public String passName;
    public int petalNum;
    public String portrait;
    public int rank;
    public int recordCount;
    public int sex;
    public long streamID;
    public String throneUid;
    public long totalPrice;
    public long userId;
    public String userName;
    public int userStatus;
    public int verifyInfoStatus;
    public int verifyStatus;
    public int verifyType;
    public int verifyVideoStatus;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_perm");
            if (optJSONObject != null) {
                this.mPermInfo = new AlaLiveUserPermData();
                this.mPermInfo.parserJson(optJSONObject);
            }
            this.userId = jSONObject.optLong("user_id");
            this.metaKey = jSONObject.optString("meta_key");
            this.alaId = jSONObject.optLong("ala_id");
            this.nickName = jSONObject.optString("user_nickname");
            if (TextUtils.isEmpty(this.nickName)) {
                this.userName = jSONObject.optString("user_name");
            } else {
                this.userName = this.nickName;
            }
            this.sex = jSONObject.optInt("sex");
            this.description = jSONObject.optString("description");
            this.portrait = jSONObject.optString("bd_portrait");
            if (StringUtils.isNull(this.portrait)) {
                this.portrait = jSONObject.optString("portrait");
            }
            this.levelId = jSONObject.optInt("level_id");
            this.levelExp = jSONObject.optInt("level_exp");
            this.location = jSONObject.optString("location");
            this.lng = jSONObject.optDouble("lng");
            this.lat = jSONObject.optDouble("lat");
            this.fansCount = jSONObject.optInt("fans_count");
            this.followCount = jSONObject.optInt("follow_count");
            this.charmCount = jSONObject.optLong("charm_count");
            this.totalPrice = jSONObject.optLong("total_price");
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
            this.isAdminOnline = jSONObject.optInt("isAdmin");
            this.isBlock = jSONObject.optInt("is_block");
            this.isUegBlock = jSONObject.optInt("ueg_block");
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
            this.isNewUser = jSONObject.optInt("is_new_user") == 1;
            praseMarkList(jSONObject);
            if (jSONObject.has("verify_video_status")) {
                this.verifyVideoStatus = jSONObject.optInt("verify_video_status");
            }
            if (jSONObject.has("is_bluediamond_member")) {
                this.isBluediamondMember = jSONObject.optInt("is_bluediamond_member");
            }
            this.throneUid = jSONObject.optString("is_guard_seat");
            this.rank = jSONObject.optInt("rank");
            this.clubMemberLevel = jSONObject.optInt("member_level");
            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                this.extraUserInfo = jSONObject.optJSONObject(TbConfig.getSubappType() + "_info");
            }
        }
    }

    private void praseMarkList(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject.has("live_mark_info_new")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.live_mark_info_new == null) {
                    this.live_mark_info_new = new ArrayList();
                }
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject);
                        this.live_mark_info_new.add(alaLiveMarkData);
                    }
                    i++;
                }
            }
        } else if (jSONObject.has("identity_icon")) {
            if (this.live_mark_info_new == null) {
                this.live_mark_info_new = new ArrayList();
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("identity_icon");
            while (i < optJSONArray2.length()) {
                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
                if (optJSONObject2 != null) {
                    AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                    alaLiveMarkData2.parserJson(optJSONObject2);
                    this.live_mark_info_new.add(alaLiveMarkData2);
                }
                i++;
            }
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mPermInfo != null) {
                jSONObject.put("user_perm", this.mPermInfo.toJsonObject());
            }
            jSONObject.put("user_id", this.userId);
            jSONObject.put("meta_key", this.metaKey);
            jSONObject.put("ala_id", this.alaId);
            jSONObject.put("user_nickname", this.nickName);
            jSONObject.put("user_name", this.userName);
            jSONObject.put("sex", this.sex);
            jSONObject.put("description", this.description);
            jSONObject.put("bd_portrait", this.portrait);
            jSONObject.put("portrait", this.portrait);
            jSONObject.put("level_id", this.levelId);
            jSONObject.put("level_exp", this.levelExp);
            jSONObject.put("location", this.location);
            jSONObject.put("lng", this.lng);
            jSONObject.put("lat", this.lat);
            jSONObject.put("fans_count", this.fansCount);
            jSONObject.put("follow_count", this.followCount);
            jSONObject.put("charm_count", this.charmCount);
            jSONObject.put("user_status", this.userStatus);
            jSONObject.put("live_status", this.liveStatus);
            jSONObject.put(ImageViewerConfig.IS_LOGIN, this.isLogin);
            jSONObject.put("live_id", this.liveId);
            jSONObject.put("create_time", this.createTime);
            jSONObject.put("change_sex", this.changeSex);
            jSONObject.put("record_count", this.recordCount);
            jSONObject.put(BdStatsConstant.StatsKey.STREAM_ID, this.streamID);
            jSONObject.put("pass_name", this.passName);
            jSONObject.put("has_tieba_username", this.hasTiebaName);
            jSONObject.put("verify_status", this.verifyStatus);
            jSONObject.put("is_official", this.isOfficial);
            jSONObject.put("next_exp", this.levelNextExp);
            jSONObject.put("is_live_admin", this.isAdmin);
            jSONObject.put("is_block", this.isBlock);
            jSONObject.put("ueg_block", this.isUegBlock);
            jSONObject.put("great_anchor_icon", this.greatAnchorIcon);
            jSONObject.put("great_anchor_desc_grade", this.greatAnchorDescGrade);
            jSONObject.put("great_anchor_desc_role", this.greatAnchorDescRole);
            jSONObject.put("verify_info_status", this.verifyInfoStatus);
            jSONObject.put("verify_video_status", this.verifyVideoStatus);
            jSONObject.put("is_bluediamond_member", this.isBluediamondMember);
            jSONObject.put("verify_type", this.verifyType);
            jSONObject.put("petal_num", this.petalNum);
            jSONObject.put("third_app_id", this.appId);
            jSONObject.put("challenge_switch", this.canUseChallenge ? 1 : 0);
            jSONObject.put("new_gift_t_dou_strategy", this.isNewGiftPriceStrategy ? 1 : 0);
            jSONObject.put("is_new_user", this.isNewUser ? 1 : 0);
            if (this.live_mark_info_new != null) {
                JSONArray jSONArray = new JSONArray();
                for (AlaLiveMarkData alaLiveMarkData : this.live_mark_info_new) {
                    jSONArray.put(alaLiveMarkData.toJsonObject());
                }
                jSONObject.put("live_mark_info_new", jSONArray);
            }
            jSONObject.put("is_guard_seat", this.throneUid);
            jSONObject.put("rank", this.rank);
            jSONObject.put("member_level", this.clubMemberLevel);
            if (this.extraUserInfo != null) {
                jSONObject.put(TbConfig.getSubappType() + "_info", this.extraUserInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String getJsonString() {
        JSONObject jsonObject = toJsonObject();
        if (jsonObject != null) {
            return jsonObject.toString();
        }
        return null;
    }
}
