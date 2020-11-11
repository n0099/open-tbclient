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
public class w extends BaseData {
    public AlaLiveUserInfoData aIV;
    public AlaLocationData aIW;
    public AlaRelationData aIX;
    public List<AlaLiveMarkData> aJA;
    public long aJB;
    public String aJC;
    public boolean aJD;
    public an aJE;
    public boolean aJF;
    public AlaLiveFeedDiversionData aJG;
    public c aJH;
    public String aJI;
    public String aJJ;
    public cx aJK;
    public ct aJL;
    public u aJM;
    public QuickImInputData aJN;
    public boolean aJO;
    public AlaWheatInfoDataWrapper aJP;
    public boolean aJQ;
    public boolean aJR;
    public boolean aJS;
    public String aJT;
    public boolean aJU;
    public int aJV;
    private boolean aJW;
    public double aJX;
    public long aJY;
    public long aJZ;
    public long aJa;
    public AlaLiveUserInfoData aJr;
    public v aJs;
    public l aJt;
    public ag aJu;
    public AlaLiveGiftUIInfo aJv;
    public ArrayList<AlaLiveWishListData> aJw;
    public ad aJx;
    public boolean aJy;
    public boolean aJz;
    public String aKa;
    public boolean aKb;
    public boolean aKc;
    private int endTime;
    public boolean isHost;
    public long logId;
    public AlaLiveInfoData mLiveInfo;
    public AlaLiveSdkInfo mLiveSdkInfo;
    public long serverTime;

