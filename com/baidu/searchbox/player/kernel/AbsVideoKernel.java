package com.baidu.searchbox.player.kernel;

import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.helper.ViewOpUtils;
import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.searchbox.player.session.VideoKernelState;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class AbsVideoKernel implements IPoolItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CYBER_PLAYER = "CyberVideoKernel";
    public static final int DURATION_MIN_DIFF = 2;
    public static final String NORMAL_PLAYER = "NormalVideoKernel";
    public static final int POSITION_NONE = -1;
    public static final String PRELOAD_PREFIX = "videoplayer:preload";
    public static final String SURFACE_PLAYER = "SurfaceVideoKernel";
    public static final String TAG = "AbsVideoKernel";
    public static final String TEXTURE_PLAYER = "TextureVideoKernel";
    public transient /* synthetic */ FieldHolder $fh;
    public int mBufferingPosition;
    public HashMap<String, String> mHeader;
    public IKernelPlayer mKernelCallBack;
    public VideoKernelState mKernelStatus;
    public String mPageUrl;
    public int mPercent;
    public String mPreparingUrl;
    public String mRemoteServer;
    public int mSpeed;
    public int mStorePosition;
    public String mVideoUrl;

    public AbsVideoKernel() {
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
        this.mStorePosition = -1;
        this.mHeader = new HashMap<>();
    }

    public abstract void changePlayUrl(@NonNull String str);

    @Nullable
    public abstract View getBVideoView();

    public abstract int getBufferingPosition();

    public String getCyberNativeVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? CyberPlayerManager.getCoreVersion() : (String) invokeV.objValue;
    }

    public String getCyberSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? CyberPlayerManager.getSDKVersion() : (String) invokeV.objValue;
    }

    public abstract int getDuration();

    public abstract int getDurationMs();

    public VideoKernelState getKernelState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mKernelStatus : (VideoKernelState) invokeV.objValue;
    }

    public String getPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPageUrl : (String) invokeV.objValue;
    }

    public abstract int getPlayedTime();

    public abstract int getPosition();

    public abstract int getPositionMs();

    @Nullable
    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mRemoteServer : (String) invokeV.objValue;
    }

    public abstract int getSyncPositionMs();

    public abstract int getVideoHeight();

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mVideoUrl : (String) invokeV.objValue;
    }

    public abstract int getVideoWidth();

    public boolean inClarityChanging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mStorePosition != -1 : invokeV.booleanValue;
    }

    public abstract void mute(boolean z);

    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.mPercent = 0;
        }
    }

    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.mPercent = 0;
            this.mSpeed = 0;
            this.mPreparingUrl = null;
        }
    }

    public void onInfo(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048597, this, i2, i3, obj) == null) {
            if (701 == i2) {
                this.mPercent = 0;
            } else if (702 == i2) {
                this.mPercent = 100;
            } else if (946 == i2) {
                this.mBufferingPosition = i3;
            } else if (924 == i2) {
                this.mSpeed = i3;
            } else if (5000 == i2 && (obj instanceof String)) {
                this.mRemoteServer = (String) obj;
            }
        }
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            BdVideoLog.d("videoKernel onRelease");
            ViewOpUtils.removeView(getBVideoView());
            this.mKernelCallBack = null;
            this.mKernelStatus = null;
            this.mPreparingUrl = null;
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    public void play(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            BdVideoLog.d(TAG, "kernel play url:" + str);
            this.mVideoUrl = str;
            if (!TextUtils.equals(this.mPreparingUrl, str)) {
                this.mKernelStatus.stateChangeNotify(PlayerStatus.PREPARING);
                this.mPreparingUrl = null;
            }
            this.mPercent = 0;
        }
    }

    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public abstract void seekTo(int i2);

    public void seekToMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
        }
    }

    public abstract void setDecodeMode(int i2);

    public abstract void setExternalInfo(String str, Object obj);

    public void setHttpDns(@NonNull CyberPlayerManager.HttpDNS httpDNS) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, httpDNS) == null) {
        }
    }

    public void setHttpHeader(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, hashMap) == null) || hashMap == null) {
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            this.mHeader.put(entry.getKey(), entry.getValue());
        }
    }

    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, iKernelPlayer) == null) {
            this.mKernelCallBack = iKernelPlayer;
        }
    }

    public abstract void setLooping(boolean z);

    public abstract void setOption(String str, String str2);

    public void setPageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.mPageUrl = str;
        }
    }

    public abstract void setProxy(@Nullable String str);

    public void setRemote(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
        }
    }

    public abstract void setSpeed(float f2);

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, surface) == null) {
        }
    }

    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        BdVideoLog.d("UserAgent", "setUserAgent " + str);
        this.mHeader.put("User-Agent", str);
    }

    public abstract void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap);

    public abstract void setVideoRotation(int i2);

    public abstract void setVideoScalingMode(int i2);

    public void setVideoSession(@NonNull VideoSession videoSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, videoSession) == null) {
            this.mKernelStatus = videoSession.getState();
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.mVideoUrl = str;
            this.mRemoteServer = null;
        }
    }

    public void setZOrderMediaOverlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            BdVideoLog.d(TAG, "start " + this.mVideoUrl);
            if (TextUtils.isEmpty(this.mVideoUrl)) {
                this.mVideoUrl = "";
                return;
            }
            if (!this.mVideoUrl.equals(this.mPreparingUrl)) {
                this.mKernelStatus.stateChangeNotify(PlayerStatus.PREPARING);
            }
            this.mPercent = 0;
            this.mSpeed = 0;
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.mPreparingUrl = null;
        }
    }

    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.mPreparingUrl = null;
        }
    }

    public abstract boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2);

    public abstract void updateFreeProxy(@Nullable String str);

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}
