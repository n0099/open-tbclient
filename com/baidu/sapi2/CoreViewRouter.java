package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.AccountRealNameActivity;
import com.baidu.sapi2.activity.AccountToolsActivity;
import com.baidu.sapi2.activity.AuthWidgetActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.baidu.sapi2.activity.ChildVerifyActivity;
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
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.AccountToolsCallback;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.AuthWidgetCallback;
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
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatLoadLogin;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.SmsLoginView;
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
/* loaded from: classes2.dex */
public class CoreViewRouter implements NoProguard {
    public static CoreViewRouter A;

    /* renamed from: a  reason: collision with root package name */
    public AbstractThirdPartyService f9465a;

    /* renamed from: b  reason: collision with root package name */
    public WebAuthListener f9466b;

    /* renamed from: c  reason: collision with root package name */
    public WebLoginDTO f9467c;

    /* renamed from: d  reason: collision with root package name */
    public WebRegDTO f9468d;

    /* renamed from: e  reason: collision with root package name */
    public WebBindWidgetDTO f9469e;

    /* renamed from: f  reason: collision with root package name */
    public WebSocialLoginDTO f9470f;

    /* renamed from: g  reason: collision with root package name */
    public AccountCenterDTO f9471g;

    /* renamed from: h  reason: collision with root package name */
    public NormalizeGuestAccountDTO f9472h;

    /* renamed from: i  reason: collision with root package name */
    public RealNameDTO f9473i;
    public SwitchAccountDTO j;
    public IdCardOcrDTO k;
    public AccountCenterCallback l;
    public AccountRealNameCallback m;
    public WebBindWidgetCallback n;
    public ImageCropCallback o;
    public ActivityResultCallback p;
    public QrLoginCallback q;
    public SmsViewLoginCallback r;
    public NormalizeGuestAccountCallback s;
    public AuthWidgetCallback t;
    public ExtendSysWebViewMethodCallback u;
    public OneKeyLoginCallback v;
    public AccountToolsCallback w;
    public IdCardOcrCallback x;
    public String y;
    public Context z = SapiAccountManager.getInstance().getSapiConfiguration().context;

    /* loaded from: classes2.dex */
    public class a extends GetTplStokenCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f9480a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9481b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f9482c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f9483d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SapiAccount f9484e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f9485f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f9486g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f9487h;

