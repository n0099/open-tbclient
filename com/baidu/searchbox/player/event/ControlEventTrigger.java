package com.baidu.searchbox.player.event;

import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes2.dex */
public class ControlEventTrigger extends AbsEventTrigger {
    @PublicMethod
    public void goBackOrForeground(boolean z) {
        VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND);
        obtainEvent.putExtra(4, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void pause(boolean z) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_PAUSE);
        obtainEvent.putExtra(7, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void prepare() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_PREPARE));
    }

    @PublicMethod
    public void resume() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_RESUME));
    }

    @PublicMethod
    public void resumeContinuePlay() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_PLAY);
        obtainEvent.putExtra(6, Boolean.TRUE);
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void seekTo(int i2) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SEEK);
        obtainEvent.putExtra(5, Integer.valueOf(i2));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void seekToMs(int i2) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SEEK_MS);
        obtainEvent.putExtra(5, Integer.valueOf(i2));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void setDataSource() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_SET_DATA_SOURCE));
    }

    @PublicMethod
    public void showGaplessPlayTip() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_TIPS_SHOW);
        obtainEvent.putExtra(9, Boolean.TRUE);
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void showNetTip() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_SHOW_TIP));
    }

    @PublicMethod
    public void showNextVideoTip(boolean z) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_TIPS_SHOW);
        obtainEvent.putExtra(8, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void start() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_START));
    }

    @PublicMethod
    public void stop() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_STOP));
    }

    @PublicMethod
    public void stopContinuePlay() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_PLAY);
        obtainEvent.putExtra(6, Boolean.FALSE);
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void switchMode(boolean z) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SWITCH_MODE);
        obtainEvent.putExtra(4, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void syncPos(int i2, int i3, int i4) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SYNC_PROGRESS);
        obtainEvent.putExtra(1, Integer.valueOf(i2));
        obtainEvent.putExtra(2, Integer.valueOf(i3));
        obtainEvent.putExtra(3, Integer.valueOf(i4));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void updateDownStatus() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_UPDATE_DOWNLOAD));
    }

    @PublicMethod
    public void pause(int i2) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_PAUSE);
        obtainEvent.putExtra(11, Integer.valueOf(i2));
        obtainEvent.putExtra(7, Boolean.valueOf(i2 == 1));
        triggerEvent(obtainEvent);
    }
}
