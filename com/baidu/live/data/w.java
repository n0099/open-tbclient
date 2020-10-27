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
    public AlaLiveUserInfoData aIA;
    public v aIB;
    public l aIC;
    public af aID;
    public AlaLiveGiftUIInfo aIE;
    public ArrayList<AlaLiveWishListData> aIF;
    public ac aIG;
    public boolean aIH;
    public boolean aII;
    public List<AlaLiveMarkData> aIJ;
    public long aIK;
    public String aIL;
    public boolean aIM;
    public am aIN;
    public boolean aIO;
    public AlaLiveFeedDiversionData aIP;
    public c aIQ;
    public String aIR;
    public ct aIS;
    public u aIT;
    public QuickImInputData aIU;
    public boolean aIV;
    public String aIW;
    public boolean aIX;
    public boolean aIY;
    public boolean aIZ;
    public AlaLiveUserInfoData aIe;
    public AlaLocationData aIf;
    public AlaRelationData aIg;
    public long aIj;
    public String aJa;
    public boolean aJb;
    public int aJc;
    private boolean aJd;
    public double aJe;
    public long aJf;
    private int endTime;
    public boolean isHost;
    public long logId;
    public AlaLiveInfoData mLiveInfo;
    public AlaLiveSdkInfo mLiveSdkInfo;
    public long serverTime;

    public w() {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aIe = new AlaLiveUserInfoData();
        this.aIA = new AlaLiveUserInfoData();
        this.aIg = new AlaRelationData();
        this.aIf = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aIB = new v();
        this.aID = new af();
        this.aIF = new ArrayList<>();
        this.aIH = false;
        this.aII = false;
        this.aIJ = new ArrayList();
        this.aIj = 5000L;
        this.aIM = false;
        this.aIN = new am();
        this.aIZ = true;
        this.aJc = 6;
        this.aJd = false;
        this.aJe = 2.0d;
        this.aJf = 300L;
    }

    public w(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aIe = new AlaLiveUserInfoData();
        this.aIA = new AlaLiveUserInfoData();
        this.aIg = new AlaRelationData();
        this.aIf = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aIB = new v();
        this.aID = new af();
        this.aIF = new ArrayList<>();
        this.aIH = false;
        this.aII = false;
        this.aIJ = new ArrayList();
        this.aIj = 5000L;
        this.aIM = false;
        this.aIN = new am();
        this.aIZ = true;
        this.aJc = 6;
        this.aJd = false;
        this.aJe = 2.0d;
        this.aJf = 300L;
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a2 = a(alaLiveInfoCoreData.userInfo);
            if (a2 != null) {
                this.aIe = a2;
            }
        }
    }

    public void bo(boolean z) {
        this.aJd = z;
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
                this.aIS = new ct();
                this.aIS.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("entry");
            if (optJSONObject4 != null) {
                this.aIY = optJSONObject4.optInt("audio_switch_moreroom") == 1;
                this.aIX = optJSONObject4.optInt("audio_switch_roomrank") == 1;
                this.aIZ = optJSONObject4.optInt("audio_noble_bottom_bar") == 1;
                this.aJb = optJSONObject4.optInt("audio_switch_miliao") == 1;
                this.aJc = optJSONObject4.optInt("audio_inviting_countdown", 6);
                this.aJe = optJSONObject4.optDouble("audio_speaker_status_interval", 2.0d);
                this.aJf = optJSONObject4.optLong("audio_speaker_decibel_android", 300L);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("location_info");
            if (optJSONObject5 != null) {
                this.aIf = new AlaLocationData();
                this.aIf.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("user_info");
            if (optJSONObject6 != null) {
                this.aIe = new AlaLiveUserInfoData();
                this.aIe.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("login_user_info");
            if (optJSONObject7 != null) {
                this.aIA = new AlaLiveUserInfoData();
                this.aIA.parserJson(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject8 != null) {
                this.aIg = new AlaRelationData();
                this.aIg.parserJson(optJSONObject8);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("task_info");
            if (optJSONObject9 != null) {
                this.aIN = new am();
                this.aIN.parserJson(optJSONObject9);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("pk_solo_info");
            if (optJSONObject10 != null) {
                this.aIG = new ac();
                this.aIG.parserJson(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pk_season_info");
            if (optJSONObject11 != null) {
                String optString = optJSONObject11.optString("show_last_time");
                if (optString != null) {
                    try {
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    if (!optString.isEmpty()) {
                        this.endTime = Integer.parseInt(optString);
                        if (optString != null || optString.isEmpty() || this.endTime > 0) {
                            this.aIH = true;
                        } else {
                            this.aIH = false;
                        }
                    }
                }
                this.endTime = -1;
                if (optString != null) {
                }
                this.aIH = true;
            } else {
                this.aIH = false;
            }
            this.aJa = jSONObject.optString("tying_gift");
            JSONObject optJSONObject12 = jSONObject.optJSONObject("tying_gift");
            if (this.aID != null) {
                this.aID = new af();
                this.aID.parser(optJSONObject12);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("toutiao");
            if (optJSONObject13 != null) {
                this.aIC = new l();
                this.aIC.serverTime = this.serverTime;
                this.aIC.parser(optJSONObject13);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject14 != null) {
                this.aIB = new v();
                this.aIB.parseJson(optJSONObject14);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aIE = new AlaLiveGiftUIInfo();
                this.aIE.parserJson(optJSONObject);
            }
            this.aIj = jSONObject.optLong("interval", 5L);
            if (this.aIj < 5) {
                this.aIj = 5000L;
            } else {
                this.aIj *= 1000;
            }
            this.aIK = jSONObject.optInt("zan_status");
            this.aIL = jSONObject.optString("user_watermark");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject15 = optJSONArray.optJSONObject(i);
                    if (optJSONObject15 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject15);
                        this.aIJ.add(alaLiveMarkData);
                    }
                }
            }
            this.aII = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                String optString2 = jSONObject.optString("scene_from");
                if (this.aJd) {
                    com.baidu.live.utils.s.in(optString2);
                } else {
                    com.baidu.live.utils.p.in(optString2);
                }
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject(CashierData.SDK);
            if (optJSONObject16 != null) {
                this.mLiveSdkInfo = new AlaLiveSdkInfo();
                this.mLiveSdkInfo.parseJson(optJSONObject16);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_wish_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    AlaLiveWishListData alaLiveWishListData = new AlaLiveWishListData();
                    alaLiveWishListData.parserJson(optJSONArray2.optJSONObject(i2));
                    this.aIF.add(alaLiveWishListData);
                }
            }
            this.aIO = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject17 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject17 != null) {
                this.aIP = new AlaLiveFeedDiversionData();
                this.aIP.parserJson(optJSONObject17);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject18 != null) {
                this.aIQ = new c();
                this.aIQ.parseJson(optJSONObject18);
            }
            this.aIR = jSONObject.optString("function_list");
            this.aIW = jSONObject.optString("user_info_list");
            JSONObject optJSONObject19 = jSONObject.optJSONObject("multi_session");
            if (optJSONObject19 != null) {
                this.aIT = u.w(optJSONObject19);
            }
            this.aIU = new QuickImInputData();
            this.aIU.parseJson(jSONObject.optJSONArray("fast_reply_word"));
            this.aIV = jSONObject.optInt("disc_optimize_user_switch") == 1;
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
        return "AlaLiveShowData{mAlaLiveMultiSession=" + this.aIT + '}';
    }
}
