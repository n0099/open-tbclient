package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebResourceRequestBoundaryInterface;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
/* loaded from: classes.dex */
public class WebkitToCompatConverter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebkitToCompatConverterBoundaryInterface mImpl;

    public WebkitToCompatConverter(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webkitToCompatConverterBoundaryInterface};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImpl = webkitToCompatConverterBoundaryInterface;
    }

    public InvocationHandler convertSafeBrowsingResponse(SafeBrowsingResponse safeBrowsingResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, safeBrowsingResponse)) == null) ? this.mImpl.convertSafeBrowsingResponse(safeBrowsingResponse) : (InvocationHandler) invokeL.objValue;
    }

    public InvocationHandler convertServiceWorkerSettings(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, serviceWorkerWebSettings)) == null) ? this.mImpl.convertServiceWorkerSettings(serviceWorkerWebSettings) : (InvocationHandler) invokeL.objValue;
    }

    public WebSettingsAdapter convertSettings(WebSettings webSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, webSettings)) == null) ? new WebSettingsAdapter((WebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebSettingsBoundaryInterface.class, this.mImpl.convertSettings(webSettings))) : (WebSettingsAdapter) invokeL.objValue;
    }

    public InvocationHandler convertWebMessagePort(WebMessagePort webMessagePort) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, webMessagePort)) == null) ? this.mImpl.convertWebMessagePort(webMessagePort) : (InvocationHandler) invokeL.objValue;
    }

    public InvocationHandler convertWebResourceError(WebResourceError webResourceError) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webResourceError)) == null) ? this.mImpl.convertWebResourceError(webResourceError) : (InvocationHandler) invokeL.objValue;
    }

    public WebResourceRequestAdapter convertWebResourceRequest(WebResourceRequest webResourceRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, webResourceRequest)) == null) ? new WebResourceRequestAdapter((WebResourceRequestBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebResourceRequestBoundaryInterface.class, this.mImpl.convertWebResourceRequest(webResourceRequest))) : (WebResourceRequestAdapter) invokeL.objValue;
    }

    @RequiresApi(27)
    public SafeBrowsingResponse convertSafeBrowsingResponse(InvocationHandler invocationHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, invocationHandler)) == null) ? (SafeBrowsingResponse) this.mImpl.convertSafeBrowsingResponse(invocationHandler) : (SafeBrowsingResponse) invokeL.objValue;
    }

    @RequiresApi(24)
    public ServiceWorkerWebSettings convertServiceWorkerSettings(InvocationHandler invocationHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, invocationHandler)) == null) ? (ServiceWorkerWebSettings) this.mImpl.convertServiceWorkerSettings(invocationHandler) : (ServiceWorkerWebSettings) invokeL.objValue;
    }

    @RequiresApi(23)
    public WebMessagePort convertWebMessagePort(InvocationHandler invocationHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, invocationHandler)) == null) ? (WebMessagePort) this.mImpl.convertWebMessagePort(invocationHandler) : (WebMessagePort) invokeL.objValue;
    }

    @RequiresApi(23)
    public WebResourceError convertWebResourceError(InvocationHandler invocationHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, invocationHandler)) == null) ? (WebResourceError) this.mImpl.convertWebResourceError(invocationHandler) : (WebResourceError) invokeL.objValue;
    }
}
