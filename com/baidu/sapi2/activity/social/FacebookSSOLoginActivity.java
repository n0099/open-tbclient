package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import d.b.x.a.j.a;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class FacebookSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String TAG = FacebookSSOLoginActivity.class.getSimpleName();
    public CallbackManager callbackManager;
    public LoginManager loginManager;

    private void initFacebook() {
        this.callbackManager = CallbackManager.Factory.create();
        LoginManager loginManager = LoginManager.getInstance();
        this.loginManager = loginManager;
        loginManager.setDefaultAudience(DefaultAudience.FRIENDS);
        this.loginManager.setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
        this.loginManager.setAuthType("rerequest");
        this.loginManager.logInWithReadPermissions(this, Arrays.asList("public_profile"));
        LoginManager.getInstance().registerCallback(this.callbackManager, new FacebookCallback<LoginResult>() { // from class: com.baidu.sapi2.activity.social.FacebookSSOLoginActivity.1
            public void onCancel() {
                Log.d(FacebookSSOLoginActivity.TAG, "facebook LoginManager login cancel");
                FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
                facebookSSOLoginActivity.handleBack(facebookSSOLoginActivity.businessFrom);
            }

            public void onError(FacebookException facebookException) {
                Log.d(FacebookSSOLoginActivity.TAG, "facebook LoginManager login error");
                FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
                facebookSSOLoginActivity.handleBack(facebookSSOLoginActivity.businessFrom);
            }

            /* JADX DEBUG: Method merged with bridge method */
            public void onSuccess(LoginResult loginResult) {
                Log.d(FacebookSSOLoginActivity.TAG, "facebook LoginManager login success");
                String token = loginResult.getAccessToken().getToken();
                String userId = loginResult.getAccessToken().getUserId();
                String applicationId = loginResult.getAccessToken().getApplicationId();
                String str = FacebookSSOLoginActivity.TAG;
                Log.d(str, "token = " + token);
                String str2 = FacebookSSOLoginActivity.TAG;
                Log.d(str2, "userId = " + userId);
                String str3 = FacebookSSOLoginActivity.TAG;
                Log.d(str3, "applicationId = " + applicationId);
                String urlBind = ParamsUtil.getUrlBind(FacebookSSOLoginActivity.this.configuration, SocialType.FACEBOOK, token, userId, applicationId);
                HashMap hashMap = new HashMap();
                hashMap.put("supportGuestAccount", "1");
                String addExtras = ParamsUtil.addExtras(urlBind, hashMap);
                FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
                facebookSSOLoginActivity.loadLoginInNA(addExtras, facebookSSOLoginActivity.getString(a.sapi_sdk_facebook_logging));
            }
        });
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.callbackManager.onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initFacebook();
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.sapi_sdk_title_login_facebook);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }
}
