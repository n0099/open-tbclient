package com.baidu.searchbox.player.callback;

import android.view.MotionEvent;
/* loaded from: classes10.dex */
public interface IUniversalPlayerCallback {
    void onBeforeSwitchToFull();

    void onBeforeSwitchToHalf();

    void onGestureActionEnd();

    void onGestureActionStart();

    boolean onGestureDoubleClick(MotionEvent motionEvent);

    void onPanelVisibilityChanged(boolean z);

    void onPauseBtnClick();

    void onReplayBtnClick();

    void onStartBtnClick();

    void onVideoSwitchToFull();

    void onVideoSwitchToHalf();
}
