package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import com.baidu.k.a.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.ParamsUtil;
/* loaded from: classes6.dex */
public class TwitterSSOLoginActivity extends BaseSSOLoginActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_twitter);
        this.sapiWebView.loadUrl(ParamsUtil.getUrlTwitterLogin(SapiAccountManager.getInstance().getConfignation()));
    }
}
