package com.baidu.searchbox.player.callback;

import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ILayer;
/* loaded from: classes2.dex */
public class VideoPlayerCallbackBaseManager {
    public ILayerActionCallback mLayerActionCallback;
    public IVideoPlayerCallback mVideoPlayerCallback;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
        if (r0.equals(com.baidu.searchbox.player.event.PlayerEvent.ACTION_SEEK_COMPLETE) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchPlayerAction(VideoEvent videoEvent) {
        char c2 = 4;
        if (videoEvent.getType() == 4 || videoEvent.getType() == 2) {
            String action = videoEvent.getAction();
            switch (action.hashCode()) {
                case -1502879971:
                    if (action.equals(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1244137507:
                    break;
                case -525235558:
                    if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -461848373:
                    if (action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 154871702:
                    if (action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 720027695:
                    if (action.equals(ControlEvent.ACTION_PAUSE)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 723345051:
                    if (action.equals(ControlEvent.ACTION_START)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 906917140:
                    if (action.equals(ControlEvent.ACTION_RESUME)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1370689931:
                    if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1547354793:
                    if (action.equals(ControlEvent.ACTION_STOP)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
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

    @PublicMethod
    public IVideoPlayerCallback getVideoPlayerCallback() {
        return this.mVideoPlayerCallback;
    }

    public void onBufferEnd() {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onBufferEnd();
        }
    }

    public void onBufferStart() {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onBufferStart();
        }
    }

    public void onEnd(int i) {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onEnd(i);
        }
    }

    public void onError(int i, int i2, Object obj) {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onError(i, i2, obj != null ? obj.toString() : "");
        }
    }

    public void onGoBackOrForeground(boolean z) {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.goBackOrForeground(z);
        }
    }

    public void onInfo(int i, int i2, Object obj) {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onInfo(i, i2);
        }
    }

    public void onLayerDismiss(ILayer iLayer) {
        ILayerActionCallback iLayerActionCallback = this.mLayerActionCallback;
        if (iLayerActionCallback != null) {
            iLayerActionCallback.onLayerDismiss(iLayer);
        }
    }

    public void onLayerShow(ILayer iLayer) {
        ILayerActionCallback iLayerActionCallback = this.mLayerActionCallback;
        if (iLayerActionCallback != null) {
            iLayerActionCallback.onLayerShow(iLayer);
        }
    }

    public void onNetworkSpeedUpdate(int i) {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onNetworkSpeedUpdate(i);
        }
    }

    public void onPause() {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onPause();
        }
    }

    public void onPrepared() {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onPrepared();
        }
    }

    public void onResume() {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onResume();
        }
    }

    public void onSeekEnd() {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onSeekEnd();
        }
    }

    public void onStart() {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onStart();
        }
    }

    public void onUpdateProgress(int i, int i2, int i3) {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onUpdateProgress(i, i2, i3);
        }
    }

    public void onVideoSizeChanged(int i, int i2) {
        IVideoPlayerCallback iVideoPlayerCallback = this.mVideoPlayerCallback;
        if (iVideoPlayerCallback != null) {
            iVideoPlayerCallback.onVideoSizeChanged(i, i2);
        }
    }

    public void release() {
        this.mVideoPlayerCallback = null;
        this.mLayerActionCallback = null;
    }

    public void setLayerActionCallback(ILayerActionCallback iLayerActionCallback) {
        this.mLayerActionCallback = iLayerActionCallback;
    }

    @PublicMethod
    public void setVideoPlayerCallback(IVideoPlayerCallback iVideoPlayerCallback) {
        this.mVideoPlayerCallback = iVideoPlayerCallback;
    }
}
