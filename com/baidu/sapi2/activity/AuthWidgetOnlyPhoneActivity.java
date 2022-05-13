package com.baidu.sapi2.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.tbadk.core.atomData.YoungsterVerifyActivityConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AuthWidgetOnlyPhoneActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_PARAM_AUTH_ID = "EXTRA_PARAM_AUTH_ID";
    public static final String EXTRA_PARAM_SCENE = "EXTRA_PARAM_SCENE";
    public static final String w = "ppsdk://authwidget/u";
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public String u;
    public SapiResult v;

    public AuthWidgetOnlyPhoneActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new SapiResult();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.init();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onBottomBackBtnClick();
            a();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onClose();
            if (CoreViewRouter.getInstance().getAuthWidgetCallback() != null) {
                this.v.setResultCode(-301);
                this.v.setResultMsg("您已取消操作");
                CoreViewRouter.getInstance().getAuthWidgetCallback().onFailure(this.v);
            }
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d04d4);
            this.t = getIntent().getStringExtra("EXTRA_PARAM_AUTH_ID");
            this.u = getIntent().getStringExtra(EXTRA_PARAM_SCENE);
            init();
            setupViews();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onLeftBtnClick();
            if (this.executeSubClassMethod) {
                a();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.setupViews();
            this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback(this) { // from class: com.baidu.sapi2.activity.AuthWidgetOnlyPhoneActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AuthWidgetOnlyPhoneActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
                public void onBack() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a();
                    }
                }
            });
            this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.activity.AuthWidgetOnlyPhoneActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AuthWidgetOnlyPhoneActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.onClose();
                    }
                }
            });
            this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback(this) { // from class: com.baidu.sapi2.activity.AuthWidgetOnlyPhoneActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AuthWidgetOnlyPhoneActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback
                public void onLeftBtnVisible(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        if (i == 0) {
                            this.a.setBtnVisibility(4, 4, 4);
                        } else {
                            this.a.setBtnVisibility(4, 0, 4);
                        }
                    }
                }
            });
            this.sapiWebView.setWebviewClientCallback(new SapiWebView.WebviewClientCallback(this) { // from class: com.baidu.sapi2.activity.AuthWidgetOnlyPhoneActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AuthWidgetOnlyPhoneActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                    }
                }

                @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                    }
                }

                @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
                public void shouldOverrideUrlLoading(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) && !TextUtils.isEmpty(str) && str.contains(AuthWidgetOnlyPhoneActivity.w)) {
                        if (CoreViewRouter.getInstance().getAuthWidgetCallback() != null) {
                            CoreViewRouter.getInstance().getAuthWidgetCallback().onSuccess(this.a.t);
                        }
                        this.a.finish();
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("u", w));
            arrayList.add(new PassNameValuePair("scene", this.u));
            arrayList.add(new PassNameValuePair(YoungsterVerifyActivityConfig.PARAMA_AUTH_ID, this.t));
            this.sapiWebView.loadAuthWidget(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && sapiWebView.canGoBack()) {
                this.sapiWebView.goBack();
                return;
            }
            if (CoreViewRouter.getInstance().getAuthWidgetCallback() != null) {
                this.v.setResultCode(-301);
                this.v.setResultMsg("您已取消操作");
                CoreViewRouter.getInstance().getAuthWidgetCallback().onFailure(this.v);
            }
            finish();
        }
    }
}
