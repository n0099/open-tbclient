package com.baidu.ar.ihttp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
/* loaded from: classes11.dex */
public class HttpException extends Exception {
    public static final int HTTP_ERROR = 4;
    public static final int INVOKE_ERROR = 3;
    public static final int LIB_ERROR = 2;
    public static final int NET_ERROR = 1;
    public static final int UNKNOWN_ERROR = -1;
    private int qT;

    public HttpException(int i, Exception exc) {
        super(exc);
        this.qT = i;
    }

    public HttpException(int i, String str) {
        super(str);
        this.qT = i;
    }

    public HttpException(IOException iOException) {
        super(iOException);
        a(iOException);
    }

    private void a(IOException iOException) {
        if ((iOException instanceof ConnectException) || (iOException instanceof SocketTimeoutException) || (iOException instanceof NoRouteToHostException) || (iOException instanceof UnknownHostException)) {
            this.qT = 1;
        } else if (iOException instanceof IOException) {
            this.qT = -1;
        } else {
            this.qT = 2;
        }
    }

    public int getCode() {
        return this.qT;
    }
}
