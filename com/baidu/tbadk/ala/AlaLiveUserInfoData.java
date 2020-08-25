package com.baidu.tbadk.ala;

import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.m;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.AlaUserInfo;
/* loaded from: classes2.dex */
public class AlaLiveUserInfoData extends m implements Serializable {
    private static final long serialVersionUID = -3860430259513905402L;
    public long alaId;
    public long anchorLive;
    public long charmCount;
    public String description;
    public long enterLive;
    public String greatAnchorDescGrade;
    public String greatAnchorDescRole;
    public String greatAnchorIcon;
    public int isOfficial;
    public double lat;
    public long levelExp;
    public int levelId;
    public long liveId;
    public int liveStatus;
    public double lng;
    public String location;
    public String portrait;
    public String sex;
    public int updateTime;
    public String userName;
    public String verifyStatus;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
    }

    public void parserProtoBuf(AlaUserInfo alaUserInfo) {
        if (alaUserInfo != null) {
            this.alaId = alaUserInfo.ala_id.longValue();
            this.userName = alaUserInfo.user_name;
            this.portrait = alaUserInfo.portrait;
            this.description = alaUserInfo.description;
            this.sex = alaUserInfo.sex;
            this.enterLive = alaUserInfo.enter_live.longValue();
            this.anchorLive = alaUserInfo.anchor_live.longValue();
            this.liveStatus = alaUserInfo.live_status.intValue();
            this.liveId = alaUserInfo.live_id.longValue();
            this.location = alaUserInfo.location;
            this.lng = alaUserInfo.lng.doubleValue();
            this.lat = alaUserInfo.lat.doubleValue();
            this.updateTime = alaUserInfo.update_time.intValue();
            this.charmCount = alaUserInfo.charm_count.longValue();
            this.levelExp = alaUserInfo.level_exp.longValue();
            this.isOfficial = alaUserInfo.is_official.intValue();
            this.verifyStatus = alaUserInfo.verify_status;
            this.levelId = alaUserInfo.level_id.intValue();
            this.greatAnchorIcon = alaUserInfo.great_anchor_icon;
            this.greatAnchorDescGrade = alaUserInfo.great_anchor_desc_grade;
            this.greatAnchorDescRole = alaUserInfo.great_anchor_desc_role;
        }
    }

    public void convertFromAlaUserInfoData(AlaUserInfoData alaUserInfoData) {
        if (alaUserInfoData != null) {
            this.alaId = alaUserInfoData.ala_id;
            this.userName = alaUserInfoData.user_name;
            this.portrait = alaUserInfoData.portrait;
            this.description = alaUserInfoData.description;
            this.sex = alaUserInfoData.sex;
            this.enterLive = alaUserInfoData.enter_live;
            this.anchorLive = alaUserInfoData.anchor_live;
            this.liveStatus = alaUserInfoData.live_status;
            this.liveId = alaUserInfoData.live_id;
            this.location = alaUserInfoData.location;
            this.lng = alaUserInfoData.lng;
            this.lat = alaUserInfoData.lat;
            this.updateTime = alaUserInfoData.update_time;
            this.charmCount = alaUserInfoData.charm_count;
            this.levelExp = alaUserInfoData.level_exp;
            this.isOfficial = alaUserInfoData.is_official;
            this.verifyStatus = alaUserInfoData.verify_status;
            this.levelId = alaUserInfoData.level_id;
            this.greatAnchorIcon = alaUserInfoData.great_anchor_icon;
            this.greatAnchorDescGrade = alaUserInfoData.great_anchor_desc_grade;
            this.greatAnchorDescRole = alaUserInfoData.great_anchor_desc_role;
        }
    }
}
