package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ap extends BaseData {
    public am acP;
    public an acQ;
    public ah acR;
    public ay acS;
    public bh acT;
    public aj acU;
    public bd acV;
    public bf acW;
    public bi acX;
    public aw acY;
    public at acZ;
    public bg ada;
    public ao adb;
    public av adc;
    public bl ade;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.acP = new am(optJSONObject.optString("general_exchange"));
            this.acQ = new an(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.ade = new bl();
            if (optJSONObject2 != null) {
                this.ade.fromJson(optJSONObject2);
            }
            this.acR = new ah(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.acS = new ay(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.acT = new bh();
                this.acT.aeK = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.acV = new bd();
                this.acV.aew = optJSONObject4.optInt("cash_gift") == 1;
                this.acV.aex = optJSONObject4.optInt("pay_barrage") == 1;
                this.acV.aey = optJSONObject4.optInt("flower_guide") == 1;
                this.acV.aez = optJSONObject4.optInt("guard_club") == 1;
                this.acV.aeA = optJSONObject4.optInt("first_recharge") == 1;
                this.acV.aeB = optJSONObject4.optInt("rotary_table") == 1;
                this.acV.aeC = optJSONObject4.optInt("red_packet") == 1;
                this.acV.aeD = optJSONObject4.optInt("host_wish") == 1;
                this.acV.aeE = optJSONObject4.optInt("alpha_video") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.acU = new aj(optJSONObject5);
            }
            this.acW = new bf(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.acX = new bi();
                this.acX.aeL = optJSONObject6.optString("agreement");
                this.acX.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.acY = new aw();
                this.acY.adH = optJSONObject7.optString("my_zhibo");
                this.acY.adI = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.acZ = new at();
                this.acZ.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.adb = new ao();
                this.adb.acN = optJSONObject9.optString("manage");
                this.adb.acO = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.ada = new bg();
                this.ada.aeJ = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.pr().putInt("guide_rename_switch", this.ada.aeJ);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.adc = new av();
                this.adc.adD = optJSONObject11.optInt("haokan_switch");
                this.adc.adE = optJSONObject11.optInt("quanmin_switch");
                this.adc.adF = optJSONObject11.optInt("tieba_switch");
                this.adc.adG = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
