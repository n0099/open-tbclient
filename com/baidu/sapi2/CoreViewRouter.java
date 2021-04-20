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
import com.baidu.sapi2.activity.HorizontalScreenLoginActivity;
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
import com.baidu.sapi2.callback.ImageCropCallback;
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
import com.baidu.sapi2.share.a;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.k;
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
    public static CoreViewRouter y;

    /* renamed from: a  reason: collision with root package name */
    public AbstractThirdPartyService f10095a;

    /* renamed from: b  reason: collision with root package name */
    public WebAuthListener f10096b;

    /* renamed from: c  reason: collision with root package name */
    public WebLoginDTO f10097c;

    /* renamed from: d  reason: collision with root package name */
    public WebRegDTO f10098d;

    /* renamed from: e  reason: collision with root package name */
    public WebBindWidgetDTO f10099e;

    /* renamed from: f  reason: collision with root package name */
    public WebSocialLoginDTO f10100f;

    /* renamed from: g  reason: collision with root package name */
    public AccountCenterDTO f10101g;

    /* renamed from: h  reason: collision with root package name */
    public NormalizeGuestAccountDTO f10102h;
    public RealNameDTO i;
    public SwitchAccountDTO j;
    public AccountCenterCallback k;
    public AccountRealNameCallback l;
    public WebBindWidgetCallback m;
    public ImageCropCallback n;
    public ActivityResultCallback o;
    public QrLoginCallback p;
    public SmsViewLoginCallback q;
    public NormalizeGuestAccountCallback r;
    public AuthWidgetCallback s;
    public ExtendSysWebViewMethodCallback t;
    public OneKeyLoginCallback u;
    public AccountToolsCallback v;
    public String w;
    public Context x = SapiAccountManager.getInstance().getSapiConfiguration().context;

    /* loaded from: classes2.dex */
    public class a extends GetTplStokenCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f10109a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10110b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f10111c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f10112d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SapiAccount f10113e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f10114f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f10115g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f10116h;

        public a(Activity activity, String str, Map map, String str2, SapiAccount sapiAccount, PassFaceRecogCallback passFaceRecogCallback, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            this.f10109a = activity;
            this.f10110b = str;
            this.f10111c = map;
            this.f10112d = str2;
            this.f10113e = sapiAccount;
            this.f10114f = passFaceRecogCallback;
            this.f10115g = extendSysWebViewMethodResult;
            this.f10116h = extendSysWebViewMethodCallback;
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
            this.f10115g.params.put(BaiduRimConstants.RETCODE_KEY, Integer.valueOf(getTplStokenResult.getResultCode()));
            this.f10115g.params.put("retMsg", getTplStokenResult.getResultMsg());
            this.f10116h.onFinish(this.f10115g);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            BiometricsManager.getInstance().recogWithBduss(this.f10109a, this.f10110b, this.f10111c, this.f10112d, this.f10113e.bduss, getTplStokenResult.tplStokenMap.get("pp"), this.f10114f);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a.b {
        public b() {
        }

        @Override // com.baidu.sapi2.share.a.b
        public void onFailed(int i, String str) {
            super.onFailed(i, str);
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(i);
            webAuthResult.setResultMsg(str);
            if (CoreViewRouter.this.f10096b != null) {
                CoreViewRouter.this.f10096b.onFailure(webAuthResult);
            }
            CoreViewRouter.getInstance().release();
        }

        @Override // com.baidu.sapi2.share.a.b
        public void onSuccess() {
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.accountType = AccountType.NORMAL;
            webAuthResult.setResultCode(0);
            if (CoreViewRouter.this.f10096b != null) {
                CoreViewRouter.this.f10096b.onSuccess(webAuthResult);
            }
            CoreViewRouter.getInstance().release();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends QrLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QrLoginCallback f10118a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f10119b;

        public c(QrLoginCallback qrLoginCallback, List list) {
            this.f10118a = qrLoginCallback;
            this.f10119b = list;
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onFinish(QrLoginResult qrLoginResult) {
            this.f10118a.onFinish(qrLoginResult);
            if (this.f10119b.size() == 1) {
                ((WebAuthResult) this.f10119b.get(0)).finishActivity();
                this.f10118a.onLocalLogin((WebAuthResult) this.f10119b.get(0));
            }
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onLocalLogin(WebAuthResult webAuthResult) {
        }
    }

    /* loaded from: classes2.dex */
    public class d extends WebAuthListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f10121a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10122b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f10123c;

        public d(List list, String str, boolean z) {
            this.f10121a = list;
            this.f10122b = str;
            this.f10123c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            this.f10121a.add(webAuthResult);
            String str = this.f10122b.indexOf("?") > 0 ? "&" : "?";
            CoreViewRouter.this.a(this.f10122b + str + "login_action_type=" + SapiUtils.getLastLoginType() + "&clientfrom=android", this.f10123c);
        }
    }

    /* loaded from: classes2.dex */
    public class e extends AuthWidgetCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f10125a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RegisterUserFaceIDCallback f10126b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceIDRegDTO f10127c;

        public e(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
            this.f10125a = activity;
            this.f10126b = registerUserFaceIDCallback;
            this.f10127c = faceIDRegDTO;
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onFailure(SapiResult sapiResult) {
            this.f10126b.onFailure(sapiResult);
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onSuccess(String str) {
            CoreViewRouter coreViewRouter = CoreViewRouter.this;
            Activity activity = this.f10125a;
            RegisterUserFaceIDCallback registerUserFaceIDCallback = this.f10126b;
            FaceIDRegDTO faceIDRegDTO = this.f10127c;
            coreViewRouter.b(activity, registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
        }
    }

    /* loaded from: classes2.dex */
    public class f extends GetTplStokenCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f10129a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FaceIDVerifyDTO f10130b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VerifyUserFaceIDCallback f10131c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RealNameFaceIDResult f10132d;

        public f(Activity activity, FaceIDVerifyDTO faceIDVerifyDTO, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
            this.f10129a = activity;
            this.f10130b = faceIDVerifyDTO;
            this.f10131c = verifyUserFaceIDCallback;
            this.f10132d = realNameFaceIDResult;
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
            this.f10132d.setResultCode(getTplStokenResult.getResultCode());
            this.f10132d.setResultMsg(getTplStokenResult.getResultMsg());
            this.f10131c.onFailure(this.f10132d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            String str = getTplStokenResult.tplStokenMap.get("pp");
            if (!TextUtils.isEmpty(str)) {
                CoreViewRouter coreViewRouter = CoreViewRouter.this;
                Activity activity = this.f10129a;
                FaceIDVerifyDTO faceIDVerifyDTO = this.f10130b;
                coreViewRouter.a(activity, faceIDVerifyDTO.subpro, (Map<String, String>) null, "0", faceIDVerifyDTO.bduss, str, faceIDVerifyDTO.businessSence, this.f10131c, this.f10132d);
                return;
            }
            this.f10132d.setResultCode(-402);
            this.f10132d.setResultMsg("服务异常，请稍后再试");
            this.f10131c.onFailure(this.f10132d);
        }
    }

    /* loaded from: classes2.dex */
    public class g extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RealNameFaceIDResult f10134a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VerifyUserFaceIDCallback f10135b;

        public g(RealNameFaceIDResult realNameFaceIDResult, VerifyUserFaceIDCallback verifyUserFaceIDCallback) {
            this.f10134a = realNameFaceIDResult;
            this.f10135b = verifyUserFaceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.f10134a.setResultCode(passFaceRecogResult.getResultCode());
            this.f10134a.setResultMsg(passFaceRecogResult.getResultMsg());
            this.f10135b.onFailure(this.f10134a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            this.f10134a.setResultCode(passFaceRecogResult.getResultCode());
            this.f10134a.setResultMsg(passFaceRecogResult.getResultMsg());
            RealNameFaceIDResult realNameFaceIDResult = this.f10134a;
            realNameFaceIDResult.authSid = passFaceRecogResult.authSid;
            realNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
            realNameFaceIDResult.setResultCode(0);
            this.f10135b.onSuccess(this.f10134a);
        }
    }

    /* loaded from: classes2.dex */
    public class h extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnRealNameFaceIDResult f10137a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10138b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceIDCallback f10139c;

        public h(UnRealNameFaceIDResult unRealNameFaceIDResult, String str, FaceIDCallback faceIDCallback) {
            this.f10137a = unRealNameFaceIDResult;
            this.f10138b = str;
            this.f10139c = faceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.f10137a.setResultCode(passFaceRecogResult.getResultCode());
            this.f10139c.onFailure(this.f10137a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            JSONObject jSONObject;
            this.f10137a.setResultMsg(passFaceRecogResult.getResultMsg());
            if (this.f10138b.equals("faceDetect") && (jSONObject = passFaceRecogResult.extraJson) != null) {
                this.f10137a.registerResult = jSONObject.toString();
            }
            UnRealNameFaceIDResult unRealNameFaceIDResult = this.f10137a;
            String str = passFaceRecogResult.callbackkey;
            unRealNameFaceIDResult.callBackKey = str;
            if (TextUtils.isEmpty(str)) {
                this.f10137a.setResultCode(-205);
                this.f10139c.onFailure(this.f10137a);
                return;
            }
            this.f10137a.setResultCode(0);
            this.f10139c.onSuccess(this.f10137a);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements SapiCallback<SapiResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f10141a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f10142b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f10143c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f10144d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f10145e;

        public i(int i, Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
            this.f10141a = i;
            this.f10142b = activity;
            this.f10143c = extendSysWebViewMethodCallback;
            this.f10144d = jSONObject;
            this.f10145e = extendSysWebViewMethodResult;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(SapiResult sapiResult) {
            this.f10145e.setResultCode(sapiResult.getResultCode());
            this.f10145e.setResultMsg(sapiResult.getResultMsg());
            this.f10143c.onFinish(this.f10145e);
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(SapiResult sapiResult) {
            int i = this.f10141a;
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    CoreViewRouter.this.a(this.f10142b, this.f10143c, this.f10144d, i, this.f10145e);
                    return;
                case 5:
                    CoreViewRouter.this.t = this.f10143c;
                    String optString = this.f10144d.optString("url");
                    String optString2 = this.f10144d.optString("title");
                    Intent intent = new Intent(CoreViewRouter.this.x, LoadExternalWebViewActivity.class);
                    intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, optString2);
                    intent.putExtra("extra_external_url", optString);
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    CoreViewRouter.this.x.startActivity(intent);
                    return;
                case 6:
                    JSONArray optJSONArray = this.f10144d.optJSONArray("di_keys");
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!TextUtils.isEmpty(optJSONArray.optString(i2))) {
                            arrayList.add(optJSONArray.optString(i2));
                        }
                    }
                    String diCookieInfo = SapiDeviceInfo.getDiCookieInfo(arrayList, false);
                    this.f10145e.params.put(BaiduRimConstants.RETCODE_KEY, "0");
                    this.f10145e.params.put("result", diCookieInfo);
                    this.f10143c.onFinish(this.f10145e);
                    return;
                default:
                    this.f10145e.params.put(BaiduRimConstants.RETCODE_KEY, "-301");
                    Map<String, Object> map = this.f10145e.params;
                    map.put("retMsg", "action :" + this.f10141a + " is not support");
                    this.f10143c.onFinish(this.f10145e);
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f10147a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f10148b;

        public j(ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            this.f10147a = extendSysWebViewMethodResult;
            this.f10148b = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f10147a;
            extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
            this.f10148b.onFinish(extendSysWebViewMethodResult);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f10147a;
            extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
            this.f10148b.onFinish(extendSysWebViewMethodResult);
        }
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
        return this.f10101g;
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
        return this.f10102h;
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
        return this.f10100f;
    }

    public SwitchAccountDTO getSwitchAccountDTO() {
        return this.j;
    }

    public AbstractThirdPartyService getThirdPartyService() {
        if (this.f10095a == null) {
            a();
        }
        return this.f10095a;
    }

    public WebAuthListener getWebAuthListener() {
        return this.f10096b;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        return this.m;
    }

    public WebBindWidgetDTO getWebBindWidgetDTO() {
        return this.f10099e;
    }

    public WebLoginDTO getWebLoginDTO() {
        return this.f10097c;
    }

    public WebRegDTO getWebRegDTO() {
        return this.f10098d;
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.f10095a = thirdPartyService;
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
                webAuthResult.setResultCode(com.baidu.sapi2.share.b.r);
                webAuthResult.setResultMsg(com.baidu.sapi2.share.b.i);
                webAuthListener.onFailure(webAuthResult);
            }
            this.f10096b = webAuthListener;
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            Intent intent = new Intent(activity, ShareResultProxyActivity.class);
            intent.putExtra(ShareResultProxyActivity.KEY_PKG, storageModel.pkg);
            intent.putExtra("key_url", storageModel.url);
            intent.putExtra("key_version", com.baidu.sapi2.share.d.f10968h);
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
        this.k = accountCenterCallback;
        this.f10101g = accountCenterDTO;
        Intent intent = new Intent(this.x, AccountCenterActivity.class);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
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
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.x.startActivity(intent);
    }

    public void loadAccountTools(AccountToolsDTO accountToolsDTO, AccountToolsCallback accountToolsCallback) {
        this.v = accountToolsCallback;
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
        this.m = webBindWidgetCallback;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            webBindWidgetDTO.bduss = currentAccount.bduss;
        }
        this.f10099e = webBindWidgetDTO;
        Intent intent = new Intent(this.x, BindWidgetActivity.class);
        intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, webBindWidgetDTO.bindWidgetAction);
        intent.putExtra("EXTRA_BDUSS", webBindWidgetDTO.bduss);
        Context context = webBindWidgetDTO.context;
        if (context instanceof Activity) {
            context.startActivity(intent);
            webBindWidgetDTO.context = this.x;
            return;
        }
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.x.startActivity(intent);
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
        intent.putExtra(RemoteProcessWebviewActivity.EXTRA_EXTERNAL_URL, str2 + "&adapter=3");
        intent.putExtra(RemoteProcessWebviewActivity.EXTRA_IS_DARK_MODE, SapiAccountManager.getInstance().getConfignation().isDarkMode);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.x.startActivity(intent);
    }

    public void loadSwitchAccount(SwitchAccountDTO switchAccountDTO, WebAuthListener webAuthListener) {
        this.j = switchAccountDTO;
        this.f10096b = webAuthListener;
        Intent intent = new Intent(this.x, SwitchAccountActivity.class);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.x.startActivity(intent);
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("eventType", "switch_account_enter");
        StatService.onEventAutoStatistic(linkedHashMap);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        this.f10100f = webSocialLoginDTO;
        webSocialLoginDTO.socialType = socialType;
        loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
    }

    public void onShareLoginActivityResult(int i2, int i3, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new PassNameValuePair("extrajson", str));
        }
        new com.baidu.sapi2.share.a().a(new b(), i2, i3, intent, arrayList, "product");
    }

    public void registerUserFaceID(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
            startAuth(new e(activity, registerUserFaceIDCallback, faceIDRegDTO), faceIDRegDTO.authWidgetURL);
        } else {
            b(activity, registerUserFaceIDCallback, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
        }
    }

    public synchronized void release() {
        this.f10096b = null;
        this.f10097c = null;
        this.f10099e = null;
        this.f10100f = null;
        this.f10102h = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.f10101g = null;
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
        this.f10095a = abstractThirdPartyService;
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        this.s = authWidgetCallback;
        Intent intent = new Intent(this.x, AuthWidgetActivity.class);
        intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.x.startActivity(intent);
    }

    public void startHorizontalScreenLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        webLoginDTO.screenType = 1;
        a(context, HorizontalScreenLoginActivity.class, webAuthListener, webLoginDTO);
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        startLogin(this.x, webAuthListener, webLoginDTO);
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        this.r = normalizeGuestAccountCallback;
        this.f10102h = normalizeGuestAccountDTO;
        Intent intent = new Intent(context, NormalizeGuestAccountActivity.class);
        intent.putExtra("EXTRA_BDUSS", normalizeGuestAccountDTO.bduss);
        if (!(context instanceof Activity)) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        this.f10096b = webAuthListener;
        this.f10098d = webRegDTO;
        Intent intent = new Intent(this.x, RegisterActivity.class);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
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
        this.p = new c(qrLoginCallback, arrayList);
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
            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL, null);
        } else {
            this.u = oneKeyLoginCallback;
            new OneKeyLoginSdkCall().getToken(SapiAccountManager.getInstance().getSapiConfiguration(), new OneKeyLoginSdkCall.TokenListener() { // from class: com.baidu.sapi2.CoreViewRouter.11

                /* renamed from: com.baidu.sapi2.CoreViewRouter$11$a */
                /* loaded from: classes2.dex */
                public class a implements com.baidu.sapi2.callback.a.c {
                    public a() {
                    }

                    @Override // com.baidu.sapi2.callback.a.c
                    public void a(String str, String str2) {
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
                            CoreViewRouter.this.x.startActivity(intent);
                            return;
                        }
                        new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -111, null);
                    }
                }

                @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                public void onGetTokenComplete(JSONObject jSONObject) {
                    String optString = jSONObject.optString("token");
                    if (!TextUtils.isEmpty(optString)) {
                        SapiAccountManager.getInstance().getAccountService().a(oneKeyLoginCallback, optString, str, new a());
                    } else {
                        new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL, null);
                    }
                }
            });
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        this.f10096b = webAuthListener;
        this.f10100f = webSocialLoginDTO;
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.f10095a = thirdPartyService;
        if (thirdPartyService == null) {
            return;
        }
        Context context = webSocialLoginDTO.context;
        if (context == null) {
            context = this.x;
        }
        thirdPartyService.loadThirdPartyLogin(context, webSocialLoginDTO.socialType, 2002);
        webSocialLoginDTO.context = null;
    }

    private void a(Context context, Class<?> cls, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        k kVar = new k();
        SapiWebView.statLoadLogin = kVar;
        kVar.f11106a = System.currentTimeMillis();
        this.f10096b = webAuthListener;
        this.f10097c = webLoginDTO;
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
        this.x.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        Intent intent = new Intent(this.x, QrLoginActivity.class);
        intent.putExtra(QrLoginActivity.EXTRA_STRING_QR_LOGIN_URL, str);
        intent.putExtra(QrLoginActivity.EXTRA_BOOLEAN_FINISH_PAGE, z);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.x.startActivity(intent);
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
