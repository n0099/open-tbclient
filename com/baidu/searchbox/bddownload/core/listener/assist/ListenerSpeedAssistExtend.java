package com.baidu.searchbox.bddownload.core.listener.assist;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.SpeedCalculator;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ListenerSpeedAssistExtend implements DownloadBlockProgressListenerAssist.AssistExtend, ListenerModelHandler.ModelCreator<Listener4SpeedModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Listener4SpeedCallback callback;

    /* loaded from: classes7.dex */
    public interface Listener4SpeedCallback {
        void blockEnd(@NonNull DownloadTask downloadTask, int i2, BlockInfo blockInfo, @NonNull SpeedCalculator speedCalculator);

        void infoReady(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull Listener4SpeedModel listener4SpeedModel);

        void progress(@NonNull DownloadTask downloadTask, long j, @NonNull SpeedCalculator speedCalculator);

        void progressBlock(@NonNull DownloadTask downloadTask, int i2, long j, @NonNull SpeedCalculator speedCalculator);

        void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, @NonNull SpeedCalculator speedCalculator);
    }

    /* loaded from: classes7.dex */
    public static class Listener4SpeedModel extends DownloadBlockProgressListenerAssist.Listener4Model {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<SpeedCalculator> blockSpeeds;
        public SpeedCalculator taskSpeed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Listener4SpeedModel(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public SpeedCalculator getBlockSpeed(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.blockSpeeds.get(i2) : (SpeedCalculator) invokeI.objValue;
        }

        public SpeedCalculator getTaskSpeed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.taskSpeed : (SpeedCalculator) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Model, com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(@NonNull BreakpointInfo breakpointInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, breakpointInfo) == null) {
                super.onInfoValid(breakpointInfo);
                this.taskSpeed = new SpeedCalculator();
                this.blockSpeeds = new SparseArray<>();
                int blockCount = breakpointInfo.getBlockCount();
                for (int i2 = 0; i2 < blockCount; i2++) {
                    this.blockSpeeds.put(i2, new SpeedCalculator());
                }
            }
        }
    }

    public ListenerSpeedAssistExtend() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.AssistExtend
    public boolean dispatchBlockEnd(DownloadTask downloadTask, int i2, DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i2, listener4Model)) == null) {
            Listener4SpeedModel listener4SpeedModel = (Listener4SpeedModel) listener4Model;
            listener4SpeedModel.blockSpeeds.get(i2).endTask();
            Listener4SpeedCallback listener4SpeedCallback = this.callback;
            if (listener4SpeedCallback != null) {
                listener4SpeedCallback.blockEnd(downloadTask, i2, listener4Model.info.getBlock(i2), listener4SpeedModel.getBlockSpeed(i2));
                return true;
            }
            return true;
        }
        return invokeLIL.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.AssistExtend
    public boolean dispatchFetchProgress(@NonNull DownloadTask downloadTask, int i2, long j, @NonNull DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j), listener4Model})) == null) {
            Listener4SpeedModel listener4SpeedModel = (Listener4SpeedModel) listener4Model;
            listener4SpeedModel.blockSpeeds.get(i2).downloading(j);
            listener4SpeedModel.taskSpeed.downloading(j);
            Listener4SpeedCallback listener4SpeedCallback = this.callback;
            if (listener4SpeedCallback != null) {
                listener4SpeedCallback.progressBlock(downloadTask, i2, listener4Model.blockCurrentOffsetMap.get(i2).longValue(), listener4SpeedModel.getBlockSpeed(i2));
                this.callback.progress(downloadTask, listener4Model.currentOffset, listener4SpeedModel.taskSpeed);
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.AssistExtend
    public boolean dispatchInfoReady(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{downloadTask, breakpointInfo, Boolean.valueOf(z), listener4Model})) == null) {
            Listener4SpeedCallback listener4SpeedCallback = this.callback;
            if (listener4SpeedCallback != null) {
                listener4SpeedCallback.infoReady(downloadTask, breakpointInfo, z, (Listener4SpeedModel) listener4Model);
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.AssistExtend
    public boolean dispatchTaskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc, @NonNull DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, downloadTask, endCause, exc, listener4Model)) == null) {
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
        return invokeLLLL.booleanValue;
    }

    public void setCallback(Listener4SpeedCallback listener4SpeedCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, listener4SpeedCallback) == null) {
            this.callback = listener4SpeedCallback;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ModelCreator
    public Listener4SpeedModel create(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new Listener4SpeedModel(i2) : (Listener4SpeedModel) invokeI.objValue;
    }
}
