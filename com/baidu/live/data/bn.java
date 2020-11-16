package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bn extends BaseData {
    public bk aNJ;
    public bl aNK;
    public bf aNL;
    public cd aNM;
    public co aNN;
    public bi aNO;
    public ci aNP;
    public ck aNQ;
    public cp aNR;
    public cb aNS;
    public bu aNT;
    public cl aNU;
    public bm aNV;
    public by aNW;
    public cs aNX;
    public List<String> aNY = new ArrayList();

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aNJ = new bk(optJSONObject.optString("general_exchange"));
            this.aNK = new bl(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aNX = new cs();
            if (optJSONObject2 != null) {
                this.aNX.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aNY.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aNY.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aNL = new bf(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aNM = new cd(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aNN = new co();
                this.aNN.aQF = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aNP = new ci();
                this.aNP.aQc = optJSONObject4.optInt("cash_gift") == 1;
                this.aNP.aQd = optJSONObject4.optInt("pay_barrage") == 1;
                this.aNP.aQe = optJSONObject4.optInt("flower_guide") == 1;
                this.aNP.aQf = optJSONObject4.optInt("guard_club") == 1;
                this.aNP.aQg = optJSONObject4.optInt("first_recharge") == 1;
                this.aNP.aQh = optJSONObject4.optInt("rotary_table") == 1;
                this.aNP.aQi = optJSONObject4.optInt("red_packet") == 1;
                this.aNP.aQj = optJSONObject4.optInt("host_wish") == 1;
                this.aNP.aQk = optJSONObject4.optInt("alpha_video") == 1;
                this.aNP.aQl = optJSONObject4.optInt("noble_switch") == 1;
                this.aNP.aQm = optJSONObject4.optInt("noble_buy_switch") == 1;
                this.aNP.aQn = optJSONObject4.optInt("noble_audio_gift_show") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aNO = new bi(optJSONObject5);
            }
            this.aNQ = new ck(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aNR = new cp();
                this.aNR.aQG = optJSONObject6.optString("agreement");
                this.aNR.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aNS = new cb();
                this.aNS.aPa = optJSONObject7.optString("my_zhibo");
                this.aNS.aPb = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aNT = new bu();
                this.aNT.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aNV = new bm();
                this.aNV.aNH = optJSONObject9.optString("manage");
                this.aNV.aNI = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aNU = new cl();
                this.aNU.aQu = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.d.Aq().putInt("guide_rename_switch", this.aNU.aQu);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aNW = new by();
                this.aNW.aON = optJSONObject11.optInt("haokan_switch");
                this.aNW.aOO = optJSONObject11.optInt("quanmin_switch");
                this.aNW.aOP = optJSONObject11.optInt("tieba_switch");
                this.aNW.aOQ = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
