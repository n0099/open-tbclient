package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.AccountRealNameActivity;
import com.baidu.sapi2.activity.AddressManageActivity;
import com.baidu.sapi2.activity.AuthWidgetActivity;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.baidu.sapi2.activity.FillUProfileActivity;
import com.baidu.sapi2.activity.InvoiceBuildActivity;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sapi2.activity.ModifyPwdActivity;
import com.baidu.sapi2.activity.NormalizeGuestAccountActivity;
import com.baidu.sapi2.activity.OperationRecordActivity;
import com.baidu.sapi2.activity.QrLoginActivity;
import com.baidu.sapi2.activity.RegisterActivity;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.AddressManageCallback;
import com.baidu.sapi2.callback.AuthWidgetCallback;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.FaceIDCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.InvoiceBuildCallback;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SapiWebCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.callback.WebFillUProfileCallback;
import com.baidu.sapi2.callback.WebModifyPwdCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.AddressManageDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.InvoiceBuildDTO;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.dto.WebBindWidgetDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatLoadLogin;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.SmsLoginView;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class PassportSDK {
    private static PassportSDK instance;
    private static LoginStatusChangeCallback loginStatusChangeCallback;
    private AccountCenterCallback accountCenterCallback;
    private AccountCenterDTO accountCenterDTO;
    private AccountRealNameCallback accountRealNameCallback;
    private ActivityResultCallback activityResultCallback;
    private AddressManageCallback addressManageCallback;
    private AddressManageDTO addressManageDTO;
    private AuthWidgetCallback authWidgetCallback;
    private WebBindWidgetDTO bindWidgetDTO;
    private Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
    private ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback;
    private ImageCropCallback imageCropCallback;
    private InvoiceBuildCallback invoiceBuildCallback;
    private InvoiceBuildDTO invoiceBuildDTO;
    private NormalizeGuestAccountCallback normalizeGuestAccountCallback;
    private NormalizeGuestAccountDTO normalizeGuestAccountDTO;
    private QrLoginCallback qrLoginCallback;
    private RealNameDTO realNameDTO;
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

    public RealNameDTO getRealNameDTO() {
        return this.realNameDTO;
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

    public AuthWidgetCallback getAuthWidgetCallback() {
        return this.authWidgetCallback;
    }

    public String getSmsLoginStatExtra() {
        return WebLoginDTO.getStatExtraDecode(this.smsLoginStatExtra);
    }

    public ExtendSysWebViewMethodCallback getExtendSysWebViewMethodCallback() {
        return this.extendSysWebViewMethodCallback;
    }

    public static void setLoginStatusChangeCallback(LoginStatusChangeCallback loginStatusChangeCallback2) {
        loginStatusChangeCallback = loginStatusChangeCallback2;
    }

    public static LoginStatusChangeCallback getLoginStatusChangeCallback() {
        return loginStatusChangeCallback;
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

    public AddressManageDTO getAddressManageDTO() {
        return this.addressManageDTO;
    }

    public InvoiceBuildDTO getInvoiceBuildDTO() {
        return this.invoiceBuildDTO;
    }

    public AddressManageCallback getAddressManageCallback() {
        return this.addressManageCallback;
    }

    public InvoiceBuildCallback getInvoiceBuildCallback() {
        return this.invoiceBuildCallback;
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
        invokeV2ShareLogin(activity, webAuthListener, storageModel, "");
    }

    public void invokeV2ShareLogin(Activity activity, WebAuthListener webAuthListener, ShareStorage.StorageModel storageModel, String str) {
        if (storageModel == null || webAuthListener == null) {
            throw new IllegalArgumentException(ShareStorage.StorageModel.class.getSimpleName() + "or" + WebAuthListener.class.getSimpleName() + "can't be null");
        }
        this.webAuthListener = webAuthListener;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new PassNameValuePair("extrajson", str));
        }
        new ShareCallPacking().startLoginShareActivityForResult(activity, storageModel.pkg, storageModel.url, null, null, arrayList);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent, "");
    }

    public void onActivityResult(int i, int i2, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new PassNameValuePair("extrajson", str));
        }
        new ShareCallPacking().onLoginActivityActivityResult(new ShareCallPacking.ShareLoginCallBack() { // from class: com.baidu.sapi2.PassportSDK.1
            @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
            public void onSuccess() {
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.accountType = AccountType.NORMAL;
                webAuthResult.setResultCode(0);
                if (PassportSDK.this.webAuthListener != null) {
                    PassportSDK.this.webAuthListener.onSuccess(webAuthResult);
                }
                PassportSDK.getInstance().release();
            }

            @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
            public void onFailed(int i3, String str2) {
                super.onFailed(i3, str2);
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(i3);
                webAuthResult.setResultMsg(str2);
                if (PassportSDK.this.webAuthListener != null) {
                    PassportSDK.this.webAuthListener.onFailure(webAuthResult);
                }
                PassportSDK.getInstance().release();
            }
        }, i, i2, intent, arrayList);
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
            this.thirdPartyService.loadThirdPartyLogin(webSocialLoginDTO.context == null ? this.context : webSocialLoginDTO.context, webSocialLoginDTO.socialType, 2002);
            webSocialLoginDTO.context = null;
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
        intent.setFlags(268435456);
        this.context.startActivity(intent);
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

    public void loadAccountRealName(AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        loadAccountRealName(this.context, accountRealNameCallback, realNameDTO);
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        this.accountRealNameCallback = accountRealNameCallback;
        this.realNameDTO = realNameDTO;
        Intent intent = new Intent(context, AccountRealNameActivity.class);
        if (realNameDTO != null) {
            intent.putExtra("EXTRA_BDUSS", realNameDTO.bduss);
            intent.putExtra(AccountRealNameActivity.EXTRA_SCENE, realNameDTO.scene);
            intent.putExtra(AccountRealNameActivity.EXTRA_NEED_CB_KEY, realNameDTO.needCbKey);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
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
        loadQrLogin(qrLoginCallback, str, null, true);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2) {
        loadQrLogin(qrLoginCallback, str, str2, true);
    }

    public void loadQrLogin(final QrLoginCallback qrLoginCallback, final String str, String str2, final boolean z) {
        JSONObject jSONObject;
        final ArrayList arrayList = new ArrayList(1);
        this.qrLoginCallback = new QrLoginCallback() { // from class: com.baidu.sapi2.PassportSDK.2
            @Override // com.baidu.sapi2.callback.QrLoginCallback
            public void onFinish(QrLoginResult qrLoginResult) {
                qrLoginCallback.onFinish(qrLoginResult);
                if (arrayList.size() == 1) {
                    ((WebAuthResult) arrayList.get(0)).finishActivity();
                    qrLoginCallback.onLocalLogin((WebAuthResult) arrayList.get(0));
                }
            }

            @Override // com.baidu.sapi2.callback.QrLoginCallback
            public void onLocalLogin(WebAuthResult webAuthResult) {
            }
        };
        if (SapiAccountManager.getInstance().isLogin()) {
            openQrLoginPage(str, z);
            return;
        }
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        try {
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(URLDecoder.decode(str2));
            }
            jSONObject.put("scenario", "1");
            webLoginDTO.statExtra = URLEncoder.encode(jSONObject.toString());
        } catch (JSONException e) {
        }
        startLogin(new WebAuthListener() { // from class: com.baidu.sapi2.PassportSDK.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                arrayList.add(webAuthResult);
                PassportSDK.this.openQrLoginPage(str + (str.indexOf("?") > 0 ? "&" : "?") + "login_action_type=" + SapiUtils.getLastLoginType() + "&clientfrom=android", z);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
            }
        }, webLoginDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openQrLoginPage(String str, boolean z) {
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

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        this.authWidgetCallback = authWidgetCallback;
        Intent intent = new Intent(this.context, AuthWidgetActivity.class);
        intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void registerUserFaceID(final RegisterUserFaceIDCallback registerUserFaceIDCallback, final FaceIDRegDTO faceIDRegDTO) {
        if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
            startAuth(new AuthWidgetCallback() { // from class: com.baidu.sapi2.PassportSDK.4
                @Override // com.baidu.sapi2.callback.AuthWidgetCallback
                public void onSuccess(String str) {
                    PassportSDK.this.bioScanFaceWrap(registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
                }

                @Override // com.baidu.sapi2.callback.AuthWidgetCallback
                public void onFailure(SapiResult sapiResult) {
                    registerUserFaceIDCallback.onFailure(sapiResult);
                }
            }, faceIDRegDTO.authWidgetURL);
        } else {
            bioScanFaceWrap(registerUserFaceIDCallback, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
        }
    }

    public void verifyUserFaceId(VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        verifyUserFaceId(this.context, verifyUserFaceIDCallback, faceIDVerifyDTO);
    }

    public void verifyUserFaceId(final Context context, final VerifyUserFaceIDCallback verifyUserFaceIDCallback, final FaceIDVerifyDTO faceIDVerifyDTO) {
        if (TextUtils.isEmpty(faceIDVerifyDTO.livingUname)) {
            final RealNameFaceIDResult realNameFaceIDResult = new RealNameFaceIDResult();
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.PassportSDK.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    String str = getTplStokenResult.tplStokenMap.get("pp");
                    if (!TextUtils.isEmpty(str)) {
                        PassportSDK.this.recogWithBdussWrap(context, faceIDVerifyDTO.subpro, null, "0", faceIDVerifyDTO.bduss, str, faceIDVerifyDTO.businessSence, verifyUserFaceIDCallback, realNameFaceIDResult);
                        return;
                    }
                    realNameFaceIDResult.setResultCode(SapiWebView.BiometricsIdentifyResult.ERROR_CODE_GET_STOKEN_FAILED);
                    realNameFaceIDResult.setResultMsg("服务异常，请稍后再试");
                    verifyUserFaceIDCallback.onFailure(realNameFaceIDResult);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    realNameFaceIDResult.setResultCode(getTplStokenResult.getResultCode());
                    realNameFaceIDResult.setResultMsg(getTplStokenResult.getResultMsg());
                    verifyUserFaceIDCallback.onFailure(realNameFaceIDResult);
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }
            }, faceIDVerifyDTO.bduss, arrayList);
            return;
        }
        bioScanFaceWrap(verifyUserFaceIDCallback, "outer", "", faceIDVerifyDTO.livingUname, faceIDVerifyDTO.showGuidePage, faceIDVerifyDTO.subpro, faceIDVerifyDTO.businessSence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recogWithBdussWrap(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5, final VerifyUserFaceIDCallback verifyUserFaceIDCallback, final RealNameFaceIDResult realNameFaceIDResult) {
        BiometricsManager.getInstance().recogWithBduss(context, BiometricsManager.buildSubPro(str, str5), map, str2, str3, str4, new PassFaceRecogCallback() { // from class: com.baidu.sapi2.PassportSDK.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                realNameFaceIDResult.setResultCode(passFaceRecogResult.getResultCode());
                realNameFaceIDResult.setResultMsg(passFaceRecogResult.getResultMsg());
                realNameFaceIDResult.authSid = passFaceRecogResult.authSid;
                realNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
                realNameFaceIDResult.setResultCode(0);
                verifyUserFaceIDCallback.onSuccess(realNameFaceIDResult);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                realNameFaceIDResult.setResultCode(passFaceRecogResult.getResultCode());
                realNameFaceIDResult.setResultMsg(passFaceRecogResult.getResultMsg());
                verifyUserFaceIDCallback.onFailure(realNameFaceIDResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bioScanFaceWrap(FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5) {
        bioScanFace(faceIDCallback, str, str2, str3, z, str4, str5);
    }

    private void bioScanFace(final FaceIDCallback faceIDCallback, final String str, String str2, String str3, boolean z, String str4, String str5) {
        if (TextUtils.isEmpty(str5)) {
            throw new IllegalArgumentException("scene can't be empty");
        }
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        String buildSubPro = BiometricsManager.buildSubPro(str4, str5);
        HashMap hashMap = new HashMap();
        final UnRealNameFaceIDResult unRealNameFaceIDResult = new UnRealNameFaceIDResult();
        PassFaceRecogCallback passFaceRecogCallback = new PassFaceRecogCallback() { // from class: com.baidu.sapi2.PassportSDK.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                unRealNameFaceIDResult.setResultMsg(passFaceRecogResult.getResultMsg());
                if (str.equals("faceDetect") && passFaceRecogResult.extraJson != null) {
                    unRealNameFaceIDResult.registerResult = passFaceRecogResult.extraJson.toString();
                }
                unRealNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
                if (TextUtils.isEmpty(unRealNameFaceIDResult.callBackKey)) {
                    UnRealNameFaceIDResult unRealNameFaceIDResult2 = unRealNameFaceIDResult;
                    UnRealNameFaceIDResult unRealNameFaceIDResult3 = unRealNameFaceIDResult;
                    unRealNameFaceIDResult2.setResultCode(-205);
                    faceIDCallback.onFailure(unRealNameFaceIDResult);
                    return;
                }
                unRealNameFaceIDResult.setResultCode(0);
                faceIDCallback.onSuccess(unRealNameFaceIDResult);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                unRealNameFaceIDResult.setResultCode(passFaceRecogResult.getResultCode());
                faceIDCallback.onFailure(unRealNameFaceIDResult);
            }
        };
        if (str.equals("faceDetect")) {
            biometricsManager.recogWithFaceDetect(this.context, buildSubPro, hashMap, "0", str3, str2, passFaceRecogCallback);
        } else if (str.equals("outer")) {
            biometricsManager.recogWithFaceOuter(this.context, buildSubPro, hashMap, "0", str3, passFaceRecogCallback);
        }
    }

    public void extendSysWebViewMethod(final Context context, String str, final ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        final ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            final int optInt = jSONObject.optInt("action");
            final JSONObject optJSONObject = jSONObject.optJSONObject("params");
            String optString = optJSONObject.optString("open_appid");
            String optString2 = optJSONObject.optString("open_apikey");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                extendSysWebViewMethodResult.params.put("retCode", "-310");
                extendSysWebViewMethodResult.params.put("retMsg", "因安全原因，操作失败");
                extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
                return;
            }
            SapiAccountManager.getInstance().getAccountService().extendSysWebViewMethodCheck(new SapiCallback<SapiResult>() { // from class: com.baidu.sapi2.PassportSDK.8
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(SapiResult sapiResult) {
                    switch (optInt) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            PassportSDK.this.extendWebviewBioWrap(extendSysWebViewMethodCallback, optJSONObject, optInt, extendSysWebViewMethodResult);
                            return;
                        case 5:
                            PassportSDK.this.extendSysWebViewMethodCallback = extendSysWebViewMethodCallback;
                            String optString3 = optJSONObject.optString("url");
                            String optString4 = optJSONObject.optString("title");
                            Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
                            intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, optString4);
                            intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_URL, optString3);
                            intent.setFlags(268435456);
                            context.startActivity(intent);
                            return;
                        case 6:
                            JSONArray optJSONArray = optJSONObject.optJSONArray("di_keys");
                            ArrayList arrayList = new ArrayList();
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                                    arrayList.add(optJSONArray.optString(i));
                                }
                            }
                            String diCookieInfo = SapiDeviceInfo.getDiCookieInfo(arrayList, false);
                            extendSysWebViewMethodResult.params.put("retCode", "0");
                            extendSysWebViewMethodResult.params.put("result", diCookieInfo);
                            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
                            return;
                        default:
                            extendSysWebViewMethodResult.params.put("retCode", "-301");
                            extendSysWebViewMethodResult.params.put("retMsg", "action :" + optInt + " is not support");
                            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
                            return;
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(SapiResult sapiResult) {
                    extendSysWebViewMethodResult.setResultCode(sapiResult.getResultCode());
                    extendSysWebViewMethodResult.setResultMsg(sapiResult.getResultMsg());
                    extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }
            }, optString, optString2);
        } catch (JSONException e) {
            Log.e(e);
            extendSysWebViewMethodResult.params.put("retCode", "-3");
            extendSysWebViewMethodResult.params.put("retMsg", "params is not json");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void extendWebviewBioWrap(final ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, int i, final ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        PassFaceRecogCallback passFaceRecogCallback = new PassFaceRecogCallback() { // from class: com.baidu.sapi2.PassportSDK.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
                extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
                extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
            }
        };
        int optInt = jSONObject.optInt("imageFlag", 0);
        String optString = TextUtils.isEmpty(jSONObject.optString("subpro")) ? "pp" : jSONObject.optString("subpro");
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("transParams");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString2 = optJSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString2)) {
                    hashMap.put(next, optString2);
                }
            }
        }
        if (i == 1) {
            biometricsManager.getClass();
            extendWebviewBioWithBdussWrap(extendSysWebViewMethodCallback, new BiometricsManager.LivenessDTO(), extendSysWebViewMethodResult, passFaceRecogCallback, optString, hashMap, optInt + "");
        }
        if (i == 2) {
            biometricsManager.recogWithCertInfo(this.context, optString, hashMap, optInt + "", jSONObject.optString("realname"), jSONObject.optString("idcardnum"), jSONObject.optString("bankmobile"), passFaceRecogCallback);
        }
        if (i == 3) {
            biometricsManager.recogWithAuthToken(this.context, optString, hashMap, optInt + "", jSONObject.optString("authtoken"), passFaceRecogCallback);
        }
        if (i == 4) {
            if (jSONObject.optInt("type") == 1) {
                biometricsManager.recogWithFaceDetect(this.context, optString, hashMap, optInt + "", jSONObject.optString("uid"), "", passFaceRecogCallback);
            } else {
                biometricsManager.recogWithFaceOuter(this.context, optString, hashMap, optInt + "", jSONObject.optString("uid"), passFaceRecogCallback);
            }
        }
    }

    private void extendWebviewBioWithBdussWrap(final ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, BiometricsManager.LivenessDTO livenessDTO, final ExtendSysWebViewMethodResult extendSysWebViewMethodResult, final PassFaceRecogCallback passFaceRecogCallback, final String str, final Map<String, String> map, final String str2) {
        final SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session == null) {
            extendSysWebViewMethodResult.params.put("retCode", "-302");
            extendSysWebViewMethodResult.params.put("retMsg", "please login first");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
            return;
        }
        livenessDTO.bduss = session.bduss;
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.PassportSDK.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                BiometricsManager.getInstance().recogWithBduss(PassportSDK.this.context, str, map, str2, session.bduss, getTplStokenResult.tplStokenMap.get("pp"), passFaceRecogCallback);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
                extendSysWebViewMethodResult.params.put("retCode", Integer.valueOf(getTplStokenResult.getResultCode()));
                extendSysWebViewMethodResult.params.put("retMsg", getTplStokenResult.getResultMsg());
                extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }
        }, livenessDTO.bduss, arrayList);
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
        this.authWidgetCallback = null;
        this.extendSysWebViewMethodCallback = null;
        this.addressManageDTO = null;
        this.addressManageCallback = null;
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

    public void loadAddressManage(Context context, AddressManageDTO addressManageDTO, AddressManageCallback addressManageCallback) {
        this.addressManageDTO = addressManageDTO;
        this.addressManageCallback = addressManageCallback;
        if (context == null) {
            context = this.context;
        }
        Intent intent = new Intent(context, AddressManageActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public String getSidKey() {
        return SapiContext.getInstance(SapiAccountManager.getInstance().getConfignation().context).getSapiOptions().sidKeys;
    }

    public void setSidValue(String str) {
        SapiAccountManager.getInstance().getConfignation().sidValue = str;
    }

    public void loadInvoiceBuild(Context context, InvoiceBuildDTO invoiceBuildDTO, InvoiceBuildCallback invoiceBuildCallback) {
        this.invoiceBuildDTO = invoiceBuildDTO;
        this.invoiceBuildCallback = invoiceBuildCallback;
        if (context == null) {
            context = this.context;
        }
        Intent intent = new Intent(context, InvoiceBuildActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }
}
