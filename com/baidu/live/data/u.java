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
    public AlaLocationData aEA;
    public AlaRelationData aEB;
    public long aEE;
    public AlaLiveUserInfoData aEz;
    private boolean aFA;
    public AlaLiveUserInfoData aFb;
    public t aFc;
    public AlaLiveGiftUIInfo aFd;
    public ArrayList<AlaLiveWishListData> aFe;
    public aa aFf;
    public boolean aFg;
    public boolean aFh;
    public List<AlaLiveMarkData> aFi;
    public long aFj;
    public String aFk;
    public boolean aFl;
    public aj aFm;
    public boolean aFn;
    public AlaLiveFeedDiversionData aFo;
    public c aFp;
    public String aFq;
    public cl aFr;
    public r aFs;
    public QuickImInputData aFt;
    public String aFu;
    public boolean aFv;
    public boolean aFw;
    public boolean aFx;
    public boolean aFy;
    public int aFz;
    private int endTime;
    public boolean isHost;
    public long logId;
    public AlaLiveInfoData mLiveInfo;
    public s mLiveSdkInfo;

    public u() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aEz = new AlaLiveUserInfoData();
        this.aFb = new AlaLiveUserInfoData();
        this.aEB = new AlaRelationData();
        this.aEA = new AlaLocationData();
        this.mLiveSdkInfo = new s();
        this.aFc = new t();
        this.aFe = new ArrayList<>();
        this.aFg = false;
        this.aFh = false;
        this.aFi = new ArrayList();
        this.aEE = 5000L;
        this.aFl = false;
        this.aFm = new aj();
        this.aFx = true;
        this.aFz = 6;
        this.aFA = false;
    }

    public u(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aEz = new AlaLiveUserInfoData();
        this.aFb = new AlaLiveUserInfoData();
        this.aEB = new AlaRelationData();
        this.aEA = new AlaLocationData();
        this.mLiveSdkInfo = new s();
        this.aFc = new t();
        this.aFe = new ArrayList<>();
        this.aFg = false;
        this.aFh = false;
        this.aFi = new ArrayList();
        this.aEE = 5000L;
        this.aFl = false;
        this.aFm = new aj();
        this.aFx = true;
        this.aFz = 6;
        this.aFA = false;
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a = a(alaLiveInfoCoreData.userInfo);
            if (a != null) {
                this.aEz = a;
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
                this.aFr = new cl();
                this.aFr.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("entry");
            if (optJSONObject4 != null) {
                this.aFw = optJSONObject4.optInt("audio_switch_moreroom") == 1;
                this.aFv = optJSONObject4.optInt("audio_switch_roomrank") == 1;
                this.aFx = optJSONObject4.optInt("audio_noble_bottom_bar") == 1;
                this.aFy = optJSONObject4.optInt("audio_switch_miliao") == 1;
                this.aFz = optJSONObject4.optInt("audio_inviting_countdown", 6);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("location_info");
            if (optJSONObject5 != null) {
                this.aEA = new AlaLocationData();
                this.aEA.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("user_info");
            if (optJSONObject6 != null) {
                this.aEz = new AlaLiveUserInfoData();
                this.aEz.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject7 != null) {
                this.aFb = new AlaLiveUserInfoData();
                this.aFb.parserJson(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject8 != null) {
                this.aEB = new AlaRelationData();
                this.aEB.parserJson(optJSONObject8);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("task_info");
            if (optJSONObject9 != null) {
                this.aFm = new aj();
                this.aFm.parserJson(optJSONObject9);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("pk_solo_info");
            if (optJSONObject10 != null) {
                this.aFf = new aa();
                this.aFf.parserJson(optJSONObject10);
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
                    this.aFg = true;
                } else {
                    this.aFg = false;
                }
            } else {
                this.aFg = false;
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject12 != null) {
                this.aFc = new t();
                this.aFc.parseJson(optJSONObject12);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aFd = new AlaLiveGiftUIInfo();
                this.aFd.parserJson(optJSONObject);
            }
            this.aEE = jSONObject.optLong("interval", 5L);
            if (this.aEE < 5) {
                this.aEE = 5000L;
            } else {
                this.aEE *= 1000;
            }
            this.aFj = jSONObject.optInt("zan_status");
            this.aFk = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject13 = optJSONArray.optJSONObject(i);
                    if (optJSONObject13 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject13);
                        this.aFi.add(alaLiveMarkData);
                    }
                }
            }
            this.aFh = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                String optString2 = jSONObject.optString("scene_from");
                if (this.aFA) {
                    com.baidu.live.utils.t.hF(optString2);
                } else {
                    com.baidu.live.utils.p.hF(optString2);
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
                    this.aFe.add(alaLiveWishListData);
                }
            }
            this.aFn = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject15 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject15 != null) {
                this.aFo = new AlaLiveFeedDiversionData();
                this.aFo.parserJson(optJSONObject15);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject16 != null) {
                this.aFp = new c();
                this.aFp.parseJson(optJSONObject16);
            }
            this.aFq = jSONObject.optString("function_list");
            this.aFu = jSONObject.optString("user_info_list");
            JSONObject optJSONObject17 = jSONObject.optJSONObject("multi_session");
            if (optJSONObject17 != null) {
                this.aFs = r.w(optJSONObject17);
            }
            this.aFt = new QuickImInputData();
            this.aFt.parseJson(jSONObject.optJSONArray("fast_reply_word"));
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
        return "AlaLiveShowData{mAlaLiveMultiSession=" + this.aFs + '}';
    }
}
