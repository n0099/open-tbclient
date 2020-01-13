package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import java.util.List;
/* loaded from: classes5.dex */
public class InvoiceBuildExternalActivity extends InvoiceBuildActivity {
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    private static final String G = "InvoiceBuildExternalActivity";
    private String H;

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
    }

    public void finishActivity() {
        super.finish();
    }

    @Override // com.baidu.sapi2.activity.InvoiceBuildActivity
    public void loadInvoiceUrl(List<PassNameValuePair> list) {
        this.H = getIntent().getStringExtra("extra_external_url");
        this.sapiWebView.loadUrl(this.H);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.InvoiceBuildActivity, com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        h();
    }

    @Override // com.baidu.sapi2.activity.InvoiceBuildActivity, com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(G, "InvoiceBuildExternalActivity onCreate");
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.InvoiceBuildExternalActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                InvoiceBuildExternalActivity.this.h();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.InvoiceBuildExternalActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                InvoiceBuildExternalActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setOnSlidePageFinishCallback(new SapiWebView.OnSlidePageFinishCallback() { // from class: com.baidu.sapi2.activity.InvoiceBuildExternalActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnSlidePageFinishCallback
            public void onFinish(String str) {
                if (SlideActiviy.INVOICE_PAGE_NAME.equals(str)) {
                    InvoiceBuildExternalActivity.this.startActivity(new Intent(InvoiceBuildExternalActivity.this, InvoiceBuildActivity.class));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.InvoiceBuildActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        h();
    }
}
