package com.baidu.searchbox.bddownload.core.interceptor;

import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher;
import com.baidu.searchbox.bddownload.core.download.DownloadChain;
import com.baidu.searchbox.bddownload.core.exception.InterruptException;
import com.baidu.searchbox.bddownload.core.file.MultiPointOutputStream;
import com.baidu.searchbox.bddownload.core.interceptor.Interceptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class FetchDataInterceptor implements Interceptor.Fetch {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int blockIndex;
    public final CallbackDispatcher dispatcher;
    public final InputStream inputStream;
    public final MultiPointOutputStream outputStream;
    public final byte[] readBuffer;
    public final DownloadTask task;

    public FetchDataInterceptor(int i, InputStream inputStream, MultiPointOutputStream multiPointOutputStream, DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), inputStream, multiPointOutputStream, downloadTask};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.blockIndex = i;
        this.inputStream = inputStream;
        this.readBuffer = new byte[downloadTask.getReadBufferSize()];
        this.outputStream = multiPointOutputStream;
        this.task = downloadTask;
        this.dispatcher = BdDownload.with().callbackDispatcher();
    }

    @Override // com.baidu.searchbox.bddownload.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain downloadChain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadChain)) == null) {
            if (!downloadChain.getCache().isInterrupt()) {
                BdDownload.with().downloadStrategy().inspectNetworkOnWifi(downloadChain.getTask());
                int read = this.inputStream.read(this.readBuffer);
                if (read == -1) {
                    return read;
                }
                this.outputStream.write(this.blockIndex, this.readBuffer, read);
                long j = read;
                downloadChain.increaseCallbackBytes(j);
                if (this.dispatcher.isFetchProcessMoment(this.task)) {
                    downloadChain.flushNoCallbackIncreaseBytes();
                }
                return j;
            }
            throw InterruptException.SIGNAL;
        }
        return invokeL.longValue;
    }
}
