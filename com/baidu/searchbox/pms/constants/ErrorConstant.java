package com.baidu.searchbox.pms.constants;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.R;
/* loaded from: classes2.dex */
public class ErrorConstant {

    /* loaded from: classes2.dex */
    public static final class Code {
        public static final int DATA_WRITE_DB = 2407;
        public static final int DOWNLOAD_BULK_DOWNLOADED = 2216;
        public static final int DOWNLOAD_CANCELED = 2211;
        public static final int DOWNLOAD_ERROR_CREATEFILE = 2205;
        public static final int DOWNLOAD_ERROR_DUPLICATED = 2212;
        public static final int DOWNLOAD_ERROR_MD5 = 2202;
        public static final int DOWNLOAD_ERROR_MISS_PARAM = 2214;
        public static final int DOWNLOAD_ERROR_NETWORK = 2201;
        public static final int DOWNLOAD_ERROR_NETWROK_CHANGE = 2207;
        public static final int DOWNLOAD_ERROR_NETWROK_LIMIT = 2213;
        public static final int DOWNLOAD_ERROR_NOSPACE = 2206;
        public static final int DOWNLOAD_ERROR_PATH = 2204;
        public static final int DOWNLOAD_ERROR_WRITE = 2208;
        public static final int DOWNLOAD_FILE_EXIST = 2217;
        public static final int DOWNLOAD_FILE_INEXIST = 2218;
        public static final int DOWNLOAD_FILTER = 2219;
        public static final int DOWNLOAD_PAUSED = 2209;
        public static final int DOWNLOAD_RESUMED = 2210;
        public static final int DOWNLOAD_RETRY = 2215;
        public static final int DOWNLOAD_SUCCESS = 2200;
        public static final int INSTALL_ERROR = 2301;
        public static final int INSTALL_SUCCESS = 2300;
        public static final int META_ERROR_CLOUD_CTRL = 2108;
        public static final int META_ERROR_CONNECTION = 2105;
        public static final int META_ERROR_FATAL = 2120;
        public static final int META_ERROR_NETWORK = 2101;
        public static final int META_ERROR_PARAMS = 2102;
        public static final int META_ERROR_RESPONSE = 2103;
    }

    /* loaded from: classes2.dex */
    public static final class ErrorMsg {
        public static final String DATA_WRITE_DB = "data:write db error";
        public static final String DOWNLOAD_BULK_DOWNLOADED = "onBulkDownloaded success:%d,error:%d,cancel:%d";
        public static final String DOWNLOAD_CANCELED = "download : customer cancel download";
        public static final String DOWNLOAD_ERROR_CREATEFILE = "download : path not writable";
        public static final String DOWNLOAD_ERROR_DUPLICATED = "duplicated download task";
        public static final String DOWNLOAD_ERROR_MD5 = "download : package MD5 verify failed.";
        public static final String DOWNLOAD_ERROR_MISS_PARAM = "download : param error:%s";
        public static final String DOWNLOAD_ERROR_NETWORK = "download : network error";
        public static final String DOWNLOAD_ERROR_NETWROK_CHANGE = "download : network state has changed";
        public static final String DOWNLOAD_ERROR_NETWROK_LIMIT = "download : network limited error";
        public static final String DOWNLOAD_ERROR_NOSPACE = "download : no space error";
        public static final String DOWNLOAD_ERROR_PATH = "download : path not available";
        public static final String DOWNLOAD_ERROR_WRITE = "download : disk write error";
        public static final String DOWNLOAD_FILE_EXIST = "download file exist:%s";
        public static final String DOWNLOAD_FILE_INEXIST = "download file not found:%s";
        public static final String DOWNLOAD_PAUSED = "download : customer stop download";
        public static final String DOWNLOAD_RESUMED = "download : customer resume download";
        public static final String DOWNLOAD_RETRY = "download : retry";
        public static final String DOWNLOAD_SUCCESS = "download : package download success";
        public static final String INSTALL_ERROR = "install error.";
        public static final String INSTALL_SUCCESS = "install success.";
        public static final String META_ERROR_CONNECTION = "metadata : network error. http code=";
        public static final String META_ERROR_FATAL = "System fatal error -";
        public static final String META_ERROR_RESPONSE = "metadata : parse response error - ";
    }

