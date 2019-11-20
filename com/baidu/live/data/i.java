package com.baidu.live.data;

import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i extends BaseData {
    public AlaLiveUserInfoData OR;
    public AlaLocationData OT;
    public AlaRelationData OU;
    public long OW;
    public AlaLiveUserInfoData Pj;
    public boolean Pk;
    public List<AlaLiveMarkData> Pl;
    public long Pm;
    public String Pn;
    public long Po;
    public q Pp;
    public boolean isHost;
    public AlaLiveInfoData mLiveInfo;
    public h mLiveSdkInfo;

    public i() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.OR = new AlaLiveUserInfoData();
        this.Pj = new AlaLiveUserInfoData();
        this.OU = new AlaRelationData();
        this.OT = new AlaLocationData();
        this.mLiveSdkInfo = new h();
        this.Pk = false;
        this.Pl = new ArrayList();
        this.OW = 5000L;
        this.Pp = new q();
    }

    public i(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.OR = new AlaLiveUserInfoData();
        this.Pj = new AlaLiveUserInfoData();
        this.OU = new AlaRelationData();
        this.OT = new AlaLocationData();
        this.mLiveSdkInfo = new h();
        this.Pk = false;
        this.Pl = new ArrayList();
        this.OW = 5000L;
        this.Pp = new q();
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a = a(alaLiveInfoCoreData.userInfo);
            if (a != null) {
                this.OR = a;
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("live_info");
            if (optJSONObject != null) {
                this.mLiveInfo = new AlaLiveInfoData();
                this.mLiveInfo.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.OT = new AlaLocationData();
                this.OT.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user_info");
            if (optJSONObject3 != null) {
                this.OR = new AlaLiveUserInfoData();
                this.OR.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject4 != null) {
                this.Pj = new AlaLiveUserInfoData();
                this.Pj.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject5 != null) {
                this.OU = new AlaRelationData();
                this.OU.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("task_info");
            if (optJSONObject6 != null) {
                this.Pp = new q();
                this.Pp.parserJson(optJSONObject6);
            }
            this.OW = jSONObject.optLong("interval", 5L);
            if (this.OW < 5) {
                this.OW = 5000L;
            } else {
                this.OW *= 1000;
            }
            this.Pm = jSONObject.optInt("zan_status");
            this.Pn = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject7 = optJSONArray.optJSONObject(i);
                    if (optJSONObject7 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject7);
                        this.Pl.add(alaLiveMarkData);
                    }
                }
            }
            this.Pk = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                com.baidu.live.utils.o.cY(jSONObject.optString("scene_from"));
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("sdk");
            if (optJSONObject8 != null) {
                this.mLiveSdkInfo = new h();
                this.mLiveSdkInfo.parseJson(optJSONObject8);
            }
        }
    }

    private AlaLiveUserInfoData a(com.baidu.live.tbadk.ala.AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        AlaLiveUserInfoData alaLiveUserInfoData2 = new AlaLiveUserInfoData();
        alaLiveUserInfoData2.alaId = alaLiveUserInfoData.alaId;
        alaLiveUserInfoData2.userName = alaLiveUserInfoData.userName;
        alaLiveUserInfoData2.portrait = alaLiveUserInfoData.portrait;
        alaLiveUserInfoData2.description = alaLiveUserInfoData.description;
        alaLiveUserInfoData2.isOfficial = alaLiveUserInfoData.isOfficial;
        alaLiveUserInfoData2.levelId = alaLiveUserInfoData.levelId;
        return alaLiveUserInfoData2;
    }

    public AlaLiveInfoData a(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (alaLiveInfoCoreData == null) {
            return null;
        }
        AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
        alaLiveInfoData.session_info = new AlaLiveStreamSessionInfo();
        alaLiveInfoData.group_id = alaLiveInfoCoreData.groupID;
        alaLiveInfoData.session_info.hlsUrl = alaLiveInfoCoreData.hlsUrl;
        alaLiveInfoData.session_info.rtmpUrl = alaLiveInfoCoreData.rtmpUrl;
        alaLiveInfoData.session_info.flvUrl = alaLiveInfoCoreData.flvUrl;
        alaLiveInfoData.cover = alaLiveInfoCoreData.liveCover;
        alaLiveInfoData.live_id = alaLiveInfoCoreData.liveID;
        alaLiveInfoData.description = alaLiveInfoCoreData.liveTitle;
        alaLiveInfoData.session_id = alaLiveInfoCoreData.sessionID;
        alaLiveInfoData.user_id = alaLiveInfoCoreData.userID;
        alaLiveInfoData.user_name = alaLiveInfoCoreData.userName;
        alaLiveInfoData.live_type = alaLiveInfoCoreData.liveType;
        alaLiveInfoData.screen_direction = alaLiveInfoCoreData.screenDirection;
        alaLiveInfoData.audience_count = (int) alaLiveInfoCoreData.audienceCount;
        return alaLiveInfoData;
    }
}
