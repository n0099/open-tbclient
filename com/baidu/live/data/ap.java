package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ap extends BaseData {
    public am acZ;
    public an ada;
    public ah adb;
    public ay adc;
    public bh ade;
    public aj adf;
    public bd adg;
    public bf adh;
    public bi adi;
    public aw adj;
    public at adk;
    public bg adl;
    public ao adm;
    public av adn;
    public bl ado;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.acZ = new am(optJSONObject.optString("general_exchange"));
            this.ada = new an(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.ado = new bl();
            if (optJSONObject2 != null) {
                this.ado.fromJson(optJSONObject2);
            }
            this.adb = new ah(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.adc = new ay(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.ade = new bh();
                this.ade.aeU = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.adg = new bd();
                this.adg.aeG = optJSONObject4.optInt("cash_gift") == 1;
                this.adg.aeH = optJSONObject4.optInt("pay_barrage") == 1;
                this.adg.aeI = optJSONObject4.optInt("flower_guide") == 1;
                this.adg.aeJ = optJSONObject4.optInt("guard_club") == 1;
                this.adg.aeK = optJSONObject4.optInt("first_recharge") == 1;
                this.adg.aeL = optJSONObject4.optInt("rotary_table") == 1;
                this.adg.aeM = optJSONObject4.optInt("red_packet") == 1;
                this.adg.aeN = optJSONObject4.optInt("host_wish") == 1;
                this.adg.aeO = optJSONObject4.optInt("alpha_video") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.adf = new aj(optJSONObject5);
            }
            this.adh = new bf(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.adi = new bi();
                this.adi.aeV = optJSONObject6.optString("agreement");
                this.adi.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.adj = new aw();
                this.adj.adR = optJSONObject7.optString("my_zhibo");
                this.adj.adS = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.adk = new at();
                this.adk.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.adm = new ao();
                this.adm.acX = optJSONObject9.optString("manage");
                this.adm.acY = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.adl = new bg();
                this.adl.aeT = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.pw().putInt("guide_rename_switch", this.adl.aeT);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.adn = new av();
                this.adn.adN = optJSONObject11.optInt("haokan_switch");
                this.adn.adO = optJSONObject11.optInt("quanmin_switch");
                this.adn.adP = optJSONObject11.optInt("tieba_switch");
                this.adn.adQ = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
