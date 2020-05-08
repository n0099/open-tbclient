package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.f.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.WebBindWidgetResult;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import java.util.Collections;
/* loaded from: classes6.dex */
public class BindWidgetActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_BIND_WIDGET_ACTION = "EXTRA_BIND_WIDGET_ACTION";
    public static final int REQUEST_CODE_LOGIN = 200001;
    private BindWidgetAction r;
    private String s;
    private WebBindWidgetResult t = new WebBindWidgetResult() { // from class: com.baidu.sapi2.activity.BindWidgetActivity.1
        @Override // com.baidu.sapi2.result.WebBindWidgetResult
        public void loginSuc() {
            super.loginSuc();
            BindWidgetActivity.this.onClose();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    private void finishActivity() {
        if (PassportSDK.getInstance().getWebBindWidgetCallback() != null) {
            PassportSDK.getInstance().getWebBindWidgetCallback().onFinish(this.t);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getWebBindWidgetDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200001 && i2 == -1) {
            onClose();
        }
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
        this.t.setResultCode(-301);
        this.t.setResultMsg("您已取消操作");
        finishActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            this.r = (BindWidgetAction) getIntent().getSerializableExtra(EXTRA_BIND_WIDGET_ACTION);
            this.s = getIntent().getStringExtra("EXTRA_BDUSS");
            if (this.r != null && !TextUtils.isEmpty(this.s)) {
                init();
                setupViews();
                return;
            }
            this.t.setResultCode(-204);
            this.t.setResultMsg("参数错误，请稍后再试");
            finishActivity();
        } catch (Throwable th) {
            reportWebviewError(th);
            onClose();
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
        configTitle();
        setTitleText(this.r.getName());
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.BindWidgetActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                BindWidgetActivity.this.e();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.BindWidgetActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                BindWidgetActivity.this.onClose();
            }
        });
        this.sapiWebView.setBindWidgetCallback(new SapiWebView.BindWidgetCallback() { // from class: com.baidu.sapi2.activity.BindWidgetActivity.4
            @Override // com.baidu.sapi2.SapiWebView.BindWidgetCallback
            public void onPhoneNumberExist(String str) {
                SapiAccountManager.getInstance().getSapiConfiguration().presetPhoneNumber = str;
                if (PassportSDK.getInstance().getWebBindWidgetDTO().handleLogin && PassportSDK.getInstance().getWebBindWidgetCallback() != null) {
                    BindWidgetActivity.this.t.setResultCode(-10001);
                    BindWidgetActivity.this.t.setResultMsg("请登录");
                    PassportSDK.getInstance().getWebBindWidgetCallback().onFinish(BindWidgetActivity.this.t);
                    return;
                }
                Intent intent = new Intent(BindWidgetActivity.this, LoginActivity.class);
                intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2003);
                BindWidgetActivity.this.startActivityForResult(intent, BindWidgetActivity.REQUEST_CODE_LOGIN);
            }
        });
        this.sapiWebView.loadBindWidget(this.r, this.s, null, true, Collections.singletonList(SapiWebView.EXTRA_BIND_WIDGET_CONFLICT_DETECT));
    }
}
