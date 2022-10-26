package com.baidu.searchbox.bddownload.core.listener.assist;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ListenerModelHandler implements ListenerAssist {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean alwaysRecoverModel;
    public final ModelCreator creator;
    public final SparseArray modelList;
    public volatile ListenerModel singleTaskModel;

    /* loaded from: classes2.dex */
    public interface ListenerModel {
        int getId();

        void onInfoValid(BreakpointInfo breakpointInfo);
    }

    /* loaded from: classes2.dex */
    public interface ModelCreator {
        ListenerModel create(int i);
    }

    public ListenerModelHandler(ModelCreator modelCreator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {modelCreator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.modelList = new SparseArray();
        this.creator = modelCreator;
    }

    public ListenerModel addAndGetModel(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, downloadTask, breakpointInfo)) == null) {
            ListenerModel create = this.creator.create(downloadTask.getId());
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
        return (ListenerModel) invokeLL.objValue;
    }

    public ListenerModel getOrRecoverModel(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        InterceptResult invokeLL;
        ListenerModel listenerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, breakpointInfo)) == null) {
            int id = downloadTask.getId();
            synchronized (this) {
                if (this.singleTaskModel != null && this.singleTaskModel.getId() == id) {
                    listenerModel = this.singleTaskModel;
                } else {
                    listenerModel = null;
                }
            }
            if (listenerModel == null) {
                listenerModel = (ListenerModel) this.modelList.get(id);
            }
            if (listenerModel == null && isAlwaysRecoverAssistModel()) {
                return addAndGetModel(downloadTask, breakpointInfo);
            }
            return listenerModel;
        }
        return (ListenerModel) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Boolean bool = this.alwaysRecoverModel;
            if (bool != null && bool.booleanValue()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ListenerModel removeOrCreate(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        InterceptResult invokeLL;
        ListenerModel listenerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, downloadTask, breakpointInfo)) == null) {
            int id = downloadTask.getId();
            synchronized (this) {
                if (this.singleTaskModel != null && this.singleTaskModel.getId() == id) {
                    listenerModel = this.singleTaskModel;
                    this.singleTaskModel = null;
                } else {
                    listenerModel = (ListenerModel) this.modelList.get(id);
                    this.modelList.remove(id);
                }
            }
            if (listenerModel == null) {
                listenerModel = this.creator.create(id);
                if (breakpointInfo != null) {
                    listenerModel.onInfoValid(breakpointInfo);
                }
            }
            return listenerModel;
        }
        return (ListenerModel) invokeLL.objValue;
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
