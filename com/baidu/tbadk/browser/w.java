package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
class w extends com.baidu.tbadk.core.hybrid.w {
    final /* synthetic */ TbWebViewActivity Qm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.hybrid.s sVar) {
        super(sVar);
        this.Qm = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.w
    public String nT() {
        return "TBHY_COMMON_UISwitch";
    }

    @com.baidu.tbadk.core.hybrid.x(tN = false, value = "viewHideSwitch")
    private void viewHideSwitch(JSONObject jSONObject) {
        boolean z;
        if (jSONObject != null) {
            String optString = jSONObject.optJSONObject(TbConfig.TMP_SHARE_DIR_NAME).optString("value");
            if ("1".equals(optString)) {
                this.Qm.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                this.Qm.mShowShareItem = false;
            }
            ab abVar = this.Qm.mView;
            z = this.Qm.mShowShareItem;
            abVar.ae(z);
        }
    }
}
