package com.baidu.live.tbadk.ala;

import android.net.http.Headers;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.AlaUserInfoData;
import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaLiveUserInfoData extends BaseData implements Serializable {
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

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.alaId = jSONObject.optLong("ala_id");
            this.userName = jSONObject.optString("user_name");
            this.portrait = jSONObject.optString("bd_portrait");
            if (StringUtils.isNull(this.portrait)) {
                this.portrait = jSONObject.optString("portrait");
            }
            this.description = jSONObject.optString("description");
            this.sex = jSONObject.optString("sex");
            this.enterLive = jSONObject.optLong("enter_live");
            this.anchorLive = jSONObject.optLong("anchor_live");
            this.liveStatus = jSONObject.optInt("live_status");
            this.liveId = jSONObject.optLong("live_id");
            this.location = jSONObject.optString(Headers.LOCATION);
            this.lng = jSONObject.optLong("lng");
            this.lat = jSONObject.optLong("lat");
            this.updateTime = jSONObject.optInt("update_time");
            this.charmCount = jSONObject.optLong("charm_count");
            this.levelExp = jSONObject.optLong("level_exp");
            this.isOfficial = jSONObject.optInt("is_official");
            this.verifyStatus = jSONObject.optString("verify_status");
            this.levelId = jSONObject.optInt("level_id");
            this.greatAnchorIcon = jSONObject.optString("great_anchor_icon");
            this.greatAnchorDescGrade = jSONObject.optString("great_anchor_desc_grade");
            this.greatAnchorDescRole = jSONObject.optString("great_anchor_desc_role");
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
