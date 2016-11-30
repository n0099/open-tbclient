package com.baidu.tbadk.core.c.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.c.n;
import com.baidu.tbadk.core.c.p;
import com.baidu.tbadk.core.c.q;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends p {
    public b(n nVar) {
        super(nVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.p
    public String nT() {
        return "TBHY_EXT_FocusFeed";
    }

    @q("appointNotice")
    protected void appointNotice(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("activityId");
            int optInt2 = jSONObject.optInt(SocialConstants.PARAM_STATE);
            String optString = jSONObject.optString("curNum");
            j jVar = new j();
            jVar.setActivityId(optInt);
            jVar.er(optInt2);
            jVar.fi(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_ADCARD, jVar));
        }
    }
}
