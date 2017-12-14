package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.AccountRealNameActivity;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.baidu.sapi2.activity.FastRegActivity;
import com.baidu.sapi2.activity.FillUProfileActivity;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sapi2.activity.ModifyPwdActivity;
import com.baidu.sapi2.activity.OperationRecordActivity;
import com.baidu.sapi2.activity.RegisterActivity;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.QrAppLoginCallback;
import com.baidu.sapi2.callback.SapiWebCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.callback.WebFillUProfileCallback;
import com.baidu.sapi2.callback.WebModifyPwdCallback;
import com.baidu.sapi2.callback.WebSocialLoginCallback;
import com.baidu.sapi2.callback.WebVoiceLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes2.dex */
public final class PassportSDK {
    private static PassportSDK instance;
    private AccountCenterCallback accountCenterCallback;
    private AccountCenterDTO accountCenterDTO;
    private AccountRealNameCallback accountRealNameCallback;
    private ActivityResultCallback activityResultCallback;
    Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
    private ImageCropCallback imageCropCallback;
    private QrAppLoginCallback qrAppLoginCallback;
    private SapiWebCallback sapiWebCallback;
    private AbstractThirdPartyService thirdPartyService;
    private WebAuthListener webAuthListener;
    private WebBindWidgetCallback webBindWidgetCallback;
    private WebFillUProfileCallback webFillUProfileCallback;
    private WebLoginDTO webLoginDTO;
    private WebModifyPwdCallback webModifyPwdCallback;
    private WebRegDTO webRegDTO;
    private WebSocialLoginCallback webSocialLoginCallback;
    private WebVoiceLoginCallback webVoiceLoginCallback;

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

    public WebVoiceLoginCallback getWebVoiceLoginCallback() {
        return this.webVoiceLoginCallback;
    }

    public QrAppLoginCallback getQrAppLoginCallback() {
        return this.qrAppLoginCallback;
    }

    public WebSocialLoginCallback getWebSocialLoginCallback() {
        return this.webSocialLoginCallback;
    }

    public AccountCenterDTO getAccountCenterDTO() {
        return this.accountCenterDTO;
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

    public AbstractThirdPartyService getThirdPartyService() {
        loadThirdPartyService();
        return this.thirdPartyService;
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        this.thirdPartyService = abstractThirdPartyService;
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        this.webAuthListener = webAuthListener;
        this.webLoginDTO = webLoginDTO;
        Intent intent = new Intent(this.context, LoginActivity.class);
        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, webLoginDTO.loginType);
        intent.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, webLoginDTO.finishActivityAfterSuc);
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        startLogin(webAuthListener, webLoginDTO);
        if ((context instanceof Activity) && webLoginDTO.openEnterAnimId != 0 && webLoginDTO.openExitAnimId != 0) {
            ((Activity) context).overridePendingTransition(webLoginDTO.openEnterAnimId, webLoginDTO.openExitAnimId);
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        this.webAuthListener = webAuthListener;
        loadThirdPartyService();
        if (this.thirdPartyService != null) {
            this.thirdPartyService.loadThirdPartyLogin(this.context, webAuthListener, socialType);
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
            intent.putExtra(FastRegActivity.EXTRA_PARAM_BUSINESS_FROM, FastRegActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER);
        }
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    private void setQrAppLoginCallback(QrAppLoginCallback qrAppLoginCallback) {
        this.qrAppLoginCallback = qrAppLoginCallback;
    }

    public void setWebVoiceLoginCallback(WebVoiceLoginCallback webVoiceLoginCallback) {
        this.webVoiceLoginCallback = webVoiceLoginCallback;
    }

    public void setWebSocialLoginCallback(WebSocialLoginCallback webSocialLoginCallback) {
        this.webSocialLoginCallback = webSocialLoginCallback;
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
        Intent intent = new Intent(this.context, AccountCenterActivity.class);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.putExtra(FillUProfileActivity.EXTRA_SIMPLIFIED, true);
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, BindWidgetAction bindWidgetAction, String str) {
        this.webBindWidgetCallback = webBindWidgetCallback;
        Intent intent = new Intent(this.context, BindWidgetActivity.class);
        intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, bindWidgetAction);
        intent.putExtra("EXTRA_BDUSS", str);
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

    public void release() {
        this.webAuthListener = null;
        this.webLoginDTO = null;
        this.qrAppLoginCallback = null;
        this.webVoiceLoginCallback = null;
        this.webSocialLoginCallback = null;
        this.accountCenterCallback = null;
        this.webFillUProfileCallback = null;
        this.webBindWidgetCallback = null;
        this.webModifyPwdCallback = null;
        this.sapiWebCallback = null;
        this.imageCropCallback = null;
        this.activityResultCallback = null;
        this.accountCenterDTO = null;
        this.accountRealNameCallback = null;
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
