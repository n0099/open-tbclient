package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import com.baidu.d.a.a.a.a;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes2.dex */
public class MeizuSSOLoginActivity extends BaseSSOLoginActivity {
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.b.sapi_sdk_title_login_mz);
        this.sapiWebView.setMeizuHandler(new SapiWebView.MeizuHandler() { // from class: com.baidu.sapi2.activity.social.MeizuSSOLoginActivity.1
            @Override // com.baidu.sapi2.SapiWebView.MeizuHandler
            public void handleMeizuLoginFailure() {
                MeizuSSOLoginActivity.this.handleBack(MeizuSSOLoginActivity.this.businessFrom);
            }
        });
        this.sapiWebView.loadMeizuSSOLogin(getStatParamList());
    }
}
