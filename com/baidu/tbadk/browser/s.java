package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
class s extends com.baidu.tbadk.core.c.p {
    final /* synthetic */ TbWebViewActivity Kw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.c.n nVar) {
        super(nVar);
        this.Kw = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.p
    public String mU() {
        return "TBHY_COMMON_Share";
    }

    @com.baidu.tbadk.core.c.q(sB = false, value = TbConfig.TMP_SHARE_DIR_NAME)
    private void share(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("bid");
            if (!StringUtils.isNULL(optString5)) {
                this.Kw.mShareResultToFe = true;
                this.Kw.mBid = optString5;
            }
            com.baidu.adp.lib.h.h.dL().post(new t(this, this.Kw.createShareContent(optString, optString4, optString2, optString3)));
        }
    }
}
