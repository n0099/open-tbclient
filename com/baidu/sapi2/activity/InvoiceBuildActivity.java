package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.d.a.a;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class InvoiceBuildActivity extends BaseActivity {
    private static final String EXTRA_PARAMS_ISCHECK = "isCheck";
    private static final String EXTRA_PARAMS_TYPE = "select";
    private InvoiceBuildDTO invoiceBuildDTO;
    private InvoiceBuildResult invoiceBuildResult = new InvoiceBuildResult();

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
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

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.invoiceBuildDTO = PassportSDK.getInstance().getInvoiceBuildDTO();
        if (this.invoiceBuildDTO == null) {
            this.invoiceBuildResult.setResultCode(-204);
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        back();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        back();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void back() {
        if (this.sapiWebView != null && this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.invoiceBuildResult.setResultCode(-301);
        finishActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getInvoiceBuildDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void configTitle() {
        setTitleText("发票管理");
        if (PassportViewManager.getInstance().getTitleViewModule() != null) {
            configCustomTitle();
            return;
        }
        setBtnVisibility(4, 0, 4);
        setTitleDrawable(null, null, null, null);
        setLeftBtnDrawable(getResources().getDrawable(a.d.sapi_sdk_btn_back), null, null, null);
        if (this.configuration.showBottomBack) {
            setBtnVisibility(4, 4, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        configTitle();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.InvoiceBuildActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                InvoiceBuildActivity.this.back();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.InvoiceBuildActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                InvoiceBuildActivity.this.invoiceBuildResult.setResultCode(-301);
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
        arrayList.add(new PassNameValuePair(EXTRA_PARAMS_TYPE, this.invoiceBuildDTO.TYPE));
        if (this.invoiceBuildDTO.isExamineVAT) {
            arrayList.add(new PassNameValuePair(EXTRA_PARAMS_ISCHECK, "1"));
        }
        this.sapiWebView.loadInvoiceBuild(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (PassportSDK.getInstance().getInvoiceBuildCallback() != null) {
            PassportSDK.getInstance().getInvoiceBuildCallback().onFinish(this.invoiceBuildResult);
        }
        PassportSDK.getInstance().release();
        finish();
    }
}
