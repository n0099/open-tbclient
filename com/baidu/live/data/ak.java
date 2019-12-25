package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ak extends BaseData {
    public ah aaE;
    public ai aaF;
    public ac aaG;
    public as aaH;
    public bb aaI;
    public ae aaJ;
    public ax aaK;
    public az aaL;
    public bc aaM;
    public aq aaN;
    public an aaO;
    public ba aaP;
    public aj aaQ;
    public ap aaR;
    public bf aaS;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aaE = new ah(optJSONObject.optString("general_exchange"));
            this.aaF = new ai(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aaS = new bf();
            if (optJSONObject2 != null) {
                this.aaS.o(optJSONObject2);
            }
            this.aaG = new ac(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aaH = new as(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aaI = new bb();
                this.aaI.acv = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aaK = new ax();
                this.aaK.acg = optJSONObject4.optInt("cash_gift") == 1;
                this.aaK.ach = optJSONObject4.optInt("pay_barrage") == 1;
                this.aaK.aci = optJSONObject4.optInt("flower_guide") == 1;
                this.aaK.acj = optJSONObject4.optInt("guard_club") == 1;
                this.aaK.acm = optJSONObject4.optInt("first_recharge") == 1;
                this.aaK.acn = optJSONObject4.optInt("rotary_table") == 1;
                this.aaK.aco = optJSONObject4.optInt("red_packet") == 1;
                this.aaK.acp = optJSONObject4.optInt("host_wish") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aaJ = new ae(optJSONObject5);
            }
            this.aaL = new az(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aaM = new bc();
                this.aaM.acx = optJSONObject6.optString("agreement");
                this.aaM.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aaN = new aq();
                this.aaN.abq = optJSONObject7.optString("my_zhibo");
                this.aaN.abr = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aaO = new an();
                this.aaO.abj = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aaQ = new aj();
                this.aaQ.aaC = optJSONObject9.optString("manage");
                this.aaQ.aaD = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aaP = new ba();
                this.aaP.acu = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.oI().putInt("guide_rename_switch", this.aaP.acu);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aaR = new ap();
                this.aaR.abm = optJSONObject11.optInt("haokan_switch");
                this.aaR.abn = optJSONObject11.optInt("quanmin_switch");
                this.aaR.abo = optJSONObject11.optInt("tieba_switch");
                this.aaR.abp = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
