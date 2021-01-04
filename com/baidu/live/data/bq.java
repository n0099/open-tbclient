package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bq extends BaseData {
    public bi aRA;
    public ch aRB;
    public cs aRC;
    public bl aRD;
    public cm aRE;
    public co aRF;
    public ct aRG;
    public cf aRH;
    public bx aRI;
    public cp aRJ;
    public bp aRK;
    public cc aRL;
    public cw aRM;
    public List<String> aRN = new ArrayList();
    public bn aRy;
    public bo aRz;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aRy = new bn(optJSONObject.optString("general_exchange"));
            this.aRz = new bo(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aRM = new cw();
            if (optJSONObject2 != null) {
                this.aRM.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aRN.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aRN.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aRA = new bi(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aRB = new ch(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aRC = new cs();
                this.aRC.aUF = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aRE = new cm();
                this.aRE.aUc = optJSONObject4.optInt("cash_gift") == 1;
                this.aRE.aUd = optJSONObject4.optInt("pay_barrage") == 1;
                this.aRE.aUe = optJSONObject4.optInt("flower_guide") == 1;
                this.aRE.aUf = optJSONObject4.optInt("guard_club") == 1;
                this.aRE.aUg = optJSONObject4.optInt("first_recharge") == 1;
                this.aRE.aUh = optJSONObject4.optInt("rotary_table") == 1;
                this.aRE.aUi = optJSONObject4.optInt("red_packet") == 1;
                this.aRE.aUj = optJSONObject4.optInt("host_wish") == 1;
                this.aRE.aUk = optJSONObject4.optInt("alpha_video") == 1;
                this.aRE.aUl = optJSONObject4.optInt("noble_switch") == 1;
                this.aRE.aUm = optJSONObject4.optInt("noble_buy_switch") == 1;
                this.aRE.aUn = optJSONObject4.optInt("noble_audio_gift_show") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aRD = new bl(optJSONObject5);
            }
            this.aRF = new co(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aRG = new ct();
                this.aRG.aUG = optJSONObject6.optString("agreement");
                this.aRG.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aRH = new cf();
                this.aRH.aSX = optJSONObject7.optString("my_zhibo");
                this.aRH.aSY = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aRI = new bx();
                this.aRI.aSx = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aRK = new bp();
                this.aRK.aRw = optJSONObject9.optString("manage");
                this.aRK.aRx = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aRJ = new cp();
                this.aRJ.aUu = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.d.Ba().putInt("guide_rename_switch", this.aRJ.aUu);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aRL = new cc();
                this.aRL.aSD = optJSONObject11.optInt("haokan_switch");
                this.aRL.aSE = optJSONObject11.optInt("quanmin_switch");
                this.aRL.aSF = optJSONObject11.optInt("tieba_switch");
                this.aRL.aSG = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
