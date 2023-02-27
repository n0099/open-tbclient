package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.AccountToolsCallback;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.AuthWidgetCallback;
import com.baidu.sapi2.callback.CertGuardianCallback;
import com.baidu.sapi2.callback.ChangeUsernameCallback;
import com.baidu.sapi2.callback.DoubleListCallback;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.AccountToolsDTO;
import com.baidu.sapi2.dto.CertGuardionDTO;
import com.baidu.sapi2.dto.ChangeUserNameDTO;
import com.baidu.sapi2.dto.DoubleListDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyCertInfoDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.dto.WebBindWidgetDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.utils.enums.BindInfoAction;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes2.dex */
public final class PassportSDK {
    public static synchronized PassportSDK getInstance() {
        PassportSDK passportSDK;
        synchronized (PassportSDK.class) {
            passportSDK = new PassportSDK();
        }
        return passportSDK;
    }

    public void extendSysWebViewMethod(Activity activity, String str, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        CoreViewRouter.getInstance().extendSysWebViewMethod(activity, str, extendSysWebViewMethodCallback);
    }

    public void invokeV2ShareLogin(Activity activity, WebAuthListener webAuthListener, ShareStorage.StorageModel storageModel) {
        CoreViewRouter.getInstance().invokeV2ShareLogin(activity, storageModel, webAuthListener, "");
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        CoreViewRouter.getInstance().loadAccountRealName(context, accountRealNameCallback, realNameDTO);
    }

    public void loadAddressManage(Context context, AddressManageDTO addressManageDTO, AddressManageCallback addressManageCallback) {
        EcommerceRouter.getInstance().loadAddressManage(context, addressManageDTO, addressManageCallback);
    }

    public void loadCertGuardian(Context context, CertGuardianCallback certGuardianCallback, CertGuardionDTO certGuardionDTO) {
        CoreViewRouter.getInstance().loadCertGuardian(context, certGuardianCallback, certGuardionDTO);
    }

    public void loadChangeUsername(Context context, ChangeUserNameDTO changeUserNameDTO, ChangeUsernameCallback changeUsernameCallback) {
        CoreViewRouter.getInstance().loadChangeUsername(context, changeUserNameDTO, changeUsernameCallback);
    }

    public void loadDoubleListActivity(Context context, DoubleListDTO doubleListDTO, DoubleListCallback doubleListCallback) {
        CoreViewRouter.getInstance().loadDoubleListActivity(context, doubleListDTO, doubleListCallback);
    }

