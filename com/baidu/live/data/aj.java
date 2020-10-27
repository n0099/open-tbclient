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
public class aj extends BaseData {
    public boolean aJF;
    public boolean aJG;
    public boolean aJH;
    public boolean aJI;
    public boolean aJJ;
    public String aJK;
    public String aJL;
    public String aJP;
    public String aJQ;
    public String aJR;
    public String aJS;
    public Integer[] aJV;
    public Integer[] aJW;
    public int aJX;
    public int aJZ;
    public boolean aKA;
    public boolean aKB;
    public boolean aKC;
    public boolean aKD;
    public String aKH;
    public String aKJ;
    public String aKK;
    public int aKQ;
    public String aKS;
    public String aKT;
    private String aKU;
    private String aKV;
    public int aKW;
    public String aKY;
    public String aKZ;
    public int aKa;
    public int aKb;
    public String aKc;
    public int aKd;
    public boolean aKe;
    public boolean aKf;
    public boolean aKg;
    public boolean aKh;
    public boolean aKj;
    public String aKk;
    public int aKl;
    public boolean aKm;
    public int aKn;
    public boolean aKo;
    public boolean aKp;
    public String aKq;
    public String aKr;
    public String aKs;
    public String aKt;
    public String aKu;
    public int aKv;
    public int aKw;
    public boolean aKx;
    public boolean aKy;
    public boolean aKz;
    public String aLA;
    public String aLB;
    public String aLC;
    public int aLD;
    public String aLH;
    public int aLM;
    public int aLN;
    public String[] aLO;
    public int aLP;
    public String aLQ;
    public String aLR;
    public QuickImInputData aLS;
    public QuickImInputData aLT;
    public List<YuanPackageData> aLU;
    public be aLV;
    public List<String> aLW;
    public List<String> aLX;
    public List<String> aLY;
    public String aLa;
    public String aLb;
    public String aLc;
    public boolean aLd;
    public long aLe;
    public long aLf;
    public String aLg;
    public String aLh;
    public String aLi;
    public String aLj;
    public long aLk;
    public long aLl;
    public long aLm;
    public String aLn;
    public String aLo;
    public String aLp;
    public int aLq;
    public int aLr;
    public int aLs;
    public String aLz;
    public as aMh;
    public boolean aMi;
    public String aMj;
    public AlaFeedDiversionData aMk;
    public r aMl;
    public boolean aMm;
    public int aMn;
    public int aMo;
    public ak aMu;
    public bv aMv;
    public bs aMw;
    public bo aMx;
    public by aMy;
    public boolean aMz;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aJD = -1;
    public String aJE = null;
    public int aKi = 1;
    public boolean aKE = true;
    public boolean aKF = false;
    public boolean aKG = false;
    public boolean aKI = false;
    public String aKL = "";
    private int aKM = 2;
    public String aKN = "";
    public int aKO = 1;
    public int aKP = 0;
    public int aKR = 1;
    public List<String> aKX = new ArrayList();
    public int aLt = 10;
    public int aLu = 60;
    public long aLv = 10000;
    public int aLw = 11;
    public int aLx = 4;
    public boolean aLy = false;
    public boolean aLE = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aLF = false;
    public boolean aLG = false;
    public boolean aLI = false;
    public boolean aLJ = false;
    public boolean aLK = false;
    public boolean aLL = false;
    public int aLZ = 200;
    public int aMa = 100;
    public int aMb = 10;
    public int aMc = 10;
    public int aMd = 10;
    public int aMe = 15;
    public int aMf = 50;
    public int aMg = 5;
    public int aMp = 20;
    public int aMq = 70;
    public int aMr = 10000;
    public int aMs = 5000;
    public int aMt = 55000;
    public ck aMA = ck.aRi;
    public List<String> aJO = new ArrayList();
    public List<String> aJY = new ArrayList();
    public List<String> aJT = new ArrayList();
    public List<Integer> aJU = new ArrayList();
    public ArrayList<o> aJM = new ArrayList<>();
    public ArrayList<o> aJN = new ArrayList<>();

