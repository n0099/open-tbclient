package com.baidu.searchbox.http.response;

import java.net.SocketTimeoutException;
/* loaded from: classes2.dex */
public class ResponseException {
    public static final String CANCELED = "Canceled";
    public static final String NO_NETWORK = " no network connected";
    public static final String ONLY_WIFI_EXECUTE = " only allow wifi connected";

    public static boolean isCancel(Exception exc) {
        return exc != null && exc.getMessage().contains(CANCELED);
    }

    public static boolean isNoNetwork(Exception exc) {
        return exc != null && NO_NETWORK.equals(exc.getMessage());
    }

    public static boolean isOnlyWifiException(Exception exc) {
        return exc != null && ONLY_WIFI_EXECUTE.equals(exc.getMessage());
    }

    public static boolean isTimeoutException(Exception exc) {
        return exc != null && (exc instanceof SocketTimeoutException);
    }
}
