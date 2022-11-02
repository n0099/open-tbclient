package com.baidu.searchbox.player.callback;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class InternalKernelCallback extends SimpleDuMediaCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PlayerEventTrigger mTrigger;

    public InternalKernelCallback(@NonNull IMessenger iMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMessenger};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        PlayerEventTrigger playerEventTrigger = new PlayerEventTrigger();
        this.mTrigger = playerEventTrigger;
        playerEventTrigger.setMessenger(iMessenger);
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onBufferingUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.mTrigger.onBufferingUpdate(i);
        }
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mTrigger.onCompletion();
        }
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mTrigger.onPrepared();
        }
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mTrigger.onSeekComplete();
        }
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onError(int i, int i2, @Nullable Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
            this.mTrigger.onError(i, i2, obj);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onInfo(int i, int i2, @Nullable Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i, i2, obj)) == null) {
            this.mTrigger.onInfo(i, i2, obj);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i, i2, obj)) == null) {
            this.mTrigger.onMediaSourceChanged(i, i2, obj);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) {
            this.mTrigger.onVideoSizeChanged(i, i2, i3, i4);
        }
    }
}
