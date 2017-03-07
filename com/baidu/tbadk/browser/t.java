package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.core.d.p {
    final /* synthetic */ TbWebViewActivity QU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.d.n nVar) {
        super(nVar);
        this.QU = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.d.p
    public String ob() {
        return "TBHY_COMMON_UISwitch";
    }

    @com.baidu.tbadk.core.d.q(ub = false, value = "viewHideSwitch")
    private void viewHideSwitch(JSONObject jSONObject) {
        boolean z;
        if (jSONObject != null) {
            String optString = jSONObject.optJSONObject(TbConfig.TMP_SHARE_DIR_NAME).optString("value");
            if ("1".equals(optString)) {
                this.QU.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                this.QU.mShowShareItem = false;
            }
            y yVar = this.QU.mView;
            z = this.QU.mShowShareItem;
            yVar.ae(z);
        }
    }
}
