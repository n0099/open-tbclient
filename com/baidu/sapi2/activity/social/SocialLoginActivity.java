package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.c.a.a.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes2.dex */
public class SocialLoginActivity extends BaseSSOLoginActivity {
    public static final String EXTRA_SOCIAL_TYPE = "social_type";
    private SocialType socialType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.socialType = (SocialType) getIntent().getSerializableExtra(EXTRA_SOCIAL_TYPE);
        if (this.socialType == null) {
            if (this.businessFrom == 2001) {
                Intent intent = new Intent();
                intent.putExtra("result_code", -204);
                intent.putExtra("result_msg", SapiResult.ERROR_MSG_PARAMS_ERROR);
                setResult(1002, intent);
            } else if (PassportSDK.getInstance().getWebAuthListener() != null) {
                this.webAuthResult.setResultCode(-204);
                this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                PassportSDK.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
                PassportSDK.getInstance().release();
            }
            finish();
        }
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        if (this.socialType == SocialType.SINA_WEIBO) {
            setTitleText(a.c.sapi_sdk_title_login_sina);
        } else if (this.socialType == SocialType.CHUANKE) {
            setTitleText(a.c.sapi_sdk_title_login_ck);
        } else if (this.socialType == SocialType.TENCENT_WEIBO) {
            setTitleText(a.c.sapi_sdk_title_login_txweibo);
        }
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.social.SocialLoginActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                if (SocialLoginActivity.this.sapiWebView.canGoBack()) {
                    SocialLoginActivity.this.sapiWebView.goBack();
                    return true;
                }
                SocialLoginActivity.this.handleBack(SocialLoginActivity.this.businessFrom);
                return true;
            }
        });
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.social.SocialLoginActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                if (SocialLoginActivity.this.sapiWebView.canGoBack()) {
                    SocialLoginActivity.this.sapiWebView.goBack();
                } else {
                    SocialLoginActivity.this.handleBack(SocialLoginActivity.this.businessFrom);
                }
            }
        });
        this.sapiWebView.loadSocialLogin(this.socialType, true, getStatParamList());
    }
}
