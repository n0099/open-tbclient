package com.baidu.searchbox.player.layer;

import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.kernel.EmptyKernel;
import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.pool.VideoKernelPool;
import com.baidu.searchbox.player.session.VideoKernelState;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class BaseKernelLayer extends AbsLayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MIN_POSITION = 2;
    public static int SEEK_TO_DELTA = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAcceptVolumeChange;
    public AbsVideoKernel mVideoKernel;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1807601770, "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1807601770, "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;");
        }
    }

    public BaseKernelLayer(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mAcceptVolumeChange = true;
        this.mVideoKernel = VideoKernelPool.getInstance().obtain(str);
        initLayer();
    }

    private void requestAudioFocus() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || getBindPlayer().isPlayerMute()) {
            return;
        }
        getBindPlayer().requestAudioFocus();
    }

    @PublicMethod
    public void changePlayUrl(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.mVideoKernel.changePlayUrl(str);
        }
    }

    @PublicMethod
    public int getBufferingPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mVideoKernel.getBufferingPosition() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    @Nullable
    @PublicMethod
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mVideoKernel.getBVideoView() : (View) invokeV.objValue;
    }

    @PublicMethod
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVideoKernel.getDuration() : invokeV.intValue;
    }

    @PublicMethod
    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVideoKernel.getDurationMs() : invokeV.intValue;
    }

    @PublicMethod
    public VideoKernelState getKernelState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mVideoKernel.getKernelState() : (VideoKernelState) invokeV.objValue;
    }

    @PublicMethod
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mVideoKernel.getPosition() : invokeV.intValue;
    }

    @PublicMethod
    public int getPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mVideoKernel.getPositionMs() : invokeV.intValue;
    }

    @Nullable
    @PublicMethod
    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mVideoKernel.getServerIpInfo() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new int[]{4, 3, 1, 2} : (int[]) invokeV.objValue;
    }

    @PublicMethod
    public int getSyncPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mVideoKernel.getSyncPositionMs() : invokeV.intValue;
    }

    @PublicMethod
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mVideoKernel.getVideoHeight() : invokeV.intValue;
    }

    @PublicMethod
    public AbsVideoKernel getVideoKernel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mVideoKernel : (AbsVideoKernel) invokeV.objValue;
    }

    @PublicMethod
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mVideoKernel.getVideoUrl() : (String) invokeV.objValue;
    }

    @PublicMethod
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mVideoKernel.getVideoWidth() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void initLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.initLayer();
        }
    }

    @PublicMethod
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mVideoKernel.mute(z);
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, videoEvent) == null) && ControlEvent.ACTION_SEEK.equals(videoEvent.getAction())) {
            this.mVideoKernel.seekTo(((Integer) videoEvent.getExtra(5)).intValue());
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, videoEvent) == null) {
            if (LayerEvent.ACTION_CLICK_NET_TIP.equals(videoEvent.getAction())) {
                getBindPlayer().doPlay();
            } else if (LayerEvent.ACTION_SEEK.equals(videoEvent.getAction())) {
                seekTo(((Integer) videoEvent.getExtra(1)).intValue());
                requestAudioFocus();
                this.mVideoKernel.resume();
            } else if (!LayerEvent.ACTION_CHANGE_CLARITY.equals(videoEvent.getAction()) || (intValue = ((Integer) videoEvent.getExtra(19)).intValue()) <= 2) {
            } else {
                int i2 = intValue - 2;
                BdVideoLog.d("changePlayUrl seek :" + i2);
                this.mVideoKernel.seekTo(i2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, videoEvent) == null) {
            String action = videoEvent.getAction();
            switch (action.hashCode()) {
                case -525235558:
                    if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -461848373:
                    if (action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 154871702:
                    if (action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1370689931:
                    if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                this.mVideoKernel.onComplete();
            } else if (c2 == 1) {
                this.mVideoKernel.onPrepared();
            } else if (c2 == 2) {
                this.mVideoKernel.onError();
            } else if (c2 != 3) {
            } else {
                this.mVideoKernel.onInfo(((Integer) videoEvent.getExtra(1)).intValue(), ((Integer) videoEvent.getExtra(2)).intValue(), videoEvent.getExtra(3));
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, videoEvent) == null) && this.mAcceptVolumeChange && SystemEvent.ACTION_VOLUME_CHANGED.equals(videoEvent.getAction())) {
            mute(((Integer) videoEvent.getExtra(5)).intValue() <= 0);
        }
    }

    @PublicMethod
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.mVideoKernel.pause();
        }
    }

    @PublicMethod
    public void play(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mVideoKernel.play(str);
        }
    }

    @PublicMethod
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.mVideoKernel.prepare();
        }
    }

    @PublicMethod
    public void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (this.mVideoKernel instanceof EmptyKernel)) {
            return;
        }
        setKernelCallBack(null);
        AbsVideoKernel absVideoKernel = this.mVideoKernel;
        this.mVideoKernel = new EmptyKernel();
        VideoKernelPool.getInstance().recycle(absVideoKernel);
    }

    @PublicMethod
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.mVideoKernel.resume();
        }
    }

    @PublicMethod
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            int duration = this.mVideoKernel.getDuration();
            int i3 = SEEK_TO_DELTA;
            if (duration > i3 && i2 > duration - i3) {
                i2 = duration - i3;
            }
            this.mVideoKernel.seekTo(i2);
        }
    }

    @PublicMethod
    public void seekToMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            int durationMs = this.mVideoKernel.getDurationMs();
            int i3 = SEEK_TO_DELTA;
            if (durationMs > i3 && i2 > durationMs - i3) {
                i2 = durationMs - i3;
            }
            this.mVideoKernel.seekToMs(i2);
        }
    }

    @PublicMethod
    public void setAcceptVolumeChange(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bool) == null) {
            this.mAcceptVolumeChange = bool.booleanValue();
        }
    }

    @PublicMethod
    public void setDecodeMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.mVideoKernel.setDecodeMode(i2);
        }
    }

    @PublicMethod
    public void setExternalInfo(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, obj) == null) {
            this.mVideoKernel.setExternalInfo(str, obj);
        }
    }

    @PublicMethod
    public void setHttpHeader(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, hashMap) == null) {
            this.mVideoKernel.setHttpHeader(hashMap);
        }
    }

    @PublicMethod
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, iKernelPlayer) == null) {
            this.mVideoKernel.setKernelCallBack(iKernelPlayer);
        }
    }

    @PublicMethod
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.mVideoKernel.setLooping(z);
        }
    }

    @PublicMethod
    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, str2) == null) {
            this.mVideoKernel.setOption(str, str2);
        }
    }

    @PublicMethod
    public void setProxy(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.mVideoKernel.setProxy(str);
        }
    }

    @PublicMethod
    public void setRemote(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.mVideoKernel.setRemote(z);
        }
    }

    @PublicMethod
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f2) == null) {
            this.mVideoKernel.setSpeed(f2);
        }
    }

    @PublicMethod
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, surface) == null) {
            this.mVideoKernel.setSurface(surface);
        }
    }

    @PublicMethod
    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.mVideoKernel.setUserAgent(str);
        }
    }

    @PublicMethod
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, hashMap) == null) {
            this.mVideoKernel.setVideoFormatOptions(str, hashMap);
        }
    }

    @PublicMethod
    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.mVideoKernel.setVideoRotation(i2);
        }
    }

    @PublicMethod
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.mVideoKernel.setVideoScalingMode(i2);
        }
    }

    @PublicMethod
    public void setVideoSession(VideoSession videoSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, videoSession) == null) {
            this.mVideoKernel.setVideoSession(videoSession);
        }
    }

    @PublicMethod
    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.mVideoKernel.setVideoUrl(str);
        }
    }

    @PublicMethod
    public void setZOrderMediaOverlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.mVideoKernel.setZOrderMediaOverlay(z);
        }
    }

    @PublicMethod
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.mVideoKernel.stop();
        }
    }

    @PublicMethod
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.mVideoKernel.stopPlayback();
        }
    }

    @PublicMethod
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048624, this, onSnapShotCompleteListener, f2)) == null) ? this.mVideoKernel.takeSnapshotAsync(onSnapShotCompleteListener, f2) : invokeLF.booleanValue;
    }

    @PublicMethod
    public void updateFreeProxy(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.mVideoKernel.updateFreeProxy(str);
        }
    }

    public BaseKernelLayer(@NonNull AbsVideoKernel absVideoKernel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoKernel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAcceptVolumeChange = true;
        this.mVideoKernel = absVideoKernel;
        initLayer();
    }
}
