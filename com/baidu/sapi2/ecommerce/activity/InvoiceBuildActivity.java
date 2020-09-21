package com.baidu.sapi2.ecommerce.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.k.a.a;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.SlideActiviy;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
import com.baidu.sapi2.ecommerce.result.InvoiceBuildResult;
import com.baidu.sapi2.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class InvoiceBuildActivity extends SlideActiviy {
    private static final String EXTRA_PARAMS_ISCHECK = "isCheck";
    private static final String EXTRA_PARAMS_ISCHECKTAG = "isCheckTag";
    private static final String EXTRA_PARAMS_TYPE = "select";
    private static final String INVOICE_BUILD_ACTIVITY = "InvoiceBuildActivity";
    private InvoiceBuildDTO invoiceBuildDTO;
    private InvoiceBuildResult invoiceBuildResult = new InvoiceBuildResult();

    /* JADX INFO: Access modifiers changed from: private */
    public void back() {
        if (this.sapiWebView != null && this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.invoiceBuildResult.setResultCode(-301);
        finishActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (EcommerceRouter.getInstance().getInvoiceBuildCallback() != null) {
            EcommerceRouter.getInstance().getInvoiceBuildCallback().onFinish(this.invoiceBuildResult);
        }
        EcommerceRouter.getInstance().release();
        finish();
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void finishActivityAfterSlideOver() {
        if (INVOICE_BUILD_ACTIVITY.equals(getClass().getSimpleName())) {
            this.invoiceBuildResult.setResultCode(-301);
            finishActivity();
            return;
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return EcommerceRouter.getInstance().getInvoiceBuildDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.invoiceBuildDTO = EcommerceRouter.getInstance().getInvoiceBuildDTO();
        if (this.invoiceBuildDTO == null) {
            this.invoiceBuildResult.setResultCode(-204);
            finishActivity();
        }
    }

    public void loadInvoiceUrl(List<PassNameValuePair> list) {
        this.sapiWebView.loadInvoiceBuild(list);
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    protected void loadSlideWebview(String str, String str2, String str3) {
        if (!"invoice".equals(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Intent intent = new Intent(this, InvoiceBuildExternalActivity.class);
        intent.putExtra("extra_external_url", str2);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        back();
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.invoiceBuildResult.setResultCode(-202);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        back();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                InvoiceBuildActivity.this.back();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                InvoiceBuildActivity.this.invoiceBuildResult.setResultCode(-301);
                InvoiceBuildActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setInvoiceBuildCallback(new SapiJsCallBacks.InvoiceBuildCallback() { // from class: com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity.3
            @Override // com.baidu.sapi2.SapiJsCallBacks.InvoiceBuildCallback
            public void onCallback(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        InvoiceBuildActivity.this.invoiceBuildResult.map.put(next, jSONObject.optString(next));
                    }
                    InvoiceBuildActivity.this.invoiceBuildResult.setResultCode(0);
                } catch (JSONException e) {
                    Log.e(e);
                    InvoiceBuildActivity.this.invoiceBuildResult.setResultCode(-205);
                }
                InvoiceBuildActivity.this.finishActivity();
            }
        });
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new PassNameValuePair("slidePage", "1"));
        InvoiceBuildDTO invoiceBuildDTO = this.invoiceBuildDTO;
        if (invoiceBuildDTO != null) {
            arrayList.add(new PassNameValuePair(EXTRA_PARAMS_TYPE, invoiceBuildDTO.TYPE));
            arrayList.add(new PassNameValuePair("tplse", this.invoiceBuildDTO.tplse));
            arrayList.add(new PassNameValuePair("tplt", this.invoiceBuildDTO.tplt));
            if (this.invoiceBuildDTO.isExamineVAT) {
                arrayList.add(new PassNameValuePair(EXTRA_PARAMS_ISCHECK, "1"));
            }
            if (this.invoiceBuildDTO.showCheckTag) {
                arrayList.add(new PassNameValuePair(EXTRA_PARAMS_ISCHECKTAG, "1"));
            }
        }
        loadInvoiceUrl(arrayList);
    }
}
