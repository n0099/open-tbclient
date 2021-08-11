package com.baidu.searchbox.bddownload.core.interceptor.connect;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.download.DownloadChain;
import com.baidu.searchbox.bddownload.core.interceptor.Interceptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes5.dex */
public class CallServerInterceptor implements Interceptor.Connect {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CallServerInterceptor() {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadChain)) == null) {
            BdDownload.with().downloadStrategy().inspectNetworkOnWifi(downloadChain.getTask());
            BdDownload.with().downloadStrategy().inspectNetworkAvailable();
            return downloadChain.getConnectionOrCreate().execute();
        }
        return (DownloadConnection.Connected) invokeL.objValue;
    }
}
