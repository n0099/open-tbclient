package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.d.a.a.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XiaomiSSOLoginActivity extends BaseSSOLoginActivity {

    /* loaded from: classes2.dex */
    public interface Callback {
        void onFinish();

        void onStart();

        void onSuccess(String str, String str2, String str3);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.b.sapi_sdk_title_login_xiaomi);
        login(SapiAccountManager.getInstance().getConfignation(), new Callback() { // from class: com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.1
            @Override // com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.Callback
            public void onStart() {
                XiaomiSSOLoginActivity.this.sapiWebView.showProgress();
            }

            @Override // com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.Callback
            public void onSuccess(String str, String str2, String str3) {
                XiaomiSSOLoginActivity.this.sapiWebView.dismissProgress();
                XiaomiSSOLoginActivity.this.sapiWebView.loadXiaomiSSOLogin(XiaomiSSOLoginActivity.this.getStatParamList(), str, str2, str3);
            }

            @Override // com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.Callback
            public void onFinish() {
                XiaomiSSOLoginActivity.this.sapiWebView.dismissProgress();
                XiaomiSSOLoginActivity.this.handleBack(XiaomiSSOLoginActivity.this.businessFrom);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity$2] */
    public void login(final SapiConfiguration sapiConfiguration, final Callback callback) {
        final XiaomiOAuthFuture startGetAccessToken = new XiaomiOAuthorize().setAppId(sapiConfiguration.xiaomiAppID.longValue()).setRedirectUrl(sapiConfiguration.xiaomiRedirectUri).setScope(new int[]{1, 3, 4}).startGetAccessToken(this);
        new Thread() { // from class: com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                callback.onStart();
                try {
                    XiaomiOAuthResults xiaomiOAuthResults = (XiaomiOAuthResults) startGetAccessToken.getResult();
                    if (xiaomiOAuthResults != null && xiaomiOAuthResults.getAccessToken() != null) {
                        String callOpenApi = XiaomiSSOLoginActivity.this.callOpenApi(xiaomiOAuthResults, sapiConfiguration, "/user/profile");
                        String callOpenApi2 = XiaomiSSOLoginActivity.this.callOpenApi(xiaomiOAuthResults, sapiConfiguration, "/user/phone");
                        if (TextUtils.isEmpty(callOpenApi) || TextUtils.isEmpty(callOpenApi2)) {
                            callback.onFinish();
                            return;
                        } else {
                            callback.onSuccess(xiaomiOAuthResults.getAccessToken(), callOpenApi, callOpenApi2);
                            return;
                        }
                    }
                    callback.onFinish();
                } catch (Exception e) {
                    Log.e(e);
                    callback.onFinish();
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String callOpenApi(XiaomiOAuthResults xiaomiOAuthResults, SapiConfiguration sapiConfiguration, String str) {
        JSONObject jSONObject;
        String optString;
        XiaomiOAuthFuture callOpenApi = new XiaomiOAuthorize().callOpenApi(sapiConfiguration.context, sapiConfiguration.xiaomiAppID.longValue(), str, xiaomiOAuthResults.getAccessToken(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm());
        String str2 = "/user/profile".equals(str) ? "userId" : "phone";
        try {
            jSONObject = new JSONObject((String) callOpenApi.getResult());
            optString = jSONObject.optString("result");
        } catch (Exception e) {
            Log.e(e);
        }
        if ("ok".equals(optString)) {
            return jSONObject.getJSONObject("data").optString(str2);
        }
        if ("error".equals(optString)) {
            Log.e(jSONObject.optString("description") + "(" + jSONObject.optString("code") + ")", new Object[0]);
        }
        return null;
    }
}
