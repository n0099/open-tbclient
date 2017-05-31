package com.baidu.tbadk.core.d.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.d.n;
import com.baidu.tbadk.core.d.p;
import com.baidu.tbadk.core.d.q;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends p {
    public b(n nVar) {
        super(nVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.d.p
    public String nX() {
        return "TBHY_EXT_FocusFeed";
    }

    @q("appointNotice")
    protected void appointNotice(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("activityId");
            int optInt2 = jSONObject.optInt("state");
            String optString = jSONObject.optString("curNum");
            i iVar = new i();
            iVar.setActivityId(optInt);
            iVar.eo(optInt2);
            iVar.eR(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_ADCARD, iVar));
        }
    }
}
