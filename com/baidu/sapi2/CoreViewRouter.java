package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.BaiduRimConstants;
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
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatLoadLogin;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.SmsLoginView;
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
/* loaded from: classes10.dex */
public class CoreViewRouter implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "https://wappass.baidu.com/v6/securitySettings/deviceManage?adapter=3";
    public static CoreViewRouter B;
    public transient /* synthetic */ FieldHolder $fh;
    public AbstractThirdPartyService a;

    /* renamed from: b  reason: collision with root package name */
    public WebAuthListener f37894b;

    /* renamed from: c  reason: collision with root package name */
    public WebLoginDTO f37895c;

    /* renamed from: d  reason: collision with root package name */
    public WebRegDTO f37896d;

    /* renamed from: e  reason: collision with root package name */
    public WebBindWidgetDTO f37897e;

    /* renamed from: f  reason: collision with root package name */
    public WebSocialLoginDTO f37898f;

    /* renamed from: g  reason: collision with root package name */
    public AccountCenterDTO f37899g;

    /* renamed from: h  reason: collision with root package name */
    public NormalizeGuestAccountDTO f37900h;

    /* renamed from: i  reason: collision with root package name */
    public RealNameDTO f37901i;

    /* renamed from: j  reason: collision with root package name */
    public SwitchAccountDTO f37902j;
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

    /* loaded from: classes10.dex */
    public class a extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExtendSysWebViewMethodResult a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f37907b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f37908c;

        public a(CoreViewRouter coreViewRouter, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, extendSysWebViewMethodResult, extendSysWebViewMethodCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37908c = coreViewRouter;
            this.a = extendSysWebViewMethodResult;
            this.f37907b = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.a;
                extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
                this.f37907b.onFinish(extendSysWebViewMethodResult);
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
                this.f37907b.onFinish(extendSysWebViewMethodResult);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f37909b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f37910c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f37911d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SapiAccount f37912e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f37913f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f37914g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f37915h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f37916i;

        public b(CoreViewRouter coreViewRouter, Activity activity, String str, Map map, String str2, SapiAccount sapiAccount, PassFaceRecogCallback passFaceRecogCallback, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, activity, str, map, str2, sapiAccount, passFaceRecogCallback, extendSysWebViewMethodResult, extendSysWebViewMethodCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37916i = coreViewRouter;
            this.a = activity;
            this.f37909b = str;
            this.f37910c = map;
            this.f37911d = str2;
            this.f37912e = sapiAccount;
            this.f37913f = passFaceRecogCallback;
            this.f37914g = extendSysWebViewMethodResult;
            this.f37915h = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) {
                this.f37914g.params.put(BaiduRimConstants.RETCODE_KEY, Integer.valueOf(getTplStokenResult.getResultCode()));
                this.f37914g.params.put("retMsg", getTplStokenResult.getResultMsg());
                this.f37915h.onFinish(this.f37914g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getTplStokenResult) == null) {
                BiometricsManager.getInstance().recogWithBduss(this.a, this.f37909b, this.f37910c, this.f37911d, this.f37912e.bduss, getTplStokenResult.tplStokenMap.get("pp"), this.f37913f);
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

    /* loaded from: classes10.dex */
    public class c implements LoadExternalWebViewActivityCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OneKeyLoginCallback f37917b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f37918c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f37919d;

        public c(CoreViewRouter coreViewRouter, boolean z, OneKeyLoginCallback oneKeyLoginCallback, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, Boolean.valueOf(z), oneKeyLoginCallback, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37919d = coreViewRouter;
            this.a = z;
            this.f37917b = oneKeyLoginCallback;
            this.f37918c = context;
        }

        @Override // com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback
        public void needLoadExternalWebView(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                if (this.a) {
                    this.f37919d.v = this.f37917b;
                    Intent intent = new Intent(this.f37918c, LoadExternalWebViewActivity.class);
                    intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, str);
                    String str3 = (str2 + "&adapter=3") + "&lastLoginType=oneKeyLogin";
                    if (SapiAccountManager.getInstance().getSapiConfiguration().supportFaceLogin) {
                        str3 = str3 + "&liveAbility=1";
                    }
                    intent.putExtra("extra_external_url", str3);
                    intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_FROM, "business_from_one_key_login");
                    Context context = this.f37918c;
                    if (context instanceof Activity) {
                        context.startActivity(intent);
                        return;
                    }
                    intent.setFlags(268435456);
                    this.f37919d.z.startActivity(intent);
                    return;
                }
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.f37917b, -111, null);
            }
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coreViewRouter;
        }

        @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
        public void onFailed(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                super.onFailed(i2, str);
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(i2);
                webAuthResult.setResultMsg(str);
                WebAuthListener webAuthListener = this.a.f37894b;
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
                if (this.a.f37894b != null) {
                    this.a.f37894b.onSuccess(webAuthResult);
                }
                CoreViewRouter.getInstance().release();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QrLoginCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f37920b;

        public e(CoreViewRouter coreViewRouter, QrLoginCallback qrLoginCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, qrLoginCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37920b = coreViewRouter;
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

    /* loaded from: classes10.dex */
    public class f extends QrLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QrLoginCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f37921b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f37922c;

        public f(CoreViewRouter coreViewRouter, QrLoginCallback qrLoginCallback, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, qrLoginCallback, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37922c = coreViewRouter;
            this.a = qrLoginCallback;
            this.f37921b = list;
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onFinish(QrLoginResult qrLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qrLoginResult) == null) {
                this.a.onFinish(qrLoginResult);
                if (this.f37921b.size() == 1) {
                    ((WebAuthResult) this.f37921b.get(0)).finishActivity();
                    this.a.onLocalLogin((WebAuthResult) this.f37921b.get(0));
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

    /* loaded from: classes10.dex */
    public class g extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f37923b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f37924c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f37925d;

        public g(CoreViewRouter coreViewRouter, List list, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, list, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37925d = coreViewRouter;
            this.a = list;
            this.f37923b = str;
            this.f37924c = z;
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
                String str = this.f37923b.indexOf("?") > 0 ? "&" : "?";
                this.f37925d.a(this.f37923b + str + "login_action_type=" + SapiUtils.getLastLoginType() + "&clientfrom=android", this.f37924c);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class h extends AuthWidgetCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RegisterUserFaceIDCallback f37926b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceIDRegDTO f37927c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f37928d;

        public h(CoreViewRouter coreViewRouter, Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, activity, registerUserFaceIDCallback, faceIDRegDTO};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37928d = coreViewRouter;
            this.a = activity;
            this.f37926b = registerUserFaceIDCallback;
            this.f37927c = faceIDRegDTO;
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.f37926b.onFailure(sapiResult);
            }
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                CoreViewRouter coreViewRouter = this.f37928d;
                Activity activity = this.a;
                RegisterUserFaceIDCallback registerUserFaceIDCallback = this.f37926b;
                FaceIDRegDTO faceIDRegDTO = this.f37927c;
                coreViewRouter.b(activity, registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class i extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FaceIDVerifyDTO f37929b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VerifyUserFaceIDCallback f37930c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RealNameFaceIDResult f37931d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f37932e;

        public i(CoreViewRouter coreViewRouter, Activity activity, FaceIDVerifyDTO faceIDVerifyDTO, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, activity, faceIDVerifyDTO, verifyUserFaceIDCallback, realNameFaceIDResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37932e = coreViewRouter;
            this.a = activity;
            this.f37929b = faceIDVerifyDTO;
            this.f37930c = verifyUserFaceIDCallback;
            this.f37931d = realNameFaceIDResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) {
                this.f37931d.setResultCode(getTplStokenResult.getResultCode());
                this.f37931d.setResultMsg(getTplStokenResult.getResultMsg());
                this.f37930c.onFailure(this.f37931d);
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
                    CoreViewRouter coreViewRouter = this.f37932e;
                    Activity activity = this.a;
                    FaceIDVerifyDTO faceIDVerifyDTO = this.f37929b;
                    coreViewRouter.a(activity, faceIDVerifyDTO.subpro, (Map<String, String>) null, "0", faceIDVerifyDTO.bduss, str, faceIDVerifyDTO.businessSence, this.f37930c, this.f37931d);
                    return;
                }
                this.f37931d.setResultCode(-402);
                this.f37931d.setResultMsg("服务异常，请稍后再试");
                this.f37930c.onFailure(this.f37931d);
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

    /* loaded from: classes10.dex */
    public class j extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RealNameFaceIDResult a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VerifyUserFaceIDCallback f37933b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f37934c;

        public j(CoreViewRouter coreViewRouter, RealNameFaceIDResult realNameFaceIDResult, VerifyUserFaceIDCallback verifyUserFaceIDCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, realNameFaceIDResult, verifyUserFaceIDCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37934c = coreViewRouter;
            this.a = realNameFaceIDResult;
            this.f37933b = verifyUserFaceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                this.a.setResultCode(passFaceRecogResult.getResultCode());
                this.a.setResultMsg(passFaceRecogResult.getResultMsg());
                this.f37933b.onFailure(this.a);
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
                this.f37933b.onSuccess(this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class k extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnRealNameFaceIDResult a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f37935b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceIDCallback f37936c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f37937d;

        public k(CoreViewRouter coreViewRouter, UnRealNameFaceIDResult unRealNameFaceIDResult, String str, FaceIDCallback faceIDCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, unRealNameFaceIDResult, str, faceIDCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37937d = coreViewRouter;
            this.a = unRealNameFaceIDResult;
            this.f37935b = str;
            this.f37936c = faceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                this.a.setResultCode(passFaceRecogResult.getResultCode());
                this.f37936c.onFailure(this.a);
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
                if (this.f37935b.equals("faceDetect") && (jSONObject = passFaceRecogResult.extraJson) != null) {
                    this.a.registerResult = jSONObject.toString();
                }
                UnRealNameFaceIDResult unRealNameFaceIDResult = this.a;
                String str = passFaceRecogResult.callbackkey;
                unRealNameFaceIDResult.callBackKey = str;
                if (TextUtils.isEmpty(str)) {
                    this.a.setResultCode(-205);
                    this.f37936c.onFailure(this.a);
                    return;
                }
                this.a.setResultCode(0);
                this.f37936c.onSuccess(this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class l implements SapiCallback<SapiResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f37938b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f37939c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f37940d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f37941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f37942f;

        public l(CoreViewRouter coreViewRouter, int i2, Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coreViewRouter, Integer.valueOf(i2), activity, extendSysWebViewMethodCallback, jSONObject, extendSysWebViewMethodResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37942f = coreViewRouter;
            this.a = i2;
            this.f37938b = activity;
            this.f37939c = extendSysWebViewMethodCallback;
            this.f37940d = jSONObject;
            this.f37941e = extendSysWebViewMethodResult;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.f37941e.setResultCode(sapiResult.getResultCode());
                this.f37941e.setResultMsg(sapiResult.getResultMsg());
                this.f37939c.onFinish(this.f37941e);
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
                int i2 = this.a;
                switch (i2) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        this.f37942f.a(this.f37938b, this.f37939c, this.f37940d, i2, this.f37941e);
                        return;
                    case 5:
                        this.f37942f.u = this.f37939c;
                        String optString = this.f37940d.optString("url");
                        String optString2 = this.f37940d.optString("title");
                        Intent intent = new Intent(this.f37942f.z, LoadExternalWebViewActivity.class);
                        intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, optString2);
                        intent.putExtra("extra_external_url", optString);
                        intent.setFlags(268435456);
                        this.f37942f.z.startActivity(intent);
                        return;
                    case 6:
                        JSONArray optJSONArray = this.f37940d.optJSONArray("di_keys");
                        ArrayList arrayList = new ArrayList();
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            if (!TextUtils.isEmpty(optJSONArray.optString(i3))) {
                                arrayList.add(optJSONArray.optString(i3));
                            }
                        }
                        String diCookieInfo = SapiDeviceInfo.getDiCookieInfo(arrayList, false);
                        this.f37941e.params.put(BaiduRimConstants.RETCODE_KEY, "0");
                        this.f37941e.params.put("result", diCookieInfo);
                        this.f37939c.onFinish(this.f37941e);
                        return;
                    default:
                        this.f37941e.params.put(BaiduRimConstants.RETCODE_KEY, "-301");
                        Map<String, Object> map = this.f37941e.params;
                        map.put("retMsg", "action :" + this.a + " is not support");
                        this.f37939c.onFinish(this.f37941e);
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
    }

    public AccountCenterCallback getAccountCenterCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (AccountCenterCallback) invokeV.objValue;
    }

    public AccountCenterDTO getAccountCenterDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37899g : (AccountCenterDTO) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37900h : (NormalizeGuestAccountDTO) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f37901i : (RealNameDTO) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f37898f : (WebSocialLoginDTO) invokeV.objValue;
    }

    public SwitchAccountDTO getSwitchAccountDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37902j : (SwitchAccountDTO) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f37894b : (WebAuthListener) invokeV.objValue;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.n : (WebBindWidgetCallback) invokeV.objValue;
    }

    public WebBindWidgetDTO getWebBindWidgetDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f37897e : (WebBindWidgetDTO) invokeV.objValue;
    }

    public WebLoginDTO getWebLoginDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f37895c : (WebLoginDTO) invokeV.objValue;
    }

    public WebRegDTO getWebRegDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f37896d : (WebRegDTO) invokeV.objValue;
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
                this.f37894b = webAuthListener;
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
            this.f37899g = accountCenterDTO;
            Intent intent = new Intent(this.z, AccountCenterActivity.class);
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, context, accountRealNameCallback, realNameDTO) == null) {
            this.m = accountRealNameCallback;
            this.f37901i = realNameDTO;
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
            intent.setFlags(268435456);
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
            intent.setFlags(268435456);
            accountToolsDTO.context.startActivity(intent);
        }
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, WebBindWidgetDTO webBindWidgetDTO) {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, webBindWidgetCallback, webBindWidgetDTO) == null) {
            this.n = webBindWidgetCallback;
            if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                webBindWidgetDTO.bduss = currentAccount.bduss;
            }
            this.f37897e = webBindWidgetDTO;
            Intent intent = new Intent(this.z, BindWidgetActivity.class);
            intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, webBindWidgetDTO.bindWidgetAction);
            intent.putExtra("EXTRA_BDUSS", webBindWidgetDTO.bduss);
            Context context = webBindWidgetDTO.context;
            if (context instanceof Activity) {
                context.startActivity(intent);
                webBindWidgetDTO.context = this.z;
                return;
            }
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    public void loadChildActivity(Context context, AccountRealNameCallback accountRealNameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, context, accountRealNameCallback) == null) {
            this.m = accountRealNameCallback;
            Intent intent = new Intent(context, ChildVerifyActivity.class);
            intent.putExtra("external_url", SapiAccountManager.getInstance().getAccountService().getChildVerifyUrl());
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    public void loadIdCardOcr(IdCardOcrDTO idCardOcrDTO, IdCardOcrCallback idCardOcrCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, idCardOcrDTO, idCardOcrCallback) == null) {
            this.x = idCardOcrCallback;
            Intent intent = new Intent(idCardOcrDTO.context, IdCardOcrCameraActivity.class);
            intent.putExtra(IdCardOcrCameraActivity.PARAM_KEY_ID_CARD_TYPE, idCardOcrDTO.type);
            Context context = idCardOcrDTO.context;
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            idCardOcrDTO.context.startActivity(intent);
        }
    }

    public void loadOneKeyLogin(Context context, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, context, oneKeyLoginCallback) == null) {
            loadOneKeyLogin(context, a(context, OneKeyLoginSdkCall.signFromAbilityApi), true, oneKeyLoginCallback);
        }
    }

    public void loadOneKeyLoginWithToken(Context context, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048613, this, context, str, str2, oneKeyLoginCallback) == null) {
            oneKeyLoginWithToken(context, str, a(context, str2), true, oneKeyLoginCallback);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, qrLoginCallback, str) == null) {
            loadQrLogin(qrLoginCallback, str, null, true);
        }
    }

    public void loadQrLoginWithEncuid(QrLoginCallback qrLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, qrLoginCallback, str) == null) {
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.encryptedId = SapiUtils.urlParamsToMap(str).get(SapiUtils.KEY_QR_LOGIN_ENCUID);
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
            startLogin(new e(this, qrLoginCallback), webLoginDTO);
        }
    }

    public void loadRemoteProcessWebViewActivity(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048618, this, context, str, str2) == null) {
            Intent intent = new Intent(context, RemoteProcessWebviewActivity.class);
            intent.putExtra(RemoteProcessWebviewActivity.EXTRA_EXTERNAL_TITLE, str);
            intent.putExtra("external_url", str2 + "&adapter=3");
            intent.putExtra(RemoteProcessWebviewActivity.EXTRA_IS_DARK_MODE, SapiAccountManager.getInstance().getConfignation().isDarkMode);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    public void loadSwitchAccount(SwitchAccountDTO switchAccountDTO, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, switchAccountDTO, webAuthListener) == null) {
            this.f37902j = switchAccountDTO;
            this.f37894b = webAuthListener;
            Intent intent = new Intent(this.z, SwitchAccountActivity.class);
            intent.setFlags(268435456);
            this.z.startActivity(intent);
            LinkedHashMap linkedHashMap = new LinkedHashMap(1);
            linkedHashMap.put("eventType", "switch_account_enter");
            StatService.onEventAutoStatistic(linkedHashMap);
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, webAuthListener, socialType) == null) {
            WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
            this.f37898f = webSocialLoginDTO;
            webSocialLoginDTO.socialType = socialType;
            loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
        }
    }

    public void loadYYSSOLogin(Context context, String str, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048622, this, context, str, webAuthListener) == null) {
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
            this.f37895c = webLoginDTO;
            WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
            webSocialLoginDTO.finishActivityAfterSuc = true;
            this.f37898f = webSocialLoginDTO;
            this.f37894b = webAuthListener;
            this.a.loadYYSSOLogin(context, str);
        }
    }

    public void onShareLoginActivityResult(int i2, int i3, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intent, str}) == null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            new ShareCallPacking().onLoginActivityActivityResult(new d(this), i2, i3, intent, arrayList, "product");
        }
    }

    public void oneKeyLoginWithToken(Context context, String str, String str2, boolean z, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{context, str, str2, Boolean.valueOf(z), oneKeyLoginCallback}) == null) {
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
        if (interceptable == null || interceptable.invokeLLL(1048625, this, activity, registerUserFaceIDCallback, faceIDRegDTO) == null) {
            if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
                startAuth(new h(this, activity, registerUserFaceIDCallback, faceIDRegDTO), faceIDRegDTO.authWidgetURL);
            } else {
                b(activity, registerUserFaceIDCallback, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
            }
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            synchronized (this) {
                this.f37894b = null;
                this.f37895c = null;
                this.f37897e = null;
                this.f37898f = null;
                this.f37900h = null;
                this.n = null;
                this.o = null;
                this.p = null;
                this.f37899g = null;
                this.q = null;
                this.l = null;
                this.s = null;
                this.t = null;
                this.u = null;
                this.f37902j = null;
                PassportViewManager.getInstance().release();
                B = null;
            }
        }
    }

    public void releaseAccountRealNameCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.m = null;
        }
    }

    public void releaseOneKeyLoginCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.v = null;
        }
    }

    public void releaseSmsViewLoginCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.r = null;
        }
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, activityResultCallback) == null) {
            this.p = activityResultCallback;
        }
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, imageCropCallback) == null) {
            this.o = imageCropCallback;
        }
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, abstractThirdPartyService) == null) {
            this.a = abstractThirdPartyService;
        }
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, authWidgetCallback, str) == null) {
            this.t = authWidgetCallback;
            Intent intent = new Intent(this.z, AuthWidgetActivity.class);
            intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    public void startHorizontalScreenLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048634, this, context, webAuthListener, webLoginDTO) == null) {
            webLoginDTO.screenType = 1;
            a(context, HorizontalScreenLoginActivity.class, webAuthListener, webLoginDTO);
        }
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, webAuthListener, webLoginDTO) == null) {
            startLogin(this.z, webAuthListener, webLoginDTO);
        }
    }

    public void startLoginDeviceManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, context) == null) {
            Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
            intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, "设备管理");
            intent.putExtra("extra_external_url", A);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048638, this, context, normalizeGuestAccountCallback, normalizeGuestAccountDTO) == null) {
            this.s = normalizeGuestAccountCallback;
            this.f37900h = normalizeGuestAccountDTO;
            Intent intent = new Intent(context, NormalizeGuestAccountActivity.class);
            intent.putExtra("EXTRA_BDUSS", normalizeGuestAccountDTO.bduss);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public void startOnlyPhoneAuth(AuthWidgetCallback authWidgetCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048639, this, authWidgetCallback, str, str2) == null) {
            this.t = authWidgetCallback;
            Intent intent = new Intent(this.z, AuthWidgetOnlyPhoneActivity.class);
            intent.putExtra("EXTRA_PARAM_AUTH_ID", str);
            intent.putExtra(AuthWidgetOnlyPhoneActivity.EXTRA_PARAM_SCENE, str2);
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, webAuthListener, webRegDTO) == null) {
            this.f37894b = webAuthListener;
            this.f37896d = webRegDTO;
            Intent intent = new Intent(this.z, RegisterActivity.class);
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    public void startSchemeLoginForQA(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, context, str) == null) {
            Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
            intent.putExtra("extra_external_url", str);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    @Deprecated
    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, smsViewLoginCallback, str) == null) {
            this.r = smsViewLoginCallback;
            this.y = str;
            SmsLoginView.notifyStartLogin();
        }
    }

    public void verifyUserFaceIDWithCertInfo(Activity activity, PassFaceRecogCallback passFaceRecogCallback, FaceIDVerifyCertInfoDTO faceIDVerifyCertInfoDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048645, this, activity, passFaceRecogCallback, faceIDVerifyCertInfoDTO) == null) {
            BiometricsManager.getInstance().recogWithCertInfo(activity, BiometricsManager.buildSubPro("", faceIDVerifyCertInfoDTO.subpro), faceIDVerifyCertInfoDTO.transParamsList, faceIDVerifyCertInfoDTO.imageFlag, faceIDVerifyCertInfoDTO.realName, faceIDVerifyCertInfoDTO.idCardNo, faceIDVerifyCertInfoDTO.needAuthorizeCertInfo, null, passFaceRecogCallback);
        }
    }

    public void verifyUserFaceId(Activity activity, VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048646, this, activity, verifyUserFaceIDCallback, faceIDVerifyDTO) == null) {
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
        if (interceptable == null || interceptable.invokeLLL(1048615, this, qrLoginCallback, str, str2) == null) {
            loadQrLogin(qrLoginCallback, str, str2, true);
        }
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048635, this, context, webAuthListener, webLoginDTO) == null) {
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
        if (interceptable == null || interceptable.invokeLLL(1048611, this, context, str, oneKeyLoginCallback) == null) {
            loadOneKeyLogin(context, str, true, oneKeyLoginCallback);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2, boolean z) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{qrLoginCallback, str, str2, Boolean.valueOf(z)}) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{context, str, Boolean.valueOf(z), oneKeyLoginCallback}) == null) {
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
                    public final /* synthetic */ String f37903b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ boolean f37904c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ OneKeyLoginCallback f37905d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ CoreViewRouter f37906e;

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
                        this.f37906e = this;
                        this.a = context;
                        this.f37903b = str;
                        this.f37904c = z;
                        this.f37905d = oneKeyLoginCallback;
                    }

                    @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                    public void onGetTokenComplete(JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                            this.f37906e.oneKeyLoginWithToken(this.a, jSONObject.optString("token"), this.f37903b, this.f37904c, this.f37905d);
                        }
                    }
                });
            }
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, webAuthListener, webSocialLoginDTO) == null) {
            this.f37894b = webAuthListener;
            this.f37898f = webSocialLoginDTO;
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
        if (!(interceptable == null || interceptable.invokeLLL(1048644, this, smsLoginView, smsViewLoginCallback, str) == null) || smsLoginView == null || smsViewLoginCallback == null) {
            return;
        }
        smsLoginView.setSmsViewLoginCallback(smsViewLoginCallback);
        smsLoginView.setSmsLoginStatExtra(str);
        SmsLoginView.notifyStartLogin();
    }

    public void startSchemeLoginForQA(Context context, String str, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048642, this, context, str, webAuthListener) == null) {
            this.f37894b = webAuthListener;
            Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
            intent.putExtra("extra_external_url", str);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
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
        this.f37894b = webAuthListener;
        this.f37895c = webLoginDTO;
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
        intent.setFlags(268435456);
        this.z.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65551, this, str, z) == null) {
            Intent intent = new Intent(this.z, QrLoginActivity.class);
            intent.putExtra(QrLoginActivity.EXTRA_STRING_QR_LOGIN_URL, str);
            intent.putExtra(QrLoginActivity.EXTRA_BOOLEAN_FINISH_PAGE, z);
            intent.setFlags(268435456);
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
                extendSysWebViewMethodResult.params.put(BaiduRimConstants.RETCODE_KEY, "-302");
                extendSysWebViewMethodResult.params.put("retMsg", "please login first");
                extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
                return;
            }
            eVar.f38087j = currentAccount.bduss;
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new b(this, activity, str, map, str2, currentAccount, passFaceRecogCallback, extendSysWebViewMethodResult, extendSysWebViewMethodCallback), eVar.f38087j, arrayList);
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
