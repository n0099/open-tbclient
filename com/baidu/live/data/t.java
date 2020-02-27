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
    public boolean YB;
    public boolean YC;
    public boolean YD;
    public boolean YE;
    public boolean YF;
    public String YG;
    public String YH;
    public String YL;
    public String YM;
    public Integer[] YP;
    public Integer[] YQ;
    public int YR;
    public int YT;
    public int YU;
    public int YV;
    public String YW;
    public int YX;
    public boolean YY;
    public boolean YZ;
    public String ZA;
    public String ZB;
    public int ZH;
    public String ZJ;
    public String ZK;
    private String ZL;
    private String ZM;
    public int ZN;
    public String ZP;
    public String ZQ;
    public String ZR;
    public String ZS;
    public String ZT;
    public boolean ZU;
    public long ZV;
    public long ZW;
    public String ZX;
    public String ZY;
    public String ZZ;
    public boolean Za;
    public boolean Zb;
    public boolean Zd;
    public String Ze;
    public int Zf;
    public boolean Zg;
    public int Zh;
    public boolean Zi;
    public boolean Zj;
    public String Zk;
    public String Zl;
    public String Zm;
    public String Zn;
    public String Zo;
    public int Zp;
    public int Zq;
    public boolean Zr;
    public boolean Zs;
    public boolean Zt;
    public boolean Zu;
    public String Zy;
    public String aaA;
    public String aaB;
    public QuickImInputData aaC;
    public List<YuanPackageData> aaD;
    public int aaE;
    public int aaF;
    public int aaG;
    public List<String> aaH;
    public List<String> aaI;
    public List<String> aaJ;
    public aa aaR;
    public boolean aaS;
    public String aaT;
    public AlaFeedDiversionData aaU;
    public boolean aaV;
    public String aaa;
    public long aab;
    public long aac;
    public long aae;
    public String aaf;
    public String aag;
    public String aah;
    public String aaj;
    public String aak;
    public String aal;
    public String aam;
    public int aan;
    public String aar;
    public int aaw;
    public int aax;
    public String[] aay;
    public int aaz;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int Yz = -1;
    public String YA = null;
    public int Zc = 1;
    public boolean Zv = true;
    public boolean Zw = false;
    public boolean Zx = false;
    public boolean Zz = false;
    public String ZC = "";
    private int ZD = 2;
    public String ZE = "";
    public int ZF = 1;
    public int ZG = 0;
    public int ZI = 1;
    public List<String> ZO = new ArrayList();
    public boolean aai = false;
    public boolean aao = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aap = false;
    public boolean aaq = false;
    public boolean aas = false;
    public boolean aat = false;
    public boolean aau = false;
    public boolean aav = false;
    public int aaK = 200;
    public int aaL = 100;
    public int aaM = 10;
    public int aaN = 10;
    public int aaO = 10;
    public int aaP = 50;
    public int aaQ = 5;
    public List<String> YK = new ArrayList();
    public List<String> YS = new ArrayList();
    public List<String> YN = new ArrayList();
    public List<Integer> YO = new ArrayList();
    public ArrayList<f> YI = new ArrayList<>();
    public ArrayList<f> YJ = new ArrayList<>();

    public t(boolean z) {
        if (z) {
            qs();
            this.YR = com.baidu.live.c.pr().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.pr().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.pr().getInt("restart_time_interval", 300);
            qt();
            qr();
            qu();
            qv();
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
                    this.YR = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.pr().putInt("conn_conf", this.YR);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.YS.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.c.pr().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.c.pr().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    k(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    l(optJSONObject5);
                }
                this.ZA = jSONObject.optString("client_id");
                com.baidu.live.c.pr().putString("client_id", this.ZA);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.YG = optJSONObject6.optString("pic_url");
                    this.YH = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            f fVar = new f();
                            fVar.parseJson(optJSONObject8);
                            this.YI.add(fVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.pr().putString("pic_url", this.YG);
                com.baidu.live.c.pr().putString(BigdayActivityConfig.JUMP_URL, this.YH);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    m(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aaz = optJSONObject10.optInt("resource_switch");
                    this.aaB = optJSONObject10.optString("photo_url");
                    this.aaA = optJSONObject10.optString("resource_url");
                }
                this.aaC = new QuickImInputData();
                this.aaC.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                JSONObject optJSONObject11 = jSONObject.optJSONObject("guide_follow");
                if (optJSONObject11 != null) {
                    n(optJSONObject11);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.pr().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject12 != null) {
                    JSONObject optJSONObject13 = optJSONObject12.optJSONObject("rank");
                    if (optJSONObject13 != null && (optJSONObject = optJSONObject13.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.c.pr().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.c.pr().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.c.pr().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject14 = optJSONObject12.optJSONObject("guard_seat");
                    if (optJSONObject14 != null) {
                        this.aaT = optJSONObject14.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject15 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject15 != null) {
                    this.aaR = new aa();
                    this.aaR.abw = optJSONObject15.optString("certify_refuse_url");
                    com.baidu.live.c.pr().putString("ala_certify_refuse_url", this.aaR.abw);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.pr().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void qr() {
        String string = com.baidu.live.c.pr().getString("ala_prepare_random_title_list", "");
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
            this.aaJ = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aaJ.add(jSONArray.optString(i));
            }
        }
    }

    private void qs() {
        this.YB = com.baidu.live.c.pr().getBoolean("map_around_map", false);
        this.Zg = com.baidu.live.c.pr().getBoolean("withdraw_switch", true);
        this.Zy = com.baidu.live.c.pr().getString("withdraw_text", "");
        this.Zr = com.baidu.live.c.pr().getBoolean("use_internal_player_switch", true);
        this.Zs = com.baidu.live.c.pr().getBoolean("live_beauty_open_switch", false);
        this.Zt = com.baidu.live.c.pr().getBoolean("live_unity_beauty_switch", true);
        this.Zu = com.baidu.live.c.pr().getBoolean("live_unity_beauty_face_style_switch", true);
        this.Zv = com.baidu.live.c.pr().getBoolean("sp_key_live_game_hard_encode", true);
        this.Zw = com.baidu.live.c.pr().getBoolean("sp_key_live_play_transcode_support", false);
        this.Zx = com.baidu.live.c.pr().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.Zz = com.baidu.live.c.pr().getBoolean("ala_enable_graffiti_str", false);
        this.YC = com.baidu.live.c.pr().getBoolean("enter_live", false);
        this.YD = com.baidu.live.c.pr().getBoolean("sync_to_forum", true);
        this.YE = com.baidu.live.c.pr().getBoolean("show_water_mark", false);
        this.YF = com.baidu.live.c.pr().getBoolean("show_third_part_water_mark_switch", false);
        this.YY = com.baidu.live.c.pr().getBoolean("stream_error_log", true);
        this.YZ = com.baidu.live.c.pr().getBoolean("disable_channel_in", true);
        this.Za = com.baidu.live.c.pr().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.Zb = com.baidu.live.c.pr().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.Zd = com.baidu.live.c.pr().getBoolean("follow_default_push_switch", true);
        this.ZH = com.baidu.live.c.pr().getInt("to_tb_some_switch", 0);
        this.ZF = com.baidu.live.c.pr().getInt("enable_live_stat", 1);
        this.ZG = com.baidu.live.c.pr().getInt("ala_free_gift_task_switch", 0);
        this.aai = com.baidu.live.c.pr().getBoolean("live_challenge_switch", false);
        this.aaj = com.baidu.live.c.pr().getString("live_challenge_tip", null);
        this.aak = com.baidu.live.c.pr().getString("live_challenge_url", null);
    }

    private void j(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.YB = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.pr().putBoolean("map_around_map", this.YB);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.Zg = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("withdraw_switch", this.Zg);
                this.Zy = optJSONObject2.optString("text");
                com.baidu.live.c.pr().putString("withdraw_text", this.Zy);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.Zr = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("use_internal_player_switch", this.Zr);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject4 != null) {
                this.Zs = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("live_beauty_open_switch", this.Zs);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject5 != null) {
                this.Zt = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("live_unity_beauty_switch", this.Zt);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject6 != null) {
                this.Zu = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("live_unity_beauty_face_style_switch", this.Zu);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject7 != null) {
                this.Zv = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("sp_key_live_game_hard_encode", this.Zv);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject8 != null) {
                this.Zw = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("sp_key_live_play_transcode_support", this.Zw);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject9 != null) {
                this.Zx = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("sp_key_live_play_attention_guide_support", this.Zx);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject10 != null) {
                this.YC = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("enter_live", this.YC);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject11 != null) {
                this.YD = optJSONObject11.optString("switch").equals("1");
                com.baidu.live.c.pr().putBoolean("sync_to_forum", this.YD);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject12 != null) {
                this.YE = optJSONObject12.optString("switch").equals("1");
                com.baidu.live.c.pr().putBoolean("show_water_mark", this.YE);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject13 != null) {
                this.YF = optJSONObject13.optString("switch").equals("1");
                com.baidu.live.c.pr().putBoolean("show_third_part_water_mark_switch", this.YF);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject14 != null) {
                this.ZF = optJSONObject14.optInt("switch");
                com.baidu.live.c.pr().putInt("enable_live_stat", this.ZF);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject15 != null) {
                this.YY = optJSONObject15.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("stream_error_log", this.YY);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject16 != null) {
                this.YZ = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.pr().putBoolean("disable_channel_in", this.YZ);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject17 != null) {
                this.Za = optJSONObject17.optString("switch").equals("1");
                com.baidu.live.c.pr().putBoolean("shoubai_yanzhi_tab_tip", this.Za);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject18 != null) {
                this.Zb = optJSONObject18.optString("switch").equals("1");
                com.baidu.live.c.pr().putBoolean(ActionJsonData.TAG_SIGN_IN, this.Zb);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject19 != null) {
                this.Zd = optJSONObject19.optString("switch").equals("2");
                com.baidu.live.c.pr().putBoolean("follow_default_push_switch", this.Zd);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject20 != null) {
                this.ZH = optJSONObject20.optInt("switch");
                com.baidu.live.c.pr().putInt("to_tb_some_switch", this.ZH);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("task_config");
            if (optJSONObject21 != null) {
                this.ZG = optJSONObject21.optInt("switch");
                com.baidu.live.c.pr().putInt("ala_free_gift_task_switch", this.ZH);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject22 != null) {
                this.Zz = optJSONObject22.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("ala_enable_graffiti_str", this.Zz);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject23 != null) {
                this.aai = optJSONObject23.optInt("switch") == 1;
                this.aaj = optJSONObject23.optString("title");
                this.aak = optJSONObject23.optString("url");
                com.baidu.live.c.pr().putBoolean("live_challenge_switch", this.aai);
                com.baidu.live.c.pr().putString("live_challenge_tip", this.aaj);
                com.baidu.live.c.pr().putString("live_challenge_url", this.aak);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject24 != null) {
                this.aaq = optJSONObject24.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("is_new_gift_t_dou_strategy", this.aaq);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject25 != null) {
                this.aau = optJSONObject25.optInt("switch") == 1;
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject26 != null) {
                this.aas = optJSONObject26.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("key_is_open_login_prove", this.aas);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject27 != null) {
                this.aat = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("key_is_open_diamond", this.aat);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject28 != null) {
                this.aav = optJSONObject28.optInt("switch") == 1;
                com.baidu.live.c.pr().putBoolean("key_is_jump_to_live_room", this.aav);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject29 != null && (optInt2 = optJSONObject29.optInt("switch", -1)) >= 0) {
                this.aaS = optInt2 == 1;
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject30 != null && (optInt = optJSONObject30.optInt("switch", -1)) >= 0) {
                this.aaV = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void qt() {
        JSONArray jSONArray;
        this.YW = com.baidu.live.c.pr().getString("bluediamond_url", "");
        this.YM = com.baidu.live.c.pr().getString("verify_content", this.YM);
        this.YL = com.baidu.live.c.pr().getString("live_notice", "");
        String string = com.baidu.live.c.pr().getString("imNotice", "");
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
                        this.YK.add(i, optString);
                    }
                }
            }
        }
        this.ZB = com.baidu.live.c.pr().getString("share_host", "");
        this.ZC = com.baidu.live.c.pr().getString("ala_share_in_bar_notice_text", "");
        this.ZE = com.baidu.live.c.pr().getString("ala_share_reward_rank_notice_text", "");
        this.ZD = com.baidu.live.c.pr().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.YX = com.baidu.live.c.pr().getInt("recommend_refresh", 60);
        this.Ze = com.baidu.live.c.pr().getString("strategy_conf", "300");
        this.Zf = com.baidu.live.c.pr().getInt("strategy_exception_interval", 1);
        this.Zc = com.baidu.live.c.pr().getInt("liveStartAuthLevel", 1);
        this.YT = com.baidu.live.c.pr().getInt("2gTo", 5);
        this.YU = com.baidu.live.c.pr().getInt("3gTo", 3);
        this.YV = com.baidu.live.c.pr().getInt("wifiTo", 3);
        String string2 = com.baidu.live.c.pr().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.YP = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.c.pr().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.YQ = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.ZI = com.baidu.live.c.pr().getInt("square_tab_strategy", 1);
        this.ZJ = com.baidu.live.c.pr().getString("ala_live_ranklist_url", null);
        this.ZK = com.baidu.live.c.pr().getString("new_flower_rank_list_description_url", "");
        this.ZL = com.baidu.live.c.pr().getString("ala_game_player_signup_url", null);
        this.ZM = com.baidu.live.c.pr().getString("ala_game_frs_live_tab_video_url", null);
        qx();
        this.ZT = com.baidu.live.c.pr().getString("ala_personal_income_detail_url", null);
        this.aan = com.baidu.live.c.pr().getInt("ala_custom_gift_category_id", -1);
        this.ZU = com.baidu.live.c.pr().getInt("ala_live_pk_switch", 0) == 1;
        this.ZV = com.baidu.live.c.pr().getLong("ala_live_pk_check_interval", 1000L);
        this.ZW = com.baidu.live.c.pr().getLong("ala_live_pk_match_timeout", 60000L);
        this.ZX = com.baidu.live.c.pr().getString("ala_live_pk_pic_url", "");
        this.ZY = com.baidu.live.c.pr().getString("ala_live_pk_pic_jump_url", "");
        this.ZZ = com.baidu.live.c.pr().getString("ala_live_pk_history_link", "");
        this.aaa = com.baidu.live.c.pr().getString("show_live_forum_url", "");
        this.aab = com.baidu.live.c.pr().getLong("ala_challenge_random_interval", 1000L);
        this.aac = com.baidu.live.c.pr().getLong("ala_challenge_direct_interval", 1000L);
        this.aae = com.baidu.live.c.pr().getLong("ala_get_challenge_info_interval", 1000L);
        this.aag = com.baidu.live.c.pr().getString("ala_challenge_pk_entry_icon_url", "");
        this.aah = com.baidu.live.c.pr().getString("ala_challenge_pk_entry_icon_url", "");
        this.aaf = com.baidu.live.c.pr().getString("ala_challenge_pk_entry_icon_url", "");
        this.aao = com.baidu.live.c.pr().getBoolean("ala_guess_use_https", false);
        cY(com.baidu.live.c.pr().getString("ala_live_bar_map_str", ""));
        this.aap = com.baidu.live.c.pr().getBoolean("is_new_live_close_strategy", false);
        this.aaq = com.baidu.live.c.pr().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aar = com.baidu.live.c.pr().getString("ala_feedback_url", null);
        this.Zh = com.baidu.live.c.pr().getInt("ala_video_resolution_level", 3);
        this.Zi = com.baidu.live.c.pr().getBoolean("ala_live_hard_encode_switch", true);
        this.Zj = com.baidu.live.c.pr().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.pr().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.pr().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.pr().getInt("ala_video_increase_count", 3);
        this.Zk = com.baidu.live.c.pr().getString("ala_video_soft_bitrate_config", null);
        this.Zl = com.baidu.live.c.pr().getString("ala_video_hard_bitrate_config", null);
        this.Zp = com.baidu.live.c.pr().getInt("ala_master_chat_video_resolution_level", 3);
        this.Zq = com.baidu.live.c.pr().getInt("ala_slave_chat_video_resolution_level", 4);
        this.Zm = com.baidu.live.c.pr().getString("ala_avts_stream_server_domain_config", null);
        this.Zn = com.baidu.live.c.pr().getString("ala_master_chat_video_bitrate_config", null);
        this.Zo = com.baidu.live.c.pr().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.pr().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.pr().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aas = com.baidu.live.c.pr().getBoolean("key_is_open_login_prove", false);
        this.aat = com.baidu.live.c.pr().getBoolean("key_is_open_diamond", false);
        this.aav = com.baidu.live.c.pr().getBoolean("key_is_jump_to_live_room", false);
        cW(com.baidu.live.c.pr().getString("feed_diversion", ""));
        qw();
    }

    private void cW(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aaU = new AlaFeedDiversionData();
                this.aaU.parserJson(jSONObject);
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
                this.YA = optJSONObject2.optString("toast");
                this.Yz = optJSONObject2.optInt("remind_type");
            }
            this.YW = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.pr().putString("bluediamond_url", this.YW);
            this.YM = jSONObject.optString("verify_content");
            com.baidu.live.c.pr().putString("verify_content", this.YM);
            this.YL = jSONObject.optString("live_notice");
            com.baidu.live.c.pr().putString("live_notice", this.YL);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.YK.add(i, optString);
                    }
                }
                com.baidu.live.c.pr().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.c.pr().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.YN.add(i2, optString2);
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
                        this.YJ.add(fVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.YO.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.ZB = optJSONObject5.optString("url");
            } else {
                this.ZB = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.ZC = optJSONObject6.optString("reward_notice");
                this.ZE = optJSONObject6.optString("reward_rank_notice");
                this.ZD = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.ZC = "";
                this.ZE = "";
                this.ZD = 2;
            }
            com.baidu.live.c.pr().putString("share_host", this.ZB);
            com.baidu.live.c.pr().putString("ala_share_in_bar_notice_text", this.ZC);
            com.baidu.live.c.pr().putString("ala_share_reward_rank_notice_text", this.ZE);
            com.baidu.live.c.pr().putInt("ala_share_in_bar_notice_tip_switch", this.ZD);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.YX = optJSONObject7.optInt("value");
            } else {
                this.YX = 60;
            }
            com.baidu.live.c.pr().putInt("recommend_refresh", this.YX);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.pr().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.YP = g(optJSONArray5);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject9 != null) {
                JSONArray optJSONArray6 = optJSONObject9.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.pr().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.YQ = g(optJSONArray6);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject10 != null) {
                this.Ze = optJSONObject10.optString("time_interval");
                this.Zf = optJSONObject10.optInt("exception_interval");
            } else {
                this.Ze = "300";
                this.Zf = 1;
            }
            com.baidu.live.c.pr().putString("strategy_conf", this.Ze);
            com.baidu.live.c.pr().putInt("strategy_exception_interval", this.Zf);
            this.Zc = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.pr().putInt("liveStartAuthLevel", this.Zc);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject11 != null) {
                this.YT = optJSONObject11.optInt("2gTo");
                if (this.YT < 3) {
                    this.YT = 3;
                }
                this.YU = optJSONObject11.optInt("3gTo");
                if (this.YU < 3) {
                    this.YU = 3;
                }
                this.YV = optJSONObject11.optInt("wifiTo");
                if (this.YV < 3) {
                    this.YV = 3;
                }
                com.baidu.live.c.pr().putInt("2gTo", this.YT);
                com.baidu.live.c.pr().putInt("3gTo", this.YU);
                com.baidu.live.c.pr().putInt("wifiTo", this.YV);
            }
            this.ZI = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.pr().putInt("square_tab_strategy", this.ZI);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject12 != null) {
                this.ZJ = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
                this.ZK = optJSONObject12.optString("flower_rank_rule");
            }
            com.baidu.live.c.pr().putString("ala_live_ranklist_url", this.ZJ);
            com.baidu.live.c.pr().putString("new_flower_rank_list_description_url", this.ZK);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject13 != null) {
                this.ZL = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.pr().putString("ala_game_player_signup_url", this.ZL);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject14 != null) {
                this.ZM = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.pr().putString("ala_game_frs_live_tab_video_url", this.ZM);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject15 != null) {
                this.ZN = optJSONObject15.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.pr().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.ZO.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject16 != null) {
                com.baidu.live.c.pr().putString("ala_live_session_replace_key", optJSONObject16.toString());
                this.ZR = optJSONObject16.optString("hlsUrl");
                this.ZP = optJSONObject16.optString("rtmpUrl");
                this.ZQ = optJSONObject16.optString("flvUrl");
                this.ZS = optJSONObject16.optString(".m3u8");
            }
            b(true, this.ZN);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject17 != null) {
                this.ZT = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.pr().putString("ala_personal_income_detail_url", this.ZT);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject18 != null) {
                this.aan = optJSONObject18.optInt("android_show");
                com.baidu.live.c.pr().putInt("ala_custom_gift_category_id", this.aan);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject19 != null) {
                int optInt = optJSONObject19.optInt("open", 0);
                this.ZU = optInt == 1;
                com.baidu.live.c.pr().putInt("ala_live_pk_switch", optInt);
                this.ZV = optJSONObject19.optLong("interval");
                if (this.ZV < 1000) {
                    this.ZV = 1000L;
                }
                com.baidu.live.c.pr().putLong("ala_live_pk_check_interval", this.ZV);
                this.ZW = optJSONObject19.optLong("match_timeout");
                if (this.ZW < 60000) {
                    this.ZW = 60000L;
                }
                com.baidu.live.c.pr().putLong("ala_live_pk_match_timeout", this.ZW);
                this.ZX = optJSONObject19.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.pr().putString("ala_live_pk_pic_url", this.ZX);
                this.ZY = optJSONObject19.optString("rank_link");
                com.baidu.live.c.pr().putString("ala_live_pk_pic_jump_url", this.ZY);
                this.ZZ = optJSONObject19.optString("history_link");
                com.baidu.live.c.pr().putString("ala_live_pk_history_link", this.ZZ);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject20 != null) {
                this.aab = optJSONObject20.optLong("random_interval");
                if (this.aab < 1000) {
                    this.aab = 1000L;
                }
                com.baidu.live.c.pr().putLong("ala_challenge_random_interval", this.aab);
                this.aac = optJSONObject20.optLong("direct_interval");
                if (this.aac < 1000) {
                    this.aac = 1000L;
                }
                com.baidu.live.c.pr().putLong("ala_challenge_direct_interval", this.aac);
                this.aae = optJSONObject20.optLong("challenge_info_interval");
                if (this.aae < 1000) {
                    this.aae = 1000L;
                }
                com.baidu.live.c.pr().putLong("ala_get_challenge_info_interval", this.aae);
                this.aag = optJSONObject20.optString("pk_icon_url");
                com.baidu.live.c.pr().putString("ala_challenge_pk_entry_icon_url", this.aag);
                this.aah = optJSONObject20.optString("icon_url");
                com.baidu.live.c.pr().putString("ala_challenge_pk_entry_icon_url", this.aah);
                this.aaf = optJSONObject20.optString("rule_url");
                com.baidu.live.c.pr().putString("ala_challenge_pk_entry_icon_url", this.aaf);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject21 != null) {
                this.aaa = optJSONObject21.optString("go_url");
                com.baidu.live.c.pr().putString("show_live_forum_url", this.aaa);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject22 != null) {
                this.aao = optJSONObject22.optInt("use_https", 0) == 1;
                com.baidu.live.c.pr().putBoolean("ala_guess_use_https", this.aao);
            }
            String optString3 = jSONObject.optString("live_bar");
            cY(optString3);
            com.baidu.live.c.pr().putString("ala_live_bar_map_str", optString3);
            this.aap = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.pr().putBoolean("is_new_live_close_strategy", this.aap);
            this.aaq = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.pr().putBoolean("is_new_gift_t_dou_strategy", this.aaq);
            this.aar = jSONObject.optString("feedback_url");
            com.baidu.live.c.pr().putString("ala_feedback_url", this.aar);
            JSONObject optJSONObject23 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject23 != null && (optJSONObject = optJSONObject23.optJSONObject("challenge_related_zip")) != null) {
                this.aal = optJSONObject.optString("zip_md5");
                this.aam = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject24 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject24.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject24.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.pr().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.pr().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("open_live");
            if (optJSONObject25 != null) {
                this.increaseThreshold = optJSONObject25.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.pr().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject25.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.pr().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject25.optInt("thi_count", 3);
                com.baidu.live.c.pr().putInt("ala_video_increase_count", this.increaseCount);
                this.Zi = optJSONObject25.optInt("encoder", 1) == 1;
                com.baidu.live.c.pr().putBoolean("ala_live_hard_encode_switch", this.Zi);
                this.Zj = optJSONObject25.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.pr().putBoolean("ala_dynamic_bitrate_switch", this.Zj);
                this.Zh = optJSONObject25.optInt("resolution", 3);
                com.baidu.live.c.pr().putInt("ala_video_resolution_level", this.Zh);
                JSONArray optJSONArray8 = optJSONObject25.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.Zk = optJSONArray8.toString();
                    com.baidu.live.c.pr().putString("ala_video_soft_bitrate_config", this.Zk);
                }
                JSONArray optJSONArray9 = optJSONObject25.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.Zl = optJSONArray9.toString();
                    com.baidu.live.c.pr().putString("ala_video_hard_bitrate_config", this.Zl);
                }
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject26 != null) {
                this.Zm = optJSONObject26.toString();
                com.baidu.live.c.pr().putString("ala_avts_stream_server_domain_config", this.Zm);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject27 != null) {
                this.Zp = optJSONObject27.optInt("host_rtc_resolution", 3);
                com.baidu.live.c.pr().putInt("ala_master_chat_video_resolution_level", this.Zp);
                this.Zq = optJSONObject27.optInt("rtc_resolution", 4);
                com.baidu.live.c.pr().putInt("ala_slave_chat_video_resolution_level", this.Zq);
                JSONArray optJSONArray10 = optJSONObject27.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.Zn = optJSONArray10.toString();
                    com.baidu.live.c.pr().putString("ala_master_chat_video_bitrate_config", this.Zn);
                }
                JSONArray optJSONArray11 = optJSONObject27.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.Zo = optJSONArray11.toString();
                    com.baidu.live.c.pr().putString("ala_slave_chat_video_bitrate_config", this.Zo);
                }
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject28 != null) {
                this.aaU = new AlaFeedDiversionData();
                this.aaU.parserJson(optJSONObject28);
                com.baidu.live.c.pr().putString("feed_diversion", optJSONObject28.toString());
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject29 != null) {
                com.baidu.live.c.pr().putString("key_stat_switch", optJSONObject29.toString());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aaK = jSONObject.optInt("im_max", 200);
            if (this.aaK <= 0) {
                this.aaK = 200;
            }
            this.aaL = jSONObject.optInt("barrage_max", 100);
            if (this.aaL <= 0) {
                this.aaL = 100;
            }
            this.aaM = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aaM <= 0) {
                this.aaM = 10;
            }
            this.aaN = jSONObject.optInt("enter_effect_max", 10);
            if (this.aaN <= 0) {
                this.aaN = 10;
            }
            this.aaO = jSONObject.optInt("gift_big_max", 10);
            if (this.aaO <= 0) {
                this.aaO = 10;
            }
            this.aaP = jSONObject.optInt("gift_small_max", 50);
            if (this.aaP <= 0) {
                this.aaP = 50;
            }
            this.aaQ = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aaQ <= 0) {
                this.aaQ = 5;
            }
        }
    }

    private void qu() {
        this.aaw = com.baidu.live.c.pr().getInt("guide_speak_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        this.aax = com.baidu.live.c.pr().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.pr().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aay = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aay[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void m(JSONObject jSONObject) {
        int length;
        this.aaw = jSONObject.optInt("rule_watch_time", BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL) * 1000;
        com.baidu.live.c.pr().putInt("guide_speak_watch_time", this.aaw);
        this.aax = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.pr().putInt("guide_speak_show_times_max", this.aax);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aay = new String[length];
            for (int i = 0; i < length; i++) {
                this.aay[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.pr().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void n(JSONObject jSONObject) {
        this.aaE = jSONObject.optInt("supernatant_time") * 1000;
        this.aaF = jSONObject.optInt("suoernatant_shownum");
        this.aaG = jSONObject.optInt("pop_window_time") * 1000;
    }

    private void qv() {
        String string = com.baidu.live.c.pr().getString("yuan_package_data", "");
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
            this.aaD = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aaD.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void cX(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aaH = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aaH.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aaI = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aaI.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.pr().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void qw() {
        cX(com.baidu.live.c.pr().getString("ala_quick_send_im_list", null));
    }

    private void cY(String str) {
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
        if (i != this.ZN) {
            z2 = true;
        }
        this.ZN = i;
        if (z || z2) {
            com.baidu.live.c.pr().putInt("ala_live_session_default_key", i);
        }
    }

    private void qx() {
        this.ZN = com.baidu.live.c.pr().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.pr().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.ZO.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.pr().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.ZR = jSONObject.optString("hlsUrl");
                this.ZP = jSONObject.optString("rtmpUrl");
                this.ZQ = jSONObject.optString("flvUrl");
                this.ZS = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean qy() {
        return this.ZG == 1;
    }
}
