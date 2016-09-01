package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
class s extends com.baidu.tbadk.core.c.p {
    final /* synthetic */ TbWebViewActivity MI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.c.n nVar) {
        super(nVar);
        this.MI = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.p
    public String nP() {
        return "TBHY_COMMON_Share";
    }

    @com.baidu.tbadk.core.c.q(tG = false, value = TbConfig.TMP_SHARE_DIR_NAME)
    private void share(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString(VrPlayerActivityConfig.TITLE);
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("bid");
            if (!StringUtils.isNULL(optString5)) {
                this.MI.mShareResultToFe = true;
                this.MI.mBid = optString5;
            }
            com.baidu.adp.lib.h.h.eG().post(new t(this, this.MI.createShareContent(optString, optString4, optString2, optString3)));
        }
    }
}
