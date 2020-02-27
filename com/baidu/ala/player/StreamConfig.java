package com.baidu.ala.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.baidu.live.adp.lib.util.BdLog;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class StreamConfig {
    public static final int AUDIO_IO_CXX = 2;
    public static final int AUDIO_IO_JAVA = 1;
    private static final boolean FORCE_OEPN_SL_ES = false;
    public static final int STREAM_COMMON_MODE = 1;
    public static final int STREAM_RTC_MODE = 2;
    private static int AUDIO_IO_MODE = -1;
    public static int OUTPUT_FRAMES_PER_BUFFER = 256;
    public static int OUTPUT_SAMPLE_RATE = Audio.AUDIO_FREQUENCY;
    private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = {"vivo X9"};
    private static final String[] WHITELISTED_OPEN_SL_ES_MODELS = {"MI 5s Plus", "MI 8", "MIX 2", "MI 6", "DUB-AL20", "V1821A", "VKY-AL00", "PACM00", "PBEM00", "OPPO R11", "OPPO R11s", "OPPO R11 Plus", "OPPO R9sk", "OPPO R9tm", "OPPO R9m", "vivo X21i A", "vivo X20A", "V1809A"};

    /* loaded from: classes3.dex */
    public static class Audio {
        public static final int AUDIO_FORMAT_BIT = 2;
        public static final int AUDIO_FORMAT_CHANNELS_NB1 = 1;
        public static final int AUDIO_FORMAT_CHANNELS_NB2 = 2;
        public static final int AUDIO_FORMAT_CHANNEL_FOR_PLAY = 4;
        public static final int AUDIO_FORMAT_CHANNEL_FOR_RECORD = 16;
        public static final int AUDIO_FORMAT_PCM_SHORT16 = 16;
        public static final int AUDIO_FREQUENCY = 44100;
        public static final int AUDIO_RTC_FREQUENCY_16K = 16000;
        public static final int AUDIO_RTC_FREQUENCY_32K = 32000;
        public static final int AUDIO_RTC_FREQUENCY_48K = 48000;
    }

    /* loaded from: classes3.dex */
    public static class Video {
        public static final int CAMERA_FACING_DEFAULT = 1;
    }

    public static synchronized int initConfig(Context context) {
        int i;
        synchronized (StreamConfig.class) {
            if (AUDIO_IO_MODE > 0 && OUTPUT_SAMPLE_RATE > 0 && OUTPUT_FRAMES_PER_BUFFER > 0) {
                i = 0;
            } else if (context == null) {
                i = -1;
            } else {
                try {
                    AudioManager audioManager = (AudioManager) context.getSystemService("audio");
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

    private static void logDeviceInfo() {
        BdLog.d("Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
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
