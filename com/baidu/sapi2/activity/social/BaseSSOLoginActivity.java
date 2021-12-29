package com.baidu.sapi2.activity.social;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class BaseSSOLoginActivity extends SocialLoginBase {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: k  reason: collision with root package name */
    public static final String f39344k = "extraJson";
    public static final String l = "sceneFrom";
    public static final String m = "isVerification";
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39345b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f39346c;

    /* renamed from: d  reason: collision with root package name */
    public Dialog f39347d;

    /* renamed from: e  reason: collision with root package name */
    public String f39348e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39349f;

    /* renamed from: g  reason: collision with root package name */
    public int f39350g;

    /* renamed from: h  reason: collision with root package name */
    public WebAuthResult f39351h;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.sapi2.a.a.b f39352i;

    /* renamed from: j  reason: collision with root package name */
    public AuthorizationListener f39353j;

    /* loaded from: classes10.dex */
    public class c extends AuthorizationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSSOLoginActivity a;

        public c(BaseSSOLoginActivity baseSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseSSOLoginActivity;
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                super.beforeSuccess(sapiAccount);
                if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                    CoreViewRouter.getInstance().getWebAuthListener().beforeSuccess(sapiAccount);
                }
            }
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (this.a.f39350g == 2001) {
                    Intent intent = new Intent();
                    intent.putExtra("result_code", i2);
                    intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
                    this.a.a(1002, intent);
                } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                    this.a.f39351h.setResultCode(i2);
                    this.a.f39351h.setResultMsg(str);
                    CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.a.f39351h);
                    CoreViewRouter.getInstance().release();
                }
                this.a.finish();
            }
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountType) == null) {
                super.onSuccess(accountType);
                if (this.a.f39345b) {
                    return;
                }
                WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                if (webAuthListener != null) {
                    WebAuthResult webAuthResult = this.a.f39351h;
                    webAuthResult.accountType = accountType;
                    webAuthResult.setResultCode(0);
                    webAuthListener.onSuccess(this.a.f39351h);
                }
                int i2 = this.a.f39350g;
                if (i2 != 2001) {
                    if (i2 != 2003 && i2 != 2004) {
                        WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
                        if (socialLoginDTO == null || !socialLoginDTO.finishActivityAfterSuc) {
                            return;
                        }
                        if (socialLoginDTO.isReleaseAllCallback.booleanValue()) {
                            CoreViewRouter.getInstance().release();
                        }
                        this.a.finish();
                        return;
                    }
                    this.a.b(1001);
                    this.a.finish();
                    return;
                }
                WebRegDTO webRegDTO = CoreViewRouter.getInstance().getWebRegDTO();
                if (webRegDTO != null) {
                    if (webRegDTO.finishActivityAfterSuc) {
                        this.a.b(1001);
                        this.a.finish();
                        return;
                    }
                    return;
                }
                WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
                if (webLoginDTO == null || !webLoginDTO.finishActivityAfterSuc) {
                    return;
                }
                this.a.b(1001);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements SapiWebView.OnBackCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSSOLoginActivity a;

        public d(BaseSSOLoginActivity baseSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseSSOLoginActivity;
        }

        @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.sapiWebView != null && this.a.sapiWebView.canGoBack()) {
                    this.a.sapiWebView.goBack();
                    return;
                }
                BaseSSOLoginActivity baseSSOLoginActivity = this.a;
                baseSSOLoginActivity.a(baseSSOLoginActivity.f39350g);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements SapiWebView.OnFinishCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSSOLoginActivity a;

        public e(BaseSSOLoginActivity baseSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseSSOLoginActivity;
        }

        @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BaseSSOLoginActivity baseSSOLoginActivity = this.a;
                baseSSOLoginActivity.a(baseSSOLoginActivity.f39350g);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiAccount a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseSSOLoginActivity f39354b;

        public f(BaseSSOLoginActivity baseSSOLoginActivity, SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSSOLoginActivity, sapiAccount};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39354b = baseSSOLoginActivity;
            this.a = sapiAccount;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f39354b.f39353j != null) {
                        this.f39354b.f39353j.beforeSuccess(this.a);
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
                SapiAccountManager.getInstance().validate(this.a);
                this.f39354b.a(AccountType.UNKNOWN);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SocialResponse a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseSSOLoginActivity f39355b;

        public g(BaseSSOLoginActivity baseSSOLoginActivity, SocialResponse socialResponse) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSSOLoginActivity, socialResponse};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39355b = baseSSOLoginActivity;
            this.a = socialResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            AuthorizationListener authorizationListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (authorizationListener = this.f39355b.f39353j) == null) {
                return;
            }
            SocialResponse socialResponse = this.a;
            authorizationListener.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
        }
    }

    /* loaded from: classes10.dex */
    public class h extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseSSOLoginActivity f39356b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(BaseSSOLoginActivity baseSSOLoginActivity, Looper looper, String str) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSSOLoginActivity, looper, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39356b = baseSSOLoginActivity;
            this.a = str;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                ThirdPartyUtil.wxAuthCodeMap.clear();
                AuthorizationListener authorizationListener = this.f39356b.f39353j;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, "登录失败");
                }
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ThirdPartyUtil.wxAuthCodeMap.clear();
                super.onFinish();
                BaseSSOLoginActivity baseSSOLoginActivity = this.f39356b;
                ViewUtility.dismissDialog(baseSSOLoginActivity, baseSSOLoginActivity.f39347d);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.onStart();
                this.f39356b.a(this.a);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, hashMap) == null) {
                ThirdPartyUtil.wxAuthCodeMap.clear();
                if (str == null) {
                    AuthorizationListener authorizationListener = this.f39356b.f39353j;
                    if (authorizationListener != null) {
                        authorizationListener.onFailed(-100, "登录失败");
                        return;
                    }
                    return;
                }
                try {
                    this.f39356b.a(SocialResponse.fromJSONObject(new JSONObject(str)), hashMap);
                } catch (Throwable th) {
                    Log.e(th);
                    AuthorizationListener authorizationListener2 = this.f39356b.f39353j;
                    if (authorizationListener2 != null) {
                        authorizationListener2.onFailed(-100, "登录失败");
                    }
                }
            }
        }
    }

    public BaseSSOLoginActivity() {
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
        this.a = "BaseSSOLoginActivity";
        this.f39351h = new a(this);
        this.f39352i = new b(this);
        this.f39353j = new c(this);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ViewUtility.dismissDialog(this, this.f39347d);
            super.finish();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? CoreViewRouter.getInstance().getSocialLoginDTO() : (SapiWebDTO) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        SapiWebView sapiWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (sapiWebView = this.sapiWebView) == null) {
            return;
        }
        sapiWebView.onKeyUp(4);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onClose();
            a(this.f39350g);
        }
    }

    @Override // com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            if (Build.VERSION.SDK_INT == 26) {
                e();
            }
            super.onCreate(bundle);
            d();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        SapiWebView sapiWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onLeftBtnClick();
            if (this.executeSubClassMethod && (sapiWebView = this.sapiWebView) != null) {
                sapiWebView.onKeyUp(4);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onRightBtnClick();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.setupViews();
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null) {
                sapiWebView.setOnBackCallback(new d(this));
                this.sapiWebView.setOnFinishCallback(new e(this));
                this.sapiWebView.setAuthorizationListener(this.f39353j);
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            super.init();
            this.f39350g = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
            this.f39348e = getIntent().getStringExtra("extraJson");
            this.f39349f = getIntent().getBooleanExtra(m, false);
            this.f39351h.activity = this;
            this.f39346c = new Handler();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
                declaredField.setAccessible(false);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            setResult(i2);
        }
    }

    public List<PassNameValuePair> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
            WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
            if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
                arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
            } else if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
                arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra)));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            a(i2, -301, "您已取消操作");
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TextUtils.isEmpty(this.f39348e)) {
                return "";
            }
            try {
                return new JSONObject(this.f39348e).optString(l);
            } catch (Exception e2) {
                Log.e(e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes10.dex */
    public class a extends WebAuthResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSSOLoginActivity a;

        public a(BaseSSOLoginActivity baseSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseSSOLoginActivity;
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BaseSSOLoginActivity baseSSOLoginActivity = this.a;
                if (baseSSOLoginActivity.f39350g == 2001) {
                    baseSSOLoginActivity.b(1001);
                } else {
                    CoreViewRouter.getInstance().release();
                }
                this.a.finish();
            }
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                super.finishActivity(z);
                BaseSSOLoginActivity baseSSOLoginActivity = this.a;
                if (baseSSOLoginActivity.f39350g == 2001) {
                    baseSSOLoginActivity.b(1001);
                } else if (z) {
                    CoreViewRouter.getInstance().release();
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements com.baidu.sapi2.a.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSSOLoginActivity a;

        public b(BaseSSOLoginActivity baseSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseSSOLoginActivity;
        }

        @Override // com.baidu.sapi2.a.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                Intent intent = new Intent();
                intent.putExtra("response", str);
                this.a.a(3001, intent);
                this.a.finish();
            }
        }

        @Override // com.baidu.sapi2.a.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(3001);
                this.a.finish();
            }
        }
    }

    public void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            if (i2 == 2001) {
                Intent intent = new Intent();
                intent.putExtra("result_code", i3);
                intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
                a(1002, intent);
            } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                this.f39345b = true;
                this.f39351h.setResultCode(i3);
                this.f39351h.setResultMsg(str);
                CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.f39351h);
                CoreViewRouter.getInstance().release();
            }
            SapiUtils.hideSoftInput(this);
            finish();
        }
    }

    public void a(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, intent) == null) {
            setResult(i2, intent);
        }
    }

    public void a(SocialResponse socialResponse, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socialResponse, hashMap) == null) {
            if (socialResponse.errorCode == 302) {
                RelativeLayout relativeLayout = this.rootView;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                String str = hashMap.get("mkey");
                String str2 = hashMap.get("BAIDUID");
                String str3 = hashMap.get(HttpRequest.BDUSS);
                String str4 = hashMap.get("PTOKEN");
                String str5 = hashMap.get("STOKEN");
                String str6 = socialResponse.userInfoXmlContent;
                String str7 = socialResponse.nextUrl;
                SapiWebView sapiWebView = this.sapiWebView;
                if (sapiWebView != null) {
                    sapiWebView.loadThirdPartySSOLogin(str7, str6, str, str2, str3, str4, str5);
                    return;
                }
                return;
            }
            SapiAccount sapiAccountResponseToAccount = ((ThirdPartyService) CoreViewRouter.getInstance().getThirdPartyService()).sapiAccountResponseToAccount(this, socialResponse);
            if (SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
                socialResponse.errorCode = 0;
            }
            if (SapiContext.getInstance().mLastLoginType != null) {
                SapiContext.getInstance().setPreLoginType(SapiContext.getInstance().mLastLoginType.getName());
            }
            if (this.f39353j != null) {
                int i2 = socialResponse.errorCode;
                if (i2 != 0 && i2 != 110000) {
                    this.f39346c.post(new g(this, socialResponse));
                } else {
                    this.f39346c.post(new f(this, sapiAccountResponseToAccount));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, accountType) == null) {
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && !TextUtils.isEmpty(sapiWebView.touchidPortraitAndSign[0])) {
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                String[] strArr = this.sapiWebView.touchidPortraitAndSign;
                currentAccount.phone = strArr[0];
                currentAccount.email = strArr[1];
                SapiContext.getInstance().addTouchidAccounts(currentAccount);
            }
            AuthorizationListener authorizationListener = this.f39353j;
            if (authorizationListener != null) {
                try {
                    if (!AuthorizationListener.class.equals(authorizationListener.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                        this.f39353j.onSuccess(accountType);
                        return;
                    }
                } catch (NoSuchMethodException e2) {
                    Log.e(e2);
                }
                this.f39353j.onSuccess();
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            if (this.sapiWebView == null) {
                if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                    this.f39351h.setResultCode(-202);
                    this.f39351h.setResultMsg("网络连接失败，请检查网络设置");
                    CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.f39351h);
                }
                CoreViewRouter.getInstance().release();
                finish();
                return;
            }
            HashMap hashMap = new HashMap();
            WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
            WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
            if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
                hashMap.put("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra));
            } else if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
                hashMap.put("extrajson", WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra));
            }
            hashMap.put(l, b());
            hashMap.put("json", "1");
            String addExtras = ParamsUtil.addExtras(str, hashMap);
            new HttpClientWrap().get(addExtras, ReqPriority.IMMEDIATE, ParamsUtil.buildNaCookie(addExtras, this.configuration), new h(this, Looper.getMainLooper(), str2));
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            LoadingDialog createDialog = new LoadingDialog.Builder(this).setMessage(str).setCancelable(false).setCancelOutside(false).createDialog();
            this.f39347d = createDialog;
            if (createDialog.isShowing() || isFinishing()) {
                return;
            }
            this.f39347d.show();
        }
    }
}
