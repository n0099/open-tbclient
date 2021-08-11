package com.baidu.searchbox.player.kernel;

import android.net.Uri;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CyberVideoKernel extends AbsVideoKernel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CyberVideoKernel";
    public transient /* synthetic */ FieldHolder $fh;
    public CyberVideoView mVideoView;

    public CyberVideoKernel() {
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
        this.mVideoView = new CyberVideoView(BDPlayerConfig.getAppContext(), 1);
    }

    private void prepareInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mPreparingUrl = this.mVideoUrl;
            this.mKernelStatus.stateChangeNotify(PlayerStatus.PREPARING);
            this.mVideoView.setVideoURI(Uri.parse(this.mVideoUrl), this.mHeader);
        }
    }

    private void setVideoViewCallBack(IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, iKernelPlayer) == null) {
            this.mVideoView.setOnCompletionListener(iKernelPlayer);
            this.mVideoView.setOnErrorListener(iKernelPlayer);
            this.mVideoView.setOnInfoListener(iKernelPlayer);
            this.mVideoView.setOnSeekCompleteListener(iKernelPlayer);
            this.mVideoView.setOnPreparedListener(iKernelPlayer);
            this.mVideoView.setOnBufferingUpdateListener(iKernelPlayer);
            this.mVideoView.setOnVideoSizeChangedListener(iKernelPlayer);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void changePlayUrl(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.mStorePosition == -1) {
                this.mStorePosition = this.mVideoView.getCurrentPosition();
            }
            this.mVideoUrl = str;
            prepareInternal();
            start();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    @PublicMethod
    public View getBVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mVideoView : (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getBufferingPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBufferingPosition : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVideoView.getDuration() / 1000 : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVideoView.getDuration() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (int) this.mVideoView.getPlayedTime() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mKernelStatus.isIdle()) {
                int duration = getDuration() / 1000;
                if (duration - (this.mVideoView.getCurrentPosition() / 1000) <= 2) {
                    return duration;
                }
            }
            return this.mVideoView.getCurrentPosition() / 1000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mKernelStatus.isIdle() && getDuration() - this.mVideoView.getCurrentPosition() <= 2) {
                return getDurationMs();
            }
            return this.mVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Nullable
    @PublicMethod(version = "11.24.0.0")
    public TextureView getRenderView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mVideoView.getRenderView() instanceof TextureView) {
                return (TextureView) this.mVideoView.getRenderView();
            }
            return null;
        }
        return (TextureView) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getSyncPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mVideoView.getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mVideoView.getVideoHeight() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mVideoView.getVideoWidth() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mVideoView.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mPreparingUrl = null;
            super.onError();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onInit();
            this.mVideoView.reset();
            this.mVideoView.setVideoScalingMode(2);
            this.mVideoView.setSpeed(1.0f);
            this.mVideoView.setVideoRotation(0);
            this.mVideoView.setVisibility(0);
            this.mVideoView.setAlpha(1.0f);
            setRemote(true);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPrepared();
            int i2 = this.mStorePosition;
            if (i2 > 2) {
                this.mVideoView.seekTo(i2 - 2);
                this.mStorePosition = -1;
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onRelease();
            this.mVideoView.stopPlayback();
            setVideoViewCallBack(null);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.pause();
            if (this.mKernelStatus.isPlaying() || this.mKernelStatus.isPrepared() || this.mKernelStatus.isPreparing()) {
                this.mKernelStatus.stateChangeNotify(PlayerStatus.PAUSE);
                this.mVideoView.pause();
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void play(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            super.play(str);
            BdVideoLog.d("CyberVideoKernel", "video kernel play " + str);
            if (!AbsVideoKernel.PRELOAD_PREFIX.equals(this.mVideoUrl)) {
                start();
            }
            this.mStorePosition = -1;
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.prepare();
            this.mKernelStatus.stateChangeNotify(PlayerStatus.PREPARING);
            if (TextUtils.equals(this.mPreparingUrl, this.mVideoUrl)) {
                return;
            }
            prepareInternal();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.mKernelStatus.isPause() || this.mKernelStatus.isComplete()) {
                this.mKernelStatus.stateChangeNotify(PlayerStatus.PLAYING);
                this.mVideoView.start();
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.mVideoView.seekTo(i2 * 1000);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setDecodeMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.mVideoView.setDecodeMode(i2);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setExternalInfo(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, obj) == null) {
            this.mVideoView.setExternalInfo(str, obj);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setHttpDns(@NonNull CyberPlayerManager.HttpDNS httpDNS) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, httpDNS) == null) {
            super.setHttpDns(httpDNS);
            this.mVideoView.setHttpDns(httpDNS);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iKernelPlayer) == null) {
            super.setKernelCallBack(iKernelPlayer);
            setVideoViewCallBack(iKernelPlayer);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.mVideoView.setLooping(z);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, str, str2) == null) {
            this.mVideoView.setOption(str, str2);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setProxy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.mVideoView.setOption(CyberPlayerManager.OPT_HTTP_PROXY, str);
                this.mVideoView.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
                return;
            }
            this.mVideoView.setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
            this.mVideoView.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setRemote(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            super.setRemote(z);
            this.mVideoView.setRemote(z);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
            this.mVideoView.setSpeed(f2);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, str, hashMap) == null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                this.mVideoView.setOption(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.mVideoView.setVideoRotation(i2);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.mVideoView.setVideoScalingMode(i2);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            super.setVideoUrl(str);
            if (TextUtils.equals(this.mPreparingUrl, str)) {
                return;
            }
            prepareInternal();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.start();
            this.mVideoView.start();
            if (this.mKernelStatus.getStatus() == PlayerStatus.COMPLETE) {
                this.mKernelStatus.stateChangeNotify(PlayerStatus.PLAYING);
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.stop();
            this.mPercent = 0;
            this.mSpeed = 0;
            this.mPreparingUrl = null;
            this.mKernelStatus.stateChangeNotify(PlayerStatus.STOP);
            this.mVideoView.stopPlayback();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.stopPlayback();
            this.mVideoView.stopPlayback();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048614, this, onSnapShotCompleteListener, f2)) == null) ? this.mVideoView.takeSnapshotAsync(onSnapShotCompleteListener) : invokeLF.booleanValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void updateFreeProxy(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            if (str != null) {
                this.mVideoView.changeProxyDynamic(str);
            } else {
                this.mVideoView.changeProxyDynamic(null);
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) ? "CyberVideoKernel".equals(str) : invokeL.booleanValue;
    }
}
