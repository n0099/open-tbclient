package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.util.Map;
@Keep
/* loaded from: classes.dex */
public abstract class PlayerProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PlayerProvider() {
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

    public abstract void changeProxyDynamic(String str, boolean z);

    public abstract int getCurrentPosition();

    public abstract int getCurrentPositionSync();

    public abstract int getDecodeMode();

    public abstract long getDownloadSpeed();

    public abstract int getDuration();

    public abstract long getPlayedTime();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract boolean isLooping();

    public abstract boolean isPlaying();

    public abstract boolean isRemotePlayer();

    public abstract void muteOrUnmuteAudio(boolean z);

    public abstract void pause();

    public abstract void prepareAsync();

    public abstract void release();

    public abstract void reset();

    public abstract void seekTo(long j);

    public abstract void seekTo(long j, int i);

    public void sendCommand(int i, int i2, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str}) == null) {
        }
    }

    public void setClarityInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
        }
    }

    public abstract void setDataSource(Context context, Uri uri);

    public abstract void setDataSource(Context context, Uri uri, Map<String, String> map);

    public abstract void setDataSource(FileDescriptor fileDescriptor);

    public abstract void setDataSource(String str);

    public abstract void setDataSource(String str, Map<String, String> map);

    public abstract void setDisplay(SurfaceHolder surfaceHolder);

    public void setEnableDumediaUA(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
        }
    }

    public abstract void setLooping(boolean z);

    public abstract void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener);

    public abstract void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener);

    public abstract void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener);

    public abstract void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener);

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onMediaSourceChangedListener) == null) {
        }
    }

    public abstract void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener);

    public abstract void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener);

    public abstract void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener);

    public void setOption(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048613, this, str, j) == null) {
        }
    }

    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, str, str2) == null) {
        }
    }

    public void setPlayJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
        }
    }

    public abstract void setScreenOnWhilePlaying(boolean z);

    public abstract void setSpeed(float f);

    public abstract void setSurface(Surface surface);

    public abstract void setVolume(float f, float f2);

    public abstract void setWakeMode(Context context, int i);

    public abstract void start();

    public abstract void stop();

    public void switchMediaSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
        }
    }

    public void updateDisplaySize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048624, this, i, i2) == null) {
        }
    }
}
