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
/* loaded from: classes7.dex */
public class ab extends BaseData {
    public boolean aEK;
    public boolean aEL;
    public boolean aEM;
    public boolean aEN;
    public boolean aEO;
    public String aEP;
    public String aEQ;
    public String aEU;
    public String aEV;
    public Integer[] aEY;
    public Integer[] aEZ;
    public boolean aFA;
    public boolean aFB;
    public boolean aFC;
    public boolean aFD;
    public boolean aFE;
    public boolean aFF;
    public boolean aFG;
    public String aFK;
    public String aFM;
    public String aFN;
    public int aFT;
    public String aFV;
    public String aFW;
    private String aFX;
    private String aFY;
    public int aFZ;
    public int aFa;
    public int aFc;
    public int aFd;
    public int aFe;
    public String aFf;
    public int aFg;
    public boolean aFh;
    public boolean aFi;
    public boolean aFj;
    public boolean aFk;
    public boolean aFm;
    public String aFn;
    public int aFo;
    public boolean aFp;
    public int aFq;
    public boolean aFr;
    public boolean aFs;
    public String aFt;
    public String aFu;
    public String aFv;
    public String aFw;
    public String aFx;
    public int aFy;
    public int aFz;
    public String aGA;
    public String aGB;
    public String aGC;
    public String aGD;
    public int aGE;
    public String aGI;
    public int aGN;
    public int aGO;
    public String[] aGP;
    public int aGQ;
    public String aGR;
    public String aGS;
    public QuickImInputData aGT;
    public List<YuanPackageData> aGU;
    public aw aGV;
    public List<String> aGW;
    public List<String> aGX;
    public List<String> aGY;
    public String aGb;
    public String aGc;
    public String aGd;
    public String aGe;
    public String aGf;
    public boolean aGg;
    public long aGh;
    public long aGi;
    public String aGj;
    public String aGk;
    public String aGl;
    public String aGm;
    public long aGn;
    public long aGo;
    public long aGp;
    public String aGq;
    public String aGr;
    public String aGs;
    public int aGt;
    public int aGu;
    public int aGv;
    public ak aHg;
    public boolean aHh;
    public String aHi;
    public AlaFeedDiversionData aHj;
    public l aHk;
    public boolean aHl;
    public int aHm;
    public int aHn;
    public ac aHt;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aEI = -1;
    public String aEJ = null;
    public int aFl = 1;
    public boolean aFH = true;
    public boolean aFI = false;
    public boolean aFJ = false;
    public boolean aFL = false;
    public String aFO = "";
    private int aFP = 2;
    public String aFQ = "";
    public int aFR = 1;
    public int aFS = 0;
    public int aFU = 1;
    public List<String> aGa = new ArrayList();
    public int aGw = 10;
    public int aGx = 60;
    public long aGy = 10000;
    public boolean aGz = false;
    public boolean aGF = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aGG = false;
    public boolean aGH = false;
    public boolean aGJ = false;
    public boolean aGK = false;
    public boolean aGL = false;
    public boolean aGM = false;
    public int aGZ = 200;
    public int aHa = 100;
    public int aHb = 10;
    public int aHc = 10;
    public int aHd = 10;
    public int aHe = 50;
    public int aHf = 5;
    public int aHo = 20;
    public int aHp = 70;
    public int aHq = 10000;
    public int aHr = 5000;
    public int aHs = 55000;
    public int aHu = 7;
    public List<String> aET = new ArrayList();
    public List<String> aFb = new ArrayList();
    public List<String> aEW = new ArrayList();
    public List<Integer> aEX = new ArrayList();
    public ArrayList<i> aER = new ArrayList<>();
    public ArrayList<i> aES = new ArrayList<>();

