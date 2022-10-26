package com.baidu.searchbox.bddownload.core.interceptor;

import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.download.DownloadChain;
import java.io.IOException;
/* loaded from: classes2.dex */
public interface Interceptor {

    /* loaded from: classes2.dex */
    public interface Connect {
        DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) throws IOException;
    }

    /* loaded from: classes2.dex */
    public interface Fetch {
        long interceptFetch(DownloadChain downloadChain) throws IOException;
    }
}
