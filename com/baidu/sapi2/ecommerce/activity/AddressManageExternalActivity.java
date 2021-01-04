package com.baidu.sapi2.ecommerce.activity;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import java.util.List;
/* loaded from: classes15.dex */
public class AddressManageExternalActivity extends AddressManageActivity {
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    private static final String TAG = AddressManageExternalActivity.class.getSimpleName();
    private String url;

    /* JADX INFO: Access modifiers changed from: private */
    public void back() {
        this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
    }

    @Override // com.baidu.sapi2.ecommerce.activity.AddressManageActivity
    public void finishActivity() {
        super.finish();
    }

    @Override // com.baidu.sapi2.ecommerce.activity.AddressManageActivity
    public void loadAddressUrl(List<PassNameValuePair> list) {
        this.url = getIntent().getStringExtra("extra_external_url");
        this.sapiWebView.loadUrl(this.url);
    }

    @Override // com.baidu.sapi2.ecommerce.activity.AddressManageActivity, com.baidu.sapi2.activity.TitleActivity
    protected void onBottomBackBtnClick() {
        back();
    }

    @Override // com.baidu.sapi2.ecommerce.activity.AddressManageActivity, com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(TAG, "AddressManageExternalActivity onCreate");
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageExternalActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                AddressManageExternalActivity.this.back();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageExternalActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AddressManageExternalActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setOnSlidePageFinishCallback(new SapiWebView.OnSlidePageFinishCallback() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageExternalActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnSlidePageFinishCallback
            public void onFinish(String str) {
                if ("address".equals(str)) {
                    Intent intent = new Intent(AddressManageExternalActivity.this, AddressManageActivity.class);
                    intent.setFlags(67108864);
                    AddressManageExternalActivity.this.startActivity(intent);
                }
            }
        });
    }

    @Override // com.baidu.sapi2.ecommerce.activity.AddressManageActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    protected void onLeftBtnClick() {
        back();
    }

    @Override // com.baidu.sapi2.ecommerce.activity.AddressManageActivity, com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
