package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public a aRm;
    public int aRu;
    public int aRv;
    public long aRw;
    public boolean aRx;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.aRx = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aRu = optJSONObject.optInt("guard_club_id");
            this.aRv = optJSONObject.optInt("guard_club_member_id");
            this.aRw = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.aRw;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof c)) {
                this.aRm = ((c) getOrginalMessage()).Cf();
            }
        }
    }
}
