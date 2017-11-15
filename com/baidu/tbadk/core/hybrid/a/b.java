package com.baidu.tbadk.core.hybrid.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.p;
import com.baidu.tbadk.data.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends o {
    public b(m mVar) {
        super(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.o
    public String oc() {
        return "TBHY_EXT_FocusFeed";
    }

    @p("appointNotice")
    protected void appointNotice(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("activityId");
            int optInt2 = jSONObject.optInt("state");
            String optString = jSONObject.optString("curNum");
            j jVar = new j();
            jVar.setActivityId(optInt);
            jVar.eE(optInt2);
            jVar.fu(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_ADCARD, jVar));
        }
    }
}
