package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bc extends BaseData {
    public List<String> aEA = new ArrayList();
    public az aEl;
    public ba aEm;
    public at aEn;
    public bm aEo;
    public bv aEp;
    public aw aEq;
    public br aEr;
    public bt aEs;
    public bw aEt;
    public bk aEu;
    public bg aEv;
    public bu aEw;
    public bb aEx;
    public bj aEy;
    public bz aEz;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aEl = new az(optJSONObject.optString("general_exchange"));
            this.aEm = new ba(optJSONObject.optString("plug_control"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("wishlist_conf");
            this.aEz = new bz();
            if (optJSONObject2 != null) {
                this.aEz.fromJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("shownotice_royal_level");
            if (optJSONArray != null) {
                this.aEA.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        if (optJSONArray.get(i) instanceof String) {
                            this.aEA.add((String) optJSONArray.get(i));
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.aEn = new at(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.aEo = new bm(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject3 != null) {
                this.aEp = new bv();
                this.aEp.aGt = optJSONObject3.optString("send_gift_guide");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject4 != null) {
                this.aEr = new br();
                this.aEr.aGc = optJSONObject4.optInt("cash_gift") == 1;
                this.aEr.aGd = optJSONObject4.optInt("pay_barrage") == 1;
                this.aEr.aGe = optJSONObject4.optInt("flower_guide") == 1;
                this.aEr.aGf = optJSONObject4.optInt("guard_club") == 1;
                this.aEr.aGg = optJSONObject4.optInt("first_recharge") == 1;
                this.aEr.aGh = optJSONObject4.optInt("rotary_table") == 1;
                this.aEr.aGi = optJSONObject4.optInt("red_packet") == 1;
                this.aEr.aGj = optJSONObject4.optInt("host_wish") == 1;
                this.aEr.aGk = optJSONObject4.optInt("alpha_video") == 1;
                this.aEr.aGl = optJSONObject4.optInt("noble_switch") == 1;
                this.aEr.aGm = optJSONObject4.optInt("noble_buy_switch") == 1;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject5 != null) {
                this.aEq = new aw(optJSONObject5);
            }
            this.aEs = new bt(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject6 != null) {
                this.aEt = new bw();
                this.aEt.aGu = optJSONObject6.optString("agreement");
                this.aEt.link = optJSONObject6.optString("link");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject7 != null) {
                this.aEu = new bk();
                this.aEu.aFc = optJSONObject7.optString("my_zhibo");
                this.aEu.aFd = optJSONObject7.optString("certify");
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject8 != null) {
                this.aEv = new bg();
                this.aEv.decodeMode = optJSONObject8.optInt("decode_mode");
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("live_privilege_page");
            if (optJSONObject9 != null) {
                this.aEx = new bb();
                this.aEx.aEj = optJSONObject9.optString("manage");
                this.aEx.aEk = optJSONObject9.optString("view");
            }
            JSONObject optJSONObject10 = optJSONObject.optJSONObject("live_utility");
            if (optJSONObject10 != null) {
                this.aEw = new bu();
                this.aEw.aGs = optJSONObject10.optInt("guide_rename_switch");
                com.baidu.live.c.vf().putInt("guide_rename_switch", this.aEw.aGs);
            }
            JSONObject optJSONObject11 = optJSONObject.optJSONObject("anchortask_config");
            if (optJSONObject11 != null) {
                this.aEy = new bj();
                this.aEy.aEY = optJSONObject11.optInt("haokan_switch");
                this.aEy.aEZ = optJSONObject11.optInt("quanmin_switch");
                this.aEy.aFa = optJSONObject11.optInt("tieba_switch");
                this.aEy.aFb = optJSONObject11.optInt("shoubai_switch");
            }
        }
    }
}
