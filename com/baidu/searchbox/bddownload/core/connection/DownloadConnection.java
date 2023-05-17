package com.baidu.searchbox.bddownload.core.connection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public interface DownloadConnection {
    public static final int NO_RESPONSE_CODE = 0;

    /* loaded from: classes3.dex */
    public interface Connected {
        InputStream getInputStream() throws IOException;

        String getRedirectLocation();

        int getResponseCode() throws IOException;

        @Nullable
        String getResponseHeaderField(String str);

        @Nullable
        Map<String, List<String>> getResponseHeaderFields();
    }

    /* loaded from: classes3.dex */
    public interface Factory {
        DownloadConnection create(String str) throws IOException;
    }

    void addHeader(String str, String str2);

    Connected execute() throws IOException;

    Map<String, List<String>> getRequestProperties();

    String getRequestProperty(String str);

    void release();

    boolean setRequestMethod(@NonNull String str) throws ProtocolException;
}
