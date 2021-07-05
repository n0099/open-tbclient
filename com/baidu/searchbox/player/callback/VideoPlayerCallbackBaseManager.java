package com.baidu.searchbox.player.callback;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ILayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class VideoPlayerCallbackBaseManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ILayerActionCallback mLayerActionCallback;
    public IVideoPlayerCallback mVideoPlayerCallback;

    public VideoPlayerCallbackBaseManager() {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
        if (r0.equals(com.baidu.searchbox.player.event.PlayerEvent.ACTION_SEEK_COMPLETE) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchPlayerAction(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoEvent) == null) {
            char c2 = 4;
            if (videoEvent.getType() == 4 || videoEvent.getType() == 2) {
                String action = videoEvent.getAction();
                switch (action.hashCode()) {
                    case -1502879971:
                        if (action.equals(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED)) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1244137507:
                        break;
                    case -525235558:
                        if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -461848373:
                        if (action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 154871702:
                        if (action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 720027695:
                        if (action.equals(ControlEvent.ACTION_PAUSE)) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 723345051:
                        if (action.equals(ControlEvent.ACTION_START)) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 906917140:
                        if (action.equals(ControlEvent.ACTION_RESUME)) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1370689931:
                        if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1547354793:
                        if (action.equals(ControlEvent.ACTION_STOP)) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        onInfo(((Integer) videoEvent.getExtra(1)).intValue(), ((Integer) videoEvent.getExtra(2)).intValue(), videoEvent.getExtra(3));
                        return;
                    case 1:
                        onError(((Integer) videoEvent.getExtra(1)).intValue(), ((Integer) videoEvent.getExtra(2)).intValue(), videoEvent.getExtra(3));
                        return;
                    case 2:
                        onPrepared();
                        return;
                    case 3:
                        onEnd(307);
                        return;
                    case 4:
                        onSeekEnd();
                        return;
                    case 5:
                        onVideoSizeChanged(((Integer) videoEvent.getExtra(5)).intValue(), ((Integer) videoEvent.getExtra(6)).intValue());
                        return;
                    case 6:
                        onStart();
                        return;
                    case 7:
                        onResume();
                        return;
                    case '\b':
                        onPause();
                        return;
                    case '\t':
                        onEnd(0);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @PublicMethod
    public IVideoPlayerCallback getVideoPlayerCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mVideoPlayerCallback : (IVideoPlayerCallback) invokeV.objValue;
    }

    public void onBufferEnd() {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onBufferEnd();
    }

    public void onBufferStart() {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onBufferStart();
    }

    public void onEnd(int i2) {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onEnd(i2);
    }

    public void onError(int i2, int i3, Object obj) {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, obj) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onError(i2, i3, obj != null ? obj.toString() : "");
    }

    public void onGoBackOrForeground(boolean z) {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.goBackOrForeground(z);
    }

    public void onInfo(int i2, int i3, Object obj) {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, obj) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onInfo(i2, i3);
    }

    public void onLayerDismiss(ILayer iLayer) {
        ILayerActionCallback iLayerActionCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iLayer) == null) || (iLayerActionCallback = this.mLayerActionCallback) == null) {
            return;
        }
        iLayerActionCallback.onLayerDismiss(iLayer);
    }

    public void onLayerShow(ILayer iLayer) {
        ILayerActionCallback iLayerActionCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, iLayer) == null) || (iLayerActionCallback = this.mLayerActionCallback) == null) {
            return;
        }
        iLayerActionCallback.onLayerShow(iLayer);
    }

    public void onNetworkSpeedUpdate(int i2) {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onNetworkSpeedUpdate(i2);
    }

    public void onPause() {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onPause();
    }

    public void onPrepared() {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onPrepared();
    }

    public void onResume() {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onResume();
    }

    public void onSeekEnd() {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onSeekEnd();
    }

    public void onStart() {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onStart();
    }

    public void onUpdateProgress(int i2, int i3, int i4) {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048592, this, i2, i3, i4) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onUpdateProgress(i2, i3, i4);
    }

    public void onVideoSizeChanged(int i2, int i3) {
        IVideoPlayerCallback iVideoPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) || (iVideoPlayerCallback = this.mVideoPlayerCallback) == null) {
            return;
        }
        iVideoPlayerCallback.onVideoSizeChanged(i2, i3);
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.mVideoPlayerCallback = null;
            this.mLayerActionCallback = null;
        }
    }

    public void setLayerActionCallback(ILayerActionCallback iLayerActionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, iLayerActionCallback) == null) {
            this.mLayerActionCallback = iLayerActionCallback;
        }
    }

    @PublicMethod
    public void setVideoPlayerCallback(IVideoPlayerCallback iVideoPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, iVideoPlayerCallback) == null) {
            this.mVideoPlayerCallback = iVideoPlayerCallback;
        }
    }
}
