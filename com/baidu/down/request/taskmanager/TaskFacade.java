package com.baidu.down.request.taskmanager;

import android.content.Context;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.TaskManagerConfiguration;
/* loaded from: classes2.dex */
public final class TaskFacade {
    public static final String TAG = "TaskFacade";
    public static TaskFacade instance;
    public BinaryTaskMng mBinaryTaskMng;
    public Context mContext;

    public TaskFacade(Context context, TaskManagerConfiguration taskManagerConfiguration) {
        this.mContext = context;
        this.mBinaryTaskMng = new BinaryTaskMng(this.mContext, taskManagerConfiguration);
    }

    public static TaskFacade getInstance(Context context) {
        return getInstanceByConfig(context, null);
    }

    public static TaskFacade getInstanceByConfig(Context context, TaskManagerConfiguration taskManagerConfiguration) {
        if (instance == null) {
            synchronized (TaskFacade.class) {
                if (instance == null) {
                    if (context == null) {
                        return null;
                    }
                    instance = new TaskFacade(context.getApplicationContext(), taskManagerConfiguration);
                }
            }
        }
        return instance;
    }

    public static synchronized void release() {
        synchronized (TaskFacade.class) {
            if (instance != null) {
                instance.mBinaryTaskMng.release();
                instance = null;
            }
        }
    }

    public long findTaskCurrentLength(String str, long j) {
        return this.mBinaryTaskMng.findTaskCurrentLength(str, j);
    }

    public String findTaskFilename(String str, long j) {
        return this.mBinaryTaskMng.findTaskFilename(str, j);
    }

    public String findTaskFilepath(String str, long j) {
        return this.mBinaryTaskMng.findTaskFilepath(str, j);
    }

    public String findTaskMimetype(String str, long j) {
        return this.mBinaryTaskMng.findTaskMimetype(str, j);
    }

    public int findTaskStatus(String str, long j) {
        return this.mBinaryTaskMng.findTaskStatus(str, j);
    }

    public long findTaskTotalLength(String str, long j) {
        return this.mBinaryTaskMng.findTaskTotalLength(str, j);
    }

    public BinaryTaskMng getBinaryTaskMng() {
        return this.mBinaryTaskMng;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCurrentTaskVacant() {
        return this.mBinaryTaskMng.getCurrentVacant();
    }

    public int getMaxTask() {
        return this.mBinaryTaskMng.getMaxDownloadThread();
    }

    public void pauseAllTask() {
        this.mBinaryTaskMng.pauseAllTask();
    }

    public void pauseDownload(String str, long j) {
        this.mBinaryTaskMng.pauseDownload(str, j);
    }

    public void setMaxTask(int i) {
        this.mBinaryTaskMng.setMaxDownloadThread(i);
    }

    public void startAllTask() {
        this.mBinaryTaskMng.runAllTask();
    }

    public long startDownload(FileMsg fileMsg) {
        return this.mBinaryTaskMng.startDownload(fileMsg);
    }

    public void stopAllTask(boolean z) {
        this.mBinaryTaskMng.stopAllTask(z);
    }

    public void stopDownload(String str, long j, boolean z) {
        this.mBinaryTaskMng.stopDownload(str, j, z);
    }
}
