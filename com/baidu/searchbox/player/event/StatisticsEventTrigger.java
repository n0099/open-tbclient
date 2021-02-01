package com.baidu.searchbox.player.event;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
/* loaded from: classes4.dex */
public class StatisticsEventTrigger extends SingleTargetTrigger {
    public static final int KEY_LOOP_COUNT = 1;

    public void onPlayerStop(int i) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_STOP);
        obtainEvent.putExtra(1, Integer.valueOf(i));
        triggerEvent(obtainEvent);
    }

    public void onPlayerComplete(int i) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_COMPLETE);
        obtainEvent.putExtra(1, Integer.valueOf(i));
        triggerEvent(obtainEvent);
    }

    public void onPlayerStart() {
        triggerEvent(StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_START));
    }

    public void onInfo(int i, int i2, Object obj) {
        VideoEvent videoEvent = null;
        switch (i) {
            case 701:
                videoEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BUFFER_START);
                break;
            case 702:
                videoEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BUFFER_END);
                break;
            case CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL /* 904 */:
            case CyberPlayerManager.MEDIA_INFO_RESTART_PLAYED /* 956 */:
                videoEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY);
                videoEvent.putExtra(2, String.valueOf(obj));
                break;
            case 10009:
                videoEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_CARLTON);
                videoEvent.putExtra(2, String.valueOf(obj));
                break;
        }
        if (videoEvent != null) {
            triggerEvent(videoEvent);
        }
    }

    public void onError(int i, int i2, Object obj) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_ERROR);
        obtainEvent.putExtra(2, String.valueOf(obj));
        obtainEvent.putExtra(4, Integer.valueOf(i2));
        triggerEvent(obtainEvent);
    }
}
