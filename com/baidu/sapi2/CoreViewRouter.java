package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.AccountRealNameActivity;
import com.baidu.sapi2.activity.AccountToolsActivity;
import com.baidu.sapi2.activity.AuthWidgetActivity;
import com.baidu.sapi2.activity.AuthWidgetOnlyPhoneActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.baidu.sapi2.activity.CertGuardianActivity;
import com.baidu.sapi2.activity.ChangeUserNameActivity;
import com.baidu.sapi2.activity.ChildVerifyActivity;
import com.baidu.sapi2.activity.CurrentProcessWebviewActivity;
import com.baidu.sapi2.activity.DoubleListActivity;
import com.baidu.sapi2.activity.HorizontalScreenLoginActivity;
import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sapi2.activity.NormalizeGuestAccountActivity;
import com.baidu.sapi2.activity.QrLoginActivity;
import com.baidu.sapi2.activity.RegisterActivity;
import com.baidu.sapi2.activity.RemoteProcessWebviewActivity;
import com.baidu.sapi2.activity.ShareResultProxyActivity;
import com.baidu.sapi2.activity.SwitchAccountActivity;
import com.baidu.sapi2.activity.YouthStyleLoginActivity;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.AccountToolsCallback;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.AuthWidgetCallback;
import com.baidu.sapi2.callback.CertGuardianCallback;
import com.baidu.sapi2.callback.ChangeUsernameCallback;
import com.baidu.sapi2.callback.DoubleListCallback;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.FaceIDCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.IdCardOcrCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.AccountToolsDTO;
import com.baidu.sapi2.dto.CertGuardionDTO;
import com.baidu.sapi2.dto.ChangeUserNameDTO;
import com.baidu.sapi2.dto.DoubleListDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyCertInfoDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.IdCardOcrDTO;
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
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatLoadLogin;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindInfoAction;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CoreViewRouter implements NoProguard {
    public static final String G = "https://wappass.baidu.com/v6/securitySettings/deviceManage?adapter=3";
    public static CoreViewRouter H;
    public IdCardOcrCallback A;
    public CertGuardianCallback B;
    public ChangeUsernameCallback C;
    public DoubleListCallback D;
    public String E;
    public Context F = SapiAccountManager.getInstance().getSapiConfiguration().context;
    public AbstractThirdPartyService a;
    public WebAuthListener b;
    public WebLoginDTO c;
    public WebRegDTO d;
    public WebBindWidgetDTO e;
    public WebSocialLoginDTO f;
    public AccountCenterDTO g;
    public NormalizeGuestAccountDTO h;
    public RealNameDTO i;
    public SwitchAccountDTO j;
    public IdCardOcrDTO k;
    public CertGuardionDTO l;
    public ChangeUserNameDTO m;
    public DoubleListDTO n;
    public AccountCenterCallback o;
    public AccountRealNameCallback p;
    public WebBindWidgetCallback q;
    public ImageCropCallback r;
    public ActivityResultCallback s;
    public QrLoginCallback t;
    public SmsViewLoginCallback u;
    public NormalizeGuestAccountCallback v;
    public AuthWidgetCallback w;
    public ExtendSysWebViewMethodCallback x;
    public OneKeyLoginCallback y;
    public AccountToolsCallback z;

    /* loaded from: classes3.dex */
    public class a extends PassFaceRecogCallback {
        public final /* synthetic */ ExtendSysWebViewMethodResult a;
        public final /* synthetic */ ExtendSysWebViewMethodCallback b;

        public a(ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            this.a = extendSysWebViewMethodResult;
            this.b = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.a;
            extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
            this.b.onFinish(extendSysWebViewMethodResult);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.a;
            extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
            this.b.onFinish(extendSysWebViewMethodResult);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends GetTplStokenCallback {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ String d;
        public final /* synthetic */ SapiAccount e;
        public final /* synthetic */ PassFaceRecogCallback f;
        public final /* synthetic */ ExtendSysWebViewMethodResult g;
        public final /* synthetic */ ExtendSysWebViewMethodCallback h;

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        public b(Activity activity, String str, Map map, String str2, SapiAccount sapiAccount, PassFaceRecogCallback passFaceRecogCallback, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            this.a = activity;
            this.b = str;
            this.c = map;
            this.d = str2;
            this.e = sapiAccount;
            this.f = passFaceRecogCallback;
            this.g = extendSysWebViewMethodResult;
            this.h = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            this.g.params.put("retCode", Integer.valueOf(getTplStokenResult.getResultCode()));
            this.g.params.put("retMsg", getTplStokenResult.getResultMsg());
            this.h.onFinish(this.g);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            BiometricsManager.getInstance().recogWithBduss(this.a, this.b, this.c, this.d, this.e.bduss, getTplStokenResult.tplStokenMap.get("pp"), this.f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements LoadExternalWebViewActivityCallback {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ OneKeyLoginCallback b;
        public final /* synthetic */ Context c;

        public c(boolean z, OneKeyLoginCallback oneKeyLoginCallback, Context context) {
            this.a = z;
            this.b = oneKeyLoginCallback;
            this.c = context;
        }

        @Override // com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback
        public void needLoadExternalWebView(String str, String str2) {
            if (this.a) {
                CoreViewRouter.this.y = this.b;
                Intent intent = new Intent(this.c, LoadExternalWebViewActivity.class);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, str);
                String str3 = (str2 + "&adapter=3") + "&lastLoginType=oneKeyLogin";
                if (SapiAccountManager.getInstance().getSapiConfiguration().supportFaceLogin) {
                    str3 = str3 + "&liveAbility=1";
                }
                intent.putExtra("extra_external_url", str3);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_FROM, "business_from_one_key_login");
                Context context = this.c;
                if (context instanceof Activity) {
                    context.startActivity(intent);
                    return;
                }
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                CoreViewRouter.this.F.startActivity(intent);
                return;
            }
            new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.b, -111, null);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ShareCallPacking.ShareLoginCallBack {
        public d() {
        }

        @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
        public void onFailed(int i, String str) {
            super.onFailed(i, str);
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(i);
            webAuthResult.setResultMsg(str);
            WebAuthListener webAuthListener = CoreViewRouter.this.b;
            CoreViewRouter.getInstance().release();
            if (webAuthListener != null) {
                webAuthListener.onFailure(webAuthResult);
            }
        }

        @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
        public void onSuccess() {
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.accountType = AccountType.NORMAL;
            webAuthResult.setResultCode(0);
            if (CoreViewRouter.this.b != null) {
                CoreViewRouter.this.b.onSuccess(webAuthResult);
            }
            CoreViewRouter.getInstance().release();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends WebAuthListener {
        public final /* synthetic */ QrLoginCallback a;

        public e(QrLoginCallback qrLoginCallback) {
            this.a = qrLoginCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            QrLoginCallback qrLoginCallback = this.a;
            if (qrLoginCallback != null) {
                qrLoginCallback.onLocalLogin(webAuthResult);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            QrLoginCallback qrLoginCallback = this.a;
            if (qrLoginCallback != null) {
                qrLoginCallback.onLocalLogin(webAuthResult);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends QrLoginCallback {
        public final /* synthetic */ QrLoginCallback a;
        public final /* synthetic */ List b;

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onLocalLogin(WebAuthResult webAuthResult) {
        }

        public f(QrLoginCallback qrLoginCallback, List list) {
            this.a = qrLoginCallback;
            this.b = list;
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onFinish(QrLoginResult qrLoginResult) {
            this.a.onFinish(qrLoginResult);
            if (this.b.size() == 1) {
                ((WebAuthResult) this.b.get(0)).finishActivity();
                this.a.onLocalLogin((WebAuthResult) this.b.get(0));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends WebAuthListener {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
        }

        public g(List list, String str, boolean z) {
            this.a = list;
            this.b = str;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            this.a.add(webAuthResult);
            String str = "?";
            if (this.b.indexOf("?") > 0) {
                str = "&";
            }
            CoreViewRouter.this.a(this.b + str + "login_action_type=" + SapiUtils.getLastLoginType() + "&clientfrom=android", this.c);
        }
    }

    /* loaded from: classes3.dex */
    public class h extends AuthWidgetCallback {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ RegisterUserFaceIDCallback b;
        public final /* synthetic */ FaceIDRegDTO c;

        public h(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
            this.a = activity;
            this.b = registerUserFaceIDCallback;
            this.c = faceIDRegDTO;
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onFailure(SapiResult sapiResult) {
            this.b.onFailure(sapiResult);
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onSuccess(String str) {
            CoreViewRouter coreViewRouter = CoreViewRouter.this;
            Activity activity = this.a;
            RegisterUserFaceIDCallback registerUserFaceIDCallback = this.b;
            FaceIDRegDTO faceIDRegDTO = this.c;
            coreViewRouter.b(activity, registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence, faceIDRegDTO.isCurrentProcessShowAgreement);
        }
    }

    /* loaded from: classes3.dex */
    public class i extends GetTplStokenCallback {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ FaceIDVerifyDTO b;
        public final /* synthetic */ VerifyUserFaceIDCallback c;
        public final /* synthetic */ RealNameFaceIDResult d;

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        public i(Activity activity, FaceIDVerifyDTO faceIDVerifyDTO, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
            this.a = activity;
            this.b = faceIDVerifyDTO;
            this.c = verifyUserFaceIDCallback;
            this.d = realNameFaceIDResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            this.d.setResultCode(getTplStokenResult.getResultCode());
            this.d.setResultMsg(getTplStokenResult.getResultMsg());
            this.c.onFailure(this.d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            String str = getTplStokenResult.tplStokenMap.get("pp");
            if (!TextUtils.isEmpty(str)) {
                CoreViewRouter coreViewRouter = CoreViewRouter.this;
                Activity activity = this.a;
                FaceIDVerifyDTO faceIDVerifyDTO = this.b;
                coreViewRouter.a(activity, faceIDVerifyDTO.subpro, (Map<String, String>) null, "0", faceIDVerifyDTO.bduss, str, faceIDVerifyDTO.businessSence, this.c, this.d, faceIDVerifyDTO.isCurrentProcessShowAgreement);
                return;
            }
            this.d.setResultCode(-402);
            this.d.setResultMsg("服务异常，请稍后再试");
            this.c.onFailure(this.d);
        }
    }

    /* loaded from: classes3.dex */
    public class j extends PassFaceRecogCallback {
        public final /* synthetic */ RealNameFaceIDResult a;
        public final /* synthetic */ VerifyUserFaceIDCallback b;

        public j(RealNameFaceIDResult realNameFaceIDResult, VerifyUserFaceIDCallback verifyUserFaceIDCallback) {
            this.a = realNameFaceIDResult;
            this.b = verifyUserFaceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.a.setResultCode(passFaceRecogResult.getResultCode());
            this.a.setResultMsg(passFaceRecogResult.getResultMsg());
            this.b.onFailure(this.a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            this.a.setResultCode(passFaceRecogResult.getResultCode());
            this.a.setResultMsg(passFaceRecogResult.getResultMsg());
            RealNameFaceIDResult realNameFaceIDResult = this.a;
            realNameFaceIDResult.authSid = passFaceRecogResult.authSid;
            realNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
            realNameFaceIDResult.setResultCode(0);
            this.b.onSuccess(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class k extends PassFaceRecogCallback {
        public final /* synthetic */ UnRealNameFaceIDResult a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FaceIDCallback c;

        public k(UnRealNameFaceIDResult unRealNameFaceIDResult, String str, FaceIDCallback faceIDCallback) {
            this.a = unRealNameFaceIDResult;
            this.b = str;
            this.c = faceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.a.setResultCode(passFaceRecogResult.getResultCode());
            this.c.onFailure(this.a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            JSONObject jSONObject;
            this.a.setResultMsg(passFaceRecogResult.getResultMsg());
            if (this.b.equals("faceDetect") && (jSONObject = passFaceRecogResult.extraJson) != null) {
                this.a.registerResult = jSONObject.toString();
            }
            UnRealNameFaceIDResult unRealNameFaceIDResult = this.a;
            String str = passFaceRecogResult.callbackkey;
            unRealNameFaceIDResult.callBackKey = str;
            if (TextUtils.isEmpty(str)) {
                this.a.setResultCode(-205);
                this.c.onFailure(this.a);
                return;
            }
            this.a.setResultCode(0);
            this.c.onSuccess(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements SapiCallback<SapiResult> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ ExtendSysWebViewMethodCallback c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ ExtendSysWebViewMethodResult e;

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        public l(int i, Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
            this.a = i;
            this.b = activity;
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
        public void onSuccess(SapiResult sapiResult) {
            int i = this.a;
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    CoreViewRouter.this.a(this.b, this.c, this.d, i, this.e);
                    return;
                case 5:
                    CoreViewRouter.this.x = this.c;
                    String optString = this.d.optString("url");
                    String optString2 = this.d.optString("title");
                    Intent intent = new Intent(CoreViewRouter.this.F, LoadExternalWebViewActivity.class);
                    intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, optString2);
                    intent.putExtra("extra_external_url", optString);
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    CoreViewRouter.this.F.startActivity(intent);
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
                    this.e.params.put("retCode", "0");
                    this.e.params.put("result", diCookieInfo);
                    this.c.onFinish(this.e);
                    return;
                default:
                    this.e.params.put("retCode", "-301");
                    Map<String, Object> map = this.e.params;
                    map.put("retMsg", "action :" + this.a + " is not support");
                    this.c.onFinish(this.e);
                    return;
            }
        }
    }

    private void a() {
        try {
            Class.forName("com.baidu.sapi2.ThirdPartyService").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    public static synchronized CoreViewRouter getInstance() {
        CoreViewRouter coreViewRouter;
        synchronized (CoreViewRouter.class) {
            if (H == null) {
                H = new CoreViewRouter();
            }
            coreViewRouter = H;
        }
        return coreViewRouter;
    }

    public AccountCenterCallback getAccountCenterCallback() {
        return this.o;
    }

    public AccountCenterDTO getAccountCenterDTO() {
        return this.g;
    }

    public AccountRealNameCallback getAccountRealNameCallback() {
        return this.p;
    }

    public AccountToolsCallback getAccountToolsCallback() {
        return this.z;
    }

    public ActivityResultCallback getActivityResultCallback() {
        return this.s;
    }

    public AuthWidgetCallback getAuthWidgetCallback() {
        return this.w;
    }

    public CertGuardianCallback getCertGuardianCallback() {
        return this.B;
    }

    public CertGuardionDTO getCertGuardionDTO() {
        return this.l;
    }

    public ChangeUserNameDTO getChangeUserNameDTO() {
        return this.m;
    }

    public ChangeUsernameCallback getChangeUsernameCallback() {
        return this.C;
    }

    public DoubleListCallback getDoubleListCallback() {
        return this.D;
    }

    public DoubleListDTO getDoubleListDTO() {
        return this.n;
    }

    public ExtendSysWebViewMethodCallback getExtendSysWebViewMethodCallback() {
        return this.x;
    }

    public IdCardOcrDTO getIDCardOcrDTO() {
        return this.k;
    }

    public IdCardOcrCallback getIdCardOcrCallback() {
        return this.A;
    }

    public ImageCropCallback getImageCropCallback() {
        return this.r;
    }

    public NormalizeGuestAccountCallback getNormalizeGuestAccountCallback() {
        return this.v;
    }

    public NormalizeGuestAccountDTO getNormalizeGuestAccountDTO() {
        return this.h;
    }

    public OneKeyLoginCallback getOneKeyLoginCallback() {
        return this.y;
    }

    public QrLoginCallback getQrLoginCallback() {
        return this.t;
    }

    public RealNameDTO getRealNameDTO() {
        return this.i;
    }

    public String getSmsLoginStatExtra() {
        return this.E;
    }

    public SmsViewLoginCallback getSmsViewLoginCallback() {
        return this.u;
    }

    public WebSocialLoginDTO getSocialLoginDTO() {
        return this.f;
    }

    public SwitchAccountDTO getSwitchAccountDTO() {
        return this.j;
    }

    public AbstractThirdPartyService getThirdPartyService() {
        if (this.a == null) {
            a();
        }
        return this.a;
    }

    public WebAuthListener getWebAuthListener() {
        return this.b;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        return this.q;
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

    public void releaseAccountRealNameCallback() {
        this.p = null;
    }

    public void releaseCertGuardianCallback() {
        this.B = null;
    }

    public void releaseChangeUsernameCallback() {
        this.C = null;
    }

    public void releaseDoubleListCallback() {
        this.D = null;
    }

    public void releaseOneKeyLoginCallback() {
        this.y = null;
    }

    public void releaseSmsViewLoginCallback() {
        this.u = null;
    }

    public void loadAccountTools(AccountToolsDTO accountToolsDTO, AccountToolsCallback accountToolsCallback) {
        this.z = accountToolsCallback;
        Intent intent = new Intent(accountToolsDTO.context, AccountToolsActivity.class);
        intent.putExtra(AccountToolsActivity.EXTRA_ACCOUNT_TOOLS_TYPE, accountToolsDTO.toolsType);
        intent.putExtra(AccountToolsActivity.EXTRA_SWEEP_LIGHT_LOADING, accountToolsDTO.sweepLightLoading);
        Context context = accountToolsDTO.context;
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        accountToolsDTO.context.startActivity(intent);
    }

    public void loadChangeUsername(Context context, ChangeUsernameCallback changeUsernameCallback) {
        this.C = changeUsernameCallback;
        Intent intent = new Intent(context, ChangeUserNameActivity.class);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void loadChildActivity(Context context, AccountRealNameCallback accountRealNameCallback) {
        this.p = accountRealNameCallback;
        Intent intent = new Intent(context, ChildVerifyActivity.class);
        intent.putExtra("external_url", SapiAccountManager.getInstance().getAccountService().getChildVerifyUrl());
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void loadIdCardOcr(IdCardOcrDTO idCardOcrDTO, IdCardOcrCallback idCardOcrCallback) {
        this.A = idCardOcrCallback;
        Intent intent = new Intent(idCardOcrDTO.context, IdCardOcrCameraActivity.class);
        intent.putExtra(IdCardOcrCameraActivity.PARAM_KEY_ID_CARD_TYPE, idCardOcrDTO.type);
        Context context = idCardOcrDTO.context;
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        idCardOcrDTO.context.startActivity(intent);
    }

    public void loadOneKeyLogin(Context context, OneKeyLoginCallback oneKeyLoginCallback) {
        loadOneKeyLogin(context, a(context, OneKeyLoginSdkCall.signFromAbilityApi), true, oneKeyLoginCallback);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        loadQrLogin(qrLoginCallback, str, null, true);
    }

    public void loadQrLoginWithEncuid(QrLoginCallback qrLoginCallback, String str) {
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.encryptedId = SapiUtils.urlParamsToMap(str).get(SapiUtils.KEY_QR_LOGIN_ENCUID);
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        startLogin(new e(qrLoginCallback), webLoginDTO);
    }

    public void loadSwitchAccount(SwitchAccountDTO switchAccountDTO, WebAuthListener webAuthListener) {
        this.j = switchAccountDTO;
        this.b = webAuthListener;
        Intent intent = new Intent(this.F, SwitchAccountActivity.class);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("eventType", "switch_account_enter");
        StatService.onEventAutoStatistic(linkedHashMap);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        this.b = webAuthListener;
        this.f = webSocialLoginDTO;
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.a = thirdPartyService;
        if (thirdPartyService == null) {
            return;
        }
        if (webAuthListener instanceof ThirdLoginCallback) {
            ThirdLoginCallback thirdLoginCallback = (ThirdLoginCallback) webAuthListener;
            Context context = webSocialLoginDTO.context;
            if (context == null) {
                context = this.F;
            }
            thirdPartyService.loadThirdPartyLogin(context, webSocialLoginDTO.socialType, 2002, thirdLoginCallback);
        } else {
            Context context2 = webSocialLoginDTO.context;
            if (context2 == null) {
                context2 = this.F;
            }
            thirdPartyService.loadThirdPartyLogin(context2, webSocialLoginDTO.socialType, 2002);
        }
        webSocialLoginDTO.context = null;
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        this.w = authWidgetCallback;
        Intent intent = new Intent(this.F, AuthWidgetActivity.class);
        intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        startLogin(this.F, webAuthListener, webLoginDTO);
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        this.b = webAuthListener;
        this.d = webRegDTO;
        Intent intent = new Intent(this.F, RegisterActivity.class);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void startSchemeLoginForQA(Context context, String str) {
        Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_url", str);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    @Deprecated
    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        this.u = smsViewLoginCallback;
        this.E = str;
        SmsLoginView.notifyStartLogin();
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        this.f = webSocialLoginDTO;
        webSocialLoginDTO.socialType = socialType;
        loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        this.s = activityResultCallback;
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        this.r = imageCropCallback;
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        this.a = abstractThirdPartyService;
    }

    public void startLoginDeviceManager(Context context) {
        Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
        intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, "设备管理");
        intent.putExtra("extra_external_url", G);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    private String a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 7) {
            String substring = str.substring(0, 8);
            String substring2 = str.substring(8, str.length());
            String upperCase = SapiUtils.getClientId(context).toUpperCase();
            return substring + SecurityUtil.md5((substring2 + SecurityUtil.md5(upperCase.getBytes(), false)).getBytes(), false);
        }
        return null;
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, WebBindWidgetDTO webBindWidgetDTO) {
        SapiAccount currentAccount;
        this.q = webBindWidgetCallback;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            webBindWidgetDTO.bduss = currentAccount.bduss;
        }
        this.e = webBindWidgetDTO;
        Intent intent = new Intent(this.F, BindWidgetActivity.class);
        intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, webBindWidgetDTO.bindWidgetAction);
        intent.putExtra("EXTRA_BDUSS", webBindWidgetDTO.bduss);
        Context context = webBindWidgetDTO.context;
        if (context instanceof Activity) {
            context.startActivity(intent);
            webBindWidgetDTO.context = this.F;
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    private void a(Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, BiometricsManager.e eVar, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, PassFaceRecogCallback passFaceRecogCallback, String str, Map<String, String> map, String str2) {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            extendSysWebViewMethodResult.params.put("retCode", "-302");
            extendSysWebViewMethodResult.params.put("retMsg", "please login first");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
            return;
        }
        eVar.j = currentAccount.bduss;
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new b(activity, str, map, str2, currentAccount, passFaceRecogCallback, extendSysWebViewMethodResult, extendSysWebViewMethodCallback), eVar.j, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, int i2, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
        String optString;
        String str;
        HashMap hashMap;
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        a aVar = new a(extendSysWebViewMethodResult, extendSysWebViewMethodCallback);
        int optInt = jSONObject.optInt("imageFlag", 0);
        if (TextUtils.isEmpty(jSONObject.optString("subpro"))) {
            optString = "pp";
        } else {
            optString = jSONObject.optString("subpro");
        }
        String str2 = optString;
        HashMap hashMap2 = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("transParams");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString2 = optJSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString2)) {
                    hashMap2.put(next, optString2);
                }
            }
        }
        if (i2 != 1) {
            str = "";
        } else {
            Objects.requireNonNull(biometricsManager);
            BiometricsManager.e eVar = new BiometricsManager.e();
            str = "";
            a(activity, extendSysWebViewMethodCallback, eVar, extendSysWebViewMethodResult, aVar, str2, hashMap2, optInt + "");
        }
        if (i2 == 2) {
            hashMap = hashMap2;
            biometricsManager.recogWithCertInfo(activity, str2, hashMap2, optInt + str, jSONObject.optString("realname"), jSONObject.optString("idcardnum"), false, jSONObject.optString("bankmobile"), aVar);
        } else {
            hashMap = hashMap2;
        }
        if (i2 == 3) {
            biometricsManager.recogWithAuthToken(activity, str2, hashMap, optInt + str, jSONObject.optString("authtoken"), aVar);
        }
        if (i2 == 4) {
            if (jSONObject.optInt("type") == 1) {
                biometricsManager.recogWithFaceDetect(activity, str2, hashMap, optInt + str, jSONObject.optString("uid"), "", aVar);
                return;
            }
            biometricsManager.recogWithFaceOuter(activity, str2, hashMap, optInt + str, jSONObject.optString("uid"), aVar);
        }
    }

    private void a(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5, boolean z2) {
        if (!TextUtils.isEmpty(str5)) {
            BiometricsManager biometricsManager = BiometricsManager.getInstance();
            String buildSubPro = BiometricsManager.buildSubPro(str4, str5);
            HashMap hashMap = new HashMap();
            k kVar = new k(new UnRealNameFaceIDResult(), str, faceIDCallback);
            if (str.equals("faceDetect")) {
                biometricsManager.recogWithFaceDetect(activity, buildSubPro, hashMap, "0", str3, str2, z2, kVar);
                return;
            } else if (str.equals("outer")) {
                biometricsManager.recogWithFaceOuter(activity, buildSubPro, hashMap, "0", str3, z2, kVar);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("scene can't be empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, String str5, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult, boolean z) {
        BiometricsManager.getInstance().recogWithBduss(activity, BiometricsManager.buildSubPro(str, str5), map, str2, str3, str4, z, new j(realNameFaceIDResult, verifyUserFaceIDCallback));
    }

    private void a(Context context, Class<?> cls, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        if (context == null) {
            return;
        }
        StatLoadLogin statLoadLogin = new StatLoadLogin();
        SapiWebView.statLoadLogin = statLoadLogin;
        statLoadLogin.tOpenLoginPage = System.currentTimeMillis();
        this.b = webAuthListener;
        this.c = webLoginDTO;
        Intent intent = new Intent(context, cls);
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
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2, boolean z) {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList(1);
        this.t = new f(qrLoginCallback, arrayList);
        if (SapiAccountManager.getInstance().isLogin()) {
            a(str, z);
            return;
        }
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        webLoginDTO.encryptedId = SapiUtils.parseQrLoginSchema(str).get("enuid");
        try {
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(URLDecoder.decode(str2));
            }
            jSONObject.put("scenario", "1");
            webLoginDTO.statExtra = URLEncoder.encode(jSONObject.toString());
        } catch (JSONException unused) {
        }
        startLogin(new g(arrayList, str, z), webLoginDTO);
    }

    public void loadCertGuardian(Context context, CertGuardianCallback certGuardianCallback, CertGuardionDTO certGuardionDTO) {
        this.B = certGuardianCallback;
        this.l = certGuardionDTO;
        Intent intent = new Intent(context, CertGuardianActivity.class);
        CertGuardionDTO certGuardionDTO2 = this.l;
        if (certGuardionDTO2 != null) {
            intent.putExtra("EXTRA_SCENE", certGuardionDTO2.scene);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void loadChangeUsername(Context context, ChangeUserNameDTO changeUserNameDTO, ChangeUsernameCallback changeUsernameCallback) {
        this.C = changeUsernameCallback;
        this.m = changeUserNameDTO;
        Intent intent = new Intent(context, ChangeUserNameActivity.class);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void loadDoubleListActivity(Context context, DoubleListDTO doubleListDTO, DoubleListCallback doubleListCallback) {
        this.D = doubleListCallback;
        this.n = doubleListDTO;
        Intent intent = new Intent(context, DoubleListActivity.class);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void loadOneKeyLogin(Context context, String str, OneKeyLoginCallback oneKeyLoginCallback) {
        loadOneKeyLogin(context, str, true, oneKeyLoginCallback);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2) {
        loadQrLogin(qrLoginCallback, str, str2, true);
    }

    public void registerUserFaceID(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
            startAuth(new h(activity, registerUserFaceIDCallback, faceIDRegDTO), faceIDRegDTO.authWidgetURL);
        } else {
            b(activity, registerUserFaceIDCallback, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence, faceIDRegDTO.isCurrentProcessShowAgreement);
        }
    }

    public void startHorizontalScreenLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        webLoginDTO.screenType = 1;
        a(context, HorizontalScreenLoginActivity.class, webAuthListener, webLoginDTO);
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Class<?> cls;
        if (webLoginDTO != null && webLoginDTO.isWithYouthStyle) {
            cls = YouthStyleLoginActivity.class;
        } else {
            cls = LoginActivity.class;
        }
        a(context, cls, webAuthListener, webLoginDTO);
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        this.v = normalizeGuestAccountCallback;
        this.h = normalizeGuestAccountDTO;
        Intent intent = new Intent(context, NormalizeGuestAccountActivity.class);
        intent.putExtra("EXTRA_BDUSS", normalizeGuestAccountDTO.bduss);
        if (!(context instanceof Activity)) {
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        context.startActivity(intent);
    }

    @Deprecated
    public void startOnlyPhoneAuth(AuthWidgetCallback authWidgetCallback, String str, String str2) {
        this.w = authWidgetCallback;
        Intent intent = new Intent(this.F, AuthWidgetOnlyPhoneActivity.class);
        intent.putExtra("EXTRA_PARAM_AUTH_ID", str);
        intent.putExtra(AuthWidgetOnlyPhoneActivity.EXTRA_PARAM_SCENE, str2);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void startSchemeLoginForQA(Context context, String str, WebAuthListener webAuthListener) {
        this.b = webAuthListener;
        Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_url", str);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void startSmsViewLogin(SmsLoginView smsLoginView, SmsViewLoginCallback smsViewLoginCallback, String str) {
        if (smsLoginView != null && smsViewLoginCallback != null) {
            smsLoginView.setSmsViewLoginCallback(smsViewLoginCallback);
            smsLoginView.setSmsLoginStatExtra(str);
            SmsLoginView.notifyStartLogin();
        }
    }

    public void startSpeciallyAuthWidget(AuthWidgetCallback authWidgetCallback, String str, String str2) {
        this.w = authWidgetCallback;
        Intent intent = new Intent(this.F, AuthWidgetOnlyPhoneActivity.class);
        intent.putExtra("EXTRA_PARAM_AUTH_ID", str);
        intent.putExtra(AuthWidgetOnlyPhoneActivity.EXTRA_PARAM_SCENE, str2);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void verifyUserFaceIDWithCertInfo(Activity activity, PassFaceRecogCallback passFaceRecogCallback, FaceIDVerifyCertInfoDTO faceIDVerifyCertInfoDTO) {
        BiometricsManager.getInstance().recogWithCertInfo(activity, BiometricsManager.buildSubPro("", faceIDVerifyCertInfoDTO.subpro), faceIDVerifyCertInfoDTO.transParamsList, faceIDVerifyCertInfoDTO.imageFlag, faceIDVerifyCertInfoDTO.realName, faceIDVerifyCertInfoDTO.idCardNo, faceIDVerifyCertInfoDTO.needAuthorizeCertInfo, null, passFaceRecogCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        Intent intent = new Intent(this.F, QrLoginActivity.class);
        intent.putExtra(QrLoginActivity.EXTRA_STRING_QR_LOGIN_URL, str);
        intent.putExtra(QrLoginActivity.EXTRA_BOOLEAN_FINISH_PAGE, z);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5, boolean z2) {
        a(activity, faceIDCallback, str, str2, str3, z, str4, str5, z2);
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
                SapiAccountManager.getInstance().getAccountService().extendSysWebViewMethodCheck(new l(optInt, activity, extendSysWebViewMethodCallback, optJSONObject, extendSysWebViewMethodResult), optString, optString2);
                return;
            }
            extendSysWebViewMethodResult.params.put("retCode", "-310");
            extendSysWebViewMethodResult.params.put("retMsg", "因安全原因，操作失败");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
        } catch (JSONException e2) {
            Log.e(e2);
            extendSysWebViewMethodResult.params.put("retCode", "-3");
            extendSysWebViewMethodResult.params.put("retMsg", "params is not json");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
        }
    }

    public void loadCurrentProcessWebviewActivity(Context context, String str, String str2) {
        SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
        boolean z = false;
        if (sapiAccountManager == null) {
            Log.e("pass sdk is not init", new Object[0]);
            return;
        }
        SapiConfiguration confignation = sapiAccountManager.getConfignation();
        if (confignation == null) {
            Log.e("pass sdk is not init", new Object[0]);
            return;
        }
        Intent intent = new Intent(context, CurrentProcessWebviewActivity.class);
        intent.putExtra("external_title", str);
        intent.putExtra("external_url", str2 + "&adapter=3");
        intent.putExtra("text_zoom", confignation.textZoom);
        intent.putExtra("is_dark_mode", (confignation.isDarkMode || confignation.isNightMode) ? true : true);
        intent.putExtra("show_bottom_back", confignation.showBottomBack);
        intent.putExtra("is_show_bottom_back_text", confignation.isShowBottomBackText);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void loadRemoteProcessWebViewActivity(Context context, String str, String str2) {
        SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
        boolean z = false;
        if (sapiAccountManager == null) {
            Log.e("pass sdk is not init", new Object[0]);
            return;
        }
        SapiConfiguration confignation = sapiAccountManager.getConfignation();
        if (confignation == null) {
            Log.e("pass sdk is not init", new Object[0]);
            return;
        }
        Intent intent = new Intent(context, RemoteProcessWebviewActivity.class);
        intent.putExtra("external_title", str);
        intent.putExtra("external_url", str2 + "&adapter=3");
        intent.putExtra("text_zoom", confignation.textZoom);
        intent.putExtra("is_dark_mode", (confignation.isDarkMode || confignation.isNightMode) ? true : true);
        intent.putExtra("show_bottom_back", confignation.showBottomBack);
        intent.putExtra("is_show_bottom_back_text", confignation.isShowBottomBackText);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void verifyUserFaceId(Activity activity, VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            faceIDVerifyDTO.bduss = currentAccount.bduss;
            faceIDVerifyDTO.uid = currentAccount.uid;
        }
        if (TextUtils.isEmpty(faceIDVerifyDTO.livingUname)) {
            RealNameFaceIDResult realNameFaceIDResult = new RealNameFaceIDResult();
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new i(activity, faceIDVerifyDTO, verifyUserFaceIDCallback, realNameFaceIDResult), faceIDVerifyDTO.bduss, arrayList);
            return;
        }
        b(activity, verifyUserFaceIDCallback, "outer", "", faceIDVerifyDTO.livingUname, faceIDVerifyDTO.showGuidePage, faceIDVerifyDTO.subpro, faceIDVerifyDTO.businessSence, faceIDVerifyDTO.isCurrentProcessShowAgreement);
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.a = thirdPartyService;
        if (thirdPartyService == null) {
            return;
        }
        thirdPartyService.handleWXLoginResp(activity, str, str2, i2);
    }

    public void loadOneKeyLogin(Context context, String str, boolean z, OneKeyLoginCallback oneKeyLoginCallback) {
        loadOneKeyLogin(context, str, z, true, oneKeyLoginCallback);
    }

    public void loadOneKeyLoginWithToken(Context context, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        oneKeyLoginWithToken(context, str, a(context, str2), true, oneKeyLoginCallback);
    }

    public void onShareLoginActivityResult(int i2, int i3, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new PassNameValuePair("extrajson", str));
        }
        new ShareCallPacking().onLoginActivityActivityResult(new d(), i2, i3, intent, arrayList, "product");
    }

    public void invokeV2ShareLogin(Activity activity, ShareStorage.StorageModel storageModel, WebAuthListener webAuthListener, String str) {
        if (activity != null) {
            if (storageModel != null) {
                if (webAuthListener != null) {
                    ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_FROM_TPL, storageModel.tpl);
                    ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_FROM_APP_NAME, storageModel.app);
                    if (!SapiUtils.isAppInstalled(activity, storageModel.pkg)) {
                        WebAuthResult webAuthResult = new WebAuthResult();
                        webAuthResult.setResultCode(ShareResult.ERROR_CODE_TARGET_APP_NOT_INSTALLED);
                        webAuthResult.setResultMsg(ShareResult.ERROR_MSG_TARGET_APP_NOT_INSTALLED);
                        webAuthListener.onFailure(webAuthResult);
                        ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_IS_INSTALL, "0");
                    }
                    ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_IS_INSTALL, "1");
                    this.b = webAuthListener;
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new PassNameValuePair("extrajson", str));
                    }
                    Intent intent = new Intent(activity, ShareResultProxyActivity.class);
                    intent.putExtra(ShareResultProxyActivity.KEY_PKG, storageModel.pkg);
                    intent.putExtra("key_url", storageModel.url);
                    intent.putExtra(ShareResultProxyActivity.KEY_VERSION, ShareUtils.SHARE_ACCOUNT_NEW_VERSION);
                    intent.putParcelableArrayListExtra(ShareResultProxyActivity.KEY_EXTRA_PARAMS, arrayList);
                    activity.startActivity(intent);
                    return;
                }
                throw new IllegalArgumentException("method invokeV2ShareLogin() param webAuthListener cat't be null !");
            }
            throw new IllegalArgumentException("method invokeV2ShareLogin() param shareModel cat't be null !");
        }
        throw new IllegalArgumentException("method invokeV2ShareLogin() invokeActivity param cat't be null !");
    }

    public void loadAccountCenter(AccountCenterCallback accountCenterCallback, AccountCenterDTO accountCenterDTO) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            accountCenterDTO.bduss = currentAccount.bduss;
        }
        this.o = accountCenterCallback;
        this.g = accountCenterDTO;
        Intent intent = new Intent(this.F, AccountCenterActivity.class);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        this.p = accountRealNameCallback;
        this.i = realNameDTO;
        Intent intent = new Intent(context, AccountRealNameActivity.class);
        if (realNameDTO != null) {
            intent.putExtra("EXTRA_BDUSS", realNameDTO.bduss);
            intent.putExtra("EXTRA_SCENE", realNameDTO.scene);
            intent.putExtra(AccountRealNameActivity.EXTRA_NEED_CB_KEY, realNameDTO.needCbKey);
            intent.putExtra(AccountRealNameActivity.EXTRA_CUSTOM_LINK, realNameDTO.customRealNameUrl);
            intent.putExtra(AccountRealNameActivity.EXTRA_REAL_NAME_LEVEL, realNameDTO.realNameLevel);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.F.startActivity(intent);
    }

    public void loadYYSSOLogin(Context context, String str, WebAuthListener webAuthListener) {
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.a = thirdPartyService;
        if (thirdPartyService == null) {
            if (webAuthListener != null) {
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(-100);
                webAuthResult.setResultMsg("thirdPartyService is null");
                webAuthListener.onFailure(webAuthResult);
                return;
            }
            return;
        }
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = true;
        this.c = webLoginDTO;
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        webSocialLoginDTO.finishActivityAfterSuc = true;
        this.f = webSocialLoginDTO;
        this.b = webAuthListener;
        this.a.loadYYSSOLogin(context, str);
    }

    public void loadBindInfo(Context context, BindInfoAction bindInfoAction) {
        SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
        if (sapiAccountManager == null) {
            Log.e("SapiAccountManager is null,did you init pass sdk already?", new Object[0]);
            return;
        }
        SapiConfiguration confignation = sapiAccountManager.getConfignation();
        if (confignation == null) {
            Log.e("SapiConfiguration is null,did you init pass sdk already?", new Object[0]);
            return;
        }
        Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
        intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, "绑定手机");
        intent.putExtra("extra_external_url", "https://wappass.baidu.com/v3/security/bindinfo?client=android&clientfrom=native&adapter=3&wapsec=center&tpl=" + confignation.tpl + ParamsUtil.getBindInfoType(bindInfoAction) + ParamsUtil.buildH5CommonParams(confignation));
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        context.startActivity(intent);
    }

    public void loadOneKeyLogin(final Context context, final String str, final boolean z, final boolean z2, final OneKeyLoginCallback oneKeyLoginCallback) {
        if (oneKeyLoginCallback == null) {
            Log.e(Log.TAG, "When load oneKeyLogin, oneKeyLoginCallback can't be null!");
        } else if (TextUtils.isEmpty(str)) {
            Log.d(Log.TAG, "oneKeyLogin sign is empty!");
            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -108, null);
        } else {
            new OneKeyLoginSdkCall().getToken(SapiAccountManager.getInstance().getSapiConfiguration(), new OneKeyLoginSdkCall.TokenListener() { // from class: com.baidu.sapi2.CoreViewRouter.12
                @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                public void onGetTokenComplete(JSONObject jSONObject) {
                    CoreViewRouter.this.oneKeyLoginWithToken(context, jSONObject.optString("token"), str, z, z2, oneKeyLoginCallback);
                }
            });
        }
    }

    public void oneKeyLoginWithToken(Context context, String str, String str2, boolean z, OneKeyLoginCallback oneKeyLoginCallback) {
        oneKeyLoginWithToken(context, str, str2, z, true, oneKeyLoginCallback);
    }

    public void oneKeyLoginWithToken(Context context, String str, String str2, boolean z, boolean z2, OneKeyLoginCallback oneKeyLoginCallback) {
        if (TextUtils.isEmpty(str2)) {
            Log.d(Log.TAG, "oneKeyLogin sign is empty!");
            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -108, null);
        } else if (!TextUtils.isEmpty(str)) {
            SapiAccountManager.getInstance().getAccountService().loadOneKeyLogin(oneKeyLoginCallback, str, str2, z2, new c(z, oneKeyLoginCallback, context));
        } else {
            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -102, null);
        }
    }

    public synchronized void release() {
        this.b = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.g = null;
        this.t = null;
        this.o = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.j = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.m = null;
        this.n = null;
        PassportViewManager.getInstance().release();
        H = null;
    }

    public synchronized void releaseWithoutAccountCenter() {
        this.b = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.g = null;
        this.t = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.j = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.n = null;
        PassportViewManager.getInstance().release();
        H = null;
    }
}
