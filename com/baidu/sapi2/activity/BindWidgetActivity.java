package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.WebBindWidgetResult;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import d.a.y.a.f;
import java.util.Collections;
/* loaded from: classes2.dex */
public class BindWidgetActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_BIND_WIDGET_ACTION = "EXTRA_BIND_WIDGET_ACTION";
    public static final int REQUEST_CODE_LOGIN = 200001;
    public BindWidgetAction t;
    public String u;
    public WebBindWidgetResult v = new WebBindWidgetResult() { // from class: com.baidu.sapi2.activity.BindWidgetActivity.1
        @Override // com.baidu.sapi2.result.WebBindWidgetResult
        public void loginSuc() {
            super.loginSuc();
            BindWidgetActivity.this.onClose();
        }
    };

    private void finishActivity() {
        if (CoreViewRouter.getInstance().getWebBindWidgetCallback() != null) {
            CoreViewRouter.getInstance().getWebBindWidgetCallback().onFinish(this.v);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getWebBindWidgetDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 200001 && i3 == -1) {
            onClose();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        a();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.v.setResultCode(-301);
        this.v.setResultMsg("您已取消操作");
        finishActivity();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            this.t = (BindWidgetAction) getIntent().getSerializableExtra(EXTRA_BIND_WIDGET_ACTION);
            String stringExtra = getIntent().getStringExtra("EXTRA_BDUSS");
            this.u = stringExtra;
            if (this.t != null && !TextUtils.isEmpty(stringExtra)) {
                init();
                setupViews();
                return;
            }
            this.v.setResultCode(-204);
            this.v.setResultMsg("参数错误，请稍后再试");
            finishActivity();
        } catch (Throwable th) {
            reportWebviewError(th);
            onClose();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            a();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(this.t.getName());
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.BindWidgetActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                BindWidgetActivity.this.a();
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
                if (CoreViewRouter.getInstance().getWebBindWidgetDTO().handleLogin && CoreViewRouter.getInstance().getWebBindWidgetCallback() != null) {
                    BindWidgetActivity.this.v.setResultCode(-10001);
                    BindWidgetActivity.this.v.setResultMsg("请登录");
                    CoreViewRouter.getInstance().getWebBindWidgetCallback().onFinish(BindWidgetActivity.this.v);
                    return;
                }
                Intent intent = new Intent(BindWidgetActivity.this, LoginActivity.class);
                intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2003);
                BindWidgetActivity.this.startActivityForResult(intent, BindWidgetActivity.REQUEST_CODE_LOGIN);
            }
        });
        this.sapiWebView.loadBindWidget(this.t, this.u, null, true, Collections.singletonList(SapiWebView.EXTRA_BIND_WIDGET_CONFLICT_DETECT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }
}