        public a(Activity activity, String str, Map map, String str2, SapiAccount sapiAccount, PassFaceRecogCallback passFaceRecogCallback, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            this.f9480a = activity;
            this.f9481b = str;
            this.f9482c = map;
            this.f9483d = str2;
            this.f9484e = sapiAccount;
            this.f9485f = passFaceRecogCallback;
            this.f9486g = extendSysWebViewMethodResult;
            this.f9487h = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            this.f9486g.params.put(BaiduRimConstants.RETCODE_KEY, Integer.valueOf(getTplStokenResult.getResultCode()));
            this.f9486g.params.put("retMsg", getTplStokenResult.getResultMsg());
            this.f9487h.onFinish(this.f9486g);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            BiometricsManager.getInstance().recogWithBduss(this.f9480a, this.f9481b, this.f9482c, this.f9483d, this.f9484e.bduss, getTplStokenResult.tplStokenMap.get("pp"), this.f9485f);
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ShareCallPacking.ShareLoginCallBack {
        public b() {
        }

        @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
        public void onFailed(int i2, String str) {
            super.onFailed(i2, str);
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(i2);
            webAuthResult.setResultMsg(str);
            if (CoreViewRouter.this.f9466b != null) {
                CoreViewRouter.this.f9466b.onFailure(webAuthResult);
            }
            CoreViewRouter.getInstance().release();
        }

        @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
        public void onSuccess() {
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.accountType = AccountType.NORMAL;
            webAuthResult.setResultCode(0);
            if (CoreViewRouter.this.f9466b != null) {
                CoreViewRouter.this.f9466b.onSuccess(webAuthResult);
            }
            CoreViewRouter.getInstance().release();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends QrLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QrLoginCallback f9490a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f9491b;

        public c(QrLoginCallback qrLoginCallback, List list) {
            this.f9490a = qrLoginCallback;
            this.f9491b = list;
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onFinish(QrLoginResult qrLoginResult) {
            this.f9490a.onFinish(qrLoginResult);
            if (this.f9491b.size() == 1) {
                ((WebAuthResult) this.f9491b.get(0)).finishActivity();
                this.f9490a.onLocalLogin((WebAuthResult) this.f9491b.get(0));
            }
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onLocalLogin(WebAuthResult webAuthResult) {
        }
    }

    /* loaded from: classes2.dex */
    public class d extends WebAuthListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f9493a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9494b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f9495c;

        public d(List list, String str, boolean z) {
            this.f9493a = list;
            this.f9494b = str;
            this.f9495c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            this.f9493a.add(webAuthResult);
            String str = this.f9494b.indexOf("?") > 0 ? "&" : "?";
            CoreViewRouter.this.a(this.f9494b + str + "login_action_type=" + SapiUtils.getLastLoginType() + "&clientfrom=android", this.f9495c);
        }
    }

    /* loaded from: classes2.dex */
    public class e extends AuthWidgetCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f9497a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RegisterUserFaceIDCallback f9498b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceIDRegDTO f9499c;

        public e(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
            this.f9497a = activity;
            this.f9498b = registerUserFaceIDCallback;
            this.f9499c = faceIDRegDTO;
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onFailure(SapiResult sapiResult) {
            this.f9498b.onFailure(sapiResult);
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onSuccess(String str) {
            CoreViewRouter coreViewRouter = CoreViewRouter.this;
            Activity activity = this.f9497a;
            RegisterUserFaceIDCallback registerUserFaceIDCallback = this.f9498b;
            FaceIDRegDTO faceIDRegDTO = this.f9499c;
            coreViewRouter.b(activity, registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
        }
    }

    /* loaded from: classes2.dex */
    public class f extends GetTplStokenCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f9501a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FaceIDVerifyDTO f9502b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VerifyUserFaceIDCallback f9503c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RealNameFaceIDResult f9504d;

        public f(Activity activity, FaceIDVerifyDTO faceIDVerifyDTO, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
            this.f9501a = activity;
            this.f9502b = faceIDVerifyDTO;
            this.f9503c = verifyUserFaceIDCallback;
            this.f9504d = realNameFaceIDResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            this.f9504d.setResultCode(getTplStokenResult.getResultCode());
            this.f9504d.setResultMsg(getTplStokenResult.getResultMsg());
            this.f9503c.onFailure(this.f9504d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            String str = getTplStokenResult.tplStokenMap.get("pp");
            if (!TextUtils.isEmpty(str)) {
                CoreViewRouter coreViewRouter = CoreViewRouter.this;
                Activity activity = this.f9501a;
                FaceIDVerifyDTO faceIDVerifyDTO = this.f9502b;
                coreViewRouter.a(activity, faceIDVerifyDTO.subpro, (Map<String, String>) null, "0", faceIDVerifyDTO.bduss, str, faceIDVerifyDTO.businessSence, this.f9503c, this.f9504d);
                return;
            }
            this.f9504d.setResultCode(-402);
            this.f9504d.setResultMsg("服务异常，请稍后再试");
            this.f9503c.onFailure(this.f9504d);
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }
    }

    /* loaded from: classes2.dex */
    public class g extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RealNameFaceIDResult f9506a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VerifyUserFaceIDCallback f9507b;

        public g(RealNameFaceIDResult realNameFaceIDResult, VerifyUserFaceIDCallback verifyUserFaceIDCallback) {
            this.f9506a = realNameFaceIDResult;
            this.f9507b = verifyUserFaceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.f9506a.setResultCode(passFaceRecogResult.getResultCode());
            this.f9506a.setResultMsg(passFaceRecogResult.getResultMsg());
            this.f9507b.onFailure(this.f9506a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            this.f9506a.setResultCode(passFaceRecogResult.getResultCode());
            this.f9506a.setResultMsg(passFaceRecogResult.getResultMsg());
            RealNameFaceIDResult realNameFaceIDResult = this.f9506a;
            realNameFaceIDResult.authSid = passFaceRecogResult.authSid;
            realNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
            realNameFaceIDResult.setResultCode(0);
            this.f9507b.onSuccess(this.f9506a);
        }
    }

    /* loaded from: classes2.dex */
    public class h extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnRealNameFaceIDResult f9509a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9510b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceIDCallback f9511c;

        public h(UnRealNameFaceIDResult unRealNameFaceIDResult, String str, FaceIDCallback faceIDCallback) {
            this.f9509a = unRealNameFaceIDResult;
            this.f9510b = str;
            this.f9511c = faceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.f9509a.setResultCode(passFaceRecogResult.getResultCode());
            this.f9511c.onFailure(this.f9509a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            JSONObject jSONObject;
            this.f9509a.setResultMsg(passFaceRecogResult.getResultMsg());
            if (this.f9510b.equals("faceDetect") && (jSONObject = passFaceRecogResult.extraJson) != null) {
                this.f9509a.registerResult = jSONObject.toString();
            }
            UnRealNameFaceIDResult unRealNameFaceIDResult = this.f9509a;
            String str = passFaceRecogResult.callbackkey;
            unRealNameFaceIDResult.callBackKey = str;
            if (TextUtils.isEmpty(str)) {
                this.f9509a.setResultCode(-205);
                this.f9511c.onFailure(this.f9509a);
                return;
            }
            this.f9509a.setResultCode(0);
            this.f9511c.onSuccess(this.f9509a);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements SapiCallback<SapiResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f9513a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f9514b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f9515c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f9516d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f9517e;

        public i(int i2, Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
            this.f9513a = i2;
            this.f9514b = activity;
            this.f9515c = extendSysWebViewMethodCallback;
            this.f9516d = jSONObject;
            this.f9517e = extendSysWebViewMethodResult;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(SapiResult sapiResult) {
            this.f9517e.setResultCode(sapiResult.getResultCode());
            this.f9517e.setResultMsg(sapiResult.getResultMsg());
            this.f9515c.onFinish(this.f9517e);
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(SapiResult sapiResult) {
            int i2 = this.f9513a;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                    CoreViewRouter.this.a(this.f9514b, this.f9515c, this.f9516d, i2, this.f9517e);
                    return;
                case 5:
                    CoreViewRouter.this.u = this.f9515c;
                    String optString = this.f9516d.optString("url");
                    String optString2 = this.f9516d.optString("title");
                    Intent intent = new Intent(CoreViewRouter.this.z, LoadExternalWebViewActivity.class);
                    intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, optString2);
                    intent.putExtra("extra_external_url", optString);
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    CoreViewRouter.this.z.startActivity(intent);
                    return;
                case 6:
                    JSONArray optJSONArray = this.f9516d.optJSONArray("di_keys");
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        if (!TextUtils.isEmpty(optJSONArray.optString(i3))) {
                            arrayList.add(optJSONArray.optString(i3));
                        }
                    }
                    String diCookieInfo = SapiDeviceInfo.getDiCookieInfo(arrayList, false);
                    this.f9517e.params.put(BaiduRimConstants.RETCODE_KEY, "0");
                    this.f9517e.params.put("result", diCookieInfo);
                    this.f9515c.onFinish(this.f9517e);
                    return;
                default:
                    this.f9517e.params.put(BaiduRimConstants.RETCODE_KEY, "-301");
                    Map<String, Object> map = this.f9517e.params;
                    map.put("retMsg", "action :" + this.f9513a + " is not support");
                    this.f9515c.onFinish(this.f9517e);
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f9519a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f9520b;

        public j(ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            this.f9519a = extendSysWebViewMethodResult;
            this.f9520b = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f9519a;
            extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
            this.f9520b.onFinish(extendSysWebViewMethodResult);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f9519a;
            extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
            this.f9520b.onFinish(extendSysWebViewMethodResult);
        }
    }

    public static synchronized CoreViewRouter getInstance() {
        CoreViewRouter coreViewRouter;
        synchronized (CoreViewRouter.class) {
            if (A == null) {
                A = new CoreViewRouter();
            }
            coreViewRouter = A;
        }
        return coreViewRouter;
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
        return this.l;
    }

    public AccountCenterDTO getAccountCenterDTO() {
        return this.f9471g;
    }

    public AccountRealNameCallback getAccountRealNameCallback() {
        return this.m;
    }

    public AccountToolsCallback getAccountToolsCallback() {
        return this.w;
    }

    public ActivityResultCallback getActivityResultCallback() {
        return this.p;
    }

    public AuthWidgetCallback getAuthWidgetCallback() {
        return this.t;
    }

    public ExtendSysWebViewMethodCallback getExtendSysWebViewMethodCallback() {
        return this.u;
    }

    public IdCardOcrDTO getIDCardOcrDTO() {
        return this.k;
    }

    public IdCardOcrCallback getIdCardOcrCallback() {
        return this.x;
    }

    public ImageCropCallback getImageCropCallback() {
        return this.o;
    }

    public NormalizeGuestAccountCallback getNormalizeGuestAccountCallback() {
        return this.s;
    }

    public NormalizeGuestAccountDTO getNormalizeGuestAccountDTO() {
        return this.f9472h;
    }

    public OneKeyLoginCallback getOneKeyLoginCallback() {
        return this.v;
    }

    public QrLoginCallback getQrLoginCallback() {
        return this.q;
    }

    public RealNameDTO getRealNameDTO() {
        return this.f9473i;
    }

    public String getSmsLoginStatExtra() {
        return WebLoginDTO.getStatExtraDecode(this.y);
    }

    public SmsViewLoginCallback getSmsViewLoginCallback() {
        return this.r;
    }

    public WebSocialLoginDTO getSocialLoginDTO() {
        return this.f9470f;
    }

    public SwitchAccountDTO getSwitchAccountDTO() {
        return this.j;
    }

    public AbstractThirdPartyService getThirdPartyService() {
        if (this.f9465a == null) {
            a();
        }
        return this.f9465a;
    }

    public WebAuthListener getWebAuthListener() {
        return this.f9466b;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        return this.n;
    }

    public WebBindWidgetDTO getWebBindWidgetDTO() {
        return this.f9469e;
    }

    public WebLoginDTO getWebLoginDTO() {
        return this.f9467c;
    }

    public WebRegDTO getWebRegDTO() {
        return this.f9468d;
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.f9465a = thirdPartyService;
        if (thirdPartyService == null) {
            return;
        }
        thirdPartyService.handleWXLoginResp(activity, str, str2, i2);
    }

    public void invokeV2ShareLogin(Activity activity, ShareStorage.StorageModel storageModel, WebAuthListener webAuthListener, String str) {
        if (activity == null) {
            throw new IllegalArgumentException("method invokeV2ShareLogin() invokeActivity param cat't be null !");
        }
        if (storageModel == null) {
            throw new IllegalArgumentException("method invokeV2ShareLogin() param shareModel cat't be null !");
        }
        if (webAuthListener != null) {
            if (!SapiUtils.isAppInstalled(activity, storageModel.pkg)) {
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(ShareResult.ERROR_CODE_TARGET_APP_NOT_INSTALLED);
                webAuthResult.setResultMsg(ShareResult.ERROR_MSG_TARGET_APP_NOT_INSTALLED);
                webAuthListener.onFailure(webAuthResult);
            }
            this.f9466b = webAuthListener;
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            Intent intent = new Intent(activity, ShareResultProxyActivity.class);
            intent.putExtra(ShareResultProxyActivity.KEY_PKG, storageModel.pkg);
            intent.putExtra("key_url", storageModel.url);
            intent.putExtra("key_version", ShareUtils.SHARE_ACCOUNT_NEW_VERSION);
            intent.putParcelableArrayListExtra(ShareResultProxyActivity.KEY_EXTRA_PARAMS, arrayList);
            activity.startActivity(intent);
            return;
        }
        throw new IllegalArgumentException("method invokeV2ShareLogin() param webAuthListener cat't be null !");
    }

    public void loadAccountCenter(AccountCenterCallback accountCenterCallback, AccountCenterDTO accountCenterDTO) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            accountCenterDTO.bduss = currentAccount.bduss;
        }
        this.l = accountCenterCallback;
        this.f9471g = accountCenterDTO;
        Intent intent = new Intent(this.z, AccountCenterActivity.class);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        this.m = accountRealNameCallback;
        this.f9473i = realNameDTO;
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
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
    }

    public void loadAccountTools(AccountToolsDTO accountToolsDTO, AccountToolsCallback accountToolsCallback) {
        this.w = accountToolsCallback;
        Intent intent = new Intent(accountToolsDTO.context, AccountToolsActivity.class);
        intent.putExtra(AccountToolsActivity.EXTRA_ACCOUNT_TOOLS_TYPE, accountToolsDTO.toolsType);
        intent.putExtra(AccountToolsActivity.EXTRA_SWEEP_LIGHT_LOADING, accountToolsDTO.sweepLightLoading);
        Context context = accountToolsDTO.context;
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        accountToolsDTO.context.startActivity(intent);
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, WebBindWidgetDTO webBindWidgetDTO) {
        SapiAccount currentAccount;
        this.n = webBindWidgetCallback;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            webBindWidgetDTO.bduss = currentAccount.bduss;
        }
        this.f9469e = webBindWidgetDTO;
        Intent intent = new Intent(this.z, BindWidgetActivity.class);
        intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, webBindWidgetDTO.bindWidgetAction);
        intent.putExtra("EXTRA_BDUSS", webBindWidgetDTO.bduss);
        Context context = webBindWidgetDTO.context;
        if (context instanceof Activity) {
            context.startActivity(intent);
            webBindWidgetDTO.context = this.z;
            return;
        }
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
    }

    public void loadChildActivity(Context context, AccountRealNameCallback accountRealNameCallback) {
        this.m = accountRealNameCallback;
        Intent intent = new Intent(context, ChildVerifyActivity.class);
        intent.putExtra("external_url", SapiAccountManager.getInstance().getAccountService().getChildVerifyUrl());
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
    }

    public void loadIdCardOcr(IdCardOcrDTO idCardOcrDTO, IdCardOcrCallback idCardOcrCallback) {
        this.x = idCardOcrCallback;
        Intent intent = new Intent(idCardOcrDTO.context, IdCardOcrCameraActivity.class);
        intent.putExtra(IdCardOcrCameraActivity.PARAM_KEY_ID_CARD_TYPE, idCardOcrDTO.type);
        Context context = idCardOcrDTO.context;
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        idCardOcrDTO.context.startActivity(intent);
    }

    public void loadOneKeyLogin(Context context, OneKeyLoginCallback oneKeyLoginCallback) {
        loadOneKeyLogin(context, a(context, OneKeyLoginSdkCall.signFromAbilityApi), true, oneKeyLoginCallback);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        loadQrLogin(qrLoginCallback, str, null, true);
    }

    public void loadRemoteProcessWebViewActivity(Context context, String str, String str2) {
        Intent intent = new Intent(context, RemoteProcessWebviewActivity.class);
        intent.putExtra(RemoteProcessWebviewActivity.EXTRA_EXTERNAL_TITLE, str);
        intent.putExtra("external_url", str2 + "&adapter=3");
        intent.putExtra(RemoteProcessWebviewActivity.EXTRA_IS_DARK_MODE, SapiAccountManager.getInstance().getConfignation().isDarkMode);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
    }

    public void loadSwitchAccount(SwitchAccountDTO switchAccountDTO, WebAuthListener webAuthListener) {
        this.j = switchAccountDTO;
        this.f9466b = webAuthListener;
        Intent intent = new Intent(this.z, SwitchAccountActivity.class);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("eventType", "switch_account_enter");
        StatService.onEventAutoStatistic(linkedHashMap);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        this.f9470f = webSocialLoginDTO;
        webSocialLoginDTO.socialType = socialType;
        loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
    }

    public void onShareLoginActivityResult(int i2, int i3, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new PassNameValuePair("extrajson", str));
        }
        new ShareCallPacking().onLoginActivityActivityResult(new b(), i2, i3, intent, arrayList, "product");
    }

    public void registerUserFaceID(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
            startAuth(new e(activity, registerUserFaceIDCallback, faceIDRegDTO), faceIDRegDTO.authWidgetURL);
        } else {
            b(activity, registerUserFaceIDCallback, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
        }
    }

    public synchronized void release() {
        this.f9466b = null;
        this.f9467c = null;
        this.f9469e = null;
        this.f9470f = null;
        this.f9472h = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.f9471g = null;
        this.m = null;
        this.q = null;
        this.r = null;
        this.y = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.j = null;
        PassportViewManager.getInstance().release();
        A = null;
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        this.p = activityResultCallback;
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        this.o = imageCropCallback;
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        this.f9465a = abstractThirdPartyService;
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        this.t = authWidgetCallback;
        Intent intent = new Intent(this.z, AuthWidgetActivity.class);
        intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
    }

    public void startHorizontalScreenLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        webLoginDTO.screenType = 1;
        a(context, HorizontalScreenLoginActivity.class, webAuthListener, webLoginDTO);
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        startLogin(this.z, webAuthListener, webLoginDTO);
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        this.s = normalizeGuestAccountCallback;
        this.f9472h = normalizeGuestAccountDTO;
        Intent intent = new Intent(context, NormalizeGuestAccountActivity.class);
        intent.putExtra("EXTRA_BDUSS", normalizeGuestAccountDTO.bduss);
        if (!(context instanceof Activity)) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        this.f9466b = webAuthListener;
        this.f9468d = webRegDTO;
        Intent intent = new Intent(this.z, RegisterActivity.class);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
    }

