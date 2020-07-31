package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.g.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import java.util.ArrayList;
/* loaded from: classes19.dex */
public class AccountRealNameActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_NEED_CB_KEY = "EXTRA_NEED_CB_KEY";
    public static final String EXTRA_SCENE = "EXTRA_SCENE";
    private String r;
    private String s;
    private boolean t;
    private AccountRealNameResult u = new AccountRealNameResult();

    private void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.back();
        } else {
            onClose();
        }
    }

    private void f() {
        if (!TextUtils.isEmpty(this.r)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.4
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    AccountRealNameActivity accountRealNameActivity = AccountRealNameActivity.this;
                    SapiWebView sapiWebView = accountRealNameActivity.sapiWebView;
                    if (sapiWebView != null) {
                        sapiWebView.loadAccountRealName(null, accountRealNameActivity.s, AccountRealNameActivity.this.t);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (AccountRealNameActivity.this.sapiWebView == null) {
                        return;
                    }
                    AccountRealNameActivity accountRealNameActivity = AccountRealNameActivity.this;
                    accountRealNameActivity.sapiWebView.loadAccountRealName(getTplStokenResult.tplStokenMap.get("pp"), accountRealNameActivity.s, AccountRealNameActivity.this.t);
                }
            }, this.r, arrayList);
            return;
        }
        Toast.makeText(this, getString(a.g.sapi_sdk_account_center_please_relogin), 1).show();
        finishActivity();
    }

    private void finishActivity() {
        if (PassportSDK.getInstance().getAccountRealNameCallback() != null) {
            PassportSDK.getInstance().getAccountRealNameCallback().onFinish();
            PassportSDK.getInstance().getAccountRealNameCallback().onFinish(this.u);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getRealNameDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.r = getIntent().getStringExtra("EXTRA_BDUSS");
        this.s = getIntent().getStringExtra(EXTRA_SCENE);
        this.t = getIntent().getBooleanExtra(EXTRA_NEED_CB_KEY, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        AccountRealNameResult accountRealNameResult = this.u;
        if (!accountRealNameResult.juniorRealNameSuc && !accountRealNameResult.seniorRealNameSuc) {
            accountRealNameResult.setResultCode(-301);
            this.u.setResultMsg("您已取消操作");
        } else {
            this.u.setResultCode(0);
            this.u.setResultMsg("成功");
        }
        finishActivity();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.u.setResultCode(-202);
            this.u.setResultMsg("网络连接失败，请检查网络设置");
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.g.sapi_sdk_title_real_name);
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                SapiWebView sapiWebView = AccountRealNameActivity.this.sapiWebView;
                if (sapiWebView != null && sapiWebView.canGoBack()) {
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
                AccountRealNameActivity.this.u = accountRealNameResult;
            }
        });
        f();
    }
}
