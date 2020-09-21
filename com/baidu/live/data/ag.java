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
    public boolean aFZ;
    public boolean aGA;
    public boolean aGB;
    public boolean aGD;
    public String aGE;
    public int aGF;
    public boolean aGG;
    public int aGH;
    public boolean aGI;
    public boolean aGJ;
    public String aGK;
    public String aGL;
    public String aGM;
    public String aGN;
    public String aGO;
    public int aGP;
    public int aGQ;
    public boolean aGR;
    public boolean aGS;
    public boolean aGT;
    public boolean aGU;
    public boolean aGV;
    public boolean aGW;
    public boolean aGX;
    public boolean aGa;
    public boolean aGb;
    public boolean aGc;
    public boolean aGd;
    public String aGe;
    public String aGf;
    public String aGj;
    public String aGk;
    public String aGl;
    public String aGm;
    public Integer[] aGp;
    public Integer[] aGq;
    public int aGr;
    public int aGt;
    public int aGu;
    public int aGv;
    public String aGw;
    public int aGx;
    public boolean aGy;
    public boolean aGz;
    public String aHA;
    public String aHB;
    public String aHC;
    public String aHD;
    public long aHE;
    public long aHF;
    public long aHG;
    public String aHH;
    public String aHI;
    public String aHJ;
    public int aHK;
    public int aHL;
    public int aHM;
    public String aHR;
    public String aHS;
    public String aHT;
    public String aHU;
    public int aHV;
    public String aHZ;
    public String aHb;
    public String aHd;
    public String aHe;
    public int aHk;
    public String aHm;
    public String aHn;
    private String aHo;
    private String aHp;
    public int aHq;
    public String aHs;
    public String aHt;
    public String aHu;
    public String aHv;
    public String aHw;
    public boolean aHx;
    public long aHy;
    public long aHz;
    public boolean aIA;
    public String aIB;
    public AlaFeedDiversionData aIC;
    public o aID;
    public boolean aIE;
    public int aIF;
    public int aIG;
    public ah aIM;
    public bo aIO;
    public bl aIP;
    public bt aIQ;
    public int aIe;
    public int aIf;
    public String[] aIg;
    public int aIh;
    public String aIi;
    public String aIj;
    public QuickImInputData aIk;
    public QuickImInputData aIl;
    public List<YuanPackageData> aIm;
    public bb aIn;
    public List<String> aIo;
    public List<String> aIp;
    public List<String> aIq;
    public ap aIz;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aFX = -1;
    public String aFY = null;
    public int aGC = 1;
    public boolean aGY = true;
    public boolean aGZ = false;
    public boolean aHa = false;
    public boolean aHc = false;
    public String aHf = "";
    private int aHg = 2;
    public String aHh = "";
    public int aHi = 1;
    public int aHj = 0;
    public int aHl = 1;
    public List<String> aHr = new ArrayList();
    public int aHN = 10;
    public int aHO = 60;
    public long aHP = 10000;
    public boolean aHQ = false;
    public boolean aHW = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aHX = false;
    public boolean aHY = false;
    public boolean aIa = false;
    public boolean aIb = false;
    public boolean aIc = false;
    public boolean aId = false;
    public int aIr = 200;
    public int aIs = 100;
    public int aIt = 10;
    public int aIu = 10;
    public int aIv = 10;
    public int aIw = 15;
    public int aIx = 50;
    public int aIy = 5;
    public int aIH = 20;
    public int aII = 70;
    public int aIJ = 10000;
    public int aIK = 5000;
    public int aIL = 55000;
    public int aIN = 7;
    public List<String> aGi = new ArrayList();
    public List<String> aGs = new ArrayList();
    public List<String> aGn = new ArrayList();
    public List<Integer> aGo = new ArrayList();
    public ArrayList<l> aGg = new ArrayList<>();
    public ArrayList<l> aGh = new ArrayList<>();

    public ag(boolean z) {
        if (z) {
            CS();
            this.aGr = com.baidu.live.c.AR().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.AR().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.AR().getInt("restart_time_interval", 300);
            CT();
            CR();
            CU();
            CV();
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
                    this.aGr = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.AR().putInt("conn_conf", this.aGr);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aGs.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.c.AR().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.c.AR().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    y(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    z(optJSONObject5);
                }
                this.aHd = jSONObject.optString("client_id");
                com.baidu.live.c.AR().putString("client_id", this.aHd);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aGe = optJSONObject6.optString("pic_url");
                    this.aGf = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            l lVar = new l();
                            lVar.parseJson(optJSONObject8);
                            this.aGg.add(lVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.AR().putString("pic_url", this.aGe);
                com.baidu.live.c.AR().putString(BigdayActivityConfig.JUMP_URL, this.aGf);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    A(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aIh = optJSONObject10.optInt("resource_switch");
                    this.aIj = optJSONObject10.optString("photo_url");
                    this.aIi = optJSONObject10.optString("resource_url");
                }
                this.aIk = new QuickImInputData();
                this.aIk.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aIl = new QuickImInputData();
                this.aIl.parseJson(jSONObject.getJSONArray("fast_reply_word_audio"));
                this.aIn = bb.B(jSONObject.optJSONObject("guide_follow"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.AR().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject11 != null) {
                    JSONObject optJSONObject12 = optJSONObject11.optJSONObject("rank");
                    if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.c.AR().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.c.AR().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.c.AR().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject13 = optJSONObject11.optJSONObject("guard_seat");
                    if (optJSONObject13 != null) {
                        this.aIB = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aIz = new ap();
                    this.aIz.aJD = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.c.AR().putString("ala_certify_refuse_url", this.aIz.aJD);
                }
                this.aIM = new ah();
                this.aIM.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aID = new o();
                    this.aID.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aIN = optJSONObject16.optInt("show_days");
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.AR().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void CR() {
        String string = com.baidu.live.c.AR().getString("ala_prepare_random_title_list", "");
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
            this.aIq = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aIq.add(jSONArray.optString(i));
            }
        }
    }

    private void CS() {
        this.aFZ = com.baidu.live.c.AR().getBoolean("map_around_map", false);
        this.aGG = com.baidu.live.c.AR().getBoolean("withdraw_switch", true);
        this.aHb = com.baidu.live.c.AR().getString("withdraw_text", "");
        this.aGU = com.baidu.live.c.AR().getBoolean("use_internal_player_switch", true);
        this.aGR = com.baidu.live.c.AR().getBoolean("use_http_dns_switch", true);
        this.aGS = com.baidu.live.c.AR().getBoolean("use_encode_bframe_switch", false);
        this.aGT = com.baidu.live.c.AR().getBoolean("enable_opt_timestamp_switch", true);
        this.aGV = com.baidu.live.c.AR().getBoolean("live_beauty_open_switch", false);
        this.aGW = com.baidu.live.c.AR().getBoolean("live_unity_beauty_switch", true);
        this.aGX = com.baidu.live.c.AR().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aGY = com.baidu.live.c.AR().getBoolean("sp_key_live_game_hard_encode", true);
        this.aGZ = com.baidu.live.c.AR().getBoolean("sp_key_live_play_transcode_support", false);
        this.aHa = com.baidu.live.c.AR().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aHc = com.baidu.live.c.AR().getBoolean("ala_enable_graffiti_str", false);
        this.aGa = com.baidu.live.c.AR().getBoolean("enter_live", false);
        this.aGb = com.baidu.live.c.AR().getBoolean("sync_to_forum", true);
        this.aGc = com.baidu.live.c.AR().getBoolean("show_water_mark", false);
        this.aGd = com.baidu.live.c.AR().getBoolean("show_third_part_water_mark_switch", false);
        this.aGy = com.baidu.live.c.AR().getBoolean("stream_error_log", true);
        this.aGz = com.baidu.live.c.AR().getBoolean("disable_channel_in", true);
        this.aGA = com.baidu.live.c.AR().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aGB = com.baidu.live.c.AR().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aGD = com.baidu.live.c.AR().getBoolean("follow_default_push_switch", true);
        this.aHk = com.baidu.live.c.AR().getInt("to_tb_some_switch", 0);
        this.aHi = com.baidu.live.c.AR().getInt("enable_live_stat", 1);
        this.aHj = com.baidu.live.c.AR().getInt("ala_free_gift_task_switch", 0);
        this.aHQ = com.baidu.live.c.AR().getBoolean("live_challenge_switch", false);
        this.aHR = com.baidu.live.c.AR().getString("live_challenge_tip", null);
        this.aHS = com.baidu.live.c.AR().getString("live_challenge_url", null);
    }

    private void x(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aFZ = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.AR().putBoolean("map_around_map", this.aFZ);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aGG = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("withdraw_switch", this.aGG);
                this.aHb = optJSONObject2.optString("text");
                com.baidu.live.c.AR().putString("withdraw_text", this.aHb);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aGU = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("use_internal_player_switch", this.aGU);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aGR = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("use_http_dns_switch", this.aGR);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aGS = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("use_encode_bframe_switch", this.aGS);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aGT = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("enable_opt_timestamp_switch", this.aGT);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.aGV = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("live_beauty_open_switch", this.aGV);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.aGW = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("live_unity_beauty_switch", this.aGW);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.aGX = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("live_unity_beauty_face_style_switch", this.aGX);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.aGY = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("sp_key_live_game_hard_encode", this.aGY);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.aGZ = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("sp_key_live_play_transcode_support", this.aGZ);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.aHa = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("sp_key_live_play_attention_guide_support", this.aHa);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.aGa = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("enter_live", this.aGa);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.aGb = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.c.AR().putBoolean("sync_to_forum", this.aGb);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.aGc = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.c.AR().putBoolean("show_water_mark", this.aGc);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.aGd = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.AR().putBoolean("show_third_part_water_mark_switch", this.aGd);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.aHi = optJSONObject17.optInt("switch");
                com.baidu.live.c.AR().putInt("enable_live_stat", this.aHi);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.aGy = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("stream_error_log", this.aGy);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.aGz = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.c.AR().putBoolean("disable_channel_in", this.aGz);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.aGA = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.c.AR().putBoolean("shoubai_yanzhi_tab_tip", this.aGA);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.aGB = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.c.AR().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aGB);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.aGD = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.c.AR().putBoolean("follow_default_push_switch", this.aGD);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.aHk = optJSONObject23.optInt("switch");
                com.baidu.live.c.AR().putInt("to_tb_some_switch", this.aHk);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.aHj = optJSONObject24.optInt("switch");
                com.baidu.live.c.AR().putInt("ala_free_gift_task_switch", this.aHk);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.aHc = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("ala_enable_graffiti_str", this.aHc);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aHQ = optJSONObject26.optInt("switch") == 1;
                this.aHR = optJSONObject26.optString("title");
                this.aHS = optJSONObject26.optString("url");
                com.baidu.live.c.AR().putBoolean("live_challenge_switch", this.aHQ);
                com.baidu.live.c.AR().putString("live_challenge_tip", this.aHR);
                com.baidu.live.c.AR().putString("live_challenge_url", this.aHS);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aHY = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("is_new_gift_t_dou_strategy", this.aHY);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aIc = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aIa = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("key_is_open_login_prove", this.aIa);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aIb = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("key_is_open_diamond", this.aIb);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aId = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.c.AR().putBoolean("key_is_jump_to_live_room", this.aId);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aIA = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aIE = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void CT() {
        JSONArray jSONArray;
        this.aGw = com.baidu.live.c.AR().getString("bluediamond_url", "");
        this.aGk = com.baidu.live.c.AR().getString("verify_content", this.aGk);
        this.aGj = com.baidu.live.c.AR().getString("live_notice", "");
        this.aGl = com.baidu.live.c.AR().getString("activity_notice", "");
        String string = com.baidu.live.c.AR().getString("imNotice", "");
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
                        this.aGi.add(i, optString);
                    }
                }
            }
        }
        this.aHe = com.baidu.live.c.AR().getString("share_host", "");
        this.aHf = com.baidu.live.c.AR().getString("ala_share_in_bar_notice_text", "");
        this.aHh = com.baidu.live.c.AR().getString("ala_share_reward_rank_notice_text", "");
        this.aHg = com.baidu.live.c.AR().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aGx = com.baidu.live.c.AR().getInt("recommend_refresh", 60);
        this.aGE = com.baidu.live.c.AR().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aGF = com.baidu.live.c.AR().getInt("strategy_exception_interval", 1);
        this.aGC = com.baidu.live.c.AR().getInt("liveStartAuthLevel", 1);
        this.aGt = com.baidu.live.c.AR().getInt("2gTo", 5);
        this.aGu = com.baidu.live.c.AR().getInt("3gTo", 3);
        this.aGv = com.baidu.live.c.AR().getInt("wifiTo", 3);
        String string2 = com.baidu.live.c.AR().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aGp = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.c.AR().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aGq = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aHl = com.baidu.live.c.AR().getInt("square_tab_strategy", 1);
        this.aHm = com.baidu.live.c.AR().getString("ala_live_ranklist_url", null);
        this.aHn = com.baidu.live.c.AR().getString("new_flower_rank_list_description_url", "");
        this.aHo = com.baidu.live.c.AR().getString("ala_game_player_signup_url", null);
        this.aHp = com.baidu.live.c.AR().getString("ala_game_frs_live_tab_video_url", null);
        CX();
        this.aHw = com.baidu.live.c.AR().getString("ala_personal_income_detail_url", null);
        this.aHV = com.baidu.live.c.AR().getInt("ala_custom_gift_category_id", -1);
        this.aHx = com.baidu.live.c.AR().getInt("ala_live_pk_switch", 0) == 1;
        this.aHy = com.baidu.live.c.AR().getLong("ala_live_pk_check_interval", 1000L);
        this.aHz = com.baidu.live.c.AR().getLong("ala_live_pk_match_timeout", 60000L);
        this.aHA = com.baidu.live.c.AR().getString("ala_live_pk_pic_url", "");
        this.aHB = com.baidu.live.c.AR().getString("ala_live_pk_pic_jump_url", "");
        this.aHC = com.baidu.live.c.AR().getString("ala_live_pk_history_link", "");
        this.aHD = com.baidu.live.c.AR().getString("show_live_forum_url", "");
        this.aHE = com.baidu.live.c.AR().getLong("ala_challenge_random_interval", 1000L);
        this.aHF = com.baidu.live.c.AR().getLong("ala_challenge_direct_interval", 1000L);
        this.aHG = com.baidu.live.c.AR().getLong("ala_get_challenge_info_interval", 1000L);
        this.aHI = com.baidu.live.c.AR().getString("ala_challenge_pk_entry_icon_url", "");
        this.aHJ = com.baidu.live.c.AR().getString("ala_challenge_pk_entry_icon_url", "");
        this.aHH = com.baidu.live.c.AR().getString("ala_challenge_pk_entry_icon_url", "");
        this.aHK = com.baidu.live.c.AR().getInt("punish_stage_button_switch", 0);
        this.aHL = com.baidu.live.c.AR().getInt("receive_challenge_im_show_time", 0);
        this.aHM = com.baidu.live.c.AR().getInt("mvpPunishSwitch", 0);
        this.aHN = com.baidu.live.c.AR().getInt("toastLifeTime", 10);
        this.aHO = com.baidu.live.c.AR().getInt("punishLifeTime", 60);
        this.aHW = com.baidu.live.c.AR().getBoolean("ala_guess_use_https", false);
        fY(com.baidu.live.c.AR().getString("ala_live_bar_map_str", ""));
        this.aHX = com.baidu.live.c.AR().getBoolean("is_new_live_close_strategy", false);
        this.aHY = com.baidu.live.c.AR().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aHZ = com.baidu.live.c.AR().getString("ala_feedback_url", null);
        this.aGH = com.baidu.live.c.AR().getInt("ala_video_resolution_level", 3);
        this.aGI = com.baidu.live.c.AR().getBoolean("ala_live_hard_encode_switch", true);
        this.aGJ = com.baidu.live.c.AR().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.AR().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.AR().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.AR().getInt("ala_video_increase_count", 3);
        this.aGK = com.baidu.live.c.AR().getString("ala_video_soft_bitrate_config", null);
        this.aGL = com.baidu.live.c.AR().getString("ala_video_hard_bitrate_config", null);
        this.aGP = com.baidu.live.c.AR().getInt("ala_master_chat_video_resolution_level", 3);
        this.aGQ = com.baidu.live.c.AR().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aGM = com.baidu.live.c.AR().getString("ala_avts_stream_server_domain_config", null);
        this.aGN = com.baidu.live.c.AR().getString("ala_master_chat_video_bitrate_config", null);
        this.aGO = com.baidu.live.c.AR().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.AR().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.AR().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aIa = com.baidu.live.c.AR().getBoolean("key_is_open_login_prove", false);
        this.aIb = com.baidu.live.c.AR().getBoolean("key_is_open_diamond", false);
        this.aId = com.baidu.live.c.AR().getBoolean("key_is_jump_to_live_room", false);
        fW(com.baidu.live.c.AR().getString("feed_diversion", ""));
        CW();
    }

    private void fW(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aIC = new AlaFeedDiversionData();
                this.aIC.parserJson(jSONObject);
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
                this.aGm = optJSONObject2.toString();
                this.aIO = new bo();
                this.aIO.parse(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject3 != null) {
                this.aFY = optJSONObject3.optString("toast");
                this.aFX = optJSONObject3.optInt("remind_type");
            }
            this.aGw = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.AR().putString("bluediamond_url", this.aGw);
            this.aGk = jSONObject.optString("verify_content");
            com.baidu.live.c.AR().putString("verify_content", this.aGk);
            this.aGj = jSONObject.optString("live_notice");
            com.baidu.live.c.AR().putString("live_notice", this.aGj);
            this.aGl = jSONObject.optString("activityNotice");
            com.baidu.live.c.AR().putString("activity_notice", this.aGl);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aGi.add(i, optString);
                    }
                }
                com.baidu.live.c.AR().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.c.AR().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.aGn.add(i2, optString2);
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
                        this.aGh.add(lVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aGo.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_host");
            if (optJSONObject6 != null) {
                this.aHe = optJSONObject6.optString("url");
            } else {
                this.aHe = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject7 != null) {
                this.aHf = optJSONObject7.optString("reward_notice");
                this.aHh = optJSONObject7.optString("reward_rank_notice");
                this.aHg = optJSONObject7.optInt("reward_switch", 2);
            } else {
                this.aHf = "";
                this.aHh = "";
                this.aHg = 2;
            }
            com.baidu.live.c.AR().putString("share_host", this.aHe);
            com.baidu.live.c.AR().putString("ala_share_in_bar_notice_text", this.aHf);
            com.baidu.live.c.AR().putString("ala_share_reward_rank_notice_text", this.aHh);
            com.baidu.live.c.AR().putInt("ala_share_in_bar_notice_tip_switch", this.aHg);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject8 != null) {
                this.aGx = optJSONObject8.optInt("value");
            } else {
                this.aGx = 60;
            }
            com.baidu.live.c.AR().putInt("recommend_refresh", this.aGx);
            JSONObject optJSONObject9 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject9 != null) {
                JSONArray optJSONArray5 = optJSONObject9.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.AR().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aGp = g(optJSONArray5);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject10 != null) {
                JSONArray optJSONArray6 = optJSONObject10.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.AR().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aGq = g(optJSONArray6);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject11 != null) {
                this.aGE = optJSONObject11.optString("time_interval");
                this.aGF = optJSONObject11.optInt("exception_interval");
            } else {
                this.aGE = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aGF = 1;
            }
            com.baidu.live.c.AR().putString("strategy_conf", this.aGE);
            com.baidu.live.c.AR().putInt("strategy_exception_interval", this.aGF);
            this.aGC = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.AR().putInt("liveStartAuthLevel", this.aGC);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject12 != null) {
                this.aGt = optJSONObject12.optInt("2gTo");
                if (this.aGt < 3) {
                    this.aGt = 3;
                }
                this.aGu = optJSONObject12.optInt("3gTo");
                if (this.aGu < 3) {
                    this.aGu = 3;
                }
                this.aGv = optJSONObject12.optInt("wifiTo");
                if (this.aGv < 3) {
                    this.aGv = 3;
                }
                com.baidu.live.c.AR().putInt("2gTo", this.aGt);
                com.baidu.live.c.AR().putInt("3gTo", this.aGu);
                com.baidu.live.c.AR().putInt("wifiTo", this.aGv);
            }
            this.aHl = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.AR().putInt("square_tab_strategy", this.aHl);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject13 != null) {
                this.aHm = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
                this.aHn = optJSONObject13.optString("flower_rank_rule");
            }
            com.baidu.live.c.AR().putString("ala_live_ranklist_url", this.aHm);
            com.baidu.live.c.AR().putString("new_flower_rank_list_description_url", this.aHn);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject14 != null) {
                this.aHo = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.AR().putString("ala_game_player_signup_url", this.aHo);
            JSONObject optJSONObject15 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject15 != null) {
                this.aHp = optJSONObject15.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.AR().putString("ala_game_frs_live_tab_video_url", this.aHp);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject16 != null) {
                this.aHq = optJSONObject16.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.AR().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aHr.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject17 != null) {
                com.baidu.live.c.AR().putString("ala_live_session_replace_key", optJSONObject17.toString());
                this.aHu = optJSONObject17.optString("hlsUrl");
                this.aHs = optJSONObject17.optString("rtmpUrl");
                this.aHt = optJSONObject17.optString("flvUrl");
                this.aHv = optJSONObject17.optString(".m3u8");
            }
            b(true, this.aHq);
            JSONObject optJSONObject18 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject18 != null) {
                this.aHw = optJSONObject18.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.AR().putString("ala_personal_income_detail_url", this.aHw);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject19 != null) {
                this.aHV = optJSONObject19.optInt("android_show");
                com.baidu.live.c.AR().putInt("ala_custom_gift_category_id", this.aHV);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject20 != null) {
                int optInt = optJSONObject20.optInt("open", 0);
                this.aHx = optInt == 1;
                com.baidu.live.c.AR().putInt("ala_live_pk_switch", optInt);
                this.aHy = optJSONObject20.optLong("interval");
                if (this.aHy < 1000) {
                    this.aHy = 1000L;
                }
                com.baidu.live.c.AR().putLong("ala_live_pk_check_interval", this.aHy);
                this.aHz = optJSONObject20.optLong("match_timeout");
                if (this.aHz < 60000) {
                    this.aHz = 60000L;
                }
                com.baidu.live.c.AR().putLong("ala_live_pk_match_timeout", this.aHz);
                this.aHA = optJSONObject20.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.AR().putString("ala_live_pk_pic_url", this.aHA);
                this.aHB = optJSONObject20.optString("rank_link");
                com.baidu.live.c.AR().putString("ala_live_pk_pic_jump_url", this.aHB);
                this.aHC = optJSONObject20.optString("history_link");
                com.baidu.live.c.AR().putString("ala_live_pk_history_link", this.aHC);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject21 != null) {
                this.aHE = optJSONObject21.optLong("random_interval");
                if (this.aHE < 1000) {
                    this.aHE = 1000L;
                }
                com.baidu.live.c.AR().putLong("ala_challenge_random_interval", this.aHE);
                this.aHF = optJSONObject21.optLong("direct_interval");
                if (this.aHF < 1000) {
                    this.aHF = 1000L;
                }
                com.baidu.live.c.AR().putLong("ala_challenge_direct_interval", this.aHF);
                this.aHG = optJSONObject21.optLong("challenge_info_interval");
                if (this.aHG < 1000) {
                    this.aHG = 1000L;
                }
                com.baidu.live.c.AR().putLong("ala_get_challenge_info_interval", this.aHG);
                this.aHI = optJSONObject21.optString("pk_icon_url");
                com.baidu.live.c.AR().putString("ala_challenge_pk_entry_icon_url", this.aHI);
                this.aHJ = optJSONObject21.optString("icon_url");
                com.baidu.live.c.AR().putString("ala_challenge_pk_entry_icon_url", this.aHJ);
                this.aHH = optJSONObject21.optString("rule_url");
                com.baidu.live.c.AR().putString("ala_challenge_pk_entry_icon_url", this.aHH);
                this.aHK = optJSONObject21.optInt("punish_stage_button_switch");
                com.baidu.live.c.AR().putInt("punish_stage_button_switch", this.aHK);
                this.aHL = optJSONObject21.optInt("receive_challenge_im_show_time");
                com.baidu.live.c.AR().putInt("receive_challenge_im_show_time", this.aHL);
                this.aHM = optJSONObject21.optInt("mvpPunishSwitch");
                com.baidu.live.c.AR().putInt("mvpPunishSwitch", this.aHM);
                this.aHN = optJSONObject21.optInt("toastLifeTime");
                com.baidu.live.c.AR().putInt("toastLifeTime", this.aHN);
                this.aHO = optJSONObject21.optInt("punishLifeTime");
                com.baidu.live.c.AR().putInt("punishLifeTime", this.aHO);
                this.aHP = optJSONObject21.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject22 != null) {
                this.aHD = optJSONObject22.optString("go_url");
                com.baidu.live.c.AR().putString("show_live_forum_url", this.aHD);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject23 != null) {
                this.aHW = optJSONObject23.optInt("use_https", 0) == 1;
                com.baidu.live.c.AR().putBoolean("ala_guess_use_https", this.aHW);
            }
            String optString3 = jSONObject.optString("live_bar");
            fY(optString3);
            com.baidu.live.c.AR().putString("ala_live_bar_map_str", optString3);
            this.aHX = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.AR().putBoolean("is_new_live_close_strategy", this.aHX);
            this.aHY = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.AR().putBoolean("is_new_gift_t_dou_strategy", this.aHY);
            this.aHZ = jSONObject.optString("feedback_url");
            com.baidu.live.c.AR().putString("ala_feedback_url", this.aHZ);
            JSONObject optJSONObject24 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject24 != null && (optJSONObject = optJSONObject24.optJSONObject("challenge_related_zip")) != null) {
                this.aHT = optJSONObject.optString("zip_md5");
                this.aHU = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject25 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject25.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject25.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.AR().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.AR().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("open_live");
            if (optJSONObject26 != null) {
                this.increaseThreshold = optJSONObject26.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.AR().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject26.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.AR().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject26.optInt("thi_count", 3);
                com.baidu.live.c.AR().putInt("ala_video_increase_count", this.increaseCount);
                this.aGI = optJSONObject26.optInt("encoder", 1) == 1;
                com.baidu.live.c.AR().putBoolean("ala_live_hard_encode_switch", this.aGI);
                this.aGJ = optJSONObject26.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.AR().putBoolean("ala_dynamic_bitrate_switch", this.aGJ);
                this.aGH = optJSONObject26.optInt("resolution", 3);
                com.baidu.live.c.AR().putInt("ala_video_resolution_level", this.aGH);
                JSONArray optJSONArray8 = optJSONObject26.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aGK = optJSONArray8.toString();
                    com.baidu.live.c.AR().putString("ala_video_soft_bitrate_config", this.aGK);
                }
                JSONArray optJSONArray9 = optJSONObject26.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aGL = optJSONArray9.toString();
                    com.baidu.live.c.AR().putString("ala_video_hard_bitrate_config", this.aGL);
                }
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject27 != null) {
                this.aGM = optJSONObject27.toString();
                com.baidu.live.c.AR().putString("ala_avts_stream_server_domain_config", this.aGM);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject28 != null) {
                this.aGP = optJSONObject28.optInt("host_rtc_resolution", 3);
                com.baidu.live.c.AR().putInt("ala_master_chat_video_resolution_level", this.aGP);
                this.aGQ = optJSONObject28.optInt("rtc_resolution", 4);
                com.baidu.live.c.AR().putInt("ala_slave_chat_video_resolution_level", this.aGQ);
                JSONArray optJSONArray10 = optJSONObject28.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aGN = optJSONArray10.toString();
                    com.baidu.live.c.AR().putString("ala_master_chat_video_bitrate_config", this.aGN);
                }
                JSONArray optJSONArray11 = optJSONObject28.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aGO = optJSONArray11.toString();
                    com.baidu.live.c.AR().putString("ala_slave_chat_video_bitrate_config", this.aGO);
                }
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject29 != null) {
                this.aIH = optJSONObject29.optInt("enter_live_msg_audience_num_p1");
                this.aII = optJSONObject29.optInt("enter_live_msg_audience_num_p2");
                this.aIJ = optJSONObject29.optInt("enter_live_msg_audience_num_p3");
                this.aIF = optJSONObject29.optInt("im_intercept_switch");
                this.aIG = optJSONObject29.optInt("is_check_im_content");
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject30 != null) {
                this.aIC = new AlaFeedDiversionData();
                this.aIC.parserJson(optJSONObject30);
                com.baidu.live.c.AR().putString("feed_diversion", optJSONObject30.toString());
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject31 != null) {
                com.baidu.live.c.AR().putString("key_stat_switch", optJSONObject31.toString());
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject32 != null) {
                this.aIK = optJSONObject32.optInt("unfold_interval", 5000);
                this.aIL = optJSONObject32.optInt("fold_interval", 55000);
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("modify_default_name_conf");
            if (optJSONObject33 != null) {
                this.aIP = new bl();
                this.aIP.parserJson(optJSONObject33);
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("audio_live_conf");
            if (optJSONObject34 != null) {
                this.aIQ = new bt();
                this.aIQ.parse(optJSONObject34);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIr = jSONObject.optInt("im_max", 200);
            if (this.aIr <= 0) {
                this.aIr = 200;
            }
            this.aIs = jSONObject.optInt("barrage_max", 100);
            if (this.aIs <= 0) {
                this.aIs = 100;
            }
            this.aIt = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aIt <= 0) {
                this.aIt = 10;
            }
            this.aIu = jSONObject.optInt("enter_effect_max", 10);
            if (this.aIu <= 0) {
                this.aIu = 10;
            }
            this.aIv = jSONObject.optInt("gift_big_max", 10);
            if (this.aIv <= 0) {
                this.aIv = 10;
            }
            this.aIw = jSONObject.optInt("audio_gift_big_max", 15);
            if (this.aIw <= 0) {
                this.aIw = 15;
            }
            this.aIx = jSONObject.optInt("gift_small_max", 50);
            if (this.aIx <= 0) {
                this.aIx = 50;
            }
            this.aIy = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aIy <= 0) {
                this.aIy = 5;
            }
        }
    }

    private void CU() {
        this.aIe = com.baidu.live.c.AR().getInt("guide_speak_watch_time", 15000);
        this.aIf = com.baidu.live.c.AR().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.AR().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aIg = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aIg[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void A(JSONObject jSONObject) {
        int length;
        this.aIe = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.c.AR().putInt("guide_speak_watch_time", this.aIe);
        this.aIf = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.AR().putInt("guide_speak_show_times_max", this.aIf);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aIg = new String[length];
            for (int i = 0; i < length; i++) {
                this.aIg[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.AR().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void CV() {
        String string = com.baidu.live.c.AR().getString("yuan_package_data", "");
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
            this.aIm = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aIm.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void fX(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aIo = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aIo.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aIp = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aIp.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.AR().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void CW() {
        fX(com.baidu.live.c.AR().getString("ala_quick_send_im_list", null));
    }

    private void fY(String str) {
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
        if (i != this.aHq) {
            z2 = true;
        }
        this.aHq = i;
        if (z || z2) {
            com.baidu.live.c.AR().putInt("ala_live_session_default_key", i);
        }
    }

    private void CX() {
        this.aHq = com.baidu.live.c.AR().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.AR().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aHr.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.AR().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aHu = jSONObject.optString("hlsUrl");
                this.aHs = jSONObject.optString("rtmpUrl");
                this.aHt = jSONObject.optString("flvUrl");
                this.aHv = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean CY() {
        return this.aHj == 1;
    }
}
