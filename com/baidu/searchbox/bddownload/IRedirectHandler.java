package com.baidu.searchbox.bddownload;

import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public interface IRedirectHandler {
    @Nullable
    String getRedirectLocation();

    void handleRedirect(DownloadConnection downloadConnection, DownloadConnection.Connected connected, Map<String, List<String>> map) throws IOException;
}
