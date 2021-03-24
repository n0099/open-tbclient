package com.baidu.searchbox.bddownload.core.interceptor;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.download.DownloadCache;
import com.baidu.searchbox.bddownload.core.download.DownloadChain;
import com.baidu.searchbox.bddownload.core.exception.InterruptException;
import com.baidu.searchbox.bddownload.core.exception.RetryException;
import com.baidu.searchbox.bddownload.core.interceptor.Interceptor;
import java.io.IOException;
/* loaded from: classes2.dex */
public class RetryInterceptor implements Interceptor.Connect, Interceptor.Fetch {
    @Override // com.baidu.searchbox.bddownload.core.interceptor.Interceptor.Connect
    @NonNull
    public DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) throws IOException {
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
        try {
            return downloadChain.processFetch();
        } catch (IOException e2) {
            downloadChain.getCache().catchException(e2);
            throw e2;
        }
    }
}
