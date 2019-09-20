package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.AddressManageDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.result.AddressManageResult;
import com.baidu.sapi2.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AddressManageActivity extends BaseActivity {
    private static final String EXTRA_PARAMS_TYPE = "select";
    private AddressManageDTO addressManageDTO;
    private AddressManageResult addressManageResult = new AddressManageResult();

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.addressManageResult.setResultCode(-202);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.addressManageDTO = PassportSDK.getInstance().getAddressManageDTO();
        if (this.addressManageDTO == null) {
            this.addressManageResult.setResultCode(-204);
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
        this.addressManageResult.setResultCode(-301);
        finishActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getAddressManageDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void configTitle() {
        setTitleText("收货地址");
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
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.AddressManageActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                AddressManageActivity.this.back();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.AddressManageActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AddressManageActivity.this.addressManageResult.setResultCode(-301);
                AddressManageActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setAddressManageCallback(new SapiJsCallBacks.AddressManageCallback() { // from class: com.baidu.sapi2.activity.AddressManageActivity.3
            @Override // com.baidu.sapi2.SapiJsCallBacks.AddressManageCallback
            public void onCallback(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        AddressManageActivity.this.addressManageResult.map.put(next, jSONObject.optString(next));
                    }
                    AddressManageActivity.this.addressManageResult.setResultCode(0);
                } catch (JSONException e) {
                    Log.e(e);
                    AddressManageActivity.this.addressManageResult.setResultCode(-205);
                }
                AddressManageActivity.this.finishActivity();
            }
        });
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new PassNameValuePair(EXTRA_PARAMS_TYPE, this.addressManageDTO.type));
        this.sapiWebView.loadAddressManage(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (PassportSDK.getInstance().getAddressManageCallback() != null) {
            PassportSDK.getInstance().getAddressManageCallback().onFinish(this.addressManageResult);
        }
        finish();
        PassportSDK.getInstance().release();
    }
}
