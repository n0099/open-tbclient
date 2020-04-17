package com.baidu.ar.ihttp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
/* loaded from: classes3.dex */
public class HttpException extends Exception {
    public static final int HTTP_ERROR = 4;
    public static final int INVOKE_ERROR = 3;
    public static final int LIB_ERROR = 2;
    public static final int NET_ERROR = 1;
    public static final int UNKNOWN_ERROR = -1;
    private int pP;

    public HttpException(int i, Exception exc) {
        super(exc);
        this.pP = i;
    }

    public HttpException(int i, String str) {
        super(str);
        this.pP = i;
    }

    public HttpException(IOException iOException) {
        super(iOException);
        a(iOException);
    }

    private void a(IOException iOException) {
        if ((iOException instanceof ConnectException) || (iOException instanceof SocketTimeoutException) || (iOException instanceof NoRouteToHostException) || (iOException instanceof UnknownHostException)) {
            this.pP = 1;
        } else if (iOException instanceof IOException) {
            this.pP = -1;
        } else {
            this.pP = 2;
        }
    }

    public int getCode() {
        return this.pP;
    }
}
