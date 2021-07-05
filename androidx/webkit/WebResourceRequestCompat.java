package androidx.webkit;

import android.annotation.SuppressLint;
import android.webkit.WebResourceRequest;
import androidx.annotation.NonNull;
import androidx.webkit.internal.WebResourceRequestAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class WebResourceRequestCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WebResourceRequestCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static WebResourceRequestAdapter getAdapter(WebResourceRequest webResourceRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webResourceRequest)) == null) ? WebViewGlueCommunicator.getCompatConverter().convertWebResourceRequest(webResourceRequest) : (WebResourceRequestAdapter) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static boolean isRedirect(@NonNull WebResourceRequest webResourceRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, webResourceRequest)) == null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.WEB_RESOURCE_REQUEST_IS_REDIRECT;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                return webResourceRequest.isRedirect();
            }
            if (webViewFeatureInternal.isSupportedByWebView()) {
                return getAdapter(webResourceRequest).isRedirect();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }
}
