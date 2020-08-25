package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public a aXT;
    public int aYb;
    public int aYc;
    public long aYd;
    public boolean aYe;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.aYe = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aYb = optJSONObject.optInt("guard_club_id");
            this.aYc = optJSONObject.optInt("guard_club_member_id");
            this.aYd = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.aYd;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof c)) {
                this.aXT = ((c) getOrginalMessage()).Ik();
            }
        }
    }
}
