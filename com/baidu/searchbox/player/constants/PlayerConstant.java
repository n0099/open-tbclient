package com.baidu.searchbox.player.constants;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes11.dex */
public class PlayerConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTO_END = 307;
    public static final int CLICK_BACK_ICON = 2;
    public static final int CLICK_KEY_BACK = 3;
    public static final int CLICK_SWITCH_BUTTON = 1;
    public static final int DEFAULT_SWITCH = -1;
    public static final String FLOATING_MODE = "FLOATING_MODE";
    public static final int FORCE_END = 0;
    public static final String FULL_MODE = "FULL_MODE";
    public static final String HALF_MODE = "HALF_MODE";
    public static final int INFO_CANCEL_PLAY = 100;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_ERROR_RETRY_BEGIN = 11004;
    public static final int MEDIA_INFO_ERROR_RETRY_END = 11005;
    public static final int MEDIA_INFO_EXTEND_SERVER_CHANGE = 5000;
    public static final int MEDIA_INFO_EXTEND_VIDEO_CACHE_PROGRESS = 946;
    public static final int MEDIA_INFO_EXTEND_VIDEO_DOWNLOAD_SPEED = 924;
    public static final int MEDIA_INFO_FIRST_FRAME_INTERVAL = 904;
    public static final int MEDIA_INFO_LOG_ID_CHANGE = 11008;
    public static final int MEDIA_INFO_LOOP_REPLAYED = 955;
    public static final int MEDIA_INFO_ON_SEI_DATA_CHANGED = 10103;
    public static final int MEDIA_INFO_PRE_RENDER_COMPLETE = 12006;
    public static final int MEDIA_INFO_PROCESS = 910;
    public static final int MEDIA_INFO_RESTART_PLAYED = 956;
    public static final int MEDIA_INFO_STREAM_RECONNECTED = 937;
    public static final int MEDIA_INFO_STREAM_RECONNECTING = 936;
    public static final int MEDIA_INFO_VIDEO_CARLTON = 10009;
    public static final int MEDIA_INFO_WEAK_NETWORK_BEST_RANK = 12005;
    public static final String PAGE_VIDEO_LANDING = "video_landing";
    public static final int PAUSE_ADVANCED_COMPLETION = 3;
    public static final int PAUSE_FROM_AUDIO_FOCUS_LOSS = 2;
    public static final int PAUSE_FROM_USER = 1;
    public static final int PAUSE_HEADSET_DISCONNECT = 4;
    public static final int PAUSE_NORMAL = 0;
    public static final int SEEK_CLOSEST = 3;
    public static final int SEEK_PREVIOUS_SYNC = 0;
    public static final int SENSOR_AUTO_SWITCH = 0;
    public static final int START_AUTO = 1;
    public static final int START_CLICK = 0;
    public static final int START_PREVIEW = 2;
    public static final int VIDEO_SCALING_MODE_SCALE_16_TO_9 = 5;
    public static final int VIDEO_SCALING_MODE_SCALE_4_TO_3 = 4;
    public static final int VIDEO_SCALING_MODE_SCALE_5_TO_4 = 3;
    public static final int VIDEO_SCALING_MODE_SCALE_NOT_SCALE = 6;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROPPING = 0;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROP_LEFT = 7;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROP_RIGHT = 8;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROP_TOP = 9;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_TO_FILL_WITH_CROP_BOTTOM = 10;
    public transient /* synthetic */ FieldHolder $fh;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface MediaInfo {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface PauseType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface PlayMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface PlayStyleSwitchReason {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface PlayerCompleteType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface ScaleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface SeekMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface StartType {
    }

    public PlayerConstant() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
