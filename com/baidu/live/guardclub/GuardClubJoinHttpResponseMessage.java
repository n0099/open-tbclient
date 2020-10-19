package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public a bdN;
    public int bdV;
    public int bdW;
    public long bdX;
    public boolean bdY;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.bdY = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bdV = optJSONObject.optInt("guard_club_id");
            this.bdW = optJSONObject.optInt("guard_club_member_id");
            this.bdX = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.bdX;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof c)) {
                this.bdN = ((c) getOrginalMessage()).JK();
            }
        }
    }
}
