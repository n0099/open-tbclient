package androidx.webkit.internal;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
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
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
/* loaded from: classes.dex */
public class WebViewProviderFactoryAdapter implements WebViewProviderFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebViewProviderFactoryBoundaryInterface mImpl;

    public WebViewProviderFactoryAdapter(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webViewProviderFactoryBoundaryInterface};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImpl = webViewProviderFactoryBoundaryInterface;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, webView)) == null) {
            return (WebViewProviderBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderBoundaryInterface.class, this.mImpl.createWebView(webView));
        }
        return (WebViewProviderBoundaryInterface) invokeL.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public ProxyControllerBoundaryInterface getProxyController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (ProxyControllerBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ProxyControllerBoundaryInterface.class, this.mImpl.getProxyController());
        }
        return (ProxyControllerBoundaryInterface) invokeV.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public ServiceWorkerControllerBoundaryInterface getServiceWorkerController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (ServiceWorkerControllerBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ServiceWorkerControllerBoundaryInterface.class, this.mImpl.getServiceWorkerController());
        }
        return (ServiceWorkerControllerBoundaryInterface) invokeV.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public StaticsBoundaryInterface getStatics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (StaticsBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(StaticsBoundaryInterface.class, this.mImpl.getStatics());
        }
        return (StaticsBoundaryInterface) invokeV.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public TracingControllerBoundaryInterface getTracingController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (TracingControllerBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(TracingControllerBoundaryInterface.class, this.mImpl.getTracingController());
        }
        return (TracingControllerBoundaryInterface) invokeV.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public String[] getWebViewFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImpl.getSupportedFeatures();
        }
        return (String[]) invokeV.objValue;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (WebkitToCompatConverterBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebkitToCompatConverterBoundaryInterface.class, this.mImpl.getWebkitToCompatConverter());
        }
        return (WebkitToCompatConverterBoundaryInterface) invokeV.objValue;
    }
}
