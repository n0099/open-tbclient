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
public class x extends BaseData {
    public AlaLiveUserInfoData aFH;
    public AlaLocationData aFI;
    public AlaRelationData aFJ;
    public long aFM;
    public v aGA;
    public QuickImInputData aGB;
    public boolean aGC;
    public AlaWheatInfoDataWrapper aGD;
    public boolean aGE;
    public boolean aGF;
    public boolean aGG;
    public String aGH;
    public boolean aGI;
    public int aGJ;
    private boolean aGK;
    public double aGL;
    public long aGM;
    public long aGN;
    public String aGO;
    public boolean aGP;
    public boolean aGQ;
    public boolean aGR;
    public ag aGS;
    public List<db> aGT;
    public AlaLiveUserInfoData aGd;
    public w aGe;
    public m aGf;
    public AlaLiveGiftUIInfo aGg;
    public d aGh;
    public ArrayList<AlaLiveWishListData> aGi;
    public af aGj;
    public boolean aGk;
    public boolean aGl;
    public int aGm;
    public boolean aGn;
    public List<AlaLiveMarkData> aGo;
    public long aGp;
    public String aGq;
    public boolean aGr;
    public aq aGs;
    public boolean aGt;
    public AlaLiveFeedDiversionData aGu;
    public b aGv;
    public String aGw;
    public String aGx;
    public dd aGy;
    public cx aGz;
    public int countDown;
    private int endTime;
    private String guardName;
    public boolean isHost;
    public long logId;
    public AlaLiveInfoData mLiveInfo;
    public AlaLiveSdkInfo mLiveSdkInfo;
    public long serverTime;
    public String url;

