package com.baidu.searchbox.player.layer;

import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.searchbox.player.event.InternalSyncControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.baidu.searchbox.player.interfaces.InternalEventDispatcher;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.kernel.EmptyKernel;
import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.player.pool.VideoKernelPool;
import com.baidu.searchbox.player.session.VideoSession;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class BaseKernelLayer extends AbsLayer {
    public static final int MIN_POSITION = 2;
    public static final int SEEK_TO_DELTA = 1;
    public boolean mAcceptVolumeChange = true;
    public InternalEventDispatcher mInternalEventDispatcher = new Dispatcher();
    public AbsVideoKernel mVideoKernel;

    @Nullable
    @PublicMethod(version = "12.5.0.0")
    public IKernelGestureDetector getGestureDetector() {
        return null;
    }

    @PublicMethod(version = "12.5.0.0")
    public void setGestureDetector(@Nullable IKernelGestureDetector iKernelGestureDetector) {
    }

    /* loaded from: classes2.dex */
    public class Dispatcher implements InternalEventDispatcher {
        @Override // com.baidu.searchbox.player.interfaces.InternalEventDispatcher
        public int getExpectOrder() {
            return 1;
        }

        public Dispatcher() {
        }

        @Override // com.baidu.searchbox.player.interfaces.InternalEventDispatcher
        public void onVideoEventNotify(VideoEvent videoEvent) {
            BaseKernelLayer.this.getVideoSession().accessEventNotify(videoEvent);
        }
    }

    public BaseKernelLayer(@NonNull AbsVideoKernel absVideoKernel) {
        this.mVideoKernel = absVideoKernel;
        initLayer();
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer
    public void attachMessenger(@NonNull IMessenger iMessenger) {
        super.attachMessenger(iMessenger);
        iMessenger.addInternalDispatcher(this.mInternalEventDispatcher);
        this.mVideoKernel.bindMessenger(iMessenger);
    }

    public void changePlayUrl(@NonNull VideoUrlModel videoUrlModel) {
        this.mVideoKernel.changePlayUrl((AbsVideoKernel) videoUrlModel);
    }

    @PublicMethod
    public void mute(boolean z) {
        this.mVideoKernel.mute(z);
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onInteractiveEventNotify(@NonNull VideoEvent videoEvent) {
        if (InteractiveEvent.ACTION_INTERACTIVE_ERROR.equals(videoEvent.getAction())) {
            this.mVideoKernel.onError();
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
        boolean z;
        if (this.mAcceptVolumeChange && SystemEvent.ACTION_VOLUME_CHANGED.equals(videoEvent.getAction())) {
            if (videoEvent.getIntExtra(5) <= 0) {
                z = true;
            } else {
                z = false;
            }
            mute(z);
        }
    }

    @PublicMethod
    public void play(@NonNull String str) {
        this.mVideoKernel.play(str);
    }

    @PublicMethod
    public void seekTo(int i) {
        int i2;
        int duration = this.mVideoKernel.getDuration();
        if (duration > 1 && i > (i2 = duration - 1)) {
            i = i2;
        }
        this.mVideoKernel.seekToMs(i * 1000);
    }

    @PublicMethod
    public void setAcceptVolumeChange(Boolean bool) {
        this.mAcceptVolumeChange = bool.booleanValue();
    }

    public void setClarityInfo(@Nullable String str) {
        this.mVideoKernel.setClarityInfo(str);
    }

    @PublicMethod
    public void setDecodeMode(int i) {
        this.mVideoKernel.setDecodeMode(i);
    }

    @PublicMethod
    public void setHttpHeader(@Nullable HashMap<String, String> hashMap) {
        this.mVideoKernel.setHttpHeader(hashMap);
    }

    @PublicMethod
    public void setKernelCallBack(@Nullable IKernelPlayer iKernelPlayer) {
        this.mVideoKernel.setKernelCallBack(iKernelPlayer);
    }

    @PublicMethod
    public void setLooping(boolean z) {
        this.mVideoKernel.setLooping(z);
    }

    public void setPlayConf(@Nullable String str) {
        this.mVideoKernel.setPlayConf(str);
    }

    @PublicMethod
    public void setProxy(@Nullable String str) {
        this.mVideoKernel.setProxy(str);
    }

    @PublicMethod(version = "11.26.0.0")
    public void setRadius(float f) {
        this.mVideoKernel.setRadius(f);
    }

    @PublicMethod
    public void setRemote(boolean z) {
        this.mVideoKernel.setRemote(z);
    }

    @PublicMethod
    public void setSpeed(float f) {
        this.mVideoKernel.setSpeed(f);
    }

    @PublicMethod
    public void setSurface(Surface surface) {
        this.mVideoKernel.setSurface(surface);
    }

    @PublicMethod
    public void setUserAgent(String str) {
        this.mVideoKernel.setUserAgent(str);
    }

    @PublicMethod
    public void setVideoRotation(int i) {
        this.mVideoKernel.setVideoRotation(i);
    }

    @PublicMethod
    public void setVideoScalingMode(int i) {
        this.mVideoKernel.setVideoScalingMode(i);
    }

    @PublicMethod(version = "12.19.0.0")
    public <T extends VideoUrlModel> void setVideoUrl(@NonNull T t) {
        this.mVideoKernel.setVideoUrl((AbsVideoKernel) t);
    }

    @PublicMethod
    public void setZOrderMediaOverlay(boolean z) {
        this.mVideoKernel.setZOrderMediaOverlay(z);
    }

    public void switchMediaSource(int i) {
        this.mVideoKernel.switchMediaSource(i);
    }

    @PublicMethod
    public void syncStatus(@NonNull PlayerStatus playerStatus) {
        this.mVideoKernel.getVideoSession().statusChangeNotify(playerStatus);
    }

    @PublicMethod
    public void updateFreeProxy(@Nullable String str) {
        this.mVideoKernel.updateFreeProxy(str);
    }

    public BaseKernelLayer(@NonNull String str) {
        this.mVideoKernel = VideoKernelPool.getInstance().obtain(str);
        initLayer();
    }

    public void changePlayUrl(@NonNull String str) {
        this.mVideoKernel.changePlayUrl(str);
    }

    @PublicMethod
    public void setVideoUrl(String str) {
        setVideoUrl(str, true);
    }

    private void requestAudioFocus() {
        if (!getBindPlayer().isPlayerMute()) {
            getBindPlayer().requestAudioFocus();
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer
    public void detachMessenger() {
        if (getMessenger() != null) {
            getMessenger().removeInternalDispatcher(this.mInternalEventDispatcher);
        }
        super.detachMessenger();
        this.mVideoKernel.unbindMessenger();
    }

    @PublicMethod
    public int getBufferingPosition() {
        return this.mVideoKernel.getBufferingPosition();
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    @Nullable
    @PublicMethod
    public View getContentView() {
        return this.mVideoKernel.getBVideoView();
    }

    @PublicMethod
    public int getDecodeMode() {
        return this.mVideoKernel.getDecodeMode();
    }

    @PublicMethod
    public int getDuration() {
        return this.mVideoKernel.getDuration();
    }

    @PublicMethod
    public int getDurationMs() {
        return this.mVideoKernel.getDurationMs();
    }

    @Nullable
    public String getKernelLogId() {
        return this.mVideoKernel.getKernelLogId();
    }

    @PublicMethod
    public int getPosition() {
        return this.mVideoKernel.getPosition();
    }

    @PublicMethod
    public int getPositionMs() {
        return this.mVideoKernel.getPositionMs();
    }

    @Nullable
    @PublicMethod
    public String getServerIpInfo() {
        return this.mVideoKernel.getServerIpInfo();
    }

    @PublicMethod
    public PlayerStatus getStatus() {
        return this.mVideoKernel.getStatus();
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{4, 3, 1, 2};
    }

    @PublicMethod
    public int getSyncPositionMs() {
        return this.mVideoKernel.getSyncPositionMs();
    }

    @PublicMethod
    public int getVideoHeight() {
        return this.mVideoKernel.getVideoHeight();
    }

    @PublicMethod
    public AbsVideoKernel getVideoKernel() {
        return this.mVideoKernel;
    }

    public VideoSession getVideoSession() {
        return this.mVideoKernel.getVideoSession();
    }

    @PublicMethod
    public String getVideoUrl() {
        return this.mVideoKernel.getVideoUrl();
    }

    @PublicMethod
    public int getVideoWidth() {
        return this.mVideoKernel.getVideoWidth();
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void initLayer() {
        super.initLayer();
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onLayerDetach() {
        super.onLayerDetach();
        sendEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_KERNEL_LAYER_DETACH));
    }

    @PublicMethod
    public void pause() {
        this.mVideoKernel.pause();
    }

    @PublicMethod
    public void prepare() {
        this.mVideoKernel.prepare();
    }

    @PublicMethod
    public void release() {
        if (this.mVideoKernel instanceof EmptyKernel) {
            return;
        }
        setKernelCallBack(null);
        AbsVideoKernel absVideoKernel = this.mVideoKernel;
        this.mVideoKernel = new EmptyKernel();
        VideoKernelPool.getInstance().recycle(absVideoKernel);
    }

    @PublicMethod
    public void resume() {
        this.mVideoKernel.resume();
    }

    @PublicMethod
    public void start() {
        this.mVideoKernel.start();
    }

    @PublicMethod
    public void stop() {
        this.mVideoKernel.stop();
    }

    @PublicMethod
    public void stopPlayback() {
        this.mVideoKernel.stopPlayback();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        char c;
        String action = videoEvent.getAction();
        switch (action.hashCode()) {
            case -1929694922:
                if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_RESUME)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1106918114:
                if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_PREPARE)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1076076346:
                if (action.equals(ControlEvent.ACTION_SEEK_MS)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -502522037:
                if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_STOP)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 745698331:
                if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_START)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1547340063:
                if (action.equals(ControlEvent.ACTION_SEEK)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1598355405:
                if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_PAUSE)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                seekToMs(videoEvent.getIntExtra(5) * 1000, videoEvent.getIntExtra(12, 3));
                return;
            case 1:
                seekToMs(videoEvent.getIntExtra(5), videoEvent.getIntExtra(12, 3));
                return;
            case 2:
                prepare();
                return;
            case 3:
                if (getContentView() != null) {
                    getContentView().setVisibility(0);
                }
                start();
                return;
            case 4:
                pause();
                return;
            case 5:
                resume();
                return;
            case 6:
                stop();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        char c;
        String action = videoEvent.getAction();
        switch (action.hashCode()) {
            case -882902390:
                if (action.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -525235558:
                if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -461848373:
                if (action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 154871702:
                if (action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1370689931:
                if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c == 4 && (videoEvent.getExtra(3) instanceof VideoUrlModel)) {
                            VideoUrlModel videoUrlModel = (VideoUrlModel) videoEvent.getExtra(3);
                            getBindPlayer().getVideoTask().videoUrl = videoUrlModel.videoUrl;
                            setVideoUrl((BaseKernelLayer) videoUrlModel);
                            return;
                        }
                        return;
                    }
                    this.mVideoKernel.onInfo(videoEvent.getIntExtra(1), videoEvent.getIntExtra(2), videoEvent.getExtra(3));
                    return;
                }
                this.mVideoKernel.onError();
                return;
            }
            this.mVideoKernel.onPrepared();
            return;
        }
        this.mVideoKernel.onComplete();
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        char c;
        String action = videoEvent.getAction();
        int hashCode = action.hashCode();
        if (hashCode != -150198673) {
            if (hashCode != -103262037) {
                if (hashCode == 1939755256 && action.equals(LayerEvent.ACTION_CHANGE_CLARITY)) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (action.equals(LayerEvent.ACTION_SEEK)) {
                    c = 1;
                }
                c = 65535;
            }
        } else {
            if (action.equals(LayerEvent.ACTION_CLICK_NET_TIP)) {
                c = 0;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c == 2) {
                    int intExtra = videoEvent.getIntExtra(19);
                    Object extra = videoEvent.getExtra(31);
                    if (extra instanceof VideoUrlModel) {
                        VideoUrlModel videoUrlModel = (VideoUrlModel) extra;
                        if (!TextUtils.isEmpty(videoUrlModel.videoUrl)) {
                            changePlayUrl(videoUrlModel);
                            seekTo(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            seekTo(videoEvent.getIntExtra(1));
            requestAudioFocus();
            this.mVideoKernel.resume();
            return;
        }
        getBindPlayer().doPlay();
    }

    public void seekToMs(int i, int i2) {
        int i3;
        int durationMs = this.mVideoKernel.getDurationMs();
        if (durationMs > 1 && i > (i3 = durationMs - 1)) {
            i = i3;
        }
        this.mVideoKernel.seekToMs(i, i2);
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
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        this.mVideoKernel.setVideoFormatOptions(str, hashMap);
    }

    public void setVideoUrl(String str, boolean z) {
        this.mVideoKernel.setVideoUrl(str, z);
    }

    @PublicMethod
    public boolean takeSnapshotAsync(OnSnapShotFrameListener onSnapShotFrameListener, float f) {
        return this.mVideoKernel.takeSnapshotAsync(onSnapShotFrameListener, f);
    }
}
