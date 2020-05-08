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
    public int arA;
    public String arB;
    public int arC;
    public boolean arD;
    public boolean arE;
    public boolean arF;
    public boolean arG;
    public boolean arI;
    public String arJ;
    public int arK;
    public boolean arL;
    public int arM;
    public boolean arN;
    public boolean arO;
    public String arP;
    public String arQ;
    public String arR;
    public String arS;
    public String arT;
    public int arU;
    public int arV;
    public boolean arW;
    public boolean arX;
    public boolean arY;
    public boolean arZ;
    public boolean arg;
    public boolean arh;
    public boolean ari;
    public boolean arj;
    public boolean ark;
    public String arl;
    public String arm;
    public String arq;
    public String arr;
    public Integer[] aru;
    public Integer[] arv;
    public int arw;
    public int ary;
    public int arz;
    public boolean asA;
    public long asB;
    public long asC;
    public String asD;
    public String asE;
    public String asF;
    public String asG;
    public long asH;
    public long asI;
    public long asJ;
    public String asK;
    public String asL;
    public String asM;
    public String asO;
    public String asP;
    public String asQ;
    public String asR;
    public int asS;
    public String asW;
    public String asd;
    public String asf;
    public String asg;
    public int asn;
    public String asp;
    public String asq;
    private String asr;
    private String ass;
    public int ast;
    public String asv;
    public String asw;
    public String asx;
    public String asy;
    public String asz;
    public i atA;
    public boolean atB;
    public int atC;
    public int atD;
    public int atb;
    public int atc;
    public String[] atd;
    public int ate;
    public String atf;
    public String atg;
    public QuickImInputData ath;
    public List<YuanPackageData> ati;
    public int atj;
    public int atk;
    public int atl;
    public List<String> atm;
    public List<String> atn;
    public List<String> ato;
    public ac atw;
    public boolean atx;
    public String aty;
    public AlaFeedDiversionData atz;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int are = -1;
    public String arf = null;
    public int arH = 1;
    public boolean asa = true;
    public boolean asb = false;
    public boolean asc = false;
    public boolean ase = false;
    public String ash = "";
    private int asi = 2;
    public String asj = "";
    public int ask = 1;
    public int asl = 0;
    public int aso = 1;
    public List<String> asu = new ArrayList();
    public boolean asN = false;
    public boolean asT = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean asU = false;
    public boolean asV = false;
    public boolean asX = false;
    public boolean asY = false;
    public boolean asZ = false;
    public boolean ata = false;
    public int atp = 200;
    public int atq = 100;
    public int atr = 10;
    public int ats = 10;
    public int att = 10;
    public int atu = 50;
    public int atv = 5;
    public int atE = 20;
    public int atF = 70;
    public int atG = 10000;
    public List<String> arp = new ArrayList();
    public List<String> arx = new ArrayList();
    public List<String> ars = new ArrayList();
    public List<Integer> art = new ArrayList();
    public ArrayList<f> arn = new ArrayList<>();
    public ArrayList<f> aro = new ArrayList<>();

    public v(boolean z) {
        if (z) {
            uN();
            this.arw = com.baidu.live.c.tG().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.c.tG().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.c.tG().getInt("restart_time_interval", 300);
            uO();
            uM();
            uP();
            uQ();
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
                    this.arw = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.c.tG().putInt("conn_conf", this.arw);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.arx.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.c.tG().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.c.tG().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    q(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    r(optJSONObject5);
                }
                this.asf = jSONObject.optString("client_id");
                com.baidu.live.c.tG().putString("client_id", this.asf);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.arl = optJSONObject6.optString("pic_url");
                    this.arm = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            f fVar = new f();
                            fVar.parseJson(optJSONObject8);
                            this.arn.add(fVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.c.tG().putString("pic_url", this.arl);
                com.baidu.live.c.tG().putString(BigdayActivityConfig.JUMP_URL, this.arm);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    s(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.ate = optJSONObject10.optInt("resource_switch");
                    this.atg = optJSONObject10.optString("photo_url");
                    this.atf = optJSONObject10.optString("resource_url");
                }
                this.ath = new QuickImInputData();
                this.ath.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                JSONObject optJSONObject11 = jSONObject.optJSONObject("guide_follow");
                if (optJSONObject11 != null) {
                    t(optJSONObject11);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.c.tG().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject12 != null) {
                    JSONObject optJSONObject13 = optJSONObject12.optJSONObject("rank");
                    if (optJSONObject13 != null && (optJSONObject = optJSONObject13.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.c.tG().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.c.tG().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.c.tG().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject14 = optJSONObject12.optJSONObject("guard_seat");
                    if (optJSONObject14 != null) {
                        this.aty = optJSONObject14.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject15 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject15 != null) {
                    this.atw = new ac();
                    this.atw.aug = optJSONObject15.optString("certify_refuse_url");
                    com.baidu.live.c.tG().putString("ala_certify_refuse_url", this.atw.aug);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject16 != null) {
                    this.atA = new i();
                    this.atA.parserJson(optJSONObject16);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.c.tG().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void uM() {
        String string = com.baidu.live.c.tG().getString("ala_prepare_random_title_list", "");
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
            this.ato = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.ato.add(jSONArray.optString(i));
            }
        }
    }

    private void uN() {
        this.arg = com.baidu.live.c.tG().getBoolean("map_around_map", false);
        this.arL = com.baidu.live.c.tG().getBoolean("withdraw_switch", true);
        this.asd = com.baidu.live.c.tG().getString("withdraw_text", "");
        this.arW = com.baidu.live.c.tG().getBoolean("use_internal_player_switch", true);
        this.arX = com.baidu.live.c.tG().getBoolean("live_beauty_open_switch", false);
        this.arY = com.baidu.live.c.tG().getBoolean("live_unity_beauty_switch", true);
        this.arZ = com.baidu.live.c.tG().getBoolean("live_unity_beauty_face_style_switch", true);
        this.asa = com.baidu.live.c.tG().getBoolean("sp_key_live_game_hard_encode", true);
        this.asb = com.baidu.live.c.tG().getBoolean("sp_key_live_play_transcode_support", false);
        this.asc = com.baidu.live.c.tG().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.ase = com.baidu.live.c.tG().getBoolean("ala_enable_graffiti_str", false);
        this.arh = com.baidu.live.c.tG().getBoolean("enter_live", false);
        this.ari = com.baidu.live.c.tG().getBoolean("sync_to_forum", true);
        this.arj = com.baidu.live.c.tG().getBoolean("show_water_mark", false);
        this.ark = com.baidu.live.c.tG().getBoolean("show_third_part_water_mark_switch", false);
        this.arD = com.baidu.live.c.tG().getBoolean("stream_error_log", true);
        this.arE = com.baidu.live.c.tG().getBoolean("disable_channel_in", true);
        this.arF = com.baidu.live.c.tG().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.arG = com.baidu.live.c.tG().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.arI = com.baidu.live.c.tG().getBoolean("follow_default_push_switch", true);
        this.asn = com.baidu.live.c.tG().getInt("to_tb_some_switch", 0);
        this.ask = com.baidu.live.c.tG().getInt("enable_live_stat", 1);
        this.asl = com.baidu.live.c.tG().getInt("ala_free_gift_task_switch", 0);
        this.asN = com.baidu.live.c.tG().getBoolean("live_challenge_switch", false);
        this.asO = com.baidu.live.c.tG().getString("live_challenge_tip", null);
        this.asP = com.baidu.live.c.tG().getString("live_challenge_url", null);
    }

    private void p(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.arg = optJSONObject.optInt("switch") != 1;
                com.baidu.live.c.tG().putBoolean("map_around_map", this.arg);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.arL = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("withdraw_switch", this.arL);
                this.asd = optJSONObject2.optString("text");
                com.baidu.live.c.tG().putString("withdraw_text", this.asd);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.arW = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("use_internal_player_switch", this.arW);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject4 != null) {
                this.arX = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("live_beauty_open_switch", this.arX);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject5 != null) {
                this.arY = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("live_unity_beauty_switch", this.arY);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject6 != null) {
                this.arZ = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("live_unity_beauty_face_style_switch", this.arZ);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject7 != null) {
                this.asa = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("sp_key_live_game_hard_encode", this.asa);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject8 != null) {
                this.asb = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("sp_key_live_play_transcode_support", this.asb);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject9 != null) {
                this.asc = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("sp_key_live_play_attention_guide_support", this.asc);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject10 != null) {
                this.arh = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("enter_live", this.arh);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject11 != null) {
                this.ari = optJSONObject11.optString("switch").equals("1");
                com.baidu.live.c.tG().putBoolean("sync_to_forum", this.ari);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject12 != null) {
                this.arj = optJSONObject12.optString("switch").equals("1");
                com.baidu.live.c.tG().putBoolean("show_water_mark", this.arj);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject13 != null) {
                this.ark = optJSONObject13.optString("switch").equals("1");
                com.baidu.live.c.tG().putBoolean("show_third_part_water_mark_switch", this.ark);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject14 != null) {
                this.ask = optJSONObject14.optInt("switch");
                com.baidu.live.c.tG().putInt("enable_live_stat", this.ask);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject15 != null) {
                this.arD = optJSONObject15.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("stream_error_log", this.arD);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject16 != null) {
                this.arE = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.c.tG().putBoolean("disable_channel_in", this.arE);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject17 != null) {
                this.arF = optJSONObject17.optString("switch").equals("1");
                com.baidu.live.c.tG().putBoolean("shoubai_yanzhi_tab_tip", this.arF);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject18 != null) {
                this.arG = optJSONObject18.optString("switch").equals("1");
                com.baidu.live.c.tG().putBoolean(ActionJsonData.TAG_SIGN_IN, this.arG);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject19 != null) {
                this.arI = optJSONObject19.optString("switch").equals("2");
                com.baidu.live.c.tG().putBoolean("follow_default_push_switch", this.arI);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject20 != null) {
                this.asn = optJSONObject20.optInt("switch");
                com.baidu.live.c.tG().putInt("to_tb_some_switch", this.asn);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("task_config");
            if (optJSONObject21 != null) {
                this.asl = optJSONObject21.optInt("switch");
                com.baidu.live.c.tG().putInt("ala_free_gift_task_switch", this.asn);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject22 != null) {
                this.ase = optJSONObject22.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("ala_enable_graffiti_str", this.ase);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject23 != null) {
                this.asN = optJSONObject23.optInt("switch") == 1;
                this.asO = optJSONObject23.optString("title");
                this.asP = optJSONObject23.optString("url");
                com.baidu.live.c.tG().putBoolean("live_challenge_switch", this.asN);
                com.baidu.live.c.tG().putString("live_challenge_tip", this.asO);
                com.baidu.live.c.tG().putString("live_challenge_url", this.asP);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject24 != null) {
                this.asV = optJSONObject24.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("is_new_gift_t_dou_strategy", this.asV);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject25 != null) {
                this.asZ = optJSONObject25.optInt("switch") == 1;
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject26 != null) {
                this.asX = optJSONObject26.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("key_is_open_login_prove", this.asX);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject27 != null) {
                this.asY = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("key_is_open_diamond", this.asY);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject28 != null) {
                this.ata = optJSONObject28.optInt("switch") == 1;
                com.baidu.live.c.tG().putBoolean("key_is_jump_to_live_room", this.ata);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject29 != null && (optInt2 = optJSONObject29.optInt("switch", -1)) >= 0) {
                this.atx = optInt2 == 1;
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject30 != null && (optInt = optJSONObject30.optInt("switch", -1)) >= 0) {
                this.atB = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void uO() {
        JSONArray jSONArray;
        this.arB = com.baidu.live.c.tG().getString("bluediamond_url", "");
        this.arr = com.baidu.live.c.tG().getString("verify_content", this.arr);
        this.arq = com.baidu.live.c.tG().getString("live_notice", "");
        String string = com.baidu.live.c.tG().getString("imNotice", "");
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
                        this.arp.add(i, optString);
                    }
                }
            }
        }
        this.asg = com.baidu.live.c.tG().getString("share_host", "");
        this.ash = com.baidu.live.c.tG().getString("ala_share_in_bar_notice_text", "");
        this.asj = com.baidu.live.c.tG().getString("ala_share_reward_rank_notice_text", "");
        this.asi = com.baidu.live.c.tG().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.arC = com.baidu.live.c.tG().getInt("recommend_refresh", 60);
        this.arJ = com.baidu.live.c.tG().getString("strategy_conf", "300");
        this.arK = com.baidu.live.c.tG().getInt("strategy_exception_interval", 1);
        this.arH = com.baidu.live.c.tG().getInt("liveStartAuthLevel", 1);
        this.ary = com.baidu.live.c.tG().getInt("2gTo", 5);
        this.arz = com.baidu.live.c.tG().getInt("3gTo", 3);
        this.arA = com.baidu.live.c.tG().getInt("wifiTo", 3);
        String string2 = com.baidu.live.c.tG().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aru = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.c.tG().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.arv = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aso = com.baidu.live.c.tG().getInt("square_tab_strategy", 1);
        this.asp = com.baidu.live.c.tG().getString("ala_live_ranklist_url", null);
        this.asq = com.baidu.live.c.tG().getString("new_flower_rank_list_description_url", "");
        this.asr = com.baidu.live.c.tG().getString("ala_game_player_signup_url", null);
        this.ass = com.baidu.live.c.tG().getString("ala_game_frs_live_tab_video_url", null);
        uS();
        this.asz = com.baidu.live.c.tG().getString("ala_personal_income_detail_url", null);
        this.asS = com.baidu.live.c.tG().getInt("ala_custom_gift_category_id", -1);
        this.asA = com.baidu.live.c.tG().getInt("ala_live_pk_switch", 0) == 1;
        this.asB = com.baidu.live.c.tG().getLong("ala_live_pk_check_interval", 1000L);
        this.asC = com.baidu.live.c.tG().getLong("ala_live_pk_match_timeout", 60000L);
        this.asD = com.baidu.live.c.tG().getString("ala_live_pk_pic_url", "");
        this.asE = com.baidu.live.c.tG().getString("ala_live_pk_pic_jump_url", "");
        this.asF = com.baidu.live.c.tG().getString("ala_live_pk_history_link", "");
        this.asG = com.baidu.live.c.tG().getString("show_live_forum_url", "");
        this.asH = com.baidu.live.c.tG().getLong("ala_challenge_random_interval", 1000L);
        this.asI = com.baidu.live.c.tG().getLong("ala_challenge_direct_interval", 1000L);
        this.asJ = com.baidu.live.c.tG().getLong("ala_get_challenge_info_interval", 1000L);
        this.asL = com.baidu.live.c.tG().getString("ala_challenge_pk_entry_icon_url", "");
        this.asM = com.baidu.live.c.tG().getString("ala_challenge_pk_entry_icon_url", "");
        this.asK = com.baidu.live.c.tG().getString("ala_challenge_pk_entry_icon_url", "");
        this.asT = com.baidu.live.c.tG().getBoolean("ala_guess_use_https", false);
        dP(com.baidu.live.c.tG().getString("ala_live_bar_map_str", ""));
        this.asU = com.baidu.live.c.tG().getBoolean("is_new_live_close_strategy", false);
        this.asV = com.baidu.live.c.tG().getBoolean("is_new_gift_t_dou_strategy", false);
        this.asW = com.baidu.live.c.tG().getString("ala_feedback_url", null);
        this.arM = com.baidu.live.c.tG().getInt("ala_video_resolution_level", 3);
        this.arN = com.baidu.live.c.tG().getBoolean("ala_live_hard_encode_switch", true);
        this.arO = com.baidu.live.c.tG().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.c.tG().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.c.tG().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.c.tG().getInt("ala_video_increase_count", 3);
        this.arP = com.baidu.live.c.tG().getString("ala_video_soft_bitrate_config", null);
        this.arQ = com.baidu.live.c.tG().getString("ala_video_hard_bitrate_config", null);
        this.arU = com.baidu.live.c.tG().getInt("ala_master_chat_video_resolution_level", 3);
        this.arV = com.baidu.live.c.tG().getInt("ala_slave_chat_video_resolution_level", 4);
        this.arR = com.baidu.live.c.tG().getString("ala_avts_stream_server_domain_config", null);
        this.arS = com.baidu.live.c.tG().getString("ala_master_chat_video_bitrate_config", null);
        this.arT = com.baidu.live.c.tG().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.c.tG().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.c.tG().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.asX = com.baidu.live.c.tG().getBoolean("key_is_open_login_prove", false);
        this.asY = com.baidu.live.c.tG().getBoolean("key_is_open_diamond", false);
        this.ata = com.baidu.live.c.tG().getBoolean("key_is_jump_to_live_room", false);
        dN(com.baidu.live.c.tG().getString("feed_diversion", ""));
        uR();
    }

    private void dN(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.atz = new AlaFeedDiversionData();
                this.atz.parserJson(jSONObject);
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
                this.arf = optJSONObject2.optString("toast");
                this.are = optJSONObject2.optInt("remind_type");
            }
            this.arB = jSONObject.optString("bluediamond_url");
            com.baidu.live.c.tG().putString("bluediamond_url", this.arB);
            this.arr = jSONObject.optString("verify_content");
            com.baidu.live.c.tG().putString("verify_content", this.arr);
            this.arq = jSONObject.optString("live_notice");
            com.baidu.live.c.tG().putString("live_notice", this.arq);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.arp.add(i, optString);
                    }
                }
                com.baidu.live.c.tG().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.c.tG().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.ars.add(i2, optString2);
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
                        this.aro.add(fVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.art.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("share_host");
            if (optJSONObject5 != null) {
                this.asg = optJSONObject5.optString("url");
            } else {
                this.asg = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject6 != null) {
                this.ash = optJSONObject6.optString("reward_notice");
                this.asj = optJSONObject6.optString("reward_rank_notice");
                this.asi = optJSONObject6.optInt("reward_switch", 2);
            } else {
                this.ash = "";
                this.asj = "";
                this.asi = 2;
            }
            com.baidu.live.c.tG().putString("share_host", this.asg);
            com.baidu.live.c.tG().putString("ala_share_in_bar_notice_text", this.ash);
            com.baidu.live.c.tG().putString("ala_share_reward_rank_notice_text", this.asj);
            com.baidu.live.c.tG().putInt("ala_share_in_bar_notice_tip_switch", this.asi);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject7 != null) {
                this.arC = optJSONObject7.optInt("value");
            } else {
                this.arC = 60;
            }
            com.baidu.live.c.tG().putInt("recommend_refresh", this.arC);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject8 != null) {
                JSONArray optJSONArray5 = optJSONObject8.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.c.tG().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aru = g(optJSONArray5);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject9 != null) {
                JSONArray optJSONArray6 = optJSONObject9.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.c.tG().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.arv = g(optJSONArray6);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject10 != null) {
                this.arJ = optJSONObject10.optString("time_interval");
                this.arK = optJSONObject10.optInt("exception_interval");
            } else {
                this.arJ = "300";
                this.arK = 1;
            }
            com.baidu.live.c.tG().putString("strategy_conf", this.arJ);
            com.baidu.live.c.tG().putInt("strategy_exception_interval", this.arK);
            this.arH = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.c.tG().putInt("liveStartAuthLevel", this.arH);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject11 != null) {
                this.ary = optJSONObject11.optInt("2gTo");
                if (this.ary < 3) {
                    this.ary = 3;
                }
                this.arz = optJSONObject11.optInt("3gTo");
                if (this.arz < 3) {
                    this.arz = 3;
                }
                this.arA = optJSONObject11.optInt("wifiTo");
                if (this.arA < 3) {
                    this.arA = 3;
                }
                com.baidu.live.c.tG().putInt("2gTo", this.ary);
                com.baidu.live.c.tG().putInt("3gTo", this.arz);
                com.baidu.live.c.tG().putInt("wifiTo", this.arA);
            }
            this.aso = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.c.tG().putInt("square_tab_strategy", this.aso);
            JSONObject optJSONObject12 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject12 != null) {
                this.asp = optJSONObject12.optString(BigdayActivityConfig.JUMP_URL);
                this.asq = optJSONObject12.optString("flower_rank_rule");
            }
            com.baidu.live.c.tG().putString("ala_live_ranklist_url", this.asp);
            com.baidu.live.c.tG().putString("new_flower_rank_list_description_url", this.asq);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject13 != null) {
                this.asr = optJSONObject13.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.c.tG().putString("ala_game_player_signup_url", this.asr);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject14 != null) {
                this.ass = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.tG().putString("ala_game_frs_live_tab_video_url", this.ass);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject15 != null) {
                this.ast = optJSONObject15.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.c.tG().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.asu.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject16 != null) {
                com.baidu.live.c.tG().putString("ala_live_session_replace_key", optJSONObject16.toString());
                this.asx = optJSONObject16.optString("hlsUrl");
                this.asv = optJSONObject16.optString("rtmpUrl");
                this.asw = optJSONObject16.optString("flvUrl");
                this.asy = optJSONObject16.optString(".m3u8");
            }
            b(true, this.ast);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject17 != null) {
                this.asz = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.c.tG().putString("ala_personal_income_detail_url", this.asz);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject18 != null) {
                this.asS = optJSONObject18.optInt("android_show");
                com.baidu.live.c.tG().putInt("ala_custom_gift_category_id", this.asS);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject19 != null) {
                int optInt = optJSONObject19.optInt("open", 0);
                this.asA = optInt == 1;
                com.baidu.live.c.tG().putInt("ala_live_pk_switch", optInt);
                this.asB = optJSONObject19.optLong("interval");
                if (this.asB < 1000) {
                    this.asB = 1000L;
                }
                com.baidu.live.c.tG().putLong("ala_live_pk_check_interval", this.asB);
                this.asC = optJSONObject19.optLong("match_timeout");
                if (this.asC < 60000) {
                    this.asC = 60000L;
                }
                com.baidu.live.c.tG().putLong("ala_live_pk_match_timeout", this.asC);
                this.asD = optJSONObject19.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.c.tG().putString("ala_live_pk_pic_url", this.asD);
                this.asE = optJSONObject19.optString("rank_link");
                com.baidu.live.c.tG().putString("ala_live_pk_pic_jump_url", this.asE);
                this.asF = optJSONObject19.optString("history_link");
                com.baidu.live.c.tG().putString("ala_live_pk_history_link", this.asF);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject20 != null) {
                this.asH = optJSONObject20.optLong("random_interval");
                if (this.asH < 1000) {
                    this.asH = 1000L;
                }
                com.baidu.live.c.tG().putLong("ala_challenge_random_interval", this.asH);
                this.asI = optJSONObject20.optLong("direct_interval");
                if (this.asI < 1000) {
                    this.asI = 1000L;
                }
                com.baidu.live.c.tG().putLong("ala_challenge_direct_interval", this.asI);
                this.asJ = optJSONObject20.optLong("challenge_info_interval");
                if (this.asJ < 1000) {
                    this.asJ = 1000L;
                }
                com.baidu.live.c.tG().putLong("ala_get_challenge_info_interval", this.asJ);
                this.asL = optJSONObject20.optString("pk_icon_url");
                com.baidu.live.c.tG().putString("ala_challenge_pk_entry_icon_url", this.asL);
                this.asM = optJSONObject20.optString("icon_url");
                com.baidu.live.c.tG().putString("ala_challenge_pk_entry_icon_url", this.asM);
                this.asK = optJSONObject20.optString("rule_url");
                com.baidu.live.c.tG().putString("ala_challenge_pk_entry_icon_url", this.asK);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject21 != null) {
                this.asG = optJSONObject21.optString("go_url");
                com.baidu.live.c.tG().putString("show_live_forum_url", this.asG);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject22 != null) {
                this.asT = optJSONObject22.optInt("use_https", 0) == 1;
                com.baidu.live.c.tG().putBoolean("ala_guess_use_https", this.asT);
            }
            String optString3 = jSONObject.optString("live_bar");
            dP(optString3);
            com.baidu.live.c.tG().putString("ala_live_bar_map_str", optString3);
            this.asU = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.c.tG().putBoolean("is_new_live_close_strategy", this.asU);
            this.asV = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.c.tG().putBoolean("is_new_gift_t_dou_strategy", this.asV);
            this.asW = jSONObject.optString("feedback_url");
            com.baidu.live.c.tG().putString("ala_feedback_url", this.asW);
            JSONObject optJSONObject23 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject23 != null && (optJSONObject = optJSONObject23.optJSONObject("challenge_related_zip")) != null) {
                this.asQ = optJSONObject.optString("zip_md5");
                this.asR = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject24 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject24.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject24.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.c.tG().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.c.tG().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("open_live");
            if (optJSONObject25 != null) {
                this.increaseThreshold = optJSONObject25.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.c.tG().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject25.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.c.tG().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject25.optInt("thi_count", 3);
                com.baidu.live.c.tG().putInt("ala_video_increase_count", this.increaseCount);
                this.arN = optJSONObject25.optInt("encoder", 1) == 1;
                com.baidu.live.c.tG().putBoolean("ala_live_hard_encode_switch", this.arN);
                this.arO = optJSONObject25.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.c.tG().putBoolean("ala_dynamic_bitrate_switch", this.arO);
                this.arM = optJSONObject25.optInt("resolution", 3);
                com.baidu.live.c.tG().putInt("ala_video_resolution_level", this.arM);
                JSONArray optJSONArray8 = optJSONObject25.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.arP = optJSONArray8.toString();
                    com.baidu.live.c.tG().putString("ala_video_soft_bitrate_config", this.arP);
                }
                JSONArray optJSONArray9 = optJSONObject25.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.arQ = optJSONArray9.toString();
                    com.baidu.live.c.tG().putString("ala_video_hard_bitrate_config", this.arQ);
                }
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject26 != null) {
                this.arR = optJSONObject26.toString();
                com.baidu.live.c.tG().putString("ala_avts_stream_server_domain_config", this.arR);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject27 != null) {
                this.arU = optJSONObject27.optInt("host_rtc_resolution", 3);
                com.baidu.live.c.tG().putInt("ala_master_chat_video_resolution_level", this.arU);
                this.arV = optJSONObject27.optInt("rtc_resolution", 4);
                com.baidu.live.c.tG().putInt("ala_slave_chat_video_resolution_level", this.arV);
                JSONArray optJSONArray10 = optJSONObject27.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.arS = optJSONArray10.toString();
                    com.baidu.live.c.tG().putString("ala_master_chat_video_bitrate_config", this.arS);
                }
                JSONArray optJSONArray11 = optJSONObject27.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.arT = optJSONArray11.toString();
                    com.baidu.live.c.tG().putString("ala_slave_chat_video_bitrate_config", this.arT);
                }
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject28 != null) {
                this.atE = optJSONObject28.optInt("enter_live_msg_audience_num_p1");
                this.atF = optJSONObject28.optInt("enter_live_msg_audience_num_p2");
                this.atG = optJSONObject28.optInt("enter_live_msg_audience_num_p3");
                this.atC = optJSONObject28.optInt("im_intercept_switch");
                this.atD = optJSONObject28.optInt("is_check_im_content");
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject29 != null) {
                this.atz = new AlaFeedDiversionData();
                this.atz.parserJson(optJSONObject29);
                com.baidu.live.c.tG().putString("feed_diversion", optJSONObject29.toString());
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject30 != null) {
                com.baidu.live.c.tG().putString("key_stat_switch", optJSONObject30.toString());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void r(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.atp = jSONObject.optInt("im_max", 200);
            if (this.atp <= 0) {
                this.atp = 200;
            }
            this.atq = jSONObject.optInt("barrage_max", 100);
            if (this.atq <= 0) {
                this.atq = 100;
            }
            this.atr = jSONObject.optInt("pay_barrage_max", 10);
            if (this.atr <= 0) {
                this.atr = 10;
            }
            this.ats = jSONObject.optInt("enter_effect_max", 10);
            if (this.ats <= 0) {
                this.ats = 10;
            }
            this.att = jSONObject.optInt("gift_big_max", 10);
            if (this.att <= 0) {
                this.att = 10;
            }
            this.atu = jSONObject.optInt("gift_small_max", 50);
            if (this.atu <= 0) {
                this.atu = 50;
            }
            this.atv = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.atv <= 0) {
                this.atv = 5;
            }
        }
    }

    private void uP() {
        this.atb = com.baidu.live.c.tG().getInt("guide_speak_watch_time", 15000);
        this.atc = com.baidu.live.c.tG().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.c.tG().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.atd = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.atd[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s(JSONObject jSONObject) {
        int length;
        this.atb = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.c.tG().putInt("guide_speak_watch_time", this.atb);
        this.atc = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.c.tG().putInt("guide_speak_show_times_max", this.atc);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.atd = new String[length];
            for (int i = 0; i < length; i++) {
                this.atd[i] = optJSONArray.optString(i);
            }
            com.baidu.live.c.tG().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void t(JSONObject jSONObject) {
        this.atj = jSONObject.optInt("supernatant_time") * 1000;
        this.atk = jSONObject.optInt("suoernatant_shownum");
        this.atl = jSONObject.optInt("pop_window_time") * 1000;
    }

    private void uQ() {
        String string = com.baidu.live.c.tG().getString("yuan_package_data", "");
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
            this.ati = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.ati.add(yuanPackageData);
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
                        this.atm = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.atm.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.atn = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.atn.add(str3);
                            }
                        }
                    }
                    com.baidu.live.c.tG().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void uR() {
        dO(com.baidu.live.c.tG().getString("ala_quick_send_im_list", null));
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
        if (i != this.ast) {
            z2 = true;
        }
        this.ast = i;
        if (z || z2) {
            com.baidu.live.c.tG().putInt("ala_live_session_default_key", i);
        }
    }

    private void uS() {
        this.ast = com.baidu.live.c.tG().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.c.tG().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.asu.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.c.tG().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.asx = jSONObject.optString("hlsUrl");
                this.asv = jSONObject.optString("rtmpUrl");
                this.asw = jSONObject.optString("flvUrl");
                this.asy = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean uT() {
        return this.asl == 1;
    }
}