    public void startSchemeLoginForQA(Context context, String str) {
        Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_url", str);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
    }

    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        this.r = smsViewLoginCallback;
        this.y = str;
        SmsLoginView.notifyStartLogin();
    }

    public void verifyUserFaceIDWithCertInfo(Activity activity, PassFaceRecogCallback passFaceRecogCallback, FaceIDVerifyCertInfoDTO faceIDVerifyCertInfoDTO) {
        BiometricsManager.getInstance().recogWithCertInfo(activity, BiometricsManager.buildSubPro("", faceIDVerifyCertInfoDTO.subpro), faceIDVerifyCertInfoDTO.transParamsList, faceIDVerifyCertInfoDTO.imageFlag, faceIDVerifyCertInfoDTO.realName, faceIDVerifyCertInfoDTO.idCardNo, null, passFaceRecogCallback);
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
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new f(activity, faceIDVerifyDTO, verifyUserFaceIDCallback, realNameFaceIDResult), faceIDVerifyDTO.bduss, arrayList);
            return;
        }
        b(activity, verifyUserFaceIDCallback, "outer", "", faceIDVerifyDTO.livingUname, faceIDVerifyDTO.showGuidePage, faceIDVerifyDTO.subpro, faceIDVerifyDTO.businessSence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5) {
        a(activity, faceIDCallback, str, str2, str3, z, str4, str5);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2) {
        loadQrLogin(qrLoginCallback, str, str2, true);
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        a(context, LoginActivity.class, webAuthListener, webLoginDTO);
    }

    public void loadOneKeyLogin(Context context, String str, OneKeyLoginCallback oneKeyLoginCallback) {
        loadOneKeyLogin(context, str, true, oneKeyLoginCallback);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2, boolean z) {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList(1);
        this.q = new c(qrLoginCallback, arrayList);
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
        } catch (JSONException unused) {
        }
        startLogin(new d(arrayList, str, z), webLoginDTO);
    }

    public void loadOneKeyLogin(final Context context, final String str, final boolean z, final OneKeyLoginCallback oneKeyLoginCallback) {
        if (oneKeyLoginCallback == null) {
            Log.e(Log.TAG, "When load oneKeyLogin, oneKeyLoginCallback can't be null!");
        } else if (TextUtils.isEmpty(str)) {
            Log.d(Log.TAG, "oneKeyLogin sign is empty!");
            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -108, null);
        } else {
            this.v = oneKeyLoginCallback;
            new OneKeyLoginSdkCall().getToken(SapiAccountManager.getInstance().getSapiConfiguration(), new OneKeyLoginSdkCall.TokenListener() { // from class: com.baidu.sapi2.CoreViewRouter.11

                /* renamed from: com.baidu.sapi2.CoreViewRouter$11$a */
                /* loaded from: classes2.dex */
                public class a implements LoadExternalWebViewActivityCallback {
                    public a() {
                    }

                    @Override // com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback
                    public void needLoadExternalWebView(String str, String str2) {
                        AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                        if (z) {
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
                            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                            CoreViewRouter.this.z.startActivity(intent);
                            return;
                        }
                        new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -111, null);
                    }
                }

                @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                public void onGetTokenComplete(JSONObject jSONObject) {
                    String optString = jSONObject.optString("token");
                    if (!TextUtils.isEmpty(optString)) {
                        SapiAccountManager.getInstance().getAccountService().loadOneKeyLogin(oneKeyLoginCallback, optString, str, new a());
                    } else {
                        new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -102, null);
                    }
                }
            });
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        this.f9466b = webAuthListener;
        this.f9470f = webSocialLoginDTO;
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.f9465a = thirdPartyService;
        if (thirdPartyService == null) {
            return;
        }
        if (webAuthListener instanceof ThirdLoginCallback) {
            ThirdLoginCallback thirdLoginCallback = (ThirdLoginCallback) webAuthListener;
            Context context = webSocialLoginDTO.context;
            if (context == null) {
                context = this.z;
            }
            thirdPartyService.loadThirdPartyLogin(context, webSocialLoginDTO.socialType, 2002, thirdLoginCallback);
        } else {
            Context context2 = webSocialLoginDTO.context;
            if (context2 == null) {
                context2 = this.z;
            }
            thirdPartyService.loadThirdPartyLogin(context2, webSocialLoginDTO.socialType, 2002);
        }
        webSocialLoginDTO.context = null;
    }

    private void a(Context context, Class<?> cls, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        StatLoadLogin statLoadLogin = new StatLoadLogin();
        SapiWebView.statLoadLogin = statLoadLogin;
        statLoadLogin.tOpenLoginPage = System.currentTimeMillis();
        this.f9466b = webAuthListener;
        this.f9467c = webLoginDTO;
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
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
    }

    public void startSchemeLoginForQA(Context context, String str, WebAuthListener webAuthListener) {
        this.f9466b = webAuthListener;
        Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_url", str);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        Intent intent = new Intent(this.z, QrLoginActivity.class);
        intent.putExtra(QrLoginActivity.EXTRA_STRING_QR_LOGIN_URL, str);
        intent.putExtra(QrLoginActivity.EXTRA_BOOLEAN_FINISH_PAGE, z);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.z.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, String str5, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
        BiometricsManager.getInstance().recogWithBduss(activity, BiometricsManager.buildSubPro(str, str5), map, str2, str3, str4, new g(realNameFaceIDResult, verifyUserFaceIDCallback));
    }

    private void a(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5) {
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
        String str;
        HashMap hashMap;
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        j jVar = new j(extendSysWebViewMethodResult, extendSysWebViewMethodCallback);
        int optInt = jSONObject.optInt("imageFlag", 0);
        String optString = TextUtils.isEmpty(jSONObject.optString("subpro")) ? "pp" : jSONObject.optString("subpro");
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
        if (i2 == 1) {
            biometricsManager.getClass();
            BiometricsManager.e eVar = new BiometricsManager.e();
            str = "";
            hashMap = hashMap2;
            a(activity, extendSysWebViewMethodCallback, eVar, extendSysWebViewMethodResult, jVar, optString, hashMap2, optInt + "");
        } else {
            str = "";
            hashMap = hashMap2;
        }
        if (i2 == 2) {
            biometricsManager.recogWithCertInfo(activity, optString, hashMap, optInt + str, jSONObject.optString("realname"), jSONObject.optString("idcardnum"), jSONObject.optString("bankmobile"), jVar);
        }
        if (i2 == 3) {
            biometricsManager.recogWithAuthToken(activity, optString, hashMap, optInt + str, jSONObject.optString("authtoken"), jVar);
        }
        if (i2 == 4) {
            if (jSONObject.optInt("type") == 1) {
                biometricsManager.recogWithFaceDetect(activity, optString, hashMap, optInt + str, jSONObject.optString("uid"), "", jVar);
                return;
            }
            biometricsManager.recogWithFaceOuter(activity, optString, hashMap, optInt + str, jSONObject.optString("uid"), jVar);
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

    private String a(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 7) {
            return null;
        }
        String substring = str.substring(0, 8);
        String substring2 = str.substring(8, str.length());
        String upperCase = SapiUtils.getClientId(context).toUpperCase();
        return substring + SecurityUtil.md5((substring2 + SecurityUtil.md5(upperCase.getBytes(), false)).getBytes(), false);
    }

    private void a() {
        try {
            Class.forName("com.baidu.sapi2.ThirdPartyService").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            Log.e(e2);
        }
    }
}
