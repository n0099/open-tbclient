package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
class u extends com.baidu.tbadk.core.hybrid.w {
    final /* synthetic */ TbWebViewActivity Qm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.hybrid.s sVar) {
        super(sVar);
        this.Qm = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.w
    public String nT() {
        return "TBHY_COMMON_Share";
    }

    @com.baidu.tbadk.core.hybrid.x(tN = false, value = TbConfig.TMP_SHARE_DIR_NAME)
    private void share(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString(VrPlayerActivityConfig.TITLE);
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("bid");
            if (!StringUtils.isNULL(optString5)) {
                this.Qm.mShareResultToFe = true;
                this.Qm.mBid = optString5;
            }
            com.baidu.adp.lib.g.h.fR().post(new v(this, this.Qm.createShareContent(optString, optString4, optString2, optString3)));
        }
    }
}
