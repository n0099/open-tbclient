package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class be extends BaseData {
    public ay aJA;
    public bt aJB;
    public bv aJC;
    public by aJD;
    public bm aJE;
    public bi aJF;
    public bw aJG;
    public bd aJH;
    public bl aJI;
    public cb aJJ;
    public List<String> aJK = new ArrayList();
    public bb aJv;
    public bc aJw;
    public av aJx;
    public bo aJy;
    public bx aJz;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aJv = new bb(optJSONObject.optString("general_exchange"));
            this.aJw = new bc(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aJJ = new cb();
            if (optJSONObject2 != null) {
                this.aJJ.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aJK.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aJK.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aJx = new av(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aJy = new bo(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aJz = new bx();
                this.aJz.aLD = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aJB = new bt();
                this.aJB.aLm = optJSONObject4.optInt("cash_gift") == 1;
                this.aJB.aLn = optJSONObject4.optInt("pay_barrage") == 1;
                this.aJB.aLo = optJSONObject4.optInt("flower_guide") == 1;
                this.aJB.aLp = optJSONObject4.optInt("guard_club") == 1;
                this.aJB.aLq = optJSONObject4.optInt("first_recharge") == 1;
                this.aJB.aLr = optJSONObject4.optInt("rotary_table") == 1;
                this.aJB.aLs = optJSONObject4.optInt("red_packet") == 1;
                this.aJB.aLt = optJSONObject4.optInt("host_wish") == 1;
                this.aJB.aLu = optJSONObject4.optInt("alpha_video") == 1;
                this.aJB.aLv = optJSONObject4.optInt("noble_switch") == 1;
                this.aJB.aLw = optJSONObject4.optInt("noble_buy_switch") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aJA = new ay(optJSONObject5);
            }
            this.aJC = new bv(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aJD = new by();
                this.aJD.aLE = optJSONObject6.optString("agreement");
                this.aJD.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aJE = new bm();
                this.aJE.aKm = optJSONObject7.optString("my_zhibo");
                this.aJE.aKn = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aJF = new bi();
                this.aJF.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aJH = new bd();
                this.aJH.aJt = optJSONObject9.optString("manage");
                this.aJH.aJu = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aJG = new bw();
                this.aJG.aLC = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.AD().putInt("guide_rename_switch", this.aJG.aLC);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aJI = new bl();
                this.aJI.aKi = optJSONObject11.optInt("haokan_switch");
                this.aJI.aKj = optJSONObject11.optInt("quanmin_switch");
                this.aJI.aKk = optJSONObject11.optInt("tieba_switch");
                this.aJI.aKl = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
