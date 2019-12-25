package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.BaseData;
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
/* loaded from: classes2.dex */
public class q extends BaseData {
    public boolean WA;
    public String WB;
    public String WC;
    public String WG;
    public String WH;
    public Integer[] WK;
    public Integer[] WL;
    public int WM;
    public int WO;
    public int WP;
    public int WQ;
    public String WR;
    public int WS;
    public boolean WT;
    public boolean WU;
    public boolean WV;
    public boolean WW;
    public boolean WY;
    public String WZ;
    public boolean Ww;
    public boolean Wx;
    public boolean Wy;
    public boolean Wz;
    public String XA;
    private String XB;
    private String XC;
    public int XD;
    public String XF;
    public String XG;
    public String XH;
    public String XI;
    public String XJ;
    public boolean XK;
    public long XL;
    public long XM;
    public String XN;
    public String XO;
    public String XP;
    public String XQ;
    public long XR;
    public long XS;
    public long XT;
    public String XU;
    public String XV;
    public String XW;
    public boolean XX;
    public String XY;
    public String XZ;
    public int Xa;
    public boolean Xb;
    public int Xc;
    public boolean Xd;
    public boolean Xe;
    public String Xf;
    public String Xg;
    public boolean Xh;
    public boolean Xi;
    public boolean Xj;
    public boolean Xk;
    public String Xo;
    public String Xq;
    public String Xr;
    public int Xx;
    public String Xz;
    public int YA;
    public int YB;
    public int YC;
    public List<String> YD;
    public List<String> YE;
    public List<String> YF;
    public x YN;
    public boolean YO;
    public String YP;
    public String Ya;
    public String Yb;
    public String Yc;
    public String Yd;
    public String Yf;
    public String Yg;
    public String Yh;
    public String Yi;
    public int Yj;
    public String Yn;
    public int Ys;
    public int Yt;
    public String[] Yu;
    public int Yv;
    public String Yw;
    public String Yx;
    public QuickImInputData Yy;
    public List<YuanPackageData> Yz;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int Wu = -1;
    public String Wv = null;
    public int WX = 1;
    public boolean Xl = true;
    public boolean Xm = false;
    public boolean Xn = false;
    public boolean Xp = false;
    public String Xs = "";
    private int Xt = 2;
    public String Xu = "";
    public int Xv = 1;
    public int Xw = 0;
    public int Xy = 1;
    public List<String> XE = new ArrayList();
    public boolean Ye = false;
    public boolean Yk = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean Yl = false;
    public boolean Ym = false;
    public boolean Yo = false;
    public boolean Yp = false;
    public boolean Yq = false;
    public boolean Yr = false;
    public int YG = 200;
    public int YH = 100;
    public int YI = 10;
    public int YJ = 10;
    public int YK = 10;
    public int YL = 50;
    public int YM = 5;
    public List<String> WF = new ArrayList();
    public List<String> WN = new ArrayList();
    public List<String> WI = new ArrayList();
    public List<Integer> WJ = new ArrayList();
    public ArrayList<e> WD = new ArrayList<>();
    public ArrayList<e> WE = new ArrayList<>();

