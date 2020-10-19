package com.baidu.searchbox.player.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes15.dex */
public class PlayerConstant {
    public static final int AUTO_END = 307;
    public static final int CLICK_BACK_ICON = 2;
    public static final int CLICK_KEY_BACK = 3;
    public static final int CLICK_SWITCH_BUTTON = 1;
    public static final String FLOATING_MODE = "FLOATING_MODE";
    public static final int FORCE_END = 0;
    public static final String FULL_MODE = "FULL_MODE";
    public static final String HALF_MODE = "HALF_MODE";
    public static final int INFO_CANCEL_PLAY = 100;
    public static final String PAGE_VIDEO_LANDING = "video_landing";
    public static final int PAUSE_ADVANCED_COMPLETION = 3;
    public static final int PAUSE_FROM_AUDIO_FOCUS_LOSS = 2;
    public static final int PAUSE_FROM_USER = 1;
    public static final int PAUSE_NORMAL = 0;
    public static final int SENSOR_AUTO_SWITCH = 0;
    public static final int START_AUTO = 1;
    public static final int START_CLICK = 0;
    public static final int START_PREVIEW = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface PauseType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface PlayMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface PlayStyleSwitchReason {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface PlayerCompleteType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface StartType {
    }
}
