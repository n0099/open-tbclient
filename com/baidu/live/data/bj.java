package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bj extends BaseData {
    public bg aNS;
    public bh aNT;
    public ba aNU;
    public bw aNV;
    public cg aNW;
    public bd aNX;
    public cb aNY;
    public cd aNZ;
    public ch aOa;
    public bu aOb;
    public bp aOc;
    public ce aOd;
    public bi aOe;
    public bs aOf;
    public ck aOg;
    public List<String> aOh = new ArrayList();

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aNS = new bg(optJSONObject.optString("general_exchange"));
            this.aNT = new bh(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aOg = new ck();
            if (optJSONObject2 != null) {
                this.aOg.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aOh.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aOh.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aNU = new ba(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aNV = new bw(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aNW = new cg();
                this.aNW.aQz = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aNY = new cb();
                this.aNY.aQb = optJSONObject4.optInt("cash_gift") == 1;
                this.aNY.aQc = optJSONObject4.optInt("pay_barrage") == 1;
                this.aNY.aQd = optJSONObject4.optInt("flower_guide") == 1;
                this.aNY.aQe = optJSONObject4.optInt("guard_club") == 1;
                this.aNY.aQf = optJSONObject4.optInt("first_recharge") == 1;
                this.aNY.aQg = optJSONObject4.optInt("rotary_table") == 1;
                this.aNY.aQh = optJSONObject4.optInt("red_packet") == 1;
                this.aNY.aQi = optJSONObject4.optInt("host_wish") == 1;
                this.aNY.aQj = optJSONObject4.optInt("alpha_video") == 1;
                this.aNY.aQk = optJSONObject4.optInt("noble_switch") == 1;
                this.aNY.aQl = optJSONObject4.optInt("noble_buy_switch") == 1;
                this.aNY.aQm = optJSONObject4.optInt("noble_audio_gift_show") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aNX = new bd(optJSONObject5);
            }
            this.aNZ = new cd(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aOa = new ch();
                this.aOa.aQA = optJSONObject6.optString("agreement");
                this.aOa.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aOb = new bu();
                this.aOb.aOZ = optJSONObject7.optString("my_zhibo");
                this.aOb.aPa = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aOc = new bp();
                this.aOc.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aOe = new bi();
                this.aOe.aNQ = optJSONObject9.optString("manage");
                this.aOe.aNR = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aOd = new ce();
                this.aOd.aQs = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.AZ().putInt("guide_rename_switch", this.aOd.aQs);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aOf = new bs();
                this.aOf.aOS = optJSONObject11.optInt("haokan_switch");
                this.aOf.aOT = optJSONObject11.optInt("quanmin_switch");
                this.aOf.aOU = optJSONObject11.optInt("tieba_switch");
                this.aOf.aOV = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
