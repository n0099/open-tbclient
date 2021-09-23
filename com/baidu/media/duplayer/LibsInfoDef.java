package com.baidu.media.duplayer;

import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.media.duplayer.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes5.dex */
public class LibsInfoDef {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CYBER_CODEC_MONITOR_NAME = "cyber-monitor";
    public static final String CYBER_CODEC_MONITOR_VERSION = "1.0.0.8";
    public static final String CYBER_PLAY_SCORE_STORAGE_NAME = "cyber-play-score";
    public static final String CYBER_PLAY_SCORE_STORAGE_VERSION = "1.0.0.1";
    public static final String CYBER_VIDEO_SR_MODEL_NAME = "video-sr";
    public static final String CYBER_VIDEO_SR_MODEL_VERSION = "1.2";
    public static final int LIB_ID_CRASHPAD_CLIENT = 1;
    public static final int LIB_ID_CRASHPAD_HANDLER = 2;
    public static final int LIB_ID_CYBER_CRYPTO = 4;
    public static final int LIB_ID_CYBER_FFMPEG = 16;
    public static final int LIB_ID_CYBER_FFMPEG_EXTEND = 128;
    public static final int LIB_ID_CYBER_OPENSSL = 8;
    public static final int LIB_ID_CYBER_PCDN = 256;
    public static final int LIB_ID_CYBER_PLAYER = 64;
    public static final int LIB_ID_CYBER_SDL = 32;
    public static final int LIB_ID_DECODE_MODE = 32768;
    public static final int LIB_ID_MML_FRAMEWORK = 2048;
    public static final int LIB_ID_MML_GBDT = 16384;
    public static final int LIB_ID_OPENCV_JAVA3 = 1024;
    public static final int LIB_ID_PADDLE_LITE = 512;
    public static final int LIB_ID_THIRD_PARTY_RTC = 8192;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Integer, d> f42670a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-921491466, "Lcom/baidu/media/duplayer/LibsInfoDef;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-921491466, "Lcom/baidu/media/duplayer/LibsInfoDef;");
                return;
            }
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f42670a = concurrentHashMap;
        concurrentHashMap.put(8, new d(8, "ssl.1.1.1j", "1.1.1j"));
        f42670a.put(4, new d(4, "crypto.1.1.1j", "1.1.1j"));
        f42670a.put(16, new d(16, "cyber-ffmpeg", "4.1.2.87"));
        f42670a.put(64, new d(64, "cyber-player", SDKVersion.VERSION));
        f42670a.put(32, new d(32, "cyber-sdl", SDKVersion.VERSION));
        f42670a.put(128, new d(128, "cyber-ffmpeg-extend", "4.1.2.16"));
        f42670a.put(256, new d(256, "cyber-pcdn", "2.0.1.1659"));
        f42670a.put(512, new d(512, "paddle-mobile-cl", "0.5.0.3"));
        f42670a.put(1024, new d(1024, "opencv_java3", "0.3.2.0"));
        f42670a.put(2048, new d(2048, "mml_framework", "0.5.0.3"));
        f42670a.put(1, new d(1, "crashpad_client", "1.0.0.3"));
        f42670a.put(2, new d(2, "crashpad_handler", "1.0.0.3"));
        f42670a.put(8192, new d(8192, "cybermedia-ext-rtc", "5.4.14.0", d.a.f42694a));
        f42670a.put(16384, new d(16384, "mml_gbdt", "1.0.0.2"));
        f42670a.put(32768, new d(32768, "decode_mode", CYBER_PLAY_SCORE_STORAGE_VERSION));
    }

    public LibsInfoDef() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final Map<Integer, d> getAllGroupMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f42670a : (Map) invokeV.objValue;
    }
}
