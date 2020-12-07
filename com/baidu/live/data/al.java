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
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class al extends BaseData {
    public boolean aLN;
    public boolean aLO;
    public boolean aLP;
    public boolean aLQ;
    public boolean aLR;
    public String aLS;
    public String aLT;
    public String aLX;
    public String aLY;
    public String aLZ;
    public String aMA;
    public String aMB;
    public String aMC;
    public String aMD;
    public int aME;
    public int aMF;
    public String aMG;
    public boolean aMH;
    public boolean aMI;
    public boolean aMJ;
    public boolean aMK;
    public boolean aML;
    public boolean aMM;
    public boolean aMN;
    public String aMR;
    public String aMT;
    public String aMU;
    public String aMa;
    public Integer[] aMd;
    public Integer[] aMe;
    public int aMf;
    public int aMh;
    public int aMi;
    public int aMj;
    public String aMk;
    public int aMl;
    public boolean aMm;
    public boolean aMn;
    public boolean aMo;
    public boolean aMp;
    public boolean aMr;
    public String aMs;
    public int aMt;
    public boolean aMu;
    public int aMv;
    public int aMw;
    public boolean aMx;
    public boolean aMy;
    public String aMz;
    public int aNA;
    public int aNB;
    public int aNC;
    public String aNJ;
    public String aNK;
    public String aNL;
    public String aNM;
    public int aNN;
    public String aNR;
    public int aNW;
    public int aNX;
    public String[] aNY;
    public int aNZ;
    public int aNa;
    public String aNc;
    public String aNd;
    private String aNe;
    private String aNf;
    public int aNg;
    public String aNi;
    public String aNj;
    public String aNk;
    public String aNl;
    public String aNm;
    public boolean aNn;
    public long aNo;
    public long aNp;
    public String aNq;
    public String aNr;
    public String aNs;
    public String aNt;
    public long aNu;
    public long aNv;
    public long aNw;
    public String aNx;
    public String aNy;
    public String aNz;
    public am aOE;
    public by aOF;
    public bu aOG;
    public bw aOH;
    public bq aOI;
    public cb aOJ;
    public af aOK;
    public boolean aOL;
    public String aOa;
    public String aOb;
    public QuickImInputData aOc;
    public QuickImInputData aOd;
    public List<YuanPackageData> aOe;
    public bh aOf;
    public List<String> aOg;
    public List<String> aOh;
    public List<String> aOi;
    public av aOr;
    public boolean aOs;
    public String aOt;
    public AlaFeedDiversionData aOu;
    public r aOv;
    public boolean aOw;
    public int aOx;
    public int aOy;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aLL = -1;
    public String aLM = null;
    public int aMq = 1;
    public boolean aMO = true;
    public boolean aMP = false;
    public boolean aMQ = false;
    public boolean aMS = false;
    public String aMV = "";
    private int aMW = 2;
    public String aMX = "";
    public int aMY = 1;
    public int aMZ = 0;
    public int aNb = 1;
    public List<String> aNh = new ArrayList();
    public int aND = 10;
    public int aNE = 60;
    public long aNF = 10000;
    public int aNG = 11;
    public int aNH = 4;
    public boolean aNI = false;
    public boolean aNO = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aNP = false;
    public boolean aNQ = false;
    public boolean aNS = false;
    public boolean aNT = false;
    public boolean aNU = false;
    public boolean aNV = false;
    public int aOj = 200;
    public int aOk = 100;
    public int aOl = 10;
    public int aOm = 10;
    public int aOn = 10;
    public int aOo = 15;
    public int aOp = 50;
    public int aOq = 5;
    public int aOz = 20;
    public int aOA = 70;
    public int aOB = 10000;
    public int aOC = 5000;
    public int aOD = 55000;
    public co aOM = co.aTB;
    public cp aON = cp.aTG;
    public Map<Integer, String> aOO = new HashMap();
    public List<String> aLW = new ArrayList();
    public List<String> aMg = new ArrayList();
    public List<String> aMb = new ArrayList();
    public List<Integer> aMc = new ArrayList();
    public ArrayList<o> aLU = new ArrayList<>();
    public ArrayList<o> aLV = new ArrayList<>();

    public al(boolean z) {
        if (z) {
            Fw();
            this.aMf = com.baidu.live.d.BM().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.d.BM().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.d.BM().getInt("restart_time_interval", 300);
            Fx();
            Fv();
            Fy();
            Fz();
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
                    u(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject3 != null) {
                    this.aMf = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.d.BM().putInt("conn_conf", this.aMf);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aMg.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.d.BM().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.d.BM().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    v(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    w(optJSONObject5);
                }
                this.aMT = jSONObject.optString("client_id");
                com.baidu.live.d.BM().putString("client_id", this.aMT);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aLS = optJSONObject6.optString("pic_url");
                    this.aLT = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            o oVar = new o();
                            oVar.parseJson(optJSONObject8);
                            this.aLU.add(oVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.d.BM().putString("pic_url", this.aLS);
                com.baidu.live.d.BM().putString(BigdayActivityConfig.JUMP_URL, this.aLT);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    x(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aNZ = optJSONObject10.optInt("resource_switch");
                    this.aOb = optJSONObject10.optString("photo_url");
                    this.aOa = optJSONObject10.optString("resource_url");
                }
                this.aOc = new QuickImInputData();
                this.aOc.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aOd = new QuickImInputData();
                this.aOd.parseJson(jSONObject.getJSONArray("fast_reply_word_audio"));
                this.aOf = bh.y(jSONObject.optJSONObject("guide_follow"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.d.BM().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject11 != null) {
                    JSONObject optJSONObject12 = optJSONObject11.optJSONObject("rank");
                    if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.d.BM().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.d.BM().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.d.BM().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject13 = optJSONObject11.optJSONObject("guard_seat");
                    if (optJSONObject13 != null) {
                        this.aOt = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aOr = new av();
                    this.aOr.aPE = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.d.BM().putString("ala_certify_refuse_url", this.aOr.aPE);
                }
                this.aOE = new am();
                this.aOE.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aOv = new r();
                    this.aOv.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aOF = new by(optJSONObject16);
                }
                com.baidu.live.guardclub.g.LZ().H(jSONObject.optJSONObject("old_club_member_level_icons"));
                this.aOL = jSONObject.optInt("disc_optimize_switch") == 1;
                JSONObject optJSONObject17 = jSONObject.optJSONObject("new_level_icon_urls");
                if (optJSONObject17 != null) {
                    int length2 = optJSONObject17.length();
                    for (int i3 = 1; i3 <= length2; i3++) {
                        this.aOO.put(Integer.valueOf(i3), optJSONObject17.optString(i3 + ""));
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.d.BM().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void Fv() {
        String string = com.baidu.live.d.BM().getString("ala_prepare_random_title_list", "");
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
            this.aOi = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aOi.add(jSONArray.optString(i));
            }
        }
    }

    private void Fw() {
        this.aLN = com.baidu.live.d.BM().getBoolean("map_around_map", false);
        this.aMu = com.baidu.live.d.BM().getBoolean("withdraw_switch", true);
        this.aMR = com.baidu.live.d.BM().getString("withdraw_text", "");
        this.aMK = com.baidu.live.d.BM().getBoolean("use_internal_player_switch", true);
        this.aMH = com.baidu.live.d.BM().getBoolean("use_http_dns_switch", true);
        this.aMI = com.baidu.live.d.BM().getBoolean("use_encode_bframe_switch", false);
        this.aMJ = com.baidu.live.d.BM().getBoolean("enable_opt_timestamp_switch", true);
        this.aML = com.baidu.live.d.BM().getBoolean("live_beauty_open_switch", false);
        this.aMM = com.baidu.live.d.BM().getBoolean("live_unity_beauty_switch", true);
        this.aMN = com.baidu.live.d.BM().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aMO = com.baidu.live.d.BM().getBoolean("sp_key_live_game_hard_encode", true);
        this.aMP = com.baidu.live.d.BM().getBoolean("sp_key_live_play_transcode_support", false);
        this.aMQ = com.baidu.live.d.BM().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aMS = com.baidu.live.d.BM().getBoolean("ala_enable_graffiti_str", false);
        this.aLO = com.baidu.live.d.BM().getBoolean("enter_live", false);
        this.aLP = com.baidu.live.d.BM().getBoolean("sync_to_forum", true);
        this.aLQ = com.baidu.live.d.BM().getBoolean("show_water_mark", false);
        this.aLR = com.baidu.live.d.BM().getBoolean("show_third_part_water_mark_switch", false);
        this.aMm = com.baidu.live.d.BM().getBoolean("stream_error_log", true);
        this.aMn = com.baidu.live.d.BM().getBoolean("disable_channel_in", true);
        this.aMo = com.baidu.live.d.BM().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aMp = com.baidu.live.d.BM().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aMr = com.baidu.live.d.BM().getBoolean("follow_default_push_switch", true);
        this.aNa = com.baidu.live.d.BM().getInt("to_tb_some_switch", 0);
        this.aMY = com.baidu.live.d.BM().getInt("enable_live_stat", 1);
        this.aMZ = com.baidu.live.d.BM().getInt("ala_free_gift_task_switch", 0);
        this.aNI = com.baidu.live.d.BM().getBoolean("live_challenge_switch", false);
        this.aNJ = com.baidu.live.d.BM().getString("live_challenge_tip", null);
        this.aNK = com.baidu.live.d.BM().getString("live_challenge_url", null);
    }

    private void u(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aLN = optJSONObject.optInt("switch") != 1;
                com.baidu.live.d.BM().putBoolean("map_around_map", this.aLN);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aMu = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("withdraw_switch", this.aMu);
                this.aMR = optJSONObject2.optString("text");
                com.baidu.live.d.BM().putString("withdraw_text", this.aMR);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aMK = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("use_internal_player_switch", this.aMK);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aMH = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("use_http_dns_switch", this.aMH);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aMI = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("use_encode_bframe_switch", this.aMI);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aMJ = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("enable_opt_timestamp_switch", this.aMJ);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.aML = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("live_beauty_open_switch", this.aML);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.aMM = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("live_unity_beauty_switch", this.aMM);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.aMN = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("live_unity_beauty_face_style_switch", this.aMN);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.aMO = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("sp_key_live_game_hard_encode", this.aMO);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.aMP = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("sp_key_live_play_transcode_support", this.aMP);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.aMQ = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("sp_key_live_play_attention_guide_support", this.aMQ);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.aLO = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("enter_live", this.aLO);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.aLP = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.d.BM().putBoolean("sync_to_forum", this.aLP);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.aLQ = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.d.BM().putBoolean("show_water_mark", this.aLQ);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.aLR = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.d.BM().putBoolean("show_third_part_water_mark_switch", this.aLR);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.aMY = optJSONObject17.optInt("switch");
                com.baidu.live.d.BM().putInt("enable_live_stat", this.aMY);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.aMm = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("stream_error_log", this.aMm);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.aMn = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.d.BM().putBoolean("disable_channel_in", this.aMn);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.aMo = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.d.BM().putBoolean("shoubai_yanzhi_tab_tip", this.aMo);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.aMp = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.d.BM().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aMp);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.aMr = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.d.BM().putBoolean("follow_default_push_switch", this.aMr);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.aNa = optJSONObject23.optInt("switch");
                com.baidu.live.d.BM().putInt("to_tb_some_switch", this.aNa);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.aMZ = optJSONObject24.optInt("switch");
                com.baidu.live.d.BM().putInt("ala_free_gift_task_switch", this.aNa);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.aMS = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("ala_enable_graffiti_str", this.aMS);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aNI = optJSONObject26.optInt("switch") == 1;
                this.aNJ = optJSONObject26.optString("title");
                this.aNK = optJSONObject26.optString("url");
                com.baidu.live.d.BM().putBoolean("live_challenge_switch", this.aNI);
                com.baidu.live.d.BM().putString("live_challenge_tip", this.aNJ);
                com.baidu.live.d.BM().putString("live_challenge_url", this.aNK);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aNQ = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("is_new_gift_t_dou_strategy", this.aNQ);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aNU = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aNS = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("key_is_open_login_prove", this.aNS);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aNT = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("key_is_open_diamond", this.aNT);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aNV = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.d.BM().putBoolean("key_is_jump_to_live_room", this.aNV);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aOs = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aOw = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void Fx() {
        JSONArray jSONArray;
        this.aMk = com.baidu.live.d.BM().getString("bluediamond_url", "");
        this.aLY = com.baidu.live.d.BM().getString("verify_content", this.aLY);
        this.aLX = com.baidu.live.d.BM().getString("live_notice", "");
        this.aLZ = com.baidu.live.d.BM().getString("activity_notice", "");
        String string = com.baidu.live.d.BM().getString("imNotice", "");
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
                        this.aLW.add(i, optString);
                    }
                }
            }
        }
        this.aMU = com.baidu.live.d.BM().getString("share_host", "");
        this.aMV = com.baidu.live.d.BM().getString("ala_share_in_bar_notice_text", "");
        this.aMX = com.baidu.live.d.BM().getString("ala_share_reward_rank_notice_text", "");
        this.aMW = com.baidu.live.d.BM().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aMl = com.baidu.live.d.BM().getInt("recommend_refresh", 60);
        this.aMs = com.baidu.live.d.BM().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aMt = com.baidu.live.d.BM().getInt("strategy_exception_interval", 1);
        this.aMq = com.baidu.live.d.BM().getInt("liveStartAuthLevel", 1);
        this.aMh = com.baidu.live.d.BM().getInt("2gTo", 5);
        this.aMi = com.baidu.live.d.BM().getInt("3gTo", 3);
        this.aMj = com.baidu.live.d.BM().getInt("wifiTo", 3);
        String string2 = com.baidu.live.d.BM().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aMd = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.d.BM().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aMe = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aNb = com.baidu.live.d.BM().getInt("square_tab_strategy", 1);
        this.aNc = com.baidu.live.d.BM().getString("ala_live_ranklist_url", null);
        this.aNd = com.baidu.live.d.BM().getString("new_flower_rank_list_description_url", "");
        this.aNe = com.baidu.live.d.BM().getString("ala_game_player_signup_url", null);
        this.aNf = com.baidu.live.d.BM().getString("ala_game_frs_live_tab_video_url", null);
        FB();
        this.aNm = com.baidu.live.d.BM().getString("ala_personal_income_detail_url", null);
        this.aNN = com.baidu.live.d.BM().getInt("ala_custom_gift_category_id", -1);
        this.aNn = com.baidu.live.d.BM().getInt("ala_live_pk_switch", 0) == 1;
        this.aNo = com.baidu.live.d.BM().getLong("ala_live_pk_check_interval", 1000L);
        this.aNp = com.baidu.live.d.BM().getLong("ala_live_pk_match_timeout", 60000L);
        this.aNq = com.baidu.live.d.BM().getString("ala_live_pk_pic_url", "");
        this.aNr = com.baidu.live.d.BM().getString("ala_live_pk_pic_jump_url", "");
        this.aNs = com.baidu.live.d.BM().getString("ala_live_pk_history_link", "");
        this.aNt = com.baidu.live.d.BM().getString("show_live_forum_url", "");
        this.aNu = com.baidu.live.d.BM().getLong("ala_challenge_random_interval", 1000L);
        this.aNv = com.baidu.live.d.BM().getLong("ala_challenge_direct_interval", 1000L);
        this.aNw = com.baidu.live.d.BM().getLong("ala_get_challenge_info_interval", 1000L);
        this.aNy = com.baidu.live.d.BM().getString("ala_challenge_pk_entry_icon_url", "");
        this.aNz = com.baidu.live.d.BM().getString("ala_challenge_pk_entry_icon_url", "");
        this.aNx = com.baidu.live.d.BM().getString("ala_challenge_pk_entry_icon_url", "");
        this.aNA = com.baidu.live.d.BM().getInt("punish_stage_button_switch", 0);
        this.aNB = com.baidu.live.d.BM().getInt("receive_challenge_im_show_time", 0);
        this.aNC = com.baidu.live.d.BM().getInt("mvpPunishSwitch", 0);
        this.aND = com.baidu.live.d.BM().getInt("toastLifeTime", 10);
        this.aNE = com.baidu.live.d.BM().getInt("punishLifeTime", 60);
        this.aNO = com.baidu.live.d.BM().getBoolean("ala_guess_use_https", false);
        gH(com.baidu.live.d.BM().getString("ala_live_bar_map_str", ""));
        this.aNP = com.baidu.live.d.BM().getBoolean("is_new_live_close_strategy", false);
        this.aNQ = com.baidu.live.d.BM().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aNR = com.baidu.live.d.BM().getString("ala_feedback_url", null);
        this.aMv = com.baidu.live.d.BM().getInt("ala_video_resolution_level", 3);
        this.aMw = com.baidu.live.d.BM().getInt("ala_video_encoder_gop", 2);
        this.aMx = com.baidu.live.d.BM().getBoolean("ala_live_hard_encode_switch", true);
        this.aMy = com.baidu.live.d.BM().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.d.BM().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.d.BM().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.d.BM().getInt("ala_video_increase_count", 3);
        this.aMz = com.baidu.live.d.BM().getString("ala_video_soft_bitrate_config", null);
        this.aMA = com.baidu.live.d.BM().getString("ala_video_hard_bitrate_config", null);
        this.aME = com.baidu.live.d.BM().getInt("ala_master_chat_video_resolution_level", 3);
        this.aMF = com.baidu.live.d.BM().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aMB = com.baidu.live.d.BM().getString("ala_avts_stream_server_domain_config", null);
        this.aMC = com.baidu.live.d.BM().getString("ala_master_chat_video_bitrate_config", null);
        this.aMD = com.baidu.live.d.BM().getString("ala_slave_chat_video_bitrate_config", null);
        this.aMG = com.baidu.live.d.BM().getString("ala_video_encoder_reset_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.d.BM().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.d.BM().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aNS = com.baidu.live.d.BM().getBoolean("key_is_open_login_prove", false);
        this.aNT = com.baidu.live.d.BM().getBoolean("key_is_open_diamond", false);
        this.aNV = com.baidu.live.d.BM().getBoolean("key_is_jump_to_live_room", false);
        gF(com.baidu.live.d.BM().getString("feed_diversion", ""));
        FA();
    }

    private void gF(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aOu = new AlaFeedDiversionData();
                this.aOu.parserJson(jSONObject);
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

    private void v(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tying_gift_conf");
            if (optJSONObject2 != null) {
                this.aNG = optJSONObject2.optInt("pendant_details_show_times");
                this.aNH = optJSONObject2.optInt("pendant_inform_show_times");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("pksolo");
            if (optJSONObject3 != null) {
                this.aMa = optJSONObject3.toString();
                this.aOG = new bu();
                this.aOG.parse(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("poke");
            this.aOH = new bw();
            if (optJSONObject4 != null) {
                this.aOH.parse(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject5 != null) {
                this.aLM = optJSONObject5.optString("toast");
                this.aLL = optJSONObject5.optInt("remind_type");
            }
            this.aMk = jSONObject.optString("bluediamond_url");
            com.baidu.live.d.BM().putString("bluediamond_url", this.aMk);
            this.aLY = jSONObject.optString("verify_content");
            com.baidu.live.d.BM().putString("verify_content", this.aLY);
            this.aLX = jSONObject.optString("live_notice");
            com.baidu.live.d.BM().putString("live_notice", this.aLX);
            this.aLZ = jSONObject.optString("activityNotice");
            com.baidu.live.d.BM().putString("activity_notice", this.aLZ);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aLW.add(i, optString);
                    }
                }
                com.baidu.live.d.BM().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.d.BM().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.aMb.add(i2, optString2);
                    }
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("bd_live_activity");
            if (optJSONObject6 != null && (optJSONArray = optJSONObject6.optJSONArray("main_page")) != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject7 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject7 != null) {
                        o oVar = new o();
                        oVar.parseJson(optJSONObject7);
                        this.aLV.add(oVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aMc.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("share_host");
            if (optJSONObject8 != null) {
                this.aMU = optJSONObject8.optString("url");
            } else {
                this.aMU = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject9 != null) {
                this.aMV = optJSONObject9.optString("reward_notice");
                this.aMX = optJSONObject9.optString("reward_rank_notice");
                this.aMW = optJSONObject9.optInt("reward_switch", 2);
            } else {
                this.aMV = "";
                this.aMX = "";
                this.aMW = 2;
            }
            com.baidu.live.d.BM().putString("share_host", this.aMU);
            com.baidu.live.d.BM().putString("ala_share_in_bar_notice_text", this.aMV);
            com.baidu.live.d.BM().putString("ala_share_reward_rank_notice_text", this.aMX);
            com.baidu.live.d.BM().putInt("ala_share_in_bar_notice_tip_switch", this.aMW);
            JSONObject optJSONObject10 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject10 != null) {
                this.aMl = optJSONObject10.optInt("value");
            } else {
                this.aMl = 60;
            }
            com.baidu.live.d.BM().putInt("recommend_refresh", this.aMl);
            JSONObject optJSONObject11 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject11 != null) {
                JSONArray optJSONArray5 = optJSONObject11.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.d.BM().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aMd = g(optJSONArray5);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject12 != null) {
                JSONArray optJSONArray6 = optJSONObject12.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.d.BM().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aMe = g(optJSONArray6);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject13 != null) {
                this.aMs = optJSONObject13.optString("time_interval");
                this.aMt = optJSONObject13.optInt("exception_interval");
            } else {
                this.aMs = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aMt = 1;
            }
            com.baidu.live.d.BM().putString("strategy_conf", this.aMs);
            com.baidu.live.d.BM().putInt("strategy_exception_interval", this.aMt);
            this.aMq = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.d.BM().putInt("liveStartAuthLevel", this.aMq);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject14 != null) {
                this.aMh = optJSONObject14.optInt("2gTo");
                if (this.aMh < 3) {
                    this.aMh = 3;
                }
                this.aMi = optJSONObject14.optInt("3gTo");
                if (this.aMi < 3) {
                    this.aMi = 3;
                }
                this.aMj = optJSONObject14.optInt("wifiTo");
                if (this.aMj < 3) {
                    this.aMj = 3;
                }
                com.baidu.live.d.BM().putInt("2gTo", this.aMh);
                com.baidu.live.d.BM().putInt("3gTo", this.aMi);
                com.baidu.live.d.BM().putInt("wifiTo", this.aMj);
            }
            this.aNb = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.d.BM().putInt("square_tab_strategy", this.aNb);
            JSONObject optJSONObject15 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject15 != null) {
                this.aNc = optJSONObject15.optString(BigdayActivityConfig.JUMP_URL);
                this.aNd = optJSONObject15.optString("flower_rank_rule");
            }
            com.baidu.live.d.BM().putString("ala_live_ranklist_url", this.aNc);
            com.baidu.live.d.BM().putString("new_flower_rank_list_description_url", this.aNd);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject16 != null) {
                this.aNe = optJSONObject16.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.d.BM().putString("ala_game_player_signup_url", this.aNe);
            JSONObject optJSONObject17 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject17 != null) {
                this.aNf = optJSONObject17.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.BM().putString("ala_game_frs_live_tab_video_url", this.aNf);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject18 != null) {
                this.aNg = optJSONObject18.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.d.BM().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aNh.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject19 != null) {
                com.baidu.live.d.BM().putString("ala_live_session_replace_key", optJSONObject19.toString());
                this.aNk = optJSONObject19.optString("hlsUrl");
                this.aNi = optJSONObject19.optString("rtmpUrl");
                this.aNj = optJSONObject19.optString("flvUrl");
                this.aNl = optJSONObject19.optString(".m3u8");
            }
            b(true, this.aNg);
            JSONObject optJSONObject20 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject20 != null) {
                this.aNm = optJSONObject20.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.BM().putString("ala_personal_income_detail_url", this.aNm);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject21 != null) {
                this.aNN = optJSONObject21.optInt("android_show");
                com.baidu.live.d.BM().putInt("ala_custom_gift_category_id", this.aNN);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("pub_show_conf");
            if (optJSONObject22 != null) {
                this.aOM = new co();
                this.aOM.parserJson(optJSONObject22);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("pub_show_two_conf");
            if (optJSONObject23 != null) {
                this.aON = new cp();
                this.aON.parserJson(optJSONObject23);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject24 != null) {
                int optInt = optJSONObject24.optInt("open", 0);
                this.aNn = optInt == 1;
                com.baidu.live.d.BM().putInt("ala_live_pk_switch", optInt);
                this.aNo = optJSONObject24.optLong("interval");
                if (this.aNo < 1000) {
                    this.aNo = 1000L;
                }
                com.baidu.live.d.BM().putLong("ala_live_pk_check_interval", this.aNo);
                this.aNp = optJSONObject24.optLong("match_timeout");
                if (this.aNp < 60000) {
                    this.aNp = 60000L;
                }
                com.baidu.live.d.BM().putLong("ala_live_pk_match_timeout", this.aNp);
                this.aNq = optJSONObject24.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.d.BM().putString("ala_live_pk_pic_url", this.aNq);
                this.aNr = optJSONObject24.optString("rank_link");
                com.baidu.live.d.BM().putString("ala_live_pk_pic_jump_url", this.aNr);
                this.aNs = optJSONObject24.optString("history_link");
                com.baidu.live.d.BM().putString("ala_live_pk_history_link", this.aNs);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject25 != null) {
                this.aNu = optJSONObject25.optLong("random_interval");
                if (this.aNu < 1000) {
                    this.aNu = 1000L;
                }
                com.baidu.live.d.BM().putLong("ala_challenge_random_interval", this.aNu);
                this.aNv = optJSONObject25.optLong("direct_interval");
                if (this.aNv < 1000) {
                    this.aNv = 1000L;
                }
                com.baidu.live.d.BM().putLong("ala_challenge_direct_interval", this.aNv);
                this.aNw = optJSONObject25.optLong("challenge_info_interval");
                if (this.aNw < 1000) {
                    this.aNw = 1000L;
                }
                com.baidu.live.d.BM().putLong("ala_get_challenge_info_interval", this.aNw);
                this.aNy = optJSONObject25.optString("pk_icon_url");
                com.baidu.live.d.BM().putString("ala_challenge_pk_entry_icon_url", this.aNy);
                this.aNz = optJSONObject25.optString("icon_url");
                com.baidu.live.d.BM().putString("ala_challenge_pk_entry_icon_url", this.aNz);
                this.aNx = optJSONObject25.optString("rule_url");
                com.baidu.live.d.BM().putString("ala_challenge_pk_entry_icon_url", this.aNx);
                this.aNA = optJSONObject25.optInt("punish_stage_button_switch");
                com.baidu.live.d.BM().putInt("punish_stage_button_switch", this.aNA);
                this.aNB = optJSONObject25.optInt("receive_challenge_im_show_time");
                com.baidu.live.d.BM().putInt("receive_challenge_im_show_time", this.aNB);
                this.aNC = optJSONObject25.optInt("mvpPunishSwitch");
                com.baidu.live.d.BM().putInt("mvpPunishSwitch", this.aNC);
                this.aND = optJSONObject25.optInt("toastLifeTime");
                com.baidu.live.d.BM().putInt("toastLifeTime", this.aND);
                this.aNE = optJSONObject25.optInt("punishLifeTime");
                com.baidu.live.d.BM().putInt("punishLifeTime", this.aNE);
                this.aNF = optJSONObject25.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject26 != null) {
                this.aNt = optJSONObject26.optString("go_url");
                com.baidu.live.d.BM().putString("show_live_forum_url", this.aNt);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject27 != null) {
                this.aNO = optJSONObject27.optInt("use_https", 0) == 1;
                com.baidu.live.d.BM().putBoolean("ala_guess_use_https", this.aNO);
            }
            String optString3 = jSONObject.optString("live_bar");
            gH(optString3);
            com.baidu.live.d.BM().putString("ala_live_bar_map_str", optString3);
            this.aNP = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.d.BM().putBoolean("is_new_live_close_strategy", this.aNP);
            this.aNQ = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.d.BM().putBoolean("is_new_gift_t_dou_strategy", this.aNQ);
            this.aNR = jSONObject.optString("feedback_url");
            com.baidu.live.d.BM().putString("ala_feedback_url", this.aNR);
            JSONObject optJSONObject28 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject28 != null && (optJSONObject = optJSONObject28.optJSONObject("challenge_related_zip")) != null) {
                this.aNL = optJSONObject.optString("zip_md5");
                this.aNM = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject29 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject29.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject29.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.d.BM().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.d.BM().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("open_live");
            if (optJSONObject30 != null) {
                this.increaseThreshold = optJSONObject30.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.d.BM().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject30.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.d.BM().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject30.optInt("thi_count", 3);
                com.baidu.live.d.BM().putInt("ala_video_increase_count", this.increaseCount);
                this.aMx = optJSONObject30.optInt("encoder", 1) == 1;
                com.baidu.live.d.BM().putBoolean("ala_live_hard_encode_switch", this.aMx);
                this.aMw = optJSONObject30.optInt("video_gop", 2);
                com.baidu.live.d.BM().putInt("ala_video_encoder_gop", this.aMw);
                this.aMy = optJSONObject30.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.d.BM().putBoolean("ala_dynamic_bitrate_switch", this.aMy);
                this.aMv = optJSONObject30.optInt("resolution", 3);
                com.baidu.live.d.BM().putInt("ala_video_resolution_level", this.aMv);
                JSONArray optJSONArray8 = optJSONObject30.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aMz = optJSONArray8.toString();
                    com.baidu.live.d.BM().putString("ala_video_soft_bitrate_config", this.aMz);
                }
                JSONArray optJSONArray9 = optJSONObject30.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aMA = optJSONArray9.toString();
                    com.baidu.live.d.BM().putString("ala_video_hard_bitrate_config", this.aMA);
                }
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject31 != null) {
                this.aMB = optJSONObject31.toString();
                com.baidu.live.d.BM().putString("ala_avts_stream_server_domain_config", this.aMB);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("encoder_auto_reset");
            if (optJSONObject32 != null) {
                this.aMG = optJSONObject32.toString();
                com.baidu.live.d.BM().putString("ala_video_encoder_reset_config", this.aMG);
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject33 != null) {
                this.aME = optJSONObject33.optInt("host_rtc_resolution", 3);
                com.baidu.live.d.BM().putInt("ala_master_chat_video_resolution_level", this.aME);
                this.aMF = optJSONObject33.optInt("rtc_resolution", 4);
                com.baidu.live.d.BM().putInt("ala_slave_chat_video_resolution_level", this.aMF);
                JSONArray optJSONArray10 = optJSONObject33.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aMC = optJSONArray10.toString();
                    com.baidu.live.d.BM().putString("ala_master_chat_video_bitrate_config", this.aMC);
                }
                JSONArray optJSONArray11 = optJSONObject33.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aMD = optJSONArray11.toString();
                    com.baidu.live.d.BM().putString("ala_slave_chat_video_bitrate_config", this.aMD);
                }
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject34 != null) {
                this.aOz = optJSONObject34.optInt("enter_live_msg_audience_num_p1");
                this.aOA = optJSONObject34.optInt("enter_live_msg_audience_num_p2");
                this.aOB = optJSONObject34.optInt("enter_live_msg_audience_num_p3");
                this.aOx = optJSONObject34.optInt("im_intercept_switch");
                this.aOy = optJSONObject34.optInt("is_check_im_content");
            }
            JSONObject optJSONObject35 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject35 != null) {
                this.aOu = new AlaFeedDiversionData();
                this.aOu.parserJson(optJSONObject35);
                com.baidu.live.d.BM().putString("feed_diversion", optJSONObject35.toString());
            }
            JSONObject optJSONObject36 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject36 != null) {
                com.baidu.live.d.BM().putString("key_stat_switch", optJSONObject36.toString());
            }
            JSONObject optJSONObject37 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject37 != null) {
                this.aOC = optJSONObject37.optInt("unfold_interval", 5000);
                this.aOD = optJSONObject37.optInt("fold_interval", 55000);
            }
            JSONObject optJSONObject38 = jSONObject.optJSONObject("modify_default_name_conf");
            if (optJSONObject38 != null) {
                this.aOI = new bq();
                this.aOI.parserJson(optJSONObject38);
            }
            JSONObject optJSONObject39 = jSONObject.optJSONObject("audio_live_conf");
            if (optJSONObject39 != null) {
                this.aOJ = new cb();
                this.aOJ.parse(optJSONObject39);
            }
            JSONObject optJSONObject40 = jSONObject.optJSONObject("quit_live_rec_conf");
            this.aOK = new af();
            this.aOK.parse(optJSONObject40);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void w(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOj = jSONObject.optInt("im_max", 200);
            if (this.aOj <= 0) {
                this.aOj = 200;
            }
            this.aOk = jSONObject.optInt("barrage_max", 100);
            if (this.aOk <= 0) {
                this.aOk = 100;
            }
            this.aOl = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aOl <= 0) {
                this.aOl = 10;
            }
            this.aOm = jSONObject.optInt("enter_effect_max", 10);
            if (this.aOm <= 0) {
                this.aOm = 10;
            }
            this.aOn = jSONObject.optInt("gift_big_max", 10);
            if (this.aOn <= 0) {
                this.aOn = 10;
            }
            this.aOo = jSONObject.optInt("audio_gift_big_max", 15);
            if (this.aOo <= 0) {
                this.aOo = 15;
            }
            this.aOp = jSONObject.optInt("gift_small_max", 50);
            if (this.aOp <= 0) {
                this.aOp = 50;
            }
            this.aOq = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aOq <= 0) {
                this.aOq = 5;
            }
        }
    }

    private void Fy() {
        this.aNW = com.baidu.live.d.BM().getInt("guide_speak_watch_time", 15000);
        this.aNX = com.baidu.live.d.BM().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.d.BM().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aNY = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aNY[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void x(JSONObject jSONObject) {
        int length;
        this.aNW = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.d.BM().putInt("guide_speak_watch_time", this.aNW);
        this.aNX = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.d.BM().putInt("guide_speak_show_times_max", this.aNX);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aNY = new String[length];
            for (int i = 0; i < length; i++) {
                this.aNY[i] = optJSONArray.optString(i);
            }
            com.baidu.live.d.BM().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void Fz() {
        String string = com.baidu.live.d.BM().getString("yuan_package_data", "");
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
            this.aOe = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aOe.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void gG(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aOg = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aOg.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aOh = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aOh.add(str3);
                            }
                        }
                    }
                    com.baidu.live.d.BM().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void FA() {
        gG(com.baidu.live.d.BM().getString("ala_quick_send_im_list", null));
    }

    private void gH(String str) {
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
        if (i != this.aNg) {
            z2 = true;
        }
        this.aNg = i;
        if (z || z2) {
            com.baidu.live.d.BM().putInt("ala_live_session_default_key", i);
        }
    }

    private void FB() {
        this.aNg = com.baidu.live.d.BM().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.d.BM().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aNh.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.d.BM().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aNk = jSONObject.optString("hlsUrl");
                this.aNi = jSONObject.optString("rtmpUrl");
                this.aNj = jSONObject.optString("flvUrl");
                this.aNl = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean FC() {
        return this.aMZ == 1;
    }
}
