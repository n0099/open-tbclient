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
    public AlaLiveUserInfoData Ya;
    public AlaLocationData Yb;
    public AlaRelationData Yc;
    public long Ye;
    public AlaLiveUserInfoData Yo;
    public l Yp;
    public ArrayList<AlaLiveWishListData> Yq;
    public boolean Yr;
    public List<AlaLiveMarkData> Ys;
    public long Yt;
    public String Yu;
    public boolean Yv;
    public long Yw;
    public v Yx;
    public boolean Yy;
    public AlaLiveFeedDiversionData Yz;
    public boolean isHost;
    public AlaLiveInfoData mLiveInfo;
    public k mLiveSdkInfo;

    public m() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.Ya = new AlaLiveUserInfoData();
        this.Yo = new AlaLiveUserInfoData();
        this.Yc = new AlaRelationData();
        this.Yb = new AlaLocationData();
        this.mLiveSdkInfo = new k();
        this.Yp = new l();
        this.Yq = new ArrayList<>();
        this.Yr = false;
        this.Ys = new ArrayList();
        this.Ye = 5000L;
        this.Yv = false;
        this.Yx = new v();
    }

    public m(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.Ya = new AlaLiveUserInfoData();
        this.Yo = new AlaLiveUserInfoData();
        this.Yc = new AlaRelationData();
        this.Yb = new AlaLocationData();
        this.mLiveSdkInfo = new k();
        this.Yp = new l();
        this.Yq = new ArrayList<>();
        this.Yr = false;
        this.Ys = new ArrayList();
        this.Ye = 5000L;
        this.Yv = false;
        this.Yx = new v();
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a = a(alaLiveInfoCoreData.userInfo);
            if (a != null) {
                this.Ya = a;
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
                this.Yb = new AlaLocationData();
                this.Yb.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user_info");
            if (optJSONObject3 != null) {
                this.Ya = new AlaLiveUserInfoData();
                this.Ya.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject4 != null) {
                this.Yo = new AlaLiveUserInfoData();
                this.Yo.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject5 != null) {
                this.Yc = new AlaRelationData();
                this.Yc.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("task_info");
            if (optJSONObject6 != null) {
                this.Yx = new v();
                this.Yx.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject7 != null) {
                this.Yp = new l();
                this.Yp.parseJson(optJSONObject7);
            }
            this.Ye = jSONObject.optLong("interval", 5L);
            if (this.Ye < 5) {
                this.Ye = 5000L;
            } else {
                this.Ye *= 1000;
            }
            this.Yt = jSONObject.optInt("zan_status");
            this.Yu = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject8 = optJSONArray.optJSONObject(i);
                    if (optJSONObject8 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject8);
                        this.Ys.add(alaLiveMarkData);
                    }
                }
            }
            this.Yr = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                com.baidu.live.utils.q.eh(jSONObject.optString("scene_from"));
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
                    this.Yq.add(alaLiveWishListData);
                }
            }
            this.Yy = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject10 != null) {
                this.Yz = new AlaLiveFeedDiversionData();
                this.Yz.parserJson(optJSONObject10);
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
