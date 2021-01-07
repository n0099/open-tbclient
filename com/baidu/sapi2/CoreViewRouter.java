package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.AccountRealNameActivity;
import com.baidu.sapi2.activity.AccountToolsActivity;
import com.baidu.sapi2.activity.AuthWidgetActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sapi2.activity.NormalizeGuestAccountActivity;
import com.baidu.sapi2.activity.QrLoginActivity;
import com.baidu.sapi2.activity.RegisterActivity;
import com.baidu.sapi2.activity.RemoteProcessWebviewActivity;
import com.baidu.sapi2.activity.SwitchAccountActivity;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.AccountToolsCallback;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.AuthWidgetCallback;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.FaceIDCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.AccountToolsDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyCertInfoDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.dto.WebBindWidgetDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.b;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.k;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.webkit.internal.ETAG;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CoreViewRouter implements NoProguard {
    private static CoreViewRouter y;
    private static LoginStatusChangeCallback z;

    /* renamed from: a  reason: collision with root package name */
    private AbstractThirdPartyService f4786a;

    /* renamed from: b  reason: collision with root package name */
    private WebAuthListener f4787b;
    private WebLoginDTO c;
    private WebRegDTO d;
    private WebBindWidgetDTO e;
    private WebSocialLoginDTO f;
    private AccountCenterDTO g;
    private NormalizeGuestAccountDTO h;
    private RealNameDTO i;
    private SwitchAccountDTO j;
    private AccountCenterCallback k;
    private AccountRealNameCallback l;
    private WebBindWidgetCallback m;
    private ImageCropCallback n;
    private ActivityResultCallback o;
    private QrLoginCallback p;
    private SmsViewLoginCallback q;
    private NormalizeGuestAccountCallback r;
    private AuthWidgetCallback s;
    private ExtendSysWebViewMethodCallback t;
    private OneKeyLoginCallback u;
    private AccountToolsCallback v;
    private String w;
    private Context x = SapiAccountManager.getInstance().getSapiConfiguration().context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends GetTplStokenCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f4791a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4792b;
        final /* synthetic */ Map c;
        final /* synthetic */ String d;
        final /* synthetic */ SapiAccount e;
        final /* synthetic */ PassFaceRecogCallback f;
        final /* synthetic */ ExtendSysWebViewMethodResult g;
        final /* synthetic */ ExtendSysWebViewMethodCallback h;

        a(Activity activity, String str, Map map, String str2, SapiAccount sapiAccount, PassFaceRecogCallback passFaceRecogCallback, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            this.f4791a = activity;
            this.f4792b = str;
            this.c = map;
            this.d = str2;
            this.e = sapiAccount;
            this.f = passFaceRecogCallback;
            this.g = extendSysWebViewMethodResult;
            this.h = extendSysWebViewMethodCallback;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            this.g.params.put(BaiduRimConstants.RETCODE_KEY, Integer.valueOf(getTplStokenResult.getResultCode()));
            this.g.params.put("retMsg", getTplStokenResult.getResultMsg());
            this.h.onFinish(this.g);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            BiometricsManager.getInstance().recogWithBduss(this.f4791a, this.f4792b, this.c, this.d, this.e.bduss, getTplStokenResult.tplStokenMap.get("pp"), this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends b.AbstractC0349b {
        b() {
        }

        @Override // com.baidu.sapi2.share.b.AbstractC0349b
        public void onFailed(int i, String str) {
            super.onFailed(i, str);
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(i);
            webAuthResult.setResultMsg(str);
            if (CoreViewRouter.this.f4787b != null) {
                CoreViewRouter.this.f4787b.onFailure(webAuthResult);
            }
            CoreViewRouter.getInstance().release();
        }

        @Override // com.baidu.sapi2.share.b.AbstractC0349b
        public void onSuccess() {
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.accountType = AccountType.NORMAL;
            webAuthResult.setResultCode(0);
            if (CoreViewRouter.this.f4787b != null) {
                CoreViewRouter.this.f4787b.onSuccess(webAuthResult);
            }
            CoreViewRouter.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends QrLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ QrLoginCallback f4794a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f4795b;

        c(QrLoginCallback qrLoginCallback, List list) {
            this.f4794a = qrLoginCallback;
            this.f4795b = list;
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onFinish(QrLoginResult qrLoginResult) {
            this.f4794a.onFinish(qrLoginResult);
            if (this.f4795b.size() == 1) {
                ((WebAuthResult) this.f4795b.get(0)).finishActivity();
                this.f4794a.onLocalLogin((WebAuthResult) this.f4795b.get(0));
            }
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onLocalLogin(WebAuthResult webAuthResult) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends WebAuthListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f4796a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4797b;
        final /* synthetic */ boolean c;

        d(List list, String str, boolean z) {
            this.f4796a = list;
            this.f4797b = str;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            this.f4796a.add(webAuthResult);
            CoreViewRouter.this.a(this.f4797b + (this.f4797b.indexOf("?") > 0 ? ETAG.ITEM_SEPARATOR : "?") + "login_action_type=" + SapiUtils.getLastLoginType() + "&clientfrom=android", this.c);
        }
    }

    /* loaded from: classes3.dex */
    class e extends AuthWidgetCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f4798a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RegisterUserFaceIDCallback f4799b;
        final /* synthetic */ FaceIDRegDTO c;

        e(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
            this.f4798a = activity;
            this.f4799b = registerUserFaceIDCallback;
            this.c = faceIDRegDTO;
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onFailure(SapiResult sapiResult) {
            this.f4799b.onFailure(sapiResult);
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onSuccess(String str) {
            CoreViewRouter coreViewRouter = CoreViewRouter.this;
            Activity activity = this.f4798a;
            RegisterUserFaceIDCallback registerUserFaceIDCallback = this.f4799b;
            FaceIDRegDTO faceIDRegDTO = this.c;
            coreViewRouter.b(activity, registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
        }
    }

    /* loaded from: classes3.dex */
    class f extends GetTplStokenCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f4800a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FaceIDVerifyDTO f4801b;
        final /* synthetic */ VerifyUserFaceIDCallback c;
        final /* synthetic */ RealNameFaceIDResult d;

        f(Activity activity, FaceIDVerifyDTO faceIDVerifyDTO, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
            this.f4800a = activity;
            this.f4801b = faceIDVerifyDTO;
            this.c = verifyUserFaceIDCallback;
            this.d = realNameFaceIDResult;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            this.d.setResultCode(getTplStokenResult.getResultCode());
            this.d.setResultMsg(getTplStokenResult.getResultMsg());
            this.c.onFailure(this.d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            String str = getTplStokenResult.tplStokenMap.get("pp");
            if (!TextUtils.isEmpty(str)) {
                CoreViewRouter coreViewRouter = CoreViewRouter.this;
                Activity activity = this.f4800a;
                FaceIDVerifyDTO faceIDVerifyDTO = this.f4801b;
                coreViewRouter.a(activity, faceIDVerifyDTO.subpro, (Map<String, String>) null, "0", faceIDVerifyDTO.bduss, str, faceIDVerifyDTO.businessSence, this.c, this.d);
                return;
            }
            this.d.setResultCode(-402);
            this.d.setResultMsg("服务异常，请稍后再试");
            this.c.onFailure(this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RealNameFaceIDResult f4802a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ VerifyUserFaceIDCallback f4803b;

        g(RealNameFaceIDResult realNameFaceIDResult, VerifyUserFaceIDCallback verifyUserFaceIDCallback) {
            this.f4802a = realNameFaceIDResult;
            this.f4803b = verifyUserFaceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.f4802a.setResultCode(passFaceRecogResult.getResultCode());
            this.f4802a.setResultMsg(passFaceRecogResult.getResultMsg());
            this.f4803b.onFailure(this.f4802a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            this.f4802a.setResultCode(passFaceRecogResult.getResultCode());
            this.f4802a.setResultMsg(passFaceRecogResult.getResultMsg());
            RealNameFaceIDResult realNameFaceIDResult = this.f4802a;
            realNameFaceIDResult.authSid = passFaceRecogResult.authSid;
            realNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
            realNameFaceIDResult.setResultCode(0);
            this.f4803b.onSuccess(this.f4802a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UnRealNameFaceIDResult f4804a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4805b;
        final /* synthetic */ FaceIDCallback c;

        h(UnRealNameFaceIDResult unRealNameFaceIDResult, String str, FaceIDCallback faceIDCallback) {
            this.f4804a = unRealNameFaceIDResult;
            this.f4805b = str;
            this.c = faceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.f4804a.setResultCode(passFaceRecogResult.getResultCode());
            this.c.onFailure(this.f4804a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            JSONObject jSONObject;
            this.f4804a.setResultMsg(passFaceRecogResult.getResultMsg());
            if (this.f4805b.equals("faceDetect") && (jSONObject = passFaceRecogResult.extraJson) != null) {
                this.f4804a.registerResult = jSONObject.toString();
            }
            UnRealNameFaceIDResult unRealNameFaceIDResult = this.f4804a;
            unRealNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
            if (TextUtils.isEmpty(unRealNameFaceIDResult.callBackKey)) {
                this.f4804a.setResultCode(-205);
                this.c.onFailure(this.f4804a);
                return;
            }
            this.f4804a.setResultCode(0);
            this.c.onSuccess(this.f4804a);
        }
    }

    /* loaded from: classes3.dex */
    class i implements SapiCallback<SapiResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4806a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f4807b;
        final /* synthetic */ ExtendSysWebViewMethodCallback c;
        final /* synthetic */ JSONObject d;
        final /* synthetic */ ExtendSysWebViewMethodResult e;

        i(int i, Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
            this.f4806a = i;
            this.f4807b = activity;
            this.c = extendSysWebViewMethodCallback;
            this.d = jSONObject;
            this.e = extendSysWebViewMethodResult;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(SapiResult sapiResult) {
            this.e.setResultCode(sapiResult.getResultCode());
            this.e.setResultMsg(sapiResult.getResultMsg());
            this.c.onFinish(this.e);
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(SapiResult sapiResult) {
            int i = this.f4806a;
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    CoreViewRouter.this.a(this.f4807b, this.c, this.d, i, this.e);
                    return;
                case 5:
                    CoreViewRouter.this.t = this.c;
                    String optString = this.d.optString("url");
                    String optString2 = this.d.optString("title");
                    Intent intent = new Intent(CoreViewRouter.this.x, LoadExternalWebViewActivity.class);
                    intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, optString2);
                    intent.putExtra("extra_external_url", optString);
                    intent.setFlags(268435456);
                    CoreViewRouter.this.x.startActivity(intent);
                    return;
                case 6:
                    JSONArray optJSONArray = this.d.optJSONArray("di_keys");
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!TextUtils.isEmpty(optJSONArray.optString(i2))) {
                            arrayList.add(optJSONArray.optString(i2));
                        }
                    }
                    String diCookieInfo = SapiDeviceInfo.getDiCookieInfo(arrayList, false);
                    this.e.params.put(BaiduRimConstants.RETCODE_KEY, "0");
                    this.e.params.put("result", diCookieInfo);
                    this.c.onFinish(this.e);
                    return;
                default:
                    this.e.params.put(BaiduRimConstants.RETCODE_KEY, "-301");
                    this.e.params.put("retMsg", "action :" + this.f4806a + " is not support");
                    this.c.onFinish(this.e);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ExtendSysWebViewMethodResult f4808a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ExtendSysWebViewMethodCallback f4809b;

        j(ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            this.f4808a = extendSysWebViewMethodResult;
            this.f4809b = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f4808a;
            extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
            this.f4809b.onFinish(extendSysWebViewMethodResult);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f4808a;
            extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
            this.f4809b.onFinish(extendSysWebViewMethodResult);
        }
    }

    private CoreViewRouter() {
    }

    public static synchronized CoreViewRouter getInstance() {
        CoreViewRouter coreViewRouter;
        synchronized (CoreViewRouter.class) {
            if (y == null) {
                y = new CoreViewRouter();
            }
            coreViewRouter = y;
        }
        return coreViewRouter;
    }

    public static LoginStatusChangeCallback getLoginStatusChangeCallback() {
        return z;
    }

    public static void setLoginStatusChangeCallback(LoginStatusChangeCallback loginStatusChangeCallback) {
        z = loginStatusChangeCallback;
    }

    public void extendSysWebViewMethod(Activity activity, String str, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("action");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            String optString = optJSONObject.optString("open_appid");
            String optString2 = optJSONObject.optString("open_apikey");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                SapiAccountManager.getInstance().getAccountService().extendSysWebViewMethodCheck(new i(optInt, activity, extendSysWebViewMethodCallback, optJSONObject, extendSysWebViewMethodResult), optString, optString2);
                return;
            }
            extendSysWebViewMethodResult.params.put(BaiduRimConstants.RETCODE_KEY, "-310");
            extendSysWebViewMethodResult.params.put("retMsg", "因安全原因，操作失败");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
        } catch (JSONException e2) {
            Log.e(e2);
            extendSysWebViewMethodResult.params.put(BaiduRimConstants.RETCODE_KEY, "-3");
            extendSysWebViewMethodResult.params.put("retMsg", "params is not json");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
        }
    }

    public AccountCenterCallback getAccountCenterCallback() {
        return this.k;
    }

    public AccountCenterDTO getAccountCenterDTO() {
        return this.g;
    }

    public AccountRealNameCallback getAccountRealNameCallback() {
        return this.l;
    }

    public AccountToolsCallback getAccountToolsCallback() {
        return this.v;
    }

    public ActivityResultCallback getActivityResultCallback() {
        return this.o;
    }

    public AuthWidgetCallback getAuthWidgetCallback() {
        return this.s;
    }

    public ExtendSysWebViewMethodCallback getExtendSysWebViewMethodCallback() {
        return this.t;
    }

    public ImageCropCallback getImageCropCallback() {
        return this.n;
    }

    public NormalizeGuestAccountCallback getNormalizeGuestAccountCallback() {
        return this.r;
    }

    public NormalizeGuestAccountDTO getNormalizeGuestAccountDTO() {
        return this.h;
    }

    public OneKeyLoginCallback getOneKeyLoginCallback() {
        return this.u;
    }

    public QrLoginCallback getQrLoginCallback() {
        return this.p;
    }

    public RealNameDTO getRealNameDTO() {
        return this.i;
    }

    public String getSmsLoginStatExtra() {
        return WebLoginDTO.getStatExtraDecode(this.w);
    }

    public SmsViewLoginCallback getSmsViewLoginCallback() {
        return this.q;
    }

    public WebSocialLoginDTO getSocialLoginDTO() {
        return this.f;
    }

    public SwitchAccountDTO getSwitchAccountDTO() {
        return this.j;
    }

    public AbstractThirdPartyService getThirdPartyService() {
        if (this.f4786a == null) {
            a();
        }
        return this.f4786a;
    }

    public WebAuthListener getWebAuthListener() {
        return this.f4787b;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        return this.m;
    }

    public WebBindWidgetDTO getWebBindWidgetDTO() {
        return this.e;
    }

    public WebLoginDTO getWebLoginDTO() {
        return this.c;
    }

    public WebRegDTO getWebRegDTO() {
        return this.d;
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        this.f4786a = getThirdPartyService();
        AbstractThirdPartyService abstractThirdPartyService = this.f4786a;
        if (abstractThirdPartyService == null) {
            return;
        }
        abstractThirdPartyService.handleWXLoginResp(activity, str, str2, i2);
    }

    public void invokeV2ShareLogin(Activity activity, WebAuthListener webAuthListener, ShareStorage.StorageModel storageModel, String str) {
        if (storageModel != null && webAuthListener != null) {
            this.f4787b = webAuthListener;
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            new com.baidu.sapi2.share.b().a(activity, storageModel.pkg, storageModel.url, null, null, arrayList);
            return;
        }
        throw new IllegalArgumentException(ShareStorage.StorageModel.class.getSimpleName() + "or" + WebAuthListener.class.getSimpleName() + "can't be null");
    }

    public void loadAccountCenter(AccountCenterCallback accountCenterCallback, AccountCenterDTO accountCenterDTO) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().m().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            accountCenterDTO.bduss = currentAccount.bduss;
        }
        this.k = accountCenterCallback;
        this.g = accountCenterDTO;
        Intent intent = new Intent(this.x, AccountCenterActivity.class);
        intent.setFlags(268435456);
        this.x.startActivity(intent);
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        this.l = accountRealNameCallback;
        this.i = realNameDTO;
        Intent intent = new Intent(context, AccountRealNameActivity.class);
        if (realNameDTO != null) {
            intent.putExtra("EXTRA_BDUSS", realNameDTO.bduss);
            intent.putExtra(AccountRealNameActivity.EXTRA_SCENE, realNameDTO.scene);
            intent.putExtra(AccountRealNameActivity.EXTRA_NEED_CB_KEY, realNameDTO.needCbKey);
            intent.putExtra(AccountRealNameActivity.EXTRA_CUSTOM_LINK, realNameDTO.customRealNameUrl);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.x.startActivity(intent);
    }

    public void loadAccountTools(AccountToolsDTO accountToolsDTO, AccountToolsCallback accountToolsCallback) {
        this.v = accountToolsCallback;
        Intent intent = new Intent(accountToolsDTO.context, AccountToolsActivity.class);
        intent.putExtra(AccountToolsActivity.EXTRA_ACCOUNT_TOOLS_TYPE, accountToolsDTO.toolsType);
        accountToolsDTO.context.startActivity(intent);
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, WebBindWidgetDTO webBindWidgetDTO) {
        SapiAccount currentAccount;
        this.m = webBindWidgetCallback;
        if (SapiContext.getInstance().getSapiOptions().m().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            webBindWidgetDTO.bduss = currentAccount.bduss;
        }
        this.e = webBindWidgetDTO;
        Intent intent = new Intent(this.x, BindWidgetActivity.class);
        intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, webBindWidgetDTO.bindWidgetAction);
        intent.putExtra("EXTRA_BDUSS", webBindWidgetDTO.bduss);
        intent.setFlags(268435456);
        this.x.startActivity(intent);
    }

    public void loadOneKeyLogin(Context context, String str, OneKeyLoginCallback oneKeyLoginCallback) {
        loadOneKeyLogin(context, str, true, oneKeyLoginCallback);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        loadQrLogin(qrLoginCallback, str, null, true);
    }

    public void loadRemoteProcessWebViewActivity(Context context, String str, String str2) {
        Intent intent = new Intent(context, RemoteProcessWebviewActivity.class);
        intent.putExtra(RemoteProcessWebviewActivity.EXTRA_EXTERNAL_TITLE, str);
        intent.putExtra(RemoteProcessWebviewActivity.EXTRA_EXTERNAL_URL, str2 + "&adapter=3");
        intent.putExtra(RemoteProcessWebviewActivity.EXTRA_IS_DARK_MODE, SapiAccountManager.getInstance().getConfignation().isDarkMode);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.x.startActivity(intent);
    }

    public void loadSwitchAccount(SwitchAccountDTO switchAccountDTO, WebAuthListener webAuthListener) {
        this.j = switchAccountDTO;
        this.f4787b = webAuthListener;
        Intent intent = new Intent(this.x, SwitchAccountActivity.class);
        intent.setFlags(268435456);
        this.x.startActivity(intent);
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("eventType", "switch_account_enter");
        k.a(linkedHashMap);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        this.f = new WebSocialLoginDTO();
        WebSocialLoginDTO webSocialLoginDTO = this.f;
        webSocialLoginDTO.socialType = socialType;
        loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        onActivityResult(i2, i3, intent, "");
    }

    public void registerUserFaceID(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
            startAuth(new e(activity, registerUserFaceIDCallback, faceIDRegDTO), faceIDRegDTO.authWidgetURL);
        } else {
            b(activity, registerUserFaceIDCallback, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
        }
    }

    public synchronized void release() {
        this.f4787b = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.g = null;
        this.l = null;
        this.p = null;
        this.q = null;
        this.w = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.j = null;
        PassportViewManager.getInstance().release();
        y = null;
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        this.o = activityResultCallback;
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        this.n = imageCropCallback;
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        this.f4786a = abstractThirdPartyService;
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        this.s = authWidgetCallback;
        Intent intent = new Intent(this.x, AuthWidgetActivity.class);
        intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
        intent.setFlags(268435456);
        this.x.startActivity(intent);
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        startLogin(this.x, webAuthListener, webLoginDTO);
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        this.r = normalizeGuestAccountCallback;
        this.h = normalizeGuestAccountDTO;
        Intent intent = new Intent(context, NormalizeGuestAccountActivity.class);
        intent.putExtra("EXTRA_BDUSS", normalizeGuestAccountDTO.bduss);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        this.f4787b = webAuthListener;
        this.d = webRegDTO;
        Intent intent = new Intent(this.x, RegisterActivity.class);
        intent.setFlags(268435456);
        this.x.startActivity(intent);
    }

    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        this.q = smsViewLoginCallback;
        this.w = str;
        SmsLoginView.notifyStartLogin();
    }

    public void verifyUserFaceIDWithCertInfo(Activity activity, PassFaceRecogCallback passFaceRecogCallback, FaceIDVerifyCertInfoDTO faceIDVerifyCertInfoDTO) {
        BiometricsManager.getInstance().recogWithCertInfo(activity, BiometricsManager.buildSubPro("", faceIDVerifyCertInfoDTO.subpro), faceIDVerifyCertInfoDTO.transParamsList, faceIDVerifyCertInfoDTO.imageFlag, faceIDVerifyCertInfoDTO.realName, faceIDVerifyCertInfoDTO.idCardNo, null, passFaceRecogCallback);
    }

    public void verifyUserFaceId(Activity activity, VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().m().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            faceIDVerifyDTO.bduss = currentAccount.bduss;
            faceIDVerifyDTO.uid = currentAccount.uid;
        }
        if (TextUtils.isEmpty(faceIDVerifyDTO.livingUname)) {
            RealNameFaceIDResult realNameFaceIDResult = new RealNameFaceIDResult();
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new f(activity, faceIDVerifyDTO, verifyUserFaceIDCallback, realNameFaceIDResult), faceIDVerifyDTO.bduss, arrayList);
            return;
        }
        b(activity, verifyUserFaceIDCallback, "outer", "", faceIDVerifyDTO.livingUname, faceIDVerifyDTO.showGuidePage, faceIDVerifyDTO.subpro, faceIDVerifyDTO.businessSence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z2, String str4, String str5) {
        a(activity, faceIDCallback, str, str2, str3, z2, str4, str5);
    }

    public void loadOneKeyLogin(final Context context, final String str, final boolean z2, final OneKeyLoginCallback oneKeyLoginCallback) {
        if (oneKeyLoginCallback != null) {
            if (TextUtils.isEmpty(str)) {
                Log.d(Log.TAG, "oneKeyLogin sign is empty!");
                new OneKeyLoginSdkCall().a(oneKeyLoginCallback, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL, null);
                return;
            }
            this.u = oneKeyLoginCallback;
            new OneKeyLoginSdkCall().b(SapiAccountManager.getInstance().getSapiConfiguration(), new OneKeyLoginSdkCall.TokenListener() { // from class: com.baidu.sapi2.CoreViewRouter.11

                /* renamed from: com.baidu.sapi2.CoreViewRouter$11$a */
                /* loaded from: classes3.dex */
                class a implements com.baidu.sapi2.callback.a.b {
                    a() {
                    }

                    @Override // com.baidu.sapi2.callback.a.b
                    public void a(String str, String str2) {
                        AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                        if (z2) {
                            Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
                            intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, str);
                            String str3 = (str2 + "&adapter=3") + "&lastLoginType=oneKeyLogin";
                            if (SapiAccountManager.getInstance().getSapiConfiguration().supportFaceLogin) {
                                str3 = str3 + "&liveAbility=1";
                            }
                            intent.putExtra("extra_external_url", str3);
                            intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_FROM, "business_from_one_key_login");
                            Context context = context;
                            if (context instanceof Activity) {
                                context.startActivity(intent);
                                return;
                            }
                            intent.setFlags(268435456);
                            CoreViewRouter.this.x.startActivity(intent);
                            return;
                        }
                        new OneKeyLoginSdkCall().a(oneKeyLoginCallback, -111, null);
                    }
                }

                @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                public void onGetTokenComplete(JSONObject jSONObject) {
                    String optString = jSONObject.optString("token");
                    if (!TextUtils.isEmpty(optString)) {
                        SapiAccountManager.getInstance().getAccountService().a(oneKeyLoginCallback, optString, str, new a());
                    } else {
                        new OneKeyLoginSdkCall().a(oneKeyLoginCallback, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL, null);
                    }
                }
            });
            return;
        }
        Log.e(Log.TAG, "When load oneKeyLogin, oneKeyLoginCallback can't be null!");
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2) {
        loadQrLogin(qrLoginCallback, str, str2, true);
    }

    public void onActivityResult(int i2, int i3, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new PassNameValuePair("extrajson", str));
        }
        new com.baidu.sapi2.share.b().a(new b(), i2, i3, intent, arrayList);
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        SapiWebView.statLoadLogin = new com.baidu.sapi2.utils.j();
        SapiWebView.statLoadLogin.f5421a = System.currentTimeMillis();
        this.f4787b = webAuthListener;
        this.c = webLoginDTO;
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, webLoginDTO.loginType);
        intent.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, webLoginDTO.finishActivityAfterSuc);
        if (!TextUtils.isEmpty(webLoginDTO.preSetUname)) {
            intent.putExtra("username", webLoginDTO.preSetUname);
        }
        int i2 = webLoginDTO.businessType;
        if (i2 != 0) {
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
        }
        if (!TextUtils.isEmpty(webLoginDTO.extraJson)) {
            intent.putExtra("extraJson", webLoginDTO.extraJson);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.x.startActivity(intent);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2, boolean z2) {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList(1);
        this.p = new c(qrLoginCallback, arrayList);
        if (SapiAccountManager.getInstance().isLogin()) {
            a(str, z2);
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
        } catch (JSONException e2) {
        }
        startLogin(new d(arrayList, str, z2), webLoginDTO);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        this.f4787b = webAuthListener;
        this.f = webSocialLoginDTO;
        this.f4786a = getThirdPartyService();
        AbstractThirdPartyService abstractThirdPartyService = this.f4786a;
        if (abstractThirdPartyService != null) {
            Context context = webSocialLoginDTO.context;
            if (context == null) {
                context = this.x;
            }
            abstractThirdPartyService.loadThirdPartyLogin(context, webSocialLoginDTO.socialType, 2002);
            webSocialLoginDTO.context = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z2) {
        Intent intent = new Intent(this.x, QrLoginActivity.class);
        intent.putExtra(QrLoginActivity.EXTRA_STRING_QR_LOGIN_URL, str);
        intent.putExtra(QrLoginActivity.EXTRA_BOOLEAN_FINISH_PAGE, z2);
        intent.setFlags(268435456);
        this.x.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, String str5, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
        BiometricsManager.getInstance().recogWithBduss(activity, BiometricsManager.buildSubPro(str, str5), map, str2, str3, str4, new g(realNameFaceIDResult, verifyUserFaceIDCallback));
    }

    private void a(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z2, String str4, String str5) {
        if (!TextUtils.isEmpty(str5)) {
            BiometricsManager biometricsManager = BiometricsManager.getInstance();
            String buildSubPro = BiometricsManager.buildSubPro(str4, str5);
            HashMap hashMap = new HashMap();
            h hVar = new h(new UnRealNameFaceIDResult(), str, faceIDCallback);
            if (str.equals("faceDetect")) {
                biometricsManager.recogWithFaceDetect(activity, buildSubPro, hashMap, "0", str3, str2, hVar);
                return;
            } else if (str.equals("outer")) {
                biometricsManager.recogWithFaceOuter(activity, buildSubPro, hashMap, "0", str3, hVar);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("scene can't be empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, int i2, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        j jVar = new j(extendSysWebViewMethodResult, extendSysWebViewMethodCallback);
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
        if (i2 == 1) {
            biometricsManager.getClass();
            a(activity, extendSysWebViewMethodCallback, new BiometricsManager.e(), extendSysWebViewMethodResult, jVar, optString, hashMap, optInt + "");
        }
        if (i2 == 2) {
            biometricsManager.recogWithCertInfo(activity, optString, hashMap, optInt + "", jSONObject.optString("realname"), jSONObject.optString("idcardnum"), jSONObject.optString("bankmobile"), jVar);
        }
        if (i2 == 3) {
            biometricsManager.recogWithAuthToken(activity, optString, hashMap, optInt + "", jSONObject.optString("authtoken"), jVar);
        }
        if (i2 == 4) {
            if (jSONObject.optInt("type") == 1) {
                biometricsManager.recogWithFaceDetect(activity, optString, hashMap, optInt + "", jSONObject.optString("uid"), "", jVar);
            } else {
                biometricsManager.recogWithFaceOuter(activity, optString, hashMap, optInt + "", jSONObject.optString("uid"), jVar);
            }
        }
    }

    private void a(Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, BiometricsManager.e eVar, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, PassFaceRecogCallback passFaceRecogCallback, String str, Map<String, String> map, String str2) {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            extendSysWebViewMethodResult.params.put(BaiduRimConstants.RETCODE_KEY, "-302");
            extendSysWebViewMethodResult.params.put("retMsg", "please login first");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
            return;
        }
        eVar.j = currentAccount.bduss;
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(activity, str, map, str2, currentAccount, passFaceRecogCallback, extendSysWebViewMethodResult, extendSysWebViewMethodCallback), eVar.j, arrayList);
    }

    private void a() {
        try {
            Class.forName("com.baidu.sapi2.ThirdPartyService").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            Log.e(e2);
        }
    }
}
