package com.baidu.tbadk.core.util.deeplink;
/* loaded from: classes8.dex */
public interface DeepLinkCode {
    public static final int APP_ERROR_APP_URL_EMPTY = -4;
    public static final int COMMON_CODE_NONE = 0;
    public static final int COMMON_CODE_SUCCEED = 1;
    public static final int ERROR_INVALID_URI = -2;
    public static final int ERROR_URI_EMPTY = -1;
    public static final int MARKET_ERROR_APP_URL_EMPTY = -5;
    public static final int WEB_ERROR_WEB_URL_EMPTY = -6;
    public static final int WEB_ERROR_WEB_URL_FAILED = -7;

    /* loaded from: classes8.dex */
    public interface OpenAppErrorCode {
        public static final int CREATE_INTENT_BY_SCHEME_ERROR = -103;
        public static final int HIT_BLACKLIST_FAILED = -105;
        public static final int INVALID_INTENT_SCHEME = -102;
        public static final int MATCH_PACKAGE_FAILED = -104;
        public static final int OPEN_APP_FAILD = -101;
    }

    /* loaded from: classes8.dex */
    public interface OpenAppSource {
        public static final String OPEN_SOURCE_APP = "app";
        public static final String OPEN_SOURCE_MARKET = "market";
        public static final String OPEN_SOURCE_NONE = "default";
        public static final String OPEN_SOURCE_WEB = "web";
    }
}
