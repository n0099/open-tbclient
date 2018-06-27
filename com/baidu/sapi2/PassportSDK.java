package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.AccountRealNameActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.baidu.sapi2.activity.FastRegActivity;
import com.baidu.sapi2.activity.FillUProfileActivity;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sapi2.activity.ModifyPwdActivity;
import com.baidu.sapi2.activity.NormalizeGuestAccountActivity;
import com.baidu.sapi2.activity.OperationRecordActivity;
import com.baidu.sapi2.activity.QrLoginActivity;
import com.baidu.sapi2.activity.RegisterActivity;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.SapiWebCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.callback.WebFillUProfileCallback;
import com.baidu.sapi2.callback.WebModifyPwdCallback;
import com.baidu.sapi2.callback.WebSocialLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.WebBindWidgetDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.StatLoadLogin;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes2.dex */
public final class PassportSDK {
    private static PassportSDK instance;
    private AccountCenterCallback accountCenterCallback;
    private AccountCenterDTO accountCenterDTO;
    private AccountRealNameCallback accountRealNameCallback;
    private ActivityResultCallback activityResultCallback;
    private WebBindWidgetDTO bindWidgetDTO;
    Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
    private ImageCropCallback imageCropCallback;
    private NormalizeGuestAccountCallback normalizeGuestAccountCallback;
    private NormalizeGuestAccountDTO normalizeGuestAccountDTO;
    private QrLoginCallback qrLoginCallback;
    private SapiWebCallback sapiWebCallback;
    private String smsLoginStatExtra;
    private SmsViewLoginCallback smsViewLoginCallback;
    private WebSocialLoginDTO socialLoginDTO;
    private AbstractThirdPartyService thirdPartyService;
    private WebAuthListener webAuthListener;
    private WebBindWidgetCallback webBindWidgetCallback;
    private WebFillUProfileCallback webFillUProfileCallback;
    private WebLoginDTO webLoginDTO;
    private WebModifyPwdCallback webModifyPwdCallback;
    private WebRegDTO webRegDTO;

    public static synchronized PassportSDK getInstance() {
        PassportSDK passportSDK;
        synchronized (PassportSDK.class) {
            if (instance == null) {
                instance = new PassportSDK();
            }
            passportSDK = instance;
        }
        return passportSDK;
    }

    private PassportSDK() {
    }

    public WebAuthListener getWebAuthListener() {
        return this.webAuthListener;
    }

    public WebLoginDTO getWebLoginDTO() {
        return this.webLoginDTO;
    }

    public WebRegDTO getWebRegDTO() {
        return this.webRegDTO;
    }

    public WebBindWidgetDTO getWebBindWidgetDTO() {
        return this.bindWidgetDTO;
    }

    public WebSocialLoginDTO getSocialLoginDTO() {
        return this.socialLoginDTO;
    }

    public AccountCenterDTO getAccountCenterDTO() {
        return this.accountCenterDTO;
    }

    public NormalizeGuestAccountDTO getNormalizeGuestAccountDTO() {
        return this.normalizeGuestAccountDTO;
    }

    public AccountCenterCallback getAccountCenterCallback() {
        return this.accountCenterCallback;
    }

    public AccountRealNameCallback getAccountRealNameCallback() {
        return this.accountRealNameCallback;
    }

    public WebFillUProfileCallback getWebFillUProfileCallback() {
        return this.webFillUProfileCallback;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        return this.webBindWidgetCallback;
    }

    public WebModifyPwdCallback getWebModifyPwdCallback() {
        return this.webModifyPwdCallback;
    }

    public SapiWebCallback getSapiWebCallback() {
        return this.sapiWebCallback;
    }

    public ImageCropCallback getImageCropCallback() {
        return this.imageCropCallback;
    }

    public ActivityResultCallback getActivityResultCallback() {
        return this.activityResultCallback;
    }

