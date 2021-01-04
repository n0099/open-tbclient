package com.baidu.searchbox.player.layer;

import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.kernel.EmptyKernel;
import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.pool.VideoKernelPool;
import com.baidu.searchbox.player.session.VideoKernelState;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class BaseKernelLayer extends AbsLayer {
    protected static final int MIN_POSITION = 2;
    public static int SEEK_TO_DELTA = 1;
    private boolean mAcceptVolumeChange = true;
    protected AbsVideoKernel mVideoKernel;

    public BaseKernelLayer(@NonNull String str) {
        this.mVideoKernel = VideoKernelPool.getInstance().obtain(str);
        initLayer();
    }

    public BaseKernelLayer(@NonNull AbsVideoKernel absVideoKernel) {
        this.mVideoKernel = absVideoKernel;
        initLayer();
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void initLayer() {
        super.initLayer();
    }

    @PublicMethod
    public VideoKernelState getKernelState() {
        return this.mVideoKernel.getKernelState();
    }

    @PublicMethod
    public void setVideoSession(VideoSession videoSession) {
        this.mVideoKernel.setVideoSession(videoSession);
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    @Nullable
    @PublicMethod
    public View getContentView() {
        return this.mVideoKernel.getBVideoView();
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{4, 3, 1, 2};
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        if (ControlEvent.ACTION_SEEK.equals(videoEvent.getAction())) {
            this.mVideoKernel.seekTo(((Integer) videoEvent.getExtra(5)).intValue());
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        String action = videoEvent.getAction();
        char c = 65535;
        switch (action.hashCode()) {
            case -525235558:
                if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                    c = 1;
                    break;
                }
                break;
            case -461848373:
                if (action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                    c = 2;
                    break;
                }
                break;
            case 154871702:
                if (action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                    c = 0;
                    break;
                }
                break;
            case 1370689931:
                if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.mVideoKernel.onComplete();
                return;
            case 1:
                this.mVideoKernel.onPrepared();
                return;
            case 2:
                this.mVideoKernel.onError();
                return;
            case 3:
                this.mVideoKernel.onInfo(((Integer) videoEvent.getExtra(1)).intValue(), ((Integer) videoEvent.getExtra(2)).intValue(), videoEvent.getExtra(3));
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        int intValue;
        if (LayerEvent.ACTION_CLICK_NET_TIP.equals(videoEvent.getAction())) {
            getBindPlayer().doPlay();
        } else if (LayerEvent.ACTION_SEEK.equals(videoEvent.getAction())) {
            seekTo(((Integer) videoEvent.getExtra(1)).intValue());
            requestAudioFocus();
            this.mVideoKernel.resume();
        } else if (LayerEvent.ACTION_CHANGE_CLARITY.equals(videoEvent.getAction()) && (intValue = ((Integer) videoEvent.getExtra(19)).intValue()) > 2) {
            int i = intValue - 2;
            BdVideoLog.d("changePlayUrl seek :" + i);
            this.mVideoKernel.seekTo(i);
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
        if (this.mAcceptVolumeChange && SystemEvent.ACTION_VOLUME_CHANGED.equals(videoEvent.getAction())) {
            mute(((Integer) videoEvent.getExtra(5)).intValue() <= 0);
        }
    }

    @PublicMethod
    public AbsVideoKernel getVideoKernel() {
        return this.mVideoKernel;
    }

    @PublicMethod
    public int getPosition() {
        return this.mVideoKernel.getPosition();
    }

    @PublicMethod
    public int getPositionMs() {
        return this.mVideoKernel.getPositionMs();
    }

    @PublicMethod
    public int getSyncPositionMs() {
        return this.mVideoKernel.getSyncPositionMs();
    }

    @PublicMethod
    public void setZOrderMediaOverlay(boolean z) {
        this.mVideoKernel.setZOrderMediaOverlay(z);
    }

    @PublicMethod
    public int getDuration() {
        return this.mVideoKernel.getDuration();
    }

    @PublicMethod
    public int getDurationMs() {
        return this.mVideoKernel.getDurationMs();
    }

    @PublicMethod
    public int getBufferingPosition() {
        return this.mVideoKernel.getBufferingPosition();
    }

    @PublicMethod
    public String getVideoUrl() {
        return this.mVideoKernel.getVideoUrl();
    }

    @Nullable
    @PublicMethod
    public String getServerIpInfo() {
        return this.mVideoKernel.getServerIpInfo();
    }

    @PublicMethod
    public void setProxy(@Nullable String str) {
        this.mVideoKernel.setProxy(str);
    }

    @PublicMethod
    public void setVideoUrl(String str) {
        this.mVideoKernel.setVideoUrl(str);
    }

    @PublicMethod
    public void setUserAgent(String str) {
        this.mVideoKernel.setUserAgent(str);
    }

    @PublicMethod
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        this.mVideoKernel.setKernelCallBack(iKernelPlayer);
    }

    @PublicMethod
    public void setLooping(boolean z) {
        this.mVideoKernel.setLooping(z);
    }

    @PublicMethod
    public void changePlayUrl(@NonNull String str) {
        this.mVideoKernel.changePlayUrl(str);
    }

    @PublicMethod
    public void stopPlayback() {
        this.mVideoKernel.stopPlayback();
    }

    @PublicMethod
    public void mute(boolean z) {
        this.mVideoKernel.mute(z);
    }

    @PublicMethod
    public void seekTo(int i) {
        int duration = this.mVideoKernel.getDuration();
        if (duration > SEEK_TO_DELTA && i > duration - SEEK_TO_DELTA) {
            i = duration - SEEK_TO_DELTA;
        }
        this.mVideoKernel.seekTo(i);
    }

    @PublicMethod
    public void seekToMs(int i) {
        int durationMs = this.mVideoKernel.getDurationMs();
        if (durationMs > SEEK_TO_DELTA && i > durationMs - SEEK_TO_DELTA) {
            i = durationMs - SEEK_TO_DELTA;
        }
        this.mVideoKernel.seekToMs(i);
    }

    @PublicMethod
    public void play(@NonNull String str) {
        this.mVideoKernel.play(str);
    }

    @PublicMethod
    public void prepare() {
        this.mVideoKernel.prepare();
    }

    @PublicMethod
    public void pause() {
        this.mVideoKernel.pause();
    }

    @PublicMethod
    public void resume() {
        this.mVideoKernel.resume();
    }

    @PublicMethod
    public void stop() {
        this.mVideoKernel.stop();
    }

    @PublicMethod
    public void release() {
        if (!(this.mVideoKernel instanceof EmptyKernel)) {
            setKernelCallBack(null);
            AbsVideoKernel absVideoKernel = this.mVideoKernel;
            this.mVideoKernel = new EmptyKernel();
            VideoKernelPool.getInstance().recycle(absVideoKernel);
        }
    }

    @PublicMethod
    public void setSpeed(float f) {
        this.mVideoKernel.setSpeed(f);
    }

    @PublicMethod
    public void setExternalInfo(String str, Object obj) {
        this.mVideoKernel.setExternalInfo(str, obj);
    }

    @PublicMethod
    public void setOption(String str, String str2) {
        this.mVideoKernel.setOption(str, str2);
    }

    @PublicMethod
    public void updateFreeProxy(@Nullable String str) {
        this.mVideoKernel.updateFreeProxy(str);
    }

    @PublicMethod
    public void setRemote(boolean z) {
        this.mVideoKernel.setRemote(z);
    }

    @PublicMethod
    public void setVideoRotation(int i) {
        this.mVideoKernel.setVideoRotation(i);
    }

    @PublicMethod
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        this.mVideoKernel.setVideoFormatOptions(str, hashMap);
    }

    @PublicMethod
    public void setVideoScalingMode(int i) {
        this.mVideoKernel.setVideoScalingMode(i);
    }

    @PublicMethod
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f) {
        return this.mVideoKernel.takeSnapshotAsync(onSnapShotCompleteListener, f);
    }

    @PublicMethod
    public void setAcceptVolumeChange(Boolean bool) {
        this.mAcceptVolumeChange = bool.booleanValue();
    }

    @PublicMethod
    public int getVideoWidth() {
        return this.mVideoKernel.getVideoWidth();
    }

    @PublicMethod
    public int getVideoHeight() {
        return this.mVideoKernel.getVideoHeight();
    }

    @PublicMethod
    public void setHttpHeader(HashMap<String, String> hashMap) {
        this.mVideoKernel.setHttpHeader(hashMap);
    }

    @PublicMethod
    public void setDecodeMode(int i) {
        this.mVideoKernel.setDecodeMode(i);
    }

    @PublicMethod
    public void setSurface(Surface surface) {
        this.mVideoKernel.setSurface(surface);
    }

    private void requestAudioFocus() {
        if (!getBindPlayer().isPlayerMute()) {
            getBindPlayer().requestAudioFocus();
        }
    }
}
