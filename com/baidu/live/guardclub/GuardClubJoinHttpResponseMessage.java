package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public a apY;
    public int aqg;
    public int aqh;
    public long aqi;
    public boolean aqj;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.aqj = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aqg = optJSONObject.optInt("guard_club_id");
            this.aqh = optJSONObject.optInt("guard_club_member_id");
            this.aqi = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.aqi;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof c)) {
                this.apY = ((c) getOrginalMessage()).vF();
            }
        }
    }
}
