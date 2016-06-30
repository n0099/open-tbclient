package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
class u extends com.baidu.tbadk.core.c.o {
    final /* synthetic */ TbWebViewActivity Kx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.c.m mVar) {
        super(mVar);
        this.Kx = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.o
    public String ne() {
        return "TBHY_COMMON_UISwitch";
    }

    @com.baidu.tbadk.core.c.p(sC = false, value = "viewHideSwitch")
    private void viewHideSwitch(JSONObject jSONObject) {
        boolean z;
        if (jSONObject != null) {
            String optString = jSONObject.optJSONObject(TbConfig.TMP_SHARE_DIR_NAME).optString("value");
            if ("1".equals(optString)) {
                this.Kx.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                this.Kx.mShowShareItem = false;
            }
            x xVar = this.Kx.mView;
            z = this.Kx.mShowShareItem;
            xVar.ab(z);
        }
    }
}
