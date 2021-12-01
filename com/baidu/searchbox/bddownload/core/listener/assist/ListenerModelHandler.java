package com.baidu.searchbox.bddownload.core.listener.assist;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ListenerModelHandler<T extends ListenerModel> implements ListenerAssist {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean alwaysRecoverModel;
    public final ModelCreator<T> creator;
    public final SparseArray<T> modelList;
    public volatile T singleTaskModel;

    /* loaded from: classes9.dex */
    public interface ListenerModel {
        int getId();

        void onInfoValid(@NonNull BreakpointInfo breakpointInfo);
    }

    /* loaded from: classes9.dex */
    public interface ModelCreator<T extends ListenerModel> {
        T create(int i2);
    }

    public ListenerModelHandler(ModelCreator<T> modelCreator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {modelCreator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.modelList = new SparseArray<>();
        this.creator = modelCreator;
    }

    @NonNull
    public T addAndGetModel(@NonNull DownloadTask downloadTask, @Nullable BreakpointInfo breakpointInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, downloadTask, breakpointInfo)) == null) {
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
        return (T) invokeLL.objValue;
    }

    @Nullable
    public T getOrRecoverModel(@NonNull DownloadTask downloadTask, @Nullable BreakpointInfo breakpointInfo) {
        InterceptResult invokeLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, breakpointInfo)) == null) {
            int id = downloadTask.getId();
            synchronized (this) {
                t = (this.singleTaskModel == null || this.singleTaskModel.getId() != id) ? null : this.singleTaskModel;
            }
            if (t == null) {
                t = this.modelList.get(id);
            }
            return (t == null && isAlwaysRecoverAssistModel()) ? addAndGetModel(downloadTask, breakpointInfo) : t;
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Boolean bool = this.alwaysRecoverModel;
            return bool != null && bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public T removeOrCreate(@NonNull DownloadTask downloadTask, @Nullable BreakpointInfo breakpointInfo) {
        InterceptResult invokeLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, downloadTask, breakpointInfo)) == null) {
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
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.alwaysRecoverModel = Boolean.valueOf(z);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && this.alwaysRecoverModel == null) {
            this.alwaysRecoverModel = Boolean.valueOf(z);
        }
    }
}
