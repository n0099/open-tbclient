package com.baidu.searchbox.bddownload.core.listener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend;
/* loaded from: classes2.dex */
public abstract class DownloadSpeedListener extends DownloadBlockProgressListener implements ListenerSpeedAssistExtend.Listener4SpeedCallback {

    /* loaded from: classes2.dex */
    public static class Listener4WithSpeedModelCreator implements ListenerModelHandler.ModelCreator<ListenerSpeedAssistExtend.Listener4SpeedModel> {
        public Listener4WithSpeedModelCreator() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ModelCreator
        public ListenerSpeedAssistExtend.Listener4SpeedModel create(int i) {
            return new ListenerSpeedAssistExtend.Listener4SpeedModel(i);
        }
    }

    public DownloadSpeedListener(ListenerSpeedAssistExtend listenerSpeedAssistExtend) {
        super(new DownloadBlockProgressListenerAssist(new Listener4WithSpeedModelCreator()));
        listenerSpeedAssistExtend.setCallback(this);
        setAssistExtend(listenerSpeedAssistExtend);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Callback
    public final void blockEnd(DownloadTask downloadTask, int i, BlockInfo blockInfo) {
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Callback
    public final void infoReady(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Callback
    public final void progress(DownloadTask downloadTask, long j) {
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Callback
    public final void progressBlock(DownloadTask downloadTask, int i, long j) {
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Callback
    public final void taskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc, @NonNull DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
    }

    public DownloadSpeedListener() {
        this(new ListenerSpeedAssistExtend());
    }
}
