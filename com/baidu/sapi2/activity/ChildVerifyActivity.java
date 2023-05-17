package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.tieba.R;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ChildVerifyActivity extends BaseActivity {
    public static final String EXTRA_EXTERNAL_URL = "external_url";
    public static final String u = "ChildVerifyActivity";
    public AccountRealNameCallback t;

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setWebviewPageFinishCallback(new SapiJsCallBacks.WebviewPageFinishCallback() { // from class: com.baidu.sapi2.activity.ChildVerifyActivity.1
            @Override // com.baidu.sapi2.SapiJsCallBacks.WebviewPageFinishCallback
            public void onFinish(String str) {
                Log.d(ChildVerifyActivity.u, "WebviewPageFinishCallback onFinish result=" + str);
                if (ChildVerifyActivity.this.t != null) {
                    AccountRealNameResult accountRealNameResult = new AccountRealNameResult();
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                    if (jSONObject != null) {
                        accountRealNameResult.setResultCode(0);
                        accountRealNameResult.setResultMsg("成功");
                        accountRealNameResult.callbackkey = jSONObject.optString("callbackKey");
                    } else {
                        accountRealNameResult.setResultCode(-202);
                        accountRealNameResult.setResultMsg("网络连接失败，请检查网络设置");
                    }
                    ChildVerifyActivity.this.t.onFinish(accountRealNameResult);
                }
                ChildVerifyActivity.this.finish();
            }
        });
        this.sapiWebView.loadUrl(getIntent().getStringExtra("external_url"));
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.t = CoreViewRouter.getInstance().getAccountRealNameCallback();
            CoreViewRouter.getInstance().releaseAccountRealNameCallback();
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
        }
    }
}
