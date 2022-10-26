package com.baidu.searchbox.bddownload;

import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes2.dex */
public interface IRedirectHandler {
    String getRedirectLocation();

    void handleRedirect(DownloadConnection downloadConnection, DownloadConnection.Connected connected, Map map) throws IOException;
}
