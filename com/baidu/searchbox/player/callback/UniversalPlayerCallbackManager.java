package com.baidu.searchbox.player.callback;

import android.view.MotionEvent;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes2.dex */
public class UniversalPlayerCallbackManager extends VideoPlayerCallbackBaseManager {
    public IUniversalPlayerCallback mUniversalCallback;

    public IUniversalPlayerCallback getUniversalPlayerCallback() {
        return this.mUniversalCallback;
    }

    @PublicMethod
    public void onBeforeSwitchToFull() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onBeforeSwitchToFull();
        }
    }

    @PublicMethod
    public void onBeforeSwitchToHalf() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onBeforeSwitchToHalf();
        }
    }

    @PublicMethod
    public void onGestureActionEnd() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onGestureActionEnd();
        }
    }

    @PublicMethod
    public void onGestureActionStart() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onGestureActionStart();
        }
    }

    @PublicMethod
    public void onPauseBtnClick() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onPauseBtnClick();
        }
    }

    @PublicMethod
    public void onReplayBtnClick() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onReplayBtnClick();
        }
    }

    @PublicMethod
    public void onStartBtnClick() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onStartBtnClick();
        }
    }

    @PublicMethod
    public void onVideoSwitchToFull() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onVideoSwitchToFull();
        }
    }

    @PublicMethod
    public void onVideoSwitchToHalf() {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onVideoSwitchToHalf();
        }
    }

    @Override // com.baidu.searchbox.player.callback.VideoPlayerCallbackBaseManager
    @PublicMethod
    public void release() {
        super.release();
        this.mUniversalCallback = null;
    }

    @PublicMethod
    public boolean onGestureDoubleClick(MotionEvent motionEvent) {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            return iUniversalPlayerCallback.onGestureDoubleClick(motionEvent);
        }
        return false;
    }

    @PublicMethod
    public void onPanelVisibilityChanged(boolean z) {
        IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
        if (iUniversalPlayerCallback != null) {
            iUniversalPlayerCallback.onPanelVisibilityChanged(z);
        }
    }

    public void setUniversalPlayerCallback(IUniversalPlayerCallback iUniversalPlayerCallback) {
        this.mUniversalCallback = iUniversalPlayerCallback;
    }
}
