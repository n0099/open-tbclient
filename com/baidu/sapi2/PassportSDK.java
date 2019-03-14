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
import com.baidu.sapi2.activity.AuthWidgetActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.baidu.sapi2.activity.FastRegActivity;
import com.baidu.sapi2.activity.FillUProfileActivity;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sapi2.activity.ModifyPwdActivity;
import com.baidu.sapi2.activity.NormalizeGuestAccountActivity;
import com.baidu.sapi2.activity.OperationRecordActivity;
import com.baidu.sapi2.activity.QrLoginActivity;
import com.baidu.sapi2.activity.RegisterActivity;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.AuthWidgetCallback;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.FaceIDCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SapiWebCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.callback.WebFillUProfileCallback;
import com.baidu.sapi2.callback.WebModifyPwdCallback;
import com.baidu.sapi2.callback.WebSocialLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
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
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatLoadLogin;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
    private AuthWidgetCallback authWidgetCallback;
    private WebBindWidgetDTO bindWidgetDTO;
    Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
    private ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback;
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
                if (PassportSDK.this.webAuthListener != null) {
                    PassportSDK.this.webAuthListener.onSuccess(webAuthResult);
                }
                PassportSDK.getInstance().release();
            }

            @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
            public void onFailed(int i3, String str) {
                super.onFailed(i3, str);
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(i3);
                webAuthResult.setResultMsg(str);
                if (PassportSDK.this.webAuthListener != null) {
                    PassportSDK.this.webAuthListener.onFailure(webAuthResult);
                }
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
        loadAccountRealName(accountRealNameCallback, str, null);
    }

    public void loadAccountRealName(AccountRealNameCallback accountRealNameCallback, String str, String str2) {
        this.accountRealNameCallback = accountRealNameCallback;
        Intent intent = new Intent(this.context, AccountRealNameActivity.class);
        intent.putExtra("EXTRA_BDUSS", str);
        if (TextUtils.isEmpty(str2)) {
            intent.putExtra(AccountRealNameActivity.EXTRA_SCENE, str2);
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
                    PassportSDK.this.bioScanFace(registerUserFaceIDCallback, BiometricsManager.LivenessDTO.LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_REG, str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
                }

                @Override // com.baidu.sapi2.callback.AuthWidgetCallback
                public void onFailure(SapiResult sapiResult) {
                    registerUserFaceIDCallback.onFailure(sapiResult);
                }
            }, faceIDRegDTO.authWidgetURL);
        } else {
            bioScanFace(registerUserFaceIDCallback, BiometricsManager.LivenessDTO.LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_REG, faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
        }
    }

    public void verifyUserFaceId(final VerifyUserFaceIDCallback verifyUserFaceIDCallback, final FaceIDVerifyDTO faceIDVerifyDTO) {
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
                        BiometricsManager.getInstance().recogWithBduss(PassportSDK.this.context, BiometricsManager.buildSubPro(faceIDVerifyDTO.subpro, faceIDVerifyDTO.businessSence), null, "0", faceIDVerifyDTO.bduss, str, new PassFaceRecogCallback() { // from class: com.baidu.sapi2.PassportSDK.5.1
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
                        return;
                    }
                    realNameFaceIDResult.setResultCode(SapiWebView.BiometricsIdentifyResult.ERROR_CODE_GET_STOKEN_FAILED);
                    realNameFaceIDResult.setResultMsg(SapiWebView.BiometricsIdentifyResult.ERROR_MSG_GET_STOKEN_FAILED);
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
        bioScanFace(verifyUserFaceIDCallback, BiometricsManager.LivenessDTO.LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_VERIFY, "", faceIDVerifyDTO.livingUname, faceIDVerifyDTO.showGuidePage, faceIDVerifyDTO.subpro, faceIDVerifyDTO.businessSence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bioScanFace(final FaceIDCallback faceIDCallback, final String str, String str2, String str3, boolean z, String str4, String str5) {
        if (TextUtils.isEmpty(str5)) {
            throw new IllegalArgumentException("scene can't be empty");
        }
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        String buildSubPro = BiometricsManager.buildSubPro(str4, str5);
        HashMap hashMap = new HashMap();
        final UnRealNameFaceIDResult unRealNameFaceIDResult = new UnRealNameFaceIDResult();
        PassFaceRecogCallback passFaceRecogCallback = new PassFaceRecogCallback() { // from class: com.baidu.sapi2.PassportSDK.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                unRealNameFaceIDResult.setResultMsg(passFaceRecogResult.getResultMsg());
                if (str.equals(BiometricsManager.LivenessDTO.LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_REG) && passFaceRecogResult.extraJson != null) {
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
        if (str.equals(BiometricsManager.LivenessDTO.LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_REG)) {
            biometricsManager.recogWithFaceDetect(this.context, buildSubPro, hashMap, "0", str3, str2, passFaceRecogCallback);
        } else if (str.equals(BiometricsManager.LivenessDTO.LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_VERIFY)) {
            biometricsManager.recogWithFaceOuter(this.context, buildSubPro, hashMap, "0", str3, passFaceRecogCallback);
        }
    }

    public void extendSysWebViewMethod(final Context context, String str, final ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        final ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("action");
            JSONObject optJSONObject = jSONObject.optJSONObject(LegoListActivityConfig.PARAMS);
            switch (optInt) {
                case 1:
                case 2:
                case 3:
                case 4:
                    final PassFaceRecogCallback passFaceRecogCallback = new PassFaceRecogCallback() { // from class: com.baidu.sapi2.PassportSDK.7
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
                    final BiometricsManager biometricsManager = BiometricsManager.getInstance();
                    final String str2 = optJSONObject.optInt("imageFlag", 0) + "";
                    final String optString = TextUtils.isEmpty(optJSONObject.optString("subpro")) ? "pp" : optJSONObject.optString("subpro");
                    final HashMap hashMap = new HashMap();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("transParams");
                    if (optJSONObject2 != null) {
                        Iterator<String> keys = optJSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String optString2 = optJSONObject2.optString(next);
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString2)) {
                                hashMap.put(next, optString2);
                            }
                        }
                    }
                    if (optInt == 1) {
                        final SapiAccount session = SapiAccountManager.getInstance().getSession();
                        if (session == null) {
                            extendSysWebViewMethodResult.params.put("retCode", "-302");
                            extendSysWebViewMethodResult.params.put("retMsg", "please login first");
                            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("pp");
                        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.PassportSDK.8
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.sapi2.callback.SapiCallback
                            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                                biometricsManager.recogWithBduss(context, optString, hashMap, str2, session.bduss, getTplStokenResult.tplStokenMap.get("pp"), passFaceRecogCallback);
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
                        }, session.bduss, arrayList);
                    }
                    if (optInt == 2) {
                        biometricsManager.recogWithCertInfo(context, optString, hashMap, str2, optJSONObject.optString("realname"), optJSONObject.optString("idcardnum"), optJSONObject.optString("bankmobile"), passFaceRecogCallback);
                    }
                    if (optInt == 3) {
                        biometricsManager.recogWithAuthToken(context, optString, hashMap, str2, optJSONObject.optString("authtoken"), passFaceRecogCallback);
                    }
                    if (optInt == 4) {
                        if (optJSONObject.optInt("type") == 1) {
                            biometricsManager.recogWithFaceDetect(context, optString, hashMap, str2, optJSONObject.optString("uid"), "", passFaceRecogCallback);
                            return;
                        } else {
                            biometricsManager.recogWithFaceOuter(context, optString, hashMap, str2, optJSONObject.optString("uid"), passFaceRecogCallback);
                            return;
                        }
                    }
                    return;
                case 5:
                    this.extendSysWebViewMethodCallback = extendSysWebViewMethodCallback;
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
                    ArrayList arrayList2 = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                            arrayList2.add(optJSONArray.optString(i));
                        }
                    }
                    String diCookieInfo = SapiDeviceInfo.getDiCookieInfo(arrayList2, false);
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
        } catch (JSONException e) {
            Log.e(e);
            extendSysWebViewMethodResult.params.put("retCode", "-3");
            extendSysWebViewMethodResult.params.put("retMsg", "params is not json");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
        }
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

    public String getSidKey() {
        return SapiContext.getInstance(SapiAccountManager.getInstance().getConfignation().context).getSapiOptions().sidKeys;
    }

    public void setSidValue(String str) {
        SapiAccountManager.getInstance().getConfignation().sidValue = str;
    }
}
