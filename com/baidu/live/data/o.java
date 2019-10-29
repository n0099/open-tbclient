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
    public int QB;
    public int QC;
    public String QD;
    public int QE;
    public boolean QF;
    public boolean QG;
    public boolean QH;
    public boolean QI;
    public boolean QK;
    public String QL;
    public int QM;
    public boolean QN;
    public int QO;
    public boolean QP;
    public boolean QR;
    public String QS;
    public String QT;
    public boolean QU;
    public boolean QV;
    public boolean QW;
    public boolean Qh;
    public boolean Qi;
    public boolean Qj;
    public boolean Qk;
    public boolean Ql;
    public String Qm;
    public String Qn;
    public String Qr;
    public String Qs;
    public Integer[] Qv;
    public Integer[] Qw;
    public int Qx;
    public int Qz;
    public String RA;
    public String RB;
    public String RC;
    public long RD;
    public long RE;
    public long RF;
    public String RG;
    public String RH;
    public String RI;
    public boolean RJ;
    public String RK;
    public String RL;
    public String RO;
    public String RP;
    public String RQ;
    public String RR;
    public String RU;
    public String RV;
    public String RW;
    public String RX;
    public int RY;
    public String Ra;
    public String Rc;
    public String Rd;
    public int Rj;
    public String Rl;
    public String Rm;
    private String Rn;
    private String Ro;
    public int Rp;
    public String Rr;
    public String Rs;
    public String Rt;
    public String Ru;
    public String Rv;
    public boolean Rw;
    public long Rx;
    public long Ry;
    public String Rz;
    public String Sc;
    public int Sg;
    public int Sh;
    public String[] Si;
    public int Sj;
    public String Sk;
    public String Sl;
    public QuickImInputData Sm;
    public List<YuanPackageData> Sn;
    public int So;
    public int Sp;
    public int Sq;
    public List<String> Sr;
    public List<String> Ss;
    public List<String> St;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int Qf = -1;
    public String Qg = null;
    public int QJ = 1;
    public boolean QX = true;
    public boolean QY = false;
    public boolean QZ = false;
    public boolean Rb = false;
    public String Re = "";
    private int Rf = 2;
    public String Rg = "";
    public int Rh = 1;
    public int Ri = 0;
    public int Rk = 1;
    public List<String> Rq = new ArrayList();
    public boolean RT = false;
    public boolean RZ = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean Sa = false;
    public boolean Sb = false;
    public boolean Sd = false;
    public boolean Se = false;
    public boolean Sf = false;
    public List<String> Qq = new ArrayList();
    public List<String> Qy = new ArrayList();
    public List<String> Qt = new ArrayList();
    public List<Integer> Qu = new ArrayList();
    public ArrayList<c> Qo = new ArrayList<>();
    public ArrayList<c> Qp = new ArrayList<>();

    public o(boolean z) {
        if (z) {
            oi();
            this.Qx = com.baidu.live.c.np().getInt("conn_conf", 0);
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
                    this.Qx = optJSONObject4.optInt("conn_conf");
                    com.baidu.live.c.np().putInt("conn_conf", this.Qx);
                    JSONArray optJSONArray2 = optJSONObject4.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.Qy.add(i, optString);
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
                this.Rc = jSONObject.optString("client_id");
                com.baidu.live.c.np().putString("client_id", this.Rc);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.Qm = optJSONObject6.optString("pic_url");
                    this.Qn = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            c cVar = new c();
                            cVar.parseJson(optJSONObject8);
                            this.Qo.add(cVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.np().putString("pic_url", this.Qm);
                com.baidu.live.c.np().putString(BigdayActivityConfig.JUMP_URL, this.Qn);
                com.baidu.live.c.np().putInt("guide_rename_switch", jSONObject.optInt("guide_rename_switch"));
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    q(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.Sj = optJSONObject10.optInt("resource_switch");
                    this.Sl = optJSONObject10.optString("photo_url");
                    this.Sk = optJSONObject10.optString("resource_url");
                }
                this.Sm = new QuickImInputData();
                this.Sm.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                JSONObject optJSONObject11 = jSONObject.optJSONObject("guide_follow");
                if (optJSONObject11 != null) {
                    r(optJSONObject11);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.np().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("rank")) != null && (optJSONObject2 = optJSONObject.optJSONObject("hour")) != null) {
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
            this.St = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.St.add(jSONArray.optString(i));
            }
        }
    }

    private void oi() {
        this.Qh = com.baidu.live.c.np().getBoolean("map_around_map", false);
        this.QN = com.baidu.live.c.np().getBoolean("withdraw_switch", true);
        this.Ra = com.baidu.live.c.np().getString("withdraw_text", "");
        this.QU = com.baidu.live.c.np().getBoolean("live_beauty_open_switch", false);
        this.QV = com.baidu.live.c.np().getBoolean("live_unity_beauty_switch", true);
        this.QW = com.baidu.live.c.np().getBoolean("live_unity_beauty_face_style_switch", true);
        this.QX = com.baidu.live.c.np().getBoolean("sp_key_live_game_hard_encode", true);
        this.QY = com.baidu.live.c.np().getBoolean("sp_key_live_play_transcode_support", false);
        this.QZ = com.baidu.live.c.np().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.Rb = com.baidu.live.c.np().getBoolean("ala_enable_graffiti_str", false);
        this.Qi = com.baidu.live.c.np().getBoolean("enter_live", false);
        this.Qj = com.baidu.live.c.np().getBoolean("sync_to_forum", true);
        this.Qk = com.baidu.live.c.np().getBoolean("show_water_mark", false);
        this.Ql = com.baidu.live.c.np().getBoolean("show_third_part_water_mark_switch", false);
        this.QF = com.baidu.live.c.np().getBoolean("stream_error_log", true);
        this.QG = com.baidu.live.c.np().getBoolean("disable_channel_in", true);
        this.QH = com.baidu.live.c.np().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.QI = com.baidu.live.c.np().getBoolean("sign_in", false);
        this.QK = com.baidu.live.c.np().getBoolean("follow_default_push_switch", true);
        this.Rj = com.baidu.live.c.np().getInt("to_tb_some_switch", 0);
        this.Rh = com.baidu.live.c.np().getInt("enable_live_stat", 1);
        this.Ri = com.baidu.live.c.np().getInt("ala_free_gift_task_switch", 0);
        this.RT = com.baidu.live.c.np().getBoolean("live_challenge_switch", false);
        this.RU = com.baidu.live.c.np().getString("live_challenge_tip", null);
        this.RV = com.baidu.live.c.np().getString("live_challenge_url", null);
    }

    private void o(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.Qh = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.np().putBoolean("map_around_map", this.Qh);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.QN = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("withdraw_switch", this.QN);
                this.Ra = optJSONObject2.optString("text");
                com.baidu.live.c.np().putString("withdraw_text", this.Ra);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject3 != null) {
                this.QU = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("live_beauty_open_switch", this.QU);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject4 != null) {
                this.QV = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("live_unity_beauty_switch", this.QV);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject5 != null) {
                this.QW = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("live_unity_beauty_face_style_switch", this.QW);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject6 != null) {
                this.QX = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("sp_key_live_game_hard_encode", this.QX);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject7 != null) {
                this.QY = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("sp_key_live_play_transcode_support", this.QY);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject8 != null) {
                this.QZ = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("sp_key_live_play_attention_guide_support", this.QZ);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject9 != null) {
                this.Qi = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("enter_live", this.Qi);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject10 != null) {
                this.Qj = optJSONObject10.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("sync_to_forum", this.Qj);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject11 != null) {
                this.Qk = optJSONObject11.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("show_water_mark", this.Qk);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject12 != null) {
                this.Ql = optJSONObject12.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("show_third_part_water_mark_switch", this.Ql);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject13 != null) {
                this.Rh = optJSONObject13.optInt("switch");
                com.baidu.live.c.np().putInt("enable_live_stat", this.Rh);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject14 != null) {
                this.QF = optJSONObject14.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("stream_error_log", this.QF);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject15 != null) {
                this.QG = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("disable_channel_in", this.QG);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject16 != null) {
                this.QH = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("shoubai_yanzhi_tab_tip", this.QH);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("sign_in");
            if (optJSONObject17 != null) {
                this.QI = optJSONObject17.optString("switch").equals("1");
                com.baidu.live.c.np().putBoolean("sign_in", this.QI);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject18 != null) {
                this.QK = optJSONObject18.optString("switch").equals("2");
                com.baidu.live.c.np().putBoolean("follow_default_push_switch", this.QK);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject19 != null) {
                this.Rj = optJSONObject19.optInt("switch");
                com.baidu.live.c.np().putInt("to_tb_some_switch", this.Rj);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("task_config");
            if (optJSONObject20 != null) {
                this.Ri = optJSONObject20.optInt("switch");
                com.baidu.live.c.np().putInt("ala_free_gift_task_switch", this.Rj);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject21 != null) {
                this.Rb = optJSONObject21.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("ala_enable_graffiti_str", this.Rb);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject22 != null) {
                this.RT = optJSONObject22.optInt("switch") == 1;
                this.RU = optJSONObject22.optString("title");
                this.RV = optJSONObject22.optString("url");
                com.baidu.live.c.np().putBoolean("live_challenge_switch", this.RT);
                com.baidu.live.c.np().putString("live_challenge_tip", this.RU);
                com.baidu.live.c.np().putString("live_challenge_url", this.RV);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject23 != null) {
                this.Sb = optJSONObject23.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("is_new_gift_t_dou_strategy", this.Sb);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject24 != null) {
                this.Sf = optJSONObject24.optInt("switch") == 1;
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject23 != null) {
                this.Sd = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("key_is_open_login_prove", this.Sd);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject26 != null) {
                this.Se = optJSONObject26.optInt("switch") == 1;
                com.baidu.live.c.np().putBoolean("key_is_open_diamond", this.Se);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void oj() {
        this.QD = com.baidu.live.c.np().getString("bluediamond_url", "");
        this.Qs = com.baidu.live.c.np().getString("verify_content", this.Qs);
        this.Qr = com.baidu.live.c.np().getString("live_notice", "");
        this.Rd = com.baidu.live.c.np().getString("share_host", "");
        this.Re = com.baidu.live.c.np().getString("ala_share_in_bar_notice_text", "");
        this.Rg = com.baidu.live.c.np().getString("ala_share_reward_rank_notice_text", "");
        this.Rf = com.baidu.live.c.np().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.QE = com.baidu.live.c.np().getInt("recommend_refresh", 60);
        this.QL = com.baidu.live.c.np().getString("strategy_conf", "300");
        this.QM = com.baidu.live.c.np().getInt("strategy_exception_interval", 1);
        this.QJ = com.baidu.live.c.np().getInt("liveStartAuthLevel", 1);
        this.Qz = com.baidu.live.c.np().getInt("2gTo", 5);
        this.QB = com.baidu.live.c.np().getInt("3gTo", 3);
        this.QC = com.baidu.live.c.np().getInt("wifiTo", 3);
        String string = com.baidu.live.c.np().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string)) {
                this.Qv = g(new JSONArray(string));
            }
            String string2 = com.baidu.live.c.np().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string2)) {
                this.Qw = g(new JSONArray(string2));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.Rk = com.baidu.live.c.np().getInt("square_tab_strategy", 1);
        this.Rl = com.baidu.live.c.np().getString("ala_live_ranklist_url", null);
        this.Rm = com.baidu.live.c.np().getString("new_flower_rank_list_description_url", "");
        this.Rn = com.baidu.live.c.np().getString("ala_game_player_signup_url", null);
        this.Ro = com.baidu.live.c.np().getString("ala_game_frs_live_tab_video_url", null);
        on();
        this.Rv = com.baidu.live.c.np().getString("ala_personal_income_detail_url", null);
        this.RY = com.baidu.live.c.np().getInt("ala_custom_gift_category_id", -1);
        this.Rw = com.baidu.live.c.np().getInt("ala_live_pk_switch", 0) == 1;
        this.Rx = com.baidu.live.c.np().getLong("ala_live_pk_check_interval", 1000L);
        this.Ry = com.baidu.live.c.np().getLong("ala_live_pk_match_timeout", 60000L);
        this.Rz = com.baidu.live.c.np().getString("ala_live_pk_pic_url", "");
        this.RA = com.baidu.live.c.np().getString("ala_live_pk_pic_jump_url", "");
        this.RB = com.baidu.live.c.np().getString("ala_live_pk_history_link", "");
        this.RC = com.baidu.live.c.np().getString("show_live_forum_url", "");
        this.RD = com.baidu.live.c.np().getLong("ala_challenge_random_interval", 1000L);
        this.RE = com.baidu.live.c.np().getLong("ala_challenge_direct_interval", 1000L);
        this.RF = com.baidu.live.c.np().getLong("ala_get_challenge_info_interval", 1000L);
        this.RH = com.baidu.live.c.np().getString("ala_challenge_pk_entry_icon_url", "");
        this.RI = com.baidu.live.c.np().getString("ala_challenge_pk_entry_icon_url", "");
        this.RG = com.baidu.live.c.np().getString("ala_challenge_pk_entry_icon_url", "");
        this.RJ = com.baidu.live.c.np().getBoolean("ala_challenge_all_in_open", true);
        this.RK = com.baidu.live.c.np().getString("ala_challenge_ad_text", "");
        this.RL = com.baidu.live.c.np().getString("ala_challenge_ad_top_img_url", "");
        this.RO = com.baidu.live.c.np().getString("ala_challenge_ad_bottom_img_url", "");
        this.RP = com.baidu.live.c.np().getString("ala_challenge_ad_btn_bg_url", "");
        this.RQ = com.baidu.live.c.np().getString("ala_challenge_ad_click_url", "");
        this.RR = com.baidu.live.c.np().getString("ala_challenge_bottom_ad_color", "");
        this.RZ = com.baidu.live.c.np().getBoolean("ala_guess_use_https", false);
        bW(com.baidu.live.c.np().getString("ala_live_bar_map_str", ""));
        this.Sa = com.baidu.live.c.np().getBoolean("is_new_live_close_strategy", false);
        this.Sb = com.baidu.live.c.np().getBoolean("is_new_gift_t_dou_strategy", false);
        this.Sc = com.baidu.live.c.np().getString("ala_feedback_url", null);
        this.QO = com.baidu.live.c.np().getInt("ala_video_resolution_level", 3);
        this.QP = com.baidu.live.c.np().getBoolean("ala_live_hard_encode_switch", true);
        this.QR = com.baidu.live.c.np().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.np().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.np().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.np().getInt("ala_video_increase_count", 3);
        this.QS = com.baidu.live.c.np().getString("ala_video_soft_bitrate_config", null);
        this.QT = com.baidu.live.c.np().getString("ala_video_hard_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.np().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.np().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.Sd = com.baidu.live.c.np().getBoolean("key_is_open_login_prove", false);
        this.Se = com.baidu.live.c.np().getBoolean("key_is_open_diamond", false);
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
                this.Qg = optJSONObject2.optString("toast");
                this.Qf = optJSONObject2.optInt("remind_type");
            }
            this.QD = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.np().putString("bluediamond_url", this.QD);
            this.Qs = jSONObject.optString("verify_content");
            com.baidu.live.c.np().putString("verify_content", this.Qs);
            this.Qr = jSONObject.optString("live_notice");
            com.baidu.live.c.np().putString("live_notice", this.Qr);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.Qq.add(i, optString);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.Qt.add(i2, optString2);
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
                        this.Qp.add(cVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.Qu.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.Rd = optJSONObject5.optString("url");
            } else {
                this.Rd = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.Re = optJSONObject6.optString("reward_notice");
                this.Rg = optJSONObject6.optString("reward_rank_notice");
                this.Rf = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.Re = "";
                this.Rg = "";
                this.Rf = 2;
            }
            com.baidu.live.c.np().putString("share_host", this.Rd);
            com.baidu.live.c.np().putString("ala_share_in_bar_notice_text", this.Re);
            com.baidu.live.c.np().putString("ala_share_reward_rank_notice_text", this.Rg);
            com.baidu.live.c.np().putInt("ala_share_in_bar_notice_tip_switch", this.Rf);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.QE = optJSONObject7.optInt("value");
            } else {
                this.QE = 60;
            }
            com.baidu.live.c.np().putInt("recommend_refresh", this.QE);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.np().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.Qv = g(optJSONArray5);
            }
            if (jSONObject.optJSONObject("stream_level_high") != null) {
                JSONArray optJSONArray6 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.np().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.Qw = g(optJSONArray6);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject9 != null) {
                this.QL = optJSONObject9.optString("time_interval");
                this.QM = optJSONObject9.optInt("exception_interval");
            } else {
                this.QL = "300";
                this.QM = 1;
            }
            com.baidu.live.c.np().putString("strategy_conf", this.QL);
            com.baidu.live.c.np().putInt("strategy_exception_interval", this.QM);
            this.QJ = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.np().putInt("liveStartAuthLevel", this.QJ);
            JSONObject optJSONObject10 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject10 != null) {
                this.Qz = optJSONObject10.optInt("2gTo");
                if (this.Qz < 3) {
                    this.Qz = 3;
                }
                this.QB = optJSONObject10.optInt("3gTo");
                if (this.QB < 3) {
                    this.QB = 3;
                }
                this.QC = optJSONObject10.optInt("wifiTo");
                if (this.QC < 3) {
                    this.QC = 3;
                }
                com.baidu.live.c.np().putInt("2gTo", this.Qz);
                com.baidu.live.c.np().putInt("3gTo", this.QB);
                com.baidu.live.c.np().putInt("wifiTo", this.QC);
            }
            this.Rk = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.np().putInt("square_tab_strategy", this.Rk);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject11 != null) {
                this.Rl = optJSONObject11.optString(BigdayActivityConfig.JUMP_URL);
                this.Rm = optJSONObject11.optString("flower_rank_rule");
            }
            com.baidu.live.c.np().putString("ala_live_ranklist_url", this.Rl);
            com.baidu.live.c.np().putString("new_flower_rank_list_description_url", this.Rm);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject12 != null) {
                this.Rn = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.np().putString("ala_game_player_signup_url", this.Rn);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject13 != null) {
                this.Ro = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.np().putString("ala_game_frs_live_tab_video_url", this.Ro);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject14 != null) {
                this.Rp = optJSONObject14.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.np().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.Rq.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject15 != null) {
                com.baidu.live.c.np().putString("ala_live_session_replace_key", optJSONObject15.toString());
                this.Rt = optJSONObject15.optString("hlsUrl");
                this.Rr = optJSONObject15.optString("rtmpUrl");
                this.Rs = optJSONObject15.optString("flvUrl");
                this.Ru = optJSONObject15.optString(".m3u8");
            }
            b(true, this.Rp);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject16 != null) {
                this.Rv = optJSONObject16.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.np().putString("ala_personal_income_detail_url", this.Rv);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject17 != null) {
                this.RY = optJSONObject17.optInt("android_show");
                com.baidu.live.c.np().putInt("ala_custom_gift_category_id", this.RY);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject18 != null) {
                int optInt = optJSONObject18.optInt("open", 0);
                this.Rw = optInt == 1;
                com.baidu.live.c.np().putInt("ala_live_pk_switch", optInt);
                this.Rx = optJSONObject18.optLong("interval");
                if (this.Rx < 1000) {
                    this.Rx = 1000L;
                }
                com.baidu.live.c.np().putLong("ala_live_pk_check_interval", this.Rx);
                this.Ry = optJSONObject18.optLong("match_timeout");
                if (this.Ry < 60000) {
                    this.Ry = 60000L;
                }
                com.baidu.live.c.np().putLong("ala_live_pk_match_timeout", this.Ry);
                this.Rz = optJSONObject18.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.np().putString("ala_live_pk_pic_url", this.Rz);
                this.RA = optJSONObject18.optString("rank_link");
                com.baidu.live.c.np().putString("ala_live_pk_pic_jump_url", this.RA);
                this.RB = optJSONObject18.optString("history_link");
                com.baidu.live.c.np().putString("ala_live_pk_history_link", this.RB);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject19 != null) {
                this.RD = optJSONObject19.optLong("random_interval");
                if (this.RD < 1000) {
                    this.RD = 1000L;
                }
                com.baidu.live.c.np().putLong("ala_challenge_random_interval", this.RD);
                this.RE = optJSONObject19.optLong("direct_interval");
                if (this.RE < 1000) {
                    this.RE = 1000L;
                }
                com.baidu.live.c.np().putLong("ala_challenge_direct_interval", this.RE);
                this.RF = optJSONObject19.optLong("challenge_info_interval");
                if (this.RF < 1000) {
                    this.RF = 1000L;
                }
                com.baidu.live.c.np().putLong("ala_get_challenge_info_interval", this.RF);
                this.RH = optJSONObject19.optString("pk_icon_url");
                com.baidu.live.c.np().putString("ala_challenge_pk_entry_icon_url", this.RH);
                this.RI = optJSONObject19.optString("icon_url");
                com.baidu.live.c.np().putString("ala_challenge_pk_entry_icon_url", this.RI);
                this.RG = optJSONObject19.optString("rule_url");
                com.baidu.live.c.np().putString("ala_challenge_pk_entry_icon_url", this.RG);
                this.RJ = optJSONObject19.optInt("allin_open") == 1;
                com.baidu.live.c.np().putBoolean("ala_challenge_all_in_open", this.RJ);
                this.RK = optJSONObject19.optString("ad_text");
                com.baidu.live.c.np().putString("ala_challenge_ad_text", this.RK);
                this.RL = optJSONObject19.optString("ad_top_image");
                com.baidu.live.c.np().putString("ala_challenge_ad_top_img_url", this.RL);
                this.RR = optJSONObject19.optString("ad_bottom_color");
                com.baidu.live.c.np().putString("ala_challenge_bottom_ad_color", this.RR);
                this.RO = optJSONObject19.optString("ad_bottom_image");
                com.baidu.live.c.np().putString("ala_challenge_ad_bottom_img_url", this.RO);
                this.RP = optJSONObject19.optString("ad_btn_bg");
                com.baidu.live.c.np().putString("ala_challenge_ad_btn_bg_url", this.RP);
                this.RQ = optJSONObject19.optString("ad_url");
                com.baidu.live.c.np().putString("ala_challenge_ad_click_url", this.RQ);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject20 != null) {
                this.RC = optJSONObject20.optString("go_url");
                com.baidu.live.c.np().putString("show_live_forum_url", this.RC);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject21 != null) {
                this.RZ = optJSONObject21.optInt("use_https", 0) == 1;
                com.baidu.live.c.np().putBoolean("ala_guess_use_https", this.RZ);
            }
            String optString3 = jSONObject.optString("live_bar");
            bW(optString3);
            com.baidu.live.c.np().putString("ala_live_bar_map_str", optString3);
            this.Sa = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.np().putBoolean("is_new_live_close_strategy", this.Sa);
            this.Sb = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.np().putBoolean("is_new_gift_t_dou_strategy", this.Sb);
            this.Sc = jSONObject.optString("feedback_url");
            com.baidu.live.c.np().putString("ala_feedback_url", this.Sc);
            JSONObject optJSONObject22 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject22 != null && (optJSONObject = optJSONObject22.optJSONObject("challenge_related_zip")) != null) {
                this.RW = optJSONObject.optString("zip_md5");
                this.RX = optJSONObject.optString("zip_url");
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
                this.QP = optJSONObject24.optInt("encoder", 1) == 1;
                com.baidu.live.c.np().putBoolean("ala_live_hard_encode_switch", this.QP);
                this.QR = optJSONObject24.optInt("dynamic", 1) == 1;
                com.baidu.live.c.np().putBoolean("ala_dynamic_bitrate_switch", this.QR);
                this.QO = optJSONObject24.optInt("resolution", 3);
                com.baidu.live.c.np().putInt("ala_video_resolution_level", this.QO);
                JSONArray optJSONArray8 = optJSONObject24.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.QS = optJSONArray8.toString();
                    com.baidu.live.c.np().putString("ala_video_soft_bitrate_config", this.QS);
                }
                JSONArray optJSONArray9 = optJSONObject24.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.QT = optJSONArray9.toString();
                    com.baidu.live.c.np().putString("ala_video_hard_bitrate_config", this.QT);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ok() {
        this.Sg = com.baidu.live.c.np().getInt("guide_speak_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        this.Sh = com.baidu.live.c.np().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.np().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.Si = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.Si[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void q(JSONObject jSONObject) {
        int length;
        this.Sg = jSONObject.optInt("rule_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL) * 1000;
        com.baidu.live.c.np().putInt("guide_speak_watch_time", this.Sg);
        this.Sh = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.np().putInt("guide_speak_show_times_max", this.Sh);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.Si = new String[length];
            for (int i = 0; i < length; i++) {
                this.Si[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.np().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void r(JSONObject jSONObject) {
        this.So = jSONObject.optInt("supernatant_time") * 1000;
        this.Sp = jSONObject.optInt("suoernatant_shownum");
        this.Sq = jSONObject.optInt("pop_window_time") * 1000;
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
            this.Sn = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.Sn.add(yuanPackageData);
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
                        this.Sr = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.Sr.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.Ss = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.Ss.add(str3);
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
        if (i != this.Rp) {
            z2 = true;
        }
        this.Rp = i;
        if (z || z2) {
            com.baidu.live.c.np().putInt("ala_live_session_default_key", i);
        }
    }

    private void on() {
        this.Rp = com.baidu.live.c.np().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.np().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.Rq.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.np().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.Rt = jSONObject.optString("hlsUrl");
                this.Rr = jSONObject.optString("rtmpUrl");
                this.Rs = jSONObject.optString("flvUrl");
                this.Ru = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean oo() {
        return this.Ri == 1;
    }
}
