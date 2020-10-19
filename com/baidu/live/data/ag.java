package com.baidu.live.data;

import android.text.TextUtils;
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
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.webkit.internal.ABTestConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ag extends BaseData {
    public String aJA;
    public int aJB;
    public boolean aJC;
    public boolean aJD;
    public boolean aJE;
    public boolean aJF;
    public boolean aJH;
    public String aJI;
    public int aJJ;
    public boolean aJK;
    public int aJL;
    public boolean aJM;
    public boolean aJN;
    public String aJO;
    public String aJP;
    public String aJQ;
    public String aJR;
    public String aJS;
    public int aJT;
    public int aJU;
    public boolean aJV;
    public boolean aJW;
    public boolean aJX;
    public boolean aJY;
    public boolean aJZ;
    public boolean aJd;
    public boolean aJe;
    public boolean aJf;
    public boolean aJg;
    public boolean aJh;
    public String aJi;
    public String aJj;
    public String aJn;
    public String aJo;
    public String aJp;
    public String aJq;
    public Integer[] aJt;
    public Integer[] aJu;
    public int aJv;
    public int aJx;
    public int aJy;
    public int aJz;
    public String aKA;
    public boolean aKB;
    public long aKC;
    public long aKD;
    public String aKE;
    public String aKF;
    public String aKG;
    public String aKH;
    public long aKI;
    public long aKJ;
    public long aKK;
    public String aKL;
    public String aKM;
    public String aKN;
    public int aKO;
    public int aKP;
    public int aKQ;
    public String aKV;
    public String aKW;
    public String aKX;
    public String aKY;
    public int aKZ;
    public boolean aKa;
    public boolean aKb;
    public String aKf;
    public String aKh;
    public String aKi;
    public int aKo;
    public String aKq;
    public String aKr;
    private String aKs;
    private String aKt;
    public int aKu;
    public String aKw;
    public String aKx;
    public String aKy;
    public String aKz;
    public ap aLD;
    public boolean aLE;
    public String aLF;
    public AlaFeedDiversionData aLG;
    public o aLH;
    public boolean aLI;
    public int aLJ;
    public int aLK;
    public ah aLQ;
    public bo aLS;
    public bl aLT;
    public bt aLU;
    public String aLd;
    public int aLi;
    public int aLj;
    public String[] aLk;
    public int aLl;
    public String aLm;
    public String aLn;
    public QuickImInputData aLo;
    public QuickImInputData aLp;
    public List<YuanPackageData> aLq;
    public bb aLr;
    public List<String> aLs;
    public List<String> aLt;
    public List<String> aLu;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aJb = -1;
    public String aJc = null;
    public int aJG = 1;
    public boolean aKc = true;
    public boolean aKd = false;
    public boolean aKe = false;
    public boolean aKg = false;
    public String aKj = "";
    private int aKk = 2;
    public String aKl = "";
    public int aKm = 1;
    public int aKn = 0;
    public int aKp = 1;
    public List<String> aKv = new ArrayList();
    public int aKR = 10;
    public int aKS = 60;
    public long aKT = 10000;
    public boolean aKU = false;
    public boolean aLa = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aLb = false;
    public boolean aLc = false;
    public boolean aLe = false;
    public boolean aLf = false;
    public boolean aLg = false;
    public boolean aLh = false;
    public int aLv = 200;
    public int aLw = 100;
    public int aLx = 10;
    public int aLy = 10;
    public int aLz = 10;
    public int aLA = 15;
    public int aLB = 50;
    public int aLC = 5;
    public int aLL = 20;
    public int aLM = 70;
    public int aLN = 10000;
    public int aLO = 5000;
    public int aLP = 55000;
    public int aLR = 7;
    public cf aLV = cf.aQx;
    public List<String> aJm = new ArrayList();
    public List<String> aJw = new ArrayList();
    public List<String> aJr = new ArrayList();
    public List<Integer> aJs = new ArrayList();
    public ArrayList<l> aJk = new ArrayList<>();
    public ArrayList<l> aJl = new ArrayList<>();

    public ag(boolean z) {
        if (z) {
            DP();
            this.aJv = com.baidu.live.c.AZ().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.AZ().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.AZ().getInt("restart_time_interval", 300);
            DQ();
            DO();
            DR();
            DS();
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
                    x(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject3 != null) {
                    this.aJv = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.AZ().putInt("conn_conf", this.aJv);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aJw.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.c.AZ().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.c.AZ().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    y(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    z(optJSONObject5);
                }
                this.aKh = jSONObject.optString("client_id");
                com.baidu.live.c.AZ().putString("client_id", this.aKh);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aJi = optJSONObject6.optString("pic_url");
                    this.aJj = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            l lVar = new l();
                            lVar.parseJson(optJSONObject8);
                            this.aJk.add(lVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.AZ().putString("pic_url", this.aJi);
                com.baidu.live.c.AZ().putString(BigdayActivityConfig.JUMP_URL, this.aJj);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    A(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aLl = optJSONObject10.optInt("resource_switch");
                    this.aLn = optJSONObject10.optString("photo_url");
                    this.aLm = optJSONObject10.optString("resource_url");
                }
                this.aLo = new QuickImInputData();
                this.aLo.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aLp = new QuickImInputData();
                this.aLp.parseJson(jSONObject.getJSONArray("fast_reply_word_audio"));
                this.aLr = bb.B(jSONObject.optJSONObject("guide_follow"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.AZ().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject11 != null) {
                    JSONObject optJSONObject12 = optJSONObject11.optJSONObject("rank");
                    if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.c.AZ().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.c.AZ().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.c.AZ().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject13 = optJSONObject11.optJSONObject("guard_seat");
                    if (optJSONObject13 != null) {
                        this.aLF = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aLD = new ap();
                    this.aLD.aMI = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.c.AZ().putString("ala_certify_refuse_url", this.aLD.aMI);
                }
                this.aLQ = new ah();
                this.aLQ.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aLH = new o();
                    this.aLH.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aLR = optJSONObject16.optInt("show_days");
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.AZ().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void DO() {
        String string = com.baidu.live.c.AZ().getString("ala_prepare_random_title_list", "");
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
            this.aLu = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aLu.add(jSONArray.optString(i));
            }
        }
    }

    private void DP() {
        this.aJd = com.baidu.live.c.AZ().getBoolean("map_around_map", false);
        this.aJK = com.baidu.live.c.AZ().getBoolean("withdraw_switch", true);
        this.aKf = com.baidu.live.c.AZ().getString("withdraw_text", "");
        this.aJY = com.baidu.live.c.AZ().getBoolean("use_internal_player_switch", true);
        this.aJV = com.baidu.live.c.AZ().getBoolean("use_http_dns_switch", true);
        this.aJW = com.baidu.live.c.AZ().getBoolean("use_encode_bframe_switch", false);
        this.aJX = com.baidu.live.c.AZ().getBoolean("enable_opt_timestamp_switch", true);
        this.aJZ = com.baidu.live.c.AZ().getBoolean("live_beauty_open_switch", false);
        this.aKa = com.baidu.live.c.AZ().getBoolean("live_unity_beauty_switch", true);
        this.aKb = com.baidu.live.c.AZ().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aKc = com.baidu.live.c.AZ().getBoolean("sp_key_live_game_hard_encode", true);
        this.aKd = com.baidu.live.c.AZ().getBoolean("sp_key_live_play_transcode_support", false);
        this.aKe = com.baidu.live.c.AZ().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aKg = com.baidu.live.c.AZ().getBoolean("ala_enable_graffiti_str", false);
        this.aJe = com.baidu.live.c.AZ().getBoolean("enter_live", false);
        this.aJf = com.baidu.live.c.AZ().getBoolean("sync_to_forum", true);
        this.aJg = com.baidu.live.c.AZ().getBoolean("show_water_mark", false);
        this.aJh = com.baidu.live.c.AZ().getBoolean("show_third_part_water_mark_switch", false);
        this.aJC = com.baidu.live.c.AZ().getBoolean("stream_error_log", true);
        this.aJD = com.baidu.live.c.AZ().getBoolean("disable_channel_in", true);
        this.aJE = com.baidu.live.c.AZ().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aJF = com.baidu.live.c.AZ().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aJH = com.baidu.live.c.AZ().getBoolean("follow_default_push_switch", true);
        this.aKo = com.baidu.live.c.AZ().getInt("to_tb_some_switch", 0);
        this.aKm = com.baidu.live.c.AZ().getInt("enable_live_stat", 1);
        this.aKn = com.baidu.live.c.AZ().getInt("ala_free_gift_task_switch", 0);
        this.aKU = com.baidu.live.c.AZ().getBoolean("live_challenge_switch", false);
        this.aKV = com.baidu.live.c.AZ().getString("live_challenge_tip", null);
        this.aKW = com.baidu.live.c.AZ().getString("live_challenge_url", null);
    }

    private void x(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aJd = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.AZ().putBoolean("map_around_map", this.aJd);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aJK = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("withdraw_switch", this.aJK);
                this.aKf = optJSONObject2.optString("text");
                com.baidu.live.c.AZ().putString("withdraw_text", this.aKf);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aJY = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("use_internal_player_switch", this.aJY);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aJV = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("use_http_dns_switch", this.aJV);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aJW = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("use_encode_bframe_switch", this.aJW);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aJX = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("enable_opt_timestamp_switch", this.aJX);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.aJZ = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("live_beauty_open_switch", this.aJZ);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.aKa = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("live_unity_beauty_switch", this.aKa);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.aKb = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("live_unity_beauty_face_style_switch", this.aKb);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.aKc = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("sp_key_live_game_hard_encode", this.aKc);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.aKd = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("sp_key_live_play_transcode_support", this.aKd);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.aKe = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("sp_key_live_play_attention_guide_support", this.aKe);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.aJe = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("enter_live", this.aJe);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.aJf = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.c.AZ().putBoolean("sync_to_forum", this.aJf);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.aJg = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.c.AZ().putBoolean("show_water_mark", this.aJg);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.aJh = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.AZ().putBoolean("show_third_part_water_mark_switch", this.aJh);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.aKm = optJSONObject17.optInt("switch");
                com.baidu.live.c.AZ().putInt("enable_live_stat", this.aKm);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.aJC = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("stream_error_log", this.aJC);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.aJD = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.c.AZ().putBoolean("disable_channel_in", this.aJD);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.aJE = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.c.AZ().putBoolean("shoubai_yanzhi_tab_tip", this.aJE);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.aJF = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.c.AZ().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aJF);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.aJH = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.c.AZ().putBoolean("follow_default_push_switch", this.aJH);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.aKo = optJSONObject23.optInt("switch");
                com.baidu.live.c.AZ().putInt("to_tb_some_switch", this.aKo);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.aKn = optJSONObject24.optInt("switch");
                com.baidu.live.c.AZ().putInt("ala_free_gift_task_switch", this.aKo);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.aKg = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("ala_enable_graffiti_str", this.aKg);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aKU = optJSONObject26.optInt("switch") == 1;
                this.aKV = optJSONObject26.optString("title");
                this.aKW = optJSONObject26.optString("url");
                com.baidu.live.c.AZ().putBoolean("live_challenge_switch", this.aKU);
                com.baidu.live.c.AZ().putString("live_challenge_tip", this.aKV);
                com.baidu.live.c.AZ().putString("live_challenge_url", this.aKW);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aLc = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("is_new_gift_t_dou_strategy", this.aLc);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aLg = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aLe = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("key_is_open_login_prove", this.aLe);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aLf = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("key_is_open_diamond", this.aLf);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aLh = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.c.AZ().putBoolean("key_is_jump_to_live_room", this.aLh);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aLE = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aLI = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void DQ() {
        JSONArray jSONArray;
        this.aJA = com.baidu.live.c.AZ().getString("bluediamond_url", "");
        this.aJo = com.baidu.live.c.AZ().getString("verify_content", this.aJo);
        this.aJn = com.baidu.live.c.AZ().getString("live_notice", "");
        this.aJp = com.baidu.live.c.AZ().getString("activity_notice", "");
        String string = com.baidu.live.c.AZ().getString("imNotice", "");
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
                        this.aJm.add(i, optString);
                    }
                }
            }
        }
        this.aKi = com.baidu.live.c.AZ().getString("share_host", "");
        this.aKj = com.baidu.live.c.AZ().getString("ala_share_in_bar_notice_text", "");
        this.aKl = com.baidu.live.c.AZ().getString("ala_share_reward_rank_notice_text", "");
        this.aKk = com.baidu.live.c.AZ().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aJB = com.baidu.live.c.AZ().getInt("recommend_refresh", 60);
        this.aJI = com.baidu.live.c.AZ().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aJJ = com.baidu.live.c.AZ().getInt("strategy_exception_interval", 1);
        this.aJG = com.baidu.live.c.AZ().getInt("liveStartAuthLevel", 1);
        this.aJx = com.baidu.live.c.AZ().getInt("2gTo", 5);
        this.aJy = com.baidu.live.c.AZ().getInt("3gTo", 3);
        this.aJz = com.baidu.live.c.AZ().getInt("wifiTo", 3);
        String string2 = com.baidu.live.c.AZ().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aJt = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.c.AZ().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aJu = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aKp = com.baidu.live.c.AZ().getInt("square_tab_strategy", 1);
        this.aKq = com.baidu.live.c.AZ().getString("ala_live_ranklist_url", null);
        this.aKr = com.baidu.live.c.AZ().getString("new_flower_rank_list_description_url", "");
        this.aKs = com.baidu.live.c.AZ().getString("ala_game_player_signup_url", null);
        this.aKt = com.baidu.live.c.AZ().getString("ala_game_frs_live_tab_video_url", null);
        DU();
        this.aKA = com.baidu.live.c.AZ().getString("ala_personal_income_detail_url", null);
        this.aKZ = com.baidu.live.c.AZ().getInt("ala_custom_gift_category_id", -1);
        this.aKB = com.baidu.live.c.AZ().getInt("ala_live_pk_switch", 0) == 1;
        this.aKC = com.baidu.live.c.AZ().getLong("ala_live_pk_check_interval", 1000L);
        this.aKD = com.baidu.live.c.AZ().getLong("ala_live_pk_match_timeout", 60000L);
        this.aKE = com.baidu.live.c.AZ().getString("ala_live_pk_pic_url", "");
        this.aKF = com.baidu.live.c.AZ().getString("ala_live_pk_pic_jump_url", "");
        this.aKG = com.baidu.live.c.AZ().getString("ala_live_pk_history_link", "");
        this.aKH = com.baidu.live.c.AZ().getString("show_live_forum_url", "");
        this.aKI = com.baidu.live.c.AZ().getLong("ala_challenge_random_interval", 1000L);
        this.aKJ = com.baidu.live.c.AZ().getLong("ala_challenge_direct_interval", 1000L);
        this.aKK = com.baidu.live.c.AZ().getLong("ala_get_challenge_info_interval", 1000L);
        this.aKM = com.baidu.live.c.AZ().getString("ala_challenge_pk_entry_icon_url", "");
        this.aKN = com.baidu.live.c.AZ().getString("ala_challenge_pk_entry_icon_url", "");
        this.aKL = com.baidu.live.c.AZ().getString("ala_challenge_pk_entry_icon_url", "");
        this.aKO = com.baidu.live.c.AZ().getInt("punish_stage_button_switch", 0);
        this.aKP = com.baidu.live.c.AZ().getInt("receive_challenge_im_show_time", 0);
        this.aKQ = com.baidu.live.c.AZ().getInt("mvpPunishSwitch", 0);
        this.aKR = com.baidu.live.c.AZ().getInt("toastLifeTime", 10);
        this.aKS = com.baidu.live.c.AZ().getInt("punishLifeTime", 60);
        this.aLa = com.baidu.live.c.AZ().getBoolean("ala_guess_use_https", false);
        gm(com.baidu.live.c.AZ().getString("ala_live_bar_map_str", ""));
        this.aLb = com.baidu.live.c.AZ().getBoolean("is_new_live_close_strategy", false);
        this.aLc = com.baidu.live.c.AZ().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aLd = com.baidu.live.c.AZ().getString("ala_feedback_url", null);
        this.aJL = com.baidu.live.c.AZ().getInt("ala_video_resolution_level", 3);
        this.aJM = com.baidu.live.c.AZ().getBoolean("ala_live_hard_encode_switch", true);
        this.aJN = com.baidu.live.c.AZ().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.AZ().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.AZ().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.AZ().getInt("ala_video_increase_count", 3);
        this.aJO = com.baidu.live.c.AZ().getString("ala_video_soft_bitrate_config", null);
        this.aJP = com.baidu.live.c.AZ().getString("ala_video_hard_bitrate_config", null);
        this.aJT = com.baidu.live.c.AZ().getInt("ala_master_chat_video_resolution_level", 3);
        this.aJU = com.baidu.live.c.AZ().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aJQ = com.baidu.live.c.AZ().getString("ala_avts_stream_server_domain_config", null);
        this.aJR = com.baidu.live.c.AZ().getString("ala_master_chat_video_bitrate_config", null);
        this.aJS = com.baidu.live.c.AZ().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.AZ().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.AZ().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aLe = com.baidu.live.c.AZ().getBoolean("key_is_open_login_prove", false);
        this.aLf = com.baidu.live.c.AZ().getBoolean("key_is_open_diamond", false);
        this.aLh = com.baidu.live.c.AZ().getBoolean("key_is_jump_to_live_room", false);
        gk(com.baidu.live.c.AZ().getString("feed_diversion", ""));
        DT();
    }

    private void gk(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aLG = new AlaFeedDiversionData();
                this.aLG.parserJson(jSONObject);
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
            numArr[i] = Integer.valueOf(jSONArray.optJSONObject(i).optInt("bitrate"));
        }
        return numArr;
    }

    private void y(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("pksolo");
            if (optJSONObject2 != null) {
                this.aJq = optJSONObject2.toString();
                this.aLS = new bo();
                this.aLS.parse(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject3 != null) {
                this.aJc = optJSONObject3.optString("toast");
                this.aJb = optJSONObject3.optInt("remind_type");
            }
            this.aJA = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.AZ().putString("bluediamond_url", this.aJA);
            this.aJo = jSONObject.optString("verify_content");
            com.baidu.live.c.AZ().putString("verify_content", this.aJo);
            this.aJn = jSONObject.optString("live_notice");
            com.baidu.live.c.AZ().putString("live_notice", this.aJn);
            this.aJp = jSONObject.optString("activityNotice");
            com.baidu.live.c.AZ().putString("activity_notice", this.aJp);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aJm.add(i, optString);
                    }
                }
                com.baidu.live.c.AZ().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.c.AZ().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.aJr.add(i2, optString2);
                    }
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("bd_live_activity");
            if (optJSONObject4 != null && (optJSONArray = optJSONObject4.optJSONArray("main_page")) != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject5 != null) {
                        l lVar = new l();
                        lVar.parseJson(optJSONObject5);
                        this.aJl.add(lVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aJs.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_host");
            if (optJSONObject6 != null) {
                this.aKi = optJSONObject6.optString("url");
            } else {
                this.aKi = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject7 != null) {
                this.aKj = optJSONObject7.optString("reward_notice");
                this.aKl = optJSONObject7.optString("reward_rank_notice");
                this.aKk = optJSONObject7.optInt("reward_switch", 2);
            } else {
                this.aKj = "";
                this.aKl = "";
                this.aKk = 2;
            }
            com.baidu.live.c.AZ().putString("share_host", this.aKi);
            com.baidu.live.c.AZ().putString("ala_share_in_bar_notice_text", this.aKj);
            com.baidu.live.c.AZ().putString("ala_share_reward_rank_notice_text", this.aKl);
            com.baidu.live.c.AZ().putInt("ala_share_in_bar_notice_tip_switch", this.aKk);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject8 != null) {
                this.aJB = optJSONObject8.optInt("value");
            } else {
                this.aJB = 60;
            }
            com.baidu.live.c.AZ().putInt("recommend_refresh", this.aJB);
            JSONObject optJSONObject9 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject9 != null) {
                JSONArray optJSONArray5 = optJSONObject9.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.AZ().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aJt = g(optJSONArray5);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject10 != null) {
                JSONArray optJSONArray6 = optJSONObject10.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.AZ().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aJu = g(optJSONArray6);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject11 != null) {
                this.aJI = optJSONObject11.optString("time_interval");
                this.aJJ = optJSONObject11.optInt("exception_interval");
            } else {
                this.aJI = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aJJ = 1;
            }
            com.baidu.live.c.AZ().putString("strategy_conf", this.aJI);
            com.baidu.live.c.AZ().putInt("strategy_exception_interval", this.aJJ);
            this.aJG = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.AZ().putInt("liveStartAuthLevel", this.aJG);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject12 != null) {
                this.aJx = optJSONObject12.optInt("2gTo");
                if (this.aJx < 3) {
                    this.aJx = 3;
                }
                this.aJy = optJSONObject12.optInt("3gTo");
                if (this.aJy < 3) {
                    this.aJy = 3;
                }
                this.aJz = optJSONObject12.optInt("wifiTo");
                if (this.aJz < 3) {
                    this.aJz = 3;
                }
                com.baidu.live.c.AZ().putInt("2gTo", this.aJx);
                com.baidu.live.c.AZ().putInt("3gTo", this.aJy);
                com.baidu.live.c.AZ().putInt("wifiTo", this.aJz);
            }
            this.aKp = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.AZ().putInt("square_tab_strategy", this.aKp);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject13 != null) {
                this.aKq = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
                this.aKr = optJSONObject13.optString("flower_rank_rule");
            }
            com.baidu.live.c.AZ().putString("ala_live_ranklist_url", this.aKq);
            com.baidu.live.c.AZ().putString("new_flower_rank_list_description_url", this.aKr);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject14 != null) {
                this.aKs = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.AZ().putString("ala_game_player_signup_url", this.aKs);
            JSONObject optJSONObject15 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject15 != null) {
                this.aKt = optJSONObject15.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.AZ().putString("ala_game_frs_live_tab_video_url", this.aKt);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject16 != null) {
                this.aKu = optJSONObject16.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.AZ().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aKv.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject17 != null) {
                com.baidu.live.c.AZ().putString("ala_live_session_replace_key", optJSONObject17.toString());
                this.aKy = optJSONObject17.optString("hlsUrl");
                this.aKw = optJSONObject17.optString("rtmpUrl");
                this.aKx = optJSONObject17.optString("flvUrl");
                this.aKz = optJSONObject17.optString(".m3u8");
            }
            b(true, this.aKu);
            JSONObject optJSONObject18 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject18 != null) {
                this.aKA = optJSONObject18.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.AZ().putString("ala_personal_income_detail_url", this.aKA);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject19 != null) {
                this.aKZ = optJSONObject19.optInt("android_show");
                com.baidu.live.c.AZ().putInt("ala_custom_gift_category_id", this.aKZ);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("pub_show_conf");
            if (optJSONObject20 != null) {
                this.aLV = new cf();
                this.aLV.parserJson(optJSONObject20);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject21 != null) {
                int optInt = optJSONObject21.optInt("open", 0);
                this.aKB = optInt == 1;
                com.baidu.live.c.AZ().putInt("ala_live_pk_switch", optInt);
                this.aKC = optJSONObject21.optLong("interval");
                if (this.aKC < 1000) {
                    this.aKC = 1000L;
                }
                com.baidu.live.c.AZ().putLong("ala_live_pk_check_interval", this.aKC);
                this.aKD = optJSONObject21.optLong("match_timeout");
                if (this.aKD < 60000) {
                    this.aKD = 60000L;
                }
                com.baidu.live.c.AZ().putLong("ala_live_pk_match_timeout", this.aKD);
                this.aKE = optJSONObject21.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.AZ().putString("ala_live_pk_pic_url", this.aKE);
                this.aKF = optJSONObject21.optString("rank_link");
                com.baidu.live.c.AZ().putString("ala_live_pk_pic_jump_url", this.aKF);
                this.aKG = optJSONObject21.optString("history_link");
                com.baidu.live.c.AZ().putString("ala_live_pk_history_link", this.aKG);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject22 != null) {
                this.aKI = optJSONObject22.optLong("random_interval");
                if (this.aKI < 1000) {
                    this.aKI = 1000L;
                }
                com.baidu.live.c.AZ().putLong("ala_challenge_random_interval", this.aKI);
                this.aKJ = optJSONObject22.optLong("direct_interval");
                if (this.aKJ < 1000) {
                    this.aKJ = 1000L;
                }
                com.baidu.live.c.AZ().putLong("ala_challenge_direct_interval", this.aKJ);
                this.aKK = optJSONObject22.optLong("challenge_info_interval");
                if (this.aKK < 1000) {
                    this.aKK = 1000L;
                }
                com.baidu.live.c.AZ().putLong("ala_get_challenge_info_interval", this.aKK);
                this.aKM = optJSONObject22.optString("pk_icon_url");
                com.baidu.live.c.AZ().putString("ala_challenge_pk_entry_icon_url", this.aKM);
                this.aKN = optJSONObject22.optString("icon_url");
                com.baidu.live.c.AZ().putString("ala_challenge_pk_entry_icon_url", this.aKN);
                this.aKL = optJSONObject22.optString("rule_url");
                com.baidu.live.c.AZ().putString("ala_challenge_pk_entry_icon_url", this.aKL);
                this.aKO = optJSONObject22.optInt("punish_stage_button_switch");
                com.baidu.live.c.AZ().putInt("punish_stage_button_switch", this.aKO);
                this.aKP = optJSONObject22.optInt("receive_challenge_im_show_time");
                com.baidu.live.c.AZ().putInt("receive_challenge_im_show_time", this.aKP);
                this.aKQ = optJSONObject22.optInt("mvpPunishSwitch");
                com.baidu.live.c.AZ().putInt("mvpPunishSwitch", this.aKQ);
                this.aKR = optJSONObject22.optInt("toastLifeTime");
                com.baidu.live.c.AZ().putInt("toastLifeTime", this.aKR);
                this.aKS = optJSONObject22.optInt("punishLifeTime");
                com.baidu.live.c.AZ().putInt("punishLifeTime", this.aKS);
                this.aKT = optJSONObject22.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject23 != null) {
                this.aKH = optJSONObject23.optString("go_url");
                com.baidu.live.c.AZ().putString("show_live_forum_url", this.aKH);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject24 != null) {
                this.aLa = optJSONObject24.optInt("use_https", 0) == 1;
                com.baidu.live.c.AZ().putBoolean("ala_guess_use_https", this.aLa);
            }
            String optString3 = jSONObject.optString("live_bar");
            gm(optString3);
            com.baidu.live.c.AZ().putString("ala_live_bar_map_str", optString3);
            this.aLb = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.AZ().putBoolean("is_new_live_close_strategy", this.aLb);
            this.aLc = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.AZ().putBoolean("is_new_gift_t_dou_strategy", this.aLc);
            this.aLd = jSONObject.optString("feedback_url");
            com.baidu.live.c.AZ().putString("ala_feedback_url", this.aLd);
            JSONObject optJSONObject25 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject25 != null && (optJSONObject = optJSONObject25.optJSONObject("challenge_related_zip")) != null) {
                this.aKX = optJSONObject.optString("zip_md5");
                this.aKY = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject26 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject26.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject26.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.AZ().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.AZ().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("open_live");
            if (optJSONObject27 != null) {
                this.increaseThreshold = optJSONObject27.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.AZ().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject27.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.AZ().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject27.optInt("thi_count", 3);
                com.baidu.live.c.AZ().putInt("ala_video_increase_count", this.increaseCount);
                this.aJM = optJSONObject27.optInt("encoder", 1) == 1;
                com.baidu.live.c.AZ().putBoolean("ala_live_hard_encode_switch", this.aJM);
                this.aJN = optJSONObject27.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.AZ().putBoolean("ala_dynamic_bitrate_switch", this.aJN);
                this.aJL = optJSONObject27.optInt("resolution", 3);
                com.baidu.live.c.AZ().putInt("ala_video_resolution_level", this.aJL);
                JSONArray optJSONArray8 = optJSONObject27.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aJO = optJSONArray8.toString();
                    com.baidu.live.c.AZ().putString("ala_video_soft_bitrate_config", this.aJO);
                }
                JSONArray optJSONArray9 = optJSONObject27.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aJP = optJSONArray9.toString();
                    com.baidu.live.c.AZ().putString("ala_video_hard_bitrate_config", this.aJP);
                }
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject28 != null) {
                this.aJQ = optJSONObject28.toString();
                com.baidu.live.c.AZ().putString("ala_avts_stream_server_domain_config", this.aJQ);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject29 != null) {
                this.aJT = optJSONObject29.optInt("host_rtc_resolution", 3);
                com.baidu.live.c.AZ().putInt("ala_master_chat_video_resolution_level", this.aJT);
                this.aJU = optJSONObject29.optInt("rtc_resolution", 4);
                com.baidu.live.c.AZ().putInt("ala_slave_chat_video_resolution_level", this.aJU);
                JSONArray optJSONArray10 = optJSONObject29.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aJR = optJSONArray10.toString();
                    com.baidu.live.c.AZ().putString("ala_master_chat_video_bitrate_config", this.aJR);
                }
                JSONArray optJSONArray11 = optJSONObject29.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aJS = optJSONArray11.toString();
                    com.baidu.live.c.AZ().putString("ala_slave_chat_video_bitrate_config", this.aJS);
                }
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject30 != null) {
                this.aLL = optJSONObject30.optInt("enter_live_msg_audience_num_p1");
                this.aLM = optJSONObject30.optInt("enter_live_msg_audience_num_p2");
                this.aLN = optJSONObject30.optInt("enter_live_msg_audience_num_p3");
                this.aLJ = optJSONObject30.optInt("im_intercept_switch");
                this.aLK = optJSONObject30.optInt("is_check_im_content");
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject31 != null) {
                this.aLG = new AlaFeedDiversionData();
                this.aLG.parserJson(optJSONObject31);
                com.baidu.live.c.AZ().putString("feed_diversion", optJSONObject31.toString());
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject32 != null) {
                com.baidu.live.c.AZ().putString("key_stat_switch", optJSONObject32.toString());
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject33 != null) {
                this.aLO = optJSONObject33.optInt("unfold_interval", 5000);
                this.aLP = optJSONObject33.optInt("fold_interval", 55000);
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("modify_default_name_conf");
            if (optJSONObject34 != null) {
                this.aLT = new bl();
                this.aLT.parserJson(optJSONObject34);
            }
            JSONObject optJSONObject35 = jSONObject.optJSONObject("audio_live_conf");
            if (optJSONObject35 != null) {
                this.aLU = new bt();
                this.aLU.parse(optJSONObject35);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLv = jSONObject.optInt("im_max", 200);
            if (this.aLv <= 0) {
                this.aLv = 200;
            }
            this.aLw = jSONObject.optInt("barrage_max", 100);
            if (this.aLw <= 0) {
                this.aLw = 100;
            }
            this.aLx = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aLx <= 0) {
                this.aLx = 10;
            }
            this.aLy = jSONObject.optInt("enter_effect_max", 10);
            if (this.aLy <= 0) {
                this.aLy = 10;
            }
            this.aLz = jSONObject.optInt("gift_big_max", 10);
            if (this.aLz <= 0) {
                this.aLz = 10;
            }
            this.aLA = jSONObject.optInt("audio_gift_big_max", 15);
            if (this.aLA <= 0) {
                this.aLA = 15;
            }
            this.aLB = jSONObject.optInt("gift_small_max", 50);
            if (this.aLB <= 0) {
                this.aLB = 50;
            }
            this.aLC = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aLC <= 0) {
                this.aLC = 5;
            }
        }
    }

    private void DR() {
        this.aLi = com.baidu.live.c.AZ().getInt("guide_speak_watch_time", 15000);
        this.aLj = com.baidu.live.c.AZ().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.AZ().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aLk = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aLk[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void A(JSONObject jSONObject) {
        int length;
        this.aLi = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.c.AZ().putInt("guide_speak_watch_time", this.aLi);
        this.aLj = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.AZ().putInt("guide_speak_show_times_max", this.aLj);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aLk = new String[length];
            for (int i = 0; i < length; i++) {
                this.aLk[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.AZ().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void DS() {
        String string = com.baidu.live.c.AZ().getString("yuan_package_data", "");
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
            this.aLq = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aLq.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void gl(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aLs = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aLs.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aLt = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aLt.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.AZ().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void DT() {
        gl(com.baidu.live.c.AZ().getString("ala_quick_send_im_list", null));
    }

    private void gm(String str) {
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
        if (i != this.aKu) {
            z2 = true;
        }
        this.aKu = i;
        if (z || z2) {
            com.baidu.live.c.AZ().putInt("ala_live_session_default_key", i);
        }
    }

    private void DU() {
        this.aKu = com.baidu.live.c.AZ().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.AZ().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aKv.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.AZ().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aKy = jSONObject.optString("hlsUrl");
                this.aKw = jSONObject.optString("rtmpUrl");
                this.aKx = jSONObject.optString("flvUrl");
                this.aKz = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean DV() {
        return this.aKn == 1;
    }
}
