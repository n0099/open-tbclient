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
/* loaded from: classes11.dex */
public class an extends BaseData {
    public String aMB;
    public String aMC;
    public String aMD;
    public String aME;
    public Integer[] aMH;
    public Integer[] aMI;
    public int aMJ;
    public int aML;
    public int aMM;
    public int aMN;
    public String aMO;
    public int aMP;
    public boolean aMQ;
    public boolean aMR;
    public boolean aMS;
    public boolean aMT;
    public boolean aMV;
    public String aMW;
    public int aMX;
    public boolean aMY;
    public int aMZ;
    public boolean aMr;
    public boolean aMs;
    public boolean aMt;
    public boolean aMu;
    public boolean aMv;
    public String aMw;
    public String aMx;
    public int aNE;
    public String aNG;
    public String aNH;
    private String aNI;
    private String aNJ;
    public int aNK;
    public String aNM;
    public String aNN;
    public String aNO;
    public String aNP;
    public String aNQ;
    public boolean aNR;
    public long aNS;
    public long aNT;
    public String aNU;
    public String aNV;
    public String aNW;
    public String aNX;
    public long aNY;
    public long aNZ;
    public int aNa;
    public boolean aNb;
    public boolean aNc;
    public String aNd;
    public String aNe;
    public String aNf;
    public String aNg;
    public String aNh;
    public int aNi;
    public int aNj;
    public String aNk;
    public boolean aNl;
    public boolean aNm;
    public boolean aNn;
    public boolean aNo;
    public boolean aNp;
    public boolean aNq;
    public boolean aNr;
    public String aNv;
    public String aNx;
    public String aNy;
    public int aOA;
    public int aOB;
    public String[] aOC;
    public int aOD;
    public String aOE;
    public String aOF;
    public QuickImInputData aOG;
    public QuickImInputData aOH;
    public List<YuanPackageData> aOL;
    public bj aOM;
    public List<String> aON;
    public List<String> aOO;
    public List<String> aOP;
    public ax aOY;
    public boolean aOZ;
    public long aOa;
    public String aOb;
    public String aOc;
    public String aOd;
    public int aOe;
    public int aOf;
    public int aOg;
    public String aOn;
    public String aOo;
    public String aOp;
    public String aOq;
    public int aOr;
    public String aOv;
    public String aPa;
    public AlaFeedDiversionData aPb;
    public s aPc;
    public boolean aPd;
    public int aPe;
    public int aPf;
    public ao aPl;
    public ca aPm;
    public bw aPn;
    public by aPo;
    public bs aPp;
    public ce aPq;
    public ah aPr;
    public boolean aPs;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aMp = -1;
    public String aMq = null;
    public int aMU = 1;
    public boolean aNs = true;
    public boolean aNt = false;
    public boolean aNu = false;
    public boolean aNw = false;
    public String aNz = "";
    private int aNA = 2;
    public String aNB = "";
    public int aNC = 1;
    public int aND = 0;
    public int aNF = 1;
    public List<String> aNL = new ArrayList();
    public int aOh = 10;
    public int aOi = 60;
    public long aOj = 10000;
    public int aOk = 11;
    public int aOl = 4;
    public boolean aOm = false;
    public boolean aOs = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aOt = false;
    public boolean aOu = false;
    public boolean aOw = false;
    public boolean aOx = false;
    public boolean aOy = false;
    public boolean aOz = false;
    public boolean aOI = false;
    public int aOJ = 50;
    public int aOK = 0;
    public int aOQ = 200;
    public int aOR = 100;
    public int aOS = 10;
    public int aOT = 10;
    public int aOU = 10;
    public int aOV = 15;
    public int aOW = 50;
    public int aOX = 5;
    public int aPg = 20;
    public int aPh = 70;
    public int aPi = 10000;
    public int aPj = 5000;
    public int aPk = 55000;
    public cq aPt = cq.aUy;
    public cr aPu = cr.aUD;
    public Map<Integer, String> aPv = new HashMap();
    public List<String> aMA = new ArrayList();
    public List<String> aMK = new ArrayList();
    public List<String> aMF = new ArrayList();
    public List<Integer> aMG = new ArrayList();
    public ArrayList<p> aMy = new ArrayList<>();
    public ArrayList<p> aMz = new ArrayList<>();

