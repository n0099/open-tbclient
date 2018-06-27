package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.c.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class LoadExternalWebViewActivity extends BaseActivity {
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
        try {
            setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
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
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
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
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.4
            @Override // com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback
            public void onLeftBtnVisible(int i) {
                if (i == 0) {
                    LoadExternalWebViewActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    LoadExternalWebViewActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setCoverWebBdussCallback(new SapiWebView.CoverWebBdussCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.5
            @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussCallback
            public void onCoverBduss(String str, SapiWebView.CoverWebBdussResult coverWebBdussResult) {
                SapiAccount session = SapiAccountManager.getInstance().getSession();
                if (session != null && !TextUtils.isEmpty(str) && !str.equals(session.bduss)) {
                    coverWebBdussResult.setWebBduss(session.bduss);
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.6
            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch() {
                Intent intent = new Intent(LoadExternalWebViewActivity.this, LoginActivity.class);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2003);
                LoadExternalWebViewActivity.this.startActivityForResult(intent, 2001);
            }

            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                Intent intent = new Intent(LoadExternalWebViewActivity.this, LoginActivity.class);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2003);
                intent.putExtra("username", result.userName);
                LoadExternalWebViewActivity.this.startActivityForResult(intent, 2001);
            }
        });
        this.sapiWebView.setPreFillUserNameCallback(new SapiWebView.PreFillUserNameCallback() { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.7
            @Override // com.baidu.sapi2.SapiWebView.PreFillUserNameCallback
            public void onPreFillUserName(SapiWebView.PreFillUserNameCallback.PreFillUserNameResult preFillUserNameResult) {
                Intent intent = new Intent();
                intent.putExtra("business", LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE);
                intent.putExtra("username", preFillUserNameResult.userName);
                LoadExternalWebViewActivity.this.setResult(-1, intent);
            }
        });
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new BasicNameValuePair("extrajson", webLoginDTO.statExtra));
        }
        this.sapiWebView.loadExternalUrl(this.url, arrayList);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void configTitle() {
        setTitleText(this.title);
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (PassportViewManager.getInstance().getTitleViewModule() != null) {
            configCustomTitle();
            return;
        }
        setBtnVisibility(4, 0, 4);
        if (sapiConfiguration.showBottomBack) {
            setLeftBtnDrawable(null, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
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
        finish();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
