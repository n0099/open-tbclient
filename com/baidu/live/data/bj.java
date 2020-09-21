package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bj extends BaseData {
    public bg aKN;
    public bh aKO;
    public ba aKP;
    public bw aKQ;
    public cf aKR;
    public bd aKS;
    public cb aKT;
    public cd aKU;
    public cg aKV;
    public bu aKW;
    public bp aKX;
    public ce aKY;
    public bi aKZ;
    public bs aLa;
    public cj aLb;
    public List<String> aLc = new ArrayList();

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aKN = new bg(optJSONObject.optString("general_exchange"));
            this.aKO = new bh(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aLb = new cj();
            if (optJSONObject2 != null) {
                this.aLb.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aLc.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aLc.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aKP = new ba(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aKQ = new bw(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aKR = new cf();
                this.aKR.aNo = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aKT = new cb();
                this.aKT.aMW = optJSONObject4.optInt("cash_gift") == 1;
                this.aKT.aMX = optJSONObject4.optInt("pay_barrage") == 1;
                this.aKT.aMY = optJSONObject4.optInt("flower_guide") == 1;
                this.aKT.aMZ = optJSONObject4.optInt("guard_club") == 1;
                this.aKT.aNa = optJSONObject4.optInt("first_recharge") == 1;
                this.aKT.aNb = optJSONObject4.optInt("rotary_table") == 1;
                this.aKT.aNc = optJSONObject4.optInt("red_packet") == 1;
                this.aKT.aNd = optJSONObject4.optInt("host_wish") == 1;
                this.aKT.aNe = optJSONObject4.optInt("alpha_video") == 1;
                this.aKT.aNf = optJSONObject4.optInt("noble_switch") == 1;
                this.aKT.aNg = optJSONObject4.optInt("noble_buy_switch") == 1;
                this.aKT.aNh = optJSONObject4.optInt("noble_audio_gift_show") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aKS = new bd(optJSONObject5);
            }
            this.aKU = new cd(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aKV = new cg();
                this.aKV.aNp = optJSONObject6.optString("agreement");
                this.aKV.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aKW = new bu();
                this.aKW.aLU = optJSONObject7.optString("my_zhibo");
                this.aKW.aLV = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aKX = new bp();
                this.aKX.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aKZ = new bi();
                this.aKZ.aKL = optJSONObject9.optString("manage");
                this.aKZ.aKM = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aKY = new ce();
                this.aKY.aNn = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.AR().putInt("guide_rename_switch", this.aKY.aNn);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aLa = new bs();
                this.aLa.aLN = optJSONObject11.optInt("haokan_switch");
                this.aLa.aLO = optJSONObject11.optInt("quanmin_switch");
                this.aLa.aLP = optJSONObject11.optInt("tieba_switch");
                this.aLa.aLQ = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
