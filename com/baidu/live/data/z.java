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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class z extends BaseData {
    public String aAA;
    public String aAC;
    public String aAD;
    public int aAJ;
    public String aAL;
    public String aAM;
    private String aAN;
    private String aAO;
    public int aAP;
    public String aAR;
    public String aAS;
    public String aAT;
    public String aAU;
    public String aAV;
    public boolean aAW;
    public long aAX;
    public long aAY;
    public String aAZ;
    public boolean aAa;
    public boolean aAc;
    public String aAd;
    public int aAe;
    public boolean aAf;
    public int aAg;
    public boolean aAh;
    public boolean aAi;
    public String aAj;
    public String aAk;
    public String aAl;
    public String aAm;
    public String aAn;
    public int aAo;
    public int aAp;
    public boolean aAq;
    public boolean aAr;
    public boolean aAs;
    public boolean aAt;
    public boolean aAu;
    public boolean aAv;
    public boolean aAw;
    public int aBD;
    public int aBE;
    public String[] aBF;
    public int aBG;
    public String aBH;
    public String aBI;
    public QuickImInputData aBJ;
    public List<YuanPackageData> aBK;
    public au aBL;
    public List<String> aBM;
    public List<String> aBN;
    public List<String> aBO;
    public ai aBW;
    public boolean aBX;
    public String aBY;
    public AlaFeedDiversionData aBZ;
    public String aBa;
    public String aBb;
    public String aBc;
    public long aBd;
    public long aBe;
    public long aBf;
    public String aBg;
    public String aBh;
    public String aBi;
    public int aBj;
    public int aBk;
    public int aBl;
    public String aBq;
    public String aBr;
    public String aBs;
    public String aBt;
    public int aBu;
    public String aBy;
    public l aCa;
    public boolean aCb;
    public int aCc;
    public int aCd;
    public aa aCj;
    public boolean azA;
    public boolean azB;
    public boolean azC;
    public boolean azD;
    public boolean azE;
    public String azF;
    public String azG;
    public String azK;
    public String azL;
    public Integer[] azO;
    public Integer[] azP;
    public int azQ;
    public int azS;
    public int azT;
    public int azU;
    public String azV;
    public int azW;
    public boolean azX;
    public boolean azY;
    public boolean azZ;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int azy = -1;
    public String azz = null;
    public int aAb = 1;
    public boolean aAx = true;
    public boolean aAy = false;
    public boolean aAz = false;
    public boolean aAB = false;
    public String aAE = "";
    private int aAF = 2;
    public String aAG = "";
    public int aAH = 1;
    public int aAI = 0;
    public int aAK = 1;
    public List<String> aAQ = new ArrayList();
    public int aBm = 10;
    public int aBn = 60;
    public long aBo = 10000;
    public boolean aBp = false;
    public boolean aBv = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aBw = false;
    public boolean aBx = false;
    public boolean aBz = false;
    public boolean aBA = false;
    public boolean aBB = false;
    public boolean aBC = false;
    public int aBP = 200;
    public int aBQ = 100;
    public int aBR = 10;
    public int aBS = 10;
    public int aBT = 10;
    public int aBU = 50;
    public int aBV = 5;
    public int aCe = 20;
    public int aCf = 70;
    public int aCg = 10000;
    public int aCh = 5000;
    public int aCi = 55000;
    public int aCk = 7;
    public List<String> azJ = new ArrayList();
    public List<String> azR = new ArrayList();
    public List<String> azM = new ArrayList();
    public List<Integer> azN = new ArrayList();
    public ArrayList<i> azH = new ArrayList<>();
    public ArrayList<i> azI = new ArrayList<>();

    public z(boolean z) {
        if (z) {
            wZ();
            this.azQ = com.baidu.live.c.vf().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.vf().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.vf().getInt("restart_time_interval", 300);
            xa();
            wY();
            xb();
            xc();
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
                    v(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject3 != null) {
                    this.azQ = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.vf().putInt("conn_conf", this.azQ);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.azR.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.c.vf().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.c.vf().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    w(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    x(optJSONObject5);
                }
                this.aAC = jSONObject.optString("client_id");
                com.baidu.live.c.vf().putString("client_id", this.aAC);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.azF = optJSONObject6.optString("pic_url");
                    this.azG = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            i iVar = new i();
                            iVar.parseJson(optJSONObject8);
                            this.azH.add(iVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.vf().putString("pic_url", this.azF);
                com.baidu.live.c.vf().putString(BigdayActivityConfig.JUMP_URL, this.azG);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    y(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aBG = optJSONObject10.optInt("resource_switch");
                    this.aBI = optJSONObject10.optString("photo_url");
                    this.aBH = optJSONObject10.optString("resource_url");
                }
                this.aBJ = new QuickImInputData();
                this.aBJ.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aBL = au.z(jSONObject.optJSONObject("guide_follow"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.vf().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject11 != null) {
                    JSONObject optJSONObject12 = optJSONObject11.optJSONObject("rank");
                    if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.c.vf().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.c.vf().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.c.vf().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject13 = optJSONObject11.optJSONObject("guard_seat");
                    if (optJSONObject13 != null) {
                        this.aBY = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aBW = new ai();
                    this.aBW.aCW = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.c.vf().putString("ala_certify_refuse_url", this.aBW.aCW);
                }
                this.aCj = new aa();
                this.aCj.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aCa = new l();
                    this.aCa.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aCk = optJSONObject16.optInt("show_days");
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.vf().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void wY() {
        String string = com.baidu.live.c.vf().getString("ala_prepare_random_title_list", "");
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
            this.aBO = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aBO.add(jSONArray.optString(i));
            }
        }
    }

    private void wZ() {
        this.azA = com.baidu.live.c.vf().getBoolean("map_around_map", false);
        this.aAf = com.baidu.live.c.vf().getBoolean("withdraw_switch", true);
        this.aAA = com.baidu.live.c.vf().getString("withdraw_text", "");
        this.aAt = com.baidu.live.c.vf().getBoolean("use_internal_player_switch", true);
        this.aAq = com.baidu.live.c.vf().getBoolean("use_http_dns_switch", true);
        this.aAr = com.baidu.live.c.vf().getBoolean("use_encode_bframe_switch", false);
        this.aAs = com.baidu.live.c.vf().getBoolean("enable_opt_timestamp_switch", true);
        this.aAu = com.baidu.live.c.vf().getBoolean("live_beauty_open_switch", false);
        this.aAv = com.baidu.live.c.vf().getBoolean("live_unity_beauty_switch", true);
        this.aAw = com.baidu.live.c.vf().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aAx = com.baidu.live.c.vf().getBoolean("sp_key_live_game_hard_encode", true);
        this.aAy = com.baidu.live.c.vf().getBoolean("sp_key_live_play_transcode_support", false);
        this.aAz = com.baidu.live.c.vf().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aAB = com.baidu.live.c.vf().getBoolean("ala_enable_graffiti_str", false);
        this.azB = com.baidu.live.c.vf().getBoolean("enter_live", false);
        this.azC = com.baidu.live.c.vf().getBoolean("sync_to_forum", true);
        this.azD = com.baidu.live.c.vf().getBoolean("show_water_mark", false);
        this.azE = com.baidu.live.c.vf().getBoolean("show_third_part_water_mark_switch", false);
        this.azX = com.baidu.live.c.vf().getBoolean("stream_error_log", true);
        this.azY = com.baidu.live.c.vf().getBoolean("disable_channel_in", true);
        this.azZ = com.baidu.live.c.vf().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aAa = com.baidu.live.c.vf().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aAc = com.baidu.live.c.vf().getBoolean("follow_default_push_switch", true);
        this.aAJ = com.baidu.live.c.vf().getInt("to_tb_some_switch", 0);
        this.aAH = com.baidu.live.c.vf().getInt("enable_live_stat", 1);
        this.aAI = com.baidu.live.c.vf().getInt("ala_free_gift_task_switch", 0);
        this.aBp = com.baidu.live.c.vf().getBoolean("live_challenge_switch", false);
        this.aBq = com.baidu.live.c.vf().getString("live_challenge_tip", null);
        this.aBr = com.baidu.live.c.vf().getString("live_challenge_url", null);
    }

    private void v(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.azA = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.vf().putBoolean("map_around_map", this.azA);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aAf = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("withdraw_switch", this.aAf);
                this.aAA = optJSONObject2.optString("text");
                com.baidu.live.c.vf().putString("withdraw_text", this.aAA);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aAt = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("use_internal_player_switch", this.aAt);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aAq = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("use_http_dns_switch", this.aAq);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aAr = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("use_encode_bframe_switch", this.aAr);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aAs = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("enable_opt_timestamp_switch", this.aAs);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.aAu = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("live_beauty_open_switch", this.aAu);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.aAv = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("live_unity_beauty_switch", this.aAv);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.aAw = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("live_unity_beauty_face_style_switch", this.aAw);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.aAx = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("sp_key_live_game_hard_encode", this.aAx);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.aAy = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("sp_key_live_play_transcode_support", this.aAy);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.aAz = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("sp_key_live_play_attention_guide_support", this.aAz);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.azB = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("enter_live", this.azB);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.azC = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean("sync_to_forum", this.azC);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.azD = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean("show_water_mark", this.azD);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.azE = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean("show_third_part_water_mark_switch", this.azE);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.aAH = optJSONObject17.optInt("switch");
                com.baidu.live.c.vf().putInt("enable_live_stat", this.aAH);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.azX = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("stream_error_log", this.azX);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.azY = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean("disable_channel_in", this.azY);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.azZ = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean("shoubai_yanzhi_tab_tip", this.azZ);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.aAa = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aAa);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.aAc = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.c.vf().putBoolean("follow_default_push_switch", this.aAc);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.aAJ = optJSONObject23.optInt("switch");
                com.baidu.live.c.vf().putInt("to_tb_some_switch", this.aAJ);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.aAI = optJSONObject24.optInt("switch");
                com.baidu.live.c.vf().putInt("ala_free_gift_task_switch", this.aAJ);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.aAB = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("ala_enable_graffiti_str", this.aAB);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aBp = optJSONObject26.optInt("switch") == 1;
                this.aBq = optJSONObject26.optString("title");
                this.aBr = optJSONObject26.optString("url");
                com.baidu.live.c.vf().putBoolean("live_challenge_switch", this.aBp);
                com.baidu.live.c.vf().putString("live_challenge_tip", this.aBq);
                com.baidu.live.c.vf().putString("live_challenge_url", this.aBr);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aBx = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("is_new_gift_t_dou_strategy", this.aBx);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aBB = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aBz = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("key_is_open_login_prove", this.aBz);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aBA = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("key_is_open_diamond", this.aBA);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aBC = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("key_is_jump_to_live_room", this.aBC);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aBX = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aCb = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void xa() {
        JSONArray jSONArray;
        this.azV = com.baidu.live.c.vf().getString("bluediamond_url", "");
        this.azL = com.baidu.live.c.vf().getString("verify_content", this.azL);
        this.azK = com.baidu.live.c.vf().getString("live_notice", "");
        String string = com.baidu.live.c.vf().getString("imNotice", "");
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
                        this.azJ.add(i, optString);
                    }
                }
            }
        }
        this.aAD = com.baidu.live.c.vf().getString("share_host", "");
        this.aAE = com.baidu.live.c.vf().getString("ala_share_in_bar_notice_text", "");
        this.aAG = com.baidu.live.c.vf().getString("ala_share_reward_rank_notice_text", "");
        this.aAF = com.baidu.live.c.vf().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.azW = com.baidu.live.c.vf().getInt("recommend_refresh", 60);
        this.aAd = com.baidu.live.c.vf().getString("strategy_conf", "300");
        this.aAe = com.baidu.live.c.vf().getInt("strategy_exception_interval", 1);
        this.aAb = com.baidu.live.c.vf().getInt("liveStartAuthLevel", 1);
        this.azS = com.baidu.live.c.vf().getInt("2gTo", 5);
        this.azT = com.baidu.live.c.vf().getInt("3gTo", 3);
        this.azU = com.baidu.live.c.vf().getInt("wifiTo", 3);
        String string2 = com.baidu.live.c.vf().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.azO = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.c.vf().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.azP = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aAK = com.baidu.live.c.vf().getInt("square_tab_strategy", 1);
        this.aAL = com.baidu.live.c.vf().getString("ala_live_ranklist_url", null);
        this.aAM = com.baidu.live.c.vf().getString("new_flower_rank_list_description_url", "");
        this.aAN = com.baidu.live.c.vf().getString("ala_game_player_signup_url", null);
        this.aAO = com.baidu.live.c.vf().getString("ala_game_frs_live_tab_video_url", null);
        xe();
        this.aAV = com.baidu.live.c.vf().getString("ala_personal_income_detail_url", null);
        this.aBu = com.baidu.live.c.vf().getInt("ala_custom_gift_category_id", -1);
        this.aAW = com.baidu.live.c.vf().getInt("ala_live_pk_switch", 0) == 1;
        this.aAX = com.baidu.live.c.vf().getLong("ala_live_pk_check_interval", 1000L);
        this.aAY = com.baidu.live.c.vf().getLong("ala_live_pk_match_timeout", 60000L);
        this.aAZ = com.baidu.live.c.vf().getString("ala_live_pk_pic_url", "");
        this.aBa = com.baidu.live.c.vf().getString("ala_live_pk_pic_jump_url", "");
        this.aBb = com.baidu.live.c.vf().getString("ala_live_pk_history_link", "");
        this.aBc = com.baidu.live.c.vf().getString("show_live_forum_url", "");
        this.aBd = com.baidu.live.c.vf().getLong("ala_challenge_random_interval", 1000L);
        this.aBe = com.baidu.live.c.vf().getLong("ala_challenge_direct_interval", 1000L);
        this.aBf = com.baidu.live.c.vf().getLong("ala_get_challenge_info_interval", 1000L);
        this.aBh = com.baidu.live.c.vf().getString("ala_challenge_pk_entry_icon_url", "");
        this.aBi = com.baidu.live.c.vf().getString("ala_challenge_pk_entry_icon_url", "");
        this.aBg = com.baidu.live.c.vf().getString("ala_challenge_pk_entry_icon_url", "");
        this.aBj = com.baidu.live.c.vf().getInt("punish_stage_button_switch", 0);
        this.aBk = com.baidu.live.c.vf().getInt("receive_challenge_im_show_time", 0);
        this.aBl = com.baidu.live.c.vf().getInt("mvpPunishSwitch", 0);
        this.aBm = com.baidu.live.c.vf().getInt("toastLifeTime", 10);
        this.aBn = com.baidu.live.c.vf().getInt("punishLifeTime", 60);
        this.aBv = com.baidu.live.c.vf().getBoolean("ala_guess_use_https", false);
        ey(com.baidu.live.c.vf().getString("ala_live_bar_map_str", ""));
        this.aBw = com.baidu.live.c.vf().getBoolean("is_new_live_close_strategy", false);
        this.aBx = com.baidu.live.c.vf().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aBy = com.baidu.live.c.vf().getString("ala_feedback_url", null);
        this.aAg = com.baidu.live.c.vf().getInt("ala_video_resolution_level", 3);
        this.aAh = com.baidu.live.c.vf().getBoolean("ala_live_hard_encode_switch", true);
        this.aAi = com.baidu.live.c.vf().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.vf().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.vf().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.vf().getInt("ala_video_increase_count", 3);
        this.aAj = com.baidu.live.c.vf().getString("ala_video_soft_bitrate_config", null);
        this.aAk = com.baidu.live.c.vf().getString("ala_video_hard_bitrate_config", null);
        this.aAo = com.baidu.live.c.vf().getInt("ala_master_chat_video_resolution_level", 3);
        this.aAp = com.baidu.live.c.vf().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aAl = com.baidu.live.c.vf().getString("ala_avts_stream_server_domain_config", null);
        this.aAm = com.baidu.live.c.vf().getString("ala_master_chat_video_bitrate_config", null);
        this.aAn = com.baidu.live.c.vf().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.vf().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.vf().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aBz = com.baidu.live.c.vf().getBoolean("key_is_open_login_prove", false);
        this.aBA = com.baidu.live.c.vf().getBoolean("key_is_open_diamond", false);
        this.aBC = com.baidu.live.c.vf().getBoolean("key_is_jump_to_live_room", false);
        ew(com.baidu.live.c.vf().getString("feed_diversion", ""));
        xd();
    }

    private void ew(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aBZ = new AlaFeedDiversionData();
                this.aBZ.parserJson(jSONObject);
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

    private void w(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject2 != null) {
                this.azz = optJSONObject2.optString("toast");
                this.azy = optJSONObject2.optInt("remind_type");
            }
            this.azV = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.vf().putString("bluediamond_url", this.azV);
            this.azL = jSONObject.optString("verify_content");
            com.baidu.live.c.vf().putString("verify_content", this.azL);
            this.azK = jSONObject.optString("live_notice");
            com.baidu.live.c.vf().putString("live_notice", this.azK);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.azJ.add(i, optString);
                    }
                }
                com.baidu.live.c.vf().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.c.vf().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.azM.add(i2, optString2);
                    }
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("bd_live_activity");
            if (optJSONObject3 != null && (optJSONArray = optJSONObject3.optJSONArray("main_page")) != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject4 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject4 != null) {
                        i iVar = new i();
                        iVar.parseJson(optJSONObject4);
                        this.azI.add(iVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.azN.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.aAD = optJSONObject5.optString("url");
            } else {
                this.aAD = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.aAE = optJSONObject6.optString("reward_notice");
                this.aAG = optJSONObject6.optString("reward_rank_notice");
                this.aAF = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.aAE = "";
                this.aAG = "";
                this.aAF = 2;
            }
            com.baidu.live.c.vf().putString("share_host", this.aAD);
            com.baidu.live.c.vf().putString("ala_share_in_bar_notice_text", this.aAE);
            com.baidu.live.c.vf().putString("ala_share_reward_rank_notice_text", this.aAG);
            com.baidu.live.c.vf().putInt("ala_share_in_bar_notice_tip_switch", this.aAF);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.azW = optJSONObject7.optInt("value");
            } else {
                this.azW = 60;
            }
            com.baidu.live.c.vf().putInt("recommend_refresh", this.azW);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.vf().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.azO = g(optJSONArray5);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject9 != null) {
                JSONArray optJSONArray6 = optJSONObject9.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.vf().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.azP = g(optJSONArray6);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject10 != null) {
                this.aAd = optJSONObject10.optString("time_interval");
                this.aAe = optJSONObject10.optInt("exception_interval");
            } else {
                this.aAd = "300";
                this.aAe = 1;
            }
            com.baidu.live.c.vf().putString("strategy_conf", this.aAd);
            com.baidu.live.c.vf().putInt("strategy_exception_interval", this.aAe);
            this.aAb = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.vf().putInt("liveStartAuthLevel", this.aAb);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject11 != null) {
                this.azS = optJSONObject11.optInt("2gTo");
                if (this.azS < 3) {
                    this.azS = 3;
                }
                this.azT = optJSONObject11.optInt("3gTo");
                if (this.azT < 3) {
                    this.azT = 3;
                }
                this.azU = optJSONObject11.optInt("wifiTo");
                if (this.azU < 3) {
                    this.azU = 3;
                }
                com.baidu.live.c.vf().putInt("2gTo", this.azS);
                com.baidu.live.c.vf().putInt("3gTo", this.azT);
                com.baidu.live.c.vf().putInt("wifiTo", this.azU);
            }
            this.aAK = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.vf().putInt("square_tab_strategy", this.aAK);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject12 != null) {
                this.aAL = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
                this.aAM = optJSONObject12.optString("flower_rank_rule");
            }
            com.baidu.live.c.vf().putString("ala_live_ranklist_url", this.aAL);
            com.baidu.live.c.vf().putString("new_flower_rank_list_description_url", this.aAM);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject13 != null) {
                this.aAN = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.vf().putString("ala_game_player_signup_url", this.aAN);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject14 != null) {
                this.aAO = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.vf().putString("ala_game_frs_live_tab_video_url", this.aAO);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject15 != null) {
                this.aAP = optJSONObject15.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.vf().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aAQ.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject16 != null) {
                com.baidu.live.c.vf().putString("ala_live_session_replace_key", optJSONObject16.toString());
                this.aAT = optJSONObject16.optString("hlsUrl");
                this.aAR = optJSONObject16.optString("rtmpUrl");
                this.aAS = optJSONObject16.optString("flvUrl");
                this.aAU = optJSONObject16.optString(".m3u8");
            }
            b(true, this.aAP);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject17 != null) {
                this.aAV = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.vf().putString("ala_personal_income_detail_url", this.aAV);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject18 != null) {
                this.aBu = optJSONObject18.optInt("android_show");
                com.baidu.live.c.vf().putInt("ala_custom_gift_category_id", this.aBu);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject19 != null) {
                int optInt = optJSONObject19.optInt("open", 0);
                this.aAW = optInt == 1;
                com.baidu.live.c.vf().putInt("ala_live_pk_switch", optInt);
                this.aAX = optJSONObject19.optLong("interval");
                if (this.aAX < 1000) {
                    this.aAX = 1000L;
                }
                com.baidu.live.c.vf().putLong("ala_live_pk_check_interval", this.aAX);
                this.aAY = optJSONObject19.optLong("match_timeout");
                if (this.aAY < 60000) {
                    this.aAY = 60000L;
                }
                com.baidu.live.c.vf().putLong("ala_live_pk_match_timeout", this.aAY);
                this.aAZ = optJSONObject19.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.vf().putString("ala_live_pk_pic_url", this.aAZ);
                this.aBa = optJSONObject19.optString("rank_link");
                com.baidu.live.c.vf().putString("ala_live_pk_pic_jump_url", this.aBa);
                this.aBb = optJSONObject19.optString("history_link");
                com.baidu.live.c.vf().putString("ala_live_pk_history_link", this.aBb);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject20 != null) {
                this.aBd = optJSONObject20.optLong("random_interval");
                if (this.aBd < 1000) {
                    this.aBd = 1000L;
                }
                com.baidu.live.c.vf().putLong("ala_challenge_random_interval", this.aBd);
                this.aBe = optJSONObject20.optLong("direct_interval");
                if (this.aBe < 1000) {
                    this.aBe = 1000L;
                }
                com.baidu.live.c.vf().putLong("ala_challenge_direct_interval", this.aBe);
                this.aBf = optJSONObject20.optLong("challenge_info_interval");
                if (this.aBf < 1000) {
                    this.aBf = 1000L;
                }
                com.baidu.live.c.vf().putLong("ala_get_challenge_info_interval", this.aBf);
                this.aBh = optJSONObject20.optString("pk_icon_url");
                com.baidu.live.c.vf().putString("ala_challenge_pk_entry_icon_url", this.aBh);
                this.aBi = optJSONObject20.optString("icon_url");
                com.baidu.live.c.vf().putString("ala_challenge_pk_entry_icon_url", this.aBi);
                this.aBg = optJSONObject20.optString("rule_url");
                com.baidu.live.c.vf().putString("ala_challenge_pk_entry_icon_url", this.aBg);
                this.aBj = optJSONObject20.optInt("punish_stage_button_switch");
                com.baidu.live.c.vf().putInt("punish_stage_button_switch", this.aBj);
                this.aBk = optJSONObject20.optInt("receive_challenge_im_show_time");
                com.baidu.live.c.vf().putInt("receive_challenge_im_show_time", this.aBk);
                this.aBl = optJSONObject20.optInt("mvpPunishSwitch");
                com.baidu.live.c.vf().putInt("mvpPunishSwitch", this.aBl);
                this.aBm = optJSONObject20.optInt("toastLifeTime");
                com.baidu.live.c.vf().putInt("toastLifeTime", this.aBm);
                this.aBn = optJSONObject20.optInt("punishLifeTime");
                com.baidu.live.c.vf().putInt("punishLifeTime", this.aBn);
                this.aBo = optJSONObject20.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject21 != null) {
                this.aBc = optJSONObject21.optString("go_url");
                com.baidu.live.c.vf().putString("show_live_forum_url", this.aBc);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject22 != null) {
                this.aBv = optJSONObject22.optInt("use_https", 0) == 1;
                com.baidu.live.c.vf().putBoolean("ala_guess_use_https", this.aBv);
            }
            String optString3 = jSONObject.optString("live_bar");
            ey(optString3);
            com.baidu.live.c.vf().putString("ala_live_bar_map_str", optString3);
            this.aBw = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.vf().putBoolean("is_new_live_close_strategy", this.aBw);
            this.aBx = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.vf().putBoolean("is_new_gift_t_dou_strategy", this.aBx);
            this.aBy = jSONObject.optString("feedback_url");
            com.baidu.live.c.vf().putString("ala_feedback_url", this.aBy);
            JSONObject optJSONObject23 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject23 != null && (optJSONObject = optJSONObject23.optJSONObject("challenge_related_zip")) != null) {
                this.aBs = optJSONObject.optString("zip_md5");
                this.aBt = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject24 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject24.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject24.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.vf().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.vf().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("open_live");
            if (optJSONObject25 != null) {
                this.increaseThreshold = optJSONObject25.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.vf().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject25.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.vf().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject25.optInt("thi_count", 3);
                com.baidu.live.c.vf().putInt("ala_video_increase_count", this.increaseCount);
                this.aAh = optJSONObject25.optInt("encoder", 1) == 1;
                com.baidu.live.c.vf().putBoolean("ala_live_hard_encode_switch", this.aAh);
                this.aAi = optJSONObject25.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.vf().putBoolean("ala_dynamic_bitrate_switch", this.aAi);
                this.aAg = optJSONObject25.optInt("resolution", 3);
                com.baidu.live.c.vf().putInt("ala_video_resolution_level", this.aAg);
                JSONArray optJSONArray8 = optJSONObject25.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aAj = optJSONArray8.toString();
                    com.baidu.live.c.vf().putString("ala_video_soft_bitrate_config", this.aAj);
                }
                JSONArray optJSONArray9 = optJSONObject25.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aAk = optJSONArray9.toString();
                    com.baidu.live.c.vf().putString("ala_video_hard_bitrate_config", this.aAk);
                }
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject26 != null) {
                this.aAl = optJSONObject26.toString();
                com.baidu.live.c.vf().putString("ala_avts_stream_server_domain_config", this.aAl);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject27 != null) {
                this.aAo = optJSONObject27.optInt("host_rtc_resolution", 3);
                com.baidu.live.c.vf().putInt("ala_master_chat_video_resolution_level", this.aAo);
                this.aAp = optJSONObject27.optInt("rtc_resolution", 4);
                com.baidu.live.c.vf().putInt("ala_slave_chat_video_resolution_level", this.aAp);
                JSONArray optJSONArray10 = optJSONObject27.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aAm = optJSONArray10.toString();
                    com.baidu.live.c.vf().putString("ala_master_chat_video_bitrate_config", this.aAm);
                }
                JSONArray optJSONArray11 = optJSONObject27.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aAn = optJSONArray11.toString();
                    com.baidu.live.c.vf().putString("ala_slave_chat_video_bitrate_config", this.aAn);
                }
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject28 != null) {
                this.aCe = optJSONObject28.optInt("enter_live_msg_audience_num_p1");
                this.aCf = optJSONObject28.optInt("enter_live_msg_audience_num_p2");
                this.aCg = optJSONObject28.optInt("enter_live_msg_audience_num_p3");
                this.aCc = optJSONObject28.optInt("im_intercept_switch");
                this.aCd = optJSONObject28.optInt("is_check_im_content");
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject29 != null) {
                this.aBZ = new AlaFeedDiversionData();
                this.aBZ.parserJson(optJSONObject29);
                com.baidu.live.c.vf().putString("feed_diversion", optJSONObject29.toString());
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject30 != null) {
                com.baidu.live.c.vf().putString("key_stat_switch", optJSONObject30.toString());
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject31 != null) {
                this.aCh = optJSONObject31.optInt("unfold_interval", 5000);
                this.aCi = optJSONObject31.optInt("fold_interval", 55000);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void x(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBP = jSONObject.optInt("im_max", 200);
            if (this.aBP <= 0) {
                this.aBP = 200;
            }
            this.aBQ = jSONObject.optInt("barrage_max", 100);
            if (this.aBQ <= 0) {
                this.aBQ = 100;
            }
            this.aBR = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aBR <= 0) {
                this.aBR = 10;
            }
            this.aBS = jSONObject.optInt("enter_effect_max", 10);
            if (this.aBS <= 0) {
                this.aBS = 10;
            }
            this.aBT = jSONObject.optInt("gift_big_max", 10);
            if (this.aBT <= 0) {
                this.aBT = 10;
            }
            this.aBU = jSONObject.optInt("gift_small_max", 50);
            if (this.aBU <= 0) {
                this.aBU = 50;
            }
            this.aBV = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aBV <= 0) {
                this.aBV = 5;
            }
        }
    }

    private void xb() {
        this.aBD = com.baidu.live.c.vf().getInt("guide_speak_watch_time", 15000);
        this.aBE = com.baidu.live.c.vf().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.vf().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aBF = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aBF[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void y(JSONObject jSONObject) {
        int length;
        this.aBD = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.c.vf().putInt("guide_speak_watch_time", this.aBD);
        this.aBE = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.vf().putInt("guide_speak_show_times_max", this.aBE);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aBF = new String[length];
            for (int i = 0; i < length; i++) {
                this.aBF[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.vf().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void xc() {
        String string = com.baidu.live.c.vf().getString("yuan_package_data", "");
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
            this.aBK = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aBK.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void ex(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aBM = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aBM.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aBN = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aBN.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.vf().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void xd() {
        ex(com.baidu.live.c.vf().getString("ala_quick_send_im_list", null));
    }

    private void ey(String str) {
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
        if (i != this.aAP) {
            z2 = true;
        }
        this.aAP = i;
        if (z || z2) {
            com.baidu.live.c.vf().putInt("ala_live_session_default_key", i);
        }
    }

    private void xe() {
        this.aAP = com.baidu.live.c.vf().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.vf().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aAQ.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.vf().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aAT = jSONObject.optString("hlsUrl");
                this.aAR = jSONObject.optString("rtmpUrl");
                this.aAS = jSONObject.optString("flvUrl");
                this.aAU = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean xf() {
        return this.aAI == 1;
    }
}
