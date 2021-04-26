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
/* loaded from: classes2.dex */
public class SinaSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String p = SinaSSOLoginActivity.class.getSimpleName();
    public static final int q = -1;
    public SsoHandler n;
    public WbAuthListener o;

    /* loaded from: classes2.dex */
    public class a implements WbAuthListener {
        public a() {
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void cancel() {
            SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
            if (((BaseSSOLoginActivity) sinaSSOLoginActivity).f10790f) {
                sinaSSOLoginActivity.b(3001);
                SinaSSOLoginActivity.this.finish();
                return;
            }
            sinaSSOLoginActivity.a(((BaseSSOLoginActivity) sinaSSOLoginActivity).f10791g);
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            Toast.makeText(SinaSSOLoginActivity.this, wbConnectErrorMessage.getErrorMessage(), 0).show();
            SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
            if (((BaseSSOLoginActivity) sinaSSOLoginActivity).f10790f) {
                sinaSSOLoginActivity.b(3001);
                SinaSSOLoginActivity.this.finish();
            }
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
            String token = oauth2AccessToken.getToken();
            String uid = oauth2AccessToken.getUid();
            String urlBind = ParamsUtil.getUrlBind(SinaSSOLoginActivity.this.configuration, SocialType.SINA_WEIBO_SSO, token, uid, SinaSSOLoginActivity.this.configuration.sinaAppId);
            SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
            if (((BaseSSOLoginActivity) sinaSSOLoginActivity).f10790f) {
                Intent intent = new Intent();
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, token);
                intent.putExtra("userId", uid);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.SINA_WEIBO_SSO.getType()));
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, "tsina");
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().sinaAppId);
                SinaSSOLoginActivity.this.a(3001, intent);
                SinaSSOLoginActivity.this.finish();
                return;
            }
            sinaSSOLoginActivity.a(urlBind, "授权微博帐号登录中");
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        this.o = null;
        super.finish();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str = p;
        Log.d(str, "requestCode = " + i2 + " resultCode = " + i3 + " data = " + intent);
        super.onActivityResult(i2, i3, intent);
        this.n.authorizeCallBack(i2, i3, intent);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(d.a.y.a.j.a.sapi_sdk_title_login_sina);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        SapiConfiguration sapiConfiguration = this.configuration;
        WbSdk.install(this, new AuthInfo(this, sapiConfiguration.sinaAppId, sapiConfiguration.sinaRedirectUri, "email"));
        this.n = new SsoHandler(this);
        a aVar = new a();
        this.o = aVar;
        this.n.authorize(aVar);
    }
}
