package com.baidu.searchbox.bddownload.core.listener.assist;

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
/* loaded from: classes2.dex */
public class TaskProgressListenerAssist implements ListenerAssist, ListenerModelHandler.ModelCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TaskProgressListenerCallback callback;
    public final ListenerModelHandler modelHandler;

    /* loaded from: classes2.dex */
    public interface TaskProgressListenerCallback {
        void connected(DownloadTask downloadTask, int i, long j, long j2);

        void progress(DownloadTask downloadTask, long j, long j2);

        void retry(DownloadTask downloadTask, ResumeFailedCause resumeFailedCause);

        void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener1Model listener1Model);

        void taskStart(DownloadTask downloadTask, Listener1Model listener1Model);
    }

    /* loaded from: classes2.dex */
    public class Listener1Model implements ListenerModelHandler.ListenerModel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int blockCount;
        public final AtomicLong currentOffset;
        public final int id;
        public volatile Boolean isFirstConnect;
        public Boolean isFromResumed;
        public Boolean isStarted;
        public long totalLength;

        public Listener1Model(int i) {
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
            this.currentOffset = new AtomicLong();
            this.id = i;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.id;
            }
            return invokeV.intValue;
        }

        public long getTotalLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.totalLength;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(BreakpointInfo breakpointInfo) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, breakpointInfo) == null) {
                this.blockCount = breakpointInfo.getBlockCount();
                this.totalLength = breakpointInfo.getTotalLength();
                this.currentOffset.set(breakpointInfo.getTotalOffset());
                if (this.isStarted == null) {
                    this.isStarted = Boolean.FALSE;
                }
                if (this.isFromResumed == null) {
                    if (this.currentOffset.get() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.isFromResumed = Boolean.valueOf(z);
                }
                if (this.isFirstConnect == null) {
                    this.isFirstConnect = Boolean.TRUE;
                }
            }
        }
    }

    public TaskProgressListenerAssist() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.modelHandler = new ListenerModelHandler(this);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.modelHandler.isAlwaysRecoverAssistModel();
        }
        return invokeV.booleanValue;
    }

    public TaskProgressListenerAssist(ListenerModelHandler listenerModelHandler) {
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

    public void setCallback(TaskProgressListenerCallback taskProgressListenerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, taskProgressListenerCallback) == null) {
            this.callback = taskProgressListenerCallback;
        }
    }

    public void taskStart(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, downloadTask) == null) {
            Listener1Model listener1Model = (Listener1Model) this.modelHandler.addAndGetModel(downloadTask, null);
            TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
            if (taskProgressListenerCallback != null) {
                taskProgressListenerCallback.taskStart(downloadTask, listener1Model);
            }
        }
    }

    public void connectEnd(DownloadTask downloadTask) {
        Listener1Model listener1Model;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, downloadTask) != null) || (listener1Model = (Listener1Model) this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo())) == null) {
            return;
        }
        if (listener1Model.isFromResumed == null) {
            listener1Model.isFromResumed = Boolean.FALSE;
        }
        if (listener1Model.isFirstConnect == null) {
            listener1Model.isFirstConnect = Boolean.TRUE;
        }
        if (listener1Model.isFromResumed.booleanValue() && listener1Model.isFirstConnect.booleanValue()) {
            listener1Model.isFirstConnect = Boolean.FALSE;
        }
        TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
        if (taskProgressListenerCallback != null) {
            taskProgressListenerCallback.connected(downloadTask, listener1Model.blockCount, listener1Model.currentOffset.get(), listener1Model.totalLength);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ModelCreator
    public Listener1Model create(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return new Listener1Model(i);
        }
        return (Listener1Model) invokeI.objValue;
    }

    public void downloadFromBeginning(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause) {
        Listener1Model listener1Model;
        TaskProgressListenerCallback taskProgressListenerCallback;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048579, this, downloadTask, breakpointInfo, resumeFailedCause) != null) || (listener1Model = (Listener1Model) this.modelHandler.getOrRecoverModel(downloadTask, breakpointInfo)) == null) {
            return;
        }
        listener1Model.onInfoValid(breakpointInfo);
        if (listener1Model.isStarted.booleanValue() && (taskProgressListenerCallback = this.callback) != null) {
            taskProgressListenerCallback.retry(downloadTask, resumeFailedCause);
        }
        listener1Model.isStarted = Boolean.TRUE;
        listener1Model.isFromResumed = Boolean.FALSE;
        listener1Model.isFirstConnect = Boolean.TRUE;
    }

    public void downloadFromBreakpoint(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        Listener1Model listener1Model;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, downloadTask, breakpointInfo) != null) || (listener1Model = (Listener1Model) this.modelHandler.getOrRecoverModel(downloadTask, breakpointInfo)) == null) {
            return;
        }
        listener1Model.onInfoValid(breakpointInfo);
        Boolean bool = Boolean.TRUE;
        listener1Model.isStarted = bool;
        listener1Model.isFromResumed = bool;
        listener1Model.isFirstConnect = bool;
    }

    public void fetchProgress(DownloadTask downloadTask, long j) {
        Listener1Model listener1Model;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(1048581, this, downloadTask, j) != null) || (listener1Model = (Listener1Model) this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo())) == null) {
            return;
        }
        listener1Model.currentOffset.addAndGet(j);
        TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
        if (taskProgressListenerCallback != null) {
            taskProgressListenerCallback.progress(downloadTask, listener1Model.currentOffset.get(), listener1Model.totalLength);
        }
    }

    public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, downloadTask, endCause, exc) == null) {
            Listener1Model listener1Model = (Listener1Model) this.modelHandler.removeOrCreate(downloadTask, downloadTask.getInfo());
            TaskProgressListenerCallback taskProgressListenerCallback = this.callback;
            if (taskProgressListenerCallback != null) {
                taskProgressListenerCallback.taskEnd(downloadTask, endCause, exc, listener1Model);
            }
        }
    }
}
