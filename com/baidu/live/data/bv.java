package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bv extends BaseData {
    public bs aPJ;
    public bt aPK;
    public bn aPL;
    public co aPM;
    public cy aPN;
    public bq aPO;
    public ct aPP;
    public cu aPQ;
    public cz aPR;
    public cm aPS;
    public ce aPT;
    public cv aPU;
    public bu aPV;
    public cj aPW;
    public dc aPX;
    public List<String> aPY = new ArrayList();
    public k aPZ;
    public m aQa;
    public m aQb;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("guard_club");
            if (optJSONObject2 != null) {
                this.aPZ = new k(optJSONObject2.optString("member_commen_icon_conf"));
                this.aQa = new m(optJSONObject2.optString("member_golden_common_icon_conf"));
                this.aQb = new m(optJSONObject2.optString("member_golden_special_icon_conf"));
            }
            this.aPJ = new bs(optJSONObject.optString("general_exchange"));
            this.aPK = new bt(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("wishlist_conf");
            this.aPX = new dc();
            if (optJSONObject3 != null) {
                this.aPX.fromJson(optJSONObject3);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aPY.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aPY.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aPL = new bn(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aPM = new co(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject4 != null) {
                this.aPN = new cy();
                this.aPN.aSV = optJSONObject4.optString("send_gift_guide");
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject5 != null) {
                this.aPP = new ct();
                this.aPP.aSr = optJSONObject5.optInt("cash_gift") == 1;
                this.aPP.aSs = optJSONObject5.optInt("pay_barrage") == 1;
                this.aPP.aSt = optJSONObject5.optInt("flower_guide") == 1;
                this.aPP.aSu = optJSONObject5.optInt("guard_club") == 1;
                this.aPP.aSv = optJSONObject5.optInt("first_recharge") == 1;
                this.aPP.aSw = optJSONObject5.optInt("rotary_table") == 1;
                this.aPP.aSx = optJSONObject5.optInt("red_packet") == 1;
                this.aPP.aSy = optJSONObject5.optInt("host_wish") == 1;
                this.aPP.aSz = optJSONObject5.optInt("alpha_video") == 1;
                this.aPP.aSA = optJSONObject5.optInt("noble_switch") == 1;
                this.aPP.aSB = optJSONObject5.optInt("noble_buy_switch") == 1;
                this.aPP.aSC = optJSONObject5.optInt("noble_audio_gift_show") == 1;
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject6 != null) {
                this.aPO = new bq(optJSONObject6);
            }
            this.aPQ = new cu(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject7 != null) {
                this.aPR = new cz();
                this.aPR.aSW = optJSONObject7.optString("agreement");
                this.aPR.link = optJSONObject7.optString("link");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject8 != null) {
                this.aPS = new cm();
                this.aPS.aRn = optJSONObject8.optString("my_zhibo");
                this.aPS.aRo = optJSONObject8.optString("certify");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject9 != null) {
                this.aPT = new ce();
                this.aPT.aQL = optJSONObject9.optInt("decode_mode");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject10 != null) {
                this.aPV = new bu();
                this.aPV.aPH = optJSONObject10.optString("manage");
                this.aPV.aPI = optJSONObject10.optString("view");
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject11 != null) {
                this.aPU = new cv();
                this.aPU.aSJ = optJSONObject11.optInt("guide_rename_switch");
                com.baidu.live.d.xc().putInt("guide_rename_switch", this.aPU.aSJ);
            }
            JSONObject optJSONObject12 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject12 != null) {
                this.aPW = new cj();
                this.aPW.aQR = optJSONObject12.optInt("haokan_switch");
                this.aPW.aQS = optJSONObject12.optInt("quanmin_switch");
                this.aPW.aQT = optJSONObject12.optInt("tieba_switch");
                this.aPW.aQU = optJSONObject12.optInt("shoubai_switch");
            }
        }
    }
}
