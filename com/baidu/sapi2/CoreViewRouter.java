package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.sapi2.activity.YouthStyleLoginActivity;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class CoreViewRouter implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "https://wappass.baidu.com/v6/securitySettings/deviceManage?adapter=3";
    public static CoreViewRouter B;
    public transient /* synthetic */ FieldHolder $fh;
    public AbstractThirdPartyService a;

    /* renamed from: b  reason: collision with root package name */
    public WebAuthListener f28319b;

    /* renamed from: c  reason: collision with root package name */
    public WebLoginDTO f28320c;

    /* renamed from: d  reason: collision with root package name */
    public WebRegDTO f28321d;

    /* renamed from: e  reason: collision with root package name */
    public WebBindWidgetDTO f28322e;

    /* renamed from: f  reason: collision with root package name */
    public WebSocialLoginDTO f28323f;

    /* renamed from: g  reason: collision with root package name */
    public AccountCenterDTO f28324g;

    /* renamed from: h  reason: collision with root package name */
    public NormalizeGuestAccountDTO f28325h;
    public RealNameDTO i;
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
    public Context z;

    /* loaded from: classes4.dex */
    public class a extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExtendSysWebViewMethodResult a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f28330b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f28331c;

        public a(CoreViewRouter coreViewRouter, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, extendSysWebViewMethodResult, extendSysWebViewMethodCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28331c = coreViewRouter;
            this.a = extendSysWebViewMethodResult;
            this.f28330b = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.a;
                extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
                this.f28330b.onFinish(extendSysWebViewMethodResult);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogResult) == null) {
                ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.a;
                extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
                this.f28330b.onFinish(extendSysWebViewMethodResult);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f28332b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f28333c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f28334d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SapiAccount f28335e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f28336f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f28337g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f28338h;
        public final /* synthetic */ CoreViewRouter i;

        public b(CoreViewRouter coreViewRouter, Activity activity, String str, Map map, String str2, SapiAccount sapiAccount, PassFaceRecogCallback passFaceRecogCallback, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, activity, str, map, str2, sapiAccount, passFaceRecogCallback, extendSysWebViewMethodResult, extendSysWebViewMethodCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = coreViewRouter;
            this.a = activity;
            this.f28332b = str;
            this.f28333c = map;
            this.f28334d = str2;
            this.f28335e = sapiAccount;
            this.f28336f = passFaceRecogCallback;
            this.f28337g = extendSysWebViewMethodResult;
            this.f28338h = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) {
                this.f28337g.params.put("retCode", Integer.valueOf(getTplStokenResult.getResultCode()));
                this.f28337g.params.put("retMsg", getTplStokenResult.getResultMsg());
                this.f28338h.onFinish(this.f28337g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getTplStokenResult) == null) {
                BiometricsManager.getInstance().recogWithBduss(this.a, this.f28332b, this.f28333c, this.f28334d, this.f28335e.bduss, getTplStokenResult.tplStokenMap.get("pp"), this.f28336f);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements LoadExternalWebViewActivityCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OneKeyLoginCallback f28339b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f28340c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f28341d;

        public c(CoreViewRouter coreViewRouter, boolean z, OneKeyLoginCallback oneKeyLoginCallback, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, Boolean.valueOf(z), oneKeyLoginCallback, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28341d = coreViewRouter;
            this.a = z;
            this.f28339b = oneKeyLoginCallback;
            this.f28340c = context;
        }

        @Override // com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback
        public void needLoadExternalWebView(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                if (this.a) {
                    this.f28341d.v = this.f28339b;
                    Intent intent = new Intent(this.f28340c, LoadExternalWebViewActivity.class);
                    intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, str);
                    String str3 = (str2 + "&adapter=3") + "&lastLoginType=oneKeyLogin";
                    if (SapiAccountManager.getInstance().getSapiConfiguration().supportFaceLogin) {
                        str3 = str3 + "&liveAbility=1";
                    }
                    intent.putExtra("extra_external_url", str3);
                    intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_FROM, "business_from_one_key_login");
                    Context context = this.f28340c;
                    if (context instanceof Activity) {
                        context.startActivity(intent);
                        return;
                    }
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    this.f28341d.z.startActivity(intent);
                    return;
                }
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.f28339b, -111, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ShareCallPacking.ShareLoginCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoreViewRouter a;

        public d(CoreViewRouter coreViewRouter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coreViewRouter;
        }

        @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
        public void onFailed(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                super.onFailed(i, str);
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(i);
                webAuthResult.setResultMsg(str);
                WebAuthListener webAuthListener = this.a.f28319b;
                CoreViewRouter.getInstance().release();
                if (webAuthListener != null) {
                    webAuthListener.onFailure(webAuthResult);
                }
            }
        }

        @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.accountType = AccountType.NORMAL;
                webAuthResult.setResultCode(0);
                if (this.a.f28319b != null) {
                    this.a.f28319b.onSuccess(webAuthResult);
                }
                CoreViewRouter.getInstance().release();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QrLoginCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f28342b;

        public e(CoreViewRouter coreViewRouter, QrLoginCallback qrLoginCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, qrLoginCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28342b = coreViewRouter;
            this.a = qrLoginCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            QrLoginCallback qrLoginCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) || (qrLoginCallback = this.a) == null) {
                return;
            }
            qrLoginCallback.onLocalLogin(webAuthResult);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            QrLoginCallback qrLoginCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) || (qrLoginCallback = this.a) == null) {
                return;
            }
            qrLoginCallback.onLocalLogin(webAuthResult);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends QrLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QrLoginCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f28343b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f28344c;

        public f(CoreViewRouter coreViewRouter, QrLoginCallback qrLoginCallback, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, qrLoginCallback, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28344c = coreViewRouter;
            this.a = qrLoginCallback;
            this.f28343b = list;
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onFinish(QrLoginResult qrLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qrLoginResult) == null) {
                this.a.onFinish(qrLoginResult);
                if (this.f28343b.size() == 1) {
                    ((WebAuthResult) this.f28343b.get(0)).finishActivity();
                    this.a.onLocalLogin((WebAuthResult) this.f28343b.get(0));
                }
            }
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onLocalLogin(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f28345b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f28346c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f28347d;

        public g(CoreViewRouter coreViewRouter, List list, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, list, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28347d = coreViewRouter;
            this.a = list;
            this.f28345b = str;
            this.f28346c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.a.add(webAuthResult);
                String str = this.f28345b.indexOf("?") > 0 ? "&" : "?";
                this.f28347d.a(this.f28345b + str + "login_action_type=" + SapiUtils.getLastLoginType() + "&clientfrom=android", this.f28346c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends AuthWidgetCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RegisterUserFaceIDCallback f28348b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceIDRegDTO f28349c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f28350d;

        public h(CoreViewRouter coreViewRouter, Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, activity, registerUserFaceIDCallback, faceIDRegDTO};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28350d = coreViewRouter;
            this.a = activity;
            this.f28348b = registerUserFaceIDCallback;
            this.f28349c = faceIDRegDTO;
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.f28348b.onFailure(sapiResult);
            }
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                CoreViewRouter coreViewRouter = this.f28350d;
                Activity activity = this.a;
                RegisterUserFaceIDCallback registerUserFaceIDCallback = this.f28348b;
                FaceIDRegDTO faceIDRegDTO = this.f28349c;
                coreViewRouter.b(activity, registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FaceIDVerifyDTO f28351b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VerifyUserFaceIDCallback f28352c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RealNameFaceIDResult f28353d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f28354e;

        public i(CoreViewRouter coreViewRouter, Activity activity, FaceIDVerifyDTO faceIDVerifyDTO, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, activity, faceIDVerifyDTO, verifyUserFaceIDCallback, realNameFaceIDResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28354e = coreViewRouter;
            this.a = activity;
            this.f28351b = faceIDVerifyDTO;
            this.f28352c = verifyUserFaceIDCallback;
            this.f28353d = realNameFaceIDResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) {
                this.f28353d.setResultCode(getTplStokenResult.getResultCode());
                this.f28353d.setResultMsg(getTplStokenResult.getResultMsg());
                this.f28352c.onFailure(this.f28353d);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getTplStokenResult) == null) {
                String str = getTplStokenResult.tplStokenMap.get("pp");
                if (!TextUtils.isEmpty(str)) {
                    CoreViewRouter coreViewRouter = this.f28354e;
                    Activity activity = this.a;
                    FaceIDVerifyDTO faceIDVerifyDTO = this.f28351b;
                    coreViewRouter.a(activity, faceIDVerifyDTO.subpro, (Map<String, String>) null, "0", faceIDVerifyDTO.bduss, str, faceIDVerifyDTO.businessSence, this.f28352c, this.f28353d);
                    return;
                }
                this.f28353d.setResultCode(-402);
                this.f28353d.setResultMsg("服务异常，请稍后再试");
                this.f28352c.onFailure(this.f28353d);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RealNameFaceIDResult a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VerifyUserFaceIDCallback f28355b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f28356c;

        public j(CoreViewRouter coreViewRouter, RealNameFaceIDResult realNameFaceIDResult, VerifyUserFaceIDCallback verifyUserFaceIDCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, realNameFaceIDResult, verifyUserFaceIDCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28356c = coreViewRouter;
            this.a = realNameFaceIDResult;
            this.f28355b = verifyUserFaceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                this.a.setResultCode(passFaceRecogResult.getResultCode());
                this.a.setResultMsg(passFaceRecogResult.getResultMsg());
                this.f28355b.onFailure(this.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogResult) == null) {
                this.a.setResultCode(passFaceRecogResult.getResultCode());
                this.a.setResultMsg(passFaceRecogResult.getResultMsg());
                RealNameFaceIDResult realNameFaceIDResult = this.a;
                realNameFaceIDResult.authSid = passFaceRecogResult.authSid;
                realNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
                realNameFaceIDResult.setResultCode(0);
                this.f28355b.onSuccess(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnRealNameFaceIDResult a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f28357b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceIDCallback f28358c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f28359d;

        public k(CoreViewRouter coreViewRouter, UnRealNameFaceIDResult unRealNameFaceIDResult, String str, FaceIDCallback faceIDCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, unRealNameFaceIDResult, str, faceIDCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28359d = coreViewRouter;
            this.a = unRealNameFaceIDResult;
            this.f28357b = str;
            this.f28358c = faceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                this.a.setResultCode(passFaceRecogResult.getResultCode());
                this.f28358c.onFailure(this.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogResult) == null) {
                this.a.setResultMsg(passFaceRecogResult.getResultMsg());
                if (this.f28357b.equals("faceDetect") && (jSONObject = passFaceRecogResult.extraJson) != null) {
                    this.a.registerResult = jSONObject.toString();
                }
                UnRealNameFaceIDResult unRealNameFaceIDResult = this.a;
                String str = passFaceRecogResult.callbackkey;
                unRealNameFaceIDResult.callBackKey = str;
                if (TextUtils.isEmpty(str)) {
                    this.a.setResultCode(-205);
                    this.f28358c.onFailure(this.a);
                    return;
                }
                this.a.setResultCode(0);
                this.f28358c.onSuccess(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements SapiCallback<SapiResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f28360b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f28361c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f28362d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f28363e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f28364f;

        public l(CoreViewRouter coreViewRouter, int i, Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, Integer.valueOf(i), activity, extendSysWebViewMethodCallback, jSONObject, extendSysWebViewMethodResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28364f = coreViewRouter;
            this.a = i;
            this.f28360b = activity;
            this.f28361c = extendSysWebViewMethodCallback;
            this.f28362d = jSONObject;
            this.f28363e = extendSysWebViewMethodResult;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.f28363e.setResultCode(sapiResult.getResultCode());
                this.f28363e.setResultMsg(sapiResult.getResultMsg());
                this.f28361c.onFinish(this.f28363e);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sapiResult) == null) {
                int i = this.a;
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        this.f28364f.a(this.f28360b, this.f28361c, this.f28362d, i, this.f28363e);
                        return;
                    case 5:
                        this.f28364f.u = this.f28361c;
                        String optString = this.f28362d.optString("url");
                        String optString2 = this.f28362d.optString("title");
                        Intent intent = new Intent(this.f28364f.z, LoadExternalWebViewActivity.class);
                        intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, optString2);
                        intent.putExtra("extra_external_url", optString);
                        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                        this.f28364f.z.startActivity(intent);
                        return;
                    case 6:
                        JSONArray optJSONArray = this.f28362d.optJSONArray("di_keys");
                        ArrayList arrayList = new ArrayList();
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            if (!TextUtils.isEmpty(optJSONArray.optString(i2))) {
                                arrayList.add(optJSONArray.optString(i2));
                            }
                        }
                        String diCookieInfo = SapiDeviceInfo.getDiCookieInfo(arrayList, false);
                        this.f28363e.params.put("retCode", "0");
                        this.f28363e.params.put("result", diCookieInfo);
                        this.f28361c.onFinish(this.f28363e);
                        return;
                    default:
                        this.f28363e.params.put("retCode", "-301");
                        Map<String, Object> map = this.f28363e.params;
                        map.put("retMsg", "action :" + this.a + " is not support");
                        this.f28361c.onFinish(this.f28363e);
                        return;
                }
            }
        }
    }

    public CoreViewRouter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = SapiAccountManager.getInstance().getSapiConfiguration().context;
    }

    public static synchronized CoreViewRouter getInstance() {
        InterceptResult invokeV;
        CoreViewRouter coreViewRouter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            synchronized (CoreViewRouter.class) {
                if (B == null) {
                    B = new CoreViewRouter();
                }
                coreViewRouter = B;
            }
            return coreViewRouter;
        }
        return (CoreViewRouter) invokeV.objValue;
    }

    public void extendSysWebViewMethod(Activity activity, String str, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, extendSysWebViewMethodCallback) == null) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("action");
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                String optString = optJSONObject.optString("open_appid");
                String optString2 = optJSONObject.optString("open_apikey");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    SapiAccountManager.getInstance().getAccountService().extendSysWebViewMethodCheck(new l(this, optInt, activity, extendSysWebViewMethodCallback, optJSONObject, extendSysWebViewMethodResult), optString, optString2);
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
    }

    public AccountCenterCallback getAccountCenterCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (AccountCenterCallback) invokeV.objValue;
    }

    public AccountCenterDTO getAccountCenterDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28324g : (AccountCenterDTO) invokeV.objValue;
    }

    public AccountRealNameCallback getAccountRealNameCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (AccountRealNameCallback) invokeV.objValue;
    }

    public AccountToolsCallback getAccountToolsCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.w : (AccountToolsCallback) invokeV.objValue;
    }

    public ActivityResultCallback getActivityResultCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (ActivityResultCallback) invokeV.objValue;
    }

    public AuthWidgetCallback getAuthWidgetCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t : (AuthWidgetCallback) invokeV.objValue;
    }

    public ExtendSysWebViewMethodCallback getExtendSysWebViewMethodCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.u : (ExtendSysWebViewMethodCallback) invokeV.objValue;
    }

    public IdCardOcrDTO getIDCardOcrDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (IdCardOcrDTO) invokeV.objValue;
    }

    public IdCardOcrCallback getIdCardOcrCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.x : (IdCardOcrCallback) invokeV.objValue;
    }

    public ImageCropCallback getImageCropCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (ImageCropCallback) invokeV.objValue;
    }

    public NormalizeGuestAccountCallback getNormalizeGuestAccountCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.s : (NormalizeGuestAccountCallback) invokeV.objValue;
    }

    public NormalizeGuestAccountDTO getNormalizeGuestAccountDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f28325h : (NormalizeGuestAccountDTO) invokeV.objValue;
    }

    public OneKeyLoginCallback getOneKeyLoginCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.v : (OneKeyLoginCallback) invokeV.objValue;
    }

    public QrLoginCallback getQrLoginCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.q : (QrLoginCallback) invokeV.objValue;
    }

    public RealNameDTO getRealNameDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.i : (RealNameDTO) invokeV.objValue;
    }

    public String getSmsLoginStatExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public SmsViewLoginCallback getSmsViewLoginCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.r : (SmsViewLoginCallback) invokeV.objValue;
    }

    public WebSocialLoginDTO getSocialLoginDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f28323f : (WebSocialLoginDTO) invokeV.objValue;
    }

    public SwitchAccountDTO getSwitchAccountDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : (SwitchAccountDTO) invokeV.objValue;
    }

    public AbstractThirdPartyService getThirdPartyService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.a == null) {
                a();
            }
            return this.a;
        }
        return (AbstractThirdPartyService) invokeV.objValue;
    }

    public WebAuthListener getWebAuthListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f28319b : (WebAuthListener) invokeV.objValue;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.n : (WebBindWidgetCallback) invokeV.objValue;
    }

    public WebBindWidgetDTO getWebBindWidgetDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f28322e : (WebBindWidgetDTO) invokeV.objValue;
    }

    public WebLoginDTO getWebLoginDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f28320c : (WebLoginDTO) invokeV.objValue;
    }

    public WebRegDTO getWebRegDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f28321d : (WebRegDTO) invokeV.objValue;
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048602, this, activity, str, str2, i2) == null) {
            AbstractThirdPartyService thirdPartyService = getThirdPartyService();
            this.a = thirdPartyService;
            if (thirdPartyService == null) {
                return;
            }
            thirdPartyService.handleWXLoginResp(activity, str, str2, i2);
        }
    }

    public void invokeV2ShareLogin(Activity activity, ShareStorage.StorageModel storageModel, WebAuthListener webAuthListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048603, this, activity, storageModel, webAuthListener, str) == null) {
            if (activity == null) {
                throw new IllegalArgumentException("method invokeV2ShareLogin() invokeActivity param cat't be null !");
            }
            if (storageModel == null) {
                throw new IllegalArgumentException("method invokeV2ShareLogin() param shareModel cat't be null !");
            }
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
                this.f28319b = webAuthListener;
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
    }

    public void loadAccountCenter(AccountCenterCallback accountCenterCallback, AccountCenterDTO accountCenterDTO) {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, accountCenterCallback, accountCenterDTO) == null) {
            if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                accountCenterDTO.bduss = currentAccount.bduss;
            }
            this.l = accountCenterCallback;
            this.f28324g = accountCenterDTO;
            Intent intent = new Intent(this.z, AccountCenterActivity.class);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, context, accountRealNameCallback, realNameDTO) == null) {
            this.m = accountRealNameCallback;
            this.i = realNameDTO;
            Intent intent = new Intent(context, AccountRealNameActivity.class);
            if (realNameDTO != null) {
                intent.putExtra("EXTRA_BDUSS", realNameDTO.bduss);
                intent.putExtra(AccountRealNameActivity.EXTRA_SCENE, realNameDTO.scene);
                intent.putExtra(AccountRealNameActivity.EXTRA_NEED_CB_KEY, realNameDTO.needCbKey);
                intent.putExtra(AccountRealNameActivity.EXTRA_CUSTOM_LINK, realNameDTO.customRealNameUrl);
                intent.putExtra(AccountRealNameActivity.EXTRA_REAL_NAME_LEVEL, realNameDTO.realNameLevel);
            }
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    public void loadAccountTools(AccountToolsDTO accountToolsDTO, AccountToolsCallback accountToolsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, accountToolsDTO, accountToolsCallback) == null) {
            this.w = accountToolsCallback;
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
    }

    public void loadBindInfo(Context context, BindInfoAction bindInfoAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, context, bindInfoAction) == null) {
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
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, WebBindWidgetDTO webBindWidgetDTO) {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, webBindWidgetCallback, webBindWidgetDTO) == null) {
            this.n = webBindWidgetCallback;
            if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                webBindWidgetDTO.bduss = currentAccount.bduss;
            }
            this.f28322e = webBindWidgetDTO;
            Intent intent = new Intent(this.z, BindWidgetActivity.class);
            intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, webBindWidgetDTO.bindWidgetAction);
            intent.putExtra("EXTRA_BDUSS", webBindWidgetDTO.bduss);
            Context context = webBindWidgetDTO.context;
            if (context instanceof Activity) {
                context.startActivity(intent);
                webBindWidgetDTO.context = this.z;
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    public void loadChildActivity(Context context, AccountRealNameCallback accountRealNameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, context, accountRealNameCallback) == null) {
            this.m = accountRealNameCallback;
            Intent intent = new Intent(context, ChildVerifyActivity.class);
            intent.putExtra("external_url", SapiAccountManager.getInstance().getAccountService().getChildVerifyUrl());
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    public void loadIdCardOcr(IdCardOcrDTO idCardOcrDTO, IdCardOcrCallback idCardOcrCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, idCardOcrDTO, idCardOcrCallback) == null) {
            this.x = idCardOcrCallback;
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
    }

    public void loadOneKeyLogin(Context context, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, context, oneKeyLoginCallback) == null) {
            loadOneKeyLogin(context, a(context, OneKeyLoginSdkCall.signFromAbilityApi), true, oneKeyLoginCallback);
        }
    }

    public void loadOneKeyLoginWithToken(Context context, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048614, this, context, str, str2, oneKeyLoginCallback) == null) {
            oneKeyLoginWithToken(context, str, a(context, str2), true, oneKeyLoginCallback);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, qrLoginCallback, str) == null) {
            loadQrLogin(qrLoginCallback, str, null, true);
        }
    }

    public void loadQrLoginWithEncuid(QrLoginCallback qrLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, qrLoginCallback, str) == null) {
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.encryptedId = SapiUtils.urlParamsToMap(str).get(SapiUtils.KEY_QR_LOGIN_ENCUID);
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
            startLogin(new e(this, qrLoginCallback), webLoginDTO);
        }
    }

    public void loadRemoteProcessWebViewActivity(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048619, this, context, str, str2) == null) {
            Intent intent = new Intent(context, RemoteProcessWebviewActivity.class);
            intent.putExtra(RemoteProcessWebviewActivity.EXTRA_EXTERNAL_TITLE, str);
            intent.putExtra("external_url", str2 + "&adapter=3");
            intent.putExtra(RemoteProcessWebviewActivity.EXTRA_IS_DARK_MODE, SapiAccountManager.getInstance().getConfignation().isDarkMode);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    public void loadSwitchAccount(SwitchAccountDTO switchAccountDTO, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, switchAccountDTO, webAuthListener) == null) {
            this.j = switchAccountDTO;
            this.f28319b = webAuthListener;
            Intent intent = new Intent(this.z, SwitchAccountActivity.class);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
            LinkedHashMap linkedHashMap = new LinkedHashMap(1);
            linkedHashMap.put("eventType", "switch_account_enter");
            StatService.onEventAutoStatistic(linkedHashMap);
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, webAuthListener, socialType) == null) {
            WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
            this.f28323f = webSocialLoginDTO;
            webSocialLoginDTO.socialType = socialType;
            loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
        }
    }

    public void loadYYSSOLogin(Context context, String str, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048623, this, context, str, webAuthListener) == null) {
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
            this.f28320c = webLoginDTO;
            WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
            webSocialLoginDTO.finishActivityAfterSuc = true;
            this.f28323f = webSocialLoginDTO;
            this.f28319b = webAuthListener;
            this.a.loadYYSSOLogin(context, str);
        }
    }

    public void onShareLoginActivityResult(int i2, int i3, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intent, str}) == null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            new ShareCallPacking().onLoginActivityActivityResult(new d(this), i2, i3, intent, arrayList, "product");
        }
    }

    public void oneKeyLoginWithToken(Context context, String str, String str2, boolean z, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{context, str, str2, Boolean.valueOf(z), oneKeyLoginCallback}) == null) {
            if (TextUtils.isEmpty(str2)) {
                Log.d(Log.TAG, "oneKeyLogin sign is empty!");
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -108, null);
            } else if (!TextUtils.isEmpty(str)) {
                SapiAccountManager.getInstance().getAccountService().loadOneKeyLogin(oneKeyLoginCallback, str, str2, new c(this, z, oneKeyLoginCallback, context));
            } else {
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -102, null);
            }
        }
    }

    public void registerUserFaceID(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048626, this, activity, registerUserFaceIDCallback, faceIDRegDTO) == null) {
            if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
                startAuth(new h(this, activity, registerUserFaceIDCallback, faceIDRegDTO), faceIDRegDTO.authWidgetURL);
            } else {
                b(activity, registerUserFaceIDCallback, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
            }
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            synchronized (this) {
                this.f28319b = null;
                this.f28320c = null;
                this.f28322e = null;
                this.f28323f = null;
                this.f28325h = null;
                this.n = null;
                this.o = null;
                this.p = null;
                this.f28324g = null;
                this.q = null;
                this.l = null;
                this.s = null;
                this.t = null;
                this.u = null;
                this.j = null;
                PassportViewManager.getInstance().release();
                B = null;
            }
        }
    }

    public void releaseAccountRealNameCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.m = null;
        }
    }

    public void releaseOneKeyLoginCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.v = null;
        }
    }

    public void releaseSmsViewLoginCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.r = null;
        }
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, activityResultCallback) == null) {
            this.p = activityResultCallback;
        }
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, imageCropCallback) == null) {
            this.o = imageCropCallback;
        }
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, abstractThirdPartyService) == null) {
            this.a = abstractThirdPartyService;
        }
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, authWidgetCallback, str) == null) {
            this.t = authWidgetCallback;
            Intent intent = new Intent(this.z, AuthWidgetActivity.class);
            intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    public void startHorizontalScreenLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048635, this, context, webAuthListener, webLoginDTO) == null) {
            webLoginDTO.screenType = 1;
            a(context, HorizontalScreenLoginActivity.class, webAuthListener, webLoginDTO);
        }
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, webAuthListener, webLoginDTO) == null) {
            startLogin(this.z, webAuthListener, webLoginDTO);
        }
    }

    public void startLoginDeviceManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, context) == null) {
            Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
            intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, "设备管理");
            intent.putExtra("extra_external_url", A);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048639, this, context, normalizeGuestAccountCallback, normalizeGuestAccountDTO) == null) {
            this.s = normalizeGuestAccountCallback;
            this.f28325h = normalizeGuestAccountDTO;
            Intent intent = new Intent(context, NormalizeGuestAccountActivity.class);
            intent.putExtra("EXTRA_BDUSS", normalizeGuestAccountDTO.bduss);
            if (!(context instanceof Activity)) {
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    @Deprecated
    public void startOnlyPhoneAuth(AuthWidgetCallback authWidgetCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048640, this, authWidgetCallback, str, str2) == null) {
            this.t = authWidgetCallback;
            Intent intent = new Intent(this.z, AuthWidgetOnlyPhoneActivity.class);
            intent.putExtra("EXTRA_PARAM_AUTH_ID", str);
            intent.putExtra(AuthWidgetOnlyPhoneActivity.EXTRA_PARAM_SCENE, str2);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, webAuthListener, webRegDTO) == null) {
            this.f28319b = webAuthListener;
            this.f28321d = webRegDTO;
            Intent intent = new Intent(this.z, RegisterActivity.class);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    public void startSchemeLoginForQA(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, context, str) == null) {
            Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
            intent.putExtra("extra_external_url", str);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    @Deprecated
    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048644, this, smsViewLoginCallback, str) == null) {
            this.r = smsViewLoginCallback;
            this.y = str;
            SmsLoginView.notifyStartLogin();
        }
    }

    public void startSpeciallyAuthWidget(AuthWidgetCallback authWidgetCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048646, this, authWidgetCallback, str, str2) == null) {
            this.t = authWidgetCallback;
            Intent intent = new Intent(this.z, AuthWidgetOnlyPhoneActivity.class);
            intent.putExtra("EXTRA_PARAM_AUTH_ID", str);
            intent.putExtra(AuthWidgetOnlyPhoneActivity.EXTRA_PARAM_SCENE, str2);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    public void verifyUserFaceIDWithCertInfo(Activity activity, PassFaceRecogCallback passFaceRecogCallback, FaceIDVerifyCertInfoDTO faceIDVerifyCertInfoDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048647, this, activity, passFaceRecogCallback, faceIDVerifyCertInfoDTO) == null) {
            BiometricsManager.getInstance().recogWithCertInfo(activity, BiometricsManager.buildSubPro("", faceIDVerifyCertInfoDTO.subpro), faceIDVerifyCertInfoDTO.transParamsList, faceIDVerifyCertInfoDTO.imageFlag, faceIDVerifyCertInfoDTO.realName, faceIDVerifyCertInfoDTO.idCardNo, faceIDVerifyCertInfoDTO.needAuthorizeCertInfo, null, passFaceRecogCallback);
        }
    }

    public void verifyUserFaceId(Activity activity, VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048648, this, activity, verifyUserFaceIDCallback, faceIDVerifyDTO) == null) {
            if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                faceIDVerifyDTO.bduss = currentAccount.bduss;
                faceIDVerifyDTO.uid = currentAccount.uid;
            }
            if (TextUtils.isEmpty(faceIDVerifyDTO.livingUname)) {
                RealNameFaceIDResult realNameFaceIDResult = new RealNameFaceIDResult();
                ArrayList arrayList = new ArrayList();
                arrayList.add("pp");
                SapiAccountManager.getInstance().getAccountService().getTplStoken(new i(this, activity, faceIDVerifyDTO, verifyUserFaceIDCallback, realNameFaceIDResult), faceIDVerifyDTO.bduss, arrayList);
                return;
            }
            b(activity, verifyUserFaceIDCallback, "outer", "", faceIDVerifyDTO.livingUname, faceIDVerifyDTO.showGuidePage, faceIDVerifyDTO.subpro, faceIDVerifyDTO.businessSence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{activity, faceIDCallback, str, str2, str3, Boolean.valueOf(z), str4, str5}) == null) {
            a(activity, faceIDCallback, str, str2, str3, z, str4, str5);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048616, this, qrLoginCallback, str, str2) == null) {
            loadQrLogin(qrLoginCallback, str, str2, true);
        }
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048636, this, context, webAuthListener, webLoginDTO) == null) {
            if (webLoginDTO != null && webLoginDTO.isWithYouthStyle) {
                cls = YouthStyleLoginActivity.class;
            } else {
                cls = LoginActivity.class;
            }
            a(context, cls, webAuthListener, webLoginDTO);
        }
    }

    public void loadOneKeyLogin(Context context, String str, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, context, str, oneKeyLoginCallback) == null) {
            loadOneKeyLogin(context, str, true, oneKeyLoginCallback);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2, boolean z) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{qrLoginCallback, str, str2, Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList(1);
            this.q = new f(this, qrLoginCallback, arrayList);
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
            startLogin(new g(this, arrayList, str, z), webLoginDTO);
        }
    }

    public void loadOneKeyLogin(Context context, String str, boolean z, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{context, str, Boolean.valueOf(z), oneKeyLoginCallback}) == null) {
            if (oneKeyLoginCallback == null) {
                Log.e(Log.TAG, "When load oneKeyLogin, oneKeyLoginCallback can't be null!");
            } else if (TextUtils.isEmpty(str)) {
                Log.d(Log.TAG, "oneKeyLogin sign is empty!");
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -108, null);
            } else {
                new OneKeyLoginSdkCall().getToken(SapiAccountManager.getInstance().getSapiConfiguration(), new OneKeyLoginSdkCall.TokenListener(this, context, str, z, oneKeyLoginCallback) { // from class: com.baidu.sapi2.CoreViewRouter.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f28326b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ boolean f28327c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ OneKeyLoginCallback f28328d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ CoreViewRouter f28329e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, Boolean.valueOf(z), oneKeyLoginCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f28329e = this;
                        this.a = context;
                        this.f28326b = str;
                        this.f28327c = z;
                        this.f28328d = oneKeyLoginCallback;
                    }

                    @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                    public void onGetTokenComplete(JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                            this.f28329e.oneKeyLoginWithToken(this.a, jSONObject.optString("token"), this.f28326b, this.f28327c, this.f28328d);
                        }
                    }
                });
            }
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, webAuthListener, webSocialLoginDTO) == null) {
            this.f28319b = webAuthListener;
            this.f28323f = webSocialLoginDTO;
            AbstractThirdPartyService thirdPartyService = getThirdPartyService();
            this.a = thirdPartyService;
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
    }

    public void startSmsViewLogin(SmsLoginView smsLoginView, SmsViewLoginCallback smsViewLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048645, this, smsLoginView, smsViewLoginCallback, str) == null) || smsLoginView == null || smsViewLoginCallback == null) {
            return;
        }
        smsLoginView.setSmsViewLoginCallback(smsViewLoginCallback);
        smsLoginView.setSmsLoginStatExtra(str);
        SmsLoginView.notifyStartLogin();
    }

    public void startSchemeLoginForQA(Context context, String str, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048643, this, context, str, webAuthListener) == null) {
            this.f28319b = webAuthListener;
            Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
            intent.putExtra("extra_external_url", str);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    private void a(Context context, Class<?> cls, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65546, this, context, cls, webAuthListener, webLoginDTO) == null) || context == null) {
            return;
        }
        StatLoadLogin statLoadLogin = new StatLoadLogin();
        SapiWebView.statLoadLogin = statLoadLogin;
        statLoadLogin.tOpenLoginPage = System.currentTimeMillis();
        this.f28319b = webAuthListener;
        this.f28320c = webLoginDTO;
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
        this.z.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65551, this, str, z) == null) {
            Intent intent = new Intent(this.z, QrLoginActivity.class);
            intent.putExtra(QrLoginActivity.EXTRA_STRING_QR_LOGIN_URL, str);
            intent.putExtra(QrLoginActivity.EXTRA_BOOLEAN_FINISH_PAGE, z);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.z.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, String str5, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{activity, str, map, str2, str3, str4, str5, verifyUserFaceIDCallback, realNameFaceIDResult}) == null) {
            BiometricsManager.getInstance().recogWithBduss(activity, BiometricsManager.buildSubPro(str, str5), map, str2, str3, str4, new j(this, realNameFaceIDResult, verifyUserFaceIDCallback));
        }
    }

    private void a(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{activity, faceIDCallback, str, str2, str3, Boolean.valueOf(z), str4, str5}) == null) {
            if (!TextUtils.isEmpty(str5)) {
                BiometricsManager biometricsManager = BiometricsManager.getInstance();
                String buildSubPro = BiometricsManager.buildSubPro(str4, str5);
                HashMap hashMap = new HashMap();
                k kVar = new k(this, new UnRealNameFaceIDResult(), str, faceIDCallback);
                if (str.equals("faceDetect")) {
                    biometricsManager.recogWithFaceDetect(activity, buildSubPro, hashMap, "0", str3, str2, kVar);
                    return;
                } else if (str.equals("outer")) {
                    biometricsManager.recogWithFaceOuter(activity, buildSubPro, hashMap, "0", str3, kVar);
                    return;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("scene can't be empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, int i2, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
        String str;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{activity, extendSysWebViewMethodCallback, jSONObject, Integer.valueOf(i2), extendSysWebViewMethodResult}) == null) {
            BiometricsManager biometricsManager = BiometricsManager.getInstance();
            a aVar = new a(this, extendSysWebViewMethodResult, extendSysWebViewMethodCallback);
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
                BiometricsManager.e eVar = new BiometricsManager.e(biometricsManager);
                str = "";
                a(activity, extendSysWebViewMethodCallback, eVar, extendSysWebViewMethodResult, aVar, optString, hashMap2, optInt + "");
            } else {
                str = "";
            }
            if (i2 == 2) {
                hashMap = hashMap2;
                biometricsManager.recogWithCertInfo(activity, optString, hashMap2, optInt + str, jSONObject.optString("realname"), jSONObject.optString("idcardnum"), false, jSONObject.optString("bankmobile"), aVar);
            } else {
                hashMap = hashMap2;
            }
            if (i2 == 3) {
                biometricsManager.recogWithAuthToken(activity, optString, hashMap, optInt + str, jSONObject.optString("authtoken"), aVar);
            }
            if (i2 == 4) {
                if (jSONObject.optInt("type") == 1) {
                    biometricsManager.recogWithFaceDetect(activity, optString, hashMap, optInt + str, jSONObject.optString("uid"), "", aVar);
                    return;
                }
                biometricsManager.recogWithFaceOuter(activity, optString, hashMap, optInt + str, jSONObject.optString("uid"), aVar);
            }
        }
    }

    private void a(Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, BiometricsManager.e eVar, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, PassFaceRecogCallback passFaceRecogCallback, String str, Map<String, String> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{activity, extendSysWebViewMethodCallback, eVar, extendSysWebViewMethodResult, passFaceRecogCallback, str, map, str2}) == null) {
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
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new b(this, activity, str, map, str2, currentAccount, passFaceRecogCallback, extendSysWebViewMethodResult, extendSysWebViewMethodCallback), eVar.j, arrayList);
        }
    }

    private String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str)) == null) {
            if (TextUtils.isEmpty(str) || str.length() <= 7) {
                return null;
            }
            String substring = str.substring(0, 8);
            String substring2 = str.substring(8, str.length());
            String upperCase = SapiUtils.getClientId(context).toUpperCase();
            return substring + SecurityUtil.md5((substring2 + SecurityUtil.md5(upperCase.getBytes(), false)).getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            try {
                Class.forName("com.baidu.sapi2.ThirdPartyService").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
    }
}
