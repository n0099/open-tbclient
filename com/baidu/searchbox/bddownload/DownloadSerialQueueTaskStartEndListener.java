package com.baidu.searchbox.bddownload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadListener;
import com.baidu.searchbox.bddownload.core.listener.DownloadListenerBunch;
import com.baidu.searchbox.bddownload.core.listener.DownloadTaskStartEndListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class DownloadSerialQueueTaskStartEndListener extends DownloadTaskStartEndListener implements Runnable {
    public static final int ID_INVALID = 0;
    public static final Executor SERIAL_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BdDownload DynamicSerial", false));
    public static final String TAG = "DownloadSerialQueueTaskStartEndListener";
    @NonNull
    public DownloadListenerBunch listenerBunch;
    public volatile boolean looping;
    public volatile boolean paused;
    public volatile DownloadTask runningTask;
    public volatile boolean shutedDown;
    public final ArrayList<DownloadTask> taskList;

    public DownloadSerialQueueTaskStartEndListener() {
        this(null);
    }

    public int getWaitingTaskCount() {
        return this.taskList.size();
    }

    public int getWorkingTaskId() {
        if (this.runningTask != null) {
            return this.runningTask.getId();
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        DownloadTask remove;
        while (!this.shutedDown) {
            synchronized (this) {
                if (!this.taskList.isEmpty() && !this.paused) {
                    remove = this.taskList.remove(0);
                }
                this.runningTask = null;
                this.looping = false;
                return;
            }
            remove.execute(this.listenerBunch);
        }
    }

    public synchronized DownloadTask[] shutdown() {
        DownloadTask[] downloadTaskArr;
        this.shutedDown = true;
        if (this.runningTask != null) {
            this.runningTask.cancel();
        }
        downloadTaskArr = new DownloadTask[this.taskList.size()];
        this.taskList.toArray(downloadTaskArr);
        this.taskList.clear();
        return downloadTaskArr;
    }

    public void startNewLooper() {
        SERIAL_EXECUTOR.execute(this);
    }

    public DownloadSerialQueueTaskStartEndListener(DownloadListener downloadListener) {
        this(downloadListener, new ArrayList());
    }

    public synchronized void enqueue(DownloadTask downloadTask) {
        this.taskList.add(downloadTask);
        Collections.sort(this.taskList);
        if (!this.paused && !this.looping) {
            this.looping = true;
            startNewLooper();
        }
    }

    public void setListener(DownloadListener downloadListener) {
        this.listenerBunch = new DownloadListenerBunch.Builder().append(this).append(downloadListener).build();
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void taskStart(@NonNull DownloadTask downloadTask) {
        this.runningTask = downloadTask;
    }

    public DownloadSerialQueueTaskStartEndListener(DownloadListener downloadListener, ArrayList<DownloadTask> arrayList) {
        this.shutedDown = false;
        this.looping = false;
        this.paused = false;
        this.listenerBunch = new DownloadListenerBunch.Builder().append(this).append(downloadListener).build();
        this.taskList = arrayList;
    }

    public synchronized void pause() {
        if (this.paused) {
            Util.w(TAG, "require pause this queue(remain " + this.taskList.size() + "), butit has already been paused");
            return;
        }
        this.paused = true;
        if (this.runningTask != null) {
            this.runningTask.cancel();
            this.taskList.add(0, this.runningTask);
            this.runningTask = null;
        }
    }

    public synchronized void resume() {
        if (!this.paused) {
            Util.w(TAG, "require resume this queue(remain " + this.taskList.size() + "), but it is still running");
            return;
        }
        this.paused = false;
        if (!this.taskList.isEmpty() && !this.looping) {
            this.looping = true;
            startNewLooper();
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public synchronized void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc) {
        if (endCause != EndCause.CANCELED && downloadTask == this.runningTask) {
            this.runningTask = null;
        }
    }
}
