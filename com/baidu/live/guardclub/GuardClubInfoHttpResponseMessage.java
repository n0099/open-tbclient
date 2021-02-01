package com.baidu.live.guardclub;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GuardClubInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public a biY;
    public String biZ;
    public String bja;
    public String bjb;
    public String[] bjc;
    public boolean bjd;
    public boolean bje;
    public d[] bjf;
    public f bjg;
    public boolean bjh;

    public GuardClubInfoHttpResponseMessage() {
        super(1021137);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.biY = new a();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("guard_club_info");
            if (optJSONObject2 != null) {
                this.biY.parseJson(optJSONObject2);
            }
            this.biZ = optJSONObject.optString("explain_url");
            JSONArray optJSONArray = optJSONObject.optJSONArray("privilege_conf");
            if (optJSONArray != null) {
                this.bjc = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.bjc[i2] = optJSONArray.getString(i2);
                }
            }
            this.bjb = optJSONObject.optString("pk_rank_url");
            this.bja = optJSONObject.optString("pk_rank_banner");
            this.bjd = optJSONObject.optInt(GuardClubInfoActivityConfig.IS_CLUB_MEMBER) == 1;
            this.bje = optJSONObject.optInt("isAnchor") == 1;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("join_club_privilege");
            if (optJSONArray2 != null) {
                this.bjf = new d[optJSONArray2.length()];
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.bjf[i3] = new d();
                    this.bjf[i3].parseJson(optJSONArray2.optJSONObject(i3));
                }
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("login_member_info");
            if (optJSONObject3 != null) {
                this.bjg = new f();
                this.bjg.parseJson(optJSONObject3);
            }
            this.bjh = optJSONObject.optInt("has_quit_tips") == 1;
        }
    }
}
