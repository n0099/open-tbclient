package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.AccountRealNameActivity;
import com.baidu.sapi2.activity.AddressManageActivity;
import com.baidu.sapi2.activity.AuthWidgetActivity;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.baidu.sapi2.activity.FillUProfileActivity;
import com.baidu.sapi2.activity.InvoiceBuildActivity;
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
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.InvoiceBuildCallback;
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
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.SmsLoginView;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class PassportSDK {
    private static PassportSDK a;
    private static LoginStatusChangeCallback b;
    private AddressManageCallback A;
    private InvoiceBuildCallback B;
    private String C;
    private Context D = SapiAccountManager.getInstance().getSapiConfiguration().context;
    private AbstractThirdPartyService c;
    private WebAuthListener d;
    private WebLoginDTO e;
    private WebRegDTO f;
    private WebBindWidgetDTO g;
    private WebSocialLoginDTO h;
    private AccountCenterDTO i;
    private NormalizeGuestAccountDTO j;
    private AddressManageDTO k;
    private RealNameDTO l;
    private InvoiceBuildDTO m;
    private AccountCenterCallback n;
    private AccountRealNameCallback o;
    private WebFillUProfileCallback p;
    private WebBindWidgetCallback q;
    private WebModifyPwdCallback r;
    private SapiWebCallback s;
    private ImageCropCallback t;
    private ActivityResultCallback u;
    private QrLoginCallback v;
    private SmsViewLoginCallback w;
    private NormalizeGuestAccountCallback x;
    private AuthWidgetCallback y;
    private ExtendSysWebViewMethodCallback z;

    private PassportSDK() {
    }

    public static synchronized PassportSDK getInstance() {
        PassportSDK passportSDK;
        synchronized (PassportSDK.class) {
            if (a == null) {
                a = new PassportSDK();
            }
            passportSDK = a;
        }
        return passportSDK;
    }

    public static LoginStatusChangeCallback getLoginStatusChangeCallback() {
        return b;
    }

    public static void setLoginStatusChangeCallback(LoginStatusChangeCallback loginStatusChangeCallback) {
        b = loginStatusChangeCallback;
    }

    public void extendSysWebViewMethod(Context context, String str, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("action");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            String optString = optJSONObject.optString("open_appid");
            String optString2 = optJSONObject.optString("open_apikey");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                SapiAccountManager.getInstance().getAccountService().extendSysWebViewMethodCheck(new l(this, optInt, extendSysWebViewMethodCallback, optJSONObject, extendSysWebViewMethodResult, context), optString, optString2);
                return;
            }
            extendSysWebViewMethodResult.params.put(BaiduRimConstants.RETCODE_KEY, "-310");
            extendSysWebViewMethodResult.params.put("retMsg", "因安全原因，操作失败");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
        } catch (JSONException e) {
            Log.e(e);
            extendSysWebViewMethodResult.params.put(BaiduRimConstants.RETCODE_KEY, "-3");
            extendSysWebViewMethodResult.params.put("retMsg", "params is not json");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
        }
    }

    public AccountCenterCallback getAccountCenterCallback() {
        return this.n;
    }

    public AccountCenterDTO getAccountCenterDTO() {
        return this.i;
    }

    public AccountRealNameCallback getAccountRealNameCallback() {
        return this.o;
    }

    public ActivityResultCallback getActivityResultCallback() {
        return this.u;
    }

    public AddressManageCallback getAddressManageCallback() {
        return this.A;
    }

    public AddressManageDTO getAddressManageDTO() {
        return this.k;
    }

    public AuthWidgetCallback getAuthWidgetCallback() {
        return this.y;
    }

    public ExtendSysWebViewMethodCallback getExtendSysWebViewMethodCallback() {
        return this.z;
    }

    public ImageCropCallback getImageCropCallback() {
        return this.t;
    }

    public InvoiceBuildCallback getInvoiceBuildCallback() {
        return this.B;
    }

    public InvoiceBuildDTO getInvoiceBuildDTO() {
        return this.m;
    }

    public NormalizeGuestAccountCallback getNormalizeGuestAccountCallback() {
        return this.x;
    }

    public NormalizeGuestAccountDTO getNormalizeGuestAccountDTO() {
        return this.j;
    }

    public QrLoginCallback getQrLoginCallback() {
        return this.v;
    }

    public RealNameDTO getRealNameDTO() {
        return this.l;
    }

    public SapiWebCallback getSapiWebCallback() {
        return this.s;
    }

    public String getSidKey() {
        return SapiContext.getInstance().getSapiOptions().da;
    }

    public String getSmsLoginStatExtra() {
        return WebLoginDTO.getStatExtraDecode(this.C);
    }

    public SmsViewLoginCallback getSmsViewLoginCallback() {
        return this.w;
    }

    public WebSocialLoginDTO getSocialLoginDTO() {
        return this.h;
    }

    public AbstractThirdPartyService getThirdPartyService() {
        if (this.c == null) {
            a();
        }
        return this.c;
    }

    public WebAuthListener getWebAuthListener() {
        return this.d;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        return this.q;
    }

    public WebBindWidgetDTO getWebBindWidgetDTO() {
        return this.g;
    }

    public WebFillUProfileCallback getWebFillUProfileCallback() {
        return this.p;
    }

    public WebLoginDTO getWebLoginDTO() {
        return this.e;
    }

    public WebModifyPwdCallback getWebModifyPwdCallback() {
        return this.r;
    }

    public WebRegDTO getWebRegDTO() {
        return this.f;
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i) {
        this.c = getThirdPartyService();
        AbstractThirdPartyService abstractThirdPartyService = this.c;
        if (abstractThirdPartyService == null) {
            return;
        }
        abstractThirdPartyService.handleWXLoginResp(activity, str, str2, i);
    }

    public void invokeV2ShareLogin(Activity activity, WebAuthListener webAuthListener, ShareStorage.StorageModel storageModel) {
        invokeV2ShareLogin(activity, webAuthListener, storageModel, "");
    }

    public void loadAccountCenter(AccountCenterCallback accountCenterCallback, AccountCenterDTO accountCenterDTO) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance(this.D).getSapiOptions().r().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance(this.D).getCurrentAccount()) != null) {
            accountCenterDTO.bduss = currentAccount.bduss;
        }
        this.n = accountCenterCallback;
        this.i = accountCenterDTO;
        Intent intent = new Intent(this.D, AccountCenterActivity.class);
        intent.setFlags(268435456);
        this.D.startActivity(intent);
    }

    public void loadAccountRealName(AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        loadAccountRealName(this.D, accountRealNameCallback, realNameDTO);
    }

    public void loadAddressManage(Context context, AddressManageDTO addressManageDTO, AddressManageCallback addressManageCallback) {
        this.k = addressManageDTO;
        this.A = addressManageCallback;
        if (context == null) {
            context = this.D;
        }
        Intent intent = new Intent(context, AddressManageActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, WebBindWidgetDTO webBindWidgetDTO) {
        SapiAccount currentAccount;
        this.q = webBindWidgetCallback;
        if (SapiContext.getInstance(this.D).getSapiOptions().r().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance(this.D).getCurrentAccount()) != null) {
            webBindWidgetDTO.bduss = currentAccount.bduss;
        }
        this.g = webBindWidgetDTO;
        Intent intent = new Intent(this.D, BindWidgetActivity.class);
        intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, webBindWidgetDTO.bindWidgetAction);
        intent.putExtra("EXTRA_BDUSS", webBindWidgetDTO.bduss);
        intent.setFlags(268435456);
        this.D.startActivity(intent);
    }

    public void loadFillProfile(WebFillUProfileCallback webFillUProfileCallback, String str) {
        this.p = webFillUProfileCallback;
        Intent intent = new Intent(this.D, FillUProfileActivity.class);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.putExtra(FillUProfileActivity.EXTRA_SIMPLIFIED, true);
        intent.setFlags(268435456);
        this.D.startActivity(intent);
    }

    public void loadHuaweiLogin(WebAuthListener webAuthListener, String str, String str2) {
        this.d = webAuthListener;
        a();
        AbstractThirdPartyService abstractThirdPartyService = this.c;
        if (abstractThirdPartyService == null) {
            return;
        }
        abstractThirdPartyService.loadHuaweiLogin(this.D, webAuthListener, str, str2);
    }

    public void loadInvoiceBuild(Context context, InvoiceBuildDTO invoiceBuildDTO, InvoiceBuildCallback invoiceBuildCallback) {
        this.m = invoiceBuildDTO;
        this.B = invoiceBuildCallback;
        if (context == null) {
            context = this.D;
        }
        Intent intent = new Intent(context, InvoiceBuildActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void loadModifyPwd(WebModifyPwdCallback webModifyPwdCallback, String str) {
        SapiAccount currentAccount;
        this.r = webModifyPwdCallback;
        if (SapiContext.getInstance(this.D).getSapiOptions().r().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance(this.D).getCurrentAccount()) != null) {
            str = currentAccount.bduss;
        }
        Intent intent = new Intent(this.D, ModifyPwdActivity.class);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        this.D.startActivity(intent);
    }

    public void loadOperationRecord(SapiWebCallback sapiWebCallback, String str) {
        this.s = sapiWebCallback;
        Intent intent = new Intent(this.D, OperationRecordActivity.class);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        this.D.startActivity(intent);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        loadQrLogin(qrLoginCallback, str, null, true);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        this.h = new WebSocialLoginDTO();
        WebSocialLoginDTO webSocialLoginDTO = this.h;
        webSocialLoginDTO.socialType = socialType;
        loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent, "");
    }

    public void registerUserFaceID(RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
            startAuth(new h(this, registerUserFaceIDCallback, faceIDRegDTO), faceIDRegDTO.authWidgetURL);
        } else {
            b(registerUserFaceIDCallback, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
        }
    }

    public void release() {
        SapiWebView.statLoadLogin = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = null;
        this.j = null;
        this.n = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.i = null;
        this.o = null;
        this.v = null;
        this.w = null;
        this.C = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.k = null;
        this.A = null;
        PassportViewManager.getInstance().release();
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        this.u = activityResultCallback;
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        this.t = imageCropCallback;
    }

    public void setSidValue(String str) {
        SapiAccountManager.getInstance().getConfignation().sidValue = str;
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        this.c = abstractThirdPartyService;
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        this.y = authWidgetCallback;
        Intent intent = new Intent(this.D, AuthWidgetActivity.class);
        intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
        intent.setFlags(268435456);
        this.D.startActivity(intent);
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        startLogin(this.D, webAuthListener, webLoginDTO);
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        this.x = normalizeGuestAccountCallback;
        this.j = normalizeGuestAccountDTO;
        Intent intent = new Intent(context, NormalizeGuestAccountActivity.class);
        intent.putExtra("EXTRA_BDUSS", normalizeGuestAccountDTO.bduss);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        this.d = webAuthListener;
        this.f = webRegDTO;
        Intent intent = new Intent(this.D, RegisterActivity.class);
        intent.setFlags(268435456);
        this.D.startActivity(intent);
    }

    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        this.w = smsViewLoginCallback;
        this.C = str;
        SmsLoginView.notifyStartLogin();
    }

    public void verifyUserFaceId(VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        verifyUserFaceId(this.D, verifyUserFaceIDCallback, faceIDVerifyDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5) {
        a(faceIDCallback, str, str2, str3, z, str4, str5);
    }

    public void invokeV2ShareLogin(Activity activity, WebAuthListener webAuthListener, ShareStorage.StorageModel storageModel, String str) {
        if (storageModel != null && webAuthListener != null) {
            this.d = webAuthListener;
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            new com.baidu.sapi2.share.m().a(activity, storageModel.pkg, storageModel.url, null, null, arrayList);
            return;
        }
        throw new IllegalArgumentException(ShareStorage.StorageModel.class.getSimpleName() + "or" + WebAuthListener.class.getSimpleName() + "can't be null");
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        this.o = accountRealNameCallback;
        this.l = realNameDTO;
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
        this.D.startActivity(intent);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2) {
        loadQrLogin(qrLoginCallback, str, str2, true);
    }

    public void onActivityResult(int i, int i2, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new PassNameValuePair("extrajson", str));
        }
        new com.baidu.sapi2.share.m().a(new e(this), i, i2, intent, arrayList);
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        SapiWebView.statLoadLogin = new com.baidu.sapi2.utils.o();
        SapiWebView.statLoadLogin.g = System.currentTimeMillis();
        this.d = webAuthListener;
        this.e = webLoginDTO;
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
        this.D.startActivity(intent);
    }

    public void verifyUserFaceId(Context context, VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance(context).getSapiOptions().r().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance(context).getCurrentAccount()) != null) {
            faceIDVerifyDTO.bduss = currentAccount.bduss;
            faceIDVerifyDTO.uid = currentAccount.uid;
        }
        if (TextUtils.isEmpty(faceIDVerifyDTO.livingUname)) {
            RealNameFaceIDResult realNameFaceIDResult = new RealNameFaceIDResult();
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new i(this, context, faceIDVerifyDTO, verifyUserFaceIDCallback, realNameFaceIDResult), faceIDVerifyDTO.bduss, arrayList);
            return;
        }
        b(verifyUserFaceIDCallback, "outer", "", faceIDVerifyDTO.livingUname, faceIDVerifyDTO.showGuidePage, faceIDVerifyDTO.subpro, faceIDVerifyDTO.businessSence);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2, boolean z) {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList(1);
        this.v = new f(this, qrLoginCallback, arrayList);
        if (SapiAccountManager.getInstance().isLogin()) {
            a(str, z);
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
        startLogin(new g(this, arrayList, str, z), webLoginDTO);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        this.d = webAuthListener;
        this.h = webSocialLoginDTO;
        this.c = getThirdPartyService();
        AbstractThirdPartyService abstractThirdPartyService = this.c;
        if (abstractThirdPartyService != null) {
            Context context = webSocialLoginDTO.context;
            if (context == null) {
                context = this.D;
            }
            abstractThirdPartyService.loadThirdPartyLogin(context, webSocialLoginDTO.socialType, 2002);
            webSocialLoginDTO.context = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        Intent intent = new Intent(this.D, QrLoginActivity.class);
        intent.putExtra(QrLoginActivity.EXTRA_STRING_QR_LOGIN_URL, str);
        intent.putExtra(QrLoginActivity.EXTRA_BOOLEAN_FINISH_PAGE, z);
        intent.setFlags(268435456);
        this.D.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
        BiometricsManager.getInstance().recogWithBduss(context, BiometricsManager.buildSubPro(str, str5), map, str2, str3, str4, new j(this, realNameFaceIDResult, verifyUserFaceIDCallback));
    }

    private void a(FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5) {
        if (!TextUtils.isEmpty(str5)) {
            BiometricsManager biometricsManager = BiometricsManager.getInstance();
            String buildSubPro = BiometricsManager.buildSubPro(str4, str5);
            HashMap hashMap = new HashMap();
            k kVar = new k(this, new UnRealNameFaceIDResult(), str, faceIDCallback);
            if (str.equals("faceDetect")) {
                biometricsManager.recogWithFaceDetect(this.D, buildSubPro, hashMap, "0", str3, str2, kVar);
                return;
            } else if (str.equals("outer")) {
                biometricsManager.recogWithFaceOuter(this.D, buildSubPro, hashMap, "0", str3, kVar);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("scene can't be empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, int i, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        m mVar = new m(this, extendSysWebViewMethodResult, extendSysWebViewMethodCallback);
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
            a(extendSysWebViewMethodCallback, new BiometricsManager.a(), extendSysWebViewMethodResult, mVar, optString, hashMap, optInt + "");
        }
        if (i == 2) {
            biometricsManager.recogWithCertInfo(this.D, optString, hashMap, optInt + "", jSONObject.optString("realname"), jSONObject.optString("idcardnum"), jSONObject.optString("bankmobile"), mVar);
        }
        if (i == 3) {
            biometricsManager.recogWithAuthToken(this.D, optString, hashMap, optInt + "", jSONObject.optString("authtoken"), mVar);
        }
        if (i == 4) {
            if (jSONObject.optInt("type") == 1) {
                biometricsManager.recogWithFaceDetect(this.D, optString, hashMap, optInt + "", jSONObject.optString("uid"), "", mVar);
            } else {
                biometricsManager.recogWithFaceOuter(this.D, optString, hashMap, optInt + "", jSONObject.optString("uid"), mVar);
            }
        }
    }

    private void a(ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, BiometricsManager.a aVar, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, PassFaceRecogCallback passFaceRecogCallback, String str, Map<String, String> map, String str2) {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            extendSysWebViewMethodResult.params.put(BaiduRimConstants.RETCODE_KEY, "-302");
            extendSysWebViewMethodResult.params.put("retMsg", "please login first");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
            return;
        }
        aVar.o = currentAccount.bduss;
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new d(this, str, map, str2, currentAccount, passFaceRecogCallback, extendSysWebViewMethodResult, extendSysWebViewMethodCallback), aVar.o, arrayList);
    }

    private void a() {
        try {
            Class.forName("com.baidu.sapi2.ThirdPartyService").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            Log.e(e);
        }
    }
}