    public q(boolean z) {
        if (z) {
            pD();
            this.WM = com.baidu.live.c.oI().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.oI().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.oI().getInt("restart_time_interval", 300);
            pE();
            pC();
            pF();
            pG();
        }
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        if (jSONObject != null) {
            try {
                this.clientIP = jSONObject.optString("client_ip");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("switch");
                if (optJSONObject2 != null) {
                    j(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject3 != null) {
                    this.WM = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.oI().putInt("conn_conf", this.WM);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.WN.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.c.oI().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.c.oI().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    k(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    l(optJSONObject5);
                }
                this.Xq = jSONObject.optString("client_id");
                com.baidu.live.c.oI().putString("client_id", this.Xq);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.WB = optJSONObject6.optString("pic_url");
                    this.WC = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            e eVar = new e();
                            eVar.parseJson(optJSONObject8);
                            this.WD.add(eVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.oI().putString("pic_url", this.WB);
                com.baidu.live.c.oI().putString(BigdayActivityConfig.JUMP_URL, this.WC);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    m(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.Yv = optJSONObject10.optInt("resource_switch");
                    this.Yx = optJSONObject10.optString("photo_url");
                    this.Yw = optJSONObject10.optString("resource_url");
                }
                this.Yy = new QuickImInputData();
                this.Yy.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                JSONObject optJSONObject11 = jSONObject.optJSONObject("guide_follow");
                if (optJSONObject11 != null) {
                    n(optJSONObject11);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.oI().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject12 != null) {
                    JSONObject optJSONObject13 = optJSONObject12.optJSONObject("rank");
                    if (optJSONObject13 != null && (optJSONObject = optJSONObject13.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.c.oI().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.c.oI().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.c.oI().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject14 = optJSONObject12.optJSONObject("guard_seat");
                    if (optJSONObject14 != null) {
                        this.YP = optJSONObject14.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject15 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject15 != null) {
                    this.YN = new x();
                    this.YN.Zn = optJSONObject15.optString("certify_refuse_url");
                    com.baidu.live.c.oI().putString("ala_certify_refuse_url", this.YN.Zn);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.oI().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void pC() {
        String string = com.baidu.live.c.oI().getString("ala_prepare_random_title_list", "");
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
            this.YF = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.YF.add(jSONArray.optString(i));
            }
        }
    }

    private void pD() {
        this.Ww = com.baidu.live.c.oI().getBoolean("map_around_map", false);
        this.Xb = com.baidu.live.c.oI().getBoolean("withdraw_switch", true);
        this.Xo = com.baidu.live.c.oI().getString("withdraw_text", "");
        this.Xh = com.baidu.live.c.oI().getBoolean("use_internal_player_switch", true);
        this.Xi = com.baidu.live.c.oI().getBoolean("live_beauty_open_switch", false);
        this.Xj = com.baidu.live.c.oI().getBoolean("live_unity_beauty_switch", true);
        this.Xk = com.baidu.live.c.oI().getBoolean("live_unity_beauty_face_style_switch", true);
        this.Xl = com.baidu.live.c.oI().getBoolean("sp_key_live_game_hard_encode", true);
        this.Xm = com.baidu.live.c.oI().getBoolean("sp_key_live_play_transcode_support", false);
        this.Xn = com.baidu.live.c.oI().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.Xp = com.baidu.live.c.oI().getBoolean("ala_enable_graffiti_str", false);
        this.Wx = com.baidu.live.c.oI().getBoolean("enter_live", false);
        this.Wy = com.baidu.live.c.oI().getBoolean("sync_to_forum", true);
        this.Wz = com.baidu.live.c.oI().getBoolean("show_water_mark", false);
        this.WA = com.baidu.live.c.oI().getBoolean("show_third_part_water_mark_switch", false);
        this.WT = com.baidu.live.c.oI().getBoolean("stream_error_log", true);
        this.WU = com.baidu.live.c.oI().getBoolean("disable_channel_in", true);
        this.WV = com.baidu.live.c.oI().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.WW = com.baidu.live.c.oI().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.WY = com.baidu.live.c.oI().getBoolean("follow_default_push_switch", true);
        this.Xx = com.baidu.live.c.oI().getInt("to_tb_some_switch", 0);
        this.Xv = com.baidu.live.c.oI().getInt("enable_live_stat", 1);
        this.Xw = com.baidu.live.c.oI().getInt("ala_free_gift_task_switch", 0);
        this.Ye = com.baidu.live.c.oI().getBoolean("live_challenge_switch", false);
        this.Yf = com.baidu.live.c.oI().getString("live_challenge_tip", null);
        this.Yg = com.baidu.live.c.oI().getString("live_challenge_url", null);
    }

    private void j(JSONObject jSONObject) {
        int optInt;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.Ww = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.oI().putBoolean("map_around_map", this.Ww);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.Xb = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("withdraw_switch", this.Xb);
                this.Xo = optJSONObject2.optString("text");
                com.baidu.live.c.oI().putString("withdraw_text", this.Xo);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.Xh = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("use_internal_player_switch", this.Xh);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject4 != null) {
                this.Xi = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("live_beauty_open_switch", this.Xi);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject5 != null) {
                this.Xj = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("live_unity_beauty_switch", this.Xj);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject6 != null) {
                this.Xk = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("live_unity_beauty_face_style_switch", this.Xk);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject7 != null) {
                this.Xl = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("sp_key_live_game_hard_encode", this.Xl);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject8 != null) {
                this.Xm = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("sp_key_live_play_transcode_support", this.Xm);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject9 != null) {
                this.Xn = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("sp_key_live_play_attention_guide_support", this.Xn);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject10 != null) {
                this.Wx = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("enter_live", this.Wx);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject11 != null) {
                this.Wy = optJSONObject11.optString("switch").equals("1");
                com.baidu.live.c.oI().putBoolean("sync_to_forum", this.Wy);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject12 != null) {
                this.Wz = optJSONObject12.optString("switch").equals("1");
                com.baidu.live.c.oI().putBoolean("show_water_mark", this.Wz);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject13 != null) {
                this.WA = optJSONObject13.optString("switch").equals("1");
                com.baidu.live.c.oI().putBoolean("show_third_part_water_mark_switch", this.WA);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject14 != null) {
                this.Xv = optJSONObject14.optInt("switch");
                com.baidu.live.c.oI().putInt("enable_live_stat", this.Xv);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject15 != null) {
                this.WT = optJSONObject15.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("stream_error_log", this.WT);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject16 != null) {
                this.WU = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.oI().putBoolean("disable_channel_in", this.WU);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject17 != null) {
                this.WV = optJSONObject17.optString("switch").equals("1");
                com.baidu.live.c.oI().putBoolean("shoubai_yanzhi_tab_tip", this.WV);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject18 != null) {
                this.WW = optJSONObject18.optString("switch").equals("1");
                com.baidu.live.c.oI().putBoolean(ActionJsonData.TAG_SIGN_IN, this.WW);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject19 != null) {
                this.WY = optJSONObject19.optString("switch").equals("2");
                com.baidu.live.c.oI().putBoolean("follow_default_push_switch", this.WY);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject20 != null) {
                this.Xx = optJSONObject20.optInt("switch");
                com.baidu.live.c.oI().putInt("to_tb_some_switch", this.Xx);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("task_config");
            if (optJSONObject21 != null) {
                this.Xw = optJSONObject21.optInt("switch");
                com.baidu.live.c.oI().putInt("ala_free_gift_task_switch", this.Xx);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject22 != null) {
                this.Xp = optJSONObject22.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("ala_enable_graffiti_str", this.Xp);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject23 != null) {
                this.Ye = optJSONObject23.optInt("switch") == 1;
                this.Yf = optJSONObject23.optString("title");
                this.Yg = optJSONObject23.optString("url");
                com.baidu.live.c.oI().putBoolean("live_challenge_switch", this.Ye);
                com.baidu.live.c.oI().putString("live_challenge_tip", this.Yf);
                com.baidu.live.c.oI().putString("live_challenge_url", this.Yg);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject24 != null) {
                this.Ym = optJSONObject24.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("is_new_gift_t_dou_strategy", this.Ym);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject25 != null) {
                this.Yq = optJSONObject25.optInt("switch") == 1;
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject26 != null) {
                this.Yo = optJSONObject26.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("key_is_open_login_prove", this.Yo);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject27 != null) {
                this.Yp = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("key_is_open_diamond", this.Yp);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject28 != null) {
                this.Yr = optJSONObject28.optInt("switch") == 1;
                com.baidu.live.c.oI().putBoolean("key_is_jump_to_live_room", this.Yr);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject29 != null && (optInt = optJSONObject29.optInt("switch", -1)) >= 0) {
                this.YO = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void pE() {
        this.WR = com.baidu.live.c.oI().getString("bluediamond_url", "");
        this.WH = com.baidu.live.c.oI().getString("verify_content", this.WH);
        this.WG = com.baidu.live.c.oI().getString("live_notice", "");
        this.Xr = com.baidu.live.c.oI().getString("share_host", "");
        this.Xs = com.baidu.live.c.oI().getString("ala_share_in_bar_notice_text", "");
        this.Xu = com.baidu.live.c.oI().getString("ala_share_reward_rank_notice_text", "");
        this.Xt = com.baidu.live.c.oI().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.WS = com.baidu.live.c.oI().getInt("recommend_refresh", 60);
        this.WZ = com.baidu.live.c.oI().getString("strategy_conf", "300");
        this.Xa = com.baidu.live.c.oI().getInt("strategy_exception_interval", 1);
        this.WX = com.baidu.live.c.oI().getInt("liveStartAuthLevel", 1);
        this.WO = com.baidu.live.c.oI().getInt("2gTo", 5);
        this.WP = com.baidu.live.c.oI().getInt("3gTo", 3);
        this.WQ = com.baidu.live.c.oI().getInt("wifiTo", 3);
        String string = com.baidu.live.c.oI().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string)) {
                this.WK = g(new JSONArray(string));
            }
            String string2 = com.baidu.live.c.oI().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string2)) {
                this.WL = g(new JSONArray(string2));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.Xy = com.baidu.live.c.oI().getInt("square_tab_strategy", 1);
        this.Xz = com.baidu.live.c.oI().getString("ala_live_ranklist_url", null);
        this.XA = com.baidu.live.c.oI().getString("new_flower_rank_list_description_url", "");
        this.XB = com.baidu.live.c.oI().getString("ala_game_player_signup_url", null);
        this.XC = com.baidu.live.c.oI().getString("ala_game_frs_live_tab_video_url", null);
        pI();
        this.XJ = com.baidu.live.c.oI().getString("ala_personal_income_detail_url", null);
        this.Yj = com.baidu.live.c.oI().getInt("ala_custom_gift_category_id", -1);
        this.XK = com.baidu.live.c.oI().getInt("ala_live_pk_switch", 0) == 1;
        this.XL = com.baidu.live.c.oI().getLong("ala_live_pk_check_interval", 1000L);
        this.XM = com.baidu.live.c.oI().getLong("ala_live_pk_match_timeout", 60000L);
        this.XN = com.baidu.live.c.oI().getString("ala_live_pk_pic_url", "");
        this.XO = com.baidu.live.c.oI().getString("ala_live_pk_pic_jump_url", "");
        this.XP = com.baidu.live.c.oI().getString("ala_live_pk_history_link", "");
        this.XQ = com.baidu.live.c.oI().getString("show_live_forum_url", "");
        this.XR = com.baidu.live.c.oI().getLong("ala_challenge_random_interval", 1000L);
        this.XS = com.baidu.live.c.oI().getLong("ala_challenge_direct_interval", 1000L);
        this.XT = com.baidu.live.c.oI().getLong("ala_get_challenge_info_interval", 1000L);
        this.XV = com.baidu.live.c.oI().getString("ala_challenge_pk_entry_icon_url", "");
        this.XW = com.baidu.live.c.oI().getString("ala_challenge_pk_entry_icon_url", "");
        this.XU = com.baidu.live.c.oI().getString("ala_challenge_pk_entry_icon_url", "");
        this.XX = com.baidu.live.c.oI().getBoolean("ala_challenge_all_in_open", true);
        this.XY = com.baidu.live.c.oI().getString("ala_challenge_ad_text", "");
        this.XZ = com.baidu.live.c.oI().getString("ala_challenge_ad_top_img_url", "");
        this.Ya = com.baidu.live.c.oI().getString("ala_challenge_ad_bottom_img_url", "");
        this.Yb = com.baidu.live.c.oI().getString("ala_challenge_ad_btn_bg_url", "");
        this.Yc = com.baidu.live.c.oI().getString("ala_challenge_ad_click_url", "");
        this.Yd = com.baidu.live.c.oI().getString("ala_challenge_bottom_ad_color", "");
        this.Yk = com.baidu.live.c.oI().getBoolean("ala_guess_use_https", false);
        cN(com.baidu.live.c.oI().getString("ala_live_bar_map_str", ""));
        this.Yl = com.baidu.live.c.oI().getBoolean("is_new_live_close_strategy", false);
        this.Ym = com.baidu.live.c.oI().getBoolean("is_new_gift_t_dou_strategy", false);
        this.Yn = com.baidu.live.c.oI().getString("ala_feedback_url", null);
        this.Xc = com.baidu.live.c.oI().getInt("ala_video_resolution_level", 3);
        this.Xd = com.baidu.live.c.oI().getBoolean("ala_live_hard_encode_switch", true);
        this.Xe = com.baidu.live.c.oI().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.oI().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.oI().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.oI().getInt("ala_video_increase_count", 3);
        this.Xf = com.baidu.live.c.oI().getString("ala_video_soft_bitrate_config", null);
        this.Xg = com.baidu.live.c.oI().getString("ala_video_hard_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.oI().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.oI().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.Yo = com.baidu.live.c.oI().getBoolean("key_is_open_login_prove", false);
        this.Yp = com.baidu.live.c.oI().getBoolean("key_is_open_diamond", false);
        this.Yr = com.baidu.live.c.oI().getBoolean("key_is_jump_to_live_room", false);
        pH();
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

    private void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject2 != null) {
                this.Wv = optJSONObject2.optString("toast");
                this.Wu = optJSONObject2.optInt("remind_type");
            }
            this.WR = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.oI().putString("bluediamond_url", this.WR);
            this.WH = jSONObject.optString("verify_content");
            com.baidu.live.c.oI().putString("verify_content", this.WH);
            this.WG = jSONObject.optString("live_notice");
            com.baidu.live.c.oI().putString("live_notice", this.WG);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.WF.add(i, optString);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.WI.add(i2, optString2);
                    }
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("bd_live_activity");
            if (optJSONObject3 != null && (optJSONArray = optJSONObject3.optJSONArray("main_page")) != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject4 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject4 != null) {
                        e eVar = new e();
                        eVar.parseJson(optJSONObject4);
                        this.WE.add(eVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.WJ.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.Xr = optJSONObject5.optString("url");
            } else {
                this.Xr = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.Xs = optJSONObject6.optString("reward_notice");
                this.Xu = optJSONObject6.optString("reward_rank_notice");
                this.Xt = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.Xs = "";
                this.Xu = "";
                this.Xt = 2;
            }
            com.baidu.live.c.oI().putString("share_host", this.Xr);
            com.baidu.live.c.oI().putString("ala_share_in_bar_notice_text", this.Xs);
            com.baidu.live.c.oI().putString("ala_share_reward_rank_notice_text", this.Xu);
            com.baidu.live.c.oI().putInt("ala_share_in_bar_notice_tip_switch", this.Xt);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.WS = optJSONObject7.optInt("value");
            } else {
                this.WS = 60;
            }
            com.baidu.live.c.oI().putInt("recommend_refresh", this.WS);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.oI().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.WK = g(optJSONArray5);
            }
            if (jSONObject.optJSONObject("stream_level_high") != null) {
                JSONArray optJSONArray6 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.oI().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.WL = g(optJSONArray6);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject9 != null) {
                this.WZ = optJSONObject9.optString("time_interval");
                this.Xa = optJSONObject9.optInt("exception_interval");
            } else {
                this.WZ = "300";
                this.Xa = 1;
            }
            com.baidu.live.c.oI().putString("strategy_conf", this.WZ);
            com.baidu.live.c.oI().putInt("strategy_exception_interval", this.Xa);
            this.WX = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.oI().putInt("liveStartAuthLevel", this.WX);
            JSONObject optJSONObject10 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject10 != null) {
                this.WO = optJSONObject10.optInt("2gTo");
                if (this.WO < 3) {
                    this.WO = 3;
                }
                this.WP = optJSONObject10.optInt("3gTo");
                if (this.WP < 3) {
                    this.WP = 3;
                }
                this.WQ = optJSONObject10.optInt("wifiTo");
                if (this.WQ < 3) {
                    this.WQ = 3;
                }
                com.baidu.live.c.oI().putInt("2gTo", this.WO);
                com.baidu.live.c.oI().putInt("3gTo", this.WP);
                com.baidu.live.c.oI().putInt("wifiTo", this.WQ);
            }
            this.Xy = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.oI().putInt("square_tab_strategy", this.Xy);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject11 != null) {
                this.Xz = optJSONObject11.optString(BigdayActivityConfig.JUMP_URL);
                this.XA = optJSONObject11.optString("flower_rank_rule");
            }
            com.baidu.live.c.oI().putString("ala_live_ranklist_url", this.Xz);
            com.baidu.live.c.oI().putString("new_flower_rank_list_description_url", this.XA);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject12 != null) {
                this.XB = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.oI().putString("ala_game_player_signup_url", this.XB);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject13 != null) {
                this.XC = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.oI().putString("ala_game_frs_live_tab_video_url", this.XC);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject14 != null) {
                this.XD = optJSONObject14.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.oI().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.XE.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject15 != null) {
                com.baidu.live.c.oI().putString("ala_live_session_replace_key", optJSONObject15.toString());
                this.XH = optJSONObject15.optString("hlsUrl");
                this.XF = optJSONObject15.optString("rtmpUrl");
                this.XG = optJSONObject15.optString("flvUrl");
                this.XI = optJSONObject15.optString(".m3u8");
            }
            b(true, this.XD);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject16 != null) {
                this.XJ = optJSONObject16.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.oI().putString("ala_personal_income_detail_url", this.XJ);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject17 != null) {
                this.Yj = optJSONObject17.optInt("android_show");
                com.baidu.live.c.oI().putInt("ala_custom_gift_category_id", this.Yj);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject18 != null) {
                int optInt = optJSONObject18.optInt("open", 0);
                this.XK = optInt == 1;
                com.baidu.live.c.oI().putInt("ala_live_pk_switch", optInt);
                this.XL = optJSONObject18.optLong("interval");
                if (this.XL < 1000) {
                    this.XL = 1000L;
                }
                com.baidu.live.c.oI().putLong("ala_live_pk_check_interval", this.XL);
                this.XM = optJSONObject18.optLong("match_timeout");
                if (this.XM < 60000) {
                    this.XM = 60000L;
                }
                com.baidu.live.c.oI().putLong("ala_live_pk_match_timeout", this.XM);
                this.XN = optJSONObject18.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.oI().putString("ala_live_pk_pic_url", this.XN);
                this.XO = optJSONObject18.optString("rank_link");
                com.baidu.live.c.oI().putString("ala_live_pk_pic_jump_url", this.XO);
                this.XP = optJSONObject18.optString("history_link");
                com.baidu.live.c.oI().putString("ala_live_pk_history_link", this.XP);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject19 != null) {
                this.XR = optJSONObject19.optLong("random_interval");
                if (this.XR < 1000) {
                    this.XR = 1000L;
                }
                com.baidu.live.c.oI().putLong("ala_challenge_random_interval", this.XR);
                this.XS = optJSONObject19.optLong("direct_interval");
                if (this.XS < 1000) {
                    this.XS = 1000L;
                }
                com.baidu.live.c.oI().putLong("ala_challenge_direct_interval", this.XS);
                this.XT = optJSONObject19.optLong("challenge_info_interval");
                if (this.XT < 1000) {
                    this.XT = 1000L;
                }
                com.baidu.live.c.oI().putLong("ala_get_challenge_info_interval", this.XT);
                this.XV = optJSONObject19.optString("pk_icon_url");
                com.baidu.live.c.oI().putString("ala_challenge_pk_entry_icon_url", this.XV);
                this.XW = optJSONObject19.optString("icon_url");
                com.baidu.live.c.oI().putString("ala_challenge_pk_entry_icon_url", this.XW);
                this.XU = optJSONObject19.optString("rule_url");
                com.baidu.live.c.oI().putString("ala_challenge_pk_entry_icon_url", this.XU);
                this.XX = optJSONObject19.optInt("allin_open") == 1;
                com.baidu.live.c.oI().putBoolean("ala_challenge_all_in_open", this.XX);
                this.XY = optJSONObject19.optString("ad_text");
                com.baidu.live.c.oI().putString("ala_challenge_ad_text", this.XY);
                this.XZ = optJSONObject19.optString("ad_top_image");
                com.baidu.live.c.oI().putString("ala_challenge_ad_top_img_url", this.XZ);
                this.Yd = optJSONObject19.optString("ad_bottom_color");
                com.baidu.live.c.oI().putString("ala_challenge_bottom_ad_color", this.Yd);
                this.Ya = optJSONObject19.optString("ad_bottom_image");
                com.baidu.live.c.oI().putString("ala_challenge_ad_bottom_img_url", this.Ya);
                this.Yb = optJSONObject19.optString("ad_btn_bg");
                com.baidu.live.c.oI().putString("ala_challenge_ad_btn_bg_url", this.Yb);
                this.Yc = optJSONObject19.optString("ad_url");
                com.baidu.live.c.oI().putString("ala_challenge_ad_click_url", this.Yc);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject20 != null) {
                this.XQ = optJSONObject20.optString("go_url");
                com.baidu.live.c.oI().putString("show_live_forum_url", this.XQ);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject21 != null) {
                this.Yk = optJSONObject21.optInt("use_https", 0) == 1;
                com.baidu.live.c.oI().putBoolean("ala_guess_use_https", this.Yk);
            }
            String optString3 = jSONObject.optString("live_bar");
            cN(optString3);
            com.baidu.live.c.oI().putString("ala_live_bar_map_str", optString3);
            this.Yl = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.oI().putBoolean("is_new_live_close_strategy", this.Yl);
            this.Ym = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.oI().putBoolean("is_new_gift_t_dou_strategy", this.Ym);
            this.Yn = jSONObject.optString("feedback_url");
            com.baidu.live.c.oI().putString("ala_feedback_url", this.Yn);
            JSONObject optJSONObject22 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject22 != null && (optJSONObject = optJSONObject22.optJSONObject("challenge_related_zip")) != null) {
                this.Yh = optJSONObject.optString("zip_md5");
                this.Yi = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject23 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject23.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject23.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.oI().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.oI().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("open_live");
            if (optJSONObject24 != null) {
                this.increaseThreshold = optJSONObject24.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.oI().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject24.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.oI().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject24.optInt("thi_count", 3);
                com.baidu.live.c.oI().putInt("ala_video_increase_count", this.increaseCount);
                this.Xd = optJSONObject24.optInt("encoder", 1) == 1;
                com.baidu.live.c.oI().putBoolean("ala_live_hard_encode_switch", this.Xd);
                this.Xe = optJSONObject24.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.oI().putBoolean("ala_dynamic_bitrate_switch", this.Xe);
                this.Xc = optJSONObject24.optInt("resolution", 3);
                com.baidu.live.c.oI().putInt("ala_video_resolution_level", this.Xc);
                JSONArray optJSONArray8 = optJSONObject24.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.Xf = optJSONArray8.toString();
                    com.baidu.live.c.oI().putString("ala_video_soft_bitrate_config", this.Xf);
                }
                JSONArray optJSONArray9 = optJSONObject24.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.Xg = optJSONArray9.toString();
                    com.baidu.live.c.oI().putString("ala_video_hard_bitrate_config", this.Xg);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.YG = jSONObject.optInt("im_max", 200);
            if (this.YG <= 0) {
                this.YG = 200;
            }
            this.YH = jSONObject.optInt("barrage_max", 100);
            if (this.YH <= 0) {
                this.YH = 100;
            }
            this.YI = jSONObject.optInt("pay_barrage_max", 10);
            if (this.YI <= 0) {
                this.YI = 10;
            }
            this.YJ = jSONObject.optInt("enter_effect_max", 10);
            if (this.YJ <= 0) {
                this.YJ = 10;
            }
            this.YK = jSONObject.optInt("gift_big_max", 10);
            if (this.YK <= 0) {
                this.YK = 10;
            }
            this.YL = jSONObject.optInt("gift_small_max", 50);
            if (this.YL <= 0) {
                this.YL = 50;
            }
            this.YM = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.YM <= 0) {
                this.YM = 5;
            }
        }
    }

    private void pF() {
        this.Ys = com.baidu.live.c.oI().getInt("guide_speak_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        this.Yt = com.baidu.live.c.oI().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.oI().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.Yu = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.Yu[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void m(JSONObject jSONObject) {
        int length;
        this.Ys = jSONObject.optInt("rule_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL) * 1000;
        com.baidu.live.c.oI().putInt("guide_speak_watch_time", this.Ys);
        this.Yt = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.oI().putInt("guide_speak_show_times_max", this.Yt);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.Yu = new String[length];
            for (int i = 0; i < length; i++) {
                this.Yu[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.oI().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void n(JSONObject jSONObject) {
        this.YA = jSONObject.optInt("supernatant_time") * 1000;
        this.YB = jSONObject.optInt("suoernatant_shownum");
        this.YC = jSONObject.optInt("pop_window_time") * 1000;
    }

    private void pG() {
        String string = com.baidu.live.c.oI().getString("yuan_package_data", "");
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
            this.Yz = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.Yz.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void cM(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.YD = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.YD.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.YE = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.YE.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.oI().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void pH() {
        cM(com.baidu.live.c.oI().getString("ala_quick_send_im_list", null));
    }

    private void cN(String str) {
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
        if (i != this.XD) {
            z2 = true;
        }
        this.XD = i;
        if (z || z2) {
            com.baidu.live.c.oI().putInt("ala_live_session_default_key", i);
        }
    }

    private void pI() {
        this.XD = com.baidu.live.c.oI().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.oI().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.XE.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.oI().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.XH = jSONObject.optString("hlsUrl");
                this.XF = jSONObject.optString("rtmpUrl");
                this.XG = jSONObject.optString("flvUrl");
                this.XI = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean pJ() {
        return this.Xw == 1;
    }
}
