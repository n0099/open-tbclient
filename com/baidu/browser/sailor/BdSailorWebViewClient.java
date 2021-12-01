package com.baidu.browser.sailor;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ClientCertRequest;
import com.baidu.webkit.sdk.HttpAuthHandler;
import com.baidu.webkit.sdk.RenderProcessGoneDetail;
import com.baidu.webkit.sdk.WebResourceError;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
/* loaded from: classes8.dex */
public class BdSailorWebViewClient implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BdSailorWebViewClient() {
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

    public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, bdSailorWebView, str, z) == null) {
        }
    }

    public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, message, message2) == null) {
            message.sendToTarget();
        }
    }

    public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
        }
    }

    public void onPageCommitVisible(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
        }
    }

    public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
        }
    }

    public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, bdSailorWebView, str, bitmap) == null) {
        }
    }

    public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bdSailorWebView, clientCertRequest) == null) {
            clientCertRequest.cancel();
        }
    }

    public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048583, this, bdSailorWebView, i2, str, str2) == null) {
        }
    }

    public void onReceivedError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdSailorWebView, webResourceRequest, webResourceError) == null) {
        }
    }

    public void onReceivedHttpAuthRequest(BdSailorWebView bdSailorWebView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, bdSailorWebView, httpAuthHandler, str, str2) == null) {
            httpAuthHandler.cancel();
        }
    }

    public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, bdSailorWebView, webResourceRequest, webResourceResponse) == null) {
        }
    }

    public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, bdSailorWebView, str, str2, str3) == null) {
        }
    }

    public void onReceivedSslError(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, bdSailorWebView, sslErrorHandler, sslError) == null) {
            sslErrorHandler.cancel();
        }
    }

    public boolean onRenderProcessGone(BdSailorWebView bdSailorWebView, RenderProcessGoneDetail renderProcessGoneDetail) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, bdSailorWebView, renderProcessGoneDetail)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void onScaleChanged(BdSailorWebView bdSailorWebView, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{bdSailorWebView, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
        }
    }

    public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bdSailorWebView, keyEvent) == null) {
        }
    }

    public WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, bdSailorWebView, webResourceRequest)) == null) {
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    @Deprecated
    public WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, bdSailorWebView, str)) == null) {
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, bdSailorWebView, keyEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, bdSailorWebView, webResourceRequest)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, bdSailorWebView, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }
}