    public SmsViewLoginCallback getSmsViewLoginCallback() {
        return this.smsViewLoginCallback;
    }

    public NormalizeGuestAccountCallback getNormalizeGuestAccountCallback() {
        return this.normalizeGuestAccountCallback;
    }

    public String getSmsLoginStatExtra() {
        return WebLoginDTO.getStatExtraDecode(this.smsLoginStatExtra);
    }

    public AbstractThirdPartyService getThirdPartyService() {
        if (this.thirdPartyService == null) {
            loadThirdPartyService();
        }
        return this.thirdPartyService;
    }

    public QrLoginCallback getQrLoginCallback() {
        return this.qrLoginCallback;
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        this.thirdPartyService = abstractThirdPartyService;
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        startLogin(this.context, webAuthListener, webLoginDTO);
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        SapiWebView.statLoadLogin = new StatLoadLogin();
        SapiWebView.statLoadLogin.tOpenLoginPage = System.currentTimeMillis();
        this.webAuthListener = webAuthListener;
        this.webLoginDTO = webLoginDTO;
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, webLoginDTO.loginType);
        intent.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, webLoginDTO.finishActivityAfterSuc);
        if (!TextUtils.isEmpty(webLoginDTO.preSetUname)) {
            intent.putExtra("username", webLoginDTO.preSetUname);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void invokeV2ShareLogin(Activity activity, WebAuthListener webAuthListener, ShareStorage.StorageModel storageModel) {
        if (storageModel == null || webAuthListener == null) {
            throw new IllegalArgumentException(ShareStorage.StorageModel.class.getSimpleName() + "or" + WebAuthListener.class.getSimpleName() + "can't be null");
        }
        this.webAuthListener = webAuthListener;
        new ShareCallPacking().startLoginShareActivityForResult(activity, storageModel.pkg, storageModel.url);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        new ShareCallPacking().onLoginActivityActivityResult(new ShareCallPacking.ShareLoginCallBack() { // from class: com.baidu.sapi2.PassportSDK.1
            @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
            public void onSuccess() {
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.accountType = SapiAccountManager.getInstance().getSession().getAccountType();
                webAuthResult.setResultCode(0);
                PassportSDK.this.webAuthListener.onSuccess(webAuthResult);
                PassportSDK.getInstance().release();
            }

            @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
            public void onFailed(int i3, String str) {
                super.onFailed(i3, str);
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(i3);
                webAuthResult.setResultMsg(str);
                PassportSDK.this.webAuthListener.onFailure(webAuthResult);
                PassportSDK.getInstance().release();
            }
        }, i, i2, intent);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        this.socialLoginDTO = new WebSocialLoginDTO();
        this.socialLoginDTO.socialType = socialType;
        loadThirdPartyLogin(webAuthListener, this.socialLoginDTO);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        this.webAuthListener = webAuthListener;
        this.socialLoginDTO = webSocialLoginDTO;
        this.thirdPartyService = getThirdPartyService();
        if (this.thirdPartyService != null) {
            this.thirdPartyService.loadThirdPartyLogin(this.context, webSocialLoginDTO.socialType, 2002);
        }
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i) {
        this.thirdPartyService = getThirdPartyService();
        if (this.thirdPartyService != null) {
            this.thirdPartyService.handleWXLoginResp(activity, str, str2, i);
        }
    }

    public void loadHuaweiLogin(WebAuthListener webAuthListener, String str, String str2) {
        this.webAuthListener = webAuthListener;
        loadThirdPartyService();
        if (this.thirdPartyService != null) {
            this.thirdPartyService.loadHuaweiLogin(this.context, webAuthListener, str, str2);
        }
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        this.webAuthListener = webAuthListener;
        this.webRegDTO = webRegDTO;
        Intent intent = new Intent(this.context, RegisterActivity.class);
        if (webRegDTO.regType == WebRegDTO.EXTRA_REGISTER_FAST) {
            intent = new Intent(this.context, FastRegActivity.class);
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2002);
        }
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void setWebSocialLoginCallback(WebSocialLoginCallback webSocialLoginCallback) {
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        this.imageCropCallback = imageCropCallback;
    }

    public void loadAccountCenter(AccountCenterCallback accountCenterCallback, AccountCenterDTO accountCenterDTO) {
        this.accountCenterCallback = accountCenterCallback;
        this.accountCenterDTO = accountCenterDTO;
        Intent intent = new Intent(this.context, AccountCenterActivity.class);
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void loadAccountRealName(AccountRealNameCallback accountRealNameCallback, String str) {
        this.accountRealNameCallback = accountRealNameCallback;
        Intent intent = new Intent(this.context, AccountRealNameActivity.class);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void loadFillProfile(WebFillUProfileCallback webFillUProfileCallback, String str) {
        this.webFillUProfileCallback = webFillUProfileCallback;
        Intent intent = new Intent(this.context, FillUProfileActivity.class);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.putExtra(FillUProfileActivity.EXTRA_SIMPLIFIED, true);
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, WebBindWidgetDTO webBindWidgetDTO) {
        this.webBindWidgetCallback = webBindWidgetCallback;
        this.bindWidgetDTO = webBindWidgetDTO;
        Intent intent = new Intent(this.context, BindWidgetActivity.class);
        intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, webBindWidgetDTO.bindWidgetAction);
        intent.putExtra("EXTRA_BDUSS", webBindWidgetDTO.bduss);
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void loadModifyPwd(WebModifyPwdCallback webModifyPwdCallback, String str) {
        this.webModifyPwdCallback = webModifyPwdCallback;
        Intent intent = new Intent(this.context, ModifyPwdActivity.class);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void loadOperationRecord(SapiWebCallback sapiWebCallback, String str) {
        this.sapiWebCallback = sapiWebCallback;
        Intent intent = new Intent(this.context, OperationRecordActivity.class);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        loadQrLogin(qrLoginCallback, str, true);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, boolean z) {
        this.qrLoginCallback = qrLoginCallback;
        Intent intent = new Intent(this.context, QrLoginActivity.class);
        intent.putExtra(QrLoginActivity.EXTRA_STRING_QR_LOGIN_URL, str);
        intent.putExtra(QrLoginActivity.EXTRA_BOOLEAN_FINISH_PAGE, z);
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        this.smsViewLoginCallback = smsViewLoginCallback;
        this.smsLoginStatExtra = str;
        SmsLoginView.notifyStartLogin();
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        this.normalizeGuestAccountCallback = normalizeGuestAccountCallback;
        this.normalizeGuestAccountDTO = normalizeGuestAccountDTO;
        Intent intent = new Intent(context, NormalizeGuestAccountActivity.class);
        intent.putExtra("EXTRA_BDUSS", normalizeGuestAccountDTO.bduss);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void release() {
        SapiWebView.statLoadLogin = null;
        this.webAuthListener = null;
        this.webLoginDTO = null;
        this.bindWidgetDTO = null;
        this.socialLoginDTO = null;
        this.normalizeGuestAccountDTO = null;
        this.accountCenterCallback = null;
        this.webFillUProfileCallback = null;
        this.webBindWidgetCallback = null;
        this.webModifyPwdCallback = null;
        this.sapiWebCallback = null;
        this.imageCropCallback = null;
        this.activityResultCallback = null;
        this.accountCenterDTO = null;
        this.accountRealNameCallback = null;
        this.qrLoginCallback = null;
        this.smsViewLoginCallback = null;
        this.smsLoginStatExtra = null;
        this.normalizeGuestAccountCallback = null;
        PassportViewManager.getInstance().release();
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        this.activityResultCallback = activityResultCallback;
    }

    private void loadThirdPartyService() {
        try {
            Class.forName("com.baidu.sapi2.ThirdPartyService").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            Log.e(e);
        }
    }
}
