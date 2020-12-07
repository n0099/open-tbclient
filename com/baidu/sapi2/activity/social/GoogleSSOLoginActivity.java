package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.l.a.a.a;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
/* loaded from: classes20.dex */
public class GoogleSSOLoginActivity extends BaseSSOLoginActivity {
    private final String TAG = "GoogleSSOLoginActivity";
    private final int SIGN_IN_REQUEST_CODE = 1000;

    private void getAuthCode() {
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        String idToken = lastSignedInAccount != null ? lastSignedInAccount.getIdToken() : null;
        if (!TextUtils.isEmpty(idToken)) {
            startSSOLogin(idToken);
        } else {
            startActivityForResult(GoogleSignIn.getClient(this, getOptions()).getSignInIntent(), 1000);
        }
    }

    private GoogleSignInOptions getOptions() {
        return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(this.configuration.googleClientId).build();
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            startSSOLogin(((GoogleSignInAccount) task.getResult(ApiException.class)).getIdToken());
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            String message = e.getMessage();
            Log.d("GoogleSSOLoginActivity", "handleSignInResult exception code=" + statusCode + " msg=" + message);
            handleBack(this.businessFrom, statusCode, message);
        }
    }

    private void startSSOLogin(String str) {
        String urlBind = ParamsUtil.getUrlBind(this.configuration, SocialType.GOOGLE, "", "", this.configuration.googleClientId);
        HashMap hashMap = new HashMap();
        hashMap.put("supportGuestAccount", "1");
        hashMap.put("id_token", str);
        loadLoginInNA(ParamsUtil.addExtras(urlBind, hashMap), getString(a.c.sapi_sdk_google_loging));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1000) {
            handleSignInResult(GoogleSignIn.getSignedInAccountFromIntent(intent));
        }
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
        setTitleText(a.c.sapi_sdk_title_login_google);
        getAuthCode();
    }
}
