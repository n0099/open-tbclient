package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
class s extends com.baidu.tbadk.core.c.o {
    final /* synthetic */ TbWebViewActivity Kx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.c.m mVar) {
        super(mVar);
        this.Kx = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.o
    public String ne() {
        return "TBHY_COMMON_Share";
    }

    @com.baidu.tbadk.core.c.p(sC = false, value = TbConfig.TMP_SHARE_DIR_NAME)
    private void share(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("bid");
            if (!StringUtils.isNULL(optString5)) {
                this.Kx.mShareResultToFe = true;
                this.Kx.mBid = optString5;
            }
            com.baidu.adp.lib.h.h.dM().post(new t(this, this.Kx.createShareContent(optString, optString4, optString2, optString3)));
        }
    }
}
