package com.baidu.searchbox.bddownload.core.listener.assist;

import android.util.SparseArray;
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
/* loaded from: classes2.dex */
public class ListenerSpeedAssistExtend implements DownloadBlockProgressListenerAssist.AssistExtend, ListenerModelHandler.ModelCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Listener4SpeedCallback callback;

    /* loaded from: classes2.dex */
    public interface Listener4SpeedCallback {
        void blockEnd(DownloadTask downloadTask, int i, BlockInfo blockInfo, SpeedCalculator speedCalculator);

        void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z, Listener4SpeedModel listener4SpeedModel);

        void progress(DownloadTask downloadTask, long j, SpeedCalculator speedCalculator);

        void progressBlock(DownloadTask downloadTask, int i, long j, SpeedCalculator speedCalculator);

        void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, SpeedCalculator speedCalculator);
    }

    /* loaded from: classes2.dex */
    public class Listener4SpeedModel extends DownloadBlockProgressListenerAssist.Listener4Model {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray blockSpeeds;
        public SpeedCalculator taskSpeed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Listener4SpeedModel(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Model, com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(BreakpointInfo breakpointInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, breakpointInfo) == null) {
                super.onInfoValid(breakpointInfo);
                this.taskSpeed = new SpeedCalculator();
                this.blockSpeeds = new SparseArray();
                int blockCount = breakpointInfo.getBlockCount();
                for (int i = 0; i < blockCount; i++) {
                    this.blockSpeeds.put(i, new SpeedCalculator());
                }
            }
        }

        public SpeedCalculator getBlockSpeed(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return (SpeedCalculator) this.blockSpeeds.get(i);
            }
            return (SpeedCalculator) invokeI.objValue;
        }

        public SpeedCalculator getTaskSpeed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.taskSpeed;
            }
            return (SpeedCalculator) invokeV.objValue;
        }
    }

    public ListenerSpeedAssistExtend() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void setCallback(Listener4SpeedCallback listener4SpeedCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, listener4SpeedCallback) == null) {
            this.callback = listener4SpeedCallback;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ModelCreator
    public Listener4SpeedModel create(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new Listener4SpeedModel(i);
        }
        return (Listener4SpeedModel) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.AssistExtend
    public boolean dispatchBlockEnd(DownloadTask downloadTask, int i, DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        InterceptResult invokeLIL;
        SpeedCalculator speedCalculator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i, listener4Model)) == null) {
            Listener4SpeedModel listener4SpeedModel = (Listener4SpeedModel) listener4Model;
            SparseArray sparseArray = listener4SpeedModel.blockSpeeds;
            if (sparseArray != null && (speedCalculator = (SpeedCalculator) sparseArray.get(i)) != null) {
                speedCalculator.endTask();
            }
            Listener4SpeedCallback listener4SpeedCallback = this.callback;
            if (listener4SpeedCallback != null) {
                listener4SpeedCallback.blockEnd(downloadTask, i, listener4Model.info.getBlock(i), listener4SpeedModel.getBlockSpeed(i));
                return true;
            }
            return true;
        }
        return invokeLIL.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.AssistExtend
    public boolean dispatchFetchProgress(DownloadTask downloadTask, int i, long j, DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        InterceptResult invokeCommon;
        SpeedCalculator speedCalculator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{downloadTask, Integer.valueOf(i), Long.valueOf(j), listener4Model})) == null) {
            Listener4SpeedModel listener4SpeedModel = (Listener4SpeedModel) listener4Model;
            SparseArray sparseArray = listener4SpeedModel.blockSpeeds;
            if (sparseArray != null && (speedCalculator = (SpeedCalculator) sparseArray.get(i)) != null) {
                speedCalculator.downloading(j);
            }
            SpeedCalculator speedCalculator2 = listener4SpeedModel.taskSpeed;
            if (speedCalculator2 != null) {
                speedCalculator2.downloading(j);
            }
            Listener4SpeedCallback listener4SpeedCallback = this.callback;
            if (listener4SpeedCallback != null) {
                listener4SpeedCallback.progressBlock(downloadTask, i, ((Long) listener4Model.blockCurrentOffsetMap.get(i)).longValue(), listener4SpeedModel.getBlockSpeed(i));
                this.callback.progress(downloadTask, listener4Model.currentOffset, listener4SpeedModel.taskSpeed);
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.AssistExtend
    public boolean dispatchInfoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z, DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
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
    public boolean dispatchTaskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
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
}
