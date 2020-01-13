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
public class s extends BaseData {
    public boolean WP;
    public boolean WQ;
    public boolean WR;
    public boolean WS;
    public boolean WT;
    public String WU;
    public String WV;
    public String WZ;
    public boolean XA;
    public boolean XB;
    public boolean XC;
    public boolean XD;
    public String XH;
    public String XJ;
    public String XK;
    public int XQ;
    public String XS;
    public String XT;
    private String XU;
    private String XV;
    public int XW;
    public String XY;
    public String XZ;
    public String Xa;
    public Integer[] Xd;
    public Integer[] Xe;
    public int Xf;
    public int Xh;
    public int Xi;
    public int Xj;
    public String Xk;
    public int Xl;
    public boolean Xm;
    public boolean Xn;
    public boolean Xo;
    public boolean Xp;
    public boolean Xr;
    public String Xs;
    public int Xt;
    public boolean Xu;
    public int Xv;
    public boolean Xw;
    public boolean Xx;
    public String Xy;
    public String Xz;
    public int YE;
    public int YF;
    public String[] YG;
    public int YH;
    public String YI;
    public String YJ;
    public QuickImInputData YK;
    public List<YuanPackageData> YL;
    public int YM;
    public int YN;
    public int YO;
    public List<String> YP;
    public List<String> YQ;
    public List<String> YR;
    public z YZ;
    public String Ya;
    public String Yb;
    public String Yc;
    public boolean Yd;
    public long Ye;
    public long Yf;
    public String Yg;
    public String Yh;
    public String Yi;
    public String Yj;
    public long Yk;
    public long Yl;
    public long Ym;
    public String Yn;
    public String Yo;
    public String Yp;
    public String Yr;
    public String Ys;
    public String Yt;
    public String Yu;
    public int Yv;
    public String Yz;
    public boolean Za;
    public String Zb;
    public AlaFeedDiversionData Zc;
    public boolean Zd;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int WN = -1;
    public String WO = null;
    public int Xq = 1;
    public boolean XE = true;
    public boolean XF = false;
    public boolean XG = false;
    public boolean XI = false;
    public String XL = "";
    private int XM = 2;
    public String XN = "";
    public int XO = 1;
    public int XP = 0;
    public int XR = 1;
    public List<String> XX = new ArrayList();
    public boolean Yq = false;
    public boolean Yw = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean Yx = false;
    public boolean Yy = false;
    public boolean YA = false;
    public boolean YB = false;
    public boolean YC = false;
    public boolean YD = false;
    public int YS = 200;
    public int YT = 100;
    public int YU = 10;
    public int YV = 10;
    public int YW = 10;
    public int YX = 50;
    public int YY = 5;
    public List<String> WY = new ArrayList();
    public List<String> Xg = new ArrayList();
    public List<String> Xb = new ArrayList();
    public List<Integer> Xc = new ArrayList();
    public ArrayList<e> WW = new ArrayList<>();
    public ArrayList<e> WX = new ArrayList<>();

