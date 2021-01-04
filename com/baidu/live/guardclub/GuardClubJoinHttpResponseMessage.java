package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public a bkF;
    public int bkP;
    public int bkQ;
    public long bkR;
    public boolean bkS;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.bkS = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bkP = optJSONObject.optInt("guard_club_id");
            this.bkQ = optJSONObject.optInt("guard_club_member_id");
            this.bkR = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.bkR;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof c)) {
                this.bkF = ((c) getOrginalMessage()).Lw();
            }
        }
    }
}
