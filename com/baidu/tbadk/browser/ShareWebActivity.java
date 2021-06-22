package com.baidu.tbadk.browser;

import android.os.Bundle;
import android.widget.ImageView;
import d.a.n0.l.e;
/* loaded from: classes3.dex */
public class ShareWebActivity extends TbWebViewActivity {
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ImageView imageView;
        super.onCreate(bundle);
        e eVar = this.mView;
        if (eVar == null || (imageView = eVar.f53245i) == null) {
            return;
        }
        imageView.setVisibility(8);
    }
}
