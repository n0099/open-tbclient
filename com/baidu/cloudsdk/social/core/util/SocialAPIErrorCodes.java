package com.baidu.cloudsdk.social.core.util;
/* loaded from: classes.dex */
public final class SocialAPIErrorCodes {
    public static final int ERROR_AUTHORIZATION_CANCELED = 150;
    public static final int ERROR_BIND_API_ALREADY_BIND_TO_CURRENT_USER = 151;
    public static final int ERROR_BIND_API_NOT_BIND_TO_CURRENT_USER = 152;
    public static final int ERROR_EXPIRED_ACCESS_TOKEN = 111;
    public static final int ERROR_EXPIRED_SESSION_KEY = 112;
    public static final int ERROR_INVALID_AUTHORIZED_CODE = 120;
    public static final int ERROR_INVALID_BDUSS = 123;
    public static final int ERROR_INVALID_CLIENT_ID = 101;
    public static final int ERROR_INVALID_GRANT_TYPE = 116;
    public static final int ERROR_INVALID_MEDIA_TYPE = 117;
    public static final int ERROR_INVALID_REDIRECT_URI = 118;
    public static final int ERROR_INVALID_REFERER = 7;
    public static final int ERROR_INVALID_RESPONSE_TYPE = 115;
    public static final int ERROR_INVALID_SECRET_KEY = 119;
    public static final int ERROR_INVALID_SESSION_KEY = 102;
    public static final int ERROR_INVALID_SIGNATURE = 104;
    public static final int ERROR_INVALID_SIGNATURE_ALGORITHM = 106;
    public static final int ERROR_INVALID_STATE = 121;
    public static final int ERROR_INVALID_TIMESTAMP = 107;
    public static final int ERROR_INVALID_UPLOAD_FILE = 125;
    public static final int ERROR_MANY_PARAMETER = 105;
    public static final int ERROR_MISS_ACCESS_TOKEN = 110;
    public static final int ERROR_MISS_PARAMETER = 100;
    public static final int ERROR_NO_PERMISSION = 6;
    public static final int ERROR_REQUEST_LIMIT_REACHED = 4;
    public static final int ERROR_REQUEST_THIRD_PLATFORM_FAILED = 12;
    public static final int ERROR_SERVICE_TEMPORARILY_UNAVAILABLE = 2;
    public static final int ERROR_SESSION_EXPIRED = 122;
    public static final int ERROR_UNAUTHORIZED_IP = 5;
    public static final int ERROR_UNKNOWN = 1;
    public static final int ERROR_UPLOAD_FILE_SIZE_TOO_LARGE = 124;

    private SocialAPIErrorCodes() {
    }

    public static String getErrorDescription(int i) {
        switch (i) {
            case 2:
                return "service temporarily unavailable";
            case 4:
                return "request too frequently";
            case 5:
                return "un_authorized ip address";
            case 6:
                return "no permission";
            case 7:
                return "invalid referer";
            case 12:
                return "request third platform failed";
            case 100:
                return "some required parameter is missing";
            case 101:
                return "invalid client id";
            case ERROR_INVALID_SESSION_KEY /* 102 */:
                return "invalid session key";
            case ERROR_INVALID_SIGNATURE /* 104 */:
                return "invalid signature";
            case 105:
                return "too many parameters";
            case ERROR_INVALID_SIGNATURE_ALGORITHM /* 106 */:
                return "invalid signature algorithm";
            case ERROR_INVALID_TIMESTAMP /* 107 */:
                return "invalid timestamp";
            case 110:
                return "missing access token";
            case ERROR_EXPIRED_ACCESS_TOKEN /* 111 */:
                return "access token expired";
            case ERROR_EXPIRED_SESSION_KEY /* 112 */:
                return "session key expired";
            case ERROR_INVALID_RESPONSE_TYPE /* 115 */:
                return "response_type parameter is invalid";
            case ERROR_INVALID_GRANT_TYPE /* 116 */:
                return "grant_type parameter is invalid";
            case ERROR_INVALID_MEDIA_TYPE /* 117 */:
                return "media_type parameter is invalid";
            case ERROR_INVALID_REDIRECT_URI /* 118 */:
                return "redirect_uri parameter is invalid";
            case ERROR_INVALID_SECRET_KEY /* 119 */:
                return "secret key is invalid";
            case ERROR_INVALID_AUTHORIZED_CODE /* 120 */:
                return "authorized_code is invalid";
            case ERROR_INVALID_STATE /* 121 */:
                return "state is invalid";
            case ERROR_SESSION_EXPIRED /* 122 */:
                return "login session is expired";
            case ERROR_INVALID_BDUSS /* 123 */:
                return "bduss is invalid";
            case ERROR_UPLOAD_FILE_SIZE_TOO_LARGE /* 124 */:
                return "upload file_size too large";
            case ERROR_INVALID_UPLOAD_FILE /* 125 */:
                return "invalid uploaded file";
            case 150:
                return "user cancelled authorization";
            case ERROR_BIND_API_ALREADY_BIND_TO_CURRENT_USER /* 151 */:
                return "api already bind to current user";
            case ERROR_BIND_API_NOT_BIND_TO_CURRENT_USER /* 152 */:
                return "api not bind to current user";
            default:
                return "unknown error";
        }
    }
}
