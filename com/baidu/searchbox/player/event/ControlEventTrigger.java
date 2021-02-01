package com.baidu.searchbox.player.event;

import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes4.dex */
public class ControlEventTrigger extends AbsEventTrigger {
    @PublicMethod
    public void start() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_START));
    }

    @PublicMethod
    public void prepare() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_PREPARE));
    }

    @PublicMethod
    public void pause(boolean z) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_PAUSE);
        obtainEvent.putExtra(7, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void pause(int i) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_PAUSE);
        obtainEvent.putExtra(11, Integer.valueOf(i));
        obtainEvent.putExtra(7, Boolean.valueOf(i == 1));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void resume() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_RESUME));
    }

    @PublicMethod
    public void stop() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_STOP));
    }

    @PublicMethod
    public void resumeContinuePlay() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_PLAY);
        obtainEvent.putExtra(6, true);
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void stopContinuePlay() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_PLAY);
        obtainEvent.putExtra(6, false);
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
    public void showGaplessPlayTip() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_TIPS_SHOW);
        obtainEvent.putExtra(9, true);
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void setDataSource() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_SET_DATA_SOURCE));
    }

    @PublicMethod
    public void updateDownStatus() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_UPDATE_DOWNLOAD));
    }

    @PublicMethod
    public void switchMode(boolean z) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SWITCH_MODE);
        obtainEvent.putExtra(4, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void seekTo(int i) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SEEK);
        obtainEvent.putExtra(5, Integer.valueOf(i));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void seekToMs(int i) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SEEK_MS);
        obtainEvent.putExtra(5, Integer.valueOf(i));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void goBackOrForeground(boolean z) {
        VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND);
        obtainEvent.putExtra(4, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void syncPos(int i, int i2, int i3) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SYNC_PROGRESS);
        obtainEvent.putExtra(1, Integer.valueOf(i));
        obtainEvent.putExtra(2, Integer.valueOf(i2));
        obtainEvent.putExtra(3, Integer.valueOf(i3));
        triggerEvent(obtainEvent);
    }
}
