package com.baidu.searchbox.player.callback;

import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class UniversalPlayerCallbackManager extends VideoPlayerCallbackBaseManager {
    public IUniversalPlayerCallback mUniversalCallback;

    public IUniversalPlayerCallback getUniversalPlayerCallback() {
        return this.mUniversalCallback;
    }

    public void onBeforeSwitchToFull() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onBeforeSwitchToFull();
        }
    }

    public void onBeforeSwitchToHalf() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onBeforeSwitchToHalf();
        }
    }

    public void onGestureActionEnd() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onGestureActionEnd();
        }
    }

    public void onGestureActionStart() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onGestureActionStart();
        }
    }

    public void onPauseBtnClick() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onPauseBtnClick();
        }
    }

    public void onReplayBtnClick() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onReplayBtnClick();
        }
    }

    public void onStartBtnClick() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onStartBtnClick();
        }
    }

    public void onVideoSwitchToFull() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onVideoSwitchToFull();
        }
    }

    public void onVideoSwitchToHalf() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onVideoSwitchToHalf();
        }
    }

    @Override // com.baidu.searchbox.player.callback.VideoPlayerCallbackBaseManager
    public void release() {
        super.release();
        this.mUniversalCallback = null;
    }

    public boolean onGestureDoubleClick(MotionEvent motionEvent) {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            return iUniversalPlayerCallback.onGestureDoubleClick(motionEvent);
        }
        return false;
    }

    public void onPanelVisibilityChanged(boolean z) {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onPanelVisibilityChanged(z);
        }
    }

    public void onVideoSwitchToFloating(String str) {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onVideoSwitchToFloating(str);
        }
    }

    public void setUniversalPlayerCallback(IUniversalPlayerCallback iUniversalPlayerCallback) {
        this.mUniversalCallback = iUniversalPlayerCallback;
    }
}
