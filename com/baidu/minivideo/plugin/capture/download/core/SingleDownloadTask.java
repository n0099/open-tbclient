package com.baidu.minivideo.plugin.capture.download.core;

import com.baidu.minivideo.plugin.capture.download.base.DownloadTask;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
/* loaded from: classes5.dex */
public class SingleDownloadTask extends DownloadTaskImpl {
    public SingleDownloadTask(DownloadInfo downloadInfo, ThreadRecord threadRecord, DownloadTask.OnDownloadListener onDownloadListener) {
        super(downloadInfo, threadRecord, onDownloadListener);
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected void insertIntoDB(ThreadRecord threadRecord) {
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected int getResponseCode() {
        return 200;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected void updateDB(ThreadRecord threadRecord) {
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected Map<String, String> getHttpHeaders(ThreadRecord threadRecord) {
        return null;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected RandomAccessFile getFile(File file, String str, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        randomAccessFile.seek(0L);
        return randomAccessFile;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    protected String getTag() {
        return getClass().getSimpleName();
    }
}
