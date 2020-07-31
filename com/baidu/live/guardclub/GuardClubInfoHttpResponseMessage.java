package com.baidu.live.guardclub;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GuardClubInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public a aSF;
    public String aSG;
    public String[] aSH;
    public boolean aSI;
    public boolean aSJ;
    public d[] aSK;
    public f aSL;
    public boolean aSM;

    public GuardClubInfoHttpResponseMessage() {
        super(1021137);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aSF = new a();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("guard_club_info");
            if (optJSONObject2 != null) {
                this.aSF.parseJson(optJSONObject2);
            }
            this.aSG = optJSONObject.optString("explain_url");
            JSONArray optJSONArray = optJSONObject.optJSONArray("privilege_conf");
            if (optJSONArray != null) {
                this.aSH = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.aSH[i2] = optJSONArray.getString(i2);
                }
            }
            this.aSI = optJSONObject.optInt(GuardClubInfoActivityConfig.IS_CLUB_MEMBER) == 1;
            this.aSJ = optJSONObject.optInt("isAnchor") == 1;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("join_club_privilege");
            if (optJSONArray2 != null) {
                this.aSK = new d[optJSONArray2.length()];
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.aSK[i3] = new d();
                    this.aSK[i3].parseJson(optJSONArray2.optJSONObject(i3));
                }
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("login_member_info");
            if (optJSONObject3 != null) {
                this.aSL = new f();
                this.aSL.parseJson(optJSONObject3);
            }
            this.aSM = optJSONObject.optInt("has_quit_tips") == 1;
        }
    }
}
