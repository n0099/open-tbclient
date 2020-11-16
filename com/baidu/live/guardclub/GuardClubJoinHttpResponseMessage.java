package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public a beL;
    public int beT;
    public int beU;
    public long beV;
    public boolean beW;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.beW = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.beT = optJSONObject.optInt("guard_club_id");
            this.beU = optJSONObject.optInt("guard_club_member_id");
            this.beV = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.beV;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof c)) {
                this.beL = ((c) getOrginalMessage()).JU();
            }
        }
    }
}