    public w() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aIV = new AlaLiveUserInfoData();
        this.aJr = new AlaLiveUserInfoData();
        this.aIX = new AlaRelationData();
        this.aIW = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aJs = new v();
        this.aJu = new ag();
        this.aJw = new ArrayList<>();
        this.aJy = false;
        this.aJz = false;
        this.aJA = new ArrayList();
        this.aJa = 5000L;
        this.aJD = false;
        this.aJE = new an();
        this.aJS = true;
        this.aJV = 6;
        this.aJW = false;
        this.aJX = 2.0d;
        this.aJY = 300L;
        this.aJZ = 3399L;
        this.aKa = "";
        this.aKb = false;
        this.aKc = true;
    }

    public w(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aIV = new AlaLiveUserInfoData();
        this.aJr = new AlaLiveUserInfoData();
        this.aIX = new AlaRelationData();
        this.aIW = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aJs = new v();
        this.aJu = new ag();
        this.aJw = new ArrayList<>();
        this.aJy = false;
        this.aJz = false;
        this.aJA = new ArrayList();
        this.aJa = 5000L;
        this.aJD = false;
        this.aJE = new an();
        this.aJS = true;
        this.aJV = 6;
        this.aJW = false;
        this.aJX = 2.0d;
        this.aJY = 300L;
        this.aJZ = 3399L;
        this.aKa = "";
        this.aKb = false;
        this.aKc = true;
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a2 = a(alaLiveInfoCoreData.userInfo);
            if (a2 != null) {
                this.aIV = a2;
            }
        }
    }

    public void bp(boolean z) {
        this.aJW = z;
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
                this.aJK = new cx();
                this.aJK.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("activity_detail");
            if (optJSONObject4 != null) {
                this.aJL = new ct();
                this.aJL.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("entry");
            if (optJSONObject5 != null) {
                this.aJR = optJSONObject5.optInt("audio_switch_moreroom") == 1;
                this.aJQ = optJSONObject5.optInt("audio_switch_roomrank") == 1;
                this.aJS = optJSONObject5.optInt("audio_noble_bottom_bar") == 1;
                this.aJU = optJSONObject5.optInt("audio_switch_miliao") == 1;
                this.aJV = optJSONObject5.optInt("audio_inviting_countdown", 6);
                this.aJX = optJSONObject5.optDouble("audio_speaker_status_interval", 2.0d);
                this.aJY = optJSONObject5.optLong("audio_speaker_decibel_android", 300L);
                this.aJZ = optJSONObject5.optLong("audio_xq_sweet_count", 3399L);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("location_info");
            if (optJSONObject6 != null) {
                this.aIW = new AlaLocationData();
                this.aIW.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("user_info");
            if (optJSONObject7 != null) {
                this.aIV = new AlaLiveUserInfoData();
                this.aIV.parserJson(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject8 != null) {
                this.aJr = new AlaLiveUserInfoData();
                this.aJr.parserJson(optJSONObject8);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject9 != null) {
                this.aIX = new AlaRelationData();
                this.aIX.parserJson(optJSONObject9);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("task_info");
            if (optJSONObject10 != null) {
                this.aJE = new an();
                this.aJE.parserJson(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pk_solo_info");
            if (optJSONObject11 != null) {
                this.aJx = new ad();
                this.aJx.parserJson(optJSONObject11);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("pk_season_info");
            if (optJSONObject12 != null) {
                String optString = optJSONObject12.optString("show_last_time");
                if (optString != null) {
                    try {
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    if (!optString.isEmpty()) {
                        this.endTime = Integer.parseInt(optString);
                        if (optString != null || optString.isEmpty() || this.endTime > 0) {
                            this.aJy = true;
                        } else {
                            this.aJy = false;
                        }
                    }
                }
                this.endTime = -1;
                if (optString != null) {
                }
                this.aJy = true;
            } else {
                this.aJy = false;
            }
            this.aJT = jSONObject.optString("tying_gift");
            JSONObject optJSONObject13 = jSONObject.optJSONObject("tying_gift");
            if (this.aJu != null) {
                this.aJu = new ag();
                this.aJu.parser(optJSONObject13);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("toutiao");
            if (optJSONObject14 != null) {
                this.aJt = new l();
                this.aJt.serverTime = this.serverTime;
                this.aJt.parser(optJSONObject14);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject15 != null) {
                this.aJs = new v();
                this.aJs.parseJson(optJSONObject15);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aJv = new AlaLiveGiftUIInfo();
                this.aJv.parserJson(optJSONObject);
            }
            this.aJa = jSONObject.optLong("interval", 5L);
            if (this.aJa < 5) {
                this.aJa = 5000L;
            } else {
                this.aJa *= 1000;
            }
            this.aJB = jSONObject.optInt("zan_status");
            this.aJC = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject16 = optJSONArray.optJSONObject(i);
                    if (optJSONObject16 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.userLevel = this.aIV.levelId;
                        alaLiveMarkData.parserJson(optJSONObject16);
                        this.aJA.add(alaLiveMarkData);
                    }
                }
            }
            this.aJz = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                String optString2 = jSONObject.optString("scene_from");
                if (this.aJW) {
                    com.baidu.live.utils.s.iG(optString2);
                } else {
                    com.baidu.live.utils.p.iG(optString2);
                }
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject(CashierData.SDK);
            if (optJSONObject17 != null) {
                this.mLiveSdkInfo = new AlaLiveSdkInfo();
                this.mLiveSdkInfo.parseJson(optJSONObject17);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_wish_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    AlaLiveWishListData alaLiveWishListData = new AlaLiveWishListData();
                    alaLiveWishListData.parserJson(optJSONArray2.optJSONObject(i2));
                    this.aJw.add(alaLiveWishListData);
                }
            }
            this.aJF = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject18 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject18 != null) {
                this.aJG = new AlaLiveFeedDiversionData();
                this.aJG.parserJson(optJSONObject18);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject19 != null) {
                this.aJH = new c();
                this.aJH.parseJson(optJSONObject19);
            }
            this.aJI = jSONObject.optString("function_list");
            this.aJJ = jSONObject.optString("function_list_detail");
            String optString3 = jSONObject.optString("user_info_list");
            if (optString3 != null) {
                this.aJP = new AlaWheatInfoDataWrapper(optString3);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("multi_session");
            if (optJSONObject20 != null) {
                this.aJM = u.z(optJSONObject20);
            }
            this.aJN = new QuickImInputData();
            this.aJN.parseJson(jSONObject.optJSONArray("fast_reply_word"));
            this.aJO = jSONObject.optInt("disc_optimize_user_switch") == 1;
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
        return "AlaLiveShowData{mAlaLiveMultiSession=" + this.aJM + '}';
    }
}
