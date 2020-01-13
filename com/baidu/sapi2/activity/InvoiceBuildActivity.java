package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.i.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.InvoiceBuildDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.result.InvoiceBuildResult;
import com.baidu.sapi2.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class InvoiceBuildActivity extends SlideActiviy {
    private static final String A = "select";
    private static final String B = "isCheck";
    private static final String C = "isCheckTag";
    private static final String D = "slidePage";
    private static final String z = "InvoiceBuildActivity";
    private InvoiceBuildDTO E;
    private InvoiceBuildResult F = new InvoiceBuildResult();

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (PassportSDK.getInstance().getInvoiceBuildCallback() != null) {
            PassportSDK.getInstance().getInvoiceBuildCallback().onFinish(this.F);
        }
        PassportSDK.getInstance().release();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.F.setResultCode(-301);
        finishActivity();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void configTitle() {
        if (PassportViewManager.getInstance().getTitleViewModule() != null) {
            configCustomTitle();
            return;
        }
        switchDarkmode();
        setBtnVisibility(4, 0, 4);
        setTitleDrawable(null, null, null, null);
        setLeftBtnDrawable(getResources().getDrawable(a.d.sapi_sdk_btn_back), null, null, null);
        if (this.configuration.showBottomBack) {
            setBtnVisibility(4, 4, 4);
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void finishActivityAfterSlideOver() {
        if (z.equals(getClass().getSimpleName())) {
            this.F.setResultCode(-301);
            finishActivity();
            return;
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getInvoiceBuildDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.E = PassportSDK.getInstance().getInvoiceBuildDTO();
        if (this.E == null) {
            this.F.setResultCode(-204);
            finishActivity();
        }
    }

    public void loadInvoiceUrl(List<PassNameValuePair> list) {
        this.sapiWebView.loadInvoiceBuild(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        g();
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
            this.F.setResultCode(-202);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        g();
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    protected void setupViews() {
        super.setupViews();
        configTitle();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.InvoiceBuildActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                InvoiceBuildActivity.this.g();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.InvoiceBuildActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                InvoiceBuildActivity.this.F.setResultCode(-301);
                InvoiceBuildActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setInvoiceBuildCallback(new SapiJsCallBacks.InvoiceBuildCallback() { // from class: com.baidu.sapi2.activity.InvoiceBuildActivity.3
            @Override // com.baidu.sapi2.SapiJsCallBacks.InvoiceBuildCallback
            public void onCallback(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        InvoiceBuildActivity.this.F.map.put(next, jSONObject.optString(next));
                    }
                    InvoiceBuildActivity.this.F.setResultCode(0);
                } catch (JSONException e) {
                    Log.e(e);
                    InvoiceBuildActivity.this.F.setResultCode(-205);
                }
                InvoiceBuildActivity.this.finishActivity();
            }
        });
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new PassNameValuePair(D, "1"));
        arrayList.add(new PassNameValuePair(A, this.E.TYPE));
        if (this.E.isExamineVAT) {
            arrayList.add(new PassNameValuePair(B, "1"));
        }
        if (this.E.showCheckTag) {
            arrayList.add(new PassNameValuePair(C, "1"));
        }
        loadInvoiceUrl(arrayList);
    }
}
