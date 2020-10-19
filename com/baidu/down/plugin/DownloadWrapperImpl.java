package com.baidu.down.plugin;

import android.content.Context;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.IDownloadWrapper;
import com.baidu.down.common.StatisticInfo;
import com.baidu.down.common.TaskManagerConfiguration;
import com.baidu.down.common.TaskObserver;
import com.baidu.down.request.taskmanager.BinaryTaskMng;
import com.baidu.down.request.taskmanager.TaskFacade;
/* loaded from: classes9.dex */
public class DownloadWrapperImpl implements IDownloadWrapper {
    private static final boolean DEBUG = false;
    private static final String TAG = "DownloadWrapperImpl";
    private BinaryTaskMng mTaskManager;

    @Override // com.baidu.down.common.IDownloadWrapper
    public void addObserver(TaskObserver taskObserver) {
        this.mTaskManager.addObserver(taskObserver);
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public int getCurrentVacant() {
        return this.mTaskManager.getCurrentVacant();
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void pauseAllTask() {
        this.mTaskManager.pauseAllTask();
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void pauseDownload(String str, long j) {
        this.mTaskManager.pauseDownload(str, j);
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void setMaxDownloadThread(int i) {
        this.mTaskManager.setMaxDownloadThread(i);
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void setup(Context context, TaskManagerConfiguration taskManagerConfiguration) {
        this.mTaskManager = TaskFacade.getInstanceByConfig(context, taskManagerConfiguration).getBinaryTaskMng();
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public long startDownload(FileMsg fileMsg) {
        return this.mTaskManager.startDownload(fileMsg);
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void stopDownload(String str, long j, boolean z) {
        this.mTaskManager.stopDownload(str, j, z);
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public StatisticInfo getStatisticInfo(long j) {
        return this.mTaskManager.getStatsticInfo(j);
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public int getDownloadCommonVersion() {
        return 7;
    }
}
