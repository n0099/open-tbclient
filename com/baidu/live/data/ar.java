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
public class ar extends BaseData {
    public Integer[] aKA;
    public int aKB;
    public int aKD;
    public int aKE;
    public int aKF;
    public String aKG;
    public int aKH;
    public boolean aKI;
    public boolean aKJ;
    public boolean aKK;
    public boolean aKL;
    public boolean aKN;
    public String aKO;
    public int aKP;
    public boolean aKQ;
    public int aKR;
    public int aKS;
    public boolean aKT;
    public boolean aKU;
    public String aKV;
    public String aKW;
    public String aKX;
    public String aKY;
    public String aKZ;
    public boolean aKi;
    public boolean aKj;
    public boolean aKk;
    public boolean aKl;
    public boolean aKm;
    public String aKn;
    public String aKo;
    public String aKs;
    public String aKt;
    public String aKu;
    public String aKv;
    public int aKw;
    public Integer[] aKz;
    public int aLB;
    public String aLD;
    public String aLE;
    private String aLF;
    private String aLG;
    public int aLH;
    public String aLJ;
    public String aLK;
    public String aLL;
    public String aLM;
    public String aLN;
    public boolean aLO;
    public long aLP;
    public long aLQ;
    public String aLR;
    public String aLS;
    public String aLT;
    public String aLU;
    public long aLV;
    public long aLW;
    public long aLX;
    public String aLY;
    public String aLZ;
    public int aLa;
    public int aLb;
    public String aLc;
    public boolean aLd;
    public int aLe;
    public int aLf;
    public int aLg;
    public String aLh;
    public boolean aLi;
    public boolean aLj;
    public boolean aLk;
    public boolean aLl;
    public boolean aLm;
    public boolean aLn;
    public boolean aLo;
    public String aLs;
    public String aLu;
    public String aLv;
    public String[] aMA;
    public int aMB;
    public String aMC;
    public String aMD;
    public QuickImInputData aME;
    public QuickImInputData aMF;
    public List<YuanPackageData> aML;
    public bo aMM;
    public List<String> aMN;
    public List<String> aMO;
    public List<String> aMP;
    public bb aMY;
    public boolean aMZ;
    public String aMa;
    public int aMb;
    public int aMc;
    public int aMd;
    public String aMk;
    public String aMl;
    public String aMm;
    public String aMn;
    public int aMo;
    public String aMs;
    public int aMy;
    public int aMz;
    public String aNA;
    public String aNE;
    public String aNa;
    public AlaFeedDiversionData aNb;
    public w aNc;
    public boolean aNd;
    public int aNe;
    public int aNf;
    public as aNl;
    public ch aNm;
    public cc aNn;
    public cd aNo;
    public cb aNp;
    public cb aNq;
    public cf aNr;
    public bx aNs;
    public cl aNt;
    public al aNu;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aKg = -1;
    public String aKh = null;
    public int aKM = 1;
    public boolean aLp = true;
    public boolean aLq = false;
    public boolean aLr = false;
    public boolean aLt = false;
    public String aLw = "";
    private int aLx = 2;
    public String aLy = "";
    public int aLz = 1;
    public int aLA = 0;
    public int aLC = 1;
    public List<String> aLI = new ArrayList();
    public int aMe = 10;
    public int aMf = 60;
    public long aMg = 10000;
    public int aMh = 11;
    public int aMi = 4;
    public boolean aMj = false;
    public boolean aMp = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aMq = false;
    public boolean aMr = false;
    public boolean aMt = false;
    public boolean aMu = false;
    public boolean aMv = false;
    public boolean aMw = false;
    public boolean aMx = false;
    public boolean aMG = false;
    public int aMH = 50;
    public int aMI = 0;
    public boolean aMJ = false;
    public int aMK = 60;
    public int aMQ = 200;
    public int aMR = 100;
    public int aMS = 10;
    public int aMT = 10;
    public int aMU = 10;
    public int aMV = 15;
    public int aMW = 50;
    public int aMX = 5;
    public int aNg = 20;
    public int aNh = 70;
    public int aNi = 10000;
    public int aNj = 5000;
    public int aNk = 55000;
    public cw aNv = cw.aSO;
    public cx aNw = cx.aST;
    public Map<Integer, String> aNx = new HashMap();
    public int aNy = 0;
    public int aNz = 15;
    public float aNB = 0.1f;
    public float aNC = 0.2f;
    public float aND = 0.7f;
    public List<String> aKr = new ArrayList();
    public List<String> aKC = new ArrayList();
    public List<String> aKx = new ArrayList();
    public List<Integer> aKy = new ArrayList();
    public ArrayList<t> aKp = new ArrayList<>();
    public ArrayList<t> aKq = new ArrayList<>();

