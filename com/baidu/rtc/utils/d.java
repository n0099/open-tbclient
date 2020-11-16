package com.baidu.rtc.utils;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.baidu.ala.helper.StreamConfig;
import java.util.Arrays;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes16.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private static int AUDIO_IO_MODE = -1;
    public static int OUTPUT_FRAMES_PER_BUFFER = 256;
    public static int OUTPUT_SAMPLE_RATE = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    public static int cqp = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = {"vivo X9"};
    private static final String[] WHITELISTED_OPEN_SL_ES_MODELS = {"MI 5s Plus", "MI 8", "MIX 2", "MI 6", "DUB-AL20", "V1821A", "VKY-AL00", "PACM00", "PBEM00", "OPPO R11", "OPPO R11s", "OPPO R11 Plus", "OPPO R9sk", "OPPO R9tm", "OPPO R9m", "vivo X21i A", "vivo X20A", "V1809A"};

    public static synchronized int initConfig(Context context) {
        int i;
        synchronized (d.class) {
            if (AUDIO_IO_MODE > 0 && OUTPUT_SAMPLE_RATE > 0 && OUTPUT_FRAMES_PER_BUFFER > 0 && cqp > 0) {
                i = 0;
            } else if (context == null) {
                i = -1;
            } else {
                try {
                    AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                    if (Build.VERSION.SDK_INT >= 17 && audioManager != null) {
                        String property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
                        if (property != null) {
                            OUTPUT_SAMPLE_RATE = Integer.parseInt(property);
                        }
                        String property2 = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
                        if (property2 != null) {
                            OUTPUT_FRAMES_PER_BUFFER = Integer.parseInt(property2);
                        }
                    }
                    boolean isOpenSLESSupported = isOpenSLESSupported(context);
                    if (!deviceIsBlackListForOpenSLES() && isOpenSLESSupported && OUTPUT_SAMPLE_RATE == 48000) {
                        AUDIO_IO_MODE = 2;
                    } else {
                        AUDIO_IO_MODE = 1;
                        if (deviceIsWhiteListForOpenSLES()) {
                            AUDIO_IO_MODE = 2;
                        }
                    }
                    i = 0;
                } catch (Exception e) {
                    e.printStackTrace();
                    i = -1;
                }
            }
        }
        return i;
    }

    public static boolean useOpenSLES() {
        return AUDIO_IO_MODE == 2;
    }

    private static boolean deviceIsBlackListForOpenSLES() {
        return Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL);
    }

    private static boolean deviceIsWhiteListForOpenSLES() {
        return Arrays.asList(WHITELISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL);
    }

    private static boolean isOpenSLESSupported(Context context) {
        return isLowLatencyInputSupported(context);
    }

    private static boolean isLowLatencyOutputSupported(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }

    private static boolean isLowLatencyInputSupported(Context context) {
        return Build.VERSION.SDK_INT >= 21 && isLowLatencyOutputSupported(context);
    }
}
