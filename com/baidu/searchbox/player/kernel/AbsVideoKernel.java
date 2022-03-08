package com.baidu.searchbox.player.kernel;

import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.helper.ViewOpUtils;
import com.baidu.searchbox.player.interfaces.IDnsProcessListener;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class AbsVideoKernel implements IPoolItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CYBER_PLAYER = "CyberVideoKernel";
    public static final int DURATION_MIN_DIFF = 2;
    public static final String NORMAL_PLAYER = "NormalVideoKernel";
    public static final String PRELOAD_PREFIX = "videoplayer:preload";
    public static final String TAG = "VideoKernel";
    public transient /* synthetic */ FieldHolder $fh;
    public int mBufferingPosition;
    public String mCurrentPlayUrl;
    public final HashMap<String, String> mHeader;
    public String mPageUrl;
    public int mPercent;
    public String mRemoteServer;
    public int mSpeed;
    public VideoUrlModel mUrlModel;
    @NonNull
    public final VideoSession mVideoSession;

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
        this.mHeader = new HashMap<>();
        this.mVideoSession = VideoSessionManager.getInstance().createVideoSession();
        printLog("VideoKernel: " + getClass().getSimpleName() + " Created, HashCode = " + System.identityHashCode(this));
    }

    private void checkInvokePrepare(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65537, this, z) == null) && !TextUtils.isEmpty(getVideoUrl()) && z) {
            this.mCurrentPlayUrl = getVideoUrl();
            printLog("setDataSourceAndPrepare " + getVideoUrl());
            notifyStatusChange(PlayerStatus.PREPARING);
            setDataSourceAndPrepare();
        }
    }

    private void processUrlChange() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || TextUtils.equals(this.mCurrentPlayUrl, getVideoUrl()) || TextUtils.isEmpty(getVideoUrl())) {
            return;
        }
        notifyStatusChange(PlayerStatus.PREPARING);
        setDataSourceAndPrepare();
    }

    private String reuseLogId(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, this, z)) == null) {
            VideoUrlModel videoUrlModel = this.mUrlModel;
            return (videoUrlModel == null || z) ? "" : videoUrlModel.logId;
        }
        return (String) invokeZ.objValue;
    }

    private void updateVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            getVideoUrlModel().videoUrl = str;
        }
    }

    public void bindMessenger(@NonNull IMessenger iMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iMessenger) == null) {
            this.mVideoSession.bindMessenger(iMessenger);
        }
    }

    public void changePlayUrl(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        updateVideoUrl(str);
        this.mCurrentPlayUrl = this.mUrlModel.videoUrl;
        notifyStatusChange(PlayerStatus.PREPARING);
        setDataSourceAndPrepare();
        start();
    }

    @Nullable
    public abstract View getBVideoView();

    public abstract int getBufferingPosition();

    public abstract int getDecodeMode();

    public abstract int getDuration();

    public abstract int getDurationMs();

    @Nullable
    public String getKernelLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getVideoUrlModel().logId : (String) invokeV.objValue;
    }

    public String getPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mPageUrl : (String) invokeV.objValue;
    }

    public abstract int getPlayedTime();

    public abstract int getPosition();

    public abstract int getPositionMs();

    @Nullable
    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mRemoteServer : (String) invokeV.objValue;
    }

    public PlayerStatus getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mVideoSession.getStatus() : (PlayerStatus) invokeV.objValue;
    }

    public abstract int getSyncPositionMs();

    public abstract int getVideoHeight();

    @NonNull
    public VideoSession getVideoSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mVideoSession : (VideoSession) invokeV.objValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            VideoUrlModel videoUrlModel = this.mUrlModel;
            return videoUrlModel != null ? videoUrlModel.videoUrl : "";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public VideoUrlModel getVideoUrlModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.mUrlModel == null) {
                this.mUrlModel = new VideoUrlModel();
            }
            return this.mUrlModel;
        }
        return (VideoUrlModel) invokeV.objValue;
    }

    public abstract int getVideoWidth();

    public boolean matchStatus(@NonNull PlayerStatus... playerStatusArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, playerStatusArr)) == null) ? this.mVideoSession.matchStatus(playerStatusArr) : invokeL.booleanValue;
    }

    public abstract void mute(boolean z);

    public void notifyStatusChange(PlayerStatus playerStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, playerStatus) == null) {
            this.mVideoSession.statusChangeNotify(playerStatus);
        }
    }

    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mPercent = 0;
        }
    }

    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.mPercent = 0;
            this.mSpeed = 0;
            this.mCurrentPlayUrl = null;
            this.mUrlModel = null;
        }
    }

    public void onInfo(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048602, this, i2, i3, obj) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            printLog("onInit");
            View bVideoView = getBVideoView();
            if (bVideoView != null) {
                bVideoView.setBackground(null);
            }
        }
    }

    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            printLog("onRelease");
            ViewOpUtils.removeView(getBVideoView());
            this.mVideoSession.reset();
            this.mCurrentPlayUrl = null;
            this.mUrlModel = null;
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            printLog("pause");
        }
    }

    public void play(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            printLog("play(), url = " + str);
            updateVideoUrl(str);
            processUrlChange();
            this.mPercent = 0;
        }
    }

    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            printLog("prepare");
            if (PlayerStatus.isActiveStatus(getStatus()) || TextUtils.isEmpty(getVideoUrl())) {
                return;
            }
            notifyStatusChange(PlayerStatus.PREPARING);
            setDataSourceAndPrepare();
        }
    }

    public void printLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            BdVideoLog.d(TAG, String.format("video kernel [%s]: %s ", "AbsVideoKernel@" + System.identityHashCode(this), str));
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            printLog("resume");
        }
    }

    public void seekToMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            seekToMs(i2, 3);
        }
    }

    public abstract void seekToMs(int i2, int i3);

    public void setClarityInfo(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
        }
    }

    public abstract void setDataSourceAndPrepare();

    public abstract void setDecodeMode(int i2);

    public abstract void setExternalInfo(String str, Object obj);

    public void setHttpDns(@NonNull IDnsProcessListener iDnsProcessListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, iDnsProcessListener) == null) {
        }
    }

    public void setHttpHeader(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, hashMap) == null) || hashMap == null) {
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            this.mHeader.put(entry.getKey(), entry.getValue());
        }
    }

    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, iKernelPlayer) == null) {
        }
    }

    public void setKernelLogId(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            getVideoUrlModel().logId = str;
        }
    }

    public abstract void setLooping(boolean z);

    public abstract void setOption(String str, String str2);

    public void setPageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.mPageUrl = str;
        }
    }

    public void setPlayConf(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
        }
    }

    public abstract void setProxy(@Nullable String str);

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048626, this, f2) == null) {
        }
    }

    public void setRemote(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
        }
    }

    public abstract void setSpeed(float f2);

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, surface) == null) {
        }
    }

    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        printLog("setUserAgent = " + str);
        this.mHeader.put("User-Agent", str);
    }

    public abstract void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap);

    public abstract void setVideoRotation(int i2);

    public abstract void setVideoScalingMode(int i2);

    public <T extends VideoUrlModel> void setVideoUrl(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, t) == null) {
            String reuseLogId = reuseLogId(t.isNeedPrepare);
            this.mUrlModel = t;
            t.logId = reuseLogId;
            this.mRemoteServer = null;
            checkInvokePrepare(t.isNeedPrepare);
        }
    }

    public void setZOrderMediaOverlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            printLog("start()" + getVideoUrl());
            if (TextUtils.isEmpty(getVideoUrl())) {
                getVideoUrlModel().videoUrl = "";
                return;
            }
            processUrlChange();
            this.mPercent = 0;
            this.mSpeed = 0;
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            printLog(IntentConfig.STOP);
            this.mPercent = 0;
            this.mSpeed = 0;
            this.mCurrentPlayUrl = null;
            this.mUrlModel = null;
            notifyStatusChange(PlayerStatus.STOP);
        }
    }

    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            printLog("stopPlayback");
            this.mCurrentPlayUrl = null;
            this.mUrlModel = null;
        }
    }

    public void switchMediaSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
        }
    }

    public abstract boolean takeSnapshotAsync(OnSnapShotFrameListener onSnapShotFrameListener, float f2);

    public void unbindMessenger() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.mVideoSession.unbindMessenger();
        }
    }

    public abstract void updateFreeProxy(@Nullable String str);

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            setVideoUrl(str, true);
        }
    }

    public <T extends VideoUrlModel> void changePlayUrl(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            String str = getVideoUrlModel().logId;
            this.mUrlModel = t;
            t.logId = str;
            String str2 = t.videoUrl;
            this.mCurrentPlayUrl = str2;
            updateVideoUrl(str2);
            notifyStatusChange(PlayerStatus.PREPARING);
            setDataSourceAndPrepare();
            start();
        }
    }

    @Deprecated
    public void setVideoUrl(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048636, this, str, z) == null) {
            String reuseLogId = reuseLogId(z);
            VideoUrlModel videoUrlModel = new VideoUrlModel();
            this.mUrlModel = videoUrlModel;
            videoUrlModel.videoUrl = str;
            videoUrlModel.isNeedPrepare = z;
            videoUrlModel.logId = reuseLogId;
            this.mRemoteServer = null;
            checkInvokePrepare(z);
        }
    }
}
