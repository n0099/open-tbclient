package com.baidu.live.data;

import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ab extends BaseData {
    public AlaLiveUserInfoData aJD;
    public AlaLocationData aJE;
    public AlaRelationData aJF;
    public long aJI;
    public AlaLiveUserInfoData aJZ;
    public boolean aKA;
    public boolean aKB;
    public String aKC;
    public boolean aKD;
    public int aKE;
    private boolean aKF;
    public double aKG;
    public long aKH;
    public long aKI;
    public long aKJ;
    public boolean aKK;
    public long aKL;
    public String aKM;
    public boolean aKN;
    public boolean aKO;
    public boolean aKP;
    public ak aKQ;
    public List<dh> aKR;
    public int aKS;
    public int aKT;
    public int aKU;
    public int aKV;
    public boolean aKW;
    public aa aKa;
    public q aKb;
    public AlaLiveGiftUIInfo aKc;
    public d aKd;
    public ArrayList<AlaLiveWishListData> aKe;
    public aj aKf;
    public boolean aKg;
    public boolean aKh;
    public int aKi;
    public boolean aKj;
    public List<AlaLiveMarkData> aKk;
    public long aKl;
    public String aKm;
    public boolean aKn;
    public au aKo;
    public boolean aKp;
    public AlaLiveFeedDiversionData aKq;
    public b aKr;
    public String aKs;
    public String aKt;
    public dj aKu;
    public dd aKv;
    public z aKw;
    public QuickImInputData aKx;
    public AlaWheatInfoDataWrapper aKy;
    public boolean aKz;
    public int countDown;
    private int endTime;
    private String guardName;
    public boolean isHost;
    public long logId;
    public AlaLiveInfoData mLiveInfo;
    public AlaLiveSdkInfo mLiveSdkInfo;
    public long serverTime;
    public String url;

    public ab() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aJD = new AlaLiveUserInfoData();
        this.aJZ = new AlaLiveUserInfoData();
        this.aJF = new AlaRelationData();
        this.aJE = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aKa = new aa();
        this.aKe = new ArrayList<>();
        this.aKg = false;
        this.aKh = false;
        this.aKj = false;
        this.aKk = new ArrayList();
        this.aJI = 5000L;
        this.aKn = false;
        this.aKo = new au();
        this.aKB = true;
        this.aKE = 6;
        this.aKF = false;
        this.aKG = 2.0d;
        this.aKH = 300L;
        this.aKI = 50L;
        this.aKJ = 5L;
        this.aKL = 3399L;
        this.aKM = "";
        this.aKN = false;
        this.aKO = true;
        this.aKP = false;
        this.aKT = 1;
        this.aKV = 1;
    }

    public ab(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aJD = new AlaLiveUserInfoData();
        this.aJZ = new AlaLiveUserInfoData();
        this.aJF = new AlaRelationData();
        this.aJE = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aKa = new aa();
        this.aKe = new ArrayList<>();
        this.aKg = false;
        this.aKh = false;
        this.aKj = false;
        this.aKk = new ArrayList();
        this.aJI = 5000L;
        this.aKn = false;
        this.aKo = new au();
        this.aKB = true;
        this.aKE = 6;
        this.aKF = false;
        this.aKG = 2.0d;
        this.aKH = 300L;
        this.aKI = 50L;
        this.aKJ = 5L;
        this.aKL = 3399L;
        this.aKM = "";
        this.aKN = false;
        this.aKO = true;
        this.aKP = false;
        this.aKT = 1;
        this.aKV = 1;
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a2 = a(alaLiveInfoCoreData.userInfo);
            if (a2 != null) {
                this.aJD = a2;
            }
        }
    }

    public String getGuardName() {
        return this.guardName;
    }

    public void bx(boolean z) {
        this.aKF = z;
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
                this.aKu = new dj();
                this.aKu.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("activity_detail");
            if (optJSONObject4 != null) {
                this.aKv = new dd();
                this.aKv.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("pub_show_info");
            if (optJSONObject5 != null) {
                this.aKQ = new ak();
                this.aKQ.parserJson(optJSONObject5);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("mode_config");
            if (optJSONArray != null) {
                if (this.aKR == null) {
                    this.aKR = new ArrayList();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject6 = optJSONArray.optJSONObject(i);
                    if (optJSONObject6 != null) {
                        this.aKR.add(new dh().H(optJSONObject6));
                    } else {
                        return;
                    }
                }
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("airdrop");
            if (optJSONObject7 != null) {
                this.aKh = true;
                this.url = optJSONObject7.optString("url");
                this.aKi = optJSONObject7.optInt("lottery_id");
                this.countDown = optJSONObject7.optInt("countdown_seconds");
            } else {
                this.aKh = false;
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("entry");
            if (optJSONObject8 != null) {
                this.aKA = optJSONObject8.optInt("audio_switch_moreroom") == 1;
                this.aKz = optJSONObject8.optInt("audio_switch_roomrank") == 1;
                this.aKB = optJSONObject8.optInt("audio_noble_bottom_bar") == 1;
                this.aKD = optJSONObject8.optInt("audio_switch_miliao") == 1;
                this.aKE = optJSONObject8.optInt("audio_inviting_countdown", 6);
                this.aKG = optJSONObject8.optDouble("audio_speaker_status_interval", 2.0d);
                this.aKH = optJSONObject8.optLong("audio_speaker_decibel_android", 300L);
                this.aKI = optJSONObject8.optLong("audio_speaker_decibel_android_yy", 50L);
                this.aKJ = optJSONObject8.optLong("audio_speaker_decibel_android_bd", 5L);
                this.aKK = optJSONObject8.optInt("is_bdrtc_aec_by_soft", 1) == 1;
                this.aKL = optJSONObject8.optLong("audio_xq_sweet_count", 3399L);
                this.aKS = optJSONObject8.optInt("phone_frame_msg_time", 5);
                this.aKT = optJSONObject8.optInt("phone_frame_msg_show", 1);
                this.aKU = optJSONObject8.optInt("phone_frame_bubble_time", 5);
                this.aKV = optJSONObject8.optInt("phone_frame_bubble_show", 1);
                this.aKW = optJSONObject8.optInt("audio_ugc_switch_charmrank", 0) == 1;
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("location_info");
            if (optJSONObject9 != null) {
                this.aJE = new AlaLocationData();
                this.aJE.parserJson(optJSONObject9);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("user_info");
            if (optJSONObject10 != null) {
                this.aJD = new AlaLiveUserInfoData();
                this.aJD.parserJson(optJSONObject10);
                List<AlaLiveMarkData> list = this.aJD.live_mark_info_new;
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
            JSONObject optJSONObject11 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject11 != null) {
                this.aJZ = new AlaLiveUserInfoData();
                this.aJZ.parserJson(optJSONObject11);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject12 != null) {
                this.aJF = new AlaRelationData();
                this.aJF.parserJson(optJSONObject12);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("task_info");
            if (optJSONObject13 != null) {
                this.aKo = new au();
                this.aKo.parserJson(optJSONObject13);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("pk_solo_info");
            if (optJSONObject14 != null) {
                this.aKf = new aj();
                this.aKf.parserJson(optJSONObject14);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("pk_season_info");
            if (optJSONObject15 != null) {
                String optString = optJSONObject15.optString("show_last_time");
                if (optString != null) {
                    try {
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    if (!optString.isEmpty()) {
                        this.endTime = Integer.parseInt(optString);
                        if (optString != null || optString.isEmpty() || this.endTime > 0) {
                            this.aKg = true;
                        } else {
                            this.aKg = false;
                        }
                    }
                }
                this.endTime = -1;
                if (optString != null) {
                }
                this.aKg = true;
            } else {
                this.aKg = false;
            }
            this.aKC = jSONObject.optString(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("toutiao");
            if (optJSONObject16 != null) {
                this.aKb = new q();
                this.aKb.serverTime = this.serverTime;
                this.aKb.parser(optJSONObject16);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject17 != null) {
                this.aKa = new aa();
                this.aKa.parseJson(optJSONObject17);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aKc = new AlaLiveGiftUIInfo();
                this.aKc.parserJson(optJSONObject);
            }
            this.aJI = jSONObject.optLong("interval", 5L);
            if (this.aJI < 5) {
                this.aJI = 5000L;
            } else {
                this.aJI *= 1000;
            }
            this.aKl = jSONObject.optInt("zan_status");
            this.aKm = jSONObject.optString("user_watermark");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject18 = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject18 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.userLevel = this.aJD.levelId;
                        alaLiveMarkData.parserJson(optJSONObject18);
                        this.aKk.add(alaLiveMarkData);
                    }
                }
            }
            this.aKj = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                String optString2 = jSONObject.optString("scene_from");
                if (this.aKF) {
                    com.baidu.live.utils.t.ik(optString2);
                } else {
                    com.baidu.live.utils.q.ik(optString2);
                }
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject(CashierData.SDK);
            if (optJSONObject19 != null) {
                this.mLiveSdkInfo = new AlaLiveSdkInfo();
                this.mLiveSdkInfo.parseJson(optJSONObject19);
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("live_wish_list");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    AlaLiveWishListData alaLiveWishListData = new AlaLiveWishListData();
                    alaLiveWishListData.parserJson(optJSONArray3.optJSONObject(i3));
                    this.aKe.add(alaLiveWishListData);
                }
            }
            this.aKp = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject20 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject20 != null) {
                this.aKq = new AlaLiveFeedDiversionData();
                this.aKq.parserJson(optJSONObject20);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject21 != null) {
                this.aKr = new b();
                this.aKr.parseJson(optJSONObject21);
            }
            this.aKs = jSONObject.optString("function_list");
            this.aKt = jSONObject.optString("function_list_detail");
            String optString3 = jSONObject.optString("user_info_list");
            if (optString3 != null) {
                this.aKy = new AlaWheatInfoDataWrapper(optString3);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("multi_session");
            if (optJSONObject22 != null) {
                this.aKw = z.B(optJSONObject22);
            }
            this.aKx = new QuickImInputData();
            this.aKx.parseJson(jSONObject.optJSONArray("fast_reply_word"));
            JSONObject optJSONObject23 = jSONObject.optJSONObject("diversion");
            if (optJSONObject23 != null) {
                this.aKd = new d();
                this.aKd.parserJson(optJSONObject23);
            }
            this.aKP = jSONObject.optInt("is_luckybag_block_user") == 1;
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
        return "AlaLiveShowData{mAlaLiveMultiSession=" + this.aKw + '}';
    }
}
