package com.baidu.minivideo.plugin.capture.download.core;

import com.baidu.minivideo.plugin.capture.download.base.DownloadTask;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
/* loaded from: classes2.dex */
public class SingleDownloadTask extends DownloadTaskImpl {
    public SingleDownloadTask(DownloadInfo downloadInfo, ThreadRecord threadRecord, DownloadTask.OnDownloadListener onDownloadListener) {
        super(downloadInfo, threadRecord, onDownloadListener);
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public RandomAccessFile getFile(File file, String str, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        randomAccessFile.seek(0L);
        return randomAccessFile;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public Map<String, String> getHttpHeaders(ThreadRecord threadRecord) {
        return null;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public int getResponseCode() {
        return 200;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public String getTag() {
        return SingleDownloadTask.class.getSimpleName();
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public void insertIntoDB(ThreadRecord threadRecord) {
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public void updateDB(ThreadRecord threadRecord) {
    }
}
