package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.d.a.a.a.a;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes2.dex */
public class QQSSOLoginActivity extends BaseSSOLoginActivity {
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.b.sapi_sdk_title_login_qq);
        this.sapiWebView.setQQSSOHandler(new SapiWebView.QQSSOHandler() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.1
            @Override // com.baidu.sapi2.SapiWebView.QQSSOHandler
            public void handleQQSSOLoginFailure() {
                QQSSOLoginActivity.this.handleBack(QQSSOLoginActivity.this.businessFrom);
            }
        });
        this.sapiWebView.loadQQSSOLogin(getStatParamList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.sapiWebView.onActivityResultData(i, i2, intent);
    }
}
