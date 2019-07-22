package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.d.a.a.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import sdk.meizu.auth.MzAuthenticator;
import sdk.meizu.auth.OAuthError;
import sdk.meizu.auth.OAuthToken;
import sdk.meizu.auth.callback.ImplictCallback;
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
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        new MzAuthenticator(confignation.mzAppID, confignation.meizuRedirectUri).requestImplictAuth(this, "uc_basic_info", new ImplictCallback() { // from class: com.baidu.sapi2.activity.social.MeizuSSOLoginActivity.1
            public void onError(OAuthError oAuthError) {
                MeizuSSOLoginActivity.this.handleBack(MeizuSSOLoginActivity.this.businessFrom);
            }

            public void onGetToken(OAuthToken oAuthToken) {
                String accessToken = oAuthToken.getAccessToken();
                String openId = oAuthToken.getOpenId();
                if (!TextUtils.isEmpty(accessToken) && !TextUtils.isEmpty(openId)) {
                    MeizuSSOLoginActivity.this.sapiWebView.loadMeizuSSOLogin(MeizuSSOLoginActivity.this.getStatParamList(), accessToken, openId);
                } else {
                    MeizuSSOLoginActivity.this.handleBack(MeizuSSOLoginActivity.this.businessFrom);
                }
            }
        });
    }
}
