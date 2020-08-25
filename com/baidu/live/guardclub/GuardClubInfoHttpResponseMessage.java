package com.baidu.live.guardclub;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GuardClubInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public a aXT;
    public String aXU;
    public String[] aXV;
    public boolean aXW;
    public boolean aXX;
    public d[] aXY;
    public f aXZ;
    public boolean aYa;

    public GuardClubInfoHttpResponseMessage() {
        super(1021137);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aXT = new a();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("guard_club_info");
            if (optJSONObject2 != null) {
                this.aXT.parseJson(optJSONObject2);
            }
            this.aXU = optJSONObject.optString("explain_url");
            JSONArray optJSONArray = optJSONObject.optJSONArray("privilege_conf");
            if (optJSONArray != null) {
                this.aXV = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.aXV[i2] = optJSONArray.getString(i2);
                }
            }
            this.aXW = optJSONObject.optInt(GuardClubInfoActivityConfig.IS_CLUB_MEMBER) == 1;
            this.aXX = optJSONObject.optInt("isAnchor") == 1;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("join_club_privilege");
            if (optJSONArray2 != null) {
                this.aXY = new d[optJSONArray2.length()];
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.aXY[i3] = new d();
                    this.aXY[i3].parseJson(optJSONArray2.optJSONObject(i3));
                }
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("login_member_info");
            if (optJSONObject3 != null) {
                this.aXZ = new f();
                this.aXZ.parseJson(optJSONObject3);
            }
            this.aYa = optJSONObject.optInt("has_quit_tips") == 1;
        }
    }
}
