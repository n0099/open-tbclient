package com.baidu.android.pushservice;

import com.baidu.android.common.security.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public final class PushConstants {
    public static final String ACTION_MESSAGE = "com.baidu.android.pushservice.action.MESSAGE";
    public static final String ACTION_METHOD = "com.baidu.android.pushservice.action.METHOD";
    public static final String ACTION_RECEIVE = "com.baidu.android.pushservice.action.RECEIVE";
    public static final int BIND_STATUS_OFFLINE = 1;
    public static final int BIND_STATUS_ONLINE = 0;
    public static final int ERROR_AUTHENTICATION_FAILED = 30603;
    public static final int ERROR_BIND_NOT_EXIST = 30608;
    public static final int ERROR_BIND_OVERLOAD = 30609;
    public static final int ERROR_CHANNEL_TOKEN_TIMEOUT = 30607;
    public static final int ERROR_DATA_NOT_FOUND = 30605;
    public static final int ERROR_METHOD_ERROR = 30601;
    public static final int ERROR_NETWORK_ERROR = 10001;
    public static final int ERROR_PARAMS_ERROR = 30602;
    public static final int ERROR_QUOTA_USE_UP = 30604;
    public static final int ERROR_SERVER_INTERNAL_ERROR = 30600;
    public static final int ERROR_SERVICE_NOT_AVAILABLE = 10002;
    public static final int ERROR_SUCCESS = 0;
    public static final int ERROR_TIME_EXPIRES = 30606;
    public static final int ERROR_UNKNOWN = 20001;
    public static final String EXTRA_ACCESS_TOKEN = "access_token";
    public static final String EXTRA_APP = "app";
    public static final String EXTRA_APP_ID = "app_id";
    public static final String EXTRA_BIND_NAME = "bind_name";
    public static final String EXTRA_BIND_STATUS = "bind_status";
    public static final String EXTRA_CONTENT = "content";
    public static final String EXTRA_ERROR_CODE = "error_msg";
    public static final String EXTRA_FETCH_NUM = "fetch_num";
    public static final String EXTRA_FETCH_TYPE = "fetch_type";
    public static final String EXTRA_GID = "gid";
    public static final String EXTRA_GROUP_FETCH_NUM = "group_fetch_num";
    public static final String EXTRA_GROUP_FETCH_TYPE = "group_fetch_type";
    public static final String EXTRA_METHOD = "method";
    public static final String EXTRA_MSG_IDS = "msg_ids";
    public static final String EXTRA_PUSH_MESSAGE = "message";
    public static final String EXTRA_USER_ID = "user_id";
    public static final String METHOD_BIND = "method_bind";
    public static final String METHOD_COUNT = "method_count";
    public static final String METHOD_COUNTGMSG = "method_countgmsg";
    public static final String METHOD_DELETE = "method_delete";
    public static final String METHOD_FETCH = "method_fetch";
    public static final String METHOD_FETCHGMSG = "method_fetchgmsg";
    public static final String METHOD_GBIND = "method_gbind";
    public static final String METHOD_GINFO = "method_ginfo";
    public static final String METHOD_GLIST = "method_glist";
    public static final String METHOD_GUNBIND = "method_gunbind";
    public static final String METHOD_ONLINE = "method_online";
    public static final String METHOD_UNBIND = "method_unbind";
    private static final String REG_ERROR_UNKNOWN = "Unknown";

    private PushConstants() {
    }

    public static String getErrorMsg(int i) {
        switch (i) {
            case 0:
                return "Success";
            case ERROR_NETWORK_ERROR /* 10001 */:
                return "Network Problem";
            case ERROR_SERVICE_NOT_AVAILABLE /* 10002 */:
                return "Service not available";
            case ERROR_SERVER_INTERNAL_ERROR /* 30600 */:
                return "Internal Server Error";
            case ERROR_METHOD_ERROR /* 30601 */:
                return "Method Not Allowed";
            case ERROR_PARAMS_ERROR /* 30602 */:
                return "Request Params Not Valid";
            case ERROR_AUTHENTICATION_FAILED /* 30603 */:
                return "Authentication Failed";
            case ERROR_QUOTA_USE_UP /* 30604 */:
                return "Quota Use Up Payment Required";
            case ERROR_DATA_NOT_FOUND /* 30605 */:
                return "Data Required Not Found";
            case ERROR_TIME_EXPIRES /* 30606 */:
                return "Request Time Expires Timeout";
            case ERROR_CHANNEL_TOKEN_TIMEOUT /* 30607 */:
                return "Channel Token Timeout";
            case ERROR_BIND_NOT_EXIST /* 30608 */:
                return "Bind Relation Not Found";
            case ERROR_BIND_OVERLOAD /* 30609 */:
                return "Bind Number Too Many";
            default:
                return REG_ERROR_UNKNOWN;
        }
    }

    public static String rsaEncrypt(String str) {
        try {
            return Base64.encode(RSAUtil.encryptByPublicKey(str.getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/7VlVn9LIrZ71PL2RZMbK/Yxc\r\ndb046w/cXVylxS7ouPY06namZUFVhdbUnNRJzmGUZlzs3jUbvMO3l+4c9cw/n9aQ\r\nrm/brgaRDeZbeSrQYRZv60xzJIimuFFxsRM+ku6/dAyYmXiQXlRbgvFQ0MsVng4j\r\nv+cXhtTis2Kbwb8mQwIDAQAB\r\n"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
