package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.b0.a.f;
import d.a.b0.a.g;
/* loaded from: classes2.dex */
public class RegisterActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebAuthResult t;

    public RegisterActivity() {
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
        this.t = new WebAuthResult(this) { // from class: com.baidu.sapi2.activity.RegisterActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RegisterActivity f9854a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f9854a = this;
            }

            @Override // com.baidu.sapi2.shell.result.WebAuthResult
            public void finishActivity() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.finishActivity();
                    this.f9854a.finish();
                    CoreViewRouter.getInstance().release();
                }
            }
        };
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CoreViewRouter.getInstance().getWebRegDTO() : (SapiWebDTO) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.init();
            this.t.activity = this;
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.sapiWebView.back();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onClose();
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            this.t.setResultCode(-301);
            this.t.setResultMsg("您已取消操作");
            if (webAuthListener != null) {
                webAuthListener.onFailure(this.t);
            }
            finish();
            CoreViewRouter.getInstance().release();
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
                WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                if (webAuthListener != null) {
                    this.t.setResultCode(-202);
                    this.t.setResultMsg("网络连接失败，请检查网络设置");
                    webAuthListener.onFailure(this.t);
                }
                finish();
                CoreViewRouter.getInstance().release();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onLeftBtnClick();
            if (this.executeSubClassMethod) {
                this.sapiWebView.back();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.setupViews();
            setTitleText(g.sapi_sdk_title_register);
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.activity.RegisterActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RegisterActivity f9855a;

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
                    this.f9855a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f9855a.onClose();
                    }
                }
            });
            this.sapiWebView.setAuthorizationListener(new AuthorizationListener(this, webAuthListener) { // from class: com.baidu.sapi2.activity.RegisterActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WebAuthListener f9856a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ RegisterActivity f9857b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, webAuthListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9857b = this;
                    this.f9856a = webAuthListener;
                }

                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void beforeSuccess(SapiAccount sapiAccount) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, sapiAccount) == null) {
                        super.beforeSuccess(sapiAccount);
                        WebAuthListener webAuthListener2 = this.f9856a;
                        if (webAuthListener2 != null) {
                            webAuthListener2.beforeSuccess(sapiAccount);
                        }
                    }
                }

                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void onFailed(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f9857b.t.setResultCode(i2);
                        this.f9857b.t.setResultMsg(str);
                        WebAuthListener webAuthListener2 = this.f9856a;
                        if (webAuthListener2 != null) {
                            webAuthListener2.onFailure(this.f9857b.t);
                        }
                        this.f9857b.finish();
                        CoreViewRouter.getInstance().release();
                    }
                }

                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void onSuccess(AccountType accountType) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountType) == null) {
                        super.onSuccess(accountType);
                        this.f9857b.t.accountType = accountType;
                        this.f9857b.t.setResultCode(0);
                        WebAuthListener webAuthListener2 = this.f9856a;
                        if (webAuthListener2 != null) {
                            webAuthListener2.onSuccess(this.f9857b.t);
                        }
                        WebRegDTO webRegDTO = CoreViewRouter.getInstance().getWebRegDTO();
                        if (webRegDTO == null || !webRegDTO.finishActivityAfterSuc) {
                            return;
                        }
                        this.f9857b.finish();
                        CoreViewRouter.getInstance().release();
                    }
                }
            });
            setNewLoginTitleAndSetStyleChangeCallBack();
            WebRegDTO webRegDTO = CoreViewRouter.getInstance().getWebRegDTO();
            this.sapiWebView.loadRegist(webRegDTO != null ? webRegDTO.extraParams : null);
        }
    }
}
