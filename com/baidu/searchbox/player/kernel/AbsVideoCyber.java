package com.baidu.searchbox.player.kernel;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public abstract class AbsVideoCyber extends AbsVideoKernel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CyberPlayer mPlayer;

    public AbsVideoCyber() {
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
        initPlayer();
    }

    private void setCyberPlayerCallBack(IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, iKernelPlayer) == null) {
            this.mPlayer.setOnCompletionListener(iKernelPlayer);
            this.mPlayer.setOnErrorListener(iKernelPlayer);
            this.mPlayer.setOnInfoListener(iKernelPlayer);
            this.mPlayer.setOnSeekCompleteListener(iKernelPlayer);
            this.mPlayer.setOnPreparedListener(iKernelPlayer);
            this.mPlayer.setOnBufferingUpdateListener(iKernelPlayer);
            this.mPlayer.setOnVideoSizeChangedListener(iKernelPlayer);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getBufferingPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBufferingPosition : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPlayer.getDuration() / 1000 : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPlayer.getDuration() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) this.mPlayer.getPlayedTime() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mKernelStatus.isIdle() && getDurationMs() - this.mPlayer.getCurrentPosition() <= 2) {
                return getDuration();
            }
            return this.mPlayer.getCurrentPosition() / 1000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mKernelStatus.isIdle() && getDuration() - this.mPlayer.getCurrentPosition() <= 2) {
                return getDurationMs();
            }
            CyberPlayer cyberPlayer = this.mPlayer;
            if (cyberPlayer != null) {
                return cyberPlayer.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getSyncPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            CyberPlayer cyberPlayer = this.mPlayer;
            if (cyberPlayer != null) {
                return cyberPlayer.getCurrentPositionSync();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void initPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            CyberPlayer cyberPlayer = this.mPlayer;
            if (cyberPlayer == null) {
                this.mPlayer = new CyberPlayer(1);
            } else {
                cyberPlayer.reset();
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mPlayer.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onRelease();
            stop();
            setCyberPlayerCallBack(null);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.mKernelStatus.isPrepared()) {
            this.mKernelStatus.stateChangeNotify(PlayerStatus.PAUSE);
            this.mPlayer.pause();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.prepare();
            this.mKernelStatus.stateChangeNotify(PlayerStatus.PREPARING);
            this.mPlayer.setDataSource(BDPlayerConfig.getAppContext(), Uri.parse(this.mVideoUrl), this.mHeader);
            this.mPlayer.prepareAsync();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.resume();
            if (this.mKernelStatus.isPrepared()) {
                this.mKernelStatus.stateChangeNotify(PlayerStatus.PLAYING);
                this.mPlayer.start();
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mPlayer.seekTo(i2);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDecodeMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setExternalInfo(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, obj) == null) {
            this.mPlayer.setExternalInfo(str, obj);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setHttpDns(@NonNull CyberPlayerManager.HttpDNS httpDNS) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, httpDNS) == null) {
            super.setHttpDns(httpDNS);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iKernelPlayer) == null) {
            super.setKernelCallBack(iKernelPlayer);
            setCyberPlayerCallBack(iKernelPlayer);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) {
            this.mPlayer.setOption(str, str2);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setProxy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.mPlayer.setOption(CyberPlayerManager.OPT_HTTP_PROXY, str);
                this.mPlayer.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
                return;
            }
            this.mPlayer.setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
            this.mPlayer.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, hashMap) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.start();
            this.mKernelStatus.stateChangeNotify(PlayerStatus.PLAYING);
            this.mPlayer.start();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.stop();
            this.mPercent = 0;
            this.mSpeed = 0;
            this.mKernelStatus.stateChangeNotify(PlayerStatus.STOP);
            this.mPlayer.stop();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048602, this, onSnapShotCompleteListener, f2)) == null) {
            return false;
        }
        return invokeLF.booleanValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void updateFreeProxy(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            if (str != null) {
                this.mPlayer.changeProxyDynamic(str, true);
            } else {
                this.mPlayer.changeProxyDynamic(null, false);
            }
        }
    }
}
