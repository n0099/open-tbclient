package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.e0.a.f;
import d.a.e0.a.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AccountRealNameActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_CUSTOM_LINK = "EXTRA_CUSTOM_LINK";
    public static final String EXTRA_NEED_CB_KEY = "EXTRA_NEED_CB_KEY";
    public static final String EXTRA_SCENE = "EXTRA_SCENE";
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public String u;
    public boolean v;
    public String w;
    public AccountRealNameResult x;

    public AccountRealNameActivity() {
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
        this.x = new AccountRealNameResult();
    }

    private void finishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (CoreViewRouter.getInstance().getAccountRealNameCallback() != null) {
                CoreViewRouter.getInstance().getAccountRealNameCallback().onFinish();
                CoreViewRouter.getInstance().getAccountRealNameCallback().onFinish(this.x);
            }
            finish();
            CoreViewRouter.getInstance().release();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CoreViewRouter.getInstance().getRealNameDTO() : (SapiWebDTO) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.init();
            Intent intent = getIntent();
            this.t = intent.getStringExtra("EXTRA_BDUSS");
            this.u = intent.getStringExtra(EXTRA_SCENE);
            this.v = intent.getBooleanExtra(EXTRA_NEED_CB_KEY, false);
            this.w = intent.getStringExtra(EXTRA_CUSTOM_LINK);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onBottomBackBtnClick();
            a();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onClose();
            AccountRealNameResult accountRealNameResult = this.x;
            if (!accountRealNameResult.juniorRealNameSuc && !accountRealNameResult.seniorRealNameSuc) {
                accountRealNameResult.setResultCode(-301);
                this.x.setResultMsg("您已取消操作");
            } else {
                this.x.setResultCode(0);
                this.x.setResultMsg("成功");
            }
            finishActivity();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(f.layout_sapi_sdk_webview_with_title_bar);
                init();
                setupViews();
            } catch (Throwable th) {
                reportWebviewError(th);
                this.x.setResultCode(-202);
                this.x.setResultMsg("网络连接失败，请检查网络设置");
                finishActivity();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onLeftBtnClick();
            if (this.executeSubClassMethod) {
                a();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.setupViews();
            setTitleText(g.sapi_sdk_title_real_name);
            this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback(this) { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AccountRealNameActivity f9669a;

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
                    this.f9669a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
                public boolean onBack() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        SapiWebView sapiWebView = this.f9669a.sapiWebView;
                        if (sapiWebView != null && sapiWebView.canGoBack()) {
                            this.f9669a.sapiWebView.goBack();
                            return false;
                        }
                        this.f9669a.onClose();
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            });
            this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AccountRealNameActivity f9670a;

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
                    this.f9670a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f9670a.onClose();
                    }
                }
            });
            this.sapiWebView.setRealNameStateCallback(new SapiJsCallBacks.RealNameStatusCallback(this) { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AccountRealNameActivity f9671a;

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
                    this.f9671a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.RealNameStatusCallback
                public void onFinish(AccountRealNameResult accountRealNameResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, accountRealNameResult) == null) {
                        this.f9671a.x = accountRealNameResult;
                    }
                }
            });
            b();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            if (!TextUtils.isEmpty(this.t)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("pp");
                SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback(this) { // from class: com.baidu.sapi2.activity.AccountRealNameActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AccountRealNameActivity f9672a;

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
                        this.f9672a = this;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetTplStokenResult getTplStokenResult) {
                        AccountRealNameActivity accountRealNameActivity;
                        SapiWebView sapiWebView;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, getTplStokenResult) == null) || (sapiWebView = (accountRealNameActivity = this.f9672a).sapiWebView) == null) {
                            return;
                        }
                        sapiWebView.loadAccountRealName(null, accountRealNameActivity.u, this.f9672a.v, this.f9672a.w);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetTplStokenResult getTplStokenResult) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048580, this, getTplStokenResult) == null) || this.f9672a.sapiWebView == null) {
                            return;
                        }
                        AccountRealNameActivity accountRealNameActivity = this.f9672a;
                        accountRealNameActivity.sapiWebView.loadAccountRealName(getTplStokenResult.tplStokenMap.get("pp"), accountRealNameActivity.u, this.f9672a.v, this.f9672a.w);
                    }
                }, this.t, arrayList);
                return;
            }
            Toast.makeText(this, getString(g.sapi_sdk_account_center_please_relogin), 1).show();
            finishActivity();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && sapiWebView.canGoBack()) {
                this.sapiWebView.back();
            } else {
                onClose();
            }
        }
    }
}
