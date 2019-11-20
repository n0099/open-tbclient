package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
public class o extends BaseData {
    public boolean PE;
    public boolean PF;
    public boolean PG;
    public boolean PH;
    public boolean PI;
    public String PJ;
    public String PK;
    public String PP;
    public String PQ;
    public Integer[] PU;
    public Integer[] PV;
    public int PW;
    public int PZ;
    public String QB;
    public String QC;
    public int QI;
    public String QK;
    public String QL;
    private String QM;
    private String QN;
    public int QO;
    public String QR;
    public String QS;
    public String QT;
    public String QU;
    public String QV;
    public boolean QW;
    public long QX;
    public long QY;
    public String QZ;
    public int Qa;
    public int Qb;
    public String Qc;
    public int Qd;
    public boolean Qe;
    public boolean Qf;
    public boolean Qg;
    public boolean Qh;
    public boolean Qj;
    public String Qk;
    public int Ql;
    public boolean Qm;
    public int Qn;
    public boolean Qo;
    public boolean Qp;
    public String Qq;
    public String Qr;
    public boolean Qs;
    public boolean Qt;
    public boolean Qu;
    public String Qy;
    public int RD;
    public int RE;
    public String[] RF;
    public int RG;
    public String RH;
    public String RI;
    public QuickImInputData RJ;
    public List<YuanPackageData> RK;
    public int RL;
    public int RO;
    public int RP;
    public List<String> RQ;
    public List<String> RR;
    public List<String> RT;
    public String Ra;
    public String Rb;
    public String Rc;
    public long Rd;
    public long Re;
    public long Rf;
    public String Rg;
    public String Rh;
    public String Ri;
    public boolean Rj;
    public String Rk;
    public String Rl;
    public String Rm;
    public String Rn;
    public String Ro;
    public String Rp;
    public String Rr;
    public String Rs;
    public String Rt;
    public String Ru;
    public int Rv;
    public String Rz;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int Pz = -1;
    public String PD = null;
    public int Qi = 1;
    public boolean Qv = true;
    public boolean Qw = false;
    public boolean Qx = false;
    public boolean Qz = false;
    public String QD = "";
    private int QE = 2;
    public String QF = "";
    public int QG = 1;
    public int QH = 0;
    public int QJ = 1;
    public List<String> QP = new ArrayList();
    public boolean Rq = false;
    public boolean Rw = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean Rx = false;
    public boolean Ry = false;
    public boolean RA = false;
    public boolean RB = false;
    public boolean RC = false;
    public int RU = 200;
    public int RV = 100;
    public int RW = 10;
    public int RX = 10;
    public int RY = 10;
    public int RZ = 50;
    public int Sa = 5;
    public List<String> PO = new ArrayList();
    public List<String> PY = new ArrayList();
    public List<String> PR = new ArrayList();
    public List<Integer> PT = new ArrayList();
    public ArrayList<c> PM = new ArrayList<>();
    public ArrayList<c> PN = new ArrayList<>();

