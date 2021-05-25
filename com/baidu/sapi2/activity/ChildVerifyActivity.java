package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.utils.Log;
import d.a.a0.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ChildVerifyActivity extends BaseActivity {
    public static final String EXTRA_EXTERNAL_URL = "external_url";
    public static final String t = "ChildVerifyActivity";

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setWebviewPageFinishCallback(new SapiJsCallBacks.WebviewPageFinishCallback() { // from class: com.baidu.sapi2.activity.ChildVerifyActivity.1
            @Override // com.baidu.sapi2.SapiJsCallBacks.WebviewPageFinishCallback
            public void onFinish(String str) {
                Log.d(ChildVerifyActivity.t, "WebviewPageFinishCallback onFinish result=" + str);
                AccountRealNameCallback accountRealNameCallback = CoreViewRouter.getInstance().getAccountRealNameCallback();
                if (accountRealNameCallback != null) {
                    AccountRealNameResult accountRealNameResult = new AccountRealNameResult();
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                    if (jSONObject != null) {
                        accountRealNameResult.setResultCode(0);
                        accountRealNameResult.setResultMsg("成功");
                        accountRealNameResult.callbackkey = jSONObject.optString("callbackKey");
                    } else {
                        accountRealNameResult.setResultCode(-202);
                        accountRealNameResult.setResultMsg("网络连接失败，请检查网络设置");
                    }
                    accountRealNameCallback.onFinish(accountRealNameResult);
                }
                ChildVerifyActivity.this.finish();
            }
        });
        this.sapiWebView.loadUrl(getIntent().getStringExtra("external_url"));
    }
}