    public ar(boolean z) {
        if (z) {
            Ce();
            this.aKB = com.baidu.live.d.xc().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.d.xc().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.d.xc().getInt("restart_time_interval", 300);
            Cf();
            Cd();
            Cg();
            Ch();
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
                    this.aKB = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.d.xc().putInt("conn_conf", this.aKB);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aKC.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.d.xc().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.d.xc().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    B(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    C(optJSONObject5);
                }
                this.aLu = jSONObject.optString("client_id");
                com.baidu.live.d.xc().putString("client_id", this.aLu);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aKn = optJSONObject6.optString("pic_url");
                    this.aKo = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            t tVar = new t();
                            tVar.parseJson(optJSONObject8);
                            this.aKp.add(tVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.d.xc().putString("pic_url", this.aKn);
                com.baidu.live.d.xc().putString(BigdayActivityConfig.JUMP_URL, this.aKo);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    D(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aMB = optJSONObject10.optInt("resource_switch");
                    this.aMD = optJSONObject10.optString("photo_url");
                    this.aMC = optJSONObject10.optString("resource_url");
                }
                this.aME = new QuickImInputData();
                this.aME.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aMF = new QuickImInputData();
                this.aMF.parseJson(jSONObject.getJSONArray("fast_reply_word_audio"));
                this.aMM = bo.E(jSONObject.optJSONObject("guide_follow"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.d.xc().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject11 != null) {
                    JSONObject optJSONObject12 = optJSONObject11.optJSONObject("rank");
                    if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.d.xc().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.d.xc().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.d.xc().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject13 = optJSONObject11.optJSONObject("guard_seat");
                    if (optJSONObject13 != null) {
                        this.aNa = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aMY = new bb();
                    this.aMY.aOD = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.d.xc().putString("ala_certify_refuse_url", this.aMY.aOD);
                }
                this.aNl = new as();
                this.aNl.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aNc = new w();
                    this.aNc.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aNm = new ch(optJSONObject16);
                }
                com.baidu.live.guardclub.g.IT().O(jSONObject.optJSONObject("old_club_member_level_icons"));
                JSONObject optJSONObject17 = jSONObject.optJSONObject("new_level_icon_urls");
                if (optJSONObject17 != null) {
                    int length2 = optJSONObject17.length();
                    for (int i3 = 1; i3 <= length2; i3++) {
                        this.aNx.put(Integer.valueOf(i3), optJSONObject17.optString(i3 + ""));
                    }
                }
                JSONObject optJSONObject18 = jSONObject.optJSONObject("collection_guide_config");
                if (optJSONObject18 != null) {
                    com.baidu.live.d.xc().putString("guide_follow_float_config", optJSONObject18.toString());
                }
                JSONObject optJSONObject19 = jSONObject.optJSONObject("memory_detection");
                if (optJSONObject19 != null) {
                    this.aNy = optJSONObject19.optInt("memory_test");
                    this.aNz = optJSONObject19.optInt("time_interval");
                    this.aNA = optJSONObject19.optString("warn_text");
                    JSONObject optJSONObject20 = optJSONObject19.optJSONObject("android_available_threshold");
                    if (optJSONObject20 != null) {
                        try {
                            this.aNB = Float.parseFloat(optJSONObject20.optString("available_alarm_threshold"));
                            this.aNC = Float.parseFloat(optJSONObject20.optString("available_resume_threshold"));
                            this.aND = Float.parseFloat(optJSONObject20.optString("queue_limit_ratio"));
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
            com.baidu.live.d.xc().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void Cd() {
        String string = com.baidu.live.d.xc().getString("ala_prepare_random_title_list", "");
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
            this.aMP = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aMP.add(jSONArray.optString(i));
            }
        }
    }

    private void Ce() {
        this.aKi = com.baidu.live.d.xc().getBoolean("map_around_map", false);
        this.aKQ = com.baidu.live.d.xc().getBoolean("withdraw_switch", true);
        this.aLs = com.baidu.live.d.xc().getString("withdraw_text", "");
        this.aLl = com.baidu.live.d.xc().getBoolean("use_internal_player_switch", true);
        this.aLi = com.baidu.live.d.xc().getBoolean("use_http_dns_switch", true);
        this.aLj = com.baidu.live.d.xc().getBoolean("use_encode_bframe_switch", false);
        this.aLk = com.baidu.live.d.xc().getBoolean("enable_opt_timestamp_switch", true);
        this.aLd = com.baidu.live.d.xc().getBoolean("enable_background_push_switch", false);
        this.aLm = com.baidu.live.d.xc().getBoolean("live_beauty_open_switch", false);
        this.aLn = com.baidu.live.d.xc().getBoolean("live_unity_beauty_switch", true);
        this.aLo = com.baidu.live.d.xc().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aLp = com.baidu.live.d.xc().getBoolean("sp_key_live_game_hard_encode", true);
        this.aLq = com.baidu.live.d.xc().getBoolean("sp_key_live_play_transcode_support", false);
        this.aLr = com.baidu.live.d.xc().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aLt = com.baidu.live.d.xc().getBoolean("ala_enable_graffiti_str", false);
        this.aKj = com.baidu.live.d.xc().getBoolean("enter_live", false);
        this.aKk = com.baidu.live.d.xc().getBoolean("sync_to_forum", true);
        this.aKl = com.baidu.live.d.xc().getBoolean("show_water_mark", false);
        this.aKm = com.baidu.live.d.xc().getBoolean("show_third_part_water_mark_switch", false);
        this.aKI = com.baidu.live.d.xc().getBoolean("stream_error_log", true);
        this.aKJ = com.baidu.live.d.xc().getBoolean("disable_channel_in", true);
        this.aKK = com.baidu.live.d.xc().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aKL = com.baidu.live.d.xc().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aKN = com.baidu.live.d.xc().getBoolean("follow_default_push_switch", true);
        this.aLB = com.baidu.live.d.xc().getInt("to_tb_some_switch", 0);
        this.aLz = com.baidu.live.d.xc().getInt("enable_live_stat", 1);
        this.aLA = com.baidu.live.d.xc().getInt("ala_free_gift_task_switch", 0);
        this.aMj = com.baidu.live.d.xc().getBoolean("live_challenge_switch", false);
        this.aMk = com.baidu.live.d.xc().getString("live_challenge_tip", null);
        this.aMl = com.baidu.live.d.xc().getString("live_challenge_url", null);
    }

    private void A(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aKi = optJSONObject.optInt("switch") != 1;
                com.baidu.live.d.xc().putBoolean("map_around_map", this.aKi);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aKQ = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("withdraw_switch", this.aKQ);
                this.aLs = optJSONObject2.optString("text");
                com.baidu.live.d.xc().putString("withdraw_text", this.aLs);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aLl = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("use_internal_player_switch", this.aLl);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aLi = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("use_http_dns_switch", this.aLi);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aLj = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("use_encode_bframe_switch", this.aLj);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aLk = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("enable_opt_timestamp_switch", this.aLk);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("bg_push");
            if (optJSONObject7 != null) {
                this.aLd = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("enable_background_push_switch", this.aLd);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject8 != null) {
                this.aLm = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("live_beauty_open_switch", this.aLm);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject9 != null) {
                this.aLn = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("live_unity_beauty_switch", this.aLn);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject10 != null) {
                this.aLo = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("live_unity_beauty_face_style_switch", this.aLo);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject11 != null) {
                this.aLp = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("sp_key_live_game_hard_encode", this.aLp);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject12 != null) {
                this.aLq = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("sp_key_live_play_transcode_support", this.aLq);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject13 != null) {
                this.aLr = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("sp_key_live_play_attention_guide_support", this.aLr);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject14 != null) {
                this.aKj = optJSONObject14.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("enter_live", this.aKj);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject15 != null) {
                this.aKk = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.d.xc().putBoolean("sync_to_forum", this.aKk);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject16 != null) {
                this.aKl = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.d.xc().putBoolean("show_water_mark", this.aKl);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject17 != null) {
                this.aKm = optJSONObject17.optString("switch").equals("1");
                com.baidu.live.d.xc().putBoolean("show_third_part_water_mark_switch", this.aKm);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject18 != null) {
                this.aLz = optJSONObject18.optInt("switch");
                com.baidu.live.d.xc().putInt("enable_live_stat", this.aLz);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject19 != null) {
                this.aKI = optJSONObject19.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("stream_error_log", this.aKI);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject20 != null) {
                this.aKJ = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.d.xc().putBoolean("disable_channel_in", this.aKJ);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject21 != null) {
                this.aKK = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.d.xc().putBoolean("shoubai_yanzhi_tab_tip", this.aKK);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject22 != null) {
                this.aKL = optJSONObject22.optString("switch").equals("1");
                com.baidu.live.d.xc().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aKL);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject23 != null) {
                this.aKN = optJSONObject23.optString("switch").equals("2");
                com.baidu.live.d.xc().putBoolean("follow_default_push_switch", this.aKN);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject24 != null) {
                this.aLB = optJSONObject24.optInt("switch");
                com.baidu.live.d.xc().putInt("to_tb_some_switch", this.aLB);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("task_config");
            if (optJSONObject25 != null) {
                this.aLA = optJSONObject25.optInt("switch");
                com.baidu.live.d.xc().putInt("ala_free_gift_task_switch", this.aLB);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject26 != null) {
                this.aLt = optJSONObject26.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("ala_enable_graffiti_str", this.aLt);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject27 != null) {
                this.aMj = optJSONObject27.optInt("switch") == 1;
                this.aMk = optJSONObject27.optString("title");
                this.aMl = optJSONObject27.optString("url");
                com.baidu.live.d.xc().putBoolean("live_challenge_switch", this.aMj);
                com.baidu.live.d.xc().putString("live_challenge_tip", this.aMk);
                com.baidu.live.d.xc().putString("live_challenge_url", this.aMl);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject28 != null) {
                this.aMr = optJSONObject28.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("is_new_gift_t_dou_strategy", this.aMr);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject29 != null) {
                this.aMv = optJSONObject29.optInt("switch") == 1;
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject30 != null) {
                this.aMt = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("key_is_open_login_prove", this.aMt);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject31 != null) {
                this.aMu = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("key_is_open_diamond", this.aMu);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject32 != null) {
                this.aMw = optJSONObject32.optInt("switch") == 1;
                com.baidu.live.d.xc().putBoolean("key_is_jump_to_live_room", this.aMw);
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("gongyan_align");
            if (optJSONObject33 != null) {
                this.aMx = optJSONObject33.optInt("android_switch") == 1;
                com.baidu.live.d.xc().putBoolean("switch_video_mode", this.aMx);
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject34 != null && (optInt2 = optJSONObject34.optInt("switch", -1)) >= 0) {
                this.aMZ = optInt2 == 1;
            }
            JSONObject optJSONObject35 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject35 != null && (optInt = optJSONObject35.optInt("switch", -1)) >= 0) {
                this.aNd = optInt == 1;
            }
            JSONObject optJSONObject36 = jSONObject.optJSONObject("live_show_exit_live_mix");
            if (optJSONObject36 != null) {
                com.baidu.live.d.xc().putInt("show_enter_mix_switch", optJSONObject36.optInt("switch"));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void Cf() {
        JSONArray jSONArray;
        String[] split;
        this.aKG = com.baidu.live.d.xc().getString("bluediamond_url", "");
        this.aKt = com.baidu.live.d.xc().getString("verify_content", this.aKt);
        this.aKs = com.baidu.live.d.xc().getString("live_notice", "");
        this.aKu = com.baidu.live.d.xc().getString("activity_notice", "");
        String string = com.baidu.live.d.xc().getString("imNotice", "");
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
                        this.aKr.add(i, optString);
                    } else {
                        this.aKr.add(i, "");
                    }
                }
            }
        }
        this.aLv = com.baidu.live.d.xc().getString("share_host", "");
        this.aLw = com.baidu.live.d.xc().getString("ala_share_in_bar_notice_text", "");
        this.aLy = com.baidu.live.d.xc().getString("ala_share_reward_rank_notice_text", "");
        this.aLx = com.baidu.live.d.xc().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aKH = com.baidu.live.d.xc().getInt("recommend_refresh", 60);
        this.aKO = com.baidu.live.d.xc().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aKP = com.baidu.live.d.xc().getInt("strategy_exception_interval", 1);
        this.aKM = com.baidu.live.d.xc().getInt("liveStartAuthLevel", 1);
        this.aKD = com.baidu.live.d.xc().getInt("2gTo", 5);
        this.aKE = com.baidu.live.d.xc().getInt("3gTo", 3);
        this.aKF = com.baidu.live.d.xc().getInt("wifiTo", 3);
        String string2 = com.baidu.live.d.xc().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aKz = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.d.xc().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aKA = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aLC = com.baidu.live.d.xc().getInt("square_tab_strategy", 1);
        this.aLD = com.baidu.live.d.xc().getString("ala_live_ranklist_url", null);
        this.aLE = com.baidu.live.d.xc().getString("new_flower_rank_list_description_url", "");
        this.aLF = com.baidu.live.d.xc().getString("ala_game_player_signup_url", null);
        this.aLG = com.baidu.live.d.xc().getString("ala_game_frs_live_tab_video_url", null);
        Cj();
        this.aLN = com.baidu.live.d.xc().getString("ala_personal_income_detail_url", null);
        this.aMo = com.baidu.live.d.xc().getInt("ala_custom_gift_category_id", -1);
        this.aLO = com.baidu.live.d.xc().getInt("ala_live_pk_switch", 0) == 1;
        this.aLP = com.baidu.live.d.xc().getLong("ala_live_pk_check_interval", 1000L);
        this.aLQ = com.baidu.live.d.xc().getLong("ala_live_pk_match_timeout", AppStatusRules.DEFAULT_GRANULARITY);
        this.aLR = com.baidu.live.d.xc().getString("ala_live_pk_pic_url", "");
        this.aLS = com.baidu.live.d.xc().getString("ala_live_pk_pic_jump_url", "");
        this.aLT = com.baidu.live.d.xc().getString("ala_live_pk_history_link", "");
        this.aLU = com.baidu.live.d.xc().getString("show_live_forum_url", "");
        this.aLV = com.baidu.live.d.xc().getLong("ala_challenge_random_interval", 1000L);
        this.aLW = com.baidu.live.d.xc().getLong("ala_challenge_direct_interval", 1000L);
        this.aLX = com.baidu.live.d.xc().getLong("ala_get_challenge_info_interval", 1000L);
        this.aLZ = com.baidu.live.d.xc().getString("ala_challenge_pk_entry_icon_url", "");
        this.aMa = com.baidu.live.d.xc().getString("ala_challenge_pk_entry_icon_url", "");
        this.aLY = com.baidu.live.d.xc().getString("ala_challenge_pk_entry_icon_url", "");
        this.aMb = com.baidu.live.d.xc().getInt("punish_stage_button_switch", 0);
        this.aMc = com.baidu.live.d.xc().getInt("receive_challenge_im_show_time", 0);
        this.aMd = com.baidu.live.d.xc().getInt("mvpPunishSwitch", 0);
        this.aMe = com.baidu.live.d.xc().getInt("toastLifeTime", 10);
        this.aMf = com.baidu.live.d.xc().getInt("punishLifeTime", 60);
        this.aMp = com.baidu.live.d.xc().getBoolean("ala_guess_use_https", false);
        fA(com.baidu.live.d.xc().getString("ala_live_bar_map_str", ""));
        this.aMq = com.baidu.live.d.xc().getBoolean("is_new_live_close_strategy", false);
        this.aMr = com.baidu.live.d.xc().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aMs = com.baidu.live.d.xc().getString("ala_feedback_url", null);
        this.aKR = com.baidu.live.d.xc().getInt("ala_video_resolution_level", 3);
        this.aKS = com.baidu.live.d.xc().getInt("ala_video_encoder_gop", 2);
        this.aKT = com.baidu.live.d.xc().getBoolean("ala_live_hard_encode_switch", true);
        this.aKU = com.baidu.live.d.xc().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.d.xc().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.d.xc().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.d.xc().getInt("ala_video_increase_count", 3);
        this.aKV = com.baidu.live.d.xc().getString("ala_video_soft_bitrate_config", null);
        this.aKW = com.baidu.live.d.xc().getString("ala_video_hard_bitrate_config", null);
        this.aLa = com.baidu.live.d.xc().getInt("ala_master_chat_video_resolution_level", 3);
        this.aLb = com.baidu.live.d.xc().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aKX = com.baidu.live.d.xc().getString("ala_avts_stream_server_domain_config", null);
        this.aKY = com.baidu.live.d.xc().getString("ala_master_chat_video_bitrate_config", null);
        this.aKZ = com.baidu.live.d.xc().getString("ala_slave_chat_video_bitrate_config", null);
        String string4 = com.baidu.live.d.xc().getString("challenge_recorder_resolution", null);
        if (!TextUtils.isEmpty(string4) && (split = string4.split("\\*")) != null && split.length == 2) {
            try {
                this.aLe = Integer.parseInt(split[0]);
                this.aLf = Integer.parseInt(split[1]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.aLg = com.baidu.live.d.xc().getInt("challenge_recorder_gop", 1);
        this.aLh = com.baidu.live.d.xc().getString("challenge_recorder_bitrate_conf", null);
        this.aLc = com.baidu.live.d.xc().getString("ala_video_encoder_reset_config", null);
        this.aNE = com.baidu.live.d.xc().getString("blm_rtc_config_sp", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.d.xc().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.d.xc().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aMt = com.baidu.live.d.xc().getBoolean("key_is_open_login_prove", false);
        this.aMu = com.baidu.live.d.xc().getBoolean("key_is_open_diamond", false);
        this.aMw = com.baidu.live.d.xc().getBoolean("key_is_jump_to_live_room", false);
        this.aMx = com.baidu.live.d.xc().getBoolean("switch_video_mode", false);
        fy(com.baidu.live.d.xc().getString("feed_diversion", ""));
        Ci();
    }

    private void fy(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aNb = new AlaFeedDiversionData();
                this.aNb.parserJson(jSONObject);
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
                this.aMh = optJSONObject2.optInt("pendant_details_show_times");
                this.aMi = optJSONObject2.optInt("pendant_inform_show_times");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("quick_im_conf");
            if (optJSONObject3 != null) {
                this.aMG = optJSONObject3.optInt("switch") == 1;
                this.aMH = optJSONObject3.optInt("show_times");
                this.aMI = optJSONObject3.optInt("delay_seconds");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("barrage_card_send_conf");
            if (optJSONObject4 != null) {
                this.aMJ = optJSONObject4.optInt("switch") == 1;
                this.aMK = optJSONObject4.optInt("watch_times");
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("pksolo");
            if (optJSONObject5 != null) {
                this.aKv = optJSONObject5.toString();
                this.aKw = optJSONObject5.optInt("start_count_down_total", 90);
                this.aNn = new cc();
                this.aNn.parse(optJSONObject5);
                this.aNp = new cb();
                this.aNp.parse(optJSONObject5);
                this.aNq = new cb();
                this.aNq.downloadUrl = optJSONObject5.optString("pk_anti_kill_video_url", "");
                this.aNq.aQJ = optJSONObject5.optString("pk_anti_kill_video_md5", "");
                this.aNo = new cd();
                this.aNo.parse(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("poke");
            this.aNr = new cf();
            if (optJSONObject6 != null) {
                this.aNr.parse(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("blm_rtc_config");
            if (optJSONObject7 != null) {
                this.aNE = optJSONObject7.toString();
                if (!TextUtils.isEmpty(this.aNE)) {
                    com.baidu.live.d.xc().putString("blm_rtc_config_sp", this.aNE);
                }
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject8 != null) {
                this.aKh = optJSONObject8.optString(TipsConfigItem.TipConfigData.TOAST);
                this.aKg = optJSONObject8.optInt("remind_type");
            }
            this.aKG = jSONObject.optString("bluediamond_url");
            com.baidu.live.d.xc().putString("bluediamond_url", this.aKG);
            this.aKt = jSONObject.optString("verify_content");
            com.baidu.live.d.xc().putString("verify_content", this.aKt);
            this.aKs = jSONObject.optString("live_notice");
            com.baidu.live.d.xc().putString("live_notice", this.aKs);
            this.aKu = jSONObject.optString("activityNotice");
            com.baidu.live.d.xc().putString("activity_notice", this.aKu);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aKr.add(i, optString);
                    } else {
                        this.aKr.add(i, "");
                    }
                }
                com.baidu.live.d.xc().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.d.xc().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.aKx.add(i2, optString2);
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
                        this.aKq.add(tVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aKy.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("share_host");
            if (optJSONObject11 != null) {
                this.aLv = optJSONObject11.optString("url");
            } else {
                this.aLv = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject12 != null) {
                this.aLw = optJSONObject12.optString("reward_notice");
                this.aLy = optJSONObject12.optString("reward_rank_notice");
                this.aLx = optJSONObject12.optInt("reward_switch", 2);
            } else {
                this.aLw = "";
                this.aLy = "";
                this.aLx = 2;
            }
            com.baidu.live.d.xc().putString("share_host", this.aLv);
            com.baidu.live.d.xc().putString("ala_share_in_bar_notice_text", this.aLw);
            com.baidu.live.d.xc().putString("ala_share_reward_rank_notice_text", this.aLy);
            com.baidu.live.d.xc().putInt("ala_share_in_bar_notice_tip_switch", this.aLx);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject13 != null) {
                this.aKH = optJSONObject13.optInt("value");
            } else {
                this.aKH = 60;
            }
            com.baidu.live.d.xc().putInt("recommend_refresh", this.aKH);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject14 != null) {
                JSONArray optJSONArray5 = optJSONObject14.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.d.xc().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aKz = g(optJSONArray5);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject15 != null) {
                JSONArray optJSONArray6 = optJSONObject15.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.d.xc().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aKA = g(optJSONArray6);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject16 != null) {
                this.aKO = optJSONObject16.optString("time_interval");
                this.aKP = optJSONObject16.optInt("exception_interval");
            } else {
                this.aKO = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aKP = 1;
            }
            com.baidu.live.d.xc().putString("strategy_conf", this.aKO);
            com.baidu.live.d.xc().putInt("strategy_exception_interval", this.aKP);
            this.aKM = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.d.xc().putInt("liveStartAuthLevel", this.aKM);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject17 != null) {
                this.aKD = optJSONObject17.optInt("2gTo");
                if (this.aKD < 3) {
                    this.aKD = 3;
                }
                this.aKE = optJSONObject17.optInt("3gTo");
                if (this.aKE < 3) {
                    this.aKE = 3;
                }
                this.aKF = optJSONObject17.optInt("wifiTo");
                if (this.aKF < 3) {
                    this.aKF = 3;
                }
                com.baidu.live.d.xc().putInt("2gTo", this.aKD);
                com.baidu.live.d.xc().putInt("3gTo", this.aKE);
                com.baidu.live.d.xc().putInt("wifiTo", this.aKF);
            }
            this.aLC = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.d.xc().putInt("square_tab_strategy", this.aLC);
            JSONObject optJSONObject18 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject18 != null) {
                this.aLD = optJSONObject18.optString(BigdayActivityConfig.JUMP_URL);
                this.aLE = optJSONObject18.optString("flower_rank_rule");
            }
            com.baidu.live.d.xc().putString("ala_live_ranklist_url", this.aLD);
            com.baidu.live.d.xc().putString("new_flower_rank_list_description_url", this.aLE);
            JSONObject optJSONObject19 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject19 != null) {
                this.aLF = optJSONObject19.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.d.xc().putString("ala_game_player_signup_url", this.aLF);
            JSONObject optJSONObject20 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject20 != null) {
                this.aLG = optJSONObject20.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.xc().putString("ala_game_frs_live_tab_video_url", this.aLG);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject21 != null) {
                this.aLH = optJSONObject21.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.d.xc().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aLI.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject22 != null) {
                com.baidu.live.d.xc().putString("ala_live_session_replace_key", optJSONObject22.toString());
                this.aLL = optJSONObject22.optString("hlsUrl");
                this.aLJ = optJSONObject22.optString("rtmpUrl");
                this.aLK = optJSONObject22.optString("flvUrl");
                this.aLM = optJSONObject22.optString(".m3u8");
            }
            b(true, this.aLH);
            JSONObject optJSONObject23 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject23 != null) {
                this.aLN = optJSONObject23.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.xc().putString("ala_personal_income_detail_url", this.aLN);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject24 != null) {
                this.aMo = optJSONObject24.optInt("android_show");
                com.baidu.live.d.xc().putInt("ala_custom_gift_category_id", this.aMo);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("pub_show_conf");
            if (optJSONObject25 != null) {
                this.aNv = new cw();
                this.aNv.parserJson(optJSONObject25);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("pub_show_two_conf");
            if (optJSONObject26 != null) {
                this.aNw = new cx();
                this.aNw.parserJson(optJSONObject26);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject27 != null) {
                int optInt = optJSONObject27.optInt("open", 0);
                this.aLO = optInt == 1;
                com.baidu.live.d.xc().putInt("ala_live_pk_switch", optInt);
                this.aLP = optJSONObject27.optLong("interval");
                if (this.aLP < 1000) {
                    this.aLP = 1000L;
                }
                com.baidu.live.d.xc().putLong("ala_live_pk_check_interval", this.aLP);
                this.aLQ = optJSONObject27.optLong("match_timeout");
                if (this.aLQ < AppStatusRules.DEFAULT_GRANULARITY) {
                    this.aLQ = AppStatusRules.DEFAULT_GRANULARITY;
                }
                com.baidu.live.d.xc().putLong("ala_live_pk_match_timeout", this.aLQ);
                this.aLR = optJSONObject27.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.d.xc().putString("ala_live_pk_pic_url", this.aLR);
                this.aLS = optJSONObject27.optString("rank_link");
                com.baidu.live.d.xc().putString("ala_live_pk_pic_jump_url", this.aLS);
                this.aLT = optJSONObject27.optString("history_link");
                com.baidu.live.d.xc().putString("ala_live_pk_history_link", this.aLT);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject28 != null) {
                this.aLV = optJSONObject28.optLong("random_interval");
                if (this.aLV < 1000) {
                    this.aLV = 1000L;
                }
                com.baidu.live.d.xc().putLong("ala_challenge_random_interval", this.aLV);
                this.aLW = optJSONObject28.optLong("direct_interval");
                if (this.aLW < 1000) {
                    this.aLW = 1000L;
                }
                com.baidu.live.d.xc().putLong("ala_challenge_direct_interval", this.aLW);
                this.aLX = optJSONObject28.optLong("challenge_info_interval");
                if (this.aLX < 1000) {
                    this.aLX = 1000L;
                }
                com.baidu.live.d.xc().putLong("ala_get_challenge_info_interval", this.aLX);
                this.aLZ = optJSONObject28.optString("pk_icon_url");
                com.baidu.live.d.xc().putString("ala_challenge_pk_entry_icon_url", this.aLZ);
                this.aMa = optJSONObject28.optString("icon_url");
                com.baidu.live.d.xc().putString("ala_challenge_pk_entry_icon_url", this.aMa);
                this.aLY = optJSONObject28.optString("rule_url");
                com.baidu.live.d.xc().putString("ala_challenge_pk_entry_icon_url", this.aLY);
                this.aMb = optJSONObject28.optInt("punish_stage_button_switch");
                com.baidu.live.d.xc().putInt("punish_stage_button_switch", this.aMb);
                this.aMc = optJSONObject28.optInt("receive_challenge_im_show_time");
                com.baidu.live.d.xc().putInt("receive_challenge_im_show_time", this.aMc);
                this.aMd = optJSONObject28.optInt("mvpPunishSwitch");
                com.baidu.live.d.xc().putInt("mvpPunishSwitch", this.aMd);
                this.aMe = optJSONObject28.optInt("toastLifeTime");
                com.baidu.live.d.xc().putInt("toastLifeTime", this.aMe);
                this.aMf = optJSONObject28.optInt("punishLifeTime");
                com.baidu.live.d.xc().putInt("punishLifeTime", this.aMf);
                this.aMg = optJSONObject28.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject29 != null) {
                this.aLU = optJSONObject29.optString("go_url");
                com.baidu.live.d.xc().putString("show_live_forum_url", this.aLU);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject30 != null) {
                this.aMp = optJSONObject30.optInt("use_https", 0) == 1;
                com.baidu.live.d.xc().putBoolean("ala_guess_use_https", this.aMp);
            }
            String optString3 = jSONObject.optString("live_bar");
            fA(optString3);
            com.baidu.live.d.xc().putString("ala_live_bar_map_str", optString3);
            this.aMq = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.d.xc().putBoolean("is_new_live_close_strategy", this.aMq);
            this.aMr = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.d.xc().putBoolean("is_new_gift_t_dou_strategy", this.aMr);
            this.aMs = jSONObject.optString("feedback_url");
            com.baidu.live.d.xc().putString("ala_feedback_url", this.aMs);
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject31 != null && (optJSONObject = optJSONObject31.optJSONObject("challenge_related_zip")) != null) {
                this.aMm = optJSONObject.optString("zip_md5");
                this.aMn = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject32 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject32.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject32.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.d.xc().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.d.xc().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("open_live");
            if (optJSONObject33 != null) {
                this.increaseThreshold = optJSONObject33.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.d.xc().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject33.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.d.xc().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject33.optInt("thi_count", 3);
                com.baidu.live.d.xc().putInt("ala_video_increase_count", this.increaseCount);
                this.aKT = optJSONObject33.optInt("encoder", 1) == 1;
                com.baidu.live.d.xc().putBoolean("ala_live_hard_encode_switch", this.aKT);
                this.aKS = optJSONObject33.optInt("video_gop", 2);
                com.baidu.live.d.xc().putInt("ala_video_encoder_gop", this.aKS);
                this.aKU = optJSONObject33.optInt("dynamic", 1) == 1;
                com.baidu.live.d.xc().putBoolean("ala_dynamic_bitrate_switch", this.aKU);
                this.aKR = optJSONObject33.optInt("resolution", 3);
                com.baidu.live.d.xc().putInt("ala_video_resolution_level", this.aKR);
                JSONArray optJSONArray8 = optJSONObject33.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aKV = optJSONArray8.toString();
                    com.baidu.live.d.xc().putString("ala_video_soft_bitrate_config", this.aKV);
                }
                JSONArray optJSONArray9 = optJSONObject33.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aKW = optJSONArray9.toString();
                    com.baidu.live.d.xc().putString("ala_video_hard_bitrate_config", this.aKW);
                }
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject34 != null) {
                this.aKX = optJSONObject34.toString();
                com.baidu.live.d.xc().putString("ala_avts_stream_server_domain_config", this.aKX);
            }
            JSONObject optJSONObject35 = jSONObject.optJSONObject("encoder_auto_reset");
            if (optJSONObject35 != null) {
                this.aLc = optJSONObject35.toString();
                com.baidu.live.d.xc().putString("ala_video_encoder_reset_config", this.aLc);
            }
            JSONObject optJSONObject36 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject36 != null) {
                this.aLa = optJSONObject36.optInt("host_rtc_resolution", 3);
                com.baidu.live.d.xc().putInt("ala_master_chat_video_resolution_level", this.aLa);
                this.aLb = optJSONObject36.optInt("rtc_resolution", 4);
                com.baidu.live.d.xc().putInt("ala_slave_chat_video_resolution_level", this.aLb);
                JSONArray optJSONArray10 = optJSONObject36.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aKY = optJSONArray10.toString();
                    com.baidu.live.d.xc().putString("ala_master_chat_video_bitrate_config", this.aKY);
                }
                JSONArray optJSONArray11 = optJSONObject36.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aKZ = optJSONArray11.toString();
                    com.baidu.live.d.xc().putString("ala_slave_chat_video_bitrate_config", this.aKZ);
                }
            }
            JSONObject optJSONObject37 = jSONObject.optJSONObject("challenge_resolution");
            if (optJSONObject37 != null) {
                this.aLe = optJSONObject37.optInt("video_width");
                this.aLf = optJSONObject37.optInt("video_height");
                if (this.aLe > 0 && this.aLf > 0) {
                    com.baidu.live.d.xc().putString("challenge_recorder_resolution", this.aLe + "*" + this.aLf);
                }
                this.aLg = optJSONObject37.optInt("video_gop", 1);
                com.baidu.live.d.xc().putInt("challenge_recorder_gop", this.aLg);
                JSONArray optJSONArray12 = optJSONObject37.optJSONArray(KsMediaMeta.KSM_KEY_BITRATE);
                if (optJSONArray12 != null) {
                    this.aLh = optJSONArray12.toString();
                    com.baidu.live.d.xc().putString("challenge_recorder_bitrate_conf", this.aLh);
                }
            }
            JSONObject optJSONObject38 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject38 != null) {
                this.aNg = optJSONObject38.optInt("enter_live_msg_audience_num_p1");
                this.aNh = optJSONObject38.optInt("enter_live_msg_audience_num_p2");
                this.aNi = optJSONObject38.optInt("enter_live_msg_audience_num_p3");
                this.aNe = optJSONObject38.optInt("im_intercept_switch");
                this.aNf = optJSONObject38.optInt("is_check_im_content");
            }
            JSONObject optJSONObject39 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject39 != null) {
                this.aNb = new AlaFeedDiversionData();
                this.aNb.parserJson(optJSONObject39);
                com.baidu.live.d.xc().putString("feed_diversion", optJSONObject39.toString());
            }
            JSONObject optJSONObject40 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject40 != null) {
                com.baidu.live.d.xc().putString("key_stat_switch", optJSONObject40.toString());
            }
            JSONObject optJSONObject41 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject41 != null) {
                this.aNj = optJSONObject41.optInt("unfold_interval", 5000);
                this.aNk = optJSONObject41.optInt("fold_interval", 55000);
            }
            JSONObject optJSONObject42 = jSONObject.optJSONObject("modify_default_name_conf");
            if (optJSONObject42 != null) {
                this.aNs = new bx();
                this.aNs.parserJson(optJSONObject42);
            }
            JSONObject optJSONObject43 = jSONObject.optJSONObject("audio_live_conf");
            if (optJSONObject43 != null) {
                this.aNt = new cl();
                this.aNt.parse(optJSONObject43);
            }
            JSONObject optJSONObject44 = jSONObject.optJSONObject("quit_live_rec_conf");
            this.aNu = new al();
            this.aNu.parse(optJSONObject44);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void C(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aMQ = jSONObject.optInt("im_max", 200);
            if (this.aMQ <= 0) {
                this.aMQ = 200;
            }
            this.aMR = jSONObject.optInt("barrage_max", 100);
            if (this.aMR <= 0) {
                this.aMR = 100;
            }
            this.aMS = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aMS <= 0) {
                this.aMS = 10;
            }
            this.aMT = jSONObject.optInt("enter_effect_max", 10);
            if (this.aMT <= 0) {
                this.aMT = 10;
            }
            this.aMU = jSONObject.optInt("gift_big_max", 10);
            if (this.aMU <= 0) {
                this.aMU = 10;
            }
            this.aMV = jSONObject.optInt("audio_gift_big_max", 15);
            if (this.aMV <= 0) {
                this.aMV = 15;
            }
            this.aMW = jSONObject.optInt("gift_small_max", 50);
            if (this.aMW <= 0) {
                this.aMW = 50;
            }
            this.aMX = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aMX <= 0) {
                this.aMX = 5;
            }
        }
    }

    private void Cg() {
        this.aMy = com.baidu.live.d.xc().getInt("guide_speak_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        this.aMz = com.baidu.live.d.xc().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.d.xc().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aMA = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aMA[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void D(JSONObject jSONObject) {
        int length;
        this.aMy = jSONObject.optInt("rule_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL) * 1000;
        com.baidu.live.d.xc().putInt("guide_speak_watch_time", this.aMy);
        this.aMz = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.d.xc().putInt("guide_speak_show_times_max", this.aMz);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aMA = new String[length];
            for (int i = 0; i < length; i++) {
                this.aMA[i] = optJSONArray.optString(i);
            }
            com.baidu.live.d.xc().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void Ch() {
        String string = com.baidu.live.d.xc().getString("yuan_package_data", "");
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
            this.aML = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aML.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void fz(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aMN = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aMN.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aMO = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aMO.add(str3);
                            }
                        }
                    }
                    com.baidu.live.d.xc().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void Ci() {
        fz(com.baidu.live.d.xc().getString("ala_quick_send_im_list", null));
    }

    private void fA(String str) {
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
        if (i != this.aLH) {
            z2 = true;
        }
        this.aLH = i;
        if (z || z2) {
            com.baidu.live.d.xc().putInt("ala_live_session_default_key", i);
        }
    }

    private void Cj() {
        this.aLH = com.baidu.live.d.xc().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.d.xc().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aLI.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.d.xc().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aLL = jSONObject.optString("hlsUrl");
                this.aLJ = jSONObject.optString("rtmpUrl");
                this.aLK = jSONObject.optString("flvUrl");
                this.aLM = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean Ck() {
        return this.aLA == 1;
    }
}
