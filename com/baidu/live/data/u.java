package com.baidu.live.data;

import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class u extends BaseData {
    public AlaLiveUserInfoData aHD;
    public AlaLocationData aHE;
    public AlaRelationData aHF;
    public long aHI;
    public boolean aIA;
    public boolean aIB;
    public boolean aIC;
    public int aID;
    private boolean aIE;
    public AlaLiveUserInfoData aIf;
    public t aIg;
    public AlaLiveGiftUIInfo aIh;
    public ArrayList<AlaLiveWishListData> aIi;
    public aa aIj;
    public boolean aIk;
    public boolean aIl;
    public List<AlaLiveMarkData> aIm;
    public long aIn;
    public String aIo;
    public boolean aIp;
    public aj aIq;
    public boolean aIr;
    public AlaLiveFeedDiversionData aIs;
    public c aIt;
    public String aIu;
    public cm aIv;
    public r aIw;
    public QuickImInputData aIx;
    public String aIy;
    public boolean aIz;
    private int endTime;
    public boolean isHost;
    public long logId;
    public AlaLiveInfoData mLiveInfo;
    public s mLiveSdkInfo;

    public u() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aHD = new AlaLiveUserInfoData();
        this.aIf = new AlaLiveUserInfoData();
        this.aHF = new AlaRelationData();
        this.aHE = new AlaLocationData();
        this.mLiveSdkInfo = new s();
        this.aIg = new t();
        this.aIi = new ArrayList<>();
        this.aIk = false;
        this.aIl = false;
        this.aIm = new ArrayList();
        this.aHI = 5000L;
        this.aIp = false;
        this.aIq = new aj();
        this.aIB = true;
        this.aID = 6;
        this.aIE = false;
    }

    public u(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aHD = new AlaLiveUserInfoData();
        this.aIf = new AlaLiveUserInfoData();
        this.aHF = new AlaRelationData();
        this.aHE = new AlaLocationData();
        this.mLiveSdkInfo = new s();
        this.aIg = new t();
        this.aIi = new ArrayList<>();
        this.aIk = false;
        this.aIl = false;
        this.aIm = new ArrayList();
        this.aHI = 5000L;
        this.aIp = false;
        this.aIq = new aj();
        this.aIB = true;
        this.aID = 6;
        this.aIE = false;
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a2 = a(alaLiveInfoCoreData.userInfo);
            if (a2 != null) {
                this.aHD = a2;
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
            JSONObject optJSONObject3 = jSONObject.optJSONObject("room_info");
            if (optJSONObject3 != null) {
                this.aIv = new cm();
                this.aIv.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("entry");
            if (optJSONObject4 != null) {
                this.aIA = optJSONObject4.optInt("audio_switch_moreroom") == 1;
                this.aIz = optJSONObject4.optInt("audio_switch_roomrank") == 1;
                this.aIB = optJSONObject4.optInt("audio_noble_bottom_bar") == 1;
                this.aIC = optJSONObject4.optInt("audio_switch_miliao") == 1;
                this.aID = optJSONObject4.optInt("audio_inviting_countdown", 6);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("location_info");
            if (optJSONObject5 != null) {
                this.aHE = new AlaLocationData();
                this.aHE.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("user_info");
            if (optJSONObject6 != null) {
                this.aHD = new AlaLiveUserInfoData();
                this.aHD.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject7 != null) {
                this.aIf = new AlaLiveUserInfoData();
                this.aIf.parserJson(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject8 != null) {
                this.aHF = new AlaRelationData();
                this.aHF.parserJson(optJSONObject8);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("task_info");
            if (optJSONObject9 != null) {
                this.aIq = new aj();
                this.aIq.parserJson(optJSONObject9);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("pk_solo_info");
            if (optJSONObject10 != null) {
                this.aIj = new aa();
                this.aIj.parserJson(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pk_season_info");
            if (optJSONObject11 != null) {
                String optString = optJSONObject11.optString("show_last_time");
                try {
                    this.endTime = Integer.parseInt(optString);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if (optString == null || optString.isEmpty() || this.endTime > 0) {
                    this.aIk = true;
                } else {
                    this.aIk = false;
                }
            } else {
                this.aIk = false;
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject12 != null) {
                this.aIg = new t();
                this.aIg.parseJson(optJSONObject12);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aIh = new AlaLiveGiftUIInfo();
                this.aIh.parserJson(optJSONObject);
            }
            this.aHI = jSONObject.optLong("interval", 5L);
            if (this.aHI < 5) {
                this.aHI = 5000L;
            } else {
                this.aHI *= 1000;
            }
            this.aIn = jSONObject.optInt("zan_status");
            this.aIo = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject13 = optJSONArray.optJSONObject(i);
                    if (optJSONObject13 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject13);
                        this.aIm.add(alaLiveMarkData);
                    }
                }
            }
            this.aIl = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                String optString2 = jSONObject.optString("scene_from");
                if (this.aIE) {
                    com.baidu.live.utils.t.hW(optString2);
                } else {
                    com.baidu.live.utils.p.hW(optString2);
                }
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject(CashierData.SDK);
            if (optJSONObject14 != null) {
                this.mLiveSdkInfo = new s();
                this.mLiveSdkInfo.parseJson(optJSONObject14);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_wish_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    AlaLiveWishListData alaLiveWishListData = new AlaLiveWishListData();
                    alaLiveWishListData.parserJson(optJSONArray2.optJSONObject(i2));
                    this.aIi.add(alaLiveWishListData);
                }
            }
            this.aIr = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject15 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject15 != null) {
                this.aIs = new AlaLiveFeedDiversionData();
                this.aIs.parserJson(optJSONObject15);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject16 != null) {
                this.aIt = new c();
                this.aIt.parseJson(optJSONObject16);
            }
            this.aIu = jSONObject.optString("function_list");
            this.aIy = jSONObject.optString("user_info_list");
            JSONObject optJSONObject17 = jSONObject.optJSONObject("multi_session");
            if (optJSONObject17 != null) {
                this.aIw = r.w(optJSONObject17);
            }
            this.aIx = new QuickImInputData();
            this.aIx.parseJson(jSONObject.optJSONArray("fast_reply_word"));
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
        return "AlaLiveShowData{mAlaLiveMultiSession=" + this.aIw + '}';
    }
}
