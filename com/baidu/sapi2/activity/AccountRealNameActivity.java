package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AccountRealNameActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_CUSTOM_LINK = "EXTRA_CUSTOM_LINK";
    public static final String EXTRA_NEED_CB_KEY = "EXTRA_NEED_CB_KEY";
    public static final String EXTRA_REAL_NAME_LEVEL = "EXTRA_REAL_NAME_LEVEL";
    public static final String EXTRA_SCENE = "EXTRA_SCENE";
    public Bundle A;
    public String t;
    public String u;
    public boolean v;
    public String w;
    public int x;
    public AccountRealNameResult y = new AccountRealNameResult();
    public AccountRealNameCallback z;

    private void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.back();
        } else {
            onClose();
        }
    }

    private void finishActivity() {
        AccountRealNameCallback accountRealNameCallback = this.z;
        if (accountRealNameCallback != null) {
            accountRealNameCallback.onFinish();
            this.z.onFinish(this.y);
        }
        this.A = null;
        finish();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public RealNameDTO getWebDTO() {
        return CoreViewRouter.getInstance().getRealNameDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        Intent intent = getIntent();
        this.t = intent.getStringExtra("EXTRA_BDUSS");
        this.u = intent.getStringExtra("EXTRA_SCENE");
        this.v = intent.getBooleanExtra(EXTRA_NEED_CB_KEY, false);
        this.w = intent.getStringExtra(EXTRA_CUSTOM_LINK);
        this.x = intent.getIntExtra(EXTRA_REAL_NAME_LEVEL, 0);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        a();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        AccountRealNameResult accountRealNameResult = this.y;
        if (!accountRealNameResult.juniorRealNameSuc && !accountRealNameResult.seniorRealNameSuc) {
            accountRealNameResult.setResultCode(-301);
            this.y.setResultMsg("您已取消操作");
        } else {
            this.y.setResultCode(0);
            this.y.setResultMsg("成功");
        }
        finishActivity();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        a();
    }

    private void b() {
        if (!TextUtils.isEmpty(this.t)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.5
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
                    if (sapiWebView == null) {
                        return;
                    }
                    sapiWebView.loadAccountRealName(null, accountRealNameActivity.u, AccountRealNameActivity.this.v, AccountRealNameActivity.this.w, AccountRealNameActivity.this.x, AccountRealNameActivity.this.A);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (AccountRealNameActivity.this.sapiWebView == null) {
                        return;
                    }
                    String str = getTplStokenResult.tplStokenMap.get("pp");
                    AccountRealNameActivity accountRealNameActivity = AccountRealNameActivity.this;
                    accountRealNameActivity.sapiWebView.loadAccountRealName(str, accountRealNameActivity.u, AccountRealNameActivity.this.v, AccountRealNameActivity.this.w, AccountRealNameActivity.this.x, AccountRealNameActivity.this.A);
                }
            }, this.t, arrayList);
            return;
        }
        Toast.makeText(this, getString(R.string.sapi_sdk_account_center_please_relogin), 1).show();
        finishActivity();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(R.string.sapi_sdk_title_real_name);
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
                if (accountRealNameResult != null && AccountRealNameActivity.this.y != null && !accountRealNameResult.seniorRealNameSuc) {
                    accountRealNameResult.errorStep = AccountRealNameActivity.this.y.errorStep;
                    accountRealNameResult.subResultCode = AccountRealNameActivity.this.y.subResultCode;
                    accountRealNameResult.subResultMsg = AccountRealNameActivity.this.y.subResultMsg;
                }
                AccountRealNameActivity.this.y = accountRealNameResult;
            }
        });
        this.sapiWebView.setRealNameSubErrorCallback(new SapiJsCallBacks.RealNameSubErrorCallback() { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.4
            @Override // com.baidu.sapi2.SapiJsCallBacks.RealNameSubErrorCallback
            public void onFinish(AccountRealNameResult accountRealNameResult) {
                if (accountRealNameResult == null) {
                    return;
                }
                if (AccountRealNameActivity.this.y != null) {
                    AccountRealNameActivity.this.y.errorStep = accountRealNameResult.errorStep;
                    AccountRealNameActivity.this.y.subResultCode = accountRealNameResult.subResultCode;
                    AccountRealNameActivity.this.y.subResultMsg = accountRealNameResult.subResultMsg;
                    return;
                }
                AccountRealNameActivity.this.y = accountRealNameResult;
            }
        });
        b();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.z = CoreViewRouter.getInstance().getAccountRealNameCallback();
            CoreViewRouter.getInstance().releaseAccountRealNameCallback();
            RealNameDTO webDTO = getWebDTO();
            if (webDTO == null) {
                this.y.setResultCode(-208);
                this.y.setResultMsg(SapiResult.ERROR_MSG_DTO_IS_NULL);
                finishActivity();
                return;
            }
            this.A = webDTO.extraParams;
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.y.setResultCode(-202);
            this.y.setResultMsg("网络连接失败，请检查网络设置");
            finishActivity();
        }
    }
}
