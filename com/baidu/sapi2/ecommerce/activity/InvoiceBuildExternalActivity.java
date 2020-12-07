package com.baidu.sapi2.ecommerce.activity;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import java.util.List;
/* loaded from: classes16.dex */
public class InvoiceBuildExternalActivity extends InvoiceBuildActivity {
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    private static final String TAG = InvoiceBuildExternalActivity.class.getSimpleName();
    private String url;

    /* JADX INFO: Access modifiers changed from: private */
    public void back() {
        this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
    }

    public void finishActivity() {
        super.finish();
    }

    @Override // com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity
    public void loadInvoiceUrl(List<PassNameValuePair> list) {
        this.url = getIntent().getStringExtra("extra_external_url");
        this.sapiWebView.loadUrl(this.url);
    }

    @Override // com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity, com.baidu.sapi2.activity.TitleActivity
    protected void onBottomBackBtnClick() {
        back();
    }

    @Override // com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity, com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(TAG, "InvoiceBuildExternalActivity onCreate");
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.ecommerce.activity.InvoiceBuildExternalActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                InvoiceBuildExternalActivity.this.back();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.ecommerce.activity.InvoiceBuildExternalActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                InvoiceBuildExternalActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setOnSlidePageFinishCallback(new SapiWebView.OnSlidePageFinishCallback() { // from class: com.baidu.sapi2.ecommerce.activity.InvoiceBuildExternalActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnSlidePageFinishCallback
            public void onFinish(String str) {
                if ("invoice".equals(str)) {
                    Intent intent = new Intent(InvoiceBuildExternalActivity.this, InvoiceBuildActivity.class);
                    intent.setFlags(67108864);
                    InvoiceBuildExternalActivity.this.startActivity(intent);
                }
            }
        });
    }

    @Override // com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    protected void onLeftBtnClick() {
        back();
    }
}
