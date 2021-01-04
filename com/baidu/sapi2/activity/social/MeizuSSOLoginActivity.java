package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.l.a.a.a;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import sdk.meizu.auth.MzAuthenticator;
import sdk.meizu.auth.OAuthError;
import sdk.meizu.auth.OAuthToken;
import sdk.meizu.auth.callback.ImplictCallback;
/* loaded from: classes4.dex */
public class MeizuSSOLoginActivity extends BaseSSOLoginActivity {
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_mz);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        new MzAuthenticator(this.configuration.mzAppID, this.configuration.meizuRedirectUri).requestImplictAuth(this, "uc_basic_info", new ImplictCallback() { // from class: com.baidu.sapi2.activity.social.MeizuSSOLoginActivity.1
            public void onError(OAuthError oAuthError) {
                MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
                meizuSSOLoginActivity.handleBack(meizuSSOLoginActivity.businessFrom);
            }

            public void onGetToken(OAuthToken oAuthToken) {
                String accessToken = oAuthToken.getAccessToken();
                String openId = oAuthToken.getOpenId();
                if (!TextUtils.isEmpty(accessToken) && !TextUtils.isEmpty(openId)) {
                    MeizuSSOLoginActivity.this.loadLoginInNA(ParamsUtil.getUrlBind(((SocialLoginBase) MeizuSSOLoginActivity.this).configuration, SocialType.MEIZU, accessToken, openId, null), "授权魅族帐号登录中");
                    return;
                }
                MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
                meizuSSOLoginActivity.handleBack(meizuSSOLoginActivity.businessFrom);
            }
        });
    }
}
