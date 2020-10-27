package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bm extends BaseData {
    public cb aOA;
    public cl aOB;
    public bg aOC;
    public cg aOD;
    public ci aOE;
    public cm aOF;
    public bz aOG;
    public bt aOH;
    public cj aOI;
    public bl aOJ;
    public bx aOK;
    public cp aOL;
    public List<String> aOM = new ArrayList();
    public bj aOx;
    public bk aOy;
    public bd aOz;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aOx = new bj(optJSONObject.optString("general_exchange"));
            this.aOy = new bk(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aOL = new cp();
            if (optJSONObject2 != null) {
                this.aOL.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aOM.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aOM.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aOz = new bd(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aOA = new cb(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aOB = new cl();
                this.aOB.aRk = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aOD = new cg();
                this.aOD.aQL = optJSONObject4.optInt("cash_gift") == 1;
                this.aOD.aQM = optJSONObject4.optInt("pay_barrage") == 1;
                this.aOD.aQN = optJSONObject4.optInt("flower_guide") == 1;
                this.aOD.aQO = optJSONObject4.optInt("guard_club") == 1;
                this.aOD.aQP = optJSONObject4.optInt("first_recharge") == 1;
                this.aOD.aQQ = optJSONObject4.optInt("rotary_table") == 1;
                this.aOD.aQR = optJSONObject4.optInt("red_packet") == 1;
                this.aOD.aQS = optJSONObject4.optInt("host_wish") == 1;
                this.aOD.aQT = optJSONObject4.optInt("alpha_video") == 1;
                this.aOD.aQU = optJSONObject4.optInt("noble_switch") == 1;
                this.aOD.aQV = optJSONObject4.optInt("noble_buy_switch") == 1;
                this.aOD.aQW = optJSONObject4.optInt("noble_audio_gift_show") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aOC = new bg(optJSONObject5);
            }
            this.aOE = new ci(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aOF = new cm();
                this.aOF.aRl = optJSONObject6.optString("agreement");
                this.aOF.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aOG = new bz();
                this.aOG.aPJ = optJSONObject7.optString("my_zhibo");
                this.aOG.aPK = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aOH = new bt();
                this.aOH.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aOJ = new bl();
                this.aOJ.aOv = optJSONObject9.optString("manage");
                this.aOJ.aOw = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aOI = new cj();
                this.aOI.aRd = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.d.AZ().putInt("guide_rename_switch", this.aOI.aRd);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aOK = new bx();
                this.aOK.aPB = optJSONObject11.optInt("haokan_switch");
                this.aOK.aPC = optJSONObject11.optInt("quanmin_switch");
                this.aOK.aPD = optJSONObject11.optInt("tieba_switch");
                this.aOK.aPE = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
