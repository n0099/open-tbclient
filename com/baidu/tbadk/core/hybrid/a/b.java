package com.baidu.tbadk.core.hybrid.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.hybrid.p;
import com.baidu.tbadk.core.hybrid.t;
import com.baidu.tbadk.core.hybrid.u;
import com.baidu.tbadk.data.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends t {
    public b(p pVar) {
        super(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.t
    public String oc() {
        return "TBHY_EXT_FocusFeed";
    }

    @u("appointNotice")
    protected void appointNotice(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("activityId");
            int optInt2 = jSONObject.optInt("state");
            String optString = jSONObject.optString("curNum");
            i iVar = new i();
            iVar.setActivityId(optInt);
            iVar.eu(optInt2);
            iVar.fu(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_ADCARD, iVar));
        }
    }
}
