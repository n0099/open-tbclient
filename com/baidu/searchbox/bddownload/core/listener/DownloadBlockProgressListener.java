package com.baidu.searchbox.bddownload.core.listener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class DownloadBlockProgressListener implements DownloadListener, DownloadBlockProgressListenerAssist.Listener4Callback, ListenerAssist {
    public final DownloadBlockProgressListenerAssist assist;

    /* loaded from: classes2.dex */
    public static class Listener4ModelCreator implements ListenerModelHandler.ModelCreator<DownloadBlockProgressListenerAssist.Listener4Model> {
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ModelCreator
        public DownloadBlockProgressListenerAssist.Listener4Model create(int i2) {
            return new DownloadBlockProgressListenerAssist.Listener4Model(i2);
        }
    }

    public DownloadBlockProgressListener(DownloadBlockProgressListenerAssist downloadBlockProgressListenerAssist) {
        this.assist = downloadBlockProgressListenerAssist;
        downloadBlockProgressListenerAssist.setCallback(this);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialEnd(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialStart(@NonNull DownloadTask downloadTask, @NonNull Map<String, List<String>> map) {
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public final void downloadFromBeginning(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull ResumeFailedCause resumeFailedCause) {
        this.assist.infoReady(downloadTask, breakpointInfo, false);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public final void downloadFromBreakpoint(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        this.assist.infoReady(downloadTask, breakpointInfo, true);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchEnd(@NonNull DownloadTask downloadTask, int i2, long j) {
        this.assist.fetchEnd(downloadTask, i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public final void fetchProgress(@NonNull DownloadTask downloadTask, int i2, long j) {
        this.assist.fetchProgress(downloadTask, i2, j);
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

    public void setAssistExtend(@NonNull DownloadBlockProgressListenerAssist.AssistExtend assistExtend) {
        this.assist.setAssistExtend(assistExtend);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public final void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc) {
        this.assist.taskEnd(downloadTask, endCause, exc);
    }

    public DownloadBlockProgressListener() {
        this(new DownloadBlockProgressListenerAssist(new Listener4ModelCreator()));
    }
}
