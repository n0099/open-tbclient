package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tieba.R;
import sdk.meizu.auth.MzAuthenticator;
import sdk.meizu.auth.OAuthError;
import sdk.meizu.auth.OAuthToken;
import sdk.meizu.auth.callback.ImplictCallback;
/* loaded from: classes3.dex */
public class MeizuSSOLoginActivity extends BaseSSOLoginActivity {

    /* loaded from: classes3.dex */
    public class a extends ImplictCallback {
        public a() {
        }

        public void onError(OAuthError oAuthError) {
            MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
            meizuSSOLoginActivity.a(((BaseSSOLoginActivity) meizuSSOLoginActivity).g);
        }

        public void onGetToken(OAuthToken oAuthToken) {
            String accessToken = oAuthToken.getAccessToken();
            String openId = oAuthToken.getOpenId();
            if (!TextUtils.isEmpty(accessToken) && !TextUtils.isEmpty(openId)) {
                MeizuSSOLoginActivity.this.a(ParamsUtil.getUrlBind(MeizuSSOLoginActivity.this.configuration, SocialType.MEIZU, accessToken, openId, null), "授权魅族帐号登录中");
                return;
            }
            MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
            meizuSSOLoginActivity.a(((BaseSSOLoginActivity) meizuSSOLoginActivity).g);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(R.string.sapi_sdk_title_login_mz);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        try {
            new MzAuthenticator(this.configuration.mzAppID, this.configuration.meizuRedirectUri).requestImplictAuth(this, "uc_basic_info", new a());
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }
}
