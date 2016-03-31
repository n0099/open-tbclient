package com.baidu.tbadk.browser;

import org.json.JSONObject;
/* loaded from: classes.dex */
class q extends com.baidu.tbadk.core.c.o {
    final /* synthetic */ TbWebViewActivity PH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.c.m mVar) {
        super(mVar);
        this.PH = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.o
    public String pT() {
        return "shareCmd";
    }

    @com.baidu.tbadk.core.c.p(uY = true, value = "shareByHybrid")
    private void showShareUtility(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            com.baidu.adp.lib.h.h.hx().post(new r(this, this.PH.createShareContent(optString, jSONObject.optString("url"), optString2, optString3)));
        }
    }
}
