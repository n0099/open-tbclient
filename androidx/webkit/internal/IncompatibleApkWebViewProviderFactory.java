package androidx.webkit.internal;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
/* loaded from: classes.dex */
public class IncompatibleApkWebViewProviderFactory implements WebViewProviderFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] EMPTY_STRING_ARRAY;
    public static final String UNSUPPORTED_EXCEPTION_EXPLANATION = "This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2106974121, "Landroidx/webkit/internal/IncompatibleApkWebViewProviderFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2106974121, "Landroidx/webkit/internal/IncompatibleApkWebViewProviderFactory;");
                return;
            }
        }
        EMPTY_STRING_ARRAY = new String[0];
    }

    public IncompatibleApkWebViewProviderFactory() {
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

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, webView)) == null) {
            throw new UnsupportedOperationException(UNSUPPORTED_EXCEPTION_EXPLANATION);
        }
        return (WebViewProviderBoundaryInterface) invokeL.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public ProxyControllerBoundaryInterface getProxyController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new UnsupportedOperationException(UNSUPPORTED_EXCEPTION_EXPLANATION);
        }
        return (ProxyControllerBoundaryInterface) invokeV.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public ServiceWorkerControllerBoundaryInterface getServiceWorkerController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new UnsupportedOperationException(UNSUPPORTED_EXCEPTION_EXPLANATION);
        }
        return (ServiceWorkerControllerBoundaryInterface) invokeV.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public StaticsBoundaryInterface getStatics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new UnsupportedOperationException(UNSUPPORTED_EXCEPTION_EXPLANATION);
        }
        return (StaticsBoundaryInterface) invokeV.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public TracingControllerBoundaryInterface getTracingController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            throw new UnsupportedOperationException(UNSUPPORTED_EXCEPTION_EXPLANATION);
        }
        return (TracingControllerBoundaryInterface) invokeV.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public String[] getWebViewFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? EMPTY_STRING_ARRAY : (String[]) invokeV.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new UnsupportedOperationException(UNSUPPORTED_EXCEPTION_EXPLANATION);
        }
        return (WebkitToCompatConverterBoundaryInterface) invokeV.objValue;
    }
}
