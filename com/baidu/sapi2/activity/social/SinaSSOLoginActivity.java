package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;
import com.baidu.d.a.a.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
/* loaded from: classes2.dex */
public class SinaSSOLoginActivity extends BaseSSOLoginActivity {
    private SsoHandler sinaSsoHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.b.sapi_sdk_title_login_sina);
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        WbSdk.install(this, new AuthInfo(this, confignation.sinaAppId, confignation.sinaRedirectUri, NotificationCompat.CATEGORY_EMAIL));
        this.sinaSsoHandler = new SsoHandler(this);
        this.sinaSsoHandler.authorize(new WbAuthListener() { // from class: com.baidu.sapi2.activity.social.SinaSSOLoginActivity.1
            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
                SinaSSOLoginActivity.this.sapiWebView.loadSinaSSOLogin(SinaSSOLoginActivity.this.getStatParamList(), oauth2AccessToken.getToken(), oauth2AccessToken.getUid());
            }

            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void cancel() {
                SinaSSOLoginActivity.this.handleBack(SinaSSOLoginActivity.this.businessFrom);
            }

            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
                Toast.makeText(SinaSSOLoginActivity.this, wbConnectErrorMessage.getErrorMessage(), 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.sinaSsoHandler.authorizeCallBack(i, i2, intent);
    }
}
