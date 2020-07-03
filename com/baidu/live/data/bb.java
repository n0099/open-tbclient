package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bb extends BaseData {
    public ay aCQ;
    public az aCR;
    public as aCS;
    public bl aCT;
    public bu aCU;
    public av aCV;
    public bq aCW;
    public bs aCX;
    public bv aCY;
    public bj aCZ;
    public bf aDa;
    public bt aDb;
    public ba aDc;
    public bi aDd;
    public by aDe;
    public List<String> aDf = new ArrayList();

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aCQ = new ay(optJSONObject.optString("general_exchange"));
            this.aCR = new az(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aDe = new by();
            if (optJSONObject2 != null) {
                this.aDe.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aDf.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aDf.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aCS = new as(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aCT = new bl(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aCU = new bu();
                this.aCU.aEY = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aCW = new bq();
                this.aCW.aEI = optJSONObject4.optInt("cash_gift") == 1;
                this.aCW.aEJ = optJSONObject4.optInt("pay_barrage") == 1;
                this.aCW.aEK = optJSONObject4.optInt("flower_guide") == 1;
                this.aCW.aEL = optJSONObject4.optInt("guard_club") == 1;
                this.aCW.aEM = optJSONObject4.optInt("first_recharge") == 1;
                this.aCW.aEN = optJSONObject4.optInt("rotary_table") == 1;
                this.aCW.aEO = optJSONObject4.optInt("red_packet") == 1;
                this.aCW.aEP = optJSONObject4.optInt("host_wish") == 1;
                this.aCW.aEQ = optJSONObject4.optInt("alpha_video") == 1;
                this.aCW.aER = optJSONObject4.optInt("noble_switch") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aCV = new av(optJSONObject5);
            }
            this.aCX = new bs(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aCY = new bv();
                this.aCY.aEZ = optJSONObject6.optString("agreement");
                this.aCY.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aCZ = new bj();
                this.aCZ.aDI = optJSONObject7.optString("my_zhibo");
                this.aCZ.aDJ = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aDa = new bf();
                this.aDa.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aDc = new ba();
                this.aDc.aCO = optJSONObject9.optString("manage");
                this.aDc.aCP = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aDb = new bt();
                this.aDb.aEX = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.vf().putInt("guide_rename_switch", this.aDb.aEX);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aDd = new bi();
                this.aDd.aDE = optJSONObject11.optInt("haokan_switch");
                this.aDd.aDF = optJSONObject11.optInt("quanmin_switch");
                this.aDd.aDG = optJSONObject11.optInt("tieba_switch");
                this.aDd.aDH = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
