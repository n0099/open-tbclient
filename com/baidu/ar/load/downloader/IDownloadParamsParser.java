package com.baidu.ar.load.downloader;
/* loaded from: classes3.dex */
public interface IDownloadParamsParser {

    /* loaded from: classes3.dex */
    public static class DownloadParam {
        public static final int STATUS_ERROR = 100;
        public static final int STATUS_OK = 0;
        public String mDownloadPath;
        public String mDownloadUrl;
        public int mErrorCode;
        public String mFileManagePath;
    }

    DownloadParam parser(String str);
}
