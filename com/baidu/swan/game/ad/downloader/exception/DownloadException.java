package com.baidu.swan.game.ad.downloader.exception;
/* loaded from: classes3.dex */
public class DownloadException extends RuntimeException {
    public static final int EXCEPTION_FILE_SIZE_ZERO = 6;
    public static final int EXCEPTION_IO_EXCEPTION = 5;
    public static final int EXCEPTION_OTHER = 9;
    public static final int EXCEPTION_PATH_NULL = 1;
    public static final int EXCEPTION_PAUSE = 7;
    public static final int EXCEPTION_PROTOCOL = 4;
    public static final int EXCEPTION_SERVER_ERROR = 3;
    public static final int EXCEPTION_SERVER_SUPPORT_CODE = 8;
    public static final int EXCEPTION_URL_ERROR = 2;
    public static final int EXCEPTION_URL_NULL = 0;
    public int code;

    public DownloadException(int i2) {
        this.code = i2;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public DownloadException(int i2, String str) {
        super(str);
        this.code = i2;
    }

    public DownloadException(int i2, String str, Throwable th) {
        super(str, th);
        this.code = i2;
    }

    public DownloadException(int i2, Throwable th) {
        super(th);
        this.code = i2;
    }
}
