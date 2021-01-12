package com.baidu.searchbox.player.callback;

import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes14.dex */
public class UniversalPlayerCallbackManager extends VideoPlayerCallbackBaseManager {
    private IUniversalPlayerCallback mUniversalCallback;

    public void setUniversalPlayerCallback(IUniversalPlayerCallback iUniversalPlayerCallback) {
        this.mUniversalCallback = iUniversalPlayerCallback;
    }

    public IUniversalPlayerCallback getUniversalPlayerCallback() {
        return this.mUniversalCallback;
    }

    @PublicMethod
    public void onBeforeSwitchToHalf() {
        if (this.mUniversalCallback != null) {
            this.mUniversalCallback.onBeforeSwitchToHalf();
        }
    }

    @PublicMethod
    public void onBeforeSwitchToFull() {
        if (this.mUniversalCallback != null) {
            this.mUniversalCallback.onBeforeSwitchToFull();
        }
    }

    @PublicMethod
    public void onVideoSwitchToHalf() {
        if (this.mUniversalCallback != null) {
            this.mUniversalCallback.onVideoSwitchToHalf();
        }
    }

    @PublicMethod
    public void onVideoSwitchToFull() {
        if (this.mUniversalCallback != null) {
            this.mUniversalCallback.onVideoSwitchToFull();
        }
    }

    @PublicMethod
    public void onPanelVisibilityChanged(boolean z) {
        if (this.mUniversalCallback != null) {
            this.mUniversalCallback.onPanelVisibilityChanged(z);
        }
    }

    @PublicMethod
    public void onGestureActionStart() {
        if (this.mUniversalCallback != null) {
            this.mUniversalCallback.onGestureActionStart();
        }
    }

    @PublicMethod
    public void onGestureActionEnd() {
        if (this.mUniversalCallback != null) {
            this.mUniversalCallback.onGestureActionEnd();
        }
    }

    @PublicMethod
    public void onStartBtnClick() {
        if (this.mUniversalCallback != null) {
            this.mUniversalCallback.onStartBtnClick();
        }
    }

    @PublicMethod
    public void onPauseBtnClick() {
        if (this.mUniversalCallback != null) {
            this.mUniversalCallback.onPauseBtnClick();
        }
    }

    @PublicMethod
    public void onReplayBtnClick() {
        if (this.mUniversalCallback != null) {
            this.mUniversalCallback.onReplayBtnClick();
        }
    }

    @Override // com.baidu.searchbox.player.callback.VideoPlayerCallbackBaseManager
    @PublicMethod
    public void release() {
        super.release();
        this.mUniversalCallback = null;
    }
}
