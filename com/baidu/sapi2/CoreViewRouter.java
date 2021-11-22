package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes7.dex */
public class CoreViewRouter implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "https://wappass.baidu.com/v6/securitySettings/deviceManage?adapter=3";
    public static CoreViewRouter B;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AbstractThirdPartyService f43141a;

    /* renamed from: b  reason: collision with root package name */
    public WebAuthListener f43142b;

    /* renamed from: c  reason: collision with root package name */
    public WebLoginDTO f43143c;

    /* renamed from: d  reason: collision with root package name */
    public WebRegDTO f43144d;

    /* renamed from: e  reason: collision with root package name */
    public WebBindWidgetDTO f43145e;

    /* renamed from: f  reason: collision with root package name */
    public WebSocialLoginDTO f43146f;

    /* renamed from: g  reason: collision with root package name */
    public AccountCenterDTO f43147g;

    /* renamed from: h  reason: collision with root package name */
    public NormalizeGuestAccountDTO f43148h;

    /* renamed from: i  reason: collision with root package name */
    public RealNameDTO f43149i;
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

    /* loaded from: classes7.dex */
    public class a extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f43156a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f43157b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f43158c;

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
            this.f43158c = coreViewRouter;
            this.f43156a = extendSysWebViewMethodResult;
            this.f43157b = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f43156a;
                extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
                this.f43157b.onFinish(extendSysWebViewMethodResult);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogResult) == null) {
                ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f43156a;
                extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
                this.f43157b.onFinish(extendSysWebViewMethodResult);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f43159a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43160b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f43161c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f43162d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SapiAccount f43163e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f43164f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f43165g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f43166h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f43167i;

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
            this.f43167i = coreViewRouter;
            this.f43159a = activity;
            this.f43160b = str;
            this.f43161c = map;
            this.f43162d = str2;
            this.f43163e = sapiAccount;
            this.f43164f = passFaceRecogCallback;
            this.f43165g = extendSysWebViewMethodResult;
            this.f43166h = extendSysWebViewMethodCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) {
                this.f43165g.params.put(BaiduRimConstants.RETCODE_KEY, Integer.valueOf(getTplStokenResult.getResultCode()));
                this.f43165g.params.put("retMsg", getTplStokenResult.getResultMsg());
                this.f43166h.onFinish(this.f43165g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getTplStokenResult) == null) {
                BiometricsManager.getInstance().recogWithBduss(this.f43159a, this.f43160b, this.f43161c, this.f43162d, this.f43163e.bduss, getTplStokenResult.tplStokenMap.get("pp"), this.f43164f);
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

    /* loaded from: classes7.dex */
    public class c extends ShareCallPacking.ShareLoginCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f43168a;

        public c(CoreViewRouter coreViewRouter) {
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
            this.f43168a = coreViewRouter;
        }

        @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
        public void onFailed(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                super.onFailed(i2, str);
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(i2);
                webAuthResult.setResultMsg(str);
                WebAuthListener webAuthListener = this.f43168a.f43142b;
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
                if (this.f43168a.f43142b != null) {
                    this.f43168a.f43142b.onSuccess(webAuthResult);
                }
                CoreViewRouter.getInstance().release();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QrLoginCallback f43169a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f43170b;

        public d(CoreViewRouter coreViewRouter, QrLoginCallback qrLoginCallback) {
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
            this.f43170b = coreViewRouter;
            this.f43169a = qrLoginCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            QrLoginCallback qrLoginCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) || (qrLoginCallback = this.f43169a) == null) {
                return;
            }
            qrLoginCallback.onLocalLogin(webAuthResult);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            QrLoginCallback qrLoginCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) || (qrLoginCallback = this.f43169a) == null) {
                return;
            }
            qrLoginCallback.onLocalLogin(webAuthResult);
        }
    }

    /* loaded from: classes7.dex */
    public class e extends QrLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QrLoginCallback f43171a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f43172b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f43173c;

        public e(CoreViewRouter coreViewRouter, QrLoginCallback qrLoginCallback, List list) {
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
            this.f43173c = coreViewRouter;
            this.f43171a = qrLoginCallback;
            this.f43172b = list;
        }

        @Override // com.baidu.sapi2.callback.QrLoginCallback
        public void onFinish(QrLoginResult qrLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qrLoginResult) == null) {
                this.f43171a.onFinish(qrLoginResult);
                if (this.f43172b.size() == 1) {
                    ((WebAuthResult) this.f43172b.get(0)).finishActivity();
                    this.f43171a.onLocalLogin((WebAuthResult) this.f43172b.get(0));
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

    /* loaded from: classes7.dex */
    public class f extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f43174a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43175b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f43176c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f43177d;

        public f(CoreViewRouter coreViewRouter, List list, String str, boolean z) {
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
            this.f43177d = coreViewRouter;
            this.f43174a = list;
            this.f43175b = str;
            this.f43176c = z;
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
                this.f43174a.add(webAuthResult);
                String str = this.f43175b.indexOf("?") > 0 ? "&" : "?";
                this.f43177d.a(this.f43175b + str + "login_action_type=" + SapiUtils.getLastLoginType() + "&clientfrom=android", this.f43176c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends AuthWidgetCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f43178a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RegisterUserFaceIDCallback f43179b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceIDRegDTO f43180c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f43181d;

        public g(CoreViewRouter coreViewRouter, Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
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
            this.f43181d = coreViewRouter;
            this.f43178a = activity;
            this.f43179b = registerUserFaceIDCallback;
            this.f43180c = faceIDRegDTO;
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.f43179b.onFailure(sapiResult);
            }
        }

        @Override // com.baidu.sapi2.callback.AuthWidgetCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                CoreViewRouter coreViewRouter = this.f43181d;
                Activity activity = this.f43178a;
                RegisterUserFaceIDCallback registerUserFaceIDCallback = this.f43179b;
                FaceIDRegDTO faceIDRegDTO = this.f43180c;
                coreViewRouter.b(activity, registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f43182a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FaceIDVerifyDTO f43183b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VerifyUserFaceIDCallback f43184c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RealNameFaceIDResult f43185d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f43186e;

        public h(CoreViewRouter coreViewRouter, Activity activity, FaceIDVerifyDTO faceIDVerifyDTO, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
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
            this.f43186e = coreViewRouter;
            this.f43182a = activity;
            this.f43183b = faceIDVerifyDTO;
            this.f43184c = verifyUserFaceIDCallback;
            this.f43185d = realNameFaceIDResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) {
                this.f43185d.setResultCode(getTplStokenResult.getResultCode());
                this.f43185d.setResultMsg(getTplStokenResult.getResultMsg());
                this.f43184c.onFailure(this.f43185d);
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
                    CoreViewRouter coreViewRouter = this.f43186e;
                    Activity activity = this.f43182a;
                    FaceIDVerifyDTO faceIDVerifyDTO = this.f43183b;
                    coreViewRouter.a(activity, faceIDVerifyDTO.subpro, (Map<String, String>) null, "0", faceIDVerifyDTO.bduss, str, faceIDVerifyDTO.businessSence, this.f43184c, this.f43185d);
                    return;
                }
                this.f43185d.setResultCode(-402);
                this.f43185d.setResultMsg("服务异常，请稍后再试");
                this.f43184c.onFailure(this.f43185d);
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

    /* loaded from: classes7.dex */
    public class i extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RealNameFaceIDResult f43187a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VerifyUserFaceIDCallback f43188b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f43189c;

        public i(CoreViewRouter coreViewRouter, RealNameFaceIDResult realNameFaceIDResult, VerifyUserFaceIDCallback verifyUserFaceIDCallback) {
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
            this.f43189c = coreViewRouter;
            this.f43187a = realNameFaceIDResult;
            this.f43188b = verifyUserFaceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                this.f43187a.setResultCode(passFaceRecogResult.getResultCode());
                this.f43187a.setResultMsg(passFaceRecogResult.getResultMsg());
                this.f43188b.onFailure(this.f43187a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogResult) == null) {
                this.f43187a.setResultCode(passFaceRecogResult.getResultCode());
                this.f43187a.setResultMsg(passFaceRecogResult.getResultMsg());
                RealNameFaceIDResult realNameFaceIDResult = this.f43187a;
                realNameFaceIDResult.authSid = passFaceRecogResult.authSid;
                realNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
                realNameFaceIDResult.setResultCode(0);
                this.f43188b.onSuccess(this.f43187a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnRealNameFaceIDResult f43190a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43191b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceIDCallback f43192c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f43193d;

        public j(CoreViewRouter coreViewRouter, UnRealNameFaceIDResult unRealNameFaceIDResult, String str, FaceIDCallback faceIDCallback) {
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
            this.f43193d = coreViewRouter;
            this.f43190a = unRealNameFaceIDResult;
            this.f43191b = str;
            this.f43192c = faceIDCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                this.f43190a.setResultCode(passFaceRecogResult.getResultCode());
                this.f43192c.onFailure(this.f43190a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogResult) == null) {
                this.f43190a.setResultMsg(passFaceRecogResult.getResultMsg());
                if (this.f43191b.equals("faceDetect") && (jSONObject = passFaceRecogResult.extraJson) != null) {
                    this.f43190a.registerResult = jSONObject.toString();
                }
                UnRealNameFaceIDResult unRealNameFaceIDResult = this.f43190a;
                String str = passFaceRecogResult.callbackkey;
                unRealNameFaceIDResult.callBackKey = str;
                if (TextUtils.isEmpty(str)) {
                    this.f43190a.setResultCode(-205);
                    this.f43192c.onFailure(this.f43190a);
                    return;
                }
                this.f43190a.setResultCode(0);
                this.f43192c.onSuccess(this.f43190a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements SapiCallback<SapiResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43194a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f43195b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodCallback f43196c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43197d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExtendSysWebViewMethodResult f43198e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CoreViewRouter f43199f;

        public k(CoreViewRouter coreViewRouter, int i2, Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
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
            this.f43199f = coreViewRouter;
            this.f43194a = i2;
            this.f43195b = activity;
            this.f43196c = extendSysWebViewMethodCallback;
            this.f43197d = jSONObject;
            this.f43198e = extendSysWebViewMethodResult;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.f43198e.setResultCode(sapiResult.getResultCode());
                this.f43198e.setResultMsg(sapiResult.getResultMsg());
                this.f43196c.onFinish(this.f43198e);
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
                int i2 = this.f43194a;
                switch (i2) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        this.f43199f.a(this.f43195b, this.f43196c, this.f43197d, i2, this.f43198e);
                        return;
                    case 5:
                        this.f43199f.u = this.f43196c;
                        String optString = this.f43197d.optString("url");
                        String optString2 = this.f43197d.optString("title");
                        Intent intent = new Intent(this.f43199f.z, LoadExternalWebViewActivity.class);
                        intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, optString2);
                        intent.putExtra("extra_external_url", optString);
                        intent.setFlags(268435456);
                        this.f43199f.z.startActivity(intent);
                        return;
                    case 6:
                        JSONArray optJSONArray = this.f43197d.optJSONArray("di_keys");
                        ArrayList arrayList = new ArrayList();
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            if (!TextUtils.isEmpty(optJSONArray.optString(i3))) {
                                arrayList.add(optJSONArray.optString(i3));
                            }
                        }
                        String diCookieInfo = SapiDeviceInfo.getDiCookieInfo(arrayList, false);
                        this.f43198e.params.put(BaiduRimConstants.RETCODE_KEY, "0");
                        this.f43198e.params.put("result", diCookieInfo);
                        this.f43196c.onFinish(this.f43198e);
                        return;
                    default:
                        this.f43198e.params.put(BaiduRimConstants.RETCODE_KEY, "-301");
                        Map<String, Object> map = this.f43198e.params;
                        map.put("retMsg", "action :" + this.f43194a + " is not support");
                        this.f43196c.onFinish(this.f43198e);
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
                    SapiAccountManager.getInstance().getAccountService().extendSysWebViewMethodCheck(new k(this, optInt, activity, extendSysWebViewMethodCallback, optJSONObject, extendSysWebViewMethodResult), optString, optString2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43147g : (AccountCenterDTO) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f43148h : (NormalizeGuestAccountDTO) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f43149i : (RealNameDTO) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f43146f : (WebSocialLoginDTO) invokeV.objValue;
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
            if (this.f43141a == null) {
                a();
            }
            return this.f43141a;
        }
        return (AbstractThirdPartyService) invokeV.objValue;
    }

    public WebAuthListener getWebAuthListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f43142b : (WebAuthListener) invokeV.objValue;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.n : (WebBindWidgetCallback) invokeV.objValue;
    }

    public WebBindWidgetDTO getWebBindWidgetDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f43145e : (WebBindWidgetDTO) invokeV.objValue;
    }

    public WebLoginDTO getWebLoginDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f43143c : (WebLoginDTO) invokeV.objValue;
    }

    public WebRegDTO getWebRegDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f43144d : (WebRegDTO) invokeV.objValue;
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048602, this, activity, str, str2, i2) == null) {
            AbstractThirdPartyService thirdPartyService = getThirdPartyService();
            this.f43141a = thirdPartyService;
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
                if (!SapiUtils.isAppInstalled(activity, storageModel.pkg)) {
                    WebAuthResult webAuthResult = new WebAuthResult();
                    webAuthResult.setResultCode(ShareResult.ERROR_CODE_TARGET_APP_NOT_INSTALLED);
                    webAuthResult.setResultMsg(ShareResult.ERROR_MSG_TARGET_APP_NOT_INSTALLED);
                    webAuthListener.onFailure(webAuthResult);
                }
                this.f43142b = webAuthListener;
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
            this.f43147g = accountCenterDTO;
            Intent intent = new Intent(this.z, AccountCenterActivity.class);
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, context, accountRealNameCallback, realNameDTO) == null) {
            this.m = accountRealNameCallback;
            this.f43149i = realNameDTO;
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
            this.f43145e = webBindWidgetDTO;
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

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, qrLoginCallback, str) == null) {
            loadQrLogin(qrLoginCallback, str, null, true);
        }
    }

    public void loadQrLoginWithEncuid(QrLoginCallback qrLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, qrLoginCallback, str) == null) {
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.encryptedId = SapiUtils.urlParamsToMap(str).get(SapiUtils.KEY_QR_LOGIN_ENCUID);
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
            startLogin(new d(this, qrLoginCallback), webLoginDTO);
        }
    }

    public void loadRemoteProcessWebViewActivity(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048617, this, context, str, str2) == null) {
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
        if (interceptable == null || interceptable.invokeLL(1048618, this, switchAccountDTO, webAuthListener) == null) {
            this.j = switchAccountDTO;
            this.f43142b = webAuthListener;
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
        if (interceptable == null || interceptable.invokeLL(1048620, this, webAuthListener, socialType) == null) {
            WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
            this.f43146f = webSocialLoginDTO;
            webSocialLoginDTO.socialType = socialType;
            loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
        }
    }

    public void loadYYSSOLogin(Context context, String str, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048621, this, context, str, webAuthListener) == null) {
            AbstractThirdPartyService thirdPartyService = getThirdPartyService();
            this.f43141a = thirdPartyService;
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
            this.f43143c = webLoginDTO;
            WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
            webSocialLoginDTO.finishActivityAfterSuc = true;
            this.f43146f = webSocialLoginDTO;
            this.f43142b = webAuthListener;
            this.f43141a.loadYYSSOLogin(context, str);
        }
    }

    public void onShareLoginActivityResult(int i2, int i3, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intent, str}) == null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            new ShareCallPacking().onLoginActivityActivityResult(new c(this), i2, i3, intent, arrayList, "product");
        }
    }

    public void registerUserFaceID(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048623, this, activity, registerUserFaceIDCallback, faceIDRegDTO) == null) {
            if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
                startAuth(new g(this, activity, registerUserFaceIDCallback, faceIDRegDTO), faceIDRegDTO.authWidgetURL);
            } else {
                b(activity, registerUserFaceIDCallback, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
            }
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            synchronized (this) {
                this.f43142b = null;
                this.f43143c = null;
                this.f43145e = null;
                this.f43146f = null;
                this.f43148h = null;
                this.n = null;
                this.o = null;
                this.p = null;
                this.f43147g = null;
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
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.m = null;
        }
    }

    public void releaseOneKeyLoginCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.v = null;
        }
    }

    public void releaseSmsViewLoginCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.r = null;
        }
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, activityResultCallback) == null) {
            this.p = activityResultCallback;
        }
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, imageCropCallback) == null) {
            this.o = imageCropCallback;
        }
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, abstractThirdPartyService) == null) {
            this.f43141a = abstractThirdPartyService;
        }
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048631, this, authWidgetCallback, str) == null) {
            this.t = authWidgetCallback;
            Intent intent = new Intent(this.z, AuthWidgetActivity.class);
            intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    public void startHorizontalScreenLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048632, this, context, webAuthListener, webLoginDTO) == null) {
            webLoginDTO.screenType = 1;
            a(context, HorizontalScreenLoginActivity.class, webAuthListener, webLoginDTO);
        }
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, webAuthListener, webLoginDTO) == null) {
            startLogin(this.z, webAuthListener, webLoginDTO);
        }
    }

    public void startLoginDeviceManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, context) == null) {
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
        if (interceptable == null || interceptable.invokeLLL(1048636, this, context, normalizeGuestAccountCallback, normalizeGuestAccountDTO) == null) {
            this.s = normalizeGuestAccountCallback;
            this.f43148h = normalizeGuestAccountDTO;
            Intent intent = new Intent(context, NormalizeGuestAccountActivity.class);
            intent.putExtra("EXTRA_BDUSS", normalizeGuestAccountDTO.bduss);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, webAuthListener, webRegDTO) == null) {
            this.f43142b = webAuthListener;
            this.f43144d = webRegDTO;
            Intent intent = new Intent(this.z, RegisterActivity.class);
            intent.setFlags(268435456);
            this.z.startActivity(intent);
        }
    }

    public void startSchemeLoginForQA(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, context, str) == null) {
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
        if (interceptable == null || interceptable.invokeLL(1048640, this, smsViewLoginCallback, str) == null) {
            this.r = smsViewLoginCallback;
            this.y = str;
            SmsLoginView.notifyStartLogin();
        }
    }

    public void verifyUserFaceIDWithCertInfo(Activity activity, PassFaceRecogCallback passFaceRecogCallback, FaceIDVerifyCertInfoDTO faceIDVerifyCertInfoDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048642, this, activity, passFaceRecogCallback, faceIDVerifyCertInfoDTO) == null) {
            BiometricsManager.getInstance().recogWithCertInfo(activity, BiometricsManager.buildSubPro("", faceIDVerifyCertInfoDTO.subpro), faceIDVerifyCertInfoDTO.transParamsList, faceIDVerifyCertInfoDTO.imageFlag, faceIDVerifyCertInfoDTO.realName, faceIDVerifyCertInfoDTO.idCardNo, null, passFaceRecogCallback);
        }
    }

    public void verifyUserFaceId(Activity activity, VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048643, this, activity, verifyUserFaceIDCallback, faceIDVerifyDTO) == null) {
            if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                faceIDVerifyDTO.bduss = currentAccount.bduss;
                faceIDVerifyDTO.uid = currentAccount.uid;
            }
            if (TextUtils.isEmpty(faceIDVerifyDTO.livingUname)) {
                RealNameFaceIDResult realNameFaceIDResult = new RealNameFaceIDResult();
                ArrayList arrayList = new ArrayList();
                arrayList.add("pp");
                SapiAccountManager.getInstance().getAccountService().getTplStoken(new h(this, activity, faceIDVerifyDTO, verifyUserFaceIDCallback, realNameFaceIDResult), faceIDVerifyDTO.bduss, arrayList);
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
        if (interceptable == null || interceptable.invokeLLL(1048614, this, qrLoginCallback, str, str2) == null) {
            loadQrLogin(qrLoginCallback, str, str2, true);
        }
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048633, this, context, webAuthListener, webLoginDTO) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{qrLoginCallback, str, str2, Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList(1);
            this.q = new e(this, qrLoginCallback, arrayList);
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
            startLogin(new f(this, arrayList, str, z), webLoginDTO);
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
                new OneKeyLoginSdkCall().getToken(SapiAccountManager.getInstance().getSapiConfiguration(), new OneKeyLoginSdkCall.TokenListener(this, oneKeyLoginCallback, str, z, context) { // from class: com.baidu.sapi2.CoreViewRouter.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ OneKeyLoginCallback f43150a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f43151b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ boolean f43152c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ Context f43153d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ CoreViewRouter f43154e;

                    /* renamed from: com.baidu.sapi2.CoreViewRouter$12$a */
                    /* loaded from: classes7.dex */
                    public class a implements LoadExternalWebViewActivityCallback {
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass12 f43155a;

                        public a(AnonymousClass12 anonymousClass12) {
                            Interceptable interceptable = $ic;
                            if (interceptable != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {anonymousClass12};
                                interceptable.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f43155a = anonymousClass12;
                        }

                        @Override // com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback
                        public void needLoadExternalWebView(String str, String str2) {
                            Interceptable interceptable = $ic;
                            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                                AnonymousClass12 anonymousClass12 = this.f43155a;
                                if (anonymousClass12.f43152c) {
                                    anonymousClass12.f43154e.v = anonymousClass12.f43150a;
                                    Intent intent = new Intent(this.f43155a.f43153d, LoadExternalWebViewActivity.class);
                                    intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, str);
                                    String str3 = (str2 + "&adapter=3") + "&lastLoginType=oneKeyLogin";
                                    if (SapiAccountManager.getInstance().getSapiConfiguration().supportFaceLogin) {
                                        str3 = str3 + "&liveAbility=1";
                                    }
                                    intent.putExtra("extra_external_url", str3);
                                    intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_FROM, "business_from_one_key_login");
                                    Context context = this.f43155a.f43153d;
                                    if (context instanceof Activity) {
                                        context.startActivity(intent);
                                        return;
                                    }
                                    intent.setFlags(268435456);
                                    this.f43155a.f43154e.z.startActivity(intent);
                                    return;
                                }
                                new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.f43155a.f43150a, -111, null);
                            }
                        }
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, oneKeyLoginCallback, str, Boolean.valueOf(z), context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f43154e = this;
                        this.f43150a = oneKeyLoginCallback;
                        this.f43151b = str;
                        this.f43152c = z;
                        this.f43153d = context;
                    }

                    @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                    public void onGetTokenComplete(JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                            String optString = jSONObject.optString("token");
                            if (!TextUtils.isEmpty(optString)) {
                                SapiAccountManager.getInstance().getAccountService().loadOneKeyLogin(this.f43150a, optString, this.f43151b, new a(this));
                            } else {
                                new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.f43150a, -102, null);
                            }
                        }
                    }
                });
            }
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, webAuthListener, webSocialLoginDTO) == null) {
            this.f43142b = webAuthListener;
            this.f43146f = webSocialLoginDTO;
            AbstractThirdPartyService thirdPartyService = getThirdPartyService();
            this.f43141a = thirdPartyService;
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
        if (!(interceptable == null || interceptable.invokeLLL(1048641, this, smsLoginView, smsViewLoginCallback, str) == null) || smsLoginView == null || smsViewLoginCallback == null) {
            return;
        }
        smsLoginView.setSmsViewLoginCallback(smsViewLoginCallback);
        smsLoginView.setSmsLoginStatExtra(str);
        SmsLoginView.notifyStartLogin();
    }

    public void startSchemeLoginForQA(Context context, String str, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048639, this, context, str, webAuthListener) == null) {
            this.f43142b = webAuthListener;
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
        this.f43142b = webAuthListener;
        this.f43143c = webLoginDTO;
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
            BiometricsManager.getInstance().recogWithBduss(activity, BiometricsManager.buildSubPro(str, str5), map, str2, str3, str4, new i(this, realNameFaceIDResult, verifyUserFaceIDCallback));
        }
    }

    private void a(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{activity, faceIDCallback, str, str2, str3, Boolean.valueOf(z), str4, str5}) == null) {
            if (!TextUtils.isEmpty(str5)) {
                BiometricsManager biometricsManager = BiometricsManager.getInstance();
                String buildSubPro = BiometricsManager.buildSubPro(str4, str5);
                HashMap hashMap = new HashMap();
                j jVar = new j(this, new UnRealNameFaceIDResult(), str, faceIDCallback);
                if (str.equals("faceDetect")) {
                    biometricsManager.recogWithFaceDetect(activity, buildSubPro, hashMap, "0", str3, str2, jVar);
                    return;
                } else if (str.equals("outer")) {
                    biometricsManager.recogWithFaceOuter(activity, buildSubPro, hashMap, "0", str3, jVar);
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
                hashMap = hashMap2;
                a(activity, extendSysWebViewMethodCallback, eVar, extendSysWebViewMethodResult, aVar, optString, hashMap2, optInt + "");
            } else {
                str = "";
                hashMap = hashMap2;
            }
            if (i2 == 2) {
                biometricsManager.recogWithCertInfo(activity, optString, hashMap, optInt + str, jSONObject.optString("realname"), jSONObject.optString("idcardnum"), jSONObject.optString("bankmobile"), aVar);
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
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{activity, extendSysWebViewMethodCallback, eVar, extendSysWebViewMethodResult, passFaceRecogCallback, str, map, str2}) == null) {
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                Class.forName("com.baidu.sapi2.ThirdPartyService").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
    }
}
