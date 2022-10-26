package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface;
/* loaded from: classes.dex */
public class WebViewRenderProcessClientAdapter implements WebViewRendererClientBoundaryInterface {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] sSupportedFeatures;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor mExecutor;
    public final WebViewRenderProcessClient mWebViewRenderProcessClient;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-972471946, "Landroidx/webkit/internal/WebViewRenderProcessClientAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-972471946, "Landroidx/webkit/internal/WebViewRenderProcessClientAdapter;");
                return;
            }
        }
        sSupportedFeatures = new String[]{"WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE"};
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return sSupportedFeatures;
        }
        return (String[]) invokeV.objValue;
    }

    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mWebViewRenderProcessClient;
        }
        return (WebViewRenderProcessClient) invokeV.objValue;
    }

    public WebViewRenderProcessClientAdapter(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, webViewRenderProcessClient};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mExecutor = executor;
        this.mWebViewRenderProcessClient = webViewRenderProcessClient;
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public final void onRendererResponsive(WebView webView, InvocationHandler invocationHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, invocationHandler) == null) {
            WebViewRenderProcessImpl forInvocationHandler = WebViewRenderProcessImpl.forInvocationHandler(invocationHandler);
            WebViewRenderProcessClient webViewRenderProcessClient = this.mWebViewRenderProcessClient;
            Executor executor = this.mExecutor;
            if (executor == null) {
                webViewRenderProcessClient.onRenderProcessResponsive(webView, forInvocationHandler);
            } else {
                executor.execute(new Runnable(this, webViewRenderProcessClient, webView, forInvocationHandler) { // from class: androidx.webkit.internal.WebViewRenderProcessClientAdapter.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WebViewRenderProcessClientAdapter this$0;
                    public final /* synthetic */ WebViewRenderProcessClient val$client;
                    public final /* synthetic */ WebViewRenderProcess val$rendererObject;
                    public final /* synthetic */ WebView val$view;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, webViewRenderProcessClient, webView, forInvocationHandler};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$client = webViewRenderProcessClient;
                        this.val$view = webView;
                        this.val$rendererObject = forInvocationHandler;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$client.onRenderProcessResponsive(this.val$view, this.val$rendererObject);
                        }
                    }
                });
            }
        }
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public final void onRendererUnresponsive(WebView webView, InvocationHandler invocationHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, webView, invocationHandler) == null) {
            WebViewRenderProcessImpl forInvocationHandler = WebViewRenderProcessImpl.forInvocationHandler(invocationHandler);
            WebViewRenderProcessClient webViewRenderProcessClient = this.mWebViewRenderProcessClient;
            Executor executor = this.mExecutor;
            if (executor == null) {
                webViewRenderProcessClient.onRenderProcessUnresponsive(webView, forInvocationHandler);
            } else {
                executor.execute(new Runnable(this, webViewRenderProcessClient, webView, forInvocationHandler) { // from class: androidx.webkit.internal.WebViewRenderProcessClientAdapter.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WebViewRenderProcessClientAdapter this$0;
                    public final /* synthetic */ WebViewRenderProcessClient val$client;
                    public final /* synthetic */ WebViewRenderProcess val$rendererObject;
                    public final /* synthetic */ WebView val$view;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, webViewRenderProcessClient, webView, forInvocationHandler};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$client = webViewRenderProcessClient;
                        this.val$view = webView;
                        this.val$rendererObject = forInvocationHandler;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$client.onRenderProcessUnresponsive(this.val$view, this.val$rendererObject);
                        }
                    }
                });
            }
        }
    }
}
