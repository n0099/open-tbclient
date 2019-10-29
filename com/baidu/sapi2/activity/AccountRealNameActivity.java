package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.SapiResult;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AccountRealNameActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_NEED_CB_KEY = "EXTRA_NEED_CB_KEY";
    public static final String EXTRA_SCENE = "EXTRA_SCENE";
    private String bduss;
    private boolean needCbKey;
    private AccountRealNameResult realNameResult = new AccountRealNameResult();
    private String sence;

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.realNameResult.setResultCode(-202);
            this.realNameResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
        this.sence = getIntent().getStringExtra(EXTRA_SCENE);
        this.needCbKey = getIntent().getBooleanExtra(EXTRA_NEED_CB_KEY, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.g.sapi_sdk_title_real_name);
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                if (AccountRealNameActivity.this.sapiWebView != null && AccountRealNameActivity.this.sapiWebView.canGoBack()) {
                    AccountRealNameActivity.this.sapiWebView.goBack();
                    return false;
                }
                AccountRealNameActivity.this.onClose();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AccountRealNameActivity.this.onClose();
            }
        });
        this.sapiWebView.setRealNameStateCallback(new SapiJsCallBacks.RealNameStatusCallback() { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.3
            @Override // com.baidu.sapi2.SapiJsCallBacks.RealNameStatusCallback
            public void onFinish(AccountRealNameResult accountRealNameResult) {
                AccountRealNameActivity.this.realNameResult = accountRealNameResult;
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
                    if (AccountRealNameActivity.this.sapiWebView != null) {
                        AccountRealNameActivity.this.sapiWebView.loadAccountRealName(getTplStokenResult.tplStokenMap.get("pp"), AccountRealNameActivity.this.sence, AccountRealNameActivity.this.needCbKey);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    if (AccountRealNameActivity.this.sapiWebView != null) {
                        AccountRealNameActivity.this.sapiWebView.loadAccountRealName(null, AccountRealNameActivity.this.sence, AccountRealNameActivity.this.needCbKey);
                    }
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
        Toast.makeText(this, getString(a.g.sapi_sdk_account_center_please_relogin), 1).show();
        finishActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            goBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        goBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        if (this.realNameResult.juniorRealNameSuc || this.realNameResult.seniorRealNameSuc) {
            this.realNameResult.setResultCode(0);
            this.realNameResult.setResultMsg("成功");
        } else {
            this.realNameResult.setResultCode(-301);
            this.realNameResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        }
        finishActivity();
    }

    private void goBack() {
        if (this.sapiWebView != null && this.sapiWebView.canGoBack()) {
            this.sapiWebView.back();
        } else {
            onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getRealNameDTO();
    }

    private void finishActivity() {
        if (PassportSDK.getInstance().getAccountRealNameCallback() != null) {
            PassportSDK.getInstance().getAccountRealNameCallback().onFinish();
            PassportSDK.getInstance().getAccountRealNameCallback().onFinish(this.realNameResult);
        }
        finish();
        PassportSDK.getInstance().release();
    }
}
