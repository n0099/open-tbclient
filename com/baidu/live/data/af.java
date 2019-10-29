package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class af extends BaseData {
    public ae Uc;
    public z Ud;
    public al Ue;
    public as Uf;
    public ab Ug;
    public ap Uh;
    public ar Ui;
    public at Uj;
    public aj Uk;
    public ai Ul;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.Uc = new ae(optJSONObject.optString("general_exchange"));
            this.Ud = new z(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.Ue = new al(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject2 != null) {
                this.Uf = new as();
                this.Uf.Vs = optJSONObject2.optString("send_gift_guide");
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject3 != null) {
                this.Uh = new ap();
                this.Uh.Vj = optJSONObject3.optInt("cash_gift") == 1;
                this.Uh.Vk = optJSONObject3.optInt("pay_barrage") == 1;
                this.Uh.Vl = optJSONObject3.optInt("flower_guide") == 1;
                this.Uh.Vm = optJSONObject3.optInt("guard_club") == 1;
                this.Uh.Vn = optJSONObject3.optInt("first_recharge") == 1;
                this.Uh.Vo = optJSONObject3.optInt("rotary_table") == 1;
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject4 != null) {
                this.Ug = new ab(optJSONObject4);
            }
            this.Ui = new ar(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject5 != null) {
                this.Uj = new at();
                this.Uj.Vt = optJSONObject5.optString("agreement");
                this.Uj.link = optJSONObject5.optString("link");
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject6 != null) {
                this.Uk = new aj();
                this.Uk.UD = optJSONObject6.optString("my_zhibo");
                this.Uk.UE = optJSONObject6.optString("certify");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject7 != null) {
                this.Ul = new ai();
                this.Ul.UC = optJSONObject7.optInt("decode_mode");
            }
        }
    }
}
