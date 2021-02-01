package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.baidu.j.a.a.a;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
/* loaded from: classes6.dex */
public class SinaSSOLoginActivity extends BaseSSOLoginActivity {
    private static final int SUCCESS_RESULTCODE = -1;
    private static final String TAG = SinaSSOLoginActivity.class.getSimpleName();
    private SsoHandler sinaSsoHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Log.d(TAG, "requestCode = " + i + " resultCode = " + i2 + " data = " + intent);
        super.onActivityResult(i, i2, intent);
        this.sinaSsoHandler.authorizeCallBack(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_sina);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        WbSdk.install(this, new AuthInfo(this, this.configuration.sinaAppId, this.configuration.sinaRedirectUri, NotificationCompat.CATEGORY_EMAIL));
        this.sinaSsoHandler = new SsoHandler(this);
        this.sinaSsoHandler.authorize(new WbAuthListener() { // from class: com.baidu.sapi2.activity.social.SinaSSOLoginActivity.1
            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void cancel() {
                SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
                sinaSSOLoginActivity.handleBack(sinaSSOLoginActivity.businessFrom);
            }

            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
                Toast.makeText(SinaSSOLoginActivity.this, wbConnectErrorMessage.getErrorMessage(), 0).show();
            }

            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
                SinaSSOLoginActivity.this.loadLoginInNA(ParamsUtil.getUrlBind(((SocialLoginBase) SinaSSOLoginActivity.this).configuration, SocialType.SINA_WEIBO_SSO, oauth2AccessToken.getToken(), oauth2AccessToken.getUid(), ((SocialLoginBase) SinaSSOLoginActivity.this).configuration.sinaAppId), "授权微博帐号登录中");
            }
        });
    }
}