    public x() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aFH = new AlaLiveUserInfoData();
        this.aGd = new AlaLiveUserInfoData();
        this.aFJ = new AlaRelationData();
        this.aFI = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aGe = new w();
        this.aGi = new ArrayList<>();
        this.aGk = false;
        this.aGl = false;
        this.aGn = false;
        this.aGo = new ArrayList();
        this.aFM = 5000L;
        this.aGr = false;
        this.aGs = new aq();
        this.aGG = true;
        this.aGJ = 6;
        this.aGK = false;
        this.aGL = 2.0d;
        this.aGM = 300L;
        this.aGN = 3399L;
        this.aGO = "";
        this.aGP = false;
        this.aGQ = true;
        this.aGR = false;
    }

    public x(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aFH = new AlaLiveUserInfoData();
        this.aGd = new AlaLiveUserInfoData();
        this.aFJ = new AlaRelationData();
        this.aFI = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aGe = new w();
        this.aGi = new ArrayList<>();
        this.aGk = false;
        this.aGl = false;
        this.aGn = false;
        this.aGo = new ArrayList();
        this.aFM = 5000L;
        this.aGr = false;
        this.aGs = new aq();
        this.aGG = true;
        this.aGJ = 6;
        this.aGK = false;
        this.aGL = 2.0d;
        this.aGM = 300L;
        this.aGN = 3399L;
        this.aGO = "";
        this.aGP = false;
        this.aGQ = true;
        this.aGR = false;
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a2 = a(alaLiveInfoCoreData.userInfo);
            if (a2 != null) {
                this.aFH = a2;
            }
        }
    }

    public String getGuardName() {
        return this.guardName;
    }

    public void bs(boolean z) {
        this.aGK = z;
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
                this.aGy = new dd();
                this.aGy.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("activity_detail");
            if (optJSONObject4 != null) {
                this.aGz = new cx();
                this.aGz.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("pub_show_info");
            if (optJSONObject5 != null) {
                this.aGS = new ag();
                this.aGS.parserJson(optJSONObject5);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("mode_config");
            if (optJSONArray != null) {
                if (this.aGT == null) {
                    this.aGT = new ArrayList();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject6 = optJSONArray.optJSONObject(i);
                    if (optJSONObject6 != null) {
                        this.aGT.add(new db().F(optJSONObject6));
                    } else {
                        return;
                    }
                }
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("airdrop");
            if (optJSONObject7 != null) {
                this.aGl = true;
                this.url = optJSONObject7.optString("url");
                this.aGm = optJSONObject7.optInt("lottery_id");
                this.countDown = optJSONObject7.optInt("countdown_seconds");
            } else {
                this.aGl = false;
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("entry");
            if (optJSONObject8 != null) {
                this.aGF = optJSONObject8.optInt("audio_switch_moreroom") == 1;
                this.aGE = optJSONObject8.optInt("audio_switch_roomrank") == 1;
                this.aGG = optJSONObject8.optInt("audio_noble_bottom_bar") == 1;
                this.aGI = optJSONObject8.optInt("audio_switch_miliao") == 1;
                this.aGJ = optJSONObject8.optInt("audio_inviting_countdown", 6);
                this.aGL = optJSONObject8.optDouble("audio_speaker_status_interval", 2.0d);
                this.aGM = optJSONObject8.optLong("audio_speaker_decibel_android", 300L);
                this.aGN = optJSONObject8.optLong("audio_xq_sweet_count", 3399L);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("location_info");
            if (optJSONObject9 != null) {
                this.aFI = new AlaLocationData();
                this.aFI.parserJson(optJSONObject9);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("user_info");
            if (optJSONObject10 != null) {
                this.aFH = new AlaLiveUserInfoData();
                this.aFH.parserJson(optJSONObject10);
                List<AlaLiveMarkData> list = this.aFH.live_mark_info_new;
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
                this.aGd = new AlaLiveUserInfoData();
                this.aGd.parserJson(optJSONObject11);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject12 != null) {
                this.aFJ = new AlaRelationData();
                this.aFJ.parserJson(optJSONObject12);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("task_info");
            if (optJSONObject13 != null) {
                this.aGs = new aq();
                this.aGs.parserJson(optJSONObject13);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("pk_solo_info");
            if (optJSONObject14 != null) {
                this.aGj = new af();
                this.aGj.parserJson(optJSONObject14);
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
                            this.aGk = true;
                        } else {
                            this.aGk = false;
                        }
                    }
                }
                this.endTime = -1;
                if (optString != null) {
                }
                this.aGk = true;
            } else {
                this.aGk = false;
            }
            this.aGH = jSONObject.optString(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("toutiao");
            if (optJSONObject16 != null) {
                this.aGf = new m();
                this.aGf.serverTime = this.serverTime;
                this.aGf.parser(optJSONObject16);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject17 != null) {
                this.aGe = new w();
                this.aGe.parseJson(optJSONObject17);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aGg = new AlaLiveGiftUIInfo();
                this.aGg.parserJson(optJSONObject);
            }
            this.aFM = jSONObject.optLong("interval", 5L);
            if (this.aFM < 5) {
                this.aFM = 5000L;
            } else {
                this.aFM *= 1000;
            }
            this.aGp = jSONObject.optInt("zan_status");
            this.aGq = jSONObject.optString("user_watermark");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject18 = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject18 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.userLevel = this.aFH.levelId;
                        alaLiveMarkData.parserJson(optJSONObject18);
                        this.aGo.add(alaLiveMarkData);
                    }
                }
            }
            this.aGn = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                String optString2 = jSONObject.optString("scene_from");
                if (this.aGK) {
                    com.baidu.live.utils.t.hJ(optString2);
                } else {
                    com.baidu.live.utils.q.hJ(optString2);
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
                    this.aGi.add(alaLiveWishListData);
                }
            }
            this.aGt = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject20 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject20 != null) {
                this.aGu = new AlaLiveFeedDiversionData();
                this.aGu.parserJson(optJSONObject20);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject21 != null) {
                this.aGv = new b();
                this.aGv.parseJson(optJSONObject21);
            }
            this.aGw = jSONObject.optString("function_list");
            this.aGx = jSONObject.optString("function_list_detail");
            String optString3 = jSONObject.optString("user_info_list");
            if (optString3 != null) {
                this.aGD = new AlaWheatInfoDataWrapper(optString3);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("multi_session");
            if (optJSONObject22 != null) {
                this.aGA = v.z(optJSONObject22);
            }
            this.aGB = new QuickImInputData();
            this.aGB.parseJson(jSONObject.optJSONArray("fast_reply_word"));
            this.aGC = jSONObject.optInt("disc_optimize_user_switch") == 1;
            JSONObject optJSONObject23 = jSONObject.optJSONObject("diversion");
            if (optJSONObject23 != null) {
                this.aGh = new d();
                this.aGh.parserJson(optJSONObject23);
            }
            this.aGR = jSONObject.optInt("is_luckybag_block_user") == 1;
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
        return "AlaLiveShowData{mAlaLiveMultiSession=" + this.aGA + '}';
    }
}
