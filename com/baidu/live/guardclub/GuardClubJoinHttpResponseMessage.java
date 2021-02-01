package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public a biY;
    public int bji;
    public int bjj;
    public long bjk;
    public boolean bjl;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.bjl = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bji = optJSONObject.optInt("guard_club_id");
            this.bjj = optJSONObject.optInt("guard_club_member_id");
            this.bjk = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.bjk;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof c)) {
                this.biY = ((c) getOrginalMessage()).IR();
            }
        }
    }
}
