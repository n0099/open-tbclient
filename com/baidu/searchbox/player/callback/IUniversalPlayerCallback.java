package com.baidu.searchbox.player.callback;
/* loaded from: classes9.dex */
public interface IUniversalPlayerCallback {
    void onBeforeSwitchToFull();

    void onBeforeSwitchToHalf();

    void onGestureActionEnd();

    void onGestureActionStart();

    void onPanelVisibilityChanged(boolean z);

    void onPauseBtnClick();

    void onReplayBtnClick();

    void onStartBtnClick();

    void onVideoSwitchToFull();

    void onVideoSwitchToHalf();
}
