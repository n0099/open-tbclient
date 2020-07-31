package com.baidu.minivideo.plugin.capture.download.core;

import com.baidu.minivideo.plugin.capture.download.base.DownloadTask;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class MultiDownloadTask extends DownloadTaskImpl {
    public MultiDownloadTask(DownloadInfo downloadInfo, ThreadRecord threadRecord, DownloadTask.OnDownloadListener onDownloadListener) {
        super(downloadInfo, threadRecord, onDownloadListener);
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected void insertIntoDB(ThreadRecord threadRecord) {
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected int getResponseCode() {
        return 206;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected void updateDB(ThreadRecord threadRecord) {
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected Map<String, String> getHttpHeaders(ThreadRecord threadRecord) {
        HashMap hashMap = new HashMap();
        long start = threadRecord.getStart() + threadRecord.getFinished();
        hashMap.put(Headers.RANGE, "bytes=" + start + Constants.ACCEPT_TIME_SEPARATOR_SERVER + threadRecord.getEnd());
        return hashMap;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected RandomAccessFile getFile(File file, String str, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        randomAccessFile.seek(j);
        return randomAccessFile;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected String getTag() {
        return getClass().getSimpleName();
    }
}
