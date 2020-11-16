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
    public AlaLiveUserInfoData aHG;
    public v aHH;
    public l aHI;
    public ag aHJ;
    public AlaLiveGiftUIInfo aHK;
    public ArrayList<AlaLiveWishListData> aHL;
    public ad aHM;
    public boolean aHN;
    public boolean aHO;
    public List<AlaLiveMarkData> aHP;
    public long aHQ;
    public String aHR;
    public boolean aHS;
    public an aHT;
    public boolean aHU;
    public AlaLiveFeedDiversionData aHV;
    public c aHW;
    public String aHX;
    public String aHY;
    public cx aHZ;
    public AlaLiveUserInfoData aHk;
    public AlaLocationData aHl;
    public AlaRelationData aHm;
    public long aHp;
    public ct aIa;
    public u aIb;
    public QuickImInputData aIc;
    public boolean aId;
    public AlaWheatInfoDataWrapper aIe;
    public boolean aIf;
    public boolean aIg;
    public boolean aIh;
    public String aIi;
    public boolean aIj;
    public int aIk;
    private boolean aIl;
    public double aIm;
    public long aIn;
    public long aIo;
    public String aIp;
    public boolean aIq;
    public boolean aIr;
    private int endTime;
    public boolean isHost;
    public long logId;
    public AlaLiveInfoData mLiveInfo;
    public AlaLiveSdkInfo mLiveSdkInfo;
    public long serverTime;

    public w() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aHk = new AlaLiveUserInfoData();
        this.aHG = new AlaLiveUserInfoData();
        this.aHm = new AlaRelationData();
        this.aHl = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aHH = new v();
        this.aHJ = new ag();
        this.aHL = new ArrayList<>();
        this.aHN = false;
        this.aHO = false;
        this.aHP = new ArrayList();
        this.aHp = 5000L;
        this.aHS = false;
        this.aHT = new an();
        this.aIh = true;
        this.aIk = 6;
        this.aIl = false;
        this.aIm = 2.0d;
        this.aIn = 300L;
        this.aIo = 3399L;
        this.aIp = "";
        this.aIq = false;
        this.aIr = true;
    }

    public w(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aHk = new AlaLiveUserInfoData();
        this.aHG = new AlaLiveUserInfoData();
        this.aHm = new AlaRelationData();
        this.aHl = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aHH = new v();
        this.aHJ = new ag();
        this.aHL = new ArrayList<>();
        this.aHN = false;
        this.aHO = false;
        this.aHP = new ArrayList();
        this.aHp = 5000L;
        this.aHS = false;
        this.aHT = new an();
        this.aIh = true;
        this.aIk = 6;
        this.aIl = false;
        this.aIm = 2.0d;
        this.aIn = 300L;
        this.aIo = 3399L;
        this.aIp = "";
        this.aIq = false;
        this.aIr = true;
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a2 = a(alaLiveInfoCoreData.userInfo);
            if (a2 != null) {
                this.aHk = a2;
            }
        }
    }

    public void br(boolean z) {
        this.aIl = z;
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
                this.aHZ = new cx();
                this.aHZ.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("activity_detail");
            if (optJSONObject4 != null) {
                this.aIa = new ct();
                this.aIa.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("entry");
            if (optJSONObject5 != null) {
                this.aIg = optJSONObject5.optInt("audio_switch_moreroom") == 1;
                this.aIf = optJSONObject5.optInt("audio_switch_roomrank") == 1;
                this.aIh = optJSONObject5.optInt("audio_noble_bottom_bar") == 1;
                this.aIj = optJSONObject5.optInt("audio_switch_miliao") == 1;
                this.aIk = optJSONObject5.optInt("audio_inviting_countdown", 6);
                this.aIm = optJSONObject5.optDouble("audio_speaker_status_interval", 2.0d);
                this.aIn = optJSONObject5.optLong("audio_speaker_decibel_android", 300L);
                this.aIo = optJSONObject5.optLong("audio_xq_sweet_count", 3399L);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("location_info");
            if (optJSONObject6 != null) {
                this.aHl = new AlaLocationData();
                this.aHl.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("user_info");
            if (optJSONObject7 != null) {
                this.aHk = new AlaLiveUserInfoData();
                this.aHk.parserJson(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject8 != null) {
                this.aHG = new AlaLiveUserInfoData();
                this.aHG.parserJson(optJSONObject8);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject9 != null) {
                this.aHm = new AlaRelationData();
                this.aHm.parserJson(optJSONObject9);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("task_info");
            if (optJSONObject10 != null) {
                this.aHT = new an();
                this.aHT.parserJson(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pk_solo_info");
            if (optJSONObject11 != null) {
                this.aHM = new ad();
                this.aHM.parserJson(optJSONObject11);
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
                            this.aHN = true;
                        } else {
                            this.aHN = false;
                        }
                    }
                }
                this.endTime = -1;
                if (optString != null) {
                }
                this.aHN = true;
            } else {
                this.aHN = false;
            }
            this.aIi = jSONObject.optString("tying_gift");
            JSONObject optJSONObject13 = jSONObject.optJSONObject("tying_gift");
            if (this.aHJ != null) {
                this.aHJ = new ag();
                this.aHJ.parser(optJSONObject13);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("toutiao");
            if (optJSONObject14 != null) {
                this.aHI = new l();
                this.aHI.serverTime = this.serverTime;
                this.aHI.parser(optJSONObject14);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject15 != null) {
                this.aHH = new v();
                this.aHH.parseJson(optJSONObject15);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aHK = new AlaLiveGiftUIInfo();
                this.aHK.parserJson(optJSONObject);
            }
            this.aHp = jSONObject.optLong("interval", 5L);
            if (this.aHp < 5) {
                this.aHp = 5000L;
            } else {
                this.aHp *= 1000;
            }
            this.aHQ = jSONObject.optInt("zan_status");
            this.aHR = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject16 = optJSONArray.optJSONObject(i);
                    if (optJSONObject16 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.userLevel = this.aHk.levelId;
                        alaLiveMarkData.parserJson(optJSONObject16);
                        this.aHP.add(alaLiveMarkData);
                    }
                }
            }
            this.aHO = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                String optString2 = jSONObject.optString("scene_from");
                if (this.aIl) {
                    com.baidu.live.utils.s.iA(optString2);
                } else {
                    com.baidu.live.utils.p.iA(optString2);
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
                    this.aHL.add(alaLiveWishListData);
                }
            }
            this.aHU = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject18 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject18 != null) {
                this.aHV = new AlaLiveFeedDiversionData();
                this.aHV.parserJson(optJSONObject18);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject19 != null) {
                this.aHW = new c();
                this.aHW.parseJson(optJSONObject19);
            }
            this.aHX = jSONObject.optString("function_list");
            this.aHY = jSONObject.optString("function_list_detail");
            String optString3 = jSONObject.optString("user_info_list");
            if (optString3 != null) {
                this.aIe = new AlaWheatInfoDataWrapper(optString3);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("multi_session");
            if (optJSONObject20 != null) {
                this.aIb = u.t(optJSONObject20);
            }
            this.aIc = new QuickImInputData();
            this.aIc.parseJson(jSONObject.optJSONArray("fast_reply_word"));
            this.aId = jSONObject.optInt("disc_optimize_user_switch") == 1;
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
        return "AlaLiveShowData{mAlaLiveMultiSession=" + this.aIb + '}';
    }
}
