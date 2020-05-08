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
    public AlaLiveUserInfoData aqD;
    public m aqE;
    public AlaLiveGiftUIInfo aqF;
    public ArrayList<AlaLiveWishListData> aqG;
    public boolean aqH;
    public List<AlaLiveMarkData> aqI;
    public long aqJ;
    public String aqK;
    public boolean aqL;
    public long aqM;
    public x aqN;
    public boolean aqO;
    public AlaLiveFeedDiversionData aqP;
    public AlaLiveUserInfoData aqk;
    public AlaLocationData aql;
    public AlaRelationData aqm;
    public long aqo;
    public boolean isHost;
    public AlaLiveInfoData mLiveInfo;
    public l mLiveSdkInfo;

    public n() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aqk = new AlaLiveUserInfoData();
        this.aqD = new AlaLiveUserInfoData();
        this.aqm = new AlaRelationData();
        this.aql = new AlaLocationData();
        this.mLiveSdkInfo = new l();
        this.aqE = new m();
        this.aqG = new ArrayList<>();
        this.aqH = false;
        this.aqI = new ArrayList();
        this.aqo = 5000L;
        this.aqL = false;
        this.aqN = new x();
    }

    public n(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aqk = new AlaLiveUserInfoData();
        this.aqD = new AlaLiveUserInfoData();
        this.aqm = new AlaRelationData();
        this.aql = new AlaLocationData();
        this.mLiveSdkInfo = new l();
        this.aqE = new m();
        this.aqG = new ArrayList<>();
        this.aqH = false;
        this.aqI = new ArrayList();
        this.aqo = 5000L;
        this.aqL = false;
        this.aqN = new x();
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a = a(alaLiveInfoCoreData.userInfo);
            if (a != null) {
                this.aqk = a;
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
                this.aql = new AlaLocationData();
                this.aql.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("user_info");
            if (optJSONObject4 != null) {
                this.aqk = new AlaLiveUserInfoData();
                this.aqk.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject5 != null) {
                this.aqD = new AlaLiveUserInfoData();
                this.aqD.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject6 != null) {
                this.aqm = new AlaRelationData();
                this.aqm.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
            if (optJSONObject7 != null) {
                this.aqN = new x();
                this.aqN.parserJson(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject8 != null) {
                this.aqE = new m();
                this.aqE.parseJson(optJSONObject8);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aqF = new AlaLiveGiftUIInfo();
                this.aqF.parserJson(optJSONObject);
            }
            this.aqo = jSONObject.optLong("interval", 5L);
            if (this.aqo < 5) {
                this.aqo = 5000L;
            } else {
                this.aqo *= 1000;
            }
            this.aqJ = jSONObject.optInt("zan_status");
            this.aqK = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject9 = optJSONArray.optJSONObject(i);
                    if (optJSONObject9 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject9);
                        this.aqI.add(alaLiveMarkData);
                    }
                }
            }
            this.aqH = jSONObject.optInt("need_renew_mark_info", 0) == 1;
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
                    this.aqG.add(alaLiveWishListData);
                }
            }
            this.aqO = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject11 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject11 != null) {
                this.aqP = new AlaLiveFeedDiversionData();
                this.aqP.parserJson(optJSONObject11);
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
