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
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class FacebookSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String p = FacebookSSOLoginActivity.class.getSimpleName();
    public CallbackManager n;
    public LoginManager o;

    /* loaded from: classes2.dex */
    public class a implements FacebookCallback<LoginResult> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: a */
        public void onSuccess(LoginResult loginResult) {
            Log.d(FacebookSSOLoginActivity.p, "facebook LoginManager login success");
            String token = loginResult.getAccessToken().getToken();
            String userId = loginResult.getAccessToken().getUserId();
            String applicationId = loginResult.getAccessToken().getApplicationId();
            String str = FacebookSSOLoginActivity.p;
            Log.d(str, "token = " + token);
            String str2 = FacebookSSOLoginActivity.p;
            Log.d(str2, "userId = " + userId);
            String str3 = FacebookSSOLoginActivity.p;
            Log.d(str3, "applicationId = " + applicationId);
            String urlBind = ParamsUtil.getUrlBind(FacebookSSOLoginActivity.this.configuration, SocialType.FACEBOOK, token, userId, applicationId);
            HashMap hashMap = new HashMap();
            hashMap.put("supportGuestAccount", "1");
            String addExtras = ParamsUtil.addExtras(urlBind, hashMap);
            FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
            facebookSSOLoginActivity.a(addExtras, facebookSSOLoginActivity.getString(d.a.y.a.j.a.sapi_sdk_facebook_logging));
        }

        public void onCancel() {
            Log.d(FacebookSSOLoginActivity.p, "facebook LoginManager login cancel");
            FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
            facebookSSOLoginActivity.a(((BaseSSOLoginActivity) facebookSSOLoginActivity).f9828g);
        }

        public void onError(FacebookException facebookException) {
            Log.d(FacebookSSOLoginActivity.p, "facebook LoginManager login error");
            FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
            facebookSSOLoginActivity.a(((BaseSSOLoginActivity) facebookSSOLoginActivity).f9828g);
        }
    }

    private void e() {
        this.n = CallbackManager.Factory.create();
        LoginManager loginManager = LoginManager.getInstance();
        this.o = loginManager;
        loginManager.setDefaultAudience(DefaultAudience.FRIENDS);
        this.o.setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
        this.o.setAuthType("rerequest");
        this.o.logInWithReadPermissions(this, Arrays.asList("public_profile"));
        LoginManager.getInstance().registerCallback(this.n, new a());
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.n.onActivityResult(i2, i3, intent);
        super.onActivityResult(i2, i3, intent);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e();
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(d.a.y.a.j.a.sapi_sdk_title_login_facebook);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }
}
