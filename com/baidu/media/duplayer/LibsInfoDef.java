package com.baidu.media.duplayer;

import com.baidu.cyberplayer.sdk.SDKVersion;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes.dex */
public class LibsInfoDef {
    public static final String CYBER_CODEC_MONITOR_NAME = "cyber-monitor";
    public static final String CYBER_CODEC_MONITOR_VERSION = "1.0.0.3";
    public static final String CYBER_VIDEO_SR_MODEL_NAME = "video-sr";
    public static final String CYBER_VIDEO_SR_MODEL_VERSION = "1.2";
    public static final int LIB_ID_CRASHPAD_CLIENT = 1;
    public static final int LIB_ID_CRASHPAD_HANDLER = 2;
    public static final int LIB_ID_CYBER_FFMPEG = 4;
    public static final int LIB_ID_CYBER_FFMPEG_EXTEND = 32;
    public static final int LIB_ID_CYBER_PCDN = 64;
    public static final int LIB_ID_CYBER_PLAYER = 16;
    public static final int LIB_ID_CYBER_SDL = 8;
    public static final int LIB_ID_MML_FRAMEWORK = 512;
    public static final int LIB_ID_OPENCV_JAVA3 = 256;
    public static final int LIB_ID_PADDLE_LITE = 128;
    private static final Map<Integer, d> a = new ConcurrentHashMap();

    static {
        a.put(4, new d(4, "cyber-ffmpeg", "4.1.2.26"));
        a.put(16, new d(16, "cyber-player", SDKVersion.VERSION));
        a.put(8, new d(8, "cyber-sdl", SDKVersion.VERSION));
        a.put(32, new d(32, "cyber-ffmpeg-extend", "4.1.2.12"));
        a.put(64, new d(64, "cyber-pcdn", "2.0.1.1118"));
        a.put(128, new d(128, "paddle-mobile-cl", "0.5.0.3"));
        a.put(256, new d(256, "opencv_java3", "0.3.2.0"));
        a.put(512, new d(512, "mml_framework", "0.5.0.3"));
        a.put(1, new d(1, "crashpad_client", "1.0.0.1"));
        a.put(2, new d(2, "crashpad_handler", "1.0.0.1"));
    }

    public static final Map<Integer, d> getAllGroupMap() {
        return a;
    }
}
