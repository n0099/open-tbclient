package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.webkit.ServiceWorkerWebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.webkit.ServiceWorkerWebSettingsCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.ServiceWorkerWebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
/* loaded from: classes.dex */
public class ServiceWorkerWebSettingsImpl extends ServiceWorkerWebSettingsCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ServiceWorkerWebSettingsBoundaryInterface mBoundaryInterface;
    public ServiceWorkerWebSettings mFrameworksImpl;

    public ServiceWorkerWebSettingsImpl(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {serviceWorkerWebSettings};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFrameworksImpl = serviceWorkerWebSettings;
    }

    private ServiceWorkerWebSettingsBoundaryInterface getBoundaryInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.mBoundaryInterface == null) {
                this.mBoundaryInterface = (ServiceWorkerWebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ServiceWorkerWebSettingsBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertServiceWorkerSettings(this.mFrameworksImpl));
            }
            return this.mBoundaryInterface;
        }
        return (ServiceWorkerWebSettingsBoundaryInterface) invokeV.objValue;
    }

    @RequiresApi(24)
    private ServiceWorkerWebSettings getFrameworksImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mFrameworksImpl == null) {
                this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertServiceWorkerSettings(Proxy.getInvocationHandler(this.mBoundaryInterface));
            }
            return this.mFrameworksImpl;
        }
        return (ServiceWorkerWebSettings) invokeV.objValue;
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    @SuppressLint({"NewApi"})
    public boolean getAllowContentAccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SERVICE_WORKER_CONTENT_ACCESS;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                return getFrameworksImpl().getAllowContentAccess();
            }
            if (webViewFeatureInternal.isSupportedByWebView()) {
                return getBoundaryInterface().getAllowContentAccess();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    @SuppressLint({"NewApi"})
    public boolean getAllowFileAccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SERVICE_WORKER_FILE_ACCESS;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                return getFrameworksImpl().getAllowFileAccess();
            }
            if (webViewFeatureInternal.isSupportedByWebView()) {
                return getBoundaryInterface().getAllowFileAccess();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    @SuppressLint({"NewApi"})
    public boolean getBlockNetworkLoads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SERVICE_WORKER_BLOCK_NETWORK_LOADS;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                return getFrameworksImpl().getBlockNetworkLoads();
            }
            if (webViewFeatureInternal.isSupportedByWebView()) {
                return getBoundaryInterface().getBlockNetworkLoads();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    @SuppressLint({"NewApi"})
    public int getCacheMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SERVICE_WORKER_CACHE_MODE;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                return getFrameworksImpl().getCacheMode();
            }
            if (webViewFeatureInternal.isSupportedByWebView()) {
                return getBoundaryInterface().getCacheMode();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeV.intValue;
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    @SuppressLint({"NewApi"})
    public void setAllowContentAccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SERVICE_WORKER_CONTENT_ACCESS;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                getFrameworksImpl().setAllowContentAccess(z);
            } else if (webViewFeatureInternal.isSupportedByWebView()) {
                getBoundaryInterface().setAllowContentAccess(z);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    @SuppressLint({"NewApi"})
    public void setAllowFileAccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SERVICE_WORKER_FILE_ACCESS;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                getFrameworksImpl().setAllowFileAccess(z);
            } else if (webViewFeatureInternal.isSupportedByWebView()) {
                getBoundaryInterface().setAllowFileAccess(z);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    @SuppressLint({"NewApi"})
    public void setBlockNetworkLoads(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SERVICE_WORKER_BLOCK_NETWORK_LOADS;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                getFrameworksImpl().setBlockNetworkLoads(z);
            } else if (webViewFeatureInternal.isSupportedByWebView()) {
                getBoundaryInterface().setBlockNetworkLoads(z);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    @SuppressLint({"NewApi"})
    public void setCacheMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SERVICE_WORKER_CACHE_MODE;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                getFrameworksImpl().setCacheMode(i2);
            } else if (webViewFeatureInternal.isSupportedByWebView()) {
                getBoundaryInterface().setCacheMode(i2);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    public ServiceWorkerWebSettingsImpl(@NonNull InvocationHandler invocationHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invocationHandler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBoundaryInterface = (ServiceWorkerWebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ServiceWorkerWebSettingsBoundaryInterface.class, invocationHandler);
    }
}
