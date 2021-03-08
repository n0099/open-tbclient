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
public class ar extends BaseData {
    public boolean aLI;
    public boolean aLJ;
    public boolean aLK;
    public boolean aLL;
    public boolean aLM;
    public String aLN;
    public String aLO;
    public String aLS;
    public String aLT;
    public String aLU;
    public String aLV;
    public int aLW;
    public Integer[] aLZ;
    public int aMA;
    public int aMB;
    public String aMC;
    public boolean aMD;
    public int aME;
    public int aMF;
    public int aMG;
    public String aMH;
    public boolean aMI;
    public boolean aMJ;
    public boolean aMK;
    public boolean aML;
    public boolean aMM;
    public boolean aMN;
    public boolean aMO;
    public String aMS;
    public String aMU;
    public String aMV;
    public Integer[] aMa;
    public int aMb;
    public int aMd;
    public int aMe;
    public int aMf;
    public String aMg;
    public int aMh;
    public boolean aMi;
    public boolean aMj;
    public boolean aMk;
    public boolean aMl;
    public boolean aMn;
    public String aMo;
    public int aMp;
    public boolean aMq;
    public int aMr;
    public int aMs;
    public boolean aMt;
    public boolean aMu;
    public String aMv;
    public String aMw;
    public String aMx;
    public String aMy;
    public String aMz;
    public String aNA;
    public int aNB;
    public int aNC;
    public int aND;
    public String aNK;
    public String aNL;
    public String aNM;
    public String aNN;
    public int aNO;
    public String aNS;
    public int aNY;
    public int aNZ;
    public int aNb;
    public String aNd;
    public String aNe;
    private String aNf;
    private String aNg;
    public int aNh;
    public String aNj;
    public String aNk;
    public String aNl;
    public String aNm;
    public String aNn;
    public boolean aNo;
    public long aNp;
    public long aNq;
    public String aNr;
    public String aNs;
    public String aNt;
    public String aNu;
    public long aNv;
    public long aNw;
    public long aNx;
    public String aNy;
    public String aNz;
    public String aOA;
    public AlaFeedDiversionData aOB;
    public w aOC;
    public boolean aOD;
    public int aOE;
    public int aOF;
    public as aOL;
    public ch aOM;
    public cc aON;
    public cd aOO;
    public cb aOP;
    public cb aOQ;
    public cf aOR;
    public bx aOS;
    public cl aOT;
    public al aOU;
    public String[] aOa;
    public int aOb;
    public String aOc;
    public String aOd;
    public QuickImInputData aOe;
    public QuickImInputData aOf;
    public List<YuanPackageData> aOl;
    public bo aOm;
    public List<String> aOn;
    public List<String> aOo;
    public List<String> aOp;
    public bb aOy;
    public boolean aOz;
    public String aPa;
    public String aPe;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aLG = -1;
    public String aLH = null;
    public int aMm = 1;
    public boolean aMP = true;
    public boolean aMQ = false;
    public boolean aMR = false;
    public boolean aMT = false;
    public String aMW = "";
    private int aMX = 2;
    public String aMY = "";
    public int aMZ = 1;
    public int aNa = 0;
    public int aNc = 1;
    public List<String> aNi = new ArrayList();
    public int aNE = 10;
    public int aNF = 60;
    public long aNG = 10000;
    public int aNH = 11;
    public int aNI = 4;
    public boolean aNJ = false;
    public boolean aNP = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aNQ = false;
    public boolean aNR = false;
    public boolean aNT = false;
    public boolean aNU = false;
    public boolean aNV = false;
    public boolean aNW = false;
    public boolean aNX = false;
    public boolean aOg = false;
    public int aOh = 50;
    public int aOi = 0;
    public boolean aOj = false;
    public int aOk = 60;
    public int aOq = 200;
    public int aOr = 100;
    public int aOs = 10;
    public int aOt = 10;
    public int aOu = 10;
    public int aOv = 15;
    public int aOw = 50;
    public int aOx = 5;
    public int aOG = 20;
    public int aOH = 70;
    public int aOI = 10000;
    public int aOJ = 5000;
    public int aOK = 55000;
    public cw aOV = cw.aUo;
    public cx aOW = cx.aUt;
    public Map<Integer, String> aOX = new HashMap();
    public int aOY = 0;
    public int aOZ = 15;
    public float aPb = 0.1f;
    public float aPc = 0.2f;
    public float aPd = 0.7f;
    public List<String> aLR = new ArrayList();
    public List<String> aMc = new ArrayList();
    public List<String> aLX = new ArrayList();
    public List<Integer> aLY = new ArrayList();
    public ArrayList<t> aLP = new ArrayList<>();
    public ArrayList<t> aLQ = new ArrayList<>();

