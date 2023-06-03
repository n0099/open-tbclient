package com.baidu.searchbox.player.kernel;

import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.helper.ViewOpUtils;
import com.baidu.searchbox.player.interfaces.IDnsProcessListener;
import com.baidu.searchbox.player.interfaces.OnMediaRuntimeInfoListener;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.KernelMediaInfo;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class AbsVideoKernel implements IPoolItem {
    public static final String CYBER_PLAYER = "CyberVideoKernel";
    public static final int DURATION_MIN_DIFF = 2;
    public static final String NORMAL_PLAYER = "NormalVideoKernel";
    public static final String PRELOAD_PREFIX = "videoplayer:preload";
    public static final String TAG = "VideoKernel";
    public int mBufferingPosition;
    public String mCurrentPlayUrl;
    public String mPageUrl;
    public int mPercent;
    public String mRemoteServer;
    public int mSpeed;
    public VideoUrlModel mUrlModel;
    public final HashMap<String, String> mHeader = new HashMap<>();
    @NonNull
    public final VideoSession mVideoSession = VideoSessionManager.getInstance().createVideoSession();

    @Nullable
    public abstract View getBVideoView();

    public abstract int getBufferingPosition();

    public abstract int getDecodeMode();

    public abstract int getDuration();

    public abstract int getDurationMs();

    @Nullable
    public Map<String, String> getKernelInfo() {
        return null;
    }

    @Nullable
    public abstract KernelMediaInfo getKernelMediaInfo();

    @NonNull
    public abstract String getKernelType();

    public abstract void getMediaRuntimeInfo(@Nullable OnMediaRuntimeInfoListener onMediaRuntimeInfoListener);

    public abstract int getPlayedTime();

    public abstract int getPosition();

    public abstract int getPositionMs();

    public abstract int getSyncPositionMs();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void mute(boolean z);

    public void onPrepared() {
    }

    public abstract void seekToMs(int i, int i2);

    public void setClarityInfo(@Nullable String str) {
    }

    public abstract void setDataSourceAndPrepare();

    public abstract void setDecodeMode(int i);

    public abstract void setDynamicOption(String str, String str2);

    public abstract void setExternalInfo(String str, Object obj);

    public void setHttpDns(@NonNull IDnsProcessListener iDnsProcessListener) {
    }

    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
    }

    public abstract void setLooping(boolean z);

    public abstract void setOption(String str, String str2);

    public abstract void setProxy(@Nullable String str);

    public void setRadius(float f) {
    }

    public void setRemote(boolean z) {
    }

    public abstract void setSpeed(float f);

    public void setSurface(Surface surface) {
    }

    public abstract void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap);

    public abstract void setVideoRotation(int i);

    public abstract void setVideoScalingMode(int i);

    public void setZOrderMediaOverlay(boolean z) {
    }

    @Deprecated
    public void switchMediaSource(int i) {
    }

    public void switchMediaSource(int i, int i2) {
    }

    public abstract boolean takeSnapshotAsync(@Nullable OnSnapShotFrameListener onSnapShotFrameListener, float f);

    @NonNull
    public abstract VideoUrlModel transformVideoUrlModel(@Nullable BasicVideoSeries basicVideoSeries);

    public abstract void updateFreeProxy(@Nullable String str);

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return false;
    }

    public AbsVideoKernel() {
        printLog("VideoKernel: " + getClass().getSimpleName() + " Created, HashCode = " + System.identityHashCode(this));
    }

    private void processUrlChange() {
        boolean equals;
        if (getVideoUrlModel().isOnlyCompareUriPath()) {
            equals = BdPlayerUtils.compareUrlTo(this.mCurrentPlayUrl, getVideoUrl());
        } else {
            equals = TextUtils.equals(this.mCurrentPlayUrl, getVideoUrl());
        }
        if (!equals && !TextUtils.isEmpty(getVideoUrl())) {
            notifyStatusChange(PlayerStatus.PREPARING);
            setDataSourceAndPrepare();
        }
    }

    public void start() {
        printLog("start()" + getVideoUrl());
        if (TextUtils.isEmpty(getVideoUrl())) {
            getVideoUrlModel().setVideoUrl("");
            return;
        }
        processUrlChange();
        this.mPercent = 0;
        this.mSpeed = 0;
    }

    private void checkInvokePrepare(boolean z) {
        if (!TextUtils.isEmpty(getVideoUrl()) && z) {
            this.mCurrentPlayUrl = getVideoUrl();
            printLog("setDataSourceAndPrepare " + getVideoUrl());
            notifyStatusChange(PlayerStatus.PREPARING);
            setDataSourceAndPrepare();
        }
    }

    private void updateVideoUrl(String str) {
        getVideoUrlModel().setVideoUrl(str);
    }

    public void bindMessenger(@NonNull IMessenger iMessenger) {
        this.mVideoSession.bindMessenger(iMessenger);
    }

    public void changePlayUrl(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            updateVideoUrl(str);
            this.mCurrentPlayUrl = this.mUrlModel.getVideoUrl();
            notifyStatusChange(PlayerStatus.PREPARING);
            setDataSourceAndPrepare();
            start();
        }
    }

    public boolean matchStatus(@NonNull PlayerStatus... playerStatusArr) {
        return this.mVideoSession.matchStatus(playerStatusArr);
    }

    public void notifyStatusChange(PlayerStatus playerStatus) {
        this.mVideoSession.statusChangeNotify(playerStatus);
    }

    public void play(@NonNull String str) {
        printLog("play(), url = " + str);
        updateVideoUrl(str);
        processUrlChange();
        this.mPercent = 0;
    }

    public void printLog(String str) {
        BdVideoLog.d(TAG, String.format("video kernel [%s]: %s ", "AbsVideoKernel@" + System.identityHashCode(this), str));
    }

    public void seekToMs(int i) {
        seekToMs(i, 3);
    }

    public void setHttpHeader(@Nullable HashMap<String, String> hashMap) {
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                this.mHeader.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void setPageUrl(String str) {
        this.mPageUrl = str;
    }

    public void setUserAgent(String str) {
        if (!TextUtils.isEmpty(str)) {
            printLog("setUserAgent = " + str);
            this.mHeader.put("User-Agent", str);
        }
    }

    public void setVideoSeries(@NonNull BasicVideoSeries basicVideoSeries) {
        setVideoSeries(basicVideoSeries, null);
    }

    public void changePlayUrl(@NonNull BasicVideoSeries basicVideoSeries, @Nullable Map<String, String> map) {
        VideoUrlModel transformVideoUrlModel = transformVideoUrlModel(basicVideoSeries);
        this.mUrlModel = transformVideoUrlModel;
        transformVideoUrlModel.setVideoUrl(basicVideoSeries.getPlayUrl());
        this.mUrlModel.setOptions(map);
        this.mCurrentPlayUrl = basicVideoSeries.getPlayUrl();
        updateVideoUrl(basicVideoSeries.getPlayUrl());
        notifyStatusChange(PlayerStatus.PREPARING);
        setDataSourceAndPrepare();
        start();
    }

    public void setVideoSeries(@NonNull BasicVideoSeries basicVideoSeries, @Nullable Map<String, String> map) {
        VideoUrlModel transformVideoUrlModel = transformVideoUrlModel(basicVideoSeries);
        this.mUrlModel = transformVideoUrlModel;
        transformVideoUrlModel.setOptions(map);
        this.mRemoteServer = null;
        checkInvokePrepare(this.mUrlModel.isNeedPrepare());
    }

    @Nullable
    public String getCurrentPlayUrl() {
        return this.mCurrentPlayUrl;
    }

    public String getKLogId() {
        VideoUrlModel videoUrlModel = this.mUrlModel;
        if (videoUrlModel != null) {
            return videoUrlModel.getKLogId();
        }
        return "";
    }

    public String getPageUrl() {
        return this.mPageUrl;
    }

    @Nullable
    public String getServerIpInfo() {
        return this.mRemoteServer;
    }

    @NonNull
    public PlayerStatus getStatus() {
        return this.mVideoSession.getStatus();
    }

    @NonNull
    public VideoSession getVideoSession() {
        return this.mVideoSession;
    }

    public String getVideoUrl() {
        VideoUrlModel videoUrlModel = this.mUrlModel;
        if (videoUrlModel != null) {
            return videoUrlModel.getVideoUrl();
        }
        return "";
    }

    @NonNull
    public <T extends VideoUrlModel> T getVideoUrlModel() {
        if (this.mUrlModel == null) {
            this.mUrlModel = transformVideoUrlModel(null);
        }
        return (T) this.mUrlModel;
    }

    public void onComplete() {
        this.mPercent = 0;
    }

    public void onError() {
        this.mPercent = 0;
        this.mSpeed = 0;
        this.mCurrentPlayUrl = null;
        this.mUrlModel = null;
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        printLog("onInit");
        View bVideoView = getBVideoView();
        if (bVideoView != null) {
            bVideoView.setBackground(null);
        }
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        printLog("onRelease");
        ViewOpUtils.removeView(getBVideoView());
        this.mVideoSession.reset();
        this.mCurrentPlayUrl = null;
        this.mUrlModel = null;
    }

    public void pause() {
        printLog(DownloadStatisticConstants.UBC_TYPE_PAUSE);
    }

    public void prepare() {
        printLog("prepare");
        if (!PlayerStatus.isActiveStatus(getStatus()) && !TextUtils.isEmpty(getVideoUrl())) {
            notifyStatusChange(PlayerStatus.PREPARING);
            setDataSourceAndPrepare();
        }
    }

    public void resume() {
        printLog(DownloadStatisticConstants.UBC_TYPE_RESUME);
    }

    public void stop() {
        printLog("stop");
        this.mPercent = 0;
        this.mSpeed = 0;
        this.mCurrentPlayUrl = null;
        this.mUrlModel = null;
        notifyStatusChange(PlayerStatus.STOP);
    }

    public void stopPlayback() {
        printLog("stopPlayback");
        this.mCurrentPlayUrl = null;
        this.mUrlModel = null;
    }

    public void unbindMessenger() {
        this.mVideoSession.unbindMessenger();
    }

    public void onInfo(int i, int i2, Object obj) {
        if (701 == i) {
            this.mPercent = 0;
        } else if (702 == i) {
            this.mPercent = 100;
        } else if (946 == i) {
            this.mBufferingPosition = i2;
        } else if (924 == i) {
            this.mSpeed = i2;
        } else if (5000 == i && (obj instanceof String)) {
            this.mRemoteServer = (String) obj;
        }
    }
}
