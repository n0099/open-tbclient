package com.baidu.searchbox.player.kernel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
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
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.interfaces.IDnsProcessListener;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.kernel.BaseDumediaVideoKernel;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.view.RoundOutlineProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class CyberVideoKernel extends BaseDumediaVideoKernel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IKernelGestureDetector mGestureDetector;
    public final CyberVideoView mVideoView;

    public CyberVideoKernel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVideoView = new CyberVideoView(this, BDPlayerConfig.getAppContext(), 1) { // from class: com.baidu.searchbox.player.kernel.CyberVideoKernel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CyberVideoKernel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext2.callArgs;
                        super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouchEvent(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) {
                    if (this.this$0.mGestureDetector != null) {
                        return this.this$0.mGestureDetector.onTouchEvent(motionEvent);
                    }
                    return super.onTouchEvent(motionEvent);
                }
                return invokeL.booleanValue;
            }
        };
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public View getBVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mVideoView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getBufferingPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBufferingPosition;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mVideoView.getDecodeMode();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mVideoView.getDuration() / 1000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mVideoView.getDuration();
        }
        return invokeV.intValue;
    }

    @Nullable
    public IKernelGestureDetector getGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mGestureDetector;
        }
        return (IKernelGestureDetector) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (int) this.mVideoView.getPlayedTime();
        }
        return invokeV.intValue;
    }

    @Nullable
    public TextureView getRenderView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mVideoView.getRenderView() instanceof TextureView) {
                return (TextureView) this.mVideoView.getRenderView();
            }
            return null;
        }
        return (TextureView) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getSyncPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mVideoView.getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mVideoView.getVideoHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mVideoView.getVideoWidth();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onRelease();
            this.mVideoView.stopPlayback();
            setKernelCallBack(null);
            setGestureDetector(null);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDataSourceAndPrepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.mVideoView.setVideoURI(getVideoUri(), this.mHeader);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.start();
            this.mVideoView.start();
            if (matchStatus(PlayerStatus.COMPLETE)) {
                notifyStatusChange(PlayerStatus.PLAYING);
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.stop();
            this.mVideoView.stopPlayback();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.stopPlayback();
            this.mVideoView.stopPlayback();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mVideoView.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setClarityInfo(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mVideoView.setClarityInfo(str);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDecodeMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.mVideoView.setDecodeMode(i);
        }
    }

    public void setGestureDetector(@Nullable IKernelGestureDetector iKernelGestureDetector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, iKernelGestureDetector) == null) {
            this.mGestureDetector = iKernelGestureDetector;
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setHttpDns(@NonNull IDnsProcessListener iDnsProcessListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iDnsProcessListener) == null) {
            super.setHttpDns(iDnsProcessListener);
            this.mVideoView.setHttpDns(new BaseDumediaVideoKernel.CyberPlayerHttpDNS(iDnsProcessListener));
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.mVideoView.setLooping(z);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setPlayConf(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.mVideoView.setPlayJson(str);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048606, this, f) == null) && Build.VERSION.SDK_INT >= 21) {
            this.mVideoView.setOutlineProvider(new RoundOutlineProvider(f));
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setRemote(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            super.setRemote(z);
            this.mVideoView.setRemote(z);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setSpeed(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048608, this, f) == null) {
            this.mVideoView.setSpeed(f);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoRotation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.mVideoView.setVideoRotation(i);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.mVideoView.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void switchMediaSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.mVideoView.switchMediaSource(i);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void updateFreeProxy(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.mVideoView.changeProxyDynamic(str);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            return AbsVideoKernel.CYBER_PLAYER.equals(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (matchStatus(PlayerStatus.IDLE)) {
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
    public int getPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (getStatus() == PlayerStatus.IDLE && getDuration() - this.mVideoView.getCurrentPosition() <= 2) {
                return getDurationMs();
            }
            return this.mVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
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
            this.mVideoView.setBackgroundColor(-16777216);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.pause();
            if (matchStatus(PlayerStatus.PLAYING, PlayerStatus.PREPARED, PlayerStatus.PREPARING)) {
                notifyStatusChange(PlayerStatus.PAUSE);
                this.mVideoView.pause();
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.resume();
            if (matchStatus(PlayerStatus.PREPARED, PlayerStatus.PREPARING, PlayerStatus.PAUSE, PlayerStatus.COMPLETE)) {
                notifyStatusChange(PlayerStatus.PLAYING);
                this.mVideoView.start();
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void play(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            super.play(str);
            BdVideoLog.d("player(), url = " + str);
            if (!AbsVideoKernel.PRELOAD_PREFIX.equals(str)) {
                start();
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setProxy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.mVideoView.setOption(CyberPlayerManager.OPT_HTTP_PROXY, str);
                this.mVideoView.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
                return;
            }
            this.mVideoView.setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
            this.mVideoView.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.BaseDumediaVideoKernel
    public void setVideoViewCallBack(DumediaInfoConverter dumediaInfoConverter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, dumediaInfoConverter) == null) {
            this.mVideoView.setOnCompletionListener(dumediaInfoConverter);
            this.mVideoView.setOnErrorListener(dumediaInfoConverter);
            this.mVideoView.setOnInfoListener(dumediaInfoConverter);
            this.mVideoView.setOnSeekCompleteListener(dumediaInfoConverter);
            this.mVideoView.setOnPreparedListener(dumediaInfoConverter);
            this.mVideoView.setOnBufferingUpdateListener(dumediaInfoConverter);
            this.mVideoView.setOnVideoSizeChangedListener(dumediaInfoConverter);
            this.mVideoView.setOnMediaSourceChangedListener(dumediaInfoConverter);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void seekToMs(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            this.mVideoView.seekTo(i, i2);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setExternalInfo(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, obj) == null) {
            this.mVideoView.setExternalInfo(str, obj);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, str, str2) == null) {
            this.mVideoView.setOption(str, str2);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public boolean takeSnapshotAsync(OnSnapShotFrameListener onSnapShotFrameListener, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048617, this, onSnapShotFrameListener, f)) == null) {
            if (onSnapShotFrameListener == null) {
                return false;
            }
            return this.mVideoView.takeSnapshotAsync(new ICyberVideoView.OnSnapShotCompleteListener(this, onSnapShotFrameListener) { // from class: com.baidu.searchbox.player.kernel.CyberVideoKernel.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CyberVideoKernel this$0;
                public final /* synthetic */ OnSnapShotFrameListener val$l;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onSnapShotFrameListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$l = onSnapShotFrameListener;
                }

                @Override // com.baidu.cyberplayer.sdk.ICyberVideoView.OnSnapShotCompleteListener
                public void onSnapShotComplete(Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bitmap) == null) {
                        this.val$l.onSnapShotComplete(bitmap);
                    }
                }
            }, f, 0, 0);
        }
        return invokeLF.booleanValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, hashMap) == null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                this.mVideoView.setOption(entry.getKey(), entry.getValue());
            }
        }
    }
}
