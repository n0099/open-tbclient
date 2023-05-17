package com.baidu.searchbox.bddownload.core.listener.assist;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel;
/* loaded from: classes3.dex */
public class ListenerModelHandler<T extends ListenerModel> implements ListenerAssist {
    public Boolean alwaysRecoverModel;
    public final ModelCreator<T> creator;
    public final SparseArray<T> modelList = new SparseArray<>();
    public volatile T singleTaskModel;

    /* loaded from: classes3.dex */
    public interface ListenerModel {
        int getId();

        void onInfoValid(@NonNull BreakpointInfo breakpointInfo);
    }

    /* loaded from: classes3.dex */
    public interface ModelCreator<T extends ListenerModel> {
        T create(int i);
    }

    public ListenerModelHandler(ModelCreator<T> modelCreator) {
        this.creator = modelCreator;
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
            if (this.singleTaskModel != null && this.singleTaskModel.getId() == id) {
                t = this.singleTaskModel;
            } else {
                t = null;
            }
        }
        if (t == null) {
            t = this.modelList.get(id);
        }
        if (t == null && isAlwaysRecoverAssistModel()) {
            return addAndGetModel(downloadTask, breakpointInfo);
        }
        return t;
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
    public boolean isAlwaysRecoverAssistModel() {
        Boolean bool = this.alwaysRecoverModel;
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }
}
