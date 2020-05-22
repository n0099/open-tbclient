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
public class y extends BaseData {
    public String awA;
    public int awB;
    public boolean awC;
    public boolean awD;
    public boolean awE;
    public boolean awF;
    public boolean awH;
    public String awI;
    public int awJ;
    public boolean awK;
    public int awL;
    public boolean awM;
    public boolean awN;
    public String awO;
    public String awP;
    public String awQ;
    public String awR;
    public String awS;
    public int awT;
    public int awU;
    public boolean awV;
    public boolean awW;
    public boolean awX;
    public boolean awY;
    public boolean awZ;
    public boolean awf;
    public boolean awg;
    public boolean awh;
    public boolean awi;
    public boolean awj;
    public String awk;
    public String awl;
    public String awp;
    public String awq;
    public Integer[] awt;
    public Integer[] awu;
    public int awv;
    public int awx;
    public int awy;
    public int awz;
    public boolean axA;
    public long axB;
    public long axC;
    public String axD;
    public String axE;
    public String axF;
    public String axG;
    public long axH;
    public long axI;
    public long axJ;
    public String axK;
    public String axL;
    public String axM;
    public String axO;
    public String axP;
    public String axQ;
    public String axR;
    public int axS;
    public String axW;
    public boolean axa;
    public String axe;
    public String axg;
    public String axh;
    public int axn;
    public String axp;
    public String axq;
    private String axr;
    private String axs;
    public int axt;
    public String axv;
    public String axw;
    public String axx;
    public String axy;
    public String axz;
    public int ayA;
    public int ayB;
    public z ayF;
    public int ayb;
    public int ayc;
    public String[] ayd;
    public int aye;
    public String ayf;
    public String ayg;
    public QuickImInputData ayh;
    public List<YuanPackageData> ayi;
    public ap ayj;
    public List<String> ayk;
    public List<String> ayl;
    public List<String> aym;
    public ag ayu;
    public boolean ayv;
    public String ayw;
    public AlaFeedDiversionData ayx;
    public l ayy;
    public boolean ayz;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int awd = -1;
    public String awe = null;
    public int awG = 1;
    public boolean axb = true;
    public boolean axc = false;
    public boolean axd = false;
    public boolean axf = false;
    public String axi = "";
    private int axj = 2;
    public String axk = "";
    public int axl = 1;
    public int axm = 0;
    public int axo = 1;
    public List<String> axu = new ArrayList();
    public boolean axN = false;
    public boolean axT = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean axU = false;
    public boolean axV = false;
    public boolean axX = false;
    public boolean axY = false;
    public boolean axZ = false;
    public boolean aya = false;
    public int ayn = 200;
    public int ayo = 100;
    public int ayp = 10;
    public int ayq = 10;
    public int ayr = 10;
    public int ays = 50;
    public int ayt = 5;
    public int ayC = 20;
    public int ayD = 70;
    public int ayE = 10000;
    public int ayG = 7;
    public List<String> awo = new ArrayList();
    public List<String> aww = new ArrayList();
    public List<String> awr = new ArrayList();
    public List<Integer> aws = new ArrayList();
    public ArrayList<i> awm = new ArrayList<>();
    public ArrayList<i> awn = new ArrayList<>();

