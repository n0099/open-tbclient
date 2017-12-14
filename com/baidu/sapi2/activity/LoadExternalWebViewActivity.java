package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.b.a.a;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
/* loaded from: classes2.dex */
public class LoadExternalWebViewActivity extends TitleActivity {
    public static final String EXTRA_EXTERNAL_TITLE = "extra_external_title";
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    private static final int REQUEST_CODE_LOGIN = 2001;
    public static final String RESULT_BUSINESS_TYPE = "business_pre_set_username";
    private AuthorizationListener authorizationListener = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.1
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            LoadExternalWebViewActivity.this.setResult(0);
            LoadExternalWebViewActivity.this.finish();
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            Intent intent = new Intent();
            intent.putExtra(GiftTabActivityConfig.ACCOUNT_TYPE, accountType.getType());
            LoadExternalWebViewActivity.this.setResult(-1, intent);
            LoadExternalWebViewActivity.this.finish();
        }
    };
    private String title;
    private String url;

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
        init();
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void init() {
        super.init();
        this.title = getIntent().getStringExtra(EXTRA_EXTERNAL_TITLE);
        this.url = getIntent().getStringExtra(EXTRA_EXTERNAL_URL);
        if (TextUtils.isEmpty(this.url)) {
            setResult(0);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void setupViews() {
        super.setupViews();
        configTitle();
        this.sapiWebView.setAuthorizationListener(this.authorizationListener);
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                LoadExternalWebViewActivity.this.goBack();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                LoadExternalWebViewActivity.this.finish();
            }
        });
        this.sapiWebView.setWebViewTitleCallback(new SapiWebView.WebViewTitleCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.4
            @Override // com.baidu.sapi2.SapiWebView.WebViewTitleCallback
            public void onTitleChange(String str) {
                LoadExternalWebViewActivity.this.setTitleText(str);
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
                SapiAccount session = SapiAccountManager.getInstance().getSession();
                if (session != null && !TextUtils.isEmpty(str) && !str.equals(session.bduss)) {
                    coverWebBdussResult.setWebBduss(session.bduss);
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.7
            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch() {
                Intent intent = new Intent(LoadExternalWebViewActivity.this, LoginActivity.class);
                intent.putExtra(LoginActivity.EXTRA_PARAM_LOGIN_FROM_BUSINESS, 1);
                LoadExternalWebViewActivity.this.startActivityForResult(intent, 2001);
            }

            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                Intent intent = new Intent(LoadExternalWebViewActivity.this, LoginActivity.class);
                intent.putExtra(LoginActivity.EXTRA_PARAM_LOGIN_FROM_BUSINESS, 1);
                intent.putExtra("username", result.userName);
                LoadExternalWebViewActivity.this.startActivityForResult(intent, 2001);
            }
        });
        this.sapiWebView.setPreFillUserNameCallback(new SapiWebView.PreFillUserNameCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.8
            @Override // com.baidu.sapi2.SapiWebView.PreFillUserNameCallback
            public void onPreFillUserName(SapiWebView.PreFillUserNameCallback.PreFillUserNameResult preFillUserNameResult) {
                Intent intent = new Intent();
                intent.putExtra("business", LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE);
                intent.putExtra("username", preFillUserNameResult.userName);
                LoadExternalWebViewActivity.this.setResult(-1, intent);
            }
        });
        this.sapiWebView.loadExternalUrl(this.url);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void configTitle() {
        PassportViewManager.TitleViewModule titleViewModule = PassportViewManager.getInstance().getTitleViewModule();
        if (titleViewModule != null) {
            setTitleLayoutBg(titleViewModule.bgColor);
            setLeftBtnImage(titleViewModule.leftBtnImgResId);
            setLeftBtnImgVisible(titleViewModule.leftBtnImgVisible);
            setLeftBtnTextVisible(titleViewModule.leftBtnTextVisible);
            setLeftBtnTextColor(titleViewModule.leftBtnTextColor);
            setLeftBtnText(titleViewModule.leftBtnText);
            setLeftBtnTextSize(SapiUtils.px2sp(this, titleViewModule.leftBtnTextSize));
            setLeftBtnDrawable(titleViewModule.leftBtnDrawableLeft, titleViewModule.leftBtnDrawableTop, titleViewModule.leftBtnDrawableRight, titleViewModule.leftBtnDrawableBottom);
            setTitleVisible(titleViewModule.titleVisible);
            setTitleText(titleViewModule.titleText);
            setTitleTextColor(titleViewModule.titleTextColor);
            setTitleTextSize(SapiUtils.px2sp(this, titleViewModule.titleTextSize));
            setTitleDrawable(titleViewModule.titleDrawableLeft, titleViewModule.titleDrawableTop, titleViewModule.titleDrawableRight, titleViewModule.titleDrawableBottom);
            setRightBtnVisible(4);
            setRightBtnText(titleViewModule.rightBtnText);
            setRightBtnTextSize(SapiUtils.px2sp(this, titleViewModule.rightBtnTextSize));
            setRightBtnColor(titleViewModule.rightBtnTextColor);
            return;
        }
        setBtnVisibility(4, 0, 4);
        setTitleText(this.title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            goBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        if (this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
