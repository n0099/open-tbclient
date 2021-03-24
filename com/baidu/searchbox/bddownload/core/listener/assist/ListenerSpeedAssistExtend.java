package com.baidu.searchbox.bddownload.core.listener.assist;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.SpeedCalculator;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler;
/* loaded from: classes2.dex */
public class ListenerSpeedAssistExtend implements DownloadBlockProgressListenerAssist.AssistExtend, ListenerModelHandler.ModelCreator<Listener4SpeedModel> {
    public Listener4SpeedCallback callback;

    /* loaded from: classes2.dex */
    public interface Listener4SpeedCallback {
        void blockEnd(@NonNull DownloadTask downloadTask, int i, BlockInfo blockInfo, @NonNull SpeedCalculator speedCalculator);

        void infoReady(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull Listener4SpeedModel listener4SpeedModel);

        void progress(@NonNull DownloadTask downloadTask, long j, @NonNull SpeedCalculator speedCalculator);

        void progressBlock(@NonNull DownloadTask downloadTask, int i, long j, @NonNull SpeedCalculator speedCalculator);

        void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, @NonNull SpeedCalculator speedCalculator);
    }

    /* loaded from: classes2.dex */
    public static class Listener4SpeedModel extends DownloadBlockProgressListenerAssist.Listener4Model {
        public SparseArray<SpeedCalculator> blockSpeeds;
        public SpeedCalculator taskSpeed;

        public Listener4SpeedModel(int i) {
            super(i);
        }

        public SpeedCalculator getBlockSpeed(int i) {
            return this.blockSpeeds.get(i);
        }

        public SpeedCalculator getTaskSpeed() {
            return this.taskSpeed;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Model, com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(@NonNull BreakpointInfo breakpointInfo) {
            super.onInfoValid(breakpointInfo);
            this.taskSpeed = new SpeedCalculator();
            this.blockSpeeds = new SparseArray<>();
            int blockCount = breakpointInfo.getBlockCount();
            for (int i = 0; i < blockCount; i++) {
                this.blockSpeeds.put(i, new SpeedCalculator());
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.AssistExtend
    public boolean dispatchBlockEnd(DownloadTask downloadTask, int i, DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        Listener4SpeedModel listener4SpeedModel = (Listener4SpeedModel) listener4Model;
        listener4SpeedModel.blockSpeeds.get(i).endTask();
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.blockEnd(downloadTask, i, listener4Model.info.getBlock(i), listener4SpeedModel.getBlockSpeed(i));
            return true;
        }
        return true;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.AssistExtend
    public boolean dispatchFetchProgress(@NonNull DownloadTask downloadTask, int i, long j, @NonNull DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        Listener4SpeedModel listener4SpeedModel = (Listener4SpeedModel) listener4Model;
        listener4SpeedModel.blockSpeeds.get(i).downloading(j);
        listener4SpeedModel.taskSpeed.downloading(j);
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.progressBlock(downloadTask, i, listener4Model.blockCurrentOffsetMap.get(i).longValue(), listener4SpeedModel.getBlockSpeed(i));
            this.callback.progress(downloadTask, listener4Model.currentOffset, listener4SpeedModel.taskSpeed);
            return true;
        }
        return true;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.AssistExtend
    public boolean dispatchInfoReady(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.infoReady(downloadTask, breakpointInfo, z, (Listener4SpeedModel) listener4Model);
            return true;
        }
        return true;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.AssistExtend
    public boolean dispatchTaskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc, @NonNull DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        SpeedCalculator speedCalculator = ((Listener4SpeedModel) listener4Model).taskSpeed;
        if (speedCalculator != null) {
            speedCalculator.endTask();
        } else {
            speedCalculator = new SpeedCalculator();
        }
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.taskEnd(downloadTask, endCause, exc, speedCalculator);
            return true;
        }
        return true;
    }

    public void setCallback(Listener4SpeedCallback listener4SpeedCallback) {
        this.callback = listener4SpeedCallback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ModelCreator
    public Listener4SpeedModel create(int i) {
        return new Listener4SpeedModel(i);
    }
}
