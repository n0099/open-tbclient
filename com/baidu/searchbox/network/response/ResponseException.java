package com.baidu.searchbox.network.response;

import java.net.SocketTimeoutException;
/* loaded from: classes13.dex */
public class ResponseException {
    public static final String CANCELED = "Canceled";
    public static final String NO_NETWORK = " no network connected";
    public static final String ONLY_WIFI_EXECUTE = " only allow wifi connected";

    public static boolean isCancel(Exception exc) {
        return exc != null && exc.getMessage().contains("Canceled");
    }

    public static boolean isNoNetwork(Exception exc) {
        return exc != null && " no network connected".equals(exc.getMessage());
    }

    public static boolean isOnlyWifiException(Exception exc) {
        return exc != null && " only allow wifi connected".equals(exc.getMessage());
    }

    public static boolean isTimeoutException(Exception exc) {
        return exc != null && (exc instanceof SocketTimeoutException);
    }
}
