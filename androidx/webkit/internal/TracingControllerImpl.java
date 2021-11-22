package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.webkit.TracingConfig;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.webkit.TracingConfig;
import androidx.webkit.TracingController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
/* loaded from: classes.dex */
public class TracingControllerImpl extends TracingController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TracingControllerBoundaryInterface mBoundaryInterface;
    public android.webkit.TracingController mFrameworksImpl;

    @SuppressLint({"NewApi"})
    public TracingControllerImpl() {
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
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            this.mFrameworksImpl = android.webkit.TracingController.getInstance();
            this.mBoundaryInterface = null;
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            this.mFrameworksImpl = null;
            this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getTracingController();
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    private TracingControllerBoundaryInterface getBoundaryInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mBoundaryInterface == null) {
                this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getTracingController();
            }
            return this.mBoundaryInterface;
        }
        return (TracingControllerBoundaryInterface) invokeV.objValue;
    }

    @RequiresApi(28)
    private android.webkit.TracingController getFrameworksImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.mFrameworksImpl == null) {
                this.mFrameworksImpl = android.webkit.TracingController.getInstance();
            }
            return this.mFrameworksImpl;
        }
        return (android.webkit.TracingController) invokeV.objValue;
    }

    @Override // androidx.webkit.TracingController
    @SuppressLint({"NewApi"})
    public boolean isTracing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                return getFrameworksImpl().isTracing();
            }
            if (webViewFeatureInternal.isSupportedByWebView()) {
                return getBoundaryInterface().isTracing();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.webkit.TracingController
    @SuppressLint({"NewApi"})
    public void start(@NonNull TracingConfig tracingConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tracingConfig) == null) {
            if (tracingConfig != null) {
                WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
                if (webViewFeatureInternal.isSupportedByFramework()) {
                    getFrameworksImpl().start(new TracingConfig.Builder().addCategories(tracingConfig.getPredefinedCategories()).addCategories(tracingConfig.getCustomIncludedCategories()).setTracingMode(tracingConfig.getTracingMode()).build());
                    return;
                } else if (webViewFeatureInternal.isSupportedByWebView()) {
                    getBoundaryInterface().start(tracingConfig.getPredefinedCategories(), tracingConfig.getCustomIncludedCategories(), tracingConfig.getTracingMode());
                    return;
                } else {
                    throw WebViewFeatureInternal.getUnsupportedOperationException();
                }
            }
            throw new IllegalArgumentException("Tracing config must be non null");
        }
    }

    @Override // androidx.webkit.TracingController
    @SuppressLint({"NewApi"})
    public boolean stop(OutputStream outputStream, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, outputStream, executor)) == null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                return getFrameworksImpl().stop(outputStream, executor);
            }
            if (webViewFeatureInternal.isSupportedByWebView()) {
                return getBoundaryInterface().stop(outputStream, executor);
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeLL.booleanValue;
    }
}
