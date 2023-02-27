package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LoadExternalWebViewActivity extends BaseActivity {
    public static final String EXTRA_BUSINESS_FROM = "business_from";
    public static final String EXTRA_BUSINESS_FROM_ONE_KEY_LOGIN = "business_from_one_key_login";
    public static final String EXTRA_BUSINESS_TYPE = "business_type";
    public static final String EXTRA_EXTERNAL_TITLE = "extra_external_title";
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    public static final String EXTRA_PAGE_FROM = "page_from";
    public static final String RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE = "business_account_freeze";
    public static final String RESULT_BUSINESS_TYPE_PRE_SET_UNAME = "business_pre_set_username";
    public static final int z = 2001;
    public String t;
    public String u;
    public String v;
    public String w;
    public OneKeyLoginCallback x;
    public WebAuthResult webAuthResult = new WebAuthResult() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity(boolean z2) {
            super.finishActivity();
            LoadExternalWebViewActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            super.finishActivity();
            LoadExternalWebViewActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }
    };
    public AuthorizationListener y = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.2
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            if ("business_from_one_key_login".equals(LoadExternalWebViewActivity.this.v)) {
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(LoadExternalWebViewActivity.this.x, -103, null);
            }
            LoadExternalWebViewActivity.this.webAuthResult.setResultCode(i);
            LoadExternalWebViewActivity.this.webAuthResult.setResultMsg(str);
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                webAuthListener.onFailure(LoadExternalWebViewActivity.this.webAuthResult);
                CoreViewRouter.getInstance().release();
            }
            LoadExternalWebViewActivity.this.setResult(0);
            LoadExternalWebViewActivity.this.finish();
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            WebAuthListener webAuthListener;
            if ("business_from_one_key_login".equals(LoadExternalWebViewActivity.this.v)) {
                OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
                oneKeyLoginResult.setResultCode(0);
                if (LoadExternalWebViewActivity.this.x != null) {
                    LoadExternalWebViewActivity.this.x.onSuccess(oneKeyLoginResult);
                }
            }
            if (!LoginActivity.EXTRA_PARAM_PAGE_LOGIN.equals(LoadExternalWebViewActivity.this.w) && (webAuthListener = CoreViewRouter.getInstance().getWebAuthListener()) != null) {
                LoadExternalWebViewActivity loadExternalWebViewActivity = LoadExternalWebViewActivity.this;
                if (loadExternalWebViewActivity.webAuthResult == null) {
                    loadExternalWebViewActivity.webAuthResult = new WebAuthResult();
                }
                WebAuthResult webAuthResult = LoadExternalWebViewActivity.this.webAuthResult;
                webAuthResult.accountType = accountType;
                webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(LoadExternalWebViewActivity.this.webAuthResult);
                CoreViewRouter.getInstance().release();
            }
            Intent intent = new Intent();
            intent.putExtra("account_type", accountType.getType());
            LoadExternalWebViewActivity.this.setResult(-1, intent);
            LoadExternalWebViewActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getWebLoginDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        a();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        finish();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.x != null) {
            this.x = null;
        }
        if (this.webAuthResult != null) {
            this.webAuthResult = null;
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        a();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            this.x = CoreViewRouter.getInstance().getOneKeyLoginCallback();
            CoreViewRouter.getInstance().releaseOneKeyLoginCallback();
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback() != null) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
            extendSysWebViewMethodResult.params.put("retCode", -301);
            extendSysWebViewMethodResult.params.put("retMsg", "您已取消操作");
            CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback().onFinish(extendSysWebViewMethodResult);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.t = getIntent().getStringExtra(EXTRA_EXTERNAL_TITLE);
        this.u = getIntent().getStringExtra("extra_external_url");
        this.w = getIntent().getStringExtra("page_from");
        this.v = getIntent().getStringExtra(EXTRA_BUSINESS_FROM);
        if (TextUtils.isEmpty(this.u)) {
            setResult(0);
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2001 && i2 == -1) {
            this.loginStatusChange = true;
            setResult(-1, new Intent());
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setAuthorizationListener(this.y);
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                LoadExternalWebViewActivity.this.a();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.4
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                LoadExternalWebViewActivity.this.finish();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.5
            @Override // com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback
            public void onLeftBtnVisible(int i) {
                if (i == 0) {
                    LoadExternalWebViewActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    LoadExternalWebViewActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setCoverWebBdussCallback(new SapiWebView.CoverWebBdussCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.6
            @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussCallback
            public void onCoverBduss(String str, SapiWebView.CoverWebBdussResult coverWebBdussResult) {
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                if (currentAccount != null && !TextUtils.isEmpty(str) && !str.equals(currentAccount.bduss)) {
                    coverWebBdussResult.setWebBduss(currentAccount.bduss);
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.7
            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                Intent intent = new Intent(LoadExternalWebViewActivity.this, LoginActivity.class);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2003);
                int i = result.switchAccountType;
                if (i == 1) {
                    intent.putExtra("username", result.userName);
                } else if (i == 2) {
                    if (result.loginType == 0) {
                        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME);
                    } else {
                        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                    }
                    intent.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, true);
                    if (!TextUtils.isEmpty(result.displayName)) {
                        intent.putExtra("username", result.displayName);
                    }
                    intent.putExtra(LoginActivity.EXTRA_PARAM_ENCRYPTED_UID, result.encryptedUid);
                }
                LoadExternalWebViewActivity.this.startActivityForResult(intent, 2001);
            }
        });
        this.sapiWebView.setAccountFreezeCallback(new SapiWebView.AccountFreezeCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.8
            @Override // com.baidu.sapi2.SapiWebView.AccountFreezeCallback
            public void onAccountFreeze(SapiWebView.AccountFreezeCallback.AccountFreezeResult accountFreezeResult) {
                Intent intent = new Intent();
                intent.putExtra("business_type", LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE);
                LoadExternalWebViewActivity.this.setResult(-1, intent);
                LoadExternalWebViewActivity.this.finish();
            }
        });
        this.sapiWebView.setPreFillUserNameCallback(new SapiWebView.PreFillUserNameCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.9
            @Override // com.baidu.sapi2.SapiWebView.PreFillUserNameCallback
            public void onPreFillUserName(SapiWebView.PreFillUserNameCallback.PreFillUserNameResult preFillUserNameResult) {
                Intent intent = new Intent();
                intent.putExtra("business_type", LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_PRE_SET_UNAME);
                intent.putExtra("username", preFillUserNameResult.userName);
                LoadExternalWebViewActivity.this.setResult(-1, intent);
            }
        });
        this.sapiWebView.setWebviewPageFinishCallback(new SapiJsCallBacks.WebviewPageFinishCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.10
            @Override // com.baidu.sapi2.SapiJsCallBacks.WebviewPageFinishCallback
            public void onFinish(String str) {
                if (CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback() != null) {
                    ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
                    extendSysWebViewMethodResult.params.put("result", str);
                    CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback().onFinish(extendSysWebViewMethodResult);
                }
                LoadExternalWebViewActivity.this.finish();
            }
        });
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", webLoginDTO.statExtra));
        }
        this.sapiWebView.loadExternalUrl(this.u, arrayList);
    }
}