    public an(boolean z) {
        if (z) {
            EM();
            this.aMJ = com.baidu.live.d.Ba().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.d.Ba().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.d.Ba().getInt("restart_time_interval", 300);
            EN();
            EL();
            EO();
            EP();
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
                    this.aMJ = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.d.Ba().putInt("conn_conf", this.aMJ);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aMK.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.d.Ba().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.d.Ba().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    B(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    C(optJSONObject5);
                }
                this.aNx = jSONObject.optString("client_id");
                com.baidu.live.d.Ba().putString("client_id", this.aNx);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aMw = optJSONObject6.optString("pic_url");
                    this.aMx = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            p pVar = new p();
                            pVar.parseJson(optJSONObject8);
                            this.aMy.add(pVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.d.Ba().putString("pic_url", this.aMw);
                com.baidu.live.d.Ba().putString(BigdayActivityConfig.JUMP_URL, this.aMx);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    D(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aOD = optJSONObject10.optInt("resource_switch");
                    this.aOF = optJSONObject10.optString("photo_url");
                    this.aOE = optJSONObject10.optString("resource_url");
                }
                this.aOG = new QuickImInputData();
                this.aOG.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aOH = new QuickImInputData();
                this.aOH.parseJson(jSONObject.getJSONArray("fast_reply_word_audio"));
                this.aOM = bj.E(jSONObject.optJSONObject("guide_follow"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.d.Ba().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject11 != null) {
                    JSONObject optJSONObject12 = optJSONObject11.optJSONObject("rank");
                    if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.d.Ba().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.d.Ba().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.d.Ba().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject13 = optJSONObject11.optJSONObject("guard_seat");
                    if (optJSONObject13 != null) {
                        this.aPa = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aOY = new ax();
                    this.aOY.aQt = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.d.Ba().putString("ala_certify_refuse_url", this.aOY.aQt);
                }
                this.aPl = new ao();
                this.aPl.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aPc = new s();
                    this.aPc.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aPm = new ca(optJSONObject16);
                }
                com.baidu.live.guardclub.g.Ly().O(jSONObject.optJSONObject("old_club_member_level_icons"));
                this.aPs = jSONObject.optInt("disc_optimize_switch") == 1;
                JSONObject optJSONObject17 = jSONObject.optJSONObject("new_level_icon_urls");
                if (optJSONObject17 != null) {
                    int length2 = optJSONObject17.length();
                    for (int i3 = 1; i3 <= length2; i3++) {
                        this.aPv.put(Integer.valueOf(i3), optJSONObject17.optString(i3 + ""));
                    }
                }
                JSONObject optJSONObject18 = jSONObject.optJSONObject("collection_guide_config");
                if (optJSONObject18 != null) {
                    com.baidu.live.d.Ba().putString("guide_follow_float_config", optJSONObject18.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.d.Ba().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void EL() {
        String string = com.baidu.live.d.Ba().getString("ala_prepare_random_title_list", "");
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
            this.aOP = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aOP.add(jSONArray.optString(i));
            }
        }
    }

    private void EM() {
        this.aMr = com.baidu.live.d.Ba().getBoolean("map_around_map", false);
        this.aMY = com.baidu.live.d.Ba().getBoolean("withdraw_switch", true);
        this.aNv = com.baidu.live.d.Ba().getString("withdraw_text", "");
        this.aNo = com.baidu.live.d.Ba().getBoolean("use_internal_player_switch", true);
        this.aNl = com.baidu.live.d.Ba().getBoolean("use_http_dns_switch", true);
        this.aNm = com.baidu.live.d.Ba().getBoolean("use_encode_bframe_switch", false);
        this.aNn = com.baidu.live.d.Ba().getBoolean("enable_opt_timestamp_switch", true);
        this.aNp = com.baidu.live.d.Ba().getBoolean("live_beauty_open_switch", false);
        this.aNq = com.baidu.live.d.Ba().getBoolean("live_unity_beauty_switch", true);
        this.aNr = com.baidu.live.d.Ba().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aNs = com.baidu.live.d.Ba().getBoolean("sp_key_live_game_hard_encode", true);
        this.aNt = com.baidu.live.d.Ba().getBoolean("sp_key_live_play_transcode_support", false);
        this.aNu = com.baidu.live.d.Ba().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aNw = com.baidu.live.d.Ba().getBoolean("ala_enable_graffiti_str", false);
        this.aMs = com.baidu.live.d.Ba().getBoolean("enter_live", false);
        this.aMt = com.baidu.live.d.Ba().getBoolean("sync_to_forum", true);
        this.aMu = com.baidu.live.d.Ba().getBoolean("show_water_mark", false);
        this.aMv = com.baidu.live.d.Ba().getBoolean("show_third_part_water_mark_switch", false);
        this.aMQ = com.baidu.live.d.Ba().getBoolean("stream_error_log", true);
        this.aMR = com.baidu.live.d.Ba().getBoolean("disable_channel_in", true);
        this.aMS = com.baidu.live.d.Ba().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aMT = com.baidu.live.d.Ba().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aMV = com.baidu.live.d.Ba().getBoolean("follow_default_push_switch", true);
        this.aNE = com.baidu.live.d.Ba().getInt("to_tb_some_switch", 0);
        this.aNC = com.baidu.live.d.Ba().getInt("enable_live_stat", 1);
        this.aND = com.baidu.live.d.Ba().getInt("ala_free_gift_task_switch", 0);
        this.aOm = com.baidu.live.d.Ba().getBoolean("live_challenge_switch", false);
        this.aOn = com.baidu.live.d.Ba().getString("live_challenge_tip", null);
        this.aOo = com.baidu.live.d.Ba().getString("live_challenge_url", null);
    }

    private void A(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aMr = optJSONObject.optInt("switch") != 1;
                com.baidu.live.d.Ba().putBoolean("map_around_map", this.aMr);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aMY = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("withdraw_switch", this.aMY);
                this.aNv = optJSONObject2.optString("text");
                com.baidu.live.d.Ba().putString("withdraw_text", this.aNv);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aNo = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("use_internal_player_switch", this.aNo);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aNl = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("use_http_dns_switch", this.aNl);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aNm = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("use_encode_bframe_switch", this.aNm);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aNn = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("enable_opt_timestamp_switch", this.aNn);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.aNp = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("live_beauty_open_switch", this.aNp);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.aNq = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("live_unity_beauty_switch", this.aNq);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.aNr = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("live_unity_beauty_face_style_switch", this.aNr);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.aNs = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("sp_key_live_game_hard_encode", this.aNs);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.aNt = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("sp_key_live_play_transcode_support", this.aNt);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.aNu = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("sp_key_live_play_attention_guide_support", this.aNu);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.aMs = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("enter_live", this.aMs);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.aMt = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.d.Ba().putBoolean("sync_to_forum", this.aMt);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.aMu = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.d.Ba().putBoolean("show_water_mark", this.aMu);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.aMv = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.d.Ba().putBoolean("show_third_part_water_mark_switch", this.aMv);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.aNC = optJSONObject17.optInt("switch");
                com.baidu.live.d.Ba().putInt("enable_live_stat", this.aNC);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.aMQ = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("stream_error_log", this.aMQ);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.aMR = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.d.Ba().putBoolean("disable_channel_in", this.aMR);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.aMS = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.d.Ba().putBoolean("shoubai_yanzhi_tab_tip", this.aMS);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.aMT = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.d.Ba().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aMT);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.aMV = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.d.Ba().putBoolean("follow_default_push_switch", this.aMV);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.aNE = optJSONObject23.optInt("switch");
                com.baidu.live.d.Ba().putInt("to_tb_some_switch", this.aNE);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.aND = optJSONObject24.optInt("switch");
                com.baidu.live.d.Ba().putInt("ala_free_gift_task_switch", this.aNE);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.aNw = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("ala_enable_graffiti_str", this.aNw);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aOm = optJSONObject26.optInt("switch") == 1;
                this.aOn = optJSONObject26.optString("title");
                this.aOo = optJSONObject26.optString("url");
                com.baidu.live.d.Ba().putBoolean("live_challenge_switch", this.aOm);
                com.baidu.live.d.Ba().putString("live_challenge_tip", this.aOn);
                com.baidu.live.d.Ba().putString("live_challenge_url", this.aOo);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aOu = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("is_new_gift_t_dou_strategy", this.aOu);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aOy = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aOw = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("key_is_open_login_prove", this.aOw);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aOx = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("key_is_open_diamond", this.aOx);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aOz = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.d.Ba().putBoolean("key_is_jump_to_live_room", this.aOz);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aOZ = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aPd = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void EN() {
        JSONArray jSONArray;
        this.aMO = com.baidu.live.d.Ba().getString("bluediamond_url", "");
        this.aMC = com.baidu.live.d.Ba().getString("verify_content", this.aMC);
        this.aMB = com.baidu.live.d.Ba().getString("live_notice", "");
        this.aMD = com.baidu.live.d.Ba().getString("activity_notice", "");
        String string = com.baidu.live.d.Ba().getString("imNotice", "");
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
                        this.aMA.add(i, optString);
                    } else {
                        this.aMA.add(i, "");
                    }
                }
            }
        }
        this.aNy = com.baidu.live.d.Ba().getString("share_host", "");
        this.aNz = com.baidu.live.d.Ba().getString("ala_share_in_bar_notice_text", "");
        this.aNB = com.baidu.live.d.Ba().getString("ala_share_reward_rank_notice_text", "");
        this.aNA = com.baidu.live.d.Ba().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aMP = com.baidu.live.d.Ba().getInt("recommend_refresh", 60);
        this.aMW = com.baidu.live.d.Ba().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aMX = com.baidu.live.d.Ba().getInt("strategy_exception_interval", 1);
        this.aMU = com.baidu.live.d.Ba().getInt("liveStartAuthLevel", 1);
        this.aML = com.baidu.live.d.Ba().getInt("2gTo", 5);
        this.aMM = com.baidu.live.d.Ba().getInt("3gTo", 3);
        this.aMN = com.baidu.live.d.Ba().getInt("wifiTo", 3);
        String string2 = com.baidu.live.d.Ba().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aMH = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.d.Ba().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aMI = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aNF = com.baidu.live.d.Ba().getInt("square_tab_strategy", 1);
        this.aNG = com.baidu.live.d.Ba().getString("ala_live_ranklist_url", null);
        this.aNH = com.baidu.live.d.Ba().getString("new_flower_rank_list_description_url", "");
        this.aNI = com.baidu.live.d.Ba().getString("ala_game_player_signup_url", null);
        this.aNJ = com.baidu.live.d.Ba().getString("ala_game_frs_live_tab_video_url", null);
        ER();
        this.aNQ = com.baidu.live.d.Ba().getString("ala_personal_income_detail_url", null);
        this.aOr = com.baidu.live.d.Ba().getInt("ala_custom_gift_category_id", -1);
        this.aNR = com.baidu.live.d.Ba().getInt("ala_live_pk_switch", 0) == 1;
        this.aNS = com.baidu.live.d.Ba().getLong("ala_live_pk_check_interval", 1000L);
        this.aNT = com.baidu.live.d.Ba().getLong("ala_live_pk_match_timeout", AppStatusRules.DEFAULT_GRANULARITY);
        this.aNU = com.baidu.live.d.Ba().getString("ala_live_pk_pic_url", "");
        this.aNV = com.baidu.live.d.Ba().getString("ala_live_pk_pic_jump_url", "");
        this.aNW = com.baidu.live.d.Ba().getString("ala_live_pk_history_link", "");
        this.aNX = com.baidu.live.d.Ba().getString("show_live_forum_url", "");
        this.aNY = com.baidu.live.d.Ba().getLong("ala_challenge_random_interval", 1000L);
        this.aNZ = com.baidu.live.d.Ba().getLong("ala_challenge_direct_interval", 1000L);
        this.aOa = com.baidu.live.d.Ba().getLong("ala_get_challenge_info_interval", 1000L);
        this.aOc = com.baidu.live.d.Ba().getString("ala_challenge_pk_entry_icon_url", "");
        this.aOd = com.baidu.live.d.Ba().getString("ala_challenge_pk_entry_icon_url", "");
        this.aOb = com.baidu.live.d.Ba().getString("ala_challenge_pk_entry_icon_url", "");
        this.aOe = com.baidu.live.d.Ba().getInt("punish_stage_button_switch", 0);
        this.aOf = com.baidu.live.d.Ba().getInt("receive_challenge_im_show_time", 0);
        this.aOg = com.baidu.live.d.Ba().getInt("mvpPunishSwitch", 0);
        this.aOh = com.baidu.live.d.Ba().getInt("toastLifeTime", 10);
        this.aOi = com.baidu.live.d.Ba().getInt("punishLifeTime", 60);
        this.aOs = com.baidu.live.d.Ba().getBoolean("ala_guess_use_https", false);
        gq(com.baidu.live.d.Ba().getString("ala_live_bar_map_str", ""));
        this.aOt = com.baidu.live.d.Ba().getBoolean("is_new_live_close_strategy", false);
        this.aOu = com.baidu.live.d.Ba().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aOv = com.baidu.live.d.Ba().getString("ala_feedback_url", null);
        this.aMZ = com.baidu.live.d.Ba().getInt("ala_video_resolution_level", 3);
        this.aNa = com.baidu.live.d.Ba().getInt("ala_video_encoder_gop", 2);
        this.aNb = com.baidu.live.d.Ba().getBoolean("ala_live_hard_encode_switch", true);
        this.aNc = com.baidu.live.d.Ba().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.d.Ba().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.d.Ba().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.d.Ba().getInt("ala_video_increase_count", 3);
        this.aNd = com.baidu.live.d.Ba().getString("ala_video_soft_bitrate_config", null);
        this.aNe = com.baidu.live.d.Ba().getString("ala_video_hard_bitrate_config", null);
        this.aNi = com.baidu.live.d.Ba().getInt("ala_master_chat_video_resolution_level", 3);
        this.aNj = com.baidu.live.d.Ba().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aNf = com.baidu.live.d.Ba().getString("ala_avts_stream_server_domain_config", null);
        this.aNg = com.baidu.live.d.Ba().getString("ala_master_chat_video_bitrate_config", null);
        this.aNh = com.baidu.live.d.Ba().getString("ala_slave_chat_video_bitrate_config", null);
        this.aNk = com.baidu.live.d.Ba().getString("ala_video_encoder_reset_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.d.Ba().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.d.Ba().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aOw = com.baidu.live.d.Ba().getBoolean("key_is_open_login_prove", false);
        this.aOx = com.baidu.live.d.Ba().getBoolean("key_is_open_diamond", false);
        this.aOz = com.baidu.live.d.Ba().getBoolean("key_is_jump_to_live_room", false);
        go(com.baidu.live.d.Ba().getString("feed_diversion", ""));
        EQ();
    }

    private void go(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aPb = new AlaFeedDiversionData();
                this.aPb.parserJson(jSONObject);
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
                this.aOk = optJSONObject2.optInt("pendant_details_show_times");
                this.aOl = optJSONObject2.optInt("pendant_inform_show_times");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("quick_im_conf");
            if (optJSONObject3 != null) {
                this.aOI = optJSONObject3.optInt("switch", 1) == 1;
                this.aOJ = optJSONObject3.optInt("show_times");
                this.aOK = optJSONObject3.optInt("delay_seconds");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("pksolo");
            if (optJSONObject4 != null) {
                this.aME = optJSONObject4.toString();
                this.aPn = new bw();
                this.aPn.parse(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("poke");
            this.aPo = new by();
            if (optJSONObject5 != null) {
                this.aPo.parse(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject6 != null) {
                this.aMq = optJSONObject6.optString(TipsConfigItem.TipConfigData.TOAST);
                this.aMp = optJSONObject6.optInt("remind_type");
            }
            this.aMO = jSONObject.optString("bluediamond_url");
            com.baidu.live.d.Ba().putString("bluediamond_url", this.aMO);
            this.aMC = jSONObject.optString("verify_content");
            com.baidu.live.d.Ba().putString("verify_content", this.aMC);
            this.aMB = jSONObject.optString("live_notice");
            com.baidu.live.d.Ba().putString("live_notice", this.aMB);
            this.aMD = jSONObject.optString("activityNotice");
            com.baidu.live.d.Ba().putString("activity_notice", this.aMD);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aMA.add(i, optString);
                    } else {
                        this.aMA.add(i, "");
                    }
                }
                com.baidu.live.d.Ba().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.d.Ba().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.aMF.add(i2, optString2);
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
                        this.aMz.add(pVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aMG.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("share_host");
            if (optJSONObject9 != null) {
                this.aNy = optJSONObject9.optString("url");
            } else {
                this.aNy = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject10 != null) {
                this.aNz = optJSONObject10.optString("reward_notice");
                this.aNB = optJSONObject10.optString("reward_rank_notice");
                this.aNA = optJSONObject10.optInt("reward_switch", 2);
            } else {
                this.aNz = "";
                this.aNB = "";
                this.aNA = 2;
            }
            com.baidu.live.d.Ba().putString("share_host", this.aNy);
            com.baidu.live.d.Ba().putString("ala_share_in_bar_notice_text", this.aNz);
            com.baidu.live.d.Ba().putString("ala_share_reward_rank_notice_text", this.aNB);
            com.baidu.live.d.Ba().putInt("ala_share_in_bar_notice_tip_switch", this.aNA);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject11 != null) {
                this.aMP = optJSONObject11.optInt("value");
            } else {
                this.aMP = 60;
            }
            com.baidu.live.d.Ba().putInt("recommend_refresh", this.aMP);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject12 != null) {
                JSONArray optJSONArray5 = optJSONObject12.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.d.Ba().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aMH = g(optJSONArray5);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject13 != null) {
                JSONArray optJSONArray6 = optJSONObject13.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.d.Ba().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aMI = g(optJSONArray6);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject14 != null) {
                this.aMW = optJSONObject14.optString("time_interval");
                this.aMX = optJSONObject14.optInt("exception_interval");
            } else {
                this.aMW = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aMX = 1;
            }
            com.baidu.live.d.Ba().putString("strategy_conf", this.aMW);
            com.baidu.live.d.Ba().putInt("strategy_exception_interval", this.aMX);
            this.aMU = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.d.Ba().putInt("liveStartAuthLevel", this.aMU);
            JSONObject optJSONObject15 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject15 != null) {
                this.aML = optJSONObject15.optInt("2gTo");
                if (this.aML < 3) {
                    this.aML = 3;
                }
                this.aMM = optJSONObject15.optInt("3gTo");
                if (this.aMM < 3) {
                    this.aMM = 3;
                }
                this.aMN = optJSONObject15.optInt("wifiTo");
                if (this.aMN < 3) {
                    this.aMN = 3;
                }
                com.baidu.live.d.Ba().putInt("2gTo", this.aML);
                com.baidu.live.d.Ba().putInt("3gTo", this.aMM);
                com.baidu.live.d.Ba().putInt("wifiTo", this.aMN);
            }
            this.aNF = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.d.Ba().putInt("square_tab_strategy", this.aNF);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject16 != null) {
                this.aNG = optJSONObject16.optString(BigdayActivityConfig.JUMP_URL);
                this.aNH = optJSONObject16.optString("flower_rank_rule");
            }
            com.baidu.live.d.Ba().putString("ala_live_ranklist_url", this.aNG);
            com.baidu.live.d.Ba().putString("new_flower_rank_list_description_url", this.aNH);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject17 != null) {
                this.aNI = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.d.Ba().putString("ala_game_player_signup_url", this.aNI);
            JSONObject optJSONObject18 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject18 != null) {
                this.aNJ = optJSONObject18.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.Ba().putString("ala_game_frs_live_tab_video_url", this.aNJ);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject19 != null) {
                this.aNK = optJSONObject19.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.d.Ba().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aNL.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject20 != null) {
                com.baidu.live.d.Ba().putString("ala_live_session_replace_key", optJSONObject20.toString());
                this.aNO = optJSONObject20.optString("hlsUrl");
                this.aNM = optJSONObject20.optString("rtmpUrl");
                this.aNN = optJSONObject20.optString("flvUrl");
                this.aNP = optJSONObject20.optString(".m3u8");
            }
            b(true, this.aNK);
            JSONObject optJSONObject21 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject21 != null) {
                this.aNQ = optJSONObject21.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.Ba().putString("ala_personal_income_detail_url", this.aNQ);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject22 != null) {
                this.aOr = optJSONObject22.optInt("android_show");
                com.baidu.live.d.Ba().putInt("ala_custom_gift_category_id", this.aOr);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("pub_show_conf");
            if (optJSONObject23 != null) {
                this.aPt = new cq();
                this.aPt.parserJson(optJSONObject23);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("pub_show_two_conf");
            if (optJSONObject24 != null) {
                this.aPu = new cr();
                this.aPu.parserJson(optJSONObject24);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject25 != null) {
                int optInt = optJSONObject25.optInt("open", 0);
                this.aNR = optInt == 1;
                com.baidu.live.d.Ba().putInt("ala_live_pk_switch", optInt);
                this.aNS = optJSONObject25.optLong("interval");
                if (this.aNS < 1000) {
                    this.aNS = 1000L;
                }
                com.baidu.live.d.Ba().putLong("ala_live_pk_check_interval", this.aNS);
                this.aNT = optJSONObject25.optLong("match_timeout");
                if (this.aNT < AppStatusRules.DEFAULT_GRANULARITY) {
                    this.aNT = AppStatusRules.DEFAULT_GRANULARITY;
                }
                com.baidu.live.d.Ba().putLong("ala_live_pk_match_timeout", this.aNT);
                this.aNU = optJSONObject25.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.d.Ba().putString("ala_live_pk_pic_url", this.aNU);
                this.aNV = optJSONObject25.optString("rank_link");
                com.baidu.live.d.Ba().putString("ala_live_pk_pic_jump_url", this.aNV);
                this.aNW = optJSONObject25.optString("history_link");
                com.baidu.live.d.Ba().putString("ala_live_pk_history_link", this.aNW);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject26 != null) {
                this.aNY = optJSONObject26.optLong("random_interval");
                if (this.aNY < 1000) {
                    this.aNY = 1000L;
                }
                com.baidu.live.d.Ba().putLong("ala_challenge_random_interval", this.aNY);
                this.aNZ = optJSONObject26.optLong("direct_interval");
                if (this.aNZ < 1000) {
                    this.aNZ = 1000L;
                }
                com.baidu.live.d.Ba().putLong("ala_challenge_direct_interval", this.aNZ);
                this.aOa = optJSONObject26.optLong("challenge_info_interval");
                if (this.aOa < 1000) {
                    this.aOa = 1000L;
                }
                com.baidu.live.d.Ba().putLong("ala_get_challenge_info_interval", this.aOa);
                this.aOc = optJSONObject26.optString("pk_icon_url");
                com.baidu.live.d.Ba().putString("ala_challenge_pk_entry_icon_url", this.aOc);
                this.aOd = optJSONObject26.optString("icon_url");
                com.baidu.live.d.Ba().putString("ala_challenge_pk_entry_icon_url", this.aOd);
                this.aOb = optJSONObject26.optString("rule_url");
                com.baidu.live.d.Ba().putString("ala_challenge_pk_entry_icon_url", this.aOb);
                this.aOe = optJSONObject26.optInt("punish_stage_button_switch");
                com.baidu.live.d.Ba().putInt("punish_stage_button_switch", this.aOe);
                this.aOf = optJSONObject26.optInt("receive_challenge_im_show_time");
                com.baidu.live.d.Ba().putInt("receive_challenge_im_show_time", this.aOf);
                this.aOg = optJSONObject26.optInt("mvpPunishSwitch");
                com.baidu.live.d.Ba().putInt("mvpPunishSwitch", this.aOg);
                this.aOh = optJSONObject26.optInt("toastLifeTime");
                com.baidu.live.d.Ba().putInt("toastLifeTime", this.aOh);
                this.aOi = optJSONObject26.optInt("punishLifeTime");
                com.baidu.live.d.Ba().putInt("punishLifeTime", this.aOi);
                this.aOj = optJSONObject26.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject27 != null) {
                this.aNX = optJSONObject27.optString("go_url");
                com.baidu.live.d.Ba().putString("show_live_forum_url", this.aNX);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject28 != null) {
                this.aOs = optJSONObject28.optInt("use_https", 0) == 1;
                com.baidu.live.d.Ba().putBoolean("ala_guess_use_https", this.aOs);
            }
            String optString3 = jSONObject.optString("live_bar");
            gq(optString3);
            com.baidu.live.d.Ba().putString("ala_live_bar_map_str", optString3);
            this.aOt = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.d.Ba().putBoolean("is_new_live_close_strategy", this.aOt);
            this.aOu = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.d.Ba().putBoolean("is_new_gift_t_dou_strategy", this.aOu);
            this.aOv = jSONObject.optString("feedback_url");
            com.baidu.live.d.Ba().putString("ala_feedback_url", this.aOv);
            JSONObject optJSONObject29 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject29 != null && (optJSONObject = optJSONObject29.optJSONObject("challenge_related_zip")) != null) {
                this.aOp = optJSONObject.optString("zip_md5");
                this.aOq = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject30 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject30.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject30.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.d.Ba().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.d.Ba().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("open_live");
            if (optJSONObject31 != null) {
                this.increaseThreshold = optJSONObject31.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.d.Ba().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject31.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.d.Ba().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject31.optInt("thi_count", 3);
                com.baidu.live.d.Ba().putInt("ala_video_increase_count", this.increaseCount);
                this.aNb = optJSONObject31.optInt("encoder", 1) == 1;
                com.baidu.live.d.Ba().putBoolean("ala_live_hard_encode_switch", this.aNb);
                this.aNa = optJSONObject31.optInt("video_gop", 2);
                com.baidu.live.d.Ba().putInt("ala_video_encoder_gop", this.aNa);
                this.aNc = optJSONObject31.optInt("dynamic", 1) == 1;
                com.baidu.live.d.Ba().putBoolean("ala_dynamic_bitrate_switch", this.aNc);
                this.aMZ = optJSONObject31.optInt("resolution", 3);
                com.baidu.live.d.Ba().putInt("ala_video_resolution_level", this.aMZ);
                JSONArray optJSONArray8 = optJSONObject31.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aNd = optJSONArray8.toString();
                    com.baidu.live.d.Ba().putString("ala_video_soft_bitrate_config", this.aNd);
                }
                JSONArray optJSONArray9 = optJSONObject31.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aNe = optJSONArray9.toString();
                    com.baidu.live.d.Ba().putString("ala_video_hard_bitrate_config", this.aNe);
                }
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject32 != null) {
                this.aNf = optJSONObject32.toString();
                com.baidu.live.d.Ba().putString("ala_avts_stream_server_domain_config", this.aNf);
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("encoder_auto_reset");
            if (optJSONObject33 != null) {
                this.aNk = optJSONObject33.toString();
                com.baidu.live.d.Ba().putString("ala_video_encoder_reset_config", this.aNk);
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject34 != null) {
                this.aNi = optJSONObject34.optInt("host_rtc_resolution", 3);
                com.baidu.live.d.Ba().putInt("ala_master_chat_video_resolution_level", this.aNi);
                this.aNj = optJSONObject34.optInt("rtc_resolution", 4);
                com.baidu.live.d.Ba().putInt("ala_slave_chat_video_resolution_level", this.aNj);
                JSONArray optJSONArray10 = optJSONObject34.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aNg = optJSONArray10.toString();
                    com.baidu.live.d.Ba().putString("ala_master_chat_video_bitrate_config", this.aNg);
                }
                JSONArray optJSONArray11 = optJSONObject34.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aNh = optJSONArray11.toString();
                    com.baidu.live.d.Ba().putString("ala_slave_chat_video_bitrate_config", this.aNh);
                }
            }
            JSONObject optJSONObject35 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject35 != null) {
                this.aPg = optJSONObject35.optInt("enter_live_msg_audience_num_p1");
                this.aPh = optJSONObject35.optInt("enter_live_msg_audience_num_p2");
                this.aPi = optJSONObject35.optInt("enter_live_msg_audience_num_p3");
                this.aPe = optJSONObject35.optInt("im_intercept_switch");
                this.aPf = optJSONObject35.optInt("is_check_im_content");
            }
            JSONObject optJSONObject36 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject36 != null) {
                this.aPb = new AlaFeedDiversionData();
                this.aPb.parserJson(optJSONObject36);
                com.baidu.live.d.Ba().putString("feed_diversion", optJSONObject36.toString());
            }
            JSONObject optJSONObject37 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject37 != null) {
                com.baidu.live.d.Ba().putString("key_stat_switch", optJSONObject37.toString());
            }
            JSONObject optJSONObject38 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject38 != null) {
                this.aPj = optJSONObject38.optInt("unfold_interval", 5000);
                this.aPk = optJSONObject38.optInt("fold_interval", 55000);
            }
            JSONObject optJSONObject39 = jSONObject.optJSONObject("modify_default_name_conf");
            if (optJSONObject39 != null) {
                this.aPp = new bs();
                this.aPp.parserJson(optJSONObject39);
            }
            JSONObject optJSONObject40 = jSONObject.optJSONObject("audio_live_conf");
            if (optJSONObject40 != null) {
                this.aPq = new ce();
                this.aPq.parse(optJSONObject40);
            }
            JSONObject optJSONObject41 = jSONObject.optJSONObject("quit_live_rec_conf");
            this.aPr = new ah();
            this.aPr.parse(optJSONObject41);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void C(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOQ = jSONObject.optInt("im_max", 200);
            if (this.aOQ <= 0) {
                this.aOQ = 200;
            }
            this.aOR = jSONObject.optInt("barrage_max", 100);
            if (this.aOR <= 0) {
                this.aOR = 100;
            }
            this.aOS = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aOS <= 0) {
                this.aOS = 10;
            }
            this.aOT = jSONObject.optInt("enter_effect_max", 10);
            if (this.aOT <= 0) {
                this.aOT = 10;
            }
            this.aOU = jSONObject.optInt("gift_big_max", 10);
            if (this.aOU <= 0) {
                this.aOU = 10;
            }
            this.aOV = jSONObject.optInt("audio_gift_big_max", 15);
            if (this.aOV <= 0) {
                this.aOV = 15;
            }
            this.aOW = jSONObject.optInt("gift_small_max", 50);
            if (this.aOW <= 0) {
                this.aOW = 50;
            }
            this.aOX = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aOX <= 0) {
                this.aOX = 5;
            }
        }
    }

    private void EO() {
        this.aOA = com.baidu.live.d.Ba().getInt("guide_speak_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        this.aOB = com.baidu.live.d.Ba().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.d.Ba().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aOC = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aOC[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void D(JSONObject jSONObject) {
        int length;
        this.aOA = jSONObject.optInt("rule_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL) * 1000;
        com.baidu.live.d.Ba().putInt("guide_speak_watch_time", this.aOA);
        this.aOB = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.d.Ba().putInt("guide_speak_show_times_max", this.aOB);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aOC = new String[length];
            for (int i = 0; i < length; i++) {
                this.aOC[i] = optJSONArray.optString(i);
            }
            com.baidu.live.d.Ba().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void EP() {
        String string = com.baidu.live.d.Ba().getString("yuan_package_data", "");
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
            this.aOL = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aOL.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void gp(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aON = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aON.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aOO = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aOO.add(str3);
                            }
                        }
                    }
                    com.baidu.live.d.Ba().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void EQ() {
        gp(com.baidu.live.d.Ba().getString("ala_quick_send_im_list", null));
    }

    private void gq(String str) {
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
        if (i != this.aNK) {
            z2 = true;
        }
        this.aNK = i;
        if (z || z2) {
            com.baidu.live.d.Ba().putInt("ala_live_session_default_key", i);
        }
    }

    private void ER() {
        this.aNK = com.baidu.live.d.Ba().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.d.Ba().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aNL.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.d.Ba().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aNO = jSONObject.optString("hlsUrl");
                this.aNM = jSONObject.optString("rtmpUrl");
                this.aNN = jSONObject.optString("flvUrl");
                this.aNP = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean ES() {
        return this.aND == 1;
    }
}
