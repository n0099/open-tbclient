package com.baidu.searchbox.bddownload.core.listener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist;
import com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class DownloadTaskProgressListener implements DownloadListener, TaskProgressListenerAssist.TaskProgressListenerCallback, ListenerAssist {
    public final TaskProgressListenerAssist assist;

    public DownloadTaskProgressListener(TaskProgressListenerAssist taskProgressListenerAssist) {
        this.assist = taskProgressListenerAssist;
        taskProgressListenerAssist.setCallback(this);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectEnd(@NonNull DownloadTask downloadTask, int i2, int i3, @NonNull Map<String, List<String>> map) {
        this.assist.connectEnd(downloadTask);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectStart(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialEnd(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialStart(@NonNull DownloadTask downloadTask, @NonNull Map<String, List<String>> map) {
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void downloadFromBeginning(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull ResumeFailedCause resumeFailedCause) {
        this.assist.downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void downloadFromBreakpoint(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        this.assist.downloadFromBreakpoint(downloadTask, breakpointInfo);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchEnd(@NonNull DownloadTask downloadTask, int i2, long j) {
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchProgress(@NonNull DownloadTask downloadTask, int i2, long j) {
        this.assist.fetchProgress(downloadTask, j);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchStart(@NonNull DownloadTask downloadTask, int i2, long j) {
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        return this.assist.isAlwaysRecoverAssistModel();
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean z) {
        this.assist.setAlwaysRecoverAssistModel(z);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        this.assist.setAlwaysRecoverAssistModelIfNotSet(z);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public final void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc) {
        this.assist.taskEnd(downloadTask, endCause, exc);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public final void taskStart(@NonNull DownloadTask downloadTask) {
        this.assist.taskStart(downloadTask);
    }

    public DownloadTaskProgressListener() {
        this(new TaskProgressListenerAssist());
    }
}
