package com.baidu.searchbox.pms.bean;

import android.text.TextUtils;
import com.baidu.searchbox.pms.constants.ErrorConstant;
/* loaded from: classes2.dex */
public class ErrorInfo {
    public int code;
    public String errorMsg;
    public String tipMsg;

    public ErrorInfo() {
    }

    private void initDefault(int i2) {
        this.code = i2;
        if (i2 == 2105) {
            this.errorMsg = ErrorConstant.ErrorMsg.META_ERROR_CONNECTION;
            this.tipMsg = ErrorConstant.TipMsg.META_ERROR_CONNECTION;
        } else if (i2 == 2120) {
            this.errorMsg = ErrorConstant.ErrorMsg.META_ERROR_FATAL;
            this.tipMsg = ErrorConstant.TipMsg.META_ERROR_FATAL;
        } else if (i2 != 2407) {
            switch (i2) {
                case 2101:
                    this.errorMsg = ErrorConstant.ErrorMsg.META_ERROR_FATAL;
                    this.tipMsg = ErrorConstant.TipMsg.META_ERROR_NETWORK;
                    return;
                case 2102:
                    this.tipMsg = ErrorConstant.TipMsg.META_ERROR_PARAMS;
                    return;
                case 2103:
                    this.errorMsg = ErrorConstant.ErrorMsg.META_ERROR_RESPONSE;
                    this.tipMsg = ErrorConstant.TipMsg.META_ERROR_RESPONSE;
                    return;
                default:
                    switch (i2) {
                        case 2200:
                            this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS;
                            this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_SUCCESS;
                            return;
                        case 2201:
                            this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK;
                            this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_NETWORK;
                            return;
                        case 2202:
                            this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5;
                            this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_MD5;
                            return;
                        default:
                            switch (i2) {
                                case ErrorConstant.Code.DOWNLOAD_ERROR_PATH /* 2204 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH;
                                    this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_PATH;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE /* 2205 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE;
                                    this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_CREATEFILE;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE /* 2206 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE;
                                    this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_NOSPACE;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE /* 2207 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWROK_CHANGE;
                                    this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_NETWROK_CHANGE;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_ERROR_WRITE /* 2208 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE;
                                    this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_WRITE;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_PAUSED /* 2209 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_PAUSED;
                                    this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_PAUSED;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_RESUMED /* 2210 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_RESUMED;
                                    this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_RESUMED;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_CANCELED /* 2211 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_CANCELED;
                                    this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_CANCELED;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_ERROR_DUPLICATED /* 2212 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_DUPLICATED;
                                    this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_DUPLICATED;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_LIMIT /* 2213 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWROK_LIMIT;
                                    this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_NETWROK_LIMIT;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_ERROR_MISS_PARAM /* 2214 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MISS_PARAM;
                                    this.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_MISS_PARAM;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_RETRY /* 2215 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_RETRY;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_BULK_DOWNLOADED /* 2216 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_BULK_DOWNLOADED;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_FILE_EXIST /* 2217 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_FILE_EXIST;
                                    return;
                                case ErrorConstant.Code.DOWNLOAD_FILE_INEXIST /* 2218 */:
                                    this.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST;
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        } else {
            this.errorMsg = ErrorConstant.ErrorMsg.DATA_WRITE_DB;
            this.tipMsg = ErrorConstant.TipMsg.DATA_WRITE_DB;
        }
    }

    public String toString() {
        return "code=" + this.code + ",errMsg=" + this.errorMsg + ",tipMsg" + this.tipMsg;
    }

    public ErrorInfo(int i2) {
        this(i2, null);
    }

    public ErrorInfo(int i2, String str) {
        initDefault(i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.errorMsg == null) {
            this.errorMsg = str;
            return;
        }
        this.errorMsg += str;
    }

    public ErrorInfo(int i2, String str, String str2) {
        this.code = i2;
        this.errorMsg = str;
        this.tipMsg = str2;
    }
}
