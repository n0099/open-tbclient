package com.baidu.searchbox.http.response;

import android.text.TextUtils;
import java.io.IOException;
import java.net.SocketTimeoutException;
/* loaded from: classes4.dex */
public class ResponseException {
    public static final String CANCELED = "Canceled";
    public static final String NO_NETWORK = " no network connected";
    public static final String ONLY_WIFI_EXECUTE = " only allow wifi connected";

    public static boolean isCancel(Exception exc) {
        if (exc != null && !TextUtils.isEmpty(exc.getMessage()) && exc.getMessage().contains("Canceled")) {
            return true;
        }
        return false;
    }

    public static boolean isNoNetwork(Exception exc) {
        if (exc != null && !TextUtils.isEmpty(exc.getMessage()) && exc.getMessage().startsWith(" no network connected")) {
            return true;
        }
        return false;
    }

    public static boolean isOnlyWifiException(Exception exc) {
        if (exc != null && " only allow wifi connected".equals(exc.getMessage())) {
            return true;
        }
        return false;
    }

    public static boolean isTimeoutException(Exception exc) {
        if (exc != null && (exc instanceof SocketTimeoutException)) {
            return true;
        }
        return false;
    }

    public static IOException wrapNoNetworkExceptionWithDetail(Exception exc) {
        return new IOException(" no network connected\n" + exc.toString(), exc);
    }
}
