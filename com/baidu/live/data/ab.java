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
    public boolean aEM;
    public boolean aEN;
    public boolean aEO;
    public boolean aEP;
    public boolean aEQ;
    public String aER;
    public String aES;
    public String aEW;
    public String aEX;
    public int aFA;
    public int aFB;
    public boolean aFC;
    public boolean aFD;
    public boolean aFE;
    public boolean aFF;
    public boolean aFG;
    public boolean aFH;
    public boolean aFI;
    public String aFM;
    public String aFO;
    public String aFP;
    public int aFV;
    public String aFX;
    public String aFY;
    private String aFZ;
    public Integer[] aFa;
    public Integer[] aFb;
    public int aFc;
    public int aFe;
    public int aFf;
    public int aFg;
    public String aFh;
    public int aFi;
    public boolean aFj;
    public boolean aFk;
    public boolean aFl;
    public boolean aFm;
    public boolean aFo;
    public String aFp;
    public int aFq;
    public boolean aFr;
    public int aFs;
    public boolean aFt;
    public boolean aFu;
    public String aFv;
    public String aFw;
    public String aFx;
    public String aFy;
    public String aFz;
    public String aGC;
    public String aGD;
    public String aGE;
    public String aGF;
    public int aGG;
    public String aGK;
    public int aGP;
    public int aGQ;
    public String[] aGR;
    public int aGS;
    public String aGT;
    public String aGU;
    public QuickImInputData aGV;
    public List<YuanPackageData> aGW;
    public aw aGX;
    public List<String> aGY;
    public List<String> aGZ;
    private String aGa;
    public int aGb;
    public String aGd;
    public String aGe;
    public String aGf;
    public String aGg;
    public String aGh;
    public boolean aGi;
    public long aGj;
    public long aGk;
    public String aGl;
    public String aGm;
    public String aGn;
    public String aGo;
    public long aGp;
    public long aGq;
    public long aGr;
    public String aGs;
    public String aGt;
    public String aGu;
    public int aGv;
    public int aGw;
    public int aGx;
    public List<String> aHa;
    public ak aHi;
    public boolean aHj;
    public String aHk;
    public AlaFeedDiversionData aHl;
    public l aHm;
    public boolean aHn;
    public int aHo;
    public int aHp;
    public ac aHv;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aEK = -1;
    public String aEL = null;
    public int aFn = 1;
    public boolean aFJ = true;
    public boolean aFK = false;
    public boolean aFL = false;
    public boolean aFN = false;
    public String aFQ = "";
    private int aFR = 2;
    public String aFS = "";
    public int aFT = 1;
    public int aFU = 0;
    public int aFW = 1;
    public List<String> aGc = new ArrayList();
    public int aGy = 10;
    public int aGz = 60;
    public long aGA = 10000;
    public boolean aGB = false;
    public boolean aGH = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aGI = false;
    public boolean aGJ = false;
    public boolean aGL = false;
    public boolean aGM = false;
    public boolean aGN = false;
    public boolean aGO = false;
    public int aHb = 200;
    public int aHc = 100;
    public int aHd = 10;
    public int aHe = 10;
    public int aHf = 10;
    public int aHg = 50;
    public int aHh = 5;
    public int aHq = 20;
    public int aHr = 70;
    public int aHs = 10000;
    public int aHt = 5000;
    public int aHu = 55000;
    public int aHw = 7;
    public List<String> aEV = new ArrayList();
    public List<String> aFd = new ArrayList();
    public List<String> aEY = new ArrayList();
    public List<Integer> aEZ = new ArrayList();
    public ArrayList<i> aET = new ArrayList<>();
    public ArrayList<i> aEU = new ArrayList<>();

    public ab(boolean z) {
        if (z) {
            CC();
            this.aFc = com.baidu.live.c.AD().getInt("conn_conf", 0);
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
                    this.aFc = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.AD().putInt("conn_conf", this.aFc);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aFd.add(i, optString);
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
                this.aFO = jSONObject.optString("client_id");
                com.baidu.live.c.AD().putString("client_id", this.aFO);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aER = optJSONObject6.optString("pic_url");
                    this.aES = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            i iVar = new i();
                            iVar.parseJson(optJSONObject8);
                            this.aET.add(iVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.AD().putString("pic_url", this.aER);
                com.baidu.live.c.AD().putString(BigdayActivityConfig.JUMP_URL, this.aES);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    A(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aGS = optJSONObject10.optInt("resource_switch");
                    this.aGU = optJSONObject10.optString("photo_url");
                    this.aGT = optJSONObject10.optString("resource_url");
                }
                this.aGV = new QuickImInputData();
                this.aGV.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aGX = aw.B(jSONObject.optJSONObject("guide_follow"));
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
                        this.aHk = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aHi = new ak();
                    this.aHi.aIi = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.c.AD().putString("ala_certify_refuse_url", this.aHi.aIi);
                }
                this.aHv = new ac();
                this.aHv.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aHm = new l();
                    this.aHm.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aHw = optJSONObject16.optInt("show_days");
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
            this.aHa = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aHa.add(jSONArray.optString(i));
            }
        }
    }

    private void CC() {
        this.aEM = com.baidu.live.c.AD().getBoolean("map_around_map", false);
        this.aFr = com.baidu.live.c.AD().getBoolean("withdraw_switch", true);
        this.aFM = com.baidu.live.c.AD().getString("withdraw_text", "");
        this.aFF = com.baidu.live.c.AD().getBoolean("use_internal_player_switch", true);
        this.aFC = com.baidu.live.c.AD().getBoolean("use_http_dns_switch", true);
        this.aFD = com.baidu.live.c.AD().getBoolean("use_encode_bframe_switch", false);
        this.aFE = com.baidu.live.c.AD().getBoolean("enable_opt_timestamp_switch", true);
        this.aFG = com.baidu.live.c.AD().getBoolean("live_beauty_open_switch", false);
        this.aFH = com.baidu.live.c.AD().getBoolean("live_unity_beauty_switch", true);
        this.aFI = com.baidu.live.c.AD().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aFJ = com.baidu.live.c.AD().getBoolean("sp_key_live_game_hard_encode", true);
        this.aFK = com.baidu.live.c.AD().getBoolean("sp_key_live_play_transcode_support", false);
        this.aFL = com.baidu.live.c.AD().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aFN = com.baidu.live.c.AD().getBoolean("ala_enable_graffiti_str", false);
        this.aEN = com.baidu.live.c.AD().getBoolean("enter_live", false);
        this.aEO = com.baidu.live.c.AD().getBoolean("sync_to_forum", true);
        this.aEP = com.baidu.live.c.AD().getBoolean("show_water_mark", false);
        this.aEQ = com.baidu.live.c.AD().getBoolean("show_third_part_water_mark_switch", false);
        this.aFj = com.baidu.live.c.AD().getBoolean("stream_error_log", true);
        this.aFk = com.baidu.live.c.AD().getBoolean("disable_channel_in", true);
        this.aFl = com.baidu.live.c.AD().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aFm = com.baidu.live.c.AD().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aFo = com.baidu.live.c.AD().getBoolean("follow_default_push_switch", true);
        this.aFV = com.baidu.live.c.AD().getInt("to_tb_some_switch", 0);
        this.aFT = com.baidu.live.c.AD().getInt("enable_live_stat", 1);
        this.aFU = com.baidu.live.c.AD().getInt("ala_free_gift_task_switch", 0);
        this.aGB = com.baidu.live.c.AD().getBoolean("live_challenge_switch", false);
        this.aGC = com.baidu.live.c.AD().getString("live_challenge_tip", null);
        this.aGD = com.baidu.live.c.AD().getString("live_challenge_url", null);
    }

    private void x(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aEM = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.AD().putBoolean("map_around_map", this.aEM);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aFr = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("withdraw_switch", this.aFr);
                this.aFM = optJSONObject2.optString("text");
                com.baidu.live.c.AD().putString("withdraw_text", this.aFM);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aFF = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("use_internal_player_switch", this.aFF);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aFC = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("use_http_dns_switch", this.aFC);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aFD = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("use_encode_bframe_switch", this.aFD);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aFE = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("enable_opt_timestamp_switch", this.aFE);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.aFG = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("live_beauty_open_switch", this.aFG);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.aFH = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("live_unity_beauty_switch", this.aFH);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.aFI = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("live_unity_beauty_face_style_switch", this.aFI);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.aFJ = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("sp_key_live_game_hard_encode", this.aFJ);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.aFK = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("sp_key_live_play_transcode_support", this.aFK);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.aFL = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("sp_key_live_play_attention_guide_support", this.aFL);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.aEN = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("enter_live", this.aEN);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.aEO = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean("sync_to_forum", this.aEO);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.aEP = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean("show_water_mark", this.aEP);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.aEQ = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean("show_third_part_water_mark_switch", this.aEQ);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.aFT = optJSONObject17.optInt("switch");
                com.baidu.live.c.AD().putInt("enable_live_stat", this.aFT);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.aFj = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("stream_error_log", this.aFj);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.aFk = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean("disable_channel_in", this.aFk);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.aFl = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean("shoubai_yanzhi_tab_tip", this.aFl);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.aFm = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.c.AD().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aFm);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.aFo = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.c.AD().putBoolean("follow_default_push_switch", this.aFo);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.aFV = optJSONObject23.optInt("switch");
                com.baidu.live.c.AD().putInt("to_tb_some_switch", this.aFV);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.aFU = optJSONObject24.optInt("switch");
                com.baidu.live.c.AD().putInt("ala_free_gift_task_switch", this.aFV);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.aFN = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("ala_enable_graffiti_str", this.aFN);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aGB = optJSONObject26.optInt("switch") == 1;
                this.aGC = optJSONObject26.optString("title");
                this.aGD = optJSONObject26.optString("url");
                com.baidu.live.c.AD().putBoolean("live_challenge_switch", this.aGB);
                com.baidu.live.c.AD().putString("live_challenge_tip", this.aGC);
                com.baidu.live.c.AD().putString("live_challenge_url", this.aGD);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aGJ = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("is_new_gift_t_dou_strategy", this.aGJ);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aGN = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aGL = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("key_is_open_login_prove", this.aGL);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aGM = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("key_is_open_diamond", this.aGM);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aGO = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.c.AD().putBoolean("key_is_jump_to_live_room", this.aGO);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aHj = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aHn = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void CD() {
        JSONArray jSONArray;
        this.aFh = com.baidu.live.c.AD().getString("bluediamond_url", "");
        this.aEX = com.baidu.live.c.AD().getString("verify_content", this.aEX);
        this.aEW = com.baidu.live.c.AD().getString("live_notice", "");
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
                        this.aEV.add(i, optString);
                    }
                }
            }
        }
        this.aFP = com.baidu.live.c.AD().getString("share_host", "");
        this.aFQ = com.baidu.live.c.AD().getString("ala_share_in_bar_notice_text", "");
        this.aFS = com.baidu.live.c.AD().getString("ala_share_reward_rank_notice_text", "");
        this.aFR = com.baidu.live.c.AD().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aFi = com.baidu.live.c.AD().getInt("recommend_refresh", 60);
        this.aFp = com.baidu.live.c.AD().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aFq = com.baidu.live.c.AD().getInt("strategy_exception_interval", 1);
        this.aFn = com.baidu.live.c.AD().getInt("liveStartAuthLevel", 1);
        this.aFe = com.baidu.live.c.AD().getInt("2gTo", 5);
        this.aFf = com.baidu.live.c.AD().getInt("3gTo", 3);
        this.aFg = com.baidu.live.c.AD().getInt("wifiTo", 3);
        String string2 = com.baidu.live.c.AD().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aFa = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.c.AD().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aFb = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aFW = com.baidu.live.c.AD().getInt("square_tab_strategy", 1);
        this.aFX = com.baidu.live.c.AD().getString("ala_live_ranklist_url", null);
        this.aFY = com.baidu.live.c.AD().getString("new_flower_rank_list_description_url", "");
        this.aFZ = com.baidu.live.c.AD().getString("ala_game_player_signup_url", null);
        this.aGa = com.baidu.live.c.AD().getString("ala_game_frs_live_tab_video_url", null);
        CH();
        this.aGh = com.baidu.live.c.AD().getString("ala_personal_income_detail_url", null);
        this.aGG = com.baidu.live.c.AD().getInt("ala_custom_gift_category_id", -1);
        this.aGi = com.baidu.live.c.AD().getInt("ala_live_pk_switch", 0) == 1;
        this.aGj = com.baidu.live.c.AD().getLong("ala_live_pk_check_interval", 1000L);
        this.aGk = com.baidu.live.c.AD().getLong("ala_live_pk_match_timeout", 60000L);
        this.aGl = com.baidu.live.c.AD().getString("ala_live_pk_pic_url", "");
        this.aGm = com.baidu.live.c.AD().getString("ala_live_pk_pic_jump_url", "");
        this.aGn = com.baidu.live.c.AD().getString("ala_live_pk_history_link", "");
        this.aGo = com.baidu.live.c.AD().getString("show_live_forum_url", "");
        this.aGp = com.baidu.live.c.AD().getLong("ala_challenge_random_interval", 1000L);
        this.aGq = com.baidu.live.c.AD().getLong("ala_challenge_direct_interval", 1000L);
        this.aGr = com.baidu.live.c.AD().getLong("ala_get_challenge_info_interval", 1000L);
        this.aGt = com.baidu.live.c.AD().getString("ala_challenge_pk_entry_icon_url", "");
        this.aGu = com.baidu.live.c.AD().getString("ala_challenge_pk_entry_icon_url", "");
        this.aGs = com.baidu.live.c.AD().getString("ala_challenge_pk_entry_icon_url", "");
        this.aGv = com.baidu.live.c.AD().getInt("punish_stage_button_switch", 0);
        this.aGw = com.baidu.live.c.AD().getInt("receive_challenge_im_show_time", 0);
        this.aGx = com.baidu.live.c.AD().getInt("mvpPunishSwitch", 0);
        this.aGy = com.baidu.live.c.AD().getInt("toastLifeTime", 10);
        this.aGz = com.baidu.live.c.AD().getInt("punishLifeTime", 60);
        this.aGH = com.baidu.live.c.AD().getBoolean("ala_guess_use_https", false);
        fT(com.baidu.live.c.AD().getString("ala_live_bar_map_str", ""));
        this.aGI = com.baidu.live.c.AD().getBoolean("is_new_live_close_strategy", false);
        this.aGJ = com.baidu.live.c.AD().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aGK = com.baidu.live.c.AD().getString("ala_feedback_url", null);
        this.aFs = com.baidu.live.c.AD().getInt("ala_video_resolution_level", 3);
        this.aFt = com.baidu.live.c.AD().getBoolean("ala_live_hard_encode_switch", true);
        this.aFu = com.baidu.live.c.AD().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.AD().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.AD().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.AD().getInt("ala_video_increase_count", 3);
        this.aFv = com.baidu.live.c.AD().getString("ala_video_soft_bitrate_config", null);
        this.aFw = com.baidu.live.c.AD().getString("ala_video_hard_bitrate_config", null);
        this.aFA = com.baidu.live.c.AD().getInt("ala_master_chat_video_resolution_level", 3);
        this.aFB = com.baidu.live.c.AD().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aFx = com.baidu.live.c.AD().getString("ala_avts_stream_server_domain_config", null);
        this.aFy = com.baidu.live.c.AD().getString("ala_master_chat_video_bitrate_config", null);
        this.aFz = com.baidu.live.c.AD().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.AD().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.AD().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aGL = com.baidu.live.c.AD().getBoolean("key_is_open_login_prove", false);
        this.aGM = com.baidu.live.c.AD().getBoolean("key_is_open_diamond", false);
        this.aGO = com.baidu.live.c.AD().getBoolean("key_is_jump_to_live_room", false);
        fR(com.baidu.live.c.AD().getString("feed_diversion", ""));
        CG();
    }

    private void fR(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aHl = new AlaFeedDiversionData();
                this.aHl.parserJson(jSONObject);
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
                this.aEL = optJSONObject2.optString("toast");
                this.aEK = optJSONObject2.optInt("remind_type");
            }
            this.aFh = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.AD().putString("bluediamond_url", this.aFh);
            this.aEX = jSONObject.optString("verify_content");
            com.baidu.live.c.AD().putString("verify_content", this.aEX);
            this.aEW = jSONObject.optString("live_notice");
            com.baidu.live.c.AD().putString("live_notice", this.aEW);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aEV.add(i, optString);
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
                        this.aEY.add(i2, optString2);
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
                        this.aEU.add(iVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aEZ.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.aFP = optJSONObject5.optString("url");
            } else {
                this.aFP = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.aFQ = optJSONObject6.optString("reward_notice");
                this.aFS = optJSONObject6.optString("reward_rank_notice");
                this.aFR = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.aFQ = "";
                this.aFS = "";
                this.aFR = 2;
            }
            com.baidu.live.c.AD().putString("share_host", this.aFP);
            com.baidu.live.c.AD().putString("ala_share_in_bar_notice_text", this.aFQ);
            com.baidu.live.c.AD().putString("ala_share_reward_rank_notice_text", this.aFS);
            com.baidu.live.c.AD().putInt("ala_share_in_bar_notice_tip_switch", this.aFR);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.aFi = optJSONObject7.optInt("value");
            } else {
                this.aFi = 60;
            }
            com.baidu.live.c.AD().putInt("recommend_refresh", this.aFi);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.AD().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aFa = g(optJSONArray5);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject9 != null) {
                JSONArray optJSONArray6 = optJSONObject9.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.AD().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aFb = g(optJSONArray6);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject10 != null) {
                this.aFp = optJSONObject10.optString("time_interval");
                this.aFq = optJSONObject10.optInt("exception_interval");
            } else {
                this.aFp = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aFq = 1;
            }
            com.baidu.live.c.AD().putString("strategy_conf", this.aFp);
            com.baidu.live.c.AD().putInt("strategy_exception_interval", this.aFq);
            this.aFn = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.AD().putInt("liveStartAuthLevel", this.aFn);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject11 != null) {
                this.aFe = optJSONObject11.optInt("2gTo");
                if (this.aFe < 3) {
                    this.aFe = 3;
                }
                this.aFf = optJSONObject11.optInt("3gTo");
                if (this.aFf < 3) {
                    this.aFf = 3;
                }
                this.aFg = optJSONObject11.optInt("wifiTo");
                if (this.aFg < 3) {
                    this.aFg = 3;
                }
                com.baidu.live.c.AD().putInt("2gTo", this.aFe);
                com.baidu.live.c.AD().putInt("3gTo", this.aFf);
                com.baidu.live.c.AD().putInt("wifiTo", this.aFg);
            }
            this.aFW = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.AD().putInt("square_tab_strategy", this.aFW);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject12 != null) {
                this.aFX = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
                this.aFY = optJSONObject12.optString("flower_rank_rule");
            }
            com.baidu.live.c.AD().putString("ala_live_ranklist_url", this.aFX);
            com.baidu.live.c.AD().putString("new_flower_rank_list_description_url", this.aFY);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject13 != null) {
                this.aFZ = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.AD().putString("ala_game_player_signup_url", this.aFZ);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject14 != null) {
                this.aGa = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.AD().putString("ala_game_frs_live_tab_video_url", this.aGa);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject15 != null) {
                this.aGb = optJSONObject15.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.AD().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aGc.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject16 != null) {
                com.baidu.live.c.AD().putString("ala_live_session_replace_key", optJSONObject16.toString());
                this.aGf = optJSONObject16.optString("hlsUrl");
                this.aGd = optJSONObject16.optString("rtmpUrl");
                this.aGe = optJSONObject16.optString("flvUrl");
                this.aGg = optJSONObject16.optString(".m3u8");
            }
            b(true, this.aGb);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject17 != null) {
                this.aGh = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.AD().putString("ala_personal_income_detail_url", this.aGh);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject18 != null) {
                this.aGG = optJSONObject18.optInt("android_show");
                com.baidu.live.c.AD().putInt("ala_custom_gift_category_id", this.aGG);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject19 != null) {
                int optInt = optJSONObject19.optInt("open", 0);
                this.aGi = optInt == 1;
                com.baidu.live.c.AD().putInt("ala_live_pk_switch", optInt);
                this.aGj = optJSONObject19.optLong("interval");
                if (this.aGj < 1000) {
                    this.aGj = 1000L;
                }
                com.baidu.live.c.AD().putLong("ala_live_pk_check_interval", this.aGj);
                this.aGk = optJSONObject19.optLong("match_timeout");
                if (this.aGk < 60000) {
                    this.aGk = 60000L;
                }
                com.baidu.live.c.AD().putLong("ala_live_pk_match_timeout", this.aGk);
                this.aGl = optJSONObject19.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.AD().putString("ala_live_pk_pic_url", this.aGl);
                this.aGm = optJSONObject19.optString("rank_link");
                com.baidu.live.c.AD().putString("ala_live_pk_pic_jump_url", this.aGm);
                this.aGn = optJSONObject19.optString("history_link");
                com.baidu.live.c.AD().putString("ala_live_pk_history_link", this.aGn);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject20 != null) {
                this.aGp = optJSONObject20.optLong("random_interval");
                if (this.aGp < 1000) {
                    this.aGp = 1000L;
                }
                com.baidu.live.c.AD().putLong("ala_challenge_random_interval", this.aGp);
                this.aGq = optJSONObject20.optLong("direct_interval");
                if (this.aGq < 1000) {
                    this.aGq = 1000L;
                }
                com.baidu.live.c.AD().putLong("ala_challenge_direct_interval", this.aGq);
                this.aGr = optJSONObject20.optLong("challenge_info_interval");
                if (this.aGr < 1000) {
                    this.aGr = 1000L;
                }
                com.baidu.live.c.AD().putLong("ala_get_challenge_info_interval", this.aGr);
                this.aGt = optJSONObject20.optString("pk_icon_url");
                com.baidu.live.c.AD().putString("ala_challenge_pk_entry_icon_url", this.aGt);
                this.aGu = optJSONObject20.optString("icon_url");
                com.baidu.live.c.AD().putString("ala_challenge_pk_entry_icon_url", this.aGu);
                this.aGs = optJSONObject20.optString("rule_url");
                com.baidu.live.c.AD().putString("ala_challenge_pk_entry_icon_url", this.aGs);
                this.aGv = optJSONObject20.optInt("punish_stage_button_switch");
                com.baidu.live.c.AD().putInt("punish_stage_button_switch", this.aGv);
                this.aGw = optJSONObject20.optInt("receive_challenge_im_show_time");
                com.baidu.live.c.AD().putInt("receive_challenge_im_show_time", this.aGw);
                this.aGx = optJSONObject20.optInt("mvpPunishSwitch");
                com.baidu.live.c.AD().putInt("mvpPunishSwitch", this.aGx);
                this.aGy = optJSONObject20.optInt("toastLifeTime");
                com.baidu.live.c.AD().putInt("toastLifeTime", this.aGy);
                this.aGz = optJSONObject20.optInt("punishLifeTime");
                com.baidu.live.c.AD().putInt("punishLifeTime", this.aGz);
                this.aGA = optJSONObject20.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject21 != null) {
                this.aGo = optJSONObject21.optString("go_url");
                com.baidu.live.c.AD().putString("show_live_forum_url", this.aGo);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject22 != null) {
                this.aGH = optJSONObject22.optInt("use_https", 0) == 1;
                com.baidu.live.c.AD().putBoolean("ala_guess_use_https", this.aGH);
            }
            String optString3 = jSONObject.optString("live_bar");
            fT(optString3);
            com.baidu.live.c.AD().putString("ala_live_bar_map_str", optString3);
            this.aGI = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.AD().putBoolean("is_new_live_close_strategy", this.aGI);
            this.aGJ = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.AD().putBoolean("is_new_gift_t_dou_strategy", this.aGJ);
            this.aGK = jSONObject.optString("feedback_url");
            com.baidu.live.c.AD().putString("ala_feedback_url", this.aGK);
            JSONObject optJSONObject23 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject23 != null && (optJSONObject = optJSONObject23.optJSONObject("challenge_related_zip")) != null) {
                this.aGE = optJSONObject.optString("zip_md5");
                this.aGF = optJSONObject.optString("zip_url");
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
                this.aFt = optJSONObject25.optInt("encoder", 1) == 1;
                com.baidu.live.c.AD().putBoolean("ala_live_hard_encode_switch", this.aFt);
                this.aFu = optJSONObject25.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.AD().putBoolean("ala_dynamic_bitrate_switch", this.aFu);
                this.aFs = optJSONObject25.optInt("resolution", 3);
                com.baidu.live.c.AD().putInt("ala_video_resolution_level", this.aFs);
                JSONArray optJSONArray8 = optJSONObject25.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aFv = optJSONArray8.toString();
                    com.baidu.live.c.AD().putString("ala_video_soft_bitrate_config", this.aFv);
                }
                JSONArray optJSONArray9 = optJSONObject25.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aFw = optJSONArray9.toString();
                    com.baidu.live.c.AD().putString("ala_video_hard_bitrate_config", this.aFw);
                }
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject26 != null) {
                this.aFx = optJSONObject26.toString();
                com.baidu.live.c.AD().putString("ala_avts_stream_server_domain_config", this.aFx);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject27 != null) {
                this.aFA = optJSONObject27.optInt("host_rtc_resolution", 3);
                com.baidu.live.c.AD().putInt("ala_master_chat_video_resolution_level", this.aFA);
                this.aFB = optJSONObject27.optInt("rtc_resolution", 4);
                com.baidu.live.c.AD().putInt("ala_slave_chat_video_resolution_level", this.aFB);
                JSONArray optJSONArray10 = optJSONObject27.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aFy = optJSONArray10.toString();
                    com.baidu.live.c.AD().putString("ala_master_chat_video_bitrate_config", this.aFy);
                }
                JSONArray optJSONArray11 = optJSONObject27.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aFz = optJSONArray11.toString();
                    com.baidu.live.c.AD().putString("ala_slave_chat_video_bitrate_config", this.aFz);
                }
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject28 != null) {
                this.aHq = optJSONObject28.optInt("enter_live_msg_audience_num_p1");
                this.aHr = optJSONObject28.optInt("enter_live_msg_audience_num_p2");
                this.aHs = optJSONObject28.optInt("enter_live_msg_audience_num_p3");
                this.aHo = optJSONObject28.optInt("im_intercept_switch");
                this.aHp = optJSONObject28.optInt("is_check_im_content");
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject29 != null) {
                this.aHl = new AlaFeedDiversionData();
                this.aHl.parserJson(optJSONObject29);
                com.baidu.live.c.AD().putString("feed_diversion", optJSONObject29.toString());
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject30 != null) {
                com.baidu.live.c.AD().putString("key_stat_switch", optJSONObject30.toString());
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject31 != null) {
                this.aHt = optJSONObject31.optInt("unfold_interval", 5000);
                this.aHu = optJSONObject31.optInt("fold_interval", 55000);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHb = jSONObject.optInt("im_max", 200);
            if (this.aHb <= 0) {
                this.aHb = 200;
            }
            this.aHc = jSONObject.optInt("barrage_max", 100);
            if (this.aHc <= 0) {
                this.aHc = 100;
            }
            this.aHd = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aHd <= 0) {
                this.aHd = 10;
            }
            this.aHe = jSONObject.optInt("enter_effect_max", 10);
            if (this.aHe <= 0) {
                this.aHe = 10;
            }
            this.aHf = jSONObject.optInt("gift_big_max", 10);
            if (this.aHf <= 0) {
                this.aHf = 10;
            }
            this.aHg = jSONObject.optInt("gift_small_max", 50);
            if (this.aHg <= 0) {
                this.aHg = 50;
            }
            this.aHh = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aHh <= 0) {
                this.aHh = 5;
            }
        }
    }

    private void CE() {
        this.aGP = com.baidu.live.c.AD().getInt("guide_speak_watch_time", 15000);
        this.aGQ = com.baidu.live.c.AD().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.AD().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aGR = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aGR[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void A(JSONObject jSONObject) {
        int length;
        this.aGP = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.c.AD().putInt("guide_speak_watch_time", this.aGP);
        this.aGQ = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.AD().putInt("guide_speak_show_times_max", this.aGQ);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aGR = new String[length];
            for (int i = 0; i < length; i++) {
                this.aGR[i] = optJSONArray.optString(i);
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
            this.aGW = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aGW.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void fS(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aGY = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aGY.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aGZ = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aGZ.add(str3);
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
        fS(com.baidu.live.c.AD().getString("ala_quick_send_im_list", null));
    }

    private void fT(String str) {
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
        if (i != this.aGb) {
            z2 = true;
        }
        this.aGb = i;
        if (z || z2) {
            com.baidu.live.c.AD().putInt("ala_live_session_default_key", i);
        }
    }

    private void CH() {
        this.aGb = com.baidu.live.c.AD().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.AD().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aGc.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.AD().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aGf = jSONObject.optString("hlsUrl");
                this.aGd = jSONObject.optString("rtmpUrl");
                this.aGe = jSONObject.optString("flvUrl");
                this.aGg = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean CI() {
        return this.aFU == 1;
    }
}
