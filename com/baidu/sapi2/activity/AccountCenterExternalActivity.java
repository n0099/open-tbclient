package com.baidu.sapi2.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes2.dex */
public class AccountCenterExternalActivity extends AccountCenterActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_EXTERNAL_IS_ACCOUNT_CENTER_TITLEBAR = "extra_external_is_account_center_titlebar";
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    public static final String K;
    public transient /* synthetic */ FieldHolder $fh;
    public String J;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1209529293, "Lcom/baidu/sapi2/activity/AccountCenterExternalActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1209529293, "Lcom/baidu/sapi2/activity/AccountCenterExternalActivity;");
                return;
            }
        }
        K = AccountCenterExternalActivity.class.getSimpleName();
    }

    public AccountCenterExternalActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void finishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
        }
    }

    @Override // com.baidu.sapi2.activity.AccountCenterActivity
    public void loadAccountCenter(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String stringExtra = getIntent().getStringExtra("extra_external_url");
            this.J = stringExtra;
            this.sapiWebView.loadUrl(stringExtra);
        }
    }

    @Override // com.baidu.sapi2.activity.AccountCenterActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 1004 && i3 == -1) {
                b();
                this.loginStatusChange = true;
            }
        }
    }

    @Override // com.baidu.sapi2.activity.AccountCenterActivity, com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a();
        }
    }

    @Override // com.baidu.sapi2.activity.AccountCenterActivity, com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.mIsAccountCenterTitleBar = intent.getBooleanExtra(EXTRA_EXTERNAL_IS_ACCOUNT_CENTER_TITLEBAR, false);
            }
            super.onCreate(bundle);
            Log.d(K, "AccountCenterExternalActivity onCreate");
            this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterExternalActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AccountCenterExternalActivity f9681a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9681a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
                public boolean onBack() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        this.f9681a.a();
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            });
            this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterExternalActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AccountCenterExternalActivity f9682a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9682a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f9682a.finishActivity();
                    }
                }
            });
            this.sapiWebView.setOnSlidePageFinishCallback(new SapiWebView.OnSlidePageFinishCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterExternalActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AccountCenterExternalActivity f9683a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9683a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnSlidePageFinishCallback
                public void onFinish(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        if (SlideActiviy.ACCOUNT_CENTER_PAGE_NAME.equals(str)) {
                            Intent intent2 = new Intent(this.f9683a, AccountCenterActivity.class);
                            intent2.setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                            this.f9683a.startActivity(intent2);
                        }
                        if (SlideActiviy.SLIDE_ACTION_QUIT.equals(str)) {
                            this.f9683a.b();
                        }
                    }
                }
            });
            this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterExternalActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AccountCenterExternalActivity f9684a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9684a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
                public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, result) == null) {
                        AccountCenterCallback accountCenterCallback = CoreViewRouter.getInstance().getAccountCenterCallback();
                        AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
                        if (accountCenterDTO != null && accountCenterDTO.handleLogin && accountCenterCallback != null) {
                            AccountCenterResult accountCenterResult = new AccountCenterResult(this) { // from class: com.baidu.sapi2.activity.AccountCenterExternalActivity.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f9685a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f9685a = this;
                                }

                                @Override // com.baidu.sapi2.result.AccountCenterResult
                                public void loginSuc() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        super.loginSuc();
                                        this.f9685a.f9684a.b();
                                        this.f9685a.f9684a.loginStatusChange = true;
                                    }
                                }
                            };
                            if (result.switchAccountType == 1) {
                                accountCenterResult.preSetUserName = result.userName;
                            }
                            if (result.switchAccountType == 2) {
                                accountCenterResult.preSetUserName = result.displayName;
                                accountCenterResult.encryptedId = result.encryptedUid;
                            }
                            accountCenterResult.setResultCode(-10001);
                            accountCenterResult.setResultMsg("请登录");
                            accountCenterCallback.onFinish(accountCenterResult);
                            return;
                        }
                        Intent intent2 = new Intent(this.f9684a, LoginActivity.class);
                        intent2.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2003);
                        int i2 = result.switchAccountType;
                        if (i2 == 1) {
                            intent2.putExtra("username", result.userName);
                        } else if (i2 == 2) {
                            if (result.loginType == 0) {
                                intent2.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME);
                            } else {
                                intent2.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                            }
                            intent2.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, true);
                            if (!TextUtils.isEmpty(result.displayName)) {
                                intent2.putExtra("username", result.displayName);
                            }
                            intent2.putExtra(LoginActivity.EXTRA_PARAM_ENCRYPTED_UID, result.encryptedUid);
                        }
                        this.f9684a.startActivityForResult(intent2, 1004);
                    }
                }
            });
        }
    }

    @Override // com.baidu.sapi2.activity.AccountCenterActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            Intent intent = new Intent(this, AccountCenterActivity.class);
            intent.setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            intent.putExtra("action", SlideActiviy.SLIDE_ACTION_QUIT);
            PendingIntent.getActivity(getApplicationContext(), 0, intent, 134217728);
            startActivity(intent);
        }
    }
}
