package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import java.util.List;
/* loaded from: classes2.dex */
public class AddressManageExternalActivity extends AddressManageActivity {
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    private static final String J = "AddressManageExternalActivity";
    private String K;

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
    }

    public void finishActivity() {
        super.finish();
    }

    @Override // com.baidu.sapi2.activity.AddressManageActivity
    public void loadAddressUrl(List<PassNameValuePair> list) {
        this.K = getIntent().getStringExtra("extra_external_url");
        this.sapiWebView.loadUrl(this.K);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.AddressManageActivity, com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        j();
    }

    @Override // com.baidu.sapi2.activity.AddressManageActivity, com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(J, "AddressManageExternalActivity onCreate");
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.AddressManageExternalActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                AddressManageExternalActivity.this.j();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.AddressManageExternalActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AddressManageExternalActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setOnSlidePageFinishCallback(new SapiWebView.OnSlidePageFinishCallback() { // from class: com.baidu.sapi2.activity.AddressManageExternalActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnSlidePageFinishCallback
            public void onFinish(String str) {
                if (SlideActiviy.ADDRESS_PAGE_NAME.equals(str)) {
                    AddressManageExternalActivity.this.startActivity(new Intent(AddressManageExternalActivity.this, AddressManageActivity.class));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.AddressManageActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        j();
    }
}
