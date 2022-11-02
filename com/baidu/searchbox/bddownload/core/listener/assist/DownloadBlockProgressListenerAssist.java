package com.baidu.searchbox.bddownload.core.listener.assist;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Model;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DownloadBlockProgressListenerAssist<T extends Listener4Model> implements ListenerAssist {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AssistExtend assistExtend;
    public Listener4Callback callback;
    public final ListenerModelHandler<T> modelHandler;

    /* loaded from: classes2.dex */
    public interface AssistExtend {
        boolean dispatchBlockEnd(DownloadTask downloadTask, int i, Listener4Model listener4Model);

        boolean dispatchFetchProgress(@NonNull DownloadTask downloadTask, int i, long j, @NonNull Listener4Model listener4Model);

        boolean dispatchInfoReady(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull Listener4Model listener4Model);

        boolean dispatchTaskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc, @NonNull Listener4Model listener4Model);
    }

    /* loaded from: classes2.dex */
    public interface Listener4Callback {
        void blockEnd(DownloadTask downloadTask, int i, BlockInfo blockInfo);

        void infoReady(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull Listener4Model listener4Model);

        void progress(DownloadTask downloadTask, long j);

        void progressBlock(DownloadTask downloadTask, int i, long j);

        void taskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc, @NonNull Listener4Model listener4Model);
    }

    /* loaded from: classes2.dex */
    public static class Listener4Model implements ListenerModelHandler.ListenerModel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<Long> blockCurrentOffsetMap;
        public long currentOffset;
        public final int id;
        public BreakpointInfo info;

        public Listener4Model(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = i;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(@NonNull BreakpointInfo breakpointInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, breakpointInfo) == null) {
                this.info = breakpointInfo;
                this.currentOffset = breakpointInfo.getTotalOffset();
                SparseArray<Long> sparseArray = new SparseArray<>();
                int blockCount = breakpointInfo.getBlockCount();
                for (int i = 0; i < blockCount; i++) {
                    sparseArray.put(i, Long.valueOf(breakpointInfo.getBlock(i).getCurrentOffset()));
                }
                this.blockCurrentOffsetMap = sparseArray;
            }
        }

        public SparseArray<Long> cloneBlockCurrentOffsetMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.blockCurrentOffsetMap.clone();
            }
            return (SparseArray) invokeV.objValue;
        }

        public SparseArray<Long> getBlockCurrentOffsetMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.blockCurrentOffsetMap;
            }
            return (SparseArray) invokeV.objValue;
        }

        public long getCurrentOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.currentOffset;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.id;
            }
            return invokeV.intValue;
        }

        public BreakpointInfo getInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.info;
            }
            return (BreakpointInfo) invokeV.objValue;
        }

        public long getBlockCurrentOffset(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                Long l = this.blockCurrentOffsetMap.get(i);
                if (l == null) {
                    return 0L;
                }
                return l.longValue();
            }
            return invokeI.longValue;
        }
    }

    public DownloadBlockProgressListenerAssist(ListenerModelHandler.ModelCreator<T> modelCreator) {
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
        this.modelHandler = new ListenerModelHandler<>(modelCreator);
    }

    public DownloadBlockProgressListenerAssist(ListenerModelHandler<T> listenerModelHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listenerModelHandler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.modelHandler = listenerModelHandler;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.modelHandler.setAlwaysRecoverAssistModel(z);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.modelHandler.setAlwaysRecoverAssistModelIfNotSet(z);
        }
    }

    public void setAssistExtend(@NonNull AssistExtend assistExtend) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, assistExtend) == null) {
            this.assistExtend = assistExtend;
        }
    }

    public void setCallback(@NonNull Listener4Callback listener4Callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, listener4Callback) == null) {
            this.callback = listener4Callback;
        }
    }

    public void fetchEnd(DownloadTask downloadTask, int i) {
        T orRecoverModel;
        Listener4Callback listener4Callback;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048576, this, downloadTask, i) != null) || (orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo())) == null) {
            return;
        }
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchBlockEnd(downloadTask, i, orRecoverModel)) && (listener4Callback = this.callback) != null) {
            listener4Callback.blockEnd(downloadTask, i, orRecoverModel.info.getBlock(i));
        }
    }

    public void fetchProgress(DownloadTask downloadTask, int i, long j) {
        T orRecoverModel;
        Listener4Callback listener4Callback;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadTask, Integer.valueOf(i), Long.valueOf(j)}) != null) || (orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo())) == null) {
            return;
        }
        long blockCurrentOffset = orRecoverModel.getBlockCurrentOffset(i) + j;
        orRecoverModel.blockCurrentOffsetMap.put(i, Long.valueOf(blockCurrentOffset));
        orRecoverModel.currentOffset += j;
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchFetchProgress(downloadTask, i, j, orRecoverModel)) && (listener4Callback = this.callback) != null) {
            listener4Callback.progressBlock(downloadTask, i, blockCurrentOffset);
            this.callback.progress(downloadTask, orRecoverModel.currentOffset);
        }
    }

    public AssistExtend getAssistExtend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.assistExtend;
        }
        return (AssistExtend) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.modelHandler.isAlwaysRecoverAssistModel();
        }
        return invokeV.booleanValue;
    }

    public void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z) {
        Listener4Callback listener4Callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, downloadTask, breakpointInfo, z) == null) {
            T addAndGetModel = this.modelHandler.addAndGetModel(downloadTask, breakpointInfo);
            AssistExtend assistExtend = this.assistExtend;
            if ((assistExtend == null || !assistExtend.dispatchInfoReady(downloadTask, breakpointInfo, z, addAndGetModel)) && (listener4Callback = this.callback) != null) {
                listener4Callback.infoReady(downloadTask, breakpointInfo, z, addAndGetModel);
            }
        }
    }

    public synchronized void taskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, downloadTask, endCause, exc) == null) {
            synchronized (this) {
                T removeOrCreate = this.modelHandler.removeOrCreate(downloadTask, downloadTask.getInfo());
                if (this.assistExtend != null && this.assistExtend.dispatchTaskEnd(downloadTask, endCause, exc, removeOrCreate)) {
                    return;
                }
                if (this.callback != null) {
                    this.callback.taskEnd(downloadTask, endCause, exc, removeOrCreate);
                }
            }
        }
    }
}