    public y(boolean z) {
        if (z) {
            vZ();
            this.awv = com.baidu.live.c.uN().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.uN().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.uN().getInt("restart_time_interval", 300);
            wa();
            vY();
            wb();
            wc();
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
                    t(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject3 != null) {
                    this.awv = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.uN().putInt("conn_conf", this.awv);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aww.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.c.uN().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.c.uN().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    u(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    v(optJSONObject5);
                }
                this.axg = jSONObject.optString("client_id");
                com.baidu.live.c.uN().putString("client_id", this.axg);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.awk = optJSONObject6.optString("pic_url");
                    this.awl = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            i iVar = new i();
                            iVar.parseJson(optJSONObject8);
                            this.awm.add(iVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.uN().putString("pic_url", this.awk);
                com.baidu.live.c.uN().putString(BigdayActivityConfig.JUMP_URL, this.awl);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    w(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aye = optJSONObject10.optInt("resource_switch");
                    this.ayg = optJSONObject10.optString("photo_url");
                    this.ayf = optJSONObject10.optString("resource_url");
                }
                this.ayh = new QuickImInputData();
                this.ayh.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.ayj = ap.x(jSONObject.optJSONObject("guide_follow"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.uN().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject11 != null) {
                    JSONObject optJSONObject12 = optJSONObject11.optJSONObject("rank");
                    if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.c.uN().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.c.uN().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.c.uN().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject13 = optJSONObject11.optJSONObject("guard_seat");
                    if (optJSONObject13 != null) {
                        this.ayw = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.ayu = new ag();
                    this.ayu.azk = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.c.uN().putString("ala_certify_refuse_url", this.ayu.azk);
                }
                this.ayF = new z();
                this.ayF.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.ayy = new l();
                    this.ayy.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.ayG = optJSONObject16.optInt("show_days");
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.uN().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void vY() {
        String string = com.baidu.live.c.uN().getString("ala_prepare_random_title_list", "");
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
            this.aym = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aym.add(jSONArray.optString(i));
            }
        }
    }

    private void vZ() {
        this.awf = com.baidu.live.c.uN().getBoolean("map_around_map", false);
        this.awK = com.baidu.live.c.uN().getBoolean("withdraw_switch", true);
        this.axe = com.baidu.live.c.uN().getString("withdraw_text", "");
        this.awX = com.baidu.live.c.uN().getBoolean("use_internal_player_switch", true);
        this.awV = com.baidu.live.c.uN().getBoolean("use_http_dns_switch", true);
        this.awW = com.baidu.live.c.uN().getBoolean("use_encode_bframe_switch", false);
        this.awY = com.baidu.live.c.uN().getBoolean("live_beauty_open_switch", false);
        this.awZ = com.baidu.live.c.uN().getBoolean("live_unity_beauty_switch", true);
        this.axa = com.baidu.live.c.uN().getBoolean("live_unity_beauty_face_style_switch", true);
        this.axb = com.baidu.live.c.uN().getBoolean("sp_key_live_game_hard_encode", true);
        this.axc = com.baidu.live.c.uN().getBoolean("sp_key_live_play_transcode_support", false);
        this.axd = com.baidu.live.c.uN().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.axf = com.baidu.live.c.uN().getBoolean("ala_enable_graffiti_str", false);
        this.awg = com.baidu.live.c.uN().getBoolean("enter_live", false);
        this.awh = com.baidu.live.c.uN().getBoolean("sync_to_forum", true);
        this.awi = com.baidu.live.c.uN().getBoolean("show_water_mark", false);
        this.awj = com.baidu.live.c.uN().getBoolean("show_third_part_water_mark_switch", false);
        this.awC = com.baidu.live.c.uN().getBoolean("stream_error_log", true);
        this.awD = com.baidu.live.c.uN().getBoolean("disable_channel_in", true);
        this.awE = com.baidu.live.c.uN().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.awF = com.baidu.live.c.uN().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.awH = com.baidu.live.c.uN().getBoolean("follow_default_push_switch", true);
        this.axn = com.baidu.live.c.uN().getInt("to_tb_some_switch", 0);
        this.axl = com.baidu.live.c.uN().getInt("enable_live_stat", 1);
        this.axm = com.baidu.live.c.uN().getInt("ala_free_gift_task_switch", 0);
        this.axN = com.baidu.live.c.uN().getBoolean("live_challenge_switch", false);
        this.axO = com.baidu.live.c.uN().getString("live_challenge_tip", null);
        this.axP = com.baidu.live.c.uN().getString("live_challenge_url", null);
    }

    private void t(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.awf = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.uN().putBoolean("map_around_map", this.awf);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.awK = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("withdraw_switch", this.awK);
                this.axe = optJSONObject2.optString("text");
                com.baidu.live.c.uN().putString("withdraw_text", this.axe);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.awX = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("use_internal_player_switch", this.awX);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.awV = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("use_http_dns_switch", this.awV);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.awW = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("use_encode_bframe_switch", this.awW);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject6 != null) {
                this.awY = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("live_beauty_open_switch", this.awY);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject7 != null) {
                this.awZ = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("live_unity_beauty_switch", this.awZ);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject8 != null) {
                this.axa = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("live_unity_beauty_face_style_switch", this.axa);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject9 != null) {
                this.axb = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("sp_key_live_game_hard_encode", this.axb);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject10 != null) {
                this.axc = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("sp_key_live_play_transcode_support", this.axc);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject11 != null) {
                this.axd = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("sp_key_live_play_attention_guide_support", this.axd);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject12 != null) {
                this.awg = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("enter_live", this.awg);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject13 != null) {
                this.awh = optJSONObject13.optString("switch").equals("1");
                com.baidu.live.c.uN().putBoolean("sync_to_forum", this.awh);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject14 != null) {
                this.awi = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.c.uN().putBoolean("show_water_mark", this.awi);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject15 != null) {
                this.awj = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.c.uN().putBoolean("show_third_part_water_mark_switch", this.awj);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject16 != null) {
                this.axl = optJSONObject16.optInt("switch");
                com.baidu.live.c.uN().putInt("enable_live_stat", this.axl);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject17 != null) {
                this.awC = optJSONObject17.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("stream_error_log", this.awC);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject18 != null) {
                this.awD = optJSONObject18.optString("switch").equals("1");
                com.baidu.live.c.uN().putBoolean("disable_channel_in", this.awD);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject19 != null) {
                this.awE = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.c.uN().putBoolean("shoubai_yanzhi_tab_tip", this.awE);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject20 != null) {
                this.awF = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.c.uN().putBoolean(ActionJsonData.TAG_SIGN_IN, this.awF);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject21 != null) {
                this.awH = optJSONObject21.optString("switch").equals("2");
                com.baidu.live.c.uN().putBoolean("follow_default_push_switch", this.awH);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject22 != null) {
                this.axn = optJSONObject22.optInt("switch");
                com.baidu.live.c.uN().putInt("to_tb_some_switch", this.axn);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("task_config");
            if (optJSONObject23 != null) {
                this.axm = optJSONObject23.optInt("switch");
                com.baidu.live.c.uN().putInt("ala_free_gift_task_switch", this.axn);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject24 != null) {
                this.axf = optJSONObject24.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("ala_enable_graffiti_str", this.axf);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject25 != null) {
                this.axN = optJSONObject25.optInt("switch") == 1;
                this.axO = optJSONObject25.optString("title");
                this.axP = optJSONObject25.optString("url");
                com.baidu.live.c.uN().putBoolean("live_challenge_switch", this.axN);
                com.baidu.live.c.uN().putString("live_challenge_tip", this.axO);
                com.baidu.live.c.uN().putString("live_challenge_url", this.axP);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject26 != null) {
                this.axV = optJSONObject26.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("is_new_gift_t_dou_strategy", this.axV);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject27 != null) {
                this.axZ = optJSONObject27.optInt("switch") == 1;
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject28 != null) {
                this.axX = optJSONObject28.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("key_is_open_login_prove", this.axX);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject29 != null) {
                this.axY = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("key_is_open_diamond", this.axY);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject30 != null) {
                this.aya = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.c.uN().putBoolean("key_is_jump_to_live_room", this.aya);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject31 != null && (optInt2 = optJSONObject31.optInt("switch", -1)) >= 0) {
                this.ayv = optInt2 == 1;
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject32 != null && (optInt = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.ayz = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void wa() {
        JSONArray jSONArray;
        this.awA = com.baidu.live.c.uN().getString("bluediamond_url", "");
        this.awq = com.baidu.live.c.uN().getString("verify_content", this.awq);
        this.awp = com.baidu.live.c.uN().getString("live_notice", "");
        String string = com.baidu.live.c.uN().getString("imNotice", "");
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
                        this.awo.add(i, optString);
                    }
                }
            }
        }
        this.axh = com.baidu.live.c.uN().getString("share_host", "");
        this.axi = com.baidu.live.c.uN().getString("ala_share_in_bar_notice_text", "");
        this.axk = com.baidu.live.c.uN().getString("ala_share_reward_rank_notice_text", "");
        this.axj = com.baidu.live.c.uN().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.awB = com.baidu.live.c.uN().getInt("recommend_refresh", 60);
        this.awI = com.baidu.live.c.uN().getString("strategy_conf", "300");
        this.awJ = com.baidu.live.c.uN().getInt("strategy_exception_interval", 1);
        this.awG = com.baidu.live.c.uN().getInt("liveStartAuthLevel", 1);
        this.awx = com.baidu.live.c.uN().getInt("2gTo", 5);
        this.awy = com.baidu.live.c.uN().getInt("3gTo", 3);
        this.awz = com.baidu.live.c.uN().getInt("wifiTo", 3);
        String string2 = com.baidu.live.c.uN().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.awt = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.c.uN().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.awu = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.axo = com.baidu.live.c.uN().getInt("square_tab_strategy", 1);
        this.axp = com.baidu.live.c.uN().getString("ala_live_ranklist_url", null);
        this.axq = com.baidu.live.c.uN().getString("new_flower_rank_list_description_url", "");
        this.axr = com.baidu.live.c.uN().getString("ala_game_player_signup_url", null);
        this.axs = com.baidu.live.c.uN().getString("ala_game_frs_live_tab_video_url", null);
        we();
        this.axz = com.baidu.live.c.uN().getString("ala_personal_income_detail_url", null);
        this.axS = com.baidu.live.c.uN().getInt("ala_custom_gift_category_id", -1);
        this.axA = com.baidu.live.c.uN().getInt("ala_live_pk_switch", 0) == 1;
        this.axB = com.baidu.live.c.uN().getLong("ala_live_pk_check_interval", 1000L);
        this.axC = com.baidu.live.c.uN().getLong("ala_live_pk_match_timeout", 60000L);
        this.axD = com.baidu.live.c.uN().getString("ala_live_pk_pic_url", "");
        this.axE = com.baidu.live.c.uN().getString("ala_live_pk_pic_jump_url", "");
        this.axF = com.baidu.live.c.uN().getString("ala_live_pk_history_link", "");
        this.axG = com.baidu.live.c.uN().getString("show_live_forum_url", "");
        this.axH = com.baidu.live.c.uN().getLong("ala_challenge_random_interval", 1000L);
        this.axI = com.baidu.live.c.uN().getLong("ala_challenge_direct_interval", 1000L);
        this.axJ = com.baidu.live.c.uN().getLong("ala_get_challenge_info_interval", 1000L);
        this.axL = com.baidu.live.c.uN().getString("ala_challenge_pk_entry_icon_url", "");
        this.axM = com.baidu.live.c.uN().getString("ala_challenge_pk_entry_icon_url", "");
        this.axK = com.baidu.live.c.uN().getString("ala_challenge_pk_entry_icon_url", "");
        this.axT = com.baidu.live.c.uN().getBoolean("ala_guess_use_https", false);
        eu(com.baidu.live.c.uN().getString("ala_live_bar_map_str", ""));
        this.axU = com.baidu.live.c.uN().getBoolean("is_new_live_close_strategy", false);
        this.axV = com.baidu.live.c.uN().getBoolean("is_new_gift_t_dou_strategy", false);
        this.axW = com.baidu.live.c.uN().getString("ala_feedback_url", null);
        this.awL = com.baidu.live.c.uN().getInt("ala_video_resolution_level", 3);
        this.awM = com.baidu.live.c.uN().getBoolean("ala_live_hard_encode_switch", true);
        this.awN = com.baidu.live.c.uN().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.uN().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.uN().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.uN().getInt("ala_video_increase_count", 3);
        this.awO = com.baidu.live.c.uN().getString("ala_video_soft_bitrate_config", null);
        this.awP = com.baidu.live.c.uN().getString("ala_video_hard_bitrate_config", null);
        this.awT = com.baidu.live.c.uN().getInt("ala_master_chat_video_resolution_level", 3);
        this.awU = com.baidu.live.c.uN().getInt("ala_slave_chat_video_resolution_level", 4);
        this.awQ = com.baidu.live.c.uN().getString("ala_avts_stream_server_domain_config", null);
        this.awR = com.baidu.live.c.uN().getString("ala_master_chat_video_bitrate_config", null);
        this.awS = com.baidu.live.c.uN().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.uN().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.uN().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.axX = com.baidu.live.c.uN().getBoolean("key_is_open_login_prove", false);
        this.axY = com.baidu.live.c.uN().getBoolean("key_is_open_diamond", false);
        this.aya = com.baidu.live.c.uN().getBoolean("key_is_jump_to_live_room", false);
        es(com.baidu.live.c.uN().getString("feed_diversion", ""));
        wd();
    }

    private void es(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.ayx = new AlaFeedDiversionData();
                this.ayx.parserJson(jSONObject);
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

    private void u(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject2 != null) {
                this.awe = optJSONObject2.optString("toast");
                this.awd = optJSONObject2.optInt("remind_type");
            }
            this.awA = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.uN().putString("bluediamond_url", this.awA);
            this.awq = jSONObject.optString("verify_content");
            com.baidu.live.c.uN().putString("verify_content", this.awq);
            this.awp = jSONObject.optString("live_notice");
            com.baidu.live.c.uN().putString("live_notice", this.awp);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.awo.add(i, optString);
                    }
                }
                com.baidu.live.c.uN().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.c.uN().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.awr.add(i2, optString2);
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
                        this.awn.add(iVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aws.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.axh = optJSONObject5.optString("url");
            } else {
                this.axh = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.axi = optJSONObject6.optString("reward_notice");
                this.axk = optJSONObject6.optString("reward_rank_notice");
                this.axj = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.axi = "";
                this.axk = "";
                this.axj = 2;
            }
            com.baidu.live.c.uN().putString("share_host", this.axh);
            com.baidu.live.c.uN().putString("ala_share_in_bar_notice_text", this.axi);
            com.baidu.live.c.uN().putString("ala_share_reward_rank_notice_text", this.axk);
            com.baidu.live.c.uN().putInt("ala_share_in_bar_notice_tip_switch", this.axj);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.awB = optJSONObject7.optInt("value");
            } else {
                this.awB = 60;
            }
            com.baidu.live.c.uN().putInt("recommend_refresh", this.awB);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.uN().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.awt = g(optJSONArray5);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject9 != null) {
                JSONArray optJSONArray6 = optJSONObject9.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.uN().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.awu = g(optJSONArray6);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject10 != null) {
                this.awI = optJSONObject10.optString("time_interval");
                this.awJ = optJSONObject10.optInt("exception_interval");
            } else {
                this.awI = "300";
                this.awJ = 1;
            }
            com.baidu.live.c.uN().putString("strategy_conf", this.awI);
            com.baidu.live.c.uN().putInt("strategy_exception_interval", this.awJ);
            this.awG = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.uN().putInt("liveStartAuthLevel", this.awG);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject11 != null) {
                this.awx = optJSONObject11.optInt("2gTo");
                if (this.awx < 3) {
                    this.awx = 3;
                }
                this.awy = optJSONObject11.optInt("3gTo");
                if (this.awy < 3) {
                    this.awy = 3;
                }
                this.awz = optJSONObject11.optInt("wifiTo");
                if (this.awz < 3) {
                    this.awz = 3;
                }
                com.baidu.live.c.uN().putInt("2gTo", this.awx);
                com.baidu.live.c.uN().putInt("3gTo", this.awy);
                com.baidu.live.c.uN().putInt("wifiTo", this.awz);
            }
            this.axo = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.uN().putInt("square_tab_strategy", this.axo);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject12 != null) {
                this.axp = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
                this.axq = optJSONObject12.optString("flower_rank_rule");
            }
            com.baidu.live.c.uN().putString("ala_live_ranklist_url", this.axp);
            com.baidu.live.c.uN().putString("new_flower_rank_list_description_url", this.axq);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject13 != null) {
                this.axr = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.uN().putString("ala_game_player_signup_url", this.axr);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject14 != null) {
                this.axs = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.uN().putString("ala_game_frs_live_tab_video_url", this.axs);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject15 != null) {
                this.axt = optJSONObject15.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.uN().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.axu.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject16 != null) {
                com.baidu.live.c.uN().putString("ala_live_session_replace_key", optJSONObject16.toString());
                this.axx = optJSONObject16.optString("hlsUrl");
                this.axv = optJSONObject16.optString("rtmpUrl");
                this.axw = optJSONObject16.optString("flvUrl");
                this.axy = optJSONObject16.optString(".m3u8");
            }
            b(true, this.axt);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject17 != null) {
                this.axz = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.uN().putString("ala_personal_income_detail_url", this.axz);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject18 != null) {
                this.axS = optJSONObject18.optInt("android_show");
                com.baidu.live.c.uN().putInt("ala_custom_gift_category_id", this.axS);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject19 != null) {
                int optInt = optJSONObject19.optInt("open", 0);
                this.axA = optInt == 1;
                com.baidu.live.c.uN().putInt("ala_live_pk_switch", optInt);
                this.axB = optJSONObject19.optLong("interval");
                if (this.axB < 1000) {
                    this.axB = 1000L;
                }
                com.baidu.live.c.uN().putLong("ala_live_pk_check_interval", this.axB);
                this.axC = optJSONObject19.optLong("match_timeout");
                if (this.axC < 60000) {
                    this.axC = 60000L;
                }
                com.baidu.live.c.uN().putLong("ala_live_pk_match_timeout", this.axC);
                this.axD = optJSONObject19.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.uN().putString("ala_live_pk_pic_url", this.axD);
                this.axE = optJSONObject19.optString("rank_link");
                com.baidu.live.c.uN().putString("ala_live_pk_pic_jump_url", this.axE);
                this.axF = optJSONObject19.optString("history_link");
                com.baidu.live.c.uN().putString("ala_live_pk_history_link", this.axF);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject20 != null) {
                this.axH = optJSONObject20.optLong("random_interval");
                if (this.axH < 1000) {
                    this.axH = 1000L;
                }
                com.baidu.live.c.uN().putLong("ala_challenge_random_interval", this.axH);
                this.axI = optJSONObject20.optLong("direct_interval");
                if (this.axI < 1000) {
                    this.axI = 1000L;
                }
                com.baidu.live.c.uN().putLong("ala_challenge_direct_interval", this.axI);
                this.axJ = optJSONObject20.optLong("challenge_info_interval");
                if (this.axJ < 1000) {
                    this.axJ = 1000L;
                }
                com.baidu.live.c.uN().putLong("ala_get_challenge_info_interval", this.axJ);
                this.axL = optJSONObject20.optString("pk_icon_url");
                com.baidu.live.c.uN().putString("ala_challenge_pk_entry_icon_url", this.axL);
                this.axM = optJSONObject20.optString("icon_url");
                com.baidu.live.c.uN().putString("ala_challenge_pk_entry_icon_url", this.axM);
                this.axK = optJSONObject20.optString("rule_url");
                com.baidu.live.c.uN().putString("ala_challenge_pk_entry_icon_url", this.axK);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject21 != null) {
                this.axG = optJSONObject21.optString("go_url");
                com.baidu.live.c.uN().putString("show_live_forum_url", this.axG);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject22 != null) {
                this.axT = optJSONObject22.optInt("use_https", 0) == 1;
                com.baidu.live.c.uN().putBoolean("ala_guess_use_https", this.axT);
            }
            String optString3 = jSONObject.optString("live_bar");
            eu(optString3);
            com.baidu.live.c.uN().putString("ala_live_bar_map_str", optString3);
            this.axU = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.uN().putBoolean("is_new_live_close_strategy", this.axU);
            this.axV = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.uN().putBoolean("is_new_gift_t_dou_strategy", this.axV);
            this.axW = jSONObject.optString("feedback_url");
            com.baidu.live.c.uN().putString("ala_feedback_url", this.axW);
            JSONObject optJSONObject23 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject23 != null && (optJSONObject = optJSONObject23.optJSONObject("challenge_related_zip")) != null) {
                this.axQ = optJSONObject.optString("zip_md5");
                this.axR = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject24 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject24.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject24.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.uN().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.uN().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("open_live");
            if (optJSONObject25 != null) {
                this.increaseThreshold = optJSONObject25.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.uN().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject25.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.uN().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject25.optInt("thi_count", 3);
                com.baidu.live.c.uN().putInt("ala_video_increase_count", this.increaseCount);
                this.awM = optJSONObject25.optInt("encoder", 1) == 1;
                com.baidu.live.c.uN().putBoolean("ala_live_hard_encode_switch", this.awM);
                this.awN = optJSONObject25.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.uN().putBoolean("ala_dynamic_bitrate_switch", this.awN);
                this.awL = optJSONObject25.optInt("resolution", 3);
                com.baidu.live.c.uN().putInt("ala_video_resolution_level", this.awL);
                JSONArray optJSONArray8 = optJSONObject25.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.awO = optJSONArray8.toString();
                    com.baidu.live.c.uN().putString("ala_video_soft_bitrate_config", this.awO);
                }
                JSONArray optJSONArray9 = optJSONObject25.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.awP = optJSONArray9.toString();
                    com.baidu.live.c.uN().putString("ala_video_hard_bitrate_config", this.awP);
                }
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject26 != null) {
                this.awQ = optJSONObject26.toString();
                com.baidu.live.c.uN().putString("ala_avts_stream_server_domain_config", this.awQ);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject27 != null) {
                this.awT = optJSONObject27.optInt("host_rtc_resolution", 3);
                com.baidu.live.c.uN().putInt("ala_master_chat_video_resolution_level", this.awT);
                this.awU = optJSONObject27.optInt("rtc_resolution", 4);
                com.baidu.live.c.uN().putInt("ala_slave_chat_video_resolution_level", this.awU);
                JSONArray optJSONArray10 = optJSONObject27.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.awR = optJSONArray10.toString();
                    com.baidu.live.c.uN().putString("ala_master_chat_video_bitrate_config", this.awR);
                }
                JSONArray optJSONArray11 = optJSONObject27.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.awS = optJSONArray11.toString();
                    com.baidu.live.c.uN().putString("ala_slave_chat_video_bitrate_config", this.awS);
                }
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject28 != null) {
                this.ayC = optJSONObject28.optInt("enter_live_msg_audience_num_p1");
                this.ayD = optJSONObject28.optInt("enter_live_msg_audience_num_p2");
                this.ayE = optJSONObject28.optInt("enter_live_msg_audience_num_p3");
                this.ayA = optJSONObject28.optInt("im_intercept_switch");
                this.ayB = optJSONObject28.optInt("is_check_im_content");
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject29 != null) {
                this.ayx = new AlaFeedDiversionData();
                this.ayx.parserJson(optJSONObject29);
                com.baidu.live.c.uN().putString("feed_diversion", optJSONObject29.toString());
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject30 != null) {
                com.baidu.live.c.uN().putString("key_stat_switch", optJSONObject30.toString());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void v(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayn = jSONObject.optInt("im_max", 200);
            if (this.ayn <= 0) {
                this.ayn = 200;
            }
            this.ayo = jSONObject.optInt("barrage_max", 100);
            if (this.ayo <= 0) {
                this.ayo = 100;
            }
            this.ayp = jSONObject.optInt("pay_barrage_max", 10);
            if (this.ayp <= 0) {
                this.ayp = 10;
            }
            this.ayq = jSONObject.optInt("enter_effect_max", 10);
            if (this.ayq <= 0) {
                this.ayq = 10;
            }
            this.ayr = jSONObject.optInt("gift_big_max", 10);
            if (this.ayr <= 0) {
                this.ayr = 10;
            }
            this.ays = jSONObject.optInt("gift_small_max", 50);
            if (this.ays <= 0) {
                this.ays = 50;
            }
            this.ayt = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.ayt <= 0) {
                this.ayt = 5;
            }
        }
    }

    private void wb() {
        this.ayb = com.baidu.live.c.uN().getInt("guide_speak_watch_time", 15000);
        this.ayc = com.baidu.live.c.uN().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.uN().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.ayd = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.ayd[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void w(JSONObject jSONObject) {
        int length;
        this.ayb = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.c.uN().putInt("guide_speak_watch_time", this.ayb);
        this.ayc = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.uN().putInt("guide_speak_show_times_max", this.ayc);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.ayd = new String[length];
            for (int i = 0; i < length; i++) {
                this.ayd[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.uN().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void wc() {
        String string = com.baidu.live.c.uN().getString("yuan_package_data", "");
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
            this.ayi = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.ayi.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void et(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.ayk = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.ayk.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.ayl = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.ayl.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.uN().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void wd() {
        et(com.baidu.live.c.uN().getString("ala_quick_send_im_list", null));
    }

    private void eu(String str) {
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
        if (i != this.axt) {
            z2 = true;
        }
        this.axt = i;
        if (z || z2) {
            com.baidu.live.c.uN().putInt("ala_live_session_default_key", i);
        }
    }

    private void we() {
        this.axt = com.baidu.live.c.uN().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.uN().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.axu.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.uN().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.axx = jSONObject.optString("hlsUrl");
                this.axv = jSONObject.optString("rtmpUrl");
                this.axw = jSONObject.optString("flvUrl");
                this.axy = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean wf() {
        return this.axm == 1;
    }
}
