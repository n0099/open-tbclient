package com.baidu.nadcore.exp;
/* loaded from: classes2.dex */
public class ADConfigError extends Exception {
    public static final String ERROR_NET_ERROR_RESPONSE_NULL = "1";
    public static final String ERROR_NULL_CODE = "4";
    public static final String ERROR_NULL_DATA = "7";
    public static final String ERROR_NULL_MSG = "6";
    public static final String ERROR_NULL_SIGN = "2";
    public static final String ERROR_OTHER = "10";
    public static final String ERROR_RESPONSE_CODE = "8";
    public static final String ERROR_WRONG_CODE = "3";
    public static final String ERROR_WRONG_MSG = "5";
    public static final String REASON_BUILD_REQUEST_FAILED = "failed to build request";
    public static final String REASON_NULL_CODE = "error_code is null";
    public static final String REASON_NULL_DATA = "data is null";
    public static final String REASON_NULL_MSG = "error_message is null";
    public static final String REASON_NULL_RESPONSE = "response is null";
    public static final String REASON_NULL_RESPONSE_BODY = "body of response is null";
    public static final String REASON_NULL_SIGN = "sign is null";
    public static final String REASON_REQUEST_SUCCESS = "request success";
    public static final String REASON_WRONG_CODE = "error_code is wrong";
    public static final String REASON_WRONG_MSG = "errorMsg is wrong";
    public static final String REQUEST_HAS_SUCCESS_BEFORE = "101";
    public static final String REQUEST_SUCCESS = "0";
    public String code;
    public String reason;

    public ADConfigError(String str, String str2) {
        this.code = str;
        this.reason = str2;
    }

    public static ADConfigError error(String str, String str2) {
        return new ADConfigError(str, str2);
    }
}
