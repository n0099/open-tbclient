package com.baidu.down.common;

import android.content.Context;
/* loaded from: classes2.dex */
public interface IDownloadWrapper {
    void addObserver(TaskObserver taskObserver);

    int getCurrentVacant();

    int getDownloadCommonVersion();

    StatisticInfo getStatisticInfo(long j);

    void pauseAllTask();

    void pauseDownload(String str, long j);

    void setMaxDownloadThread(int i);

    void setup(Context context, TaskManagerConfiguration taskManagerConfiguration);

    long startDownload(FileMsg fileMsg);

    void stopDownload(String str, long j, boolean z);
}
