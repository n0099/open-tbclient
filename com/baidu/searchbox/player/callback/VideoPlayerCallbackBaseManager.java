package com.baidu.searchbox.player.callback;

import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ILayer;
/* loaded from: classes15.dex */
public class VideoPlayerCallbackBaseManager {
    private ILayerActionCallback mLayerActionCallback;
    private IVideoPlayerCallback mVideoPlayerCallback;

    @PublicMethod
    public void setVideoPlayerCallback(IVideoPlayerCallback iVideoPlayerCallback) {
        this.mVideoPlayerCallback = iVideoPlayerCallback;
    }

    @PublicMethod
    public IVideoPlayerCallback getVideoPlayerCallback() {
        return this.mVideoPlayerCallback;
    }

    public void setLayerActionCallback(ILayerActionCallback iLayerActionCallback) {
        this.mLayerActionCallback = iLayerActionCallback;
    }

    public void onStart() {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onStart();
        }
    }

    public void onPause() {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onPause();
        }
    }

    public void onResume() {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onResume();
        }
    }

    public void onEnd(int i) {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onEnd(i);
        }
    }

    public void onBufferStart() {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onBufferStart();
        }
    }

    public void onBufferEnd() {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onBufferEnd();
        }
    }

    public void onNetworkSpeedUpdate(int i) {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onNetworkSpeedUpdate(i);
        }
    }

    public void onSeekEnd() {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onSeekEnd();
        }
    }

    public void onError(int i, int i2, Object obj) {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onError(i, i2, obj != null ? obj.toString() : "");
        }
    }

    public void onInfo(int i, int i2, Object obj) {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onInfo(i, i2);
        }
    }

    public void onPrepared() {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onPrepared();
        }
    }

    public void onGoBackOrForeground(boolean z) {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.goBackOrForeground(z);
        }
    }

    public void onVideoSizeChanged(int i, int i2) {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onVideoSizeChanged(i, i2);
        }
    }

    public void onUpdateProgress(int i, int i2, int i3) {
        if (this.mVideoPlayerCallback != null) {
            this.mVideoPlayerCallback.onUpdateProgress(i, i2, i3);
        }
    }

    public void onLayerShow(ILayer iLayer) {
        if (this.mLayerActionCallback != null) {
            this.mLayerActionCallback.onLayerShow(iLayer);
        }
    }

    public void onLayerDismiss(ILayer iLayer) {
        if (this.mLayerActionCallback != null) {
            this.mLayerActionCallback.onLayerDismiss(iLayer);
        }
    }

    public void dispatchPlayerAction(VideoEvent videoEvent) {
        if (videoEvent.getType() == 4 || videoEvent.getType() == 2) {
            String action = videoEvent.getAction();
            char c = 65535;
            switch (action.hashCode()) {
                case -1502879971:
                    if (action.equals(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED)) {
                        c = 5;
                        break;
                    }
                    break;
                case -1244137507:
                    if (action.equals(PlayerEvent.ACTION_SEEK_COMPLETE)) {
                        c = 4;
                        break;
                    }
                    break;
                case -525235558:
                    if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c = 2;
                        break;
                    }
                    break;
                case -461848373:
                    if (action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c = 1;
                        break;
                    }
                    break;
                case 154871702:
                    if (action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c = 3;
                        break;
                    }
                    break;
                case 720027695:
                    if (action.equals(ControlEvent.ACTION_PAUSE)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 723345051:
                    if (action.equals(ControlEvent.ACTION_START)) {
                        c = 6;
                        break;
                    }
                    break;
                case 906917140:
                    if (action.equals(ControlEvent.ACTION_RESUME)) {
                        c = 7;
                        break;
                    }
                    break;
                case 1370689931:
                    if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1547354793:
                    if (action.equals(ControlEvent.ACTION_STOP)) {
                        c = '\t';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    onInfo(((Integer) videoEvent.getExtra(1)).intValue(), ((Integer) videoEvent.getExtra(2)).intValue(), videoEvent.getExtra(3));
                    return;
                case 1:
                    onError(((Integer) videoEvent.getExtra(1)).intValue(), ((Integer) videoEvent.getExtra(2)).intValue(), videoEvent.getExtra(3));
                    return;
                case 2:
                    onPrepared();
                    return;
                case 3:
                    onEnd(307);
                    return;
                case 4:
                    onSeekEnd();
                    return;
                case 5:
                    onVideoSizeChanged(((Integer) videoEvent.getExtra(5)).intValue(), ((Integer) videoEvent.getExtra(6)).intValue());
                    return;
                case 6:
                    onStart();
                    return;
                case 7:
                    onResume();
                    return;
                case '\b':
                    onPause();
                    return;
                case '\t':
                    onEnd(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void release() {
        this.mVideoPlayerCallback = null;
        this.mLayerActionCallback = null;
    }
}
