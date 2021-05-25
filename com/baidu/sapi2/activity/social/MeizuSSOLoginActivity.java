package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import sdk.meizu.auth.MzAuthenticator;
import sdk.meizu.auth.OAuthError;
import sdk.meizu.auth.OAuthToken;
import sdk.meizu.auth.callback.ImplictCallback;
/* loaded from: classes2.dex */
public class MeizuSSOLoginActivity extends BaseSSOLoginActivity {

    /* loaded from: classes2.dex */
    public class a extends ImplictCallback {
        public a() {
        }

        public void onError(OAuthError oAuthError) {
            MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
            meizuSSOLoginActivity.a(((BaseSSOLoginActivity) meizuSSOLoginActivity).f9728g);
        }

        public void onGetToken(OAuthToken oAuthToken) {
            String accessToken = oAuthToken.getAccessToken();
            String openId = oAuthToken.getOpenId();
            if (!TextUtils.isEmpty(accessToken) && !TextUtils.isEmpty(openId)) {
                MeizuSSOLoginActivity.this.a(ParamsUtil.getUrlBind(MeizuSSOLoginActivity.this.configuration, SocialType.MEIZU, accessToken, openId, null), "授权魅族帐号登录中");
                return;
            }
            MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
            meizuSSOLoginActivity.a(((BaseSSOLoginActivity) meizuSSOLoginActivity).f9728g);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(d.a.a0.a.j.a.sapi_sdk_title_login_mz);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        SapiConfiguration sapiConfiguration = this.configuration;
        new MzAuthenticator(sapiConfiguration.mzAppID, sapiConfiguration.meizuRedirectUri).requestImplictAuth(this, "uc_basic_info", new a());
    }
}
