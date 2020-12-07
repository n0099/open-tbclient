package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public a bja;
    public int bjk;
    public int bjl;
    public long bjm;
    public boolean bjn;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.bjn = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bjk = optJSONObject.optInt("guard_club_id");
            this.bjl = optJSONObject.optInt("guard_club_member_id");
            this.bjm = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.bjm;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof c)) {
                this.bja = ((c) getOrginalMessage()).LX();
            }
        }
    }
}
