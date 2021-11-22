package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import b.a.p0.a.b3.d.b;
import b.a.p0.a.h0.j.d;
import b.a.p0.a.n2.e;
import b.a.p0.a.z2.n0;
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
/* loaded from: classes8.dex */
public class SwanWebModeWidget extends SwanAppWebViewWidget implements CallbackHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                d dVar = this.this$0.Y;
                if (dVar != null) {
                    dVar.e(str);
                }
                b.a().h(str);
                b.a.p0.a.b3.b.c().q(str);
                this.this$0.a2();
                b.a.p0.a.b3.b.c().l(str);
                super.onPageFinished(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str, bitmap) == null) {
                this.this$0.X = n0.t();
                super.onPageStarted(bdSailorWebView, str, bitmap);
            }
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, i2, str, str2) == null) {
                d dVar = this.this$0.Y;
                if (dVar != null) {
                    dVar.d(i2, str, str2);
                }
                super.onReceivedError(bdSailorWebView, i2, str, str2);
            }
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bdSailorWebView, str)) == null) {
                d dVar = this.this$0.Y;
                return dVar != null && dVar.c(str);
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ SwanWebModeClient(SwanWebModeWidget swanWebModeWidget, a aVar) {
            this(swanWebModeWidget);
        }
    }

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                b.a().c(str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                super.onFirstImagePaintExt(bdSailorWebView, str);
                b.a().d(str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                b.a().f(str);
                if (TextUtils.equals(b.a.p0.a.b3.b.c().f(), "3")) {
                    e.s(b.a.p0.a.d2.d.J().r().V());
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                super.onFirstTextPaintExt(bdSailorWebView, str);
                b.a().e(str);
            }
        }
    }

    /* loaded from: classes8.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            dVar.f44395b = true;
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
            int b2 = b.a.p0.a.k1.f.b.b();
            b.a.p0.a.k1.f.b.g(b2, b.a.p0.a.k1.f.b.a(b2));
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "swan_app_web_mode_widget" : (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.h0.f.c
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d dVar = this.Y;
            if (dVar != null) {
                dVar.goBack();
            }
            return super.p();
        }
        return invokeV.booleanValue;
    }
}
