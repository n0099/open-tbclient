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
public class ab extends BaseData {
    public aa aIA;
    public q aIB;
    public AlaLiveGiftUIInfo aIC;
    public d aID;
    public ArrayList<AlaLiveWishListData> aIE;
    public aj aIF;
    public boolean aIG;
    public boolean aIH;
    public int aII;
    public boolean aIJ;
    public List<AlaLiveMarkData> aIK;
    public long aIL;
    public String aIM;
    public boolean aIN;
    public au aIO;
    public boolean aIP;
    public AlaLiveFeedDiversionData aIQ;
    public b aIR;
    public String aIS;
    public String aIT;
    public dj aIU;
    public dd aIV;
    public z aIW;
    public QuickImInputData aIX;
    public AlaWheatInfoDataWrapper aIY;
    public boolean aIZ;
    public AlaLiveUserInfoData aId;
    public AlaLocationData aIe;
    public AlaRelationData aIf;
    public long aIi;
    public AlaLiveUserInfoData aIz;
    public boolean aJa;
    public boolean aJb;
    public String aJc;
    public boolean aJd;
    public int aJe;
    private boolean aJf;
    public double aJg;
    public long aJh;
    public long aJi;
    public long aJj;
    public boolean aJk;
    public long aJl;
    public String aJm;
    public boolean aJn;
    public boolean aJo;
    public boolean aJp;
    public ak aJq;
    public List<dh> aJr;
    public int aJs;
    public int aJt;
    public int aJu;
    public int aJv;
    public boolean aJw;
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
        this.aId = new AlaLiveUserInfoData();
        this.aIz = new AlaLiveUserInfoData();
        this.aIf = new AlaRelationData();
        this.aIe = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aIA = new aa();
        this.aIE = new ArrayList<>();
        this.aIG = false;
        this.aIH = false;
        this.aIJ = false;
        this.aIK = new ArrayList();
        this.aIi = 5000L;
        this.aIN = false;
        this.aIO = new au();
        this.aJb = true;
        this.aJe = 6;
        this.aJf = false;
        this.aJg = 2.0d;
        this.aJh = 300L;
        this.aJi = 50L;
        this.aJj = 5L;
        this.aJl = 3399L;
        this.aJm = "";
        this.aJn = false;
        this.aJo = true;
        this.aJp = false;
        this.aJt = 1;
        this.aJv = 1;
    }

    public ab(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        this.mLiveInfo = new AlaLiveInfoData();
        this.aId = new AlaLiveUserInfoData();
        this.aIz = new AlaLiveUserInfoData();
        this.aIf = new AlaRelationData();
        this.aIe = new AlaLocationData();
        this.mLiveSdkInfo = new AlaLiveSdkInfo();
        this.aIA = new aa();
        this.aIE = new ArrayList<>();
        this.aIG = false;
        this.aIH = false;
        this.aIJ = false;
        this.aIK = new ArrayList();
        this.aIi = 5000L;
        this.aIN = false;
        this.aIO = new au();
        this.aJb = true;
        this.aJe = 6;
        this.aJf = false;
        this.aJg = 2.0d;
        this.aJh = 300L;
        this.aJi = 50L;
        this.aJj = 5L;
        this.aJl = 3399L;
        this.aJm = "";
        this.aJn = false;
        this.aJo = true;
        this.aJp = false;
        this.aJt = 1;
        this.aJv = 1;
        if (alaLiveInfoCoreData != null) {
            this.mLiveInfo = a(alaLiveInfoCoreData);
            AlaLiveUserInfoData a2 = a(alaLiveInfoCoreData.userInfo);
            if (a2 != null) {
                this.aId = a2;
            }
        }
    }

    public String getGuardName() {
        return this.guardName;
    }

    public void bx(boolean z) {
        this.aJf = z;
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
                this.aIU = new dj();
                this.aIU.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("activity_detail");
            if (optJSONObject4 != null) {
                this.aIV = new dd();
                this.aIV.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("pub_show_info");
            if (optJSONObject5 != null) {
                this.aJq = new ak();
                this.aJq.parserJson(optJSONObject5);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("mode_config");
            if (optJSONArray != null) {
                if (this.aJr == null) {
                    this.aJr = new ArrayList();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject6 = optJSONArray.optJSONObject(i);
                    if (optJSONObject6 != null) {
                        this.aJr.add(new dh().F(optJSONObject6));
                    } else {
                        return;
                    }
                }
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("airdrop");
            if (optJSONObject7 != null) {
                this.aIH = true;
                this.url = optJSONObject7.optString("url");
                this.aII = optJSONObject7.optInt("lottery_id");
                this.countDown = optJSONObject7.optInt("countdown_seconds");
            } else {
                this.aIH = false;
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("entry");
            if (optJSONObject8 != null) {
                this.aJa = optJSONObject8.optInt("audio_switch_moreroom") == 1;
                this.aIZ = optJSONObject8.optInt("audio_switch_roomrank") == 1;
                this.aJb = optJSONObject8.optInt("audio_noble_bottom_bar") == 1;
                this.aJd = optJSONObject8.optInt("audio_switch_miliao") == 1;
                this.aJe = optJSONObject8.optInt("audio_inviting_countdown", 6);
                this.aJg = optJSONObject8.optDouble("audio_speaker_status_interval", 2.0d);
                this.aJh = optJSONObject8.optLong("audio_speaker_decibel_android", 300L);
                this.aJi = optJSONObject8.optLong("audio_speaker_decibel_android_yy", 50L);
                this.aJj = optJSONObject8.optLong("audio_speaker_decibel_android_bd", 5L);
                this.aJk = optJSONObject8.optInt("is_bdrtc_aec_by_soft", 1) == 1;
                this.aJl = optJSONObject8.optLong("audio_xq_sweet_count", 3399L);
                this.aJs = optJSONObject8.optInt("phone_frame_msg_time", 5);
                this.aJt = optJSONObject8.optInt("phone_frame_msg_show", 1);
                this.aJu = optJSONObject8.optInt("phone_frame_bubble_time", 5);
                this.aJv = optJSONObject8.optInt("phone_frame_bubble_show", 1);
                this.aJw = optJSONObject8.optInt("audio_ugc_switch_charmrank", 0) == 1;
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("location_info");
            if (optJSONObject9 != null) {
                this.aIe = new AlaLocationData();
                this.aIe.parserJson(optJSONObject9);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("user_info");
            if (optJSONObject10 != null) {
                this.aId = new AlaLiveUserInfoData();
                this.aId.parserJson(optJSONObject10);
                List<AlaLiveMarkData> list = this.aId.live_mark_info_new;
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
                this.aIz = new AlaLiveUserInfoData();
                this.aIz.parserJson(optJSONObject11);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject12 != null) {
                this.aIf = new AlaRelationData();
                this.aIf.parserJson(optJSONObject12);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("task_info");
            if (optJSONObject13 != null) {
                this.aIO = new au();
                this.aIO.parserJson(optJSONObject13);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("pk_solo_info");
            if (optJSONObject14 != null) {
                this.aIF = new aj();
                this.aIF.parserJson(optJSONObject14);
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
                            this.aIG = true;
                        } else {
                            this.aIG = false;
                        }
                    }
                }
                this.endTime = -1;
                if (optString != null) {
                }
                this.aIG = true;
            } else {
                this.aIG = false;
            }
            this.aJc = jSONObject.optString(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("toutiao");
            if (optJSONObject16 != null) {
                this.aIB = new q();
                this.aIB.serverTime = this.serverTime;
                this.aIB.parser(optJSONObject16);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("share_live_info");
            if (optJSONObject17 != null) {
                this.aIA = new aa();
                this.aIA.parseJson(optJSONObject17);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && (optJSONObject = jSONObject.optJSONObject("gift_bg_info")) != null) {
                this.aIC = new AlaLiveGiftUIInfo();
                this.aIC.parserJson(optJSONObject);
            }
            this.aIi = jSONObject.optLong("interval", 5L);
            if (this.aIi < 5) {
                this.aIi = 5000L;
            } else {
                this.aIi *= 1000;
            }
            this.aIL = jSONObject.optInt("zan_status");
            this.aIM = jSONObject.optString("user_watermark");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject18 = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject18 != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.userLevel = this.aId.levelId;
                        alaLiveMarkData.parserJson(optJSONObject18);
                        this.aIK.add(alaLiveMarkData);
                    }
                }
            }
            this.aIJ = jSONObject.optInt("need_renew_mark_info", 0) == 1;
            if (jSONObject.has("scene_from")) {
                String optString2 = jSONObject.optString("scene_from");
                if (this.aJf) {
                    com.baidu.live.utils.t.ie(optString2);
                } else {
                    com.baidu.live.utils.q.ie(optString2);
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
                    this.aIE.add(alaLiveWishListData);
                }
            }
            this.aIP = jSONObject.optInt("switch_guard_seat") == 1;
            JSONObject optJSONObject20 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject20 != null) {
                this.aIQ = new AlaLiveFeedDiversionData();
                this.aIQ.parserJson(optJSONObject20);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("anchor_info");
            if (optJSONObject21 != null) {
                this.aIR = new b();
                this.aIR.parseJson(optJSONObject21);
            }
            this.aIS = jSONObject.optString("function_list");
            this.aIT = jSONObject.optString("function_list_detail");
            String optString3 = jSONObject.optString("user_info_list");
            if (optString3 != null) {
                this.aIY = new AlaWheatInfoDataWrapper(optString3);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("multi_session");
            if (optJSONObject22 != null) {
                this.aIW = z.z(optJSONObject22);
            }
            this.aIX = new QuickImInputData();
            this.aIX.parseJson(jSONObject.optJSONArray("fast_reply_word"));
            JSONObject optJSONObject23 = jSONObject.optJSONObject("diversion");
            if (optJSONObject23 != null) {
                this.aID = new d();
                this.aID.parserJson(optJSONObject23);
            }
            this.aJp = jSONObject.optInt("is_luckybag_block_user") == 1;
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
        return "AlaLiveShowData{mAlaLiveMultiSession=" + this.aIW + '}';
    }
}
