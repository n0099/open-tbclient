package com.baidu.live.data;

import android.text.TextUtils;
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
public class v extends BaseData {
    public boolean arA;
    public boolean arC;
    public String arD;
    public int arE;
    public boolean arF;
    public int arG;
    public boolean arH;
    public boolean arI;
    public String arJ;
    public String arK;
    public String arL;
    public String arM;
    public String arN;
    public int arO;
    public int arP;
    public boolean arQ;
    public boolean arR;
    public boolean arS;
    public boolean arT;
    public String arX;
    public String arZ;
    public boolean ara;
    public boolean arb;
    public boolean arc;
    public boolean ard;
    public boolean are;
    public String arf;
    public String arg;
    public String ark;
    public String arl;
    public Integer[] aro;
    public Integer[] arp;
    public int arq;
    public int ars;
    public int art;
    public int aru;
    public String arv;
    public int arw;
    public boolean arx;
    public boolean ary;
    public boolean arz;
    public String asA;
    public long asB;
    public long asC;
    public long asD;
    public String asE;
    public String asF;
    public String asG;
    public String asI;
    public String asJ;
    public String asK;
    public String asL;
    public int asM;
    public String asQ;
    public int asV;
    public int asW;
    public String[] asX;
    public int asY;
    public String asZ;
    public String asa;
    public int asg;
    public String asi;
    public String asj;
    private String ask;
    private String asl;
    public int asn;
    public String asp;
    public String asq;
    public String asr;
    public String ass;
    public String ast;
    public boolean asu;
    public long asv;
    public long asw;
    public String asx;
    public String asy;
    public String asz;
    public String ata;
    public QuickImInputData atb;
    public List<YuanPackageData> atc;
    public int atd;
    public int ate;
    public int atf;
    public List<String> atg;
    public List<String> ath;
    public List<String> ati;
    public ac atq;
    public boolean atr;
    public String ats;
    public AlaFeedDiversionData att;
    public i atu;
    public boolean atv;
    public int atw;
    public int atx;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aqY = -1;
    public String aqZ = null;
    public int arB = 1;
    public boolean arU = true;
    public boolean arV = false;
    public boolean arW = false;
    public boolean arY = false;
    public String asb = "";
    private int asc = 2;
    public String asd = "";
    public int ase = 1;
    public int asf = 0;
    public int ash = 1;
    public List<String> aso = new ArrayList();
    public boolean asH = false;
    public boolean asN = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean asO = false;
    public boolean asP = false;
    public boolean asR = false;
    public boolean asS = false;
    public boolean asT = false;
    public boolean asU = false;
    public int atj = 200;
    public int atk = 100;
    public int atl = 10;
    public int atm = 10;
    public int atn = 10;
    public int ato = 50;
    public int atp = 5;
    public int aty = 20;
    public int atz = 70;
    public int atA = 10000;
    public List<String> arj = new ArrayList();
    public List<String> arr = new ArrayList();
    public List<String> arm = new ArrayList();
    public List<Integer> arn = new ArrayList();
    public ArrayList<f> arh = new ArrayList<>();
    public ArrayList<f> ari = new ArrayList<>();

