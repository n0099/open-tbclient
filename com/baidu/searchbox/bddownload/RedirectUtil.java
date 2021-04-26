package com.baidu.searchbox.bddownload;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import java.io.IOException;
import java.net.ProtocolException;
/* loaded from: classes2.dex */
public class RedirectUtil {
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    public static final int MAX_REDIRECT_TIMES = 10;

    @NonNull
    public static String getRedirectedUrl(DownloadConnection.Connected connected, int i2) throws IOException {
        String responseHeaderField = connected.getResponseHeaderField("Location");
        if (responseHeaderField != null) {
            return responseHeaderField;
        }
        throw new ProtocolException("Response code is " + i2 + " but can't find Location field");
    }

    public static boolean isRedirect(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 300 || i2 == 307 || i2 == 308;
    }
}
