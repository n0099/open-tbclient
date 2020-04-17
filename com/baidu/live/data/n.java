package com.baidu.live.data;

import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n extends BaseData {
    public ArrayList<AlaLiveWishListData> aqA;
    public boolean aqB;
    public List<AlaLiveMarkData> aqC;
    public long aqD;
    public String aqE;
    public boolean aqF;
    public long aqG;
    public x aqH;
    public boolean aqI;
    public AlaLiveFeedDiversionData aqJ;
    public AlaLiveUserInfoData aqe;
    public AlaLocationData aqf;
    public AlaRelationData aqg;
    public long aqi;
    public AlaLiveUserInfoData aqx;
    public m aqy;
    public AlaLiveGiftUIInfo aqz;
    public boolean isHost;
    public AlaLiveInfoData mLiveInfo;
    public l mLiveSdkInfo;

    public n() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aqe = new AlaLiveUserInfoData();
        this.aqx = new AlaLiveUserInfoData();
        this.aqg = new AlaRelationData();
        this.aqf = new AlaLocationData();
        this.mLiveSdkInfo = new l();
        this.aqy = new m();
        this.aqA = new ArrayList<>();
        this.aqB = false;
        this.aqC = new ArrayList();
        this.aqi = 5000L;
        this.aqF = false;
        this.aqH = new x();
    }

    public n(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aqe = new AlaLiveUserInfoData();
        this.aqx = new AlaLiveUserInfoData();
        this.aqg = new AlaRelationData();
        this.aqf = new AlaLocationData();
        this.mLiveSdkInfo = new l();
        this.aqy = new m();
        this.aqA = new ArrayList<>();
        this.aqB = false;
        this.aqC = new ArrayList();
        this.aqi = 5000L;
        this.aqF = false;
        this.aqH = new x();
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a = a(alaLiveInfoCoreData.userInfo);
            if (a != null) {
                this.aqe = a;
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.mLiveInfo = new AlaLiveInfoData();
                this.mLiveInfo.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("location_info");
            if (optJSONObject3 != null) {
                this.aqf = new AlaLocationData();
                this.aqf.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("user_info");
            if (optJSONObject4 != null) {
                this.aqe = new AlaLiveUserInfoData();
                this.aqe.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject5 != null) {
                this.aqx = new AlaLiveUserInfoData();
                this.aqx.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject6 != null) {
                this.aqg = new AlaRelationData();
                this.aqg.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
            if (optJSONObject7 != null) {
                this.aqH = new x();
                this.aqH.parserJson(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject8 != null) {
                this.aqy = new m();
                this.aqy.parseJson(optJSONObject8);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aqz = new AlaLiveGiftUIInfo();
                this.aqz.parserJson(optJSONObject);
            }
            this.aqi = jSONObject.optLong("interval", 5L);
            if (this.aqi < 5) {
                this.aqi = 5000L;
            } else {
                this.aqi *= 1000;
            }
            this.aqD = jSONObject.optInt("zan_status");
            this.aqE = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject9 = optJSONArray.optJSONObject(i);
                    if (optJSONObject9 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject9);
                        this.aqC.add(alaLiveMarkData);
                    }
                }
            }
            this.aqB = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                com.baidu.live.utils.q.fa(jSONObject.optString("scene_from"));
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject(CashierData.SDK);
            if (optJSONObject10 != null) {
                this.mLiveSdkInfo = new l();
                this.mLiveSdkInfo.parseJson(optJSONObject10);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_wish_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    AlaLiveWishListData alaLiveWishListData = new AlaLiveWishListData();
                    alaLiveWishListData.parserJson(optJSONArray2.optJSONObject(i2));
                    this.aqA.add(alaLiveWishListData);
                }
            }
            this.aqI = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject11 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject11 != null) {
                this.aqJ = new AlaLiveFeedDiversionData();
                this.aqJ.parserJson(optJSONObject11);
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
