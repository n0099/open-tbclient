package com.baidu.sapi2.activity.social;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.callback.VerifyListener;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseSSOLoginActivity extends SocialLoginBase {
    public static final String EXTRA_PARAM_EXTRAS_JSON = "extraJson";
    public static final String LOAD_THIRD_PARTY_SCENE_FROM = "sceneFrom";
    public static final String PARAMS_IS_SAFETY_VERIFICATION = "isVerification";
    public int businessFrom;
    public String extraJson;
    public boolean isClose;
    public Dialog loadingDialog;
    public boolean mIsVerification;
    public Handler mainHandler;
    public final String TAG = "BaseSSOLoginActivity";
    public WebAuthResult webAuthResult = new WebAuthResult() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            if (baseSSOLoginActivity.businessFrom == 2001) {
                baseSSOLoginActivity.setActivtyResult(1001);
            } else {
                CoreViewRouter.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity(boolean z) {
            super.finishActivity(z);
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            if (baseSSOLoginActivity.businessFrom == 2001) {
                baseSSOLoginActivity.setActivtyResult(1001);
            } else if (z) {
                CoreViewRouter.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }
    };
    public VerifyListener mVerifyListener = new VerifyListener() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.2
        @Override // com.baidu.sapi2.activity.callback.VerifyListener
        public void onFailure() {
            BaseSSOLoginActivity.this.setActivtyResult(3001);
            BaseSSOLoginActivity.this.finish();
        }

        @Override // com.baidu.sapi2.activity.callback.VerifyListener
        public void onSuccess(String str) {
            Intent intent = new Intent();
            intent.putExtra("response", str);
            BaseSSOLoginActivity.this.setActivtyResult(3001, intent);
            BaseSSOLoginActivity.this.finish();
        }
    };
    public AuthorizationListener authorizationListener = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.3
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                CoreViewRouter.getInstance().getWebAuthListener().beforeSuccess(sapiAccount);
            }
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            if (BaseSSOLoginActivity.this.businessFrom == 2001) {
                Intent intent = new Intent();
                intent.putExtra("result_code", i);
                intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
                BaseSSOLoginActivity.this.setActivtyResult(1002, intent);
            } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                BaseSSOLoginActivity.this.webAuthResult.setResultCode(i);
                BaseSSOLoginActivity.this.webAuthResult.setResultMsg(str);
                CoreViewRouter.getInstance().getWebAuthListener().onFailure(BaseSSOLoginActivity.this.webAuthResult);
                CoreViewRouter.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            if (BaseSSOLoginActivity.this.isClose) {
                return;
            }
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                WebAuthResult webAuthResult = BaseSSOLoginActivity.this.webAuthResult;
                webAuthResult.accountType = accountType;
                webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(BaseSSOLoginActivity.this.webAuthResult);
            }
            int i = BaseSSOLoginActivity.this.businessFrom;
            if (i != 2001) {
                if (i != 2003 && i != 2004) {
                    WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
                    if (socialLoginDTO == null || !socialLoginDTO.finishActivityAfterSuc) {
                        return;
                    }
                    CoreViewRouter.getInstance().release();
                    BaseSSOLoginActivity.this.finish();
                    return;
                }
                BaseSSOLoginActivity.this.setActivtyResult(1001);
                BaseSSOLoginActivity.this.finish();
                return;
            }
            WebRegDTO webRegDTO = CoreViewRouter.getInstance().getWebRegDTO();
            if (webRegDTO != null) {
                if (webRegDTO.finishActivityAfterSuc) {
                    BaseSSOLoginActivity.this.setActivtyResult(1001);
                    BaseSSOLoginActivity.this.finish();
                    return;
                }
                return;
            }
            WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
            if (webLoginDTO == null || !webLoginDTO.finishActivityAfterSuc) {
                return;
            }
            BaseSSOLoginActivity.this.setActivtyResult(1001);
            BaseSSOLoginActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void authorizeSuccess(AccountType accountType) {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && !TextUtils.isEmpty(sapiWebView.touchidPortraitAndSign[0])) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String[] strArr = this.sapiWebView.touchidPortraitAndSign;
            currentAccount.phone = strArr[0];
            currentAccount.email = strArr[1];
            SapiContext.getInstance().addTouchidAccounts(currentAccount);
        }
        AuthorizationListener authorizationListener = this.authorizationListener;
        if (authorizationListener != null) {
            try {
                if (!AuthorizationListener.class.equals(authorizationListener.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.authorizationListener.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.authorizationListener.onSuccess();
        }
    }

    private void initData() {
        super.init();
        this.businessFrom = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.extraJson = getIntent().getStringExtra("extraJson");
        this.mIsVerification = getIntent().getBooleanExtra(PARAMS_IS_SAFETY_VERIFICATION, false);
        this.webAuthResult.activity = this;
        this.mainHandler = new Handler();
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

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        ViewUtility.dismissDialog(this, this.loadingDialog);
        super.finish();
    }

    public Map<String, String> getSceneFromParam() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.extraJson)) {
            try {
                hashMap.put(LOAD_THIRD_PARTY_SCENE_FROM, new JSONObject(this.extraJson).optString(LOAD_THIRD_PARTY_SCENE_FROM));
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
        return hashMap;
    }

    public List<PassNameValuePair> getStatParamList() {
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
        } else if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra)));
        }
        return arrayList;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getSocialLoginDTO();
    }

    public void handleBack(int i) {
        handleBack(i, -301, "您已取消操作");
    }

    public void handleOpenApiAuthorizeResponse(final SocialResponse socialResponse, HashMap<String, String> hashMap) {
        if (socialResponse.errorCode == 302) {
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            String str = socialResponse.userInfoXmlContent;
            String str2 = socialResponse.nextUrl;
            this.sapiWebView.loadThirdPartySSOLogin(str2, str, hashMap.get("mkey"), hashMap.get("BAIDUID"), hashMap.get(HttpRequest.BDUSS), hashMap.get("PTOKEN"), hashMap.get("STOKEN"));
            return;
        }
        final SapiAccount sapiAccountResponseToAccount = ((ThirdPartyService) CoreViewRouter.getInstance().getThirdPartyService()).sapiAccountResponseToAccount(this, socialResponse);
        if (SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
            socialResponse.errorCode = 0;
        }
        if (this.authorizationListener != null) {
            int i = socialResponse.errorCode;
            if (i != 0 && i != 110000) {
                this.mainHandler.post(new Runnable() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.7
                    @Override // java.lang.Runnable
                    public void run() {
                        AuthorizationListener authorizationListener = BaseSSOLoginActivity.this.authorizationListener;
                        if (authorizationListener != null) {
                            SocialResponse socialResponse2 = socialResponse;
                            authorizationListener.onFailed(socialResponse2.errorCode, socialResponse2.errorMsg);
                        }
                    }
                });
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (BaseSSOLoginActivity.this.authorizationListener != null) {
                                BaseSSOLoginActivity.this.authorizationListener.beforeSuccess(sapiAccountResponseToAccount);
                            }
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                        BaseSSOLoginActivity.this.authorizeSuccess(AccountType.UNKNOWN);
                    }
                });
            }
        }
    }

    public void loadLoginInNA(String str, final String str2) {
        if (this.sapiWebView == null) {
            if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                this.webAuthResult.setResultCode(-202);
                this.webAuthResult.setResultMsg("网络连接失败，请检查网络设置");
                CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            }
            CoreViewRouter.getInstance().release();
            finish();
            return;
        }
        HashMap hashMap = new HashMap();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            hashMap.put("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra));
        } else if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
            hashMap.put("extrajson", WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra));
        }
        hashMap.putAll(getSceneFromParam());
        hashMap.put("json", "1");
        String addExtras = ParamsUtil.addExtras(str, hashMap);
        new HttpClientWrap().get(addExtras, ParamsUtil.buildNaCookie(addExtras, this.configuration), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.8
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                AuthorizationListener authorizationListener = BaseSSOLoginActivity.this.authorizationListener;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, "登录失败");
                }
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                super.onFinish();
                BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
                ViewUtility.dismissDialog(baseSSOLoginActivity, baseSSOLoginActivity.loadingDialog);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                super.onStart();
                BaseSSOLoginActivity.this.showLoading(str2);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str3, HashMap<String, String> hashMap2) {
                if (str3 == null) {
                    AuthorizationListener authorizationListener = BaseSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener != null) {
                        authorizationListener.onFailed(-100, "登录失败");
                        return;
                    }
                    return;
                }
                try {
                    BaseSSOLoginActivity.this.handleOpenApiAuthorizeResponse(SocialResponse.fromJSONObject(new JSONObject(str3)), hashMap2);
                } catch (Throwable th) {
                    Log.e(th);
                    AuthorizationListener authorizationListener2 = BaseSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener2 != null) {
                        authorizationListener2.onFailed(-100, "登录失败");
                    }
                }
            }
        });
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        this.sapiWebView.onKeyUp(4);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        handleBack(this.businessFrom);
    }

    @Override // com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26) {
            setOrientationToUndefined();
        }
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.onKeyUp(4);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    public void setActivtyResult(int i, Intent intent) {
        setResult(i, intent);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.4
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                if (BaseSSOLoginActivity.this.sapiWebView != null && BaseSSOLoginActivity.this.sapiWebView.canGoBack()) {
                    BaseSSOLoginActivity.this.sapiWebView.goBack();
                    return;
                }
                BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
                baseSSOLoginActivity.handleBack(baseSSOLoginActivity.businessFrom);
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.5
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
                baseSSOLoginActivity.handleBack(baseSSOLoginActivity.businessFrom);
            }
        });
        this.sapiWebView.setAuthorizationListener(this.authorizationListener);
    }

    public void showLoading(String str) {
        LoadingDialog createDialog = new LoadingDialog.Builder(this).setMessage(str).setCancelable(false).setCancelOutside(false).createDialog();
        this.loadingDialog = createDialog;
        if (createDialog.isShowing() || isFinishing()) {
            return;
        }
        this.loadingDialog.show();
    }

    public void handleBack(int i, int i2, String str) {
        if (i == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", i2);
            intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
            setActivtyResult(1002, intent);
        } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
            this.isClose = true;
            this.webAuthResult.setResultCode(i2);
            this.webAuthResult.setResultMsg(str);
            CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            CoreViewRouter.getInstance().release();
        }
        SapiUtils.hideSoftInput(this);
        finish();
    }

    public void setActivtyResult(int i) {
        setResult(i);
    }
}
