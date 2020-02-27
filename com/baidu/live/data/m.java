package com.baidu.live.data;

import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends BaseData {
    public AlaLiveUserInfoData XQ;
    public AlaLocationData XR;
    public AlaRelationData XS;
    public long XU;
    public AlaLiveUserInfoData Ye;
    public l Yf;
    public ArrayList<AlaLiveWishListData> Yg;
    public boolean Yh;
    public List<AlaLiveMarkData> Yi;
    public long Yj;
    public String Yk;
    public boolean Yl;
    public long Ym;
    public v Yn;
    public boolean Yo;
    public AlaLiveFeedDiversionData Yp;
    public boolean isHost;
    public AlaLiveInfoData mLiveInfo;
    public k mLiveSdkInfo;

    public m() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.XQ = new AlaLiveUserInfoData();
        this.Ye = new AlaLiveUserInfoData();
        this.XS = new AlaRelationData();
        this.XR = new AlaLocationData();
        this.mLiveSdkInfo = new k();
        this.Yf = new l();
        this.Yg = new ArrayList<>();
        this.Yh = false;
        this.Yi = new ArrayList();
        this.XU = 5000L;
        this.Yl = false;
        this.Yn = new v();
    }

    public m(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.XQ = new AlaLiveUserInfoData();
        this.Ye = new AlaLiveUserInfoData();
        this.XS = new AlaRelationData();
        this.XR = new AlaLocationData();
        this.mLiveSdkInfo = new k();
        this.Yf = new l();
        this.Yg = new ArrayList<>();
        this.Yh = false;
        this.Yi = new ArrayList();
        this.XU = 5000L;
        this.Yl = false;
        this.Yn = new v();
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a = a(alaLiveInfoCoreData.userInfo);
            if (a != null) {
                this.XQ = a;
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
                this.XR = new AlaLocationData();
                this.XR.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user_info");
            if (optJSONObject3 != null) {
                this.XQ = new AlaLiveUserInfoData();
                this.XQ.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject4 != null) {
                this.Ye = new AlaLiveUserInfoData();
                this.Ye.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject5 != null) {
                this.XS = new AlaRelationData();
                this.XS.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("task_info");
            if (optJSONObject6 != null) {
                this.Yn = new v();
                this.Yn.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject7 != null) {
                this.Yf = new l();
                this.Yf.parseJson(optJSONObject7);
            }
            this.XU = jSONObject.optLong("interval", 5L);
            if (this.XU < 5) {
                this.XU = 5000L;
            } else {
                this.XU *= 1000;
            }
            this.Yj = jSONObject.optInt("zan_status");
            this.Yk = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject8 = optJSONArray.optJSONObject(i);
                    if (optJSONObject8 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject8);
                        this.Yi.add(alaLiveMarkData);
                    }
                }
            }
            this.Yh = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                com.baidu.live.utils.q.ei(jSONObject.optString("scene_from"));
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject(CashierData.SDK);
            if (optJSONObject9 != null) {
                this.mLiveSdkInfo = new k();
                this.mLiveSdkInfo.parseJson(optJSONObject9);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_wish_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    AlaLiveWishListData alaLiveWishListData = new AlaLiveWishListData();
                    alaLiveWishListData.parserJson(optJSONArray2.optJSONObject(i2));
                    this.Yg.add(alaLiveWishListData);
                }
            }
            this.Yo = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject10 != null) {
                this.Yp = new AlaLiveFeedDiversionData();
                this.Yp.parserJson(optJSONObject10);
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
