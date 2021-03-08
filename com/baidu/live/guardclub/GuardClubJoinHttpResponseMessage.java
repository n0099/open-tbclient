package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public int bkI;
    public int bkJ;
    public long bkK;
    public boolean bkL;
    public a bky;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.bkL = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bkI = optJSONObject.optInt("guard_club_id");
            this.bkJ = optJSONObject.optInt("guard_club_member_id");
            this.bkK = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.bkK;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof c)) {
                this.bky = ((c) getOrginalMessage()).IU();
            }
        }
    }
}
