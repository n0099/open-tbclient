package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.webkit.internal.ABTestConstants;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import com.kwai.video.player.KsMediaMeta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class an extends BaseData {
    public boolean aHE;
    public boolean aHF;
    public boolean aHG;
    public boolean aHH;
    public boolean aHI;
    public String aHJ;
    public String aHK;
    public String aHO;
    public String aHP;
    public String aHQ;
    public String aHR;
    public Integer[] aHU;
    public Integer[] aHV;
    public int aHW;
    public int aHY;
    public int aHZ;
    public boolean aIA;
    public boolean aIB;
    public boolean aIC;
    public boolean aID;
    public boolean aIE;
    public String aII;
    public String aIK;
    public String aIL;
    public int aIR;
    public String aIT;
    public String aIU;
    private String aIV;
    private String aIW;
    public int aIX;
    public String aIZ;
    public int aIa;
    public String aIb;
    public int aIc;
    public boolean aId;
    public boolean aIe;
    public boolean aIf;
    public boolean aIg;
    public boolean aIi;
    public String aIj;
    public int aIk;
    public boolean aIl;
    public int aIm;
    public int aIn;
    public boolean aIo;
    public boolean aIp;
    public String aIq;
    public String aIr;
    public String aIs;
    public String aIt;
    public String aIu;
    public int aIv;
    public int aIw;
    public String aIx;
    public boolean aIy;
    public boolean aIz;
    public String aJA;
    public String aJB;
    public String aJC;
    public String aJD;
    public int aJE;
    public String aJI;
    public int aJN;
    public int aJO;
    public String[] aJP;
    public int aJQ;
    public String aJR;
    public String aJS;
    public QuickImInputData aJT;
    public QuickImInputData aJU;
    public List<YuanPackageData> aJY;
    public bj aJZ;
    public String aJa;
    public String aJb;
    public String aJc;
    public String aJd;
    public boolean aJe;
    public long aJf;
    public long aJg;
    public String aJh;
    public String aJi;
    public String aJj;
    public String aJk;
    public long aJl;
    public long aJm;
    public long aJn;
    public String aJo;
    public String aJp;
    public String aJq;
    public int aJr;
    public int aJs;
    public int aJt;
    public bw aKA;
    public by aKB;
    public bs aKC;
    public ce aKD;
    public ah aKE;
    public boolean aKF;
    public List<String> aKa;
    public List<String> aKb;
    public List<String> aKc;
    public ax aKl;
    public boolean aKm;
    public String aKn;
    public AlaFeedDiversionData aKo;
    public s aKp;
    public boolean aKq;
    public int aKr;
    public int aKs;
    public ao aKy;
    public ca aKz;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aHC = -1;
    public String aHD = null;
    public int aIh = 1;
    public boolean aIF = true;
    public boolean aIG = false;
    public boolean aIH = false;
    public boolean aIJ = false;
    public String aIM = "";
    private int aIN = 2;
    public String aIO = "";
    public int aIP = 1;
    public int aIQ = 0;
    public int aIS = 1;
    public List<String> aIY = new ArrayList();
    public int aJu = 10;
    public int aJv = 60;
    public long aJw = 10000;
    public int aJx = 11;
    public int aJy = 4;
    public boolean aJz = false;
    public boolean aJF = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aJG = false;
    public boolean aJH = false;
    public boolean aJJ = false;
    public boolean aJK = false;
    public boolean aJL = false;
    public boolean aJM = false;
    public boolean aJV = false;
    public int aJW = 50;
    public int aJX = 0;
    public int aKd = 200;
    public int aKe = 100;
    public int aKf = 10;
    public int aKg = 10;
    public int aKh = 10;
    public int aKi = 15;
    public int aKj = 50;
    public int aKk = 5;
    public int aKt = 20;
    public int aKu = 70;
    public int aKv = 10000;
    public int aKw = 5000;
    public int aKx = 55000;
    public cq aKG = cq.aPL;
    public cr aKH = cr.aPQ;
    public Map<Integer, String> aKI = new HashMap();
    public List<String> aHN = new ArrayList();
    public List<String> aHX = new ArrayList();
    public List<String> aHS = new ArrayList();
    public List<Integer> aHT = new ArrayList();
    public ArrayList<p> aHL = new ArrayList<>();
    public ArrayList<p> aHM = new ArrayList<>();

    public an(boolean z) {
        if (z) {
            AR();
            this.aHW = com.baidu.live.d.xf().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.d.xf().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.d.xf().getInt("restart_time_interval", 300);
            AS();
            AQ();
            AT();
            AU();
        }
        SharedPrefHelper.getInstance().remove(SharedPrefConfig.KEY_SYNC_CLIENT_IP);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        if (jSONObject != null) {
            try {
                this.clientIP = jSONObject.optString("client_ip");
                SharedPrefHelper.getInstance().putString(SharedPrefConfig.KEY_SYNC_CLIENT_IP, this.clientIP);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("switch");
                if (optJSONObject2 != null) {
                    A(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject3 != null) {
                    this.aHW = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.d.xf().putInt("conn_conf", this.aHW);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aHX.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.d.xf().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.d.xf().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    B(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    C(optJSONObject5);
                }
                this.aIK = jSONObject.optString("client_id");
                com.baidu.live.d.xf().putString("client_id", this.aIK);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aHJ = optJSONObject6.optString("pic_url");
                    this.aHK = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            p pVar = new p();
                            pVar.parseJson(optJSONObject8);
                            this.aHL.add(pVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.d.xf().putString("pic_url", this.aHJ);
                com.baidu.live.d.xf().putString(BigdayActivityConfig.JUMP_URL, this.aHK);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    D(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aJQ = optJSONObject10.optInt("resource_switch");
                    this.aJS = optJSONObject10.optString("photo_url");
                    this.aJR = optJSONObject10.optString("resource_url");
                }
                this.aJT = new QuickImInputData();
                this.aJT.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aJU = new QuickImInputData();
                this.aJU.parseJson(jSONObject.getJSONArray("fast_reply_word_audio"));
                this.aJZ = bj.E(jSONObject.optJSONObject("guide_follow"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.d.xf().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject11 != null) {
                    JSONObject optJSONObject12 = optJSONObject11.optJSONObject("rank");
                    if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.d.xf().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.d.xf().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.d.xf().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject13 = optJSONObject11.optJSONObject("guard_seat");
                    if (optJSONObject13 != null) {
                        this.aKn = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aKl = new ax();
                    this.aKl.aLG = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.d.xf().putString("ala_certify_refuse_url", this.aKl.aLG);
                }
                this.aKy = new ao();
                this.aKy.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aKp = new s();
                    this.aKp.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aKz = new ca(optJSONObject16);
                }
                com.baidu.live.guardclub.g.HD().O(jSONObject.optJSONObject("old_club_member_level_icons"));
                this.aKF = jSONObject.optInt("disc_optimize_switch") == 1;
                JSONObject optJSONObject17 = jSONObject.optJSONObject("new_level_icon_urls");
                if (optJSONObject17 != null) {
                    int length2 = optJSONObject17.length();
                    for (int i3 = 1; i3 <= length2; i3++) {
                        this.aKI.put(Integer.valueOf(i3), optJSONObject17.optString(i3 + ""));
                    }
                }
                JSONObject optJSONObject18 = jSONObject.optJSONObject("collection_guide_config");
                if (optJSONObject18 != null) {
                    com.baidu.live.d.xf().putString("guide_follow_float_config", optJSONObject18.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.d.xf().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void AQ() {
        String string = com.baidu.live.d.xf().getString("ala_prepare_random_title_list", "");
        try {
            if (!TextUtils.isEmpty(string)) {
                f(new JSONArray(string));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void f(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.aKc = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aKc.add(jSONArray.optString(i));
            }
        }
    }

    private void AR() {
        this.aHE = com.baidu.live.d.xf().getBoolean("map_around_map", false);
        this.aIl = com.baidu.live.d.xf().getBoolean("withdraw_switch", true);
        this.aII = com.baidu.live.d.xf().getString("withdraw_text", "");
        this.aIB = com.baidu.live.d.xf().getBoolean("use_internal_player_switch", true);
        this.aIy = com.baidu.live.d.xf().getBoolean("use_http_dns_switch", true);
        this.aIz = com.baidu.live.d.xf().getBoolean("use_encode_bframe_switch", false);
        this.aIA = com.baidu.live.d.xf().getBoolean("enable_opt_timestamp_switch", true);
        this.aIC = com.baidu.live.d.xf().getBoolean("live_beauty_open_switch", false);
        this.aID = com.baidu.live.d.xf().getBoolean("live_unity_beauty_switch", true);
        this.aIE = com.baidu.live.d.xf().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aIF = com.baidu.live.d.xf().getBoolean("sp_key_live_game_hard_encode", true);
        this.aIG = com.baidu.live.d.xf().getBoolean("sp_key_live_play_transcode_support", false);
        this.aIH = com.baidu.live.d.xf().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aIJ = com.baidu.live.d.xf().getBoolean("ala_enable_graffiti_str", false);
        this.aHF = com.baidu.live.d.xf().getBoolean("enter_live", false);
        this.aHG = com.baidu.live.d.xf().getBoolean("sync_to_forum", true);
        this.aHH = com.baidu.live.d.xf().getBoolean("show_water_mark", false);
        this.aHI = com.baidu.live.d.xf().getBoolean("show_third_part_water_mark_switch", false);
        this.aId = com.baidu.live.d.xf().getBoolean("stream_error_log", true);
        this.aIe = com.baidu.live.d.xf().getBoolean("disable_channel_in", true);
        this.aIf = com.baidu.live.d.xf().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aIg = com.baidu.live.d.xf().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aIi = com.baidu.live.d.xf().getBoolean("follow_default_push_switch", true);
        this.aIR = com.baidu.live.d.xf().getInt("to_tb_some_switch", 0);
        this.aIP = com.baidu.live.d.xf().getInt("enable_live_stat", 1);
        this.aIQ = com.baidu.live.d.xf().getInt("ala_free_gift_task_switch", 0);
        this.aJz = com.baidu.live.d.xf().getBoolean("live_challenge_switch", false);
        this.aJA = com.baidu.live.d.xf().getString("live_challenge_tip", null);
        this.aJB = com.baidu.live.d.xf().getString("live_challenge_url", null);
    }

    private void A(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aHE = optJSONObject.optInt("switch") != 1;
                com.baidu.live.d.xf().putBoolean("map_around_map", this.aHE);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aIl = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("withdraw_switch", this.aIl);
                this.aII = optJSONObject2.optString("text");
                com.baidu.live.d.xf().putString("withdraw_text", this.aII);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aIB = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("use_internal_player_switch", this.aIB);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aIy = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("use_http_dns_switch", this.aIy);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aIz = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("use_encode_bframe_switch", this.aIz);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aIA = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("enable_opt_timestamp_switch", this.aIA);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.aIC = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("live_beauty_open_switch", this.aIC);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.aID = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("live_unity_beauty_switch", this.aID);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.aIE = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("live_unity_beauty_face_style_switch", this.aIE);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.aIF = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("sp_key_live_game_hard_encode", this.aIF);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.aIG = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("sp_key_live_play_transcode_support", this.aIG);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.aIH = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("sp_key_live_play_attention_guide_support", this.aIH);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.aHF = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("enter_live", this.aHF);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.aHG = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean("sync_to_forum", this.aHG);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.aHH = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean("show_water_mark", this.aHH);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.aHI = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean("show_third_part_water_mark_switch", this.aHI);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.aIP = optJSONObject17.optInt("switch");
                com.baidu.live.d.xf().putInt("enable_live_stat", this.aIP);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.aId = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("stream_error_log", this.aId);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.aIe = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean("disable_channel_in", this.aIe);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.aIf = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean("shoubai_yanzhi_tab_tip", this.aIf);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.aIg = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aIg);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.aIi = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.d.xf().putBoolean("follow_default_push_switch", this.aIi);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.aIR = optJSONObject23.optInt("switch");
                com.baidu.live.d.xf().putInt("to_tb_some_switch", this.aIR);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.aIQ = optJSONObject24.optInt("switch");
                com.baidu.live.d.xf().putInt("ala_free_gift_task_switch", this.aIR);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.aIJ = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("ala_enable_graffiti_str", this.aIJ);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aJz = optJSONObject26.optInt("switch") == 1;
                this.aJA = optJSONObject26.optString("title");
                this.aJB = optJSONObject26.optString("url");
                com.baidu.live.d.xf().putBoolean("live_challenge_switch", this.aJz);
                com.baidu.live.d.xf().putString("live_challenge_tip", this.aJA);
                com.baidu.live.d.xf().putString("live_challenge_url", this.aJB);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aJH = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("is_new_gift_t_dou_strategy", this.aJH);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aJL = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aJJ = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("key_is_open_login_prove", this.aJJ);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aJK = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("key_is_open_diamond", this.aJK);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aJM = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("key_is_jump_to_live_room", this.aJM);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aKm = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aKq = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void AS() {
        JSONArray jSONArray;
        this.aIb = com.baidu.live.d.xf().getString("bluediamond_url", "");
        this.aHP = com.baidu.live.d.xf().getString("verify_content", this.aHP);
        this.aHO = com.baidu.live.d.xf().getString("live_notice", "");
        this.aHQ = com.baidu.live.d.xf().getString("activity_notice", "");
        String string = com.baidu.live.d.xf().getString("imNotice", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                jSONArray = new JSONArray(string);
            } catch (JSONException e) {
                BdLog.e(e);
                jSONArray = null;
            }
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = jSONArray.optString(i);
                    if (!optString.isEmpty()) {
                        this.aHN.add(i, optString);
                    } else {
                        this.aHN.add(i, "");
                    }
                }
            }
        }
        this.aIL = com.baidu.live.d.xf().getString("share_host", "");
        this.aIM = com.baidu.live.d.xf().getString("ala_share_in_bar_notice_text", "");
        this.aIO = com.baidu.live.d.xf().getString("ala_share_reward_rank_notice_text", "");
        this.aIN = com.baidu.live.d.xf().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aIc = com.baidu.live.d.xf().getInt("recommend_refresh", 60);
        this.aIj = com.baidu.live.d.xf().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aIk = com.baidu.live.d.xf().getInt("strategy_exception_interval", 1);
        this.aIh = com.baidu.live.d.xf().getInt("liveStartAuthLevel", 1);
        this.aHY = com.baidu.live.d.xf().getInt("2gTo", 5);
        this.aHZ = com.baidu.live.d.xf().getInt("3gTo", 3);
        this.aIa = com.baidu.live.d.xf().getInt("wifiTo", 3);
        String string2 = com.baidu.live.d.xf().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aHU = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.d.xf().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aHV = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aIS = com.baidu.live.d.xf().getInt("square_tab_strategy", 1);
        this.aIT = com.baidu.live.d.xf().getString("ala_live_ranklist_url", null);
        this.aIU = com.baidu.live.d.xf().getString("new_flower_rank_list_description_url", "");
        this.aIV = com.baidu.live.d.xf().getString("ala_game_player_signup_url", null);
        this.aIW = com.baidu.live.d.xf().getString("ala_game_frs_live_tab_video_url", null);
        AW();
        this.aJd = com.baidu.live.d.xf().getString("ala_personal_income_detail_url", null);
        this.aJE = com.baidu.live.d.xf().getInt("ala_custom_gift_category_id", -1);
        this.aJe = com.baidu.live.d.xf().getInt("ala_live_pk_switch", 0) == 1;
        this.aJf = com.baidu.live.d.xf().getLong("ala_live_pk_check_interval", 1000L);
        this.aJg = com.baidu.live.d.xf().getLong("ala_live_pk_match_timeout", AppStatusRules.DEFAULT_GRANULARITY);
        this.aJh = com.baidu.live.d.xf().getString("ala_live_pk_pic_url", "");
        this.aJi = com.baidu.live.d.xf().getString("ala_live_pk_pic_jump_url", "");
        this.aJj = com.baidu.live.d.xf().getString("ala_live_pk_history_link", "");
        this.aJk = com.baidu.live.d.xf().getString("show_live_forum_url", "");
        this.aJl = com.baidu.live.d.xf().getLong("ala_challenge_random_interval", 1000L);
        this.aJm = com.baidu.live.d.xf().getLong("ala_challenge_direct_interval", 1000L);
        this.aJn = com.baidu.live.d.xf().getLong("ala_get_challenge_info_interval", 1000L);
        this.aJp = com.baidu.live.d.xf().getString("ala_challenge_pk_entry_icon_url", "");
        this.aJq = com.baidu.live.d.xf().getString("ala_challenge_pk_entry_icon_url", "");
        this.aJo = com.baidu.live.d.xf().getString("ala_challenge_pk_entry_icon_url", "");
        this.aJr = com.baidu.live.d.xf().getInt("punish_stage_button_switch", 0);
        this.aJs = com.baidu.live.d.xf().getInt("receive_challenge_im_show_time", 0);
        this.aJt = com.baidu.live.d.xf().getInt("mvpPunishSwitch", 0);
        this.aJu = com.baidu.live.d.xf().getInt("toastLifeTime", 10);
        this.aJv = com.baidu.live.d.xf().getInt("punishLifeTime", 60);
        this.aJF = com.baidu.live.d.xf().getBoolean("ala_guess_use_https", false);
        ff(com.baidu.live.d.xf().getString("ala_live_bar_map_str", ""));
        this.aJG = com.baidu.live.d.xf().getBoolean("is_new_live_close_strategy", false);
        this.aJH = com.baidu.live.d.xf().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aJI = com.baidu.live.d.xf().getString("ala_feedback_url", null);
        this.aIm = com.baidu.live.d.xf().getInt("ala_video_resolution_level", 3);
        this.aIn = com.baidu.live.d.xf().getInt("ala_video_encoder_gop", 2);
        this.aIo = com.baidu.live.d.xf().getBoolean("ala_live_hard_encode_switch", true);
        this.aIp = com.baidu.live.d.xf().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.d.xf().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.d.xf().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.d.xf().getInt("ala_video_increase_count", 3);
        this.aIq = com.baidu.live.d.xf().getString("ala_video_soft_bitrate_config", null);
        this.aIr = com.baidu.live.d.xf().getString("ala_video_hard_bitrate_config", null);
        this.aIv = com.baidu.live.d.xf().getInt("ala_master_chat_video_resolution_level", 3);
        this.aIw = com.baidu.live.d.xf().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aIs = com.baidu.live.d.xf().getString("ala_avts_stream_server_domain_config", null);
        this.aIt = com.baidu.live.d.xf().getString("ala_master_chat_video_bitrate_config", null);
        this.aIu = com.baidu.live.d.xf().getString("ala_slave_chat_video_bitrate_config", null);
        this.aIx = com.baidu.live.d.xf().getString("ala_video_encoder_reset_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.d.xf().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.d.xf().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aJJ = com.baidu.live.d.xf().getBoolean("key_is_open_login_prove", false);
        this.aJK = com.baidu.live.d.xf().getBoolean("key_is_open_diamond", false);
        this.aJM = com.baidu.live.d.xf().getBoolean("key_is_jump_to_live_room", false);
        fd(com.baidu.live.d.xf().getString("feed_diversion", ""));
        AV();
    }

    private void fd(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aKo = new AlaFeedDiversionData();
                this.aKo.parserJson(jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Integer[] g(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        Integer[] numArr = new Integer[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            numArr[i] = Integer.valueOf(jSONArray.optJSONObject(i).optInt(KsMediaMeta.KSM_KEY_BITRATE));
        }
        return numArr;
    }

    private void B(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tying_gift_conf");
            if (optJSONObject2 != null) {
                this.aJx = optJSONObject2.optInt("pendant_details_show_times");
                this.aJy = optJSONObject2.optInt("pendant_inform_show_times");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("quick_im_conf");
            if (optJSONObject3 != null) {
                this.aJV = optJSONObject3.optInt("switch", 1) == 1;
                this.aJW = optJSONObject3.optInt("show_times");
                this.aJX = optJSONObject3.optInt("delay_seconds");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("pksolo");
            if (optJSONObject4 != null) {
                this.aHR = optJSONObject4.toString();
                this.aKA = new bw();
                this.aKA.parse(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("poke");
            this.aKB = new by();
            if (optJSONObject5 != null) {
                this.aKB.parse(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject6 != null) {
                this.aHD = optJSONObject6.optString(TipsConfigItem.TipConfigData.TOAST);
                this.aHC = optJSONObject6.optInt("remind_type");
            }
            this.aIb = jSONObject.optString("bluediamond_url");
            com.baidu.live.d.xf().putString("bluediamond_url", this.aIb);
            this.aHP = jSONObject.optString("verify_content");
            com.baidu.live.d.xf().putString("verify_content", this.aHP);
            this.aHO = jSONObject.optString("live_notice");
            com.baidu.live.d.xf().putString("live_notice", this.aHO);
            this.aHQ = jSONObject.optString("activityNotice");
            com.baidu.live.d.xf().putString("activity_notice", this.aHQ);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aHN.add(i, optString);
                    } else {
                        this.aHN.add(i, "");
                    }
                }
                com.baidu.live.d.xf().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.d.xf().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.aHS.add(i2, optString2);
                    }
                }
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("bd_live_activity");
            if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("main_page")) != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject8 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject8 != null) {
                        p pVar = new p();
                        pVar.parseJson(optJSONObject8);
                        this.aHM.add(pVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aHT.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("share_host");
            if (optJSONObject9 != null) {
                this.aIL = optJSONObject9.optString("url");
            } else {
                this.aIL = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject10 != null) {
                this.aIM = optJSONObject10.optString("reward_notice");
                this.aIO = optJSONObject10.optString("reward_rank_notice");
                this.aIN = optJSONObject10.optInt("reward_switch", 2);
            } else {
                this.aIM = "";
                this.aIO = "";
                this.aIN = 2;
            }
            com.baidu.live.d.xf().putString("share_host", this.aIL);
            com.baidu.live.d.xf().putString("ala_share_in_bar_notice_text", this.aIM);
            com.baidu.live.d.xf().putString("ala_share_reward_rank_notice_text", this.aIO);
            com.baidu.live.d.xf().putInt("ala_share_in_bar_notice_tip_switch", this.aIN);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject11 != null) {
                this.aIc = optJSONObject11.optInt("value");
            } else {
                this.aIc = 60;
            }
            com.baidu.live.d.xf().putInt("recommend_refresh", this.aIc);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject12 != null) {
                JSONArray optJSONArray5 = optJSONObject12.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.d.xf().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aHU = g(optJSONArray5);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject13 != null) {
                JSONArray optJSONArray6 = optJSONObject13.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.d.xf().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aHV = g(optJSONArray6);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject14 != null) {
                this.aIj = optJSONObject14.optString("time_interval");
                this.aIk = optJSONObject14.optInt("exception_interval");
            } else {
                this.aIj = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aIk = 1;
            }
            com.baidu.live.d.xf().putString("strategy_conf", this.aIj);
            com.baidu.live.d.xf().putInt("strategy_exception_interval", this.aIk);
            this.aIh = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.d.xf().putInt("liveStartAuthLevel", this.aIh);
            JSONObject optJSONObject15 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject15 != null) {
                this.aHY = optJSONObject15.optInt("2gTo");
                if (this.aHY < 3) {
                    this.aHY = 3;
                }
                this.aHZ = optJSONObject15.optInt("3gTo");
                if (this.aHZ < 3) {
                    this.aHZ = 3;
                }
                this.aIa = optJSONObject15.optInt("wifiTo");
                if (this.aIa < 3) {
                    this.aIa = 3;
                }
                com.baidu.live.d.xf().putInt("2gTo", this.aHY);
                com.baidu.live.d.xf().putInt("3gTo", this.aHZ);
                com.baidu.live.d.xf().putInt("wifiTo", this.aIa);
            }
            this.aIS = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.d.xf().putInt("square_tab_strategy", this.aIS);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject16 != null) {
                this.aIT = optJSONObject16.optString(BigdayActivityConfig.JUMP_URL);
                this.aIU = optJSONObject16.optString("flower_rank_rule");
            }
            com.baidu.live.d.xf().putString("ala_live_ranklist_url", this.aIT);
            com.baidu.live.d.xf().putString("new_flower_rank_list_description_url", this.aIU);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject17 != null) {
                this.aIV = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.d.xf().putString("ala_game_player_signup_url", this.aIV);
            JSONObject optJSONObject18 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject18 != null) {
                this.aIW = optJSONObject18.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.xf().putString("ala_game_frs_live_tab_video_url", this.aIW);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject19 != null) {
                this.aIX = optJSONObject19.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.d.xf().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aIY.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject20 != null) {
                com.baidu.live.d.xf().putString("ala_live_session_replace_key", optJSONObject20.toString());
                this.aJb = optJSONObject20.optString("hlsUrl");
                this.aIZ = optJSONObject20.optString("rtmpUrl");
                this.aJa = optJSONObject20.optString("flvUrl");
                this.aJc = optJSONObject20.optString(".m3u8");
            }
            b(true, this.aIX);
            JSONObject optJSONObject21 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject21 != null) {
                this.aJd = optJSONObject21.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.xf().putString("ala_personal_income_detail_url", this.aJd);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject22 != null) {
                this.aJE = optJSONObject22.optInt("android_show");
                com.baidu.live.d.xf().putInt("ala_custom_gift_category_id", this.aJE);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("pub_show_conf");
            if (optJSONObject23 != null) {
                this.aKG = new cq();
                this.aKG.parserJson(optJSONObject23);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("pub_show_two_conf");
            if (optJSONObject24 != null) {
                this.aKH = new cr();
                this.aKH.parserJson(optJSONObject24);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject25 != null) {
                int optInt = optJSONObject25.optInt("open", 0);
                this.aJe = optInt == 1;
                com.baidu.live.d.xf().putInt("ala_live_pk_switch", optInt);
                this.aJf = optJSONObject25.optLong("interval");
                if (this.aJf < 1000) {
                    this.aJf = 1000L;
                }
                com.baidu.live.d.xf().putLong("ala_live_pk_check_interval", this.aJf);
                this.aJg = optJSONObject25.optLong("match_timeout");
                if (this.aJg < AppStatusRules.DEFAULT_GRANULARITY) {
                    this.aJg = AppStatusRules.DEFAULT_GRANULARITY;
                }
                com.baidu.live.d.xf().putLong("ala_live_pk_match_timeout", this.aJg);
                this.aJh = optJSONObject25.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.d.xf().putString("ala_live_pk_pic_url", this.aJh);
                this.aJi = optJSONObject25.optString("rank_link");
                com.baidu.live.d.xf().putString("ala_live_pk_pic_jump_url", this.aJi);
                this.aJj = optJSONObject25.optString("history_link");
                com.baidu.live.d.xf().putString("ala_live_pk_history_link", this.aJj);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject26 != null) {
                this.aJl = optJSONObject26.optLong("random_interval");
                if (this.aJl < 1000) {
                    this.aJl = 1000L;
                }
                com.baidu.live.d.xf().putLong("ala_challenge_random_interval", this.aJl);
                this.aJm = optJSONObject26.optLong("direct_interval");
                if (this.aJm < 1000) {
                    this.aJm = 1000L;
                }
                com.baidu.live.d.xf().putLong("ala_challenge_direct_interval", this.aJm);
                this.aJn = optJSONObject26.optLong("challenge_info_interval");
                if (this.aJn < 1000) {
                    this.aJn = 1000L;
                }
                com.baidu.live.d.xf().putLong("ala_get_challenge_info_interval", this.aJn);
                this.aJp = optJSONObject26.optString("pk_icon_url");
                com.baidu.live.d.xf().putString("ala_challenge_pk_entry_icon_url", this.aJp);
                this.aJq = optJSONObject26.optString("icon_url");
                com.baidu.live.d.xf().putString("ala_challenge_pk_entry_icon_url", this.aJq);
                this.aJo = optJSONObject26.optString("rule_url");
                com.baidu.live.d.xf().putString("ala_challenge_pk_entry_icon_url", this.aJo);
                this.aJr = optJSONObject26.optInt("punish_stage_button_switch");
                com.baidu.live.d.xf().putInt("punish_stage_button_switch", this.aJr);
                this.aJs = optJSONObject26.optInt("receive_challenge_im_show_time");
                com.baidu.live.d.xf().putInt("receive_challenge_im_show_time", this.aJs);
                this.aJt = optJSONObject26.optInt("mvpPunishSwitch");
                com.baidu.live.d.xf().putInt("mvpPunishSwitch", this.aJt);
                this.aJu = optJSONObject26.optInt("toastLifeTime");
                com.baidu.live.d.xf().putInt("toastLifeTime", this.aJu);
                this.aJv = optJSONObject26.optInt("punishLifeTime");
                com.baidu.live.d.xf().putInt("punishLifeTime", this.aJv);
                this.aJw = optJSONObject26.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject27 != null) {
                this.aJk = optJSONObject27.optString("go_url");
                com.baidu.live.d.xf().putString("show_live_forum_url", this.aJk);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject28 != null) {
                this.aJF = optJSONObject28.optInt("use_https", 0) == 1;
                com.baidu.live.d.xf().putBoolean("ala_guess_use_https", this.aJF);
            }
            String optString3 = jSONObject.optString("live_bar");
            ff(optString3);
            com.baidu.live.d.xf().putString("ala_live_bar_map_str", optString3);
            this.aJG = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.d.xf().putBoolean("is_new_live_close_strategy", this.aJG);
            this.aJH = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.d.xf().putBoolean("is_new_gift_t_dou_strategy", this.aJH);
            this.aJI = jSONObject.optString("feedback_url");
            com.baidu.live.d.xf().putString("ala_feedback_url", this.aJI);
            JSONObject optJSONObject29 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject29 != null && (optJSONObject = optJSONObject29.optJSONObject("challenge_related_zip")) != null) {
                this.aJC = optJSONObject.optString("zip_md5");
                this.aJD = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject30 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject30.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject30.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.d.xf().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.d.xf().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("open_live");
            if (optJSONObject31 != null) {
                this.increaseThreshold = optJSONObject31.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.d.xf().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject31.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.d.xf().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject31.optInt("thi_count", 3);
                com.baidu.live.d.xf().putInt("ala_video_increase_count", this.increaseCount);
                this.aIo = optJSONObject31.optInt("encoder", 1) == 1;
                com.baidu.live.d.xf().putBoolean("ala_live_hard_encode_switch", this.aIo);
                this.aIn = optJSONObject31.optInt("video_gop", 2);
                com.baidu.live.d.xf().putInt("ala_video_encoder_gop", this.aIn);
                this.aIp = optJSONObject31.optInt("dynamic", 1) == 1;
                com.baidu.live.d.xf().putBoolean("ala_dynamic_bitrate_switch", this.aIp);
                this.aIm = optJSONObject31.optInt("resolution", 3);
                com.baidu.live.d.xf().putInt("ala_video_resolution_level", this.aIm);
                JSONArray optJSONArray8 = optJSONObject31.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aIq = optJSONArray8.toString();
                    com.baidu.live.d.xf().putString("ala_video_soft_bitrate_config", this.aIq);
                }
                JSONArray optJSONArray9 = optJSONObject31.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aIr = optJSONArray9.toString();
                    com.baidu.live.d.xf().putString("ala_video_hard_bitrate_config", this.aIr);
                }
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject32 != null) {
                this.aIs = optJSONObject32.toString();
                com.baidu.live.d.xf().putString("ala_avts_stream_server_domain_config", this.aIs);
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("encoder_auto_reset");
            if (optJSONObject33 != null) {
                this.aIx = optJSONObject33.toString();
                com.baidu.live.d.xf().putString("ala_video_encoder_reset_config", this.aIx);
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject34 != null) {
                this.aIv = optJSONObject34.optInt("host_rtc_resolution", 3);
                com.baidu.live.d.xf().putInt("ala_master_chat_video_resolution_level", this.aIv);
                this.aIw = optJSONObject34.optInt("rtc_resolution", 4);
                com.baidu.live.d.xf().putInt("ala_slave_chat_video_resolution_level", this.aIw);
                JSONArray optJSONArray10 = optJSONObject34.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aIt = optJSONArray10.toString();
                    com.baidu.live.d.xf().putString("ala_master_chat_video_bitrate_config", this.aIt);
                }
                JSONArray optJSONArray11 = optJSONObject34.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aIu = optJSONArray11.toString();
                    com.baidu.live.d.xf().putString("ala_slave_chat_video_bitrate_config", this.aIu);
                }
            }
            JSONObject optJSONObject35 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject35 != null) {
                this.aKt = optJSONObject35.optInt("enter_live_msg_audience_num_p1");
                this.aKu = optJSONObject35.optInt("enter_live_msg_audience_num_p2");
                this.aKv = optJSONObject35.optInt("enter_live_msg_audience_num_p3");
                this.aKr = optJSONObject35.optInt("im_intercept_switch");
                this.aKs = optJSONObject35.optInt("is_check_im_content");
            }
            JSONObject optJSONObject36 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject36 != null) {
                this.aKo = new AlaFeedDiversionData();
                this.aKo.parserJson(optJSONObject36);
                com.baidu.live.d.xf().putString("feed_diversion", optJSONObject36.toString());
            }
            JSONObject optJSONObject37 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject37 != null) {
                com.baidu.live.d.xf().putString("key_stat_switch", optJSONObject37.toString());
            }
            JSONObject optJSONObject38 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject38 != null) {
                this.aKw = optJSONObject38.optInt("unfold_interval", 5000);
                this.aKx = optJSONObject38.optInt("fold_interval", 55000);
            }
            JSONObject optJSONObject39 = jSONObject.optJSONObject("modify_default_name_conf");
            if (optJSONObject39 != null) {
                this.aKC = new bs();
                this.aKC.parserJson(optJSONObject39);
            }
            JSONObject optJSONObject40 = jSONObject.optJSONObject("audio_live_conf");
            if (optJSONObject40 != null) {
                this.aKD = new ce();
                this.aKD.parse(optJSONObject40);
            }
            JSONObject optJSONObject41 = jSONObject.optJSONObject("quit_live_rec_conf");
            this.aKE = new ah();
            this.aKE.parse(optJSONObject41);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void C(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKd = jSONObject.optInt("im_max", 200);
            if (this.aKd <= 0) {
                this.aKd = 200;
            }
            this.aKe = jSONObject.optInt("barrage_max", 100);
            if (this.aKe <= 0) {
                this.aKe = 100;
            }
            this.aKf = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aKf <= 0) {
                this.aKf = 10;
            }
            this.aKg = jSONObject.optInt("enter_effect_max", 10);
            if (this.aKg <= 0) {
                this.aKg = 10;
            }
            this.aKh = jSONObject.optInt("gift_big_max", 10);
            if (this.aKh <= 0) {
                this.aKh = 10;
            }
            this.aKi = jSONObject.optInt("audio_gift_big_max", 15);
            if (this.aKi <= 0) {
                this.aKi = 15;
            }
            this.aKj = jSONObject.optInt("gift_small_max", 50);
            if (this.aKj <= 0) {
                this.aKj = 50;
            }
            this.aKk = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aKk <= 0) {
                this.aKk = 5;
            }
        }
    }

    private void AT() {
        this.aJN = com.baidu.live.d.xf().getInt("guide_speak_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        this.aJO = com.baidu.live.d.xf().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.d.xf().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aJP = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aJP[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void D(JSONObject jSONObject) {
        int length;
        this.aJN = jSONObject.optInt("rule_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL) * 1000;
        com.baidu.live.d.xf().putInt("guide_speak_watch_time", this.aJN);
        this.aJO = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.d.xf().putInt("guide_speak_show_times_max", this.aJO);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aJP = new String[length];
            for (int i = 0; i < length; i++) {
                this.aJP[i] = optJSONArray.optString(i);
            }
            com.baidu.live.d.xf().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void AU() {
        String string = com.baidu.live.d.xf().getString("yuan_package_data", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                h(new JSONArray(string));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void h(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aJY = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aJY.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void fe(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aKa = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aKa.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aKb = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aKb.add(str3);
                            }
                        }
                    }
                    com.baidu.live.d.xf().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void AV() {
        fe(com.baidu.live.d.xf().getString("ala_quick_send_im_list", null));
    }

    private void ff(String str) {
        if (!StringUtils.isNull(str)) {
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        long optLong = optJSONObject.optLong("id", 0L);
                        this.liveForumMap.put(Long.valueOf(optLong), optJSONObject.optString("name"));
                    }
                }
            }
        }
    }

    public void b(boolean z, int i) {
        boolean z2 = false;
        if (i != this.aIX) {
            z2 = true;
        }
        this.aIX = i;
        if (z || z2) {
            com.baidu.live.d.xf().putInt("ala_live_session_default_key", i);
        }
    }

    private void AW() {
        this.aIX = com.baidu.live.d.xf().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.d.xf().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aIY.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.d.xf().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aJb = jSONObject.optString("hlsUrl");
                this.aIZ = jSONObject.optString("rtmpUrl");
                this.aJa = jSONObject.optString("flvUrl");
                this.aJc = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean AX() {
        return this.aIQ == 1;
    }
}
