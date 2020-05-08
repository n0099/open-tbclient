package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class as extends BaseData {
    public bb avA;
    public bk avB;
    public am avC;
    public bg avD;
    public bi avE;
    public bl avF;
    public az avG;
    public aw avH;
    public bj avI;
    public ar avJ;
    public ay avK;
    public bo avL;
    public ap avx;
    public aq avy;
    public ak avz;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.avx = new ap(optJSONObject.optString("general_exchange"));
            this.avy = new aq(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.avL = new bo();
            if (optJSONObject2 != null) {
                this.avL.fromJson(optJSONObject2);
            }
            this.avz = new ak(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.avA = new bb(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.avB = new bk();
                this.avB.axq = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.avD = new bg();
                this.avD.axc = optJSONObject4.optInt("cash_gift") == 1;
                this.avD.axd = optJSONObject4.optInt("pay_barrage") == 1;
                this.avD.axe = optJSONObject4.optInt("flower_guide") == 1;
                this.avD.axf = optJSONObject4.optInt("guard_club") == 1;
                this.avD.axg = optJSONObject4.optInt("first_recharge") == 1;
                this.avD.axh = optJSONObject4.optInt("rotary_table") == 1;
                this.avD.axi = optJSONObject4.optInt("red_packet") == 1;
                this.avD.axj = optJSONObject4.optInt("host_wish") == 1;
                this.avD.axk = optJSONObject4.optInt("alpha_video") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.avC = new am(optJSONObject5);
            }
            this.avE = new bi(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.avF = new bl();
                this.avF.axr = optJSONObject6.optString("agreement");
                this.avF.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.avG = new az();
                this.avG.awo = optJSONObject7.optString("my_zhibo");
                this.avG.awp = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.avH = new aw();
                this.avH.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.avJ = new ar();
                this.avJ.avv = optJSONObject9.optString("manage");
                this.avJ.avw = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.avI = new bj();
                this.avI.axp = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.tG().putInt("guide_rename_switch", this.avI.axp);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.avK = new ay();
                this.avK.awk = optJSONObject11.optInt("haokan_switch");
                this.avK.awl = optJSONObject11.optInt("quanmin_switch");
                this.avK.awm = optJSONObject11.optInt("tieba_switch");
                this.avK.awn = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
