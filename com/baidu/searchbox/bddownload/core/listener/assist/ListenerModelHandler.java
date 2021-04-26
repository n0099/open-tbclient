package com.baidu.searchbox.bddownload.core.listener.assist;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel;
/* loaded from: classes2.dex */
public class ListenerModelHandler<T extends ListenerModel> implements ListenerAssist {
    public Boolean alwaysRecoverModel;
    public final ModelCreator<T> creator;
    public final SparseArray<T> modelList = new SparseArray<>();
    public volatile T singleTaskModel;

    /* loaded from: classes2.dex */
    public interface ListenerModel {
        int getId();

        void onInfoValid(@NonNull BreakpointInfo breakpointInfo);
    }

    /* loaded from: classes2.dex */
    public interface ModelCreator<T extends ListenerModel> {
        T create(int i2);
    }

    public ListenerModelHandler(ModelCreator<T> modelCreator) {
        this.creator = modelCreator;
    }

    @NonNull
    public T addAndGetModel(@NonNull DownloadTask downloadTask, @Nullable BreakpointInfo breakpointInfo) {
        T create = this.creator.create(downloadTask.getId());
        synchronized (this) {
            if (this.singleTaskModel == null) {
                this.singleTaskModel = create;
            } else {
                this.modelList.put(downloadTask.getId(), create);
            }
            if (breakpointInfo != null) {
                create.onInfoValid(breakpointInfo);
            }
        }
        return create;
    }

    @Nullable
    public T getOrRecoverModel(@NonNull DownloadTask downloadTask, @Nullable BreakpointInfo breakpointInfo) {
        T t;
        int id = downloadTask.getId();
        synchronized (this) {
            t = (this.singleTaskModel == null || this.singleTaskModel.getId() != id) ? null : this.singleTaskModel;
        }
        if (t == null) {
            t = this.modelList.get(id);
        }
        return (t == null && isAlwaysRecoverAssistModel()) ? addAndGetModel(downloadTask, breakpointInfo) : t;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        Boolean bool = this.alwaysRecoverModel;
        return bool != null && bool.booleanValue();
    }

    @NonNull
    public T removeOrCreate(@NonNull DownloadTask downloadTask, @Nullable BreakpointInfo breakpointInfo) {
        T t;
        int id = downloadTask.getId();
        synchronized (this) {
            if (this.singleTaskModel != null && this.singleTaskModel.getId() == id) {
                t = this.singleTaskModel;
                this.singleTaskModel = null;
            } else {
                t = this.modelList.get(id);
                this.modelList.remove(id);
            }
        }
        if (t == null) {
            t = this.creator.create(id);
            if (breakpointInfo != null) {
                t.onInfoValid(breakpointInfo);
            }
        }
        return t;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean z) {
        this.alwaysRecoverModel = Boolean.valueOf(z);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        if (this.alwaysRecoverModel == null) {
            this.alwaysRecoverModel = Boolean.valueOf(z);
        }
    }
}
