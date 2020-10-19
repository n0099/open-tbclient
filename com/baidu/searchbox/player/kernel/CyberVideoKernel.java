package com.baidu.searchbox.player.kernel;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public class CyberVideoKernel extends AbsVideoKernel {
    private static final String TAG = "CyberVideoKernel";
    private CyberVideoView mVideoView = new CyberVideoView(BDPlayerConfig.getAppContext(), 1);

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        super.setKernelCallBack(iKernelPlayer);
        setVideoViewCallBack(iKernelPlayer);
    }

    private void setVideoViewCallBack(IKernelPlayer iKernelPlayer) {
        this.mVideoView.setOnCompletionListener(iKernelPlayer);
        this.mVideoView.setOnErrorListener(iKernelPlayer);
        this.mVideoView.setOnInfoListener(iKernelPlayer);
        this.mVideoView.setOnSeekCompleteListener(iKernelPlayer);
        this.mVideoView.setOnPreparedListener(iKernelPlayer);
        this.mVideoView.setOnBufferingUpdateListener(iKernelPlayer);
        this.mVideoView.setOnVideoSizeChangedListener(iKernelPlayer);
    }

    @PublicMethod(version = "11.24.0.0")
    @Nullable
    public TextureView getRenderView() {
        if (this.mVideoView.getRenderView() instanceof TextureView) {
            return (TextureView) this.mVideoView.getRenderView();
        }
        return null;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setDecodeMode(int i) {
        this.mVideoView.setDecodeMode(i);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setSpeed(float f) {
        this.mVideoView.setSpeed(f);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setProxy(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mVideoView.setOption(CyberPlayerManager.OPT_HTTP_PROXY, str);
            this.mVideoView.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            return;
        }
        this.mVideoView.setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
        this.mVideoView.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void updateFreeProxy(@Nullable String str) {
        if (str != null) {
            this.mVideoView.changeProxyDynamic(str);
        } else {
            this.mVideoView.changeProxyDynamic(null);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    @NonNull
    public View getBVideoView() {
        return this.mVideoView;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getVideoHeight() {
        return this.mVideoView.getVideoHeight();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getVideoWidth() {
        return this.mVideoView.getVideoWidth();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getPositionMs() {
        return (!this.mKernelStatus.isIdle() || getDuration() - this.mVideoView.getCurrentPosition() > 2) ? this.mVideoView.getCurrentPosition() : getDurationMs();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getSyncPositionMs() {
        return this.mVideoView.getCurrentPosition();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getPosition() {
        if (this.mKernelStatus.isIdle()) {
            int duration = getDuration() / 1000;
            if (duration - (this.mVideoView.getCurrentPosition() / 1000) <= 2) {
                return duration;
            }
        }
        return this.mVideoView.getCurrentPosition() / 1000;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void mute(boolean z) {
        this.mVideoView.muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getBufferingPosition() {
        return this.mBufferingPosition;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getDuration() {
        return this.mVideoView.getDuration() / 1000;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getDurationMs() {
        return this.mVideoView.getDuration();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public int getPlayedTime() {
        return (int) this.mVideoView.getPlayedTime();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void seekTo(int i) {
        this.mVideoView.seekTo(i * 1000);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setLooping(boolean z) {
        this.mVideoView.setLooping(z);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setExternalInfo(String str, Object obj) {
        this.mVideoView.setExternalInfo(str, obj);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setOption(String str, String str2) {
        this.mVideoView.setOption(str, str2);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setVideoRotation(int i) {
        this.mVideoView.setVideoRotation(i);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setVideoScalingMode(int i) {
        this.mVideoView.setVideoScalingMode(i);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onError() {
        this.mPreparingUrl = null;
        super.onError();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onPrepared() {
        super.onPrepared();
        if (this.mStorePosition > 2) {
            this.mVideoView.seekTo(this.mStorePosition - 2);
            this.mStorePosition = -1;
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        super.onInit();
        this.mVideoView.reset();
        this.mVideoView.setVideoScalingMode(2);
        this.mVideoView.setSpeed(1.0f);
        this.mVideoView.setVideoRotation(0);
        this.mVideoView.setVisibility(0);
        this.mVideoView.setAlpha(1.0f);
        setRemote(true);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        super.onRelease();
        this.mVideoView.stopPlayback();
        setVideoViewCallBack(null);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return "CyberVideoKernel".equals(str);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setVideoUrl(String str) {
        super.setVideoUrl(str);
        if (!TextUtils.equals(this.mPreparingUrl, str)) {
            prepareInternal();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void play(@NonNull String str) {
        super.play(str);
        BdVideoLog.d("CyberVideoKernel", "video kernel play " + str);
        if (!"videoplayer:preload".equals(this.mVideoUrl)) {
            start();
        }
        this.mStorePosition = -1;
    }

    private void prepareInternal() {
        this.mPreparingUrl = this.mVideoUrl;
        this.mKernelStatus.stateChangeNotify(PlayerStatus.PREPARING);
        this.mVideoView.setVideoURI(Uri.parse(this.mVideoUrl), this.mHeader);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void resume() {
        if (this.mKernelStatus.isPause() || this.mKernelStatus.isComplete()) {
            this.mKernelStatus.stateChangeNotify(PlayerStatus.PLAYING);
            this.mVideoView.start();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void pause() {
        super.pause();
        if (this.mKernelStatus.isPlaying() || this.mKernelStatus.isPrepared() || this.mKernelStatus.isPreparing()) {
            this.mKernelStatus.stateChangeNotify(PlayerStatus.PAUSE);
            this.mVideoView.pause();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void stop() {
        super.stop();
        this.mPercent = 0;
        this.mSpeed = 0;
        this.mPreparingUrl = null;
        this.mKernelStatus.stateChangeNotify(PlayerStatus.STOP);
        this.mVideoView.stopPlayback();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void stopPlayback() {
        super.stopPlayback();
        this.mVideoView.stopPlayback();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void start() {
        super.start();
        this.mVideoView.start();
        if (this.mKernelStatus.getStatus() == PlayerStatus.COMPLETE) {
            this.mKernelStatus.stateChangeNotify(PlayerStatus.PLAYING);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void prepare() {
        super.prepare();
        this.mKernelStatus.stateChangeNotify(PlayerStatus.PREPARING);
        if (!TextUtils.equals(this.mPreparingUrl, this.mVideoUrl)) {
            prepareInternal();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void changePlayUrl(@NonNull String str) {
        if (this.mStorePosition == -1) {
            this.mStorePosition = this.mVideoView.getCurrentPosition();
        }
        this.mVideoUrl = str;
        prepareInternal();
        start();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setRemote(boolean z) {
        super.setRemote(z);
        this.mVideoView.setRemote(z);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            this.mVideoView.setOption(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f) {
        return this.mVideoView.takeSnapshotAsync(onSnapShotCompleteListener);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @PublicMethod
    public void setHttpDns(@NonNull CyberPlayerManager.HttpDNS httpDNS) {
        super.setHttpDns(httpDNS);
        this.mVideoView.setHttpDns(httpDNS);
    }
}
