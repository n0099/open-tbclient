package com.baidu.down.request.taskmanager;

import android.content.Context;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.TaskManagerConfiguration;
/* loaded from: classes3.dex */
public final class TaskFacade {
    private static final String TAG = TaskFacade.class.getSimpleName();
    private static TaskFacade instance = null;
    private BinaryTaskMng mBinaryTaskMng;
    Context mContext;

    private TaskFacade(Context context, TaskManagerConfiguration taskManagerConfiguration) {
        this.mContext = context;
        this.mBinaryTaskMng = new BinaryTaskMng(this.mContext, taskManagerConfiguration);
    }

    public BinaryTaskMng getBinaryTaskMng() {
        return this.mBinaryTaskMng;
    }

    public Context getContext() {
        return this.mContext;
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

    public static TaskFacade getInstance(Context context) {
        return getInstanceByConfig(context, null);
    }

    public static synchronized void release() {
        synchronized (TaskFacade.class) {
            if (instance != null) {
                instance.mBinaryTaskMng.release();
                instance = null;
            }
        }
    }

    public int getMaxTask() {
        return this.mBinaryTaskMng.getMaxDownloadThread();
    }

    public int getCurrentTaskVacant() {
        return this.mBinaryTaskMng.getCurrentVacant();
    }

    public void setMaxTask(int i) {
        this.mBinaryTaskMng.setMaxDownloadThread(i);
    }

    public long startDownload(FileMsg fileMsg) {
        return this.mBinaryTaskMng.startDownload(fileMsg);
    }

    public void pauseDownload(String str, long j) {
        this.mBinaryTaskMng.pauseDownload(str, j);
    }

    public void stopDownload(String str, long j, boolean z) {
        this.mBinaryTaskMng.stopDownload(str, j, z);
    }

    public void stopAllTask(boolean z) {
        this.mBinaryTaskMng.stopAllTask(z);
    }

    public void startAllTask() {
        this.mBinaryTaskMng.runAllTask();
    }

    public void pauseAllTask() {
        this.mBinaryTaskMng.pauseAllTask();
    }

    public int findTaskStatus(String str, long j) {
        return this.mBinaryTaskMng.findTaskStatus(str, j);
    }

    public long findTaskTotalLength(String str, long j) {
        return this.mBinaryTaskMng.findTaskTotalLength(str, j);
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
}
