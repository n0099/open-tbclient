package com.baidu.searchbox.player.event;
/* loaded from: classes2.dex */
public class StatisticsEventTrigger extends SingleTargetTrigger {
    public static final int KEY_LOOP_COUNT = 1;

    public void onError(int i, int i2, Object obj) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_ERROR);
        obtainEvent.putExtra(2, String.valueOf(obj));
        obtainEvent.putExtra(4, Integer.valueOf(i2));
        triggerEvent(obtainEvent);
    }

    public void onInfo(int i, int i2, Object obj) {
        VideoEvent obtainEvent;
        if (i == 701) {
            obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BUFFER_START);
        } else if (i == 702) {
            obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BUFFER_END);
        } else if (i == 904 || i == 956) {
            obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY);
            obtainEvent.putExtra(2, String.valueOf(obj));
        } else if (i != 10009) {
            obtainEvent = null;
        } else {
            obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_CARLTON);
            obtainEvent.putExtra(2, String.valueOf(obj));
        }
        if (obtainEvent != null) {
            triggerEvent(obtainEvent);
        }
    }

    public void onPlayerComplete(int i) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_COMPLETE);
        obtainEvent.putExtra(1, Integer.valueOf(i));
        triggerEvent(obtainEvent);
    }

    public void onPlayerStart() {
        triggerEvent(StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_START));
    }

    public void onPlayerStop(int i) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_STOP);
        obtainEvent.putExtra(1, Integer.valueOf(i));
        triggerEvent(obtainEvent);
    }
}
