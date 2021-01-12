package com.baidu.live.guardclub;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GuardClubInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public a bfP;
    public String bfQ;
    public String bfR;
    public String bfS;
    public String[] bfT;
    public boolean bfU;
    public boolean bfV;
    public d[] bfW;
    public f bfX;
    public boolean bfY;

    public GuardClubInfoHttpResponseMessage() {
        super(1021137);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bfP = new a();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("guard_club_info");
            if (optJSONObject2 != null) {
                this.bfP.parseJson(optJSONObject2);
            }
            this.bfQ = optJSONObject.optString("explain_url");
            JSONArray optJSONArray = optJSONObject.optJSONArray("privilege_conf");
            if (optJSONArray != null) {
                this.bfT = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.bfT[i2] = optJSONArray.getString(i2);
                }
            }
            this.bfS = optJSONObject.optString("pk_rank_url");
            this.bfR = optJSONObject.optString("pk_rank_banner");
            this.bfU = optJSONObject.optInt(GuardClubInfoActivityConfig.IS_CLUB_MEMBER) == 1;
            this.bfV = optJSONObject.optInt("isAnchor") == 1;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("join_club_privilege");
            if (optJSONArray2 != null) {
                this.bfW = new d[optJSONArray2.length()];
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.bfW[i3] = new d();
                    this.bfW[i3].parseJson(optJSONArray2.optJSONObject(i3));
                }
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("login_member_info");
            if (optJSONObject3 != null) {
                this.bfX = new f();
                this.bfX.parseJson(optJSONObject3);
            }
            this.bfY = optJSONObject.optInt("has_quit_tips") == 1;
        }
    }
}
