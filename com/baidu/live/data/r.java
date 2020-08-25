package com.baidu.live.data;

import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r extends BaseData {
    public AlaLiveUserInfoData aDE;
    public AlaLocationData aDF;
    public AlaRelationData aDG;
    public long aDI;
    public AlaLiveUserInfoData aEd;
    public q aEe;
    public AlaLiveGiftUIInfo aEf;
    public ArrayList<AlaLiveWishListData> aEg;
    public boolean aEh;
    public List<AlaLiveMarkData> aEi;
    public long aEj;
    public String aEk;
    public boolean aEl;
    public long aEm;
    public ae aEn;
    public boolean aEo;
    public AlaLiveFeedDiversionData aEp;
    public b aEq;
    public o aEr;
    public QuickImInputData aEs;
    public boolean isHost;
    public AlaLiveInfoData mLiveInfo;
    public p mLiveSdkInfo;

    public r() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aDE = new AlaLiveUserInfoData();
        this.aEd = new AlaLiveUserInfoData();
        this.aDG = new AlaRelationData();
        this.aDF = new AlaLocationData();
        this.mLiveSdkInfo = new p();
        this.aEe = new q();
        this.aEg = new ArrayList<>();
        this.aEh = false;
        this.aEi = new ArrayList();
        this.aDI = 5000L;
        this.aEl = false;
        this.aEn = new ae();
    }

    public r(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aDE = new AlaLiveUserInfoData();
        this.aEd = new AlaLiveUserInfoData();
        this.aDG = new AlaRelationData();
        this.aDF = new AlaLocationData();
        this.mLiveSdkInfo = new p();
        this.aEe = new q();
        this.aEg = new ArrayList<>();
        this.aEh = false;
        this.aEi = new ArrayList();
        this.aDI = 5000L;
        this.aEl = false;
        this.aEn = new ae();
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a = a(alaLiveInfoCoreData.userInfo);
            if (a != null) {
                this.aDE = a;
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
                this.aDF = new AlaLocationData();
                this.aDF.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("user_info");
            if (optJSONObject4 != null) {
                this.aDE = new AlaLiveUserInfoData();
                this.aDE.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject5 != null) {
                this.aEd = new AlaLiveUserInfoData();
                this.aEd.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject6 != null) {
                this.aDG = new AlaRelationData();
                this.aDG.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
            if (optJSONObject7 != null) {
                this.aEn = new ae();
                this.aEn.parserJson(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject8 != null) {
                this.aEe = new q();
                this.aEe.parseJson(optJSONObject8);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aEf = new AlaLiveGiftUIInfo();
                this.aEf.parserJson(optJSONObject);
            }
            this.aDI = jSONObject.optLong("interval", 5L);
            if (this.aDI < 5) {
                this.aDI = 5000L;
            } else {
                this.aDI *= 1000;
            }
            this.aEj = jSONObject.optInt("zan_status");
            this.aEk = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject9 = optJSONArray.optJSONObject(i);
                    if (optJSONObject9 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject9);
                        this.aEi.add(alaLiveMarkData);
                    }
                }
            }
            this.aEh = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                com.baidu.live.utils.p.ho(jSONObject.optString("scene_from"));
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject(CashierData.SDK);
            if (optJSONObject10 != null) {
                this.mLiveSdkInfo = new p();
                this.mLiveSdkInfo.parseJson(optJSONObject10);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_wish_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    AlaLiveWishListData alaLiveWishListData = new AlaLiveWishListData();
                    alaLiveWishListData.parserJson(optJSONArray2.optJSONObject(i2));
                    this.aEg.add(alaLiveWishListData);
                }
            }
            this.aEo = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject11 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject11 != null) {
                this.aEp = new AlaLiveFeedDiversionData();
                this.aEp.parserJson(optJSONObject11);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject12 != null) {
                this.aEq = new b();
                this.aEq.parseJson(optJSONObject12);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("multi_session");
            if (optJSONObject13 != null) {
                this.aEr = o.w(optJSONObject13);
            }
            this.aEs = new QuickImInputData();
            this.aEs.parseJson(jSONObject.optJSONArray("fast_reply_word"));
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

    public String toString() {
        return "AlaLiveShowData{mAlaLiveMultiSession=" + this.aEr + '}';
    }
}
