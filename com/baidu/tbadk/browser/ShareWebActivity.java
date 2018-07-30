package com.baidu.tbadk.browser;

import android.os.Bundle;
/* loaded from: classes.dex */
public class ShareWebActivity extends TbWebViewActivity {
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mView != null && this.mView.aaZ != null) {
            this.mView.aaZ.setVisibility(8);
        }
    }
}
