package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ao extends BaseData {
    public al aaR;
    public am aaS;
    public ag aaT;
    public aw aaU;
    public bf aaV;
    public ai aaW;
    public bb aaX;
    public bd aaY;
    public bg aaZ;
    public au aba;
    public ar abb;
    public be abd;
    public an abe;
    public at abf;
    public bj abg;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aaR = new al(optJSONObject.optString("general_exchange"));
            this.aaS = new am(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.abg = new bj();
            if (optJSONObject2 != null) {
                this.abg.fromJson(optJSONObject2);
            }
            this.aaT = new ag(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aaU = new aw(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aaV = new bf();
                this.aaV.acI = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aaX = new bb();
                this.aaX.acu = optJSONObject4.optInt("cash_gift") == 1;
                this.aaX.acv = optJSONObject4.optInt("pay_barrage") == 1;
                this.aaX.acx = optJSONObject4.optInt("flower_guide") == 1;
                this.aaX.acy = optJSONObject4.optInt("guard_club") == 1;
                this.aaX.acz = optJSONObject4.optInt("first_recharge") == 1;
                this.aaX.acA = optJSONObject4.optInt("rotary_table") == 1;
                this.aaX.acB = optJSONObject4.optInt("red_packet") == 1;
                this.aaX.acC = optJSONObject4.optInt("host_wish") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aaW = new ai(optJSONObject5);
            }
            this.aaY = new bd(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aaZ = new bg();
                this.aaZ.acJ = optJSONObject6.optString("agreement");
                this.aaZ.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aba = new au();
                this.aba.abC = optJSONObject7.optString("my_zhibo");
                this.aba.abD = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.abb = new ar();
                this.abb.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.abe = new an();
                this.abe.aaP = optJSONObject9.optString("manage");
                this.abe.aaQ = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.abd = new be();
                this.abd.acH = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.oJ().putInt("guide_rename_switch", this.abd.acH);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.abf = new at();
                this.abf.aby = optJSONObject11.optInt("haokan_switch");
                this.abf.abz = optJSONObject11.optInt("quanmin_switch");
                this.abf.abA = optJSONObject11.optInt("tieba_switch");
                this.abf.abB = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
