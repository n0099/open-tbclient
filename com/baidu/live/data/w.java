package com.baidu.live.data;

import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class w extends BaseData {
    public AlaLiveUserInfoData aJV;
    public AlaLocationData aJW;
    public AlaRelationData aJX;
    public boolean aKA;
    public List<AlaLiveMarkData> aKB;
    public long aKC;
    public String aKD;
    public boolean aKE;
    public ao aKF;
    public boolean aKG;
    public AlaLiveFeedDiversionData aKH;
    public b aKI;
    public String aKJ;
    public String aKK;
    public cz aKL;
    public cv aKM;
    public u aKN;
    public QuickImInputData aKO;
    public boolean aKP;
    public AlaWheatInfoDataWrapper aKQ;
    public boolean aKR;
    public boolean aKS;
    public boolean aKT;
    public String aKU;
    public boolean aKV;
    public int aKW;
    private boolean aKX;
    public double aKY;
    public long aKZ;
    public long aKa;
    public AlaLiveUserInfoData aKr;
    public v aKs;
    public l aKt;
    public AlaLiveGiftUIInfo aKu;
    public d aKv;
    public ArrayList<AlaLiveWishListData> aKw;
    public ae aKx;
    public boolean aKy;
    public boolean aKz;
    public long aLa;
    public String aLb;
    public boolean aLc;
    public boolean aLd;
    public boolean aLe;
    public int countDown;
    private int endTime;
    private String guardName;
    public boolean isHost;
    public long logId;
    public AlaLiveInfoData mLiveInfo;
    public AlaLiveSdkInfo mLiveSdkInfo;
    public long serverTime;
    public String url;

    public w() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aJV = new AlaLiveUserInfoData();
        this.aKr = new AlaLiveUserInfoData();
        this.aJX = new AlaRelationData();
        this.aJW = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aKs = new v();
        this.aKw = new ArrayList<>();
        this.aKy = false;
        this.aKz = false;
        this.aKA = false;
        this.aKB = new ArrayList();
        this.aKa = 5000L;
        this.aKE = false;
        this.aKF = new ao();
        this.aKT = true;
        this.aKW = 6;
        this.aKX = false;
        this.aKY = 2.0d;
        this.aKZ = 300L;
        this.aLa = 3399L;
        this.aLb = "";
        this.aLc = false;
        this.aLd = true;
        this.aLe = false;
    }

    public w(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aJV = new AlaLiveUserInfoData();
        this.aKr = new AlaLiveUserInfoData();
        this.aJX = new AlaRelationData();
        this.aJW = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aKs = new v();
        this.aKw = new ArrayList<>();
        this.aKy = false;
        this.aKz = false;
        this.aKA = false;
        this.aKB = new ArrayList();
        this.aKa = 5000L;
        this.aKE = false;
        this.aKF = new ao();
        this.aKT = true;
        this.aKW = 6;
        this.aKX = false;
        this.aKY = 2.0d;
        this.aKZ = 300L;
        this.aLa = 3399L;
        this.aLb = "";
        this.aLc = false;
        this.aLd = true;
        this.aLe = false;
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a2 = a(alaLiveInfoCoreData.userInfo);
            if (a2 != null) {
                this.aJV = a2;
            }
        }
    }

    public String getGuardName() {
        return this.guardName;
    }

    public void bz(boolean z) {
        this.aKX = z;
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
                this.aKL = new cz();
                this.aKL.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("activity_detail");
            if (optJSONObject4 != null) {
                this.aKM = new cv();
                this.aKM.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("airdrop");
            if (optJSONObject5 != null) {
                this.aKz = true;
                this.url = optJSONObject5.optString("url");
                this.countDown = optJSONObject5.optInt("countdown_seconds");
            } else {
                this.aKz = false;
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("entry");
            if (optJSONObject6 != null) {
                this.aKS = optJSONObject6.optInt("audio_switch_moreroom") == 1;
                this.aKR = optJSONObject6.optInt("audio_switch_roomrank") == 1;
                this.aKT = optJSONObject6.optInt("audio_noble_bottom_bar") == 1;
                this.aKV = optJSONObject6.optInt("audio_switch_miliao") == 1;
                this.aKW = optJSONObject6.optInt("audio_inviting_countdown", 6);
                this.aKY = optJSONObject6.optDouble("audio_speaker_status_interval", 2.0d);
                this.aKZ = optJSONObject6.optLong("audio_speaker_decibel_android", 300L);
                this.aLa = optJSONObject6.optLong("audio_xq_sweet_count", 3399L);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("location_info");
            if (optJSONObject7 != null) {
                this.aJW = new AlaLocationData();
                this.aJW.parserJson(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("user_info");
            if (optJSONObject8 != null) {
                this.aJV = new AlaLiveUserInfoData();
                this.aJV.parserJson(optJSONObject8);
                List<AlaLiveMarkData> list = this.aJV.live_mark_info_new;
                if (list != null && !list.isEmpty()) {
                    Iterator<AlaLiveMarkData> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        AlaLiveMarkData next = it.next();
                        if (next.isGuardType()) {
                            this.guardName = next.guardName;
                            break;
                        }
                    }
                }
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject9 != null) {
                this.aKr = new AlaLiveUserInfoData();
                this.aKr.parserJson(optJSONObject9);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject10 != null) {
                this.aJX = new AlaRelationData();
                this.aJX.parserJson(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("task_info");
            if (optJSONObject11 != null) {
                this.aKF = new ao();
                this.aKF.parserJson(optJSONObject11);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("pk_solo_info");
            if (optJSONObject12 != null) {
                this.aKx = new ae();
                this.aKx.parserJson(optJSONObject12);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("pk_season_info");
            if (optJSONObject13 != null) {
                String optString = optJSONObject13.optString("show_last_time");
                if (optString != null) {
                    try {
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    if (!optString.isEmpty()) {
                        this.endTime = Integer.parseInt(optString);
                        if (optString != null || optString.isEmpty() || this.endTime > 0) {
                            this.aKy = true;
                        } else {
                            this.aKy = false;
                        }
                    }
                }
                this.endTime = -1;
                if (optString != null) {
                }
                this.aKy = true;
            } else {
                this.aKy = false;
            }
            this.aKU = jSONObject.optString("tying_gift");
            JSONObject optJSONObject14 = jSONObject.optJSONObject("toutiao");
            if (optJSONObject14 != null) {
                this.aKt = new l();
                this.aKt.serverTime = this.serverTime;
                this.aKt.parser(optJSONObject14);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject15 != null) {
                this.aKs = new v();
                this.aKs.parseJson(optJSONObject15);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aKu = new AlaLiveGiftUIInfo();
                this.aKu.parserJson(optJSONObject);
            }
            this.aKa = jSONObject.optLong("interval", 5L);
            if (this.aKa < 5) {
                this.aKa = 5000L;
            } else {
                this.aKa *= 1000;
            }
            this.aKC = jSONObject.optInt("zan_status");
            this.aKD = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject16 = optJSONArray.optJSONObject(i);
                    if (optJSONObject16 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.userLevel = this.aJV.levelId;
                        alaLiveMarkData.parserJson(optJSONObject16);
                        this.aKB.add(alaLiveMarkData);
                    }
                }
            }
            this.aKA = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                String optString2 = jSONObject.optString("scene_from");
                if (this.aKX) {
                    com.baidu.live.utils.s.je(optString2);
                } else {
                    com.baidu.live.utils.p.je(optString2);
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
                    this.aKw.add(alaLiveWishListData);
                }
            }
            this.aKG = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject18 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject18 != null) {
                this.aKH = new AlaLiveFeedDiversionData();
                this.aKH.parserJson(optJSONObject18);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject19 != null) {
                this.aKI = new b();
                this.aKI.parseJson(optJSONObject19);
            }
            this.aKJ = jSONObject.optString("function_list");
            this.aKK = jSONObject.optString("function_list_detail");
            String optString3 = jSONObject.optString("user_info_list");
            if (optString3 != null) {
                this.aKQ = new AlaWheatInfoDataWrapper(optString3);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("multi_session");
            if (optJSONObject20 != null) {
                this.aKN = u.t(optJSONObject20);
            }
            this.aKO = new QuickImInputData();
            this.aKO.parseJson(jSONObject.optJSONArray("fast_reply_word"));
            this.aKP = jSONObject.optInt("disc_optimize_user_switch") == 1;
            JSONObject optJSONObject21 = jSONObject.optJSONObject("diversion");
            if (optJSONObject21 != null) {
                this.aKv = new d();
                this.aKv.parserJson(optJSONObject21);
            }
            this.aLe = jSONObject.optInt("is_luckybag_block_user") == 1;
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
        return "AlaLiveShowData{mAlaLiveMultiSession=" + this.aKN + '}';
    }
}
