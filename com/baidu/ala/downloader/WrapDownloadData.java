package com.baidu.ala.downloader;

import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes9.dex */
public class WrapDownloadData {
    public static final int ST_FILE_DOWNLOADED = 3;
    public static final int ST_FILE_DOWNLOAD_FAILED = 5;
    public static final int ST_FILE_PRE_DOWNLOAD = 1;
    public static final int ST_FILE_UNZIP_SUCC = 4;
    public static final int ST_FILE_UPDATE_PROGRESS = 2;
    public DownloadData data;
    public int status;
}
