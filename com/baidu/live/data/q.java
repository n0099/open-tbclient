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
public class q extends BaseData {
    public AlaLiveUserInfoData avC;
    public p avD;
    public AlaLiveGiftUIInfo avE;
    public ArrayList<AlaLiveWishListData> avF;
    public boolean avG;
    public List<AlaLiveMarkData> avH;
    public long avI;
    public String avJ;
    public boolean avK;
    public long avL;
    public ab avM;
    public boolean avN;
    public AlaLiveFeedDiversionData avO;
    public b avP;
    public AlaLiveUserInfoData avj;
    public AlaLocationData avk;
    public AlaRelationData avl;
    public long avn;
    public boolean isHost;
    public AlaLiveInfoData mLiveInfo;
    public o mLiveSdkInfo;

    public q() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.avj = new AlaLiveUserInfoData();
        this.avC = new AlaLiveUserInfoData();
        this.avl = new AlaRelationData();
        this.avk = new AlaLocationData();
        this.mLiveSdkInfo = new o();
        this.avD = new p();
        this.avF = new ArrayList<>();
        this.avG = false;
        this.avH = new ArrayList();
        this.avn = 5000L;
        this.avK = false;
        this.avM = new ab();
    }

    public q(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.avj = new AlaLiveUserInfoData();
        this.avC = new AlaLiveUserInfoData();
        this.avl = new AlaRelationData();
        this.avk = new AlaLocationData();
        this.mLiveSdkInfo = new o();
        this.avD = new p();
        this.avF = new ArrayList<>();
        this.avG = false;
        this.avH = new ArrayList();
        this.avn = 5000L;
        this.avK = false;
        this.avM = new ab();
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a = a(alaLiveInfoCoreData.userInfo);
            if (a != null) {
                this.avj = a;
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
                this.avk = new AlaLocationData();
                this.avk.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("user_info");
            if (optJSONObject4 != null) {
                this.avj = new AlaLiveUserInfoData();
                this.avj.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject5 != null) {
                this.avC = new AlaLiveUserInfoData();
                this.avC.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject6 != null) {
                this.avl = new AlaRelationData();
                this.avl.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
            if (optJSONObject7 != null) {
                this.avM = new ab();
                this.avM.parserJson(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject8 != null) {
                this.avD = new p();
                this.avD.parseJson(optJSONObject8);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.avE = new AlaLiveGiftUIInfo();
                this.avE.parserJson(optJSONObject);
            }
            this.avn = jSONObject.optLong("interval", 5L);
            if (this.avn < 5) {
                this.avn = 5000L;
            } else {
                this.avn *= 1000;
            }
            this.avI = jSONObject.optInt("zan_status");
            this.avJ = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject9 = optJSONArray.optJSONObject(i);
                    if (optJSONObject9 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject9);
                        this.avH.add(alaLiveMarkData);
                    }
                }
            }
            this.avG = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                com.baidu.live.utils.q.fM(jSONObject.optString("scene_from"));
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject(CashierData.SDK);
            if (optJSONObject10 != null) {
                this.mLiveSdkInfo = new o();
                this.mLiveSdkInfo.parseJson(optJSONObject10);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_wish_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    AlaLiveWishListData alaLiveWishListData = new AlaLiveWishListData();
                    alaLiveWishListData.parserJson(optJSONArray2.optJSONObject(i2));
                    this.avF.add(alaLiveWishListData);
                }
            }
            this.avN = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject11 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject11 != null) {
                this.avO = new AlaLiveFeedDiversionData();
                this.avO.parserJson(optJSONObject11);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject12 != null) {
                this.avP = new b();
                this.avP.parseJson(optJSONObject12);
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
