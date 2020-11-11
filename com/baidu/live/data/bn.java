package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bn extends BaseData {
    public ci aPA;
    public ck aPB;
    public cp aPC;
    public cb aPD;
    public bu aPE;
    public cl aPF;
    public bm aPG;
    public by aPH;
    public cs aPI;
    public List<String> aPJ = new ArrayList();
    public bk aPu;
    public bl aPv;
    public bf aPw;
    public cd aPx;
    public co aPy;
    public bi aPz;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aPu = new bk(optJSONObject.optString("general_exchange"));
            this.aPv = new bl(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aPI = new cs();
            if (optJSONObject2 != null) {
                this.aPI.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aPJ.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aPJ.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aPw = new bf(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aPx = new cd(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aPy = new co();
                this.aPy.aSq = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aPA = new ci();
                this.aPA.aRN = optJSONObject4.optInt("cash_gift") == 1;
                this.aPA.aRO = optJSONObject4.optInt("pay_barrage") == 1;
                this.aPA.aRP = optJSONObject4.optInt("flower_guide") == 1;
                this.aPA.aRQ = optJSONObject4.optInt("guard_club") == 1;
                this.aPA.aRR = optJSONObject4.optInt("first_recharge") == 1;
                this.aPA.aRS = optJSONObject4.optInt("rotary_table") == 1;
                this.aPA.aRT = optJSONObject4.optInt("red_packet") == 1;
                this.aPA.aRU = optJSONObject4.optInt("host_wish") == 1;
                this.aPA.aRV = optJSONObject4.optInt("alpha_video") == 1;
                this.aPA.aRW = optJSONObject4.optInt("noble_switch") == 1;
                this.aPA.aRX = optJSONObject4.optInt("noble_buy_switch") == 1;
                this.aPA.aRY = optJSONObject4.optInt("noble_audio_gift_show") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aPz = new bi(optJSONObject5);
            }
            this.aPB = new ck(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aPC = new cp();
                this.aPC.aSr = optJSONObject6.optString("agreement");
                this.aPC.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aPD = new cb();
                this.aPD.aQL = optJSONObject7.optString("my_zhibo");
                this.aPD.aQM = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aPE = new bu();
                this.aPE.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aPG = new bm();
                this.aPG.aPs = optJSONObject9.optString("manage");
                this.aPG.aPt = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aPF = new cl();
                this.aPF.aSf = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.d.AZ().putInt("guide_rename_switch", this.aPF.aSf);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aPH = new by();
                this.aPH.aQy = optJSONObject11.optInt("haokan_switch");
                this.aPH.aQz = optJSONObject11.optInt("quanmin_switch");
                this.aPH.aQA = optJSONObject11.optInt("tieba_switch");
                this.aPH.aQB = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