    public ar(boolean z) {
        if (z) {
            Ch();
            this.aMb = com.baidu.live.d.xf().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.d.xf().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.d.xf().getInt("restart_time_interval", 300);
            Ci();
            Cg();
            Cj();
            Ck();
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
                    C(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject3 != null) {
                    this.aMb = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.d.xf().putInt("conn_conf", this.aMb);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aMc.add(i, optString);
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
                    D(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    E(optJSONObject5);
                }
                this.aMU = jSONObject.optString("client_id");
                com.baidu.live.d.xf().putString("client_id", this.aMU);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aLN = optJSONObject6.optString("pic_url");
                    this.aLO = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            t tVar = new t();
                            tVar.parseJson(optJSONObject8);
                            this.aLP.add(tVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.d.xf().putString("pic_url", this.aLN);
                com.baidu.live.d.xf().putString(BigdayActivityConfig.JUMP_URL, this.aLO);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    F(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aOb = optJSONObject10.optInt("resource_switch");
                    this.aOd = optJSONObject10.optString("photo_url");
                    this.aOc = optJSONObject10.optString("resource_url");
                }
                this.aOe = new QuickImInputData();
                this.aOe.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aOf = new QuickImInputData();
                this.aOf.parseJson(jSONObject.getJSONArray("fast_reply_word_audio"));
                this.aOm = bo.G(jSONObject.optJSONObject("guide_follow"));
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
                        this.aOA = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aOy = new bb();
                    this.aOy.aQd = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.d.xf().putString("ala_certify_refuse_url", this.aOy.aQd);
                }
                this.aOL = new as();
                this.aOL.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aOC = new w();
                    this.aOC.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aOM = new ch(optJSONObject16);
                }
                com.baidu.live.guardclub.g.IW().Q(jSONObject.optJSONObject("old_club_member_level_icons"));
                JSONObject optJSONObject17 = jSONObject.optJSONObject("new_level_icon_urls");
                if (optJSONObject17 != null) {
                    int length2 = optJSONObject17.length();
                    for (int i3 = 1; i3 <= length2; i3++) {
                        this.aOX.put(Integer.valueOf(i3), optJSONObject17.optString(i3 + ""));
                    }
                }
                JSONObject optJSONObject18 = jSONObject.optJSONObject("collection_guide_config");
                if (optJSONObject18 != null) {
                    com.baidu.live.d.xf().putString("guide_follow_float_config", optJSONObject18.toString());
                }
                JSONObject optJSONObject19 = jSONObject.optJSONObject("memory_detection");
                if (optJSONObject19 != null) {
                    this.aOY = optJSONObject19.optInt("memory_test");
                    this.aOZ = optJSONObject19.optInt("time_interval");
                    this.aPa = optJSONObject19.optString("warn_text");
                    JSONObject optJSONObject20 = optJSONObject19.optJSONObject("android_available_threshold");
                    if (optJSONObject20 != null) {
                        try {
                            this.aPb = Float.parseFloat(optJSONObject20.optString("available_alarm_threshold"));
                            this.aPc = Float.parseFloat(optJSONObject20.optString("available_resume_threshold"));
                            this.aPd = Float.parseFloat(optJSONObject20.optString("queue_limit_ratio"));
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.d.xf().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void Cg() {
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
            this.aOp = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aOp.add(jSONArray.optString(i));
            }
        }
    }

    private void Ch() {
        this.aLI = com.baidu.live.d.xf().getBoolean("map_around_map", false);
        this.aMq = com.baidu.live.d.xf().getBoolean("withdraw_switch", true);
        this.aMS = com.baidu.live.d.xf().getString("withdraw_text", "");
        this.aML = com.baidu.live.d.xf().getBoolean("use_internal_player_switch", true);
        this.aMI = com.baidu.live.d.xf().getBoolean("use_http_dns_switch", true);
        this.aMJ = com.baidu.live.d.xf().getBoolean("use_encode_bframe_switch", false);
        this.aMK = com.baidu.live.d.xf().getBoolean("enable_opt_timestamp_switch", true);
        this.aMD = com.baidu.live.d.xf().getBoolean("enable_background_push_switch", false);
        this.aMM = com.baidu.live.d.xf().getBoolean("live_beauty_open_switch", false);
        this.aMN = com.baidu.live.d.xf().getBoolean("live_unity_beauty_switch", true);
        this.aMO = com.baidu.live.d.xf().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aMP = com.baidu.live.d.xf().getBoolean("sp_key_live_game_hard_encode", true);
        this.aMQ = com.baidu.live.d.xf().getBoolean("sp_key_live_play_transcode_support", false);
        this.aMR = com.baidu.live.d.xf().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aMT = com.baidu.live.d.xf().getBoolean("ala_enable_graffiti_str", false);
        this.aLJ = com.baidu.live.d.xf().getBoolean("enter_live", false);
        this.aLK = com.baidu.live.d.xf().getBoolean("sync_to_forum", true);
        this.aLL = com.baidu.live.d.xf().getBoolean("show_water_mark", false);
        this.aLM = com.baidu.live.d.xf().getBoolean("show_third_part_water_mark_switch", false);
        this.aMi = com.baidu.live.d.xf().getBoolean("stream_error_log", true);
        this.aMj = com.baidu.live.d.xf().getBoolean("disable_channel_in", true);
        this.aMk = com.baidu.live.d.xf().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aMl = com.baidu.live.d.xf().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aMn = com.baidu.live.d.xf().getBoolean("follow_default_push_switch", true);
        this.aNb = com.baidu.live.d.xf().getInt("to_tb_some_switch", 0);
        this.aMZ = com.baidu.live.d.xf().getInt("enable_live_stat", 1);
        this.aNa = com.baidu.live.d.xf().getInt("ala_free_gift_task_switch", 0);
        this.aNJ = com.baidu.live.d.xf().getBoolean("live_challenge_switch", false);
        this.aNK = com.baidu.live.d.xf().getString("live_challenge_tip", null);
        this.aNL = com.baidu.live.d.xf().getString("live_challenge_url", null);
    }

    private void C(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aLI = optJSONObject.optInt("switch") != 1;
                com.baidu.live.d.xf().putBoolean("map_around_map", this.aLI);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aMq = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("withdraw_switch", this.aMq);
                this.aMS = optJSONObject2.optString("text");
                com.baidu.live.d.xf().putString("withdraw_text", this.aMS);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aML = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("use_internal_player_switch", this.aML);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aMI = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("use_http_dns_switch", this.aMI);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aMJ = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("use_encode_bframe_switch", this.aMJ);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aMK = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("enable_opt_timestamp_switch", this.aMK);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("bg_push");
            if (optJSONObject7 != null) {
                this.aMD = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("enable_background_push_switch", this.aMD);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject8 != null) {
                this.aMM = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("live_beauty_open_switch", this.aMM);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject9 != null) {
                this.aMN = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("live_unity_beauty_switch", this.aMN);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject10 != null) {
                this.aMO = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("live_unity_beauty_face_style_switch", this.aMO);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject11 != null) {
                this.aMP = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("sp_key_live_game_hard_encode", this.aMP);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject12 != null) {
                this.aMQ = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("sp_key_live_play_transcode_support", this.aMQ);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject13 != null) {
                this.aMR = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("sp_key_live_play_attention_guide_support", this.aMR);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject14 != null) {
                this.aLJ = optJSONObject14.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("enter_live", this.aLJ);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject15 != null) {
                this.aLK = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean("sync_to_forum", this.aLK);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject16 != null) {
                this.aLL = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean("show_water_mark", this.aLL);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject17 != null) {
                this.aLM = optJSONObject17.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean("show_third_part_water_mark_switch", this.aLM);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject18 != null) {
                this.aMZ = optJSONObject18.optInt("switch");
                com.baidu.live.d.xf().putInt("enable_live_stat", this.aMZ);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject19 != null) {
                this.aMi = optJSONObject19.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("stream_error_log", this.aMi);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject20 != null) {
                this.aMj = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean("disable_channel_in", this.aMj);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject21 != null) {
                this.aMk = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean("shoubai_yanzhi_tab_tip", this.aMk);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject22 != null) {
                this.aMl = optJSONObject22.optString("switch").equals("1");
                com.baidu.live.d.xf().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aMl);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject23 != null) {
                this.aMn = optJSONObject23.optString("switch").equals("2");
                com.baidu.live.d.xf().putBoolean("follow_default_push_switch", this.aMn);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject24 != null) {
                this.aNb = optJSONObject24.optInt("switch");
                com.baidu.live.d.xf().putInt("to_tb_some_switch", this.aNb);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("task_config");
            if (optJSONObject25 != null) {
                this.aNa = optJSONObject25.optInt("switch");
                com.baidu.live.d.xf().putInt("ala_free_gift_task_switch", this.aNb);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject26 != null) {
                this.aMT = optJSONObject26.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("ala_enable_graffiti_str", this.aMT);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject27 != null) {
                this.aNJ = optJSONObject27.optInt("switch") == 1;
                this.aNK = optJSONObject27.optString("title");
                this.aNL = optJSONObject27.optString("url");
                com.baidu.live.d.xf().putBoolean("live_challenge_switch", this.aNJ);
                com.baidu.live.d.xf().putString("live_challenge_tip", this.aNK);
                com.baidu.live.d.xf().putString("live_challenge_url", this.aNL);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject28 != null) {
                this.aNR = optJSONObject28.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("is_new_gift_t_dou_strategy", this.aNR);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject29 != null) {
                this.aNV = optJSONObject29.optInt("switch") == 1;
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject30 != null) {
                this.aNT = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("key_is_open_login_prove", this.aNT);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject31 != null) {
                this.aNU = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("key_is_open_diamond", this.aNU);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject32 != null) {
                this.aNW = optJSONObject32.optInt("switch") == 1;
                com.baidu.live.d.xf().putBoolean("key_is_jump_to_live_room", this.aNW);
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("gongyan_align");
            if (optJSONObject33 != null) {
                this.aNX = optJSONObject33.optInt("android_switch") == 1;
                com.baidu.live.d.xf().putBoolean("switch_video_mode", this.aNX);
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject34 != null && (optInt2 = optJSONObject34.optInt("switch", -1)) >= 0) {
                this.aOz = optInt2 == 1;
            }
            JSONObject optJSONObject35 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject35 != null && (optInt = optJSONObject35.optInt("switch", -1)) >= 0) {
                this.aOD = optInt == 1;
            }
            JSONObject optJSONObject36 = jSONObject.optJSONObject("live_show_exit_live_mix");
            if (optJSONObject36 != null) {
                com.baidu.live.d.xf().putInt("show_enter_mix_switch", optJSONObject36.optInt("switch"));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void Ci() {
        JSONArray jSONArray;
        String[] split;
        this.aMg = com.baidu.live.d.xf().getString("bluediamond_url", "");
        this.aLT = com.baidu.live.d.xf().getString("verify_content", this.aLT);
        this.aLS = com.baidu.live.d.xf().getString("live_notice", "");
        this.aLU = com.baidu.live.d.xf().getString("activity_notice", "");
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
                        this.aLR.add(i, optString);
                    } else {
                        this.aLR.add(i, "");
                    }
                }
            }
        }
        this.aMV = com.baidu.live.d.xf().getString("share_host", "");
        this.aMW = com.baidu.live.d.xf().getString("ala_share_in_bar_notice_text", "");
        this.aMY = com.baidu.live.d.xf().getString("ala_share_reward_rank_notice_text", "");
        this.aMX = com.baidu.live.d.xf().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aMh = com.baidu.live.d.xf().getInt("recommend_refresh", 60);
        this.aMo = com.baidu.live.d.xf().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aMp = com.baidu.live.d.xf().getInt("strategy_exception_interval", 1);
        this.aMm = com.baidu.live.d.xf().getInt("liveStartAuthLevel", 1);
        this.aMd = com.baidu.live.d.xf().getInt("2gTo", 5);
        this.aMe = com.baidu.live.d.xf().getInt("3gTo", 3);
        this.aMf = com.baidu.live.d.xf().getInt("wifiTo", 3);
        String string2 = com.baidu.live.d.xf().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aLZ = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.d.xf().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aMa = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aNc = com.baidu.live.d.xf().getInt("square_tab_strategy", 1);
        this.aNd = com.baidu.live.d.xf().getString("ala_live_ranklist_url", null);
        this.aNe = com.baidu.live.d.xf().getString("new_flower_rank_list_description_url", "");
        this.aNf = com.baidu.live.d.xf().getString("ala_game_player_signup_url", null);
        this.aNg = com.baidu.live.d.xf().getString("ala_game_frs_live_tab_video_url", null);
        Cm();
        this.aNn = com.baidu.live.d.xf().getString("ala_personal_income_detail_url", null);
        this.aNO = com.baidu.live.d.xf().getInt("ala_custom_gift_category_id", -1);
        this.aNo = com.baidu.live.d.xf().getInt("ala_live_pk_switch", 0) == 1;
        this.aNp = com.baidu.live.d.xf().getLong("ala_live_pk_check_interval", 1000L);
        this.aNq = com.baidu.live.d.xf().getLong("ala_live_pk_match_timeout", AppStatusRules.DEFAULT_GRANULARITY);
        this.aNr = com.baidu.live.d.xf().getString("ala_live_pk_pic_url", "");
        this.aNs = com.baidu.live.d.xf().getString("ala_live_pk_pic_jump_url", "");
        this.aNt = com.baidu.live.d.xf().getString("ala_live_pk_history_link", "");
        this.aNu = com.baidu.live.d.xf().getString("show_live_forum_url", "");
        this.aNv = com.baidu.live.d.xf().getLong("ala_challenge_random_interval", 1000L);
        this.aNw = com.baidu.live.d.xf().getLong("ala_challenge_direct_interval", 1000L);
        this.aNx = com.baidu.live.d.xf().getLong("ala_get_challenge_info_interval", 1000L);
        this.aNz = com.baidu.live.d.xf().getString("ala_challenge_pk_entry_icon_url", "");
        this.aNA = com.baidu.live.d.xf().getString("ala_challenge_pk_entry_icon_url", "");
        this.aNy = com.baidu.live.d.xf().getString("ala_challenge_pk_entry_icon_url", "");
        this.aNB = com.baidu.live.d.xf().getInt("punish_stage_button_switch", 0);
        this.aNC = com.baidu.live.d.xf().getInt("receive_challenge_im_show_time", 0);
        this.aND = com.baidu.live.d.xf().getInt("mvpPunishSwitch", 0);
        this.aNE = com.baidu.live.d.xf().getInt("toastLifeTime", 10);
        this.aNF = com.baidu.live.d.xf().getInt("punishLifeTime", 60);
        this.aNP = com.baidu.live.d.xf().getBoolean("ala_guess_use_https", false);
        fG(com.baidu.live.d.xf().getString("ala_live_bar_map_str", ""));
        this.aNQ = com.baidu.live.d.xf().getBoolean("is_new_live_close_strategy", false);
        this.aNR = com.baidu.live.d.xf().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aNS = com.baidu.live.d.xf().getString("ala_feedback_url", null);
        this.aMr = com.baidu.live.d.xf().getInt("ala_video_resolution_level", 3);
        this.aMs = com.baidu.live.d.xf().getInt("ala_video_encoder_gop", 2);
        this.aMt = com.baidu.live.d.xf().getBoolean("ala_live_hard_encode_switch", true);
        this.aMu = com.baidu.live.d.xf().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.d.xf().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.d.xf().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.d.xf().getInt("ala_video_increase_count", 3);
        this.aMv = com.baidu.live.d.xf().getString("ala_video_soft_bitrate_config", null);
        this.aMw = com.baidu.live.d.xf().getString("ala_video_hard_bitrate_config", null);
        this.aMA = com.baidu.live.d.xf().getInt("ala_master_chat_video_resolution_level", 3);
        this.aMB = com.baidu.live.d.xf().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aMx = com.baidu.live.d.xf().getString("ala_avts_stream_server_domain_config", null);
        this.aMy = com.baidu.live.d.xf().getString("ala_master_chat_video_bitrate_config", null);
        this.aMz = com.baidu.live.d.xf().getString("ala_slave_chat_video_bitrate_config", null);
        String string4 = com.baidu.live.d.xf().getString("challenge_recorder_resolution", null);
        if (!TextUtils.isEmpty(string4) && (split = string4.split("\\*")) != null && split.length == 2) {
            try {
                this.aME = Integer.parseInt(split[0]);
                this.aMF = Integer.parseInt(split[1]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.aMG = com.baidu.live.d.xf().getInt("challenge_recorder_gop", 1);
        this.aMH = com.baidu.live.d.xf().getString("challenge_recorder_bitrate_conf", null);
        this.aMC = com.baidu.live.d.xf().getString("ala_video_encoder_reset_config", null);
        this.aPe = com.baidu.live.d.xf().getString("blm_rtc_config_sp", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.d.xf().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.d.xf().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aNT = com.baidu.live.d.xf().getBoolean("key_is_open_login_prove", false);
        this.aNU = com.baidu.live.d.xf().getBoolean("key_is_open_diamond", false);
        this.aNW = com.baidu.live.d.xf().getBoolean("key_is_jump_to_live_room", false);
        this.aNX = com.baidu.live.d.xf().getBoolean("switch_video_mode", false);
        fE(com.baidu.live.d.xf().getString("feed_diversion", ""));
        Cl();
    }

    private void fE(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aOB = new AlaFeedDiversionData();
                this.aOB.parserJson(jSONObject);
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

    private void D(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tying_gift_conf");
            if (optJSONObject2 != null) {
                this.aNH = optJSONObject2.optInt("pendant_details_show_times");
                this.aNI = optJSONObject2.optInt("pendant_inform_show_times");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("quick_im_conf");
            if (optJSONObject3 != null) {
                this.aOg = optJSONObject3.optInt("switch") == 1;
                this.aOh = optJSONObject3.optInt("show_times");
                this.aOi = optJSONObject3.optInt("delay_seconds");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("barrage_card_send_conf");
            if (optJSONObject4 != null) {
                this.aOj = optJSONObject4.optInt("switch") == 1;
                this.aOk = optJSONObject4.optInt("watch_times");
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("pksolo");
            if (optJSONObject5 != null) {
                this.aLV = optJSONObject5.toString();
                this.aLW = optJSONObject5.optInt("start_count_down_total", 90);
                this.aON = new cc();
                this.aON.parse(optJSONObject5);
                this.aOP = new cb();
                this.aOP.parse(optJSONObject5);
                this.aOQ = new cb();
                this.aOQ.downloadUrl = optJSONObject5.optString("pk_anti_kill_video_url", "");
                this.aOQ.aSj = optJSONObject5.optString("pk_anti_kill_video_md5", "");
                this.aOO = new cd();
                this.aOO.parse(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("poke");
            this.aOR = new cf();
            if (optJSONObject6 != null) {
                this.aOR.parse(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("blm_rtc_config");
            if (optJSONObject7 != null) {
                this.aPe = optJSONObject7.toString();
                if (!TextUtils.isEmpty(this.aPe)) {
                    com.baidu.live.d.xf().putString("blm_rtc_config_sp", this.aPe);
                }
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject8 != null) {
                this.aLH = optJSONObject8.optString(TipsConfigItem.TipConfigData.TOAST);
                this.aLG = optJSONObject8.optInt("remind_type");
            }
            this.aMg = jSONObject.optString("bluediamond_url");
            com.baidu.live.d.xf().putString("bluediamond_url", this.aMg);
            this.aLT = jSONObject.optString("verify_content");
            com.baidu.live.d.xf().putString("verify_content", this.aLT);
            this.aLS = jSONObject.optString("live_notice");
            com.baidu.live.d.xf().putString("live_notice", this.aLS);
            this.aLU = jSONObject.optString("activityNotice");
            com.baidu.live.d.xf().putString("activity_notice", this.aLU);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aLR.add(i, optString);
                    } else {
                        this.aLR.add(i, "");
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
                        this.aLX.add(i2, optString2);
                    }
                }
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("bd_live_activity");
            if (optJSONObject9 != null && (optJSONArray = optJSONObject9.optJSONArray("main_page")) != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject10 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject10 != null) {
                        t tVar = new t();
                        tVar.parseJson(optJSONObject10);
                        this.aLQ.add(tVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aLY.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("share_host");
            if (optJSONObject11 != null) {
                this.aMV = optJSONObject11.optString("url");
            } else {
                this.aMV = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject12 != null) {
                this.aMW = optJSONObject12.optString("reward_notice");
                this.aMY = optJSONObject12.optString("reward_rank_notice");
                this.aMX = optJSONObject12.optInt("reward_switch", 2);
            } else {
                this.aMW = "";
                this.aMY = "";
                this.aMX = 2;
            }
            com.baidu.live.d.xf().putString("share_host", this.aMV);
            com.baidu.live.d.xf().putString("ala_share_in_bar_notice_text", this.aMW);
            com.baidu.live.d.xf().putString("ala_share_reward_rank_notice_text", this.aMY);
            com.baidu.live.d.xf().putInt("ala_share_in_bar_notice_tip_switch", this.aMX);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject13 != null) {
                this.aMh = optJSONObject13.optInt("value");
            } else {
                this.aMh = 60;
            }
            com.baidu.live.d.xf().putInt("recommend_refresh", this.aMh);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject14 != null) {
                JSONArray optJSONArray5 = optJSONObject14.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.d.xf().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aLZ = g(optJSONArray5);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject15 != null) {
                JSONArray optJSONArray6 = optJSONObject15.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.d.xf().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aMa = g(optJSONArray6);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject16 != null) {
                this.aMo = optJSONObject16.optString("time_interval");
                this.aMp = optJSONObject16.optInt("exception_interval");
            } else {
                this.aMo = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aMp = 1;
            }
            com.baidu.live.d.xf().putString("strategy_conf", this.aMo);
            com.baidu.live.d.xf().putInt("strategy_exception_interval", this.aMp);
            this.aMm = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.d.xf().putInt("liveStartAuthLevel", this.aMm);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject17 != null) {
                this.aMd = optJSONObject17.optInt("2gTo");
                if (this.aMd < 3) {
                    this.aMd = 3;
                }
                this.aMe = optJSONObject17.optInt("3gTo");
                if (this.aMe < 3) {
                    this.aMe = 3;
                }
                this.aMf = optJSONObject17.optInt("wifiTo");
                if (this.aMf < 3) {
                    this.aMf = 3;
                }
                com.baidu.live.d.xf().putInt("2gTo", this.aMd);
                com.baidu.live.d.xf().putInt("3gTo", this.aMe);
                com.baidu.live.d.xf().putInt("wifiTo", this.aMf);
            }
            this.aNc = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.d.xf().putInt("square_tab_strategy", this.aNc);
            JSONObject optJSONObject18 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject18 != null) {
                this.aNd = optJSONObject18.optString(BigdayActivityConfig.JUMP_URL);
                this.aNe = optJSONObject18.optString("flower_rank_rule");
            }
            com.baidu.live.d.xf().putString("ala_live_ranklist_url", this.aNd);
            com.baidu.live.d.xf().putString("new_flower_rank_list_description_url", this.aNe);
            JSONObject optJSONObject19 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject19 != null) {
                this.aNf = optJSONObject19.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.d.xf().putString("ala_game_player_signup_url", this.aNf);
            JSONObject optJSONObject20 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject20 != null) {
                this.aNg = optJSONObject20.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.xf().putString("ala_game_frs_live_tab_video_url", this.aNg);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject21 != null) {
                this.aNh = optJSONObject21.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.d.xf().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aNi.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject22 != null) {
                com.baidu.live.d.xf().putString("ala_live_session_replace_key", optJSONObject22.toString());
                this.aNl = optJSONObject22.optString("hlsUrl");
                this.aNj = optJSONObject22.optString("rtmpUrl");
                this.aNk = optJSONObject22.optString("flvUrl");
                this.aNm = optJSONObject22.optString(".m3u8");
            }
            b(true, this.aNh);
            JSONObject optJSONObject23 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject23 != null) {
                this.aNn = optJSONObject23.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.xf().putString("ala_personal_income_detail_url", this.aNn);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject24 != null) {
                this.aNO = optJSONObject24.optInt("android_show");
                com.baidu.live.d.xf().putInt("ala_custom_gift_category_id", this.aNO);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("pub_show_conf");
            if (optJSONObject25 != null) {
                this.aOV = new cw();
                this.aOV.parserJson(optJSONObject25);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("pub_show_two_conf");
            if (optJSONObject26 != null) {
                this.aOW = new cx();
                this.aOW.parserJson(optJSONObject26);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject27 != null) {
                int optInt = optJSONObject27.optInt("open", 0);
                this.aNo = optInt == 1;
                com.baidu.live.d.xf().putInt("ala_live_pk_switch", optInt);
                this.aNp = optJSONObject27.optLong("interval");
                if (this.aNp < 1000) {
                    this.aNp = 1000L;
                }
                com.baidu.live.d.xf().putLong("ala_live_pk_check_interval", this.aNp);
                this.aNq = optJSONObject27.optLong("match_timeout");
                if (this.aNq < AppStatusRules.DEFAULT_GRANULARITY) {
                    this.aNq = AppStatusRules.DEFAULT_GRANULARITY;
                }
                com.baidu.live.d.xf().putLong("ala_live_pk_match_timeout", this.aNq);
                this.aNr = optJSONObject27.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.d.xf().putString("ala_live_pk_pic_url", this.aNr);
                this.aNs = optJSONObject27.optString("rank_link");
                com.baidu.live.d.xf().putString("ala_live_pk_pic_jump_url", this.aNs);
                this.aNt = optJSONObject27.optString("history_link");
                com.baidu.live.d.xf().putString("ala_live_pk_history_link", this.aNt);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject28 != null) {
                this.aNv = optJSONObject28.optLong("random_interval");
                if (this.aNv < 1000) {
                    this.aNv = 1000L;
                }
                com.baidu.live.d.xf().putLong("ala_challenge_random_interval", this.aNv);
                this.aNw = optJSONObject28.optLong("direct_interval");
                if (this.aNw < 1000) {
                    this.aNw = 1000L;
                }
                com.baidu.live.d.xf().putLong("ala_challenge_direct_interval", this.aNw);
                this.aNx = optJSONObject28.optLong("challenge_info_interval");
                if (this.aNx < 1000) {
                    this.aNx = 1000L;
                }
                com.baidu.live.d.xf().putLong("ala_get_challenge_info_interval", this.aNx);
                this.aNz = optJSONObject28.optString("pk_icon_url");
                com.baidu.live.d.xf().putString("ala_challenge_pk_entry_icon_url", this.aNz);
                this.aNA = optJSONObject28.optString("icon_url");
                com.baidu.live.d.xf().putString("ala_challenge_pk_entry_icon_url", this.aNA);
                this.aNy = optJSONObject28.optString("rule_url");
                com.baidu.live.d.xf().putString("ala_challenge_pk_entry_icon_url", this.aNy);
                this.aNB = optJSONObject28.optInt("punish_stage_button_switch");
                com.baidu.live.d.xf().putInt("punish_stage_button_switch", this.aNB);
                this.aNC = optJSONObject28.optInt("receive_challenge_im_show_time");
                com.baidu.live.d.xf().putInt("receive_challenge_im_show_time", this.aNC);
                this.aND = optJSONObject28.optInt("mvpPunishSwitch");
                com.baidu.live.d.xf().putInt("mvpPunishSwitch", this.aND);
                this.aNE = optJSONObject28.optInt("toastLifeTime");
                com.baidu.live.d.xf().putInt("toastLifeTime", this.aNE);
                this.aNF = optJSONObject28.optInt("punishLifeTime");
                com.baidu.live.d.xf().putInt("punishLifeTime", this.aNF);
                this.aNG = optJSONObject28.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject29 != null) {
                this.aNu = optJSONObject29.optString("go_url");
                com.baidu.live.d.xf().putString("show_live_forum_url", this.aNu);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject30 != null) {
                this.aNP = optJSONObject30.optInt("use_https", 0) == 1;
                com.baidu.live.d.xf().putBoolean("ala_guess_use_https", this.aNP);
            }
            String optString3 = jSONObject.optString("live_bar");
            fG(optString3);
            com.baidu.live.d.xf().putString("ala_live_bar_map_str", optString3);
            this.aNQ = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.d.xf().putBoolean("is_new_live_close_strategy", this.aNQ);
            this.aNR = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.d.xf().putBoolean("is_new_gift_t_dou_strategy", this.aNR);
            this.aNS = jSONObject.optString("feedback_url");
            com.baidu.live.d.xf().putString("ala_feedback_url", this.aNS);
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject31 != null && (optJSONObject = optJSONObject31.optJSONObject("challenge_related_zip")) != null) {
                this.aNM = optJSONObject.optString("zip_md5");
                this.aNN = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject32 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject32.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject32.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.d.xf().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.d.xf().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("open_live");
            if (optJSONObject33 != null) {
                this.increaseThreshold = optJSONObject33.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.d.xf().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject33.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.d.xf().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject33.optInt("thi_count", 3);
                com.baidu.live.d.xf().putInt("ala_video_increase_count", this.increaseCount);
                this.aMt = optJSONObject33.optInt("encoder", 1) == 1;
                com.baidu.live.d.xf().putBoolean("ala_live_hard_encode_switch", this.aMt);
                this.aMs = optJSONObject33.optInt("video_gop", 2);
                com.baidu.live.d.xf().putInt("ala_video_encoder_gop", this.aMs);
                this.aMu = optJSONObject33.optInt("dynamic", 1) == 1;
                com.baidu.live.d.xf().putBoolean("ala_dynamic_bitrate_switch", this.aMu);
                this.aMr = optJSONObject33.optInt("resolution", 3);
                com.baidu.live.d.xf().putInt("ala_video_resolution_level", this.aMr);
                JSONArray optJSONArray8 = optJSONObject33.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aMv = optJSONArray8.toString();
                    com.baidu.live.d.xf().putString("ala_video_soft_bitrate_config", this.aMv);
                }
                JSONArray optJSONArray9 = optJSONObject33.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aMw = optJSONArray9.toString();
                    com.baidu.live.d.xf().putString("ala_video_hard_bitrate_config", this.aMw);
                }
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject34 != null) {
                this.aMx = optJSONObject34.toString();
                com.baidu.live.d.xf().putString("ala_avts_stream_server_domain_config", this.aMx);
            }
            JSONObject optJSONObject35 = jSONObject.optJSONObject("encoder_auto_reset");
            if (optJSONObject35 != null) {
                this.aMC = optJSONObject35.toString();
                com.baidu.live.d.xf().putString("ala_video_encoder_reset_config", this.aMC);
            }
            JSONObject optJSONObject36 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject36 != null) {
                this.aMA = optJSONObject36.optInt("host_rtc_resolution", 3);
                com.baidu.live.d.xf().putInt("ala_master_chat_video_resolution_level", this.aMA);
                this.aMB = optJSONObject36.optInt("rtc_resolution", 4);
                com.baidu.live.d.xf().putInt("ala_slave_chat_video_resolution_level", this.aMB);
                JSONArray optJSONArray10 = optJSONObject36.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aMy = optJSONArray10.toString();
                    com.baidu.live.d.xf().putString("ala_master_chat_video_bitrate_config", this.aMy);
                }
                JSONArray optJSONArray11 = optJSONObject36.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aMz = optJSONArray11.toString();
                    com.baidu.live.d.xf().putString("ala_slave_chat_video_bitrate_config", this.aMz);
                }
            }
            JSONObject optJSONObject37 = jSONObject.optJSONObject("challenge_resolution");
            if (optJSONObject37 != null) {
                this.aME = optJSONObject37.optInt("video_width");
                this.aMF = optJSONObject37.optInt("video_height");
                if (this.aME > 0 && this.aMF > 0) {
                    com.baidu.live.d.xf().putString("challenge_recorder_resolution", this.aME + "*" + this.aMF);
                }
                this.aMG = optJSONObject37.optInt("video_gop", 1);
                com.baidu.live.d.xf().putInt("challenge_recorder_gop", this.aMG);
                JSONArray optJSONArray12 = optJSONObject37.optJSONArray(KsMediaMeta.KSM_KEY_BITRATE);
                if (optJSONArray12 != null) {
                    this.aMH = optJSONArray12.toString();
                    com.baidu.live.d.xf().putString("challenge_recorder_bitrate_conf", this.aMH);
                }
            }
            JSONObject optJSONObject38 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject38 != null) {
                this.aOG = optJSONObject38.optInt("enter_live_msg_audience_num_p1");
                this.aOH = optJSONObject38.optInt("enter_live_msg_audience_num_p2");
                this.aOI = optJSONObject38.optInt("enter_live_msg_audience_num_p3");
                this.aOE = optJSONObject38.optInt("im_intercept_switch");
                this.aOF = optJSONObject38.optInt("is_check_im_content");
            }
            JSONObject optJSONObject39 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject39 != null) {
                this.aOB = new AlaFeedDiversionData();
                this.aOB.parserJson(optJSONObject39);
                com.baidu.live.d.xf().putString("feed_diversion", optJSONObject39.toString());
            }
            JSONObject optJSONObject40 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject40 != null) {
                com.baidu.live.d.xf().putString("key_stat_switch", optJSONObject40.toString());
            }
            JSONObject optJSONObject41 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject41 != null) {
                this.aOJ = optJSONObject41.optInt("unfold_interval", 5000);
                this.aOK = optJSONObject41.optInt("fold_interval", 55000);
            }
            JSONObject optJSONObject42 = jSONObject.optJSONObject("modify_default_name_conf");
            if (optJSONObject42 != null) {
                this.aOS = new bx();
                this.aOS.parserJson(optJSONObject42);
            }
            JSONObject optJSONObject43 = jSONObject.optJSONObject("audio_live_conf");
            if (optJSONObject43 != null) {
                this.aOT = new cl();
                this.aOT.parse(optJSONObject43);
            }
            JSONObject optJSONObject44 = jSONObject.optJSONObject("quit_live_rec_conf");
            this.aOU = new al();
            this.aOU.parse(optJSONObject44);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void E(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOq = jSONObject.optInt("im_max", 200);
            if (this.aOq <= 0) {
                this.aOq = 200;
            }
            this.aOr = jSONObject.optInt("barrage_max", 100);
            if (this.aOr <= 0) {
                this.aOr = 100;
            }
            this.aOs = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aOs <= 0) {
                this.aOs = 10;
            }
            this.aOt = jSONObject.optInt("enter_effect_max", 10);
            if (this.aOt <= 0) {
                this.aOt = 10;
            }
            this.aOu = jSONObject.optInt("gift_big_max", 10);
            if (this.aOu <= 0) {
                this.aOu = 10;
            }
            this.aOv = jSONObject.optInt("audio_gift_big_max", 15);
            if (this.aOv <= 0) {
                this.aOv = 15;
            }
            this.aOw = jSONObject.optInt("gift_small_max", 50);
            if (this.aOw <= 0) {
                this.aOw = 50;
            }
            this.aOx = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aOx <= 0) {
                this.aOx = 5;
            }
        }
    }

    private void Cj() {
        this.aNY = com.baidu.live.d.xf().getInt("guide_speak_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        this.aNZ = com.baidu.live.d.xf().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.d.xf().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aOa = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aOa[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void F(JSONObject jSONObject) {
        int length;
        this.aNY = jSONObject.optInt("rule_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL) * 1000;
        com.baidu.live.d.xf().putInt("guide_speak_watch_time", this.aNY);
        this.aNZ = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.d.xf().putInt("guide_speak_show_times_max", this.aNZ);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aOa = new String[length];
            for (int i = 0; i < length; i++) {
                this.aOa[i] = optJSONArray.optString(i);
            }
            com.baidu.live.d.xf().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void Ck() {
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
            this.aOl = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aOl.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void fF(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aOn = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aOn.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aOo = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aOo.add(str3);
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

    private void Cl() {
        fF(com.baidu.live.d.xf().getString("ala_quick_send_im_list", null));
    }

    private void fG(String str) {
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
        if (i != this.aNh) {
            z2 = true;
        }
        this.aNh = i;
        if (z || z2) {
            com.baidu.live.d.xf().putInt("ala_live_session_default_key", i);
        }
    }

    private void Cm() {
        this.aNh = com.baidu.live.d.xf().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.d.xf().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aNi.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.d.xf().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aNl = jSONObject.optString("hlsUrl");
                this.aNj = jSONObject.optString("rtmpUrl");
                this.aNk = jSONObject.optString("flvUrl");
                this.aNm = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean Cn() {
        return this.aNa == 1;
    }
}
