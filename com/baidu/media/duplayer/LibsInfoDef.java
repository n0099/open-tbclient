package com.baidu.media.duplayer;

import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.media.duplayer.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes15.dex */
public class LibsInfoDef {
    public static final String CYBER_CODEC_MONITOR_NAME = "cyber-monitor";
    public static final String CYBER_CODEC_MONITOR_VERSION = "1.0.0.5";
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
    public static final int LIB_ID_THIRD_PARTY_RTC = 2048;

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, d> f3230a = new ConcurrentHashMap();

    static {
        f3230a.put(4, new d(4, "cyber-ffmpeg", "4.1.2.39"));
        f3230a.put(16, new d(16, "cyber-player", SDKVersion.VERSION));
        f3230a.put(8, new d(8, "cyber-sdl", SDKVersion.VERSION));
        f3230a.put(32, new d(32, "cyber-ffmpeg-extend", "4.1.2.13"));
        f3230a.put(64, new d(64, "cyber-pcdn", "2.0.1.1327"));
        f3230a.put(128, new d(128, "paddle-mobile-cl", "0.5.0.3"));
        f3230a.put(256, new d(256, "opencv_java3", "0.3.2.0"));
        f3230a.put(512, new d(512, "mml_framework", "0.5.0.3"));
        f3230a.put(1, new d(1, "crashpad_client", "1.0.0.3"));
        f3230a.put(2, new d(2, "crashpad_handler", "1.0.0.3"));
        f3230a.put(2048, new d(2048, "cybermedia-ext-rtc", "5.4.13.0", d.a.LIB_TYPE_JAR));
    }

    public static final Map<Integer, d> getAllGroupMap() {
        return f3230a;
    }
}
