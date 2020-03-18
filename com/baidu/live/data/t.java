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
/* loaded from: classes3.dex */
public class t extends BaseData {
    public boolean YL;
    public boolean YM;
    public boolean YN;
    public boolean YO;
    public boolean YP;
    public String YQ;
    public String YR;
    public String YV;
    public String YW;
    public Integer[] YZ;
    public int ZA;
    public boolean ZB;
    public boolean ZC;
    public boolean ZD;
    public boolean ZE;
    public String ZI;
    public String ZK;
    public String ZL;
    public int ZR;
    public String ZT;
    public String ZU;
    private String ZV;
    private String ZW;
    public int ZX;
    public String ZZ;
    public Integer[] Za;
    public int Zb;
    public int Zd;
    public int Ze;
    public int Zf;
    public String Zg;
    public int Zh;
    public boolean Zi;
    public boolean Zj;
    public boolean Zk;
    public boolean Zl;
    public boolean Zn;
    public String Zo;
    public int Zp;
    public boolean Zq;
    public int Zr;
    public boolean Zs;
    public boolean Zt;
    public String Zu;
    public String Zv;
    public String Zw;
    public String Zx;
    public String Zy;
    public int Zz;
    public String aaB;
    public int aaG;
    public int aaH;
    public String[] aaI;
    public int aaJ;
    public String aaK;
    public String aaL;
    public QuickImInputData aaM;
    public List<YuanPackageData> aaN;
    public int aaO;
    public int aaP;
    public int aaQ;
    public List<String> aaR;
    public List<String> aaS;
    public List<String> aaT;
    public String aaa;
    public String aab;
    public String aac;
    public String aae;
    public boolean aaf;
    public long aag;
    public long aah;
    public String aai;
    public String aaj;
    public String aak;
    public String aal;
    public long aam;
    public long aan;
    public long aao;
    public String aap;
    public String aaq;
    public String aar;
    public String aat;
    public String aau;
    public String aav;
    public String aaw;
    public int aax;
    public aa abb;
    public boolean abd;
    public String abe;
    public AlaFeedDiversionData abf;
    public boolean abg;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int YJ = -1;
    public String YK = null;
    public int Zm = 1;
    public boolean ZF = true;
    public boolean ZG = false;
    public boolean ZH = false;
    public boolean ZJ = false;
    public String ZM = "";
    private int ZN = 2;
    public String ZO = "";
    public int ZP = 1;
    public int ZQ = 0;
    public int ZS = 1;
    public List<String> ZY = new ArrayList();
    public boolean aas = false;
    public boolean aay = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aaz = false;
    public boolean aaA = false;
    public boolean aaC = false;
    public boolean aaD = false;
    public boolean aaE = false;
    public boolean aaF = false;
    public int aaU = 200;
    public int aaV = 100;
    public int aaW = 10;
    public int aaX = 10;
    public int aaY = 10;
    public int aaZ = 50;
    public int aba = 5;
    public List<String> YU = new ArrayList();
    public List<String> Zc = new ArrayList();
    public List<String> YX = new ArrayList();
    public List<Integer> YY = new ArrayList();
    public ArrayList<f> YS = new ArrayList<>();
    public ArrayList<f> YT = new ArrayList<>();

