package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import d.b.a0.a.j.a;
/* loaded from: classes2.dex */
public class SinaSSOLoginActivity extends BaseSSOLoginActivity {
    public static final int SUCCESS_RESULTCODE = -1;
    public static final String TAG = SinaSSOLoginActivity.class.getSimpleName();
    public SsoHandler sinaSsoHandler;
    public WbAuthListener wbAuthListener;

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        this.wbAuthListener = null;
        super.finish();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String str = TAG;
        Log.d(str, "requestCode = " + i + " resultCode = " + i2 + " data = " + intent);
        super.onActivityResult(i, i2, intent);
        this.sinaSsoHandler.authorizeCallBack(i, i2, intent);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.sapi_sdk_title_login_sina);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        SapiConfiguration sapiConfiguration = this.configuration;
        WbSdk.install(this, new AuthInfo(this, sapiConfiguration.sinaAppId, sapiConfiguration.sinaRedirectUri, "email"));
        this.sinaSsoHandler = new SsoHandler(this);
        WbAuthListener wbAuthListener = new WbAuthListener() { // from class: com.baidu.sapi2.activity.social.SinaSSOLoginActivity.1
            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void cancel() {
                SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
                if (sinaSSOLoginActivity.mIsVerification) {
                    sinaSSOLoginActivity.setActivtyResult(3001);
                    SinaSSOLoginActivity.this.finish();
                    return;
                }
                sinaSSOLoginActivity.handleBack(sinaSSOLoginActivity.businessFrom);
            }

            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
                Toast.makeText(SinaSSOLoginActivity.this, wbConnectErrorMessage.getErrorMessage(), 0).show();
                SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
                if (sinaSSOLoginActivity.mIsVerification) {
                    sinaSSOLoginActivity.setActivtyResult(3001);
                    SinaSSOLoginActivity.this.finish();
                }
            }

            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
                String token = oauth2AccessToken.getToken();
                String uid = oauth2AccessToken.getUid();
                String urlBind = ParamsUtil.getUrlBind(SinaSSOLoginActivity.this.configuration, SocialType.SINA_WEIBO_SSO, token, uid, SinaSSOLoginActivity.this.configuration.sinaAppId);
                SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
                if (sinaSSOLoginActivity.mIsVerification) {
                    Intent intent = new Intent();
                    intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, token);
                    intent.putExtra("userId", uid);
                    intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.SINA_WEIBO_SSO.getType()));
                    intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, "tsina");
                    intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().sinaAppId);
                    SinaSSOLoginActivity.this.setActivtyResult(3001, intent);
                    SinaSSOLoginActivity.this.finish();
                    return;
                }
                sinaSSOLoginActivity.loadLoginInNA(urlBind, "授权微博帐号登录中");
            }
        };
        this.wbAuthListener = wbAuthListener;
        this.sinaSsoHandler.authorize(wbAuthListener);
    }
}
