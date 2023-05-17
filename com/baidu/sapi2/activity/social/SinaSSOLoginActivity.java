package com.baidu.sapi2.activity.social;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tieba.R;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
/* loaded from: classes3.dex */
public class SinaSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String p = SinaSSOLoginActivity.class.getSimpleName();
    public static final int q = -1;
    public SsoHandler n;
    public WbAuthListener o;

    /* loaded from: classes3.dex */
    public class a implements WbAuthListener {
        public a() {
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            Toast.makeText(SinaSSOLoginActivity.this, wbConnectErrorMessage.getErrorMessage(), 0).show();
            SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
            if (((BaseSSOLoginActivity) sinaSSOLoginActivity).f) {
                sinaSSOLoginActivity.b(4001);
                ThirdPartyService.releaseThirdLoginCallback();
                SinaSSOLoginActivity.this.finish();
            }
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void cancel() {
            SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
            if (((BaseSSOLoginActivity) sinaSSOLoginActivity).f) {
                sinaSSOLoginActivity.b(4001);
                SinaSSOLoginActivity.this.finish();
                return;
            }
            sinaSSOLoginActivity.a(((BaseSSOLoginActivity) sinaSSOLoginActivity).g);
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
            String token = oauth2AccessToken.getToken();
            String uid = oauth2AccessToken.getUid();
            String urlBind = ParamsUtil.getUrlBind(SinaSSOLoginActivity.this.configuration, SocialType.SINA_WEIBO_SSO, token, uid, SinaSSOLoginActivity.this.configuration.sinaAppId);
            SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
            if (((BaseSSOLoginActivity) sinaSSOLoginActivity).f) {
                Intent intent = new Intent();
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, token);
                intent.putExtra("userId", uid);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.SINA_WEIBO_SSO.getType()));
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, "tsina");
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().sinaAppId);
                SinaSSOLoginActivity.this.a(4001, intent);
                ThirdPartyService.releaseThirdLoginCallback();
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

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setupViews();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String str = p;
        Log.d(str, "requestCode = " + i + " resultCode = " + i2 + " data = " + intent);
        super.onActivityResult(i, i2, intent);
        this.n.authorizeCallBack(i, i2, intent);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(R.string.sapi_sdk_title_login_sina);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        Context applicationContext = getApplicationContext();
        Context applicationContext2 = getApplicationContext();
        SapiConfiguration sapiConfiguration = this.configuration;
        WbSdk.install(applicationContext, new AuthInfo(applicationContext2, sapiConfiguration.sinaAppId, sapiConfiguration.sinaRedirectUri, "email"));
        this.n = new SsoHandler(this);
        a aVar = new a();
        this.o = aVar;
        this.n.authorize(aVar);
    }
}
