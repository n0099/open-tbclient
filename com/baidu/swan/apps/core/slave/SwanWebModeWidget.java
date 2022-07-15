package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cg3;
import com.repackage.dq2;
import com.repackage.g03;
import com.repackage.r63;
import com.repackage.v12;
import com.repackage.yd3;
import com.repackage.zf3;
/* loaded from: classes2.dex */
public class SwanWebModeWidget extends SwanAppWebViewWidget implements CallbackHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class SwanWebModeClient extends SwanAppWebViewWidget.WebViewWidgetClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanWebModeWidget this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SwanWebModeClient(SwanWebModeWidget swanWebModeWidget) {
            super(swanWebModeWidget);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanWebModeWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SwanAppWebViewWidget) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swanWebModeWidget;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdSailorWebView, str) == null) {
                v12 v12Var = this.this$0.U;
                if (v12Var != null) {
                    v12Var.e(str);
                }
                cg3.a().h(str);
                zf3.c().q(str);
                this.this$0.a2();
                zf3.c().l(str);
                super.onPageFinished(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str, bitmap) == null) {
                this.this$0.T = yd3.t();
                super.onPageStarted(bdSailorWebView, str, bitmap);
            }
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, i, str, str2) == null) {
                v12 v12Var = this.this$0.U;
                if (v12Var != null) {
                    v12Var.c(i, str, str2);
                }
                super.onReceivedError(bdSailorWebView, i, str, str2);
            }
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bdSailorWebView, str)) == null) {
                v12 v12Var = this.this$0.U;
                return v12Var != null && v12Var.b(str);
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ SwanWebModeClient(SwanWebModeWidget swanWebModeWidget, a aVar) {
            this(swanWebModeWidget);
        }
    }

    /* loaded from: classes2.dex */
    public class SwanWebWidgetClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanWebModeWidget this$0;

        public SwanWebWidgetClientExt(SwanWebModeWidget swanWebModeWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanWebModeWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swanWebModeWidget;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdSailorWebView, str) == null) {
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                cg3.a().c(str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                super.onFirstImagePaintExt(bdSailorWebView, str);
                cg3.a().d(str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                cg3.a().f(str);
                if (TextUtils.equals(zf3.c().f(), "3")) {
                    r63.s(g03.K().q().W());
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                super.onFirstTextPaintExt(bdSailorWebView, str);
                cg3.a().e(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanWebModeWidget(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a1(new SwanWebModeClient(this, null));
        b1(new SwanWebWidgetClientExt(this));
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void W0(SwanAppWebViewManager.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            super.W0(dVar);
            dVar.b = true;
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int b = dq2.b();
            dq2.g(b, dq2.a(b));
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "swan_app_web_mode_widget" : (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.hz1
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            v12 v12Var = this.U;
            if (v12Var != null) {
                v12Var.goBack();
            }
            return super.p();
        }
        return invokeV.booleanValue;
    }
}
