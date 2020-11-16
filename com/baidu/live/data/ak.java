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
public class ak extends BaseData {
    public boolean aIU;
    public boolean aIV;
    public boolean aIW;
    public boolean aIX;
    public boolean aIY;
    public String aIZ;
    public int aJA;
    public boolean aJB;
    public int aJC;
    public boolean aJD;
    public boolean aJE;
    public String aJF;
    public String aJG;
    public String aJH;
    public String aJI;
    public String aJJ;
    public int aJK;
    public int aJL;
    public boolean aJM;
    public boolean aJN;
    public boolean aJO;
    public boolean aJP;
    public boolean aJQ;
    public boolean aJR;
    public boolean aJS;
    public String aJW;
    public String aJY;
    public String aJZ;
    public String aJa;
    public String aJe;
    public String aJf;
    public String aJg;
    public String aJh;
    public Integer[] aJk;
    public Integer[] aJl;
    public int aJm;
    public int aJo;
    public int aJp;
    public int aJq;
    public String aJr;
    public int aJs;
    public boolean aJt;
    public boolean aJu;
    public boolean aJv;
    public boolean aJw;
    public boolean aJy;
    public String aJz;
    public long aKA;
    public long aKB;
    public String aKC;
    public String aKD;
    public String aKE;
    public int aKF;
    public int aKG;
    public int aKH;
    public String aKO;
    public String aKP;
    public String aKQ;
    public String aKR;
    public int aKS;
    public String aKW;
    public int aKf;
    public String aKh;
    public String aKi;
    private String aKj;
    private String aKk;
    public int aKl;
    public String aKn;
    public String aKo;
    public String aKp;
    public String aKq;
    public String aKr;
    public boolean aKs;
    public long aKt;
    public long aKu;
    public String aKv;
    public String aKw;
    public String aKx;
    public String aKy;
    public long aKz;
    public r aLA;
    public boolean aLB;
    public int aLC;
    public int aLD;
    public al aLJ;
    public bw aLK;
    public bt aLL;
    public bp aLM;
    public bz aLN;
    public boolean aLO;
    public int aLb;
    public int aLc;
    public String[] aLd;
    public int aLe;
    public String aLf;
    public String aLg;
    public QuickImInputData aLh;
    public QuickImInputData aLi;
    public List<YuanPackageData> aLj;
    public bg aLk;
    public List<String> aLl;
    public List<String> aLm;
    public List<String> aLn;
    public au aLw;
    public boolean aLx;
    public String aLy;
    public AlaFeedDiversionData aLz;
    public String clientIP;
    public int continuousFailCount;
    public double decreaseThreshold;
    public int increaseCount;
    public double increaseThreshold;
    public String mBigHeaderPhotoUrlPrefix;
    public String mSmallHeaderPhotoUrlPrefix;
    public int restartTimeInterval;
    public int aIS = -1;
    public String aIT = null;
    public int aJx = 1;
    public boolean aJT = true;
    public boolean aJU = false;
    public boolean aJV = false;
    public boolean aJX = false;
    public String aKa = "";
    private int aKb = 2;
    public String aKc = "";
    public int aKd = 1;
    public int aKe = 0;
    public int aKg = 1;
    public List<String> aKm = new ArrayList();
    public int aKI = 10;
    public int aKJ = 60;
    public long aKK = 10000;
    public int aKL = 11;
    public int aKM = 4;
    public boolean aKN = false;
    public boolean aKT = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean aKU = false;
    public boolean aKV = false;
    public boolean aKX = false;
    public boolean aKY = false;
    public boolean aKZ = false;
    public boolean aLa = false;
    public int aLo = 200;
    public int aLp = 100;
    public int aLq = 10;
    public int aLr = 10;
    public int aLs = 10;
    public int aLt = 15;
    public int aLu = 50;
    public int aLv = 5;
    public int aLE = 20;
    public int aLF = 70;
    public int aLG = 10000;
    public int aLH = 5000;
    public int aLI = 55000;
    public cm aLP = cm.aQz;
    public cn aLQ = cn.aQE;
    public Map<Integer, String> aLR = new HashMap();
    public List<String> aJd = new ArrayList();
    public List<String> aJn = new ArrayList();
    public List<String> aJi = new ArrayList();
    public List<Integer> aJj = new ArrayList();
    public ArrayList<o> aJb = new ArrayList<>();
    public ArrayList<o> aJc = new ArrayList<>();

