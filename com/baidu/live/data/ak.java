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
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ak extends BaseData {
    public boolean aKF;
    public boolean aKG;
    public boolean aKH;
    public boolean aKI;
    public boolean aKJ;
    public String aKK;
    public String aKL;
    public String aKP;
    public String aKQ;
    public String aKR;
    public String aKS;
    public Integer[] aKV;
    public Integer[] aKW;
    public int aKX;
    public int aKZ;
    public boolean aLA;
    public boolean aLB;
    public boolean aLC;
    public boolean aLD;
    public String aLH;
    public String aLJ;
    public String aLK;
    public int aLQ;
    public String aLS;
    public String aLT;
    private String aLU;
    private String aLV;
    public int aLW;
    public String aLY;
    public String aLZ;
    public int aLa;
    public int aLb;
    public String aLc;
    public int aLd;
    public boolean aLe;
    public boolean aLf;
    public boolean aLg;
    public boolean aLh;
    public boolean aLj;
    public String aLk;
    public int aLl;
    public boolean aLm;
    public int aLn;
    public boolean aLo;
    public boolean aLp;
    public String aLq;
    public String aLr;
    public String aLs;
    public String aLt;
    public String aLu;
    public int aLv;
    public int aLw;
    public boolean aLx;
    public boolean aLy;
    public boolean aLz;
    public String aMA;
    public String aMB;
    public String aMC;
    public int aMD;
    public String aMH;
    public int aMM;
    public int aMN;
    public String[] aMO;
    public int aMP;
    public String aMQ;
    public String aMR;
    public QuickImInputData aMS;
    public QuickImInputData aMT;
    public List<YuanPackageData> aMU;
    public bg aMV;
    public List<String> aMW;
    public List<String> aMX;
    public List<String> aMY;
    public String aMa;
    public String aMb;
    public String aMc;
    public boolean aMd;
    public long aMe;
    public long aMf;
    public String aMg;
    public String aMh;
    public String aMi;
    public String aMj;
    public long aMk;
    public long aMl;
    public long aMm;
    public String aMn;
    public String aMo;
    public String aMp;
    public int aMq;
    public int aMr;
    public int aMs;
    public String aMz;
    public au aNh;
    public boolean aNi;
    public String aNj;
    public AlaFeedDiversionData aNk;
    public r aNl;
    public boolean aNm;
    public int aNn;
    public int aNo;
    public al aNu;
    public bw aNv;
    public bt aNw;
    public bp aNx;
    public bz aNy;
    public boolean aNz;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aKD = -1;
    public String aKE = null;
    public int aLi = 1;
    public boolean aLE = true;
    public boolean aLF = false;
    public boolean aLG = false;
    public boolean aLI = false;
    public String aLL = "";
    private int aLM = 2;
    public String aLN = "";
    public int aLO = 1;
    public int aLP = 0;
    public int aLR = 1;
    public List<String> aLX = new ArrayList();
    public int aMt = 10;
    public int aMu = 60;
    public long aMv = 10000;
    public int aMw = 11;
    public int aMx = 4;
    public boolean aMy = false;
    public boolean aME = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aMF = false;
    public boolean aMG = false;
    public boolean aMI = false;
    public boolean aMJ = false;
    public boolean aMK = false;
    public boolean aML = false;
    public int aMZ = 200;
    public int aNa = 100;
    public int aNb = 10;
    public int aNc = 10;
    public int aNd = 10;
    public int aNe = 15;
    public int aNf = 50;
    public int aNg = 5;
    public int aNp = 20;
    public int aNq = 70;
    public int aNr = 10000;
    public int aNs = 5000;
    public int aNt = 55000;
    public cm aNA = cm.aSk;
    public cn aNB = cn.aSp;
    public Map<Integer, String> aNC = new HashMap();
    public List<String> aKO = new ArrayList();
    public List<String> aKY = new ArrayList();
    public List<String> aKT = new ArrayList();
    public List<Integer> aKU = new ArrayList();
    public ArrayList<o> aKM = new ArrayList<>();
    public ArrayList<o> aKN = new ArrayList<>();

    public ak(boolean z) {
        if (z) {
            Eu();
            this.aKX = com.baidu.live.d.AZ().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.d.AZ().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.d.AZ().getInt("restart_time_interval", 300);
            Ev();
            Et();
            Ew();
            Ex();
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
                    this.aKX = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.d.AZ().putInt("conn_conf", this.aKX);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aKY.add(i, optString);
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
                    B(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    C(optJSONObject5);
                }
                this.aLJ = jSONObject.optString("client_id");
                com.baidu.live.d.AZ().putString("client_id", this.aLJ);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aKK = optJSONObject6.optString("pic_url");
                    this.aKL = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            o oVar = new o();
                            oVar.parseJson(optJSONObject8);
                            this.aKM.add(oVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.d.AZ().putString("pic_url", this.aKK);
                com.baidu.live.d.AZ().putString(BigdayActivityConfig.JUMP_URL, this.aKL);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    D(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aMP = optJSONObject10.optInt("resource_switch");
                    this.aMR = optJSONObject10.optString("photo_url");
                    this.aMQ = optJSONObject10.optString("resource_url");
                }
                this.aMS = new QuickImInputData();
                this.aMS.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aMT = new QuickImInputData();
                this.aMT.parseJson(jSONObject.getJSONArray("fast_reply_word_audio"));
                this.aMV = bg.E(jSONObject.optJSONObject("guide_follow"));
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
                        this.aNj = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aNh = new au();
                    this.aNh.aOq = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.d.AZ().putString("ala_certify_refuse_url", this.aNh.aOq);
                }
                this.aNu = new al();
                this.aNu.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aNl = new r();
                    this.aNl.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aNv = new bw(optJSONObject16);
                }
                this.aNz = jSONObject.optInt("disc_optimize_switch") == 1;
                JSONObject optJSONObject17 = jSONObject.optJSONObject("new_level_icon_urls");
                if (optJSONObject17 != null) {
                    int length2 = optJSONObject17.length();
                    for (int i3 = 1; i3 <= length2; i3++) {
                        this.aNC.put(Integer.valueOf(i3), optJSONObject17.optString(i3 + ""));
                    }
                }
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

    private void Et() {
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
            this.aMY = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aMY.add(jSONArray.optString(i));
            }
        }
    }

    private void Eu() {
        this.aKF = com.baidu.live.d.AZ().getBoolean("map_around_map", false);
        this.aLm = com.baidu.live.d.AZ().getBoolean("withdraw_switch", true);
        this.aLH = com.baidu.live.d.AZ().getString("withdraw_text", "");
        this.aLA = com.baidu.live.d.AZ().getBoolean("use_internal_player_switch", true);
        this.aLx = com.baidu.live.d.AZ().getBoolean("use_http_dns_switch", true);
        this.aLy = com.baidu.live.d.AZ().getBoolean("use_encode_bframe_switch", false);
        this.aLz = com.baidu.live.d.AZ().getBoolean("enable_opt_timestamp_switch", true);
        this.aLB = com.baidu.live.d.AZ().getBoolean("live_beauty_open_switch", false);
        this.aLC = com.baidu.live.d.AZ().getBoolean("live_unity_beauty_switch", true);
        this.aLD = com.baidu.live.d.AZ().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aLE = com.baidu.live.d.AZ().getBoolean("sp_key_live_game_hard_encode", true);
        this.aLF = com.baidu.live.d.AZ().getBoolean("sp_key_live_play_transcode_support", false);
        this.aLG = com.baidu.live.d.AZ().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aLI = com.baidu.live.d.AZ().getBoolean("ala_enable_graffiti_str", false);
        this.aKG = com.baidu.live.d.AZ().getBoolean("enter_live", false);
        this.aKH = com.baidu.live.d.AZ().getBoolean("sync_to_forum", true);
        this.aKI = com.baidu.live.d.AZ().getBoolean("show_water_mark", false);
        this.aKJ = com.baidu.live.d.AZ().getBoolean("show_third_part_water_mark_switch", false);
        this.aLe = com.baidu.live.d.AZ().getBoolean("stream_error_log", true);
        this.aLf = com.baidu.live.d.AZ().getBoolean("disable_channel_in", true);
        this.aLg = com.baidu.live.d.AZ().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aLh = com.baidu.live.d.AZ().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aLj = com.baidu.live.d.AZ().getBoolean("follow_default_push_switch", true);
        this.aLQ = com.baidu.live.d.AZ().getInt("to_tb_some_switch", 0);
        this.aLO = com.baidu.live.d.AZ().getInt("enable_live_stat", 1);
        this.aLP = com.baidu.live.d.AZ().getInt("ala_free_gift_task_switch", 0);
        this.aMy = com.baidu.live.d.AZ().getBoolean("live_challenge_switch", false);
        this.aMz = com.baidu.live.d.AZ().getString("live_challenge_tip", null);
        this.aMA = com.baidu.live.d.AZ().getString("live_challenge_url", null);
    }

    private void A(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aKF = optJSONObject.optInt("switch") != 1;
                com.baidu.live.d.AZ().putBoolean("map_around_map", this.aKF);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aLm = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("withdraw_switch", this.aLm);
                this.aLH = optJSONObject2.optString("text");
                com.baidu.live.d.AZ().putString("withdraw_text", this.aLH);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aLA = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("use_internal_player_switch", this.aLA);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aLx = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("use_http_dns_switch", this.aLx);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aLy = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("use_encode_bframe_switch", this.aLy);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aLz = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("enable_opt_timestamp_switch", this.aLz);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.aLB = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("live_beauty_open_switch", this.aLB);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.aLC = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("live_unity_beauty_switch", this.aLC);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.aLD = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("live_unity_beauty_face_style_switch", this.aLD);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.aLE = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("sp_key_live_game_hard_encode", this.aLE);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.aLF = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("sp_key_live_play_transcode_support", this.aLF);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.aLG = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("sp_key_live_play_attention_guide_support", this.aLG);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.aKG = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("enter_live", this.aKG);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.aKH = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean("sync_to_forum", this.aKH);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.aKI = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean("show_water_mark", this.aKI);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.aKJ = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean("show_third_part_water_mark_switch", this.aKJ);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.aLO = optJSONObject17.optInt("switch");
                com.baidu.live.d.AZ().putInt("enable_live_stat", this.aLO);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.aLe = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("stream_error_log", this.aLe);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.aLf = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean("disable_channel_in", this.aLf);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.aLg = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean("shoubai_yanzhi_tab_tip", this.aLg);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.aLh = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.d.AZ().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aLh);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.aLj = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.d.AZ().putBoolean("follow_default_push_switch", this.aLj);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.aLQ = optJSONObject23.optInt("switch");
                com.baidu.live.d.AZ().putInt("to_tb_some_switch", this.aLQ);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.aLP = optJSONObject24.optInt("switch");
                com.baidu.live.d.AZ().putInt("ala_free_gift_task_switch", this.aLQ);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.aLI = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("ala_enable_graffiti_str", this.aLI);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aMy = optJSONObject26.optInt("switch") == 1;
                this.aMz = optJSONObject26.optString("title");
                this.aMA = optJSONObject26.optString("url");
                com.baidu.live.d.AZ().putBoolean("live_challenge_switch", this.aMy);
                com.baidu.live.d.AZ().putString("live_challenge_tip", this.aMz);
                com.baidu.live.d.AZ().putString("live_challenge_url", this.aMA);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aMG = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("is_new_gift_t_dou_strategy", this.aMG);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aMK = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aMI = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("key_is_open_login_prove", this.aMI);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aMJ = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("key_is_open_diamond", this.aMJ);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aML = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.d.AZ().putBoolean("key_is_jump_to_live_room", this.aML);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aNi = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aNm = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void Ev() {
        JSONArray jSONArray;
        this.aLc = com.baidu.live.d.AZ().getString("bluediamond_url", "");
        this.aKQ = com.baidu.live.d.AZ().getString("verify_content", this.aKQ);
        this.aKP = com.baidu.live.d.AZ().getString("live_notice", "");
        this.aKR = com.baidu.live.d.AZ().getString("activity_notice", "");
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
                        this.aKO.add(i, optString);
                    }
                }
            }
        }
        this.aLK = com.baidu.live.d.AZ().getString("share_host", "");
        this.aLL = com.baidu.live.d.AZ().getString("ala_share_in_bar_notice_text", "");
        this.aLN = com.baidu.live.d.AZ().getString("ala_share_reward_rank_notice_text", "");
        this.aLM = com.baidu.live.d.AZ().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aLd = com.baidu.live.d.AZ().getInt("recommend_refresh", 60);
        this.aLk = com.baidu.live.d.AZ().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aLl = com.baidu.live.d.AZ().getInt("strategy_exception_interval", 1);
        this.aLi = com.baidu.live.d.AZ().getInt("liveStartAuthLevel", 1);
        this.aKZ = com.baidu.live.d.AZ().getInt("2gTo", 5);
        this.aLa = com.baidu.live.d.AZ().getInt("3gTo", 3);
        this.aLb = com.baidu.live.d.AZ().getInt("wifiTo", 3);
        String string2 = com.baidu.live.d.AZ().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aKV = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.d.AZ().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aKW = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aLR = com.baidu.live.d.AZ().getInt("square_tab_strategy", 1);
        this.aLS = com.baidu.live.d.AZ().getString("ala_live_ranklist_url", null);
        this.aLT = com.baidu.live.d.AZ().getString("new_flower_rank_list_description_url", "");
        this.aLU = com.baidu.live.d.AZ().getString("ala_game_player_signup_url", null);
        this.aLV = com.baidu.live.d.AZ().getString("ala_game_frs_live_tab_video_url", null);
        Ez();
        this.aMc = com.baidu.live.d.AZ().getString("ala_personal_income_detail_url", null);
        this.aMD = com.baidu.live.d.AZ().getInt("ala_custom_gift_category_id", -1);
        this.aMd = com.baidu.live.d.AZ().getInt("ala_live_pk_switch", 0) == 1;
        this.aMe = com.baidu.live.d.AZ().getLong("ala_live_pk_check_interval", 1000L);
        this.aMf = com.baidu.live.d.AZ().getLong("ala_live_pk_match_timeout", 60000L);
        this.aMg = com.baidu.live.d.AZ().getString("ala_live_pk_pic_url", "");
        this.aMh = com.baidu.live.d.AZ().getString("ala_live_pk_pic_jump_url", "");
        this.aMi = com.baidu.live.d.AZ().getString("ala_live_pk_history_link", "");
        this.aMj = com.baidu.live.d.AZ().getString("show_live_forum_url", "");
        this.aMk = com.baidu.live.d.AZ().getLong("ala_challenge_random_interval", 1000L);
        this.aMl = com.baidu.live.d.AZ().getLong("ala_challenge_direct_interval", 1000L);
        this.aMm = com.baidu.live.d.AZ().getLong("ala_get_challenge_info_interval", 1000L);
        this.aMo = com.baidu.live.d.AZ().getString("ala_challenge_pk_entry_icon_url", "");
        this.aMp = com.baidu.live.d.AZ().getString("ala_challenge_pk_entry_icon_url", "");
        this.aMn = com.baidu.live.d.AZ().getString("ala_challenge_pk_entry_icon_url", "");
        this.aMq = com.baidu.live.d.AZ().getInt("punish_stage_button_switch", 0);
        this.aMr = com.baidu.live.d.AZ().getInt("receive_challenge_im_show_time", 0);
        this.aMs = com.baidu.live.d.AZ().getInt("mvpPunishSwitch", 0);
        this.aMt = com.baidu.live.d.AZ().getInt("toastLifeTime", 10);
        this.aMu = com.baidu.live.d.AZ().getInt("punishLifeTime", 60);
        this.aME = com.baidu.live.d.AZ().getBoolean("ala_guess_use_https", false);
        gr(com.baidu.live.d.AZ().getString("ala_live_bar_map_str", ""));
        this.aMF = com.baidu.live.d.AZ().getBoolean("is_new_live_close_strategy", false);
        this.aMG = com.baidu.live.d.AZ().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aMH = com.baidu.live.d.AZ().getString("ala_feedback_url", null);
        this.aLn = com.baidu.live.d.AZ().getInt("ala_video_resolution_level", 3);
        this.aLo = com.baidu.live.d.AZ().getBoolean("ala_live_hard_encode_switch", true);
        this.aLp = com.baidu.live.d.AZ().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.d.AZ().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.d.AZ().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.d.AZ().getInt("ala_video_increase_count", 3);
        this.aLq = com.baidu.live.d.AZ().getString("ala_video_soft_bitrate_config", null);
        this.aLr = com.baidu.live.d.AZ().getString("ala_video_hard_bitrate_config", null);
        this.aLv = com.baidu.live.d.AZ().getInt("ala_master_chat_video_resolution_level", 3);
        this.aLw = com.baidu.live.d.AZ().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aLs = com.baidu.live.d.AZ().getString("ala_avts_stream_server_domain_config", null);
        this.aLt = com.baidu.live.d.AZ().getString("ala_master_chat_video_bitrate_config", null);
        this.aLu = com.baidu.live.d.AZ().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.d.AZ().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.d.AZ().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aMI = com.baidu.live.d.AZ().getBoolean("key_is_open_login_prove", false);
        this.aMJ = com.baidu.live.d.AZ().getBoolean("key_is_open_diamond", false);
        this.aML = com.baidu.live.d.AZ().getBoolean("key_is_jump_to_live_room", false);
        gp(com.baidu.live.d.AZ().getString("feed_diversion", ""));
        Ey();
    }

    private void gp(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aNk = new AlaFeedDiversionData();
                this.aNk.parserJson(jSONObject);
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

    private void B(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tying_gift_conf");
            if (optJSONObject2 != null) {
                this.aMw = optJSONObject2.optInt("pendant_details_show_times");
                this.aMx = optJSONObject2.optInt("pendant_inform_show_times");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("pksolo");
            if (optJSONObject3 != null) {
                this.aKS = optJSONObject3.toString();
                this.aNw = new bt();
                this.aNw.parse(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject4 != null) {
                this.aKE = optJSONObject4.optString("toast");
                this.aKD = optJSONObject4.optInt("remind_type");
            }
            this.aLc = jSONObject.optString("bluediamond_url");
            com.baidu.live.d.AZ().putString("bluediamond_url", this.aLc);
            this.aKQ = jSONObject.optString("verify_content");
            com.baidu.live.d.AZ().putString("verify_content", this.aKQ);
            this.aKP = jSONObject.optString("live_notice");
            com.baidu.live.d.AZ().putString("live_notice", this.aKP);
            this.aKR = jSONObject.optString("activityNotice");
            com.baidu.live.d.AZ().putString("activity_notice", this.aKR);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aKO.add(i, optString);
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
                        this.aKT.add(i2, optString2);
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
                        this.aKN.add(oVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aKU.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("share_host");
            if (optJSONObject7 != null) {
                this.aLK = optJSONObject7.optString("url");
            } else {
                this.aLK = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject8 != null) {
                this.aLL = optJSONObject8.optString("reward_notice");
                this.aLN = optJSONObject8.optString("reward_rank_notice");
                this.aLM = optJSONObject8.optInt("reward_switch", 2);
            } else {
                this.aLL = "";
                this.aLN = "";
                this.aLM = 2;
            }
            com.baidu.live.d.AZ().putString("share_host", this.aLK);
            com.baidu.live.d.AZ().putString("ala_share_in_bar_notice_text", this.aLL);
            com.baidu.live.d.AZ().putString("ala_share_reward_rank_notice_text", this.aLN);
            com.baidu.live.d.AZ().putInt("ala_share_in_bar_notice_tip_switch", this.aLM);
            JSONObject optJSONObject9 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject9 != null) {
                this.aLd = optJSONObject9.optInt("value");
            } else {
                this.aLd = 60;
            }
            com.baidu.live.d.AZ().putInt("recommend_refresh", this.aLd);
            JSONObject optJSONObject10 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject10 != null) {
                JSONArray optJSONArray5 = optJSONObject10.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.d.AZ().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aKV = g(optJSONArray5);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject11 != null) {
                JSONArray optJSONArray6 = optJSONObject11.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.d.AZ().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aKW = g(optJSONArray6);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject12 != null) {
                this.aLk = optJSONObject12.optString("time_interval");
                this.aLl = optJSONObject12.optInt("exception_interval");
            } else {
                this.aLk = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aLl = 1;
            }
            com.baidu.live.d.AZ().putString("strategy_conf", this.aLk);
            com.baidu.live.d.AZ().putInt("strategy_exception_interval", this.aLl);
            this.aLi = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.d.AZ().putInt("liveStartAuthLevel", this.aLi);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject13 != null) {
                this.aKZ = optJSONObject13.optInt("2gTo");
                if (this.aKZ < 3) {
                    this.aKZ = 3;
                }
                this.aLa = optJSONObject13.optInt("3gTo");
                if (this.aLa < 3) {
                    this.aLa = 3;
                }
                this.aLb = optJSONObject13.optInt("wifiTo");
                if (this.aLb < 3) {
                    this.aLb = 3;
                }
                com.baidu.live.d.AZ().putInt("2gTo", this.aKZ);
                com.baidu.live.d.AZ().putInt("3gTo", this.aLa);
                com.baidu.live.d.AZ().putInt("wifiTo", this.aLb);
            }
            this.aLR = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.d.AZ().putInt("square_tab_strategy", this.aLR);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject14 != null) {
                this.aLS = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                this.aLT = optJSONObject14.optString("flower_rank_rule");
            }
            com.baidu.live.d.AZ().putString("ala_live_ranklist_url", this.aLS);
            com.baidu.live.d.AZ().putString("new_flower_rank_list_description_url", this.aLT);
            JSONObject optJSONObject15 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject15 != null) {
                this.aLU = optJSONObject15.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.d.AZ().putString("ala_game_player_signup_url", this.aLU);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject16 != null) {
                this.aLV = optJSONObject16.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.AZ().putString("ala_game_frs_live_tab_video_url", this.aLV);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject17 != null) {
                this.aLW = optJSONObject17.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.d.AZ().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aLX.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject18 != null) {
                com.baidu.live.d.AZ().putString("ala_live_session_replace_key", optJSONObject18.toString());
                this.aMa = optJSONObject18.optString("hlsUrl");
                this.aLY = optJSONObject18.optString("rtmpUrl");
                this.aLZ = optJSONObject18.optString("flvUrl");
                this.aMb = optJSONObject18.optString(".m3u8");
            }
            b(true, this.aLW);
            JSONObject optJSONObject19 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject19 != null) {
                this.aMc = optJSONObject19.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.AZ().putString("ala_personal_income_detail_url", this.aMc);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject20 != null) {
                this.aMD = optJSONObject20.optInt("android_show");
                com.baidu.live.d.AZ().putInt("ala_custom_gift_category_id", this.aMD);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("pub_show_conf");
            if (optJSONObject21 != null) {
                this.aNA = new cm();
                this.aNA.parserJson(optJSONObject21);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("pub_show_two_conf");
            if (optJSONObject22 != null) {
                this.aNB = new cn();
                this.aNB.parserJson(optJSONObject22);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject23 != null) {
                int optInt = optJSONObject23.optInt("open", 0);
                this.aMd = optInt == 1;
                com.baidu.live.d.AZ().putInt("ala_live_pk_switch", optInt);
                this.aMe = optJSONObject23.optLong("interval");
                if (this.aMe < 1000) {
                    this.aMe = 1000L;
                }
                com.baidu.live.d.AZ().putLong("ala_live_pk_check_interval", this.aMe);
                this.aMf = optJSONObject23.optLong("match_timeout");
                if (this.aMf < 60000) {
                    this.aMf = 60000L;
                }
                com.baidu.live.d.AZ().putLong("ala_live_pk_match_timeout", this.aMf);
                this.aMg = optJSONObject23.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.d.AZ().putString("ala_live_pk_pic_url", this.aMg);
                this.aMh = optJSONObject23.optString("rank_link");
                com.baidu.live.d.AZ().putString("ala_live_pk_pic_jump_url", this.aMh);
                this.aMi = optJSONObject23.optString("history_link");
                com.baidu.live.d.AZ().putString("ala_live_pk_history_link", this.aMi);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject24 != null) {
                this.aMk = optJSONObject24.optLong("random_interval");
                if (this.aMk < 1000) {
                    this.aMk = 1000L;
                }
                com.baidu.live.d.AZ().putLong("ala_challenge_random_interval", this.aMk);
                this.aMl = optJSONObject24.optLong("direct_interval");
                if (this.aMl < 1000) {
                    this.aMl = 1000L;
                }
                com.baidu.live.d.AZ().putLong("ala_challenge_direct_interval", this.aMl);
                this.aMm = optJSONObject24.optLong("challenge_info_interval");
                if (this.aMm < 1000) {
                    this.aMm = 1000L;
                }
                com.baidu.live.d.AZ().putLong("ala_get_challenge_info_interval", this.aMm);
                this.aMo = optJSONObject24.optString("pk_icon_url");
                com.baidu.live.d.AZ().putString("ala_challenge_pk_entry_icon_url", this.aMo);
                this.aMp = optJSONObject24.optString("icon_url");
                com.baidu.live.d.AZ().putString("ala_challenge_pk_entry_icon_url", this.aMp);
                this.aMn = optJSONObject24.optString("rule_url");
                com.baidu.live.d.AZ().putString("ala_challenge_pk_entry_icon_url", this.aMn);
                this.aMq = optJSONObject24.optInt("punish_stage_button_switch");
                com.baidu.live.d.AZ().putInt("punish_stage_button_switch", this.aMq);
                this.aMr = optJSONObject24.optInt("receive_challenge_im_show_time");
                com.baidu.live.d.AZ().putInt("receive_challenge_im_show_time", this.aMr);
                this.aMs = optJSONObject24.optInt("mvpPunishSwitch");
                com.baidu.live.d.AZ().putInt("mvpPunishSwitch", this.aMs);
                this.aMt = optJSONObject24.optInt("toastLifeTime");
                com.baidu.live.d.AZ().putInt("toastLifeTime", this.aMt);
                this.aMu = optJSONObject24.optInt("punishLifeTime");
                com.baidu.live.d.AZ().putInt("punishLifeTime", this.aMu);
                this.aMv = optJSONObject24.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject25 != null) {
                this.aMj = optJSONObject25.optString("go_url");
                com.baidu.live.d.AZ().putString("show_live_forum_url", this.aMj);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject26 != null) {
                this.aME = optJSONObject26.optInt("use_https", 0) == 1;
                com.baidu.live.d.AZ().putBoolean("ala_guess_use_https", this.aME);
            }
            String optString3 = jSONObject.optString("live_bar");
            gr(optString3);
            com.baidu.live.d.AZ().putString("ala_live_bar_map_str", optString3);
            this.aMF = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.d.AZ().putBoolean("is_new_live_close_strategy", this.aMF);
            this.aMG = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.d.AZ().putBoolean("is_new_gift_t_dou_strategy", this.aMG);
            this.aMH = jSONObject.optString("feedback_url");
            com.baidu.live.d.AZ().putString("ala_feedback_url", this.aMH);
            JSONObject optJSONObject27 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject27 != null && (optJSONObject = optJSONObject27.optJSONObject("challenge_related_zip")) != null) {
                this.aMB = optJSONObject.optString("zip_md5");
                this.aMC = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject28 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject28.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject28.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.d.AZ().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.d.AZ().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("open_live");
            if (optJSONObject29 != null) {
                this.increaseThreshold = optJSONObject29.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.d.AZ().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject29.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.d.AZ().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject29.optInt("thi_count", 3);
                com.baidu.live.d.AZ().putInt("ala_video_increase_count", this.increaseCount);
                this.aLo = optJSONObject29.optInt("encoder", 1) == 1;
                com.baidu.live.d.AZ().putBoolean("ala_live_hard_encode_switch", this.aLo);
                this.aLp = optJSONObject29.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.d.AZ().putBoolean("ala_dynamic_bitrate_switch", this.aLp);
                this.aLn = optJSONObject29.optInt("resolution", 3);
                com.baidu.live.d.AZ().putInt("ala_video_resolution_level", this.aLn);
                JSONArray optJSONArray8 = optJSONObject29.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aLq = optJSONArray8.toString();
                    com.baidu.live.d.AZ().putString("ala_video_soft_bitrate_config", this.aLq);
                }
                JSONArray optJSONArray9 = optJSONObject29.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aLr = optJSONArray9.toString();
                    com.baidu.live.d.AZ().putString("ala_video_hard_bitrate_config", this.aLr);
                }
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject30 != null) {
                this.aLs = optJSONObject30.toString();
                com.baidu.live.d.AZ().putString("ala_avts_stream_server_domain_config", this.aLs);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject31 != null) {
                this.aLv = optJSONObject31.optInt("host_rtc_resolution", 3);
                com.baidu.live.d.AZ().putInt("ala_master_chat_video_resolution_level", this.aLv);
                this.aLw = optJSONObject31.optInt("rtc_resolution", 4);
                com.baidu.live.d.AZ().putInt("ala_slave_chat_video_resolution_level", this.aLw);
                JSONArray optJSONArray10 = optJSONObject31.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aLt = optJSONArray10.toString();
                    com.baidu.live.d.AZ().putString("ala_master_chat_video_bitrate_config", this.aLt);
                }
                JSONArray optJSONArray11 = optJSONObject31.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aLu = optJSONArray11.toString();
                    com.baidu.live.d.AZ().putString("ala_slave_chat_video_bitrate_config", this.aLu);
                }
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject32 != null) {
                this.aNp = optJSONObject32.optInt("enter_live_msg_audience_num_p1");
                this.aNq = optJSONObject32.optInt("enter_live_msg_audience_num_p2");
                this.aNr = optJSONObject32.optInt("enter_live_msg_audience_num_p3");
                this.aNn = optJSONObject32.optInt("im_intercept_switch");
                this.aNo = optJSONObject32.optInt("is_check_im_content");
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject33 != null) {
                this.aNk = new AlaFeedDiversionData();
                this.aNk.parserJson(optJSONObject33);
                com.baidu.live.d.AZ().putString("feed_diversion", optJSONObject33.toString());
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject34 != null) {
                com.baidu.live.d.AZ().putString("key_stat_switch", optJSONObject34.toString());
            }
            JSONObject optJSONObject35 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject35 != null) {
                this.aNs = optJSONObject35.optInt("unfold_interval", 5000);
                this.aNt = optJSONObject35.optInt("fold_interval", 55000);
            }
            JSONObject optJSONObject36 = jSONObject.optJSONObject("modify_default_name_conf");
            if (optJSONObject36 != null) {
                this.aNx = new bp();
                this.aNx.parserJson(optJSONObject36);
            }
            JSONObject optJSONObject37 = jSONObject.optJSONObject("audio_live_conf");
            if (optJSONObject37 != null) {
                this.aNy = new bz();
                this.aNy.parse(optJSONObject37);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void C(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aMZ = jSONObject.optInt("im_max", 200);
            if (this.aMZ <= 0) {
                this.aMZ = 200;
            }
            this.aNa = jSONObject.optInt("barrage_max", 100);
            if (this.aNa <= 0) {
                this.aNa = 100;
            }
            this.aNb = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aNb <= 0) {
                this.aNb = 10;
            }
            this.aNc = jSONObject.optInt("enter_effect_max", 10);
            if (this.aNc <= 0) {
                this.aNc = 10;
            }
            this.aNd = jSONObject.optInt("gift_big_max", 10);
            if (this.aNd <= 0) {
                this.aNd = 10;
            }
            this.aNe = jSONObject.optInt("audio_gift_big_max", 15);
            if (this.aNe <= 0) {
                this.aNe = 15;
            }
            this.aNf = jSONObject.optInt("gift_small_max", 50);
            if (this.aNf <= 0) {
                this.aNf = 50;
            }
            this.aNg = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aNg <= 0) {
                this.aNg = 5;
            }
        }
    }

    private void Ew() {
        this.aMM = com.baidu.live.d.AZ().getInt("guide_speak_watch_time", 15000);
        this.aMN = com.baidu.live.d.AZ().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.d.AZ().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aMO = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aMO[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void D(JSONObject jSONObject) {
        int length;
        this.aMM = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.d.AZ().putInt("guide_speak_watch_time", this.aMM);
        this.aMN = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.d.AZ().putInt("guide_speak_show_times_max", this.aMN);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aMO = new String[length];
            for (int i = 0; i < length; i++) {
                this.aMO[i] = optJSONArray.optString(i);
            }
            com.baidu.live.d.AZ().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void Ex() {
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
            this.aMU = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aMU.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void gq(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aMW = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aMW.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aMX = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aMX.add(str3);
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

    private void Ey() {
        gq(com.baidu.live.d.AZ().getString("ala_quick_send_im_list", null));
    }

    private void gr(String str) {
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
        if (i != this.aLW) {
            z2 = true;
        }
        this.aLW = i;
        if (z || z2) {
            com.baidu.live.d.AZ().putInt("ala_live_session_default_key", i);
        }
    }

    private void Ez() {
        this.aLW = com.baidu.live.d.AZ().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.d.AZ().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aLX.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.d.AZ().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aMa = jSONObject.optString("hlsUrl");
                this.aLY = jSONObject.optString("rtmpUrl");
                this.aLZ = jSONObject.optString("flvUrl");
                this.aMb = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean EA() {
        return this.aLP == 1;
    }
}
