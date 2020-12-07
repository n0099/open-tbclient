package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bo extends BaseData {
    public bl aQJ;
    public bm aQK;
    public bg aQL;
    public cf aQM;
    public cq aQN;
    public bj aQO;
    public ck aQP;
    public cm aQQ;
    public cr aQR;
    public cd aQS;
    public bv aQT;
    public cn aQU;
    public bn aQV;
    public ca aQW;
    public cu aQX;
    public List<String> aQY = new ArrayList();

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aQJ = new bl(optJSONObject.optString("general_exchange"));
            this.aQK = new bm(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aQX = new cu();
            if (optJSONObject2 != null) {
                this.aQX.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aQY.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aQY.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aQL = new bg(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aQM = new cf(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aQN = new cq();
                this.aQN.aTH = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aQP = new ck();
                this.aQP.aTe = optJSONObject4.optInt("cash_gift") == 1;
                this.aQP.aTf = optJSONObject4.optInt("pay_barrage") == 1;
                this.aQP.aTg = optJSONObject4.optInt("flower_guide") == 1;
                this.aQP.aTh = optJSONObject4.optInt("guard_club") == 1;
                this.aQP.aTi = optJSONObject4.optInt("first_recharge") == 1;
                this.aQP.aTj = optJSONObject4.optInt("rotary_table") == 1;
                this.aQP.aTk = optJSONObject4.optInt("red_packet") == 1;
                this.aQP.aTl = optJSONObject4.optInt("host_wish") == 1;
                this.aQP.aTm = optJSONObject4.optInt("alpha_video") == 1;
                this.aQP.aTn = optJSONObject4.optInt("noble_switch") == 1;
                this.aQP.aTo = optJSONObject4.optInt("noble_buy_switch") == 1;
                this.aQP.aTp = optJSONObject4.optInt("noble_audio_gift_show") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aQO = new bj(optJSONObject5);
            }
            this.aQQ = new cm(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aQR = new cr();
                this.aQR.aTI = optJSONObject6.optString("agreement");
                this.aQR.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aQS = new cd();
                this.aQS.aSc = optJSONObject7.optString("my_zhibo");
                this.aQS.aSd = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aQT = new bv();
                this.aQT.aRI = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aQV = new bn();
                this.aQV.aQH = optJSONObject9.optString("manage");
                this.aQV.aQI = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aQU = new cn();
                this.aQU.aTw = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.d.BM().putInt("guide_rename_switch", this.aQU.aTw);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aQW = new ca();
                this.aQW.aRP = optJSONObject11.optInt("haokan_switch");
                this.aQW.aRQ = optJSONObject11.optInt("quanmin_switch");
                this.aQW.aRR = optJSONObject11.optInt("tieba_switch");
                this.aQW.aRS = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
