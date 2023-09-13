package com.baidu.searchbox.player.kernel;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberRuntimeInfo;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.interfaces.IDnsProcessListener;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.baidu.searchbox.player.interfaces.OnMediaRuntimeInfoListener;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.kernel.BaseDumediaVideoKernel;
import com.baidu.searchbox.player.model.KernelMediaInfo;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.utils.MediaInfoConvert;
import com.baidu.searchbox.player.view.RoundOutlineProvider;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class CyberVideoKernel extends BaseDumediaVideoKernel {
    public IKernelGestureDetector mGestureDetector;
    public final CyberVideoView mVideoView = createCyberVideoView();

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public String getKernelType() {
        return AbsVideoKernel.CYBER_PLAYER;
    }

    public CyberVideoView createCyberVideoView() {
        return new CyberVideoView(BDPlayerConfig.getAppContext(), 1) { // from class: com.baidu.searchbox.player.kernel.CyberVideoKernel.1
            @Override // android.view.View
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (CyberVideoKernel.this.mGestureDetector != null) {
                    return CyberVideoKernel.this.mGestureDetector.onTouchEvent(motionEvent);
                }
                return super.onTouchEvent(motionEvent);
            }
        };
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public View getBVideoView() {
        return this.mVideoView;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getBufferingPosition() {
        return this.mBufferingPosition;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDecodeMode() {
        return this.mVideoView.getDecodeMode();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDuration() {
        return this.mVideoView.getDuration() / 1000;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDurationMs() {
        return this.mVideoView.getDuration();
    }

    @Nullable
    public IKernelGestureDetector getGestureDetector() {
        return this.mGestureDetector;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @Nullable
    public Map<String, String> getKernelInfo() {
        return super.getKernelInfo();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @Nullable
    public KernelMediaInfo getKernelMediaInfo() {
        CyberVideoView cyberVideoView = this.mVideoView;
        if (cyberVideoView != null) {
            return MediaInfoConvert.transform(cyberVideoView.getMediaInfo());
        }
        return null;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPlayedTime() {
        return (int) this.mVideoView.getPlayedTime();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPosition() {
        if (matchStatus(PlayerStatus.IDLE)) {
            int duration = getDuration() / 1000;
            if (duration - (this.mVideoView.getCurrentPosition() / 1000) <= 2) {
                return duration;
            }
        }
        return this.mVideoView.getCurrentPosition() / 1000;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPositionMs() {
        if (getStatus() == PlayerStatus.IDLE && getDuration() - this.mVideoView.getCurrentPosition() <= 2) {
            return getDurationMs();
        }
        return this.mVideoView.getCurrentPosition();
    }

    @Nullable
    public TextureView getRenderView() {
        if (this.mVideoView.getRenderView() instanceof TextureView) {
            return this.mVideoView.getRenderView();
        }
        return null;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getSyncPositionMs() {
        return this.mVideoView.getCurrentPositionSync();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoHeight() {
        return this.mVideoView.getVideoHeight();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoWidth() {
        return this.mVideoView.getVideoWidth();
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
        this.mVideoView.setBackgroundColor(-16777216);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        super.onRelease();
        this.mVideoView.stopPlayback();
        setKernelCallBack(null);
        setGestureDetector(null);
        this.mGestureDetector = null;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void pause() {
        super.pause();
        if (matchStatus(PlayerStatus.PLAYING, PlayerStatus.PREPARED, PlayerStatus.PREPARING)) {
            notifyStatusChange(PlayerStatus.PAUSE);
            this.mVideoView.pause();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void resume() {
        super.resume();
        if (matchStatus(PlayerStatus.PREPARED, PlayerStatus.PREPARING, PlayerStatus.PAUSE, PlayerStatus.COMPLETE)) {
            notifyStatusChange(PlayerStatus.PLAYING);
            this.mVideoView.start();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDataSourceAndPrepare() {
        this.mVideoView.setVideoURI(getVideoUri(), this.mHeader, getVideoUrlModel().getOptions());
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void start() {
        super.start();
        this.mVideoView.start();
        if (matchStatus(PlayerStatus.COMPLETE)) {
            notifyStatusChange(PlayerStatus.PLAYING);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void stop() {
        super.stop();
        this.mVideoView.stopPlayback();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void stopPlayback() {
        super.stopPlayback();
        this.mVideoView.stopPlayback();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void getMediaRuntimeInfo(@Nullable final OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        CyberVideoView cyberVideoView = this.mVideoView;
        if (cyberVideoView != null) {
            cyberVideoView.getMediaRuntimeInfo(new CyberRuntimeInfo.OnMediaRuntimeInfoDefault() { // from class: com.baidu.searchbox.player.kernel.CyberVideoKernel.3
                @Override // com.baidu.cyberplayer.sdk.CyberRuntimeInfo.OnMediaRuntimeInfoDefault
                public void onInfo(CyberRuntimeInfo cyberRuntimeInfo) {
                    OnMediaRuntimeInfoListener onMediaRuntimeInfoListener2 = onMediaRuntimeInfoListener;
                    if (onMediaRuntimeInfoListener2 != null) {
                        onMediaRuntimeInfoListener2.onInfo(MediaInfoConvert.transform(cyberRuntimeInfo));
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void mute(boolean z) {
        this.mVideoView.muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void play(@NonNull String str) {
        super.play(str);
        BdVideoLog.d("player(), url = " + str);
        if (!AbsVideoKernel.PRELOAD_PREFIX.equals(str)) {
            start();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setClarityInfo(@Nullable String str) {
        this.mVideoView.setClarityInfo(str);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDecodeMode(int i) {
        this.mVideoView.setDecodeMode(i);
    }

    public void setGestureDetector(@Nullable IKernelGestureDetector iKernelGestureDetector) {
        this.mGestureDetector = iKernelGestureDetector;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setHttpDns(@NonNull IDnsProcessListener iDnsProcessListener) {
        super.setHttpDns(iDnsProcessListener);
        this.mVideoView.setHttpDns(new BaseDumediaVideoKernel.CyberPlayerHttpDNS(iDnsProcessListener));
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setLooping(boolean z) {
        this.mVideoView.setLooping(z);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setProxy(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mVideoView.setOption(CyberPlayerManager.OPT_HTTP_PROXY, str);
            this.mVideoView.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, YYOption.IsLive.VALUE_TRUE);
            return;
        }
        this.mVideoView.setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
        this.mVideoView.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setRadius(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.mVideoView.setOutlineProvider(new RoundOutlineProvider(f));
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setRemote(boolean z) {
        super.setRemote(z);
        this.mVideoView.setRemote(z);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setSpeed(float f) {
        this.mVideoView.setSpeed(f);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoRotation(int i) {
        this.mVideoView.setVideoRotation(i);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoScalingMode(int i) {
        this.mVideoView.setVideoScalingMode(i);
    }

    @Override // com.baidu.searchbox.player.kernel.BaseDumediaVideoKernel
    public void setVideoViewCallBack(DumediaInfoConverter dumediaInfoConverter) {
        this.mVideoView.setOnCompletionListener(dumediaInfoConverter);
        this.mVideoView.setOnErrorListener(dumediaInfoConverter);
        this.mVideoView.setOnInfoListener(dumediaInfoConverter);
        this.mVideoView.setOnSeekCompleteListener(dumediaInfoConverter);
        this.mVideoView.setOnPreparedListener(dumediaInfoConverter);
        this.mVideoView.setOnBufferingUpdateListener(dumediaInfoConverter);
        this.mVideoView.setOnVideoSizeChangedListener(dumediaInfoConverter);
        this.mVideoView.setOnMediaSourceChangedListener(dumediaInfoConverter);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void switchMediaSource(int i) {
        this.mVideoView.switchMediaSource(i);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void updateFreeProxy(@Nullable String str) {
        this.mVideoView.changeProxyDynamic(str);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return AbsVideoKernel.CYBER_PLAYER.equals(str);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void seekToMs(int i, int i2) {
        this.mVideoView.seekTo(i, i2);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDynamicOption(String str, String str2) {
        this.mVideoView.setOption(str, str2);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setExternalInfo(String str, Object obj) {
        this.mVideoView.setExternalInfo(str, obj);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setOption(String str, String str2) {
        this.mVideoView.setOption(str, str2);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            this.mVideoView.setOption(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void switchMediaSource(int i, int i2) {
        if (i2 == 1) {
            this.mVideoView.switchMediaSource(i, CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_FORCE_MODE);
        } else {
            this.mVideoView.switchMediaSource(i, CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public boolean takeSnapshotAsync(@Nullable final OnSnapShotFrameListener onSnapShotFrameListener, float f) {
        if (onSnapShotFrameListener == null) {
            return false;
        }
        return this.mVideoView.takeSnapshotAsync(new ICyberVideoView.OnSnapShotCompleteListener() { // from class: com.baidu.searchbox.player.kernel.CyberVideoKernel.2
            @Override // com.baidu.cyberplayer.sdk.ICyberVideoView.OnSnapShotCompleteListener
            public void onSnapShotComplete(@Nullable Bitmap bitmap) {
                onSnapShotFrameListener.onSnapShotComplete(bitmap);
            }
        }, f, 0, 0);
    }
}
