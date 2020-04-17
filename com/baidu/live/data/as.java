package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class as extends BaseData {
    public az avA;
    public aw avB;
    public bj avC;
    public ar avD;
    public ay avE;
    public bo avF;
    public ap avr;
    public aq avs;
    public ak avt;
    public bb avu;
    public bk avv;
    public am avw;
    public bg avx;
    public bi avy;
    public bl avz;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.avr = new ap(optJSONObject.optString("general_exchange"));
            this.avs = new aq(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.avF = new bo();
            if (optJSONObject2 != null) {
                this.avF.fromJson(optJSONObject2);
            }
            this.avt = new ak(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.avu = new bb(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.avv = new bk();
                this.avv.axk = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.avx = new bg();
                this.avx.awW = optJSONObject4.optInt("cash_gift") == 1;
                this.avx.awX = optJSONObject4.optInt("pay_barrage") == 1;
                this.avx.awY = optJSONObject4.optInt("flower_guide") == 1;
                this.avx.awZ = optJSONObject4.optInt("guard_club") == 1;
                this.avx.axa = optJSONObject4.optInt("first_recharge") == 1;
                this.avx.axb = optJSONObject4.optInt("rotary_table") == 1;
                this.avx.axc = optJSONObject4.optInt("red_packet") == 1;
                this.avx.axd = optJSONObject4.optInt("host_wish") == 1;
                this.avx.axe = optJSONObject4.optInt("alpha_video") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.avw = new am(optJSONObject5);
            }
            this.avy = new bi(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.avz = new bl();
                this.avz.axl = optJSONObject6.optString("agreement");
                this.avz.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.avA = new az();
                this.avA.awi = optJSONObject7.optString("my_zhibo");
                this.avA.awj = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.avB = new aw();
                this.avB.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.avD = new ar();
                this.avD.avp = optJSONObject9.optString("manage");
                this.avD.avq = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.avC = new bj();
                this.avC.axj = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.tH().putInt("guide_rename_switch", this.avC.axj);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.avE = new ay();
                this.avE.awe = optJSONObject11.optInt("haokan_switch");
                this.avE.awf = optJSONObject11.optInt("quanmin_switch");
                this.avE.awg = optJSONObject11.optInt("tieba_switch");
                this.avE.awh = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
