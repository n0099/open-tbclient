package com.baidu.searchbox.player.kernel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DumediaInfoConverter implements CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnVideoSizeChangedListener, CyberPlayerManager.OnMediaSourceChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AbsVideoKernel mKernel;
    public IKernelPlayer mPlayerCallback;

    private int transformInfoWhat(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            if (i != 701) {
                if (i != 702) {
                    if (i != 904) {
                        if (i != 910) {
                            if (i != 924) {
                                if (i != 946) {
                                    if (i != 5000) {
                                        if (i != 10009) {
                                            if (i != 10103) {
                                                if (i != 11008) {
                                                    if (i != 936) {
                                                        if (i != 937) {
                                                            if (i != 955) {
                                                                if (i != 956) {
                                                                    if (i != 11004) {
                                                                        if (i != 11005) {
                                                                            if (i != 12005) {
                                                                                if (i != 12006) {
                                                                                    return i;
                                                                                }
                                                                                return 12006;
                                                                            }
                                                                            return 12005;
                                                                        }
                                                                        return 11005;
                                                                    }
                                                                    return 11004;
                                                                }
                                                                return 956;
                                                            }
                                                            return 955;
                                                        }
                                                        return 937;
                                                    }
                                                    return 936;
                                                }
                                                return 11008;
                                            }
                                            return 10103;
                                        }
                                        return 10009;
                                    }
                                    return 5000;
                                }
                                return 946;
                            }
                            return 924;
                        }
                        return 910;
                    }
                    return 904;
                }
                return 702;
            }
            return 701;
        }
        return invokeI.intValue;
    }

    public DumediaInfoConverter(@NonNull AbsVideoKernel absVideoKernel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoKernel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mKernel = absVideoKernel;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        IKernelPlayer iKernelPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (iKernelPlayer = this.mPlayerCallback) != null) {
            iKernelPlayer.onBufferingUpdate(i);
        }
    }

    public void setPlayerCallback(@Nullable IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iKernelPlayer) == null) {
            this.mPlayerCallback = iKernelPlayer;
        }
    }

    private void processInternalAction(int i, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65537, this, i, obj) == null) && i == 11008) {
            this.mKernel.setKernelLogId(String.valueOf(obj));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        IKernelPlayer iKernelPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (iKernelPlayer = this.mPlayerCallback) != null) {
            iKernelPlayer.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        IKernelPlayer iKernelPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (iKernelPlayer = this.mPlayerCallback) != null) {
            iKernelPlayer.onPrepared();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        IKernelPlayer iKernelPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (iKernelPlayer = this.mPlayerCallback) != null) {
            iKernelPlayer.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
            IKernelPlayer iKernelPlayer = this.mPlayerCallback;
            if (iKernelPlayer != null) {
                return iKernelPlayer.onError(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i, i2, obj)) == null) {
            if (this.mPlayerCallback != null) {
                processInternalAction(i, obj);
                return this.mPlayerCallback.onInfo(transformInfoWhat(i), i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i, i2, obj)) == null) {
            IKernelPlayer iKernelPlayer = this.mPlayerCallback;
            if (iKernelPlayer != null) {
                return iKernelPlayer.onMediaSourceChanged(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        IKernelPlayer iKernelPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) && (iKernelPlayer = this.mPlayerCallback) != null) {
            iKernelPlayer.onVideoSizeChanged(i, i2, i3, i4);
        }
    }
}
