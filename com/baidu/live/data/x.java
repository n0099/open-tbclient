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
/* loaded from: classes11.dex */
public class x extends BaseData {
    public AlaLiveUserInfoData aKQ;
    public w aKR;
    public m aKS;
    public AlaLiveGiftUIInfo aKT;
    public d aKU;
    public ArrayList<AlaLiveWishListData> aKV;
    public af aKW;
    public boolean aKX;
    public boolean aKY;
    public int aKZ;
    public AlaLiveUserInfoData aKu;
    public AlaLocationData aKv;
    public AlaRelationData aKw;
    public long aKz;
    public long aLA;
    public String aLB;
    public boolean aLC;
    public boolean aLD;
    public boolean aLE;
    public ag aLF;
    public List<db> aLG;
    public boolean aLa;
    public List<AlaLiveMarkData> aLb;
    public long aLc;
    public String aLd;
    public boolean aLe;
    public aq aLf;
    public boolean aLg;
    public AlaLiveFeedDiversionData aLh;
    public b aLi;
    public String aLj;
    public String aLk;
    public dd aLl;
    public cx aLm;
    public v aLn;
    public QuickImInputData aLo;
    public boolean aLp;
    public AlaWheatInfoDataWrapper aLq;
    public boolean aLr;
    public boolean aLs;
    public boolean aLt;
    public String aLu;
    public boolean aLv;
    public int aLw;
    private boolean aLx;
    public double aLy;
    public long aLz;
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
        this.aKu = new AlaLiveUserInfoData();
        this.aKQ = new AlaLiveUserInfoData();
        this.aKw = new AlaRelationData();
        this.aKv = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aKR = new w();
        this.aKV = new ArrayList<>();
        this.aKX = false;
        this.aKY = false;
        this.aLa = false;
        this.aLb = new ArrayList();
        this.aKz = 5000L;
        this.aLe = false;
        this.aLf = new aq();
        this.aLt = true;
        this.aLw = 6;
        this.aLx = false;
        this.aLy = 2.0d;
        this.aLz = 300L;
        this.aLA = 3399L;
        this.aLB = "";
        this.aLC = false;
        this.aLD = true;
        this.aLE = false;
    }

    public x(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aKu = new AlaLiveUserInfoData();
        this.aKQ = new AlaLiveUserInfoData();
        this.aKw = new AlaRelationData();
        this.aKv = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aKR = new w();
        this.aKV = new ArrayList<>();
        this.aKX = false;
        this.aKY = false;
        this.aLa = false;
        this.aLb = new ArrayList();
        this.aKz = 5000L;
        this.aLe = false;
        this.aLf = new aq();
        this.aLt = true;
        this.aLw = 6;
        this.aLx = false;
        this.aLy = 2.0d;
        this.aLz = 300L;
        this.aLA = 3399L;
        this.aLB = "";
        this.aLC = false;
        this.aLD = true;
        this.aLE = false;
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a2 = a(alaLiveInfoCoreData.userInfo);
            if (a2 != null) {
                this.aKu = a2;
            }
        }
    }

    public String getGuardName() {
        return this.guardName;
    }

    public void bw(boolean z) {
        this.aLx = z;
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
                this.aLl = new dd();
                this.aLl.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("activity_detail");
            if (optJSONObject4 != null) {
                this.aLm = new cx();
                this.aLm.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("pub_show_info");
            if (optJSONObject5 != null) {
                this.aLF = new ag();
                this.aLF.parserJson(optJSONObject5);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("mode_config");
            if (optJSONArray != null) {
                if (this.aLG == null) {
                    this.aLG = new ArrayList();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject6 = optJSONArray.optJSONObject(i);
                    if (optJSONObject6 != null) {
                        this.aLG.add(new db().F(optJSONObject6));
                    } else {
                        return;
                    }
                }
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("airdrop");
            if (optJSONObject7 != null) {
                this.aKY = true;
                this.url = optJSONObject7.optString("url");
                this.aKZ = optJSONObject7.optInt("lottery_id");
                this.countDown = optJSONObject7.optInt("countdown_seconds");
            } else {
                this.aKY = false;
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("entry");
            if (optJSONObject8 != null) {
                this.aLs = optJSONObject8.optInt("audio_switch_moreroom") == 1;
                this.aLr = optJSONObject8.optInt("audio_switch_roomrank") == 1;
                this.aLt = optJSONObject8.optInt("audio_noble_bottom_bar") == 1;
                this.aLv = optJSONObject8.optInt("audio_switch_miliao") == 1;
                this.aLw = optJSONObject8.optInt("audio_inviting_countdown", 6);
                this.aLy = optJSONObject8.optDouble("audio_speaker_status_interval", 2.0d);
                this.aLz = optJSONObject8.optLong("audio_speaker_decibel_android", 300L);
                this.aLA = optJSONObject8.optLong("audio_xq_sweet_count", 3399L);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("location_info");
            if (optJSONObject9 != null) {
                this.aKv = new AlaLocationData();
                this.aKv.parserJson(optJSONObject9);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("user_info");
            if (optJSONObject10 != null) {
                this.aKu = new AlaLiveUserInfoData();
                this.aKu.parserJson(optJSONObject10);
                List<AlaLiveMarkData> list = this.aKu.live_mark_info_new;
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
                this.aKQ = new AlaLiveUserInfoData();
                this.aKQ.parserJson(optJSONObject11);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject12 != null) {
                this.aKw = new AlaRelationData();
                this.aKw.parserJson(optJSONObject12);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("task_info");
            if (optJSONObject13 != null) {
                this.aLf = new aq();
                this.aLf.parserJson(optJSONObject13);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("pk_solo_info");
            if (optJSONObject14 != null) {
                this.aKW = new af();
                this.aKW.parserJson(optJSONObject14);
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
                            this.aKX = true;
                        } else {
                            this.aKX = false;
                        }
                    }
                }
                this.endTime = -1;
                if (optString != null) {
                }
                this.aKX = true;
            } else {
                this.aKX = false;
            }
            this.aLu = jSONObject.optString(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("toutiao");
            if (optJSONObject16 != null) {
                this.aKS = new m();
                this.aKS.serverTime = this.serverTime;
                this.aKS.parser(optJSONObject16);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject17 != null) {
                this.aKR = new w();
                this.aKR.parseJson(optJSONObject17);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aKT = new AlaLiveGiftUIInfo();
                this.aKT.parserJson(optJSONObject);
            }
            this.aKz = jSONObject.optLong("interval", 5L);
            if (this.aKz < 5) {
                this.aKz = 5000L;
            } else {
                this.aKz *= 1000;
            }
            this.aLc = jSONObject.optInt("zan_status");
            this.aLd = jSONObject.optString("user_watermark");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject18 = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject18 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.userLevel = this.aKu.levelId;
                        alaLiveMarkData.parserJson(optJSONObject18);
                        this.aLb.add(alaLiveMarkData);
                    }
                }
            }
            this.aLa = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                String optString2 = jSONObject.optString("scene_from");
                if (this.aLx) {
                    com.baidu.live.utils.t.iU(optString2);
                } else {
                    com.baidu.live.utils.q.iU(optString2);
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
                    this.aKV.add(alaLiveWishListData);
                }
            }
            this.aLg = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject20 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject20 != null) {
                this.aLh = new AlaLiveFeedDiversionData();
                this.aLh.parserJson(optJSONObject20);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject21 != null) {
                this.aLi = new b();
                this.aLi.parseJson(optJSONObject21);
            }
            this.aLj = jSONObject.optString("function_list");
            this.aLk = jSONObject.optString("function_list_detail");
            String optString3 = jSONObject.optString("user_info_list");
            if (optString3 != null) {
                this.aLq = new AlaWheatInfoDataWrapper(optString3);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("multi_session");
            if (optJSONObject22 != null) {
                this.aLn = v.z(optJSONObject22);
            }
            this.aLo = new QuickImInputData();
            this.aLo.parseJson(jSONObject.optJSONArray("fast_reply_word"));
            this.aLp = jSONObject.optInt("disc_optimize_user_switch") == 1;
            JSONObject optJSONObject23 = jSONObject.optJSONObject("diversion");
            if (optJSONObject23 != null) {
                this.aKU = new d();
                this.aKU.parserJson(optJSONObject23);
            }
            this.aLE = jSONObject.optInt("is_luckybag_block_user") == 1;
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
        return "AlaLiveShowData{mAlaLiveMultiSession=" + this.aLn + '}';
    }
}