    /* loaded from: classes2.dex */
    public static final class TipMsg {
        public static final String META_ERROR_NETWORK = ErrorConstant.getTipMsg(R.string.META_ERROR_NETWORK);
        public static final String META_ERROR_CONNECTION = ErrorConstant.getTipMsg(R.string.META_ERROR_CONNECTION);
        public static final String META_ERROR_PARAMS = ErrorConstant.getTipMsg(R.string.META_ERROR_PARAMS);
        public static final String META_ERROR_RESPONSE = ErrorConstant.getTipMsg(R.string.META_ERROR_RESPONSE);
        public static final String META_ERROR_FATAL = ErrorConstant.getTipMsg(R.string.META_ERROR_FATAL);
        public static final String DOWNLOAD_SUCCESS = ErrorConstant.getTipMsg(R.string.DOWNLOAD_SUCCESS);
        public static final String DOWNLOAD_ERROR_NETWORK = ErrorConstant.getTipMsg(R.string.DOWNLOAD_ERROR_NETWORK);
        public static final String DOWNLOAD_ERROR_MD5 = ErrorConstant.getTipMsg(R.string.DOWNLOAD_ERROR_MD5);
        public static final String DOWNLOAD_ERROR_PATH = ErrorConstant.getTipMsg(R.string.DOWNLOAD_ERROR_PATH);
        public static final String DOWNLOAD_ERROR_CREATEFILE = ErrorConstant.getTipMsg(R.string.DOWNLOAD_ERROR_CREATEFILE);
        public static final String DOWNLOAD_ERROR_NOSPACE = ErrorConstant.getTipMsg(R.string.DOWNLOAD_ERROR_NOSPACE);
        public static final String DOWNLOAD_ERROR_NETWROK_CHANGE = ErrorConstant.getTipMsg(R.string.DOWNLOAD_ERROR_NETWROK_CHANGE);
        public static final String DOWNLOAD_ERROR_WRITE = ErrorConstant.getTipMsg(R.string.DOWNLOAD_ERROR_WRITE);
        public static final String DOWNLOAD_PAUSED = ErrorConstant.getTipMsg(R.string.DOWNLOAD_PAUSED);
        public static final String DOWNLOAD_RESUMED = ErrorConstant.getTipMsg(R.string.DOWNLOAD_RESUMED);
        public static final String DOWNLOAD_CANCELED = ErrorConstant.getTipMsg(R.string.DOWNLOAD_CANCELED);
        public static final String DOWNLOAD_ERROR_DUPLICATED = ErrorConstant.getTipMsg(R.string.DOWNLOAD_ERROR_DUPLICATED);
        public static final String DOWNLOAD_ERROR_NETWROK_LIMIT = ErrorConstant.getTipMsg(R.string.DOWNLOAD_ERROR_NETWROK_LIMIT);
        public static final String DOWNLOAD_ERROR_MISS_PARAM = ErrorConstant.getTipMsg(R.string.DOWNLOAD_ERROR_MISS_PARAM);
        public static final String INSTALL_ERROR = ErrorConstant.getTipMsg(R.string.INSTALL_ERROR);
        public static final String INSTALL_SUCCESS = ErrorConstant.getTipMsg(R.string.INSTALL_SUCCESS);
        public static final String DATA_WRITE_DB = ErrorConstant.getTipMsg(R.string.DATA_WRITE_DB);
    }

    public static String getTipMsg(int i) {
        return AppRuntime.getApplication().getResources().getString(i);
    }
}
