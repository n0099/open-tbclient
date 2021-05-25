package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.ParamsUtil;
/* loaded from: classes2.dex */
public class TwitterSSOLoginActivity extends BaseSSOLoginActivity {
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(d.a.a0.a.j.a.sapi_sdk_title_login_twitter);
        this.sapiWebView.loadUrl(ParamsUtil.getUrlTwitterLogin(SapiAccountManager.getInstance().getConfignation()));
    }
}
