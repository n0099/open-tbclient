package com.baidu.searchbox.bddownload.core.interceptor;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.download.DownloadCache;
import com.baidu.searchbox.bddownload.core.download.DownloadChain;
import com.baidu.searchbox.bddownload.core.exception.InterruptException;
import com.baidu.searchbox.bddownload.core.exception.RetryException;
import com.baidu.searchbox.bddownload.core.interceptor.Interceptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes5.dex */
public class RetryInterceptor implements Interceptor.Connect, Interceptor.Fetch {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RetryInterceptor() {
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

    @Override // com.baidu.searchbox.bddownload.core.interceptor.Interceptor.Connect
    @NonNull
    public DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, downloadChain)) != null) {
            return (DownloadConnection.Connected) invokeL.objValue;
        }
        DownloadCache cache = downloadChain.getCache();
        while (true) {
            try {
                if (!cache.isInterrupt()) {
                    return downloadChain.processConnect();
                }
                throw InterruptException.SIGNAL;
            } catch (IOException e2) {
                if (e2 instanceof RetryException) {
                    downloadChain.resetConnectForRetry();
                } else {
                    downloadChain.getCache().catchException(e2);
                    downloadChain.getOutputStream().catchBlockConnectException(downloadChain.getBlockIndex());
                    throw e2;
                }
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain downloadChain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadChain)) == null) {
            try {
                return downloadChain.processFetch();
            } catch (IOException e2) {
                downloadChain.getCache().catchException(e2);
                throw e2;
            }
        }
        return invokeL.longValue;
    }
}
