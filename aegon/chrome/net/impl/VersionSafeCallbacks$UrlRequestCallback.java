package aegon.chrome.net.impl;

import aegon.chrome.net.CronetException;
import aegon.chrome.net.UrlRequest;
import aegon.chrome.net.UrlResponseInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class VersionSafeCallbacks$UrlRequestCallback extends UrlRequest.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final UrlRequest.Callback mWrappedCallback;

    public VersionSafeCallbacks$UrlRequestCallback(UrlRequest.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWrappedCallback = callback;
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, urlRequest, urlResponseInfo) == null) {
            this.mWrappedCallback.onCanceled(urlRequest, urlResponseInfo);
        }
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlRequest, urlResponseInfo, cronetException) == null) {
            this.mWrappedCallback.onFailed(urlRequest, urlResponseInfo, cronetException);
        }
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, urlRequest, urlResponseInfo, byteBuffer) == null) {
            this.mWrappedCallback.onReadCompleted(urlRequest, urlResponseInfo, byteBuffer);
        }
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, urlRequest, urlResponseInfo, str) == null) {
            this.mWrappedCallback.onRedirectReceived(urlRequest, urlResponseInfo, str);
        }
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, urlRequest, urlResponseInfo) == null) {
            this.mWrappedCallback.onResponseStarted(urlRequest, urlResponseInfo);
        }
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, urlRequest, urlResponseInfo) == null) {
            this.mWrappedCallback.onSucceeded(urlRequest, urlResponseInfo);
        }
    }
}