    public t(boolean z) {
        if (z) {
            qx();
            this.Zb = com.baidu.live.c.pw().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.pw().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.pw().getInt("restart_time_interval", 300);
            qy();
            qw();
            qz();
            qA();
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
                    this.Zb = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.pw().putInt("conn_conf", this.Zb);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.Zc.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.c.pw().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.c.pw().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    k(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    l(optJSONObject5);
                }
                this.ZK = jSONObject.optString("client_id");
                com.baidu.live.c.pw().putString("client_id", this.ZK);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.YQ = optJSONObject6.optString("pic_url");
                    this.YR = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            f fVar = new f();
                            fVar.parseJson(optJSONObject8);
                            this.YS.add(fVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.pw().putString("pic_url", this.YQ);
                com.baidu.live.c.pw().putString(BigdayActivityConfig.JUMP_URL, this.YR);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    m(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aaJ = optJSONObject10.optInt("resource_switch");
                    this.aaL = optJSONObject10.optString("photo_url");
                    this.aaK = optJSONObject10.optString("resource_url");
                }
                this.aaM = new QuickImInputData();
                this.aaM.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                JSONObject optJSONObject11 = jSONObject.optJSONObject("guide_follow");
                if (optJSONObject11 != null) {
                    n(optJSONObject11);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.pw().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject12 != null) {
                    JSONObject optJSONObject13 = optJSONObject12.optJSONObject("rank");
                    if (optJSONObject13 != null && (optJSONObject = optJSONObject13.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.c.pw().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.c.pw().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.c.pw().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject14 = optJSONObject12.optJSONObject("guard_seat");
                    if (optJSONObject14 != null) {
                        this.abe = optJSONObject14.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject15 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject15 != null) {
                    this.abb = new aa();
                    this.abb.abG = optJSONObject15.optString("certify_refuse_url");
                    com.baidu.live.c.pw().putString("ala_certify_refuse_url", this.abb.abG);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.pw().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void qw() {
        String string = com.baidu.live.c.pw().getString("ala_prepare_random_title_list", "");
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
            this.aaT = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aaT.add(jSONArray.optString(i));
            }
        }
    }

    private void qx() {
        this.YL = com.baidu.live.c.pw().getBoolean("map_around_map", false);
        this.Zq = com.baidu.live.c.pw().getBoolean("withdraw_switch", true);
        this.ZI = com.baidu.live.c.pw().getString("withdraw_text", "");
        this.ZB = com.baidu.live.c.pw().getBoolean("use_internal_player_switch", true);
        this.ZC = com.baidu.live.c.pw().getBoolean("live_beauty_open_switch", false);
        this.ZD = com.baidu.live.c.pw().getBoolean("live_unity_beauty_switch", true);
        this.ZE = com.baidu.live.c.pw().getBoolean("live_unity_beauty_face_style_switch", true);
        this.ZF = com.baidu.live.c.pw().getBoolean("sp_key_live_game_hard_encode", true);
        this.ZG = com.baidu.live.c.pw().getBoolean("sp_key_live_play_transcode_support", false);
        this.ZH = com.baidu.live.c.pw().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.ZJ = com.baidu.live.c.pw().getBoolean("ala_enable_graffiti_str", false);
        this.YM = com.baidu.live.c.pw().getBoolean("enter_live", false);
        this.YN = com.baidu.live.c.pw().getBoolean("sync_to_forum", true);
        this.YO = com.baidu.live.c.pw().getBoolean("show_water_mark", false);
        this.YP = com.baidu.live.c.pw().getBoolean("show_third_part_water_mark_switch", false);
        this.Zi = com.baidu.live.c.pw().getBoolean("stream_error_log", true);
        this.Zj = com.baidu.live.c.pw().getBoolean("disable_channel_in", true);
        this.Zk = com.baidu.live.c.pw().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.Zl = com.baidu.live.c.pw().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.Zn = com.baidu.live.c.pw().getBoolean("follow_default_push_switch", true);
        this.ZR = com.baidu.live.c.pw().getInt("to_tb_some_switch", 0);
        this.ZP = com.baidu.live.c.pw().getInt("enable_live_stat", 1);
        this.ZQ = com.baidu.live.c.pw().getInt("ala_free_gift_task_switch", 0);
        this.aas = com.baidu.live.c.pw().getBoolean("live_challenge_switch", false);
        this.aat = com.baidu.live.c.pw().getString("live_challenge_tip", null);
        this.aau = com.baidu.live.c.pw().getString("live_challenge_url", null);
    }

    private void j(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.YL = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.pw().putBoolean("map_around_map", this.YL);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.Zq = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("withdraw_switch", this.Zq);
                this.ZI = optJSONObject2.optString("text");
                com.baidu.live.c.pw().putString("withdraw_text", this.ZI);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.ZB = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("use_internal_player_switch", this.ZB);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject4 != null) {
                this.ZC = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("live_beauty_open_switch", this.ZC);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject5 != null) {
                this.ZD = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("live_unity_beauty_switch", this.ZD);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject6 != null) {
                this.ZE = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("live_unity_beauty_face_style_switch", this.ZE);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject7 != null) {
                this.ZF = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("sp_key_live_game_hard_encode", this.ZF);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject8 != null) {
                this.ZG = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("sp_key_live_play_transcode_support", this.ZG);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject9 != null) {
                this.ZH = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("sp_key_live_play_attention_guide_support", this.ZH);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject10 != null) {
                this.YM = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("enter_live", this.YM);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject11 != null) {
                this.YN = optJSONObject11.optString("switch").equals("1");
                com.baidu.live.c.pw().putBoolean("sync_to_forum", this.YN);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject12 != null) {
                this.YO = optJSONObject12.optString("switch").equals("1");
                com.baidu.live.c.pw().putBoolean("show_water_mark", this.YO);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject13 != null) {
                this.YP = optJSONObject13.optString("switch").equals("1");
                com.baidu.live.c.pw().putBoolean("show_third_part_water_mark_switch", this.YP);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject14 != null) {
                this.ZP = optJSONObject14.optInt("switch");
                com.baidu.live.c.pw().putInt("enable_live_stat", this.ZP);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject15 != null) {
                this.Zi = optJSONObject15.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("stream_error_log", this.Zi);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject16 != null) {
                this.Zj = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.pw().putBoolean("disable_channel_in", this.Zj);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject17 != null) {
                this.Zk = optJSONObject17.optString("switch").equals("1");
                com.baidu.live.c.pw().putBoolean("shoubai_yanzhi_tab_tip", this.Zk);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject18 != null) {
                this.Zl = optJSONObject18.optString("switch").equals("1");
                com.baidu.live.c.pw().putBoolean(ActionJsonData.TAG_SIGN_IN, this.Zl);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject19 != null) {
                this.Zn = optJSONObject19.optString("switch").equals("2");
                com.baidu.live.c.pw().putBoolean("follow_default_push_switch", this.Zn);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject20 != null) {
                this.ZR = optJSONObject20.optInt("switch");
                com.baidu.live.c.pw().putInt("to_tb_some_switch", this.ZR);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("task_config");
            if (optJSONObject21 != null) {
                this.ZQ = optJSONObject21.optInt("switch");
                com.baidu.live.c.pw().putInt("ala_free_gift_task_switch", this.ZR);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject22 != null) {
                this.ZJ = optJSONObject22.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("ala_enable_graffiti_str", this.ZJ);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject23 != null) {
                this.aas = optJSONObject23.optInt("switch") == 1;
                this.aat = optJSONObject23.optString("title");
                this.aau = optJSONObject23.optString("url");
                com.baidu.live.c.pw().putBoolean("live_challenge_switch", this.aas);
                com.baidu.live.c.pw().putString("live_challenge_tip", this.aat);
                com.baidu.live.c.pw().putString("live_challenge_url", this.aau);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject24 != null) {
                this.aaA = optJSONObject24.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("is_new_gift_t_dou_strategy", this.aaA);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject25 != null) {
                this.aaE = optJSONObject25.optInt("switch") == 1;
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject26 != null) {
                this.aaC = optJSONObject26.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("key_is_open_login_prove", this.aaC);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject27 != null) {
                this.aaD = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("key_is_open_diamond", this.aaD);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject28 != null) {
                this.aaF = optJSONObject28.optInt("switch") == 1;
                com.baidu.live.c.pw().putBoolean("key_is_jump_to_live_room", this.aaF);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject29 != null && (optInt2 = optJSONObject29.optInt("switch", -1)) >= 0) {
                this.abd = optInt2 == 1;
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject30 != null && (optInt = optJSONObject30.optInt("switch", -1)) >= 0) {
                this.abg = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void qy() {
        JSONArray jSONArray;
        this.Zg = com.baidu.live.c.pw().getString("bluediamond_url", "");
        this.YW = com.baidu.live.c.pw().getString("verify_content", this.YW);
        this.YV = com.baidu.live.c.pw().getString("live_notice", "");
        String string = com.baidu.live.c.pw().getString("imNotice", "");
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
                        this.YU.add(i, optString);
                    }
                }
            }
        }
        this.ZL = com.baidu.live.c.pw().getString("share_host", "");
        this.ZM = com.baidu.live.c.pw().getString("ala_share_in_bar_notice_text", "");
        this.ZO = com.baidu.live.c.pw().getString("ala_share_reward_rank_notice_text", "");
        this.ZN = com.baidu.live.c.pw().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.Zh = com.baidu.live.c.pw().getInt("recommend_refresh", 60);
        this.Zo = com.baidu.live.c.pw().getString("strategy_conf", "300");
        this.Zp = com.baidu.live.c.pw().getInt("strategy_exception_interval", 1);
        this.Zm = com.baidu.live.c.pw().getInt("liveStartAuthLevel", 1);
        this.Zd = com.baidu.live.c.pw().getInt("2gTo", 5);
        this.Ze = com.baidu.live.c.pw().getInt("3gTo", 3);
        this.Zf = com.baidu.live.c.pw().getInt("wifiTo", 3);
        String string2 = com.baidu.live.c.pw().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.YZ = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.c.pw().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.Za = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.ZS = com.baidu.live.c.pw().getInt("square_tab_strategy", 1);
        this.ZT = com.baidu.live.c.pw().getString("ala_live_ranklist_url", null);
        this.ZU = com.baidu.live.c.pw().getString("new_flower_rank_list_description_url", "");
        this.ZV = com.baidu.live.c.pw().getString("ala_game_player_signup_url", null);
        this.ZW = com.baidu.live.c.pw().getString("ala_game_frs_live_tab_video_url", null);
        qC();
        this.aae = com.baidu.live.c.pw().getString("ala_personal_income_detail_url", null);
        this.aax = com.baidu.live.c.pw().getInt("ala_custom_gift_category_id", -1);
        this.aaf = com.baidu.live.c.pw().getInt("ala_live_pk_switch", 0) == 1;
        this.aag = com.baidu.live.c.pw().getLong("ala_live_pk_check_interval", 1000L);
        this.aah = com.baidu.live.c.pw().getLong("ala_live_pk_match_timeout", 60000L);
        this.aai = com.baidu.live.c.pw().getString("ala_live_pk_pic_url", "");
        this.aaj = com.baidu.live.c.pw().getString("ala_live_pk_pic_jump_url", "");
        this.aak = com.baidu.live.c.pw().getString("ala_live_pk_history_link", "");
        this.aal = com.baidu.live.c.pw().getString("show_live_forum_url", "");
        this.aam = com.baidu.live.c.pw().getLong("ala_challenge_random_interval", 1000L);
        this.aan = com.baidu.live.c.pw().getLong("ala_challenge_direct_interval", 1000L);
        this.aao = com.baidu.live.c.pw().getLong("ala_get_challenge_info_interval", 1000L);
        this.aaq = com.baidu.live.c.pw().getString("ala_challenge_pk_entry_icon_url", "");
        this.aar = com.baidu.live.c.pw().getString("ala_challenge_pk_entry_icon_url", "");
        this.aap = com.baidu.live.c.pw().getString("ala_challenge_pk_entry_icon_url", "");
        this.aay = com.baidu.live.c.pw().getBoolean("ala_guess_use_https", false);
        cX(com.baidu.live.c.pw().getString("ala_live_bar_map_str", ""));
        this.aaz = com.baidu.live.c.pw().getBoolean("is_new_live_close_strategy", false);
        this.aaA = com.baidu.live.c.pw().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aaB = com.baidu.live.c.pw().getString("ala_feedback_url", null);
        this.Zr = com.baidu.live.c.pw().getInt("ala_video_resolution_level", 3);
        this.Zs = com.baidu.live.c.pw().getBoolean("ala_live_hard_encode_switch", true);
        this.Zt = com.baidu.live.c.pw().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.pw().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.pw().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.pw().getInt("ala_video_increase_count", 3);
        this.Zu = com.baidu.live.c.pw().getString("ala_video_soft_bitrate_config", null);
        this.Zv = com.baidu.live.c.pw().getString("ala_video_hard_bitrate_config", null);
        this.Zz = com.baidu.live.c.pw().getInt("ala_master_chat_video_resolution_level", 3);
        this.ZA = com.baidu.live.c.pw().getInt("ala_slave_chat_video_resolution_level", 4);
        this.Zw = com.baidu.live.c.pw().getString("ala_avts_stream_server_domain_config", null);
        this.Zx = com.baidu.live.c.pw().getString("ala_master_chat_video_bitrate_config", null);
        this.Zy = com.baidu.live.c.pw().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.pw().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.pw().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aaC = com.baidu.live.c.pw().getBoolean("key_is_open_login_prove", false);
        this.aaD = com.baidu.live.c.pw().getBoolean("key_is_open_diamond", false);
        this.aaF = com.baidu.live.c.pw().getBoolean("key_is_jump_to_live_room", false);
        cV(com.baidu.live.c.pw().getString("feed_diversion", ""));
        qB();
    }

    private void cV(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.abf = new AlaFeedDiversionData();
                this.abf.parserJson(jSONObject);
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
                this.YK = optJSONObject2.optString("toast");
                this.YJ = optJSONObject2.optInt("remind_type");
            }
            this.Zg = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.pw().putString("bluediamond_url", this.Zg);
            this.YW = jSONObject.optString("verify_content");
            com.baidu.live.c.pw().putString("verify_content", this.YW);
            this.YV = jSONObject.optString("live_notice");
            com.baidu.live.c.pw().putString("live_notice", this.YV);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.YU.add(i, optString);
                    }
                }
                com.baidu.live.c.pw().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.c.pw().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.YX.add(i2, optString2);
                    }
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("bd_live_activity");
            if (optJSONObject3 != null && (optJSONArray = optJSONObject3.optJSONArray("main_page")) != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject4 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject4 != null) {
                        f fVar = new f();
                        fVar.parseJson(optJSONObject4);
                        this.YT.add(fVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.YY.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.ZL = optJSONObject5.optString("url");
            } else {
                this.ZL = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.ZM = optJSONObject6.optString("reward_notice");
                this.ZO = optJSONObject6.optString("reward_rank_notice");
                this.ZN = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.ZM = "";
                this.ZO = "";
                this.ZN = 2;
            }
            com.baidu.live.c.pw().putString("share_host", this.ZL);
            com.baidu.live.c.pw().putString("ala_share_in_bar_notice_text", this.ZM);
            com.baidu.live.c.pw().putString("ala_share_reward_rank_notice_text", this.ZO);
            com.baidu.live.c.pw().putInt("ala_share_in_bar_notice_tip_switch", this.ZN);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.Zh = optJSONObject7.optInt("value");
            } else {
                this.Zh = 60;
            }
            com.baidu.live.c.pw().putInt("recommend_refresh", this.Zh);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.pw().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.YZ = g(optJSONArray5);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject9 != null) {
                JSONArray optJSONArray6 = optJSONObject9.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.pw().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.Za = g(optJSONArray6);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject10 != null) {
                this.Zo = optJSONObject10.optString("time_interval");
                this.Zp = optJSONObject10.optInt("exception_interval");
            } else {
                this.Zo = "300";
                this.Zp = 1;
            }
            com.baidu.live.c.pw().putString("strategy_conf", this.Zo);
            com.baidu.live.c.pw().putInt("strategy_exception_interval", this.Zp);
            this.Zm = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.pw().putInt("liveStartAuthLevel", this.Zm);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject11 != null) {
                this.Zd = optJSONObject11.optInt("2gTo");
                if (this.Zd < 3) {
                    this.Zd = 3;
                }
                this.Ze = optJSONObject11.optInt("3gTo");
                if (this.Ze < 3) {
                    this.Ze = 3;
                }
                this.Zf = optJSONObject11.optInt("wifiTo");
                if (this.Zf < 3) {
                    this.Zf = 3;
                }
                com.baidu.live.c.pw().putInt("2gTo", this.Zd);
                com.baidu.live.c.pw().putInt("3gTo", this.Ze);
                com.baidu.live.c.pw().putInt("wifiTo", this.Zf);
            }
            this.ZS = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.pw().putInt("square_tab_strategy", this.ZS);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject12 != null) {
                this.ZT = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
                this.ZU = optJSONObject12.optString("flower_rank_rule");
            }
            com.baidu.live.c.pw().putString("ala_live_ranklist_url", this.ZT);
            com.baidu.live.c.pw().putString("new_flower_rank_list_description_url", this.ZU);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject13 != null) {
                this.ZV = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.pw().putString("ala_game_player_signup_url", this.ZV);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject14 != null) {
                this.ZW = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.pw().putString("ala_game_frs_live_tab_video_url", this.ZW);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject15 != null) {
                this.ZX = optJSONObject15.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.pw().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.ZY.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject16 != null) {
                com.baidu.live.c.pw().putString("ala_live_session_replace_key", optJSONObject16.toString());
                this.aab = optJSONObject16.optString("hlsUrl");
                this.ZZ = optJSONObject16.optString("rtmpUrl");
                this.aaa = optJSONObject16.optString("flvUrl");
                this.aac = optJSONObject16.optString(".m3u8");
            }
            b(true, this.ZX);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject17 != null) {
                this.aae = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.pw().putString("ala_personal_income_detail_url", this.aae);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject18 != null) {
                this.aax = optJSONObject18.optInt("android_show");
                com.baidu.live.c.pw().putInt("ala_custom_gift_category_id", this.aax);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject19 != null) {
                int optInt = optJSONObject19.optInt("open", 0);
                this.aaf = optInt == 1;
                com.baidu.live.c.pw().putInt("ala_live_pk_switch", optInt);
                this.aag = optJSONObject19.optLong("interval");
                if (this.aag < 1000) {
                    this.aag = 1000L;
                }
                com.baidu.live.c.pw().putLong("ala_live_pk_check_interval", this.aag);
                this.aah = optJSONObject19.optLong("match_timeout");
                if (this.aah < 60000) {
                    this.aah = 60000L;
                }
                com.baidu.live.c.pw().putLong("ala_live_pk_match_timeout", this.aah);
                this.aai = optJSONObject19.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.pw().putString("ala_live_pk_pic_url", this.aai);
                this.aaj = optJSONObject19.optString("rank_link");
                com.baidu.live.c.pw().putString("ala_live_pk_pic_jump_url", this.aaj);
                this.aak = optJSONObject19.optString("history_link");
                com.baidu.live.c.pw().putString("ala_live_pk_history_link", this.aak);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject20 != null) {
                this.aam = optJSONObject20.optLong("random_interval");
                if (this.aam < 1000) {
                    this.aam = 1000L;
                }
                com.baidu.live.c.pw().putLong("ala_challenge_random_interval", this.aam);
                this.aan = optJSONObject20.optLong("direct_interval");
                if (this.aan < 1000) {
                    this.aan = 1000L;
                }
                com.baidu.live.c.pw().putLong("ala_challenge_direct_interval", this.aan);
                this.aao = optJSONObject20.optLong("challenge_info_interval");
                if (this.aao < 1000) {
                    this.aao = 1000L;
                }
                com.baidu.live.c.pw().putLong("ala_get_challenge_info_interval", this.aao);
                this.aaq = optJSONObject20.optString("pk_icon_url");
                com.baidu.live.c.pw().putString("ala_challenge_pk_entry_icon_url", this.aaq);
                this.aar = optJSONObject20.optString("icon_url");
                com.baidu.live.c.pw().putString("ala_challenge_pk_entry_icon_url", this.aar);
                this.aap = optJSONObject20.optString("rule_url");
                com.baidu.live.c.pw().putString("ala_challenge_pk_entry_icon_url", this.aap);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject21 != null) {
                this.aal = optJSONObject21.optString("go_url");
                com.baidu.live.c.pw().putString("show_live_forum_url", this.aal);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject22 != null) {
                this.aay = optJSONObject22.optInt("use_https", 0) == 1;
                com.baidu.live.c.pw().putBoolean("ala_guess_use_https", this.aay);
            }
            String optString3 = jSONObject.optString("live_bar");
            cX(optString3);
            com.baidu.live.c.pw().putString("ala_live_bar_map_str", optString3);
            this.aaz = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.pw().putBoolean("is_new_live_close_strategy", this.aaz);
            this.aaA = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.pw().putBoolean("is_new_gift_t_dou_strategy", this.aaA);
            this.aaB = jSONObject.optString("feedback_url");
            com.baidu.live.c.pw().putString("ala_feedback_url", this.aaB);
            JSONObject optJSONObject23 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject23 != null && (optJSONObject = optJSONObject23.optJSONObject("challenge_related_zip")) != null) {
                this.aav = optJSONObject.optString("zip_md5");
                this.aaw = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject24 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject24.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject24.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.pw().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.pw().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("open_live");
            if (optJSONObject25 != null) {
                this.increaseThreshold = optJSONObject25.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.pw().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject25.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.pw().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject25.optInt("thi_count", 3);
                com.baidu.live.c.pw().putInt("ala_video_increase_count", this.increaseCount);
                this.Zs = optJSONObject25.optInt("encoder", 1) == 1;
                com.baidu.live.c.pw().putBoolean("ala_live_hard_encode_switch", this.Zs);
                this.Zt = optJSONObject25.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.pw().putBoolean("ala_dynamic_bitrate_switch", this.Zt);
                this.Zr = optJSONObject25.optInt("resolution", 3);
                com.baidu.live.c.pw().putInt("ala_video_resolution_level", this.Zr);
                JSONArray optJSONArray8 = optJSONObject25.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.Zu = optJSONArray8.toString();
                    com.baidu.live.c.pw().putString("ala_video_soft_bitrate_config", this.Zu);
                }
                JSONArray optJSONArray9 = optJSONObject25.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.Zv = optJSONArray9.toString();
                    com.baidu.live.c.pw().putString("ala_video_hard_bitrate_config", this.Zv);
                }
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject26 != null) {
                this.Zw = optJSONObject26.toString();
                com.baidu.live.c.pw().putString("ala_avts_stream_server_domain_config", this.Zw);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject27 != null) {
                this.Zz = optJSONObject27.optInt("host_rtc_resolution", 3);
                com.baidu.live.c.pw().putInt("ala_master_chat_video_resolution_level", this.Zz);
                this.ZA = optJSONObject27.optInt("rtc_resolution", 4);
                com.baidu.live.c.pw().putInt("ala_slave_chat_video_resolution_level", this.ZA);
                JSONArray optJSONArray10 = optJSONObject27.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.Zx = optJSONArray10.toString();
                    com.baidu.live.c.pw().putString("ala_master_chat_video_bitrate_config", this.Zx);
                }
                JSONArray optJSONArray11 = optJSONObject27.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.Zy = optJSONArray11.toString();
                    com.baidu.live.c.pw().putString("ala_slave_chat_video_bitrate_config", this.Zy);
                }
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject28 != null) {
                this.abf = new AlaFeedDiversionData();
                this.abf.parserJson(optJSONObject28);
                com.baidu.live.c.pw().putString("feed_diversion", optJSONObject28.toString());
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject29 != null) {
                com.baidu.live.c.pw().putString("key_stat_switch", optJSONObject29.toString());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aaU = jSONObject.optInt("im_max", 200);
            if (this.aaU <= 0) {
                this.aaU = 200;
            }
            this.aaV = jSONObject.optInt("barrage_max", 100);
            if (this.aaV <= 0) {
                this.aaV = 100;
            }
            this.aaW = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aaW <= 0) {
                this.aaW = 10;
            }
            this.aaX = jSONObject.optInt("enter_effect_max", 10);
            if (this.aaX <= 0) {
                this.aaX = 10;
            }
            this.aaY = jSONObject.optInt("gift_big_max", 10);
            if (this.aaY <= 0) {
                this.aaY = 10;
            }
            this.aaZ = jSONObject.optInt("gift_small_max", 50);
            if (this.aaZ <= 0) {
                this.aaZ = 50;
            }
            this.aba = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aba <= 0) {
                this.aba = 5;
            }
        }
    }

    private void qz() {
        this.aaG = com.baidu.live.c.pw().getInt("guide_speak_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        this.aaH = com.baidu.live.c.pw().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.pw().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aaI = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aaI[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void m(JSONObject jSONObject) {
        int length;
        this.aaG = jSONObject.optInt("rule_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL) * 1000;
        com.baidu.live.c.pw().putInt("guide_speak_watch_time", this.aaG);
        this.aaH = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.pw().putInt("guide_speak_show_times_max", this.aaH);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aaI = new String[length];
            for (int i = 0; i < length; i++) {
                this.aaI[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.pw().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void n(JSONObject jSONObject) {
        this.aaO = jSONObject.optInt("supernatant_time") * 1000;
        this.aaP = jSONObject.optInt("suoernatant_shownum");
        this.aaQ = jSONObject.optInt("pop_window_time") * 1000;
    }

    private void qA() {
        String string = com.baidu.live.c.pw().getString("yuan_package_data", "");
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
            this.aaN = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aaN.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void cW(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aaR = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aaR.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aaS = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aaS.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.pw().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void qB() {
        cW(com.baidu.live.c.pw().getString("ala_quick_send_im_list", null));
    }

    private void cX(String str) {
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
        if (i != this.ZX) {
            z2 = true;
        }
        this.ZX = i;
        if (z || z2) {
            com.baidu.live.c.pw().putInt("ala_live_session_default_key", i);
        }
    }

    private void qC() {
        this.ZX = com.baidu.live.c.pw().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.pw().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.ZY.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.pw().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aab = jSONObject.optString("hlsUrl");
                this.ZZ = jSONObject.optString("rtmpUrl");
                this.aaa = jSONObject.optString("flvUrl");
                this.aac = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean qD() {
        return this.ZQ == 1;
    }
}
