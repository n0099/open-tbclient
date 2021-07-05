package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.webkit.WebResourceError;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebResourceErrorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
/* loaded from: classes.dex */
public class WebResourceErrorImpl extends WebResourceErrorCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebResourceErrorBoundaryInterface mBoundaryInterface;
    public WebResourceError mFrameworksImpl;

    public WebResourceErrorImpl(@NonNull InvocationHandler invocationHandler) {
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
        this.mBoundaryInterface = (WebResourceErrorBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebResourceErrorBoundaryInterface.class, invocationHandler);
    }

    private WebResourceErrorBoundaryInterface getBoundaryInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.mBoundaryInterface == null) {
                this.mBoundaryInterface = (WebResourceErrorBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebResourceErrorBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertWebResourceError(this.mFrameworksImpl));
            }
            return this.mBoundaryInterface;
        }
        return (WebResourceErrorBoundaryInterface) invokeV.objValue;
    }

    @RequiresApi(23)
    private WebResourceError getFrameworksImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mFrameworksImpl == null) {
                this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertWebResourceError(Proxy.getInvocationHandler(this.mBoundaryInterface));
            }
            return this.mFrameworksImpl;
        }
        return (WebResourceError) invokeV.objValue;
    }

    @Override // androidx.webkit.WebResourceErrorCompat
    @NonNull
    @SuppressLint({"NewApi"})
    public CharSequence getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("WEB_RESOURCE_ERROR_GET_DESCRIPTION");
            if (feature.isSupportedByFramework()) {
                return getFrameworksImpl().getDescription();
            }
            if (feature.isSupportedByWebView()) {
                return getBoundaryInterface().getDescription();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.webkit.WebResourceErrorCompat
    @SuppressLint({"NewApi"})
    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("WEB_RESOURCE_ERROR_GET_CODE");
            if (feature.isSupportedByFramework()) {
                return getFrameworksImpl().getErrorCode();
            }
            if (feature.isSupportedByWebView()) {
                return getBoundaryInterface().getErrorCode();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeV.intValue;
    }

    public WebResourceErrorImpl(@NonNull WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webResourceError};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFrameworksImpl = webResourceError;
    }
}
