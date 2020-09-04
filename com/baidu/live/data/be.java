package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class be extends BaseData {
    public bo aJA;
    public bx aJB;
    public ay aJC;
    public bt aJD;
    public bv aJE;
    public by aJF;
    public bm aJG;
    public bi aJH;
    public bw aJI;
    public bd aJJ;
    public bl aJK;
    public cb aJL;
    public List<String> aJM = new ArrayList();
    public bb aJx;
    public bc aJy;
    public av aJz;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aJx = new bb(optJSONObject.optString("general_exchange"));
            this.aJy = new bc(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aJL = new cb();
            if (optJSONObject2 != null) {
                this.aJL.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aJM.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aJM.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aJz = new av(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aJA = new bo(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aJB = new bx();
                this.aJB.aLF = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aJD = new bt();
                this.aJD.aLo = optJSONObject4.optInt("cash_gift") == 1;
                this.aJD.aLp = optJSONObject4.optInt("pay_barrage") == 1;
                this.aJD.aLq = optJSONObject4.optInt("flower_guide") == 1;
                this.aJD.aLr = optJSONObject4.optInt("guard_club") == 1;
                this.aJD.aLs = optJSONObject4.optInt("first_recharge") == 1;
                this.aJD.aLt = optJSONObject4.optInt("rotary_table") == 1;
                this.aJD.aLu = optJSONObject4.optInt("red_packet") == 1;
                this.aJD.aLv = optJSONObject4.optInt("host_wish") == 1;
                this.aJD.aLw = optJSONObject4.optInt("alpha_video") == 1;
                this.aJD.aLx = optJSONObject4.optInt("noble_switch") == 1;
                this.aJD.aLy = optJSONObject4.optInt("noble_buy_switch") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aJC = new ay(optJSONObject5);
            }
            this.aJE = new bv(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aJF = new by();
                this.aJF.aLG = optJSONObject6.optString("agreement");
                this.aJF.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aJG = new bm();
                this.aJG.aKo = optJSONObject7.optString("my_zhibo");
                this.aJG.aKp = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aJH = new bi();
                this.aJH.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aJJ = new bd();
                this.aJJ.aJv = optJSONObject9.optString("manage");
                this.aJJ.aJw = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aJI = new bw();
                this.aJI.aLE = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.AD().putInt("guide_rename_switch", this.aJI.aLE);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aJK = new bl();
                this.aJK.aKk = optJSONObject11.optInt("haokan_switch");
                this.aJK.aKl = optJSONObject11.optInt("quanmin_switch");
                this.aJK.aKm = optJSONObject11.optInt("tieba_switch");
                this.aJK.aKn = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