    public void loadInvoiceBuild(Context context, InvoiceBuildDTO invoiceBuildDTO, InvoiceBuildCallback invoiceBuildCallback) {
        EcommerceRouter.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, invoiceBuildCallback);
    }

    @Deprecated
    public void loadOneKeyLogin(Context context, String str, OneKeyLoginCallback oneKeyLoginCallback) {
        CoreViewRouter.getInstance().loadOneKeyLogin(context, str, oneKeyLoginCallback);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2) {
        CoreViewRouter.getInstance().loadQrLogin(qrLoginCallback, str, str2);
    }

    public void loadYYSSOLogin(Context context, String str, WebAuthListener webAuthListener) {
        CoreViewRouter.getInstance().loadYYSSOLogin(context, str, webAuthListener);
    }

    public void registerUserFaceID(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        CoreViewRouter.getInstance().registerUserFaceID(activity, registerUserFaceIDCallback, faceIDRegDTO);
    }

    public void startHorizontalScreenLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        CoreViewRouter.getInstance().startHorizontalScreenLogin(context, webAuthListener, webLoginDTO);
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        CoreViewRouter.getInstance().startLogin(context, webAuthListener, webLoginDTO);
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        CoreViewRouter.getInstance().startNormalizeGuestAccount(context, normalizeGuestAccountCallback, normalizeGuestAccountDTO);
    }

    @Deprecated
    public void startOnlyPhoneAuth(AuthWidgetCallback authWidgetCallback, String str, String str2) {
        CoreViewRouter.getInstance().startOnlyPhoneAuth(authWidgetCallback, str, str2);
    }

    public void startSchemeLoginForQA(Context context, String str, WebAuthListener webAuthListener) {
        CoreViewRouter.getInstance().startSchemeLoginForQA(context, str, webAuthListener);
    }

    public void startSpeciallyAuthWidget(AuthWidgetCallback authWidgetCallback, String str, String str2) {
        CoreViewRouter.getInstance().startSpeciallyAuthWidget(authWidgetCallback, str, str2);
    }

    public void verifyUserFaceIDWithCertInfo(Activity activity, PassFaceRecogCallback passFaceRecogCallback, FaceIDVerifyCertInfoDTO faceIDVerifyCertInfoDTO) {
        CoreViewRouter.getInstance().verifyUserFaceIDWithCertInfo(activity, passFaceRecogCallback, faceIDVerifyCertInfoDTO);
    }

    public void verifyUserFaceId(Activity activity, VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        CoreViewRouter.getInstance().verifyUserFaceId(activity, verifyUserFaceIDCallback, faceIDVerifyDTO);
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i) {
        CoreViewRouter.getInstance().handleWXLoginResp(activity, str, str2, i);
    }

    public void invokeV2ShareLogin(Activity activity, WebAuthListener webAuthListener, ShareStorage.StorageModel storageModel, String str) {
        CoreViewRouter.getInstance().invokeV2ShareLogin(activity, storageModel, webAuthListener, str);
    }

    public void loadOneKeyLogin(Context context, String str, boolean z, OneKeyLoginCallback oneKeyLoginCallback) {
        CoreViewRouter.getInstance().loadOneKeyLogin(context, str, z, oneKeyLoginCallback);
    }

    public void loadOneKeyLoginWithToken(Context context, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        CoreViewRouter.getInstance().loadOneKeyLoginWithToken(context, str, str2, oneKeyLoginCallback);
    }

    public void loadOneKeyLoginWithoutYYNormalOneKey(Context context, String str, boolean z, OneKeyLoginCallback oneKeyLoginCallback) {
        CoreViewRouter.getInstance().loadOneKeyLogin(context, str, z, false, oneKeyLoginCallback);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2, boolean z) {
        CoreViewRouter.getInstance().loadQrLogin(qrLoginCallback, str, str2, z);
    }

    public void loadAccountCenter(AccountCenterCallback accountCenterCallback, AccountCenterDTO accountCenterDTO) {
        CoreViewRouter.getInstance().loadAccountCenter(accountCenterCallback, accountCenterDTO);
    }

    public void loadAccountTools(AccountToolsDTO accountToolsDTO, AccountToolsCallback accountToolsCallback) {
        CoreViewRouter.getInstance().loadAccountTools(accountToolsDTO, accountToolsCallback);
    }

    public void loadBindInfo(Context context, BindInfoAction bindInfoAction) {
        CoreViewRouter.getInstance().loadBindInfo(context, bindInfoAction);
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, WebBindWidgetDTO webBindWidgetDTO) {
        CoreViewRouter.getInstance().loadBindWidget(webBindWidgetCallback, webBindWidgetDTO);
    }

    public void loadChangeUsername(Context context, ChangeUsernameCallback changeUsernameCallback) {
        CoreViewRouter.getInstance().loadChangeUsername(context, changeUsernameCallback);
    }

    public void loadChildActivity(Context context, AccountRealNameCallback accountRealNameCallback) {
        CoreViewRouter.getInstance().loadChildActivity(context, accountRealNameCallback);
    }

    public void loadOneKeyLogin(Context context, OneKeyLoginCallback oneKeyLoginCallback) {
        CoreViewRouter.getInstance().loadOneKeyLogin(context, oneKeyLoginCallback);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        CoreViewRouter.getInstance().loadQrLogin(qrLoginCallback, str);
    }

    public void loadQrLoginWithEncuid(QrLoginCallback qrLoginCallback, String str) {
        CoreViewRouter.getInstance().loadQrLoginWithEncuid(qrLoginCallback, str);
    }

    public void loadSwitchAccount(SwitchAccountDTO switchAccountDTO, WebAuthListener webAuthListener) {
        CoreViewRouter.getInstance().loadSwitchAccount(switchAccountDTO, webAuthListener);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        CoreViewRouter.getInstance().loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        CoreViewRouter.getInstance().startAuth(authWidgetCallback, str);
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        CoreViewRouter.getInstance().startLogin(webAuthListener, webLoginDTO);
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        CoreViewRouter.getInstance().startRegister(webAuthListener, webRegDTO);
    }

    public void startSchemeLoginForQA(Context context, String str) {
        CoreViewRouter.getInstance().startSchemeLoginForQA(context, str);
    }

    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        CoreViewRouter.getInstance().startSmsViewLogin(smsViewLoginCallback, str);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        CoreViewRouter.getInstance().loadThirdPartyLogin(webAuthListener, socialType);
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        CoreViewRouter.getInstance().setActivityResultCallback(activityResultCallback);
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        CoreViewRouter.getInstance().setImageCropCallback(imageCropCallback);
    }

    public void startLoginDeviceManager(Context context) {
        if (SapiAccountManager.getInstance().isLogin()) {
            CoreViewRouter.getInstance().startLoginDeviceManager(context);
        }
    }
}
