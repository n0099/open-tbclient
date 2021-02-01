package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.j.a.a;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class AccountRealNameActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_CUSTOM_LINK = "EXTRA_CUSTOM_LINK";
    public static final String EXTRA_NEED_CB_KEY = "EXTRA_NEED_CB_KEY";
    public static final String EXTRA_SCENE = "EXTRA_SCENE";
    private String p;
    private String q;
    private boolean r;
    private String s;
    private AccountRealNameResult t = new AccountRealNameResult();

    private void finishActivity() {
        if (CoreViewRouter.getInstance().getAccountRealNameCallback() != null) {
            CoreViewRouter.getInstance().getAccountRealNameCallback().onFinish();
            CoreViewRouter.getInstance().getAccountRealNameCallback().onFinish(this.t);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getRealNameDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        Intent intent = getIntent();
        this.p = intent.getStringExtra("EXTRA_BDUSS");
        this.q = intent.getStringExtra(EXTRA_SCENE);
        this.r = intent.getBooleanExtra(EXTRA_NEED_CB_KEY, false);
        this.s = intent.getStringExtra(EXTRA_CUSTOM_LINK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        AccountRealNameResult accountRealNameResult = this.t;
        if (!accountRealNameResult.juniorRealNameSuc && !accountRealNameResult.seniorRealNameSuc) {
            accountRealNameResult.setResultCode(-301);
            this.t.setResultMsg("您已取消操作");
        } else {
            this.t.setResultCode(0);
            this.t.setResultMsg("成功");
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
            this.t.setResultCode(-202);
            this.t.setResultMsg("网络连接失败，请检查网络设置");
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
        a();
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
                AccountRealNameActivity.this.t = accountRealNameResult;
            }
        });
        b();
    }

    private void b() {
        if (!TextUtils.isEmpty(this.p)) {
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
                        sapiWebView.loadAccountRealName(null, accountRealNameActivity.q, AccountRealNameActivity.this.r, AccountRealNameActivity.this.s);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (AccountRealNameActivity.this.sapiWebView == null) {
                        return;
                    }
                    AccountRealNameActivity accountRealNameActivity = AccountRealNameActivity.this;
                    accountRealNameActivity.sapiWebView.loadAccountRealName(getTplStokenResult.tplStokenMap.get("pp"), accountRealNameActivity.q, AccountRealNameActivity.this.r, AccountRealNameActivity.this.s);
                }
            }, this.p, arrayList);
            return;
        }
        Toast.makeText(this, getString(a.g.sapi_sdk_account_center_please_relogin), 1).show();
        finishActivity();
    }

    private void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.back();
        } else {
            onClose();
        }
    }
}
