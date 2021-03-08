package com.baidu.live.guardclub;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GuardClubInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public String bkA;
    public String bkB;
    public String[] bkC;
    public boolean bkD;
    public boolean bkE;
    public d[] bkF;
    public f bkG;
    public boolean bkH;
    public a bky;
    public String bkz;

    public GuardClubInfoHttpResponseMessage() {
        super(1021137);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bky = new a();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("guard_club_info");
            if (optJSONObject2 != null) {
                this.bky.parseJson(optJSONObject2);
            }
            this.bkz = optJSONObject.optString("explain_url");
            JSONArray optJSONArray = optJSONObject.optJSONArray("privilege_conf");
            if (optJSONArray != null) {
                this.bkC = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.bkC[i2] = optJSONArray.getString(i2);
                }
            }
            this.bkB = optJSONObject.optString("pk_rank_url");
            this.bkA = optJSONObject.optString("pk_rank_banner");
            this.bkD = optJSONObject.optInt(GuardClubInfoActivityConfig.IS_CLUB_MEMBER) == 1;
            this.bkE = optJSONObject.optInt("isAnchor") == 1;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("join_club_privilege");
            if (optJSONArray2 != null) {
                this.bkF = new d[optJSONArray2.length()];
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.bkF[i3] = new d();
                    this.bkF[i3].parseJson(optJSONArray2.optJSONObject(i3));
                }
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("login_member_info");
            if (optJSONObject3 != null) {
                this.bkG = new f();
                this.bkG.parseJson(optJSONObject3);
            }
            this.bkH = optJSONObject.optInt("has_quit_tips") == 1;
        }
    }
}
