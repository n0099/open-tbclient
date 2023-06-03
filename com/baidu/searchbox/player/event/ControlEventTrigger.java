package com.baidu.searchbox.player.event;
/* loaded from: classes4.dex */
public class ControlEventTrigger extends SingleTargetTrigger {
    public void prepare() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_PREPARE));
    }

    public void resume() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_RESUME));
    }

    public void resumeContinuePlay() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_PLAY);
        obtainEvent.putExtra(6, Boolean.TRUE);
        triggerEvent(obtainEvent);
    }

    public void showGaplessPlayTip() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_TIPS_SHOW);
        obtainEvent.putExtra(9, Boolean.TRUE);
        triggerEvent(obtainEvent);
    }

    public void showNetTip() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_SHOW_TIP));
    }

    public void start() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_START));
    }

    public void stop() {
        triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_STOP));
    }

    public void stopContinuePlay() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_PLAY);
        obtainEvent.putExtra(6, Boolean.FALSE);
        triggerEvent(obtainEvent);
    }

    public void pause(int i) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_PAUSE);
        obtainEvent.putExtra(11, Integer.valueOf(i));
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        obtainEvent.putExtra(7, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    public void showNextVideoTip(boolean z) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_TIPS_SHOW);
        obtainEvent.putExtra(8, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    public void switchMode(boolean z) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SWITCH_MODE);
        obtainEvent.putExtra(4, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    public void pause(boolean z) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_PAUSE);
        obtainEvent.putExtra(7, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    public void seekToMs(int i, int i2) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SEEK_MS);
        obtainEvent.putExtra(5, Integer.valueOf(i));
        obtainEvent.putExtra(12, Integer.valueOf(i2));
        triggerEvent(obtainEvent);
    }

    public void syncPos(int i, int i2, int i3, int i4) {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SYNC_PROGRESS);
        obtainEvent.putExtra(1, Integer.valueOf(i));
        obtainEvent.putExtra(13, Integer.valueOf(i2));
        obtainEvent.putExtra(2, Integer.valueOf(i3));
        obtainEvent.putExtra(3, Integer.valueOf(i4));
        obtainEvent.setLogLevel(1);
        triggerEvent(obtainEvent);
    }
}
