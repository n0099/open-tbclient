package com.baidu.searchbox.http.response;

import java.io.IOException;
/* loaded from: classes15.dex */
public class StatusCodeException extends IOException {
    public static final String ERROR_MSG_FORMATED = "Server statusCode Error; statusCode=%s; response.message=%s";
    private static final int IGNORE_429_CODE = 429;
    private static final int STATUS_CODE_START = 400;

    public StatusCodeException(String str) {
        super(str);
    }

    public static boolean isStatusCodeMatched(int i) {
        return i >= 400 && i != IGNORE_429_CODE;
    }
}