    public ak(boolean z) {
        if (z) {
            DL();
            this.aJm = com.baidu.live.d.Aq().getInt("conn_conf", 0);
            this.continuousFailCount = com.baidu.live.d.Aq().getInt("continuous_fail_count", 3);
            this.restartTimeInterval = com.baidu.live.d.Aq().getInt("restart_time_interval", 300);
            DM();
            DK();
            DN();
            DO();
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
                    this.aJm = optJSONObject3.optInt("conn_conf");
                    com.baidu.live.d.Aq().putInt("conn_conf", this.aJm);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("android_conn_black_list");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray2.optString(i);
                            if (!optString.isEmpty()) {
                                this.aJn.add(i, optString);
                            }
                        }
                    }
                    this.continuousFailCount = optJSONObject3.optInt("continuous_fail_count");
                    com.baidu.live.d.Aq().putInt("continuous_fail_count", this.continuousFailCount);
                    this.restartTimeInterval = optJSONObject3.optInt("restart_time_interval");
                    com.baidu.live.d.Aq().putInt("restart_time_interval", this.restartTimeInterval);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("config");
                if (optJSONObject4 != null) {
                    v(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("queue_limit");
                if (optJSONObject5 != null) {
                    w(optJSONObject5);
                }
                this.aJY = jSONObject.optString("client_id");
                com.baidu.live.d.Aq().putString("client_id", this.aJY);
                JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity");
                if (optJSONObject6 != null) {
                    this.aIZ = optJSONObject6.optString("pic_url");
                    this.aJa = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("live_activity_new");
                if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject8 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject8 != null) {
                            o oVar = new o();
                            oVar.parseJson(optJSONObject8);
                            this.aJb.add(oVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("live_headline");
                if (optJSONArray3 != null) {
                    f(optJSONArray3);
                    e(optJSONArray3);
                }
                com.baidu.live.d.Aq().putString("pic_url", this.aIZ);
                com.baidu.live.d.Aq().putString(BigdayActivityConfig.JUMP_URL, this.aJa);
                JSONObject optJSONObject9 = jSONObject.optJSONObject("guide_speak");
                if (optJSONObject9 != null) {
                    x(optJSONObject9);
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("charge_board_resource_location");
                if (optJSONObject10 != null) {
                    this.aLe = optJSONObject10.optInt("resource_switch");
                    this.aLg = optJSONObject10.optString("photo_url");
                    this.aLf = optJSONObject10.optString("resource_url");
                }
                this.aLh = new QuickImInputData();
                this.aLh.parseJson(jSONObject.optJSONArray("fast_reply_word"));
                this.aLi = new QuickImInputData();
                this.aLi.parseJson(jSONObject.getJSONArray("fast_reply_word_audio"));
                this.aLk = bg.y(jSONObject.optJSONObject("guide_follow"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("yuan_package");
                if (optJSONArray4 != null) {
                    h(optJSONArray4);
                    com.baidu.live.d.Aq().putString("yuan_package_data", optJSONArray4.toString());
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("rmb_conf");
                if (optJSONObject11 != null) {
                    JSONObject optJSONObject12 = optJSONObject11.optJSONObject("rank");
                    if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("hour")) != null) {
                        if (!TextUtils.isEmpty(optJSONObject.optString("haokan_url"))) {
                            com.baidu.live.d.Aq().putString("hour_rank_rule_hk_190808", optJSONObject.optString("haokan_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("quanmin_url"))) {
                            com.baidu.live.d.Aq().putString("hour_rank_rule_qm_190808", optJSONObject.optString("quanmin_url"));
                        }
                        if (!TextUtils.isEmpty(optJSONObject.optString("default_url"))) {
                            com.baidu.live.d.Aq().putString("hour_rank_rule_default", optJSONObject.optString("default_url"));
                        }
                    }
                    JSONObject optJSONObject13 = optJSONObject11.optJSONObject("guard_seat");
                    if (optJSONObject13 != null) {
                        this.aLy = optJSONObject13.optString(LogConfig.LOG_GIFT_ID);
                    }
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("certify_info");
                if (optJSONObject14 != null) {
                    this.aLw = new au();
                    this.aLw.aMF = optJSONObject14.optString("certify_refuse_url");
                    com.baidu.live.d.Aq().putString("ala_certify_refuse_url", this.aLw.aMF);
                }
                this.aLJ = new al();
                this.aLJ.parseJson(jSONObject.optJSONObject("tags_conf"));
                JSONObject optJSONObject15 = jSONObject.optJSONObject("authority_info");
                if (optJSONObject15 != null) {
                    this.aLA = new r();
                    this.aLA.parserJson(optJSONObject15);
                }
                JSONObject optJSONObject16 = jSONObject.optJSONObject("recommend_conf");
                if (optJSONObject16 != null) {
                    this.aLK = new bw(optJSONObject16);
                }
                this.aLO = jSONObject.optInt("disc_optimize_switch") == 1;
                JSONObject optJSONObject17 = jSONObject.optJSONObject("new_level_icon_urls");
                if (optJSONObject17 != null) {
                    int length2 = optJSONObject17.length();
                    for (int i3 = 1; i3 <= length2; i3++) {
                        this.aLR.put(Integer.valueOf(i3), optJSONObject17.optString(i3 + ""));
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            com.baidu.live.d.Aq().putString("ala_prepare_random_title_list", jSONArray.toString());
        }
    }

    private void DK() {
        String string = com.baidu.live.d.Aq().getString("ala_prepare_random_title_list", "");
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
            this.aLn = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.aLn.add(jSONArray.optString(i));
            }
        }
    }

    private void DL() {
        this.aIU = com.baidu.live.d.Aq().getBoolean("map_around_map", false);
        this.aJB = com.baidu.live.d.Aq().getBoolean("withdraw_switch", true);
        this.aJW = com.baidu.live.d.Aq().getString("withdraw_text", "");
        this.aJP = com.baidu.live.d.Aq().getBoolean("use_internal_player_switch", true);
        this.aJM = com.baidu.live.d.Aq().getBoolean("use_http_dns_switch", true);
        this.aJN = com.baidu.live.d.Aq().getBoolean("use_encode_bframe_switch", false);
        this.aJO = com.baidu.live.d.Aq().getBoolean("enable_opt_timestamp_switch", true);
        this.aJQ = com.baidu.live.d.Aq().getBoolean("live_beauty_open_switch", false);
        this.aJR = com.baidu.live.d.Aq().getBoolean("live_unity_beauty_switch", true);
        this.aJS = com.baidu.live.d.Aq().getBoolean("live_unity_beauty_face_style_switch", true);
        this.aJT = com.baidu.live.d.Aq().getBoolean("sp_key_live_game_hard_encode", true);
        this.aJU = com.baidu.live.d.Aq().getBoolean("sp_key_live_play_transcode_support", false);
        this.aJV = com.baidu.live.d.Aq().getBoolean("sp_key_live_play_attention_guide_support", false);
        this.aJX = com.baidu.live.d.Aq().getBoolean("ala_enable_graffiti_str", false);
        this.aIV = com.baidu.live.d.Aq().getBoolean("enter_live", false);
        this.aIW = com.baidu.live.d.Aq().getBoolean("sync_to_forum", true);
        this.aIX = com.baidu.live.d.Aq().getBoolean("show_water_mark", false);
        this.aIY = com.baidu.live.d.Aq().getBoolean("show_third_part_water_mark_switch", false);
        this.aJt = com.baidu.live.d.Aq().getBoolean("stream_error_log", true);
        this.aJu = com.baidu.live.d.Aq().getBoolean("disable_channel_in", true);
        this.aJv = com.baidu.live.d.Aq().getBoolean("shoubai_yanzhi_tab_tip", false);
        this.aJw = com.baidu.live.d.Aq().getBoolean(ActionJsonData.TAG_SIGN_IN, false);
        this.aJy = com.baidu.live.d.Aq().getBoolean("follow_default_push_switch", true);
        this.aKf = com.baidu.live.d.Aq().getInt("to_tb_some_switch", 0);
        this.aKd = com.baidu.live.d.Aq().getInt("enable_live_stat", 1);
        this.aKe = com.baidu.live.d.Aq().getInt("ala_free_gift_task_switch", 0);
        this.aKN = com.baidu.live.d.Aq().getBoolean("live_challenge_switch", false);
        this.aKO = com.baidu.live.d.Aq().getString("live_challenge_tip", null);
        this.aKP = com.baidu.live.d.Aq().getString("live_challenge_url", null);
    }

    private void u(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("map_around_map");
            if (optJSONObject != null) {
                this.aIU = optJSONObject.optInt("switch") != 1;
                com.baidu.live.d.Aq().putBoolean("map_around_map", this.aIU);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("withdraw");
            if (optJSONObject2 != null) {
                this.aJB = optJSONObject2.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("withdraw_switch", this.aJB);
                this.aJW = optJSONObject2.optString("text");
                com.baidu.live.d.Aq().putString("withdraw_text", this.aJW);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("use_internal_player");
            if (optJSONObject3 != null) {
                this.aJP = optJSONObject3.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("use_internal_player_switch", this.aJP);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("useHttpDns");
            if (optJSONObject4 != null) {
                this.aJM = optJSONObject4.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("use_http_dns_switch", this.aJM);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("useBFrame");
            if (optJSONObject5 != null) {
                this.aJN = optJSONObject5.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("use_encode_bframe_switch", this.aJN);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("enable_opt_timestamp");
            if (optJSONObject6 != null) {
                this.aJO = optJSONObject6.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("enable_opt_timestamp_switch", this.aJO);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("use_face_beauty");
            if (optJSONObject7 != null) {
                this.aJQ = optJSONObject7.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("live_beauty_open_switch", this.aJQ);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("use_fulive_beauty_and");
            if (optJSONObject8 != null) {
                this.aJR = optJSONObject8.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("live_unity_beauty_switch", this.aJR);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("use_fulive_face_shape_and");
            if (optJSONObject9 != null) {
                this.aJS = optJSONObject9.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("live_unity_beauty_face_style_switch", this.aJS);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("use_hw_game_encoder");
            if (optJSONObject10 != null) {
                this.aJT = optJSONObject10.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("sp_key_live_game_hard_encode", this.aJT);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("audience_transcode");
            if (optJSONObject11 != null) {
                this.aJU = optJSONObject11.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("sp_key_live_play_transcode_support", this.aJU);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("anchor_follow_tip");
            if (optJSONObject12 != null) {
                this.aJV = optJSONObject12.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("sp_key_live_play_attention_guide_support", this.aJV);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("enter_live");
            if (optJSONObject13 != null) {
                this.aIV = optJSONObject13.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("enter_live", this.aIV);
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("sync_to_forum");
            if (optJSONObject14 != null) {
                this.aIW = optJSONObject14.optString("switch").equals("1");
                com.baidu.live.d.Aq().putBoolean("sync_to_forum", this.aIW);
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("show_water_mark");
            if (optJSONObject15 != null) {
                this.aIX = optJSONObject15.optString("switch").equals("1");
                com.baidu.live.d.Aq().putBoolean("show_water_mark", this.aIX);
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("show_chushou_water_mark");
            if (optJSONObject16 != null) {
                this.aIY = optJSONObject16.optString("switch").equals("1");
                com.baidu.live.d.Aq().putBoolean("show_third_part_water_mark_switch", this.aIY);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("enable_live_sta");
            if (optJSONObject17 != null) {
                this.aKd = optJSONObject17.optInt("switch");
                com.baidu.live.d.Aq().putInt("enable_live_stat", this.aKd);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_error_log");
            if (optJSONObject18 != null) {
                this.aJt = optJSONObject18.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("stream_error_log", this.aJt);
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("disable_channel_in");
            if (optJSONObject19 != null) {
                this.aJu = optJSONObject19.optString("switch").equals("1");
                com.baidu.live.d.Aq().putBoolean("disable_channel_in", this.aJu);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("shoubai_yanzhi_tab_tip");
            if (optJSONObject20 != null) {
                this.aJv = optJSONObject20.optString("switch").equals("1");
                com.baidu.live.d.Aq().putBoolean("shoubai_yanzhi_tab_tip", this.aJv);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject(ActionJsonData.TAG_SIGN_IN);
            if (optJSONObject21 != null) {
                this.aJw = optJSONObject21.optString("switch").equals("1");
                com.baidu.live.d.Aq().putBoolean(ActionJsonData.TAG_SIGN_IN, this.aJw);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("follow_default_push_switch");
            if (optJSONObject22 != null) {
                this.aJy = optJSONObject22.optString("switch").equals("2");
                com.baidu.live.d.Aq().putBoolean("follow_default_push_switch", this.aJy);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("to_tb_some");
            if (optJSONObject23 != null) {
                this.aKf = optJSONObject23.optInt("switch");
                com.baidu.live.d.Aq().putInt("to_tb_some_switch", this.aKf);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("task_config");
            if (optJSONObject24 != null) {
                this.aKe = optJSONObject24.optInt("switch");
                com.baidu.live.d.Aq().putInt("ala_free_gift_task_switch", this.aKf);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("enable_graffiti");
            if (optJSONObject25 != null) {
                this.aJX = optJSONObject25.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("ala_enable_graffiti_str", this.aJX);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("live_challenge_activity");
            if (optJSONObject26 != null) {
                this.aKN = optJSONObject26.optInt("switch") == 1;
                this.aKO = optJSONObject26.optString("title");
                this.aKP = optJSONObject26.optString("url");
                com.baidu.live.d.Aq().putBoolean("live_challenge_switch", this.aKN);
                com.baidu.live.d.Aq().putString("live_challenge_tip", this.aKO);
                com.baidu.live.d.Aq().putString("live_challenge_url", this.aKP);
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject("new_gift_t_dou_strategy");
            if (optJSONObject27 != null) {
                this.aKV = optJSONObject27.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("is_new_gift_t_dou_strategy", this.aKV);
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("liveapp_day_rank");
            if (optJSONObject28 != null) {
                this.aKZ = optJSONObject28.optInt("switch") == 1;
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("login_prove");
            if (optJSONObject29 != null) {
                this.aKX = optJSONObject29.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("key_is_open_login_prove", this.aKX);
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("diamond_entry");
            if (optJSONObject30 != null) {
                this.aKY = optJSONObject30.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("key_is_open_diamond", this.aKY);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("challenge_jump_rival");
            if (optJSONObject31 != null) {
                this.aLa = optJSONObject31.optInt("switch") == 1;
                com.baidu.live.d.Aq().putBoolean("key_is_jump_to_live_room", this.aLa);
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("guard_seat");
            if (optJSONObject32 != null && (optInt2 = optJSONObject32.optInt("switch", -1)) >= 0) {
                this.aLx = optInt2 == 1;
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("errorcode_display");
            if (optJSONObject33 != null && (optInt = optJSONObject33.optInt("switch", -1)) >= 0) {
                this.aLB = optInt == 1;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void DM() {
        JSONArray jSONArray;
        this.aJr = com.baidu.live.d.Aq().getString("bluediamond_url", "");
        this.aJf = com.baidu.live.d.Aq().getString("verify_content", this.aJf);
        this.aJe = com.baidu.live.d.Aq().getString("live_notice", "");
        this.aJg = com.baidu.live.d.Aq().getString("activity_notice", "");
        String string = com.baidu.live.d.Aq().getString("imNotice", "");
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
                        this.aJd.add(i, optString);
                    }
                }
            }
        }
        this.aJZ = com.baidu.live.d.Aq().getString("share_host", "");
        this.aKa = com.baidu.live.d.Aq().getString("ala_share_in_bar_notice_text", "");
        this.aKc = com.baidu.live.d.Aq().getString("ala_share_reward_rank_notice_text", "");
        this.aKb = com.baidu.live.d.Aq().getInt("ala_share_in_bar_notice_tip_switch", 2);
        this.aJs = com.baidu.live.d.Aq().getInt("recommend_refresh", 60);
        this.aJz = com.baidu.live.d.Aq().getString("strategy_conf", ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE);
        this.aJA = com.baidu.live.d.Aq().getInt("strategy_exception_interval", 1);
        this.aJx = com.baidu.live.d.Aq().getInt("liveStartAuthLevel", 1);
        this.aJo = com.baidu.live.d.Aq().getInt("2gTo", 5);
        this.aJp = com.baidu.live.d.Aq().getInt("3gTo", 3);
        this.aJq = com.baidu.live.d.Aq().getInt("wifiTo", 3);
        String string2 = com.baidu.live.d.Aq().getString("ala_live_stream_config_normal", null);
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.aJk = g(new JSONArray(string2));
            }
            String string3 = com.baidu.live.d.Aq().getString("ala_live_stream_config_high_level", null);
            if (!TextUtils.isEmpty(string3)) {
                this.aJl = g(new JSONArray(string3));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.aKg = com.baidu.live.d.Aq().getInt("square_tab_strategy", 1);
        this.aKh = com.baidu.live.d.Aq().getString("ala_live_ranklist_url", null);
        this.aKi = com.baidu.live.d.Aq().getString("new_flower_rank_list_description_url", "");
        this.aKj = com.baidu.live.d.Aq().getString("ala_game_player_signup_url", null);
        this.aKk = com.baidu.live.d.Aq().getString("ala_game_frs_live_tab_video_url", null);
        DQ();
        this.aKr = com.baidu.live.d.Aq().getString("ala_personal_income_detail_url", null);
        this.aKS = com.baidu.live.d.Aq().getInt("ala_custom_gift_category_id", -1);
        this.aKs = com.baidu.live.d.Aq().getInt("ala_live_pk_switch", 0) == 1;
        this.aKt = com.baidu.live.d.Aq().getLong("ala_live_pk_check_interval", 1000L);
        this.aKu = com.baidu.live.d.Aq().getLong("ala_live_pk_match_timeout", 60000L);
        this.aKv = com.baidu.live.d.Aq().getString("ala_live_pk_pic_url", "");
        this.aKw = com.baidu.live.d.Aq().getString("ala_live_pk_pic_jump_url", "");
        this.aKx = com.baidu.live.d.Aq().getString("ala_live_pk_history_link", "");
        this.aKy = com.baidu.live.d.Aq().getString("show_live_forum_url", "");
        this.aKz = com.baidu.live.d.Aq().getLong("ala_challenge_random_interval", 1000L);
        this.aKA = com.baidu.live.d.Aq().getLong("ala_challenge_direct_interval", 1000L);
        this.aKB = com.baidu.live.d.Aq().getLong("ala_get_challenge_info_interval", 1000L);
        this.aKD = com.baidu.live.d.Aq().getString("ala_challenge_pk_entry_icon_url", "");
        this.aKE = com.baidu.live.d.Aq().getString("ala_challenge_pk_entry_icon_url", "");
        this.aKC = com.baidu.live.d.Aq().getString("ala_challenge_pk_entry_icon_url", "");
        this.aKF = com.baidu.live.d.Aq().getInt("punish_stage_button_switch", 0);
        this.aKG = com.baidu.live.d.Aq().getInt("receive_challenge_im_show_time", 0);
        this.aKH = com.baidu.live.d.Aq().getInt("mvpPunishSwitch", 0);
        this.aKI = com.baidu.live.d.Aq().getInt("toastLifeTime", 10);
        this.aKJ = com.baidu.live.d.Aq().getInt("punishLifeTime", 60);
        this.aKT = com.baidu.live.d.Aq().getBoolean("ala_guess_use_https", false);
        gl(com.baidu.live.d.Aq().getString("ala_live_bar_map_str", ""));
        this.aKU = com.baidu.live.d.Aq().getBoolean("is_new_live_close_strategy", false);
        this.aKV = com.baidu.live.d.Aq().getBoolean("is_new_gift_t_dou_strategy", false);
        this.aKW = com.baidu.live.d.Aq().getString("ala_feedback_url", null);
        this.aJC = com.baidu.live.d.Aq().getInt("ala_video_resolution_level", 3);
        this.aJD = com.baidu.live.d.Aq().getBoolean("ala_live_hard_encode_switch", true);
        this.aJE = com.baidu.live.d.Aq().getBoolean("ala_dynamic_bitrate_switch", true);
        this.increaseThreshold = com.baidu.live.d.Aq().getFloat("ala_video_increase_threshold", 0.006f);
        this.decreaseThreshold = com.baidu.live.d.Aq().getFloat("ala_video_decrease_threshold", 0.3f);
        this.increaseCount = com.baidu.live.d.Aq().getInt("ala_video_increase_count", 3);
        this.aJF = com.baidu.live.d.Aq().getString("ala_video_soft_bitrate_config", null);
        this.aJG = com.baidu.live.d.Aq().getString("ala_video_hard_bitrate_config", null);
        this.aJK = com.baidu.live.d.Aq().getInt("ala_master_chat_video_resolution_level", 3);
        this.aJL = com.baidu.live.d.Aq().getInt("ala_slave_chat_video_resolution_level", 4);
        this.aJH = com.baidu.live.d.Aq().getString("ala_avts_stream_server_domain_config", null);
        this.aJI = com.baidu.live.d.Aq().getString("ala_master_chat_video_bitrate_config", null);
        this.aJJ = com.baidu.live.d.Aq().getString("ala_slave_chat_video_bitrate_config", null);
        this.mBigHeaderPhotoUrlPrefix = com.baidu.live.d.Aq().getString("ala_big_header_photo_prefix", TbConfig.PHOTO_BIG_ADDRESS);
        this.mSmallHeaderPhotoUrlPrefix = com.baidu.live.d.Aq().getString("ala_small_header_photo_prefix", TbConfig.PHOTO_SMALL_ADDRESS);
        TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
        TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
        this.aKX = com.baidu.live.d.Aq().getBoolean("key_is_open_login_prove", false);
        this.aKY = com.baidu.live.d.Aq().getBoolean("key_is_open_diamond", false);
        this.aLa = com.baidu.live.d.Aq().getBoolean("key_is_jump_to_live_room", false);
        gj(com.baidu.live.d.Aq().getString("feed_diversion", ""));
        DP();
    }

    private void gj(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.aLz = new AlaFeedDiversionData();
                this.aLz.parserJson(jSONObject);
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
                this.aKL = optJSONObject2.optInt("pendant_details_show_times");
                this.aKM = optJSONObject2.optInt("pendant_inform_show_times");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("pksolo");
            if (optJSONObject3 != null) {
                this.aJh = optJSONObject3.toString();
                this.aLL = new bt();
                this.aLL.parse(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tb_ala_toast_config");
            if (optJSONObject4 != null) {
                this.aIT = optJSONObject4.optString("toast");
                this.aIS = optJSONObject4.optInt("remind_type");
            }
            this.aJr = jSONObject.optString("bluediamond_url");
            com.baidu.live.d.Aq().putString("bluediamond_url", this.aJr);
            this.aJf = jSONObject.optString("verify_content");
            com.baidu.live.d.Aq().putString("verify_content", this.aJf);
            this.aJe = jSONObject.optString("live_notice");
            com.baidu.live.d.Aq().putString("live_notice", this.aJe);
            this.aJg = jSONObject.optString("activityNotice");
            com.baidu.live.d.Aq().putString("activity_notice", this.aJg);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("imNotice");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    if (!optString.isEmpty()) {
                        this.aJd.add(i, optString);
                    }
                }
                com.baidu.live.d.Aq().putString("imNotice", optJSONArray2.toString());
            } else {
                com.baidu.live.d.Aq().putString("imNotice", "");
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("imGetMsgStrategy");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray3.optString(i2);
                    if (!optString2.isEmpty()) {
                        this.aJi.add(i2, optString2);
                    }
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("bd_live_activity");
            if (optJSONObject5 != null && (optJSONArray = optJSONObject5.optJSONArray("main_page")) != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject6 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject6 != null) {
                        o oVar = new o();
                        oVar.parseJson(optJSONObject6);
                        this.aJc.add(oVar);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    this.aJj.add(i4, Integer.valueOf(optJSONArray4.optInt(i4)));
                }
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("share_host");
            if (optJSONObject7 != null) {
                this.aJZ = optJSONObject7.optString("url");
            } else {
                this.aJZ = "http://tieba.baidu.com/ala/share/live";
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("share_reward");
            if (optJSONObject8 != null) {
                this.aKa = optJSONObject8.optString("reward_notice");
                this.aKc = optJSONObject8.optString("reward_rank_notice");
                this.aKb = optJSONObject8.optInt("reward_switch", 2);
            } else {
                this.aKa = "";
                this.aKc = "";
                this.aKb = 2;
            }
            com.baidu.live.d.Aq().putString("share_host", this.aJZ);
            com.baidu.live.d.Aq().putString("ala_share_in_bar_notice_text", this.aKa);
            com.baidu.live.d.Aq().putString("ala_share_reward_rank_notice_text", this.aKc);
            com.baidu.live.d.Aq().putInt("ala_share_in_bar_notice_tip_switch", this.aKb);
            JSONObject optJSONObject9 = jSONObject.optJSONObject("recommend_refresh");
            if (optJSONObject9 != null) {
                this.aJs = optJSONObject9.optInt("value");
            } else {
                this.aJs = 60;
            }
            com.baidu.live.d.Aq().putInt("recommend_refresh", this.aJs);
            JSONObject optJSONObject10 = jSONObject.optJSONObject("stream_config");
            if (optJSONObject10 != null) {
                JSONArray optJSONArray5 = optJSONObject10.optJSONArray("configs");
                if (optJSONArray5 != null) {
                    com.baidu.live.d.Aq().putString("ala_live_stream_config_normal", optJSONArray5.toString());
                }
                this.aJk = g(optJSONArray5);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("stream_level_high");
            if (optJSONObject11 != null) {
                JSONArray optJSONArray6 = optJSONObject11.optJSONArray("configs");
                if (optJSONArray6 != null) {
                    com.baidu.live.d.Aq().putString("ala_live_stream_config_high_level", optJSONArray6.toString());
                }
                this.aJl = g(optJSONArray6);
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject("strategy_conf");
            if (optJSONObject12 != null) {
                this.aJz = optJSONObject12.optString("time_interval");
                this.aJA = optJSONObject12.optInt("exception_interval");
            } else {
                this.aJz = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
                this.aJA = 1;
            }
            com.baidu.live.d.Aq().putString("strategy_conf", this.aJz);
            com.baidu.live.d.Aq().putInt("strategy_exception_interval", this.aJA);
            this.aJx = jSONObject.optInt("liveStartAuthLevel");
            com.baidu.live.d.Aq().putInt("liveStartAuthLevel", this.aJx);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject13 != null) {
                this.aJo = optJSONObject13.optInt("2gTo");
                if (this.aJo < 3) {
                    this.aJo = 3;
                }
                this.aJp = optJSONObject13.optInt("3gTo");
                if (this.aJp < 3) {
                    this.aJp = 3;
                }
                this.aJq = optJSONObject13.optInt("wifiTo");
                if (this.aJq < 3) {
                    this.aJq = 3;
                }
                com.baidu.live.d.Aq().putInt("2gTo", this.aJo);
                com.baidu.live.d.Aq().putInt("3gTo", this.aJp);
                com.baidu.live.d.Aq().putInt("wifiTo", this.aJq);
            }
            this.aKg = jSONObject.optInt("square_tab_strategy", 1);
            com.baidu.live.d.Aq().putInt("square_tab_strategy", this.aKg);
            JSONObject optJSONObject14 = jSONObject.optJSONObject("livesquare_rank");
            if (optJSONObject14 != null) {
                this.aKh = optJSONObject14.optString(BigdayActivityConfig.JUMP_URL);
                this.aKi = optJSONObject14.optString("flower_rank_rule");
            }
            com.baidu.live.d.Aq().putString("ala_live_ranklist_url", this.aKh);
            com.baidu.live.d.Aq().putString("new_flower_rank_list_description_url", this.aKi);
            JSONObject optJSONObject15 = jSONObject.optJSONObject("game_player_sign_up_h5");
            if (optJSONObject15 != null) {
                this.aKj = optJSONObject15.optString(BigdayActivityConfig.JUMP_URL);
            }
            com.baidu.live.d.Aq().putString("ala_game_player_signup_url", this.aKj);
            JSONObject optJSONObject16 = jSONObject.optJSONObject("frs_new_live_tab_video_h5");
            if (optJSONObject16 != null) {
                this.aKk = optJSONObject16.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.Aq().putString("ala_game_frs_live_tab_video_url", this.aKk);
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("session_backup");
            if (optJSONObject17 != null) {
                this.aKl = optJSONObject17.optInt("session_default");
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("stream_domain");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.baidu.live.d.Aq().putString("ala_live_session_domains_key", optJSONArray7.toString());
                for (int i5 = 0; i5 < optJSONArray7.length(); i5++) {
                    String string = optJSONArray7.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        this.aKm.add(string.trim());
                    }
                }
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("stream_backup_replace");
            if (optJSONObject18 != null) {
                com.baidu.live.d.Aq().putString("ala_live_session_replace_key", optJSONObject18.toString());
                this.aKp = optJSONObject18.optString("hlsUrl");
                this.aKn = optJSONObject18.optString("rtmpUrl");
                this.aKo = optJSONObject18.optString("flvUrl");
                this.aKq = optJSONObject18.optString(".m3u8");
            }
            b(true, this.aKl);
            JSONObject optJSONObject19 = jSONObject.optJSONObject("ala_personal_income_detail_url");
            if (optJSONObject19 != null) {
                this.aKr = optJSONObject19.optString(BigdayActivityConfig.JUMP_URL);
                com.baidu.live.d.Aq().putString("ala_personal_income_detail_url", this.aKr);
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("live_gift_flower_scene_id_to_category_id");
            if (optJSONObject20 != null) {
                this.aKS = optJSONObject20.optInt("android_show");
                com.baidu.live.d.Aq().putInt("ala_custom_gift_category_id", this.aKS);
            }
            JSONObject optJSONObject21 = jSONObject.optJSONObject("pub_show_conf");
            if (optJSONObject21 != null) {
                this.aLP = new cm();
                this.aLP.parserJson(optJSONObject21);
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("pub_show_two_conf");
            if (optJSONObject22 != null) {
                this.aLQ = new cn();
                this.aLQ.parserJson(optJSONObject22);
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject("pk_conf");
            if (optJSONObject23 != null) {
                int optInt = optJSONObject23.optInt("open", 0);
                this.aKs = optInt == 1;
                com.baidu.live.d.Aq().putInt("ala_live_pk_switch", optInt);
                this.aKt = optJSONObject23.optLong("interval");
                if (this.aKt < 1000) {
                    this.aKt = 1000L;
                }
                com.baidu.live.d.Aq().putLong("ala_live_pk_check_interval", this.aKt);
                this.aKu = optJSONObject23.optLong("match_timeout");
                if (this.aKu < 60000) {
                    this.aKu = 60000L;
                }
                com.baidu.live.d.Aq().putLong("ala_live_pk_match_timeout", this.aKu);
                this.aKv = optJSONObject23.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                com.baidu.live.d.Aq().putString("ala_live_pk_pic_url", this.aKv);
                this.aKw = optJSONObject23.optString("rank_link");
                com.baidu.live.d.Aq().putString("ala_live_pk_pic_jump_url", this.aKw);
                this.aKx = optJSONObject23.optString("history_link");
                com.baidu.live.d.Aq().putString("ala_live_pk_history_link", this.aKx);
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject("challenge_conf");
            if (optJSONObject24 != null) {
                this.aKz = optJSONObject24.optLong("random_interval");
                if (this.aKz < 1000) {
                    this.aKz = 1000L;
                }
                com.baidu.live.d.Aq().putLong("ala_challenge_random_interval", this.aKz);
                this.aKA = optJSONObject24.optLong("direct_interval");
                if (this.aKA < 1000) {
                    this.aKA = 1000L;
                }
                com.baidu.live.d.Aq().putLong("ala_challenge_direct_interval", this.aKA);
                this.aKB = optJSONObject24.optLong("challenge_info_interval");
                if (this.aKB < 1000) {
                    this.aKB = 1000L;
                }
                com.baidu.live.d.Aq().putLong("ala_get_challenge_info_interval", this.aKB);
                this.aKD = optJSONObject24.optString("pk_icon_url");
                com.baidu.live.d.Aq().putString("ala_challenge_pk_entry_icon_url", this.aKD);
                this.aKE = optJSONObject24.optString("icon_url");
                com.baidu.live.d.Aq().putString("ala_challenge_pk_entry_icon_url", this.aKE);
                this.aKC = optJSONObject24.optString("rule_url");
                com.baidu.live.d.Aq().putString("ala_challenge_pk_entry_icon_url", this.aKC);
                this.aKF = optJSONObject24.optInt("punish_stage_button_switch");
                com.baidu.live.d.Aq().putInt("punish_stage_button_switch", this.aKF);
                this.aKG = optJSONObject24.optInt("receive_challenge_im_show_time");
                com.baidu.live.d.Aq().putInt("receive_challenge_im_show_time", this.aKG);
                this.aKH = optJSONObject24.optInt("mvpPunishSwitch");
                com.baidu.live.d.Aq().putInt("mvpPunishSwitch", this.aKH);
                this.aKI = optJSONObject24.optInt("toastLifeTime");
                com.baidu.live.d.Aq().putInt("toastLifeTime", this.aKI);
                this.aKJ = optJSONObject24.optInt("punishLifeTime");
                com.baidu.live.d.Aq().putInt("punishLifeTime", this.aKJ);
                this.aKK = optJSONObject24.optLong("challenge_dynamic_effect", 10000L);
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("showlive_forum");
            if (optJSONObject25 != null) {
                this.aKy = optJSONObject25.optString("go_url");
                com.baidu.live.d.Aq().putString("show_live_forum_url", this.aKy);
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("guess_conf");
            if (optJSONObject26 != null) {
                this.aKT = optJSONObject26.optInt("use_https", 0) == 1;
                com.baidu.live.d.Aq().putBoolean("ala_guess_use_https", this.aKT);
            }
            String optString3 = jSONObject.optString("live_bar");
            gl(optString3);
            com.baidu.live.d.Aq().putString("ala_live_bar_map_str", optString3);
            this.aKU = jSONObject.optInt("new_live_close_strategy_value", 0) == 1;
            com.baidu.live.d.Aq().putBoolean("is_new_live_close_strategy", this.aKU);
            this.aKV = jSONObject.optInt("new_gift_t_dou_strategy", 0) == 1;
            com.baidu.live.d.Aq().putBoolean("is_new_gift_t_dou_strategy", this.aKV);
            this.aKW = jSONObject.optString("feedback_url");
            com.baidu.live.d.Aq().putString("ala_feedback_url", this.aKW);
            JSONObject optJSONObject27 = jSONObject.optJSONObject("challenge_and_ar_zip_config_android");
            if (optJSONObject27 != null && (optJSONObject = optJSONObject27.optJSONObject("challenge_related_zip")) != null) {
                this.aKQ = optJSONObject.optString("zip_md5");
                this.aKR = optJSONObject.optString("zip_url");
            }
            JSONObject optJSONObject28 = jSONObject.optJSONObject("avatar_host");
            if (optJSONObject28 != null) {
                this.mBigHeaderPhotoUrlPrefix = optJSONObject28.optString("big", TbConfig.PHOTO_BIG_ADDRESS);
                this.mSmallHeaderPhotoUrlPrefix = optJSONObject28.optString("small", TbConfig.PHOTO_SMALL_ADDRESS);
                TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(this.mBigHeaderPhotoUrlPrefix);
                TbadkCoreApplication.getInst().setSmallHeaderPhotoUrlPrefix(this.mSmallHeaderPhotoUrlPrefix);
                com.baidu.live.d.Aq().putString("ala_big_header_photo_prefix", this.mBigHeaderPhotoUrlPrefix);
                com.baidu.live.d.Aq().putString("ala_small_header_photo_prefix", this.mSmallHeaderPhotoUrlPrefix);
            }
            JSONObject optJSONObject29 = jSONObject.optJSONObject("open_live");
            if (optJSONObject29 != null) {
                this.increaseThreshold = optJSONObject29.optDouble("thi", 0.05999999865889549d);
                com.baidu.live.d.Aq().putFloat("ala_video_increase_threshold", (float) this.increaseThreshold);
                this.decreaseThreshold = optJSONObject29.optDouble("thd", 0.30000001192092896d);
                com.baidu.live.d.Aq().putFloat("ala_video_decrease_threshold", (float) this.decreaseThreshold);
                this.increaseCount = optJSONObject29.optInt("thi_count", 3);
                com.baidu.live.d.Aq().putInt("ala_video_increase_count", this.increaseCount);
                this.aJD = optJSONObject29.optInt("encoder", 1) == 1;
                com.baidu.live.d.Aq().putBoolean("ala_live_hard_encode_switch", this.aJD);
                this.aJE = optJSONObject29.optInt(PraiseUBCHelper.SOURCE_DYNAMIC, 1) == 1;
                com.baidu.live.d.Aq().putBoolean("ala_dynamic_bitrate_switch", this.aJE);
                this.aJC = optJSONObject29.optInt("resolution", 3);
                com.baidu.live.d.Aq().putInt("ala_video_resolution_level", this.aJC);
                JSONArray optJSONArray8 = optJSONObject29.optJSONArray("soft_configs");
                if (optJSONArray8 != null) {
                    this.aJF = optJSONArray8.toString();
                    com.baidu.live.d.Aq().putString("ala_video_soft_bitrate_config", this.aJF);
                }
                JSONArray optJSONArray9 = optJSONObject29.optJSONArray("hard_configs");
                if (optJSONArray9 != null) {
                    this.aJG = optJSONArray9.toString();
                    com.baidu.live.d.Aq().putString("ala_video_hard_bitrate_config", this.aJG);
                }
            }
            JSONObject optJSONObject30 = jSONObject.optJSONObject("avts_domain_conf");
            if (optJSONObject30 != null) {
                this.aJH = optJSONObject30.toString();
                com.baidu.live.d.Aq().putString("ala_avts_stream_server_domain_config", this.aJH);
            }
            JSONObject optJSONObject31 = jSONObject.optJSONObject("live_chat_conf");
            if (optJSONObject31 != null) {
                this.aJK = optJSONObject31.optInt("host_rtc_resolution", 3);
                com.baidu.live.d.Aq().putInt("ala_master_chat_video_resolution_level", this.aJK);
                this.aJL = optJSONObject31.optInt("rtc_resolution", 4);
                com.baidu.live.d.Aq().putInt("ala_slave_chat_video_resolution_level", this.aJL);
                JSONArray optJSONArray10 = optJSONObject31.optJSONArray("host_rtc_configs");
                if (optJSONArray10 != null) {
                    this.aJI = optJSONArray10.toString();
                    com.baidu.live.d.Aq().putString("ala_master_chat_video_bitrate_config", this.aJI);
                }
                JSONArray optJSONArray11 = optJSONObject31.optJSONArray("rtc_configs");
                if (optJSONArray11 != null) {
                    this.aJJ = optJSONArray11.toString();
                    com.baidu.live.d.Aq().putString("ala_slave_chat_video_bitrate_config", this.aJJ);
                }
            }
            JSONObject optJSONObject32 = jSONObject.optJSONObject("im_conf");
            if (optJSONObject32 != null) {
                this.aLE = optJSONObject32.optInt("enter_live_msg_audience_num_p1");
                this.aLF = optJSONObject32.optInt("enter_live_msg_audience_num_p2");
                this.aLG = optJSONObject32.optInt("enter_live_msg_audience_num_p3");
                this.aLC = optJSONObject32.optInt("im_intercept_switch");
                this.aLD = optJSONObject32.optInt("is_check_im_content");
            }
            JSONObject optJSONObject33 = jSONObject.optJSONObject("feed_diversion");
            if (optJSONObject33 != null) {
                this.aLz = new AlaFeedDiversionData();
                this.aLz.parserJson(optJSONObject33);
                com.baidu.live.d.Aq().putString("feed_diversion", optJSONObject33.toString());
            }
            JSONObject optJSONObject34 = jSONObject.optJSONObject("stat_switch");
            if (optJSONObject34 != null) {
                com.baidu.live.d.Aq().putString("key_stat_switch", optJSONObject34.toString());
            }
            JSONObject optJSONObject35 = jSONObject.optJSONObject("goback_last_live");
            if (optJSONObject35 != null) {
                this.aLH = optJSONObject35.optInt("unfold_interval", 5000);
                this.aLI = optJSONObject35.optInt("fold_interval", 55000);
            }
            JSONObject optJSONObject36 = jSONObject.optJSONObject("modify_default_name_conf");
            if (optJSONObject36 != null) {
                this.aLM = new bp();
                this.aLM.parserJson(optJSONObject36);
            }
            JSONObject optJSONObject37 = jSONObject.optJSONObject("audio_live_conf");
            if (optJSONObject37 != null) {
                this.aLN = new bz();
                this.aLN.parse(optJSONObject37);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void w(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLo = jSONObject.optInt("im_max", 200);
            if (this.aLo <= 0) {
                this.aLo = 200;
            }
            this.aLp = jSONObject.optInt("barrage_max", 100);
            if (this.aLp <= 0) {
                this.aLp = 100;
            }
            this.aLq = jSONObject.optInt("pay_barrage_max", 10);
            if (this.aLq <= 0) {
                this.aLq = 10;
            }
            this.aLr = jSONObject.optInt("enter_effect_max", 10);
            if (this.aLr <= 0) {
                this.aLr = 10;
            }
            this.aLs = jSONObject.optInt("gift_big_max", 10);
            if (this.aLs <= 0) {
                this.aLs = 10;
            }
            this.aLt = jSONObject.optInt("audio_gift_big_max", 15);
            if (this.aLt <= 0) {
                this.aLt = 15;
            }
            this.aLu = jSONObject.optInt("gift_small_max", 50);
            if (this.aLu <= 0) {
                this.aLu = 50;
            }
            this.aLv = jSONObject.optInt("gift_graffiti_max", 5);
            if (this.aLv <= 0) {
                this.aLv = 5;
            }
        }
    }

    private void DN() {
        this.aLb = com.baidu.live.d.Aq().getInt("guide_speak_watch_time", 15000);
        this.aLc = com.baidu.live.d.Aq().getInt("guide_speak_show_times_max", 3);
        String string = com.baidu.live.d.Aq().getString("guide_speak_texts", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                if (length != 0) {
                    this.aLd = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.aLd[i] = jSONArray.optString(i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void x(JSONObject jSONObject) {
        int length;
        this.aLb = jSONObject.optInt("rule_watch_time", 15000) * 1000;
        com.baidu.live.d.Aq().putInt("guide_speak_watch_time", this.aLb);
        this.aLc = jSONObject.optInt("rule_show_times", 3);
        com.baidu.live.d.Aq().putInt("guide_speak_show_times_max", this.aLc);
        JSONArray optJSONArray = jSONObject.optJSONArray("speak_txt");
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            this.aLd = new String[length];
            for (int i = 0; i < length; i++) {
                this.aLd[i] = optJSONArray.optString(i);
            }
            com.baidu.live.d.Aq().putString("guide_speak_texts", optJSONArray.toString());
        }
    }

    private void DO() {
        String string = com.baidu.live.d.Aq().getString("yuan_package_data", "");
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
            this.aLj = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    YuanPackageData yuanPackageData = new YuanPackageData();
                    yuanPackageData.parseJson(jSONArray.getJSONObject(i));
                    this.aLj.add(yuanPackageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void gk(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("static_im_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.aLl = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String str2 = (String) optJSONArray.opt(i);
                            if (!StringUtils.isNull(str2)) {
                                this.aLl.add(str2);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("what_im_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aLm = new ArrayList(optJSONArray2.length());
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String str3 = (String) optJSONArray2.opt(i2);
                            if (!StringUtils.isNull(str3)) {
                                this.aLm.add(str3);
                            }
                        }
                    }
                    com.baidu.live.d.Aq().putString("ala_quick_send_im_list", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void DP() {
        gk(com.baidu.live.d.Aq().getString("ala_quick_send_im_list", null));
    }

    private void gl(String str) {
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
        if (i != this.aKl) {
            z2 = true;
        }
        this.aKl = i;
        if (z || z2) {
            com.baidu.live.d.Aq().putInt("ala_live_session_default_key", i);
        }
    }

    private void DQ() {
        this.aKl = com.baidu.live.d.Aq().getInt("ala_live_session_default_key", 0);
        String string = com.baidu.live.d.Aq().getString("ala_live_session_domains_key", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string2)) {
                            this.aKm.add(string2.trim());
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.live.d.Aq().getString("ala_live_session_replace_key", null));
            if (jSONObject != null) {
                this.aKp = jSONObject.optString("hlsUrl");
                this.aKn = jSONObject.optString("rtmpUrl");
                this.aKo = jSONObject.optString("flvUrl");
                this.aKq = jSONObject.optString(".m3u8");
            }
        } catch (Exception e2) {
        }
    }

    public boolean DR() {
        return this.aKe == 1;
    }
}
