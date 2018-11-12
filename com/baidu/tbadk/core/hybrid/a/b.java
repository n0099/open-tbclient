package com.baidu.tbadk.core.hybrid.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.data.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends n {
    public b(l lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String vM() {
        return "TBHY_EXT_FocusFeed";
    }

    @o("appointNotice")
    protected void appointNotice(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("activityId");
            int optInt2 = jSONObject.optInt("state");
            String optString = jSONObject.optString("curNum");
            g gVar = new g();
            gVar.setActivityId(optInt);
            gVar.fn(optInt2);
            gVar.hb(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016492, gVar));
        }
    }
}
