package com.baidu.sapi2.activity.social;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.d.a.a.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.views.ViewUtility;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class BaseSSOLoginActivity extends SocialLoginBase {
    private Handler aAX;
    protected int businessFrom;
    protected RelativeLayout ebP;
    private boolean isClose;
    protected Dialog loadingDialog;
    protected WebAuthResult webAuthResult = new WebAuthResult() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            if (baseSSOLoginActivity.businessFrom == 2001) {
                baseSSOLoginActivity.setActivtyResult(1001);
            } else {
                PassportSDK.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }
    };
    protected AuthorizationListener authorizationListener = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.2
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            if (PassportSDK.getInstance().getWebAuthListener() != null) {
                PassportSDK.getInstance().getWebAuthListener().beforeSuccess(sapiAccount);
            }
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            if (BaseSSOLoginActivity.this.businessFrom == 2001) {
                Intent intent = new Intent();
                intent.putExtra("result_code", i);
                intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
                BaseSSOLoginActivity.this.setActivtyResult(1002, intent);
            } else if (PassportSDK.getInstance().getWebAuthListener() != null) {
                BaseSSOLoginActivity.this.webAuthResult.setResultCode(i);
                BaseSSOLoginActivity.this.webAuthResult.setResultMsg(str);
                PassportSDK.getInstance().getWebAuthListener().onFailure(BaseSSOLoginActivity.this.webAuthResult);
                PassportSDK.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            if (!BaseSSOLoginActivity.this.isClose) {
                WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
                if (webAuthListener != null) {
                    WebAuthResult webAuthResult = BaseSSOLoginActivity.this.webAuthResult;
                    webAuthResult.accountType = accountType;
                    webAuthResult.setResultCode(0);
                    webAuthListener.onSuccess(BaseSSOLoginActivity.this.webAuthResult);
                }
                int i = BaseSSOLoginActivity.this.businessFrom;
                if (i != 2001) {
                    if (i != 2003 && i != 2004) {
                        WebSocialLoginDTO socialLoginDTO = PassportSDK.getInstance().getSocialLoginDTO();
                        if (socialLoginDTO != null && socialLoginDTO.finishActivityAfterSuc) {
                            PassportSDK.getInstance().release();
                            BaseSSOLoginActivity.this.finish();
                            return;
                        }
                        return;
                    }
                    BaseSSOLoginActivity.this.setActivtyResult(1001);
                    BaseSSOLoginActivity.this.finish();
                    return;
                }
                WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
                if (webRegDTO != null) {
                    if (webRegDTO.finishActivityAfterSuc) {
                        BaseSSOLoginActivity.this.setActivtyResult(1001);
                        BaseSSOLoginActivity.this.finish();
                        return;
                    }
                    return;
                }
                WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
                if (webLoginDTO != null && webLoginDTO.finishActivityAfterSuc) {
                    BaseSSOLoginActivity.this.setActivtyResult(1001);
                    BaseSSOLoginActivity.this.finish();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void authorizeSuccess(AccountType accountType) {
        if (!TextUtils.isEmpty(this.sapiWebView.touchidPortraitAndSign[0])) {
            SapiAccount currentAccount = SapiContext.getInstance(this.configuration.context).getCurrentAccount();
            currentAccount.phone = this.sapiWebView.touchidPortraitAndSign[0];
            currentAccount.email = this.sapiWebView.touchidPortraitAndSign[1];
            SapiContext.getInstance(this.configuration.context).addTouchidAccounts(currentAccount);
        }
        SapiUtils.reportGid(10002);
        if (this.authorizationListener != null) {
            ViewUtility.dismissDialog(this, this.loadingDialog);
            try {
                if (!AuthorizationListener.class.equals(this.authorizationListener.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.authorizationListener.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e) {
                Log.e(e);
            }
            this.authorizationListener.onSuccess();
        }
    }

    private void initData() {
        super.init();
        this.businessFrom = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.webAuthResult.activity = this;
        this.aAX = new Handler();
    }

    private void setOrientationToUndefined() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<PassNameValuePair> getStatParamList() {
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
        WebSocialLoginDTO socialLoginDTO = PassportSDK.getInstance().getSocialLoginDTO();
        if (webLoginDTO == null || !WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
                arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra)));
            }
        } else {
            arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getSocialLoginDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleBack(int i) {
        if (i == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", -301);
            intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, SapiResult.ERROR_MSG_PROCESSED_END);
            setActivtyResult(1002, intent);
        } else if (PassportSDK.getInstance().getWebAuthListener() != null) {
            this.isClose = true;
            this.webAuthResult.setResultCode(-301);
            this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
            PassportSDK.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            PassportSDK.getInstance().release();
        }
        SapiUtils.hideSoftInput(this);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleOpenApiAuthorizeResponse(final SocialResponse socialResponse, HashMap<String, String> hashMap) {
        if (socialResponse.errorCode == 302) {
            ViewUtility.dismissDialog(this, this.loadingDialog);
            RelativeLayout relativeLayout = this.ebP;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            String str = socialResponse.userInfoXmlContent;
            String str2 = socialResponse.nextUrl;
            this.sapiWebView.loadThirdPartySSOLogin(str2, str, hashMap.get("mkey"), hashMap.get("BAIDUID"), hashMap.get("BDUSS"), hashMap.get("PTOKEN"), hashMap.get("STOKEN"));
            return;
        }
        final SapiAccount sapiAccountResponseToAccount = ((ThirdPartyService) PassportSDK.getInstance().getThirdPartyService()).sapiAccountResponseToAccount(this, socialResponse);
        if (SapiUtils.isValidAccount(sapiAccountResponseToAccount)) {
            socialResponse.errorCode = 0;
        }
        if (this.authorizationListener != null) {
            if (socialResponse.errorCode != 0 && socialResponse.errorCode != 110000) {
                this.aAX.post(new Runnable() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
                        if (baseSSOLoginActivity.authorizationListener != null) {
                            ViewUtility.dismissDialog(baseSSOLoginActivity, baseSSOLoginActivity.loadingDialog);
                            BaseSSOLoginActivity.this.authorizationListener.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
                        }
                    }
                });
            } else {
                this.aAX.post(new Runnable() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (BaseSSOLoginActivity.this.authorizationListener != null) {
                                BaseSSOLoginActivity.this.authorizationListener.beforeSuccess(sapiAccountResponseToAccount);
                            }
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        SapiShareClient.getInstance().validate(sapiAccountResponseToAccount);
                        BaseSSOLoginActivity.this.authorizeSuccess(AccountType.UNKNOWN);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        this.sapiWebView.onKeyUp(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        handleBack(this.businessFrom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26) {
            setOrientationToUndefined();
        }
        super.onCreate(bundle);
        try {
            setContentView(a.C0054a.layout_sapi_sdk_webview_with_title_bar);
            initData();
        } catch (Throwable th) {
            reportWebviewError(th);
            if (PassportSDK.getInstance().getWebAuthListener() != null) {
                this.webAuthResult.setResultCode(-202);
                this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                PassportSDK.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            }
            PassportSDK.getInstance().release();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        this.sapiWebView.onKeyUp(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setActivtyResult(int i, Intent intent) {
        setResult(i, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        configTitle();
        this.ebP = (RelativeLayout) findViewById(a.c.root_view);
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                if (((SocialLoginBase) BaseSSOLoginActivity.this).sapiWebView != null && ((SocialLoginBase) BaseSSOLoginActivity.this).sapiWebView.canGoBack()) {
                    ((SocialLoginBase) BaseSSOLoginActivity.this).sapiWebView.goBack();
                    return;
                }
                BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
                baseSSOLoginActivity.handleBack(baseSSOLoginActivity.businessFrom);
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.4
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
                baseSSOLoginActivity.handleBack(baseSSOLoginActivity.businessFrom);
            }
        });
        this.sapiWebView.setAuthorizationListener(this.authorizationListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setActivtyResult(int i) {
        setResult(i);
    }
}
