package com.baidu.searchbox.bddownload.core.listener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class DownloadSpeedListener extends DownloadBlockProgressListener implements ListenerSpeedAssistExtend.Listener4SpeedCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.bddownload.core.listener.DownloadSpeedListener$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Listener4WithSpeedModelCreator implements ListenerModelHandler.ModelCreator<ListenerSpeedAssistExtend.Listener4SpeedModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Listener4WithSpeedModelCreator() {
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

        public /* synthetic */ Listener4WithSpeedModelCreator(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerModelHandler.ModelCreator
        public ListenerSpeedAssistExtend.Listener4SpeedModel create(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new ListenerSpeedAssistExtend.Listener4SpeedModel(i2) : (ListenerSpeedAssistExtend.Listener4SpeedModel) invokeI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadSpeedListener(ListenerSpeedAssistExtend listenerSpeedAssistExtend) {
        super(new DownloadBlockProgressListenerAssist(new Listener4WithSpeedModelCreator(null)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listenerSpeedAssistExtend};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((DownloadBlockProgressListenerAssist) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        listenerSpeedAssistExtend.setCallback(this);
        setAssistExtend(listenerSpeedAssistExtend);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Callback
    public final void blockEnd(DownloadTask downloadTask, int i2, BlockInfo blockInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadTask, i2, blockInfo) == null) {
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Callback
    public final void infoReady(DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadTask, breakpointInfo, Boolean.valueOf(z), listener4Model}) == null) {
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Callback
    public final void progress(DownloadTask downloadTask, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, downloadTask, j) == null) {
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Callback
    public final void progressBlock(DownloadTask downloadTask, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.DownloadBlockProgressListenerAssist.Listener4Callback
    public final void taskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc, @NonNull DownloadBlockProgressListenerAssist.Listener4Model listener4Model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, downloadTask, endCause, exc, listener4Model) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadSpeedListener() {
        this(new ListenerSpeedAssistExtend());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((ListenerSpeedAssistExtend) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
