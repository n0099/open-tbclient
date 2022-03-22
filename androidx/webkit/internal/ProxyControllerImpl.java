package androidx.webkit.internal;

import androidx.annotation.NonNull;
import androidx.webkit.ProxyConfig;
import androidx.webkit.ProxyController;
import androidx.webkit.WebViewFeature;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
/* loaded from: classes.dex */
public class ProxyControllerImpl extends ProxyController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProxyControllerBoundaryInterface mBoundaryInterface;

    public ProxyControllerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private ProxyControllerBoundaryInterface getBoundaryInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mBoundaryInterface == null) {
                this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getProxyController();
            }
            return this.mBoundaryInterface;
        }
        return (ProxyControllerBoundaryInterface) invokeV.objValue;
    }

    @Override // androidx.webkit.ProxyController
    public void clearProxyOverride(@NonNull Executor executor, @NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, executor, runnable) == null) {
            if (WebViewFeatureInternal.getFeature(WebViewFeature.PROXY_OVERRIDE).isSupportedByWebView()) {
                getBoundaryInterface().clearProxyOverride(runnable, executor);
                return;
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @Override // androidx.webkit.ProxyController
    public void setProxyOverride(@NonNull ProxyConfig proxyConfig, @NonNull Executor executor, @NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, proxyConfig, executor, runnable) == null) {
            if (WebViewFeatureInternal.getFeature(WebViewFeature.PROXY_OVERRIDE).isSupportedByWebView()) {
                List<ProxyConfig.ProxyRule> proxyRules = proxyConfig.getProxyRules();
                String[][] strArr = (String[][]) Array.newInstance(String.class, proxyRules.size(), 2);
                for (int i = 0; i < proxyRules.size(); i++) {
                    strArr[i][0] = proxyRules.get(0).getSchemeFilter();
                    strArr[i][1] = proxyRules.get(0).getUrl();
                }
                getBoundaryInterface().setProxyOverride(strArr, (String[]) proxyConfig.getBypassRules().toArray(new String[0]), runnable, executor);
                return;
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }
}
