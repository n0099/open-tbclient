package com.baidu.searchbox.bddownload.core.listener.assist;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public class TaskProgressListenerAssist implements ListenerAssist, ListenerModelHandler.ModelCreator<Listener1Model> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TaskProgressListenerCallback callback;
    public final ListenerModelHandler<Listener1Model> modelHandler;

    /* loaded from: classes10.dex */
    public static class Listener1Model implements ListenerModelHandler.ListenerModel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int blockCount;
        public final AtomicLong currentOffset;
        public final int id;
        public volatile Boolean isFirstConnect;
        public Boolean isFromResumed;
        public Boolean isStarted;
        public long totalLength;

        public Listener1Model(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.currentOffset = new AtomicLong();
            this.id = i2;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : invokeV.intValue;
        }

        public long getTotalLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.totalLength : invokeV.longValue;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(@NonNull BreakpointInfo breakpointInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, breakpointInfo) == null) {
                this.blockCount = breakpointInfo.getBlockCount();
                this.totalLength = breakpointInfo.getTotalLength();
                this.currentOffset.set(breakpointInfo.getTotalOffset());
                if (this.isStarted == null) {
                    this.isStarted = Boolean.FALSE;
                }
                if (this.isFromResumed == null) {
                    this.isFromResumed = Boolean.valueOf(this.currentOffset.get() > 0);
                }
                if (this.isFirstConnect == null) {
                    this.isFirstConnect = Boolean.TRUE;
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface TaskProgressListenerCallback {
        void connected(@NonNull DownloadTask downloadTask, @IntRange(from = 0) int i2, @IntRange(from = 0) long j2, @IntRange(from = 0) long j3);

        void progress(@NonNull DownloadTask downloadTask, @IntRange(from = 0) long j2, @IntRange(from = 0) long j3);

        void retry(@NonNull DownloadTask downloadTask, @NonNull ResumeFailedCause resumeFailedCause);

        void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, @NonNull Listener1Model listener1Model);

        void taskStart(@NonNull DownloadTask downloadTask, @NonNull Listener1Model listener1Model);
    }

    public TaskProgressListenerAssist() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.modelHandler = new ListenerModelHandler<>(this);
    }

    public void connectEnd(DownloadTask downloadTask) {
        Listener1Model orRecoverModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadTask) == null) || (orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo())) == null) {
            return;
        }
        if (orRecoverModel.isFromResumed == null) {
            orRecoverModel.isFromResumed = Boolean.FALSE;
        }
        if (orRecoverModel.isFirstConnect == null) {
            orRecoverModel.isFirstConnect = Boolean.TRUE;
        }
        if (orRecoverModel.isFromResumed.booleanValue() && orRecoverModel.isFirstConnect.booleanValue()) {
            orRecoverModel.isFirstConnect = Boolean.FALSE;
        }
        TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
        if (taskProgressListenerCallback != null) {
            taskProgressListenerCallback.connected(downloadTask, orRecoverModel.blockCount, orRecoverModel.currentOffset.get(), orRecoverModel.totalLength);
        }
    }

    public void downloadFromBeginning(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause) {
        Listener1Model orRecoverModel;
        TaskProgressListenerCallback taskProgressListenerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, downloadTask, breakpointInfo, resumeFailedCause) == null) || (orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, breakpointInfo)) == null) {
            return;
        }
        orRecoverModel.onInfoValid(breakpointInfo);
        if (orRecoverModel.isStarted.booleanValue() && (taskProgressListenerCallback = this.callback) != null) {
            taskProgressListenerCallback.retry(downloadTask, resumeFailedCause);
        }
        orRecoverModel.isStarted = Boolean.TRUE;
        orRecoverModel.isFromResumed = Boolean.FALSE;
        orRecoverModel.isFirstConnect = Boolean.TRUE;
    }

    public void downloadFromBreakpoint(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        Listener1Model orRecoverModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, downloadTask, breakpointInfo) == null) || (orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, breakpointInfo)) == null) {
            return;
        }
        orRecoverModel.onInfoValid(breakpointInfo);
        Boolean bool = Boolean.TRUE;
        orRecoverModel.isStarted = bool;
        orRecoverModel.isFromResumed = bool;
        orRecoverModel.isFirstConnect = bool;
    }

    public void fetchProgress(DownloadTask downloadTask, long j2) {
        Listener1Model orRecoverModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048581, this, downloadTask, j2) == null) || (orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo())) == null) {
            return;
        }
        orRecoverModel.currentOffset.addAndGet(j2);
        TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
        if (taskProgressListenerCallback != null) {
            taskProgressListenerCallback.progress(downloadTask, orRecoverModel.currentOffset.get(), orRecoverModel.totalLength);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.modelHandler.isAlwaysRecoverAssistModel() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.modelHandler.setAlwaysRecoverAssistModel(z);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.modelHandler.setAlwaysRecoverAssistModelIfNotSet(z);
        }
    }

    public void setCallback(@NonNull TaskProgressListenerCallback taskProgressListenerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, taskProgressListenerCallback) == null) {
            this.callback = taskProgressListenerCallback;
        }
    }

    public void taskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, downloadTask, endCause, exc) == null) {
            Listener1Model removeOrCreate = this.modelHandler.removeOrCreate(downloadTask, downloadTask.getInfo());
            TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
            if (taskProgressListenerCallback != null) {
                taskProgressListenerCallback.taskEnd(downloadTask, endCause, exc, removeOrCreate);
            }
        }
    }

    public void taskStart(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, downloadTask) == null) {
            Listener1Model addAndGetModel = this.modelHandler.addAndGetModel(downloadTask, null);
            TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
            if (taskProgressListenerCallback != null) {
                taskProgressListenerCallback.taskStart(downloadTask, addAndGetModel);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ModelCreator
    public Listener1Model create(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new Listener1Model(i2) : (Listener1Model) invokeI.objValue;
    }

    public TaskProgressListenerAssist(ListenerModelHandler<Listener1Model> listenerModelHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listenerModelHandler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.modelHandler = listenerModelHandler;
    }
}
