package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ax extends BaseData {
    public au aAF;
    public av aAG;
    public ao aAH;
    public bg aAI;
    public bp aAJ;
    public ar aAK;
    public bl aAL;
    public bn aAM;
    public bq aAN;
    public be aAO;
    public bb aAP;
    public bo aAQ;
    public aw aAR;
    public bd aAS;
    public bt aAT;
    public List<String> aAU = new ArrayList();

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aAF = new au(optJSONObject.optString("general_exchange"));
            this.aAG = new av(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aAT = new bt();
            if (optJSONObject2 != null) {
                this.aAT.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aAU.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aAU.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aAH = new ao(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aAI = new bg(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aAJ = new bp();
                this.aAJ.aCG = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aAL = new bl();
                this.aAL.aCr = optJSONObject4.optInt("cash_gift") == 1;
                this.aAL.aCs = optJSONObject4.optInt("pay_barrage") == 1;
                this.aAL.aCt = optJSONObject4.optInt("flower_guide") == 1;
                this.aAL.aCu = optJSONObject4.optInt("guard_club") == 1;
                this.aAL.aCv = optJSONObject4.optInt("first_recharge") == 1;
                this.aAL.aCw = optJSONObject4.optInt("rotary_table") == 1;
                this.aAL.aCx = optJSONObject4.optInt("red_packet") == 1;
                this.aAL.aCy = optJSONObject4.optInt("host_wish") == 1;
                this.aAL.aCz = optJSONObject4.optInt("alpha_video") == 1;
                this.aAL.aCA = optJSONObject4.optInt("noble_switch") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aAK = new ar(optJSONObject5);
            }
            this.aAM = new bn(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aAN = new bq();
                this.aAN.aCH = optJSONObject6.optString("agreement");
                this.aAN.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aAO = new be();
                this.aAO.aBx = optJSONObject7.optString("my_zhibo");
                this.aAO.aBy = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aAP = new bb();
                this.aAP.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aAR = new aw();
                this.aAR.aAD = optJSONObject9.optString("manage");
                this.aAR.aAE = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aAQ = new bo();
                this.aAQ.aCF = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.uN().putInt("guide_rename_switch", this.aAQ.aCF);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aAS = new bd();
                this.aAS.aBt = optJSONObject11.optInt("haokan_switch");
                this.aAS.aBu = optJSONObject11.optInt("quanmin_switch");
                this.aAS.aBv = optJSONObject11.optInt("tieba_switch");
                this.aAS.aBw = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
