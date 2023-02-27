package com.baidu.searchbox.player.event;

import android.graphics.Point;
/* loaded from: classes2.dex */
public class StatisticsEventTrigger extends SingleTargetTrigger {
    public static final int KEY_LOOP_COUNT = 1;

    public void onPlayerPause() {
        triggerEvent(StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_PAUSE));
    }

    public void onPlayerResume() {
        triggerEvent(StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_RESUME));
    }

    public void onPlayerStart() {
        triggerEvent(StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_START));
    }

    public void onError(int i, int i2, Object obj) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_ERROR);
        obtainEvent.putExtra(2, String.valueOf(obj));
        obtainEvent.putExtra(4, Integer.valueOf(i2));
        triggerEvent(obtainEvent);
    }

    public void onFloatingScale(boolean z, String str, Point point) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_FLOATING_SCALE);
        obtainEvent.putExtra(10, Boolean.valueOf(z));
        obtainEvent.putExtra(9, str);
        obtainEvent.putExtra(11, Integer.valueOf(point.x));
        obtainEvent.putExtra(12, Integer.valueOf(point.y));
        triggerEvent(obtainEvent);
    }

    public void onFloatingClick(String str, Point point) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_FLOATING_CLICK);
        obtainEvent.putExtra(9, str);
        obtainEvent.putExtra(11, Integer.valueOf(point.x));
        obtainEvent.putExtra(12, Integer.valueOf(point.y));
        triggerEvent(obtainEvent);
    }

    public void onFloatingDismiss(String str, Point point) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_FLOATING_DISMISS);
        obtainEvent.putExtra(9, str);
        obtainEvent.putExtra(11, Integer.valueOf(point.x));
        obtainEvent.putExtra(12, Integer.valueOf(point.y));
        triggerEvent(obtainEvent);
    }

    public void onFloatingShow(String str, Point point) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_FLOATING_SHOW);
        obtainEvent.putExtra(9, str);
        obtainEvent.putExtra(11, Integer.valueOf(point.x));
        obtainEvent.putExtra(12, Integer.valueOf(point.y));
        triggerEvent(obtainEvent);
    }

    public void onInfo(int i, int i2, Object obj) {
        VideoEvent obtainEvent;
        if (i != 701) {
            if (i != 702) {
                if (i != 904 && i != 956) {
                    if (i != 10009) {
                        if (i != 11004) {
                            if (i != 11005) {
                                obtainEvent = null;
                            } else {
                                obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_ERROR_RETRY_END);
                            }
                        } else {
                            obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_ERROR_RETRY_START);
                            obtainEvent.putExtra(4, Integer.valueOf(i2));
                        }
                    } else {
                        obtainEvent = StatisticsEvent.obtainEvent("statistics_player_carlton");
                        obtainEvent.putExtra(2, String.valueOf(obj));
                    }
                } else {
                    obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY);
                    obtainEvent.putExtra(2, String.valueOf(obj));
                }
            } else {
                obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BUFFER_END);
            }
        } else {
            obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BUFFER_START);
        }
        if (obtainEvent != null) {
            triggerEvent(obtainEvent);
        }
    }

    public void onPlayerBackOrForeground(boolean z) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BACK_OR_FOREGROUND);
        obtainEvent.putExtra(8, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    public void onPlayerComplete(int i) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_COMPLETE);
        obtainEvent.putExtra(1, Integer.valueOf(i));
        triggerEvent(obtainEvent);
    }

    public void onPlayerStop(int i) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_STOP);
        obtainEvent.putExtra(1, Integer.valueOf(i));
        triggerEvent(obtainEvent);
    }
}
