package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public a aqi;
    public int aqq;
    public int aqr;
    public long aqs;
    public boolean aqt;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.aqt = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aqq = optJSONObject.optInt("guard_club_id");
            this.aqr = optJSONObject.optInt("guard_club_member_id");
            this.aqs = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.aqs;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof c)) {
                this.aqi = ((c) getOrginalMessage()).vK();
            }
        }
    }
}
