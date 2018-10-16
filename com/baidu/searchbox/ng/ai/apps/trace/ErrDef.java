package com.baidu.searchbox.ng.ai.apps.trace;
/* loaded from: classes2.dex */
public interface ErrDef {

    /* loaded from: classes2.dex */
    public interface BaseCode {
        public static final int UNKNOWN = 0;
    }

    /* loaded from: classes2.dex */
    public interface Error extends BaseCode {
        public static final int AIAPP_DATA_INVALID = 11;
        public static final int BAD_SIGN = 5;
        public static final int BUNDLE_LOAD_ERR = 20;
        public static final int DATA_PARSE = 14;
        public static final int DOWNLOAD_ICON_FAIL = 10;
        public static final int DOWNLOAD_PKG_FAIL = 9;
        public static final int EMPTY_DATA = 15;
        public static final int ERROR_APPID = 13;
        public static final int ERROR_PAGE_STACK = 16;
        public static final int FE_BUSI_ERR = 23;
        public static final int FE_FRMAE_ERR = 22;
        public static final int GET_LAUNCH_SCHEME_FAIL = 12;
        public static final int ILLEGAL_ARGS = 1;
        public static final int LAUNCH_ALWAYS_LOADING = 18;
        public static final int LOADING_WHITE_SCREEN = 19;
        public static final int LOW_OS_VERSION = 21;
        public static final int NETWORK = 2;
        public static final int NO_PKG_BOTH_APS_N_DISK = 8;
        public static final int NO_PKG_IN_DB = 3;
        public static final int NO_PKG_IN_DISK = 4;
        public static final int OVERFLOW = 9999;
        public static final int PKG_DECRYPT_ERR = 24;
        public static final int PKG_PARSE = 6;
        public static final int PKG_UNZIP = 7;
        public static final int RENAME_ZIP_FAIL = 17;
        public static final long WEIGHT = 1;
    }

    /* loaded from: classes2.dex */
    public interface Feature extends BaseCode {
        public static final int APS_DOWNLOAD_UPDATE = 2;
        public static final int AUTHORIZE = 8;
        public static final int DEBUG_DOWNLOAD = 7;
        public static final int LAUNCH_SCHEME = 1;
        public static final int OVERFLOW = 999;
        public static final int PKG_CHECK = 3;
        public static final int PKG_INSTALL = 4;
        public static final int RUN_H5 = 6;
        public static final int RUN_NA = 5;
        public static final long WEIGHT = 10000;
    }

    /* loaded from: classes2.dex */
    public interface Platform extends BaseCode {
        public static final int ANDROID = 2;
        public static final int IDE = 3;
        public static final int IOS = 1;
        public static final int OVERFLOW = 9;
        public static final long WEIGHT = 10000000;
    }
}