    public o(boolean z) {
        if (z) {
            oi();
            this.PW = com.baidu.live.c.np().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.np().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.np().getInt("restart_time_interval", 300);
            oj();
            oh();
            ok();
            ol();
        }
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray optJSONArray;
        if (jSONObject != null) {
            try {
                this.clientIP = jSONObject.optString("client_ip");
                JSONObject optJSONObject3 = jSONObject.optJSONObject("switch");
                if (optJSONObject3 != null) {
                    o(optJSONObject3);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject4 != null) {
                    this.PW = optJSONObject4.optInt("conn_conf");
                    com.baidu.live.c.np().putInt("conn_conf", this.PW);
                    JSONArray optJSONArray2 = optJSONObject4.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.PY.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject4.optInt("continuous_fail_count");
                    com.baidu.live.c.np().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject4.optInt("restart_time_interval");
                    com.baidu.live.c.np().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("config");
                if (optJSONObject5 != null) {
                    p(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject6 != null) {
                    q(optJSONObject6);
                }
                this.QB = jSONObject.optString("client_id");
                com.baidu.live.c.np().putString("client_id", this.QB);
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject7 != null) {
                    this.PJ = optJSONObject7.optString("pic_url");
                    this.PK = optJSONObject7.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject8 != null && (optJSONArray = optJSONObject8.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject9 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject9 != null) {
                            c cVar = new c();
                            cVar.parseJson(optJSONObject9);
                            this.PM.add(cVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.np().putString("pic_url", this.PJ);
                com.baidu.live.c.np().putString(BigdayActivityConfig.JUMP_URL, this.PK);
                com.baidu.live.c.np().putInt("guide_rename_switch", jSONObject.optInt("guide_rename_switch"));
                JSONObject optJSONObject10 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject10 != null) {
                    r(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject11 != null) {
                    this.RG = optJSONObject11.optInt("resource_switch");
                    this.RI = optJSONObject11.optString("photo_url");
                    this.RH = optJSONObject11.optString("resource_url");
                }
                this.RJ = new QuickImInputData();
                this.RJ.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                JSONObject optJSONObject12 = jSONObject.optJSONObject("guide_follow");
                if (optJSONObject12 != null) {
                    s(optJSONObject12);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.np().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject13 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject13 != null && (optJSONObject = optJSONObject13.optJSONObject("rank")) != null && (optJSONObject2 = optJSONObject.optJSONObject("hour")) != null) {
                    if (!TextUtils.isEmpty(optJSONObject2.optString("haokan_url"))) {
                        com.baidu.live.c.np().putString("hour_rank_rule_hk_190808", optJSONObject2.optString("haokan_url"));
                    }
                    if (!TextUtils.isEmpty(optJSONObject2.optString("quanmin_url"))) {
                        com.baidu.live.c.np().putString("hour_rank_rule_qm_190808", optJSONObject2.optString("quanmin_url"));
                    }
                    if (!TextUtils.isEmpty(optJSONObject2.optString("default_url"))) {
                        com.baidu.live.c.np().putString("hour_rank_rule_default", optJSONObject2.optString("default_url"));
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.np().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void oh() {
        String string = com.baidu.live.c.np().getString("ala_prepare_random_title_list", "");
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
            this.RT = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.RT.add(jSONArray.optString(i));
            }
        }
    }

    private void oi() {
        this.PE = com.baidu.live.c.np().getBoolean("map_around_map", false);
        this.Qm = com.baidu.live.c.np().getBoolean("withdraw_switch", true);
        this.Qy = com.baidu.live.c.np().getString("withdraw_text", "");
        this.Qs = com.baidu.live.c.np().getBoolean("live_beauty_open_switch", false);
        this.Qt = com.baidu.live.c.np().getBoolean("live_unity_beauty_switch", true);
        this.Qu = com.baidu.live.c.np().getBoolean("live_unity_beauty_face_style_switch", true);
        this.Qv = com.baidu.live.c.np().getBoolean("sp_key_live_game_hard_encode", true);
        this.Qw = com.baidu.live.c.np().getBoolean("sp_key_live_play_transcode_support", false);
        this.Qx = com.baidu.live.c.np().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.Qz = com.baidu.live.c.np().getBoolean("ala_enable_graffiti_str", false);
        this.PF = com.baidu.live.c.np().getBoolean("enter_live", false);
        this.PG = com.baidu.live.c.np().getBoolean("sync_to_forum", true);
        this.PH = com.baidu.live.c.np().getBoolean("show_water_mark", false);
        this.PI = com.baidu.live.c.np().getBoolean("show_third_part_water_mark_switch", false);
        this.Qe = com.baidu.live.c.np().getBoolean("stream_error_log", true);
        this.Qf = com.baidu.live.c.np().getBoolean("disable_channel_in", true);
        this.Qg = com.baidu.live.c.np().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.Qh = com.baidu.live.c.np().getBoolean("sign_in", false);
        this.Qj = com.baidu.live.c.np().getBoolean("follow_default_push_switch", true);
        this.QI = com.baidu.live.c.np().getInt("to_tb_some_switch", 0);
        this.QG = com.baidu.live.c.np().getInt("enable_live_stat", 1);
        this.QH = com.baidu.live.c.np().getInt("ala_free_gift_task_switch", 0);
        this.Rq = com.baidu.live.c.np().getBoolean("live_challenge_switch", false);
        this.Rr = com.baidu.live.c.np().getString("live_challenge_tip", null);
        this.Rs = com.baidu.live.c.np().getString("live_challenge_url", null);
    }

    private void o(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.PE = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.np().putBoolean("map_around_map", this.PE);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.Qm = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("withdraw_switch", this.Qm);
                this.Qy = optJSONObject2.optString("text");
                com.baidu.live.c.np().putString("withdraw_text", this.Qy);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject3 != null) {
                this.Qs = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("live_beauty_open_switch", this.Qs);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject4 != null) {
                this.Qt = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("live_unity_beauty_switch", this.Qt);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject5 != null) {
                this.Qu = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("live_unity_beauty_face_style_switch", this.Qu);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject6 != null) {
                this.Qv = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("sp_key_live_game_hard_encode", this.Qv);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject7 != null) {
                this.Qw = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("sp_key_live_play_transcode_support", this.Qw);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject8 != null) {
                this.Qx = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("sp_key_live_play_attention_guide_support", this.Qx);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject9 != null) {
                this.PF = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("enter_live", this.PF);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject10 != null) {
                this.PG = optJSONObject10.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("sync_to_forum", this.PG);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject11 != null) {
                this.PH = optJSONObject11.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("show_water_mark", this.PH);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject12 != null) {
                this.PI = optJSONObject12.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("show_third_part_water_mark_switch", this.PI);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject13 != null) {
                this.QG = optJSONObject13.optInt("switch");
                com.baidu.live.c.np().putInt("enable_live_stat", this.QG);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject14 != null) {
                this.Qe = optJSONObject14.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("stream_error_log", this.Qe);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject15 != null) {
                this.Qf = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("disable_channel_in", this.Qf);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject16 != null) {
                this.Qg = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("shoubai_yanzhi_tab_tip", this.Qg);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("sign_in");
            if (optJSONObject17 != null) {
                this.Qh = optJSONObject17.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("sign_in", this.Qh);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject18 != null) {
                this.Qj = optJSONObject18.optString("switch").equals("2");
                com.baidu.live.c.np().putBoolean("follow_default_push_switch", this.Qj);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject19 != null) {
                this.QI = optJSONObject19.optInt("switch");
                com.baidu.live.c.np().putInt("to_tb_some_switch", this.QI);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("task_config");
            if (optJSONObject20 != null) {
                this.QH = optJSONObject20.optInt("switch");
                com.baidu.live.c.np().putInt("ala_free_gift_task_switch", this.QI);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject21 != null) {
                this.Qz = optJSONObject21.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("ala_enable_graffiti_str", this.Qz);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject22 != null) {
                this.Rq = optJSONObject22.optInt("switch") == 1;
                this.Rr = optJSONObject22.optString("title");
                this.Rs = optJSONObject22.optString("url");
                com.baidu.live.c.np().putBoolean("live_challenge_switch", this.Rq);
                com.baidu.live.c.np().putString("live_challenge_tip", this.Rr);
                com.baidu.live.c.np().putString("live_challenge_url", this.Rs);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject23 != null) {
                this.Ry = optJSONObject23.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("is_new_gift_t_dou_strategy", this.Ry);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject24 != null) {
                this.RC = optJSONObject24.optInt("switch") == 1;
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject23 != null) {
                this.RA = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("key_is_open_login_prove", this.RA);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject26 != null) {
                this.RB = optJSONObject26.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("key_is_open_diamond", this.RB);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void oj() {
        this.Qc = com.baidu.live.c.np().getString("bluediamond_url", "");
        this.PQ = com.baidu.live.c.np().getString("verify_content", this.PQ);
        this.PP = com.baidu.live.c.np().getString("live_notice", "");
        this.QC = com.baidu.live.c.np().getString("share_host", "");
        this.QD = com.baidu.live.c.np().getString("ala_share_in_bar_notice_text", "");
        this.QF = com.baidu.live.c.np().getString("ala_share_reward_rank_notice_text", "");
        this.QE = com.baidu.live.c.np().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.Qd = com.baidu.live.c.np().getInt("recommend_refresh", 60);
        this.Qk = com.baidu.live.c.np().getString("strategy_conf", "300");
        this.Ql = com.baidu.live.c.np().getInt("strategy_exception_interval", 1);
        this.Qi = com.baidu.live.c.np().getInt("liveStartAuthLevel", 1);
        this.PZ = com.baidu.live.c.np().getInt("2gTo", 5);
        this.Qa = com.baidu.live.c.np().getInt("3gTo", 3);
        this.Qb = com.baidu.live.c.np().getInt("wifiTo", 3);
        String string = com.baidu.live.c.np().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string)) {
                this.PU = g(new JSONArray(string));
            }
            String string2 = com.baidu.live.c.np().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string2)) {
                this.PV = g(new JSONArray(string2));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.QJ = com.baidu.live.c.np().getInt("square_tab_strategy", 1);
        this.QK = com.baidu.live.c.np().getString("ala_live_ranklist_url", null);
        this.QL = com.baidu.live.c.np().getString("new_flower_rank_list_description_url", "");
        this.QM = com.baidu.live.c.np().getString("ala_game_player_signup_url", null);
        this.QN = com.baidu.live.c.np().getString("ala_game_frs_live_tab_video_url", null);
        on();
        this.QV = com.baidu.live.c.np().getString("ala_personal_income_detail_url", null);
        this.Rv = com.baidu.live.c.np().getInt("ala_custom_gift_category_id", -1);
        this.QW = com.baidu.live.c.np().getInt("ala_live_pk_switch", 0) == 1;
        this.QX = com.baidu.live.c.np().getLong("ala_live_pk_check_interval", 1000L);
        this.QY = com.baidu.live.c.np().getLong("ala_live_pk_match_timeout", 60000L);
        this.QZ = com.baidu.live.c.np().getString("ala_live_pk_pic_url", "");
        this.Ra = com.baidu.live.c.np().getString("ala_live_pk_pic_jump_url", "");
        this.Rb = com.baidu.live.c.np().getString("ala_live_pk_history_link", "");
        this.Rc = com.baidu.live.c.np().getString("show_live_forum_url", "");
        this.Rd = com.baidu.live.c.np().getLong("ala_challenge_random_interval", 1000L);
        this.Re = com.baidu.live.c.np().getLong("ala_challenge_direct_interval", 1000L);
        this.Rf = com.baidu.live.c.np().getLong("ala_get_challenge_info_interval", 1000L);
        this.Rh = com.baidu.live.c.np().getString("ala_challenge_pk_entry_icon_url", "");
        this.Ri = com.baidu.live.c.np().getString("ala_challenge_pk_entry_icon_url", "");
        this.Rg = com.baidu.live.c.np().getString("ala_challenge_pk_entry_icon_url", "");
        this.Rj = com.baidu.live.c.np().getBoolean("ala_challenge_all_in_open", true);
        this.Rk = com.baidu.live.c.np().getString("ala_challenge_ad_text", "");
        this.Rl = com.baidu.live.c.np().getString("ala_challenge_ad_top_img_url", "");
        this.Rm = com.baidu.live.c.np().getString("ala_challenge_ad_bottom_img_url", "");
        this.Rn = com.baidu.live.c.np().getString("ala_challenge_ad_btn_bg_url", "");
        this.Ro = com.baidu.live.c.np().getString("ala_challenge_ad_click_url", "");
        this.Rp = com.baidu.live.c.np().getString("ala_challenge_bottom_ad_color", "");
        this.Rw = com.baidu.live.c.np().getBoolean("ala_guess_use_https", false);
        bW(com.baidu.live.c.np().getString("ala_live_bar_map_str", ""));
        this.Rx = com.baidu.live.c.np().getBoolean("is_new_live_close_strategy", false);
        this.Ry = com.baidu.live.c.np().getBoolean("is_new_gift_t_dou_strategy", false);
        this.Rz = com.baidu.live.c.np().getString("ala_feedback_url", null);
        this.Qn = com.baidu.live.c.np().getInt("ala_video_resolution_level", 3);
        this.Qo = com.baidu.live.c.np().getBoolean("ala_live_hard_encode_switch", true);
        this.Qp = com.baidu.live.c.np().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.np().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.np().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.np().getInt("ala_video_increase_count", 3);
        this.Qq = com.baidu.live.c.np().getString("ala_video_soft_bitrate_config", null);
        this.Qr = com.baidu.live.c.np().getString("ala_video_hard_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.np().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.np().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.RA = com.baidu.live.c.np().getBoolean("key_is_open_login_prove", false);
        this.RB = com.baidu.live.c.np().getBoolean("key_is_open_diamond", false);
        om();
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

    private void p(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject2 != null) {
                this.PD = optJSONObject2.optString("toast");
                this.Pz = optJSONObject2.optInt("remind_type");
            }
            this.Qc = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.np().putString("bluediamond_url", this.Qc);
            this.PQ = jSONObject.optString("verify_content");
            com.baidu.live.c.np().putString("verify_content", this.PQ);
            this.PP = jSONObject.optString("live_notice");
            com.baidu.live.c.np().putString("live_notice", this.PP);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.PO.add(i, optString);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.PR.add(i2, optString2);
                    }
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("bd_live_activity");
            if (optJSONObject3 != null && (optJSONArray = optJSONObject3.optJSONArray("main_page")) != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject4 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject4 != null) {
                        c cVar = new c();
                        cVar.parseJson(optJSONObject4);
                        this.PN.add(cVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.PT.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.QC = optJSONObject5.optString("url");
            } else {
                this.QC = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.QD = optJSONObject6.optString("reward_notice");
                this.QF = optJSONObject6.optString("reward_rank_notice");
                this.QE = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.QD = "";
                this.QF = "";
                this.QE = 2;
            }
            com.baidu.live.c.np().putString("share_host", this.QC);
            com.baidu.live.c.np().putString("ala_share_in_bar_notice_text", this.QD);
            com.baidu.live.c.np().putString("ala_share_reward_rank_notice_text", this.QF);
            com.baidu.live.c.np().putInt("ala_share_in_bar_notice_tip_switch", this.QE);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.Qd = optJSONObject7.optInt("value");
            } else {
                this.Qd = 60;
            }
            com.baidu.live.c.np().putInt("recommend_refresh", this.Qd);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.np().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.PU = g(optJSONArray5);
            }
            if (jSONObject.optJSONObject("stream_level_high") != null) {
                JSONArray optJSONArray6 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.np().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.PV = g(optJSONArray6);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject9 != null) {
                this.Qk = optJSONObject9.optString("time_interval");
                this.Ql = optJSONObject9.optInt("exception_interval");
            } else {
                this.Qk = "300";
                this.Ql = 1;
            }
            com.baidu.live.c.np().putString("strategy_conf", this.Qk);
            com.baidu.live.c.np().putInt("strategy_exception_interval", this.Ql);
            this.Qi = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.np().putInt("liveStartAuthLevel", this.Qi);
            JSONObject optJSONObject10 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject10 != null) {
                this.PZ = optJSONObject10.optInt("2gTo");
                if (this.PZ < 3) {
                    this.PZ = 3;
                }
                this.Qa = optJSONObject10.optInt("3gTo");
                if (this.Qa < 3) {
                    this.Qa = 3;
                }
                this.Qb = optJSONObject10.optInt("wifiTo");
                if (this.Qb < 3) {
                    this.Qb = 3;
                }
                com.baidu.live.c.np().putInt("2gTo", this.PZ);
                com.baidu.live.c.np().putInt("3gTo", this.Qa);
                com.baidu.live.c.np().putInt("wifiTo", this.Qb);
            }
            this.QJ = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.np().putInt("square_tab_strategy", this.QJ);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject11 != null) {
                this.QK = optJSONObject11.optString(BigdayActivityConfig.JUMP_URL);
                this.QL = optJSONObject11.optString("flower_rank_rule");
            }
            com.baidu.live.c.np().putString("ala_live_ranklist_url", this.QK);
            com.baidu.live.c.np().putString("new_flower_rank_list_description_url", this.QL);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject12 != null) {
                this.QM = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.np().putString("ala_game_player_signup_url", this.QM);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject13 != null) {
                this.QN = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.np().putString("ala_game_frs_live_tab_video_url", this.QN);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject14 != null) {
                this.QO = optJSONObject14.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.np().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.QP.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject15 != null) {
                com.baidu.live.c.np().putString("ala_live_session_replace_key", optJSONObject15.toString());
                this.QT = optJSONObject15.optString("hlsUrl");
                this.QR = optJSONObject15.optString("rtmpUrl");
                this.QS = optJSONObject15.optString("flvUrl");
                this.QU = optJSONObject15.optString(".m3u8");
            }
            b(true, this.QO);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject16 != null) {
                this.QV = optJSONObject16.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.np().putString("ala_personal_income_detail_url", this.QV);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject17 != null) {
                this.Rv = optJSONObject17.optInt("android_show");
                com.baidu.live.c.np().putInt("ala_custom_gift_category_id", this.Rv);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject18 != null) {
                int optInt = optJSONObject18.optInt("open", 0);
                this.QW = optInt == 1;
                com.baidu.live.c.np().putInt("ala_live_pk_switch", optInt);
                this.QX = optJSONObject18.optLong("interval");
                if (this.QX < 1000) {
                    this.QX = 1000L;
                }
                com.baidu.live.c.np().putLong("ala_live_pk_check_interval", this.QX);
                this.QY = optJSONObject18.optLong("match_timeout");
                if (this.QY < 60000) {
                    this.QY = 60000L;
                }
                com.baidu.live.c.np().putLong("ala_live_pk_match_timeout", this.QY);
                this.QZ = optJSONObject18.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.np().putString("ala_live_pk_pic_url", this.QZ);
                this.Ra = optJSONObject18.optString("rank_link");
                com.baidu.live.c.np().putString("ala_live_pk_pic_jump_url", this.Ra);
                this.Rb = optJSONObject18.optString("history_link");
                com.baidu.live.c.np().putString("ala_live_pk_history_link", this.Rb);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject19 != null) {
                this.Rd = optJSONObject19.optLong("random_interval");
                if (this.Rd < 1000) {
                    this.Rd = 1000L;
                }
                com.baidu.live.c.np().putLong("ala_challenge_random_interval", this.Rd);
                this.Re = optJSONObject19.optLong("direct_interval");
                if (this.Re < 1000) {
                    this.Re = 1000L;
                }
                com.baidu.live.c.np().putLong("ala_challenge_direct_interval", this.Re);
                this.Rf = optJSONObject19.optLong("challenge_info_interval");
                if (this.Rf < 1000) {
                    this.Rf = 1000L;
                }
                com.baidu.live.c.np().putLong("ala_get_challenge_info_interval", this.Rf);
                this.Rh = optJSONObject19.optString("pk_icon_url");
                com.baidu.live.c.np().putString("ala_challenge_pk_entry_icon_url", this.Rh);
                this.Ri = optJSONObject19.optString("icon_url");
                com.baidu.live.c.np().putString("ala_challenge_pk_entry_icon_url", this.Ri);
                this.Rg = optJSONObject19.optString("rule_url");
                com.baidu.live.c.np().putString("ala_challenge_pk_entry_icon_url", this.Rg);
                this.Rj = optJSONObject19.optInt("allin_open") == 1;
                com.baidu.live.c.np().putBoolean("ala_challenge_all_in_open", this.Rj);
                this.Rk = optJSONObject19.optString("ad_text");
                com.baidu.live.c.np().putString("ala_challenge_ad_text", this.Rk);
                this.Rl = optJSONObject19.optString("ad_top_image");
                com.baidu.live.c.np().putString("ala_challenge_ad_top_img_url", this.Rl);
                this.Rp = optJSONObject19.optString("ad_bottom_color");
                com.baidu.live.c.np().putString("ala_challenge_bottom_ad_color", this.Rp);
                this.Rm = optJSONObject19.optString("ad_bottom_image");
                com.baidu.live.c.np().putString("ala_challenge_ad_bottom_img_url", this.Rm);
                this.Rn = optJSONObject19.optString("ad_btn_bg");
                com.baidu.live.c.np().putString("ala_challenge_ad_btn_bg_url", this.Rn);
                this.Ro = optJSONObject19.optString("ad_url");
                com.baidu.live.c.np().putString("ala_challenge_ad_click_url", this.Ro);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject20 != null) {
                this.Rc = optJSONObject20.optString("go_url");
                com.baidu.live.c.np().putString("show_live_forum_url", this.Rc);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject21 != null) {
                this.Rw = optJSONObject21.optInt("use_https", 0) == 1;
                com.baidu.live.c.np().putBoolean("ala_guess_use_https", this.Rw);
            }
            String optString3 = jSONObject.optString("live_bar");
            bW(optString3);
            com.baidu.live.c.np().putString("ala_live_bar_map_str", optString3);
            this.Rx = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.np().putBoolean("is_new_live_close_strategy", this.Rx);
            this.Ry = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.np().putBoolean("is_new_gift_t_dou_strategy", this.Ry);
            this.Rz = jSONObject.optString("feedback_url");
            com.baidu.live.c.np().putString("ala_feedback_url", this.Rz);
            JSONObject optJSONObject22 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject22 != null && (optJSONObject = optJSONObject22.optJSONObject("challenge_related_zip")) != null) {
                this.Rt = optJSONObject.optString("zip_md5");
                this.Ru = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject23 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject23.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject23.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.np().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.np().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("open_live");
            if (optJSONObject24 != null) {
                this.increaseThreshold = optJSONObject24.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.np().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject24.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.np().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject24.optInt("thi_count", 3);
                com.baidu.live.c.np().putInt("ala_video_increase_count", this.increaseCount);
                this.Qo = optJSONObject24.optInt("encoder", 1) == 1;
                com.baidu.live.c.np().putBoolean("ala_live_hard_encode_switch", this.Qo);
                this.Qp = optJSONObject24.optInt("dynamic", 1) == 1;
                com.baidu.live.c.np().putBoolean("ala_dynamic_bitrate_switch", this.Qp);
                this.Qn = optJSONObject24.optInt("resolution", 3);
                com.baidu.live.c.np().putInt("ala_video_resolution_level", this.Qn);
                JSONArray optJSONArray8 = optJSONObject24.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.Qq = optJSONArray8.toString();
                    com.baidu.live.c.np().putString("ala_video_soft_bitrate_config", this.Qq);
                }
                JSONArray optJSONArray9 = optJSONObject24.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.Qr = optJSONArray9.toString();
                    com.baidu.live.c.np().putString("ala_video_hard_bitrate_config", this.Qr);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void q(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.RU = jSONObject.optInt("im_max", 200);
            if (this.RU <= 0) {
                this.RU = 200;
            }
            this.RV = jSONObject.optInt("barrage_max", 100);
            if (this.RV <= 0) {
                this.RV = 100;
            }
            this.RW = jSONObject.optInt("pay_barrage_max", 10);
            if (this.RW <= 0) {
                this.RW = 10;
            }
            this.RX = jSONObject.optInt("enter_effect_max", 10);
            if (this.RX <= 0) {
                this.RX = 10;
            }
            this.RY = jSONObject.optInt("gift_big_max", 10);
            if (this.RY <= 0) {
                this.RY = 10;
            }
            this.RZ = jSONObject.optInt("gift_small_max", 50);
            if (this.RZ <= 0) {
                this.RZ = 50;
            }
            this.Sa = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.Sa <= 0) {
                this.Sa = 5;
            }
        }
    }

    private void ok() {
        this.RD = com.baidu.live.c.np().getInt("guide_speak_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        this.RE = com.baidu.live.c.np().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.np().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.RF = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.RF[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void r(JSONObject jSONObject) {
        int length;
        this.RD = jSONObject.optInt("rule_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL) * 1000;
        com.baidu.live.c.np().putInt("guide_speak_watch_time", this.RD);
        this.RE = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.np().putInt("guide_speak_show_times_max", this.RE);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.RF = new String[length];
            for (int i = 0; i < length; i++) {
                this.RF[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.np().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void s(JSONObject jSONObject) {
        this.RL = jSONObject.optInt("supernatant_time") * 1000;
        this.RO = jSONObject.optInt("suoernatant_shownum");
        this.RP = jSONObject.optInt("pop_window_time") * 1000;
    }

    private void ol() {
        String string = com.baidu.live.c.np().getString("yuan_package_data", "");
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
            this.RK = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.RK.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void bV(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.RQ = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.RQ.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.RR = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.RR.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.np().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void om() {
        bV(com.baidu.live.c.np().getString("ala_quick_send_im_list", null));
    }

    private void bW(String str) {
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
        if (i != this.QO) {
            z2 = true;
        }
        this.QO = i;
        if (z || z2) {
            com.baidu.live.c.np().putInt("ala_live_session_default_key", i);
        }
    }

    private void on() {
        this.QO = com.baidu.live.c.np().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.np().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.QP.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.np().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.QT = jSONObject.optString("hlsUrl");
                this.QR = jSONObject.optString("rtmpUrl");
                this.QS = jSONObject.optString("flvUrl");
                this.QU = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean oo() {
        return this.QH == 1;
    }
}
