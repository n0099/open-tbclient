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
import com.baidu.sapi2.activity.CertGuardianActivity;
import com.baidu.sapi2.activity.ChildVerifyActivity;
import com.baidu.sapi2.activity.CurrentProcessWebviewActivity;
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
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes2.dex */
public class CoreViewRouter implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String C = "https://wappass.baidu.com/v6/securitySettings/deviceManage?adapter=3";
    public static CoreViewRouter D;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public Context B;
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
    public AccountCenterCallback m;
    public AccountRealNameCallback n;
    public WebBindWidgetCallback o;
    public ImageCropCallback p;
    public ActivityResultCallback q;
    public QrLoginCallback r;
    public SmsViewLoginCallback s;
    public NormalizeGuestAccountCallback t;
    public AuthWidgetCallback u;
    public ExtendSysWebViewMethodCallback v;
    public OneKeyLoginCallback w;
    public AccountToolsCallback x;
    public IdCardOcrCallback y;
    public CertGuardianCallback z;

    /* loaded from: classes2.dex */
    public class a extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExtendSysWebViewMethodResult a;
        public final /* synthetic */ ExtendSysWebViewMethodCallback b;
        public final /* synthetic */ CoreViewRouter c;

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
            this.c = coreViewRouter;
            this.a = extendSysWebViewMethodResult;
            this.b = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.a;
                extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
                this.b.onFinish(extendSysWebViewMethodResult);
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
                this.b.onFinish(extendSysWebViewMethodResult);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ String d;
        public final /* synthetic */ SapiAccount e;
        public final /* synthetic */ PassFaceRecogCallback f;
        public final /* synthetic */ ExtendSysWebViewMethodResult g;
        public final /* synthetic */ ExtendSysWebViewMethodCallback h;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) {
                this.g.params.put("retCode", Integer.valueOf(getTplStokenResult.getResultCode()));
                this.g.params.put("retMsg", getTplStokenResult.getResultMsg());
                this.h.onFinish(this.g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getTplStokenResult) == null) {
                BiometricsManager.getInstance().recogWithBduss(this.a, this.b, this.c, this.d, this.e.bduss, getTplStokenResult.tplStokenMap.get("pp"), this.f);
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

    /* loaded from: classes2.dex */
    public class c implements LoadExternalWebViewActivityCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ OneKeyLoginCallback b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ CoreViewRouter d;

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
            this.d = coreViewRouter;
            this.a = z;
            this.b = oneKeyLoginCallback;
            this.c = context;
        }

        @Override // com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback
        public void needLoadExternalWebView(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                if (this.a) {
                    this.d.w = this.b;
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
                    this.d.B.startActivity(intent);
                    return;
                }
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.b, -111, null);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                WebAuthListener webAuthListener = this.a.b;
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
                if (this.a.b != null) {
                    this.a.b.onSuccess(webAuthResult);
                }
                CoreViewRouter.getInstance().release();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QrLoginCallback a;
        public final /* synthetic */ CoreViewRouter b;

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
            this.b = coreViewRouter;
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

    /* loaded from: classes2.dex */
    public class f extends QrLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QrLoginCallback a;
        public final /* synthetic */ List b;
        public final /* synthetic */ CoreViewRouter c;

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
            this.c = coreViewRouter;
            this.a = qrLoginCallback;
            this.b = list;
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onFinish(QrLoginResult qrLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qrLoginResult) == null) {
                this.a.onFinish(qrLoginResult);
                if (this.b.size() == 1) {
                    ((WebAuthResult) this.b.get(0)).finishActivity();
                    this.a.onLocalLogin((WebAuthResult) this.b.get(0));
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

    /* loaded from: classes2.dex */
    public class g extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ CoreViewRouter d;

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
            this.d = coreViewRouter;
            this.a = list;
            this.b = str;
            this.c = z;
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
                String str = this.b.indexOf("?") > 0 ? "&" : "?";
                this.d.a(this.b + str + "login_action_type=" + SapiUtils.getLastLoginType() + "&clientfrom=android", this.c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends AuthWidgetCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ RegisterUserFaceIDCallback b;
        public final /* synthetic */ FaceIDRegDTO c;
        public final /* synthetic */ CoreViewRouter d;

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
            this.d = coreViewRouter;
            this.a = activity;
            this.b = registerUserFaceIDCallback;
            this.c = faceIDRegDTO;
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.b.onFailure(sapiResult);
            }
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                CoreViewRouter coreViewRouter = this.d;
                Activity activity = this.a;
                RegisterUserFaceIDCallback registerUserFaceIDCallback = this.b;
                FaceIDRegDTO faceIDRegDTO = this.c;
                coreViewRouter.b(activity, registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence, faceIDRegDTO.isCurrentProcessShowAgreement);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ FaceIDVerifyDTO b;
        public final /* synthetic */ VerifyUserFaceIDCallback c;
        public final /* synthetic */ RealNameFaceIDResult d;
        public final /* synthetic */ CoreViewRouter e;

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
            this.e = coreViewRouter;
            this.a = activity;
            this.b = faceIDVerifyDTO;
            this.c = verifyUserFaceIDCallback;
            this.d = realNameFaceIDResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) {
                this.d.setResultCode(getTplStokenResult.getResultCode());
                this.d.setResultMsg(getTplStokenResult.getResultMsg());
                this.c.onFailure(this.d);
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
                    CoreViewRouter coreViewRouter = this.e;
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

    /* loaded from: classes2.dex */
    public class j extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RealNameFaceIDResult a;
        public final /* synthetic */ VerifyUserFaceIDCallback b;
        public final /* synthetic */ CoreViewRouter c;

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
            this.c = coreViewRouter;
            this.a = realNameFaceIDResult;
            this.b = verifyUserFaceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                this.a.setResultCode(passFaceRecogResult.getResultCode());
                this.a.setResultMsg(passFaceRecogResult.getResultMsg());
                this.b.onFailure(this.a);
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
                this.b.onSuccess(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnRealNameFaceIDResult a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FaceIDCallback c;
        public final /* synthetic */ CoreViewRouter d;

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
            this.d = coreViewRouter;
            this.a = unRealNameFaceIDResult;
            this.b = str;
            this.c = faceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                this.a.setResultCode(passFaceRecogResult.getResultCode());
                this.c.onFailure(this.a);
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
    }

    /* loaded from: classes2.dex */
    public class l implements SapiCallback<SapiResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ ExtendSysWebViewMethodCallback c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ ExtendSysWebViewMethodResult e;
        public final /* synthetic */ CoreViewRouter f;

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
            this.f = coreViewRouter;
            this.a = i;
            this.b = activity;
            this.c = extendSysWebViewMethodCallback;
            this.d = jSONObject;
            this.e = extendSysWebViewMethodResult;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.e.setResultCode(sapiResult.getResultCode());
                this.e.setResultMsg(sapiResult.getResultMsg());
                this.c.onFinish(this.e);
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
                        this.f.a(this.b, this.c, this.d, i, this.e);
                        return;
                    case 5:
                        this.f.v = this.c;
                        String optString = this.d.optString("url");
                        String optString2 = this.d.optString("title");
                        Intent intent = new Intent(this.f.B, LoadExternalWebViewActivity.class);
                        intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, optString2);
                        intent.putExtra("extra_external_url", optString);
                        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                        this.f.B.startActivity(intent);
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
                        this.e.params.put(TiebaStatic.LogFields.RESULT, diCookieInfo);
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
        this.B = SapiAccountManager.getInstance().getSapiConfiguration().context;
    }

    public static synchronized CoreViewRouter getInstance() {
        InterceptResult invokeV;
        CoreViewRouter coreViewRouter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            synchronized (CoreViewRouter.class) {
                if (D == null) {
                    D = new CoreViewRouter();
                }
                coreViewRouter = D;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (AccountCenterCallback) invokeV.objValue;
    }

    public AccountCenterDTO getAccountCenterDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (AccountCenterDTO) invokeV.objValue;
    }

    public AccountRealNameCallback getAccountRealNameCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : (AccountRealNameCallback) invokeV.objValue;
    }

    public AccountToolsCallback getAccountToolsCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.x : (AccountToolsCallback) invokeV.objValue;
    }

    public ActivityResultCallback getActivityResultCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : (ActivityResultCallback) invokeV.objValue;
    }

    public AuthWidgetCallback getAuthWidgetCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.u : (AuthWidgetCallback) invokeV.objValue;
    }

    public CertGuardianCallback getCertGuardianCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.z : (CertGuardianCallback) invokeV.objValue;
    }

    public CertGuardionDTO getCertGuardionDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : (CertGuardionDTO) invokeV.objValue;
    }

    public ExtendSysWebViewMethodCallback getExtendSysWebViewMethodCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.v : (ExtendSysWebViewMethodCallback) invokeV.objValue;
    }

    public IdCardOcrDTO getIDCardOcrDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : (IdCardOcrDTO) invokeV.objValue;
    }

    public IdCardOcrCallback getIdCardOcrCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.y : (IdCardOcrCallback) invokeV.objValue;
    }

    public ImageCropCallback getImageCropCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p : (ImageCropCallback) invokeV.objValue;
    }

    public NormalizeGuestAccountCallback getNormalizeGuestAccountCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.t : (NormalizeGuestAccountCallback) invokeV.objValue;
    }

    public NormalizeGuestAccountDTO getNormalizeGuestAccountDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.h : (NormalizeGuestAccountDTO) invokeV.objValue;
    }

    public OneKeyLoginCallback getOneKeyLoginCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.w : (OneKeyLoginCallback) invokeV.objValue;
    }

    public QrLoginCallback getQrLoginCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.r : (QrLoginCallback) invokeV.objValue;
    }

    public RealNameDTO getRealNameDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.i : (RealNameDTO) invokeV.objValue;
    }

    public String getSmsLoginStatExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public SmsViewLoginCallback getSmsViewLoginCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.s : (SmsViewLoginCallback) invokeV.objValue;
    }

    public WebSocialLoginDTO getSocialLoginDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f : (WebSocialLoginDTO) invokeV.objValue;
    }

    public SwitchAccountDTO getSwitchAccountDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.j : (SwitchAccountDTO) invokeV.objValue;
    }

    public AbstractThirdPartyService getThirdPartyService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.b : (WebAuthListener) invokeV.objValue;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.o : (WebBindWidgetCallback) invokeV.objValue;
    }

    public WebBindWidgetDTO getWebBindWidgetDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.e : (WebBindWidgetDTO) invokeV.objValue;
    }

    public WebLoginDTO getWebLoginDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.c : (WebLoginDTO) invokeV.objValue;
    }

    public WebRegDTO getWebRegDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.d : (WebRegDTO) invokeV.objValue;
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048604, this, activity, str, str2, i2) == null) {
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
        if (interceptable == null || interceptable.invokeLLLL(1048605, this, activity, storageModel, webAuthListener, str) == null) {
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
    }

    public void loadAccountCenter(AccountCenterCallback accountCenterCallback, AccountCenterDTO accountCenterDTO) {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, accountCenterCallback, accountCenterDTO) == null) {
            if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                accountCenterDTO.bduss = currentAccount.bduss;
            }
            this.m = accountCenterCallback;
            this.g = accountCenterDTO;
            Intent intent = new Intent(this.B, AccountCenterActivity.class);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048607, this, context, accountRealNameCallback, realNameDTO) == null) {
            this.n = accountRealNameCallback;
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
            this.B.startActivity(intent);
        }
    }

    public void loadAccountTools(AccountToolsDTO accountToolsDTO, AccountToolsCallback accountToolsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, accountToolsDTO, accountToolsCallback) == null) {
            this.x = accountToolsCallback;
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
        if (interceptable == null || interceptable.invokeLL(1048609, this, context, bindInfoAction) == null) {
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
        if (interceptable == null || interceptable.invokeLL(1048610, this, webBindWidgetCallback, webBindWidgetDTO) == null) {
            this.o = webBindWidgetCallback;
            if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                webBindWidgetDTO.bduss = currentAccount.bduss;
            }
            this.e = webBindWidgetDTO;
            Intent intent = new Intent(this.B, BindWidgetActivity.class);
            intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, webBindWidgetDTO.bindWidgetAction);
            intent.putExtra("EXTRA_BDUSS", webBindWidgetDTO.bduss);
            Context context = webBindWidgetDTO.context;
            if (context instanceof Activity) {
                context.startActivity(intent);
                webBindWidgetDTO.context = this.B;
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    public void loadCertGuardian(Context context, CertGuardianCallback certGuardianCallback, CertGuardionDTO certGuardionDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, context, certGuardianCallback, certGuardionDTO) == null) {
            this.z = certGuardianCallback;
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
            this.B.startActivity(intent);
        }
    }

    public void loadChildActivity(Context context, AccountRealNameCallback accountRealNameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, context, accountRealNameCallback) == null) {
            this.n = accountRealNameCallback;
            Intent intent = new Intent(context, ChildVerifyActivity.class);
            intent.putExtra("external_url", SapiAccountManager.getInstance().getAccountService().getChildVerifyUrl());
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    public void loadCurrentProcessWebviewActivity(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048613, this, context, str, str2) == null) {
            Intent intent = new Intent(context, CurrentProcessWebviewActivity.class);
            intent.putExtra("external_title", str);
            intent.putExtra("external_url", str2 + "&adapter=3");
            intent.putExtra("is_dark_mode", SapiAccountManager.getInstance().getConfignation().isDarkMode);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    public void loadIdCardOcr(IdCardOcrDTO idCardOcrDTO, IdCardOcrCallback idCardOcrCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, idCardOcrDTO, idCardOcrCallback) == null) {
            this.y = idCardOcrCallback;
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
        if (interceptable == null || interceptable.invokeLL(1048615, this, context, oneKeyLoginCallback) == null) {
            loadOneKeyLogin(context, a(context, OneKeyLoginSdkCall.signFromAbilityApi), true, oneKeyLoginCallback);
        }
    }

    public void loadOneKeyLoginWithToken(Context context, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048618, this, context, str, str2, oneKeyLoginCallback) == null) {
            oneKeyLoginWithToken(context, str, a(context, str2), true, oneKeyLoginCallback);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, qrLoginCallback, str) == null) {
            loadQrLogin(qrLoginCallback, str, null, true);
        }
    }

    public void loadQrLoginWithEncuid(QrLoginCallback qrLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, qrLoginCallback, str) == null) {
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.encryptedId = SapiUtils.urlParamsToMap(str).get(SapiUtils.KEY_QR_LOGIN_ENCUID);
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
            startLogin(new e(this, qrLoginCallback), webLoginDTO);
        }
    }

    public void loadRemoteProcessWebViewActivity(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048623, this, context, str, str2) == null) {
            Intent intent = new Intent(context, RemoteProcessWebviewActivity.class);
            intent.putExtra("external_title", str);
            intent.putExtra("external_url", str2 + "&adapter=3");
            intent.putExtra("is_dark_mode", SapiAccountManager.getInstance().getConfignation().isDarkMode);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    public void loadSwitchAccount(SwitchAccountDTO switchAccountDTO, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, switchAccountDTO, webAuthListener) == null) {
            this.j = switchAccountDTO;
            this.b = webAuthListener;
            Intent intent = new Intent(this.B, SwitchAccountActivity.class);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
            LinkedHashMap linkedHashMap = new LinkedHashMap(1);
            linkedHashMap.put("eventType", "switch_account_enter");
            StatService.onEventAutoStatistic(linkedHashMap);
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, webAuthListener, socialType) == null) {
            WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
            this.f = webSocialLoginDTO;
            webSocialLoginDTO.socialType = socialType;
            loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
        }
    }

    public void loadYYSSOLogin(Context context, String str, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048627, this, context, str, webAuthListener) == null) {
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
    }

    public void onShareLoginActivityResult(int i2, int i3, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intent, str}) == null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            new ShareCallPacking().onLoginActivityActivityResult(new d(this), i2, i3, intent, arrayList, "product");
        }
    }

    public void oneKeyLoginWithToken(Context context, String str, String str2, boolean z, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{context, str, str2, Boolean.valueOf(z), oneKeyLoginCallback}) == null) {
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
        if (interceptable == null || interceptable.invokeLLL(1048630, this, activity, registerUserFaceIDCallback, faceIDRegDTO) == null) {
            if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
                startAuth(new h(this, activity, registerUserFaceIDCallback, faceIDRegDTO), faceIDRegDTO.authWidgetURL);
            } else {
                b(activity, registerUserFaceIDCallback, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence, faceIDRegDTO.isCurrentProcessShowAgreement);
            }
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            synchronized (this) {
                this.b = null;
                this.c = null;
                this.e = null;
                this.f = null;
                this.h = null;
                this.o = null;
                this.p = null;
                this.q = null;
                this.g = null;
                this.r = null;
                this.m = null;
                this.t = null;
                this.u = null;
                this.v = null;
                this.j = null;
                this.z = null;
                PassportViewManager.getInstance().release();
                D = null;
            }
        }
    }

    public void releaseAccountRealNameCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.n = null;
        }
    }

    public void releaseCertGuardianCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            this.z = null;
        }
    }

    public void releaseOneKeyLoginCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.w = null;
        }
    }

    public void releaseSmsViewLoginCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.s = null;
        }
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, activityResultCallback) == null) {
            this.q = activityResultCallback;
        }
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, imageCropCallback) == null) {
            this.p = imageCropCallback;
        }
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, abstractThirdPartyService) == null) {
            this.a = abstractThirdPartyService;
        }
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, authWidgetCallback, str) == null) {
            this.u = authWidgetCallback;
            Intent intent = new Intent(this.B, AuthWidgetActivity.class);
            intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    public void startHorizontalScreenLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048640, this, context, webAuthListener, webLoginDTO) == null) {
            webLoginDTO.screenType = 1;
            a(context, HorizontalScreenLoginActivity.class, webAuthListener, webLoginDTO);
        }
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, webAuthListener, webLoginDTO) == null) {
            startLogin(this.B, webAuthListener, webLoginDTO);
        }
    }

    public void startLoginDeviceManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, context) == null) {
            Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
            intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, "设备管理");
            intent.putExtra("extra_external_url", C);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048644, this, context, normalizeGuestAccountCallback, normalizeGuestAccountDTO) == null) {
            this.t = normalizeGuestAccountCallback;
            this.h = normalizeGuestAccountDTO;
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
        if (interceptable == null || interceptable.invokeLLL(1048645, this, authWidgetCallback, str, str2) == null) {
            this.u = authWidgetCallback;
            Intent intent = new Intent(this.B, AuthWidgetOnlyPhoneActivity.class);
            intent.putExtra("EXTRA_PARAM_AUTH_ID", str);
            intent.putExtra(AuthWidgetOnlyPhoneActivity.EXTRA_PARAM_SCENE, str2);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048646, this, webAuthListener, webRegDTO) == null) {
            this.b = webAuthListener;
            this.d = webRegDTO;
            Intent intent = new Intent(this.B, RegisterActivity.class);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    public void startSchemeLoginForQA(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048647, this, context, str) == null) {
            Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
            intent.putExtra("extra_external_url", str);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    @Deprecated
    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048649, this, smsViewLoginCallback, str) == null) {
            this.s = smsViewLoginCallback;
            this.A = str;
            SmsLoginView.notifyStartLogin();
        }
    }

    public void startSpeciallyAuthWidget(AuthWidgetCallback authWidgetCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048651, this, authWidgetCallback, str, str2) == null) {
            this.u = authWidgetCallback;
            Intent intent = new Intent(this.B, AuthWidgetOnlyPhoneActivity.class);
            intent.putExtra("EXTRA_PARAM_AUTH_ID", str);
            intent.putExtra(AuthWidgetOnlyPhoneActivity.EXTRA_PARAM_SCENE, str2);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    public void verifyUserFaceIDWithCertInfo(Activity activity, PassFaceRecogCallback passFaceRecogCallback, FaceIDVerifyCertInfoDTO faceIDVerifyCertInfoDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048652, this, activity, passFaceRecogCallback, faceIDVerifyCertInfoDTO) == null) {
            BiometricsManager.getInstance().recogWithCertInfo(activity, BiometricsManager.buildSubPro("", faceIDVerifyCertInfoDTO.subpro), faceIDVerifyCertInfoDTO.transParamsList, faceIDVerifyCertInfoDTO.imageFlag, faceIDVerifyCertInfoDTO.realName, faceIDVerifyCertInfoDTO.idCardNo, faceIDVerifyCertInfoDTO.needAuthorizeCertInfo, null, passFaceRecogCallback);
        }
    }

    public void verifyUserFaceId(Activity activity, VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048653, this, activity, verifyUserFaceIDCallback, faceIDVerifyDTO) == null) {
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
            b(activity, verifyUserFaceIDCallback, "outer", "", faceIDVerifyDTO.livingUname, faceIDVerifyDTO.showGuidePage, faceIDVerifyDTO.subpro, faceIDVerifyDTO.businessSence, faceIDVerifyDTO.isCurrentProcessShowAgreement);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{activity, faceIDCallback, str, str2, str3, Boolean.valueOf(z), str4, str5, Boolean.valueOf(z2)}) == null) {
            a(activity, faceIDCallback, str, str2, str3, z, str4, str5, z2);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048620, this, qrLoginCallback, str, str2) == null) {
            loadQrLogin(qrLoginCallback, str, str2, true);
        }
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048641, this, context, webAuthListener, webLoginDTO) == null) {
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
        if (interceptable == null || interceptable.invokeLLL(1048616, this, context, str, oneKeyLoginCallback) == null) {
            loadOneKeyLogin(context, str, true, oneKeyLoginCallback);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2, boolean z) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{qrLoginCallback, str, str2, Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList(1);
            this.r = new f(this, qrLoginCallback, arrayList);
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
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{context, str, Boolean.valueOf(z), oneKeyLoginCallback}) == null) {
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
                    public final /* synthetic */ String b;
                    public final /* synthetic */ boolean c;
                    public final /* synthetic */ OneKeyLoginCallback d;
                    public final /* synthetic */ CoreViewRouter e;

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
                        this.e = this;
                        this.a = context;
                        this.b = str;
                        this.c = z;
                        this.d = oneKeyLoginCallback;
                    }

                    @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                    public void onGetTokenComplete(JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                            this.e.oneKeyLoginWithToken(this.a, jSONObject.optString("token"), this.b, this.c, this.d);
                        }
                    }
                });
            }
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, webAuthListener, webSocialLoginDTO) == null) {
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
                    context = this.B;
                }
                thirdPartyService.loadThirdPartyLogin(context, webSocialLoginDTO.socialType, 2002, thirdLoginCallback);
            } else {
                Context context2 = webSocialLoginDTO.context;
                if (context2 == null) {
                    context2 = this.B;
                }
                thirdPartyService.loadThirdPartyLogin(context2, webSocialLoginDTO.socialType, 2002);
            }
            webSocialLoginDTO.context = null;
        }
    }

    public void startSmsViewLogin(SmsLoginView smsLoginView, SmsViewLoginCallback smsViewLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048650, this, smsLoginView, smsViewLoginCallback, str) == null) || smsLoginView == null || smsViewLoginCallback == null) {
            return;
        }
        smsLoginView.setSmsViewLoginCallback(smsViewLoginCallback);
        smsLoginView.setSmsLoginStatExtra(str);
        SmsLoginView.notifyStartLogin();
    }

    public void startSchemeLoginForQA(Context context, String str, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048648, this, context, str, webAuthListener) == null) {
            this.b = webAuthListener;
            Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
            intent.putExtra("extra_external_url", str);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
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
        this.B.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65551, this, str, z) == null) {
            Intent intent = new Intent(this.B, QrLoginActivity.class);
            intent.putExtra(QrLoginActivity.EXTRA_STRING_QR_LOGIN_URL, str);
            intent.putExtra(QrLoginActivity.EXTRA_BOOLEAN_FINISH_PAGE, z);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.B.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, String str5, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{activity, str, map, str2, str3, str4, str5, verifyUserFaceIDCallback, realNameFaceIDResult, Boolean.valueOf(z)}) == null) {
            BiometricsManager.getInstance().recogWithBduss(activity, BiometricsManager.buildSubPro(str, str5), map, str2, str3, str4, z, new j(this, realNameFaceIDResult, verifyUserFaceIDCallback));
        }
    }

    private void a(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{activity, faceIDCallback, str, str2, str3, Boolean.valueOf(z), str4, str5, Boolean.valueOf(z2)}) == null) {
            if (!TextUtils.isEmpty(str5)) {
                BiometricsManager biometricsManager = BiometricsManager.getInstance();
                String buildSubPro = BiometricsManager.buildSubPro(str4, str5);
                HashMap hashMap = new HashMap();
                k kVar = new k(this, new UnRealNameFaceIDResult(), str, faceIDCallback);
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
