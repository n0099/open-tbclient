package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bq extends BaseData {
    public bn aML;
    public bo aMM;
    public bi aMN;
    public ch aMO;
    public cs aMP;
    public bl aMQ;
    public cm aMR;
    public co aMS;
    public ct aMT;
    public cf aMU;
    public bx aMV;
    public cp aMW;
    public bp aMX;
    public cc aMY;
    public cw aMZ;
    public List<String> aNa = new ArrayList();

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aML = new bn(optJSONObject.optString("general_exchange"));
            this.aMM = new bo(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aMZ = new cw();
            if (optJSONObject2 != null) {
                this.aMZ.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aNa.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aNa.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aMN = new bi(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aMO = new ch(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aMP = new cs();
                this.aMP.aPS = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aMR = new cm();
                this.aMR.aPp = optJSONObject4.optInt("cash_gift") == 1;
                this.aMR.aPq = optJSONObject4.optInt("pay_barrage") == 1;
                this.aMR.aPr = optJSONObject4.optInt("flower_guide") == 1;
                this.aMR.aPs = optJSONObject4.optInt("guard_club") == 1;
                this.aMR.aPt = optJSONObject4.optInt("first_recharge") == 1;
                this.aMR.aPu = optJSONObject4.optInt("rotary_table") == 1;
                this.aMR.aPv = optJSONObject4.optInt("red_packet") == 1;
                this.aMR.aPw = optJSONObject4.optInt("host_wish") == 1;
                this.aMR.aPx = optJSONObject4.optInt("alpha_video") == 1;
                this.aMR.aPy = optJSONObject4.optInt("noble_switch") == 1;
                this.aMR.aPz = optJSONObject4.optInt("noble_buy_switch") == 1;
                this.aMR.aPA = optJSONObject4.optInt("noble_audio_gift_show") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aMQ = new bl(optJSONObject5);
            }
            this.aMS = new co(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aMT = new ct();
                this.aMT.aPT = optJSONObject6.optString("agreement");
                this.aMT.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aMU = new cf();
                this.aMU.aOk = optJSONObject7.optString("my_zhibo");
                this.aMU.aOl = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aMV = new bx();
                this.aMV.aNK = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aMX = new bp();
                this.aMX.aMJ = optJSONObject9.optString("manage");
                this.aMX.aMK = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aMW = new cp();
                this.aMW.aPH = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.d.xf().putInt("guide_rename_switch", this.aMW.aPH);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aMY = new cc();
                this.aMY.aNQ = optJSONObject11.optInt("haokan_switch");
                this.aMY.aNR = optJSONObject11.optInt("quanmin_switch");
                this.aMY.aNS = optJSONObject11.optInt("tieba_switch");
                this.aMY.aNT = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
