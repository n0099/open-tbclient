package com.baidu.down.common;

import android.content.Context;
/* loaded from: classes5.dex */
public interface IDownloadWrapper {
    void addObserver(TaskObserver taskObserver);

    int getCurrentVacant();

    int getDownloadCommonVersion();

    StatisticInfo getStatisticInfo(long j2);

    void pauseAllTask();

    void pauseDownload(String str, long j2);

    void setMaxDownloadThread(int i2);

    void setup(Context context, TaskManagerConfiguration taskManagerConfiguration);

    long startDownload(FileMsg fileMsg);

    void stopDownload(String str, long j2, boolean z);
}
