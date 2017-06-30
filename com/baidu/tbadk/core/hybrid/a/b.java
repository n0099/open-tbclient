package com.baidu.tbadk.core.hybrid.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.hybrid.s;
import com.baidu.tbadk.core.hybrid.w;
import com.baidu.tbadk.core.hybrid.x;
import com.baidu.tbadk.data.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends w {
    public b(s sVar) {
        super(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.w
    public String nT() {
        return "TBHY_EXT_FocusFeed";
    }

    @x("appointNotice")
    protected void appointNotice(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("activityId");
            int optInt2 = jSONObject.optInt("state");
            String optString = jSONObject.optString("curNum");
            i iVar = new i();
            iVar.setActivityId(optInt);
            iVar.eq(optInt2);
            iVar.fl(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_ADCARD, iVar));
        }
    }
}
