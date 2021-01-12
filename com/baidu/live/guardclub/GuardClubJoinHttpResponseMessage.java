package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public a bfP;
    public int bfZ;
    public int bga;
    public long bgb;
    public boolean bgc;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.bgc = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bfZ = optJSONObject.optInt("guard_club_id");
            this.bga = optJSONObject.optInt("guard_club_member_id");
            this.bgb = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.bgb;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof c)) {
                this.bfP = ((c) getOrginalMessage()).HB();
            }
        }
    }
}