    public ab(boolean z) {
        if (z) {
            CC();
            this.aFa = com.baidu.live.c.AD().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.AD().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.AD().getInt("restart_time_interval", 300);
            CD();
            CB();
            CE();
            CF();
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
                    this.aFa = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.AD().putInt("conn_conf", this.aFa);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aFb.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.c.AD().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.c.AD().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    y(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    z(optJSONObject5);
                }
                this.aFM = jSONObject.optString("client_id");
                com.baidu.live.c.AD().putString("client_id", this.aFM);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aEP = optJSONObject6.optString("pic_url");
                    this.aEQ = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            i iVar = new i();
                            iVar.parseJson(optJSONObject8);
                            this.aER.add(iVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.AD().putString("pic_url", this.aEP);
                com.baidu.live.c.AD().putString(BigdayActivityConfig.JUMP_URL, this.aEQ);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    A(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aGQ = optJSONObject10.optInt("resource_switch");
                    this.aGS = optJSONObject10.optString("photo_url");
                    this.aGR = optJSONObject10.optString("resource_url");
                }
                this.aGT = new QuickImInputData();
                this.aGT.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aGV = aw.B(jSONObject.optJSONObject("guide_follow"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.AD().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject11 != null) {
                    JSONObject optJSONObject12 = optJSONObject11.optJSONObject("rank");
                    if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.c.AD().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.c.AD().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.c.AD().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject13 = optJSONObject11.optJSONObject("guard_seat");
                    if (optJSONObject13 != null) {
                        this.aHi = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aHg = new ak();
                    this.aHg.aIg = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.c.AD().putString("ala_certify_refuse_url", this.aHg.aIg);
                }
                this.aHt = new ac();
                this.aHt.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aHk = new l();
                    this.aHk.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aHu = optJSONObject16.optInt("show_days");
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.AD().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void CB() {
        String string = com.baidu.live.c.AD().getString("ala_prepare_random_title_list", "");
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
            this.aGY = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aGY.add(jSONArray.optString(i));
            }
        }
    }

    private void CC() {
        this.aEK = com.baidu.live.c.AD().getBoolean("map_around_map", false);
        this.aFp = com.baidu.live.c.AD().getBoolean("withdraw_switch", true);
        this.aFK = com.baidu.live.c.AD().getString("withdraw_text", "");
        this.aFD = com.baidu.live.c.AD().getBoolean("use_internal_player_switch", true);
        this.aFA = com.baidu.live.c.AD().getBoolean("use_http_dns_switch", true);
        this.aFB = com.baidu.live.c.AD().getBoolean("use_encode_bframe_switch", false);
        this.aFC = com.baidu.live.c.AD().getBoolean("enable_opt_timestamp_switch", true);
        this.aFE = com.baidu.live.c.AD().getBoolean("live_beauty_open_switch", false);
        this.aFF = com.baidu.live.c.AD().getBoolean("live_unity_beauty_switch", true);
        this.aFG = com.baidu.live.c.AD().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aFH = com.baidu.live.c.AD().getBoolean("sp_key_live_game_hard_encode", true);
        this.aFI = com.baidu.live.c.AD().getBoolean("sp_key_live_play_transcode_support", false);
        this.aFJ = com.baidu.live.c.AD().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aFL = com.baidu.live.c.AD().getBoolean("ala_enable_graffiti_str", false);
        this.aEL = com.baidu.live.c.AD().getBoolean("enter_live", false);
        this.aEM = com.baidu.live.c.AD().getBoolean("sync_to_forum", true);
        this.aEN = com.baidu.live.c.AD().getBoolean("show_water_mark", false);
        this.aEO = com.baidu.live.c.AD().getBoolean("show_third_part_water_mark_switch", false);
        this.aFh = com.baidu.live.c.AD().getBoolean("stream_error_log", true);
        this.aFi = com.baidu.live.c.AD().getBoolean("disable_channel_in", true);
        this.aFj = com.baidu.live.c.AD().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aFk = com.baidu.live.c.AD().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aFm = com.baidu.live.c.AD().getBoolean("follow_default_push_switch", true);
        this.aFT = com.baidu.live.c.AD().getInt("to_tb_some_switch", 0);
        this.aFR = com.baidu.live.c.AD().getInt("enable_live_stat", 1);
        this.aFS = com.baidu.live.c.AD().getInt("ala_free_gift_task_switch", 0);
        this.aGz = com.baidu.live.c.AD().getBoolean("live_challenge_switch", false);
        this.aGA = com.baidu.live.c.AD().getString("live_challenge_tip", null);
        this.aGB = com.baidu.live.c.AD().getString("live_challenge_url", null);
    }

    private void x(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aEK = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.AD().putBoolean("map_around_map", this.aEK);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aFp = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("withdraw_switch", this.aFp);
                this.aFK = optJSONObject2.optString("text");
                com.baidu.live.c.AD().putString("withdraw_text", this.aFK);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aFD = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("use_internal_player_switch", this.aFD);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aFA = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("use_http_dns_switch", this.aFA);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aFB = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("use_encode_bframe_switch", this.aFB);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aFC = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("enable_opt_timestamp_switch", this.aFC);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.aFE = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("live_beauty_open_switch", this.aFE);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.aFF = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("live_unity_beauty_switch", this.aFF);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.aFG = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("live_unity_beauty_face_style_switch", this.aFG);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.aFH = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("sp_key_live_game_hard_encode", this.aFH);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.aFI = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("sp_key_live_play_transcode_support", this.aFI);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.aFJ = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("sp_key_live_play_attention_guide_support", this.aFJ);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.aEL = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("enter_live", this.aEL);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.aEM = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean("sync_to_forum", this.aEM);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.aEN = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean("show_water_mark", this.aEN);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.aEO = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean("show_third_part_water_mark_switch", this.aEO);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.aFR = optJSONObject17.optInt("switch");
                com.baidu.live.c.AD().putInt("enable_live_stat", this.aFR);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.aFh = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("stream_error_log", this.aFh);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.aFi = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean("disable_channel_in", this.aFi);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.aFj = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean("shoubai_yanzhi_tab_tip", this.aFj);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.aFk = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aFk);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.aFm = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.c.AD().putBoolean("follow_default_push_switch", this.aFm);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.aFT = optJSONObject23.optInt("switch");
                com.baidu.live.c.AD().putInt("to_tb_some_switch", this.aFT);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.aFS = optJSONObject24.optInt("switch");
                com.baidu.live.c.AD().putInt("ala_free_gift_task_switch", this.aFT);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.aFL = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("ala_enable_graffiti_str", this.aFL);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aGz = optJSONObject26.optInt("switch") == 1;
                this.aGA = optJSONObject26.optString("title");
                this.aGB = optJSONObject26.optString("url");
                com.baidu.live.c.AD().putBoolean("live_challenge_switch", this.aGz);
                com.baidu.live.c.AD().putString("live_challenge_tip", this.aGA);
                com.baidu.live.c.AD().putString("live_challenge_url", this.aGB);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aGH = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("is_new_gift_t_dou_strategy", this.aGH);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aGL = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aGJ = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("key_is_open_login_prove", this.aGJ);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aGK = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("key_is_open_diamond", this.aGK);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aGM = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("key_is_jump_to_live_room", this.aGM);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aHh = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aHl = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void CD() {
        JSONArray jSONArray;
        this.aFf = com.baidu.live.c.AD().getString("bluediamond_url", "");
        this.aEV = com.baidu.live.c.AD().getString("verify_content", this.aEV);
        this.aEU = com.baidu.live.c.AD().getString("live_notice", "");
        String string = com.baidu.live.c.AD().getString("imNotice", "");
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
                        this.aET.add(i, optString);
                    }
                }
            }
        }
        this.aFN = com.baidu.live.c.AD().getString("share_host", "");
        this.aFO = com.baidu.live.c.AD().getString("ala_share_in_bar_notice_text", "");
        this.aFQ = com.baidu.live.c.AD().getString("ala_share_reward_rank_notice_text", "");
        this.aFP = com.baidu.live.c.AD().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aFg = com.baidu.live.c.AD().getInt("recommend_refresh", 60);
        this.aFn = com.baidu.live.c.AD().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aFo = com.baidu.live.c.AD().getInt("strategy_exception_interval", 1);
        this.aFl = com.baidu.live.c.AD().getInt("liveStartAuthLevel", 1);
        this.aFc = com.baidu.live.c.AD().getInt("2gTo", 5);
        this.aFd = com.baidu.live.c.AD().getInt("3gTo", 3);
        this.aFe = com.baidu.live.c.AD().getInt("wifiTo", 3);
        String string2 = com.baidu.live.c.AD().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aEY = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.c.AD().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aEZ = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aFU = com.baidu.live.c.AD().getInt("square_tab_strategy", 1);
        this.aFV = com.baidu.live.c.AD().getString("ala_live_ranklist_url", null);
        this.aFW = com.baidu.live.c.AD().getString("new_flower_rank_list_description_url", "");
        this.aFX = com.baidu.live.c.AD().getString("ala_game_player_signup_url", null);
        this.aFY = com.baidu.live.c.AD().getString("ala_game_frs_live_tab_video_url", null);
        CH();
        this.aGf = com.baidu.live.c.AD().getString("ala_personal_income_detail_url", null);
        this.aGE = com.baidu.live.c.AD().getInt("ala_custom_gift_category_id", -1);
        this.aGg = com.baidu.live.c.AD().getInt("ala_live_pk_switch", 0) == 1;
        this.aGh = com.baidu.live.c.AD().getLong("ala_live_pk_check_interval", 1000L);
        this.aGi = com.baidu.live.c.AD().getLong("ala_live_pk_match_timeout", 60000L);
        this.aGj = com.baidu.live.c.AD().getString("ala_live_pk_pic_url", "");
        this.aGk = com.baidu.live.c.AD().getString("ala_live_pk_pic_jump_url", "");
        this.aGl = com.baidu.live.c.AD().getString("ala_live_pk_history_link", "");
        this.aGm = com.baidu.live.c.AD().getString("show_live_forum_url", "");
        this.aGn = com.baidu.live.c.AD().getLong("ala_challenge_random_interval", 1000L);
        this.aGo = com.baidu.live.c.AD().getLong("ala_challenge_direct_interval", 1000L);
        this.aGp = com.baidu.live.c.AD().getLong("ala_get_challenge_info_interval", 1000L);
        this.aGr = com.baidu.live.c.AD().getString("ala_challenge_pk_entry_icon_url", "");
        this.aGs = com.baidu.live.c.AD().getString("ala_challenge_pk_entry_icon_url", "");
        this.aGq = com.baidu.live.c.AD().getString("ala_challenge_pk_entry_icon_url", "");
        this.aGt = com.baidu.live.c.AD().getInt("punish_stage_button_switch", 0);
        this.aGu = com.baidu.live.c.AD().getInt("receive_challenge_im_show_time", 0);
        this.aGv = com.baidu.live.c.AD().getInt("mvpPunishSwitch", 0);
        this.aGw = com.baidu.live.c.AD().getInt("toastLifeTime", 10);
        this.aGx = com.baidu.live.c.AD().getInt("punishLifeTime", 60);
        this.aGF = com.baidu.live.c.AD().getBoolean("ala_guess_use_https", false);
        fS(com.baidu.live.c.AD().getString("ala_live_bar_map_str", ""));
        this.aGG = com.baidu.live.c.AD().getBoolean("is_new_live_close_strategy", false);
        this.aGH = com.baidu.live.c.AD().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aGI = com.baidu.live.c.AD().getString("ala_feedback_url", null);
        this.aFq = com.baidu.live.c.AD().getInt("ala_video_resolution_level", 3);
        this.aFr = com.baidu.live.c.AD().getBoolean("ala_live_hard_encode_switch", true);
        this.aFs = com.baidu.live.c.AD().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.AD().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.AD().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.AD().getInt("ala_video_increase_count", 3);
        this.aFt = com.baidu.live.c.AD().getString("ala_video_soft_bitrate_config", null);
        this.aFu = com.baidu.live.c.AD().getString("ala_video_hard_bitrate_config", null);
        this.aFy = com.baidu.live.c.AD().getInt("ala_master_chat_video_resolution_level", 3);
        this.aFz = com.baidu.live.c.AD().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aFv = com.baidu.live.c.AD().getString("ala_avts_stream_server_domain_config", null);
        this.aFw = com.baidu.live.c.AD().getString("ala_master_chat_video_bitrate_config", null);
        this.aFx = com.baidu.live.c.AD().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.AD().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.AD().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aGJ = com.baidu.live.c.AD().getBoolean("key_is_open_login_prove", false);
        this.aGK = com.baidu.live.c.AD().getBoolean("key_is_open_diamond", false);
        this.aGM = com.baidu.live.c.AD().getBoolean("key_is_jump_to_live_room", false);
        fQ(com.baidu.live.c.AD().getString("feed_diversion", ""));
        CG();
    }

    private void fQ(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aHj = new AlaFeedDiversionData();
                this.aHj.parserJson(jSONObject);
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
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject2 != null) {
                this.aEJ = optJSONObject2.optString("toast");
                this.aEI = optJSONObject2.optInt("remind_type");
            }
            this.aFf = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.AD().putString("bluediamond_url", this.aFf);
            this.aEV = jSONObject.optString("verify_content");
            com.baidu.live.c.AD().putString("verify_content", this.aEV);
            this.aEU = jSONObject.optString("live_notice");
            com.baidu.live.c.AD().putString("live_notice", this.aEU);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aET.add(i, optString);
                    }
                }
                com.baidu.live.c.AD().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.c.AD().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.aEW.add(i2, optString2);
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
                        this.aES.add(iVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aEX.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.aFN = optJSONObject5.optString("url");
            } else {
                this.aFN = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.aFO = optJSONObject6.optString("reward_notice");
                this.aFQ = optJSONObject6.optString("reward_rank_notice");
                this.aFP = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.aFO = "";
                this.aFQ = "";
                this.aFP = 2;
            }
            com.baidu.live.c.AD().putString("share_host", this.aFN);
            com.baidu.live.c.AD().putString("ala_share_in_bar_notice_text", this.aFO);
            com.baidu.live.c.AD().putString("ala_share_reward_rank_notice_text", this.aFQ);
            com.baidu.live.c.AD().putInt("ala_share_in_bar_notice_tip_switch", this.aFP);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.aFg = optJSONObject7.optInt("value");
            } else {
                this.aFg = 60;
            }
            com.baidu.live.c.AD().putInt("recommend_refresh", this.aFg);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.AD().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aEY = g(optJSONArray5);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject9 != null) {
                JSONArray optJSONArray6 = optJSONObject9.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.AD().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aEZ = g(optJSONArray6);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject10 != null) {
                this.aFn = optJSONObject10.optString("time_interval");
                this.aFo = optJSONObject10.optInt("exception_interval");
            } else {
                this.aFn = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aFo = 1;
            }
            com.baidu.live.c.AD().putString("strategy_conf", this.aFn);
            com.baidu.live.c.AD().putInt("strategy_exception_interval", this.aFo);
            this.aFl = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.AD().putInt("liveStartAuthLevel", this.aFl);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject11 != null) {
                this.aFc = optJSONObject11.optInt("2gTo");
                if (this.aFc < 3) {
                    this.aFc = 3;
                }
                this.aFd = optJSONObject11.optInt("3gTo");
                if (this.aFd < 3) {
                    this.aFd = 3;
                }
                this.aFe = optJSONObject11.optInt("wifiTo");
                if (this.aFe < 3) {
                    this.aFe = 3;
                }
                com.baidu.live.c.AD().putInt("2gTo", this.aFc);
                com.baidu.live.c.AD().putInt("3gTo", this.aFd);
                com.baidu.live.c.AD().putInt("wifiTo", this.aFe);
            }
            this.aFU = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.AD().putInt("square_tab_strategy", this.aFU);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject12 != null) {
                this.aFV = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
                this.aFW = optJSONObject12.optString("flower_rank_rule");
            }
            com.baidu.live.c.AD().putString("ala_live_ranklist_url", this.aFV);
            com.baidu.live.c.AD().putString("new_flower_rank_list_description_url", this.aFW);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject13 != null) {
                this.aFX = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.AD().putString("ala_game_player_signup_url", this.aFX);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject14 != null) {
                this.aFY = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.AD().putString("ala_game_frs_live_tab_video_url", this.aFY);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject15 != null) {
                this.aFZ = optJSONObject15.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.AD().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aGa.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject16 != null) {
                com.baidu.live.c.AD().putString("ala_live_session_replace_key", optJSONObject16.toString());
                this.aGd = optJSONObject16.optString("hlsUrl");
                this.aGb = optJSONObject16.optString("rtmpUrl");
                this.aGc = optJSONObject16.optString("flvUrl");
                this.aGe = optJSONObject16.optString(".m3u8");
            }
            b(true, this.aFZ);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject17 != null) {
                this.aGf = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.AD().putString("ala_personal_income_detail_url", this.aGf);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject18 != null) {
                this.aGE = optJSONObject18.optInt("android_show");
                com.baidu.live.c.AD().putInt("ala_custom_gift_category_id", this.aGE);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject19 != null) {
                int optInt = optJSONObject19.optInt("open", 0);
                this.aGg = optInt == 1;
                com.baidu.live.c.AD().putInt("ala_live_pk_switch", optInt);
                this.aGh = optJSONObject19.optLong("interval");
                if (this.aGh < 1000) {
                    this.aGh = 1000L;
                }
                com.baidu.live.c.AD().putLong("ala_live_pk_check_interval", this.aGh);
                this.aGi = optJSONObject19.optLong("match_timeout");
                if (this.aGi < 60000) {
                    this.aGi = 60000L;
                }
                com.baidu.live.c.AD().putLong("ala_live_pk_match_timeout", this.aGi);
                this.aGj = optJSONObject19.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.AD().putString("ala_live_pk_pic_url", this.aGj);
                this.aGk = optJSONObject19.optString("rank_link");
                com.baidu.live.c.AD().putString("ala_live_pk_pic_jump_url", this.aGk);
                this.aGl = optJSONObject19.optString("history_link");
                com.baidu.live.c.AD().putString("ala_live_pk_history_link", this.aGl);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject20 != null) {
                this.aGn = optJSONObject20.optLong("random_interval");
                if (this.aGn < 1000) {
                    this.aGn = 1000L;
                }
                com.baidu.live.c.AD().putLong("ala_challenge_random_interval", this.aGn);
                this.aGo = optJSONObject20.optLong("direct_interval");
                if (this.aGo < 1000) {
                    this.aGo = 1000L;
                }
                com.baidu.live.c.AD().putLong("ala_challenge_direct_interval", this.aGo);
                this.aGp = optJSONObject20.optLong("challenge_info_interval");
                if (this.aGp < 1000) {
                    this.aGp = 1000L;
                }
                com.baidu.live.c.AD().putLong("ala_get_challenge_info_interval", this.aGp);
                this.aGr = optJSONObject20.optString("pk_icon_url");
                com.baidu.live.c.AD().putString("ala_challenge_pk_entry_icon_url", this.aGr);
                this.aGs = optJSONObject20.optString("icon_url");
                com.baidu.live.c.AD().putString("ala_challenge_pk_entry_icon_url", this.aGs);
                this.aGq = optJSONObject20.optString("rule_url");
                com.baidu.live.c.AD().putString("ala_challenge_pk_entry_icon_url", this.aGq);
                this.aGt = optJSONObject20.optInt("punish_stage_button_switch");
                com.baidu.live.c.AD().putInt("punish_stage_button_switch", this.aGt);
                this.aGu = optJSONObject20.optInt("receive_challenge_im_show_time");
                com.baidu.live.c.AD().putInt("receive_challenge_im_show_time", this.aGu);
                this.aGv = optJSONObject20.optInt("mvpPunishSwitch");
                com.baidu.live.c.AD().putInt("mvpPunishSwitch", this.aGv);
                this.aGw = optJSONObject20.optInt("toastLifeTime");
                com.baidu.live.c.AD().putInt("toastLifeTime", this.aGw);
                this.aGx = optJSONObject20.optInt("punishLifeTime");
                com.baidu.live.c.AD().putInt("punishLifeTime", this.aGx);
                this.aGy = optJSONObject20.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject21 != null) {
                this.aGm = optJSONObject21.optString("go_url");
                com.baidu.live.c.AD().putString("show_live_forum_url", this.aGm);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject22 != null) {
                this.aGF = optJSONObject22.optInt("use_https", 0) == 1;
                com.baidu.live.c.AD().putBoolean("ala_guess_use_https", this.aGF);
            }
            String optString3 = jSONObject.optString("live_bar");
            fS(optString3);
            com.baidu.live.c.AD().putString("ala_live_bar_map_str", optString3);
            this.aGG = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.AD().putBoolean("is_new_live_close_strategy", this.aGG);
            this.aGH = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.AD().putBoolean("is_new_gift_t_dou_strategy", this.aGH);
            this.aGI = jSONObject.optString("feedback_url");
            com.baidu.live.c.AD().putString("ala_feedback_url", this.aGI);
            JSONObject optJSONObject23 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject23 != null && (optJSONObject = optJSONObject23.optJSONObject("challenge_related_zip")) != null) {
                this.aGC = optJSONObject.optString("zip_md5");
                this.aGD = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject24 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject24.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject24.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.AD().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.AD().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("open_live");
            if (optJSONObject25 != null) {
                this.increaseThreshold = optJSONObject25.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.AD().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject25.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.AD().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject25.optInt("thi_count", 3);
                com.baidu.live.c.AD().putInt("ala_video_increase_count", this.increaseCount);
                this.aFr = optJSONObject25.optInt("encoder", 1) == 1;
                com.baidu.live.c.AD().putBoolean("ala_live_hard_encode_switch", this.aFr);
                this.aFs = optJSONObject25.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.AD().putBoolean("ala_dynamic_bitrate_switch", this.aFs);
                this.aFq = optJSONObject25.optInt("resolution", 3);
                com.baidu.live.c.AD().putInt("ala_video_resolution_level", this.aFq);
                JSONArray optJSONArray8 = optJSONObject25.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aFt = optJSONArray8.toString();
                    com.baidu.live.c.AD().putString("ala_video_soft_bitrate_config", this.aFt);
                }
                JSONArray optJSONArray9 = optJSONObject25.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aFu = optJSONArray9.toString();
                    com.baidu.live.c.AD().putString("ala_video_hard_bitrate_config", this.aFu);
                }
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject26 != null) {
                this.aFv = optJSONObject26.toString();
                com.baidu.live.c.AD().putString("ala_avts_stream_server_domain_config", this.aFv);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject27 != null) {
                this.aFy = optJSONObject27.optInt("host_rtc_resolution", 3);
                com.baidu.live.c.AD().putInt("ala_master_chat_video_resolution_level", this.aFy);
                this.aFz = optJSONObject27.optInt("rtc_resolution", 4);
                com.baidu.live.c.AD().putInt("ala_slave_chat_video_resolution_level", this.aFz);
                JSONArray optJSONArray10 = optJSONObject27.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aFw = optJSONArray10.toString();
                    com.baidu.live.c.AD().putString("ala_master_chat_video_bitrate_config", this.aFw);
                }
                JSONArray optJSONArray11 = optJSONObject27.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aFx = optJSONArray11.toString();
                    com.baidu.live.c.AD().putString("ala_slave_chat_video_bitrate_config", this.aFx);
                }
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject28 != null) {
                this.aHo = optJSONObject28.optInt("enter_live_msg_audience_num_p1");
                this.aHp = optJSONObject28.optInt("enter_live_msg_audience_num_p2");
                this.aHq = optJSONObject28.optInt("enter_live_msg_audience_num_p3");
                this.aHm = optJSONObject28.optInt("im_intercept_switch");
                this.aHn = optJSONObject28.optInt("is_check_im_content");
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject29 != null) {
                this.aHj = new AlaFeedDiversionData();
                this.aHj.parserJson(optJSONObject29);
                com.baidu.live.c.AD().putString("feed_diversion", optJSONObject29.toString());
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject30 != null) {
                com.baidu.live.c.AD().putString("key_stat_switch", optJSONObject30.toString());
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject31 != null) {
                this.aHr = optJSONObject31.optInt("unfold_interval", 5000);
                this.aHs = optJSONObject31.optInt("fold_interval", 55000);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGZ = jSONObject.optInt("im_max", 200);
            if (this.aGZ <= 0) {
                this.aGZ = 200;
            }
            this.aHa = jSONObject.optInt("barrage_max", 100);
            if (this.aHa <= 0) {
                this.aHa = 100;
            }
            this.aHb = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aHb <= 0) {
                this.aHb = 10;
            }
            this.aHc = jSONObject.optInt("enter_effect_max", 10);
            if (this.aHc <= 0) {
                this.aHc = 10;
            }
            this.aHd = jSONObject.optInt("gift_big_max", 10);
            if (this.aHd <= 0) {
                this.aHd = 10;
            }
            this.aHe = jSONObject.optInt("gift_small_max", 50);
            if (this.aHe <= 0) {
                this.aHe = 50;
            }
            this.aHf = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aHf <= 0) {
                this.aHf = 5;
            }
        }
    }

    private void CE() {
        this.aGN = com.baidu.live.c.AD().getInt("guide_speak_watch_time", 15000);
        this.aGO = com.baidu.live.c.AD().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.AD().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aGP = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aGP[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void A(JSONObject jSONObject) {
        int length;
        this.aGN = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.c.AD().putInt("guide_speak_watch_time", this.aGN);
        this.aGO = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.AD().putInt("guide_speak_show_times_max", this.aGO);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aGP = new String[length];
            for (int i = 0; i < length; i++) {
                this.aGP[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.AD().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void CF() {
        String string = com.baidu.live.c.AD().getString("yuan_package_data", "");
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
            this.aGU = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aGU.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void fR(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aGW = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aGW.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aGX = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aGX.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.AD().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void CG() {
        fR(com.baidu.live.c.AD().getString("ala_quick_send_im_list", null));
    }

    private void fS(String str) {
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
        if (i != this.aFZ) {
            z2 = true;
        }
        this.aFZ = i;
        if (z || z2) {
            com.baidu.live.c.AD().putInt("ala_live_session_default_key", i);
        }
    }

    private void CH() {
        this.aFZ = com.baidu.live.c.AD().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.AD().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aGa.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.AD().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aGd = jSONObject.optString("hlsUrl");
                this.aGb = jSONObject.optString("rtmpUrl");
                this.aGc = jSONObject.optString("flvUrl");
                this.aGe = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean CI() {
        return this.aFS == 1;
    }
}
