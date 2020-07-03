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
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public class z extends BaseData {
    public List<String> aAA;
    public List<String> aAB;
    public ah aAJ;
    public boolean aAK;
    public String aAL;
    public AlaFeedDiversionData aAM;
    public l aAN;
    public boolean aAO;
    public int aAP;
    public int aAQ;
    public aa aAW;
    public String aAd;
    public String aAe;
    public String aAf;
    public String aAg;
    public int aAh;
    public String aAl;
    public int aAq;
    public int aAr;
    public String[] aAs;
    public int aAt;
    public String aAu;
    public String aAv;
    public QuickImInputData aAw;
    public List<YuanPackageData> aAx;
    public at aAy;
    public List<String> aAz;
    public Integer[] ayB;
    public Integer[] ayC;
    public int ayD;
    public int ayF;
    public int ayG;
    public int ayH;
    public String ayI;
    public int ayJ;
    public boolean ayK;
    public boolean ayL;
    public boolean ayM;
    public boolean ayN;
    public boolean ayP;
    public String ayQ;
    public int ayR;
    public boolean ayS;
    public int ayT;
    public boolean ayU;
    public boolean ayV;
    public String ayW;
    public String ayX;
    public String ayY;
    public String ayZ;
    public boolean ayn;
    public boolean ayo;
    public boolean ayp;
    public boolean ayq;
    public boolean ayr;
    public String ays;
    public String ayt;
    public String ayx;
    public String ayy;
    private String azA;
    private String azB;
    public int azC;
    public String azE;
    public String azF;
    public String azG;
    public String azH;
    public String azI;
    public boolean azJ;
    public long azK;
    public long azL;
    public String azM;
    public String azN;
    public String azO;
    public String azP;
    public long azQ;
    public long azR;
    public long azS;
    public String azT;
    public String azU;
    public String azV;
    public int azW;
    public int azX;
    public int azY;
    public String aza;
    public int azb;
    public int azc;
    public boolean azd;
    public boolean aze;
    public boolean azf;
    public boolean azg;
    public boolean azh;
    public boolean azi;
    public boolean azj;
    public String azn;
    public String azp;
    public String azq;
    public int azw;
    public String azy;
    public String azz;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int ayl = -1;
    public String aym = null;
    public int ayO = 1;
    public boolean azk = true;
    public boolean azl = false;
    public boolean azm = false;
    public boolean azo = false;
    public String azr = "";
    private int azs = 2;
    public String azt = "";
    public int azu = 1;
    public int azv = 0;
    public int azx = 1;
    public List<String> azD = new ArrayList();
    public int azZ = 10;
    public int aAa = 60;
    public long aAb = 10000;
    public boolean aAc = false;
    public boolean aAi = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aAj = false;
    public boolean aAk = false;
    public boolean aAm = false;
    public boolean aAn = false;
    public boolean aAo = false;
    public boolean aAp = false;
    public int aAC = 200;
    public int aAD = 100;
    public int aAE = 10;
    public int aAF = 10;
    public int aAG = 10;
    public int aAH = 50;
    public int aAI = 5;
    public int aAR = 20;
    public int aAS = 70;
    public int aAT = 10000;
    public int aAU = 5000;
    public int aAV = 55000;
    public int aAX = 7;
    public List<String> ayw = new ArrayList();
    public List<String> ayE = new ArrayList();
    public List<String> ayz = new ArrayList();
    public List<Integer> ayA = new ArrayList();
    public ArrayList<i> ayu = new ArrayList<>();
    public ArrayList<i> ayv = new ArrayList<>();

    public z(boolean z) {
        if (z) {
            wx();
            this.ayD = com.baidu.live.c.vf().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.vf().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.vf().getInt("restart_time_interval", 300);
            wy();
            ww();
            wz();
            wA();
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
                    this.ayD = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.vf().putInt("conn_conf", this.ayD);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.ayE.add(i, optString);
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
                this.azp = jSONObject.optString("client_id");
                com.baidu.live.c.vf().putString("client_id", this.azp);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.ays = optJSONObject6.optString("pic_url");
                    this.ayt = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            i iVar = new i();
                            iVar.parseJson(optJSONObject8);
                            this.ayu.add(iVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.vf().putString("pic_url", this.ays);
                com.baidu.live.c.vf().putString(BigdayActivityConfig.JUMP_URL, this.ayt);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    y(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aAt = optJSONObject10.optInt("resource_switch");
                    this.aAv = optJSONObject10.optString("photo_url");
                    this.aAu = optJSONObject10.optString("resource_url");
                }
                this.aAw = new QuickImInputData();
                this.aAw.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aAy = at.z(jSONObject.optJSONObject("guide_follow"));
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
                        this.aAL = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aAJ = new ah();
                    this.aAJ.aBB = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.c.vf().putString("ala_certify_refuse_url", this.aAJ.aBB);
                }
                this.aAW = new aa();
                this.aAW.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aAN = new l();
                    this.aAN.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aAX = optJSONObject16.optInt("show_days");
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

    private void ww() {
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
            this.aAB = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aAB.add(jSONArray.optString(i));
            }
        }
    }

    private void wx() {
        this.ayn = com.baidu.live.c.vf().getBoolean("map_around_map", false);
        this.ayS = com.baidu.live.c.vf().getBoolean("withdraw_switch", true);
        this.azn = com.baidu.live.c.vf().getString("withdraw_text", "");
        this.azg = com.baidu.live.c.vf().getBoolean("use_internal_player_switch", true);
        this.azd = com.baidu.live.c.vf().getBoolean("use_http_dns_switch", true);
        this.aze = com.baidu.live.c.vf().getBoolean("use_encode_bframe_switch", false);
        this.azf = com.baidu.live.c.vf().getBoolean("enable_opt_timestamp_switch", true);
        this.azh = com.baidu.live.c.vf().getBoolean("live_beauty_open_switch", false);
        this.azi = com.baidu.live.c.vf().getBoolean("live_unity_beauty_switch", true);
        this.azj = com.baidu.live.c.vf().getBoolean("live_unity_beauty_face_style_switch", true);
        this.azk = com.baidu.live.c.vf().getBoolean("sp_key_live_game_hard_encode", true);
        this.azl = com.baidu.live.c.vf().getBoolean("sp_key_live_play_transcode_support", false);
        this.azm = com.baidu.live.c.vf().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.azo = com.baidu.live.c.vf().getBoolean("ala_enable_graffiti_str", false);
        this.ayo = com.baidu.live.c.vf().getBoolean("enter_live", false);
        this.ayp = com.baidu.live.c.vf().getBoolean("sync_to_forum", true);
        this.ayq = com.baidu.live.c.vf().getBoolean("show_water_mark", false);
        this.ayr = com.baidu.live.c.vf().getBoolean("show_third_part_water_mark_switch", false);
        this.ayK = com.baidu.live.c.vf().getBoolean("stream_error_log", true);
        this.ayL = com.baidu.live.c.vf().getBoolean("disable_channel_in", true);
        this.ayM = com.baidu.live.c.vf().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.ayN = com.baidu.live.c.vf().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.ayP = com.baidu.live.c.vf().getBoolean("follow_default_push_switch", true);
        this.azw = com.baidu.live.c.vf().getInt("to_tb_some_switch", 0);
        this.azu = com.baidu.live.c.vf().getInt("enable_live_stat", 1);
        this.azv = com.baidu.live.c.vf().getInt("ala_free_gift_task_switch", 0);
        this.aAc = com.baidu.live.c.vf().getBoolean("live_challenge_switch", false);
        this.aAd = com.baidu.live.c.vf().getString("live_challenge_tip", null);
        this.aAe = com.baidu.live.c.vf().getString("live_challenge_url", null);
    }

    private void v(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.ayn = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.vf().putBoolean("map_around_map", this.ayn);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.ayS = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("withdraw_switch", this.ayS);
                this.azn = optJSONObject2.optString("text");
                com.baidu.live.c.vf().putString("withdraw_text", this.azn);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.azg = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("use_internal_player_switch", this.azg);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.azd = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("use_http_dns_switch", this.azd);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aze = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("use_encode_bframe_switch", this.aze);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.azf = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("enable_opt_timestamp_switch", this.azf);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.azh = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("live_beauty_open_switch", this.azh);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.azi = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("live_unity_beauty_switch", this.azi);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.azj = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("live_unity_beauty_face_style_switch", this.azj);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.azk = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("sp_key_live_game_hard_encode", this.azk);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.azl = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("sp_key_live_play_transcode_support", this.azl);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.azm = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("sp_key_live_play_attention_guide_support", this.azm);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.ayo = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("enter_live", this.ayo);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.ayp = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean("sync_to_forum", this.ayp);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.ayq = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean("show_water_mark", this.ayq);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.ayr = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean("show_third_part_water_mark_switch", this.ayr);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.azu = optJSONObject17.optInt("switch");
                com.baidu.live.c.vf().putInt("enable_live_stat", this.azu);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.ayK = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("stream_error_log", this.ayK);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.ayL = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean("disable_channel_in", this.ayL);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.ayM = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean("shoubai_yanzhi_tab_tip", this.ayM);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.ayN = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.c.vf().putBoolean(ActionJsonData.TAG_SIGN_IN, this.ayN);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.ayP = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.c.vf().putBoolean("follow_default_push_switch", this.ayP);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.azw = optJSONObject23.optInt("switch");
                com.baidu.live.c.vf().putInt("to_tb_some_switch", this.azw);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.azv = optJSONObject24.optInt("switch");
                com.baidu.live.c.vf().putInt("ala_free_gift_task_switch", this.azw);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.azo = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("ala_enable_graffiti_str", this.azo);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aAc = optJSONObject26.optInt("switch") == 1;
                this.aAd = optJSONObject26.optString("title");
                this.aAe = optJSONObject26.optString("url");
                com.baidu.live.c.vf().putBoolean("live_challenge_switch", this.aAc);
                com.baidu.live.c.vf().putString("live_challenge_tip", this.aAd);
                com.baidu.live.c.vf().putString("live_challenge_url", this.aAe);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aAk = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("is_new_gift_t_dou_strategy", this.aAk);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aAo = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aAm = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("key_is_open_login_prove", this.aAm);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aAn = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("key_is_open_diamond", this.aAn);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aAp = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.c.vf().putBoolean("key_is_jump_to_live_room", this.aAp);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aAK = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aAO = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void wy() {
        JSONArray jSONArray;
        this.ayI = com.baidu.live.c.vf().getString("bluediamond_url", "");
        this.ayy = com.baidu.live.c.vf().getString("verify_content", this.ayy);
        this.ayx = com.baidu.live.c.vf().getString("live_notice", "");
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
                        this.ayw.add(i, optString);
                    }
                }
            }
        }
        this.azq = com.baidu.live.c.vf().getString("share_host", "");
        this.azr = com.baidu.live.c.vf().getString("ala_share_in_bar_notice_text", "");
        this.azt = com.baidu.live.c.vf().getString("ala_share_reward_rank_notice_text", "");
        this.azs = com.baidu.live.c.vf().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.ayJ = com.baidu.live.c.vf().getInt("recommend_refresh", 60);
        this.ayQ = com.baidu.live.c.vf().getString("strategy_conf", "300");
        this.ayR = com.baidu.live.c.vf().getInt("strategy_exception_interval", 1);
        this.ayO = com.baidu.live.c.vf().getInt("liveStartAuthLevel", 1);
        this.ayF = com.baidu.live.c.vf().getInt("2gTo", 5);
        this.ayG = com.baidu.live.c.vf().getInt("3gTo", 3);
        this.ayH = com.baidu.live.c.vf().getInt("wifiTo", 3);
        String string2 = com.baidu.live.c.vf().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.ayB = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.c.vf().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.ayC = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.azx = com.baidu.live.c.vf().getInt("square_tab_strategy", 1);
        this.azy = com.baidu.live.c.vf().getString("ala_live_ranklist_url", null);
        this.azz = com.baidu.live.c.vf().getString("new_flower_rank_list_description_url", "");
        this.azA = com.baidu.live.c.vf().getString("ala_game_player_signup_url", null);
        this.azB = com.baidu.live.c.vf().getString("ala_game_frs_live_tab_video_url", null);
        wC();
        this.azI = com.baidu.live.c.vf().getString("ala_personal_income_detail_url", null);
        this.aAh = com.baidu.live.c.vf().getInt("ala_custom_gift_category_id", -1);
        this.azJ = com.baidu.live.c.vf().getInt("ala_live_pk_switch", 0) == 1;
        this.azK = com.baidu.live.c.vf().getLong("ala_live_pk_check_interval", 1000L);
        this.azL = com.baidu.live.c.vf().getLong("ala_live_pk_match_timeout", 60000L);
        this.azM = com.baidu.live.c.vf().getString("ala_live_pk_pic_url", "");
        this.azN = com.baidu.live.c.vf().getString("ala_live_pk_pic_jump_url", "");
        this.azO = com.baidu.live.c.vf().getString("ala_live_pk_history_link", "");
        this.azP = com.baidu.live.c.vf().getString("show_live_forum_url", "");
        this.azQ = com.baidu.live.c.vf().getLong("ala_challenge_random_interval", 1000L);
        this.azR = com.baidu.live.c.vf().getLong("ala_challenge_direct_interval", 1000L);
        this.azS = com.baidu.live.c.vf().getLong("ala_get_challenge_info_interval", 1000L);
        this.azU = com.baidu.live.c.vf().getString("ala_challenge_pk_entry_icon_url", "");
        this.azV = com.baidu.live.c.vf().getString("ala_challenge_pk_entry_icon_url", "");
        this.azT = com.baidu.live.c.vf().getString("ala_challenge_pk_entry_icon_url", "");
        this.azW = com.baidu.live.c.vf().getInt("punish_stage_button_switch", 0);
        this.azX = com.baidu.live.c.vf().getInt("receive_challenge_im_show_time", 0);
        this.azY = com.baidu.live.c.vf().getInt("mvpPunishSwitch", 0);
        this.azZ = com.baidu.live.c.vf().getInt("toastLifeTime", 10);
        this.aAa = com.baidu.live.c.vf().getInt("punishLifeTime", 60);
        this.aAi = com.baidu.live.c.vf().getBoolean("ala_guess_use_https", false);
        ez(com.baidu.live.c.vf().getString("ala_live_bar_map_str", ""));
        this.aAj = com.baidu.live.c.vf().getBoolean("is_new_live_close_strategy", false);
        this.aAk = com.baidu.live.c.vf().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aAl = com.baidu.live.c.vf().getString("ala_feedback_url", null);
        this.ayT = com.baidu.live.c.vf().getInt("ala_video_resolution_level", 3);
        this.ayU = com.baidu.live.c.vf().getBoolean("ala_live_hard_encode_switch", true);
        this.ayV = com.baidu.live.c.vf().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.vf().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.vf().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.vf().getInt("ala_video_increase_count", 3);
        this.ayW = com.baidu.live.c.vf().getString("ala_video_soft_bitrate_config", null);
        this.ayX = com.baidu.live.c.vf().getString("ala_video_hard_bitrate_config", null);
        this.azb = com.baidu.live.c.vf().getInt("ala_master_chat_video_resolution_level", 3);
        this.azc = com.baidu.live.c.vf().getInt("ala_slave_chat_video_resolution_level", 4);
        this.ayY = com.baidu.live.c.vf().getString("ala_avts_stream_server_domain_config", null);
        this.ayZ = com.baidu.live.c.vf().getString("ala_master_chat_video_bitrate_config", null);
        this.aza = com.baidu.live.c.vf().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.vf().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.vf().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aAm = com.baidu.live.c.vf().getBoolean("key_is_open_login_prove", false);
        this.aAn = com.baidu.live.c.vf().getBoolean("key_is_open_diamond", false);
        this.aAp = com.baidu.live.c.vf().getBoolean("key_is_jump_to_live_room", false);
        ex(com.baidu.live.c.vf().getString("feed_diversion", ""));
        wB();
    }

    private void ex(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aAM = new AlaFeedDiversionData();
                this.aAM.parserJson(jSONObject);
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
            numArr[i] = Integer.valueOf(jSONArray.optJSONObject(i).optInt(IjkMediaMeta.IJKM_KEY_BITRATE));
        }
        return numArr;
    }

    private void w(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject2 != null) {
                this.aym = optJSONObject2.optString("toast");
                this.ayl = optJSONObject2.optInt("remind_type");
            }
            this.ayI = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.vf().putString("bluediamond_url", this.ayI);
            this.ayy = jSONObject.optString("verify_content");
            com.baidu.live.c.vf().putString("verify_content", this.ayy);
            this.ayx = jSONObject.optString("live_notice");
            com.baidu.live.c.vf().putString("live_notice", this.ayx);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.ayw.add(i, optString);
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
                        this.ayz.add(i2, optString2);
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
                        this.ayv.add(iVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.ayA.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.azq = optJSONObject5.optString("url");
            } else {
                this.azq = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.azr = optJSONObject6.optString("reward_notice");
                this.azt = optJSONObject6.optString("reward_rank_notice");
                this.azs = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.azr = "";
                this.azt = "";
                this.azs = 2;
            }
            com.baidu.live.c.vf().putString("share_host", this.azq);
            com.baidu.live.c.vf().putString("ala_share_in_bar_notice_text", this.azr);
            com.baidu.live.c.vf().putString("ala_share_reward_rank_notice_text", this.azt);
            com.baidu.live.c.vf().putInt("ala_share_in_bar_notice_tip_switch", this.azs);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.ayJ = optJSONObject7.optInt("value");
            } else {
                this.ayJ = 60;
            }
            com.baidu.live.c.vf().putInt("recommend_refresh", this.ayJ);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.vf().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.ayB = g(optJSONArray5);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject9 != null) {
                JSONArray optJSONArray6 = optJSONObject9.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.vf().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.ayC = g(optJSONArray6);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject10 != null) {
                this.ayQ = optJSONObject10.optString("time_interval");
                this.ayR = optJSONObject10.optInt("exception_interval");
            } else {
                this.ayQ = "300";
                this.ayR = 1;
            }
            com.baidu.live.c.vf().putString("strategy_conf", this.ayQ);
            com.baidu.live.c.vf().putInt("strategy_exception_interval", this.ayR);
            this.ayO = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.vf().putInt("liveStartAuthLevel", this.ayO);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject11 != null) {
                this.ayF = optJSONObject11.optInt("2gTo");
                if (this.ayF < 3) {
                    this.ayF = 3;
                }
                this.ayG = optJSONObject11.optInt("3gTo");
                if (this.ayG < 3) {
                    this.ayG = 3;
                }
                this.ayH = optJSONObject11.optInt("wifiTo");
                if (this.ayH < 3) {
                    this.ayH = 3;
                }
                com.baidu.live.c.vf().putInt("2gTo", this.ayF);
                com.baidu.live.c.vf().putInt("3gTo", this.ayG);
                com.baidu.live.c.vf().putInt("wifiTo", this.ayH);
            }
            this.azx = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.vf().putInt("square_tab_strategy", this.azx);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject12 != null) {
                this.azy = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
                this.azz = optJSONObject12.optString("flower_rank_rule");
            }
            com.baidu.live.c.vf().putString("ala_live_ranklist_url", this.azy);
            com.baidu.live.c.vf().putString("new_flower_rank_list_description_url", this.azz);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject13 != null) {
                this.azA = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.vf().putString("ala_game_player_signup_url", this.azA);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject14 != null) {
                this.azB = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.vf().putString("ala_game_frs_live_tab_video_url", this.azB);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject15 != null) {
                this.azC = optJSONObject15.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.vf().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.azD.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject16 != null) {
                com.baidu.live.c.vf().putString("ala_live_session_replace_key", optJSONObject16.toString());
                this.azG = optJSONObject16.optString("hlsUrl");
                this.azE = optJSONObject16.optString("rtmpUrl");
                this.azF = optJSONObject16.optString("flvUrl");
                this.azH = optJSONObject16.optString(".m3u8");
            }
            b(true, this.azC);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject17 != null) {
                this.azI = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.vf().putString("ala_personal_income_detail_url", this.azI);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject18 != null) {
                this.aAh = optJSONObject18.optInt("android_show");
                com.baidu.live.c.vf().putInt("ala_custom_gift_category_id", this.aAh);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject19 != null) {
                int optInt = optJSONObject19.optInt("open", 0);
                this.azJ = optInt == 1;
                com.baidu.live.c.vf().putInt("ala_live_pk_switch", optInt);
                this.azK = optJSONObject19.optLong("interval");
                if (this.azK < 1000) {
                    this.azK = 1000L;
                }
                com.baidu.live.c.vf().putLong("ala_live_pk_check_interval", this.azK);
                this.azL = optJSONObject19.optLong("match_timeout");
                if (this.azL < 60000) {
                    this.azL = 60000L;
                }
                com.baidu.live.c.vf().putLong("ala_live_pk_match_timeout", this.azL);
                this.azM = optJSONObject19.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.vf().putString("ala_live_pk_pic_url", this.azM);
                this.azN = optJSONObject19.optString("rank_link");
                com.baidu.live.c.vf().putString("ala_live_pk_pic_jump_url", this.azN);
                this.azO = optJSONObject19.optString("history_link");
                com.baidu.live.c.vf().putString("ala_live_pk_history_link", this.azO);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject20 != null) {
                this.azQ = optJSONObject20.optLong("random_interval");
                if (this.azQ < 1000) {
                    this.azQ = 1000L;
                }
                com.baidu.live.c.vf().putLong("ala_challenge_random_interval", this.azQ);
                this.azR = optJSONObject20.optLong("direct_interval");
                if (this.azR < 1000) {
                    this.azR = 1000L;
                }
                com.baidu.live.c.vf().putLong("ala_challenge_direct_interval", this.azR);
                this.azS = optJSONObject20.optLong("challenge_info_interval");
                if (this.azS < 1000) {
                    this.azS = 1000L;
                }
                com.baidu.live.c.vf().putLong("ala_get_challenge_info_interval", this.azS);
                this.azU = optJSONObject20.optString("pk_icon_url");
                com.baidu.live.c.vf().putString("ala_challenge_pk_entry_icon_url", this.azU);
                this.azV = optJSONObject20.optString("icon_url");
                com.baidu.live.c.vf().putString("ala_challenge_pk_entry_icon_url", this.azV);
                this.azT = optJSONObject20.optString("rule_url");
                com.baidu.live.c.vf().putString("ala_challenge_pk_entry_icon_url", this.azT);
                this.azW = optJSONObject20.optInt("punish_stage_button_switch");
                com.baidu.live.c.vf().putInt("punish_stage_button_switch", this.azW);
                this.azX = optJSONObject20.optInt("receive_challenge_im_show_time");
                com.baidu.live.c.vf().putInt("receive_challenge_im_show_time", this.azX);
                this.azY = optJSONObject20.optInt("mvpPunishSwitch");
                com.baidu.live.c.vf().putInt("mvpPunishSwitch", this.azY);
                this.azZ = optJSONObject20.optInt("toastLifeTime");
                com.baidu.live.c.vf().putInt("toastLifeTime", this.azZ);
                this.aAa = optJSONObject20.optInt("punishLifeTime");
                com.baidu.live.c.vf().putInt("punishLifeTime", this.aAa);
                this.aAb = optJSONObject20.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject21 != null) {
                this.azP = optJSONObject21.optString("go_url");
                com.baidu.live.c.vf().putString("show_live_forum_url", this.azP);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject22 != null) {
                this.aAi = optJSONObject22.optInt("use_https", 0) == 1;
                com.baidu.live.c.vf().putBoolean("ala_guess_use_https", this.aAi);
            }
            String optString3 = jSONObject.optString("live_bar");
            ez(optString3);
            com.baidu.live.c.vf().putString("ala_live_bar_map_str", optString3);
            this.aAj = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.vf().putBoolean("is_new_live_close_strategy", this.aAj);
            this.aAk = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.vf().putBoolean("is_new_gift_t_dou_strategy", this.aAk);
            this.aAl = jSONObject.optString("feedback_url");
            com.baidu.live.c.vf().putString("ala_feedback_url", this.aAl);
            JSONObject optJSONObject23 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject23 != null && (optJSONObject = optJSONObject23.optJSONObject("challenge_related_zip")) != null) {
                this.aAf = optJSONObject.optString("zip_md5");
                this.aAg = optJSONObject.optString("zip_url");
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
                this.ayU = optJSONObject25.optInt("encoder", 1) == 1;
                com.baidu.live.c.vf().putBoolean("ala_live_hard_encode_switch", this.ayU);
                this.ayV = optJSONObject25.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.vf().putBoolean("ala_dynamic_bitrate_switch", this.ayV);
                this.ayT = optJSONObject25.optInt("resolution", 3);
                com.baidu.live.c.vf().putInt("ala_video_resolution_level", this.ayT);
                JSONArray optJSONArray8 = optJSONObject25.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.ayW = optJSONArray8.toString();
                    com.baidu.live.c.vf().putString("ala_video_soft_bitrate_config", this.ayW);
                }
                JSONArray optJSONArray9 = optJSONObject25.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.ayX = optJSONArray9.toString();
                    com.baidu.live.c.vf().putString("ala_video_hard_bitrate_config", this.ayX);
                }
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject26 != null) {
                this.ayY = optJSONObject26.toString();
                com.baidu.live.c.vf().putString("ala_avts_stream_server_domain_config", this.ayY);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject27 != null) {
                this.azb = optJSONObject27.optInt("host_rtc_resolution", 3);
                com.baidu.live.c.vf().putInt("ala_master_chat_video_resolution_level", this.azb);
                this.azc = optJSONObject27.optInt("rtc_resolution", 4);
                com.baidu.live.c.vf().putInt("ala_slave_chat_video_resolution_level", this.azc);
                JSONArray optJSONArray10 = optJSONObject27.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.ayZ = optJSONArray10.toString();
                    com.baidu.live.c.vf().putString("ala_master_chat_video_bitrate_config", this.ayZ);
                }
                JSONArray optJSONArray11 = optJSONObject27.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aza = optJSONArray11.toString();
                    com.baidu.live.c.vf().putString("ala_slave_chat_video_bitrate_config", this.aza);
                }
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject28 != null) {
                this.aAR = optJSONObject28.optInt("enter_live_msg_audience_num_p1");
                this.aAS = optJSONObject28.optInt("enter_live_msg_audience_num_p2");
                this.aAT = optJSONObject28.optInt("enter_live_msg_audience_num_p3");
                this.aAP = optJSONObject28.optInt("im_intercept_switch");
                this.aAQ = optJSONObject28.optInt("is_check_im_content");
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject29 != null) {
                this.aAM = new AlaFeedDiversionData();
                this.aAM.parserJson(optJSONObject29);
                com.baidu.live.c.vf().putString("feed_diversion", optJSONObject29.toString());
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject30 != null) {
                com.baidu.live.c.vf().putString("key_stat_switch", optJSONObject30.toString());
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject31 != null) {
                this.aAU = optJSONObject31.optInt("unfold_interval", 5000);
                this.aAV = optJSONObject31.optInt("fold_interval", 55000);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void x(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAC = jSONObject.optInt("im_max", 200);
            if (this.aAC <= 0) {
                this.aAC = 200;
            }
            this.aAD = jSONObject.optInt("barrage_max", 100);
            if (this.aAD <= 0) {
                this.aAD = 100;
            }
            this.aAE = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aAE <= 0) {
                this.aAE = 10;
            }
            this.aAF = jSONObject.optInt("enter_effect_max", 10);
            if (this.aAF <= 0) {
                this.aAF = 10;
            }
            this.aAG = jSONObject.optInt("gift_big_max", 10);
            if (this.aAG <= 0) {
                this.aAG = 10;
            }
            this.aAH = jSONObject.optInt("gift_small_max", 50);
            if (this.aAH <= 0) {
                this.aAH = 50;
            }
            this.aAI = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aAI <= 0) {
                this.aAI = 5;
            }
        }
    }

    private void wz() {
        this.aAq = com.baidu.live.c.vf().getInt("guide_speak_watch_time", 15000);
        this.aAr = com.baidu.live.c.vf().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.vf().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aAs = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aAs[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void y(JSONObject jSONObject) {
        int length;
        this.aAq = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.c.vf().putInt("guide_speak_watch_time", this.aAq);
        this.aAr = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.vf().putInt("guide_speak_show_times_max", this.aAr);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aAs = new String[length];
            for (int i = 0; i < length; i++) {
                this.aAs[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.vf().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void wA() {
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
            this.aAx = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aAx.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void ey(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aAz = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aAz.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aAA = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aAA.add(str3);
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

    private void wB() {
        ey(com.baidu.live.c.vf().getString("ala_quick_send_im_list", null));
    }

    private void ez(String str) {
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
        if (i != this.azC) {
            z2 = true;
        }
        this.azC = i;
        if (z || z2) {
            com.baidu.live.c.vf().putInt("ala_live_session_default_key", i);
        }
    }

    private void wC() {
        this.azC = com.baidu.live.c.vf().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.vf().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.azD.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.vf().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.azG = jSONObject.optString("hlsUrl");
                this.azE = jSONObject.optString("rtmpUrl");
                this.azF = jSONObject.optString("flvUrl");
                this.azH = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean wD() {
        return this.azv == 1;
    }
}
