package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class af extends BaseData {
    public ae TI;
    public z TJ;
    public al TK;
    public as TL;
    public ab TM;
    public ap TO;
    public ar TP;
    public at TQ;
    public aj TR;
    public ai TS;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.TI = new ae(optJSONObject.optString("general_exchange"));
            this.TJ = new z(optJSONObject.optJSONObject("guard_club"));
            if (optJSONObject.has("live_activity")) {
                this.TK = new al(optJSONObject.optJSONObject("live_activity"));
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("toast_text");
            if (optJSONObject2 != null) {
                this.TL = new as();
                this.TL.UZ = optJSONObject2.optString("send_gift_guide");
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("live_activity_switch");
            if (optJSONObject3 != null) {
                this.TO = new ap();
                this.TO.UQ = optJSONObject3.optInt("cash_gift") == 1;
                this.TO.UR = optJSONObject3.optInt("pay_barrage") == 1;
                this.TO.US = optJSONObject3.optInt("flower_guide") == 1;
                this.TO.UT = optJSONObject3.optInt("guard_club") == 1;
                this.TO.UU = optJSONObject3.optInt("first_recharge") == 1;
                this.TO.UV = optJSONObject3.optInt("rotary_table") == 1;
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("im_effect");
            if (optJSONObject4 != null) {
                this.TM = new ab(optJSONObject4);
            }
            this.TP = new ar(optJSONObject.optJSONObject("live_goods"));
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("zhibo_service_agreement");
            if (optJSONObject5 != null) {
                this.TQ = new at();
                this.TQ.Va = optJSONObject5.optString("agreement");
                this.TQ.link = optJSONObject5.optString("link");
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("baiduyun_certify_url");
            if (optJSONObject6 != null) {
                this.TR = new aj();
                this.TR.Uj = optJSONObject6.optString("my_zhibo");
                this.TR.Uk = optJSONObject6.optString("certify");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("player_config");
            if (optJSONObject7 != null) {
                this.TS = new ai();
                this.TS.Ui = optJSONObject7.optInt("decode_mode");
            }
        }
    }
}
