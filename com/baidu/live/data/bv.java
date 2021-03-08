package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bv extends BaseData {
    public m aRA;
    public m aRB;
    public bs aRj;
    public bt aRk;
    public bn aRl;
    public co aRm;
    public cy aRn;
    public bq aRo;
    public ct aRp;
    public cu aRq;
    public cz aRr;
    public cm aRs;
    public ce aRt;
    public cv aRu;
    public bu aRv;
    public cj aRw;
    public dc aRx;
    public List<String> aRy = new ArrayList();
    public k aRz;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("guard_club");
            if (optJSONObject2 != null) {
                this.aRz = new k(optJSONObject2.optString("member_commen_icon_conf"));
                this.aRA = new m(optJSONObject2.optString("member_golden_common_icon_conf"));
                this.aRB = new m(optJSONObject2.optString("member_golden_special_icon_conf"));
            }
            this.aRj = new bs(optJSONObject.optString("general_exchange"));
            this.aRk = new bt(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("wishlist_conf");
            this.aRx = new dc();
            if (optJSONObject3 != null) {
                this.aRx.fromJson(optJSONObject3);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aRy.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aRy.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aRl = new bn(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aRm = new co(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject4 != null) {
                this.aRn = new cy();
                this.aRn.aUv = optJSONObject4.optString("send_gift_guide");
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject5 != null) {
                this.aRp = new ct();
                this.aRp.aTR = optJSONObject5.optInt("cash_gift") == 1;
                this.aRp.aTS = optJSONObject5.optInt("pay_barrage") == 1;
                this.aRp.aTT = optJSONObject5.optInt("flower_guide") == 1;
                this.aRp.aTU = optJSONObject5.optInt("guard_club") == 1;
                this.aRp.aTV = optJSONObject5.optInt("first_recharge") == 1;
                this.aRp.aTW = optJSONObject5.optInt("rotary_table") == 1;
                this.aRp.aTX = optJSONObject5.optInt("red_packet") == 1;
                this.aRp.aTY = optJSONObject5.optInt("host_wish") == 1;
                this.aRp.aTZ = optJSONObject5.optInt("alpha_video") == 1;
                this.aRp.aUa = optJSONObject5.optInt("noble_switch") == 1;
                this.aRp.aUb = optJSONObject5.optInt("noble_buy_switch") == 1;
                this.aRp.aUc = optJSONObject5.optInt("noble_audio_gift_show") == 1;
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject6 != null) {
                this.aRo = new bq(optJSONObject6);
            }
            this.aRq = new cu(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject7 != null) {
                this.aRr = new cz();
                this.aRr.aUw = optJSONObject7.optString("agreement");
                this.aRr.link = optJSONObject7.optString("link");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject8 != null) {
                this.aRs = new cm();
                this.aRs.aSN = optJSONObject8.optString("my_zhibo");
                this.aRs.aSO = optJSONObject8.optString("certify");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject9 != null) {
                this.aRt = new ce();
                this.aRt.aSl = optJSONObject9.optInt("decode_mode");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject10 != null) {
                this.aRv = new bu();
                this.aRv.aRh = optJSONObject10.optString("manage");
                this.aRv.aRi = optJSONObject10.optString("view");
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject11 != null) {
                this.aRu = new cv();
                this.aRu.aUj = optJSONObject11.optInt("guide_rename_switch");
                com.baidu.live.d.xf().putInt("guide_rename_switch", this.aRu.aUj);
            }
            JSONObject optJSONObject12 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject12 != null) {
                this.aRw = new cj();
                this.aRw.aSr = optJSONObject12.optInt("haokan_switch");
                this.aRw.aSs = optJSONObject12.optInt("quanmin_switch");
                this.aRw.aSt = optJSONObject12.optInt("tieba_switch");
                this.aRw.aSu = optJSONObject12.optInt("shoubai_switch");
            }
        }
    }
}
