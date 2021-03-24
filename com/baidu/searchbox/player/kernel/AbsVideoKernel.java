package com.baidu.searchbox.player.kernel;

import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.helper.ViewOpUtils;
import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.searchbox.player.session.VideoKernelState;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class AbsVideoKernel implements IPoolItem {
    public static final String CYBER_PLAYER = "CyberVideoKernel";
    public static final int DURATION_MIN_DIFF = 2;
    public static final String NORMAL_PLAYER = "NormalVideoKernel";
    public static final int POSITION_NONE = -1;
    public static final String PRELOAD_PREFIX = "videoplayer:preload";
    public static final String SURFACE_PLAYER = "SurfaceVideoKernel";
    public static final String TAG = "AbsVideoKernel";
    public static final String TEXTURE_PLAYER = "TextureVideoKernel";
    public int mBufferingPosition;
    public IKernelPlayer mKernelCallBack;
    public VideoKernelState mKernelStatus;
    public String mPageUrl;
    public int mPercent;
    public String mPreparingUrl;
    public String mRemoteServer;
    public int mSpeed;
    public String mVideoUrl;
    public int mStorePosition = -1;
    public HashMap<String, String> mHeader = new HashMap<>();

    public abstract void changePlayUrl(@NonNull String str);

    @Nullable
    public abstract View getBVideoView();

    public abstract int getBufferingPosition();

    public String getCyberNativeVersion() {
        return CyberPlayerManager.getCoreVersion();
    }

    public String getCyberSDKVersion() {
        return CyberPlayerManager.getSDKVersion();
    }

    public abstract int getDuration();

    public abstract int getDurationMs();

    public VideoKernelState getKernelState() {
        return this.mKernelStatus;
    }

    public String getPageUrl() {
        return this.mPageUrl;
    }

    public abstract int getPlayedTime();

    public abstract int getPosition();

    public abstract int getPositionMs();

    @Nullable
    public String getServerIpInfo() {
        return this.mRemoteServer;
    }

    public abstract int getSyncPositionMs();

    public abstract int getVideoHeight();

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public abstract int getVideoWidth();

    public boolean inClarityChanging() {
        return this.mStorePosition != -1;
    }

    public abstract void mute(boolean z);

    public void onComplete() {
        this.mPercent = 0;
    }

    public void onError() {
        this.mPercent = 0;
        this.mSpeed = 0;
        this.mPreparingUrl = null;
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

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
    }

    public void onPrepared() {
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        BdVideoLog.d("videoKernel onRelease");
        ViewOpUtils.removeView(getBVideoView());
        this.mKernelCallBack = null;
        this.mKernelStatus = null;
        this.mPreparingUrl = null;
    }

    public void pause() {
    }

    public void play(@NonNull String str) {
        BdVideoLog.d(TAG, "kernel play url:" + str);
        this.mVideoUrl = str;
        if (!TextUtils.equals(this.mPreparingUrl, str)) {
            this.mKernelStatus.stateChangeNotify(PlayerStatus.PREPARING);
            this.mPreparingUrl = null;
        }
        this.mPercent = 0;
    }

    public void prepare() {
    }

    public void resume() {
    }

    public abstract void seekTo(int i);

    public void seekToMs(int i) {
    }

    public abstract void setDecodeMode(int i);

    public abstract void setExternalInfo(String str, Object obj);

    public void setHttpDns(@NonNull CyberPlayerManager.HttpDNS httpDNS) {
    }

    public void setHttpHeader(@Nullable HashMap<String, String> hashMap) {
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                this.mHeader.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        this.mKernelCallBack = iKernelPlayer;
    }

    public abstract void setLooping(boolean z);

    public abstract void setOption(String str, String str2);

    public void setPageUrl(String str) {
        this.mPageUrl = str;
    }

    public abstract void setProxy(@Nullable String str);

    public void setRemote(boolean z) {
    }

    public abstract void setSpeed(float f2);

    public void setSurface(Surface surface) {
    }

    public void setUserAgent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BdVideoLog.d("UserAgent", "setUserAgent " + str);
        this.mHeader.put("User-Agent", str);
    }

    public abstract void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap);

    public abstract void setVideoRotation(int i);

    public abstract void setVideoScalingMode(int i);

    public void setVideoSession(@NonNull VideoSession videoSession) {
        this.mKernelStatus = videoSession.getState();
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
        this.mRemoteServer = null;
    }

    public void setZOrderMediaOverlay(boolean z) {
    }

    public void start() {
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

    public void stop() {
        this.mPreparingUrl = null;
    }

    public void stopPlayback() {
        this.mPreparingUrl = null;
    }

    public abstract boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2);

    public abstract void updateFreeProxy(@Nullable String str);

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return false;
    }
}