    public aj(boolean z) {
        if (z) {
            DY();
            this.aJX = com.baidu.live.d.AZ().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.d.AZ().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.d.AZ().getInt("restart_time_interval", 300);
            DZ();
            DX();
            Ea();
            Eb();
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
                    this.aJX = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.d.AZ().putInt("conn_conf", this.aJX);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aJY.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.d.AZ().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.d.AZ().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    y(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    z(optJSONObject5);
                }
                this.aKJ = jSONObject.optString("client_id");
                com.baidu.live.d.AZ().putString("client_id", this.aKJ);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aJK = optJSONObject6.optString("pic_url");
                    this.aJL = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            o oVar = new o();
                            oVar.parseJson(optJSONObject8);
                            this.aJM.add(oVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.d.AZ().putString("pic_url", this.aJK);
                com.baidu.live.d.AZ().putString(BigdayActivityConfig.JUMP_URL, this.aJL);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    A(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aLP = optJSONObject10.optInt("resource_switch");
                    this.aLR = optJSONObject10.optString("photo_url");
                    this.aLQ = optJSONObject10.optString("resource_url");
                }
                this.aLS = new QuickImInputData();
                this.aLS.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aLT = new QuickImInputData();
                this.aLT.parseJson(jSONObject.getJSONArray("fast_reply_word_audio"));
                this.aLV = be.B(jSONObject.optJSONObject("guide_follow"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.d.AZ().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject11 != null) {
                    JSONObject optJSONObject12 = optJSONObject11.optJSONObject("rank");
                    if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.d.AZ().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.d.AZ().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.d.AZ().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject13 = optJSONObject11.optJSONObject("guard_seat");
                    if (optJSONObject13 != null) {
                        this.aMj = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aMh = new as();
                    this.aMh.aNn = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.d.AZ().putString("ala_certify_refuse_url", this.aMh.aNn);
                }
                this.aMu = new ak();
                this.aMu.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aMl = new r();
                    this.aMl.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aMv = new bv(optJSONObject16);
                }
                this.aMz = jSONObject.optInt("disc_optimize_switch") == 1;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.d.AZ().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void DX() {
        String string = com.baidu.live.d.AZ().getString("ala_prepare_random_title_list", "");
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
            this.aLY = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aLY.add(jSONArray.optString(i));
            }
        }
    }

    private void DY() {
        this.aJF = com.baidu.live.d.AZ().getBoolean("map_around_map", false);
        this.aKm = com.baidu.live.d.AZ().getBoolean("withdraw_switch", true);
        this.aKH = com.baidu.live.d.AZ().getString("withdraw_text", "");
        this.aKA = com.baidu.live.d.AZ().getBoolean("use_internal_player_switch", true);
        this.aKx = com.baidu.live.d.AZ().getBoolean("use_http_dns_switch", true);
        this.aKy = com.baidu.live.d.AZ().getBoolean("use_encode_bframe_switch", false);
        this.aKz = com.baidu.live.d.AZ().getBoolean("enable_opt_timestamp_switch", true);
        this.aKB = com.baidu.live.d.AZ().getBoolean("live_beauty_open_switch", false);
        this.aKC = com.baidu.live.d.AZ().getBoolean("live_unity_beauty_switch", true);
        this.aKD = com.baidu.live.d.AZ().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aKE = com.baidu.live.d.AZ().getBoolean("sp_key_live_game_hard_encode", true);
        this.aKF = com.baidu.live.d.AZ().getBoolean("sp_key_live_play_transcode_support", false);
        this.aKG = com.baidu.live.d.AZ().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aKI = com.baidu.live.d.AZ().getBoolean("ala_enable_graffiti_str", false);
        this.aJG = com.baidu.live.d.AZ().getBoolean("enter_live", false);
        this.aJH = com.baidu.live.d.AZ().getBoolean("sync_to_forum", true);
        this.aJI = com.baidu.live.d.AZ().getBoolean("show_water_mark", false);
        this.aJJ = com.baidu.live.d.AZ().getBoolean("show_third_part_water_mark_switch", false);
        this.aKe = com.baidu.live.d.AZ().getBoolean("stream_error_log", true);
        this.aKf = com.baidu.live.d.AZ().getBoolean("disable_channel_in", true);
        this.aKg = com.baidu.live.d.AZ().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aKh = com.baidu.live.d.AZ().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aKj = com.baidu.live.d.AZ().getBoolean("follow_default_push_switch", true);
        this.aKQ = com.baidu.live.d.AZ().getInt("to_tb_some_switch", 0);
        this.aKO = com.baidu.live.d.AZ().getInt("enable_live_stat", 1);
        this.aKP = com.baidu.live.d.AZ().getInt("ala_free_gift_task_switch", 0);
        this.aLy = com.baidu.live.d.AZ().getBoolean("live_challenge_switch", false);
        this.aLz = com.baidu.live.d.AZ().getString("live_challenge_tip", null);
        this.aLA = com.baidu.live.d.AZ().getString("live_challenge_url", null);
    }

    private void x(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aJF = optJSONObject.optInt("switch") != 1;
                com.baidu.live.d.AZ().putBoolean("map_around_map", this.aJF);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aKm = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("withdraw_switch", this.aKm);
                this.aKH = optJSONObject2.optString("text");
                com.baidu.live.d.AZ().putString("withdraw_text", this.aKH);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aKA = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("use_internal_player_switch", this.aKA);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aKx = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("use_http_dns_switch", this.aKx);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aKy = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("use_encode_bframe_switch", this.aKy);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aKz = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("enable_opt_timestamp_switch", this.aKz);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.aKB = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("live_beauty_open_switch", this.aKB);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.aKC = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("live_unity_beauty_switch", this.aKC);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.aKD = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("live_unity_beauty_face_style_switch", this.aKD);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.aKE = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("sp_key_live_game_hard_encode", this.aKE);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.aKF = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("sp_key_live_play_transcode_support", this.aKF);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.aKG = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("sp_key_live_play_attention_guide_support", this.aKG);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.aJG = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("enter_live", this.aJG);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.aJH = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean("sync_to_forum", this.aJH);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.aJI = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean("show_water_mark", this.aJI);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.aJJ = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean("show_third_part_water_mark_switch", this.aJJ);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.aKO = optJSONObject17.optInt("switch");
                com.baidu.live.d.AZ().putInt("enable_live_stat", this.aKO);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.aKe = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("stream_error_log", this.aKe);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.aKf = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean("disable_channel_in", this.aKf);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.aKg = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean("shoubai_yanzhi_tab_tip", this.aKg);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.aKh = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aKh);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.aKj = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.d.AZ().putBoolean("follow_default_push_switch", this.aKj);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.aKQ = optJSONObject23.optInt("switch");
                com.baidu.live.d.AZ().putInt("to_tb_some_switch", this.aKQ);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.aKP = optJSONObject24.optInt("switch");
                com.baidu.live.d.AZ().putInt("ala_free_gift_task_switch", this.aKQ);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.aKI = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("ala_enable_graffiti_str", this.aKI);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aLy = optJSONObject26.optInt("switch") == 1;
                this.aLz = optJSONObject26.optString("title");
                this.aLA = optJSONObject26.optString("url");
                com.baidu.live.d.AZ().putBoolean("live_challenge_switch", this.aLy);
                com.baidu.live.d.AZ().putString("live_challenge_tip", this.aLz);
                com.baidu.live.d.AZ().putString("live_challenge_url", this.aLA);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aLG = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("is_new_gift_t_dou_strategy", this.aLG);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aLK = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aLI = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("key_is_open_login_prove", this.aLI);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aLJ = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("key_is_open_diamond", this.aLJ);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aLL = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("key_is_jump_to_live_room", this.aLL);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aMi = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aMm = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void DZ() {
        JSONArray jSONArray;
        this.aKc = com.baidu.live.d.AZ().getString("bluediamond_url", "");
        this.aJQ = com.baidu.live.d.AZ().getString("verify_content", this.aJQ);
        this.aJP = com.baidu.live.d.AZ().getString("live_notice", "");
        this.aJR = com.baidu.live.d.AZ().getString("activity_notice", "");
        String string = com.baidu.live.d.AZ().getString("imNotice", "");
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
                        this.aJO.add(i, optString);
                    }
                }
            }
        }
        this.aKK = com.baidu.live.d.AZ().getString("share_host", "");
        this.aKL = com.baidu.live.d.AZ().getString("ala_share_in_bar_notice_text", "");
        this.aKN = com.baidu.live.d.AZ().getString("ala_share_reward_rank_notice_text", "");
        this.aKM = com.baidu.live.d.AZ().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aKd = com.baidu.live.d.AZ().getInt("recommend_refresh", 60);
        this.aKk = com.baidu.live.d.AZ().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aKl = com.baidu.live.d.AZ().getInt("strategy_exception_interval", 1);
        this.aKi = com.baidu.live.d.AZ().getInt("liveStartAuthLevel", 1);
        this.aJZ = com.baidu.live.d.AZ().getInt("2gTo", 5);
        this.aKa = com.baidu.live.d.AZ().getInt("3gTo", 3);
        this.aKb = com.baidu.live.d.AZ().getInt("wifiTo", 3);
        String string2 = com.baidu.live.d.AZ().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aJV = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.d.AZ().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aJW = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aKR = com.baidu.live.d.AZ().getInt("square_tab_strategy", 1);
        this.aKS = com.baidu.live.d.AZ().getString("ala_live_ranklist_url", null);
        this.aKT = com.baidu.live.d.AZ().getString("new_flower_rank_list_description_url", "");
        this.aKU = com.baidu.live.d.AZ().getString("ala_game_player_signup_url", null);
        this.aKV = com.baidu.live.d.AZ().getString("ala_game_frs_live_tab_video_url", null);
        Ed();
        this.aLc = com.baidu.live.d.AZ().getString("ala_personal_income_detail_url", null);
        this.aLD = com.baidu.live.d.AZ().getInt("ala_custom_gift_category_id", -1);
        this.aLd = com.baidu.live.d.AZ().getInt("ala_live_pk_switch", 0) == 1;
        this.aLe = com.baidu.live.d.AZ().getLong("ala_live_pk_check_interval", 1000L);
        this.aLf = com.baidu.live.d.AZ().getLong("ala_live_pk_match_timeout", 60000L);
        this.aLg = com.baidu.live.d.AZ().getString("ala_live_pk_pic_url", "");
        this.aLh = com.baidu.live.d.AZ().getString("ala_live_pk_pic_jump_url", "");
        this.aLi = com.baidu.live.d.AZ().getString("ala_live_pk_history_link", "");
        this.aLj = com.baidu.live.d.AZ().getString("show_live_forum_url", "");
        this.aLk = com.baidu.live.d.AZ().getLong("ala_challenge_random_interval", 1000L);
        this.aLl = com.baidu.live.d.AZ().getLong("ala_challenge_direct_interval", 1000L);
        this.aLm = com.baidu.live.d.AZ().getLong("ala_get_challenge_info_interval", 1000L);
        this.aLo = com.baidu.live.d.AZ().getString("ala_challenge_pk_entry_icon_url", "");
        this.aLp = com.baidu.live.d.AZ().getString("ala_challenge_pk_entry_icon_url", "");
        this.aLn = com.baidu.live.d.AZ().getString("ala_challenge_pk_entry_icon_url", "");
        this.aLq = com.baidu.live.d.AZ().getInt("punish_stage_button_switch", 0);
        this.aLr = com.baidu.live.d.AZ().getInt("receive_challenge_im_show_time", 0);
        this.aLs = com.baidu.live.d.AZ().getInt("mvpPunishSwitch", 0);
        this.aLt = com.baidu.live.d.AZ().getInt("toastLifeTime", 10);
        this.aLu = com.baidu.live.d.AZ().getInt("punishLifeTime", 60);
        this.aLE = com.baidu.live.d.AZ().getBoolean("ala_guess_use_https", false);
        gn(com.baidu.live.d.AZ().getString("ala_live_bar_map_str", ""));
        this.aLF = com.baidu.live.d.AZ().getBoolean("is_new_live_close_strategy", false);
        this.aLG = com.baidu.live.d.AZ().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aLH = com.baidu.live.d.AZ().getString("ala_feedback_url", null);
        this.aKn = com.baidu.live.d.AZ().getInt("ala_video_resolution_level", 3);
        this.aKo = com.baidu.live.d.AZ().getBoolean("ala_live_hard_encode_switch", true);
        this.aKp = com.baidu.live.d.AZ().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.d.AZ().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.d.AZ().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.d.AZ().getInt("ala_video_increase_count", 3);
        this.aKq = com.baidu.live.d.AZ().getString("ala_video_soft_bitrate_config", null);
        this.aKr = com.baidu.live.d.AZ().getString("ala_video_hard_bitrate_config", null);
        this.aKv = com.baidu.live.d.AZ().getInt("ala_master_chat_video_resolution_level", 3);
        this.aKw = com.baidu.live.d.AZ().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aKs = com.baidu.live.d.AZ().getString("ala_avts_stream_server_domain_config", null);
        this.aKt = com.baidu.live.d.AZ().getString("ala_master_chat_video_bitrate_config", null);
        this.aKu = com.baidu.live.d.AZ().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.d.AZ().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.d.AZ().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aLI = com.baidu.live.d.AZ().getBoolean("key_is_open_login_prove", false);
        this.aLJ = com.baidu.live.d.AZ().getBoolean("key_is_open_diamond", false);
        this.aLL = com.baidu.live.d.AZ().getBoolean("key_is_jump_to_live_room", false);
        gl(com.baidu.live.d.AZ().getString("feed_diversion", ""));
        Ec();
    }

    private void gl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aMk = new AlaFeedDiversionData();
                this.aMk.parserJson(jSONObject);
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
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tying_gift_conf");
            if (optJSONObject2 != null) {
                this.aLw = optJSONObject2.optInt("pendant_details_show_times");
                this.aLx = optJSONObject2.optInt("pendant_inform_show_times");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("pksolo");
            if (optJSONObject3 != null) {
                this.aJS = optJSONObject3.toString();
                this.aMw = new bs();
                this.aMw.parse(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject4 != null) {
                this.aJE = optJSONObject4.optString("toast");
                this.aJD = optJSONObject4.optInt("remind_type");
            }
            this.aKc = jSONObject.optString("bluediamond_url");
            com.baidu.live.d.AZ().putString("bluediamond_url", this.aKc);
            this.aJQ = jSONObject.optString("verify_content");
            com.baidu.live.d.AZ().putString("verify_content", this.aJQ);
            this.aJP = jSONObject.optString("live_notice");
            com.baidu.live.d.AZ().putString("live_notice", this.aJP);
            this.aJR = jSONObject.optString("activityNotice");
            com.baidu.live.d.AZ().putString("activity_notice", this.aJR);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aJO.add(i, optString);
                    }
                }
                com.baidu.live.d.AZ().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.d.AZ().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.aJT.add(i2, optString2);
                    }
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("bd_live_activity");
            if (optJSONObject5 != null && (optJSONArray = optJSONObject5.optJSONArray("main_page")) != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject6 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject6 != null) {
                        o oVar = new o();
                        oVar.parseJson(optJSONObject6);
                        this.aJN.add(oVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aJU.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("share_host");
            if (optJSONObject7 != null) {
                this.aKK = optJSONObject7.optString("url");
            } else {
                this.aKK = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject8 != null) {
                this.aKL = optJSONObject8.optString("reward_notice");
                this.aKN = optJSONObject8.optString("reward_rank_notice");
                this.aKM = optJSONObject8.optInt("reward_switch", 2);
            } else {
                this.aKL = "";
                this.aKN = "";
                this.aKM = 2;
            }
            com.baidu.live.d.AZ().putString("share_host", this.aKK);
            com.baidu.live.d.AZ().putString("ala_share_in_bar_notice_text", this.aKL);
            com.baidu.live.d.AZ().putString("ala_share_reward_rank_notice_text", this.aKN);
            com.baidu.live.d.AZ().putInt("ala_share_in_bar_notice_tip_switch", this.aKM);
            JSONObject optJSONObject9 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject9 != null) {
                this.aKd = optJSONObject9.optInt("value");
            } else {
                this.aKd = 60;
            }
            com.baidu.live.d.AZ().putInt("recommend_refresh", this.aKd);
            JSONObject optJSONObject10 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject10 != null) {
                JSONArray optJSONArray5 = optJSONObject10.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.d.AZ().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aJV = g(optJSONArray5);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject11 != null) {
                JSONArray optJSONArray6 = optJSONObject11.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.d.AZ().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aJW = g(optJSONArray6);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject12 != null) {
                this.aKk = optJSONObject12.optString("time_interval");
                this.aKl = optJSONObject12.optInt("exception_interval");
            } else {
                this.aKk = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aKl = 1;
            }
            com.baidu.live.d.AZ().putString("strategy_conf", this.aKk);
            com.baidu.live.d.AZ().putInt("strategy_exception_interval", this.aKl);
            this.aKi = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.d.AZ().putInt("liveStartAuthLevel", this.aKi);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject13 != null) {
                this.aJZ = optJSONObject13.optInt("2gTo");
                if (this.aJZ < 3) {
                    this.aJZ = 3;
                }
                this.aKa = optJSONObject13.optInt("3gTo");
                if (this.aKa < 3) {
                    this.aKa = 3;
                }
                this.aKb = optJSONObject13.optInt("wifiTo");
                if (this.aKb < 3) {
                    this.aKb = 3;
                }
                com.baidu.live.d.AZ().putInt("2gTo", this.aJZ);
                com.baidu.live.d.AZ().putInt("3gTo", this.aKa);
                com.baidu.live.d.AZ().putInt("wifiTo", this.aKb);
            }
            this.aKR = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.d.AZ().putInt("square_tab_strategy", this.aKR);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject14 != null) {
                this.aKS = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                this.aKT = optJSONObject14.optString("flower_rank_rule");
            }
            com.baidu.live.d.AZ().putString("ala_live_ranklist_url", this.aKS);
            com.baidu.live.d.AZ().putString("new_flower_rank_list_description_url", this.aKT);
            JSONObject optJSONObject15 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject15 != null) {
                this.aKU = optJSONObject15.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.d.AZ().putString("ala_game_player_signup_url", this.aKU);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject16 != null) {
                this.aKV = optJSONObject16.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.AZ().putString("ala_game_frs_live_tab_video_url", this.aKV);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject17 != null) {
                this.aKW = optJSONObject17.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.d.AZ().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aKX.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject18 != null) {
                com.baidu.live.d.AZ().putString("ala_live_session_replace_key", optJSONObject18.toString());
                this.aLa = optJSONObject18.optString("hlsUrl");
                this.aKY = optJSONObject18.optString("rtmpUrl");
                this.aKZ = optJSONObject18.optString("flvUrl");
                this.aLb = optJSONObject18.optString(".m3u8");
            }
            b(true, this.aKW);
            JSONObject optJSONObject19 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject19 != null) {
                this.aLc = optJSONObject19.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.AZ().putString("ala_personal_income_detail_url", this.aLc);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject20 != null) {
                this.aLD = optJSONObject20.optInt("android_show");
                com.baidu.live.d.AZ().putInt("ala_custom_gift_category_id", this.aLD);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("pub_show_conf");
            if (optJSONObject21 != null) {
                this.aMA = new ck();
                this.aMA.parserJson(optJSONObject21);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject22 != null) {
                int optInt = optJSONObject22.optInt("open", 0);
                this.aLd = optInt == 1;
                com.baidu.live.d.AZ().putInt("ala_live_pk_switch", optInt);
                this.aLe = optJSONObject22.optLong("interval");
                if (this.aLe < 1000) {
                    this.aLe = 1000L;
                }
                com.baidu.live.d.AZ().putLong("ala_live_pk_check_interval", this.aLe);
                this.aLf = optJSONObject22.optLong("match_timeout");
                if (this.aLf < 60000) {
                    this.aLf = 60000L;
                }
                com.baidu.live.d.AZ().putLong("ala_live_pk_match_timeout", this.aLf);
                this.aLg = optJSONObject22.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.d.AZ().putString("ala_live_pk_pic_url", this.aLg);
                this.aLh = optJSONObject22.optString("rank_link");
                com.baidu.live.d.AZ().putString("ala_live_pk_pic_jump_url", this.aLh);
                this.aLi = optJSONObject22.optString("history_link");
                com.baidu.live.d.AZ().putString("ala_live_pk_history_link", this.aLi);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject23 != null) {
                this.aLk = optJSONObject23.optLong("random_interval");
                if (this.aLk < 1000) {
                    this.aLk = 1000L;
                }
                com.baidu.live.d.AZ().putLong("ala_challenge_random_interval", this.aLk);
                this.aLl = optJSONObject23.optLong("direct_interval");
                if (this.aLl < 1000) {
                    this.aLl = 1000L;
                }
                com.baidu.live.d.AZ().putLong("ala_challenge_direct_interval", this.aLl);
                this.aLm = optJSONObject23.optLong("challenge_info_interval");
                if (this.aLm < 1000) {
                    this.aLm = 1000L;
                }
                com.baidu.live.d.AZ().putLong("ala_get_challenge_info_interval", this.aLm);
                this.aLo = optJSONObject23.optString("pk_icon_url");
                com.baidu.live.d.AZ().putString("ala_challenge_pk_entry_icon_url", this.aLo);
                this.aLp = optJSONObject23.optString("icon_url");
                com.baidu.live.d.AZ().putString("ala_challenge_pk_entry_icon_url", this.aLp);
                this.aLn = optJSONObject23.optString("rule_url");
                com.baidu.live.d.AZ().putString("ala_challenge_pk_entry_icon_url", this.aLn);
                this.aLq = optJSONObject23.optInt("punish_stage_button_switch");
                com.baidu.live.d.AZ().putInt("punish_stage_button_switch", this.aLq);
                this.aLr = optJSONObject23.optInt("receive_challenge_im_show_time");
                com.baidu.live.d.AZ().putInt("receive_challenge_im_show_time", this.aLr);
                this.aLs = optJSONObject23.optInt("mvpPunishSwitch");
                com.baidu.live.d.AZ().putInt("mvpPunishSwitch", this.aLs);
                this.aLt = optJSONObject23.optInt("toastLifeTime");
                com.baidu.live.d.AZ().putInt("toastLifeTime", this.aLt);
                this.aLu = optJSONObject23.optInt("punishLifeTime");
                com.baidu.live.d.AZ().putInt("punishLifeTime", this.aLu);
                this.aLv = optJSONObject23.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject24 != null) {
                this.aLj = optJSONObject24.optString("go_url");
                com.baidu.live.d.AZ().putString("show_live_forum_url", this.aLj);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject25 != null) {
                this.aLE = optJSONObject25.optInt("use_https", 0) == 1;
                com.baidu.live.d.AZ().putBoolean("ala_guess_use_https", this.aLE);
            }
            String optString3 = jSONObject.optString("live_bar");
            gn(optString3);
            com.baidu.live.d.AZ().putString("ala_live_bar_map_str", optString3);
            this.aLF = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.d.AZ().putBoolean("is_new_live_close_strategy", this.aLF);
            this.aLG = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.d.AZ().putBoolean("is_new_gift_t_dou_strategy", this.aLG);
            this.aLH = jSONObject.optString("feedback_url");
            com.baidu.live.d.AZ().putString("ala_feedback_url", this.aLH);
            JSONObject optJSONObject26 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject26 != null && (optJSONObject = optJSONObject26.optJSONObject("challenge_related_zip")) != null) {
                this.aLB = optJSONObject.optString("zip_md5");
                this.aLC = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject27 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject27.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject27.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.d.AZ().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.d.AZ().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("open_live");
            if (optJSONObject28 != null) {
                this.increaseThreshold = optJSONObject28.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.d.AZ().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject28.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.d.AZ().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject28.optInt("thi_count", 3);
                com.baidu.live.d.AZ().putInt("ala_video_increase_count", this.increaseCount);
                this.aKo = optJSONObject28.optInt("encoder", 1) == 1;
                com.baidu.live.d.AZ().putBoolean("ala_live_hard_encode_switch", this.aKo);
                this.aKp = optJSONObject28.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.d.AZ().putBoolean("ala_dynamic_bitrate_switch", this.aKp);
                this.aKn = optJSONObject28.optInt("resolution", 3);
                com.baidu.live.d.AZ().putInt("ala_video_resolution_level", this.aKn);
                JSONArray optJSONArray8 = optJSONObject28.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aKq = optJSONArray8.toString();
                    com.baidu.live.d.AZ().putString("ala_video_soft_bitrate_config", this.aKq);
                }
                JSONArray optJSONArray9 = optJSONObject28.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aKr = optJSONArray9.toString();
                    com.baidu.live.d.AZ().putString("ala_video_hard_bitrate_config", this.aKr);
                }
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject29 != null) {
                this.aKs = optJSONObject29.toString();
                com.baidu.live.d.AZ().putString("ala_avts_stream_server_domain_config", this.aKs);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject30 != null) {
                this.aKv = optJSONObject30.optInt("host_rtc_resolution", 3);
                com.baidu.live.d.AZ().putInt("ala_master_chat_video_resolution_level", this.aKv);
                this.aKw = optJSONObject30.optInt("rtc_resolution", 4);
                com.baidu.live.d.AZ().putInt("ala_slave_chat_video_resolution_level", this.aKw);
                JSONArray optJSONArray10 = optJSONObject30.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aKt = optJSONArray10.toString();
                    com.baidu.live.d.AZ().putString("ala_master_chat_video_bitrate_config", this.aKt);
                }
                JSONArray optJSONArray11 = optJSONObject30.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aKu = optJSONArray11.toString();
                    com.baidu.live.d.AZ().putString("ala_slave_chat_video_bitrate_config", this.aKu);
                }
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject31 != null) {
                this.aMp = optJSONObject31.optInt("enter_live_msg_audience_num_p1");
                this.aMq = optJSONObject31.optInt("enter_live_msg_audience_num_p2");
                this.aMr = optJSONObject31.optInt("enter_live_msg_audience_num_p3");
                this.aMn = optJSONObject31.optInt("im_intercept_switch");
                this.aMo = optJSONObject31.optInt("is_check_im_content");
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject32 != null) {
                this.aMk = new AlaFeedDiversionData();
                this.aMk.parserJson(optJSONObject32);
                com.baidu.live.d.AZ().putString("feed_diversion", optJSONObject32.toString());
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject33 != null) {
                com.baidu.live.d.AZ().putString("key_stat_switch", optJSONObject33.toString());
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject34 != null) {
                this.aMs = optJSONObject34.optInt("unfold_interval", 5000);
                this.aMt = optJSONObject34.optInt("fold_interval", 55000);
            }
            JSONObject optJSONObject35 = jSONObject.optJSONObject("modify_default_name_conf");
            if (optJSONObject35 != null) {
                this.aMx = new bo();
                this.aMx.parserJson(optJSONObject35);
            }
            JSONObject optJSONObject36 = jSONObject.optJSONObject("audio_live_conf");
            if (optJSONObject36 != null) {
                this.aMy = new by();
                this.aMy.parse(optJSONObject36);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLZ = jSONObject.optInt("im_max", 200);
            if (this.aLZ <= 0) {
                this.aLZ = 200;
            }
            this.aMa = jSONObject.optInt("barrage_max", 100);
            if (this.aMa <= 0) {
                this.aMa = 100;
            }
            this.aMb = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aMb <= 0) {
                this.aMb = 10;
            }
            this.aMc = jSONObject.optInt("enter_effect_max", 10);
            if (this.aMc <= 0) {
                this.aMc = 10;
            }
            this.aMd = jSONObject.optInt("gift_big_max", 10);
            if (this.aMd <= 0) {
                this.aMd = 10;
            }
            this.aMe = jSONObject.optInt("audio_gift_big_max", 15);
            if (this.aMe <= 0) {
                this.aMe = 15;
            }
            this.aMf = jSONObject.optInt("gift_small_max", 50);
            if (this.aMf <= 0) {
                this.aMf = 50;
            }
            this.aMg = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aMg <= 0) {
                this.aMg = 5;
            }
        }
    }

    private void Ea() {
        this.aLM = com.baidu.live.d.AZ().getInt("guide_speak_watch_time", 15000);
        this.aLN = com.baidu.live.d.AZ().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.d.AZ().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aLO = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aLO[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void A(JSONObject jSONObject) {
        int length;
        this.aLM = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.d.AZ().putInt("guide_speak_watch_time", this.aLM);
        this.aLN = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.d.AZ().putInt("guide_speak_show_times_max", this.aLN);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aLO = new String[length];
            for (int i = 0; i < length; i++) {
                this.aLO[i] = optJSONArray.optString(i);
            }
            com.baidu.live.d.AZ().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void Eb() {
        String string = com.baidu.live.d.AZ().getString("yuan_package_data", "");
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
            this.aLU = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aLU.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void gm(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aLW = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aLW.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aLX = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aLX.add(str3);
                            }
                        }
                    }
                    com.baidu.live.d.AZ().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void Ec() {
        gm(com.baidu.live.d.AZ().getString("ala_quick_send_im_list", null));
    }

    private void gn(String str) {
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
        if (i != this.aKW) {
            z2 = true;
        }
        this.aKW = i;
        if (z || z2) {
            com.baidu.live.d.AZ().putInt("ala_live_session_default_key", i);
        }
    }

    private void Ed() {
        this.aKW = com.baidu.live.d.AZ().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.d.AZ().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aKX.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.d.AZ().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aLa = jSONObject.optString("hlsUrl");
                this.aKY = jSONObject.optString("rtmpUrl");
                this.aKZ = jSONObject.optString("flvUrl");
                this.aLb = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean Ee() {
        return this.aKP == 1;
    }
}
