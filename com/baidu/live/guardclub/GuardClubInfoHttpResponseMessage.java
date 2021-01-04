package com.baidu.live.guardclub;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GuardClubInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public a bkF;
    public String bkG;
    public String bkH;
    public String bkI;
    public String[] bkJ;
    public boolean bkK;
    public boolean bkL;
    public d[] bkM;
    public f bkN;
    public boolean bkO;

    public GuardClubInfoHttpResponseMessage() {
        super(1021137);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bkF = new a();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("guard_club_info");
            if (optJSONObject2 != null) {
                this.bkF.parseJson(optJSONObject2);
            }
            this.bkG = optJSONObject.optString("explain_url");
            JSONArray optJSONArray = optJSONObject.optJSONArray("privilege_conf");
            if (optJSONArray != null) {
                this.bkJ = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.bkJ[i2] = optJSONArray.getString(i2);
                }
            }
            this.bkI = optJSONObject.optString("pk_rank_url");
            this.bkH = optJSONObject.optString("pk_rank_banner");
            this.bkK = optJSONObject.optInt(GuardClubInfoActivityConfig.IS_CLUB_MEMBER) == 1;
            this.bkL = optJSONObject.optInt("isAnchor") == 1;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("join_club_privilege");
            if (optJSONArray2 != null) {
                this.bkM = new d[optJSONArray2.length()];
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.bkM[i3] = new d();
                    this.bkM[i3].parseJson(optJSONArray2.optJSONObject(i3));
                }
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("login_member_info");
            if (optJSONObject3 != null) {
                this.bkN = new f();
                this.bkN.parseJson(optJSONObject3);
            }
            this.bkO = optJSONObject.optInt("has_quit_tips") == 1;
        }
    }
}
