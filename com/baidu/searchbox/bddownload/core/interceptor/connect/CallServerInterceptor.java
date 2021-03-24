package com.baidu.searchbox.bddownload.core.interceptor.connect;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.download.DownloadChain;
import com.baidu.searchbox.bddownload.core.interceptor.Interceptor;
import java.io.IOException;
/* loaded from: classes2.dex */
public class CallServerInterceptor implements Interceptor.Connect {
    @Override // com.baidu.searchbox.bddownload.core.interceptor.Interceptor.Connect
    @NonNull
    public DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) throws IOException {
        BdDownload.with().downloadStrategy().inspectNetworkOnWifi(downloadChain.getTask());
        BdDownload.with().downloadStrategy().inspectNetworkAvailable();
        return downloadChain.getConnectionOrCreate().execute();
    }
}
