package com.baidu.searchbox.bddownload.core.listener.assist;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Model;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler;
/* loaded from: classes2.dex */
public class DownloadBlockProgressListenerAssist<T extends Listener4Model> implements ListenerAssist {
    public AssistExtend assistExtend;
    public Listener4Callback callback;
    public final ListenerModelHandler<T> modelHandler;

    /* loaded from: classes2.dex */
    public interface AssistExtend {
        boolean dispatchBlockEnd(DownloadTask downloadTask, int i2, Listener4Model listener4Model);

        boolean dispatchFetchProgress(@NonNull DownloadTask downloadTask, int i2, long j, @NonNull Listener4Model listener4Model);

        boolean dispatchInfoReady(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull Listener4Model listener4Model);

        boolean dispatchTaskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc, @NonNull Listener4Model listener4Model);
    }

    /* loaded from: classes2.dex */
    public interface Listener4Callback {
        void blockEnd(DownloadTask downloadTask, int i2, BlockInfo blockInfo);

        void infoReady(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull Listener4Model listener4Model);

        void progress(DownloadTask downloadTask, long j);

        void progressBlock(DownloadTask downloadTask, int i2, long j);

        void taskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc, @NonNull Listener4Model listener4Model);
    }

    /* loaded from: classes2.dex */
    public static class Listener4Model implements ListenerModelHandler.ListenerModel {
        public SparseArray<Long> blockCurrentOffsetMap;
        public long currentOffset;
        public final int id;
        public BreakpointInfo info;

        public Listener4Model(int i2) {
            this.id = i2;
        }

        public SparseArray<Long> cloneBlockCurrentOffsetMap() {
            return this.blockCurrentOffsetMap.clone();
        }

        public long getBlockCurrentOffset(int i2) {
            return this.blockCurrentOffsetMap.get(i2).longValue();
        }

        public SparseArray<Long> getBlockCurrentOffsetMap() {
            return this.blockCurrentOffsetMap;
        }

        public long getCurrentOffset() {
            return this.currentOffset;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public int getId() {
            return this.id;
        }

        public BreakpointInfo getInfo() {
            return this.info;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(@NonNull BreakpointInfo breakpointInfo) {
            this.info = breakpointInfo;
            this.currentOffset = breakpointInfo.getTotalOffset();
            SparseArray<Long> sparseArray = new SparseArray<>();
            int blockCount = breakpointInfo.getBlockCount();
            for (int i2 = 0; i2 < blockCount; i2++) {
                sparseArray.put(i2, Long.valueOf(breakpointInfo.getBlock(i2).getCurrentOffset()));
            }
            this.blockCurrentOffsetMap = sparseArray;
        }
    }

    public DownloadBlockProgressListenerAssist(ListenerModelHandler<T> listenerModelHandler) {
        this.modelHandler = listenerModelHandler;
    }

    public void fetchEnd(DownloadTask downloadTask, int i2) {
        Listener4Callback listener4Callback;
        T orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo());
        if (orRecoverModel == null) {
            return;
        }
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchBlockEnd(downloadTask, i2, orRecoverModel)) && (listener4Callback = this.callback) != null) {
            listener4Callback.blockEnd(downloadTask, i2, orRecoverModel.info.getBlock(i2));
        }
    }

    public void fetchProgress(DownloadTask downloadTask, int i2, long j) {
        Listener4Callback listener4Callback;
        T orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo());
        if (orRecoverModel == null) {
            return;
        }
        long longValue = orRecoverModel.blockCurrentOffsetMap.get(i2).longValue() + j;
        orRecoverModel.blockCurrentOffsetMap.put(i2, Long.valueOf(longValue));
        orRecoverModel.currentOffset += j;
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchFetchProgress(downloadTask, i2, j, orRecoverModel)) && (listener4Callback = this.callback) != null) {
            listener4Callback.progressBlock(downloadTask, i2, longValue);
            this.callback.progress(downloadTask, orRecoverModel.currentOffset);
        }
    }

    public AssistExtend getAssistExtend() {
        return this.assistExtend;
    }

    public void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z) {
        Listener4Callback listener4Callback;
        T addAndGetModel = this.modelHandler.addAndGetModel(downloadTask, breakpointInfo);
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchInfoReady(downloadTask, breakpointInfo, z, addAndGetModel)) && (listener4Callback = this.callback) != null) {
            listener4Callback.infoReady(downloadTask, breakpointInfo, z, addAndGetModel);
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

    public void setAssistExtend(@NonNull AssistExtend assistExtend) {
        this.assistExtend = assistExtend;
    }

    public void setCallback(@NonNull Listener4Callback listener4Callback) {
        this.callback = listener4Callback;
    }

    public synchronized void taskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc) {
        T removeOrCreate = this.modelHandler.removeOrCreate(downloadTask, downloadTask.getInfo());
        if (this.assistExtend == null || !this.assistExtend.dispatchTaskEnd(downloadTask, endCause, exc, removeOrCreate)) {
            if (this.callback != null) {
                this.callback.taskEnd(downloadTask, endCause, exc, removeOrCreate);
            }
        }
    }

    public DownloadBlockProgressListenerAssist(ListenerModelHandler.ModelCreator<T> modelCreator) {
        this.modelHandler = new ListenerModelHandler<>(modelCreator);
    }
}
