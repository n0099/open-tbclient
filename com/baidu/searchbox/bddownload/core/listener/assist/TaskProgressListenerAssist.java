package com.baidu.searchbox.bddownload.core.listener.assist;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public class TaskProgressListenerAssist implements ListenerAssist, ListenerModelHandler.ModelCreator<Listener1Model> {
    public TaskProgressListenerCallback callback;
    public final ListenerModelHandler<Listener1Model> modelHandler;

    /* loaded from: classes2.dex */
    public static class Listener1Model implements ListenerModelHandler.ListenerModel {
        public int blockCount;
        public final AtomicLong currentOffset = new AtomicLong();
        public final int id;
        public volatile Boolean isFirstConnect;
        public Boolean isFromResumed;
        public Boolean isStarted;
        public long totalLength;

        public Listener1Model(int i2) {
            this.id = i2;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public int getId() {
            return this.id;
        }

        public long getTotalLength() {
            return this.totalLength;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(@NonNull BreakpointInfo breakpointInfo) {
            this.blockCount = breakpointInfo.getBlockCount();
            this.totalLength = breakpointInfo.getTotalLength();
            this.currentOffset.set(breakpointInfo.getTotalOffset());
            if (this.isStarted == null) {
                this.isStarted = Boolean.FALSE;
            }
            if (this.isFromResumed == null) {
                this.isFromResumed = Boolean.valueOf(this.currentOffset.get() > 0);
            }
            if (this.isFirstConnect == null) {
                this.isFirstConnect = Boolean.TRUE;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface TaskProgressListenerCallback {
        void connected(@NonNull DownloadTask downloadTask, @IntRange(from = 0) int i2, @IntRange(from = 0) long j, @IntRange(from = 0) long j2);

        void progress(@NonNull DownloadTask downloadTask, @IntRange(from = 0) long j, @IntRange(from = 0) long j2);

        void retry(@NonNull DownloadTask downloadTask, @NonNull ResumeFailedCause resumeFailedCause);

        void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, @NonNull Listener1Model listener1Model);

        void taskStart(@NonNull DownloadTask downloadTask, @NonNull Listener1Model listener1Model);
    }

    public TaskProgressListenerAssist() {
        this.modelHandler = new ListenerModelHandler<>(this);
    }

    public void connectEnd(DownloadTask downloadTask) {
        Listener1Model orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo());
        if (orRecoverModel == null) {
            return;
        }
        if (orRecoverModel.isFromResumed == null) {
            orRecoverModel.isFromResumed = Boolean.FALSE;
        }
        if (orRecoverModel.isFirstConnect == null) {
            orRecoverModel.isFirstConnect = Boolean.TRUE;
        }
        if (orRecoverModel.isFromResumed.booleanValue() && orRecoverModel.isFirstConnect.booleanValue()) {
            orRecoverModel.isFirstConnect = Boolean.FALSE;
        }
        TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
        if (taskProgressListenerCallback != null) {
            taskProgressListenerCallback.connected(downloadTask, orRecoverModel.blockCount, orRecoverModel.currentOffset.get(), orRecoverModel.totalLength);
        }
    }

    public void downloadFromBeginning(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause) {
        TaskProgressListenerCallback taskProgressListenerCallback;
        Listener1Model orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, breakpointInfo);
        if (orRecoverModel == null) {
            return;
        }
        orRecoverModel.onInfoValid(breakpointInfo);
        if (orRecoverModel.isStarted.booleanValue() && (taskProgressListenerCallback = this.callback) != null) {
            taskProgressListenerCallback.retry(downloadTask, resumeFailedCause);
        }
        orRecoverModel.isStarted = Boolean.TRUE;
        orRecoverModel.isFromResumed = Boolean.FALSE;
        orRecoverModel.isFirstConnect = Boolean.TRUE;
    }

    public void downloadFromBreakpoint(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        Listener1Model orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, breakpointInfo);
        if (orRecoverModel == null) {
            return;
        }
        orRecoverModel.onInfoValid(breakpointInfo);
        Boolean bool = Boolean.TRUE;
        orRecoverModel.isStarted = bool;
        orRecoverModel.isFromResumed = bool;
        orRecoverModel.isFirstConnect = bool;
    }

    public void fetchProgress(DownloadTask downloadTask, long j) {
        Listener1Model orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo());
        if (orRecoverModel == null) {
            return;
        }
        orRecoverModel.currentOffset.addAndGet(j);
        TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
        if (taskProgressListenerCallback != null) {
            taskProgressListenerCallback.progress(downloadTask, orRecoverModel.currentOffset.get(), orRecoverModel.totalLength);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        return this.modelHandler.isAlwaysRecoverAssistModel();
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean z) {
        this.modelHandler.setAlwaysRecoverAssistModel(z);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        this.modelHandler.setAlwaysRecoverAssistModelIfNotSet(z);
    }

    public void setCallback(@NonNull TaskProgressListenerCallback taskProgressListenerCallback) {
        this.callback = taskProgressListenerCallback;
    }

    public void taskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc) {
        Listener1Model removeOrCreate = this.modelHandler.removeOrCreate(downloadTask, downloadTask.getInfo());
        TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
        if (taskProgressListenerCallback != null) {
            taskProgressListenerCallback.taskEnd(downloadTask, endCause, exc, removeOrCreate);
        }
    }

    public void taskStart(DownloadTask downloadTask) {
        Listener1Model addAndGetModel = this.modelHandler.addAndGetModel(downloadTask, null);
        TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
        if (taskProgressListenerCallback != null) {
            taskProgressListenerCallback.taskStart(downloadTask, addAndGetModel);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ModelCreator
    public Listener1Model create(int i2) {
        return new Listener1Model(i2);
    }

    public TaskProgressListenerAssist(ListenerModelHandler<Listener1Model> listenerModelHandler) {
        this.modelHandler = listenerModelHandler;
    }
}
