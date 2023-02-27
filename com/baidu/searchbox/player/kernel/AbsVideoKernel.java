package com.baidu.searchbox.player.kernel;

import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
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

    public abstract void setExternalInfo(String str, Object obj);

    public void setHttpDns(@NonNull IDnsProcessListener iDnsProcessListener) {
    }

    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
    }

    public abstract void setLooping(boolean z);

    public abstract void setOption(String str, String str2);

    public void setPlayConf(@Nullable String str) {
    }

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

    public void switchMediaSource(int i) {
    }

    public abstract boolean takeSnapshotAsync(OnSnapShotFrameListener onSnapShotFrameListener, float f);

    public abstract void updateFreeProxy(@Nullable String str);

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return false;
    }

    public AbsVideoKernel() {
        printLog("VideoKernel: " + getClass().getSimpleName() + " Created, HashCode = " + System.identityHashCode(this));
    }

    public void start() {
        printLog("start()" + getVideoUrl());
        if (TextUtils.isEmpty(getVideoUrl())) {
            getVideoUrlModel().videoUrl = "";
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

    private void processUrlChange() {
        if (!TextUtils.equals(this.mCurrentPlayUrl, getVideoUrl()) && !TextUtils.isEmpty(getVideoUrl())) {
            notifyStatusChange(PlayerStatus.PREPARING);
            setDataSourceAndPrepare();
        }
    }

    @Nullable
    public String getKernelLogId() {
        return getVideoUrlModel().logId;
    }

    public String getPageUrl() {
        return this.mPageUrl;
    }

    @Nullable
    public String getServerIpInfo() {
        return this.mRemoteServer;
    }

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
            return videoUrlModel.videoUrl;
        }
        return "";
    }

    @NonNull
    public VideoUrlModel getVideoUrlModel() {
        if (this.mUrlModel == null) {
            this.mUrlModel = new VideoUrlModel();
        }
        return this.mUrlModel;
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
        printLog("pause");
    }

    public void prepare() {
        printLog("prepare");
        if (!PlayerStatus.isActiveStatus(getStatus()) && !TextUtils.isEmpty(getVideoUrl())) {
            notifyStatusChange(PlayerStatus.PREPARING);
            setDataSourceAndPrepare();
        }
    }

    public void resume() {
        printLog("resume");
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

    private String reuseLogId(boolean z) {
        VideoUrlModel videoUrlModel = this.mUrlModel;
        if (videoUrlModel != null && !z) {
            return videoUrlModel.logId;
        }
        return "";
    }

    private void updateVideoUrl(String str) {
        getVideoUrlModel().videoUrl = str;
    }

    public void bindMessenger(@NonNull IMessenger iMessenger) {
        this.mVideoSession.bindMessenger(iMessenger);
    }

    public <T extends VideoUrlModel> void changePlayUrl(@NonNull T t) {
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

    public void setKernelLogId(@NonNull String str) {
        getVideoUrlModel().logId = str;
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

    public <T extends VideoUrlModel> void setVideoUrl(@NonNull T t) {
        String reuseLogId = reuseLogId(t.isNeedPrepare);
        this.mUrlModel = t;
        t.logId = reuseLogId;
        this.mRemoteServer = null;
        checkInvokePrepare(t.isNeedPrepare);
    }

    public void changePlayUrl(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            updateVideoUrl(str);
            this.mCurrentPlayUrl = this.mUrlModel.videoUrl;
            notifyStatusChange(PlayerStatus.PREPARING);
            setDataSourceAndPrepare();
            start();
        }
    }

    @Deprecated
    public void setVideoUrl(String str) {
        setVideoUrl(str, true);
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

    @Deprecated
    public void setVideoUrl(String str, boolean z) {
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