    public s(boolean z) {
        if (z) {
            pH();
            this.Xf = com.baidu.live.c.oJ().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.oJ().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.oJ().getInt("restart_time_interval", 300);
            pI();
            pG();
            pJ();
            pK();
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
                    this.Xf = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.oJ().putInt("conn_conf", this.Xf);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.Xg.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.c.oJ().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.c.oJ().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    k(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    l(optJSONObject5);
                }
                this.XJ = jSONObject.optString("client_id");
                com.baidu.live.c.oJ().putString("client_id", this.XJ);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.WU = optJSONObject6.optString("pic_url");
                    this.WV = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            e eVar = new e();
                            eVar.parseJson(optJSONObject8);
                            this.WW.add(eVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.oJ().putString("pic_url", this.WU);
                com.baidu.live.c.oJ().putString(BigdayActivityConfig.JUMP_URL, this.WV);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    m(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.YH = optJSONObject10.optInt("resource_switch");
                    this.YJ = optJSONObject10.optString("photo_url");
                    this.YI = optJSONObject10.optString("resource_url");
                }
                this.YK = new QuickImInputData();
                this.YK.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                JSONObject optJSONObject11 = jSONObject.optJSONObject("guide_follow");
                if (optJSONObject11 != null) {
                    n(optJSONObject11);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.oJ().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject12 != null) {
                    JSONObject optJSONObject13 = optJSONObject12.optJSONObject("rank");
                    if (optJSONObject13 != null && (optJSONObject = optJSONObject13.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.c.oJ().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.c.oJ().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.c.oJ().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject14 = optJSONObject12.optJSONObject("guard_seat");
                    if (optJSONObject14 != null) {
                        this.Zb = optJSONObject14.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject15 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject15 != null) {
                    this.YZ = new z();
                    this.YZ.ZB = optJSONObject15.optString("certify_refuse_url");
                    com.baidu.live.c.oJ().putString("ala_certify_refuse_url", this.YZ.ZB);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.oJ().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void pG() {
        String string = com.baidu.live.c.oJ().getString("ala_prepare_random_title_list", "");
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
            this.YR = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.YR.add(jSONArray.optString(i));
            }
        }
    }

    private void pH() {
        this.WP = com.baidu.live.c.oJ().getBoolean("map_around_map", false);
        this.Xu = com.baidu.live.c.oJ().getBoolean("withdraw_switch", true);
        this.XH = com.baidu.live.c.oJ().getString("withdraw_text", "");
        this.XA = com.baidu.live.c.oJ().getBoolean("use_internal_player_switch", true);
        this.XB = com.baidu.live.c.oJ().getBoolean("live_beauty_open_switch", false);
        this.XC = com.baidu.live.c.oJ().getBoolean("live_unity_beauty_switch", true);
        this.XD = com.baidu.live.c.oJ().getBoolean("live_unity_beauty_face_style_switch", true);
        this.XE = com.baidu.live.c.oJ().getBoolean("sp_key_live_game_hard_encode", true);
        this.XF = com.baidu.live.c.oJ().getBoolean("sp_key_live_play_transcode_support", false);
        this.XG = com.baidu.live.c.oJ().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.XI = com.baidu.live.c.oJ().getBoolean("ala_enable_graffiti_str", false);
        this.WQ = com.baidu.live.c.oJ().getBoolean("enter_live", false);
        this.WR = com.baidu.live.c.oJ().getBoolean("sync_to_forum", true);
        this.WS = com.baidu.live.c.oJ().getBoolean("show_water_mark", false);
        this.WT = com.baidu.live.c.oJ().getBoolean("show_third_part_water_mark_switch", false);
        this.Xm = com.baidu.live.c.oJ().getBoolean("stream_error_log", true);
        this.Xn = com.baidu.live.c.oJ().getBoolean("disable_channel_in", true);
        this.Xo = com.baidu.live.c.oJ().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.Xp = com.baidu.live.c.oJ().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.Xr = com.baidu.live.c.oJ().getBoolean("follow_default_push_switch", true);
        this.XQ = com.baidu.live.c.oJ().getInt("to_tb_some_switch", 0);
        this.XO = com.baidu.live.c.oJ().getInt("enable_live_stat", 1);
        this.XP = com.baidu.live.c.oJ().getInt("ala_free_gift_task_switch", 0);
        this.Yq = com.baidu.live.c.oJ().getBoolean("live_challenge_switch", false);
        this.Yr = com.baidu.live.c.oJ().getString("live_challenge_tip", null);
        this.Ys = com.baidu.live.c.oJ().getString("live_challenge_url", null);
    }

    private void j(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.WP = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.oJ().putBoolean("map_around_map", this.WP);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.Xu = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("withdraw_switch", this.Xu);
                this.XH = optJSONObject2.optString("text");
                com.baidu.live.c.oJ().putString("withdraw_text", this.XH);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.XA = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("use_internal_player_switch", this.XA);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject4 != null) {
                this.XB = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("live_beauty_open_switch", this.XB);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject5 != null) {
                this.XC = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("live_unity_beauty_switch", this.XC);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject6 != null) {
                this.XD = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("live_unity_beauty_face_style_switch", this.XD);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject7 != null) {
                this.XE = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("sp_key_live_game_hard_encode", this.XE);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject8 != null) {
                this.XF = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("sp_key_live_play_transcode_support", this.XF);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject9 != null) {
                this.XG = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("sp_key_live_play_attention_guide_support", this.XG);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject10 != null) {
                this.WQ = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("enter_live", this.WQ);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject11 != null) {
                this.WR = optJSONObject11.optString("switch").equals("1");
                com.baidu.live.c.oJ().putBoolean("sync_to_forum", this.WR);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject12 != null) {
                this.WS = optJSONObject12.optString("switch").equals("1");
                com.baidu.live.c.oJ().putBoolean("show_water_mark", this.WS);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject13 != null) {
                this.WT = optJSONObject13.optString("switch").equals("1");
                com.baidu.live.c.oJ().putBoolean("show_third_part_water_mark_switch", this.WT);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject14 != null) {
                this.XO = optJSONObject14.optInt("switch");
                com.baidu.live.c.oJ().putInt("enable_live_stat", this.XO);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject15 != null) {
                this.Xm = optJSONObject15.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("stream_error_log", this.Xm);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject16 != null) {
                this.Xn = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.oJ().putBoolean("disable_channel_in", this.Xn);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject17 != null) {
                this.Xo = optJSONObject17.optString("switch").equals("1");
                com.baidu.live.c.oJ().putBoolean("shoubai_yanzhi_tab_tip", this.Xo);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject18 != null) {
                this.Xp = optJSONObject18.optString("switch").equals("1");
                com.baidu.live.c.oJ().putBoolean(ActionJsonData.TAG_SIGN_IN, this.Xp);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject19 != null) {
                this.Xr = optJSONObject19.optString("switch").equals("2");
                com.baidu.live.c.oJ().putBoolean("follow_default_push_switch", this.Xr);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject20 != null) {
                this.XQ = optJSONObject20.optInt("switch");
                com.baidu.live.c.oJ().putInt("to_tb_some_switch", this.XQ);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("task_config");
            if (optJSONObject21 != null) {
                this.XP = optJSONObject21.optInt("switch");
                com.baidu.live.c.oJ().putInt("ala_free_gift_task_switch", this.XQ);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject22 != null) {
                this.XI = optJSONObject22.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("ala_enable_graffiti_str", this.XI);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject23 != null) {
                this.Yq = optJSONObject23.optInt("switch") == 1;
                this.Yr = optJSONObject23.optString("title");
                this.Ys = optJSONObject23.optString("url");
                com.baidu.live.c.oJ().putBoolean("live_challenge_switch", this.Yq);
                com.baidu.live.c.oJ().putString("live_challenge_tip", this.Yr);
                com.baidu.live.c.oJ().putString("live_challenge_url", this.Ys);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject24 != null) {
                this.Yy = optJSONObject24.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("is_new_gift_t_dou_strategy", this.Yy);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject25 != null) {
                this.YC = optJSONObject25.optInt("switch") == 1;
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject26 != null) {
                this.YA = optJSONObject26.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("key_is_open_login_prove", this.YA);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject27 != null) {
                this.YB = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("key_is_open_diamond", this.YB);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject28 != null) {
                this.YD = optJSONObject28.optInt("switch") == 1;
                com.baidu.live.c.oJ().putBoolean("key_is_jump_to_live_room", this.YD);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject29 != null && (optInt2 = optJSONObject29.optInt("switch", -1)) >= 0) {
                this.Za = optInt2 == 1;
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject30 != null && (optInt = optJSONObject30.optInt("switch", -1)) >= 0) {
                this.Zd = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void pI() {
        this.Xk = com.baidu.live.c.oJ().getString("bluediamond_url", "");
        this.Xa = com.baidu.live.c.oJ().getString("verify_content", this.Xa);
        this.WZ = com.baidu.live.c.oJ().getString("live_notice", "");
        this.XK = com.baidu.live.c.oJ().getString("share_host", "");
        this.XL = com.baidu.live.c.oJ().getString("ala_share_in_bar_notice_text", "");
        this.XN = com.baidu.live.c.oJ().getString("ala_share_reward_rank_notice_text", "");
        this.XM = com.baidu.live.c.oJ().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.Xl = com.baidu.live.c.oJ().getInt("recommend_refresh", 60);
        this.Xs = com.baidu.live.c.oJ().getString("strategy_conf", "300");
        this.Xt = com.baidu.live.c.oJ().getInt("strategy_exception_interval", 1);
        this.Xq = com.baidu.live.c.oJ().getInt("liveStartAuthLevel", 1);
        this.Xh = com.baidu.live.c.oJ().getInt("2gTo", 5);
        this.Xi = com.baidu.live.c.oJ().getInt("3gTo", 3);
        this.Xj = com.baidu.live.c.oJ().getInt("wifiTo", 3);
        String string = com.baidu.live.c.oJ().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string)) {
                this.Xd = g(new JSONArray(string));
            }
            String string2 = com.baidu.live.c.oJ().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string2)) {
                this.Xe = g(new JSONArray(string2));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.XR = com.baidu.live.c.oJ().getInt("square_tab_strategy", 1);
        this.XS = com.baidu.live.c.oJ().getString("ala_live_ranklist_url", null);
        this.XT = com.baidu.live.c.oJ().getString("new_flower_rank_list_description_url", "");
        this.XU = com.baidu.live.c.oJ().getString("ala_game_player_signup_url", null);
        this.XV = com.baidu.live.c.oJ().getString("ala_game_frs_live_tab_video_url", null);
        pM();
        this.Yc = com.baidu.live.c.oJ().getString("ala_personal_income_detail_url", null);
        this.Yv = com.baidu.live.c.oJ().getInt("ala_custom_gift_category_id", -1);
        this.Yd = com.baidu.live.c.oJ().getInt("ala_live_pk_switch", 0) == 1;
        this.Ye = com.baidu.live.c.oJ().getLong("ala_live_pk_check_interval", 1000L);
        this.Yf = com.baidu.live.c.oJ().getLong("ala_live_pk_match_timeout", 60000L);
        this.Yg = com.baidu.live.c.oJ().getString("ala_live_pk_pic_url", "");
        this.Yh = com.baidu.live.c.oJ().getString("ala_live_pk_pic_jump_url", "");
        this.Yi = com.baidu.live.c.oJ().getString("ala_live_pk_history_link", "");
        this.Yj = com.baidu.live.c.oJ().getString("show_live_forum_url", "");
        this.Yk = com.baidu.live.c.oJ().getLong("ala_challenge_random_interval", 1000L);
        this.Yl = com.baidu.live.c.oJ().getLong("ala_challenge_direct_interval", 1000L);
        this.Ym = com.baidu.live.c.oJ().getLong("ala_get_challenge_info_interval", 1000L);
        this.Yo = com.baidu.live.c.oJ().getString("ala_challenge_pk_entry_icon_url", "");
        this.Yp = com.baidu.live.c.oJ().getString("ala_challenge_pk_entry_icon_url", "");
        this.Yn = com.baidu.live.c.oJ().getString("ala_challenge_pk_entry_icon_url", "");
        this.Yw = com.baidu.live.c.oJ().getBoolean("ala_guess_use_https", false);
        cP(com.baidu.live.c.oJ().getString("ala_live_bar_map_str", ""));
        this.Yx = com.baidu.live.c.oJ().getBoolean("is_new_live_close_strategy", false);
        this.Yy = com.baidu.live.c.oJ().getBoolean("is_new_gift_t_dou_strategy", false);
        this.Yz = com.baidu.live.c.oJ().getString("ala_feedback_url", null);
        this.Xv = com.baidu.live.c.oJ().getInt("ala_video_resolution_level", 3);
        this.Xw = com.baidu.live.c.oJ().getBoolean("ala_live_hard_encode_switch", true);
        this.Xx = com.baidu.live.c.oJ().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.oJ().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.oJ().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.oJ().getInt("ala_video_increase_count", 3);
        this.Xy = com.baidu.live.c.oJ().getString("ala_video_soft_bitrate_config", null);
        this.Xz = com.baidu.live.c.oJ().getString("ala_video_hard_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.oJ().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.oJ().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.YA = com.baidu.live.c.oJ().getBoolean("key_is_open_login_prove", false);
        this.YB = com.baidu.live.c.oJ().getBoolean("key_is_open_diamond", false);
        this.YD = com.baidu.live.c.oJ().getBoolean("key_is_jump_to_live_room", false);
        cN(com.baidu.live.c.oJ().getString("feed_diversion", ""));
        pL();
    }

    private void cN(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.Zc = new AlaFeedDiversionData();
                this.Zc.parserJson(jSONObject);
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

    private void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject2 != null) {
                this.WO = optJSONObject2.optString("toast");
                this.WN = optJSONObject2.optInt("remind_type");
            }
            this.Xk = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.oJ().putString("bluediamond_url", this.Xk);
            this.Xa = jSONObject.optString("verify_content");
            com.baidu.live.c.oJ().putString("verify_content", this.Xa);
            this.WZ = jSONObject.optString("live_notice");
            com.baidu.live.c.oJ().putString("live_notice", this.WZ);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.WY.add(i, optString);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.Xb.add(i2, optString2);
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
                        this.WX.add(eVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.Xc.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.XK = optJSONObject5.optString("url");
            } else {
                this.XK = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.XL = optJSONObject6.optString("reward_notice");
                this.XN = optJSONObject6.optString("reward_rank_notice");
                this.XM = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.XL = "";
                this.XN = "";
                this.XM = 2;
            }
            com.baidu.live.c.oJ().putString("share_host", this.XK);
            com.baidu.live.c.oJ().putString("ala_share_in_bar_notice_text", this.XL);
            com.baidu.live.c.oJ().putString("ala_share_reward_rank_notice_text", this.XN);
            com.baidu.live.c.oJ().putInt("ala_share_in_bar_notice_tip_switch", this.XM);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.Xl = optJSONObject7.optInt("value");
            } else {
                this.Xl = 60;
            }
            com.baidu.live.c.oJ().putInt("recommend_refresh", this.Xl);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.oJ().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.Xd = g(optJSONArray5);
            }
            if (jSONObject.optJSONObject("stream_level_high") != null) {
                JSONArray optJSONArray6 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.oJ().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.Xe = g(optJSONArray6);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject9 != null) {
                this.Xs = optJSONObject9.optString("time_interval");
                this.Xt = optJSONObject9.optInt("exception_interval");
            } else {
                this.Xs = "300";
                this.Xt = 1;
            }
            com.baidu.live.c.oJ().putString("strategy_conf", this.Xs);
            com.baidu.live.c.oJ().putInt("strategy_exception_interval", this.Xt);
            this.Xq = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.oJ().putInt("liveStartAuthLevel", this.Xq);
            JSONObject optJSONObject10 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject10 != null) {
                this.Xh = optJSONObject10.optInt("2gTo");
                if (this.Xh < 3) {
                    this.Xh = 3;
                }
                this.Xi = optJSONObject10.optInt("3gTo");
                if (this.Xi < 3) {
                    this.Xi = 3;
                }
                this.Xj = optJSONObject10.optInt("wifiTo");
                if (this.Xj < 3) {
                    this.Xj = 3;
                }
                com.baidu.live.c.oJ().putInt("2gTo", this.Xh);
                com.baidu.live.c.oJ().putInt("3gTo", this.Xi);
                com.baidu.live.c.oJ().putInt("wifiTo", this.Xj);
            }
            this.XR = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.oJ().putInt("square_tab_strategy", this.XR);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject11 != null) {
                this.XS = optJSONObject11.optString(BigdayActivityConfig.JUMP_URL);
                this.XT = optJSONObject11.optString("flower_rank_rule");
            }
            com.baidu.live.c.oJ().putString("ala_live_ranklist_url", this.XS);
            com.baidu.live.c.oJ().putString("new_flower_rank_list_description_url", this.XT);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject12 != null) {
                this.XU = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.oJ().putString("ala_game_player_signup_url", this.XU);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject13 != null) {
                this.XV = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.oJ().putString("ala_game_frs_live_tab_video_url", this.XV);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject14 != null) {
                this.XW = optJSONObject14.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.oJ().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.XX.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject15 != null) {
                com.baidu.live.c.oJ().putString("ala_live_session_replace_key", optJSONObject15.toString());
                this.Ya = optJSONObject15.optString("hlsUrl");
                this.XY = optJSONObject15.optString("rtmpUrl");
                this.XZ = optJSONObject15.optString("flvUrl");
                this.Yb = optJSONObject15.optString(".m3u8");
            }
            b(true, this.XW);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject16 != null) {
                this.Yc = optJSONObject16.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.oJ().putString("ala_personal_income_detail_url", this.Yc);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject17 != null) {
                this.Yv = optJSONObject17.optInt("android_show");
                com.baidu.live.c.oJ().putInt("ala_custom_gift_category_id", this.Yv);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject18 != null) {
                int optInt = optJSONObject18.optInt("open", 0);
                this.Yd = optInt == 1;
                com.baidu.live.c.oJ().putInt("ala_live_pk_switch", optInt);
                this.Ye = optJSONObject18.optLong("interval");
                if (this.Ye < 1000) {
                    this.Ye = 1000L;
                }
                com.baidu.live.c.oJ().putLong("ala_live_pk_check_interval", this.Ye);
                this.Yf = optJSONObject18.optLong("match_timeout");
                if (this.Yf < 60000) {
                    this.Yf = 60000L;
                }
                com.baidu.live.c.oJ().putLong("ala_live_pk_match_timeout", this.Yf);
                this.Yg = optJSONObject18.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.oJ().putString("ala_live_pk_pic_url", this.Yg);
                this.Yh = optJSONObject18.optString("rank_link");
                com.baidu.live.c.oJ().putString("ala_live_pk_pic_jump_url", this.Yh);
                this.Yi = optJSONObject18.optString("history_link");
                com.baidu.live.c.oJ().putString("ala_live_pk_history_link", this.Yi);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject19 != null) {
                this.Yk = optJSONObject19.optLong("random_interval");
                if (this.Yk < 1000) {
                    this.Yk = 1000L;
                }
                com.baidu.live.c.oJ().putLong("ala_challenge_random_interval", this.Yk);
                this.Yl = optJSONObject19.optLong("direct_interval");
                if (this.Yl < 1000) {
                    this.Yl = 1000L;
                }
                com.baidu.live.c.oJ().putLong("ala_challenge_direct_interval", this.Yl);
                this.Ym = optJSONObject19.optLong("challenge_info_interval");
                if (this.Ym < 1000) {
                    this.Ym = 1000L;
                }
                com.baidu.live.c.oJ().putLong("ala_get_challenge_info_interval", this.Ym);
                this.Yo = optJSONObject19.optString("pk_icon_url");
                com.baidu.live.c.oJ().putString("ala_challenge_pk_entry_icon_url", this.Yo);
                this.Yp = optJSONObject19.optString("icon_url");
                com.baidu.live.c.oJ().putString("ala_challenge_pk_entry_icon_url", this.Yp);
                this.Yn = optJSONObject19.optString("rule_url");
                com.baidu.live.c.oJ().putString("ala_challenge_pk_entry_icon_url", this.Yn);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject20 != null) {
                this.Yj = optJSONObject20.optString("go_url");
                com.baidu.live.c.oJ().putString("show_live_forum_url", this.Yj);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject21 != null) {
                this.Yw = optJSONObject21.optInt("use_https", 0) == 1;
                com.baidu.live.c.oJ().putBoolean("ala_guess_use_https", this.Yw);
            }
            String optString3 = jSONObject.optString("live_bar");
            cP(optString3);
            com.baidu.live.c.oJ().putString("ala_live_bar_map_str", optString3);
            this.Yx = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.oJ().putBoolean("is_new_live_close_strategy", this.Yx);
            this.Yy = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.oJ().putBoolean("is_new_gift_t_dou_strategy", this.Yy);
            this.Yz = jSONObject.optString("feedback_url");
            com.baidu.live.c.oJ().putString("ala_feedback_url", this.Yz);
            JSONObject optJSONObject22 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject22 != null && (optJSONObject = optJSONObject22.optJSONObject("challenge_related_zip")) != null) {
                this.Yt = optJSONObject.optString("zip_md5");
                this.Yu = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject23 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject23.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject23.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.oJ().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.oJ().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("open_live");
            if (optJSONObject24 != null) {
                this.increaseThreshold = optJSONObject24.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.oJ().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject24.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.oJ().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject24.optInt("thi_count", 3);
                com.baidu.live.c.oJ().putInt("ala_video_increase_count", this.increaseCount);
                this.Xw = optJSONObject24.optInt("encoder", 1) == 1;
                com.baidu.live.c.oJ().putBoolean("ala_live_hard_encode_switch", this.Xw);
                this.Xx = optJSONObject24.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.oJ().putBoolean("ala_dynamic_bitrate_switch", this.Xx);
                this.Xv = optJSONObject24.optInt("resolution", 3);
                com.baidu.live.c.oJ().putInt("ala_video_resolution_level", this.Xv);
                JSONArray optJSONArray8 = optJSONObject24.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.Xy = optJSONArray8.toString();
                    com.baidu.live.c.oJ().putString("ala_video_soft_bitrate_config", this.Xy);
                }
                JSONArray optJSONArray9 = optJSONObject24.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.Xz = optJSONArray9.toString();
                    com.baidu.live.c.oJ().putString("ala_video_hard_bitrate_config", this.Xz);
                }
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject25 != null) {
                this.Zc = new AlaFeedDiversionData();
                this.Zc.parserJson(optJSONObject25);
                com.baidu.live.c.oJ().putString("feed_diversion", optJSONObject25.toString());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.YS = jSONObject.optInt("im_max", 200);
            if (this.YS <= 0) {
                this.YS = 200;
            }
            this.YT = jSONObject.optInt("barrage_max", 100);
            if (this.YT <= 0) {
                this.YT = 100;
            }
            this.YU = jSONObject.optInt("pay_barrage_max", 10);
            if (this.YU <= 0) {
                this.YU = 10;
            }
            this.YV = jSONObject.optInt("enter_effect_max", 10);
            if (this.YV <= 0) {
                this.YV = 10;
            }
            this.YW = jSONObject.optInt("gift_big_max", 10);
            if (this.YW <= 0) {
                this.YW = 10;
            }
            this.YX = jSONObject.optInt("gift_small_max", 50);
            if (this.YX <= 0) {
                this.YX = 50;
            }
            this.YY = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.YY <= 0) {
                this.YY = 5;
            }
        }
    }

    private void pJ() {
        this.YE = com.baidu.live.c.oJ().getInt("guide_speak_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        this.YF = com.baidu.live.c.oJ().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.oJ().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.YG = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.YG[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void m(JSONObject jSONObject) {
        int length;
        this.YE = jSONObject.optInt("rule_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL) * 1000;
        com.baidu.live.c.oJ().putInt("guide_speak_watch_time", this.YE);
        this.YF = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.oJ().putInt("guide_speak_show_times_max", this.YF);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.YG = new String[length];
            for (int i = 0; i < length; i++) {
                this.YG[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.oJ().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void n(JSONObject jSONObject) {
        this.YM = jSONObject.optInt("supernatant_time") * 1000;
        this.YN = jSONObject.optInt("suoernatant_shownum");
        this.YO = jSONObject.optInt("pop_window_time") * 1000;
    }

    private void pK() {
        String string = com.baidu.live.c.oJ().getString("yuan_package_data", "");
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
            this.YL = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.YL.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void cO(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.YP = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.YP.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.YQ = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.YQ.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.oJ().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void pL() {
        cO(com.baidu.live.c.oJ().getString("ala_quick_send_im_list", null));
    }

    private void cP(String str) {
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
        if (i != this.XW) {
            z2 = true;
        }
        this.XW = i;
        if (z || z2) {
            com.baidu.live.c.oJ().putInt("ala_live_session_default_key", i);
        }
    }

    private void pM() {
        this.XW = com.baidu.live.c.oJ().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.oJ().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.XX.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.oJ().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.Ya = jSONObject.optString("hlsUrl");
                this.XY = jSONObject.optString("rtmpUrl");
                this.XZ = jSONObject.optString("flvUrl");
                this.Yb = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean pN() {
        return this.XP == 1;
    }
}
