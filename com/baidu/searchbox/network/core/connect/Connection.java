package com.baidu.searchbox.network.core.connect;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
/* loaded from: classes13.dex */
public interface Connection extends Closeable {
    @Deprecated
    public static final int APACH_HTTP_TYPE = 0;
    public static final int CRONET_HTTP_TYPE = 3;
    public static final int HTTPURLCONNECTION_HTTP_TYPE = 1;
    public static final int OKHTTP_HTTP_TYPE = 2;

    void disconnect();

    int getCode() throws IOException;

    Map<String, List<String>> getHeaders() throws IOException;

    InputStream getInputStream() throws IOException;

    String getMessage() throws IOException;

    int getNetEngine();

    OutputStream getOutputStream() throws IOException;

    void setNetEngine(int i);
}
