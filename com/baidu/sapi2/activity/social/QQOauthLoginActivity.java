package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.UnionInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class QQOauthLoginActivity extends BaseSSOLoginActivity implements com.baidu.sapi2.a.a.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String p = "QQOauthLoginActivity";
    public static final String q = "QQ未安装";
    public transient /* synthetic */ FieldHolder $fh;
    public IUiListener n;
    public ThirdLoginCallback o;

    /* loaded from: classes2.dex */
    public class a implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Tencent a;
        public final /* synthetic */ com.baidu.sapi2.a.a.a b;
        public final /* synthetic */ QQOauthLoginActivity c;

        public a(QQOauthLoginActivity qQOauthLoginActivity, Tencent tencent, com.baidu.sapi2.a.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qQOauthLoginActivity, tencent, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qQOauthLoginActivity;
            this.a = tencent;
            this.b = aVar;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (obj instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    String optString = jSONObject.optString("access_token");
                    String optString2 = jSONObject.optString("expires_in");
                    String optString3 = jSONObject.optString("openid");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        this.a.setAccessToken(optString, optString2);
                        this.a.setOpenId(optString3);
                        this.c.a(this.a, this.b);
                        return;
                    }
                    this.b.a();
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                this.b.a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                Log.e(QQOauthLoginActivity.p, Integer.valueOf(i));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.sapi2.a.a.a a;
        public final /* synthetic */ Tencent b;
        public final /* synthetic */ QQOauthLoginActivity c;

        public b(QQOauthLoginActivity qQOauthLoginActivity, com.baidu.sapi2.a.a.a aVar, Tencent tencent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qQOauthLoginActivity, aVar, tencent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qQOauthLoginActivity;
            this.a = aVar;
            this.b = tencent;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (obj != null) {
                    this.a.a(this.b.getAccessToken(), this.b.getOpenId(), ((JSONObject) obj).optString("unionid"));
                    return;
                }
                this.a.a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                this.a.a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                Log.e(QQOauthLoginActivity.p, Integer.valueOf(i));
            }
        }
    }

    public QQOauthLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            Log.d(p, "requestCode = " + i + " resultCode = " + i2 + " data = " + intent);
            if (i == 11101 || i == 10102) {
                Tencent.onActivityResultData(i, i2, intent, this.n);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setupViews();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.setupViews();
            this.o = ThirdPartyService.getThirdLoginCallback();
            ThirdPartyService.releaseThirdLoginCallback();
            try {
                a((com.baidu.sapi2.a.a.a) this);
            } catch (Exception e) {
                e.printStackTrace();
                finish();
            }
        }
    }

    private void a(com.baidu.sapi2.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, aVar) == null) || aVar == null) {
            return;
        }
        Tencent createInstance = Tencent.createInstance(this.configuration.qqAppID, this);
        if (!SapiUtils.isAppInstalled(this, "com.tencent.mobileqq")) {
            Toast.makeText(this.configuration.context, q, 0).show();
            aVar.a();
            return;
        }
        a aVar2 = new a(this, createInstance, aVar);
        this.n = aVar2;
        createInstance.login(this, "all", aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Tencent tencent, com.baidu.sapi2.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, tencent, aVar) == null) {
            if (tencent != null && tencent.isSessionValid()) {
                new UnionInfo(this, tencent.getQQToken()).getUnionId(new b(this, aVar, tencent));
            } else {
                aVar.a();
            }
        }
    }

    @Override // com.baidu.sapi2.a.a.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.d(p, "onAuthFailure");
            ThirdLoginCallback thirdLoginCallback = this.o;
            if (thirdLoginCallback != null) {
                thirdLoginCallback.onAuthFailure(-100, "QQ授权失败");
            }
            finish();
        }
    }

    @Override // com.baidu.sapi2.a.a.a
    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            Log.d(p, "onAuthSuccess");
            String urlQQBind = ParamsUtil.getUrlQQBind(this.configuration, str, str2, str3);
            ThirdLoginCallback thirdLoginCallback = this.o;
            if (thirdLoginCallback != null) {
                thirdLoginCallback.onAuthSuccess();
            }
            com.baidu.sapi2.activity.social.a.a().a(urlQQBind, this.o);
            finish();
        }
    }
}
