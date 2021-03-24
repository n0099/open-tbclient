package com.baidu.minivideo.plugin.capture.download.core;

import com.baidu.minivideo.plugin.capture.download.base.DownloadTask;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class MultiDownloadTask extends DownloadTaskImpl {
    public MultiDownloadTask(DownloadInfo downloadInfo, ThreadRecord threadRecord, DownloadTask.OnDownloadListener onDownloadListener) {
        super(downloadInfo, threadRecord, onDownloadListener);
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public RandomAccessFile getFile(File file, String str, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        randomAccessFile.seek(j);
        return randomAccessFile;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public Map<String, String> getHttpHeaders(ThreadRecord threadRecord) {
        HashMap hashMap = new HashMap();
        long start = threadRecord.getStart() + threadRecord.getFinished();
        long end = threadRecord.getEnd();
        hashMap.put("Range", "bytes=" + start + "-" + end);
        return hashMap;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public int getResponseCode() {
        return 206;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public String getTag() {
        return MultiDownloadTask.class.getSimpleName();
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public void insertIntoDB(ThreadRecord threadRecord) {
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public void updateDB(ThreadRecord threadRecord) {
    }
}