    public v(boolean z) {
        if (z) {
            uO();
            this.arq = com.baidu.live.c.tH().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.tH().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.tH().getInt("restart_time_interval", 300);
            uP();
            uN();
            uQ();
            uR();
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
                    p(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject3 != null) {
                    this.arq = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.tH().putInt("conn_conf", this.arq);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.arr.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.c.tH().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.c.tH().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    q(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    r(optJSONObject5);
                }
                this.arZ = jSONObject.optString("client_id");
                com.baidu.live.c.tH().putString("client_id", this.arZ);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.arf = optJSONObject6.optString("pic_url");
                    this.arg = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            f fVar = new f();
                            fVar.parseJson(optJSONObject8);
                            this.arh.add(fVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.tH().putString("pic_url", this.arf);
                com.baidu.live.c.tH().putString(BigdayActivityConfig.JUMP_URL, this.arg);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    s(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.asY = optJSONObject10.optInt("resource_switch");
                    this.ata = optJSONObject10.optString("photo_url");
                    this.asZ = optJSONObject10.optString("resource_url");
                }
                this.atb = new QuickImInputData();
                this.atb.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                JSONObject optJSONObject11 = jSONObject.optJSONObject("guide_follow");
                if (optJSONObject11 != null) {
                    t(optJSONObject11);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.tH().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject12 != null) {
                    JSONObject optJSONObject13 = optJSONObject12.optJSONObject("rank");
                    if (optJSONObject13 != null && (optJSONObject = optJSONObject13.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.c.tH().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.c.tH().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.c.tH().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject14 = optJSONObject12.optJSONObject("guard_seat");
                    if (optJSONObject14 != null) {
                        this.ats = optJSONObject14.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject15 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject15 != null) {
                    this.atq = new ac();
                    this.atq.aua = optJSONObject15.optString("certify_refuse_url");
                    com.baidu.live.c.tH().putString("ala_certify_refuse_url", this.atq.aua);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject16 != null) {
                    this.atu = new i();
                    this.atu.parserJson(optJSONObject16);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.tH().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void uN() {
        String string = com.baidu.live.c.tH().getString("ala_prepare_random_title_list", "");
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
            this.ati = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.ati.add(jSONArray.optString(i));
            }
        }
    }

    private void uO() {
        this.ara = com.baidu.live.c.tH().getBoolean("map_around_map", false);
        this.arF = com.baidu.live.c.tH().getBoolean("withdraw_switch", true);
        this.arX = com.baidu.live.c.tH().getString("withdraw_text", "");
        this.arQ = com.baidu.live.c.tH().getBoolean("use_internal_player_switch", true);
        this.arR = com.baidu.live.c.tH().getBoolean("live_beauty_open_switch", false);
        this.arS = com.baidu.live.c.tH().getBoolean("live_unity_beauty_switch", true);
        this.arT = com.baidu.live.c.tH().getBoolean("live_unity_beauty_face_style_switch", true);
        this.arU = com.baidu.live.c.tH().getBoolean("sp_key_live_game_hard_encode", true);
        this.arV = com.baidu.live.c.tH().getBoolean("sp_key_live_play_transcode_support", false);
        this.arW = com.baidu.live.c.tH().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.arY = com.baidu.live.c.tH().getBoolean("ala_enable_graffiti_str", false);
        this.arb = com.baidu.live.c.tH().getBoolean("enter_live", false);
        this.arc = com.baidu.live.c.tH().getBoolean("sync_to_forum", true);
        this.ard = com.baidu.live.c.tH().getBoolean("show_water_mark", false);
        this.are = com.baidu.live.c.tH().getBoolean("show_third_part_water_mark_switch", false);
        this.arx = com.baidu.live.c.tH().getBoolean("stream_error_log", true);
        this.ary = com.baidu.live.c.tH().getBoolean("disable_channel_in", true);
        this.arz = com.baidu.live.c.tH().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.arA = com.baidu.live.c.tH().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.arC = com.baidu.live.c.tH().getBoolean("follow_default_push_switch", true);
        this.asg = com.baidu.live.c.tH().getInt("to_tb_some_switch", 0);
        this.ase = com.baidu.live.c.tH().getInt("enable_live_stat", 1);
        this.asf = com.baidu.live.c.tH().getInt("ala_free_gift_task_switch", 0);
        this.asH = com.baidu.live.c.tH().getBoolean("live_challenge_switch", false);
        this.asI = com.baidu.live.c.tH().getString("live_challenge_tip", null);
        this.asJ = com.baidu.live.c.tH().getString("live_challenge_url", null);
    }

    private void p(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.ara = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.tH().putBoolean("map_around_map", this.ara);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.arF = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("withdraw_switch", this.arF);
                this.arX = optJSONObject2.optString("text");
                com.baidu.live.c.tH().putString("withdraw_text", this.arX);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.arQ = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("use_internal_player_switch", this.arQ);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject4 != null) {
                this.arR = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("live_beauty_open_switch", this.arR);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject5 != null) {
                this.arS = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("live_unity_beauty_switch", this.arS);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject6 != null) {
                this.arT = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("live_unity_beauty_face_style_switch", this.arT);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject7 != null) {
                this.arU = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("sp_key_live_game_hard_encode", this.arU);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject8 != null) {
                this.arV = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("sp_key_live_play_transcode_support", this.arV);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject9 != null) {
                this.arW = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("sp_key_live_play_attention_guide_support", this.arW);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject10 != null) {
                this.arb = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("enter_live", this.arb);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject11 != null) {
                this.arc = optJSONObject11.optString("switch").equals("1");
                com.baidu.live.c.tH().putBoolean("sync_to_forum", this.arc);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject12 != null) {
                this.ard = optJSONObject12.optString("switch").equals("1");
                com.baidu.live.c.tH().putBoolean("show_water_mark", this.ard);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject13 != null) {
                this.are = optJSONObject13.optString("switch").equals("1");
                com.baidu.live.c.tH().putBoolean("show_third_part_water_mark_switch", this.are);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject14 != null) {
                this.ase = optJSONObject14.optInt("switch");
                com.baidu.live.c.tH().putInt("enable_live_stat", this.ase);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject15 != null) {
                this.arx = optJSONObject15.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("stream_error_log", this.arx);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject16 != null) {
                this.ary = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.tH().putBoolean("disable_channel_in", this.ary);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject17 != null) {
                this.arz = optJSONObject17.optString("switch").equals("1");
                com.baidu.live.c.tH().putBoolean("shoubai_yanzhi_tab_tip", this.arz);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject18 != null) {
                this.arA = optJSONObject18.optString("switch").equals("1");
                com.baidu.live.c.tH().putBoolean(ActionJsonData.TAG_SIGN_IN, this.arA);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject19 != null) {
                this.arC = optJSONObject19.optString("switch").equals("2");
                com.baidu.live.c.tH().putBoolean("follow_default_push_switch", this.arC);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject20 != null) {
                this.asg = optJSONObject20.optInt("switch");
                com.baidu.live.c.tH().putInt("to_tb_some_switch", this.asg);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("task_config");
            if (optJSONObject21 != null) {
                this.asf = optJSONObject21.optInt("switch");
                com.baidu.live.c.tH().putInt("ala_free_gift_task_switch", this.asg);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject22 != null) {
                this.arY = optJSONObject22.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("ala_enable_graffiti_str", this.arY);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject23 != null) {
                this.asH = optJSONObject23.optInt("switch") == 1;
                this.asI = optJSONObject23.optString("title");
                this.asJ = optJSONObject23.optString("url");
                com.baidu.live.c.tH().putBoolean("live_challenge_switch", this.asH);
                com.baidu.live.c.tH().putString("live_challenge_tip", this.asI);
                com.baidu.live.c.tH().putString("live_challenge_url", this.asJ);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject24 != null) {
                this.asP = optJSONObject24.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("is_new_gift_t_dou_strategy", this.asP);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject25 != null) {
                this.asT = optJSONObject25.optInt("switch") == 1;
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject26 != null) {
                this.asR = optJSONObject26.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("key_is_open_login_prove", this.asR);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject27 != null) {
                this.asS = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("key_is_open_diamond", this.asS);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject28 != null) {
                this.asU = optJSONObject28.optInt("switch") == 1;
                com.baidu.live.c.tH().putBoolean("key_is_jump_to_live_room", this.asU);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject29 != null && (optInt2 = optJSONObject29.optInt("switch", -1)) >= 0) {
                this.atr = optInt2 == 1;
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject30 != null && (optInt = optJSONObject30.optInt("switch", -1)) >= 0) {
                this.atv = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void uP() {
        JSONArray jSONArray;
        this.arv = com.baidu.live.c.tH().getString("bluediamond_url", "");
        this.arl = com.baidu.live.c.tH().getString("verify_content", this.arl);
        this.ark = com.baidu.live.c.tH().getString("live_notice", "");
        String string = com.baidu.live.c.tH().getString("imNotice", "");
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
                        this.arj.add(i, optString);
                    }
                }
            }
        }
        this.asa = com.baidu.live.c.tH().getString("share_host", "");
        this.asb = com.baidu.live.c.tH().getString("ala_share_in_bar_notice_text", "");
        this.asd = com.baidu.live.c.tH().getString("ala_share_reward_rank_notice_text", "");
        this.asc = com.baidu.live.c.tH().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.arw = com.baidu.live.c.tH().getInt("recommend_refresh", 60);
        this.arD = com.baidu.live.c.tH().getString("strategy_conf", "300");
        this.arE = com.baidu.live.c.tH().getInt("strategy_exception_interval", 1);
        this.arB = com.baidu.live.c.tH().getInt("liveStartAuthLevel", 1);
        this.ars = com.baidu.live.c.tH().getInt("2gTo", 5);
        this.art = com.baidu.live.c.tH().getInt("3gTo", 3);
        this.aru = com.baidu.live.c.tH().getInt("wifiTo", 3);
        String string2 = com.baidu.live.c.tH().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aro = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.c.tH().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.arp = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.ash = com.baidu.live.c.tH().getInt("square_tab_strategy", 1);
        this.asi = com.baidu.live.c.tH().getString("ala_live_ranklist_url", null);
        this.asj = com.baidu.live.c.tH().getString("new_flower_rank_list_description_url", "");
        this.ask = com.baidu.live.c.tH().getString("ala_game_player_signup_url", null);
        this.asl = com.baidu.live.c.tH().getString("ala_game_frs_live_tab_video_url", null);
        uT();
        this.ast = com.baidu.live.c.tH().getString("ala_personal_income_detail_url", null);
        this.asM = com.baidu.live.c.tH().getInt("ala_custom_gift_category_id", -1);
        this.asu = com.baidu.live.c.tH().getInt("ala_live_pk_switch", 0) == 1;
        this.asv = com.baidu.live.c.tH().getLong("ala_live_pk_check_interval", 1000L);
        this.asw = com.baidu.live.c.tH().getLong("ala_live_pk_match_timeout", 60000L);
        this.asx = com.baidu.live.c.tH().getString("ala_live_pk_pic_url", "");
        this.asy = com.baidu.live.c.tH().getString("ala_live_pk_pic_jump_url", "");
        this.asz = com.baidu.live.c.tH().getString("ala_live_pk_history_link", "");
        this.asA = com.baidu.live.c.tH().getString("show_live_forum_url", "");
        this.asB = com.baidu.live.c.tH().getLong("ala_challenge_random_interval", 1000L);
        this.asC = com.baidu.live.c.tH().getLong("ala_challenge_direct_interval", 1000L);
        this.asD = com.baidu.live.c.tH().getLong("ala_get_challenge_info_interval", 1000L);
        this.asF = com.baidu.live.c.tH().getString("ala_challenge_pk_entry_icon_url", "");
        this.asG = com.baidu.live.c.tH().getString("ala_challenge_pk_entry_icon_url", "");
        this.asE = com.baidu.live.c.tH().getString("ala_challenge_pk_entry_icon_url", "");
        this.asN = com.baidu.live.c.tH().getBoolean("ala_guess_use_https", false);
        dP(com.baidu.live.c.tH().getString("ala_live_bar_map_str", ""));
        this.asO = com.baidu.live.c.tH().getBoolean("is_new_live_close_strategy", false);
        this.asP = com.baidu.live.c.tH().getBoolean("is_new_gift_t_dou_strategy", false);
        this.asQ = com.baidu.live.c.tH().getString("ala_feedback_url", null);
        this.arG = com.baidu.live.c.tH().getInt("ala_video_resolution_level", 3);
        this.arH = com.baidu.live.c.tH().getBoolean("ala_live_hard_encode_switch", true);
        this.arI = com.baidu.live.c.tH().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.tH().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.tH().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.tH().getInt("ala_video_increase_count", 3);
        this.arJ = com.baidu.live.c.tH().getString("ala_video_soft_bitrate_config", null);
        this.arK = com.baidu.live.c.tH().getString("ala_video_hard_bitrate_config", null);
        this.arO = com.baidu.live.c.tH().getInt("ala_master_chat_video_resolution_level", 3);
        this.arP = com.baidu.live.c.tH().getInt("ala_slave_chat_video_resolution_level", 4);
        this.arL = com.baidu.live.c.tH().getString("ala_avts_stream_server_domain_config", null);
        this.arM = com.baidu.live.c.tH().getString("ala_master_chat_video_bitrate_config", null);
        this.arN = com.baidu.live.c.tH().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.tH().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.tH().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.asR = com.baidu.live.c.tH().getBoolean("key_is_open_login_prove", false);
        this.asS = com.baidu.live.c.tH().getBoolean("key_is_open_diamond", false);
        this.asU = com.baidu.live.c.tH().getBoolean("key_is_jump_to_live_room", false);
        dN(com.baidu.live.c.tH().getString("feed_diversion", ""));
        uS();
    }

    private void dN(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.att = new AlaFeedDiversionData();
                this.att.parserJson(jSONObject);
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

    private void q(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject2 != null) {
                this.aqZ = optJSONObject2.optString("toast");
                this.aqY = optJSONObject2.optInt("remind_type");
            }
            this.arv = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.tH().putString("bluediamond_url", this.arv);
            this.arl = jSONObject.optString("verify_content");
            com.baidu.live.c.tH().putString("verify_content", this.arl);
            this.ark = jSONObject.optString("live_notice");
            com.baidu.live.c.tH().putString("live_notice", this.ark);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.arj.add(i, optString);
                    }
                }
                com.baidu.live.c.tH().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.c.tH().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.arm.add(i2, optString2);
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
                        this.ari.add(fVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.arn.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.asa = optJSONObject5.optString("url");
            } else {
                this.asa = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.asb = optJSONObject6.optString("reward_notice");
                this.asd = optJSONObject6.optString("reward_rank_notice");
                this.asc = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.asb = "";
                this.asd = "";
                this.asc = 2;
            }
            com.baidu.live.c.tH().putString("share_host", this.asa);
            com.baidu.live.c.tH().putString("ala_share_in_bar_notice_text", this.asb);
            com.baidu.live.c.tH().putString("ala_share_reward_rank_notice_text", this.asd);
            com.baidu.live.c.tH().putInt("ala_share_in_bar_notice_tip_switch", this.asc);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.arw = optJSONObject7.optInt("value");
            } else {
                this.arw = 60;
            }
            com.baidu.live.c.tH().putInt("recommend_refresh", this.arw);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.tH().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aro = g(optJSONArray5);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject9 != null) {
                JSONArray optJSONArray6 = optJSONObject9.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.tH().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.arp = g(optJSONArray6);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject10 != null) {
                this.arD = optJSONObject10.optString("time_interval");
                this.arE = optJSONObject10.optInt("exception_interval");
            } else {
                this.arD = "300";
                this.arE = 1;
            }
            com.baidu.live.c.tH().putString("strategy_conf", this.arD);
            com.baidu.live.c.tH().putInt("strategy_exception_interval", this.arE);
            this.arB = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.tH().putInt("liveStartAuthLevel", this.arB);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject11 != null) {
                this.ars = optJSONObject11.optInt("2gTo");
                if (this.ars < 3) {
                    this.ars = 3;
                }
                this.art = optJSONObject11.optInt("3gTo");
                if (this.art < 3) {
                    this.art = 3;
                }
                this.aru = optJSONObject11.optInt("wifiTo");
                if (this.aru < 3) {
                    this.aru = 3;
                }
                com.baidu.live.c.tH().putInt("2gTo", this.ars);
                com.baidu.live.c.tH().putInt("3gTo", this.art);
                com.baidu.live.c.tH().putInt("wifiTo", this.aru);
            }
            this.ash = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.tH().putInt("square_tab_strategy", this.ash);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject12 != null) {
                this.asi = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
                this.asj = optJSONObject12.optString("flower_rank_rule");
            }
            com.baidu.live.c.tH().putString("ala_live_ranklist_url", this.asi);
            com.baidu.live.c.tH().putString("new_flower_rank_list_description_url", this.asj);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject13 != null) {
                this.ask = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.tH().putString("ala_game_player_signup_url", this.ask);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject14 != null) {
                this.asl = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.tH().putString("ala_game_frs_live_tab_video_url", this.asl);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject15 != null) {
                this.asn = optJSONObject15.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.tH().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aso.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject16 != null) {
                com.baidu.live.c.tH().putString("ala_live_session_replace_key", optJSONObject16.toString());
                this.asr = optJSONObject16.optString("hlsUrl");
                this.asp = optJSONObject16.optString("rtmpUrl");
                this.asq = optJSONObject16.optString("flvUrl");
                this.ass = optJSONObject16.optString(".m3u8");
            }
            b(true, this.asn);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject17 != null) {
                this.ast = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.tH().putString("ala_personal_income_detail_url", this.ast);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject18 != null) {
                this.asM = optJSONObject18.optInt("android_show");
                com.baidu.live.c.tH().putInt("ala_custom_gift_category_id", this.asM);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject19 != null) {
                int optInt = optJSONObject19.optInt("open", 0);
                this.asu = optInt == 1;
                com.baidu.live.c.tH().putInt("ala_live_pk_switch", optInt);
                this.asv = optJSONObject19.optLong("interval");
                if (this.asv < 1000) {
                    this.asv = 1000L;
                }
                com.baidu.live.c.tH().putLong("ala_live_pk_check_interval", this.asv);
                this.asw = optJSONObject19.optLong("match_timeout");
                if (this.asw < 60000) {
                    this.asw = 60000L;
                }
                com.baidu.live.c.tH().putLong("ala_live_pk_match_timeout", this.asw);
                this.asx = optJSONObject19.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.tH().putString("ala_live_pk_pic_url", this.asx);
                this.asy = optJSONObject19.optString("rank_link");
                com.baidu.live.c.tH().putString("ala_live_pk_pic_jump_url", this.asy);
                this.asz = optJSONObject19.optString("history_link");
                com.baidu.live.c.tH().putString("ala_live_pk_history_link", this.asz);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject20 != null) {
                this.asB = optJSONObject20.optLong("random_interval");
                if (this.asB < 1000) {
                    this.asB = 1000L;
                }
                com.baidu.live.c.tH().putLong("ala_challenge_random_interval", this.asB);
                this.asC = optJSONObject20.optLong("direct_interval");
                if (this.asC < 1000) {
                    this.asC = 1000L;
                }
                com.baidu.live.c.tH().putLong("ala_challenge_direct_interval", this.asC);
                this.asD = optJSONObject20.optLong("challenge_info_interval");
                if (this.asD < 1000) {
                    this.asD = 1000L;
                }
                com.baidu.live.c.tH().putLong("ala_get_challenge_info_interval", this.asD);
                this.asF = optJSONObject20.optString("pk_icon_url");
                com.baidu.live.c.tH().putString("ala_challenge_pk_entry_icon_url", this.asF);
                this.asG = optJSONObject20.optString("icon_url");
                com.baidu.live.c.tH().putString("ala_challenge_pk_entry_icon_url", this.asG);
                this.asE = optJSONObject20.optString("rule_url");
                com.baidu.live.c.tH().putString("ala_challenge_pk_entry_icon_url", this.asE);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject21 != null) {
                this.asA = optJSONObject21.optString("go_url");
                com.baidu.live.c.tH().putString("show_live_forum_url", this.asA);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject22 != null) {
                this.asN = optJSONObject22.optInt("use_https", 0) == 1;
                com.baidu.live.c.tH().putBoolean("ala_guess_use_https", this.asN);
            }
            String optString3 = jSONObject.optString("live_bar");
            dP(optString3);
            com.baidu.live.c.tH().putString("ala_live_bar_map_str", optString3);
            this.asO = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.tH().putBoolean("is_new_live_close_strategy", this.asO);
            this.asP = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.tH().putBoolean("is_new_gift_t_dou_strategy", this.asP);
            this.asQ = jSONObject.optString("feedback_url");
            com.baidu.live.c.tH().putString("ala_feedback_url", this.asQ);
            JSONObject optJSONObject23 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject23 != null && (optJSONObject = optJSONObject23.optJSONObject("challenge_related_zip")) != null) {
                this.asK = optJSONObject.optString("zip_md5");
                this.asL = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject24 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject24.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject24.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.tH().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.tH().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("open_live");
            if (optJSONObject25 != null) {
                this.increaseThreshold = optJSONObject25.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.tH().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject25.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.tH().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject25.optInt("thi_count", 3);
                com.baidu.live.c.tH().putInt("ala_video_increase_count", this.increaseCount);
                this.arH = optJSONObject25.optInt("encoder", 1) == 1;
                com.baidu.live.c.tH().putBoolean("ala_live_hard_encode_switch", this.arH);
                this.arI = optJSONObject25.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.tH().putBoolean("ala_dynamic_bitrate_switch", this.arI);
                this.arG = optJSONObject25.optInt("resolution", 3);
                com.baidu.live.c.tH().putInt("ala_video_resolution_level", this.arG);
                JSONArray optJSONArray8 = optJSONObject25.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.arJ = optJSONArray8.toString();
                    com.baidu.live.c.tH().putString("ala_video_soft_bitrate_config", this.arJ);
                }
                JSONArray optJSONArray9 = optJSONObject25.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.arK = optJSONArray9.toString();
                    com.baidu.live.c.tH().putString("ala_video_hard_bitrate_config", this.arK);
                }
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject26 != null) {
                this.arL = optJSONObject26.toString();
                com.baidu.live.c.tH().putString("ala_avts_stream_server_domain_config", this.arL);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject27 != null) {
                this.arO = optJSONObject27.optInt("host_rtc_resolution", 3);
                com.baidu.live.c.tH().putInt("ala_master_chat_video_resolution_level", this.arO);
                this.arP = optJSONObject27.optInt("rtc_resolution", 4);
                com.baidu.live.c.tH().putInt("ala_slave_chat_video_resolution_level", this.arP);
                JSONArray optJSONArray10 = optJSONObject27.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.arM = optJSONArray10.toString();
                    com.baidu.live.c.tH().putString("ala_master_chat_video_bitrate_config", this.arM);
                }
                JSONArray optJSONArray11 = optJSONObject27.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.arN = optJSONArray11.toString();
                    com.baidu.live.c.tH().putString("ala_slave_chat_video_bitrate_config", this.arN);
                }
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject28 != null) {
                this.aty = optJSONObject28.optInt("enter_live_msg_audience_num_p1");
                this.atz = optJSONObject28.optInt("enter_live_msg_audience_num_p2");
                this.atA = optJSONObject28.optInt("enter_live_msg_audience_num_p3");
                this.atw = optJSONObject28.optInt("im_intercept_switch");
                this.atx = optJSONObject28.optInt("is_check_im_content");
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject29 != null) {
                this.att = new AlaFeedDiversionData();
                this.att.parserJson(optJSONObject29);
                com.baidu.live.c.tH().putString("feed_diversion", optJSONObject29.toString());
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject30 != null) {
                com.baidu.live.c.tH().putString("key_stat_switch", optJSONObject30.toString());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void r(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.atj = jSONObject.optInt("im_max", 200);
            if (this.atj <= 0) {
                this.atj = 200;
            }
            this.atk = jSONObject.optInt("barrage_max", 100);
            if (this.atk <= 0) {
                this.atk = 100;
            }
            this.atl = jSONObject.optInt("pay_barrage_max", 10);
            if (this.atl <= 0) {
                this.atl = 10;
            }
            this.atm = jSONObject.optInt("enter_effect_max", 10);
            if (this.atm <= 0) {
                this.atm = 10;
            }
            this.atn = jSONObject.optInt("gift_big_max", 10);
            if (this.atn <= 0) {
                this.atn = 10;
            }
            this.ato = jSONObject.optInt("gift_small_max", 50);
            if (this.ato <= 0) {
                this.ato = 50;
            }
            this.atp = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.atp <= 0) {
                this.atp = 5;
            }
        }
    }

    private void uQ() {
        this.asV = com.baidu.live.c.tH().getInt("guide_speak_watch_time", 15000);
        this.asW = com.baidu.live.c.tH().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.tH().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.asX = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.asX[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s(JSONObject jSONObject) {
        int length;
        this.asV = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.c.tH().putInt("guide_speak_watch_time", this.asV);
        this.asW = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.tH().putInt("guide_speak_show_times_max", this.asW);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.asX = new String[length];
            for (int i = 0; i < length; i++) {
                this.asX[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.tH().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void t(JSONObject jSONObject) {
        this.atd = jSONObject.optInt("supernatant_time") * 1000;
        this.ate = jSONObject.optInt("suoernatant_shownum");
        this.atf = jSONObject.optInt("pop_window_time") * 1000;
    }

    private void uR() {
        String string = com.baidu.live.c.tH().getString("yuan_package_data", "");
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
            this.atc = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.atc.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void dO(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.atg = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.atg.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.ath = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.ath.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.tH().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void uS() {
        dO(com.baidu.live.c.tH().getString("ala_quick_send_im_list", null));
    }

    private void dP(String str) {
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
        if (i != this.asn) {
            z2 = true;
        }
        this.asn = i;
        if (z || z2) {
            com.baidu.live.c.tH().putInt("ala_live_session_default_key", i);
        }
    }

    private void uT() {
        this.asn = com.baidu.live.c.tH().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.tH().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aso.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.tH().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.asr = jSONObject.optString("hlsUrl");
                this.asp = jSONObject.optString("rtmpUrl");
                this.asq = jSONObject.optString("flvUrl");
                this.ass = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean uU() {
        return this.asf == 1;
    }
}
