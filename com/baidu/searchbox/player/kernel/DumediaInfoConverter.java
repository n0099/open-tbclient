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
/* loaded from: classes11.dex */
public class DumediaInfoConverter implements CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnVideoSizeChangedListener, CyberPlayerManager.OnMediaSourceChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AbsVideoKernel mKernel;
    public IKernelPlayer mPlayerCallback;

    public DumediaInfoConverter(@NonNull AbsVideoKernel absVideoKernel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoKernel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mKernel = absVideoKernel;
    }

    private void processInternalAction(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65537, this, i2, obj) == null) && i2 == 11008) {
            this.mKernel.setKernelLogId(String.valueOf(obj));
        }
    }

    private int transformInfoWhat(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            if (i2 != 701) {
                if (i2 != 702) {
                    if (i2 != 904) {
                        if (i2 != 910) {
                            if (i2 != 924) {
                                if (i2 != 946) {
                                    if (i2 != 5000) {
                                        if (i2 != 10009) {
                                            if (i2 != 10103) {
                                                if (i2 != 11008) {
                                                    if (i2 != 936) {
                                                        if (i2 != 937) {
                                                            if (i2 != 955) {
                                                                if (i2 != 956) {
                                                                    if (i2 != 11004) {
                                                                        if (i2 != 11005) {
                                                                            if (i2 != 12005) {
                                                                                if (i2 != 12006) {
                                                                                    return i2;
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

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        IKernelPlayer iKernelPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (iKernelPlayer = this.mPlayerCallback) == null) {
            return;
        }
        iKernelPlayer.onBufferingUpdate(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        IKernelPlayer iKernelPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iKernelPlayer = this.mPlayerCallback) == null) {
            return;
        }
        iKernelPlayer.onCompletion();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
            IKernelPlayer iKernelPlayer = this.mPlayerCallback;
            if (iKernelPlayer != null) {
                return iKernelPlayer.onError(i2, i3, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i2, i3, obj)) == null) {
            if (this.mPlayerCallback != null) {
                processInternalAction(i2, obj);
                return this.mPlayerCallback.onInfo(transformInfoWhat(i2), i3, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i2, i3, obj)) == null) {
            IKernelPlayer iKernelPlayer = this.mPlayerCallback;
            if (iKernelPlayer != null) {
                return iKernelPlayer.onMediaSourceChanged(i2, i3, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        IKernelPlayer iKernelPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (iKernelPlayer = this.mPlayerCallback) == null) {
            return;
        }
        iKernelPlayer.onPrepared();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        IKernelPlayer iKernelPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (iKernelPlayer = this.mPlayerCallback) == null) {
            return;
        }
        iKernelPlayer.onSeekComplete();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        IKernelPlayer iKernelPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) || (iKernelPlayer = this.mPlayerCallback) == null) {
            return;
        }
        iKernelPlayer.onVideoSizeChanged(i2, i3, i4, i5);
    }

    public void setPlayerCallback(@Nullable IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iKernelPlayer) == null) {
            this.mPlayerCallback = iKernelPlayer;
        }
    }
}
