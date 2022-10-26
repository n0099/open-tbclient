package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import androidx.webkit.SafeBrowsingResponseCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
/* loaded from: classes.dex */
public class SafeBrowsingResponseImpl extends SafeBrowsingResponseCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SafeBrowsingResponseBoundaryInterface mBoundaryInterface;
    public SafeBrowsingResponse mFrameworksImpl;

    public SafeBrowsingResponseImpl(SafeBrowsingResponse safeBrowsingResponse) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {safeBrowsingResponse};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFrameworksImpl = safeBrowsingResponse;
    }

    public SafeBrowsingResponseImpl(InvocationHandler invocationHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invocationHandler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBoundaryInterface = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    @Override // androidx.webkit.SafeBrowsingResponseCompat
    public void backToSafety(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");
            if (feature.isSupportedByFramework()) {
                getFrameworksImpl().backToSafety(z);
            } else if (feature.isSupportedByWebView()) {
                getBoundaryInterface().backToSafety(z);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @Override // androidx.webkit.SafeBrowsingResponseCompat
    public void proceed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_RESPONSE_PROCEED");
            if (feature.isSupportedByFramework()) {
                getFrameworksImpl().proceed(z);
            } else if (feature.isSupportedByWebView()) {
                getBoundaryInterface().proceed(z);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @Override // androidx.webkit.SafeBrowsingResponseCompat
    public void showInterstitial(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
            if (feature.isSupportedByFramework()) {
                getFrameworksImpl().showInterstitial(z);
            } else if (feature.isSupportedByWebView()) {
                getBoundaryInterface().showInterstitial(z);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    private SafeBrowsingResponseBoundaryInterface getBoundaryInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.mBoundaryInterface == null) {
                this.mBoundaryInterface = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertSafeBrowsingResponse(this.mFrameworksImpl));
            }
            return this.mBoundaryInterface;
        }
        return (SafeBrowsingResponseBoundaryInterface) invokeV.objValue;
    }

    private SafeBrowsingResponse getFrameworksImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mFrameworksImpl == null) {
                this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertSafeBrowsingResponse(Proxy.getInvocationHandler(this.mBoundaryInterface));
            }
            return this.mFrameworksImpl;
        }
        return (SafeBrowsingResponse) invokeV.objValue;
    }
}
