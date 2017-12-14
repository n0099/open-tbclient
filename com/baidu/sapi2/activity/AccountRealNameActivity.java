package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.b.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AccountRealNameActivity extends TitleActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    private String bduss;

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
        this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setWebViewTitleCallback(new SapiWebView.WebViewTitleCallback() { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.1
            @Override // com.baidu.sapi2.SapiWebView.WebViewTitleCallback
            public void onTitleChange(String str) {
                AccountRealNameActivity.this.setTitleText(str);
            }
        });
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                if (!AccountRealNameActivity.this.sapiWebView.canGoBack()) {
                    AccountRealNameActivity.this.finishActivity();
                    return false;
                }
                AccountRealNameActivity.this.sapiWebView.goBack();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AccountRealNameActivity.this.finishActivity();
            }
        });
        loadAccountRealName();
    }

    private void loadAccountRealName() {
        if (!TextUtils.isEmpty(this.bduss)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    AccountRealNameActivity.this.sapiWebView.loadAccountRealName(getTplStokenResult.tplStokenMap.get("pp"));
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    AccountRealNameActivity.this.sapiWebView.loadAccountRealName(null);
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }
            }, this.bduss, arrayList);
            return;
        }
        Toast.makeText(this, getString(a.f.sapi_sdk_account_center_please_relogin), 1).show();
        finishActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            goBack();
        }
    }

    private void goBack() {
        if (this.sapiWebView.canGoBack()) {
            this.sapiWebView.back();
        } else {
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (PassportSDK.getInstance().getAccountRealNameCallback() != null) {
            PassportSDK.getInstance().getAccountRealNameCallback().onFinish();
        }
        PassportSDK.getInstance().release();
        finish();
    }
}
