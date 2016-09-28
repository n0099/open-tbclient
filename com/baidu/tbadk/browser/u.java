package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
class u extends com.baidu.tbadk.core.c.p {
    final /* synthetic */ TbWebViewActivity MH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.c.n nVar) {
        super(nVar);
        this.MH = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.p
    public String nP() {
        return "TBHY_COMMON_UISwitch";
    }

    @com.baidu.tbadk.core.c.q(tV = false, value = "viewHideSwitch")
    private void viewHideSwitch(JSONObject jSONObject) {
        boolean z;
        if (jSONObject != null) {
            String optString = jSONObject.optJSONObject(TbConfig.TMP_SHARE_DIR_NAME).optString("value");
            if ("1".equals(optString)) {
                this.MH.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                this.MH.mShowShareItem = false;
            }
            x xVar = this.MH.mView;
            z = this.MH.mShowShareItem;
            xVar.af(z);
        }
    }
}
