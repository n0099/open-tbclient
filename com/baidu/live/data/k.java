package com.baidu.live.data;

import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k extends BaseData {
    public AlaLiveUserInfoData VP;
    public AlaLocationData VQ;
    public AlaRelationData VR;
    public long VT;
    public AlaLiveUserInfoData Wc;
    public ArrayList<AlaLiveWishListData> We;
    public boolean Wf;
    public List<AlaLiveMarkData> Wg;
    public long Wh;
    public String Wi;
    public long Wj;
    public s Wk;
    public boolean Wl;
    public boolean isHost;
    public AlaLiveInfoData mLiveInfo;
    public j mLiveSdkInfo;

    public k() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.VP = new AlaLiveUserInfoData();
        this.Wc = new AlaLiveUserInfoData();
        this.VR = new AlaRelationData();
        this.VQ = new AlaLocationData();
        this.mLiveSdkInfo = new j();
        this.We = new ArrayList<>();
        this.Wf = false;
        this.Wg = new ArrayList();
        this.VT = 5000L;
        this.Wk = new s();
    }

    public k(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.VP = new AlaLiveUserInfoData();
        this.Wc = new AlaLiveUserInfoData();
        this.VR = new AlaRelationData();
        this.VQ = new AlaLocationData();
        this.mLiveSdkInfo = new j();
        this.We = new ArrayList<>();
        this.Wf = false;
        this.Wg = new ArrayList();
        this.VT = 5000L;
        this.Wk = new s();
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a = a(alaLiveInfoCoreData.userInfo);
            if (a != null) {
                this.VP = a;
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
                this.VQ = new AlaLocationData();
                this.VQ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user_info");
            if (optJSONObject3 != null) {
                this.VP = new AlaLiveUserInfoData();
                this.VP.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject4 != null) {
                this.Wc = new AlaLiveUserInfoData();
                this.Wc.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject5 != null) {
                this.VR = new AlaRelationData();
                this.VR.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("task_info");
            if (optJSONObject6 != null) {
                this.Wk = new s();
                this.Wk.parserJson(optJSONObject6);
            }
            this.VT = jSONObject.optLong("interval", 5L);
            if (this.VT < 5) {
                this.VT = 5000L;
            } else {
                this.VT *= 1000;
            }
            this.Wh = jSONObject.optInt("zan_status");
            this.Wi = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject7 = optJSONArray.optJSONObject(i);
                    if (optJSONObject7 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject7);
                        this.Wg.add(alaLiveMarkData);
                    }
                }
            }
            this.Wf = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                com.baidu.live.utils.p.dR(jSONObject.optString("scene_from"));
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject(CashierData.SDK);
            if (optJSONObject8 != null) {
                this.mLiveSdkInfo = new j();
                this.mLiveSdkInfo.parseJson(optJSONObject8);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_wish_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    AlaLiveWishListData alaLiveWishListData = new AlaLiveWishListData();
                    alaLiveWishListData.parserJson(optJSONArray2.optJSONObject(i2));
                    this.We.add(alaLiveWishListData);
                }
            }
            this.Wl = jSONObject.optInt("switch_guard_seat") == 1;
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
